package org.fastioc.test;

import junit.framework.Assert;

import org.fastioc.GeneralContainer;
import org.fastioc.IGeneralContainer;
import org.fastioc.ITypeCheckContainer;
import org.fastioc.SimpleTypeCheckContainer;
import org.junit.Test;

public class TestGeneralContainer {

	public void setUp(){}
	public void tearDown(){}
	
	public void testContainer(){
	  IGeneralContainer container = new GeneralContainer();
	  container.regit(ITypeCheckContainer.class, new SimpleTypeCheckContainer());
	  container.regit(IGeneralContainer.class, new GeneralContainer());
	  
	  Assert.assertEquals(null, container.resolve(String.class));
	  Assert.assertNotNull(container.resolve(ITypeCheckContainer.class));
	  Assert.assertTrue(container.resolve(IGeneralContainer.class) instanceof GeneralContainer);
	}
}
