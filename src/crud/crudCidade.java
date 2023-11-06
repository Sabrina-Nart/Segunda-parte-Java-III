
package crud;

import controller.daoCidade;
import enums.Estado;
import model.Cidade;

public class crudCidade {
    
    public static void main(String[] args) {
        
        Cidade c1 = new Cidade(0, "criciúma", Estado.SC);
        Cidade c2 = new Cidade(0, "cúritiba", Estado.PR);
        Cidade c3 = new Cidade(0, "são paulo", Estado.SP);
        
        daoCidade dao = new daoCidade();

        try {

            /*dao.create(c1);
            dao.create(c2);
            dao.create(c3);*/  //CRUD - Testar - Shift F6

            for (Cidade cidade : dao.read("r")) { //Teste - filtro colocando o que quer que apareça= filtro - se não tiver filtro, aparece tudo
                System.out.println(cidade.getId() + "\t" + 
                                   cidade.getNome() + "\t" + 
                                   cidade.getEstado());
            }
        }catch(Exception ex) {

            System.out.println("Erro: " + ex.getMessage());
        }        
    }
    
/////////////////     
    
}
