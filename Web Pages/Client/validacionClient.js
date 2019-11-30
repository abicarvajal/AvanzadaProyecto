jQuery.validator.addMethod("noSpace", function(value, element) { 
    return value == '' || value.trim().length != 0;  
}, "El campo no tiene que ir vacio!");

jQuery.validator.addMethod("customEmail", function(value, element) { 
  return this.optional( element ) || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test( value ); 
}, "Ingrese un correo válido!");

$.validator.addMethod( "alphanumeric", function( value, element ) {
return this.optional( element ) || /^\w+$/i.test( value );
}, "Solo letras, números y guiones bajos" );

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
}, "Cédula invalida"); 

var $registrationForm = $('#registration');
if($registrationForm.length){
  $registrationForm.validate({
      rules:{
          cedula: {
              required: true,
              validaCI:true
          },
          correo: {
              required: true,
              customEmail: true
          },
          nombre: {
              required: true
          },
          telefono: {
              required: true,
              noSpace:true
          },
          ciudad: {
              required: true,
              noSpace: true
          },
          zona: {
              required: true
          },
          callep: {
              required: true
          },
          calles: {
              required: true
          },
          lote: {
              required: true
          }
      },
      messages:{
          cedula: {
              required: 'Ingrese cedula'
          },
          correo: {
              required: 'Ingrese correo',
              email: 'Ingrese un correo válido'
          },
          nombre: {
              required: 'Ingrese el nombre!'
          },
          telefono: {
              required: 'Ingrese telefono!',
          },
          ciudad: {
              required: 'Ingrese ciudad!'
          },
          zona: {
              required: 'Elija una zona!'
          },
          callep: {
              required: 'Ingrese calle principal!'
          },
          calles: {
              required: 'Ingrese calle secundaria!'
          },
          lote: {
            required: 'Ingrese lote!'
        }
      }
  });
}