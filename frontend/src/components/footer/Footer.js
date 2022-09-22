import React from "react"
import { Container, Row, Col } from "reactstrap"
import { Link } from "gatsby"

import "./Footer.css"

export default function Footer() {
  return (
    <footer className="footer-section">
      <Container>
        <Row>
          <Col lg="4">
            <div className="footer-left">
              <div className="footer-logo">
                <Link to="/" className="navbar-brand text-light">
                  <span>e</span>-shop
                </Link>
              </div>
              <ul>
                <li>
                  <i className="fa fa-map-marker"></i> Rosario - Santa Fe - Argentina
                </li>
                <li>
                  <i className="fa fa-phone"></i>{" "}
                  <a href="tel:+341-3383805">+341-3383805</a>
                </li>
                <li>
                  <i className="fa fa-envelope"></i>{" "}
                  <a href="mailto:eshop@gmail.com">
                  eshop@gmail.com
                  </a>
                </li>
              </ul>
              <div className="footer-social">
                <Link to="/">
                  <i className="fa fa-facebook"></i>
                </Link>
                <Link to="/">
                  <i className="fa fa-instagram"></i>
                </Link>
                <Link to="/">
                  <i className="fa fa-twitter"></i>
                </Link>
                <Link to="/">
                  <i className="fa fa-pinterest"></i>
                </Link>
              </div>
            </div>
          </Col>
          <Col lg="4">
            <div className="footer-widget">
              <h5>Mapa del Sitio</h5>
              <ul>
                <li>
                  <Link to="/">Inicio</Link>
                </li>
                <li>
                  <Link to="/">Contacto</Link>
                </li>
                <li>
                  <Link to="/">Mi Carrito</Link>
                </li>
                <li>
                  <Link to="/">Opiniones</Link>
                </li>
              </ul>
            </div>
          </Col>
          <Col lg="4">
            <div className="newslatter-item">
              <h5>Recibi nuestras Ofertas</h5>
              <p>
                Suscribite y enterarte de todas las Novedades.
              </p>
              <form action="#" className="subscribe-form">
                <input type="email" placeholder="Ingresa tu e-mail" />
                <button className="btn">Suscribirte</button>
              </form>
            </div>
          </Col>
        </Row>
      </Container>
      <div className="copyright-reserved">
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="copyright-text">
                Copyright © {new Date().getFullYear()} All rights reserved
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
  )
}
