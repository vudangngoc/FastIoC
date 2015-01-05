package com.creative.fastioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ReflectHelper {
	public static <V> V createObject(ITypeCheckContainer container, Class<V> v) throws Exception{
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
			objectPara[i] = container.resolve(clazz);
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
