var nombre = document.getElementById("nombrelg");
var password = document.getElementById("passwordlg");
var error = document.getElementById("error");
error.style.color = "red";


function enviarFormulario(){
    console.log("Enviando formulario...");
    
    var mensajeError = [];

    if(nombre.value === null || nombre.value === ""){
        mensajeError.push("Ingresa tu nombre");
    }
    else if(nombre.value !== "ivan"){
        mensajeError.push("Usuario no registrado");
    }


    if(password.value === null || password.value === ""){
        mensajeError.push("Ingresa tu password");
    }

    else if(password.value !== "1234"){
        mensajeError.push("Password incorrecto");
    }   
    
    error.innerHTML = mensajeError.join(", ");



    return false;
}