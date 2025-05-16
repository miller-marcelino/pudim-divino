import React from 'react';
import './Card.scss';

function Card({ foto, legenda }) {
  return (
    <div className="col-md-3">
      <div className="card-component">
        <img
          src={require(`../../imagens/${foto}`)}
          alt=""
          className="card-img"
        />
        <p className="card-caption">{legenda}</p>
      </div>
    </div>
  );
}

export default Card;