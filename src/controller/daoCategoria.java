
package controller;

import abstratas.Dados;
import abstratas.dao;
import java.util.List;
import javax.persistence.Query;
import model.Categoria;

public class daoCategoria extends dao<Categoria>{    
    
    public List<Categoria> read() {
        
        return super.read("select c from Categoria c order by c.nome");
    }
}
