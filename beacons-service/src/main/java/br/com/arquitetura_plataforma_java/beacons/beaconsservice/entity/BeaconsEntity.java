package br.com.arquitetura_plataforma_java.beacons.beaconsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_beacons")
public class BeaconsEntity {
    @Id
    private String uuid;
    private String nome;
}
