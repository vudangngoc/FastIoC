package org.fastioc.test;

import org.fastioc.GeneralContainer;
import org.fastioc.IGeneralContainer;
import org.fastioc.ISimpleTypeCheckContainer;
import org.fastioc.SimpleTypeCheckContainer;


public class TestSimpleTypeCheckContainer {
	public void setUp(){}
	public void tearDown(){}
	public void Get(){
		ISimpleTypeCheckContainer container = new SimpleTypeCheckContainer();
		container.regit(IGeneralContainer.class,GeneralContainer.class);
		System.out.println("implement of IGeneralContainer.class is " + container.resolve(IGeneralContainer.class).getTypeName());
	}
	public void testValiding(){
		ISimpleTypeCheckContainer container = new SimpleTypeCheckContainer();
		System.out.println("should be true but " + container.regit(IGeneralContainer.class,GeneralContainer.class));
		System.out.println("should be false but " + container.regit(IGeneralContainer.class,SimpleTypeCheckContainer.class));
	}
}
