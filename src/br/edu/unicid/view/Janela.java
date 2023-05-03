package br.edu.unicid.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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
    private JLabel lblRgm;
    private JFormattedTextField txtRgm;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblDataNasc;
    private JFormattedTextField txtDataNasc;
    private JLabel lblCpf;
    private JFormattedTextField txtCpf;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblEndereco;
    private JTextField txtEndereco;
    private JLabel lblMunicipio;
    private JTextField txtMunicipio;
    private JLabel lblUF;
    private JComboBox<String> txtUF;
    private JLabel lblCelular;
    private JFormattedTextField txtCelular;
    private JLabel lblCurso;
    private JComboBox<String> txtCurso;
    private JComboBox<String> txtCampus;
    private JLabel lblCampus;
    private JLabel lblPeriodo;
    private JRadioButton txtMatutino;
    private JRadioButton txtVespertino;
    private JRadioButton txtNoturno;
    private ButtonGroup periodo;
    private JButton btnNovo;
    private JButton btnAlterar;
    private JButton btnSalva;
    private AbstractButton btnConsulta;
    private JButton btnDelete;

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

        // Configurando janela de guias
        painelSup = new JTabbedPane(JTabbedPane.TOP);
        painelSup.setBounds(10, 10, 762, 416);
        painelPrincipal.add(painelSup);

        // Configurando guia Dados Pessoais
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Dados Pessoais", null, painelDP, null);
        painelDP.setLayout(null);

        lblRgm = new JLabel("Rgm");
        lblRgm.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblRgm.setBounds(15, 50, 100, 30);
        painelDP.add(lblRgm);

        txtRgm = new JFormattedTextField();
        txtRgm.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtRgm.setBounds(130, 50, 150, 30);
        txtRgm.setHorizontalAlignment(SwingConstants.CENTER);
        formatarCampo();
        painelDP.add(txtRgm);
        txtRgm.setColumns(10);

        lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNome.setBounds(310, 50, 100, 30);
        painelDP.add(lblNome);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNome.setBounds(380, 50, 350, 30);
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtNome);
        txtNome.setColumns(10);

        lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblDataNasc.setBounds(15, 110, 100, 30);
        painelDP.add(lblDataNasc);

        txtDataNasc = new JFormattedTextField();
        txtDataNasc.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtDataNasc.setBounds(130, 110, 150, 30);
        txtDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
        formatarCampo2();
        painelDP.add(txtDataNasc);
        txtDataNasc.setColumns(10);

        lblCpf = new JLabel("Cpf");
        lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCpf.setBounds(310, 110, 100, 30);
        painelDP.add(lblCpf);

        txtCpf = new JFormattedTextField();
        txtCpf.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCpf.setBounds(380, 110, 350, 30);
        txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
        formatarCampo3();
        painelDP.add(txtCpf);
        txtCpf.setColumns(10);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblEmail.setBounds(15, 170, 100, 30);
        painelDP.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtEmail.setBounds(130, 170, 600, 30);
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtEmail);
        txtEmail.setColumns(10);

        lblEndereco = new JLabel("Endereco");
        lblEndereco.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblEndereco.setBounds(15, 230, 100, 30);
        painelDP.add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtEndereco.setBounds(130, 230, 600, 30);
        txtEndereco.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtEndereco);
        txtEndereco.setColumns(10);

        lblMunicipio = new JLabel("Municipio");
        lblMunicipio.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblMunicipio.setBounds(15, 290, 100, 30);
        painelDP.add(lblMunicipio);

        txtMunicipio = new JTextField();
        txtMunicipio.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtMunicipio.setBounds(130, 290, 150, 30);
        txtMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtMunicipio);
        txtMunicipio.setColumns(10);

        lblUF = new JLabel("UF");
        lblUF.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblUF.setBounds(310, 290, 100, 30);
        painelDP.add(lblUF);

        String[] opcoes = { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
                "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
        txtUF = new JComboBox<String>(opcoes);
        txtUF.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtUF.setBounds(380, 290, 80, 30);
        painelDP.add(txtUF);

        lblCelular = new JLabel("Celular");
        lblCelular.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCelular.setBounds(460, 290, 100, 30);
        painelDP.add(lblCelular);

        txtCelular = new JFormattedTextField();
        txtCelular.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCelular.setBounds(540, 290, 190, 30);
        txtCelular.setHorizontalAlignment(SwingConstants.CENTER);
        formatarCampo4();
        painelDP.add(txtCelular);
        txtCelular.setColumns(10);

        // Configurando guia Curso
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Curso", null, painelDP, null);
        painelDP.setLayout(null);

        lblCurso = new JLabel("Curso");
        lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCurso.setBounds(15, 50, 150, 30);
        painelDP.add(lblCurso);

        String[] opcoes2 = { "", "Análise e Desenvolvimento de Sistemas", "Ciência da Computação",
                "Engenharia da Computação", "Gestão da Tecnologia da Informação", "Sistemas de Informação" };
        txtCurso = new JComboBox<String>(opcoes2);
        txtCurso.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCurso.setBounds(130, 50, 600, 30);
        painelDP.add(txtCurso);

        lblCampus = new JLabel("Campus");
        lblCampus.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCampus.setBounds(15, 110, 150, 30);
        painelDP.add(lblCampus);

        String[] opcoes3 = { "", "Pinheiros", "Tatuapé" };
        txtCampus = new JComboBox<String>(opcoes3);
        txtCampus.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCampus.setBounds(130, 110, 600, 30);
        painelDP.add(txtCampus);

        lblPeriodo = new JLabel("Período");
        lblPeriodo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblPeriodo.setBounds(15, 170, 150, 30);
        painelDP.add(lblPeriodo);

        txtMatutino = new JRadioButton("Matutino");
        txtMatutino.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtMatutino.setBounds(130, 170, 200, 30);
        txtVespertino = new JRadioButton("Vespertino");
        txtVespertino.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtVespertino.setBounds(370, 170, 200, 30);
        txtNoturno = new JRadioButton("Noturno");
        txtNoturno.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNoturno.setBounds(620, 170, 100, 30);
        periodo = new ButtonGroup();
        periodo.add(txtMatutino);
        periodo.add(txtVespertino);
        periodo.add(txtNoturno);
        
        painelDP.add(txtMatutino);
        painelDP.add(txtVespertino);
        painelDP.add(txtNoturno);

        btnSalva = new JButton("");
        btnSalva.setToolTipText("Novo");
        btnSalva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });
        ImageIcon iconeSalva = new ImageIcon("imgs/icons/salvar.png");
        iconeSalva.setImage(iconeSalva.getImage().getScaledInstance(80 , 75, 1));
        btnSalva.setIcon(iconeSalva);
        btnSalva.setBounds(15, 230, 90, 85);
        painelDP.add(btnSalva);

        btnAlterar = new JButton("");
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });
        ImageIcon iconeAlterar = new ImageIcon("imgs/icons/alterar.png");
        iconeAlterar.setImage(iconeAlterar.getImage().getScaledInstance(80 , 75, 1));
        btnAlterar.setIcon(iconeAlterar);
        btnAlterar.setBounds(169, 230, 90, 85);
        painelDP.add(btnAlterar);

        btnConsulta = new JButton("");
        btnConsulta.setToolTipText("Novo");
        btnConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });
        ImageIcon iconeConsulta = new ImageIcon("imgs/icons/consultar.png");
        iconeConsulta.setImage(iconeConsulta.getImage().getScaledInstance(80, 75, 1));
        btnConsulta.setIcon(iconeConsulta);
        btnConsulta.setBounds(323, 230, 90, 85);
        painelDP.add(btnConsulta);

        btnDelete = new JButton("");
        btnDelete.setToolTipText("Novo");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });
        ImageIcon iconeDelete = new ImageIcon("imgs/icons/deletar.png");
        iconeDelete.setImage(iconeDelete.getImage().getScaledInstance(80, 75, 1));
        btnDelete.setIcon(iconeDelete);
        btnDelete.setBounds(477, 230, 90, 85);
        painelDP.add(btnDelete);


        btnNovo = new JButton("");
        btnNovo.setToolTipText("Novo");
        btnNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                txtRgm.setText(null);
                txtNome.setText(null);
                txtDataNasc.setText(null);
                txtCpf.setText(null);
                txtEmail.setText(null);
                txtEndereco.setText(null);
                txtMunicipio.setText(null);
                txtUF.setSelectedIndex(0);
                txtCelular.setText(null);
                txtCurso.setSelectedIndex(0);
                txtCampus.setSelectedIndex(0);
                periodo.clearSelection();
            }
        });
        ImageIcon iconeNovo = new ImageIcon("imgs/icons/novo.png");
        iconeNovo.setImage(iconeNovo.getImage().getScaledInstance(110 , 105, 1));
        btnNovo.setIcon(iconeNovo);
        btnNovo.setBounds(630, 230, 90, 85);
        painelDP.add(btnNovo);
        

        // Configurando guia Notas e Faltas
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Notas e Faltas", null, painelDP, null);
        painelDP.setLayout(null);

        // Configurando guia Boletim
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Boletim", null, painelDP, null);
        painelDP.setLayout(null);
    }

    private void formatarCampo() {
        try {
            MaskFormatter mask = new MaskFormatter("########");
            mask.install(txtRgm);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
        }
    }

    private void formatarCampo2() {
        try {
            MaskFormatter mask2 = new MaskFormatter("##/##/####");
            mask2.install(txtDataNasc);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
        }
    }

    private void formatarCampo3() {
        try {
            MaskFormatter mask3 = new MaskFormatter("###.###.###-##");
            mask3.install(txtCpf);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
        }
    }

    private void formatarCampo4() {
        try {
            MaskFormatter mask4 = new MaskFormatter("(##)#####-####");
            mask4.install(txtCelular);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
        }
    }
}
