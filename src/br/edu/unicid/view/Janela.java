package br.edu.unicid.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela extends JFrame {

    private JPanel painel;
    private JPanel subPainel;

    public Janela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        painel = new JPanel();
        painel.setBackground(new Color(255, 200, 200));
        JButton botao1 = new JButton("OK");
        painel.add(botao1);

        subPainel = new JPanel();

        painel.setLayout(new OverlayLayout(painel));

        subPainel.setVisible(false);
        painel.add(subPainel);

        botao1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                subPainel.setVisible(true);
                Dimension tamanhoPainel = painel.getSize();
                Dimension tamanhoSubPainel = subPainel.getPreferredSize();
                int x = (tamanhoPainel.width - tamanhoSubPainel.width) / 2;
                int y = (tamanhoPainel.height - tamanhoSubPainel.height) / 2;
                subPainel.setBounds(x, y, tamanhoPainel.width, tamanhoSubPainel.height);
            }
        });

        add(painel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Janela();
    }
}
