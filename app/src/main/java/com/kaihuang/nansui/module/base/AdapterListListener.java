package com.kaihuang.nansui.module.base;


public interface AdapterListListener<T> {
	void click(int opt, int position, T item);
}