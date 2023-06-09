import React, { Component } from 'react';
import Post from '../components/Post';
import '../css/heroes.css';
import test from '../assets/images/skala.jpeg';
import LegendCard from '../components/heroes/LegendCard';
import LowTabCard from '../components/heroes/LowTabCard';

interface HeroesPageProps {
    
}
 
interface HeroesPageState {
    
}
 
class HeroesPage extends React.Component<HeroesPageProps, HeroesPageState> {
    state = {

    }
    render() { 
        return (
            <>
            <div className='container row'>
                <div className='bests down-list'>
                    <div className='legends'>
                        <div className='legends-box'>
                            <LegendCard place={2} />
                            <LegendCard place={1} />
                            <LegendCard place={3} />
                        </div>
                    </div>
                    <div className='others down-list'>
                        <LowTabCard place={4}/>
                        <LowTabCard place={5}/>
                        <LowTabCard place={6}/>
                    </div>
                </div>
                <div className='posts down-list'>
                    <Post/>
                    <Post />
                    <Post />
                    <Post />
                </div>
            </div>
            </>
        );
    }
}
 
export default HeroesPage;