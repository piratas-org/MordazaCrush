package org.confederacionpirata.mordazacrush.api;

public interface ActionListener {

	/**
	 * Progress has advanced.
	 * 
	 * @param queueHandler
	 */
	void onProgress(QueueHandler queueHandler);

	/**
	 * An error was raised. 
	 */
	void onError(QueueHandler queueHandler);

	/**
	 * Photo was sent.
	 */
	void onComplete(QueueHandler queueHandler);
}
