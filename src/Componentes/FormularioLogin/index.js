import React, { useState } from 'react';
import './FormularioLogin.scss';

function FormularioLogin() {
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const handleSubmit = e => {
        e.preventDefault();
        // lógica de login aqui
    };

    return (
        <div className="login-page">
            <div className="form-login">
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label>E-mail</label>
                        <input
                            type="email"
                            name="email"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Senha</label>
                        <input
                            type="password"
                            name="senha"
                            value={senha}
                            onChange={e => setSenha(e.target.value)}
                            required
                        />
                    </div>
                    <button type="submit">Entrar</button>
                </form>
            </div>
        </div>
    );
}

export default FormularioLogin;