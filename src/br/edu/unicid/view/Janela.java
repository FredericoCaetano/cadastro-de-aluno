package br.edu.unicid.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Janela extends JFrame {

    private JPanel painel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Janela frame = new Janela();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Janela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 814, 436);
        painel = new JPanel();
        painel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(painel);
        painel.setLayout(null);

    }
}
