/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kuis_123200061_f;

/**
 *
 * @author VANKA
 */
public class Daftar extends Tes {
    String nik, nama, status, divisi;
    double cdg, tls, wwc, jml;

    public Daftar(char mode) {
        if (mode == '1') {
            super.testulis = 0.2;
            super.tescoding =  0.5;
            super.teswawancara = 0.3;
            this.divisi = "Android";
        } else {
            super.testulis = 0.4;
            super.tescoding =  0.35;
            super.teswawancara = 0.25;
            this.divisi = "Web";
        }
    }

    public void edit(String nik,
                     String nama,
                     double coding,
                     double tulis,
                     double wawancara) {
        this.nik = nik;
        this.nama = nama;
        this.cdg = coding;
        this.tls = tulis;
        this.wwc = wawancara;
    }

    public void tampil() {
        this.jml = tls * this.testulis
                + cdg * this.tescoding
                + wwc * this.teswawancara;
        if ( jml < 85) {
            this.status = "GAGAL\nMohon maaf " + nama + " telah ditolak sebagai" + divisi;
        } else {
            this.status = "SELAMAT\n" + nama + " telah diterima sebagai " + divisi ;
        }
    }
    
}
