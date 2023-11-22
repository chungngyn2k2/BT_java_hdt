package entity;

import java.util.Date;

public class ThongTinDocGia extends DocGia {
    private int stt;
    private String maSv;
    private String hoTen;
    private String lop;
    private Date ngaySinh;
    private int sdt;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public ThongTinDocGia(Date ngayThamGia, Date ngayHetHan, int stt, String maSv, String hoTen, String lop, Date ngaySinh, int sdt) {
        super(ngayThamGia, ngayHetHan);
        this.stt = stt;
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
    }

    public ThongTinDocGia() {
        super();
    }
}