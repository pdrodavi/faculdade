function converterTempo(celsius, fahrenheit, kelvin){

    var c = celsius;
    var f = fahrenheit;
    var k = kelvin;

    this.fahrenheitToCelsius = function(){
		return ((c - 32) * 5/9); 
	}

	this.CelsiusToFahrenheit = function(){
		return ((f + 459.67) * 5/9);   
	}

	this.kelvinToCelsius = function(){
		return (k - 273.15);   
	}

	this.celsiusToKelvin = function(){
		return (5/9 * (c - 32) + 273.15 );   
	}

}