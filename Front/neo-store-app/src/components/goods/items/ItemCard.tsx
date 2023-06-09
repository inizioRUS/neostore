import React, { PureComponent } from 'react';
import '../../../css/item.css'
import test from '../../../assets/images/skala.jpeg';
import coin from '../../../assets/icons/NeoCoin.svg';

interface ItemCardProps {
    
}
 
interface ItemCardState {
    
}
 
class ItemCard extends React.Component<ItemCardProps, ItemCardState> {
    state = {

    }
    render() { 
        return (
            <div className='item-card'>
                <img src={test} alt="" />
                <div className='item-info'>
                    <h2>Вилка и ложка</h2>
                    <div className='price-box'>228 <img src={coin} alt="" /></div>
                    <div className='item-actions'>
                        <button className='item-button bright'>В корзину</button>
                        <button className='item-button bright'>Избранное</button>
                    </div>
                </div>
            </div>
        );
    }
}
 
export default ItemCard;