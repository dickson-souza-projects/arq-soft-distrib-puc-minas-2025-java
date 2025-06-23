package br.com.arquitetura_plataforma_java.beacons.establishment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    private final RestTemplate restTemplate;
    private final String iamUrl;

    public EstablishmentServiceImpl(
            RestTemplate restTemplate,
            @Value("${iam.url}") String iamUrl) {
        this.restTemplate = restTemplate;
        this.iamUrl = iamUrl;
    }

    @Override
    public String teste() {
        ResponseEntity<String> response = restTemplate.getForEntity(iamUrl + "/public/teste", String.class);
        return "resposta do micro serviço iam: " + response.getBody();
    }
}
