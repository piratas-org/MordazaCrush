package org.confederacionpirata.mordazacrush.api;

public interface QueuedMessage {

	public enum Status {
		NONE, WAITING, SENDING, SENT, CANCELED, ERROR
	}

	/**
	 * Status of the queue element.
	 * 
	 * @return The status.
	 */
	Status getStatus();

	/**
	 * Progress of the sending.
	 * 
	 * @return The progress over 1.
	 */
	double getProgress();

	/**
	 * Processed bytes in the sending.
	 * 
	 * @return Current sent bytes.
	 */
	long getProcessedBytes();

	/**
	 * Length of the element.
	 * 
	 * @return Length in bytes.
	 */
	long getTotalBytes();

	/**
	 * Removes the element from the queue.
	 */
	void remove();

	/**
	 * Cancels the sending of the element.
	 */
	void cancel();

	/**
	 * Retries sending when cancelled.
	 */
	void retry();
}
