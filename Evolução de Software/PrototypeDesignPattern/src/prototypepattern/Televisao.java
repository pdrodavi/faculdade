package prototypepattern;

public class Televisao extends TelevisaoPrototype {

    protected Televisao(Televisao tv) {
        this.tamanho = tv.getTamanho();
        this.valor = tv.getValor();
        this.resolucao = tv.getResolucao();
        this.fabricante = tv.getFabricante();
    }

    public Televisao() {
        tamanho = 0.0;
        valor = 0.0;
        resolucao = 0.0;
        fabricante = 0.0;
    }
    
    @Override
    public String exibirInfo() {
        return "Fabricante: " + getFabricante() + "\n" + 
                "Valor: " + getValor() + "\n" +
                "Tamanho: " + getTamanho() + "\n" +
                "Resolucao: " + getResolucao() + "\n";
    }

    @Override
    public TelevisaoPrototype clonar() {
        return new Televisao(this);
    }
    
    
    
}
