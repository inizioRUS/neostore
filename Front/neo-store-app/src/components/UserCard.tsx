import React, { Component } from 'react';
import { Worker } from '../assets/scripts/models/worker';
import '../css/user.css';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';

interface UserCardProps {
    profile : Worker
}
 
interface UserCardState {
    profile : Worker;
}
 
class UserCard extends React.Component<UserCardProps, UserCardState> {
    constructor(props : UserCardProps){
        super(props);
        this.state = {
            profile : this.props.profile
        }
    }

    render() { 
        return (
            <div className='s-user-card'>
                <img src={this.state.profile.imageURL} alt="" />
                <div className='s-user-info'>
                    <h2>{`${this.state.profile.surname} ${this.state.profile.name}`}</h2>
                </div>
            </div>
        );
    }
}
 
export default UserCard;