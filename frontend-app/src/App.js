import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import About from './components/About';
import Contact from './components/Contact';
import './App.css'
import LoginPage from './Pages/LoginPage';
import SignupPage from './Pages/SignupPage';
import DirectTeam from './Dashboard/MyTeam/DirectTeam';
import FastTradeTeam from './Dashboard/MyTeam/FastTradeTeam';
import RewardTeam from './Dashboard/MyTeam/RewardTeam';
import LevelTeam from './Dashboard/MyTeam/LevelTeam';
function App() {
  return (
    <Router>
      <Header />
      <main >
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/dashboard/DirectTeam" element={<DirectTeam/>}/>
          <Route path="/dashboard/FastTradeTeam" element={<FastTradeTeam/>}/>
          <Route path="/dashboard/RewardTeam" element={<RewardTeam/>}/>
          <Route path="/dashboard/LevelTeam/:level" element={<LevelTeam/>}/>


        </Routes>

      </main>
      <Footer/>
    </Router>
  );
}

export default App;
