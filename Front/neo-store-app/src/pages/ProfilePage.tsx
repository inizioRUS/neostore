import React, { Component } from 'react';
import { Worker } from '../assets/scripts/models/worker';
import '../css/user.css';

interface ProfileProps {
    userId : number
}
 
interface ProfileState {
    profile : Worker;
}
 
class Profile extends React.Component<ProfileProps, ProfileState> {
    constructor(props : ProfileProps){
        super(props);
        this.state = {
            profile : new Worker(1, '', '', '', '', 1, 1, 1, '', 1, '', '', '', '')
        }
    }

    componentDidMount(): void {
        this.fetchProfile(this.props.userId)
    }
    

    fetchProfile(id: number) {
        let url = `http://5.101.51.166:8080/workers/worker/id/${id}`;
        fetch(url)
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            this.setState({ profile: data });
          })
          .catch((error) => console.log(error));
    }

    render() { 
        return (
            <div className='container'>
                <div className='user-card'>
                    <div className='pic-block'>
                        <img src={this.state.profile.imageURL} alt="" />
                    </div>
                    <div className='user-block'>
                        <div className='main-info'>
                            <h2>{`${this.state.profile.surname} ${this.state.profile.name} ${this.state.profile.secondName}`}</h2>
                            <div className='job-info'>
                                <h3>{this.state.profile.position}</h3>
                                <h3>{this.state.profile.post}</h3>
                            </div>
                        </div>
                    </div>
                    <div>

                    </div>
                    <div className='achievements-block'>

                    </div>
                </div>
                {   }
                <div className='recommends'></div>
            </div>
        );
    }
}
 
export default Profile;