package padrãostrategy.sempadrao;


import java.util.List;

public class CalcularPontuacao {
    
    Passageiro passageiro;
    
    public int calcularPontuacao(Passageiro passageiro) {
        
        int totalDePontos = 0;
        List<Voo> voosPendentes = passageiro.getVoosComPontuacaoPendente();
        
        for (Voo voo : voosPendentes) {
        Bilhete bilhete = passageiro.getBilhete(voo.getNumero());
        
        if (bilhete.isPrimeiraClasse() && passageiro.isDiamante()) {    
            totalDePontos += voo.getDistancia();  
        } else if (bilhete.isPrimeiraClasse()) {     
            totalDePontos += voo.getDistancia()/2;          
        } else if (bilhete.isClasseEconomica()) { 
            totalDePontos += voo.getDistancia()/4;
        } else {   
           totalDePontos += voo.getDistancia()/10; } 
        }
        
        passageiro.atualizarPontuacao(totalDePontos);
        passageiro.marcarVoosComoProcessados();
        
        return totalDePontos;
    
    }
        
    
}
