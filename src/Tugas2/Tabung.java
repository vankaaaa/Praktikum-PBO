/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas2;

/**
 *
 * @author VANKA
 */
public class Tabung extends Lingkaran implements MenghitungRuang {
    
    private double tinggi;

    public Tabung(double r, double t) {
        super(r);
        tinggi = t;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return PHI * (super.getJari() * super.getJari()) * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * (PHI * super.getJari()) * (super.getJari() + tinggi);
    }
    
}
