package com.fzain.akupintar.Model;

public class UniversitasModel {
    private int Id;
    private String namaUniversitas;
    private String akreditas;
    private String status;


    public UniversitasModel(int universitasID, String namaUniversitas, String akreditas, String status) {
        this.Id = universitasID;
        this.namaUniversitas = namaUniversitas;
        this.akreditas = akreditas;
        this.status = status;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }

    public String getNamaUniversitas() {
        return namaUniversitas;
    }
    public void setNamaUniversitas(String namaUniversitas) {
        this.namaUniversitas = namaUniversitas;
    }

    public String getAkreditas() {
        return akreditas;
    }
    public void setAkreditas(String akreditas) {
        this.akreditas = akreditas;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }





}
