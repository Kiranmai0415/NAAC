import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './UGProgramTable.css';
import { ButtonGroup, Button } from '@mui/material';

const academicYear = [
  '2020-21',
  '2019-20',
  '2018-19',
  '2017-18',
  '2016-17',
  '2015-16',
  '2014-15',
  '2013-14',
  '2012-13',
  '2011-12',
  '2010-11',
];
const ugStudent = [
  { id: 1, ugStudentText: 'Academic Year' },
  { id: 2, ugStudentText: 'No. of first year students intake in the year' },
  { id: 3, ugStudentText: 'No. of first year students admitted in the year' },
  { id: 4, ugStudentText: 'Academic Year' },
  { id: 5, ugStudentText: 'No. of students admitted through Lateral entry' },
  { id: 6, ugStudentText: 'Academic Year' },
  {
    id: 7,
    ugStudentText: 'No. of students graduating in minimum stipulated time',
  },
  { id: 8, ugStudentText: 'No. of students placed' },
  { id: 9, ugStudentText: 'Median salary of placed graduates(Amount in Rs.)' },
  { id: 10, ugStudentText: 'No. of students selected for Higher Studies' },
];

function UGProgramTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [ugProgramInput, setUgProgramInput] = useState('');
  const [ugProgramInputBody01, setUgProgramBodyText01] = useState('');
  const [ugProgramInputBody02, setUgProgramBodyText02] = useState('');
  const [ugProgramInputBody03, setUgProgramBodyText03] = useState('');
  const [ugProgramInputBody04, setUgProgramBodyText04] = useState('');
  const [ugProgramInputBody05, setUgProgramBodyText05] = useState('');
  const [ugProgramInputBody06, setUgProgramBodyText06] = useState('');
  const [ugProgramInputBody07, setUgProgramBodyText07] = useState('');
  const [ugProgramInputBody08, setUgProgramBodyText08] = useState('');
  const [ugProgramInputBody09, setUgProgramBodyText09] = useState('');

  const dataObject = {
    ugProgramInputValue: ugProgramInput,
    ugProgramInputBody01Value: ugProgramInputBody01,
    ugProgramInputBody02Value: ugProgramInputBody02,
    ugProgramInputBody03Value: ugProgramInputBody03,
    ugProgramInputBody04Value: ugProgramInputBody04,
    ugProgramInputBody05Value: ugProgramInputBody05,
    ugProgramInputBody06Value: ugProgramInputBody06,
    ugProgramInputBody07Value: ugProgramInputBody07,
    ugProgramInputBody08Value: ugProgramInputBody08,
    ugProgramInputBody09Value: ugProgramInputBody09,
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
    if (ugProgramInput === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody04 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody07 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody08 === '') {
      alert('please fill the academic year field');
    }
    if (ugProgramInputBody09 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td>
          <Autocomplete
            id="program-input-dropdown"
            options={academicYear}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="ug-program-input"
                placeholder="Select Academic Year"
                variant="filled"
                value={ugProgramInput}
                onChange={(e) => setUgProgramInput(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input01"
            variant="filled"
            value={ugProgramInputBody01}
            onChange={(e) => setUgProgramBodyText01(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input02"
            variant="filled"
            value={ugProgramInputBody02}
            onChange={(e) => setUgProgramBodyText02(e.target.value)}
          />
        </td>
        <td>
          <Autocomplete
            id="program-input-dropdown"
            options={academicYear}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="ug-program-input03"
                placeholder="Select Academic Year"
                variant="filled"
                value={ugProgramInputBody03}
                onChange={(e) => setUgProgramBodyText03(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input04"
            variant="filled"
            value={ugProgramInputBody04}
            onChange={(e) => setUgProgramBodyText04(e.target.value)}
          />
        </td>
        <td>
          <Autocomplete
            id="program-input-dropdown"
            options={academicYear}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                placeholder="Select Academic Year"
                id="ug-program-input05"
                variant="filled"
                value={ugProgramInputBody05}
                onChange={(e) => setUgProgramBodyText05(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input06"
            variant="filled"
            value={ugProgramInputBody06}
            onChange={(e) => setUgProgramBodyText06(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input07"
            variant="filled"
            value={ugProgramInputBody07}
            onChange={(e) => setUgProgramBodyText07(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input08"
            variant="filled"
            value={ugProgramInputBody08}
            onChange={(e) => setUgProgramBodyText08(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="ug-program-input09"
            variant="filled"
            value={ugProgramInputBody09}
            onChange={(e) => setUgProgramBodyText09(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <>
      <div className="table-bg">
        <form className="table-wrapper" onSubmit={onSubmit}>
          <table className="ug-programs-table">
            <thead>
              <tr>
                {ugStudent.map((eachColumn) => (
                  <th key={eachColumn.id}>{eachColumn.ugStudentText}</th>
                ))}
              </tr>
            </thead>
            {[...Array(academicProgramRow)].map((elementInArray, index) => tableBody())}
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
    </>
  );
}

export default UGProgramTable;
