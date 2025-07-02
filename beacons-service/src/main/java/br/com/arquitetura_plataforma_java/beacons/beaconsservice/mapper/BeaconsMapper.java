package br.com.arquitetura_plataforma_java.beacons.beaconsservice.mapper;

import br.com.arquitetura_plataforma_java.beacons.beaconsservice.DTO.BeaconsDTO;
import br.com.arquitetura_plataforma_java.beacons.beaconsservice.entity.BeaconsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BeaconsMapper {
    BeaconsEntity toEntity(BeaconsDTO dto);

    BeaconsDTO toDTO(BeaconsEntity entity);
}
