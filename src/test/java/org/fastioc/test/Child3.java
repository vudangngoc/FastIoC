package org.fastioc.test;

public class Child3 extends Father {
	public Child3(Child1 child1, Child2 child2){}
	public void doSomething(int i){
		System.out.println("Do something from thread: " + i);
	}
}
