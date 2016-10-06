package com.raaldi.banker.util.service;

public interface ModelService<T> {

  public void save(T model);

  // public void update(T model);
  // public void delete(Long id);
  // public void delete(T model);
  // public void deleteAll();

  public T findOne(Long id);

  // public T find(T model);

  public Iterable<T> findAll();

  public boolean exists(T model);

  public boolean exists(Long id);

}
