package entity;

import java.util.Date;

public class DocGia {
    private Date ngayThamGia;
    private Date ngayHetHan;

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public DocGia(Date ngayThamGia, Date ngayHetHan) {
        this.ngayThamGia = ngayThamGia;
        this.ngayHetHan = ngayHetHan;
    }

    public DocGia() {
    }
}