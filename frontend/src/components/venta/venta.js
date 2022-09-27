import { VerticalAlignTopSharp } from "@material-ui/icons"
import React from "react";
import venta from './venta.css'
function Venta() {
    
    var formulario = document.formulario_registro,
    elementos = formulario.elements;

  // Funcion que se ejecuta cuando el evento click es activado

  var validarInputs = function() {
    for (var i = 0; i < elementos.length; i++) {
      // Identificamos si el elemento es de tipo texto, email, password, radio o checkbox
      if (elementos[i].type == "text" || elementos[i].type == "email" || elementos[i].type == "text2") {
        // Si es tipo texto, email o password vamos a comprobar que esten completados los input
        if (elementos[i].value.length == 0) {
          console.log('El campo ' + elementos[i].name + ' esta incompleto');
          elementos[i].className = elementos[i].className + " error";
          return false;
        } else {
          elementos[i].className = elementos[i].className.replace(" error", "");
        }
      }
    }

    return true;
  };

  var validarRadios = function() {
    var opciones = document.getElementsByName('sexo'),
      resultado = false;

    for (var i = 0; i < elementos.length; i++) {
      if (elementos[i].type == "radio" && elementos[i].name == "sexo") {
        // Recorremos los radio button
        for (var o = 0; o < opciones.length; o++) {
          if (opciones[o].checked) {
            resultado = true;
            break;
          }
        }

        if (resultado == false) {
          elementos[i].parentNode.className = elementos[i].parentNode.className + " error";
          console.log('El campo sexo esta incompleto');
          return false;
        } else {
          // Eliminamos la clase Error del radio button
          elementos[i].parentNode.className = elementos[i].parentNode.className.replace(" error", "");
          return true;
        }
      }
    }
  };


  var enviar = function(e) {
    if (!validarInputs()) {
      console.log('Falto validar los Input');
      e.preventDefault();
    } else if (!validarRadios()) {
      console.log('Falto validar los Radio Button');
      e.preventDefault();
    } else {
      console.log('Envia');
      e.preventDefault();
    }
  };

  var focusInput = function() {
    this.parentElement.children[1].className = "label active";
    this.parentElement.children[0].className = this.parentElement.children[0].className.replace("error", "");
  };

  var blurInput = function() {
    if (this.value <= 0) {
      this.parentElement.children[1].className = "label";
      this.parentElement.children[0].className = this.parentElement.children[0].className + " error";
    }
  };

  // --- Eventos ---
  formulario.addEventListener("submit", enviar);

  for (var i = 0; i < elementos.length; i++) {
    if (elementos[i].type == "text" || elementos[i].type == "email" || elementos[i].type == "text2") {
      elementos[i].addEventListener("focus", focusInput);
      elementos[i].addEventListener("blur", blurInput);
    }
  }


    return (
        <div class="contenedor-formulario">
    <div class="wrap">
        <form action="" class="formulario" name="formulario_registro" method="post">
        <div>
            <div class="input-group">
                <input type="text" id="nombre" name="nombre"/>
                <label class="label" for="nombre">Name</label>
            </div>

            <div class="input-group">
                <input type="email" id="email" name="email"/>
                <label class="label" for="email">Email</label>
            </div>

            <div class="input-group">
                <input type="text" id="text2" name="text2"/>
                <label class="label" for="text2">Write your message</label>
            </div>

            <div class="input-group radio">
                <input type="radio" name="sexo" id="hombre"/>
                <label class="label" for="hombre">Man</label>
                <input type="radio" name="sexo" id="mujer"/>
                <label class="label" for="mujer">Woman</label>
            </div>


            <input type="submit" name="btn-submit" value="Send"/>

        </div>
    </form>
    </div>


</div>
    )};
    export default Venta;