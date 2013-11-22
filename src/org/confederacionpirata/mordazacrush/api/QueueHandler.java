package org.confederacionpirata.mordazacrush.api;

public interface QueueHandler {

	public enum Status {
		WAITING, SENDING, SENT, ERROR
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
	 * Removes de element from the queue.
	 */
	void remove();

	/**
	 * Retries sending when cancelled.
	 */
	void retry();
}
