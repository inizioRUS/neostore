import React from 'react';
import FullSearchBlock from '../components/goods/filters/FullSearchBlock';
import '../css/store.css';
import ItemCard from '../components/goods/items/ItemCard';
import { Good } from '../assets/scripts/models/good';

interface StorePageProps {}

interface StorePageState {
  savedGoods: Good[];
}

class StorePage extends React.Component<StorePageProps, StorePageState> {
  constructor(props: StorePageProps) {
    super(props);
    this.state = {
      savedGoods: [],
    };
  }

  componentDidMount() {
    this.fetchGoods();
  }

  fetchGoods() {
    let url = "http://5.101.51.166:8080/goods/getAllGoods";
    fetch(url)
      .then((response) => response.json())
      .then((data) => {
        this.setState({ savedGoods: data });
      })
      .catch((error) => console.log(error));
  }

  render() {
    const { savedGoods } = this.state;

    return (
      <div className='container'>
        <FullSearchBlock />
        <div className='goods-list'>
          {savedGoods.map((product) => (
            <ItemCard key={product.id} product={product} />
          ))}
        </div>
      </div>
    );
  }
}

export default StorePage;