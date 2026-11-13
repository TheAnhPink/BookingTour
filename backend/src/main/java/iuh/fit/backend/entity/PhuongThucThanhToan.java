package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PhuongThucThanhToan {
    VNPAY("VNPAY"),
    MOMO("MOMO"),
    ZALOPAY("ZALOPAY"),
    CHUYEN_KHOAN("Chuyển khoản");

    private final String tenHT;

    PhuongThucThanhToan(String tenHT) {
        this.tenHT = tenHT;
    }

    @JsonValue
    public String getTenHT() {
        return tenHT;
    }
}