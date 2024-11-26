import { IconButton } from '@mui/material';
import CircleIcon from '@mui/icons-material/CircleTwoTone';
import SquareIcon from '@mui/icons-material/SquareTwoTone';
import TriangleIcon from '@mui/icons-material/ChangeHistoryTwoTone';
import RectangleIcon from '@mui/icons-material/RectangleTwoTone';
import LineIcon from '@mui/icons-material/HorizontalRule';
import ShapesIcon from '@mui/icons-material/CategoryRounded';
import TextIcon from '@mui/icons-material/TextFields';

function Sidebar(){
    return(
        <div className="sidebar">
            <br></br>
            <ShapesIcon sx={{ fontSize: 45 }}/>
            <p style={{margin: "0", fontFamily: "Arial"}}>Shapes</p>
            <br></br>
            <IconButton>
                <LineIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton>
                <CircleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton>
                <SquareIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton>
                <RectangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton>
                <TriangleIcon color='disabled' fontSize="large"/>
            </IconButton>
            <IconButton>
                <TextIcon color='disabled' fontSize="large"/>
            </IconButton>
        </div>
    );
}

export default Sidebar