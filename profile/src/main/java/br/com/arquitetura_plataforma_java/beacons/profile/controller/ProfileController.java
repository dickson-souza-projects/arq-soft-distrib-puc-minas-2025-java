package br.com.arquitetura_plataforma_java.beacons.profile.controller;

import br.com.arquitetura_plataforma_java.beacons.profile.DTO.ProfileDTO;
import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfileController {
    ResponseEntity<List<ProfileEntity>> getAllUser();
    ResponseEntity<String> saveUser(@RequestBody ProfileDTO profile) ;
}
