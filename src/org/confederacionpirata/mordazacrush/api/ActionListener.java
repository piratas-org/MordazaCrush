package org.confederacionpirata.mordazacrush.api;

public interface ActionListener {

	/**
	 * Progress has advanced.
	 * 
	 * @param queueHandler
	 */
	void onProgress(QueuedMessage queueHandler);

	/**
	 * An error was raised. 
	 */
	void onError(QueuedMessage queueHandler);

	/**
	 * Photo was sent.
	 */
	void onComplete(QueuedMessage queueHandler);
}
