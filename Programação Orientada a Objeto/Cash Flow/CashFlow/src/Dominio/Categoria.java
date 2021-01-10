package Dominio;

public class Categoria {
    
    private String descricao;
    private TipoCategoria tipoCategoria;

    public Categoria() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "descricao=" + descricao + ", tipoCategoria=" + tipoCategoria + '}';
    }
    
    
    
}
