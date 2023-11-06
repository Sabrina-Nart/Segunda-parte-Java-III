
package controller;

import abstratas.dao;
import java.util.List;
import model.Cidade;
import model.Cliente;

public class daoCliente extends dao<Cliente>{
       public List<Cliente> read(){
        
        return super.read("select e from Editora e order by e.razaoSocial");
    }

    
/////////////////////    
    
    public List<Cliente> read (String filtroNome){
        String JPQL="select e from Cliente e where e.nome like ?1" + " order by e.nome";
    
        return super.read(JPQL, "%" +filtroNome.toUpperCase()+"%");
    }
    
/////////////////////    
    
    public List<Cliente> read (Cidade cidade){
         String JPQL="select e from Cliente e where e.cidade like =?1" + " order by e.nome";
    
         return super.read(JPQL, cidade);
    }    
    
/////////////////////      
}
