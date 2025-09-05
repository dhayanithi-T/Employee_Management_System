import './App.css';
import {BrowserRouter, Routes, Route } from 'react-router-dom';
import Footer from './components/Footer'; 
import  Header from './components/Header';
import ListEmployeeComponent from './components/listemployee';
import EmployeeComponent from './components/EmployeeComponent';
function App() {
  return (
    <div>
        <BrowserRouter>
         <Header />
         <Footer />
        <div className= "container">
          <Routes>
              <Route path = "/" element = { <ListEmployeeComponent /> }></Route>
              <Route path = "/employees" element = { <ListEmployeeComponent /> }></Route>
              <Route path = "/add-employee" element = { <EmployeeComponent />} ></Route>
              <Route path = "/edit-employee/:id" element = { <EmployeeComponent />}></Route>
            </Routes>
     
  </div>
      
      </BrowserRouter>
   </div>
  );
}

export default App;