package org.confederacionpirata.mordazacrush.api;

import java.io.InputStream;

import android.location.Location;

/**
 * Message with the media content sent to the servers.
 */
public interface Message {

	public static final int TYPE_IMAGE_JPEG = 1;

	/**
	 * Returns the type of the media content. Types are associated with some
	 * supported MIME types.
	 * 
	 * @return See Message.TYPE_* constants.
	 */
	int getType();

	/**
	 * Getter to read the data of the media content.
	 * 
	 * @return A stream of bytes with the data.
	 */
	InputStream getMedia();

	/**
	 * Hashtags related to the media content. One word by hashtag, no
	 * whitespaces. For example: "#DesalojoSol" will be a valid hashtag,
	 * "Desalojo Sol" won't. Hash symbol is not mandatory but recommended.
	 * 
	 * @return An array with the hashtags. Empty array when no hashtags.
	 */
	String[] getHashtag();

	/**
	 * Location where the media content was taken. Always is an option from
	 * user, but it could help to organize the messages on server.
	 * 
	 * @return An object with location properties. Null when no location.
	 */
	Location getLocation();

}
