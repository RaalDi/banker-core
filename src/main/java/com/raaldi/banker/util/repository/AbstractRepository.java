package com.raaldi.banker.util.repository;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;

import javax.persistence.EntityManager;

public abstract class AbstractRepository<T extends Serializable, ID extends Serializable>
    extends SimpleJpaRepository<T, ID> {

  public AbstractRepository(final Class<T> domainClass, final EntityManager entityManager) {
    super(domainClass, entityManager);
  }
}
