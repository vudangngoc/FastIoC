
package com.creative.fastioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

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
	
	@Override
	public <K, V extends K> boolean regit(Class<K> key, Class<V> value) throws Exception {
		V object = null;
		try {
			object = createObject(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		if(classContainer.containsKey(key)){
			classContainer.remove(key);
			classContainer.put(key, object);
			return false;
		}
		classContainer.put(key, object);
		return true;
	}
	
	public <V> V createObject(Class<V> v) throws Exception{
		V result = null;
		//Class classOfValue = result.getClass();
		Constructor[] constructors = v.getConstructors();
		Constructor willBeImplemented = constructors[0];
		for(int i = 1; i <constructors.length; i++){
			if(willBeImplemented.getParameterCount() > constructors[i].getParameterCount()) willBeImplemented = constructors[i];
		}
		Parameter[] para = willBeImplemented.getParameters();
		Object[] objectPara = new Object[para.length];
		for(int i = 0;i < para.length;i++){
			Class<?> clazz = para[i].getType();
			objectPara[i] = classContainer.get(clazz);
			if(objectPara[i] == null) return null;
		}
		try {
			result = (V) willBeImplemented.newInstance(objectPara);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {

			throw e;
		}
		return result;
	}


}
