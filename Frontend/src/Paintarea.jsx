import { useEffect, useState, useRef } from 'react';
import { Stage, Layer, Transformer, Rect, Text, Circle, Line } from 'react-konva';
import axios from "axios";

function Paintarea(props){
    const [stageSize, setStageSize] = useState({width:1450,height:545});
    const [newID, setNewID] = useState("0");

    //Check weather the page was refreshed or not and send to back to clear data
    /*useEffect(() => {
      if (sessionStorage.getItem('is_reloaded')) {
          alert("Data will be lost");
          //axios.post("http://localhost:8080/paint/clearAll");
      }
    }, []);*/
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

    const [isDrawing, setIsDrawing] = useState(false);
    const [newShape, setNewShape] = useState(null);
    const layerRef = useRef(null);
    const [selectedNode, setSelectedNode] = useState(null); // Track the currently selected shape
    const transformerRef = useRef(null);

    const createShape = async (data) =>{
      console.log(data);
      const shape = new Konva[data.konvaname](data);
      setNewShape(shape);
      layerRef.current.add(shape);
      layerRef.current.draw();
    }
    
      const handleMouseDown = async (e) => {
        if(props.shapeType != null){
          const { x, y } = e.target.getStage().getPointerPosition();
          const response = await axios.post("http://localhost:8080/paint/create", {
            "name": props.shapeType,
            "id" : newID,
            "x": x,
            "y": y
          });
          createShape(response.data);
          setIsDrawing(true);
        }
      };
    
      const handleMouseMove = async (e) => {
        if (!isDrawing) return;
        const { x, y } = e.target.getStage().getPointerPosition();
        const response = await axios.put(`http://localhost:8080/paint/createupdate/${x}/${y}`, {
          name: props.shapeType,
          id: newID,
        });
        console.log("hello");
        console.log(response.data);
        newShape.setAttrs(response.data);
        console.log(newShape);
        layerRef.current.batchDraw();
    };
    
      const handleMouseUp = async () => {
        if (!isDrawing) return;
        await axios.put(`http://localhost:8080/paint/endUpdate/${true}`);
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
            axios.put(`http://localhost:8080/paint/update`,{
              "name": selectedNode.name,
              "id": selectedNode.id,
              "fill": props.color
            });
            selectedNode.fill(props.color);
            layerRef.current.batchDraw();
        }
      }, [props.color]);

      useEffect(() => {
        console.log(selectedNode);
        console.log(props.strokeColor);
        console.log(typeof(props.strokeColor));
        if (selectedNode != null) {
            axios.put(`http://localhost:8080/paint/update`,{
              "name": selectedNode.name(),
              "id": selectedNode.id(),
              "stroke": props.strokeColor
            });
            selectedNode.stroke(props.strokeColor);
            layerRef.current.batchDraw();
        }
      }, [props.strokeColor]);

      useEffect(() => {
        const clone = async () =>{
          console.log(selectedNode);
          if (selectedNode != null && props.copy) {
            const response = await axios.post(`http://localhost:8080/paint/clone/${selectedNode.attrs.id}/${newID}`);
            createShape(response.data);
            setSelectedNode(null);
          }
          props.setCopy(false);
        }
        clone();
      }, [props.copy]);

      useEffect(() => {
        const del = () =>{
          console.log(selectedNode);
          if (selectedNode != null && props.del) {
            axios.delete(`http://localhost:8080/paint/remove/${selectedNode.attrs.id}`);
            selectedNode.remove();
            setSelectedNode(null);
          }
        }
        const clear = () =>{
            layerRef.current.destroyChildren();
            layerRef.current.draw();
            axios.delete(`http://localhost:8080/paint/clearAll`);
        }
        if(props.del){
          del();
          props.setDel(false);
        }
        else if(props.clear){
          clear();
          props.setClear(false);
        }
        
      }, [props.del,props.clear]);

      useEffect(() => {
        const undo = async () => {
            const response = await axios.post(`http://localhost:8080/paint/undo`);
            layerRef.current.destroyChildren();
            layerRef.current.draw();
            if(response.data == ""){return;}
            response.data.forEach(shapeData => {
              console.log(shapeData);
              createShape(shapeData);
            });
          }

        const redo = async () => {
            const response = await axios.post(`http://localhost:8080/paint/redo`);
            if(response.data == ""){return;}
            layerRef.current.destroyChildren();
            layerRef.current.draw();
            response.data.forEach(shapeData => {
              console.log(shapeData);
              createShape(shapeData);
            });
            }
        if (props.undo) {
          undo();
          props.setUndo(false);
        } else if (props.redo) {
          redo();
          props.setRedo(false);
        }
      }, [props.undo, props.redo]);

      
      /*const [directoryPath, setDirectoryPath] = useState('');
  const [directoryContents, setDirectoryContents] = useState([]);
  const [filePath, setFilePath] = useState('');
  const [fileContents, setFileContents] = useState('');
      useEffect(() => {
        async function getDirectory() {
          const handle = await window.showDirectoryPicker();
          console.log(handle);
          return handle;
        }

        async function getFile() {
          const [handle] = await window.showOpenFilePicker();
          console.log(handle);
          return handle;
        }
        
        const save = async () => {
          const handle = await getDirectory();
          const path = handle.name;
          console.log(path);
          setDirectoryPath(path);

      // List contents of the directory
      const contents = [];
      for await (const entry of handle.values()) {
        contents.push(entry.name);
      }
      setDirectoryContents(contents);

      console.log(`Selected directory: ${path}`);
      console.log('Directory contents:', contents);
        }
          
        const load = async () => {
          const handle = await getFile(); // Await the getFile function
    const file = await handle.getFile();
    console.log(file);
    const path = file.name;
    console.log(path);
    setFilePath(path);
        }
      
        if (props.save) {
          save();
        } else if (props.load) {
          load();
        }
      }, [props.save, props.load]);*/

      const [saved, setSaved] = useState(false);
      useEffect(() => {
        const save = async () => {
          const path = window.prompt("Enter The Saving Location:");
          console.log(path);
          if(path != null){
            axios.post(`http://localhost:8080/paint/save?path=${path.replaceAll("\\", "/")}`);
            setSaved(true);
          }
        }
        
        const load = async () => {
          const path = window.prompt("Enter The File Path:");
          console.log(path);
          if(path != null){
            const response = await axios.post(`http://localhost:8080/paint/load?path=${path.replaceAll("\\", "/")}`);
            layerRef.current.destroyChildren();
            layerRef.current.draw();
            response.data.forEach(shapeData => {
              console.log(shapeData);
              createShape(shapeData);
            });
            setSaved(true);
          }
        }
      
        if (props.save) {
          save();
          props.setSave(false);
        } else if (props.load) {
          load();
          props.setLoad(false);
        }
      }, [props.save, props.load]);

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