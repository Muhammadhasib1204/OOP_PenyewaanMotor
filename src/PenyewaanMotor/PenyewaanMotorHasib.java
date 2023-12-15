/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PenyewaanMotor;

/**
 *
 * @author lilis
 */
public class PenyewaanMotorHasib extends Abstract {
    String Nama,Umur,Alamat,JenisMotor,WarnaMotor;
    String MetodePmbyrn;
    String identitas;
    int HargaSewa,totalbayar,DurasiPenyewaan;
    int dndhr,totaldn;
    double pajak;
    void Nama(String Nama){
        this.Nama = Nama;
    }
    void Umur (String Umur){
        this.Umur = Umur;
    }
    void Alamat(String Alamat){
        this.Alamat = Alamat;
    }
    void JenisMotor(String JenisMotor){
        this.JenisMotor = JenisMotor;
    }
    void WarnaMotor(String WarnaMotor){
        this.WarnaMotor = WarnaMotor;
    }
    void DurasiPenyewaan(int DurasiPenyewaan){
        this.DurasiPenyewaan = DurasiPenyewaan;
    }
    void HargaSewa(int Hargasewa){
        this.HargaSewa = Hargasewa;
    }
    void MetodePmbyrn(String MetodePmbyrn){
        this.MetodePmbyrn = MetodePmbyrn;
    }
    public void setMetodePmbyrn(String MetodePmbyrn) {
        this.MetodePmbyrn = MetodePmbyrn;
    }
    public String getMetodePmbyrn() {
        return MetodePmbyrn;
    }

    public PenyewaanMotorHasib() {
        this.HargaSewa = 250000;
        this.pajak = 0.1;
    }
    public int PenyewaanMotorHasib(){
        totalbayar = (HargaSewa * DurasiPenyewaan);
        return totalbayar;
    }
    String Identitas(){
        return identitas;
    }
    String Nama(){
        return Nama;
    }
    String Umur(){
        return Umur;
    }
    String Alamat(){
        return Alamat;
    }
    String JenisMotor(){
        return JenisMotor;
    }
    String WarnaMotor(){
        return WarnaMotor;
    }
    int DurasiPenyewaan(){
        return DurasiPenyewaan;
    }
    String MetodePmbyrn(){
        return MetodePmbyrn;
    }
    int HargaSewa(){
        return HargaSewa;
    }
    int denda(){
        return 0;
    }
    int denda(int hari){
        totaldn = hari * 150000;
        return totaldn;
    }
    void Pjk(double Pajak){
        this.pajak = Pajak;
    }
    @Override
    void identitas(String Identitas) {
        this.identitas = Identitas;
    }
    double Pajak(){ // Penerapan Polymorfisme
        return pajak;
    }
}
