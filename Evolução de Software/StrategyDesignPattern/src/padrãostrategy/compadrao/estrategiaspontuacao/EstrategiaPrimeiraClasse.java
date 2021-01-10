package padrãostrategy.compadrao.estrategiaspontuacao;

import padrãostrategy.compadrao.interfaces.EstrategiaDePontuacao;

public class EstrategiaPrimeiraClasse implements EstrategiaDePontuacao {

    @Override
    public int calcularPontuacao(int distanciaDeVoo) {
       return distanciaDeVoo/2;
    }
    
}
