package org.confederacionpirata.mordazacrush.api;

import java.io.File;

import android.location.Location;

public interface ChannelProvider {

	/**
	 * Informs about the capability of supporting image posts.
	 * 
	 * @return True if images are supported.
	 */
	boolean isSupportingImages();

	/**
	 * Informs about the capability of supporting video posts.
	 * 
	 * @return True if videos are supported.
	 */
	boolean isSupportingVideos();

	/**
	 * Informs about the capability of supporting audio posts.
	 * 
	 * @return True if audios are supported.
	 */
	boolean isSupportingAudios();

	/**
	 * Queues a photo in order to send to the remote server.
	 * 
	 * @param file
	 *            The media file to send.
	 * @param hashtags
	 *            The hashtags related to the post.
	 * @param location
	 *            Where the media file was taken. It could be null.
	 * @param listener
	 *            Listener to handle action events.
	 * @return A handler to control the element in the queue.
	 */
	QueuedMessage postImage(File file, String[] hashtags, Location location,
			ActionListener listener);

	/***
	 * Removes all elements in the queue waiting to be processed.
	 */
	void removeAll();
}
