import React from 'react';
import Menu from "../../Componentes/Menu";
import Rodape from "../../Componentes/Rodape";
import familiaImg from "../../imagens/familiapudimdivino.jpeg";

function Sobre () {
    return (
        <>
            <Menu />
            <div className="container my-4">
                <div className="row">
                    <div className="col-md-8 mx-auto">
                        <img src={familiaImg} alt="Família Pudim Divino" className="img-fluid w-50 mx-auto d-block" />
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-8 mx-auto">
                        <p className="mt-4 text-justify">
                            Fundada por uma família apaixonada pelo sabor genuíno do pudim caseiro, a Pudim Divino une tradição e devoção em cada receita. Utilizamos ingredientes selecionados e prática artesanal para criar sobremesas que aquecem o coração e celebram nossa fé em Nossa Senhora de Fátima. Venha descobrir o prazer de saborear um doce preparado com carinho e fé, e faça parte dessa história doce e inspiradora!
                        </p>
                    </div>
                </div>
            </div>
            <Rodape />
        </>
    )
}

export default Sobre;