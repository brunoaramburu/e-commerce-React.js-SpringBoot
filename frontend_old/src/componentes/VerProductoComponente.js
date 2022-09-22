import ProductosServicio from '../servicios/ProductosServicio'
import React, { useState, useEffect } from 'react';
import {useParams} from 'react-router-dom';

function VerProductoComponente () {

    const {id} = useParams()
    const [producto, setProducto] = useState([])
  
    const fetchProducto = () => {
        ProductosServicio.httpGet(`/${id}`)
            .then((res) => setProducto(res.data))
    }

    useEffect(fetchProducto, [])

    return (
        <div>
            <br></br>
            <div className = "card col-md-6 offset-md-3">
                <h3 className = "text-center"> Ver detalles del Producto</h3>
                <div className = "card-body">
                    <div className = "row">
                        <label> Nombre: </label>
                        <div> { producto.nombres }</div>
                    </div>
                    <div className = "row">
                        <label> Precio: </label>
                        <div> { producto.precio }</div>
                    </div>
                    <div className = "row">
                        <label> Stock: </label>
                        <div> { producto.stock }</div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default VerProductoComponente