package org.confederacionpirata.mordazacrush;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class CameraPreview extends SurfaceView implements Callback {

	private Camera camera;
	private SurfaceHolder holder;

	@SuppressWarnings("deprecation")
	public CameraPreview(Context context, Camera camera) {

		super(context);

		this.camera = camera;
		this.holder = getHolder();

		// callback
		holder.addCallback(this);

		if (Build.VERSION.SDK_INT < 11) {
			holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

		if (holder.getSurface() != null) {

			// stop preview
			try {
				
				camera.stopPreview();
				
			} catch (Exception e) {
				
				// ignore: tried to stop a non-existent preview
			}

			// TODO set preview size and make any resize, rotate or reformatting

			// start preview with new settings
			try {
				
				camera.setPreviewDisplay(holder);
				camera.startPreview();
				
			} catch (Exception e) {
				
				// TODO Error starting camera preview
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		try {
			
            camera.setPreviewDisplay(holder);
            camera.startPreview();
            
        } catch (Exception e) {
        	
            // TODO Error setting camera preview
        }
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

		camera.stopPreview();
	}

}
