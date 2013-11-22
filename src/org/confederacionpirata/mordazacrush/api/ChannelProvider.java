package org.confederacionpirata.mordazacrush.api;

import android.graphics.Bitmap;
import android.location.Location;

public interface ChannelProvider {

	/***
	 * Queues a photo in order to send to the remote server.
	 * 
	 * @param photo
	 *            The photo.
	 * @param location
	 *            Where the photo was taken. It could be null.
	 * @param listener
	 *            Listener to handle action events.
	 * @return A handler to control the element in the queue.
	 */
	QueueHandler sendPhoto(Bitmap photo, Location location,
			ActionListener listener);

	/***
	 * Removes all elements in the queue waiting to be processed.
	 */
	void removeAll();
}
