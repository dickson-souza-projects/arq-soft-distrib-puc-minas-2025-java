package br.com.arquitetura_plataforma_java.beacons.iam.controller;


import DTO.TokenDTO;
import br.com.arquitetura_plataforma_java.beacons.iam.service.AuthenticatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "public")
class AuthenticatorControllerImpl implements AuthenticatorController {

    @Autowired
    private AuthenticatorService authenticatorService;

    @Override
    @GetMapping(value = "token")
    public ResponseEntity<TokenDTO> getToken() {
        return new ResponseEntity<>(authenticatorService.getToken(), HttpStatus.OK);
    }
}
