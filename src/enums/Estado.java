
package enums;

public enum Estado {
    
    SC("Santa Catarina"),
    RS("Rio Grande do Sul"),
    PR("Paraná"),
    SP("São Paulo"),
    RJ("Rio de Janeiro"),
    BH("Bahia"),
    TO("Tocantins"),
    PE("Pernambuco"),
    MG("Minas Gerais"),
    MT("Mato Grosso"),
    ES("Espirito Santo"),
    GO("Góiais");
    
    private String descricao;
    
///////////////
    
    private Estado(String descricao) {
        
        this.descricao = descricao;
    }
    
///////////////
    
    @Override
    public String toString() {
        
        return descricao;
    }
    
///////////////   
}
