package com.kangjian.study.reflect;

import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class  AbstractPage<T, V> implements Ipage<V> {
    protected T aggrData;
    protected V response;

    public AbstractPage() {
        String className = ((ParameterizedType) (this.getClass().getGenericSuperclass()))
                .getActualTypeArguments()[NumberUtils.INTEGER_ONE].getTypeName();

        try {
            if (className.startsWith(List.class.getTypeName())) {
                this.response = (V) new ArrayList();
            } else {
                this.response = (V) Class.forName(className).newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getClass().getInterfaces()[0]);
        Method[] methods = this.getClass().getInterfaces()[0].getDeclaredMethods();
        for (Method m : methods) {
            if (m.getParameterCount() != NumberUtils.LONG_ZERO) {
                throw new RuntimeException("d");
            }
            try {
               m.invoke(this);
            } catch (Exception e) {
               // ignore
            }
        }
    }

    @Override
    public V build() {
        return response;
    }


}
