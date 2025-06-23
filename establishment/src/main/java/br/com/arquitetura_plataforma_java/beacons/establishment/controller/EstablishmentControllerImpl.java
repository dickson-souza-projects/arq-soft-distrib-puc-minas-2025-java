package br.com.arquitetura_plataforma_java.beacons.establishment.controller;


import br.com.arquitetura_plataforma_java.beacons.establishment.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "public")
public class EstablishmentControllerImpl implements EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @Override
    @GetMapping("teste")
    public ResponseEntity<String> teste() {
        return new ResponseEntity<>(establishmentService.teste(), HttpStatus.OK);
    }
}
