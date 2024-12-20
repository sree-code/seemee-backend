package com.seemee.dto;

import com.seemee.model.UserRole;
import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private String phone;
    private Set<AddressDTO> addresses;
    private UserRole role;
}