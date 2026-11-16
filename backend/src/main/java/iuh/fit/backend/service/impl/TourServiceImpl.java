package iuh.fit.backend.service.impl;

import iuh.fit.backend.dto.response.ChiTietTourDTO;
import iuh.fit.backend.dto.response.LichKhoiHanhDTO;
import iuh.fit.backend.dto.response.LichTrinhDTO;
import iuh.fit.backend.dto.response.TourDTO;
import iuh.fit.backend.entity.Tour;
import iuh.fit.backend.exception.NotFoundException;
import iuh.fit.backend.repository.AnhTourRepository;
import iuh.fit.backend.repository.LichKhoiHanhRepository;
import iuh.fit.backend.repository.LichTrinhTourRepository;
import iuh.fit.backend.repository.TourRepository;
import iuh.fit.backend.service.TourService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;
    private final AnhTourRepository anhTourRepository;
    private final LichTrinhTourRepository lichTrinhTourRepository;
    private final LichKhoiHanhRepository lichKhoiHanhRepository;

    public TourServiceImpl(TourRepository tourRepository, AnhTourRepository anhTourRepository, LichTrinhTourRepository lichTrinhTourRepository, LichKhoiHanhRepository lichKhoiHanhRepository) {
        this.tourRepository = tourRepository;
        this.anhTourRepository = anhTourRepository;
        this.lichTrinhTourRepository = lichTrinhTourRepository;
        this.lichKhoiHanhRepository = lichKhoiHanhRepository;
    }
    @Override
    public Page<TourDTO> getTours(String tenTim, Long maLoaiTim, BigDecimal giaMin,
                                  BigDecimal giaMax, LocalDate ngayKH, LocalDate ngayKT,
                                  int trang, int size) {

        // trang hiện tại, số phần tử, sắp xếp theo mã tour giảm dần
        Pageable pageable = PageRequest.of(trang, size, Sort.by("maTour").descending());

        // nếu rỗng hoặc toàn khoảng trắng thì gán null để Repo bỏ qua điều kiện này
        String searchKeyword = (tenTim != null && !tenTim.trim().isEmpty()) ? tenTim.trim() : null;


        Page<Tour> pageTour= tourRepository.getTours(searchKeyword, maLoaiTim, giaMin, giaMax, ngayKH, ngayKT, pageable);

        return pageTour.map(tour-> new TourDTO(
                tour.getMaTour(),
                tour.getTenTour(),
                tour.getDiemDen(),
                tour.getGiaNguoiLon(),
                tour.getHinhAnhChinh(),
                tour.getLoaiTour()!= null ? tour.getLoaiTour().getTenLoai(): "Chưa phân loại tour"
        ));
    }
    @Override
    public ChiTietTourDTO getChiTietTour(Long maTour){
        Tour tour= tourRepository.findById(maTour).orElseThrow(()-> new RuntimeException("Không tìm thấy tour có mã: "+ maTour));
        // láy các ảnh cua tour
        List<String> anhs= anhTourRepository.findByTour_MaTour(maTour)
                .stream().map(at->at.getDuongDan()).collect(Collectors.toList());
        // Lấy lịch trình của tour
        List<LichTrinhDTO> lichTrinhDTO= lichTrinhTourRepository.findByTour_MaTourOrderByNgayThuAsc(maTour)
                .stream().map(lt->new LichTrinhDTO(lt.getNgayThu(),lt.getTieuDe(),lt.getNoiDung())).toList();
        // Lấy lịch khởi hành kèm khách sạn
        List<LichKhoiHanhDTO> lichKhoiHanhDTOS= lichKhoiHanhRepository.findByMaTourVaDangMoBan(maTour)
                .stream().map(lkh->
                        new LichKhoiHanhDTO(lkh.getMaLichKhoiHanh(),lkh.getNgayKhoiHanh(),
                                lkh.getNgayKetThuc(),lkh.getSoChoToiDa(),lkh.getSoChoConLai(),
                                lkh.getTrangThai() != null ? lkh.getTrangThai().getTenHT() : "",lkh.getKhachSan().getTenKhachSan(),
                                lkh.getKhachSan().getHangSao()))
                .toList();

        return new ChiTietTourDTO(tour.getMaTour(),tour.getTenTour(),tour.getDiemDen(),
                tour.getMoTa(),tour.getThoiLuong(),tour.getPhuongTien(),tour.getGiaNguoiLon(),
                tour.getHinhAnhChinh(), tour.getLoaiTour()!=null ? tour.getLoaiTour().getTenLoai() : "Tour chưa được phân loại",
                tour.getMucDoVanDong(), anhs,lichTrinhDTO,lichKhoiHanhDTOS);
    }

    @Override
    public Tour save(Tour t) {
        if(t.getMaTour()!=null){
            if(!tourRepository.existsById(t.getMaTour())){
                throw new NotFoundException("Không tìm thấy tour có mã: " + t.getMaTour());
            }
        }
        return tourRepository.save(t);
    }


    @Override
    public boolean delete(Long maTour) {
        if(!tourRepository.existsById(maTour)){
            throw new NotFoundException("Không tìm thấy tour có mã: "+ maTour);
        }
        try {
            tourRepository.deleteById(maTour);
            tourRepository.flush();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Không thể xóa Tour này vì đã có khách hàng đặt. Vui lòng chuyển trạng thái sang TẠM NGỪNG trước khi xóa");
        }
    }
}
