package org.fastioc.test;

import com.google.inject.Binder;
import com.google.inject.Module;

public class GuiceBinderModule implements Module {
	public void configure(final Binder binder) {
		
		binder.bind(Father.class).toInstance(new Child1());
//		binder.bind(Father.class).toInstance(new Child2());
//		binder.bind(Father.class).toInstance(new Child3());
	}
}