import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Header from './Header'
import Footer from './Footer'
import Paint from './Paint'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Header />
    <Paint/>
    <Footer/>
  </StrictMode>
)
