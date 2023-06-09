import React from 'react';
import logo from './logo.svg';
import { Routes, Route, Link } from 'react-router-dom';
import Header from './components/header/Header';
import NotFound from './pages/NotFound';
import ProfilePage from './pages/ProfilePage';
import HeroesPage from './pages/HeroesPage';
import StorePage from './pages/StorePage';
import './css/reset.css';
import './css/main.css';

function App() {
  return (
    <>
        <Header />
        <Routes>
          <Route path='/store' element={<StorePage />}/>
          <Route path='/heroes' element={<HeroesPage />}/>
          <Route path='/profile' element={<ProfilePage />}/>
          <Route path='*' element={<NotFound />} />
        </Routes>
    </>
  );
}

export default App;
