package br.com.arquitetura_plataforma_java.promotion.mapper;


import DTO.PromotionDTO;
import br.com.arquitetura_plataforma_java.promotion.entity.PromotionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    PromotionEntity toEntity(PromotionDTO promotion);
    PromotionDTO toDTO(PromotionEntity promotion);
}
