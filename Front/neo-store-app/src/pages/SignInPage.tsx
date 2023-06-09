import React, {ChangeEvent, Component} from 'react';
import logo from "../assets/images/BlackNeoStore.png"
import "../css/signin.css"

interface ProfileProps {

}

interface ProfileState {
    login: string,
    password: string
}

class SignInPage extends Component<ProfileProps, ProfileState> {
    constructor(props: ProfileProps) {
        super(props);
        this.state = {
            login: '',
            password: ''
        }
        this.handleLoginChange = this.handleLoginChange.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
    }

    render() {
        return (
            <div className='container'>
                <form className='signin' onClick={(event) => {
                    event.preventDefault();
                    if (this.state.login.length !== 0 && this.state.password.length !== 0) {
                        this.handleSubmit();
                    }
                }
                }>
                    <img src={logo} alt='' className='img'></img>
                    <input type='text' placeholder='Логин'
                           className='input'
                           value={this.state.login}
                           onChange={this.handleLoginChange}
                           required>
                    </input>
                    <input type='text' placeholder='Пароль'
                           className='input'
                           value={this.state.password}
                           onChange={this.handlePasswordChange}
                           required>
                    </input>
                    <button className='button'>Войти</button>
                </form>
            </div>
        );
    }

    handleLoginChange(event: React.ChangeEvent<HTMLInputElement>) {
        event.preventDefault();
        this.setState({
            login: event.target.value,
        })
    }

    handlePasswordChange(event: React.ChangeEvent<HTMLInputElement>) {
        event.preventDefault();
        this.setState({
            password: event.target.value,
        })
    }

    handleSubmit() {
        let url = "http://5.101.51.166:8080/auth/signin";
        let data = {
            login: this.state.login,
            password: this.state.password
        }
        let request = new Request(url, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json;charset=utf-8',
                "Accept": "application/json",
            }
        })
        let id;
        let promise = fetch(request)
        .then((response) => response.json())
        .then((data) => {
            console.log(data)
        })
        .catch((error) => console.log(error))
    }
}

export default SignInPage;