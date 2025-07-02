package br.com.arquitetura_plataforma_java.beacons.establishment.repository;

import br.com.arquitetura_plataforma_java.beacons.establishment.entity.EstablishmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablishmentRepository extends JpaRepository<EstablishmentEntity, Long> {

    @Query("select establishment from EstablishmentEntity establishment where establishment.nome = :nome")
    List<EstablishmentEntity> findByNome(String nome);

    @Query("select establishment from EstablishmentEntity establishment where establishment.id = :id")
    EstablishmentEntity findById(@Param("id") int id);

}
