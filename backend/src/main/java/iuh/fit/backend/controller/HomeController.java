package iuh.fit.backend.controller;

import iuh.fit.backend.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/banner")
    public ResponseEntity<?> getBanner() {
        return ResponseEntity.ok(Map.of("imageUrl", homeService.getBannerImageUrl()));
    }
}