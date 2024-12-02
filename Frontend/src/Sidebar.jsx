/* eslint-disable no-unused-vars */
/* eslint-disable react/prop-types */
import { IconButton } from '@mui/material';
import CircleIcon from '@mui/icons-material/CircleTwoTone';
import EllipseIcon from '@mui/icons-material/AllOutTwoTone';
import SquareIcon from '@mui/icons-material/SquareTwoTone';
import TriangleIcon from '@mui/icons-material/ChangeHistoryTwoTone';
import RectangleIcon from '@mui/icons-material/RectangleTwoTone';
import LineIcon from '@mui/icons-material/HorizontalRule';
import ShapesIcon from '@mui/icons-material/CategoryRounded';
import TextIcon from '@mui/icons-material/TextFields';
import HexagonIcon from '@mui/icons-material/HexagonTwoTone';
import PentagonIcon from '@mui/icons-material/PentagonTwoTone';

function Sidebar(props){
    const handleShapeType = (shape, e) =>{
        if(shape === props.shapeType){
            props.setShapeType(null);
            props.setActiveShape(null);
        }
        else{
            props.setShapeType(shape);
            props.setActiveShape(shape);
        }
    }

    return(
        <div className="sidebar">
            <br></br>
            <ShapesIcon sx={{ fontSize: 45 }}/>
            <p style={{margin: "0", fontFamily: "Arial"}}>Shapes</p>
            <br></br>
            <IconButton title='Line' onClick={(e)=>handleShapeType("Line",e)}
                        sx={{ backgroundColor: props.activeShape === 'Line' ? '#e0e0e0' : 'transparent' }}>
                <LineIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Circle' onClick={(e)=>handleShapeType("Circle",e)}
                        sx={{ backgroundColor: props.activeShape === 'Circle' ? '#e0e0e0' : 'transparent' }}>
                <CircleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Ellipse' onClick={(e)=>handleShapeType("ellipse",e)}
                        sx={{ backgroundColor: props.activeShape === 'ellipse' ? '#e0e0e0' : 'transparent' }}>
                <EllipseIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Square' onClick={(e)=>handleShapeType("square",e)}
                        sx={{ backgroundColor: props.activeShape === 'square' ? '#e0e0e0' : 'transparent' }}>
                <SquareIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Rectangle' onClick={(e)=>handleShapeType("Rect",e)}
                        sx={{ backgroundColor: props.activeShape === 'Rect' ? '#e0e0e0' : 'transparent' }}>
                <RectangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Triangle' onClick={(e)=>handleShapeType("triangle",e)}
                        sx={{ backgroundColor: props.activeShape === 'triangle' ? '#e0e0e0' : 'transparent' }}>
                <TriangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Pentagon' onClick={(e)=>handleShapeType("pentagon",e)}
                        sx={{ backgroundColor: props.activeShape === 'pentagon' ? '#e0e0e0' : 'transparent' }}>
                <PentagonIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton title='Hexagon' onClick={(e)=>handleShapeType("hexagon",e)}
                        sx={{ backgroundColor: props.activeShape === 'hexagon' ? '#e0e0e0' : 'transparent' }}>
                <HexagonIcon color='disabled' fontSize="large"/>
            </IconButton>
        </div>
    );
}

export default Sidebar