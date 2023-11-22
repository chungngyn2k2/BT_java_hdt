package entity;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TaiLieu extends DanhMuc{
	private int stt;
	private String maSach;
	private String tenSach;
	private String tacGia;
	private Date ngayNhap;
	
	
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public TaiLieu(String maDanhMuc, String tenDanhMuc, int stt, String maSach, String tenSach, String tacGia,
			Date ngayNhap) {
		super(maDanhMuc, tenDanhMuc);
		this.stt = stt;
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.ngayNhap = ngayNhap;
	}
	public TaiLieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiLieu(String maDanhMuc, String tenDanhMuc) {
		super(maDanhMuc, tenDanhMuc);
		// TODO Auto-generated constructor stub
	}
	
}
