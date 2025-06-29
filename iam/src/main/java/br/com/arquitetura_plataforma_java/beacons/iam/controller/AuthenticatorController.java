package br.com.arquitetura_plataforma_java.beacons.iam.controller;

import org.springframework.http.ResponseEntity;

public interface AuthenticatorController {
    ResponseEntity<String> getToken();
}
