package com.gabrieljuliao.desafiohdregistros.services;

import com.gabrieljuliao.desafiohdregistros.dto.SignUpDTO;
import com.gabrieljuliao.desafiohdregistros.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SignUpService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public SignUpDTO cadastraUsuario(SignUpDTO signUpDTO){
        return new SignUpDTO(userRepository.save(signUpDTO.toUser(bCryptPasswordEncoder)));
    }
}
