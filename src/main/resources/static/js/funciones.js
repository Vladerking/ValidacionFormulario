function deseleccionaRadios(botonesRadioName) {
    const elementos = document.getElementsByName(botonesRadioName);
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type == "radio") {
            elementos[i].checked = false;
        }
    }
}

function deseleccionarTodos(checkboxName) {
    const elementos = document.getElementById(checkboxName);
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type == "checkbox") {
            elementos[i].checked = false;
        }
    }
}

function mostrarOcultarClave() {
    // Obtener los elementos de los campos de contraseña
    var clave = document.getElementById("clave");
    var confirmarClave = document.getElementById("confirmarClave");

    // Cambiar el tipo de ambos campos
    if (clave.type === "password" && confirmarClave.type === "password") {
        clave.type = "text";  // Cambiar a tipo 'text' para mostrar la clave
        confirmarClave.type = "text";  // Cambiar a tipo 'text' para mostrar la confirmación
    } else {
        clave.type = "password";  // Cambiar a tipo 'password' para ocultar la clave
        confirmarClave.type = "password";  // Cambiar a tipo 'password' para ocultar la confirmación
    }
}


function seleccionarTodosSelect(selectName) {
    const selectElement = document.getElementById(selectName); // Usamos getElementById
    if (selectElement) { // Aseguramos que el elemento realmente existe
        const options = selectElement.options;
        for (let i = 0; i < options.length; i++) {
            options[i].selected = true;
        }
    }
}


function deseleccionarTodosSelect(selectName) {
    const selectElement = document.getElementById(selectName); // Usamos getElementById
    if (selectElement) { // Aseguramos que el elemento realmente existe
        const options = selectElement.options;
        for (let i = 0; i < options.length; i++) {
            options[i].selected = false;
        }
    }
}

function mostrarVentana() {
    alert("prueba");
}

function desCheck() {
    const elementos = document.getElementsByName("aficionesSeleccionadas");
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type == "checkbox") {
            elementos[i].checked = false;
        }
    }
}

function selecCheck() {
    const elementos = document.getElementsByName("aficionesSeleccionadas");
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type == "checkbox") {
            elementos[i].checked = true;
        }
    }
}

function desSelect() {
    const selectElement = document.getElementById("musicasSeleccionadas"); // Usamos getElementById
    if (selectElement) { // Aseguramos que el elemento realmente existe
        const options = selectElement.options;
        for (let i = 0; i < options.length; i++) {
            options[i].selected = false;
        }
    }
}

function selecSelect() {
    const selectElement = document.getElementById("musicasSeleccionadas"); // Usamos getElementById
    if (selectElement) { // Aseguramos que el elemento realmente existe
        const options = selectElement.options;
        for (let i = 0; i < options.length; i++) {
            options[i].selected = true;
        }
    }
}

function confirmaReseteo(nombreFormulario) {
    var mensaje = "Pulsa Aceptar para establecer el valor por defecto de los campos del formulario. Pulsa Cancelar para abortar esta operación.";
    if (confirm(mensaje)) { // si se pulsa Aceptar
        // se resetea el formulario
        document.getElementById(nombreFormulario).reset();
    }
}

function confirmaBorrado() {
    // Confirmación antes de borrar
    if (confirm("¿Estás seguro de que deseas borrar todo el contenido del formulario?")) {
        const formulario = document.getElementById('formulario');  // Selecciona el formulario
        const elementos = formulario.elements;  // Obtiene todos los elementos dentro del formulario

        // Recorremos los elementos del formulario
        for (let i = 0; i < elementos.length; i++) {
            const elemento = elementos[i];

            // Para los campos de texto, contraseñas y área de texto
            if (elemento.type === "text" || elemento.type === "password" || elemento.type === "textarea") {
                elemento.value = "";  // Borra el valor
            }// Para los checkboxes y radios
            else if (elemento.type === "checkbox" || elemento.type === "radio") {
                elemento.checked = false;  // Desmarca los checkboxes y radios
            }// Para los selects
            else if (elemento.type === "select-one" || elemento.type === "select-multiple") {
                for (let j = 0; j < elemento.options.length; j++) {
                    elemento.options[j].selected = false;  // Deselecciona todas las opciones
                }
            }
           /* desSelect();
            desCheck();*/
        }
    }

}

function confirmaEnvio(nombreFormulario) {
    var mensaje = "Pulsa Aceptar para enviar el formulario. Pulsa Cancelar para abortar esta operación.";
    if (confirm(mensaje)) { // si se pulsa Aceptar
        // se resetea el formulario
        document.getElementById(nombreFormulario).submit();
    }
}

$(document).ready(function() {
    $("#idioma").change(function () {
        var selectedOption = $('#idioma').val();
        if (selectedOption != ''){
            window.location.replace('devuelve-formulario?lang=' + selectedOption);
        }
    });
});






