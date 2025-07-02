package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreatePromotionDTO {
    private Integer id;
    private String nome;
    private String uuid;
    private Integer establishmentId;
}
