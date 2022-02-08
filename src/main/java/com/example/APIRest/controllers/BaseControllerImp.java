package com.example.APIRest.controllers;

import com.example.APIRest.entities.Base;
import com.example.APIRest.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

public abstract class BaseControllerImp <E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long>{
@Autowired
    protected S servicio;

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return servicio.pruebaGetall().thenApply(ResponseEntity::ok);
    }
    @GetMapping("/{id}")
    public CompletableFuture<ResponseEntity> getOneAsync(@PathVariable Long id) throws Exception{
        return servicio.findByIdAsync(id).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> save(@RequestBody E entity) throws Exception{
        return servicio.save(entity).thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@PathVariable Long id, @RequestBody E entity)throws Exception{
        return  servicio.update(id, entity).thenApply(ResponseEntity::ok);

    }
    @DeleteMapping("{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id) throws Exception{
        return servicio.delete(id).thenApply(ResponseEntity::ok);
    }
}
