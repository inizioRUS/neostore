import React, { Component } from 'react';
import test from '../../assets/images/skala.jpeg';
import coin from '../../assets/icons/NeoCoin.svg';
import cart from '../../assets/icons/Cart.svg';
import burger from '../../assets/icons/Burger.svg';

interface UserMenuProps {
    userId : number
}
 
interface UserMenuState {
    
}
 
class UserMenu extends React.Component<UserMenuProps, UserMenuState> {
    constructor(props : UserMenuProps){
      super(props);
    }

    state = {

    }
    render() {
        return (
            <div className='outer-user-menu'>
              <div className='inner-user-menu bright'>
                <img src={test} alt="" />
                <div className="user-menu-avatar" style={{ backgroundImage: `url(${test})`, backgroundSize: 'cover' }}></div>
                <div className='user-info'>
                  <h3>Дуэйн</h3>
                  <div className='balance'>
                    228 <img src={coin} alt="" /></div>
                </div>
                <div className='user-buttons'>
                  <button><img src={cart} alt="" /></button>
                  <button><img src={burger} alt="" /></button>
                </div>
              </div>
              
            </div>
        );
    }
}
 
export default UserMenu;