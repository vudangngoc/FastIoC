package org.fastioc.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.fastioc.GeneralContainer;
import org.fastioc.IGeneralContainer;
import org.fastioc.ITypeCheckContainer;
import org.fastioc.SimpleTypeCheckContainer;
import org.junit.Test;


public class TestSimpleTypeCheckContainer {
	public void setUp(){}
	public void tearDown(){}
	@Test
	public void testGet(){
		ITypeCheckContainer container = new SimpleTypeCheckContainer();
    container.regit(ITypeCheckContainer.class, new SimpleTypeCheckContainer());
    container.regit(IGeneralContainer.class, new GeneralContainer());
    
    assertEquals(null, container.resolve(String.class));
    assertNotNull(container.resolve(ITypeCheckContainer.class));
    assertTrue(container.resolve(IGeneralContainer.class) instanceof GeneralContainer);
	}
	@Test
	public void testValiding(){
//		ISimpleTypeCheckContainer container = new SimpleTypeCheckContainer();
//		assertEquals(true, container.regit(IGeneralContainer.class,new GeneralContainer()));
//		
//		assertEquals(false,container.regit(IGeneralContainer.class,SimpleTypeCheckContainer.class));
	}
}
