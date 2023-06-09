import React, { Component } from 'react';
import FullSearchBlock from '../components/goods/filters/FullSearchBlock';
import '../css/store.css';
import ItemCard from '../components/goods/items/ItemCard';
import { Good } from '../assets/scripts/models/good';

interface StorePageProps {
    
}
 
interface StorePageState {
    savedGoods : Good[];
}
 
class StorePage extends React.Component<StorePageProps, StorePageState> {
    constructor(props : StorePageProps){
        super(props);
        this.state = {
            savedGoods: this.GetAllGoods()
        }
    }

    
    render() { 
        return (
            <div className='container'>
                <FullSearchBlock />
                <div className='goods-list'>
                    {this.GetFromStorage().map((product) => (<ItemCard key={product.id} product={product} />))}

                </div>
            </div>
        );
    }


    GetFromStorage() : Good[]{
        let res = localStorage.getItem("goods");
        return res ? JSON.parse(res) : [];
    }

    GetAllGoods() : Good[] {
        let allGoods : Good[] = [];

        let url = "http://5.101.51.166:8080/goods/getAllGoods";
        let request = new Request(url, {
            method: 'GET'
        })
        let promise = fetch(request)
        .then((response) => response.json())
        .then((data) => {
            console.log(JSON.stringify(data));
            localStorage.setItem("goods", JSON.stringify(data));
            allGoods = data;
        })
        .catch((error) => console.log(error))

        return allGoods;
    }
}
 
export default StorePage;