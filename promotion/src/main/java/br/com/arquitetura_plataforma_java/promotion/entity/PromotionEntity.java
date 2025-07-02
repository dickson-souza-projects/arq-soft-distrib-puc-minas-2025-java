package br.com.arquitetura_plataforma_java.promotion.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String uuid;
    private String beaconNome;
    private Integer establishmentId;
    private String establishmentNome;
    private String establishmentEndereco;
}
