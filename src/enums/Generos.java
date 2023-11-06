
package enums;


public enum Generos {
    
    D("Derivada"),
    A("Ação"),
    T("Trabalho");
    
    private String descricao;

    private Generos(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Generos{" + "descricao=" + descricao + '}';
    }
    
    
}
