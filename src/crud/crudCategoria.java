
package crud;

import controller.daoCategoria;
import model.Categoria;

public class crudCategoria {
    
    public static void main(String[] args) {
        
        Categoria c1 = new Categoria(0, "Lançamnento", 5);
        Categoria c2 = new Categoria(0, "Livro Comun", 3);
        Categoria c3 = new Categoria(0, "Quadrinho Encadernado", 6);
        
 ////////

        daoCategoria dao = new daoCategoria();

        try {
          /*  dao.create(c1);
            dao.create(c2);
            dao.create(c3); */ 
            
            Categoria c = dao.read(Categoria.class, 3);
            System.out.println((c == null ? "Não tem" : c.getNome()));
        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
    
 ////////    
}
