import React, { Component } from 'react';
import test from '../../assets/images/skala.jpeg';
import coin from '../../assets/icons/NeoCoin.svg';
import cart from '../../assets/icons/Cart.svg';
import burger from '../../assets/icons/Burger.svg';
import { Worker } from '../../assets/scripts/models/worker';

interface UserMenuProps {
    userId : number;
}
 
interface UserMenuState {
    profile : Worker;
}
 
class UserMenu extends React.Component<UserMenuProps, UserMenuState> {
    constructor(props : UserMenuProps){
      super(props);

      this.state = {
        profile : new Worker(1, '', '', '', '', 1, 1, 1, '', 1, '', '', '', '')
      }
    }

    componentDidMount() {
      this.fetchProfile(this.props.userId);
    }
  
    fetchProfile(id: number) {
      let url = `http://5.101.51.166:8080/workers/worker/id/${id}`;
      fetch(url)
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          this.setState({ profile: data });
        })
        .catch((error) => console.log(error));
    }
    
    render() {
        return (
            <div className='outer-user-menu'>
              <div className='inner-user-menu bright'>
                <img src={this.state.profile.imageURL} alt="" />
                <div className='user-info'>
                  <h3>{this.state.profile.name}</h3>
                  <div className='balance'>
                    {this.state.profile.balance} <img src={coin} alt="" /></div>
                </div>
                <div className='user-buttons'>
                  <button><img src={burger} alt="" /></button>
                </div>
              </div>
              
            </div>
        );
    }
}
 
export default UserMenu;