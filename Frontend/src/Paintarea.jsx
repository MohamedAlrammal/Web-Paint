import { useEffect, useState, useRef } from 'react';
import { Stage, Layer, Transformer } from 'react-konva';
import axios from "axios";

function Paintarea(props) {
    const [stageSize, setStageSize] = useState({ width: 1450, height: 545 });
    const [newID, setNewID] = useState("0");
    const [shapes, setShapes] = useState([]);
    const [isDrawing, setIsDrawing] = useState(false);
    const [newShape, setNewShape] = useState(null);
    const layerRef = useRef(null);
    const transformerRef = useRef(null);
    const [selectedNode, setSelectedNode] = useState(null); // Track the currently selected shape

    // Handle resizing of the canvas area
    useEffect(() => {
        const handleResize = () => {
            const container = document.getElementById("paintarea");
            setStageSize({
                width: container.offsetWidth,
                height: container.offsetHeight,
            });
        };

        handleResize();
        window.addEventListener("resize", handleResize);

        return () => {
            window.removeEventListener("resize", handleResize);
        };
    }, []);

    // Handle mouse down event to start drawing a new shape
    const handleMouseDown = async (e) => {
        if (props.shapeType) {
            const { x, y } = e.target.getStage().getPointerPosition();

            try {
                const response = await axios.post("http://localhost:8088/paint/create", {
                    name: props.shapeType,
                    id: newID,
                    x,
                    y,
                });

                const shapeData = response.data;
                const shape = new Konva[shapeData.name]({
                    ...shapeData,
                });

                setNewShape(shape);
                layerRef.current.add(shape);
                layerRef.current.draw();
                setIsDrawing(true);
            } catch (error) {
                console.error("Error creating shape:", error);
            }
        }
    };

    // Handle mouse move event to resize the shape while drawing
    const handleMouseMove = (e) => {
        if (!isDrawing || !newShape) return;

        const { x, y } = e.target.getStage().getPointerPosition();
        newShape.width(Math.abs(x - newShape.x()));
        newShape.height(Math.abs(y - newShape.y()));
        layerRef.current.batchDraw();
    };

    // Handle mouse up event to finalize the drawing
    const handleMouseUp = async () => {
        if (!isDrawing || !newShape) return;

        try {
            await axios.put("http://localhost:8088/paint/update", {
                name: newShape.name(),
                id: newID,
                width: newShape.width(),
                height: newShape.height(),
            });

            setShapes((prevShapes) => [...prevShapes, newShape]);
            setNewShape(null);
            setNewID((prevID) => (parseInt(prevID) + 1).toString());
            setIsDrawing(false);
        } catch (error) {
            console.error("Error updating shape:", error);
        }
    };

    // Update the transformer whenever the selected node changes
    useEffect(() => {
        if (selectedNode) {
            transformerRef.current.nodes([selectedNode]);
            transformerRef.current.getLayer().batchDraw();
        }
    }, [selectedNode]);

    // Update the fill color of the selected shape
    useEffect(() => {
        if (selectedNode) {
            selectedNode.fill(props.color);
            layerRef.current.batchDraw();
        }
    }, [props.color]);

    // Update the stroke color of the selected shape
    useEffect(() => {
        if (selectedNode) {
            selectedNode.stroke(props.strokeColor);
            layerRef.current.batchDraw();
        }
    }, [props.strokeColor]);
    // Listen for changes in opacity and apply it to the selected shape
useEffect(() => {
  if (selectedNode) {
      selectedNode.opacity(props.opacity);
      layerRef.current.batchDraw();
  }
}, [props.opacity]);


    // Handle stage click to select or deselect shapes
    const handleClick = (e) => {
        if (e.target instanceof Konva.Stage) {
            setSelectedNode(null);
        } else {
            setSelectedNode(e.target);
        }
    };

    return (
        <div id="paintarea" style={{ width: "100%", height: "100%" }}>
            <Stage
                width={stageSize.width}
                height={stageSize.height}
                onMouseDown={handleMouseDown}
                onMouseMove={handleMouseMove}
                onMouseUp={handleMouseUp}
                onClick={handleClick}
            >
                <Layer ref={layerRef}>
                    {selectedNode && <Transformer ref={transformerRef} />}
                </Layer>
            </Stage>
        </div>
    );
}

export default Paintarea;
