import React, { useState } from 'react';
import './FormularioCadastro.scss';

function FormularioCadastro() {
    const [temSabor, setTemSabor] = useState(null);
    const [nome, setNome] = useState('');
    const [sobrenome, setSobrenome] = useState('');
    const [bairro, setBairro] = useState('');
    const [cidade, setCidade] = useState('');
    const [cep, setCep] = useState('');
    const [rua, setRua] = useState('');
    const [whatsapp, setWhatsapp] = useState('');

    const handleSaborChange = (e) => {
        setTemSabor(e.target.value === 'sim');
    };

    const handleCepChange = e => {
        setCep(e.target.value.replace(/\D/g, ''));
    };

    const handleCepBlur = async () => {
        if (cep.length === 8) {
            try {
                const res = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
                const data = await res.json();
                if (!data.erro) {
                    setRua(data.logradouro || '');
                    setBairro(data.bairro || '');
                    setCidade(data.localidade || '');
                }
            } catch (err) {
                console.error(err);
            }
        }
    };

    const formatWhatsapp = (value) => {
        const digits = value.replace(/\D/g, '').slice(0, 11);
        if (digits.length <= 2) {
            return '(' + digits;
        }
        return '(' + digits.slice(0, 2) + ')' + digits.slice(2);
    };

    return (
        <div className="form-cadastro">
            <form>
                <div className="form-group">
                    <label>Nome</label>
                    <input type="text" name="nome" value={nome} onChange={e => setNome(e.target.value.replace(/\d/g, ''))} pattern="[A-Za-zÀ-ÖØ-öø-ÿ ]+" title="Use apenas letras" />
                </div>
                <div className="form-group">
                    <label>Sobrenome</label>
                    <input type="text" name="sobrenome" value={sobrenome} onChange={e => setSobrenome(e.target.value.replace(/\d/g, ''))} pattern="[A-Za-zÀ-ÖØ-öø-ÿ ]+" title="Use apenas letras" />
                </div>
                <div className="form-group">
                    <label>CEP</label>
                    <input type="text" name="cep" value={cep} onChange={handleCepChange} onBlur={handleCepBlur} inputMode="numeric" pattern="\d*" maxLength={8} title="Apenas números" />
                </div>
                <div className="form-group">
                    <label>Rua</label>
                    <input type="text" name="rua" value={rua} onChange={e => setRua(e.target.value)} />
                </div>
                <div className="form-group">
                    <label>Número</label>
                    <input type="text" name="numero" />
                </div>
                <div className="form-group">
                    <label>Complemento</label>
                    <input type="text" name="complemento" />
                </div>
                <div className="form-group">
                    <label>Bairro</label>
                    <input type="text" name="bairro" value={bairro} onChange={e => setBairro(e.target.value.replace(/\d/g, ''))} />
                </div>
                <div className="form-group">
                    <label>Cidade</label>
                    <input type="text" name="cidade" value={cidade} onChange={e => setCidade(e.target.value.replace(/\d/g, ''))} />
                </div>
                <div className="form-group">
                    <label>WhatsApp</label>
                    <input
                        type="text"
                        name="whatsapp"
                        value={whatsapp}
                        onChange={e => setWhatsapp(formatWhatsapp(e.target.value))}
                        inputMode="numeric"
                        maxLength={13}
                        pattern="[\d()]*"
                        title="Apenas números (até 11 dígitos)"
                    />
                </div>
                <div className="form-group">
                    <label>E-mail</label>
                    <input type="email" name="email" />
                </div>
                <div className="form-group">
                    <label>Tem sabor de pudim favorito?</label>
                    <div className="radio-group">
                        <label>
                            <input type="radio" name="temSabor" value="sim" onChange={handleSaborChange} /> Sim
                        </label>
                        <label>
                            <input type="radio" name="temSabor" value="nao" onChange={handleSaborChange} /> Não
                        </label>
                    </div>
                </div>
                {temSabor && (
                    <div className="form-group">
                        <label>Sabor de pudim favorito</label>
                        <select name="sabor">
                            <option value="">Selecione...</option>
                            <option value="tradicional">Tradicional</option>
                            <option value="chocolate">Chocolate</option>
                            <option value="coco">Coco</option>
                            <option value="leite-condensado">Leite Condensado</option>
                        </select>
                    </div>
                )}
                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
}

export default FormularioCadastro;