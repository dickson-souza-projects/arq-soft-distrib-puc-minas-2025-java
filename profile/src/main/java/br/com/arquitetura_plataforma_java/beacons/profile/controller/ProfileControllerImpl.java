package br.com.arquitetura_plataforma_java.beacons.profile.controller;

import br.com.arquitetura_plataforma_java.beacons.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "public")
public class ProfileControllerImpl implements ProfileController {
    @Autowired
    private ProfileService profileService;

    @Override
    @GetMapping(value = "allUser")
    public ResponseEntity<String> getAllUser() {
        return ResponseEntity.ok(profileService.getAllUser());
    }
}
