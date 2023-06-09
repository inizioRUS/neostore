import React, { PureComponent } from 'react';
import SearchFilter from './SearchFilter';
import CategoryFilter from './CategoryFilter';

interface FullSearchBlockProps {
    
}
 
interface FullSearchBlockState {
    
}
 
class FullSearchBlock extends React.Component<FullSearchBlockProps, FullSearchBlockState> {
    state = {

    }
    render() { 
        return (
            <div className='search-block'>
                <SearchFilter />
                <CategoryFilter />
            </div>
        );
    }
}
 
export default FullSearchBlock;