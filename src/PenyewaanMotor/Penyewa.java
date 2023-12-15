/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PenyewaanMotor;

/**
 *
 * @author lilis
 */
public class Penyewa extends PenyewaanMotorHasib{
    String tglPinjam,tglKembali,tglDikembalikan;
    private String idsewa;
    void tglPinjam (String tglPinjam){
        this.tglPinjam = tglPinjam;
    }
    void tglKembali (String tglKembali){
        this.tglKembali = tglKembali;
    }
    void idsewa (String idsewa){
        this.idsewa = idsewa;
    }
    void tglDikembalikan (String tglDikembalikan){
        this.tglDikembalikan = tglDikembalikan;
    }
    public void setIdsewa(String idsewa) {
        this.idsewa = idsewa;
    }
    public String getIdsewa() {
        return idsewa;
    }
    String tglPinjam(){
        return tglPinjam;
    }
    String tglKembali(){
        return tglKembali;
    }
    String idsewa(){
        return idsewa;
    }
    String tglDikembalikan(){
        return tglDikembalikan;
    }
    @Override
    void identitas(String Identitas) {
        this.identitas = Identitas;
    }
    @Override
    int denda() {
        return 0;
    }
    @Override
    int denda(int hari) {
        totaldn = hari * 150000;
        return totaldn;
    }
}
