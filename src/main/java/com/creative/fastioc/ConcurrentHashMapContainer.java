package com.creative.fastioc;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapContainer implements ITypeCheckContainer {

	private ConcurrentHashMap<Class<?>, Object> container = new ConcurrentHashMap<Class<?>, Object>();

	@Override
	public <K, V extends K> boolean regit(Class<K> key, V value) {
		return container.put(key, value) == null;
	}

	@Override
	public <K, V extends K> boolean regit(Class<K> key, Class<V> value)
			throws Exception {
		V object;
		try {
			object = ReflectHelper.createObject(this,value);
		} catch (Exception e) {
			throw e;
		}
		return (container.put(key, object) == null);
	}

	@Override
	public <K, V extends K> V resolve(Class<K> keyObject) {
		return (V) container.get(keyObject);
	}
}
