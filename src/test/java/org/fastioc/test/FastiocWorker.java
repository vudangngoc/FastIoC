package org.fastioc.test;

import com.creative.fastioc.ConcurrentHashMapContainer;

public class FastiocWorker implements Runnable {

	private ConcurrentHashMapContainer container;
	public FastiocWorker(ConcurrentHashMapContainer container){
		this.container = container;
	}
	@Override
	public void run() {

		container.resolve(Father.class).doSomething();
	}

}
