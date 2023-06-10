import React, { Component } from 'react';
import expand from '../../../assets/icons/ExpandArrow.svg';

interface CategoryFilterProps {
    
}
 
interface CategoryFilterState {
    isExpanded: boolean;
}
 
class CategoryFilter extends React.Component<CategoryFilterProps, CategoryFilterState> {
    constructor(props: CategoryFilterProps) {
        super(props);
        this.state = {
            isExpanded: false
        };
    }

    toggleExpanded = () => {
        this.setState(prevState => ({
            isExpanded: !prevState.isExpanded
        }));
    }

    render() { 
        const { isExpanded } = this.state;
        
        return (
            <div className={`category-filter ${isExpanded ? 'expanded' : ''}`}>
                <button className="bright" onClick={this.toggleExpanded}>
                    Категории
                    <img className="expand-icon" src={expand} alt="" />
                </button>
                {isExpanded && (
                    <div className="category-dropdown">
                        <ul>
                            <li>Мерч</li>
                            <li>Техника</li>
                            <li>Услуги</li>
                        </ul>
                    </div>
                )}
            </div>
        );
    }
}
 
export default CategoryFilter;