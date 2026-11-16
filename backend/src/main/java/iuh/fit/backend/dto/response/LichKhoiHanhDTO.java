package iuh.fit.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LichKhoiHanhDTO {
    private Long maLichKH;
    private LocalDateTime ngayKhoiHanh;
    private LocalDateTime ngayKetThuc;
    private Integer soChoToiDa;
    private Integer soChoConLai;
    private String trangThai;

    private String khachSan;
    private Integer hangSaoKhachSan;
}
