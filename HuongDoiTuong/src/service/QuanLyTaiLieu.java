package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import data.TaiLieuDao;
import entity.TaiLieu;
import entity.DanhMuc;

public class QuanLyTaiLieu {
	public ArrayList<TaiLieu> dstl = new ArrayList<TaiLieu>();
	Scanner sc = new Scanner(System.in);
	TaiLieuDao obj = new TaiLieuDao();
	private final String filePath = "./Tailieu.txt";
	
	public void nhap() {
		int n;
		System.out.print("Số tài liệu cần nhập: ");
		n = sc.nextInt();
		sc.nextLine();
		int currentStudents = getNumberStudents1();
	    int successfulStudents = 0;
	    dstl = obj.readFile(filePath);
	    currentStudents = dstl.size();
		for (int i=0;i<n;i++) {
			 int stt = currentStudents + successfulStudents + 1;
		    System.out.println("STT: " + stt);
		    
			System.out.println("Nhập mã tài liệu: ");
			String maSach = sc.nextLine();
			System.out.println("Nhập tên tài liệu: ");
			String tenSach = sc.nextLine();
			System.out.println("Tác giả: ");
			String tacGia =sc.nextLine();
			System.out.println("Thể loại: ");
			String theLoai = sc.nextLine();
			System.out.println("Ma thể loại");
			String matheLoai = sc.nextLine();
			
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				System.out.println("Ngày nhập: ");
				Date ngayNhap = df.parse(sc.nextLine());
				TaiLieu tl = new TaiLieu(theLoai, matheLoai, stt, maSach, tenSach, tacGia, ngayNhap);
				dstl.add(tl);
				successfulStudents++;
			}catch (ParseException ex) {
				 System.out.println("Lỗi xảy ra: " + ex.getMessage());
			}
		}
		TaiLieuDao taiLieuDao = new TaiLieuDao();
		taiLieuDao.writeFile("./TaiLieu.txt", dstl);
	}
	

	public int getNumberStudents1() {
		TaiLieuDao taiLieuDao = new TaiLieuDao();
		ArrayList<TaiLieu> dstl = taiLieuDao.readFile("TaiLieu.txt");
		return dstl.size();
	}
	
	public void header() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	    System.out.println("-----------------------------------------------------DANH SÁCH TÀI LIỆU---------------------------------------------------");
	    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-5s | %-10s | %-20s | %-20s | %-17s | %-17s | %-17s |\n",
	            "STT", "Mã Sách", "Tên sách", "Tác giả", "Ngày nhập", "Danh mục", "Mã Danh Mục");
	    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void footer() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void hienthi() {
	    TaiLieuDao taiLieuDao = new TaiLieuDao();
	    ArrayList<TaiLieu> dstl = taiLieuDao.readFile("TaiLieu.txt");
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    header();

	    for (TaiLieu tl : dstl) {
	        String ngayNhapFormatted = df.format(tl.getNgayNhap());

	        System.out.printf("| %-5s | %-10s | %-20s | %-20s | %-17s | %-17s | %-17s |\n",
	                tl.getStt(), tl.getMaSach(), tl.getTenSach(), tl.getTacGia(), ngayNhapFormatted, 
	                tl.getTenDanhMuc(), tl.getMaDanhMuc());
	    }
	    footer();
	}
	
	public void timkiemms(String maSach) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		TaiLieuDao taiLieuDao = new TaiLieuDao();
		dstl = taiLieuDao.readFile("TaiLieu.txt");
	    System.out.println("Nhập mã Tài liệu cần tìm: ");
	    maSach = sc.nextLine();
	    boolean found = false; // Đặt cờ found để kiểm tra xem có tìm thấy mã sách hay không
	    for (TaiLieu tl : dstl) {
	        String ngayNhapFormatted = df.format(tl.getNgayNhap());
	        if (tl.getMaSach().equals(maSach)) { // Sử dụng equals() để so sánh giá trị của hai chuỗi
	        	header();
	        	System.out.printf("| %-5s | %-10s | %-20s | %-20s | %-17s | %-17s | %-17s |\n",
		                tl.getStt(), tl.getMaSach(), tl.getTenSach(), tl.getTacGia(), ngayNhapFormatted, 
		                tl.getTenDanhMuc(), tl.getMaDanhMuc());	           
	        	found = true; // Đặt cờ found thành true khi tìm thấy mã sách
	        }
	        footer();
	    }
	    if (!found) {
	        System.out.println("Không tìm thấy mã Tài liệu cần tìm!");
	    }
	}
	public void timkiemten(String tenSach) {
		TaiLieuDao taiLieuDao = new TaiLieuDao();
		dstl = taiLieuDao.readFile("TaiLieu.txt");
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("Nhập tên Tài liệu cần tìm: ");
	    tenSach = sc.nextLine();
	    boolean found = false; 
	    for (TaiLieu tl : dstl) {
	        String ngayNhapFormatted = df.format(tl.getNgayNhap());
	        if (tl.getTenSach().equals(tenSach)) { 
	        	System.out.printf("| %-5s | %-10s | %-20s | %-20s | %-17s | %-17s | %-17s |\n",
		                tl.getStt(), tl.getMaSach(), tl.getTenSach(), tl.getTacGia(), ngayNhapFormatted, 
		                tl.getTenDanhMuc(), tl.getMaDanhMuc());
	            found = true; 
	        }
	    }
	    if (!found) {
	        System.out.println("Không tìm thấy Tài liệu cần tìm!");
	    }
	}
	
	public void xoa(String maSach) {
	    System.out.println("Nhập mã Tài Liệu cần xóa: ");
	    maSach = sc.nextLine().trim();
	    boolean daXoa = false;
	    for (int i = 0; i < dstl.size(); i++) {
	        dstl.get(i).setStt(i + 1);
	        if (dstl.get(i).getMaSach().equals(maSach)) {
	            dstl.remove(i);
	            daXoa = true;
	            System.out.println("Tài Liệu " + maSach + " đã được xóa khỏi hệ thống!");
	            break;
	        }
	    }
	    if (!daXoa) {
	        System.out.println("Không tìm thấy Tài Liệu " + maSach + " trong hệ thống!");
	    }
	    TaiLieuDao taiLieuDao = new TaiLieuDao();
	    taiLieuDao.writeFile("./TaiLieu.txt", dstl);
	}
	
	public void chen() {
		TaiLieuDao taiLieuDao = new TaiLieuDao();
		dstl = taiLieuDao.readFile("TaiLieu.txt");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập vị trí bạn muốn chen: ");
		int stt = sc.nextInt();
		sc.nextLine();
		if (stt < 1 || stt > dstl.size() + 1) {
	        System.out.println("Vị trí STT không hợp lệ!");
	        return;
	    }
		System.out.println("Nhập mã tài liệu: ");
	    String maSach = sc.nextLine();
	    System.out.println("Nhập tên tài liệu: ");
	    String tenSach = sc.nextLine();
	    System.out.println("Tác giả: ");
	    String tacGia = sc.nextLine();
	    System.out.println("Danh mục: ");
	    String tenDanhMuc = sc.nextLine();
	    System.out.println("Mã danh mục: ");
	    String maDanhMuc = sc.nextLine();
	    sc.nextLine();

	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        System.out.println("Ngày Nhập: ");
	        Date ngayNhap = df.parse(sc.nextLine());
	        
	        TaiLieu tl = new TaiLieu(maDanhMuc, tenDanhMuc, stt, maSach, tenSach, tacGia, ngayNhap);
	        dstl.add(stt - 1, tl);
	        System.out.println("Thêm đọc giả thành công!");

	        // Cập nhật lại STT của các đối tượng sau vị trí chèn
	        for (int i = stt; i < dstl.size(); i++) {
	            dstl.get(i).setStt(dstl.get(i).getStt() + 1);
	        }

	        taiLieuDao.writeFile("TaiLieu.txt", dstl);
	    } catch (ParseException ex) {
	        System.out.println("Lỗi xảy ra: " + ex.getMessage());
	    }
	}
}
