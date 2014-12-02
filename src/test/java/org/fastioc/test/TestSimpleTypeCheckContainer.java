package org.fastioc.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.fastioc.GeneralContainer;
import org.fastioc.IGeneralContainer;
import org.fastioc.ISimpleTypeCheckContainer;
import org.fastioc.SimpleTypeCheckContainer;
import org.junit.Test;


public class TestSimpleTypeCheckContainer {
	public void setUp(){}
	public void tearDown(){}
	@Test
	public void testGet(){
		ISimpleTypeCheckContainer container = new SimpleTypeCheckContainer();
		container.regit(IGeneralContainer.class,new GeneralContainer());
		System.out.println("implement of IGeneralContainer.class is " + ((IGeneralContainer)container.resolve(IGeneralContainer.class)).getClass());
	}
	@Test
	public void testValiding(){
//		ISimpleTypeCheckContainer container = new SimpleTypeCheckContainer();
//		assertEquals(true, container.regit(IGeneralContainer.class,new GeneralContainer()));
//		
//		assertEquals(false,container.regit(IGeneralContainer.class,SimpleTypeCheckContainer.class));
	}
}
