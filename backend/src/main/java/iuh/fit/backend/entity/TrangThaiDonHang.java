package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TrangThaiDonHang {
    CHO_XU_LY("Chờ xử lý"),
    DA_XAC_NHAN("Đã xác nhận"),
    DA_HUY("Đã hủy");

    private final String tenHT;

    TrangThaiDonHang(String tenHT) {
        this.tenHT = tenHT;
    }

    @JsonValue
    public String getTenHT() {
        return tenHT;
    }
}