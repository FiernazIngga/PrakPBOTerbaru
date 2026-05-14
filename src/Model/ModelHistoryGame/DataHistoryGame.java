/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.ModelHistoryGame;

import java.time.LocalDateTime;

public class DataHistoryGame {

    private int id;
    private String namaPilot1;
    private String namaPilot2;
    private String namaPesawat1;
    private String namaPesawat2;
    private LocalDateTime waktu_mulai;
    private LocalDateTime waktu_selesai;
    private LocalDateTime waktu_sekarang;
    private String catatan;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNamaPilot1() {
        return namaPilot1;
    }

    public void setNamaPilot1(String namaPilot1) {
        this.namaPilot1 = namaPilot1;
    }

    public String getNamaPilot2() {
        return namaPilot2;
    }

    public void setNamaPilot2(String namaPilot2) {
        this.namaPilot2 = namaPilot2;
    }
    
    public String getNamaPesawat1() {
        return namaPesawat1;
    }

    public void setNamaPesawat1(String namaPesawat1) {
        this.namaPesawat1 = namaPesawat1;
    }

    public String getNamaPesawat2() {
        return namaPesawat2;
    }

    public void setNamaPesawat2(String namaPesawat2) {
        this.namaPesawat2 = namaPesawat2;
    }

    public LocalDateTime getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(LocalDateTime waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public LocalDateTime getWaktu_selesai() {
        return waktu_selesai;
    }

    public void setWaktu_selesai(LocalDateTime waktu_selesai) {
        this.waktu_selesai = waktu_selesai;
    }

    public LocalDateTime getWaktu_sekarang() {
        return waktu_sekarang;
    }

    public void setWaktu_sekarang(LocalDateTime waktu_sekarang) {
        this.waktu_sekarang = waktu_sekarang;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}