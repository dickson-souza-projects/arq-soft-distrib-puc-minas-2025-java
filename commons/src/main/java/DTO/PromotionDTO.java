package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PromotionDTO {
    private Integer id;
    private String nome;
    private String uuid;
    private String beaconNome;
    private Integer establishmentId;
    private String establishmentNome;
    private String establishmentEndereco;
}
