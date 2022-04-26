/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg123200061_tugas4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI extends JFrame{
    JLabel judul = new JLabel ("LOGIN");
    JLabel luser = new JLabel("Username : ");
    JTextField fuser = new JTextField (20);
    JLabel lpass = new JLabel ("Password : ");
    JPasswordField fpass = new JPasswordField(10);
    JButton blogin = new JButton("Login");
    JButton bcancel = new JButton ("Cancel");
    JLabel lreguser = new JLabel ("Username : ");
    JTextField freguser = new JTextField (20);
    JLabel lregpass = new JLabel ("Password : ");
    JPasswordField fregpass = new JPasswordField (10);
    JButton bregister = new JButton ("Register");
    public GUI(){
        setVisible(true);
        setTitle("LOGIN");
        setSize(500,200);
        setLayout(null);
        add(judul);
        add(luser);
        add(fuser);
        add(lpass);
        add(fpass);
        add(blogin);
        add(lreguser);
        add(freguser);
        add(lregpass);
        add(fregpass);
        add(bregister);
        judul.setBounds(210,15,85,25);
        luser.setBounds(15, 40, 100,35);
        fuser.setBounds(80,40,100,35);
        lpass.setBounds(15,80,100,35);
        fpass.setBounds(80,80,100,35);
        blogin.setBounds(40,120,90,20);
        lreguser.setBounds(250,40,100,35);
        freguser.setBounds(320,40,100,35);
        lregpass.setBounds(250,80,100,35);
        fregpass.setBounds(320,80,100,35);
        bregister.setBounds(290,120,90,20);
        
        blogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                connector conn = new connector();
                String user = fuser.getText();
                System.out.println(user);
                if (conn.checkUsername(user) && user != "" && conn.checkLogin(user, String.valueOf(fpass.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                }
                else if (user.isEmpty() || String.valueOf(fpass.getPassword()).isEmpty()) { 
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong!");
                }
                else if (!conn.checkUsername(user)) {
                    JOptionPane.showMessageDialog(null, "Username Salah!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password Salah!");
                }
            }            
        });
        
        bregister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                connector conn = new connector();
                String reguser = freguser.getText();
                String regpass = String.valueOf(fregpass.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    conn.masukData(reguser,regpass);
                    JOptionPane.showMessageDialog(null, "Register Berhasil!");
                }
                else if (reguser.isEmpty() || regpass.isEmpty()) { 
                    JOptionPane.showMessageDialog(null, "Tidak Boleh Kosong!");
                }
            }
        });
    }    
}
