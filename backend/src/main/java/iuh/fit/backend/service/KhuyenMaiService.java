package iuh.fit.backend.service;

import iuh.fit.backend.dto.response.KhuyenMaiDTO;
import iuh.fit.backend.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhuyenMaiService {
    Page<KhuyenMaiDTO> findAll(int trang, int size);
    KhuyenMai save(KhuyenMai km);
    boolean delete(Long maKhuyenMai);
}
