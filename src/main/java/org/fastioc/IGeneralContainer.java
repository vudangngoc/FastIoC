
package org.fastioc;

/**
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public interface IGeneralContainer {

  public boolean regit(Class<?> key, Class<?> value);

  public Class<?> resolve(Class<?> key);

}
