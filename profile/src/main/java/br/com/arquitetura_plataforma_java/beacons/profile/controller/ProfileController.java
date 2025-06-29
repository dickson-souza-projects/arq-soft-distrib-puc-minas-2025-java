package br.com.arquitetura_plataforma_java.beacons.profile.controller;

import org.springframework.http.ResponseEntity;

public interface ProfileController {
    ResponseEntity<String> getAllUser();
}
