package com.apin2.api_n2.Interface;

import java.util.List;

public interface GenericOptions <T,N> {

    public T create(T entity);
    public T get (N id);
    public List<T> get ();
    public T update (N id, T entity);
    public void delete(N id);
}
