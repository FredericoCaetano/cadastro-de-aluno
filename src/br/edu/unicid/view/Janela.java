package br.edu.unicid.view;

/*
Este projeto foi criado no intuito de facilitar o cadastro de alunos do unicid e tambem facilitar a consulta por parte dos alunos 
**/

//Importando todas bibliotecas e pacotes necessarias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import br.edu.unicid.dao.AlunoDAO;
import br.edu.unicid.dao.AlunoDAO2;
import br.edu.unicid.model.Aluno;
import br.edu.unicid.model.Aluno2;
import br.edu.unicid.util.ConnectionFactory;

public class Janela extends JFrame {

    // Declarando variaveis
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
    private Aluno aluno;
    private AlunoDAO dao;
    private AlunoDAO2 dao2;
    private JMenuItem menuItemSalvar2;
    private JMenuItem menuItemAlterar2;
    private JMenuItem menuItemExcluir2;
    private JMenuItem menuItemConsultar2;
    private JFormattedTextField txtRgm2;
    private JTextField txtNome2;
    private JTextField txtCurso2;
    private JLabel lblDisciplina;
    private JComboBox<String> txtDisciplina;
    private JLabel lblSemestre;
    private JComboBox<String> txtSemestre;
    private JLabel lblNota;
    private JComboBox<String> txtNota;
    private JLabel lblFaltas;
    private JFormattedTextField txtFaltas;
    private JButton btnSalva2;
    private JButton btnAlterar2;
    private JButton btnConsulta2;
    private JButton btnDelete2;
    private JButton btnNovo2;
    private java.sql.Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private JMenuItem menuItemSobre;
    private JFormattedTextField txtRgm3;
    private JButton btnConsulta3;
    private JTextField txtNome3;
    private JTextField txtCurso3;
    private JTextField txtDisciplina2;
    private JTextField txtSemestre2;
    private JTextField txtNota2;
    private JTextField txtFaltas2;
    private JButton btnNovo3;

    // Metedo que executa a Janela
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

        // Criando o item Salvar no menu Aluno
        menuItemSalvar = new JMenuItem("Salvar");
        menuItemSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (txtRgm.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Campo RGM Invalido!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Nome em branco!");
                    } else if (txtDataNasc.getText().trim().length() <= 9) {
                        JOptionPane.showMessageDialog(null, "Campo Data Nascimento Invalido!");
                    } else if (txtCpf.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo CPF Invalido!");
                    } else if (txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Email em branco!");
                    } else if (txtEndereco.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Endereco em branco!");
                    } else if (txtMunicipio.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Municipio em branco!");
                    } else if (txtUF.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo UF em branco!");
                    } else if (txtCelular.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo Celular Invalido!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Curso nao selecionado!");
                    } else if (txtCampus.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Campus nao selecionado!");
                    } else if (periodo.isSelected(null)) {
                        JOptionPane.showMessageDialog(null, "Campo Periodo nao selecionado!");
                    } else {
                        aluno = new Aluno();
                        aluno.setRgm(Integer.parseInt(txtRgm.getText()));
                        aluno.setNome(txtNome.getText());
                        aluno.setDataNasc(txtDataNasc.getText());
                        aluno.setCpf(txtCpf.getText());
                        aluno.setEmail(txtEmail.getText());
                        aluno.setEndereco(txtEndereco.getText());
                        aluno.setMunicipio(txtMunicipio.getText());
                        aluno.setUf((String) txtUF.getSelectedItem());
                        aluno.setCelular(txtCelular.getText());
                        aluno.setCurso((String) txtCurso.getSelectedItem());
                        aluno.setCampus((String) txtCampus.getSelectedItem());
                        if (txtMatutino.isSelected()) {
                            aluno.setPeriodo("Matutino");
                        } else if (txtVespertino.isSelected()) {
                            aluno.setPeriodo("Vespertino");
                        } else {
                            aluno.setPeriodo("Noturno");
                        }

                        dao = new AlunoDAO();

                        dao.salvar(aluno);
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        menuItemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menuAluno.add(menuItemSalvar);

        // Criando item Alterar no menu Aluno
        menuItemAlterar = new JMenuItem("Alterar");
        menuItemAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (txtRgm.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Campo RGM Invalido!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Nome em branco!");
                    } else if (txtDataNasc.getText().trim().length() <= 9) {
                        JOptionPane.showMessageDialog(null, "Campo Data Nascimento Invalido!");
                    } else if (txtCpf.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo CPF Invalido!");
                    } else if (txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Email em branco!");
                    } else if (txtEndereco.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Endereco em branco!");
                    } else if (txtMunicipio.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Municipio em branco!");
                    } else if (txtUF.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo UF nao selecionado!");
                    } else if (txtCelular.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo Celular Invalido!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Curso nao selecionado!");
                    } else if (txtCampus.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Campus nao selecionado!");
                    } else if (periodo.isSelected(null)) {
                        JOptionPane.showMessageDialog(null, "Campo Periodo nao selecionado!");
                    } else {
                        aluno = new Aluno();
                        aluno.setRgm(Integer.parseInt(txtRgm.getText()));
                        aluno.setNome(txtNome.getText());
                        aluno.setDataNasc(txtDataNasc.getText());
                        aluno.setCpf(txtCpf.getText());
                        aluno.setEmail(txtEmail.getText());
                        aluno.setEndereco(txtEndereco.getText());
                        aluno.setMunicipio(txtMunicipio.getText());
                        aluno.setUf((String) txtUF.getSelectedItem());
                        aluno.setCelular(txtCelular.getText());
                        aluno.setCurso((String) txtCurso.getSelectedItem());
                        aluno.setCampus((String) txtCampus.getSelectedItem());
                        if (txtMatutino.isSelected()) {
                            aluno.setPeriodo("Matutino");
                        } else if (txtVespertino.isSelected()) {
                            aluno.setPeriodo("Vespertino");
                        } else {
                            aluno.setPeriodo("Noturno");
                        }
                        dao = new AlunoDAO();
                        dao.alterar(aluno);
                        JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Cadastro nao foi alterado" + e1);
                }
            }
        });
        menuAluno.add(menuItemAlterar);

        // Criando o item Consultar no menu Aluno
        menuItemConsultar = new JMenuItem("Consultar");
        menuItemConsultar.setEnabled(false);
        menuAluno.add(menuItemConsultar);

        // Criando o item Excluir no menu Aluno
        menuItemExcluir = new JMenuItem("Excluir");
        menuItemExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Excluir");
                    } else {
                        dao = new AlunoDAO();
                        dao2 = new AlunoDAO2();

                        int rgm = Integer.parseInt(txtRgm.getText());
                        dao.deletar(rgm);
                        dao2.deletar2(rgm);
                        JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
                    }

                } catch (Exception e1) {
                    JOptionPane.showInternalMessageDialog(null, e1);
                }
            }
        });
        menuAluno.add(menuItemExcluir);

        // Separador
        separador = new JSeparator();
        menuAluno.add(separador);

        // Criando item Sair no menu Aluno
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

        // Criando item Salvar no menu Notas e Faltas
        menuItemSalvar2 = new JMenuItem("Salvar");
        menuItemSalvar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Salvar!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Salvar!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Curso para Salvar!");
                    } else if (txtDisciplina.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione uma Disciplina para Salvar!");
                    } else if (txtSemestre.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Semestre para Salvar!");
                    } else if (txtNota.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe uma Nota para Salvar!");
                    } else if (txtFaltas.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe o numero de Faltas para Salvar!");
                    } else {
                        Aluno aluno = new Aluno();
                        Aluno2 aluno2 = new Aluno2();
                        aluno.setRgm(Integer.parseInt(txtRgm2.getText()));
                        aluno.setNome(txtNome.getText());
                        aluno.setCurso((String) txtCurso.getSelectedItem());
                        aluno2.setDisciplina((String) txtDisciplina.getSelectedItem());
                        aluno2.setSemestre((String) txtSemestre.getSelectedItem());
                        double nota = (Double.parseDouble((String) txtNota.getSelectedItem()));
                        aluno2.setNota(nota);
                        aluno2.setFaltas(Integer.parseInt(txtFaltas.getText()));
                        aluno2.setAluno(aluno);
                        dao2 = new AlunoDAO2();
                        dao2.salvar2(aluno2);
                        JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao SalvarMenu" + e1);
                }
            }
        });
        menuNeF.add(menuItemSalvar2);

        // Criando item Alterar no menu Notas e Faltas
        menuItemAlterar2 = new JMenuItem("Alterar");
        menuItemAlterar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    conn = ConnectionFactory.getConnection();
                    ps = conn.prepareStatement("SELECT * FROM notasfaltas");
                    rs = ps.executeQuery();

                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Alterar!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Alterar!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Curso para salvar!");
                    } else if (txtDisciplina.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione uma Disciplina para salvar!");
                    } else if (txtSemestre.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Semestre para salvar!");
                    } else if (txtNota.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe uma Nota para salvar!");
                    } else if (txtFaltas.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe o numero de faltas para Salvar!");
                    } else {
                        char s = 's';
                        while (s == 's') {
                            while (rs.next()) {
                                int rgm = rs.getInt("rgm");
                                int rgm2 = Integer.parseInt(txtRgm2.getText());
                                if (rgm2 == rgm) {
                                    Aluno aluno = new Aluno();
                                    Aluno2 aluno2 = new Aluno2();
                                    aluno2.setDisciplina((String) txtDisciplina.getSelectedItem());
                                    aluno2.setSemestre((String) txtSemestre.getSelectedItem());
                                    aluno2.setNota(Double.parseDouble((String) txtNota.getSelectedItem()));
                                    aluno2.setFaltas(Integer.parseInt(txtFaltas.getText()));
                                    aluno.setRgm(Integer.parseInt(txtRgm2.getText()));

                                    ps = conn.prepareStatement(
                                            "UPDATE notasfaltas SET disciplina=?, semestre=?, nota=?, falta=? WHERE rgm=?");

                                    ps.setString(1, aluno2.getDisciplina());
                                    ps.setString(2, aluno2.getDisciplina());
                                    ps.setDouble(3, aluno2.getNota());
                                    ps.setInt(4, aluno2.getFaltas());
                                    ps.setInt(5, aluno.getRgm());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
                                }
                            }
                            s = 'n';
                        }

                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
                }

            }
        });
        menuItemAlterar2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        menuNeF.add(menuItemAlterar2);

        // Criando item Consultar no menu Notas e Faltas
        menuItemConsultar2 = new JMenuItem("Consultar");
        menuItemConsultar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Consultar!");
                    } else {
                        try {
                            dao = new AlunoDAO();
                            int rgm = Integer.parseInt(txtRgm2.getText());
                            aluno = dao.consultar(rgm);

                            txtNome2.setText(aluno.getNome());
                            txtCurso2.setText(aluno.getCurso());
                            String rgm2 = (String.valueOf(aluno.getRgm()));
                            txtRgm.setText(rgm2);
                            txtRgm.setEditable(false);
                            txtNome.setText(aluno.getNome());
                            txtDataNasc.setText(aluno.getDataNasc());
                            txtCpf.setText(aluno.getCpf());
                            txtEmail.setText(aluno.getEmail());
                            txtEndereco.setText(aluno.getEndereco());
                            txtMunicipio.setText(aluno.getMunicipio());
                            txtUF.setSelectedItem(aluno.getUf());
                            txtCelular.setText(aluno.getCelular());
                            txtCurso.setSelectedItem(aluno.getCurso());
                            txtCampus.setSelectedItem(aluno.getCampus());
                            if (aluno.getPeriodo().equals("Matutino")) {
                                txtMatutino.setSelected(true);
                                txtVespertino.setSelected(false);
                                txtNoturno.setSelected(false);
                            } else if (aluno.getPeriodo().equals("Vespertino")) {
                                txtVespertino.setSelected(true);
                                txtMatutino.setSelected(false);
                                txtNoturno.setSelected(false);
                            } else {
                                txtNoturno.setSelected(true);
                                txtMatutino.setSelected(false);
                                txtVespertino.setSelected(false);
                            }
                        } catch (NullPointerException e1) {
                            JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Consultar!");
                        }
                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Consultar!");
                }
            }
        });
        menuNeF.add(menuItemConsultar2);

        // Criando item Excluir no menu Notas e Faltas
        menuItemExcluir2 = new JMenuItem("Excluir");
        menuItemExcluir2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Excluir");
                    } else {
                        dao = new AlunoDAO();
                        dao2 = new AlunoDAO2();

                        int rgm = Integer.parseInt(txtRgm.getText());
                        dao.deletar(rgm);
                        dao2.deletar2(rgm);
                        JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
                    }

                } catch (Exception e1) {
                    JOptionPane.showInternalMessageDialog(null, e1);
                }
            }
        });
        menuNeF.add(menuItemExcluir2);

        // Configurando o menu "Ajuda"
        menuAjuda = new JMenu("Ajuda");
        menu.add(menuAjuda);

        // Criando item Sobre no menu Ajuda
        menuItemSobre = new JMenuItem("Sobre");
        menuItemSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Este progama foi desenvolvido para que facilite o cadastro\n de dados para seja consultado o boletim pelos alunos");
            }
        });
        menuAjuda.add(menuItemSobre);

        // Configurando o painel principal
        painelPrincipal = new JPanel();
        painelPrincipal.setBackground(new Color(191, 224, 255));
        painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelPrincipal);
        painelPrincipal.setLayout(null);

        // Configurando janela das guias
        painelSup = new JTabbedPane(JTabbedPane.TOP);
        painelSup.setBounds(10, 10, 762, 416);
        painelPrincipal.add(painelSup);

        // Configurando guia Dados Pessoais
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Dados Pessoais", null, painelDP, null);
        painelDP.setLayout(null);

        /*
         * Configurando todos os labels da guia Dados Pessoais
         */
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

        /*
         * Configurando todos os labels da guia Curso
         */
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

        /*
         * Configurando todos botoes da guia Curso
         */
        btnSalva = new JButton("");
        btnSalva.setToolTipText("Salvar");
        btnSalva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (txtRgm.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Campo RGM Invalido");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Nome em branco!");
                    } else if (txtDataNasc.getText().trim().length() <= 9) {
                        JOptionPane.showMessageDialog(null, "Campo Data Nascimento Invalido!");
                    } else if (txtCpf.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo CPF Invalido!");
                    } else if (txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Email em branco!");
                    } else if (txtEndereco.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Endereco em branco!");
                    } else if (txtMunicipio.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Municipio em branco!");
                    } else if (txtUF.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo UF nao selecionado!");
                    } else if (txtCelular.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo Celular Invalido!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Curso nao selecionado!");
                    } else if (txtCampus.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Campus nao selecionado!");
                    } else if (periodo.isSelected(null)) {
                        JOptionPane.showMessageDialog(null, "Campo Periodo nao selecionado!");
                    } else {
                        aluno = new Aluno();
                        aluno.setRgm(Integer.parseInt(txtRgm.getText()));
                        aluno.setNome(txtNome.getText());
                        aluno.setDataNasc(txtDataNasc.getText());
                        aluno.setCpf(txtCpf.getText());
                        aluno.setEmail(txtEmail.getText());
                        aluno.setEndereco(txtEndereco.getText());
                        aluno.setMunicipio(txtMunicipio.getText());
                        aluno.setUf((String) txtUF.getSelectedItem());
                        aluno.setCelular(txtCelular.getText());
                        aluno.setCurso((String) txtCurso.getSelectedItem());
                        aluno.setCampus((String) txtCampus.getSelectedItem());
                        if (txtMatutino.isSelected()) {
                            aluno.setPeriodo("Matutino");
                        } else if (txtVespertino.isSelected()) {
                            aluno.setPeriodo("Vespertino");
                        } else {
                            aluno.setPeriodo("Noturno");
                        }

                        dao = new AlunoDAO();

                        dao.salvar(aluno);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
        ImageIcon iconeSalva = new ImageIcon("imgs/icons/salvar.png");
        iconeSalva.setImage(iconeSalva.getImage().getScaledInstance(80, 75, 1));
        btnSalva.setIcon(iconeSalva);
        btnSalva.setBounds(15, 230, 90, 85);
        painelDP.add(btnSalva);

        btnAlterar = new JButton("");
        btnAlterar.setToolTipText("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (txtRgm.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Campo RGM Invalido!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Nome em branco!");
                    } else if (txtDataNasc.getText().trim().length() <= 9) {
                        JOptionPane.showMessageDialog(null, "Campo Data Nascimento Invalido!");
                    } else if (txtCpf.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo CPF Invalido!");
                    } else if (txtEmail.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Email em branco!");
                    } else if (txtEndereco.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Endereco em branco!");
                    } else if (txtMunicipio.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Municipio em branco!");
                    } else if (txtUF.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo UF nao selecionado!");
                    } else if (txtCelular.getText().trim().length() <= 13) {
                        JOptionPane.showMessageDialog(null, "Campo Celular Invalido!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Curso nao selecionado!");
                    } else if (txtCampus.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Campus nao selecionado!");
                    } else if (periodo.isSelected(null)) {
                        JOptionPane.showMessageDialog(null, "Campo Periodo nao selecionado!");
                    } else {
                        aluno = new Aluno();
                        aluno.setRgm(Integer.parseInt(txtRgm.getText()));
                        aluno.setNome(txtNome.getText());
                        aluno.setDataNasc(txtDataNasc.getText());
                        aluno.setCpf(txtCpf.getText());
                        aluno.setEmail(txtEmail.getText());
                        aluno.setEndereco(txtEndereco.getText());
                        aluno.setMunicipio(txtMunicipio.getText());
                        aluno.setUf((String) txtUF.getSelectedItem());
                        aluno.setCelular(txtCelular.getText());
                        aluno.setCurso((String) txtCurso.getSelectedItem());
                        aluno.setCampus((String) txtCampus.getSelectedItem());
                        if (txtMatutino.isSelected()) {
                            aluno.setPeriodo("Matutino");
                        } else if (txtVespertino.isSelected()) {
                            aluno.setPeriodo("Vespertino");
                        } else {
                            aluno.setPeriodo("Noturno");
                        }

                        dao = new AlunoDAO();

                        dao.alterar(aluno);
                        JOptionPane.showMessageDialog(null, "Cadastro Alterado com Sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Cadastro nao foi alterado");
                }
            }
        });
        ImageIcon iconeAlterar = new ImageIcon("imgs/icons/alterar.png");
        iconeAlterar.setImage(iconeAlterar.getImage().getScaledInstance(80, 75, 1));
        btnAlterar.setIcon(iconeAlterar);
        btnAlterar.setBounds(169, 230, 90, 85);
        painelDP.add(btnAlterar);

        btnConsulta = new JButton("");
        btnConsulta.setToolTipText("Consulta");
        btnConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        ImageIcon iconeConsulta = new ImageIcon("imgs/icons/consultar.png");
        iconeConsulta.setImage(iconeConsulta.getImage().getScaledInstance(80, 75, 1));
        btnConsulta.setIcon(iconeConsulta);
        btnConsulta.setBounds(323, 230, 90, 85);
        painelDP.add(btnConsulta);

        btnDelete = new JButton("");
        btnDelete.setToolTipText("Delete");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Excluir");
                    } else {
                        dao = new AlunoDAO();
                        dao2 = new AlunoDAO2();

                        int rgm = Integer.parseInt(txtRgm.getText());
                        dao.deletar(rgm);
                        dao2.deletar2(rgm);
                        JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
                    }

                } catch (Exception e1) {
                    JOptionPane.showInternalMessageDialog(null, e1);
                }
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
            public void actionPerformed(ActionEvent e) {
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
        iconeNovo.setImage(iconeNovo.getImage().getScaledInstance(80, 75, 1));
        btnNovo.setIcon(iconeNovo);
        btnNovo.setBounds(630, 230, 90, 85);
        painelDP.add(btnNovo);

        // Configurando guia Notas e Faltas
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Notas e Faltas", null, painelDP, null);
        painelDP.setLayout(null);

        /*
         * Configurando todos os labels da guia Notas e Faltas
         */
        lblRgm = new JLabel("Rgm");
        lblRgm.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblRgm.setBounds(15, 30, 100, 30);
        painelDP.add(lblRgm);

        txtRgm2 = new JFormattedTextField();
        txtRgm2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtRgm2.setBounds(70, 30, 150, 30);
        txtRgm2.setHorizontalAlignment(SwingConstants.CENTER);
        formatarCampo5();
        painelDP.add(txtRgm2);
        txtRgm2.setColumns(10);

        txtNome2 = new JTextField();
        txtNome2.setEditable(false);
        txtNome2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNome2.setBounds(240, 30, 490, 30);
        txtNome2.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtNome2);
        txtNome2.setColumns(10);

        txtCurso2 = new JTextField();
        txtCurso2.setEditable(false);
        txtCurso2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCurso2.setBounds(15, 90, 715, 30);
        txtCurso2.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtCurso2);
        txtCurso2.setColumns(10);

        lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblDisciplina.setBounds(15, 140, 100, 30);
        painelDP.add(lblDisciplina);

        String[] opcoes4 = { "", "Algoritmos e Estruturas de Dados", "Banco de Dados", "Linguagens de Programação",
                "Sistemas Operacionais", "Redes de Computadores" };
        txtDisciplina = new JComboBox<String>(opcoes4);
        txtDisciplina.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtDisciplina.setBounds(130, 140, 600, 30);
        painelDP.add(txtDisciplina);

        lblSemestre = new JLabel("Semestre");
        lblSemestre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblSemestre.setBounds(15, 200, 100, 30);
        painelDP.add(lblSemestre);

        String[] opcoes5 = { " ", "2020-1", "2020-2", "2021-1", "2021-2",
                "2022-1", "2022-2" };
        txtSemestre = new JComboBox<String>(opcoes5);
        txtSemestre.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtSemestre.setBounds(130, 200, 100, 30);
        painelDP.add(txtSemestre);

        lblNota = new JLabel("Nota");
        lblNota.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNota.setBounds(330, 200, 100, 30);
        painelDP.add(lblNota);

        String[] opcoes6 = { " ", "0.0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5",
                "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0", "9.5", "10.0" };
        txtNota = new JComboBox<String>(opcoes6);
        txtNota.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNota.setBounds(410, 200, 100, 30);
        painelDP.add(txtNota);

        lblFaltas = new JLabel("Faltas");
        lblFaltas.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblFaltas.setBounds(600, 200, 100, 30);
        painelDP.add(lblFaltas);

        txtFaltas = new JFormattedTextField();
        txtFaltas.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtFaltas.setHorizontalAlignment(SwingConstants.CENTER);
        txtFaltas.setBounds(680, 200, 50, 30);
        painelDP.add(txtFaltas);

        /*
         * Configurando todos os botoes da guia Notas e Faltas
         */
        btnSalva2 = new JButton("");
        btnSalva2.setToolTipText("Salvar");
        btnSalva2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Salvar!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Salvar!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Curso para Salvar!");
                    } else if (txtDisciplina.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione uma Disciplina para Salvar!");
                    } else if (txtSemestre.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Semestre para Salvar!");
                    } else if (txtNota.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe uma Nota para Salvar!");
                    } else if (txtFaltas.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe o numero de Faltas para Salvar!");
                    } else {
                        Aluno aluno = new Aluno();
                        Aluno2 aluno2 = new Aluno2();
                        aluno.setRgm(Integer.parseInt(txtRgm2.getText()));
                        aluno.setNome(txtNome.getText());
                        aluno.setCurso((String) txtCurso.getSelectedItem());
                        aluno2.setDisciplina((String) txtDisciplina.getSelectedItem());
                        aluno2.setSemestre((String) txtSemestre.getSelectedItem());
                        double nota = (Double.parseDouble((String) txtNota.getSelectedItem()));
                        aluno2.setNota(nota);
                        aluno2.setFaltas(Integer.parseInt(txtFaltas.getText()));
                        aluno2.setAluno(aluno);
                        dao2 = new AlunoDAO2();
                        dao2.salvar2(aluno2);
                        JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao SalvarMenu" + e1);
                }
            }
        });
        ImageIcon iconeSalva2 = new ImageIcon("imgs/icons/salvar.png");
        iconeSalva2.setImage(iconeSalva2.getImage().getScaledInstance(80, 75, 1));
        btnSalva2.setIcon(iconeSalva2);
        btnSalva2.setBounds(15, 260, 90, 85);
        painelDP.add(btnSalva2);

        btnAlterar2 = new JButton("");
        btnAlterar2.setToolTipText("Alterar");
        btnAlterar2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                try {

                    conn = ConnectionFactory.getConnection();
                    ps = conn.prepareStatement("SELECT * FROM notasfaltas");
                    rs = ps.executeQuery();

                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Alterar!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Alterar!");
                    } else if (txtCurso.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Curso para salvar!");
                    } else if (txtDisciplina.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione uma Disciplina para salvar!");
                    } else if (txtSemestre.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Selecione um Semestre para salvar!");
                    } else if (txtNota.getSelectedItem().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe uma Nota para salvar!");
                    } else if (txtFaltas.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Campo Falta em branco!");
                    } else {
                        char s = 's';
                        while (s == 's') {
                            while (rs.next()) {
                                int rgm = rs.getInt("RGM");
                                int rgm2 = Integer.parseInt(txtRgm2.getText());
                                if (rgm2 == rgm) {
                                    Aluno aluno = new Aluno();
                                    Aluno2 aluno2 = new Aluno2();
                                    aluno2.setDisciplina((String) txtDisciplina.getSelectedItem());
                                    aluno2.setSemestre((String) txtSemestre.getSelectedItem());
                                    aluno2.setNota((Double.parseDouble((String) txtNota.getSelectedItem())));
                                    aluno2.setFaltas(Integer.parseInt(txtFaltas.getText()));
                                    aluno.setRgm(Integer.parseInt(txtRgm2.getText()));

                                    ps = conn.prepareStatement(
                                            "UPDATE notasfaltas SET disciplina=?, semestre=?, nota=?, falta=? "
                                                    + "WHERE rgm=?");
                                    ps.setString(1, aluno2.getDisciplina());
                                    ps.setString(2, aluno2.getSemestre());
                                    ps.setDouble(3, aluno2.getNota());
                                    ps.setInt(4, aluno2.getFaltas());
                                    ps.setInt(5, aluno.getRgm());
                                    ps.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
                                }
                            }
                            s = 'n';
                        }
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Alterar!");
                }
            }
        });
        ImageIcon iconeAlterar2 = new ImageIcon("imgs/icons/alterar.png");
        iconeAlterar2.setImage(iconeAlterar2.getImage().getScaledInstance(80, 75, 1));
        btnAlterar2.setIcon(iconeAlterar2);
        btnAlterar2.setBounds(172, 260, 90, 85);
        painelDP.add(btnAlterar2);

        btnConsulta2 = new JButton("");
        btnConsulta2.setToolTipText("Consulta");
        btnConsulta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Consultar!");
                    } else {
                        try {
                            dao = new AlunoDAO();
                            int rgm = Integer.parseInt(txtRgm2.getText());
                            aluno = dao.consultar(rgm);

                            txtNome2.setText(aluno.getNome());
                            txtCurso2.setText(aluno.getCurso());
                            String rgm2 = (String.valueOf(aluno.getRgm()));
                            txtRgm.setText(rgm2);
                            txtRgm.setEditable(false);
                            txtNome.setText(aluno.getNome());
                            txtDataNasc.setText(aluno.getDataNasc());
                            txtCpf.setText(aluno.getCpf());
                            txtEmail.setText(aluno.getEmail());
                            txtEndereco.setText(aluno.getEndereco());
                            txtMunicipio.setText(aluno.getMunicipio());
                            txtUF.setSelectedItem(aluno.getUf());
                            txtCelular.setText(aluno.getCelular());
                            txtCurso.setSelectedItem(aluno.getCurso());
                            txtCampus.setSelectedItem(aluno.getCampus());
                            if (aluno.getPeriodo().equals("Matutino")) {
                                txtMatutino.setSelected(true);
                                txtVespertino.setSelected(false);
                                txtNoturno.setSelected(false);
                            } else if (aluno.getPeriodo().equals("Vespertino")) {
                                txtVespertino.setSelected(true);
                                txtMatutino.setSelected(false);
                                txtNoturno.setSelected(false);
                            } else {
                                txtNoturno.setSelected(true);
                                txtMatutino.setSelected(false);
                                txtVespertino.setSelected(false);
                            }
                        } catch (NullPointerException e1) {
                            JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Consultar!");
                        }
                    }

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Consultar!");
                }
            }
        });
        ImageIcon iconeConsulta2 = new ImageIcon("imgs/icons/consultar.png");
        iconeConsulta2.setImage(iconeConsulta2.getImage().getScaledInstance(80, 75, 1));
        btnConsulta2.setIcon(iconeConsulta2);
        btnConsulta2.setBounds(326, 260, 90, 85);
        painelDP.add(btnConsulta2);

        btnDelete2 = new JButton("");
        btnDelete2.setToolTipText("Delete");
        btnDelete2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtRgm2.getText().trim().length() <= 7) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Excluir!");
                    } else if (txtNome.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Informe um RGM Cadastrado para Excluir!");
                    } else {
                        // Abrir a conex�o
                        dao = new AlunoDAO();
                        dao2 = new AlunoDAO2();
                        // Excluir
                        int rgm = Integer.parseInt(txtRgm2.getText());
                        dao.deletar(rgm);
                        dao2.deletar2(rgm);
                        JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Erro ao Excluir!");
                }
            }
        });
        ImageIcon iconeDelete2 = new ImageIcon("imgs/icons/deletar.png");
        iconeDelete2.setImage(iconeDelete2.getImage().getScaledInstance(80, 75, 1));
        btnDelete2.setIcon(iconeDelete2);
        btnDelete2.setBounds(480, 260, 90, 85);
        painelDP.add(btnDelete2);

        btnNovo2 = new JButton("");
        btnNovo2.setToolTipText("Novo");
        btnNovo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtRgm2.setText(null);
                txtNome2.setText(null);
                txtCurso2.setText(null);
                txtDisciplina.setSelectedIndex(0);
                txtSemestre.setSelectedIndex(0);
                txtNota.setSelectedIndex(0);
                txtFaltas.setText(null);
            }
        });
        ImageIcon iconeNovo2 = new ImageIcon("imgs/icons/novo.png");
        iconeNovo2.setImage(iconeNovo2.getImage().getScaledInstance(80, 75, 1));
        btnNovo2.setIcon(iconeNovo2);
        btnNovo2.setBounds(640, 260, 90, 85);
        painelDP.add(btnNovo2);

        // Configurando guia Boletim
        painelDP = new JPanel();
        painelDP.setForeground(new Color(30, 144, 255));
        painelSup.addTab("Boletim", null, painelDP, null);
        painelDP.setLayout(null);

        /*
         * Configurando todas as labels da guia Boletim
         */
        lblRgm = new JLabel("Informe seu RGM:");
        lblRgm.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblRgm.setBounds(175, 30, 200, 30);
        painelDP.add(lblRgm);

        txtRgm3 = new JFormattedTextField();
        txtRgm3.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtRgm3.setBounds(340, 30, 150, 30);
        txtRgm3.setHorizontalAlignment(SwingConstants.CENTER);
        formatarCampo6();
        painelDP.add(txtRgm3);
        txtRgm3.setColumns(10);

        /*
         * Configurando os botoes de Consulta e Novo da guia Boletim
         */
        btnConsulta3 = new JButton("");
        btnConsulta3.setToolTipText("Consulta");
        btnConsulta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtRgm3.getText().trim().length() <= 7) {
                    JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Listar os Dados!");
                } else {
                    try {
                        conn = ConnectionFactory.getConnection();
                        ps = conn.prepareStatement("SELECT * FROM notasfaltas");
                        rs = ps.executeQuery();

                        try {
                            char s = 's';
                            while (s == 's') {
                                while (rs.next()) {
                                    String disciplina = rs.getString("disciplina");
                                    String semestre = rs.getString("semestre");
                                    double nota = rs.getDouble("nota");
                                    int faltas = rs.getInt("faltas");
                                    String nome = rs.getString("nome");
                                    String curso = rs.getString("curso");

                                    txtNome3.setText(nome);
                                    txtCurso3.setText(curso);
                                    txtDisciplina2.setText(disciplina);
                                    txtSemestre2.setText(semestre);
                                    txtNota2.setText(Double.toString(nota));
                                    txtFaltas2.setText(Integer.toString(faltas));

                                }
                                s = 'n';
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Informe um RGM Valido para Listar os Dados");
                        }
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Erro ao listar os dados");
                    }
                }
            }
        });
        ImageIcon iconeConsulta3 = new ImageIcon("imgs/icons/consultar2.png");
        iconeConsulta3.setImage(iconeConsulta3.getImage().getScaledInstance(25, 25, 1));
        btnConsulta3.setIcon(iconeConsulta3);
        btnConsulta3.setBounds(500, 30, 30, 30);
        painelDP.add(btnConsulta3);

        btnNovo3 = new JButton("");
        btnNovo3.setToolTipText("Consulta");
        btnNovo3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtRgm3.setText(null);
                txtNome3.setText(null);
                txtCurso3.setText(null);
                txtDisciplina2.setText(null);
                txtSemestre2.setText(null);
                txtNota2.setText(null);
                txtFaltas2.setText(null);

            }
        });
        ImageIcon iconeNovo3 = new ImageIcon("imgs/icons/novo2.png");
        iconeNovo3.setImage(iconeNovo3.getImage().getScaledInstance(25, 25, 1));
        btnNovo3.setIcon(iconeNovo3);
        btnNovo3.setBounds(540, 30, 30, 30);
        painelDP.add(btnNovo3);

        /*
         * Configurando todos os labels da guia Boletim
         */
        lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNome.setBounds(15, 90, 100, 30);
        painelDP.add(lblNome);

        txtNome3 = new JTextField();
        txtNome3.setEditable(false);
        txtNome3.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNome3.setBounds(130, 90, 600, 30);
        txtNome3.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtNome3);
        txtNome3.setColumns(10);

        lblCurso = new JLabel("Curso");
        lblCurso.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCurso.setBounds(15, 150, 100, 30);
        painelDP.add(lblCurso);

        txtCurso3 = new JTextField();
        txtCurso3.setEditable(false);
        txtCurso3.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCurso3.setBounds(130, 150, 600, 30);
        txtCurso3.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtCurso3);
        txtCurso3.setColumns(10);

        lblDisciplina = new JLabel("Disciplina");
        lblDisciplina.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblDisciplina.setBounds(15, 210, 100, 30);
        painelDP.add(lblDisciplina);

        txtDisciplina2 = new JTextField();
        txtDisciplina2.setEditable(false);
        txtDisciplina2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtDisciplina2.setBounds(130, 210, 600, 30);
        txtDisciplina2.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtDisciplina2);
        txtDisciplina2.setColumns(10);

        lblSemestre = new JLabel("Semestre");
        lblSemestre.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblSemestre.setBounds(15, 270, 100, 30);
        painelDP.add(lblSemestre);

        txtSemestre2 = new JTextField();
        txtSemestre2.setEditable(false);
        txtSemestre2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtSemestre2.setBounds(130, 270, 100, 30);
        txtSemestre2.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtSemestre2);
        txtSemestre2.setColumns(10);

        lblNota = new JLabel("Nota");
        lblNota.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNota.setBounds(330, 270, 100, 30);
        painelDP.add(lblNota);

        txtNota2 = new JTextField();
        txtNota2.setEditable(false);
        txtNota2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNota2.setBounds(410, 270, 100, 30);
        txtNota2.setHorizontalAlignment(SwingConstants.CENTER);
        painelDP.add(txtNota2);
        txtNota2.setColumns(10);

        lblFaltas = new JLabel("Faltas");
        lblFaltas.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblFaltas.setBounds(600, 270, 100, 30);
        painelDP.add(lblFaltas);

        txtFaltas2 = new JTextField();
        txtFaltas2.setEditable(false);
        txtFaltas2.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtFaltas2.setHorizontalAlignment(SwingConstants.CENTER);
        txtFaltas2.setBounds(680, 270, 50, 30);
        painelDP.add(txtFaltas2);
        txtNota2.setColumns(10);

    }

    /*
     * Metodos de formatacao dos campos
     */
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

    private void formatarCampo5() {
        try {
            MaskFormatter mask = new MaskFormatter("########");
            mask.install(txtRgm2);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
        }
    }

    private void formatarCampo6() {
        try {
            MaskFormatter mask = new MaskFormatter("########");
            mask.install(txtRgm3);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
        }
    }
}