package br.com.arquitetura_plataforma_java.promotion.service;


import DTO.PromotionDTO;
import br.com.arquitetura_plataforma_java.promotion.mapper.PromotionMapper;
import br.com.arquitetura_plataforma_java.promotion.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PromotionServiceImpl implements PromotionService{

    @Value("${iam.url}")
    private String tokenUrl;

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public List<PromotionDTO> getAllPromotions() {
        return promotionRepository.findAll().stream().map(promotionMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PromotionDTO getPromotionById(int id) {
        return promotionMapper.toDTO(promotionRepository.findById(id));
    }

    @Override
    public void save(PromotionDTO promotion) {
        promotionRepository.save(promotionMapper.toEntity(promotion));
    }

    @Override
    public void delete(int id) {
        promotionRepository.deleteById((long) id);
    }

}
