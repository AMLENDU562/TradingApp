import React,{useEffect, useState} from 'react'
import Tableform from '../../components/Tableform';
export default function FastTradeTeam() {
    const [list,setList]=useState([])
    const columns = [
        'Id','Name','Sponsor Code','Sponsor Activation Amount','Sponsor Activation Date','User Id',
        'User Activation Amount','User Activation Date','Days','Status'];

   

    useEffect(() => {
      // Define an async function inside the useEffect
      const fetchData = async () => {
        try {
          const response = await fetch(`http://localhost:8080/api/FastTradeTeam/all/602`, {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
            },
          });
  
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
  
          const data = await response.json(); // Parse the response as JSON
          setList(data);
          console.log(list) // Set the data to the state
        } catch (error) {
          console.error('There was a problem with the fetch operation:', error);
        }
      };
  
      fetchData(); // Call the async function
    }, [list]);

  return (
    <div style={{backgroundColor:"white",width:"70%",margin:"20px auto",padding:"20px"}}>
      
        <h3 style={{textAlign:"left",paddingLeft:"85px",color:"#4158A6"}}>Fast Trade Users</h3>
        {<Tableform header={columns} data={list} />}   
           
    </div>
  )
}
