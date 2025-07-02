package br.com.arquitetura_plataforma_java.beacons.beaconsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.arquitetura_plataforma_java.beacons.beaconsservice.DTO.BeaconsDTO;
import br.com.arquitetura_plataforma_java.beacons.beaconsservice.repository.BeaconsRepository;
import br.com.arquitetura_plataforma_java.beacons.beaconsservice.mapper.BeaconsMapper;

@Service
public class BeaconsServiceImpl implements BeaconsService {

    @Autowired
    private BeaconsRepository repository;

    @Autowired
    private BeaconsMapper beaconsMapper;


    @Override
    public List<BeaconsDTO> getAllUser() {
        return repository.findAll().stream().map(beaconsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BeaconsDTO getBeaconByUUID(String id) {
        return null;
    }

    @Override
    public void save(BeaconsDTO profileDTO) {
        repository.save(beaconsMapper.toEntity(profileDTO));
    }

    @Override
    public void delete(String uuid) {

    }
}
