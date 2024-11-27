import { useEffect, useState, useRef } from 'react';
import { Stage, Layer, Rect, Text, Circle, Line } from 'react-konva';

function Paintarea(props){
    const [stageSize, setStageSize] = useState({width:1450,height:545});

    useEffect(() => {
            const handleResize = () => {
            const container = document.getElementById("paintarea");
            console.log(container);
            setStageSize({
                width: container.offsetWidth,
                height: container.offsetHeight
            });
        };
    
        handleResize();
        window.addEventListener('resize', handleResize);
    
        return () => {
          window.removeEventListener('resize', handleResize);
        };
      }, []);

    const [shapes, setShapes] = useState([]);
    const [isDrawing, setIsDrawing] = useState(false);
    const [newShape, setNewShape] = useState(null);
    var layer = document.getElementById("konvalayer")
    const [selectedNode, setSelectedNode] = useState(null); // Track the currently selected shape
    const transformerRef = useRef(null);
    
      const handleMouseDown = (e) => {
        const { x, y } = e.target.getStage().getPointerPosition();
        var shape = new Konva.Rect({
            x: x,
            y: y,
            width: 0,
            height: 0,
            fill: 'white',
            stroke: 'black',
            strokeWidth: 4,
            draggable: true,
        });
        setNewShape(shape);
        layer.add(shape);
        layer.draw();
        setIsDrawing(true);
      };
    
      const handleMouseMove = (e) => {
        if (!isDrawing) return;
    
        const { x, y } = e.target.getStage().getPointerPosition();
        setNewShape((prevShape) => ({
          ...prevShape,
          width: x - prevShape.x,
          height: y - prevShape.y,
        }));
      };
    
      const handleMouseUp = () => {
        setShapes((prevShapes) => [...prevShapes, newShape]);
        setNewShape(null);
        setIsDrawing(false);
      };

    useEffect(() => {    
        if (selectedNode) {
            transformerRef.current.nodes([selectedNode]);
            transformerRef.current.getLayer().batchDraw();
        }
    }, [selectedNode]);

    const handleShapeClick = (shape, node) => {
        setSelectedNode(node); 
    };

    return(
        <div id="paintarea">
            <Stage width={stageSize.width} height={stageSize.height}
                onMouseDown={handleMouseDown}
                onMouseMove={handleMouseMove}
                onMouseUp={handleMouseUp}>
                <Layer id='konvaLayer'> 
                <Rect
                    x={200}
                    y={100}
                    width={300}
                    height={100}
                    fill="red"
                    shadowBlur={10}
                    draggable 
                    onClick={(e) => handleShapeClick(shape, e.target)} 
                />
                {selectedNode && <Transformer ref={transformerRef} />}
                <Circle x={1000} y={200} radius={50} fill="green" />

                </Layer>
            </Stage>
        </div>
    );
}

export default Paintarea