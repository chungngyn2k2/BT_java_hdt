package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import data.DocGiaDao;
import entity.DocGia;
import entity.ThongTinDocGia;

public class QuanLyDocGia {
	
	public ArrayList<ThongTinDocGia> dsdg = new ArrayList<ThongTinDocGia>();
	Scanner sc = new Scanner(System.in);
	DocGiaDao obj = new DocGiaDao();
	private final String filePath = "./DocGia.txt";
	
	public void nhap() {
	    int n;
	    System.out.println("Số đọc giả cần nhập: ");
	    n = sc.nextInt();
	    sc.nextLine();
	    int currentStudents = getNumberStudents();
	    int successfulStudents = 0;
	    dsdg = obj.readFile(filePath);// Số lượng sinh viên đã nhập thành công
	    currentStudents = dsdg.size();
	    for (int i = 0; i < n; i++) {
	        int stt = currentStudents + successfulStudents + 1;
	        System.out.println("STT: " + stt);
	        
	        System.out.println("Nhập mã đọc giả: ");
	        String maSv = sc.nextLine();
	        System.out.println("Nhập tên đọc giả: ");
	        String hoTen = sc.nextLine();
	        System.out.println("Lớp: ");
	        String Lop = sc.nextLine();
	        System.out.println("Số liên lạc: ");
	        int sdt = sc.nextInt();
	        sc.nextLine();

	        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	            System.out.println("Ngày sinh: ");
	            Date ngaySinh = df.parse(sc.nextLine());
	            System.out.println("Ngày Tham gia: ");
	            Date ngayThamGia = df.parse(sc.nextLine());
	            System.out.println("Ngày hết hạn(2 tháng): ");
	            Date ngayHetHan = df.parse(sc.nextLine());
	            ThongTinDocGia dg = new ThongTinDocGia(ngayThamGia, ngayHetHan, stt, maSv,
	            		hoTen, Lop, ngaySinh, sdt);
	            dsdg.add(dg);
	            successfulStudents++; // Tăng số lượng sinh viên đã nhập thành công
	        } catch (ParseException ex) {
	            System.out.println("Lỗi xảy ra: " + ex.getMessage());
	        }
	    }
	    DocGiaDao docGiaDao = new DocGiaDao();
	    docGiaDao.writeFile("./DocGia.txt", dsdg);
	}
	
	public int getNumberStudents() {
		DocGiaDao docGiaDao = new DocGiaDao();
		ArrayList<ThongTinDocGia> dsdg = docGiaDao.readFile("DocGia.txt");
		return dsdg.size();
	}
	
	public void header() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	    System.out.println("-----------------------------------------------------DANH SÁCH ĐỌC GIẢ----------------------------------------------------");
	    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("| %-5s | %-10s | %-20s | %-10s | %-15s | %-12s | %-14s | %-12s |\n",
	            "STT", "Mã SV", "Họ và tên", "Lớp", "Số điện thoại", "Ngày sinh", "Ngày tham gia", "Ngày hết hạn");
	    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void footer() {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void hienthi() {
	    DocGiaDao docGiaDao = new DocGiaDao();
	    ArrayList<ThongTinDocGia> dsdg = docGiaDao.readFile("DocGia.txt");
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    header();

	    for (ThongTinDocGia dg : dsdg) {
	        String ngaySinhFormatted = df.format(dg.getNgaySinh());
	        String ngayThamGiaFormatted = df.format(dg.getNgayThamGia());
	        String ngayHetHanFormatted = df.format(dg.getNgayHetHan());

	        System.out.printf("| %-5d | %-10s | %-20s | %-10s | %-15d | %-12s | %-14s | %-12s |\n",
	                dg.getStt(), dg.getMaSv(), dg.getHoTen(), dg.getLop(), dg.getSdt(),
	                ngaySinhFormatted, ngayThamGiaFormatted, ngayHetHanFormatted);
	    }
	    footer();
	}
	
	public void timkiemma(String maSv) {
	    DocGiaDao docGiaDao = new DocGiaDao();
	    dsdg = docGiaDao.readFile("DocGia.txt");
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("Nhập mã Đọc giả cần tìm: ");
	    maSv = sc.nextLine();
	    boolean found = false;
	    for (ThongTinDocGia dg : dsdg) {
	        String ngaySinhFormatted = df.format(dg.getNgaySinh());
	        String ngayThamGiaFormatted = df.format(dg.getNgayThamGia());
	        String ngayHetHanFormatted = df.format(dg.getNgayHetHan());
	        if (dg.getMaSv().equals(maSv)) {
	        	header();
	            System.out.printf("| %-5d | %-10s | %-20s | %-10s | %-15d | %-12s | %-14s | %-12s |\n",
	                    dg.getStt(), dg.getMaSv(), dg.getHoTen(), dg.getLop(), dg.getSdt(),
	                    ngaySinhFormatted, ngayThamGiaFormatted, ngayHetHanFormatted);
	            found = true;
	        }
	        footer();
	    }
	    if (!found) {
	        System.out.println("Không tìm thấy mã Đọc giả cần tìm!");
	    }
	}

	public void timkiemten(String hoTen) {
	    DocGiaDao docGiaDao = new DocGiaDao();
	    dsdg = docGiaDao.readFile("DocGia.txt");
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("Nhập tên Đọc giả cần tìm: ");
	    hoTen = sc.nextLine();
	    boolean found = false;
	    for (ThongTinDocGia dg : dsdg) {
	        String ngaySinhFormatted = df.format(dg.getNgaySinh());
	        String ngayThamGiaFormatted = df.format(dg.getNgayThamGia());
	        String ngayHetHanFormatted = df.format(dg.getNgayHetHan());
	        if (dg.getHoTen().equals(hoTen)) {
	        	header();
	            System.out.printf("| %-5d | %-10s | %-20s | %-10s | %-15d | %-12s | %-14s | %-12s |\n",
	                    dg.getStt(), dg.getMaSv(), dg.getHoTen(), dg.getLop(), dg.getSdt(),
	                    ngaySinhFormatted, ngayThamGiaFormatted, ngayHetHanFormatted);
	            found = true;
	        }
	        footer();
	    }
	    if (!found) {
	        System.out.println("Không tìm thấy Đọc giả cần tìm!");
	    }
	}
	
	public void xoa(String maSv) {
	    System.out.println("Nhập mã Đọc giả cần xóa: ");
	    maSv = sc.nextLine().trim();
	    boolean daXoa = false;
	    for (int i = 0; i < dsdg.size(); i++) {
	        dsdg.get(i).setStt(i + 1);
	        if (dsdg.get(i).getMaSv().equals(maSv)) {
	            dsdg.remove(i);
	            daXoa = true;
	            System.out.println("Đọc giả " + maSv + " đã được xóa khỏi hệ thống!");
	            break;
	        }
	    }
	    if (!daXoa) {
	        System.out.println("Không tìm thấy đọc giả " + maSv + " trong hệ thống!");
	    }
	    DocGiaDao docGiaDao = new DocGiaDao();
	    docGiaDao.writeFile("./DocGia.txt", dsdg);
	}
	

	public void chen() {
	    DocGiaDao docGiaDao = new DocGiaDao();
	    dsdg = docGiaDao.readFile("DocGia.txt");
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Nhập vị trí STT cần chèn: ");
	    int stt = sc.nextInt();
	    sc.nextLine();
	    if (stt < 1 || stt > dsdg.size() + 1) {
	        System.out.println("Vị trí STT không hợp lệ!");
	        return;
	    }

	    System.out.println("Nhập mã đọc giả: ");
	    String maSv = sc.nextLine();
	    System.out.println("Nhập tên đọc giả: ");
	    String hoTen = sc.nextLine();
	    System.out.println("Lớp: ");
	    String Lop = sc.nextLine();
	    System.out.println("Số liên lạc: ");
	    int sdt = sc.nextInt();
	    sc.nextLine();

	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        System.out.println("Ngày sinh: ");
	        Date ngaySinh = df.parse(sc.nextLine());
	        System.out.println("Ngày Tham gia: ");
	        Date ngayThamGia = df.parse(sc.nextLine());
	        System.out.println("Ngày hết hạn(2 tháng): ");
	        Date ngayHetHan = df.parse(sc.nextLine());

	        ThongTinDocGia dg = new ThongTinDocGia(ngayThamGia, ngayHetHan, stt, maSv, 
	        		hoTen, Lop, ngaySinh, sdt);
	        dsdg.add(stt - 1, dg);
	        System.out.println("Thêm đọc giả thành công!");

	        // Cập nhật lại STT của các đối tượng sau vị trí chèn
	        for (int i = stt; i < dsdg.size(); i++) {
	            dsdg.get(i).setStt(dsdg.get(i).getStt() + 1);
	        }

	        docGiaDao.writeFile("DocGia.txt", dsdg);
	    } catch (ParseException ex) {
	        System.out.println("Lỗi xảy ra: " + ex.getMessage());
	    }
	}
	
	    public void sapXepTheoNgayGanNhat() {
	        DocGiaDao docGiaDao = new DocGiaDao();
	        dsdg = docGiaDao.readFile("DocGia.txt");

	        Comparator<ThongTinDocGia> comparator = new Comparator<ThongTinDocGia>() {
	            @Override
	            public int compare(ThongTinDocGia dg1, ThongTinDocGia dg2) {
	                return dg1.getNgayThamGia().compareTo(dg2.getNgayThamGia());
	            }
	        };

	        Collections.sort(dsdg, comparator);

	        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	        header();
	        for (ThongTinDocGia dg : dsdg) {
	            String ngaySinhFormatted = df.format(dg.getNgaySinh());
	            String ngayThamGiaFormatted = df.format(dg.getNgayThamGia());
	            String ngayHetHanFormatted = df.format(dg.getNgayHetHan());

	            System.out.printf("| %-5d | %-10s | %-20s | %-10s | %-15d | %-12s | %-14s | %-12s |\n",
	                    dg.getStt(), dg.getMaSv(), dg.getHoTen(), dg.getLop(), dg.getSdt(),
	                    ngaySinhFormatted, ngayThamGiaFormatted, ngayHetHanFormatted);
	        }
	        footer();
	    }
	
}
