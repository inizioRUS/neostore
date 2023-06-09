import React, { PureComponent } from 'react';
import SearchFilter from '../components/goods/filters/SearchFilter';
import FullSearchBlock from '../components/goods/filters/FullSearchBlock';
import FullItemCard from '../components/goods/items/FullItemCard';

interface ItemPageProps {
    
}
 
interface ItemPageState {
    
}
 
class ItemPage extends React.Component<ItemPageProps, ItemPageState> {
    state = {

    }
    render() { 
        return (
            <div className='container'>
                <FullSearchBlock />
                <FullItemCard />
            </div>
        );
    }
}
 
export default ItemPage;