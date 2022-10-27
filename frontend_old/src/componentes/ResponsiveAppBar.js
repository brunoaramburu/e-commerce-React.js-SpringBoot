import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function ResponsiveAppBar() {
  return (
    <>
      
      <Navbar bg="primary" variant="dark">
        <Container>
          <Navbar.Brand href="/">Inicio</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Comprar</Nav.Link>
            <Nav.Link href="#features">Vender</Nav.Link>
            <Nav.Link href="/inicio">Ingresar</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      
    </>
  );
}

export default ResponsiveAppBar;