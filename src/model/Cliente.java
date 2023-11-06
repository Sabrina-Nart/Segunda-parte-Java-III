
package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // Serve para aparecer no persistence.xml
@Table(name = "TB_CLIENTE")

public class Cliente implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @SwingColumn(description = "Código")
    @Column(name = "ID_CLIENTE",nullable = false)
    private int id;
    
    @SwingColumn(description = "Nome do Cliente")
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;    
    
    @SwingColumn(description = "Telefone")
    @Column(name = "TELEFONE", length = 100, nullable = false)
    private String telefone;    

    @SwingColumn(description = "CPF")
    @Column(name = "CPF", length = 14, nullable = false)
     
//////////////////   
    
    // 2 anotações utilizadas para FK
    // Sem o referencedColumnName NADA irá funcionar
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", nullable = false, referencedColumnName = "ID_CIDADE")
    private Cidade cidade; // Chave estrangeira = Relacionamento de classes    
 
//////////////////

    public Cliente() {
        this.setId(0);
        this.setNome("");
        this.setTelefone("");
        this.setCidade(null);
    }    
    
    public Cliente(int id, String nome, String telefone, Cidade cidade) {
        
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setCidade(cidade);
    }
    
//////////////////
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "VÁZIO" : nome.toUpperCase();
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone.trim().isEmpty() ? "" : telefone;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
//////////////////
    
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Cidade getCidade() {
        return this.cidade;
    }
    
//////////////////
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + '}';
    }
    
//////////////////
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        return this.id == other.id;
    }
    
//////////////////    
}
