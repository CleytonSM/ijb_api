package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.VisitReportDTO;
import br.com.unifacef.ijb.models.entities.VisitReport;

public class VisitReportMapper {
    public static VisitReport conveVisitReportDTOIntoVisitReport(VisitReportDTO visitReportDTO){
        return new VisitReport(visitReportDTO.getVisit(), visitReportDTO.getReport(), visitReportDTO.getFirstImage(),
        visitReportDTO.getSecondImage(), visitReportDTO.getThirdImage(), visitReportDTO.getFourthImage(), visitReportDTO.getFifthImage());
    }

    public static VisitReportDTO convertToVisitReportDTO(VisitReport visitReport){
        return new VisitReportDTO(visitReport.getVisit(), visitReport.getReport(), visitReport.getFirstImage(),
        visitReport.getSecondImage(), visitReport.getThirdImage(), visitReport.getFourthImage(), visitReport.getFifthImage());
    }
}
