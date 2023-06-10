import React, { PureComponent } from 'react';
import '../../../css/item.css'
import test from '../../../assets/images/skala.jpeg';
import coin from '../../../assets/icons/NeoCoin.svg';
import cart from '../../../assets/icons/Cart.svg';
import storage from '../../../assets/scripts/functions/storage';
import { Good } from '../../../assets/scripts/models/good';

interface ItemCardProps {
    product : Good
}
 
interface ItemCardState {
    
}
 
class ItemCard extends React.Component<ItemCardProps, ItemCardState> {
    constructor(props : ItemCardProps){
        super(props)
    }

    state = {

    }
    render() { 
        return (
            <div className='item-card'>
                <img src={this.props.product.imageURL} alt="" />
                <div className='item-info'>
                    <h2>{this.props.product.title}</h2>
                    <div className='price-box'>{this.props.product.price}<img src={coin} alt="" />
                    {storage.CheckLogin() ? 
                            <div className='item-actions'>
                            <button className='item-button bright'>В корзину <img src={cart} alt="" /></button>
                            </div>
                        : <div></div>}
                    </div>
                    
                </div>
            </div>
        );
    }
}
 
export default ItemCard;