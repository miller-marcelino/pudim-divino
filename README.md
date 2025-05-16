# Pudim Divino

Projeto web desenvolvido em React para o site **Pudim Divino**, uma plataforma interativa que oferece cadastro de usuários, exibição de produtos, contato com redes sociais e um carrossel de vídeos. O projeto é focado na experiência do usuário e usabilidade, com design responsivo e integração com APIs externas.

---

## 📋 Sobre o Projeto

Este projeto utiliza React.js com componentes funcionais, Bootstrap 5 para estilização e funcionalidades como carrossel e formulários controlados. O site permite:

- Navegação via menu com React Router.
- Cadastro de usuários com validação de campos e busca automática de endereço via API ViaCEP.
- Página de contato com links para redes sociais e WhatsApp.
- Exibição de produtos e conteúdos multimídia com carrossel de vídeos do YouTube.
- Formulário de login simples.

---

## 🛠 Tecnologias Utilizadas

- React.js (com Hooks)
- Bootstrap 5
- React Router DOM
- API ViaCEP para busca de endereço via CEP
- React Icons (para redes sociais)
- JavaScript (ES6+)
- HTML5 e CSS3 (SCSS modularizado)

---

## 🚀 Funcionalidades Principais

- **Menu de navegação** com links para as páginas principais: Início, Contato, Cadastro, Produtos, Sobre e Login.
- **Carrossel personalizado** com vídeos do YouTube que pausam e tocam conforme o slide ativo.
- **Formulário de cadastro** com campos para nome, sobrenome, endereço (CEP, rua, bairro, cidade), WhatsApp formatado, e seleção de sabor favorito de pudim.
- **Formulário de login** com validação simples.
- **Página de contato** com links diretos para Instagram, iFood e WhatsApp.

---

## 📁 Estrutura de Pastas

/public
└─ index.html
/src
├─ Componentes
│ ├─ Card.jsx
│ ├─ Carousel.jsx
│ ├─ FormularioCadastro.jsx
│ ├─ FormularioLogin.jsx
│ ├─ Menu.jsx
│ ├─ Rodape.jsx
├─ Paginas
│ ├─ Home.jsx
│ ├─ Cadastro.jsx
│ ├─ Contato.jsx
│ ├─ TelaLogin.jsx
├─ estilos (SCSS)
│ ├─ Card.scss
│ ├─ FormularioCadastro.scss
│ ├─ FormularioLogin.scss
│ ├─ Menu.scss
│ ├─ Rodape.scss
│ ├─ TelaLogin.scss
├─ imagens



---

## 🔧 Como Rodar o Projeto Localmente

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/pudim-divino.git
cd pudim-divino

2. Instale as dependências:
npm install

3. Inicie o servidor de desenvolvimento:
npm start 

4. Acesse o site:
http://localhost:3000

5. Para compilar o projeto para produção:
npm run build

📝 Notas
O projeto utiliza a API pública ViaCEP para busca automática de endereço pelo CEP.

Os vídeos do carrossel são incorporados via iframe do YouTube, com controle via API para pausar e reproduzir conforme o slide ativo.

O formulário de cadastro possui validações básicas e tratamento de eventos para manter a experiência fluida.

📞 Contato
Desenvolvido por Miller Marcelino - 2025

Instagram: Miller Marcelino

WhatsApp (81) 99525-2696    

Email: miller.marcelino@hotmail.com

Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.