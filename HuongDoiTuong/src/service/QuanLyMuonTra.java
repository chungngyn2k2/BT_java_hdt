package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;	

import data.MuonTraDao;
import data.TaiLieuDao;
import entity.MuonTra;
import entity.TaiLieu;

public class QuanLyMuonTra {
    private ArrayList<MuonTra> dsmt;
    private Scanner sc;
    private MuonTraDao muonTraDao;
    private final String filePath = "./MuonTra.txt";

    public QuanLyMuonTra() {
        dsmt = new ArrayList<>();
        sc = new Scanner(System.in);
        muonTraDao = new MuonTraDao();
    }

    public void nhap() {
        int n;
        System.out.println("Số phiếu cần nhập: ");
        n = sc.nextInt();
        sc.nextLine();
        int currentStudents = getNumberStudents1();
        int successfulStudents = 0;
        dsmt = muonTraDao.readFile(filePath);
        currentStudents = dsmt.size();
        for (int i = 0; i < n; i++) {
            int stt = currentStudents + successfulStudents + 1;
            System.out.println("STT: " + stt);
            System.out.println("Nhập mã đọc giả");
            String maSv = sc.nextLine();
            System.out.println("Nhập mã tài liệu");
            String maSach = sc.nextLine();
            String trangThai="";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                System.out.println("Ngày mượn: ");
                Date ngayMuon = df.parse(sc.nextLine());
                System.out.println("Ngày trả (7 ngày): ");
                Date ngayTra = df.parse(sc.nextLine());

                boolean nhapDungTrangThai = false;

                do {
                    System.out.print("Nhập trạng thái (T - đã trả, C - chưa trả): ");
                    trangThai = sc.nextLine();

                    if (trangThai.equalsIgnoreCase("T")) {
                        trangThai = "Đã trả";
                        nhapDungTrangThai = true;
                    } else if (trangThai.equalsIgnoreCase("C")) {
                        trangThai = "Chưa trả";
                        nhapDungTrangThai = true;
                    } else {	
                        System.out.println("Trạng thái không hợp lệ! Vui lòng nhập lại.");
                    }
                } while (!nhapDungTrangThai);

                MuonTra mt = new MuonTra(stt, maSv, maSach, ngayMuon, ngayTra, trangThai);
                dsmt.add(mt);
                successfulStudents++;
            } catch (ParseException ex) {
                System.out.println("Lỗi xảy ra: " + ex.getMessage());
            }
        }

        muonTraDao.writeFile(filePath, dsmt);
    }

    public int getNumberStudents1() {
        dsmt = muonTraDao.readFile(filePath);
        return dsmt.size();
    }
    
    public void hienThi() {
        dsmt = muonTraDao.readFile(filePath);

        if (dsmt.isEmpty()) {
            System.out.println("Không có phiếu mượn sách nào.");
        } else {
            System.out.println("Danh sách phiếu mượn sách:");
            System.out.println("------------------------------------------------------------");
            System.out.printf("| %-4s | %-12s | %-12s | %-12s | %-12s | %-12s |\n",
                    "STT", "Mã Đọc Giả", "Mã Tài Liệu", "Ngày Mượn", "Ngày Trả", "Trạng Thái");
            System.out.println("------------------------------------------------------------");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (MuonTra mt : dsmt) {
                String maSv = mt.getThongTinDocGia();
                String maSach = mt.getTaiLieu();
                String ngayMuon = dateFormat.format(mt.getNgayMuon());
                String ngayTra = dateFormat.format(mt.getNgayTra());

                System.out.printf("| %-4d | %-12s | %-12s | %-12s | %-12s | %-12s |\n",
                        mt.getStt(), maSv, maSach, ngayMuon, ngayTra, mt.getTrangThai());
            }
            System.out.println("------------------------------------------------------------");
        }
    }
    
    public void timkiemmasv(String maSv) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        MuonTraDao muonTraDao = new MuonTraDao();
        dsmt = muonTraDao.readFile("TaiLieu.txt");
        System.out.println("Nhập mã đọc giả cần tìm: ");
        maSv = sc.nextLine().trim();
        boolean found = false; 
        for (MuonTra mt : dsmt) {
            String maSvMuonTra = mt.getThongTinDocGia(); 
            String maSach = mt.getTaiLieu();
            String ngayMuon = df.format(mt.getNgayMuon());
            String ngayTra = df.format(mt.getNgayTra());
            if (maSvMuonTra.equals(maSv)) { 
                // header();
                System.out.printf("| %-4d | %-12s | %-12s | %-12s | %-12s | %-12s |\n",
                        mt.getStt(), maSvMuonTra, maSach, ngayMuon, ngayTra, mt.getTrangThai());
                found = true;
            }
            // footer();
        }
        if (!found) {
            System.out.println("Không tìm thấy mã Đọc giả cần tìm!");
        }
    }
    
    public void thayDoiTrangThaiMuonTra(String maSv, String maSach) {
        dsmt = muonTraDao.readFile(filePath);
        boolean found = false;
        for (MuonTra mt : dsmt) {
            if (mt.getThongTinDocGia().equals(maSv) && mt.getTaiLieu().equals(maSach)) {
                if (mt.getTrangThai().equalsIgnoreCase("C")) {
                    mt.setTrangThai("Đã trả");
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            muonTraDao.writeFile(filePath, dsmt);
            System.out.println("Thay đổi trạng thái thành công.");
        } else {
            System.out.println("Không tìm thấy phiếu mượn sách tương ứng.");
        }
    }
}