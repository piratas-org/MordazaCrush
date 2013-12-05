package org.confederacionpirata.mordazacrush.api;

import java.io.File;

public class MediaCrushMessage implements QueuedMessage {

	private Status status;
	private long totalBytes;
	private long processedBytes;

	private MediaCrushProvider provider;
	private File file;
	private int fileType;
	private ActionListener listener;

	public MediaCrushMessage(final MediaCrushProvider provider,
			final File file, final int fileType, ActionListener listener) {

		this.provider = provider;
		this.file = file;
		this.fileType = fileType;
		this.listener = listener;

		this.status = Status.NONE;
		this.totalBytes = 0;
		this.processedBytes = 0;
	}
	
	public MediaCrushProvider getProvider() {
		
		return provider;
	}
	
	public File getFile() {
		
		return file;
	}
	
	public int getFileType() {
		
		return fileType;
	}
	
	public ActionListener getListener() {
		
		return listener;
	}

	@Override
	public Status getStatus() {

		return status;
	}

	@Override
	public double getProgress() {

		return (totalBytes > 0 ? processedBytes / totalBytes : 0);
	}

	@Override
	public long getProcessedBytes() {

		return processedBytes;
	}

	@Override
	public long getTotalBytes() {

		return totalBytes;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retry() {
		// TODO Auto-generated method stub
		
	}

}
