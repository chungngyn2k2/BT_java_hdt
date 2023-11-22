package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.ThongTinDocGia;

public class DocGiaDao {
	public void writeFile(String filePath, ArrayList<ThongTinDocGia> dsdg) {
	    try {
	        FileWriter writer = new FileWriter(filePath);
	        for (ThongTinDocGia dg : dsdg) {
	            String line = dg.getStt() + "," +
	                    dg.getMaSv() + "," +
	                    dg.getHoTen() + "," +
	                    dg.getLop() + "," +
	                    dg.getSdt() + "," +
	                    dg.getNgaySinh() + "," +
	                    dg.getNgayThamGia() + "," +
	                    dg.getNgayHetHan();
	            writer.write(line + "\n");
	        }
	        writer.close();
	        System.out.println("Dữ liệu đã được ghi vào tệp " + filePath);
	    } catch (IOException e) {
	        System.out.println("Lỗi xảy ra khi ghi file: " + e.getMessage());
	    }
	}

	public ArrayList<ThongTinDocGia> readFile(String filePath) {
	    ArrayList<ThongTinDocGia> dsdg = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] fields = line.split(",");
	            if (fields.length == 8) {
	                int stt = Integer.parseInt(fields[0].trim());
	                String maSv = fields[1].trim();
	                String hoTen = fields[2].trim();
	                String lop = fields[3].trim();
	                int sdt = Integer.parseInt(fields[4].trim());
	                Date ngaySinh = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(fields[5].trim());
	                Date ngayThamGia = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(fields[6].trim());
	                Date ngayHetHan = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(fields[7].trim());

	                ThongTinDocGia dg = new ThongTinDocGia(ngayThamGia, ngayHetHan, stt, maSv, hoTen, lop, ngaySinh, sdt);
	                dsdg.add(dg);
	            }
	        }
	    } catch (IOException | ParseException e) {
	        System.out.println("Lỗi xảy ra khi đọc file: " + e.getMessage());
	    }

	    return dsdg;
	}
}