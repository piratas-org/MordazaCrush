package org.confederacionpirata.mordazacrush.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.location.Location;

public class ChannelManager {

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

	public QueuedMessage[] sendImage(File file, Location location,
			ActionListener listener) {

		int channelsLength = channels.size();
		QueuedMessage[] result = new QueuedMessage[channelsLength];

		int fileType = ChannelProvider.FILETYPE_IMAGE_JPEG;
		for (int c = 0; c < channelsLength; c++) {
			result[c] = channels.get(c)
					.send(file, fileType, location, listener);
		}

		return result;
	}

}
