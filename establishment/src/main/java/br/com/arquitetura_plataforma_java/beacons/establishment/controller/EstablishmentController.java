package br.com.arquitetura_plataforma_java.beacons.establishment.controller;


import DTO.EstablishmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EstablishmentController {
    @GetMapping("teste")
    ResponseEntity<String> teste();

    @GetMapping
    ResponseEntity<List<EstablishmentDTO>> findAll();

    @GetMapping("{id}")
    ResponseEntity<EstablishmentDTO> findById(@PathVariable int id);

    @PostMapping
    ResponseEntity<EstablishmentDTO> create(@RequestBody EstablishmentDTO dto);

    @PutMapping("{id}")
    ResponseEntity<EstablishmentDTO> update(@PathVariable int id, @RequestBody EstablishmentDTO dto);

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable int id);
}
