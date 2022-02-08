package com.example.APIRest.controllers;

import com.example.APIRest.entities.Users;
import com.example.APIRest.services.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/users")
public class UsersController  extends BaseControllerImp<Users, UsersServiceImpl>{

    private static final Logger LOGGER= LoggerFactory.getLogger(BaseController.class);

    @GetMapping("/testgetdto")
    public CompletableFuture<ResponseEntity> getTestAllDto(){
        return servicio.getAllDTO().thenApply(ResponseEntity::ok);
    }
    @GetMapping("/testgetdto/{id}")
    public CompletableFuture<ResponseEntity> getOneAsyncDto(@PathVariable Long id)throws Exception{
        return servicio.getOneUsersDTO(id).thenApply(ResponseEntity::ok);
    }




}
