package padrãostrategy.compadrao.estrategiaspontuacao;

import padrãostrategy.compadrao.interfaces.EstrategiaDePontuacao;

public class EstrategiaPrimeiraClasseDiamante implements EstrategiaDePontuacao {

    @Override
    public int calcularPontuacao(int distanciaDeVoo) {
        return distanciaDeVoo;
    }
    
}
