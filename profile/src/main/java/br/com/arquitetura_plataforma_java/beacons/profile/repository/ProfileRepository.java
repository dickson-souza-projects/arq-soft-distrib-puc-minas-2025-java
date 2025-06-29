package br.com.arquitetura_plataforma_java.beacons.profile.repository;

import br.com.arquitetura_plataforma_java.beacons.profile.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    @Query("select profile from ProfileEntity profile where profile.nome = :nome")
    public List<ProfileEntity> findByNome(String nome);

}
