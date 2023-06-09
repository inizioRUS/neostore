import React, { Component } from 'react';
import FullSearchBlock from '../components/goods/filters/FullSearchBlock';
import '../css/store.css';
import ItemCard from '../components/goods/items/ItemCard';

interface StorePageProps {
    
}
 
interface StorePageState {
    
}
 
class StorePage extends React.Component<StorePageProps, StorePageState> {
    state = {

    }
    render() { 
        return (
            <div className='container'>
                <FullSearchBlock />
                <div className='goods-list'>
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                    <ItemCard />
                </div>
            </div>
        );
    }
}
 
export default StorePage;