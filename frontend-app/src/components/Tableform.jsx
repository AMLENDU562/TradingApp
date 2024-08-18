import React from 'react'
import'../styles/Tableform.css'
export default function Tableform(props) {
  return (
    <table>
        <thead>
        <tr>
            {
                props.header.map((data,index)=><th key={index}>{data}</th>)
            }
        </tr>
        </thead>
        
        <tbody>
            {
                props.data.map((rowData, index) => (
                    <tr key={index}>
                        {Object.values(rowData).map((value, colIndex) => (
                            <td key={colIndex}>{value}</td>
                        ))}
                    </tr>
                ))
                
                
            }
        </tbody>
    </table>
  )
}


