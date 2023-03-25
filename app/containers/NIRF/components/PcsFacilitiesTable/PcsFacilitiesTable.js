import React, { Fragment, useState } from 'react';
import './PcsFacilitiesTable.css';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import { ButtonGroup, Button } from '@mui/material';

const options = ['Yes', 'No', 'Yes, more than 80% of the building'];

function PcsFacilities() {
  const [pcsFacilitiesInputBody01, setPcsFacilitiesBodyText01] = useState('');
  const [pcsFacilitiesInputBody02, setPcsFacilitiesBodyText02] = useState('');
  const [pcsFacilitiesInputBody03, setPcsFacilitiesBodyText03] = useState('');

  const dataObject = {
    pcsFacilitiesInputBody01Value: pcsFacilitiesInputBody01,
    pcsFacilitiesInputBody02Value: pcsFacilitiesInputBody02,
    pcsFacilitiesInputBody03Value: pcsFacilitiesInputBody03,

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
    if (pcsFacilitiesInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (pcsFacilitiesInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (pcsFacilitiesInputBody03 === '') {
      alert('please fill the academic year field');
    }
  };

  return (
    <div className='table-bg'>
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="pcs-facilities-table">
          <thead></thead>
          <tbody>
            <tr>
              <td>
                        1. Do your institution buildings have Lifts/Ramps?
              </td>
              <td style={{ width: '50%' }}>
                <Autocomplete
                  id="program-input-dropdown"
                  options={options}
                  renderInput={(params) => <TextField {...params}
                    required="required"
                    placeholder="Select Academic Year"
                    id="pcs-facilities-input01"
                    variant="filled"
                    value={pcsFacilitiesInputBody01}
                    onChange={(e) => setPcsFacilitiesBodyText01(e.target.value)}
                  />}
                />
              </td>
            </tr>
            <tr>
              <td>
                        2. Do your institution have provision for walking aids, including wheelchairs and transportation from one building to another for handicapped students?
              </td>
              <td>
                <Autocomplete
                  id="program-input-dropdown"
                  options={options}
                  renderInput={(params) => <TextField {...params}
                    required="required"
                    placeholder="Select Academic Year"
                    id="pcs-facilities-input02"
                    variant="filled"
                    value={pcsFacilitiesInputBody02}
                    onChange={(e) => setPcsFacilitiesBodyText02(e.target.value)}
                  />}
                />
              </td>
            </tr>
            <tr>
              <td>
                        3. Do your institution buildings have specially designed toilets for handicapped students?
              </td>
              <td>
                <Autocomplete
                  id="program-input-dropdown"
                  options={options}
                  renderInput={(params) => <TextField {...params}
                    required="required"
                    placeholder="Select Academic Year"
                    id="pcs-facilities-input03"
                    variant="filled"
                    value={pcsFacilitiesInputBody03}
                    onChange={(e) => setPcsFacilitiesBodyText03(e.target.value)}
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

export default PcsFacilities;
