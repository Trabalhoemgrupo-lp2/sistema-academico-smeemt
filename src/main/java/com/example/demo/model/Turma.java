package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turma_id") 
    private Long turmaId;

    @ManyToOne
    @JoinColumn(name = "id_componente") 
    private Componente componente; 

    @Column(name = "ano_semestre", length = 10)
    private String anoSemestre; 

    @Column(length = 20)
    private String turno; 

    @Column
    private Integer capacidade;

   public Turma() {}

    public Turma(Long turmaId, Componente componente, String anoSemestre, String turno, Integer capacidade) {
        this.turmaId = turmaId;
        this.componente = componente;
        this.anoSemestre = anoSemestre;
        this.turno = turno;
        this.capacidade = capacidade;
    }

   public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public String getAnoSemestre() {
        return anoSemestre;
    }

    public void setAnoSemestre(String anoSemestre) {
        this.anoSemestre = anoSemestre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
}
