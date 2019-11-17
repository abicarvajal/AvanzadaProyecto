jQuery.validator.addMethod("noSpace", function(value, element) { 
    return value == '' || value.trim().length != 0;  
}, "El campo no tiene que ir vacio!");

jQuery.validator.addMethod("customEmail", function(value, element) { 
  return this.optional( element ) || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test( value ); 
}, "Ingrese un correo válido!");

$.validator.addMethod( "alphanumeric", function( value, element ) {
return this.optional( element ) || /^\w+$/i.test( value );
}, "Solo letras, números y guiones bajos" );

var $registrationForm = $('#registration');
if($registrationForm.length){
  $registrationForm.validate({
      rules:{
          cedula: {
              required: true
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
              required: true,
              noSpace: true
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
              required: 'Ingrese cedula!'
          },
          email: {
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
              required: 'Ingrese zona!'
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