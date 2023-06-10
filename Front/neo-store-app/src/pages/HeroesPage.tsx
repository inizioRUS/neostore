import React, { Component } from 'react';
import Post from '../components/Post';
import '../css/heroes.css';
import LowTabCard from '../components/heroes/LowTabCard';
import {Worker} from "../assets/scripts/models/worker";
import LegendCard from "../components/heroes/LegendCard";
import image from "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"


interface HeroesPageProps {
    
}
 
interface HeroesPageState {
    workers: Worker[]
}
 
class HeroesPage extends React.Component<HeroesPageProps, HeroesPageState> {
    constructor(props: HeroesPageProps) {
        super(props);
        this.state = {
            workers: []
        }
        this.fetchWorkers = this.fetchWorkers.bind(this)
        this.parseJSONStringToArrayObjects = this.parseJSONStringToArrayObjects.bind(this)
    }

    componentDidMount() {
        this.fetchWorkers()
    }

    render() {
        const { workers } = this.state;
        return <>

        <div className='container row'>
            <div className='bests down-list'>
                <div className='legends'>
                    <div className='legends-box'>
                        <LegendCard place={2}
                                    name={workers.length > 0 ? workers[1].name : "name"}
                                    src={workers.length > 0 ? workers[1].imageURL : "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"}/>
                        <LegendCard place={1} name={workers.length > 0 ? workers[0].name : "name"}
                                    src={workers.length > 0 ? workers[0].imageURL : "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"}/>
                        <LegendCard place={3} name={workers.length > 0 ? workers[2].name : "name"}
                                    src={workers.length > 0 ? workers[2].imageURL : "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"}/>
                    </div>
                </div>
                <div className='others down-list'>
                    <LowTabCard place={4}
                                name={workers.length > 0 ? workers[4].name : "name"}
                                src={workers.length > 0 ? workers[4].imageURL : "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"}/>
                    <LowTabCard place={5}
                                name={workers.length > 0 ? workers[5].name : "name"}
                                src={workers.length > 0 ? workers[5].imageURL : "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"}/>
                    <LowTabCard place={6}
                                name={workers.length > 0 ? workers[6].name : "name"}
                                src={workers.length > 0 ? workers[6].imageURL : "https://s0.rbk.ru/v6_top_pics/resized/590xH/media/img/8/61/756545219815618.jpg"}/>

                </div>
            </div>
            <div className='posts down-list'>
                <Post/>
                <Post />
                <Post />
                <Post />
            </div>
        </div>
        </>;
    }

    parseJSONStringToArrayObjects(jsonString : string) {
        try {
            return JSON.parse(jsonString);
        } catch (err) {
            console.error(err);
            return [];
        }
    }

    fetchWorkers() {
        let url = "http://5.101.51.166:8080/workers/orderByBalance";
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                console.log(JSON.stringify(data))
                this.setState({workers: data})
            })
            .catch((error) => console.log(error));
    }
}
 
export default HeroesPage;