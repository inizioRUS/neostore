import React, {Component} from 'react';
import logo from "../assets/images/BlackNeoStore.png"
import "../css/signin.css"

class SignInPage extends Component {
    render() {
        return (
            <div className='container'>
                <div className='signin'>
                    <img src={logo} alt='' className='img'></img>
                    <input type='text' placeholder='Логин' className='input'></input>
                    <input type='text' placeholder='Пароль' className='input'></input>
                    <button className='button'>Войти</button>
                </div>
            </div>
        );
    }
}

export default SignInPage;