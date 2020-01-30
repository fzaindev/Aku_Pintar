package com.fzain.akupintar;

public class UniversitasModel {
    private int universitasID;
    private String namaUniversitas;
    private String akreditas;
    private String status;

    public UniversitasModel(int universitasID, String namaUniversitas, String akreditas, String status) {
        this.universitasID = universitasID;
        this.namaUniversitas = namaUniversitas;
        this.akreditas = akreditas;
        this.status = status;
    }

    public UniversitasModel(int universitasID, String namaUniversitas, String akreditas) {
        this.universitasID = universitasID;
        this.namaUniversitas = namaUniversitas;
        this.akreditas = akreditas;
    }

    public UniversitasModel(String namaUniversitas, String akreditas, String status) {
        this.namaUniversitas = namaUniversitas;
        this.akreditas = akreditas;
        this.status = status;
    }

    public int getUniversitasID() {
        return universitasID;
    }

    public void setUniversitasID(int universitasID) {
        this.universitasID = universitasID;
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
