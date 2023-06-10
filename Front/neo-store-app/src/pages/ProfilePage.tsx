import React, { Component } from 'react';
import { Worker } from '../assets/scripts/models/worker';
import '../css/user.css';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import UserCard from '../components/UserCard';

interface ProfileProps {
    userId : number
}
 
interface ProfileState {
    profile : Worker;
    recommendations : Worker[]
}
 
class Profile extends React.Component<ProfileProps, ProfileState> {
    constructor(props : ProfileProps){
        super(props);
        this.state = {
            profile : new Worker(1, '', '', '', '', 1, 1, 1, '', 1, '', '', '', ''),
            recommendations : []
        }
    }

    componentDidMount(): void {
        this.fetchProfile(this.props.userId)
        this.fetchProfiles();
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

    fetchProfiles(){
        let url = `http://5.101.51.166:8080/workers`;
        fetch(url)
          .then((response) => response.json())
          .then((data) => {
            console.log(data);
            this.setState({ recommendations: data });
          })
          .catch((error) => console.log(error));
    }

    render() { 
        const settings = {
            dots: true,
            infinite: true,
            speed: 500,
            slidesToShow: 1,
            slidesToScroll: 1
          };

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
                        <div className='achievements-block'>
                        {/* <Slider {...settings}>
                            <div>
                            <h3>Achievement 1</h3>
                            </div>
                            <div>
                            <h3>Achievement 2</h3>
                            </div>
                            <div>
                            <h3>Achievement 3</h3>
                            </div>
                        </Slider> */}

                        </div>
                    </div>
                </div>
                {   }
                <div className='recommends'>
                    {this.state.recommendations.map((product) => (
                        <UserCard profile={product} />
                    ))}
                </div>
            </div>
        );
    }
}
 
export default Profile;