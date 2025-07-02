package br.com.arquitetura_plataforma_java.beacons.establishment.service;

import br.com.arquitetura_plataforma_java.beacons.establishment.DTO.EstablishmentDTO;

import java.util.List;

public interface EstablishmentService {

    String teste();

    List<EstablishmentDTO> findAll();

    EstablishmentDTO findById(int id);

    EstablishmentDTO create(EstablishmentDTO dto);

    EstablishmentDTO update(int id, EstablishmentDTO dto);

    void delete(int id);
}
