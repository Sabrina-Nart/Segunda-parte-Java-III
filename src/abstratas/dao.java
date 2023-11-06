
package abstratas;

import java.util.List;
import javax.persistence.Query;
import model.Categoria;

abstract public class dao<T> { //<T> Representação Diamante - T = Tipe - Dizer qual é o tipo e a partir de todo lugar que achar um T, vai ser Categoria
    
    public void create(T objeto) { //Todos esses métodos não tenham que ser reescritos
        Dados.getManager().getTransaction().begin(); 
        Dados.getManager().persist(objeto);
        Dados.getManager().getTransaction().commit(); //Tem que fazer o início e fim da transação
    }
    
//////////////////
    
    public void update(T objeto) {
        
        Dados.getManager().getTransaction().begin();
        Dados.getManager().merge(objeto);
        Dados.getManager().getTransaction().commit(); //Tem que fazer o início e fim da transação
    }
    
//////////////////
    
    public void delete(T objeto) {
        
        Dados.getManager().getTransaction().begin();
        Dados.getManager().remove(objeto);
        Dados.getManager().getTransaction().commit(); //Tem que fazer o início e fim da transação
    }
    
//////////////////
    
    //Devolve uma objeto
    public T read(Class<T> classToRerurn, int id){ 
        
        return Dados.getManager().find(classToRerurn, id); //Substitui o find = estático - aqui ele assume qualquer coisa
    }
    
//////////////////    

    public List<T> read(String JQPL) {
        
        Query query = Dados.getManager().createQuery(JQPL); //Passar o JPQL sem Parâmetro
        return query.getResultList();
    }
    
//////////////////  
    
   //JPQL com filtro
  
     public List<T> read(String JQPL, Object... args) {
        
        Query query = Dados.getManager().createQuery(JQPL); //Criação da query
        
        for (int i=0; i<args.length; i++){ //Passar o JPQL com Parâmetro
            
            query.setParameter(i+1, args[i]);
        }
        
        return query.getResultList(); //Execução da query
    }   
    
//////////////////     
}
