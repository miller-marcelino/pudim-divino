import React from 'react';
import './Menu.scss';
import { Link } from 'react-router-dom';

function Menu () {
    return (
        <nav className="menu">
            <ul>
                <li><Link to="/">Início</Link></li>
                <li><Link to="/contato">Contato</Link></li>
                <li><Link to="/cadastro">Cadastro</Link></li>
                <li><Link to="/produtos">Produtos</Link></li>   
                <li><Link to="/sobre">Sobre</Link></li>
                <li><Link to="/telalogin">Entrar</Link></li>
            </ul>
        </nav>
    )
}

export default Menu;