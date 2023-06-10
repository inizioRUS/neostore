import React, { PureComponent } from 'react';
import glass from '../../../assets/icons/FindGlass.svg';

interface SearchFilterProps {
    
}
 
interface SearchFilterState {
    
}
 
class SearchFilter extends React.Component<SearchFilterProps, SearchFilterState> {
    state = {
        
    }
    render() { 
        return (
            <div className='search-filter'>
                <input type="search" className='search-field' placeholder='Поиск по товарам...'/>
                <button className='bright'><img src={glass} alt="" /></button>
            </div>
        );
    }
}
 
export default SearchFilter;