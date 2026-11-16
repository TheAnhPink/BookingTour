package iuh.fit.backend.dto.response;

import iuh.fit.backend.entity.LichKhoiHanh;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietTourDTO {
    private Long maTour;
    private String tenTour;
    private String diemDen;
    private String moTa;
    private String thoiLuong;
    private String phuongTien;
    private BigDecimal giaNguoiLon;
    private String hinhAnhChinh;
    private String tenLoaiTour;
    private Integer mucDoVanDong;

    private List<String> anhs;
    private List<LichTrinhDTO> lichTrinhs;
    private List<LichKhoiHanhDTO> lichKhoiHanhs;
}
