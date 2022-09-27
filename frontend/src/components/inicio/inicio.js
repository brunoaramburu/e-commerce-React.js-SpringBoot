import React from 'react';
import './inicio.css'



function Inicio() {
    
  return (
    
    <div className="App">
     
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="#">
			<h1>Registrate</h1>
			
			<span>Elegí un usuario y una contraseña</span>
			<input type="usuario" placeholder="Usuario" />
			<input type="contraseña" placeholder="Contraseña" />
			<button>Registrarme</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="#">
			<h1>Hola!</h1>
			<span>Ingresá tu Usuario y Contraseña</span>
			<input type="usuario" placeholder="Usuario" />
			<input type="contraseña" placeholder="Contraseña" />
			<a href="#">Olvidé mi contraseña</a>
			<button>Enviar</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>Bienvenido!</h1>
				<p>Si ya tenes tu cuenta, ingresa acá</p>
				<button class="ghost" id="signIn">Ingresar</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>Sé parte</h1>
				<p>Creá tu cuenta para poder comprar y vender sin límites</p>
				<button class="ghost" id="signUp">Resgistrarme</button>
			</div>
		</div>
	</div>
</div>


       
    
    </div>
  );
}

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

console.log(signUpButton);

signUpButton && signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton && signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});



export default Inicio;