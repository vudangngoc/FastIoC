
package org.fastioc;

/**
 * 
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public interface ITypeCheckContainer {
  public <K, V extends K> boolean regit(Class<K> key,V value);
  public <K, V extends K> V resolve(Class<K> key);

}
