package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TrangThaiThanhToan {
    DANG_CHO("Đang chờ thanh toán"),
    DA_THANH_TOAN("Đã thanh toán"),
    DA_HUY("Đã hủy");

    private final String tenHT;

    TrangThaiThanhToan(String tenHT) {
        this.tenHT = tenHT;
    }

    @JsonValue
    public String getTenHT() {
        return tenHT;
    }
}