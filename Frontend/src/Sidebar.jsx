import { IconButton } from '@mui/material';
import CircleIcon from '@mui/icons-material/CircleTwoTone';
import SquareIcon from '@mui/icons-material/SquareTwoTone';
import TriangleIcon from '@mui/icons-material/ChangeHistoryTwoTone';
import RectangleIcon from '@mui/icons-material/RectangleTwoTone';
import LineIcon from '@mui/icons-material/HorizontalRule';
import ShapesIcon from '@mui/icons-material/CategoryRounded';
import TextIcon from '@mui/icons-material/TextFields';
import { Circle } from 'react-konva';

function Sidebar(props){

    const handleShapeType = (type) =>{
        if(type === props.shapeType){
            props.setShapeType(null);
        }
        else{
            props.setShapeType(type);
        }
    }

    return(
        <div className="sidebar">
            <br></br>
            <ShapesIcon sx={{ fontSize: 45 }}/>
            <p style={{margin: "0", fontFamily: "Arial"}}>Shapes</p>
            <br></br>
            <IconButton onClick={()=>handleShapeType("Line")}>
                <LineIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton onClick={()=>handleShapeType("Circle")}>
                <CircleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton onClick={()=>handleShapeType("square")}>
                <SquareIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton onClick={()=>handleShapeType("Rect")}>
                <RectangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton onClick={()=>handleShapeType("Triangle")}>
                <TriangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton onClick={()=>handleShapeType("Text")}>
                <TextIcon color='disabled' fontSize="large"/>
            </IconButton>
        </div>
    );
}

export default Sidebar