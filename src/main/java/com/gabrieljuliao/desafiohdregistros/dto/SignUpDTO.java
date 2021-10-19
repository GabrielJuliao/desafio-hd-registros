package com.gabrieljuliao.desafiohdregistros.dto;

import com.gabrieljuliao.desafiohdregistros.model.Conta;
import com.gabrieljuliao.desafiohdregistros.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class SignUpDTO {
    private long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    public SignUpDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public User toUser(BCryptPasswordEncoder bCryptPasswordEncoder) {
        return new User(
                0,
                this.email,
                this.email,
                bCryptPasswordEncoder.encode(this.password),
                this.firstName,
                this.lastName,
                true,
                "ROLE_USER",
                new Conta(BigDecimal.valueOf(100))
        );
    }
}
