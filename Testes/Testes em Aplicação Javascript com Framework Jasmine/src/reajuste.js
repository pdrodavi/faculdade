function reajuste(salario){

    var salario = document.getElementById("salario").value;
    var salarioAtualizado;
    var aumento;

    if(salario <= 280.00){ // 20%
        aumento = salario / 0.2;
        salarioAtualizado = parseFloat(salario + aumento);
        alert(salarioAtualizado);
        return salarioAtualizado;
    } else if((salario > 280.00) && (salario <= 700.00)){ // 15%
        aumento = salario / 0.15;
        salarioAtualizado = parseFloat(salario + aumento);
        alert(salarioAtualizado);
        return salarioAtualizado;
    } else if((salario > 700.00) && (salario <= 1500.00)){ // 10%
        aumento = salario / 0.10;
        salarioAtualizado = parseFloat(salario + aumento);
        alert(salarioAtualizado);
        return salarioAtualizado;
    } else if(salario > 1500.00){ // 5%
        aumento = salario / 0.05;
        salarioAtualizado = parseFloat(salario + aumento);
        alert(salarioAtualizado);
        return salarioAtualizado;
    } 
}