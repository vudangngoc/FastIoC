
package org.fastioc;

import com.hv.nitroCache.CacheEviction;
import com.hv.nitroCache.NitroCache;


/**
 * 
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 * @param <T>
 */
public class GeneralContainer implements IGeneralContainer {

  private  NitroCache<Class<?>,Class<?>> classContainer = NitroCache.getInstance(5000,CacheEviction.LRU);
  /* (non-Javadoc)
   * @see org.fastioc.IGeneralContainer#regit(java.lang.Class, java.lang.Class)
   */
  public  boolean regit(Class<?> key, Class<?> value) {
    classContainer.put(key, value);
    return false;
  }

  /* (non-Javadoc)
   * @see org.fastioc.IGeneralContainer#resolve(java.lang.Class)
   */
  public Class<?> resolve(Class<?> key) {
    return classContainer.get(key);
  }




}
