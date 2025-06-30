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

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<ProfileEntity> getAllUser() {
        return profileRepository.findAll();
    }

    @Override
    public void save(ProfileEntity profileEntity) {
        profileRepository.save(profileEntity);
    }
}
