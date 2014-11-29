
package org.fastioc;

/**
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public interface ISimpleTypeCheckContainer {
	public <K,V extends K> boolean regit(Class<K> key,V value);
	public abstract Class<?> resolve(Class<?> keyObject);
}
