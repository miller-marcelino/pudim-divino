import Menu from "../../Componentes/Menu";
import Rodape from "../../Componentes/Rodape";
import FormularioLogin from "../../Componentes/FormularioLogin";
import './TelaLogin.scss';

function TelaLogin() {
    return (
        <div className="login-layout">
            <Menu />
            <div className="login-page">
                <FormularioLogin />
            </div>
            <Rodape />
        </div>
    )
}

export default TelaLogin
