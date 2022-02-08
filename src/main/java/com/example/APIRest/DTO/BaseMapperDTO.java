package com.example.APIRest.DTO;

import com.example.APIRest.entities.Users;
import org.modelmapper.ModelMapper;

public class BaseMapperDTO {
    private final ModelMapper modelMapper=new ModelMapper();
    private static BaseMapperDTO baseMapperDTO;
    private BaseMapperDTO(){}

    public static BaseMapperDTO singleIntance(){
        if(baseMapperDTO==null){
            baseMapperDTO=new BaseMapperDTO();
        }
        return baseMapperDTO;
    }
    public UsersDto mapToUsers(Users users){
        return modelMapper.map(users,UsersDto.class);
    }

}
