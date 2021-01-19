package br.com.alura.spring.data.orm;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private Double salario;
    private LocalDate dataContratacao;
    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidades",joinColumns = {
            @JoinColumn(name = "fk_funcionario") },
    inverseJoinColumns = {
            @JoinColumn(name = "fk_unidade")    })
    private List<UnidadeTrabalho> unidadeTrabalhos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataCotratacao(LocalDate dataCotratacao) {
        this.dataContratacao = dataCotratacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public List<UnidadeTrabalho> getUnidadeTrabalhos() {
        return unidadeTrabalhos;
    }

    public void setUnidadeTrabalhos(List<UnidadeTrabalho> unidadeTrabalhos) {
        this.unidadeTrabalhos = unidadeTrabalhos;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo +
                ", unidadeTrabalhos=" + unidadeTrabalhos +
                '}';
    }
}
