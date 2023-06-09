import React, { Component } from 'react';
import UserMenu from './UserMenu';
import { Link } from 'react-router-dom';
import '../../css/header.css';
import logo from '../../assets/images/NeoStore.svg';

interface HeaderProps {
    
}
 
interface HeaderState {
    
}
 
class Header extends React.Component<HeaderProps, HeaderState> {
    state = {

    }
    render() { 
        return (
            <header>
                <div className='nav-line'>
                    <img src={logo} alt="" />
                    <div>
                    </div>
                    <div className='nav-buttons'>
                        <Link to='/store'>Главная</Link>
                        <Link to='/heroes'>Зал славы</Link>
                        <Link to='/activities'>Активности</Link>
                    </div>
                </div>
                <UserMenu />
            </header>
        );
    }
}
 
export default Header;