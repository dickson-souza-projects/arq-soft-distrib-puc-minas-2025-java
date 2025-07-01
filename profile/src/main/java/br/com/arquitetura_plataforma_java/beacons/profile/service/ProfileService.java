package br.com.arquitetura_plataforma_java.beacons.profile.service;

import br.com.arquitetura_plataforma_java.beacons.profile.DTO.ProfileDTO;

import java.util.List;


public interface ProfileService {

    List<ProfileDTO> getAllUser();

    ProfileDTO getUserById(int id);

    void save(ProfileDTO profileDTO);

    void delete(int id);

}
