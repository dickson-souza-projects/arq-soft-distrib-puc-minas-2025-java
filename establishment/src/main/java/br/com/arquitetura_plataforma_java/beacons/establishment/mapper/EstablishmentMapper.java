package br.com.arquitetura_plataforma_java.beacons.establishment.mapper;

import DTO.EstablishmentDTO;
import br.com.arquitetura_plataforma_java.beacons.establishment.entity.EstablishmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {
    EstablishmentEntity toEntity(EstablishmentDTO dto);
    EstablishmentDTO toDTO(EstablishmentEntity entity);
}
