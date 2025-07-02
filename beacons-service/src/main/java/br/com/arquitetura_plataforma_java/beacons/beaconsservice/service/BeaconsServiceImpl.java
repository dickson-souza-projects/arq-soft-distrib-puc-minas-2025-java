package br.com.arquitetura_plataforma_java.beacons.beaconsservice.service;

import DTO.BeaconsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import br.com.arquitetura_plataforma_java.beacons.beaconsservice.repository.BeaconsRepository;
import br.com.arquitetura_plataforma_java.beacons.beaconsservice.mapper.BeaconsMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class BeaconsServiceImpl implements BeaconsService {

    @Value("${iam.url}")
    private String tokenUrl;

    @Autowired
    private BeaconsRepository repository;

    @Autowired
    private BeaconsMapper beaconsMapper;

    private final RestTemplate restTemplate;
    @Autowired
    public BeaconsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<BeaconsDTO> getAllUser() {
        return repository.findAll().stream().map(beaconsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BeaconsDTO getBeaconByUUID(String id) {
        return beaconsMapper.toDTO(repository.findByUUID(id));
    }

    @Override
    public void save(BeaconsDTO profileDTO) {
        repository.save(beaconsMapper.toEntity(profileDTO));
    }

    @Override
    public void delete(BeaconsDTO profileDTO) {
        repository.delete(beaconsMapper.toEntity(profileDTO));
    }


}
