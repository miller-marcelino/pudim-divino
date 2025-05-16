import React, { useEffect } from 'react';
import CarouselJS from 'bootstrap/js/dist/carousel';
import SelectorEngine from 'bootstrap/js/dist/dom/selector-engine';

// override find to ensure correct context and avoid illegal invocation
SelectorEngine.find = (selector, element) => {
    const root = element || document;
    return Array.from(root.querySelectorAll(selector));
};

function Carousel() {
    useEffect(() => {
        const el = document.getElementById('demo');
        const carousel = new CarouselJS(el, { interval: 3000, pause: false });

        // autoplay videos using YouTube IFrame API
        const iframes = el.querySelectorAll('iframe');
        const slideHandler = () => {
            iframes.forEach(frame =>
                frame.contentWindow.postMessage(
                    JSON.stringify({ event: 'command', func: 'pauseVideo' }), '*'
                )
            );
            const activeFrame = el.querySelector('.carousel-item.active iframe');
            if (activeFrame)
                activeFrame.contentWindow.postMessage(
                    JSON.stringify({ event: 'command', func: 'playVideo' }), '*'
                );
        };
        el.addEventListener('slid.bs.carousel', slideHandler);
        // play first video on load
        if (iframes[0])
            iframes[0].contentWindow.postMessage(
                JSON.stringify({ event: 'command', func: 'playVideo' }), '*'
            );

        return () => {
            el.removeEventListener('slid.bs.carousel', slideHandler);
            carousel.dispose();
        };
    }, []);

    return (
        <>

            <div id="demo" className="carousel slide w-100" data-bs-ride="carousel" data-bs-interval="3000" data-bs-pause="false">

                <div className="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" className="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                </div>

                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <iframe className="d-block w-100" style={{ height: '500px' }} src="https://www.youtube.com/embed/5qap5aO4i9A" title="LoFi Girl" frameBorder="0" allow="autoplay; encrypted-media" allowFullScreen></iframe>
                    </div>
                    <div className="carousel-item">
                        <iframe className="d-block w-100" style={{ height: '500px' }} src="https://www.youtube.com/embed/ZR8efvBplVM" title="Nature Relax" frameBorder="0" allow="autoplay; encrypted-media" allowFullScreen></iframe>
                    </div>
                    <div className="carousel-item">
                        <iframe className="d-block w-100" style={{ height: '500px' }} src="https://www.youtube.com/embed/eZWRaOuOijU" title="Cooking Demo" frameBorder="0" allow="autoplay; encrypted-media" allowFullScreen></iframe>
                    </div>
                </div>

                <button className="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev"><span className="carousel-control-prev-icon"></span></button>
                <button className="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next"><span className="carousel-control-next-icon"></span></button>
            </div>

        </>
    );
}

export default Carousel;
