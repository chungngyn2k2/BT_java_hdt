package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.TaiLieu;

public class TaiLieuDao {
    public void writeFile(String filePath, ArrayList<TaiLieu> dstl) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (TaiLieu tl : dstl) {
                String line = tl.getStt() + "," +
                        tl.getMaSach() + "," +
                        tl.getTenSach() + "," +
                        tl.getTacGia() + "," +
                        tl.getNgayNhap() + "," +
                        tl.getTenDanhMuc() + "," +
                        tl.getMaDanhMuc() + ",";
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("Dữ liệu đã được ghi vào tệp " + filePath);
        } catch (IOException e) {
            System.out.println("Lỗi xảy ra khi ghi file: " + e.getMessage());
        }
    }

    public ArrayList<TaiLieu> readFile(String filePath) {
        ArrayList<TaiLieu> dstl = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 7) { // Sửa thành 7 vì chỉ có 7 trường thông tin
                    int stt = Integer.parseInt(fields[0].trim());
                    String maSach = fields[1].trim();
                    String tenSach = fields[2].trim();
                    String tacGia = fields[3].trim();
                    Date ngayNhap = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(fields[4].trim());
                    String tenDanhMuc = fields[5].trim();
                    String maDanhMuc = fields[6].trim(); // Sửa vị trí maDanhMuc và tenDanhMuc

                    TaiLieu tl = new TaiLieu(maDanhMuc, tenDanhMuc, stt, maSach, tenSach, tacGia, ngayNhap);
                    dstl.add(tl);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Lỗi xảy ra khi đọc file: " + e.getMessage());
        }

        return dstl;
    }
}