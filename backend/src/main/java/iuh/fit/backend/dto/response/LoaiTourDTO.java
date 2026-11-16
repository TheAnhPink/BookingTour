package iuh.fit.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoaiTourDTO {
    private Long maLoai;
    private String tenLoai;
    private String moTa;
}
