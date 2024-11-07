import Paintarea from './Paintarea'
import Sidebar from './Sidebar'
import Toolbar from './Toolbar'

function Paint(){
    return(
    <main>
        <Sidebar/>
        <div className="container">
            <Toolbar/>
            <Paintarea/>
        </div>
      </main>
    )
}

export default Paint