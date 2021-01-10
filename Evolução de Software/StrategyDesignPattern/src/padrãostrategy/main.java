package padrãostrategy;

import padrãostrategy.compadrao.estrategiaspontuacao.EstrategiaClasseEconomica;
import padrãostrategy.compadrao.estrategiaspontuacao.EstrategiaPrimeiraClasse;
import padrãostrategy.compadrao.estrategiaspontuacao.EstrategiaPrimeiraClasseDiamante;
import padrãostrategy.compadrao.estrategiaspontuacao.EstrategiaPromocional;
import padrãostrategy.sempadrao.CalcularPontuacao;

public class main {


    public static void main(String[] args) {
        
        //sem padrão
        CalcularPontuacao calc = new CalcularPontuacao();
        calc.calcularPontuacao(args);
        
        //com padrão
        EstrategiaClasseEconomica economica = new EstrategiaClasseEconomica();
        economica.calcularPontuacao(0);
        
        EstrategiaPrimeiraClasse primeiraclasse = new EstrategiaPrimeiraClasse();
        primeiraclasse.calcularPontuacao(0);
        
        EstrategiaPrimeiraClasseDiamante diamante = new EstrategiaPrimeiraClasseDiamante();
        diamante.calcularPontuacao(0);
        
        EstrategiaPromocional promocional = new EstrategiaPromocional();
        promocional.calcularPontuacao(0);
    }
    
}
