package org.confederacionpirata.mordazacrush.api;

import android.graphics.Bitmap;

public interface RemoteHostApi {

	/***
	 * Queue a photo in order to send to the MediaCrush server.
	 * 
	 * @param photo
	 *            The taken photo.
	 * @return Id refering the delivery in the queue.
	 */
	long sendPhoto(Bitmap photo);

}
