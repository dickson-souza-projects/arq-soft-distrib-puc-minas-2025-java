package br.com.arquitetura_plataforma_java.beacons.beaconsservice.repository;

import br.com.arquitetura_plataforma_java.beacons.beaconsservice.entity.BeaconsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeaconsRepository extends JpaRepository<BeaconsEntity, Long> {

    @Query("select beacons from BeaconsEntity beacons")
    List<BeaconsEntity> findByUUID(String uuid);

}
