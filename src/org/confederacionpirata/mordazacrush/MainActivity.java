package org.confederacionpirata.mordazacrush;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	Camera camera = null;
	private CameraPreview cameraPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// title
		String template = getString(R.string.main_lblTitle);
		setTitle(String.format(template, MCApp.getAppVersionName()));

		initCamera();
	}

	@Override
	protected void onResume() {

		super.onResume();
		resumeCameraPreview();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void initCamera() {

		try {
			camera = Camera.open();
		} catch (Exception e) {
			camera = null;
		}
		
        cameraPreview = new CameraPreview(this, camera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.layCameraPreview);
        preview.addView(cameraPreview);
	}

	private void resumeCameraPreview() {

		// TODO http://developer.android.com/training/camera/cameradirect.html
	}
}
