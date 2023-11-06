
package model;

import enums.Estado;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CIDADE") //Name - nome físico Table e Column

public class Cidade implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Leva para o banco a responsabilidade de criar sua chave primária
    @Column (name = "ID_CIDADE", nullable = false) //Diz que vai ser uma coluna do banco de dados
    @SwingColumn(description = "Código")
    private int id;
    
    @Column(name = "NOME_CIDADE", nullable = false, length = 100) //O nome não pode ser nulo, tamanho do nome
    @SwingColumn(description = "Nome da Cidade")
    private String nome;
    
    @Enumerated(EnumType.STRING) //O ordinal grava 0 no banco - String grava String = texto 
    @Column(name = "SIGLA_ESTADO", nullable = false, length = 2)
    @SwingColumn(description = "Estado")
    private Estado estado;
    
//////////////////
    
    public Cidade() {
        
        this.setId(0);
        this.setNome("SEM NOME");
        this.setEstado(Estado.SC);
    }    
    
    public Cidade(int id, String nome, Estado estado) {
        
        this.setId(id);
        this.setNome(nome);
        this.setEstado(estado);
    }
    
//////////////////
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "SEM NOME" : nome.toUpperCase();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
//////////////////
    
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Estado getEstado() {
        return this.estado;
    }
    
//////////////////
    
    @Override
    public String toString() {
        return nome;
    }
    
//////////////////
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        return this.id == other.id;
    }
       
 //////////////////   
}
