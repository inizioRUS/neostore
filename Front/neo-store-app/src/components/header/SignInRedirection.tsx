import React, { PureComponent } from 'react';
import { Link } from 'react-router-dom';

interface SignInRedirectionProps {
    
}
 
interface SignInRedirectionState {
    
}
 
class SignInRedirection extends React.Component<SignInRedirectionProps, SignInRedirectionState> {
    state = {

    }
    render() { 
        return (
            <div className='outer-user-menu'>
                <Link to='/signin'><button className='bright'>Войти</button></Link>
            </div>
        );
    }
}
 
export default SignInRedirection;