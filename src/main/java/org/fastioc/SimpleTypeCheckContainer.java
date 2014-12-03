
package org.fastioc;

import com.hv.nitroCache.CacheEviction;
import com.hv.nitroCache.NitroCache;

/**
 * 
 * Author : vudangngoc
 *          vudangngoc@gmail.com
 * Nov 27, 2014  
 */
public class SimpleTypeCheckContainer implements ITypeCheckContainer {
	private NitroCache<Class<?>,Object> classContainer = NitroCache.getInstance(5000,CacheEviction.LRU);

	public <K, V extends K> boolean regit(Class<K> key, V value) {
		if(classContainer.containsKey(key)){
		  classContainer.remove(key);
		  classContainer.put(key, value);
		  return false;
		}
	  classContainer.put(key, value);
		return true;
	}

  @SuppressWarnings("unchecked")
  public <K, V extends K> V resolve(Class<K> keyObject) {
    return (V)classContainer.get(keyObject);
  }

}
