package br.com.arquitetura_plataforma_java.promotion.controller;

import DTO.CreatePromotionDTO;
import DTO.PromotionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

interface PromotionController {
    ResponseEntity<String> save(@RequestBody CreatePromotionDTO promotionDTO);
    ResponseEntity<PromotionDTO> getById(@PathVariable int id);
    ResponseEntity<List<PromotionDTO>> getAll();
    ResponseEntity<String> update(@RequestBody PromotionDTO promotionDTO);
    public ResponseEntity<String> delete(@RequestBody PromotionDTO promotionDTO);
}
