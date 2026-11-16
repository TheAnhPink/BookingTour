package iuh.fit.backend.service.impl;

import iuh.fit.backend.dto.response.KhuyenMaiDTO;
import iuh.fit.backend.entity.KhuyenMai;
import iuh.fit.backend.exception.NotFoundException;
import iuh.fit.backend.repository.KhuyenMaiRepository;
import iuh.fit.backend.service.KhuyenMaiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class KhuyenMaiImpl implements KhuyenMaiService {
    private final KhuyenMaiRepository khuyenMaiRepository;

    public KhuyenMaiImpl(KhuyenMaiRepository khuyenMaiRepository) {
        this.khuyenMaiRepository = khuyenMaiRepository;
    }

    @Override
    public Page<KhuyenMaiDTO> findAll(int trang, int size) {
        Pageable pageable= PageRequest.of(trang,size, Sort.by("maKhuyenMai").descending());
        Page<KhuyenMai> dsKM= khuyenMaiRepository.findAll(pageable);
        return dsKM.map(km->new KhuyenMaiDTO(km.getMaKhuyenMai(),
                km.getTenChuongTrinh(),km.getMoTa(),km.getLoaiGiamGia(),
                km.getGiaTriGiam(),km.getGiamToiDa(),km.getNgayBatDau(),
                km.getNgayKetThuc()));
    }

    @Override
    public KhuyenMai save(KhuyenMai km) {
        if (km.getMaKhuyenMai() != null) {
            if (!khuyenMaiRepository.existsById(km.getMaKhuyenMai())) {
                throw new NotFoundException("Không tìm thấy khuyến mãi có mã: " + km.getMaKhuyenMai());
            }
        }
        return khuyenMaiRepository.save(km);
    }

    @Override
    public boolean delete(Long maKhuyenMai) {
        if (!khuyenMaiRepository.existsById(maKhuyenMai)) {
            throw new NotFoundException("Không tìm thấy khuyến mãi có mã: " + maKhuyenMai);
        }
        try {
            khuyenMaiRepository.deleteById(maKhuyenMai);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Không thể xóa khuyến mãi này vì đã có đơn hàng sử dụng. Vui lòng chuyển trạng thái sang TẠM NGƯNG.");
        }
    }
}
