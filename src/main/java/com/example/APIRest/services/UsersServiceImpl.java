package com.example.APIRest.services;

import com.example.APIRest.DTO.BaseMapperDTO;
import com.example.APIRest.DTO.UsersDto;
import com.example.APIRest.entities.Users;
import com.example.APIRest.repositories.BaseRepository;
import com.example.APIRest.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.ModelMBean;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public abstract class UsersServiceImpl extends BaseServiceImpl<Users, Long>implements UsersService{

     @Autowired
     private UsersRepository usersRepository;
     static BaseMapperDTO baseMapperDTO=BaseMapperDTO.singleIntance();

     public UsersServiceImpl(BaseRepository<Users, Long> baseRepository){
         super(baseRepository);
     }
     private static final Logger LOGGER= LoggerFactory.getLogger(BaseServiceImpl.class);

     @Async("taskExecutor")
     @Transactional
     public CompletableFuture<List<UsersDto>> getAllDTO(){
         List<Users> entities=usersRepository.findAll();
         List<UsersDto> dtos=new ArrayList<>();
         for(Users users:entities){
             UsersDto usersDto;
             usersDto= baseMapperDTO.mapToUsers(users);
             dtos.add(usersDto);
         }
         return CompletableFuture.completedFuture(dtos);
     }


     @Async("taskExecutor")
     @Transactional
     public CompletableFuture<UsersDto> getOneUsersDTO(Long id){
         Optional<Users> existingUser=usersRepository.findById(id);
         ModelMapper modelMapper=new ModelMapper();
         UsersDto usersDto=modelMapper.map(existingUser,UsersDto.class);
         return CompletableFuture.completedFuture(usersDto);
     }




    @Async("taskExecutor")
    @Override
    public CompletableFuture<List<Users>> pruebaGetall(){
         return CompletableFuture.completedFuture(usersRepository.findAll());
    }


}
