package br.edu.unicid.model;

public class Aluno2 {
    /*
     * Criando variaveis
     */
    private String disciplina;
    private String semestre;
    private double nota;
    private int faltas;
    private Aluno aluno;

    /*
     * Getters e Setters
     */
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno2() {

    }

    public Aluno2(String disciplina, String semestre, double nota, int faltas, Aluno aluno) {
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.nota = nota;
        this.faltas = faltas;
        this.aluno = aluno;

    }
}
