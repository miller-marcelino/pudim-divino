import './App.scss';
import Home from './Paginas/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Cadastro from './Paginas/Cadastro';
import Contato from './Paginas/Contato';
import Sobre from './Paginas/Sobre';
import TelaLogin from './Paginas/Login';
import Produtos from './Paginas/Produtos';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/contato" element={<Contato />} />
        <Route path="/sobre" element={<Sobre />} />
        <Route path="/produtos" element={<Produtos />} />
        <Route path="/telalogin" element={<TelaLogin />} />
      </Routes>
    </Router>
  );
}

export default App;
