
jQuery.validator.addMethod("lettersonly", function(value, element) {
    return this.optional(element) || /^[a-zA-Z ]+$/i.test(value);
  }, "Solo letras");


var $registrationForm = $('#location-form');
if($registrationForm.length){
  $registrationForm.validate({
      rules:{
          direccion: {
              required: true,
              lettersonly:true
          }
      },
      messages:{
          
          direccion: {
              required: 'Ingrese direccion!'
          }
          
      }
  });
}