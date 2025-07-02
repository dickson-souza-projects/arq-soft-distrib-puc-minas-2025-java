package br.com.arquitetura_plataforma_java.beacons.iam.controller;

import DTO.TokenDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticatorController {
    ResponseEntity<TokenDTO> getToken();
}
