package org.confederacionpirata.mordazacrush.api;

public interface ActionListener {

	/**
	 * Progress has advanced.
	 * 
	 * @param message The queued message.
	 */
	void onProgress(QueuedMessage message);

	/**
	 * An error was raised.
	 *  
	 * @param message The queued message.
	 */
	void onError(QueuedMessage message);

	/**
	 * Message was sent.
	 *  
	 * @param message The queued message.
	 */
	void onComplete(QueuedMessage message);
}
