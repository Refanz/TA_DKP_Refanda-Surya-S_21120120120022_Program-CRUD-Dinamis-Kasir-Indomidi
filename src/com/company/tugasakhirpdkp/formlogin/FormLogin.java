package com.company.tugasakhirpdkp.formlogin;

import com.company.tugasakhirpdkp.formcrud.FormCRUD;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FormLogin {

    private JPanel panel1;
    private JButton btnLogin;
    private JButton btnLogout;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private static JFrame frame ;


    public static void showFrame(){

        frame = new JFrame("Form Login");

        frame.setSize(500,500);
        frame.setContentPane(new FormLogin().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }




    public static void main(String[] args) {


        showFrame();






    }

    public FormLogin() {


        /* Button Login */

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                FormCRUD fc = new FormCRUD();
                
                String username = tfUsername.getText();
                String password = tfPassword.getText();

                ProsesLogin pl = new ProsesLogin(username,password);

                boolean status = pl.CheckCredetial();

                if(status == true){

                    JOptionPane.showMessageDialog(frame,"Anda berhasil login...");

                    fc.showCRUD();

                    frame.setVisible(false);

                }else{

                    JOptionPane.showMessageDialog(frame,"Username / Passowrd anda salah !!!");

                }

            }
        });

        /* Button Logout */

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int konfirmasi = JOptionPane.showConfirmDialog(frame,"Apakah anda ingin keluar ?", "Keluar", JOptionPane.YES_NO_OPTION);

                if(konfirmasi == JOptionPane.YES_OPTION){

                    JOptionPane.showMessageDialog(frame,"Anda akan keluar...");
                    System.exit(0);

                }


            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


    }
}
