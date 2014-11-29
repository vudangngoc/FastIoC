
package org.fastioc;

/**
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public interface ISimpleTypeCheckContainer {

  public abstract boolean regit(Class<?> key, Class<?> value);

  public abstract Class<?> resolve(Class<?> keyObject);

}
