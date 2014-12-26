package org.fastioc.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.creative.fastioc.GeneralContainer;
import com.creative.fastioc.IGeneralContainer;
import com.creative.fastioc.ITypeCheckContainer;
import com.creative.fastioc.SimpleTypeCheckContainer;


public class TestSimpleTypeCheckContainer {
	public void setUp(){}
	public void tearDown(){}
	
	public void testGet(){
		ITypeCheckContainer container = new SimpleTypeCheckContainer();
    container.regit(ITypeCheckContainer.class, new SimpleTypeCheckContainer());
    container.regit(IGeneralContainer.class, new GeneralContainer());
    
    assertEquals(null, container.resolve(String.class));
    assertNotNull(container.resolve(ITypeCheckContainer.class));
    assertTrue(container.resolve(IGeneralContainer.class) instanceof GeneralContainer);
	}

	public void testValiding(){
//		ISimpleTypeCheckContainer container = new SimpleTypeCheckContainer();
//		assertEquals(true, container.regit(IGeneralContainer.class,new GeneralContainer()));
//		
//		assertEquals(false,container.regit(IGeneralContainer.class,SimpleTypeCheckContainer.class));
	}
}
