import React, { Component } from 'react';
import test from '../../assets/images/skala.jpeg';

interface LowTabCardProps {
    place : number;
    name: string;
    src: string;
}
 
interface LowTabCardState {
    
}
 
class LowTabCard extends React.Component<LowTabCardProps, LowTabCardState> {
    constructor(props : LowTabCardProps){
        super(props);
    }

    state = {

    }
    render() { 
        return (
            <div className='low-tab-card'>
                <h3>{this.props.place}</h3>
                <div>
                    <img src={this.props.src} alt="" />
                    {this.props.name}
                </div>
            </div>
        );
    }
}
 
export default LowTabCard;