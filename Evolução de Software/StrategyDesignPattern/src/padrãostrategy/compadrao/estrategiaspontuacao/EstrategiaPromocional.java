package padrãostrategy.compadrao.estrategiaspontuacao;

import padrãostrategy.compadrao.interfaces.EstrategiaDePontuacao;

public class EstrategiaPromocional implements EstrategiaDePontuacao{

    @Override
    public int calcularPontuacao(int distanciaDeVoo) {
       return distanciaDeVoo/10;
    }
    
}
