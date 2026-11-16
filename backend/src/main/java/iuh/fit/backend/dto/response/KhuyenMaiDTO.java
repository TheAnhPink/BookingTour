package iuh.fit.backend.dto.response;

import iuh.fit.backend.entity.LoaiGiamGia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMaiDTO {
    private Long maKhuyenMai;
    private String tenChuongTrinh;
    private String moTa;
    private LoaiGiamGia loaiGiamGia;
    private BigDecimal giaTriGiam;
    private BigDecimal giamToiDa;
    private LocalDateTime ngayBatDau;
    private LocalDateTime ngayKetThuc;
}
