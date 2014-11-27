
package org.fastioc;

import com.hv.nitroCache.CacheEviction;
import com.hv.nitroCache.NitroCache;

/**
 * 
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public class SimpleTypeCheckContainer implements ISimpleTypeCheckContainer {
  private NitroCache<Class<?>,Class<?>> classContainer = NitroCache.getInstance(5000,CacheEviction.LRU);
  public boolean regit(Class<?> value) {
    //if (K.isAssignableFrom(value.getClass()))
    classContainer.put(value.getSuperclass(),value);
    
    return false;
  }

  public Class<?> resolve(Class<?> keyObject) {
    // TODO Auto-generated method stub
    return classContainer.get(keyObject.getClass());
  }

}
