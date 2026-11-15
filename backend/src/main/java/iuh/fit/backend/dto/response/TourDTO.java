package iuh.fit.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourDTO {
    private Long maTour;
    private String tenTour;
    private String diemDen;
    private BigDecimal giaNguoiLon;
    private String hinhAnhChinh;
    private String tenLoaiTour;
}
