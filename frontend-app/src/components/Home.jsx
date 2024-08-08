import React from 'react';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import Events from './Events';
import Event from './event.js';
import security1 from '../images/security1.jpg';
import security2 from '../images/security2.jpg';
import security3 from '../images/security3.jpg';
import security4 from '../images/security4.jpg';
import security5 from '../images/security5.png';
import team from '../images/team.jpg';
import '../styles/Home.css';
import Ai from './Ai'
import AiProduct from './AiProduct.js';

const Home = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000, // Slide change every 3 seconds
  };

  return (
    <div className="container">
      <h2 className="title">COMPANY PROFILE</h2>

      <div className="about">
        <div className="about-image">
          <img src={team} alt="Team" className="team-image" />
        </div>
        <div className="about-text">
          <p>
            GTB is a financial service provider that was founded in 2010. With its roots in 
            Corporate Advisory, GTB has evolved to become a leader in the financial markets, 
            offering a wide range of investment services. Regulated by ASIC, GTB provides products 
            and services such as fund management for private clients. Additionally, GTB offers securities 
            financing and debt advisory services to brokers, hedge fund divisions, and other financial services firms. 
            In the following article, we will analyze the characteristics of this broker from various aspects, 
            providing you with simple and organized information. If you are interested, please read on. 
            At the end of the article, we will also briefly make a conclusion so that you can understand the 
            broker's characteristics at a glance.
          </p>
          <h2>A diverse team with a single vision</h2>
          <p>
            We're bringing together the world's sharpest, most creative professionals across engineering, business, 
            design, marketing, and real estate.
          </p>
        </div>
      </div>

      <div className="security" style={{marginTop:"150px"}} >
        <h2>Security System</h2>
        
        <Slider {...settings} className="slider">
          {[
            { src: security1, alt: 'Highly Secured Software' },
            { src: security2, alt: 'Own Server And Domain' },
            { src: security3, alt: 'Peer To Peer Technology' },
            { src: security4, alt: 'Technical Team Support' },
            { src: security5, alt: 'Web Mail Service' }
          ].map((image, index) => (
            <div key={index} className="slider-item">
              <div className="image-container">
                <img src={image.src} alt={image.alt} className="slider-image" />
              </div>
              <div className="caption-container">
                <div className="cloud">
                  <div className="arrow"></div>
                  <p>{image.alt}</p>
                </div>
              </div>
            </div>
          ))}
        </Slider>
      </div>
      <div className='events' style={{marginTop:"150px"}}>
        <h1>Upcoming Events</h1>
        <div style={{display:"flex"}}>
        {  Event.map((props)=><Events name={props.name} img={props.img}/>)}
        </div>
      </div>

      <div class="AI">
          <h1>AI Platforms</h1>
          <div style={{display:"flex",justifyContent:"center"}}>
          {AiProduct.map((props)=><Ai img={props.img} key={props.id} name={props.name} desc={props.desc}/>)}
          </div>
      </div>
    </div>
  );
}

export default Home;
