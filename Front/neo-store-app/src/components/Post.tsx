import React, { PureComponent } from 'react';
import test from '../assets/images/skala.jpeg';

interface PostProps {
    
}
 
interface PostState {
    
}
 
class Post extends React.Component<PostProps, PostState> {
    state = {
        
    }
    render() { 
        return (
            <div className='post'>
                Привет, мир!
                <img src={test} alt="" />
            </div>
        );
    }
}
 
export default Post;