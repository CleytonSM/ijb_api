package br.com.unifacef.ijb.models.dtos;

import br.com.unifacef.ijb.models.entities.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitReportDTO {
    private Visit visit;
    private String report;
    private byte[] firstImage;
    private byte[] secondImage;
    private byte[] thirdImage;
    private byte[] fourthImage;
    private byte[] fifthImage;
    // não sei se a parte das imagens seria feita dessa forma 
    // apenas desfiz o vetor da versão anterior e usei como byte
}
