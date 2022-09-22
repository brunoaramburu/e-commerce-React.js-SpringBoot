import React from "react"
import { Container, Row, Col } from "reactstrap"

import "./Categories.css"
export default function Categories() {
  return (
    <div className="banner-section">
      <Container fluid>
        <Row>
          <Col lg="4">
            <div className="single-banner">
              <img src={require("../../images/banner-1.jpg")} alt="" />
              <div className="inner-text">
                <h4>ElectroHogar</h4>
              </div>
            </div>
          </Col>
          <Col lg="4">
            <div className="single-banner">
              <img src={require("../../images/banner-2.jpg")} alt="" />
              <div className="inner-text">
                <h4>Telefonía</h4>
              </div>
            </div>
          </Col>
          <Col lg="4">
            <div className="single-banner">
              <img src={require("../../images/banner-3.jpg")} alt="" />
              <div className="inner-text">
                <h4>Informática</h4>
              </div>
            </div>
          </Col>
          <Col lg="4">
            <div className="single-banner">
              <img src={require("../../images/banner-4.jpg")} alt="" />
              <div className="inner-text">
                <h4>Climatización</h4>
              </div>
            </div>
          </Col>
          <Col lg="4">
            <div className="single-banner">
              <img src={require("../../images/banner-5.jpg")} alt="" />
              <div className="inner-text">
                <h4>Audio-Tv-Video</h4>
              </div>
            </div>
          </Col>
          <Col lg="4">
            <div className="single-banner">
              <img src={require("../../images/banner-6.jpg")} alt="" />
              <div className="inner-text">
                <h4>Deco y Jardín</h4>
              </div>
            </div>
          </Col>
        </Row>
      </Container>
    </div>
  )
}
