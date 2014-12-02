
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
	private NitroCache<Class<?>,Object> classContainer = NitroCache.getInstance(5000,CacheEviction.LRU);

	public <K, V extends K> boolean regit(Class<K> key, V value) {
		
		//classC.put(key, value);
		return false;
	}

  public <K, V extends K> V resolve(Class<K> keyObject) {
    // TODO Auto-generated method stub
    return (V)classContainer.get(keyObject);
  }

}
