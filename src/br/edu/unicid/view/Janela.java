package br.edu.unicid.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PlainDocument;

public class Janela extends JFrame {

    private JPanel painel;
    private JLabel lblRgm;
    private JTextField txtRgm;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblDataNasc;
    private JTextField txtDataNasc;
    private JLabel lblCpf;
    private JTextField txtCpf;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblEndereco;
    private JTextField txtEndereco;
    private JLabel lblMunicipio;
    private JTextField txtMunicipio;
    private JLabel lblUF;
    private JTextField txtUF;
    private JLabel lblCelular;
    private JTextField txtCelular;

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
        setBounds(100, 100, 800, 450);
        painel = new JPanel();
        painel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(painel);
        painel.setLayout(null);

        lblRgm = new JLabel("Rgm");
        lblRgm.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblRgm.setBounds(15, 10, 100, 30);
        painel.add(lblRgm);

        txtRgm = new JTextField();
        txtRgm.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtRgm.setBounds(70, 10, 150, 30);
        txtRgm.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtRgm);
        txtRgm.setColumns(10);
        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new LimitadorDeCaracteres(8));
        txtRgm.setDocument(doc);

        lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNome.setBounds(230, 10, 100, 30);
        painel.add(lblNome);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtNome.setBounds(303, 10, 460, 30);
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtNome);
        txtNome.setColumns(10);

        lblDataNasc = new JLabel("Data de Nascimento");
        lblDataNasc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblDataNasc.setBounds(15, 50, 100, 30);
        painel.add(lblDataNasc);

        txtDataNasc = new JTextField();
        txtDataNasc.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtDataNasc.setBounds(120, 50, 150, 30);
        txtDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtDataNasc);
        txtDataNasc.setColumns(10);

        lblCpf = new JLabel("Cpf");
        lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCpf.setBounds(280, 50, 100, 30);
        painel.add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCpf.setBounds(330, 50, 180, 30);
        txtCpf.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtCpf);
        txtCpf.setColumns(10);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblEmail.setBounds(15, 90, 100, 30);
        painel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtEmail.setBounds(130, 90, 630, 30);
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtEmail);
        txtEmail.setColumns(10);

        lblEndereco = new JLabel("Endereco");
        lblEndereco.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblEndereco.setBounds(15, 130, 100, 30);
        painel.add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtEndereco.setBounds(130, 130, 630, 30);
        txtEndereco.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtEndereco);
        txtEndereco.setColumns(10);

        lblMunicipio = new JLabel("Municipio");
        lblMunicipio.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblMunicipio.setBounds(15, 170, 100, 30);
        painel.add(lblMunicipio);

        txtMunicipio = new JTextField();
        txtMunicipio.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtMunicipio.setBounds(130, 170, 150, 30);
        txtMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtMunicipio);
        txtMunicipio.setColumns(10);

        lblUF = new JLabel("UF");
        lblUF.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblUF.setBounds(310, 170, 100, 30);
        painel.add(lblUF);

        txtUF = new JTextField();
        txtUF.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtUF.setBounds(380, 170, 70, 30);
        txtUF.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtUF);
        txtUF.setColumns(10);

        lblCelular = new JLabel("Celular");
        lblCelular.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblCelular.setBounds(480, 170, 100, 30);
        painel.add(lblCelular);

        txtCelular = new JTextField();
        txtCelular.setFont(new Font("Times New Roman", Font.PLAIN + Font.ITALIC, 20));
        txtCelular.setBounds(570, 170, 190, 30);
        txtCelular.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(txtCelular);
        txtCelular.setColumns(10);

    }

    class LimitadorDeCaracteres extends javax.swing.text.DocumentFilter {
        private int maxCaracteres;

        public LimitadorDeCaracteres(int maxCaracteres) {
            this.maxCaracteres = maxCaracteres;
        }

        @Override
        public void replace(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, int length, String text,
                javax.swing.text.AttributeSet attrs) throws javax.swing.text.BadLocationException {
            int novoComprimento = fb.getDocument().getLength() - length + text.length();
            if (novoComprimento <= maxCaracteres) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        @Override
        public void insertString(javax.swing.text.DocumentFilter.FilterBypass fb, int offset, String string,
                javax.swing.text.AttributeSet attr) throws javax.swing.text.BadLocationException {
            int novoComprimento = fb.getDocument().getLength() + string.length();
            if (novoComprimento <= maxCaracteres) {
                super.insertString(fb, offset, string, attr);
            }
        }

    }
}
