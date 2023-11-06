package crud;

import controller.daoCategoria;
import controller.daoCidade;
import controller.daoCliente;
import controller.daoEditora;
import controller.daoLivro;
import enums.Generos;
import model.Categoria;
import model.Cidade;
import model.Cliente;
import model.Editora;
import model.Livro;

public class crudClienteLivro {
    public static void main(String[] args) {
        
        //criação dos dao
        daoCliente daocliente = new daoCliente();
        daoLivro daolivro     = new daoLivro();
        
        //Criação de objetos cliente
        Cliente c1 = new Cliente(0,"cliente teste 1", "(48)99997-1234", "000.000.000-00", new daoCidade().read(Cidade.class, 1));
        Cliente c2 = new Cliente(0,"cliente teste 2", "(48)99123-9876", "123.456.789-00", new daoCidade().read(Cidade.class, 2));
        Cliente c3 = new Cliente(0,"cliente teste 3", "(48)99777-0000", "111.222.222-33", new daoCidade().read(Cidade.class, 3));
        
        //criação de objetos Livro
        Livro l1 = new Livro(0,"livro teste 1","é um bom livro"          ,Generos.D,2015,"joaquim silveira",false,new daoEditora().read(Editora.class, 1),new daoCategoria().read(Categoria.class, 1));
        Livro l2 = new Livro(0,"titulo livro teste 2","é um bom mediano" ,Generos.A,2022,"maria laura"     ,false,new daoEditora().read(Editora.class, 2),new daoCategoria().read(Categoria.class, 2));
        Livro l3 = new Livro(0,"outro livro teste 3","não é um bom livro",Generos.T,2000,"jorge lucas"     ,false,new daoEditora().read(Editora.class, 3),new daoCategoria().read(Categoria.class, 3));
        
        try{
            //gravar clientes
            
            daocliente.create(c1);
            daocliente.create(c2);
            daocliente.create(c3);
            
            //gravar livros
            daolivro.create(l1);
            daolivro.create(l2);
            daolivro.create(l3);
            
        }catch(Exception ex){
            System.out.println("ERRO:"+ex.getMessage());
        }
        //listar todos os cliente
        System.out.println("--Todos os clientes--");
        for(Cliente cliente : daocliente.read()){
            System.out.println(cliente.getNome()+"\t"+cliente.getCidade());
        }
        //listar todos os livros
        System.out.println("--Todos os Livros--");
        for(Livro livro : daolivro.read()){
            System.out.println(livro.getTitulo()+"\t"+livro.getAnoLancamento()+"\t"+livro.getGenero()+"\t"+livro.getEditora());
        }

        //listar os cliente filtrando pelo nome
        System.out.println("--clientes filtro pelo nome--");
        for(Cliente cliente : daocliente.readNome("2")){
            System.out.println(cliente.getNome()+"\t"+cliente.getCidade());
        }
        //listar os cliente filtrando pelo cpf
        System.out.println("--clientes filtro pelo cpf--");
        for(Cliente cliente : daocliente.readCpf("000.000.000-00")){
            System.out.println(cliente.getNome()+"\t"+cliente.getCidade());
        }

        //listar os livros filtrando pelo titulo
        System.out.println("--livros filtro pelo titulo--");
        for(Livro livro : daolivro.readTitulo("tro")){
            System.out.println(livro.getTitulo()+"\t"+livro.getCategoria());
        }
        //listar os livro filtrando pelo Autor
        System.out.println("--livros filtro pelo autor--");
        for(Livro livro : daolivro.readAutor("ri")){
            System.out.println(livro.getTitulo()+"\t"+livro.getAutor());
        }
        //listar os livro filtrando pela categoria
        System.out.println("--livros filtro pela categoria--");
        for(Livro livro : daolivro.readCategoria(new daoCategoria().read(Categoria.class, 2))){
            System.out.println(livro.getTitulo()+"\t"+livro.getCategoria());
        }
    }
    
}
