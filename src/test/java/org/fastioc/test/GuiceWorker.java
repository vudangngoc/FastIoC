package org.fastioc.test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GuiceWorker implements Runnable {

	private Injector injector;
	public GuiceWorker(Injector injector){this.injector = injector;}
	@Override
	public void run() {
		
		
		injector.getInstance(Father.class).doSomething();
		
	}

}
