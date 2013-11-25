package org.confederacionpirata.mordazacrush.api;

import java.io.File;

import android.location.Location;

public interface ChannelProvider {

	public static final int FILETYPE_IMAGE_JPEG = 1;

	/**
	 * Queues a photo in order to send to the remote server.
	 * 
	 * @param file
	 *            The media file to send.
	 * @param location
	 *            Where the media file was taken. It could be null.
	 * @param listener
	 *            Listener to handle action events.
	 * @return A handler to control the element in the queue.
	 */
	QueuedMessage send(File file, int fileType, Location location,
			ActionListener listener);

	/***
	 * Removes all elements in the queue waiting to be processed.
	 */
	void removeAll();
}
