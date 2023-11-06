
package abstratas;

import javax.persistence.EntityManager; //SEMPRE DESSE IMPORT
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

abstract public class Dados { //Usamos Framework para reduzir código, etc - ele faz algo que teria que ser feito manualmente
    
    private static EntityManager manager = null;
    
////////////////
    
    public static EntityManager getManager(){ //da conta do projeto inteiro
        
        if (manager == null){
            
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("projectBibliotecaPU"); //Copia cola do Persistence.xml = primeiro campo
            //Factory = para carregar a UML = carrega tudo de configuração que for colocado lá
            
            manager = factory.createEntityManager();
        }
        
        return manager;
    }
    
////////////////    
}
