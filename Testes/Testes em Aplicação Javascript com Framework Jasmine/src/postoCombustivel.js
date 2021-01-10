function precoCombustivel(combustivel, litros){
    
    var combustivel = document.getElementById("combustivel").value;
    var litros = document.getElementById("litros").value;

    var i, desconto, valor, valorTotal;

    // -- ALCOOL -- //
    // abaixo de 20 litros
    if((combustivel === "A") && (litros < 20)){
        valor = litros * 3.20;
        desconto = litros * 0.096;
        valorTotal = valor - desconto;
        return valorTotal; 
    }

    // acima de 20 litros
    if((combustivel === "A") && (litros > 20)){
        valor = litros * 3.20;
        desconto = litros * 0.16;
        valorTotal = valor - desconto;
        return valorTotal;
    }

    // -- GASOLINA -- //
    // abaixo de 20 litros
    if((combustivel === "G") && (litros < 20)){
        valor = litros * 3.70;
        desconto = litros * 0.148;
        valorTotal = valor - desconto;
        return valorTotal;
    }

    // acima de 20 litros
    if((combustivel === "G") && (litros > 20)){
        valor = litros * 3.70;
        desconto = litros * 0.222;
        valorTotal = valor - desconto;
        return valorTotal; 
    }
}