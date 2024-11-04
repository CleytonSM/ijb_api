package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.VisitReportDTO;
import br.com.unifacef.ijb.models.entities.VisitReport;

public class VisitReportMapper {
    public static VisitReportDTO conveVisitReportDTOIntoVisitReport(VisitReportDTO visitReportDTO){
        return new VisitReportDTO(visitReportDTO.getVisitDTO(), visitReportDTO.getReport(), visitReportDTO.getFirstImage(),
        visitReportDTO.getSecondImage(), visitReportDTO.getThirdImage(), visitReportDTO.getFourthImage(), visitReportDTO.getFifthImage());
    }

    public static VisitReport convertToVisitReportDTO(VisitReport visitReport){
        return new VisitReport(visitReport.getVisit(), visitReport.getReport(), visitReport.getFirstImage(),
        visitReport.getSecondImage(), visitReport.getThirdImage(), visitReport.getFourthImage(), visitReport.getFifthImage());
    }
}
