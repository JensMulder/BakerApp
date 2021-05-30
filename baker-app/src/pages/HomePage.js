import React from 'react';
import '../Styles/App.css';
import HeroSection from '../Components/heroSection/HeroSection';
import Cards from "../Components/cards/Cards";
import Footer from "../Components/footer/Footer";


function HomePage() {
    return (
        <>
            <HeroSection />
            <Cards/>
            <Footer/>

        </>
    );
}

export default HomePage;
