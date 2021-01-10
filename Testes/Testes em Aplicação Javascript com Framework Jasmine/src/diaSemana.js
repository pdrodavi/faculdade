function diaSemana(numero){
    
    var numero = document.getElementById("dia").value;
    
    if(numero === '1'){
        alert("Domingo")
        return "Domingo"
    }else if(numero === '2'){
        alert("Segunda")
        return "Segunda"
    }else if(numero === '3'){
        alert("Terça")
        return "Terça"
    }else if(numero === '4'){
        alert("Quarta")
        return "Quarta"
    }else if(numero === '5'){
        alert("Quinta")
        return "Quinta"
    }else if(numero === '6'){
        alert("Sexta")
        return "Sexta"
    }else if(numero === '7'){
        alert("Sábado")
        return "Sábado"
    }else{
        alert("Não existe esse dia na semana")
        return "Inválido"
    } 
    
}