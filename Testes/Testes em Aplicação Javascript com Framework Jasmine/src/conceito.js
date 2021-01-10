function conceito(n1, n2){

    var n1 = document.getElementById("nota1").value;
    var n2 = document.getElementById("nota2").value;
    var soma;
    var media;

    soma = parseFloat(n1) + parseFloat(n2);
    media = soma/2;

    if((media >= 9) && (media <= 10)){
        alert("Conceito A");
        return "A";
    } else if((media >= 7.5) && (media <= 8.9)){
        alert("Conceito B");
        return "B";
    } else{
        alert("Conceito C");
        return "C";
    }
}