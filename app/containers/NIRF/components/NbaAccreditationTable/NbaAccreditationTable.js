import React, { Fragment, useState } from 'react';
import './NbaAccreditationTable.css';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import { ButtonGroup, Button } from '@mui/material';

const options = ['Yes', 'No', 'Yes, more than 80% of the building'];

function NbaAccreditationTable() {
  const [nbaInputBody01, setNbaBodyText01] = useState('');

  const dataObject = {
    nbaInputBody01Value: nbaInputBody01,

  };

  const saveFormData = async () => {
    const response = await fetch('', {
      method: 'POST',
      body: JSON.stringify(dataObject)
    });
    if (response.status !== 200) {
      throw new Error(`Request failed: ${response.status}`);
    }
  };

  const onSubmit = async (event) => {
    event.preventDefault();
    if (nbaInputBody01 === '') {
      alert('please fill the academic year field');
    }
  };

  return (
    <div className='table-bg'>
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="nba-table">
          <thead></thead>
          <tbody>
            <tr>
              <td>
                        1. Does your institute have a valid NBA Accreditation?
              </td>
              <td style={{ width: '50%' }}>
                <Autocomplete
                  id="program-input-dropdown"
                  options={options}
                  renderInput={(params) => <TextField {...params}
                    required="required"
                    placeholder="Select Academic Year"
                    id="nba-input01"
                    variant="filled"
                    value={nbaInputBody01}
                    onChange={(e) => setNbaBodyText01(e.target.value)}
                  />}
                />
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>

  );
}

export default NbaAccreditationTable;
