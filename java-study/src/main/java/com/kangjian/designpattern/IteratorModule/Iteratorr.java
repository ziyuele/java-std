package com.kangjian.designpattern.IteratorModule;

import com.sun.tools.javac.util.List;

/**
 * 迭代器
 */
public interface Iteratorr<T> {
     boolean hasNext();
     T next();
}
