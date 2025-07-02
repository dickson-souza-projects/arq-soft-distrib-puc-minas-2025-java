package br.com.arquitetura_plataforma_java.promotion.repository;

import br.com.arquitetura_plataforma_java.promotion.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {

    @Query("select promotion from PromotionEntity promotion where promotion.id = :id")
    PromotionEntity findById(@Param("id") int id);

}
