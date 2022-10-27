import React from 'react';
import './Home.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'jquery/dist/jquery.min.js';
import $ from 'jquery';
class Home extends React.Component {
  componentDidMount(){
   //animation code
    $(document).ready(function(){
        $('.login-info-box').fadeOut();
        $('.login-show').addClass('show-log-panel');
    
    
    
    $('input[type="radio"]').on('change',function() {
       
    
        if($('#log-reg-show').is(':checked')) {
            $('.register-info-box').fadeIn();
            $('.login-info-box').fadeOut();
            
            $('.white-panel').removeClass('right-log');
            
            $('.login-show').addClass('show-log-panel');
            $('.register-show').removeClass('show-log-panel');
        }
        if($('#log-login-show').is(':checked')) {
            $('.register-info-box').fadeOut(); 
            $('.login-info-box').fadeIn();
            
            $('.white-panel').addClass('right-log');
            $('.register-show').addClass('show-log-panel');
            $('.login-show').removeClass('show-log-panel');
            
        }
    });
});
  }
 
  render() {
   
    return (
     
      
       <div class="login-reg-panel">
        
            <div class="login-info-box">
                
                <h2>Ya tenes una cuenta?</h2>
                <p>Ingresa para difrutar de todos los beneficios</p>
                <label id="label-register" for="log-reg-show">Ingresar</label>
                <input type="radio" name="active-log-panel" id="log-reg-show" value="log-reg-show" />
            </div>
                        
            <div class="register-info-box">
                <h2>No tenes una cuenta?</h2>
                <p>Registrate para disfrutar de todos los beneficios</p>
                <label id="label-login" for="log-login-show">Registrate</label>
                <input type="radio" name="active-log-panel" value="log-login-show" id="log-login-show" />
            </div>
                        
            <div class="white-panel">
                <div class="login-show">
                <h2>INGRESAR</h2>
                <input type="text" placeholder="Email" />
                <input type="password" placeholder="Contraseña" />
                <input type="button" value="Ingresar" />
                
                </div>
                <div class="register-show">
                <h2>CREAR CUENTA</h2>
                <input type="text" placeholder="Email" />
                <input type="password" placeholder="Contraseña" />
                <input type="password" placeholder="Confirme su Contraseña" />
                <input type="button" value="Registrate" />
                </div>
            </div>
            </div>
         
       
     
      
)
};
}
export default Home;