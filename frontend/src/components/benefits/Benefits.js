import React from "react"
import { Row, Col } from "reactstrap"

import "./Benefits.css"

export default function Benefits() {
  return (
    <div className="benefit-items mx-3">
      <Row>
        <Col md="4">
          <div className="single-benefit">
            <div className="sb-icon">
              <img src={require("../../images/icons/icon-1.png")} alt="" />
            </div>
            <div className="sb-text">
              <h6>Envios Gratis</h6>
              <p>En todo el país</p>
            </div>
          </div>
        </Col>
        <Col md="4">
          <div className="single-benefit">
            <div className="sb-icon">
              <img src={require("../../images/icons/icon-2.png")} alt="" />
            </div>
            <div className="sb-text">
              <h6>Compra y vende</h6>
              <p>Optimiza tu tiempo</p>
            </div>
          </div>
        </Col>
        <Col md="4">
          <div className="single-benefit">
            <div className="sb-icon">
              <img src={require("../../images/icons/icon-3.png")} alt="" />
            </div>
            <div className="sb-text">
              <h6>medios de pago</h6>
              <p>Mercado Pago</p>
            </div>
          </div>
        </Col>
      </Row>
    </div>
  )
}
