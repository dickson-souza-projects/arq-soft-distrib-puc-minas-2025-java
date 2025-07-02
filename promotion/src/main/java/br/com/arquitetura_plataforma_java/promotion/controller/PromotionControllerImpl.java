package br.com.arquitetura_plataforma_java.promotion.controller;

import DTO.*;
import br.com.arquitetura_plataforma_java.promotion.service.PromotionService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.logging.Level;

@RestController
@RequestMapping(value = "api")
public class PromotionControllerImpl implements PromotionController {

    private final RestTemplate restTemplate;
    @Autowired
    public PromotionControllerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final Logger Logger = LoggerFactory.getLogger(PromotionControllerImpl.class);

    @Autowired
    private PromotionService promotionService;

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @PostMapping(value = "promotion")
    public ResponseEntity<String> save(@RequestBody CreatePromotionDTO promotionDTO) {
        try {
            BeaconsDTO beacon = new BeaconsDTO();
            try {
                beacon = getBeacon(promotionDTO.getUuid());
            } catch (Exception e) {
                Logger.info(e.getMessage());
            }

            EstablishmentDTO establishmentDTO = new EstablishmentDTO();
            try {
                establishmentDTO = getEstablishment(promotionDTO.getEstablishmentId());
            } catch (Exception e) {
                Logger.info(e.getMessage());
            }

            PromotionDTO newPromotion = PromotionDTO.builder()
                    .id(promotionDTO.getId())
                    .nome(promotionDTO.getNome())
                    .beaconNome(beacon.getNome())
                    .uuid(beacon.getUuid())
                    .establishmentId(establishmentDTO.getId())
                    .establishmentEndereco(establishmentDTO.getEndereco())
                    .establishmentNome(establishmentDTO.getNome())
                    .build();
            promotionService.save(newPromotion);
            return ResponseEntity.status(HttpStatus.OK).body("Promocao cadastrada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro cadastrada com sucesso");
        }

    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @GetMapping(value = "promotion/{id}")
    public ResponseEntity<PromotionDTO> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok(promotionService.getPromotionById(id));
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @GetMapping(value = "promotion/all")
    public ResponseEntity<List<PromotionDTO>> getAll() {
        return ResponseEntity.ok(promotionService.getAllPromotions());
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @PatchMapping(value = "promotion/{id}")
    public ResponseEntity<String> update(@RequestBody PromotionDTO promotionDTO) {
        promotionService.save(promotionDTO);
        return ResponseEntity.ok("Promocao atualizada com sucesso");
    }

    @Override
    @PreAuthorize("hasAnyRole('access_profile')")
    @DeleteMapping(value = "promotion/{id}")
    public ResponseEntity<String> delete(@RequestBody PromotionDTO promotionDTO) {
        promotionService.save(promotionDTO);
        return ResponseEntity.ok("Promocao deletada com sucesso");
    }


    private String getToken() {
        ResponseEntity<TokenDTO> response = restTemplate.getForEntity("http://iam:8082/public/token", TokenDTO.class);
        Logger.info(response.getBody().toString());
        return response.getBody().getAccess_token();
    }

    private BeaconsDTO getBeacon(String beaconUUID) {
        String token = getToken();

        Logger.info("Token {}", token);
        String url = "http://beacons-service:8084/api/beacon/" + beaconUUID;
        Logger.info("URL {}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<BeaconsDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, BeaconsDTO.class);
        Logger.info("BEACON {}", response.getBody().toString());
        return response.getBody();
    }

    private EstablishmentDTO getEstablishment(int id) {
        String token = getToken();

        Logger.info("Token {}", token);
        String url = "http://establishment:8081/api/establishments/" + id;
        Logger.info("URL {}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<EstablishmentDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, EstablishmentDTO.class);
        Logger.info(response.getBody().toString());
        return response.getBody();
    }
}
