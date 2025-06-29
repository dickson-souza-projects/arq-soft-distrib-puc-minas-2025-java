package br.com.arquitetura_plataforma_java.beacons.profile.service;

import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;
import br.com.arquitetura_plataforma_java.beacons.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Value("${keycloak.token.url}")
    private String tokenUrl;

    @Value("${keycloak.client.id}")
    private String clientId;

    @Value("${keycloak.client.secret}")
    private String clientSecret;

    private final RestTemplate restTemplate;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String getToken() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            org.springframework.util.MultiValueMap<String, String> form = new org.springframework.util.LinkedMultiValueMap<>();
            form.add("grant_type", "client_credentials");
            form.add("client_id", clientId);
            form.add("client_secret", clientSecret);

            HttpEntity<org.springframework.util.MultiValueMap<String, String>> request = new HttpEntity<>(form, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);

            if (response.getBody() != null && response.getBody().containsKey("access_token")) {
                return (String) response.getBody().get("access_token");
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<ProfileEntity> getAllUser() {
        return profileRepository.findAll();
    }

    @Override
    public void save(ProfileEntity profileEntity) {
        profileRepository.save(profileEntity);
    }
}
