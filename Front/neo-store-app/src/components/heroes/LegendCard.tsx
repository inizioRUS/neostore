import React, { PureComponent } from 'react';
import test from '../../assets/images/skala.jpeg';

interface LegendCardProps {
    place : number;
}
 
interface LegendCardState {
    
}
 
class LegendCard extends React.Component<LegendCardProps, LegendCardState> {
    classPlace : string;
    constructor(props : LegendCardProps){
        super(props);
        switch(this.props.place){
            case 1 : 
                this.classPlace = 'first';
                break;
            case 2 : 
                this.classPlace = 'second';
                break;
            case 3 :
                this.classPlace = 'third';
                break;
            default : 
                this.classPlace = '';
        }
    }

    state = {

    }
    render() { 
        return (
            <div className={'legend-card down-list ' + this.classPlace}>
                <img src={test} alt="" />
                Да Крутой!
            </div>
        );
    }
}
 
export default LegendCard;