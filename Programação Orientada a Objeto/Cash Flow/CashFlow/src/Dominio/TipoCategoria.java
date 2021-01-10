package Dominio;

public class TipoCategoria {
    
    private String descricao;

    public TipoCategoria() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "tipoCategoria{" + "descricao=" + descricao + '}';
    }
    
    
    
}
