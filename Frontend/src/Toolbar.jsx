/* eslint-disable no-unused-vars */
/* eslint-disable react/prop-types */
import { useState, useEffect, useRef } from 'react';
import { IconButton } from '@mui/material'
import FillColorIcon from '@mui/icons-material/SquareRounded'
import BorderWidthIcon from '@mui/icons-material/LineWeightRounded';
import OpacityIcon from '@mui/icons-material/OpacityTwoTone'
import UndoIcon from '@mui/icons-material/UndoRounded'
import RedoIcon from '@mui/icons-material/RedoRounded'
import SaveIcon from '@mui/icons-material/SaveTwoTone'
import LoadIcon from '@mui/icons-material/UploadFileTwoTone'
import CopyIcon from '@mui/icons-material/ContentCopyTwoTone'
import DeleteIcon from '@mui/icons-material/DeleteTwoTone'
import ClearIcon from '@mui/icons-material/LayersClearTwoTone'

function Toolbar(props){
    function handleColorChange(e){
        props.setColor(e.target.value);
    }
    function handleStrokeColorChange(e){
        props.setStrokeColor(e.target.value);
    }

    function handleUpdate(){
        props.setUpdate(true);
        console.log(props.update);
    }
    
    function handleClick(option){
        switch(option){
            case "undo":
                props.setUndo(true);
                break;
            case "redo":
                props.setRedo(true);
                break;
            case "copy":
                props.setCopy(true);
                break;
            case "delete":
                props.setDel(true);
                break;
            case "clear":
                props.setClear(true);
                break;
            case "save":
                props.setSave(true);
                break;
            case "load":
                props.setLoad(true);
                break;
        }
    }

    return(
        <div className="toolbar">
            <div className='toolbarLeft'>
                <label style={{display: "flex"}}>
                    <FillColorIcon style={{marginRight: "15px"}} sx={{ fontSize: 27 , color: props.color, stroke: "#B3B3B3", strokeWidth: "2"}}/>
                    <input type='color' onClick={handleUpdate} value={props.color} onChange={handleColorChange} style={{display: "none"}}/>
                </label>
                <label style={{display: "flex"}}>
                    <FillColorIcon style={{marginRight: "7px"}} sx={{ fontSize: 27, color: "#B3B3B3", stroke: props.strokeColor, strokeWidth: "2"}}/>
                    <input type='color' onClick={handleUpdate} value={props.strokeColor} onChange={handleStrokeColorChange} style={{display: "none"}}/>
                </label>
                <IconButton onClick={() => handleClick("undo")}>
                    <UndoIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton onClick={() => handleClick("redo")}>
                    <RedoIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton onClick={() => handleClick("copy")}>
                    <CopyIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton onClick={() => handleClick("delete")}>
                    <DeleteIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton onClick={() => handleClick("clear")}>
                    <ClearIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
            </div>
            <div className='toolbarRight'>
                <IconButton onClick={() => handleClick("save")}>
                    <SaveIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
                <IconButton onClick={() => handleClick("load")}>
                    <LoadIcon color='disabled' sx={{ fontSize: 30 }}/>
                </IconButton>
            </div>

        </div>
    );
}

export default Toolbar