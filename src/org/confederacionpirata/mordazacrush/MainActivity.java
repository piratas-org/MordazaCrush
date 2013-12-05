package org.confederacionpirata.mordazacrush;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.confederacionpirata.mordazacrush.api.ChannelManager;
import org.confederacionpirata.mordazacrush.api.MediaCrushProvider;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends Activity implements PictureCallback {

	private static final String MEDIACRUSH_URL = "http://mediacrush.confederacionpirata.org/api";

	// widgets
	private CameraPreview cameraPreview;
	private ImageButton btnTakePhoto;

	// fields
	List<String> hashtags;

	// constructor
	public MainActivity() {
		this.hashtags = new ArrayList<String>();
	}

	// properties

	private String getMainHashtag() {
		return (hashtags.size() > 0 ? hashtags.get(0) : "");
	}

	// activity

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// title
		String template = getString(R.string.main_lblTitle);
		setTitle(String.format(template, MCApp.getAppVersionName()));

		// take photo button
		btnTakePhoto = (ImageButton) findViewById(R.id.btnTakePhoto);
		btnTakePhoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				takePhoto();
			}
		});

		// camera preview
		cameraPreview = new CameraPreview(this);
		FrameLayout preview = (FrameLayout) findViewById(R.id.layCameraPreview);
		preview.addView(cameraPreview);

		setupChannels();
	}

	@Override
	protected void onResume() {
		super.onResume();
		cameraPreview.startPreview();
	}

	@Override
	protected void onPause() {
		cameraPreview.stopPreview();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// implementation

	protected void takePhoto() {
		cameraPreview.getCamera().takePicture(null, null, this);
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {

		// continue on preview mode
		cameraPreview.stopPreview();
		cameraPreview.startPreview();

		long now = System.currentTimeMillis();
		String filename = ((now / 100) % 100000000) + ".jpg";
		File directory = MCApp.getContext().getExternalFilesDir(null);
		File pictureFile = new File(directory, filename);

		try {

			FileOutputStream fos = new FileOutputStream(pictureFile);
			fos.write(data);
			fos.close();

			// send photo to the channels
			String[] hashtags = getHashtags();
			Location location = null;
			ChannelManager.getInstance().sendImage(pictureFile, hashtags,
					location);

		} catch (FileNotFoundException e) {

			Log.d(MCApp.LOGTAG, "File not found: " + e.getMessage());

		} catch (IOException e) {

			Log.d(MCApp.LOGTAG, "Error accessing file: " + e.getMessage());
		}
	}

	private String[] getHashtags() {
		return hashtags.toArray(new String[hashtags.size()]);
	}

	private void setupChannels() {

		ChannelManager cm = ChannelManager.getInstance();

		MediaCrushProvider mediaCrush = new MediaCrushProvider(MEDIACRUSH_URL);
		cm.getChannels().add(mediaCrush);
	}

}
