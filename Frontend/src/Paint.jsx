import { useState } from 'react'
import Paintarea from './Paintarea'
import Sidebar from './Sidebar'
import Toolbar from './Toolbar'

function Paint(){
    const [shapeType,setShapeType] = useState();
    const [color,setColor] = useState("#00BFFF");
    const [strokecolor,setStrokeColor] = useState("#00BFFF");
    return(
    <main>
        <Sidebar setShapeType={setShapeType} />
        <div className="container">
            <Toolbar strokecolor={strokecolor} setStrokeColor={setStrokeColor} color={color} setColor={setColor} />
            <Paintarea color={color} strokecolor={strokecolor} ShapeType={shapeType}/>
        </div>
      </main>
    )
}

export default Paint