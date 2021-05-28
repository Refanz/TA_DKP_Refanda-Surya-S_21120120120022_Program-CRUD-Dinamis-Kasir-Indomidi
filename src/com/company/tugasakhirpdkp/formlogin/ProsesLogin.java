package com.company.tugasakhirpdkp.formlogin;



public class ProsesLogin {



    private String[]userData = new String[2];
    private String username, password, showname = "";


    /* Constructor */

    public ProsesLogin(String usernames, String passwords){

        username = usernames;
        password = passwords;

        /* Data user dideklarasikan di dalam sebuah array 1 dimensi */

        String[]userDatas = {"refan","123456", "Refanda Surya S"};

        this.userData = userDatas;


    }

    /* Fungsi untuk cek apakah user memasukkan data sesuai dengan yang ada dalam array */

    public boolean CheckCredetial(){

        if(userData[0].equals(username)){

            if(userData[1].equals(password)){

                showname = userData[2];

                return true;

            }

        }

        return false;

    }





}
