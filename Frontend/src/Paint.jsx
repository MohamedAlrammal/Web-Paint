import { useState } from 'react';
import Paintarea from './Paintarea';
import Sidebar from './Sidebar';
import Toolbar from './Toolbar';

function Paint() {
    const [shapeType, setShapeType] = useState();
    const [color, setColor] = useState("#00BFFF");
    const [strokeColor, setStrokeColor] = useState("#00BFFF");
    const [opacity, setOpacity] = useState(1); // Opacity state (default: fully opaque)

    return (
        <main>
            <Sidebar shapeType={shapeType} setShapeType={setShapeType} />
            <div className="container">
                <Toolbar 
                    strokeColor={strokeColor} 
                    setStrokeColor={setStrokeColor} 
                    color={color} 
                    setColor={setColor} 
                    opacity={opacity} 
                    setOpacity={setOpacity} // Pass opacity to Toolbar
                />
                <Paintarea 
                    color={color} 
                    strokeColor={strokeColor} 
                    shapeType={shapeType} 
                    opacity={opacity} // Pass opacity to Paintarea
                />
            </div>
        </main>
    );
}

export default Paint;
