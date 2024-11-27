import { useState } from 'react'
import Paintarea from './Paintarea'
import Sidebar from './Sidebar'
import Toolbar from './Toolbar'

function Paint(){
    const [shapeType,setShapeType] = useState();
    const [color,setColor] = useState("#00BFFF");
    const [strokeColor,setStrokeColor] = useState("#00BFFF");
    const [strokeWidth,setStrokeWidth] = useState(4);
    const [opactity,setOpacity] = useState(1);
    const [undo,setUndo] = useState(false);
    const [redo,setRedo] = useState(false);
    const [copy,setCopy] = useState(false);
    const [del,setDel] = useState(false);
    const [save,setSave] = useState(false);
    const [load,setLoad] = useState(false);

    return(
    <main>
        <Sidebar shapeType={shapeType} setShapeType={setShapeType} />
        <div className="container">
            <Toolbar setLoad={setLoad} 
                     setSave={setSave} 
                     setDel={setDel} 
                     setCopy={setCopy} 
                     setRedo={setRedo} 
                     setUndo={setUndo} 
                     setOpacity={setOpacity} 
                     strokeColor={strokeColor} 
                     setStrokeColor={setStrokeColor} 
                     color={color} setColor={setColor} 
                     setStrokeWidth={setStrokeWidth}/>
                     
            <Paintarea load={load}
                       save={save} 
                       del={del} 
                       copy={copy}
                       setCopy={setCopy} 
                       redo={redo} 
                       undo={undo} 
                       opactity={opactity} 
                       strokeWidth={strokeWidth} 
                       color={color} 
                       strokeColor={strokeColor} 
                       shapeType={shapeType}/>
        </div>
      </main>
    )
}

export default Paint