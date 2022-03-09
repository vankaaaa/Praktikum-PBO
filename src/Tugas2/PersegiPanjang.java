/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas2;

/**
 *
 * @author VANKA
 */
public class PersegiPanjang implements MenghitungBidang{
    private double panjang, lebar;
    public PersegiPanjang(double p, double l){
        panjang = p;
        lebar = l;
    }
    
    // encaptulation
    public void setPanjang(int p){
        panjang = p;
    }
    
    public double getPanjang(){
        return panjang;
    }
    
    public void setLebar(int l){
        lebar = l;
    }
    
    public double getLebar(){
        return lebar;
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }

    @Override
    public double hitungKeliling() {
        return 2 *(panjang + lebar);
    }
}
