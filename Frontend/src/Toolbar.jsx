import { IconButton } from '@mui/material'
import FillColorIcon from '@mui/icons-material/SquareRounded'
import BorderColorIcon from '@mui/icons-material/CropDinRounded'
import BorderWidthIcon from '@mui/icons-material/LineWeightRounded';
import OpacityIcon from '@mui/icons-material/OpacityTwoTone'
import UndoIcon from '@mui/icons-material/UndoRounded'
import RedoIcon from '@mui/icons-material/RedoRounded'
import SaveIcon from '@mui/icons-material/SaveTwoTone'
import LoadIcon from '@mui/icons-material/UploadFileTwoTone'
import CopyIcon from '@mui/icons-material/ContentCopyTwoTone'
import DeleteIcon from '@mui/icons-material/DeleteTwoTone'

function Toolbar(props){

    function handleColorChange(e){
        props.setColor(e.target.value);
    }
    function handleStrokeColorChange(e){
        props.setStrokeColor(e.target.value);
    }

    return(
        <div className="toolbar">
            <div className='toolbarLeft'>
                <label style={{display: "flex"}}>
                    <FillColorIcon style={{marginRight: "15px"}} sx={{ fontSize: 27 , color: props.color, stroke: "#B3B3B3", strokeWidth: "2"}}/>
                    <input type='color' value={props.color} onChange={handleColorChange} style={{display: "none"}}/>
                </label>
                <label style={{display: "flex"}}>
                    <FillColorIcon style={{marginRight: "7px"}} sx={{ fontSize: 27, color: "#B3B3B3", stroke: props.strokeColor, strokeWidth: "2"}}/>
                    <input type='color' value={props.strokeColor} onChange={handleStrokeColorChange} style={{display: "none"}}/>
                </label>
                <IconButton>
                    <BorderWidthIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton>
                    <OpacityIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton>
                    <UndoIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton>
                    <RedoIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton>
                    <CopyIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton>
                    <DeleteIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
            </div>
            <div className='toolbarRight'>
                <IconButton>
                    <SaveIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton>
                    <LoadIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
            </div>
            
        </div>
    );
}

export default Toolbar