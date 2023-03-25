import React, { useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './OnlineEducationTable.css';
import { ButtonGroup, Button } from '@mui/material';

import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';

const options = ['Yes', 'No'];

function OnlineEducation() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [onlineEducationInputBody01, setOnlineEducationBodyText01] = useState('');
  const [onlineEducationInputBody02, setOnlineEducationBodyText02] = useState('');
  const [onlineEducationInputBody03, setOnlineEducationBodyText03] = useState('');
  const [onlineEducationInputBody04, setOnlineEducationBodyText04] = useState('');
  const [onlineEducationInputBody05, setOnlineEducationBodyText05] = useState('');
  const [onlineEducationInputBody06, setOnlineEducationBodyText06] = useState('');
  const [onlineEducationInputBody07, setOnlineEducationBodyText07] = useState('');
  const [onlineEducationInputBody08, setOnlineEducationBodyText08] = useState('');
  const [onlineEducationInputBody09, setOnlineEducationBodyText09] = useState('');

  const dataObject = {
    onlineEducationInputBody01Value: onlineEducationInputBody01,
    onlineEducationInputBody02Value: onlineEducationInputBody02,
    onlineEducationInputBody03Value: onlineEducationInputBody03,
    onlineEducationInputBody04Value: onlineEducationInputBody04,
    onlineEducationInputBody05Value: onlineEducationInputBody05,
    onlineEducationInputBody06Value: onlineEducationInputBody06,
    onlineEducationInputBody07Value: onlineEducationInputBody07,
    onlineEducationInputBody08Value: onlineEducationInputBody08,
    onlineEducationInputBody09Value: onlineEducationInputBody09,
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
    if (onlineEducationInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody04 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody07 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody08 === '') {
      alert('please fill the academic year field');
    }
    if (onlineEducationInputBody09 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tr>
      <td>
        <TextField
          style={{ width: '100%' }}
          required="required"
          placeholder="Enter Name"
          id="online-education-input05"
          variant="filled"
          value={onlineEducationInputBody05}
          onChange={(e) => setOnlineEducationBodyText05(e.target.value)}
        />
      </td>
      <td>
        <TextField
          style={{ width: '100%' }}
          required="required"
          placeholder="Enter Number"
          id="online-education-input06"
          variant="filled"
          value={onlineEducationInputBody06}
          onChange={(e) => setOnlineEducationBodyText06(e.target.value)}
        />
      </td>
      <td>
        <TextField
          style={{ width: '100%' }}
          required="required"
          placeholder="Enter Number"
          id="online-education-input07"
          variant="filled"
          value={onlineEducationInputBody07}
          onChange={(e) => setOnlineEducationBodyText07(e.target.value)}
        />
      </td>
      <td>
        <TextField
          style={{ width: '100%' }}
          required="required"
          placeholder="Enter Number"
          id="online-education-input08"
          variant="filled"
          value={onlineEducationInputBody08}
          onChange={(e) => setOnlineEducationBodyText08(e.target.value)}
        />
      </td>
    </tr>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="online-education-table">
          <thead></thead>
          <tbody>
            <tr>
              <td colspan="2">
                1. Does all programs/courses were completed on time.
              </td>
              <td colspan="2">
                <Autocomplete
                  id="header-academic-year03"
                  options={options}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      placeholder="Select Yes or No"
                      id="online-education-input01"
                      variant="filled"
                      value={onlineEducationInputBody01}
                      onChange={(e) => setOnlineEducationBodyText01(e.target.value)
                      }
                    />
                  )}
                />
              </td>
            </tr>
            <tr>
              <td colspan="2">
                2. Measures taken to complete the syllabus of courses and
                programs.
              </td>
              <td colspan="2">
                <ReactQuill
                  style={{ backgroundColor: 'white' }}
                  theme="snow"
                  placeholder="Mention the details of syllabus "
                  id="online-education-input02"
                  variant="filled"
                  value={onlineEducationInputBody02}
                  onChange={(e) => setOnlineEducationBodyText02(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td colspan="2">
                3. The period of delay in completion of syllabus (in months).
              </td>
              <td colspan="2">
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="online-education-input03"
                  variant="filled"
                  value={onlineEducationInputBody03}
                  onChange={(e) => setOnlineEducationBodyText03(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td colspan="2">
                4. The period of delay in conducting exams (in months).
              </td>
              <td colspan="2">
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="online-education-input04"
                  variant="filled"
                  value={onlineEducationInputBody04}
                  onChange={(e) => setOnlineEducationBodyText04(e.target.value)}
                />
              </td>
            </tr>
          </tbody>
          <thead>
            <tr>
              <th style={{ width: '20%' }}>Portal Name</th>
              <th>
                No. of students offered online courses which have credit
                transferred to transcript
              </th>
              <th>
                Total no. of online courses which have credit transferred to the
                transcript
              </th>
              <th>Total no. of credits transferred to transcript</th>
            </tr>
          </thead>
          <tbody>
            {[...Array(academicProgramRow)].map((elementInArray, index) => tableBody())}
            <tr>
              <td colspan="2">
                5. No. of courses developed and available online on{' '}
                {onlineEducationInputBody05} platform by your institution
                faculty
              </td>
              <td colspan="2">
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="online-education-input09"
                  variant="filled"
                  value={onlineEducationInputBody09}
                  onChange={(e) => setOnlineEducationBodyText09(e.target.value)}
                />
              </td>
            </tr>
          </tbody>
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
              setAcademicProgramRow(academicProgramRow + 1);
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
              setAcademicProgramRow(academicProgramRow - 1);
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

export default OnlineEducation;
