package iuh.fit.backend.service;

import iuh.fit.backend.dto.response.KhachSanDTO;
import iuh.fit.backend.entity.KhachSan;

import java.util.List;

public interface KhachSanService {
    List<KhachSanDTO> findAll();
    KhachSan findById(Long id);
    KhachSan save(KhachSan ks);
    boolean delete(Long id);
}