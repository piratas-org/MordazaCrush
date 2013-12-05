package org.confederacionpirata.mordazacrush.api;

import java.io.File;

import jcrush.JCrush;
import android.location.Location;

public class MediaCrushProvider implements ChannelProvider {

	String serverApiUrl;

	public MediaCrushProvider(String serverApiUrl) {
		this.serverApiUrl = serverApiUrl;
		JCrush.init(serverApiUrl);
	}

	@Override
	public QueuedMessage postImage(File file, String[] hashtags,
			Location location, ActionListener listener) {

		MediaCrushMessage message = new MediaCrushMessage(this, file,
				Message.TYPE_IMAGE_JPEG, listener);

		return message;
	};

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
	}


	@Override
	public boolean isSupportingImages() {
		return true;
	}

	@Override
	public boolean isSupportingVideos() {
		return false;
	}

	@Override
	public boolean isSupportingAudios() {
		return false;
	}

}
