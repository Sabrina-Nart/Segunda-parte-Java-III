
package model;

import javax.persistence.Column;   //META - ANOTAÇÃO - SE NÃO, NÃO FUNCIONA
import javax.persistence.Entity; // 1° coisa a se fazer - Falando para o JPA que está mapeando uma tabela
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
                                //Até não falar quem é chave primária, o erro não some

@Entity 
@Table(name = "TB_CATEGORIA") //Sistemas Legados = utilizam coisas que não dele = dos outros - nomes de tabela sigam uma padrão
           //O nome da tabela no banco será esse - fisicamente será esse
        //Quando tiver uma Categoria, ele entende que é a TB_CATEGORIA
//Se não colocar o name, ele assume o mesmo nome da classe = não é obrigatório

public class Categoria implements java.io.Serializable{
    
    @Id //Esse é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Ele será um valor gerado
                                            //Transfere a responsabilidade para o banco = só troca o banco, não precisa se preocupar com o resto
    @Column(name = "ID_CATEGORIA", nullable = false) //Diz que é coluna no banco - nem tudo é tabela do banco - Item do Pedido, 
                          //dois x que custa 15 vai para o banco, o 30 não vai para o banco, mas o usuário vê
                        //Chave primária não é nula   
    private int id;
    
    @Column(name = "NOME_CATEGORIA", nullable = false, length = 100) //Por padão vem true e 2,5
    private String nome;
    
    @Column(name = "VALOR_MULTA", nullable = false, scale = 2)
    private double multa;
    
//////////////////
    
    public Categoria() {
        this.setId(0);
        this.setNome("VÁZIO");
        this.setMulta(0);
    }
    
    public Categoria(int id, String nome, double multa) {
        this.setId(id);
        this.setNome(nome);
        this.setMulta(multa);
    }
    
//////////////////
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "VÁZIO" : nome.toUpperCase();
    }

    public void setMulta(double multa) {
        this.multa = multa < 0 ? 0.01 : multa;
    }
    
//////////////////
    
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getMulta() {
        return this.multa;
    }
    
//////////////////
    
    @Override
    public String toString() {
        return " nome=" + nome + '}';
    }
    
//////////////////
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Categoria other = (Categoria) obj;
        return this.id == other.id;
    }
    
//////////////////    
}
