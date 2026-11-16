package iuh.fit.backend.service.impl;

import iuh.fit.backend.dto.response.KhachSanDTO;
import iuh.fit.backend.entity.KhachSan;
import iuh.fit.backend.exception.NotFoundException;
import iuh.fit.backend.repository.KhachSanRepository;
import iuh.fit.backend.service.KhachSanService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhachSanServiceImpl implements KhachSanService {
    private final KhachSanRepository khachSanRepository;

    public KhachSanServiceImpl(KhachSanRepository khachSanRepository) {
        this.khachSanRepository = khachSanRepository;
    }

    @Override
    public List<KhachSanDTO> findAll() {
        return khachSanRepository.findAll().stream()
                .map(ks -> new KhachSanDTO(
                        ks.getMaKhachSan(),
                        ks.getTenKhachSan(),
                        ks.getDiaChi(),
                        ks.getHangSao(),
                        ks.getSoDienThoai()))
                .collect(Collectors.toList());
    }

    @Override
    public KhachSan findById(Long id) {
        return khachSanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy khách sạn có mã: " + id));
    }

    @Override
    public KhachSan save(KhachSan ks) {
        if (ks.getMaKhachSan() != null) {
            if (!khachSanRepository.existsById(ks.getMaKhachSan())) {
                throw new NotFoundException("Không tìm thấy khách sạn có mã: " + ks.getMaKhachSan());
            }
        }
        return khachSanRepository.save(ks);
    }

    @Override
    public boolean delete(Long id) {
        if (!khachSanRepository.existsById(id)) {
            throw new NotFoundException("Không tìm thấy khách sạn có mã: " + id);
        }
        try {
            khachSanRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Không thể xóa khách sạn này vì đã có tour đang sử dụng. Vui lòng kiểm tra lại!");
        }
    }
}