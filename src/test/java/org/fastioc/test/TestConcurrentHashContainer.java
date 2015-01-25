package org.fastioc.test;

import org.junit.Test;

import com.creative.fastioc.ConcurrentHashMapContainer;
import com.creative.fastioc.ITypeCheckContainer;

public class TestConcurrentHashContainer {
	public class MyThread implements Runnable{
		private int i;
		public MyThread(int i){
			this.i = i;
		}
		@Override
		public void run() {
			container.resolve(Child1.class);
			container.resolve(Child2.class);
			container.resolve(Child3.class);
			container.resolve(Child3.class).doSomething();
		}
	}
	public void setUp(){
		System.out.println("Setup complete");
	}
	public void tearDown(){
		System.out.println("TearDown complete");
	}
	private ITypeCheckContainer container = new ConcurrentHashMapContainer();
	@Test
	public void testHashMap(){

		container.regit(Father.class, new Child2());
		container.regit(Child2.class, new Child2());
		try {
			container.regit(Child1.class, Child1.class);
			container.regit(Child3.class, Child3.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 1000; i++){
			(new Thread(new TestConcurrentHashContainer.MyThread(i))).start();
			//				container.resolve(Child1.class);
			//				container.resolve(Child2.class);
			//				container.resolve(Child3.class);
			//				container.resolve(Child3.class).doSomething();
		}
	}
}
