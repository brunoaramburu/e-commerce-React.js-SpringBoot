import React from "react"
import Layout from "../components/layout/Layout"
import SEO from "../components/seo/Seo"
import "bootstrap/dist/css/bootstrap.min.css"
import "font-awesome/css/font-awesome.min.css"
import HomeCarousel from "../components/carousel/HomeCarousel"
import Products from "../components/productsSection/Products"
import Benefits from "../components/benefits/Benefits"
import Recommended from "../components/recommendationSector/Recommended"
import Categories from "../components/categorySection/Categories"
import ProductCard from "../components/productCard/ProductCard"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Inicio from "../components/inicio/inicio"





function IndexPage() {
  return (
    
              
        <Inicio />
                      
                 
          
  );
}

export default IndexPage;
