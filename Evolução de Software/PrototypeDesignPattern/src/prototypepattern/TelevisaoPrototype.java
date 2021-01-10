package prototypepattern;

public abstract class TelevisaoPrototype {
    
    protected double tamanho;
    protected double resolucao;
    protected double valor;
    protected double fabricante;
    
    public abstract String exibirInfo();
    public abstract TelevisaoPrototype clonar();

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getResolucao() {
        return resolucao;
    }

    public void setResolucao(double resolucao) {
        this.resolucao = resolucao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getFabricante() {
        return fabricante;
    }

    public void setFabricante(double fabricante) {
        this.fabricante = fabricante;
    }
    
}
