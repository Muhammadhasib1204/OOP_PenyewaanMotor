/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PenyewaanMotor;

/**
 *
 * @author lilis
 */
public class MainPenyewaanMotor {
    public static void main(String[]args){
        PenyewaanMotorHasib sewa = new PenyewaanMotorHasib();
        System.out.println("Isi Data Penyewa");
        sewa.Nama("Hasib");
        sewa.Umur=("17");
        sewa.Alamat("Ijen Nirwana");
        sewa.JenisMotor("Honda Beat");
        sewa.WarnaMotor("Merah");
        sewa.DurasiPenyewaan(1);
        sewa.HargaSewa(250000);
        sewa.MetodePmbyrn("Transfer Melalui Rekening");
        System.out.println("Nama = "+sewa.Nama);
        System.out.println("Umur = "+sewa.Umur);
        System.out.println("Alamat = "+sewa.Alamat);
        System.out.println("Jenis Motor = "+sewa.JenisMotor);
        System.out.println("Warna Motor = "+sewa.WarnaMotor);
        System.out.println("Durasi Penyewaan = "+sewa.DurasiPenyewaan+" Hari");
        System.out.println("Harga Sewa = "+sewa.HargaSewa);
        System.out.println("\n");
        System.out.println("Data Penyewa");
        System.out.println("Nama = "+sewa.Nama());
        System.out.println("Umur = "+sewa.Umur());
        System.out.println("Alamat = "+sewa.Alamat());
        System.out.println("Jenis Motor = "+sewa.JenisMotor());
        System.out.println("Warna Motor = "+sewa.WarnaMotor());
        System.out.println("Durasi Penyewaan = "+sewa.DurasiPenyewaan()+" Hari");
        System.out.println("Harga Sewa = "+sewa.HargaSewa());
        System.out.println("Metode Pembayaran = "+sewa.MetodePmbyrn());
        System.out.println("Informasi Kendaraan Bermotor = ");
 
    }
}
