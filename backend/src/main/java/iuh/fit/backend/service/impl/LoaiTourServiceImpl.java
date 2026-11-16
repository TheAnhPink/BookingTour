package iuh.fit.backend.service.impl;

import iuh.fit.backend.dto.response.LoaiTourDTO;
import iuh.fit.backend.entity.LoaiTour;
import iuh.fit.backend.exception.NotFoundException;
import iuh.fit.backend.repository.LoaiTourRepository;
import iuh.fit.backend.service.LoaiTourService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoaiTourServiceImpl implements LoaiTourService {
    private final LoaiTourRepository loaiTourRepository;

    public LoaiTourServiceImpl(LoaiTourRepository loaiTourRepository) {
        this.loaiTourRepository = loaiTourRepository;
    }

    @Override
    public List<LoaiTourDTO> findAll() {
        List<LoaiTour> dsLoaiTour= loaiTourRepository.findAll();
        return dsLoaiTour.stream().map(
                lt-> new LoaiTourDTO(lt.getMaLoaiTour(),lt.getTenLoai(),lt.getMoTa())
        ).toList();
    }

    @Override
    public LoaiTour save(LoaiTour ltMoi) {
        if(ltMoi.getMaLoaiTour()!=null){
            if(!loaiTourRepository.existsById(ltMoi.getMaLoaiTour())){
                throw new NotFoundException("Không tìm thấy loại tour: "+ ltMoi.getMaLoaiTour());
            }
        }
        return loaiTourRepository.save(ltMoi);
    }

    @Override
    public boolean delete(Long maLoaiTour) {
        if(!loaiTourRepository.existsById(maLoaiTour)){
            throw new NotFoundException("Không tìm thấy loại tour có mã: "+maLoaiTour);
        }
        try{
            loaiTourRepository.deleteById(maLoaiTour);
            loaiTourRepository.flush();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Không thể xóa loại tour vì tour đang phụ thuộc loại tour này",e);
        }
    }

}
