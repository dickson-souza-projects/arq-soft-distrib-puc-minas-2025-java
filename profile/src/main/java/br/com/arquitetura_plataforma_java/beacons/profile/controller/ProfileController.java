package br.com.arquitetura_plataforma_java.beacons.profile.controller;

import br.com.arquitetura_plataforma_java.beacons.profile.DTO.ProfileDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProfileController {
    ResponseEntity<List<ProfileDTO>> getAllUser();
    ResponseEntity<ProfileDTO> getUserById(@PathVariable int id);
    ResponseEntity<String> saveUser(@RequestBody ProfileDTO profile) ;
    ResponseEntity<String> updateUser(@RequestBody ProfileDTO profile);
    ResponseEntity<String> deleteUser(@PathVariable int id);
}
