package org.confederacionpirata.mordazacrush.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.location.Location;

public class ChannelManager implements ActionListener {

	private List<ChannelProvider> channels;
	private static ChannelManager instance = null;

	private ChannelManager() {

		this.channels = new ArrayList<ChannelProvider>();
	}

	public static ChannelManager getInstance() {

		if (instance == null) {

			instance = new ChannelManager();
		}

		return instance;
	}

	public List<ChannelProvider> getChannels() {

		return channels;
	}

	public QueuedMessage[] sendImage(File file, String[] hashtags,
			Location location) {

		int channelsLength = channels.size();
		QueuedMessage[] result = new QueuedMessage[channelsLength];

		for (int c = 0; c < channelsLength; c++) {
			result[c] = channels.get(c).postImage(file, hashtags, location,
					this);
		}

		return result;
	}

	@Override
	public void onProgress(QueuedMessage message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(QueuedMessage message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onComplete(QueuedMessage message) {
		// TODO Auto-generated method stub

	}

}
