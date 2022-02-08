package com.example.APIRest.services;

import com.example.APIRest.entities.Base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BaseService <E extends Base, ID extends Serializable>{
public CompletableFuture<E> save(E entity) throws Exception;
public CompletableFuture<E> update(ID id, E entity) throws Exception;
public CompletableFuture<Boolean> delete(ID id) throws Exception;
CompletableFuture<List<E>> pruebaGetall() throws Exception;
public CompletableFuture< Optional<E>> findByIdAsync(ID id) throws Exception;

}
