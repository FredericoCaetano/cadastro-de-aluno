package br.edu.unicid.view;

import javax.swing.*;

public class Janela extends JFrame{

    public Janela(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Janela();
    }
}
