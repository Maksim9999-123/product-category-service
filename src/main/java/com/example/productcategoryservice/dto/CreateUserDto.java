package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class CreateUserDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Role role;

}
