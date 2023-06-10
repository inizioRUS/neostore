import React, { Component } from 'react';
import Post from '../components/Post';
import '../css/heroes.css';
import LowTabCard from '../components/heroes/LowTabCard';
import {Worker} from "../assets/scripts/models/worker";
import LegendCard from "../components/heroes/LegendCard";
import {log} from "util";


interface HeroesPageProps {
    
}
 
interface HeroesPageState {
    workers: Worker[]
}
 
class HeroesPage extends React.Component<HeroesPageProps, HeroesPageState> {
    private data: any[];

    constructor(props: HeroesPageProps) {
        super(props);
        this.state = {
            workers: []
        }
        this.data = [];
        this.fetchWorkers = this.fetchWorkers.bind(this)
        this.parseJSONStringToArrayObjects = this.parseJSONStringToArrayObjects.bind(this)
    }

    componentDidMount() {
        this.fetchWorkers()
    }

    render() {
        return (
            <>
            <div className='container row'>
                <div className='bests down-list'>
                    <div className='legends'>
                        <div className='legends-box'>
                            {/*<LegendCard place={2} name={this.state.workers[1].name}/>*/}
                            {/*<LegendCard place={1} name={this.state.workers[0].name}/>*/}
                            {/*<LegendCard place={3} name={this.state.workers[2].name}/>*/}
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
            .then((response) => response)
            .then((data) => {
                console.log(this.parseJSONStringToArrayObjects(JSON.stringify(data)))
                localStorage.setItem("workers", JSON.stringify(data))
            })
            .catch((error) => console.log(error));
    }
}
 
export default HeroesPage;