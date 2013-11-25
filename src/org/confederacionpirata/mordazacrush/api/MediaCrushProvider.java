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
	public QueuedMessage send(File file, int fileType, Location location,
			ActionListener listener) {

		MediaCrushMessage message = new MediaCrushMessage(this, file, fileType,
				listener);

		return send(message);
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
	}

	private QueuedMessage send(MediaCrushMessage message) {
		// TODO
		return null;
	}

	public void remove(MediaCrushMessage mediaCrushMessage) {
		// TODO Auto-generated method stub
	}

	public void cancel(MediaCrushMessage mediaCrushMessage) {
		// TODO Auto-generated method stub
	}

	public void retry(MediaCrushMessage mediaCrushMessage) {
		// TODO Auto-generated method stub
	}

}
