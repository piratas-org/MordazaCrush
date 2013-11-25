package org.confederacionpirata.mordazacrush.api;

public interface ActionListener {

	/**
	 * Progress has advanced.
	 * 
	 * @param queueHandler
	 */
	void onProgress(QueuedMessage queueMessage);

	/**
	 * An error was raised. 
	 */
	void onError(QueuedMessage queueMessage);

	/**
	 * Photo was sent.
	 */
	void onComplete(QueuedMessage queueMessage);
}
