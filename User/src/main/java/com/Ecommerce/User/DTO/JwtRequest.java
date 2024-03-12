package com.Ecommerce.User.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtRequest {
    @NotNull(message = "please provide username")
    private String username;
    @NotNull(message = "please provide password")
    private String password;
}
