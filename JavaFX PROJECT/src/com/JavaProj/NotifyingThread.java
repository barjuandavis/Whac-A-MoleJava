package com.JavaProj;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class NotifyingThread extends Thread{
	private final Set<ThreadCompleteListener> listeners = new CopyOnWriteArraySet<ThreadCompleteListener>();
	
	public final void addListere(final ThreadCompleteListener listener) {
		listeners.add(listener);
	}
	
	public final void removeListener (final ThreadCompleteListener listener) {
		listeners.remove(listener);
	}
	
	private final void notifyListeners() {
		for (ThreadCompleteListener listener : listeners) {
			listener.notifyOfThreadComplete(this);
		}
	}
	@Override
	public final void run() {
			try{
				doRun();
			} finally {
				notifyListeners();
			}
	}
	public abstract void doRun();
	
	/*
	 * untuk implementasi :
	 * NotifyingThread threadname = new YourThread();
	 * threadname.addListener(this);
	 * threadname.start();
	 * 
	 *kalau sudah selesai, notifyOfThreadComplete method will be invoked with the Thread instance that just completed or crashed
	 */
}
