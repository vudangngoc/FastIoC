
package com.creative.fastioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public interface ITypeCheckContainer {
	public <K,V extends K> boolean regit(Class<K> key,V value);
	public <K,V extends K> boolean regit(Class<K> key,Class<V> value) throws Exception;
	public <K,V extends K> V resolve(Class<K> keyObject);

}
