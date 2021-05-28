package com.company.tugasakhirpdkp.formcrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormCRUD  {

    private JPanel panelCRUD;
    private JTextField tfKodeBarang;
    private JTextField tfNamaBarang;
    private JTextField tfHargaBarang;
    private JButton btnTambah;
    private JButton btnHapus;
    private JButton btnUbah;
    private JFrame frame;
    private JTable tabelBarang;
    private JButton btnKeluar;
    
    /* Membuat Setter */
    
    public void setKodeBarang(String kodeBarang){
        
        this.tfKodeBarang.setText(kodeBarang);

    }

    public void setNamaBarang(String namaBarang){

        this.tfNamaBarang.setText(namaBarang);

    }

    public void setHargaBarang(int hargaBarang){

        this.tfHargaBarang.setText(String.valueOf(hargaBarang));

    }

    /* Membuat Getter */

    public String getKodeBarang(){

        return tfKodeBarang.getText();


    }

    public String getNamaBarang(){

        return tfNamaBarang.getText();

    }

    public int getHargaBarang(){

        return Integer.parseInt(tfHargaBarang.getText());
    }


    public FormCRUD() {
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();

                if(getKodeBarang().equals("") || getNamaBarang().equals("") || getHargaBarang() == 0){

                    JOptionPane.showMessageDialog(frame,"Ada field yang belum diisi !!!");

                }else{

                    model.addRow(new Object[]{

                            getKodeBarang(),
                            getNamaBarang(),
                            getHargaBarang()



                    });

                    JOptionPane.showMessageDialog(frame,"Berhasil menambah data barang");


                }


                kosongkanField();


            }
        });

        btnUbah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();
               if(tabelBarang.getSelectedRow() == -1){

                   if(tabelBarang.getRowCount() == 0){

                       JOptionPane.showMessageDialog(frame,"Tidak ada data dalam tabel");

                   }else{


                       JOptionPane.showMessageDialog(frame,"Pilih data yang akan diubah");

                   }
                   

               }else{

                   model.setValueAt(getKodeBarang(), tabelBarang.getSelectedRow(), 0);
                   model.setValueAt(getNamaBarang(), tabelBarang.getSelectedRow(), 1);
                   model.setValueAt(getHargaBarang(), tabelBarang.getSelectedRow(), 2);

                   JOptionPane.showMessageDialog(frame,"Ubah data berhasil");
               }

               kosongkanField();



            }
        });
        tabelBarang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                DefaultTableModel model =  (DefaultTableModel) tabelBarang.getModel();

                if(tabelBarang.getSelectedRow() == -1){

                    if(tabelBarang.getRowCount() == 0){

                        JOptionPane.showMessageDialog(frame,"Tidak ada data dalam tabel");


                    }


                }else{

                    String fieldKode = (String) model.getValueAt(tabelBarang.getSelectedRow(),0);
                    String fieldNama = (String) model.getValueAt(tabelBarang.getSelectedRow(),1);
                    Integer fieldHarga = (Integer) model.getValueAt(tabelBarang.getSelectedRow(),2);

                    setKodeBarang(fieldKode);
                    setNamaBarang(fieldNama);
                    setHargaBarang(fieldHarga);

                }



            }
        });
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int konfirmasi = JOptionPane.showConfirmDialog(frame,"Apakah anda ingin keluar ?","Keluar",JOptionPane.YES_NO_OPTION);
                
                if(konfirmasi == JOptionPane.YES_OPTION){

                    JOptionPane.showMessageDialog(frame,"Anda akan keluar... ");
                    System.exit(0);


                }

            }
        });
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) tabelBarang.getModel();

                if(tabelBarang.getSelectedRow() == -1){

                    if (tabelBarang.getRowCount() == 0){

                        JOptionPane.showMessageDialog(frame, "Tidak ada data di dalam tabel");


                    }else{

                        JOptionPane.showMessageDialog(frame,"Pilih data yang akan dihapus");
                    }

                }else{

                    model.removeRow(tabelBarang.getSelectedRow());

                    JOptionPane.showMessageDialog(frame,"Data berhasil dihapus");
                }

                kosongkanField();

            }
        });
        tfHargaBarang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

                char enter = e.getKeyChar();
                if(!Character.isDigit(enter)){
                    e.consume();
                }
            }
        });
    }

    private void kosongkanField(){

        tfKodeBarang.setText("");
        tfNamaBarang.setText("");
        tfHargaBarang.setText("");


    }

    public  void showCRUD(){

        frame = new JFrame("Form CRUD");
        frame.setContentPane(new FormCRUD().panelCRUD);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,500);
        frame.setVisible(true);


    }

    /* Main Class */


    public static void main(String[] args) {

        FormCRUD fc = new FormCRUD();


        fc.showCRUD();





    }

    /* Array Kolom */

    String header[] = {"Kode Barang","Nama Barang", "Harga Barang"};

    private void createUIComponents() {
        // TODO: place custom component creation code here

        DefaultTableModel model = new DefaultTableModel(0,2);
        model.setColumnIdentifiers(header);
        tabelBarang = new JTable(model);

    }
}
