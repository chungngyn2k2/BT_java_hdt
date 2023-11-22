package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.MuonTra;

public class MuonTraDao {
    public void writeFile(String filePath, ArrayList<MuonTra> dsmt) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (MuonTra mt : dsmt) {
                String line = mt.getStt() + "," +
                        mt.getThongTinDocGia() + "," +
                        mt.getTaiLieu() + "," +
                        mt.getNgayMuon() + "," +
                        mt.getNgayTra() + "," +
                        mt.getTrangThai() + "," ;
                writer.write(line + "\n");
            }
            writer.close();
            System.out.println("Dữ liệu đã được ghi vào tệp " + filePath);
        } catch (IOException e) {
            System.out.println("Lỗi xảy ra khi ghi file: " + e.getMessage());
        }
    }

    public ArrayList<MuonTra> readFile(String filePath) {
        ArrayList<MuonTra> dsmt = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) {
                    int stt = Integer.parseInt(fields[0].trim());
                    String maSv = fields[1].trim();
                    String maSach = fields[2].trim();
                    Date ngayMuon = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(fields[3].trim());
                    Date ngayTra = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").parse(fields[4].trim());
                    String trangThai = fields[5].trim();

                    MuonTra mt = new MuonTra(stt, maSv, maSach, ngayMuon, ngayTra, trangThai);
                    dsmt.add(mt);
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Lỗi xảy ra khi đọc file: " + e.getMessage());
        }

        return dsmt;
    }
}