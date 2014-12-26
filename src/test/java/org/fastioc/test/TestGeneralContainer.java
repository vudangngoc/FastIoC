package org.fastioc.test;

import junit.framework.Assert;

import org.junit.Test;

import com.creative.fastioc.GeneralContainer;
import com.creative.fastioc.IGeneralContainer;
import com.creative.fastioc.ITypeCheckContainer;
import com.creative.fastioc.SimpleTypeCheckContainer;

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
