/*
 * SpringGuiceComparison - Comparing Guice, Pico and Spring
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package org.christianschenk.guicepicospringcomparison;

import org.christianschenk.guicepicospringcomparison.managers.ComputationManager;
import org.christianschenk.guicepicospringcomparison.managers.OutputManager1;
import org.christianschenk.guicepicospringcomparison.managers.OutputManager2;
import org.christianschenk.guicepicospringcomparison.managers.SuperManager;
import org.christianschenk.guicepicospringcomparison.util.ComputationHelper;
import org.christianschenk.guicepicospringcomparison.util.OutputHelper;
import org.christianschenk.guicepicospringcomparison.util.output.LoggerOutput;
import org.christianschenk.guicepicospringcomparison.util.output.SystemOutOutput;
import org.fastioc.ITypeCheckContainer;
import org.fastioc.SimpleTypeCheckContainer;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ComparisonTest {

	/*
	 * Guice
	 */
	@Test
	public void guice() {
	  for(int i =0; i<10000; i++){
			final Injector injector = Guice.createInjector(new GuiceBinderModule());
		
			final SuperManager mgr = injector.getInstance(SuperManager.class);
			mgr.manage1();
			mgr.manage2();
		}
	  System.out.println("Test Guice finish");
	}

	private final class GuiceBinderModule implements Module {
		public void configure(final Binder binder) {
			binder.bind(OutputManager1.class).toInstance(new OutputManager1(new OutputHelper(new SystemOutOutput())));
			binder.bind(OutputManager2.class).toInstance(new OutputManager2(new OutputHelper(new LoggerOutput())));
		}
	}

	/*
	 * FastIoC
	 */
//	@Test
//	public void fastioc() {
//	  for(int i =0; i<10000; i++){
//			ITypeCheckContainer container = new SimpleTypeCheckContainer();
//			container.regit(OutputManager1.class, new OutputManager1(new OutputHelper(new SystemOutOutput())));
//			container.regit(OutputManager2.class, new OutputManager2(new OutputHelper(new LoggerOutput())));
//			container.regit(ComputationHelper.class, new ComputationHelper());
//			container.regit(ComputationManager.class, new ComputationManager(container.resolve(ComputationHelper.class)));
//			container.regit(SuperManager.class, new SuperManager(container.resolve(OutputManager1.class), container.resolve(OutputManager2.class), container.resolve(ComputationManager.class)));
//		
//			final SuperManager mgr = container.resolve(SuperManager.class);
//			mgr.manage1();
//			mgr.manage2();
//		}
//	  System.out.println("Test FastIoC finish");
//	}

}