import React from 'react';
import Menu from "../../Componentes/Menu";
import Rodape from "../../Componentes/Rodape";
import { FaInstagram, FaWhatsapp } from 'react-icons/fa';
import { SiIfood } from 'react-icons/si';

function Contato () {
    return (
        <>
            <div className="d-flex flex-column min-vh-100" style={{ backgroundColor: '#fff5f8' }}>
                <Menu />
                <div className="flex-grow-1 d-flex align-items-center justify-content-center py-5">
                    <div className="container">
                        <div className="row justify-content-center">
                            <div className="col-md-8">
                                <div className="list-group">
                                    <a href="https://www.instagram.com/pudimdivino_/" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <FaInstagram size={24} className="me-2" /> Instagram
                                    </a>
                                    <a href="https://www.ifood.com.br/delivery/paulista-pe/pudim-divino---north-way-shopping-centro/6ad325b4-6e03-4734-a851-6a2cbfeb560a?utm_medium=share" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <SiIfood size={24} className="me-2" /> iFood - Paulista North Way Shopping
                                    </a>
                                    <a href="https://www.ifood.com.br/delivery/paulista-pe/pudim-divino---jardim-paulista-jardim-paulista/46a90d0e-721d-458b-96e9-16f9ed64aaf2?utm_medium=share" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <SiIfood size={24} className="me-2" /> iFood - Jardim Paulista Baixo
                                    </a>
                                    <a href="https://www.ifood.com.br/delivery/olinda-pe/pudim-divino---olinda-casa-caiada/a7a8f776-dd7e-4219-8d57-fdcc209dd6f1?utm_medium=share" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <SiIfood size={24} className="me-2" /> iFood - Mix Mateus Olinda
                                    </a>
                                    <a href="https://api.whatsapp.com/send/?phone=558189456196&text=Oi%21+Cheguei+pelo+link+da+bio+do+instagram.&type=phone_number&app_absent=0" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <FaWhatsapp size={24} className="me-2" /> WhatsApp - RioMar Shopping Recife
                                    </a>
                                    <a href="https://api.whatsapp.com/send/?phone=5581996790720&text=Oi%21+Cheguei+pelo+link+da+bio+do+instagram.&type=phone_number&app_absent=0" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <FaWhatsapp size={24} className="me-2" /> WhatsApp - Paulista North Way Shopping
                                    </a>
                                    <a href="https://api.whatsapp.com/send/?phone=5581989456361&text=Oi%21+Cheguei+pelo+link+da+bio+do+instagram&type=phone_number&app_absent=0" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <FaWhatsapp size={24} className="me-2" /> WhatsApp - Jardim Paulista Baixo
                                    </a>
                                    <a href="https://api.whatsapp.com/send/?phone=5581989456340&text=Oi%21+Cheguei+pelo+link+da+bio+do+instagram&type=phone_number&app_absent=0" target="_blank" rel="noopener noreferrer" className="list-group-item list-group-item-action d-flex align-items-center" style={{ backgroundColor: 'rgb(162,45,112)', color: '#fff' }}>
                                        <FaWhatsapp size={24} className="me-2" /> WhatsApp - Mix Mateus Olinda
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <Rodape />
            </div>
        </>
    )
}

export default Contato;