import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import HeaderComponente from './componentes/HeaderComponente';
import ResponsiveAppBar from './componentes/ResponsiveAppBar'
import FooterComponente from './componentes/FooterComponente';
import CrearProductoComponente from './componentes/CrearProductoComponente';
import ListarProductosComponente from './componentes/ListarProductosComponente';
import ActualizarProductoComponente from './componentes/ActualizarProductoComponente';
import VerProductoComponente from './componentes/VerProductoComponente';
import Product from './componentes/Product';
import Home from './componentes/Login/Home'
import Principal from './componentes/Principal/Principal';
function App() {
  return (
    <div>
        <Router>
        <ResponsiveAppBar />
                <div className="container">
                    <Routes> 
                          <Route path="/inicio" element = {<Home></Home>}></Route>
                          <Route path = "/" exact element={<ListarProductosComponente></ListarProductosComponente>}></Route>
                          <Route path = "/productos" element = {<ListarProductosComponente></ListarProductosComponente>}></Route>
                          <Route path = "/crear-producto/:id" element = {<CrearProductoComponente></CrearProductoComponente>}></Route>
                          <Route path = "/ver-producto/:id" element = {<VerProductoComponente></VerProductoComponente>}></Route>
                          <Route path = "/actualizar-producto/:id" element = {<ActualizarProductoComponente></ActualizarProductoComponente>}></Route>
                    </Routes>
                </div>
        </Router>
    </div>
    
  );
}

export default App;