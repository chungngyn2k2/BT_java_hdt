package main;

import service.QuanLyTaiLieu;
import java.util.Scanner;

public class Main {
    QuanLyTaiLieu tlobj = new QuanLyTaiLieu();
    MainClass menu = new MainClass();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MainClass menu = new MainClass();
        Scanner sc = new Scanner(System.in);
        int select =-1;
        do {
            System.out.println("=====================================================");
            System.out.println("||-----------------QUẢN LÝ THƯ VIỆN----------------||");
            System.out.println("||-----------------ĐẠI HỌC PHÚ XUÂN----------------||");
            System.out.println("|| 1. QUẢN LÝ TÀI LIỆU_____________________________||");
            System.out.println("|| 2. QUẢN LÝ ĐỌC GIẢ______________________________||");
            System.out.println("|| 3. QUẢN LÝ THÔNG TIN MƯỢN TRẢ___________________||");
            System.out.println("|| 0. THOÁT________________________________________||");
            System.out.println("=====================================================");
            System.out.println("Lựa chọn tác vụ của bạn là (0-3): ");
            try {
                select = Integer.parseInt(sc.nextLine());
                if (select < 0 || select > 3) {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
                continue;
            }
            switch (select) {
                case 1: {
                    menu.menuTL();
                    break;
                }
                case 2: {
                    menu.menuDG();
                    break;
                }
                case 3: {
                    menu.menuMT();
                    break;
                }
                default:
                    break;
            }
        } while (select != 0);
    }
}