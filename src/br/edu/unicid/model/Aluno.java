package br.edu.unicid.model;

public class Aluno {
    /*
     * Criando variaveis
     */
    private int Rgm;
    private String nome;
    private String dataNasc;
    private String cpf;
    private String email;
    private String endereco;
    private String municipio;
    private String uf;
    private String celular;
    private String curso;
    private String campus;
    private String periodo;

    /*
     * Getters e Setters
     */
    public int getRgm() {
        return Rgm;
    }

    public void setRgm(int rgm) {
        Rgm = rgm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Aluno() {

    }

    public Aluno(int rgm, String nome, String dataNasc, String cpf, String email, String endereco, String municipio,
            String uf, String celular, String curso, String campus, String periodo) {
        Rgm = rgm;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.municipio = municipio;
        this.uf = uf;
        this.celular = celular;
        this.curso = curso;
        this.campus = campus;
        this.periodo = periodo;
    }

    public Aluno(String nome2, String curso2) {
    }

}