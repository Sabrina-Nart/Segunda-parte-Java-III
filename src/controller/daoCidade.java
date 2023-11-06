
package controller;

import abstratas.dao;
import java.util.List;
import model.Cidade;

public class daoCidade extends dao<Cidade>{ //Create, update, delete, read feito
    
    public List<Cidade> read() { //Método que devolve todas as cidade
        
        return super.read("select i from Cidade i order by i.nome");
    }
    
///////////
    
    public List<Cidade> read(String filtroNome){ //Método que devolve um filtro
        
        return super.read("select i from Cidade i where i.nome like ?1", "%" + filtroNome.toUpperCase() + "%");
        //Número ou nome = filtros JQPL
    }
    
///////////    
}


