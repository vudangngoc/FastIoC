package org.fastioc.test;

import java.util.concurrent.ConcurrentHashMap;

import junit.framework.Assert;

import org.junit.Test;

import com.creative.fastioc.ConcurrentHashMapContainer;
import com.creative.fastioc.ITypeCheckContainer;
import com.creative.fastioc.SimpleTypeCheckContainer;

public class TestConcurrentHashContainer {
	public void setUp(){
		System.out.println("Setup complete");
	}
	public void tearDown(){
		System.out.println("TearDown complete");
	}
	private ITypeCheckContainer container = new ConcurrentHashMapContainer();
	@Test
	public void testHashMap(){
		for(int i = 0; i < 10000; i++){
		container.regit(Father.class, new Child2());
		container.regit(Child2.class, new Child2());
		Assert.assertNotNull(container.resolve(Father.class));
		try {
			container.regit(Child1.class, Child1.class);
			container.regit(Child3.class, Child3.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertNotNull(container.resolve(Child1.class));
		Assert.assertNotNull(container.resolve(Child2.class));
		Assert.assertNotNull(container.resolve(Child3.class));
		Assert.assertNull(container.resolve(String.class));
		container.resolve(Child3.class).doSomething();
	}
	}
}
