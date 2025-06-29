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


@RestController
@RequestMapping(value = "public")
public class ProfileControllerImpl implements ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileMapper profileMapper;

    private static final Logger Logger = LoggerFactory.getLogger(ProfileControllerImpl.class);

    @Override
    @PreAuthorize("hasAnyRole({'user'})")
    @GetMapping(value = "allUser")
    public ResponseEntity<List<ProfileEntity>> getAllUser() {
        return ResponseEntity.ok(profileService.getAllUser());
    }

    @Override
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping(value = "user")
    public ResponseEntity<String> saveUser(@RequestBody ProfileDTO profile) {
        Logger.info("Recebido {}", profile);
        if (profile.getNome() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O Nome não podem ser nulos");
        } else {
            ProfileEntity profileEntity = profileMapper.toEntity(profile);
            profileService.save(profileEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body("Perfil cadastrado com sucesso");
        }
    }
}
