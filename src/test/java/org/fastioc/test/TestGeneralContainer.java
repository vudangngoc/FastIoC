package org.fastioc.test;

import junit.framework.Assert;

import org.fastioc.GeneralContainer;
import org.fastioc.IGeneralContainer;
import org.fastioc.ISimpleTypeCheckContainer;
import org.fastioc.ITypeCheckContainer;
import org.fastioc.SimpleTypeCheckContainer;
import org.junit.Test;

public class TestGeneralContainer {

	public void setUp(){}
	public void tearDown(){}
	@Test
	public void testContainer(){
	  IGeneralContainer container = new GeneralContainer();
	  container.regit(ISimpleTypeCheckContainer.class, new SimpleTypeCheckContainer());
	  container.regit(IGeneralContainer.class, new GeneralContainer());
	  
	  Assert.assertEquals(null, container.resolve(ITypeCheckContainer.class));
	  Assert.assertNotNull(container.resolve(ISimpleTypeCheckContainer.class));
	  Assert.assertTrue(container.resolve(IGeneralContainer.class) instanceof GeneralContainer);
	}
}
