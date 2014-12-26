
package com.creative.fastioc;

/**
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public interface IGeneralContainer {

  public boolean regit(Class<?> key, Object value);

  public Object resolve(Class<?> key);

}
