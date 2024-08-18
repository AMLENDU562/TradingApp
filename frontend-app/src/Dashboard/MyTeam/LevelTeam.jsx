import React, { useEffect, useState } from 'react';
import Tableform from '../../components/Tableform';
import { useParams } from 'react-router-dom';

export default function LevelTeam() {
    const [list, setList] = useState([]);
    const { level } = useParams();
    const columns = ['Id', 'Sponsor Id', 'Name', 'Amount', 'Level Trade Income', 'Level', 'User Id'];

    useEffect(() => {
        // Define an async function inside the useEffect
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/LevelTeam/all/602/${level}`, {
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
            } catch (error) {
                console.error('There was a problem with the fetch operation:', error);
            }
        };

        fetchData(); // Call the async function
    }, [level]); // Only fetch data when `level` changes

    return (
        <div style={{ backgroundColor: "white", width: "70%", margin: "20px auto", padding: "20px" }}>
            <h3 style={{ textAlign: "left", paddingLeft: "85px", color: "#4158A6" }}>Level Team</h3>
            <Tableform header={columns} data={list} />
        </div>
    );
}
