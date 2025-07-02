package br.com.arquitetura_plataforma_java.beacons.beaconsservice.controller;

import br.com.arquitetura_plataforma_java.beacons.beaconsservice.DTO.BeaconsDTO;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


interface BeaconsController {
    ResponseEntity<List<BeaconsDTO>> getAllBeacons();
    ResponseEntity<BeaconsDTO> getBeaconByUUID(@PathVariable String UUID);
    ResponseEntity<String> saveBeacon(@RequestBody BeaconsDTO profile) ;
    ResponseEntity<String> updateBeacon(@RequestBody BeaconsDTO profile);
    ResponseEntity<String> deleteBeacon(@RequestBody BeaconsDTO beacon);

}
