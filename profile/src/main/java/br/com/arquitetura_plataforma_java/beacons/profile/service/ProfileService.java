package br.com.arquitetura_plataforma_java.beacons.profile.service;

import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;

import java.util.List;


public interface ProfileService {

    List<ProfileEntity> getAllUser();

    void save(ProfileEntity profileEntity);

}
