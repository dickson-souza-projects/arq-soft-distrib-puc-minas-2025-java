package br.com.arquitetura_plataforma_java.beacons.beaconsservice.controller;

import DTO.BeaconsDTO;
import br.com.arquitetura_plataforma_java.beacons.beaconsservice.service.BeaconsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "api")
public class BeaconsControllerImpl implements BeaconsController {
    @Autowired
    private BeaconsService beaconsService;

    private final RestTemplate restTemplate;
    @Autowired
    public BeaconsControllerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Value("${iam.url}")
    private String tokenUrl;

    private static final Logger Logger = LoggerFactory.getLogger(BeaconsController.class);

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @GetMapping(value = "all")
    public ResponseEntity<List<BeaconsDTO>> getAllBeacons() {
        return ResponseEntity.ok(beaconsService.getAllUser());
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @GetMapping(value = "beacon/{uuid}")
    public ResponseEntity<BeaconsDTO> getBeaconByUUID(@PathVariable("uuid") String UUID) {
        return ResponseEntity.ok(beaconsService.getBeaconByUUID(UUID));
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @PostMapping(value = "beacon")
    public ResponseEntity<String> saveBeacon(@RequestBody BeaconsDTO beacon) {
        Logger.info("Recebido {}", beacon);
        if (beacon.getUuid() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O UUID não podem ser nulos");
        } else {
            beaconsService.save(beacon);
            return ResponseEntity.status(HttpStatus.CREATED).body("Beacon cadastrado com sucesso");
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @PatchMapping(value = "beacon")
    public ResponseEntity<String> updateBeacon(@RequestBody BeaconsDTO beacon) {
        Logger.info("Recebido {}", beacon);
        if (beacon.getUuid() == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("O UUID não podem ser nulos");
        } else {
            beaconsService.save(beacon);
            return ResponseEntity.status(HttpStatus.CREATED).body("Beacon atualizado com sucesso");
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('admin')")
    @DeleteMapping(value = "beacon")
    public ResponseEntity<String> deleteBeacon(@RequestBody BeaconsDTO beacon) {
        beaconsService.delete(beacon);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Beacon deletado com sucesso");
    }

    private String getToken() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://iam:8082/public/token", String.class);
        Logger.info(response.getBody());
        return response.getBody();
    }
}
