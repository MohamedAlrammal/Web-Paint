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

function Toolbar(){
    return(
        <div className="toolbar">
            <div className='toolbarLeft'>
                <IconButton>
                    <FillColorIcon sx={{ fontSize: 30 , color: "#f44336"}}/>
                </IconButton>
                <IconButton>
                    <BorderColorIcon sx={{ fontSize: 30 , color: "#2196f3"}}/>
                </IconButton>
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