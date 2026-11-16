package iuh.fit.backend.service;

import iuh.fit.backend.dto.response.LoaiTourDTO;
import iuh.fit.backend.entity.LoaiTour;

import java.util.List;

public interface LoaiTourService {
    List<LoaiTourDTO> findAll();
    LoaiTour save(LoaiTour ltMoi);
    boolean delete(Long maLoaiTour);

}
