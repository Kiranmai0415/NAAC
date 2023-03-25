import React, { Fragment, useState } from 'react';
import './NaacAccreditationTable.css';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import { ButtonGroup, Button } from '@mui/material';

const options = ['Yes', 'No', 'Yes, more than 80% of the building'];

function NaacAccreditationTable() {
  const [naacInputBody01, setNaacBodyText01] = useState('');
  const [naacInputBody02, setNaacBodyText02] = useState('');
  const [naacInputBody03, setNaacBodyText03] = useState('');
  const [naacInputBody04, setNaacBodyText04] = useState('');

  const dataObject = {
    naacInputBody01Value: naacInputBody01,
    naacInputBody02Value: naacInputBody02,
    naacInputBody03Value: naacInputBody03,
    naacInputBody04Value: naacInputBody04,
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
    if (naacInputBody01 === '') {
      alert('please fill the academic year field');
    }
  };

  return (
    <div className='table-bg'>
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="naac-table">
          <thead></thead>
          <tbody>
            <tr>
              <td colSpan="1">
                        1. Does your institute have a valid NAAC Accreditation?
              </td>
              <td style={{ width: '50%' }} colSpan="2">
                <Autocomplete
                  id="program-input-dropdown"
                  options={options}
                  renderInput={(params) => <TextField {...params}
                    required="required"
                    placeholder="Select Academic Year"
                    id="naac-input01"
                    variant="filled"
                    value={naacInputBody01}
                    onChange={(e) => setNaacBodyText01(e.target.value)}
                  />}
                />
              </td>
            </tr>
          </tbody>
          <thead>
            <tr>
              <th style={{ width: '30%' }}>Valid from</th>
              <th>Valid upto</th>
              <th>CGPA</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th>
                <TextField
                  style={{ width: '100%' }}
                  id="date1"
                  type="date"
                  defaultValue=" "
                  InputLabelProps={{
                    shrink: true,
                  }}
                  variant="filled"
                  value={naacInputBody02}
                  onChange={(e) => setNaacBodyText02(e.target.value)}
                />
              </th>
              <th>
                <TextField
                  style={{ width: '100%' }}
                  id="date2"
                  type="date"
                  defaultValue=" "
                  InputLabelProps={{
                    shrink: true,
                  }}
                  variant="filled"
                  value={naacInputBody03}
                  onChange={(e) => setNaacBodyText03(e.target.value)}
                />
              </th>
              <th>
                <TextField
                  style={{ width: '100%' }}
                  id="date3"
                  type="date"
                  defaultValue=" "
                  InputLabelProps={{
                    shrink: true,
                  }}
                  variant="filled"
                  value={naacInputBody04}
                  onChange={(e) => setNaacBodyText04(e.target.value)}
                />
              </th>
            </tr>
          </tbody>
        </table>
      </form>
    </div>

  );
}

export default NaacAccreditationTable;
