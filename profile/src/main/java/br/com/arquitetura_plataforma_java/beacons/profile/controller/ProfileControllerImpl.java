package br.com.arquitetura_plataforma_java.beacons.profile.controller;


import br.com.arquitetura_plataforma_java.beacons.profile.DTO.ProfileDTO;
import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;
import br.com.arquitetura_plataforma_java.beacons.profile.mapper.ProfileMapper;
import br.com.arquitetura_plataforma_java.beacons.profile.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "api")
public class ProfileControllerImpl implements ProfileController {
    @Autowired
    private ProfileService profileService;

    private static final Logger Logger = LoggerFactory.getLogger(ProfileControllerImpl.class);

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @GetMapping(value = "allUser")
    public ResponseEntity<List<ProfileDTO>> getAllUser() {
        return ResponseEntity.ok(profileService.getAllUser());
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @GetMapping(value = "user/{id}")
    public ResponseEntity<ProfileDTO> getUserById(@PathVariable("id") int id) {
        return ResponseEntity.ok(profileService.getUserById(id));
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @PostMapping(value = "user")
    public ResponseEntity<String> saveUser(@RequestBody ProfileDTO profile) {
        Logger.info("Recebido {}", profile);
        if (profile.getNome() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O Nome não podem ser nulos");
        } else {
            profileService.save(profile);
            return ResponseEntity.status(HttpStatus.CREATED).body("Perfil cadastrado com sucesso");
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @PatchMapping(value = "user")
    public ResponseEntity<String> updateUser(@RequestBody ProfileDTO profile) {
        Logger.info("Recebido {}", profile);
        if (profile.getNome() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O Nome não podem ser nulos");
        } else {
            profileService.save(profile);
            return ResponseEntity.status(HttpStatus.CREATED).body("Perfil atualizado com sucesso");
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('admin')")
    @DeleteMapping(value = "user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        if (id <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O Id precisa ser informado");
        }
        profileService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Perfil deletado com sucesso");
    }
}
