import { useEffect, useState, useRef } from 'react';
import { Stage, Layer, Transformer, Rect, Text, Circle, Line } from 'react-konva';
import axios from "axios";

function Paintarea(props){
    const [stageSize, setStageSize] = useState({width:1450,height:545});
    const [newID, setNewID] = useState("0");

    useEffect(() => {
            const handleResize = () => {
            const container = document.getElementById("paintarea");
            console.log(container);
            console.log(document.getElementById("konvaLayer"));
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
    const layerRef = useRef(null);
    const [selectedNode, setSelectedNode] = useState(null); // Track the currently selected shape
    const transformerRef = useRef(null);
    
      const handleMouseDown = async (e) => {
        if(props.shapeType != null){
          const { x, y } = e.target.getStage().getPointerPosition();
          console.log(layerRef);
          console.log(props.shapeType);
          console.log(typeof(props.shapeType));
          const response = await axios.post("http://localhost:8080/paint/create", {
            "name": props.shapeType,
            "id" : newID,
            "x": x,
            "y": y
          });
          console.log(response.data);
          const shape = new Konva[response.data.name](response.data);
        setNewShape(shape);
        layerRef.current.add(shape);
        layerRef.current.draw();
        setIsDrawing(true);
        }
      };
    
      const handleMouseMove = (e) => {
        if (!isDrawing) return;
        const { x, y } = e.target.getStage().getPointerPosition();
        newShape.width(Math.abs(x - newShape.x()));
        newShape.height(Math.abs(y - newShape.y()));
        layerRef.current.batchDraw();
    };
    
      const handleMouseUp = () => {
        if (!isDrawing) return;
        const response = axios.put("http://localhost:8080/paint/update", {
          "name": newShape.name(),
          "id" : newID,
          "width": newShape.width(),
          "height": newShape.height()
        });
        console.log(response);
        setShapes((prevShapes) => [...prevShapes, newShape]);
        setNewShape(null);
        setNewID(n => (parseInt(n) + 1).toString());
        setIsDrawing(false);
      };

      useEffect(() => {
        if (selectedNode) {
            transformerRef.current.nodes([selectedNode]);
            transformerRef.current.getLayer().batchDraw();
        }
      }, [selectedNode]);

      useEffect(() => {
        console.log(selectedNode);
        if (selectedNode != null) {
            selectedNode.fill(props.color);
            layerRef.current.batchDraw();
        }
      }, [props.color]);

      useEffect(() => {
        console.log(selectedNode);
        if (selectedNode != null) {
            selectedNode.stroke(props.strokeColor);
            layerRef.current.batchDraw();
        }
      }, [props.strokeColor]);

      const handleClick = (e) => {
        if(e.target instanceof Konva.Stage){
          setSelectedNode(null);
        }
        else{
          setSelectedNode(e.target);
        } 
      };

    return(
        <div id="paintarea">
            <Stage width={stageSize.width} height={stageSize.height}
                onMouseDown={handleMouseDown}
                onMouseMove={handleMouseMove}
                onMouseUp={handleMouseUp}
                onClick={handleClick}>
                <Layer ref={layerRef}>
                  {selectedNode && <Transformer ref={transformerRef} />}
                </Layer>
            </Stage>
        </div>
    );
}

export default Paintarea