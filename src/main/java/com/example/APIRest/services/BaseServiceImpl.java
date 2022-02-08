package com.example.APIRest.services;

import com.example.APIRest.entities.Base;
import com.example.APIRest.repositories.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<E>> getAll() {
        LOGGER.info("Request to get a list");
        return CompletableFuture.completedFuture(baseRepository.findAll());

    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<Optional<E>> findIdAsync(ID id) throws Exception {
        try {
            return CompletableFuture.completedFuture(baseRepository.findById(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Async("taskExecutor")
    @Override
    @Transactional
    public CompletableFuture<List<E>> pruebaGetall() {
        return CompletableFuture.completedFuture(baseRepository.findAll());

    }

    @Async("taskExecutor")
    @Transactional
    @Override
    public CompletableFuture<E> update(ID id, E entity) throws Exception {
        Optional<E> entityOptional = baseRepository.findById(id);
        E entityUpdate = entityOptional.get();
        return CompletableFuture.completedFuture(baseRepository.save(entity));
    }

    @Async("taskExecutor")
    @Transactional
    @Override
    public CompletableFuture<E> save(E entity) throws Exception{
        return CompletableFuture.completedFuture(baseRepository.save(entity));
    }

    @Async("taskExecutor")
    @Override
    @Transactional
    public CompletableFuture<Boolean> delete(ID id) throws Exception{
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return CompletableFuture.completedFuture(true);
            }else{
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
