function verificaTriangulo(l1, l2, l3){

    var l1 = document.getElementById("l1").value;
    var l2 = document.getElementById("l2").value;
    var l3 = document.getElementById("l3").value;

    if((l1 < l2 + l3) && (l2 < l1 + l3) && (l3 < l1 + l2)){

        if((l1 === l2) && (l2 === l3) && (l1 === l3)){
            alert("Equilátero");
            return "Equilátero";
        } else if((l1 === l2) || (l2 === l3) || (l1 === l3)){
            alert("Isóceles");
            return "Isóceles";
        } else {
            alert("Escaleno");
            return "Escaleno";
        }
    
    }
}