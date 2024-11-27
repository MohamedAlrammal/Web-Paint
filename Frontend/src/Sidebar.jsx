import { IconButton } from '@mui/material';
import CircleIcon from '@mui/icons-material/CircleTwoTone';
import SquareIcon from '@mui/icons-material/SquareTwoTone';
import TriangleIcon from '@mui/icons-material/ChangeHistoryTwoTone';
import RectangleIcon from '@mui/icons-material/RectangleTwoTone';
import LineIcon from '@mui/icons-material/HorizontalRule';
import ShapesIcon from '@mui/icons-material/CategoryRounded';
import TextIcon from '@mui/icons-material/TextFields';
import { useState } from 'react';

function Sidebar(props){
    const [activeShape, setActiveShape] = useState(null); // Tracks the currently selected shape

    const handleShapeType = (shape, e) =>{
        if(shape === props.shapeType){
            props.setShapeType(null);
            setActiveShape(null);
        }
        else{
            props.setShapeType(shape);
            setActiveShape(shape);
        }
    }

    return(
        <div className="sidebar">
            <br></br>
            <ShapesIcon sx={{ fontSize: 45 }}/>
            <p style={{margin: "0", fontFamily: "Arial"}}>Shapes</p>
            <br></br>
            <IconButton title='Line' onClick={(e)=>handleShapeType("Line",e)}
                        sx={{ backgroundColor: activeShape === 'Line' ? '#e0e0e0' : 'transparent' }}>
                <LineIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Circle' onClick={(e)=>handleShapeType("Circle",e)}
                        sx={{ backgroundColor: activeShape === 'Circle' ? '#e0e0e0' : 'transparent' }}>
                <CircleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Square' onClick={(e)=>handleShapeType("Square",e)}
                        sx={{ backgroundColor: activeShape === 'Square' ? '#e0e0e0' : 'transparent' }}>
                <SquareIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Rectangle' onClick={(e)=>handleShapeType("Rect",e)}
                        sx={{ backgroundColor: activeShape === 'Rect' ? '#e0e0e0' : 'transparent' }}>
                <RectangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Triangle' onClick={(e)=>handleShapeType("Triangle",e)}
                        sx={{ backgroundColor: activeShape === 'Triangle' ? '#e0e0e0' : 'transparent' }}>
                <TriangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Text' onClick={(e)=>handleShapeType("Text",e)}
                        sx={{ backgroundColor: activeShape === 'Text' ? '#e0e0e0' : 'transparent' }}>
                <TextIcon color='disabled' fontSize="large"/>
            </IconButton>
        </div>
    );
}

export default Sidebar