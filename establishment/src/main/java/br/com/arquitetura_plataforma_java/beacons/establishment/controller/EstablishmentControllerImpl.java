package br.com.arquitetura_plataforma_java.beacons.establishment.controller;

import br.com.arquitetura_plataforma_java.beacons.establishment.DTO.EstablishmentDTO;
import br.com.arquitetura_plataforma_java.beacons.establishment.service.EstablishmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("public/establishments")
class EstablishmentControllerImpl implements EstablishmentController {

    private static final Logger Logger = LoggerFactory.getLogger(EstablishmentControllerImpl.class);

    @Autowired
    private EstablishmentService service;

    @GetMapping("teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok(service.teste());
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('access_profile')")
    public ResponseEntity<List<EstablishmentDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('access_profile')")
    public ResponseEntity<EstablishmentDTO> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('access_profile')")
    public ResponseEntity<EstablishmentDTO> create(@RequestBody EstablishmentDTO dto) {
        Logger.info("Recebido {}",dto);
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('access_profile')")
    public ResponseEntity<EstablishmentDTO> update(@PathVariable("id")  int id, @RequestBody EstablishmentDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('access_profile')")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
