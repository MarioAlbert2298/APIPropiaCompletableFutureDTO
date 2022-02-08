package com.example.APIRest.services;

import com.example.APIRest.DTO.UsersDto;
import com.example.APIRest.entities.Users;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UsersService extends BaseService<Users, Long>{

    CompletableFuture<List<Users>> pruebaGetall();
    CompletableFuture<List<UsersDto>> getAllDTO();
    CompletableFuture<UsersDto> getOneUsersDTO(Long id);

}
