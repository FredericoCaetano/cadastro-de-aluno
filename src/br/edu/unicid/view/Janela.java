package br.edu.unicid.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Janela extends JFrame {

    private JMenuBar menu;
    private JMenu menuAluno;
    private JMenu menuAjuda;
    private JMenu menuNeF;
    private JMenuItem menuItemSalvar;
    private JMenuItem menuItemAlterar;
    private JMenuItem menuItemConsultar;
    private JMenuItem menuItemExcluir;
    private JSeparator separador;
    private JMenuItem menuItemSair;
    private JPanel painelPrincipal;
    private JTabbedPane painelSup;
    private JPanel painelDP;

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

        // Configurando o frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 300, 800, 500);
        setTitle("Cadastro de Aluno");
        setFont(new Font("Times New Roman", Font.PLAIN, 16));

        // Criando o menu
        menu = new JMenuBar();
        setJMenuBar(menu);

        // Configurando o menu "Aluno"
        menuAluno = new JMenu("Aluno");
        menu.add(menuAluno);

        menuItemSalvar = new JMenuItem("Salvar");
        menuItemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menuAluno.add(menuItemSalvar);

        menuItemAlterar = new JMenuItem("Alterar");
        menuAluno.add(menuItemAlterar);

        menuItemConsultar = new JMenuItem("Consulta");
        menuAluno.add(menuItemConsultar);

        menuItemExcluir = new JMenuItem("Excluir");
        menuAluno.add(menuItemExcluir);

        separador = new JSeparator();
        menuAluno.add(separador);

        menuItemSair = new JMenuItem("Sair");
        menuItemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
        menuAluno.add(menuItemSair);

        // Configurando o menu "Notas e Faltas"
        menuNeF = new JMenu("Notas e Faltas");
        menu.add(menuNeF);

        menuItemSalvar = new JMenuItem("Salvar");
        menuNeF.add(menuItemSalvar);

        menuItemAlterar = new JMenuItem("Alterar");
        menuItemAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        menuNeF.add(menuItemAlterar);

        menuItemExcluir = new JMenuItem("Excluir");
        menuNeF.add(menuItemExcluir);

        menuItemConsultar = new JMenuItem("Consulta");
        menuNeF.add(menuItemConsultar);

        // Configurando o menu "Ajuda"
        menuAjuda = new JMenu("Ajuda");
        menu.add(menuAjuda);

        menuItemConsultar = new JMenuItem("Sobre");
        menuAjuda.add(menuItemConsultar);

        // Configurando o painel principal
        painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(191, 224, 255));
        painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelPrincipal);
        painelPrincipal.setLayout(null);

        // Configurando as guias
        painelSup = new JTabbedPane(JTabbedPane.TOP);
        painelSup.setBounds(10, 10, 762, 416);
        painelPrincipal.add(painelSup);

        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Dados Pessoais", null, painelDP, null);
        painelDP.setLayout(null);

        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Curso", null, painelDP, null);
        painelDP.setLayout(null);

        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Notas e Faltas", null, painelDP, null);
        painelDP.setLayout(null);

        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Boletim", null, painelDP, null);
        painelDP.setLayout(null);
    }
}
