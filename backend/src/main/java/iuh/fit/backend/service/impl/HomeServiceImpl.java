package iuh.fit.backend.service.impl;

import iuh.fit.backend.entity.Tour;
import iuh.fit.backend.repository.TourRepository;
import iuh.fit.backend.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final TourRepository tourRepository;

    @Override
    public String getBannerImageUrl() {
        // Tìm ảnh của tour mới nhất. Nếu không có, trả về ảnh mặc định.
        return tourRepository.findFirstByHinhAnhChinhIsNotNullOrderByMaTourDesc()
                .map(Tour::getHinhAnhChinh)
                .orElse("https://images.unsplash.com/photo-1549421255-70663d14bc16?q=80&w=2000");
    }
}