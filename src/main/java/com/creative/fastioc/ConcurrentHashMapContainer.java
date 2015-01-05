package com.creative.fastioc;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapContainer implements ITypeCheckContainer {

	private ConcurrentHashMap<Class<?>, Object> container = new ConcurrentHashMap<Class<?>, Object>();


	@Override
	public <K, V extends K> boolean regit(Class<K> key, V value) {
		container.put(key, value);
		return true;
	}

	@Override
	public <K, V extends K> boolean regit(Class<K> key, Class<V> value)
			throws Exception {
		V object = null;
		try {
			object = ReflectHelper.createObject(this,value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		if(container.containsKey(key)){
			container.remove(key);
			container.put(key, object);
			return false;
		}
		container.put(key, object);
		return true;
	}

	@Override
	public <K, V extends K> V resolve(Class<K> keyObject) {
		
		return (V) container.get(keyObject);
	}

}
