import Card from "../../Componentes/Card";
import Menu from "../../Componentes/Menu";
import Rodape from "../../Componentes/Rodape";

function Produtos() {
    return (
        <>
            <Menu />
            <br></br>
            <div className="container">
                <div className="row">

                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 1" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 2" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 3" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 4" />
                </div>
                <div className="row mt-3">
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 5" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 6" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 7" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 8" />
                </div>
                <div className="row mt-3">
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 9" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 10" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 11" />
                    <Card foto="imagem_pudim1.jpeg" legenda="Pudim 12" />
                </div>
            </div>
            <Rodape />
        </>
    )
}   

export default Produtos;