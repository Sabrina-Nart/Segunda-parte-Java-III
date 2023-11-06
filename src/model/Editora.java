
package model;

import java.time.LocalDate;
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
@Table(name = "TB_EDITORA")

public class Editora implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // BD que gera a senha
    @SwingColumn(description = "Código")
    @Column(name = "ID_EDITORA",nullable = false)
    private int id;
    
    @SwingColumn(description = "Nome da Editora")
    @Column(name = "NOME_EDITORA", length = 100, nullable = false)
    private String razaoSocial;
    
    @SwingColumn(description = "Nome Fantasia")
    @Column(name = "NOME_FANTASIA", length = 80, nullable = false)
    private String nomeFantasia;
    
    @SwingColumn(description = "Endereço")
    @Column(name = "ENDERECO_EDITORA", length = 100, nullable = false)
    private String endereco;
    
    @SwingColumn(description = "Data de Cadastro")
    @Column(name = "DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastro;
    
    @SwingColumn(description = "CNPJ da Editora")
    @Column(name = "CNPJ_EDITORA", length = 18, nullable = false)
    private String cnpj;
    
//////////////////   
    
    // 2 anotações utilizadas para FK
    // Sem o referencedColumnName NADA irá funcionar
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", nullable = false, referencedColumnName = "ID_CIDADE")
    private Cidade cidade; // Chave estrangeira = Relacionamento de classes
    
//////////////////
    
    //SEM parametro
    public Editora() {
        this.setId (0);
        this.setRazaoSocial("");
        this.setNomeFantasia ("");
        this.setEndereco("");
        this.setDataCadastro(null);
        this.setCnpj("");
        this.setCidade (null);
    }
    
/////////   
    
    //COM parametro
    public Editora(int id, String razaoSocial, String nomeFantasia, String endereco, LocalDate dataCadastro, String cnpj, Cidade cidade) {
        this.setId (id);
        this.setRazaoSocial(razaoSocial);
        this.setNomeFantasia (nomeFantasia);
        this.setEndereco(endereco);
        this.setDataCadastro(dataCadastro);
        this.setCnpj(cnpj);
        this.setCidade (cidade);
    }

//////////////////    

    //SET
    public void setId(int id) {
        this.id = id;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial.trim().isEmpty()?"VAZIO":razaoSocial.toUpperCase();
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia.trim().isEmpty()?"VAZIO":nomeFantasia.toUpperCase();
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.trim().isEmpty()?"VAZIO":endereco.toUpperCase();
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
//////////////////
    
    //GET
    public int getId() {
        return this.id;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public LocalDate getDataCadastro() {
        return this.dataCadastro;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public Cidade getCidade() {
        return this.cidade;
    }
    
//////////////////
    
    //toString
    @Override
    public String toString() {
        return "Editora{" + "razaoSocial=" + razaoSocial + '}';
    }

//////////////////
    
    //Equals / hasCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Editora other = (Editora) obj;
        return this.id == other.id;
    } 
    
//////////////////    
}
