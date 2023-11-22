package main;

import java.util.Scanner;

import service.QuanLyDocGia;
import service.QuanLyMuonTra;
import service.QuanLyTaiLieu;

public class MainClass {
	
	QuanLyTaiLieu tlobj = new QuanLyTaiLieu();
	QuanLyDocGia dgobj = new QuanLyDocGia();
	QuanLyMuonTra mtobj = new QuanLyMuonTra();
	Scanner sc = new Scanner(System.in);
	
	public void menuTL() {
	    int c1 = -1;
	    do {
	        System.out.println("======================================================");
	        System.out.println("||-----------------QUẢN LÝ TÀI LIỆU-----------------||");
	        System.out.println("|| 1. THÊM TÀI LIỆU_________________________________||");
	        System.out.println("|| 2. HIỂN THỊ DANH SÁCH TÀI LIỆU___________________||");
	        System.out.println("|| 3. TÌM KIẾM TÀI LIỆU THEO MÃ_____________________||");
	        System.out.println("|| 4. TÌM KIẾM TÀI LIỆU THEO TÊN____________________||");
	        System.out.println("|| 5. XÓA TÀI LIỆU__________________________________||");
	        System.out.println("|| 6. CHÈN THÊM TÀI LIỆU____________________________||");
	        System.out.println("|| 0. THOÁT_________________________________________||");
	        System.out.println("======================================================");
	        System.out.println("Hiện tại có " + tlobj.getNumberStudents1() + " Tài liệu");
	        System.out.println("Lựa chọn tác vụ của bạn là(0-6): ");

	        // Sử dụng một biến boolean để kiểm tra tính hợp lệ của đầu vào
	        boolean validInput = false;

	        while (!validInput) {
	            try {
	                c1 = Integer.parseInt(sc.nextLine());

	                // Kiểm tra giá trị của c1
	                if (c1 >= 0 && c1 <= 6) {
	                    validInput = true; // Đánh dấu đầu vào là hợp lệ
	                } else {
	                    System.out.println("----------LỰA CHỌN KHÔNG HỢP LỆ, VUI LÒNG NHẬP LẠI------------");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("----------LỰA CHỌN PHẢI LÀ SỐ------------");
	            }
	        }

	        switch (c1) {
	            case 1: {
	                tlobj.nhap();
	                break;
	            }
	            case 2: {
	                tlobj.hienthi();
	                break;
	            }
	            case 3: {
	                tlobj.timkiemms(null);
	                break;
	            }
	            case 4: {
	                tlobj.timkiemten(null);
	                break;
	            }
	            case 5: {
	                tlobj.xoa(null);
	                break;
	            }
	            case 6: {
	                tlobj.chen();
	            }
	            default:
	                break;
	        }
	    } while (c1 != 0);
	}
	
	public void menuDG() {
		int c2 = -1;
		do {
			System.out.println("=====================================================");
			System.out.println("||-----------------QUẢN LÝ ĐỘC GIẢ-----------------||");
			System.out.println("|| 1. THÊM ĐỌC GIẢ_________________________________||");
			System.out.println("|| 2. HIỂN THỊ DANH SÁCH ĐỌC GIẢ___________________||");
			System.out.println("|| 3. TÌM KIẾM ĐỌC GIẢ THEO MÃ_____________________||");
			System.out.println("|| 4. TÌM KIẾM ĐỌC GIẢ THEO TÊN____________________||");
			System.out.println("|| 5. XÓA ĐỌC GIẢ__________________________________||");
			System.out.println("|| 6. CHÈN THÔNG TIN ĐỌC GIẢ_______________________||");
			System.out.println("|| 7. SẮP XẾP THEO NGÀY ĐĂNG KÍ GẦN NHẤT___________||");
			System.out.println("|| 0. Thoát________________________________________||");
			System.out.println("=====================================================");
			System.out.println("Hiện tại có " + dgobj.getNumberStudents() + " Đọc giả");
			System.out.println("Lựa chọn tác vụ của bạn là(0-7): ");
			boolean validInput = false;

	        while (!validInput) {
	            try {
	                c2 = Integer.parseInt(sc.nextLine());

	                // Kiểm tra giá trị của c1
	                if (c2 >= 0 && c2 <= 7) {
	                    validInput = true; // Đánh dấu đầu vào là hợp lệ
	                } else {
	                    System.out.println("----------LỰA CHỌN KHÔNG HỢP LỆ, VUI LÒNG NHẬP LẠI------------");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("----------LỰA CHỌN PHẢI LÀ SỐ------------");
	            }
	        }
			switch(c2) {
			case 1: {
				dgobj.nhap();
				break;
			}
			case 2: {
				dgobj.hienthi();
				break;
			}
			case 3: {
				dgobj.timkiemma(null);
				break;
			}
			case 4: {
				dgobj.timkiemten(null);
				break;
			}
			case 5: {
				dgobj.xoa(null);
				break;
			}
			case 6: {
				dgobj.chen();
			}
			case 7: {
				dgobj.sapXepTheoNgayGanNhat();
				break;
			}
			default: break;
			}
		}while(c2 != 0);
	}
	
	public void menuMT() {
		int c3 = -1;
		do {
			System.out.println("=====================================================");
			System.out.println("||-----------------QUẢN LÝ MƯỢN TRẢ----------------||");
			System.out.println("|| 1. NHẬP PHIẾU MỚI ______________________________||");
			System.out.println("|| 2. HIỂN THỊ DANH SÁCH PHIẾU MƯỢN________________||");
			System.out.println("|| 3. TÌM KIẾM PHIẾU MƯỢN THEO MÃ__________________||");
			System.out.println("|| 4. TÌM KIẾM PHIẾU MƯỢN THEO TÊN_________________||");
			System.out.println("|| 5. XÓA PHIẾU____________________________________||");
			System.out.println("|| 6. SỬA TRẠNG THÁI_______________________________||");
			System.out.println("|| 0. Thoát________________________________________||");
			System.out.println("=====================================================");
			boolean validInput = false;

	        while (!validInput) {
	            try {
	                c3 = Integer.parseInt(sc.nextLine());

	                if (c3 >= 0 && c3 <= 6) {
	                    validInput = true;
	                } else {
	                    System.out.println("----------LỰA CHỌN KHÔNG HỢP LỆ, VUI LÒNG NHẬP LẠI------------");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("----------LỰA CHỌN PHẢI LÀ SỐ------------");
	            }
	        }
	        switch(c3) {
			case 1: {
				mtobj.nhap();
				break;
			}
			case 2: {
				mtobj.hienThi();
				break;
			}
			case 3: {
				mtobj.timkiemmasv(null);
				break;
			}
			case 4: {
				break;
			}
			case 5: {
				break;
			}
			case 6: {
				mtobj.thayDoiTrangThaiMuonTra(null, null);
				break;
			}
			default: break;
			}
		}while(c3 != 0);
	}
}

