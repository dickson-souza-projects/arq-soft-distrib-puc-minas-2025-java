package br.com.arquitetura_plataforma_java.beacons.establishment.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstablishmentDTO {
    private Integer id;
    private String nome;
    private String endereco;
}
