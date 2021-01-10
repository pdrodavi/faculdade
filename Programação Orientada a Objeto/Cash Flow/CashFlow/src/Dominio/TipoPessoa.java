package Dominio;

public class TipoPessoa {
    
    private String descricao;

    public TipoPessoa() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "tipoPessoa{" + "descricao=" + descricao + '}';
    }
    
    
    
}
