package br.com.arquitetura_plataforma_java.promotion.service;


import DTO.PromotionDTO;

import java.util.List;

public interface PromotionService {

    List<PromotionDTO> getAllPromotions();

    PromotionDTO getPromotionById(int id);

    void save(PromotionDTO promotion);

    void delete(int id);
}
