package org.confederacionpirata.mordazacrush;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends Activity implements PictureCallback {

	private CameraPreview cameraPreview;
	private ImageButton btnTakePhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
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

	protected void takePhoto() {
		cameraPreview.getCamera().takePicture(null, null, this);
	}

	@Override
	public void onPictureTaken(byte[] data, Camera camera) {
		
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
		} catch (FileNotFoundException e) {
			Log.d(MCApp.LOGTAG, "File not found: " + e.getMessage());
		} catch (IOException e) {
			Log.d(MCApp.LOGTAG, "Error accessing file: " + e.getMessage());
		}		
	}

}
