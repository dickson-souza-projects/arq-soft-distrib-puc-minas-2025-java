package br.com.arquitetura_plataforma_java.beacons.beaconsservice.service;


import DTO.BeaconsDTO;

import java.util.List;

public interface BeaconsService {

    List<BeaconsDTO> getAllUser();
    BeaconsDTO getBeaconByUUID(String uuid);
    void save(BeaconsDTO profileDTO);
    void delete(BeaconsDTO profileDTO);

}
