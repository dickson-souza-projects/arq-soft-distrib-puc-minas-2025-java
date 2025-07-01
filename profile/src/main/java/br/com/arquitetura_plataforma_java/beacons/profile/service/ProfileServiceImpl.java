package br.com.arquitetura_plataforma_java.beacons.profile.service;

import br.com.arquitetura_plataforma_java.beacons.profile.DTO.ProfileDTO;
import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;
import br.com.arquitetura_plataforma_java.beacons.profile.mapper.ProfileMapper;
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
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public List<ProfileDTO> getAllUser() {
        return profileRepository.findAll().stream().map(profileMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProfileDTO getUserById(int id) {
        return profileMapper.toDTO(profileRepository.findById(id));
    }

    @Override
    public void save(ProfileDTO profileDTO) {
        profileRepository.save(profileMapper.toEntity(profileDTO));
    }

    @Override
    public void delete(int id) {
        profileRepository.deleteById((long) id);
    }


}
