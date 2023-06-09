import React, { PureComponent } from 'react';
import expand from '../../../assets/icons/ExpandArrow.svg';

interface CategoryFilterProps {
    
}
 
interface CategoryFilterState {
    
}
 
class CategoryFilter extends React.Component<CategoryFilterProps, CategoryFilterState> {
    state = {

    }
    render() { 
        return (
            <button className='bright'>
                Категории
                <img src={expand} alt="" />
            </button>
        );
    }
}
 
export default CategoryFilter;