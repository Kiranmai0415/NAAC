import React, { useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './FacultyDetailsTable.css';
import { ButtonGroup, Button } from '@mui/material';

const facultyDetails = [
  { id: 1, displayText: 'Sno' },
  { id: 2, displayText: 'Name' },
  { id: 3, displayText: 'Age' },
  { id: 4, displayText: 'Designation' },
  { id: 5, displayText: 'Gender' },
  { id: 6, displayText: 'Qualification' },
  { id: 7, displayText: 'Experience (In Months)' },
  { id: 8, displayText: 'Currently working with institution?' },
  { id: 9, displayText: 'Joining Date' },
  { id: 10, displayText: 'Leaving Date' },
  { id: 11, displayText: 'Association type' },
];

const options = ['Yes', 'No'];
const gender = ['Male', 'Female', 'Other'];
const type = ['Regular', 'Adhoc / Contractual'];

function FacultyDetailsTable() {
  const [academicFacultyDetailsRow, setAcademicFacultyDetailsRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [facultyDetailsInput, setFacultyDetailsInput] = useState('');
  const [facultyDetailsInputBody01, setFacultyDetailsBodyText01] = useState('');
  const [facultyDetailsInputBody02, setFacultyDetailsBodyText02] = useState('');
  const [facultyDetailsInputBody03, setFacultyDetailsBodyText03] = useState('');
  const [facultyDetailsInputBody04, setFacultyDetailsBodyText04] = useState('');
  const [facultyDetailsInputBody05, setFacultyDetailsBodyText05] = useState('');
  const [facultyDetailsInputBody06, setFacultyDetailsBodyText06] = useState('');
  const [facultyDetailsInputBody07, setFacultyDetailsBodyText07] = useState('');
  const [facultyDetailsInputBody08, setFacultyDetailsBodyText08] = useState('');
  const [facultyDetailsInputBody09, setFacultyDetailsBodyText09] = useState('');
  const [facultyDetailsInputBody10, setFacultyDetailsBodyText10] = useState('');

  const dataObject = {
    facultyDetailsInputValue: facultyDetailsInput,
    facultyDetailsInputBody01Value: facultyDetailsInputBody01,
    facultyDetailsInputBody02Value: facultyDetailsInputBody02,
    facultyDetailsInputBody03Value: facultyDetailsInputBody03,
    facultyDetailsInputBody04Value: facultyDetailsInputBody04,
    facultyDetailsInputBody05Value: facultyDetailsInputBody05,
    facultyDetailsInputBody06Value: facultyDetailsInputBody06,
    facultyDetailsInputBody07Value: facultyDetailsInputBody07,
    facultyDetailsInputBody08Value: facultyDetailsInputBody08,
    facultyDetailsInputBody09Value: facultyDetailsInputBody09,
    facultyDetailsInputBody10Value: facultyDetailsInputBody10,
  };
  const disable = () => {
    if (numberOfRows <= 0) {
      setIsValidDisable(true);
    } else {
      setIsValidDisable(false);
    }
  };
  function onAddingRow() {
    disable();
    console.log('adding', numberOfRows);
    setNumberOFRows(numberOfRows + 1);
  }
  function onDeletingRow() {
    disable();
    console.log(numberOfRows);
    if (numberOfRows >= 2) {
      setNumberOFRows(numberOfRows - 1);
    } else {
      setNumberOFRows(1);
    }
  }

  const saveFormData = async () => {
    const response = await fetch('', {
      method: 'POST',
      body: JSON.stringify(dataObject),
    });
    if (response.status !== 200) {
      throw new Error(`Request failed: ${response.status}`);
    }
  };

  const onSubmit = async (event) => {
    event.preventDefault();
    if (facultyDetailsInput === '') {
      alert('please fill the SNo field');
    }
    if (facultyDetailsInputBody01 === '') {
      alert('please fill the Name field');
    }
    if (facultyDetailsInputBody02 === '') {
      alert('please fill the Age field');
    }
    if (facultyDetailsInputBody03 === '') {
      alert('please fill the Designation field');
    }
    if (facultyDetailsInputBody04 === '') {
      alert('please fill the Gender field');
    }
    if (facultyDetailsInputBody05 === '') {
      alert('please fill the Qualification field');
    }
    if (facultyDetailsInputBody05 === '') {
      alert('please fill the Experience field');
    }
    if (facultyDetailsInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (facultyDetailsInputBody07 === '') {
      alert('please select the Yes or No field');
    }
    if (facultyDetailsInputBody08 === '') {
      alert('please select the Joining Date field');
    }
    if (facultyDetailsInputBody09 === '') {
      alert('please select the Leaving Date field');
    }
    if (facultyDetailsInputBody10 === '') {
      alert('please select the Association type field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td style={{ width: '10%' }}>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="facultydetails-input01"
            variant="filled"
            value={facultyDetailsInput}
            onChange={(e) => setFacultyDetailsInput(e.target.value)}
          />
        </td>
        <td style={{ width: '15%' }}>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="facultydetails-input01"
            variant="filled"
            value={facultyDetailsInputBody01}
            onChange={(e) => setFacultyDetailsBodyText01(e.target.value)}
          />
        </td>
        <td style={{ width: '10%' }}>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Age"
            id="facultydetails-input02"
            variant="filled"
            value={facultyDetailsInputBody02}
            onChange={(e) => setFacultyDetailsBodyText02(e.target.value)}
          />
        </td>
        <td style={{ width: '15%' }}>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Role"
            id="facultydetails-input03"
            variant="filled"
            value={facultyDetailsInputBody03}
            onChange={(e) => setFacultyDetailsBodyText03(e.target.value)}
          />
        </td>
        <td style={{ width: '10%' }}>
          <Autocomplete
            id="facultydetails-input-dropdown"
            options={gender}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                placeholder="Select Gender"
                id="facultydetails-input04"
                variant="filled"
                value={facultyDetailsInputBody04}
                onChange={(e) => setFacultyDetailsBodyText04(e.target.value)}
              />
            )}
          />
        </td>
        <td style={{ width: '10%' }}>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Degree"
            id="facultydetails-input05"
            variant="filled"
            value={facultyDetailsInputBody05}
            onChange={(e) => setFacultyDetailsBodyText05(e.target.value)}
          />
        </td>
        <td style={{ width: '10%' }}>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Experience"
            id="facultydetails-input06"
            variant="filled"
            value={facultyDetailsInputBody06}
            onChange={(e) => setFacultyDetailsBodyText06(e.target.value)}
          />
        </td>
        <td style={{ width: '10%' }}>
          <Autocomplete
            id="facultydetails-input-dropdown"
            options={options}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                placeholder="Select Yes or No"
                id="facultydetails-input07"
                variant="filled"
                value={facultyDetailsInputBody07}
                onChange={(e) => setFacultyDetailsBodyText07(e.target.value)}
              />
            )}
          />
        </td>
        <td style={{ width: '10%' }}>
          <TextField
            style={{ width: '100%' }}
            id="date1"
            type="date"
            defaultValue=" "
            InputLabelProps={{
              shrink: true,
            }}
            variant="filled"
            value={facultyDetailsInputBody08}
            onChange={(e) => setFacultyDetailsBodyText08(e.target.value)}
          />
        </td>
        <td style={{ width: '10%' }}>
          <TextField
            style={{ width: '100%' }}
            id="date2"
            type="date"
            defaultValue=" "
            InputLabelProps={{
              shrink: true,
            }}
            variant="filled"
            value={facultyDetailsInputBody09}
            onChange={(e) => setFacultyDetailsBodyText09(e.target.value)}
          />
        </td>
        <td style={{ width: '10%' }}>
          <Autocomplete
            id="facultydetails-input-dropdown"
            options={type}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                placeholder="Select Yes or No"
                id="facultydetails-input10"
                variant="filled"
                value={facultyDetailsInputBody10}
                onChange={(e) => setFacultyDetailsBodyText10(e.target.value)}
              />
            )}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="faculty-details-table">
          <thead>
            <tr>
              {facultyDetails.map((eachColumn) => (
                <th key={eachColumn.id}>{eachColumn.displayText}</th>
              ))}
            </tr>
          </thead>
          {[...Array(academicFacultyDetailsRow)].map(
            (elementInArray, index) => tableBody()
          )}
        </table>
        <ButtonGroup
          id="buttons-div"
          disableElevation
          variant="contained"
          aria-label="Disabled elevation buttons"
        >
          <Button
            id="add-row-sanctioned"
            onClick={() => {
              setAcademicFacultyDetailsRow(academicFacultyDetailsRow + 1);
              onAddingRow();
            }}
          >
            +
          </Button>
          <Button disabled>Row</Button>
          <Button
            id="minus-row-sanctioned"
            disabled={isValidDisable}
            onClick={() => {
              setAcademicFacultyDetailsRow(academicFacultyDetailsRow - 1);
              onDeletingRow();
            }}
          >
            -
          </Button>
          <Button
            id="save-sanctioned"
            variant="contained"
            onClick={saveFormData}
          >
            Save
          </Button>
        </ButtonGroup>
      </form>
    </div>
  );
}

export default FacultyDetailsTable;
