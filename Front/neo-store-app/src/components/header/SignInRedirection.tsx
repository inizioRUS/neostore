import React, { PureComponent } from 'react';

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
              <button className='bright'>Войти</button>
            </div>
        );
    }
}
 
export default SignInRedirection;