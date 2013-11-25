package org.confederacionpirata.mordazacrush;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements Callback {

	private Camera camera;
	private SurfaceHolder holder;
	private boolean started;

	@SuppressWarnings("deprecation")
	public CameraPreview(Context context) {

		super(context);
		camera = null;

		holder = getHolder();
		holder.addCallback(this);

		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
			holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}
	}

	public Camera getCamera() {
		return camera;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

		if (holder.getSurface() != null) {

			if (started) {
				stopPreview();
				startPreview();
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		startPreview();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}

	private void initCamera() {

		try {

			camera = Camera.open();
			started = false;

		} catch (Exception e) {

			Log.e(MCApp.LOGTAG, "Error opening the camera: " + e.getMessage());
			e.printStackTrace();
			camera = null;
		}
	}

	public void startPreview() {

		if (camera == null) {
			initCamera();
		}

		if (camera != null && !started) {

			try {

				camera.setPreviewDisplay(holder);
				camera.startPreview();
				started = true;

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stopPreview() {

		if (camera != null && started) {

			camera.stopPreview();
			camera.release();
			camera = null;
			started = false;
		}
	}

}
