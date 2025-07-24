package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    Long id;
    String userName;
    String passWord;
    String first_name;
    String last_name;
}
