
package controller;

import abstratas.dao;
import java.util.List;
import model.Cidade;
import model.Editora;

public class daoEditora extends dao<Editora>{
    
    public List<Editora> read(){
        return super.read("select e from Editora e order by e.razaoSocial");
    }
    
/////////////////////    
    
    public List<Editora> read (String filtroRazao){
        String JPQL="select e from Editora e where e.razaoSocial like ?1" + " order by e.razaoSocial";
    
        return super.read(JPQL, "%"+filtroRazao.toUpperCase()+"%");
    }
    
/////////////////////    
    
    public List<Editora> read (Cidade cidade){
         String JPQL="select e from Editora e where e.cidade like =?1" + " order by e.razaoSocial";
    
         return super.read(JPQL, cidade);
    }
    
/////////////////////    
}
