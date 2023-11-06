
package crud;

import controller.daoCidade;
import controller.daoEditora;
import java.time.LocalDate;
import model.Cidade;
import model.Editora;
        
public class crudEditora {
  
    public static void main(String[] args) {
        
        Editora e1 = new Editora(0, "Editora Cultura", "Cultura", "São Paulo", LocalDate.MAX, "70.283.397/0001-51", new daoCidade().read(Cidade.class, 1));
        Editora e2 = new Editora(0, "Editora Arqueiro", "Arqueiro", "Rio de Janeiro", LocalDate.MAX, "88.654.268/0001-98", new daoCidade().read(Cidade.class, 2));
        Editora e3 = new Editora(0, "Editora Abril", "Abril", "São Paulo", LocalDate.MAX, "32.967.924/0001-58", new daoCidade().read(Cidade.class, 3));            
        
        daoEditora dao = new daoEditora();

        try {

            /*dao.create(c1);
            dao.create(c2);
            dao.create(c3);*/  //CRUD - Testar - Shift F6

            for (Editora editora : dao.read("r")) { //Teste - filtro colocando o que quer que apareça= filtro - se não tiver filtro, aparece tudo
                System.out.println(editora.getId() + "\t" + 
                                   editora.getRazaoSocial() + "\t" + 
                                   editora.getNomeFantasia() + "\t" + 
                                   editora.getEndereco() + "\t" + 
                                   editora.getDataCadastro() + "\t" + 
                                   editora.getCnpj() + "\t" + 
                                   editora.getCidade());
            }
        }catch(Exception ex) {

            System.out.println("Erro: " + ex.getMessage());
        }        
    }    
}
