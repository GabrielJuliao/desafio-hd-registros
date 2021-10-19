package com.gabrieljuliao.desafiohdregistros.controllers;

import com.gabrieljuliao.desafiohdregistros.dto.SignUpDTO;
import com.gabrieljuliao.desafiohdregistros.services.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/signup", produces = "application/json")
public class SignUpController {
    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public ResponseEntity<SignUpDTO> getForm(){
        return new ResponseEntity<>(new SignUpDTO(), HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<SignUpDTO> signUp(@RequestBody @Valid SignUpDTO signUpDTO) {
        return new ResponseEntity<>(signUpService.cadastraUsuario(signUpDTO), HttpStatus.CREATED);
    }
}
