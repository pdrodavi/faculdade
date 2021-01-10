package padrãostrategy.compadrao.estrategiaspontuacao;

import padrãostrategy.compadrao.interfaces.EstrategiaDePontuacao;

public class EstrategiaClasseEconomica implements EstrategiaDePontuacao {

    @Override
    public int calcularPontuacao(int distanciaDeVoo) {
       return distanciaDeVoo/4;
    }
    
}
