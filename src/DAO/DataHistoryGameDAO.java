package DAO;

import Interface.InterfaceHistoryGame;
import Model.ModelHistoryGame.DataHistoryGame;
import Connector.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataHistoryGameDAO implements InterfaceHistoryGame {

    Connection conn;

    public DataHistoryGameDAO() {
        Connector c = new Connector();
        conn = c.connection;
    }

    @Override
    public void insert(DataHistoryGame h) {

        try {

            String sql = "INSERT INTO history_game "
                    + "(namaPilot1, namaPilot2, namaPesawat1, namaPesawat2, waktu_mulai, waktu_selesai, waktu_sekarang, catatan) "
                    + "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, h.getNamaPilot1());
            ps.setString(2, h.getNamaPilot2());

            ps.setString(3, h.getNamaPesawat1());
            ps.setString(4, h.getNamaPesawat2());

            ps.setTimestamp(5, Timestamp.valueOf(h.getWaktu_mulai()));
            ps.setTimestamp(6, Timestamp.valueOf(h.getWaktu_selesai()));
            ps.setTimestamp(7, Timestamp.valueOf(h.getWaktu_sekarang()));

            ps.setString(8, h.getCatatan());

            ps.executeUpdate();

            System.out.println("Insert berhasil");

        } catch (SQLException e) {
            System.out.println("Insert gagal");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<DataHistoryGame> getAll() {

        List<DataHistoryGame> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM history_game";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                DataHistoryGame h = new DataHistoryGame();
                
                h.setId(
                    Integer.parseInt(rs.getString("id"))
                );
                
                h.setNamaPilot1(
                    rs.getString("namaPilot1")
                );

                h.setNamaPilot2(
                    rs.getString("namaPilot2")
                );

                h.setNamaPesawat1(
                    rs.getString("namaPesawat1")
                );

                h.setNamaPesawat2(
                    rs.getString("namaPesawat2")
                );

                h.setWaktu_mulai(
                    rs.getTimestamp("waktu_mulai").toLocalDateTime()
                );

                h.setWaktu_selesai(
                    rs.getTimestamp("waktu_selesai").toLocalDateTime()
                );

                h.setWaktu_sekarang(
                    rs.getTimestamp("waktu_sekarang").toLocalDateTime()
                );

                h.setCatatan(
                    rs.getString("catatan")
                );

                list.add(h);
            }

        } catch (SQLException e) {
            System.out.println("Get all gagal");
            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public void update(DataHistoryGame h) {

        try {

            String sql = "UPDATE history_game SET "
                    + "namaPilot1=?, "
                    + "namaPilot2=?, "
                    + "namaPesawat1=?, "
                    + "namaPesawat2=?, "
                    + "waktu_mulai=?, "
                    + "waktu_selesai=?, "
                    + "waktu_sekarang=?, "
                    + "catatan=? "
                    + "WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, h.getNamaPilot1());
            ps.setString(2, h.getNamaPilot2());

            ps.setString(3, h.getNamaPesawat1());
            ps.setString(4, h.getNamaPesawat2());

            ps.setTimestamp(5, Timestamp.valueOf(h.getWaktu_mulai()));
            ps.setTimestamp(6, Timestamp.valueOf(h.getWaktu_selesai()));
            ps.setTimestamp(7, Timestamp.valueOf(h.getWaktu_sekarang()));

            ps.setString(8, h.getCatatan());

            ps.setInt(9, h.getId());

            ps.executeUpdate();

            System.out.println("Update berhasil");

        } catch (SQLException e) {
            System.out.println("Update gagal");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {

        try {

            String sql = "DELETE FROM history_game WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int row = ps.executeUpdate();
            System.out.println("Row affected: " + row);

            System.out.println("Delete berhasil");

        } catch (SQLException e) {
            System.out.println("Delete gagal");
            System.out.println(e.getMessage());
        }
    }
    
    public String data(String field) {

        try {

            String sql = "SELECT * FROM history_game ORDER BY id DESC LIMIT 1";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                switch (field) {

                    case "namaPilot1":
                        return rs.getString("namaPilot1");

                    case "namaPilot2":
                        return rs.getString("namaPilot2");

                    case "namaPesawat1":
                        return rs.getString("namaPesawat1");

                    case "namaPesawat2":
                        return rs.getString("namaPesawat2");

                    case "catatan":
                        return rs.getString("catatan");

                    default:
                        return "";
                }
            }

        } catch (SQLException e) {

            System.out.println("Get latest data gagal");
            System.out.println(e.getMessage());
        }

        return "";
    }
}

