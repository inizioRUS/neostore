import React, { Component } from 'react';

interface NotFoundProps {
    
}
 
interface NotFoundState {
    
}
 
class NotFound extends React.Component<NotFoundProps, NotFoundState> {
    state = {

    }
    render() { 
        return (
            <>
            <h1>Это страница не найдена!</h1>
            </>
        );
    }
}
 
export default NotFound;