import { Stage, Layer, Rect, Text, Circle, Line } from 'react-konva';

function Paintarea(){
    return(
        <div id="paintarea">
            <Stage width={1450} height={545}>
                <Layer> 
                <Rect
          x={200}
          y={100}
          width={300}
          height={100}
          fill="red"
          shadowBlur={10}
        />   
                <Circle x={1000} y={200} radius={50} fill="green" />

                </Layer>
            </Stage>
        </div>
    );
}

export default Paintarea