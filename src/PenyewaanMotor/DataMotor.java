/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PenyewaanMotor;

/**
 *
 * @author lilis
 */
public class DataMotor extends PenyewaanMotorHasib implements InterfacePenyewaan {
    String thnbuat;
    private String noplat;
    private String idMotor;
    void noplat(String noplat){
        this.noplat = noplat;
    }
    void idMotor(String idmotor){
        this.idMotor = idmotor;
    }
    void thnbuat(String thnbuat){
        this.thnbuat = thnbuat;
    }
    public void setNoplat(String noplat) {
        this.noplat = noplat;
    }
    public String getNoplat() {
        return noplat;
    }
    public void setIdMotor(String idMotor) {
        this.idMotor = idMotor;
    }
    public String getIdMotor() {
        return idMotor;
    }
    String idMotor(){
        return idMotor;
    }
    String noplat(){
        return noplat;
    }
    String thnbuat(){
        return thnbuat;
    }
    @Override
    void identitas(String IdentitasMTR) {
        this.identitas = IdentitasMTR;
    }
    @Override
    double Pajak() { // Penerapan Polymorfisme
        return ((HargaSewa*(pajak))+HargaSewa);
    }
    @Override // penerapan interface
    public String disewa() {
        return "Kendaraan Sedang Disewa";
    }
    @Override // penerapan interface
    public String tidakdisewa() {
        return "Kendaraan Sudah Dikembalikan";
    }
}
