jQuery.validator.addMethod("noSpace", function(value, element) { 
    return value == '' || value.trim().length != 0;  
}, "El campo no tiene que ir vacio!");

$.validator.addMethod( "alphanumeric", function( value, element ) {
return this.optional( element ) || /^\w+$/i.test( value );
}, "Solo letras, números y guiones bajos" );

jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-zA-Z ]+$/i.test(value);
  }, "Solo letras");


jQuery.validator.addMethod("validaCI", function(value, element){
        if (value != "") {
            var i;
            var cedula;
            var acumulado;
            cedula = value;
            var instancia;
            acumulado = 0;
            for (i = 1; i <= 9; i++) {
                if (i % 2 != 0) {
                    instancia = cedula.substring(i - 1, i) * 2;
                    if (instancia > 9) instancia -= 9;
                } else instancia = cedula.substring(i - 1, i);
                acumulado += parseInt(instancia);
            }
            while (acumulado > 0)
                acumulado -= 10;
            if (cedula.substring(9, 10) != (acumulado * -1)) {
                //alert("Cédula incorrecta");
                return value = "";
            }
            else{
                return(element);
            }
        }
}, "Cedula invalida"); 

var $registrationForm = $('#form_datos');
if($registrationForm.length){
  $registrationForm.validate({
      rules:{
        numGuia:{
            required: true,
            noSpace:true
        },
          cedula: {
              required: true,
              validaCI:true
          },
          cedulaT: {
              required: true,
              validaCI:true
          },
          codigoP: {
              required: true,
              noSpace:true
          },
          codigoZ: {
            required: true,
            noSpace:true
        },
          direccion: {
              required: true,
              lettersonly:true
          },
          destino: {
            required: true,
            lettersonly:true
        },
          numero: {
              required: true,
              noSpace: true
          },
          valor: {
              required: true,
              noSpace: true
          }
      },
      messages:{
          cedula: {
              required: 'Ingrese cedula '
          },
          cedulaT: {
            required: 'Ingrese cedula '
        },
          codigoP: {
              required: 'Ingrese codigo de producto',
          },
          codigoZ: {
            required: 'Ingrese codigo de zona',
        },
          direccion: {
              required: 'Ingrese direccion!'
          },
         
          destino: {
              required: 'Ingrese destino!'
          },
          numero: {
              required: 'Ingrese numero!'
          },
          valor: {
              required: 'Ingrese un valor!'
          }
          
      }
  });
}