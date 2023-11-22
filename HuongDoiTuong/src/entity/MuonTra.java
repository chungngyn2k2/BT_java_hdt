package entity;

import java.util.Date;

public class MuonTra {
    private int stt;
    private String thongTinDocGia;
    private String taiLieu;
    private Date ngayMuon;
    private Date ngayTra;
    private String trangThai;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getThongTinDocGia() {
        return thongTinDocGia;
    }

    public void setThongTinDocGia(String thongTinDocGia) {
        this.thongTinDocGia = thongTinDocGia;
    }

    public String getTaiLieu() {
        return taiLieu;
    }

    public void setTaiLieu(String taiLieu) {
        this.taiLieu = taiLieu;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
 // Phương thức getter cho mã đọc giả
//    public String getMaDocGia() {
//        return thongTinDocGia.getMaSv();
//    }
//
//    // Phương thức getter cho mã tài liệu
//    public String getMaTaiLieu() {
//        return taiLieu.getMaSach();
//    }

	public MuonTra(int stt, String maSv, String maSach, Date ngayMuon, Date ngayTra,
			String trangThai) {
		super();
		this.stt = stt;
		this.thongTinDocGia = maSv;
		this.taiLieu = maSach;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.trangThai = trangThai;
	}

    
}
	
