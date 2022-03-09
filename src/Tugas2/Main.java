/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tugas2;
import java.util.Scanner;

/**
 *
 * @author VANKA
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ulang;
        
        do{
            System.out.print("==========\n");
            System.out.print("Menu Utama\n");
            System.out.print("==========\n");
            System.out.print("1. Hitung Balok\n");
            System.out.print("2. Hitung Tabung\n");
            System.out.print("0. Exit\n");

            System.out.print("Pilih: ");
            int pilih = in.nextInt();
            System.out.println("");

            switch(pilih){
                case 1:
                 
                    double p, l, t;
                    System.out.print("Input Panjang: ");
                    p = in.nextInt();
                    System.out.print("Input Lebar: ");
                    l = in.nextInt();
                    System.out.print("Input Tinggi: ");
                    t = in.nextInt();
                    Balok blk = new Balok(p, l, t);

                    System.out.println("");
                    System.out.println("Luas Persegi Panjang= " + blk.hitungLuas());
                    System.out.println("Keliling Persegi Panjang= " + blk.hitungKeliling());
                    System.out.println("Volume Balok= " + blk.hitungVolume());
                    System.out.println("Luas Permukaan Balok= " + blk.hitungLuasPermukaan());
                    break;
                    
                case 2:
                    
                    double r;
                    System.out.print("Input Tinggi: ");
                    t = in.nextInt();
                    System.out.print("Input Jari - Jari: ");
                    r = in.nextInt();
                    Tabung tbng = new Tabung(r, t);

                    System.out.println("");
                    System.out.println("Luas Lingkaran= " + tbng.hitungLuas());
                    System.out.println("Keliling Lingkaran= " + tbng.hitungKeliling());
                    System.out.println("Volume Tabung= " + tbng.hitungVolume());
                    System.out.println("Luas Permukaan Tabung= " + tbng.hitungLuasPermukaan());
            }
            
            System.out.println("");
            System.out.print("Ulangi? (Ya: 1 || Tidak: 0)");
            ulang = in.nextInt();
        }while(ulang == 1);
    }
}
