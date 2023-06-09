import React, { PureComponent } from 'react';
import test from '../../../assets/images/skala.jpeg';
import coin from '../../../assets/icons/NeoCoin.svg';
import cart from '../../../assets/icons/Cart.svg';
import favorite from '../../../assets/icons/Favorite.svg';

interface FullItemCardProps {
    
}
 
interface FullItemCardState {
    
}
 
class FullItemCard extends React.Component<FullItemCardProps, FullItemCardState> {
    state = {

    }
    render() { 
        return (
            <div className='full-item-card'>
                <img src={test} alt="" />
                <div className='item-info'>
                    <div className='item-text-info'>
                        <h2>Вилка и ложка</h2>
                        <h4>Хорошая кружка для вашего крутого вечера перед компьютером или автомобилем Audi A5.</h4>
                    </div>
                    
                    <div className='price-box'>228 <img src={coin} alt="" />
                        <button className='item-button bright'>В корзину <img src={cart} alt="" /></button>
                        <button className='item-button bright'>Избранное <img src={favorite} alt="" /></button>
                    </div>
                </div>
            </div>
        );
    }
}
 
export default FullItemCard;