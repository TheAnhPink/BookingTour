package iuh.fit.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachSanDTO {
    private Long maKhachSan;
    private String tenKhachSan;
    private String diaChi;
    private Integer hangSao;
    private String soDienThoai;
}