/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kuis_123200061_f;
import java.util.Scanner;

/**
 *
 * @author VANKA
 */
public class Kuis_123200061_F {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char menu, pilih;
        String nik, nama;
        double tulis, coding, wawancara;
       
       while(true){
       System.out.print("FORM PENDAFTARAN PT.UDIN\n");
       System.out.print("1. Android Development\n");
       System.out.print("2. Web Development\n");
       System.out.print("Pilih Jenis Form : ");
       
       menu = in.next().charAt(0);
            if (menu == '0') {
                System.exit(0);
            }
            Daftar pendaftar = null;
            if (menu == '1') {
                pendaftar = new Daftar(menu);
            } else if (menu == '2') {
                pendaftar = new Daftar(menu);
            }

            System.out.println("");
            System.out.println("FORM INPUT DATA");
            System.out.println("");

            System.out.print("NIK: ");
            nik = in.next();
            System.out.print("Nama: ");
            in.nextLine();
            nama = in.nextLine();
            System.out.print("Nilai Tes Tulis: ");
            tulis = in.nextDouble();
            System.out.print("Nilai Tes Coding: ");
            coding = in.nextDouble();
            System.out.print("Nilai Tes Wawancara: ");
            wawancara = in.nextDouble();

            pendaftar.edit(nik, nama, coding, tulis, wawancara);

            if (menu == '1') {
                pendaftar.tampil();
            } else if (menu == '2') {
                pendaftar.tampil();
            }
            do {
                System.out.println("1. Edit");
                System.out.println("2. Tampil");
                System.out.println("0. Exit");
                System.out.print("Pilih : ");
                pilih = in.next().charAt(0);

                if (pilih == '1') {
                    System.out.println("");
                    System.out.println("FORM INPUT DATA");
                    System.out.println("");
                    System.out.print("Nilai Tes Tulis: ");
                    tulis = in.nextDouble();
                    System.out.print("Nilai Tes Coding: ");
                    coding = in.nextDouble();
                    System.out.print("Nilai Tes Wawancara: ");
                    wawancara = in.nextDouble();
                    in.nextLine();

                    pendaftar.edit(nik, nama, coding, tulis, wawancara);

                    if (menu == '1') {
                        pendaftar.tampil();
                    } else if (menu == '2') {
                        pendaftar.tampil();
                    }
                } else if (pilih == '2') {
                    System.out.println("\nNilai akhir: " + pendaftar.jml);
                    System.out.println("KETERANGAN : " + pendaftar.status + "\n");
                }
            } while (pilih != '0');
            System.out.println("");
       }
    }
}