package br.com.arquitetura_plataforma_java.beacons.profile.mapper;

import br.com.arquitetura_plataforma_java.beacons.profile.DTO.ProfileDTO;
import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileEntity toEntity(ProfileDTO dto);
    ProfileDTO toDTO(ProfileEntity entity);
}
