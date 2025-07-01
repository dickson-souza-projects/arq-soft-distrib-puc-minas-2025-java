package br.com.arquitetura_plataforma_java.beacons.profile.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProfileDTO {
    private Integer id;
    private String nome;
    private String email;
}
