package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TrangThaiTour {
    HOAT_DONG("Hoạt động"), TAM_NGUNG("Tạm ngưng");

    private final String tenHT;

    TrangThaiTour(String tenHT) {
        this.tenHT = tenHT;
    }
    @JsonValue
    public String getTenHT(){
        return this.tenHT;
    }
}
