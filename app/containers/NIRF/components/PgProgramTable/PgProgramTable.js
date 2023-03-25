import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './PgProgramTable.css';
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
const pgStudent = [
  { id: 1, pgStudentText: 'Academic Year' },
  { id: 2, pgStudentText: 'No. of first year students intake in the year' },
  { id: 3, pgStudentText: 'No. of first year students admitted in the year' },
  { id: 4, pgStudentText: 'Academic Year' },
  {
    id: 5,
    pgStudentText: 'No. of students graduating in minimum stipulated time',
  },
  { id: 6, pgStudentText: 'No. of students placed' },
  { id: 7, pgStudentText: 'Median salary of placed graduates(Amount in Rs.)' },
  { id: 8, pgStudentText: 'No. of students selected for Higher Studies' },
];
function PgProgramTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [pgProgramInput, setPgProgramInput] = useState('');
  const [pgProgramInputBody01, setPgProgramBodyText01] = useState('');
  const [pgProgramInputBody02, setPgProgramBodyText02] = useState('');
  const [pgProgramInputBody03, setPgProgramBodyText03] = useState('');
  const [pgProgramInputBody04, setPgProgramBodyText04] = useState('');
  const [pgProgramInputBody05, setPgProgramBodyText05] = useState('');
  const [pgProgramInputBody06, setPgProgramBodyText06] = useState('');
  const [pgProgramInputBody07, setPgProgramBodyText07] = useState('');

  const dataObject = {
    pgProgramInputValue: pgProgramInput,
    pgProgramInputBody01Value: pgProgramInputBody01,
    pgProgramInputBody02Value: pgProgramInputBody02,
    pgProgramInputBody03Value: pgProgramInputBody03,
    pgProgramInputBody04Value: pgProgramInputBody04,
    pgProgramInputBody05Value: pgProgramInputBody05,
    pgProgramInputBody06Value: pgProgramInputBody06,
    pgProgramInputBody07Value: pgProgramInputBody07,
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
    if (pgProgramInput === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody04 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramInputBody07 === '') {
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
                id="pg-program-input"
                placeholder="Enter Degree Program"
                variant="filled"
                value={pgProgramInput}
                onChange={(e) => setPgProgramInput(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input01"
            variant="filled"
            value={pgProgramInputBody01}
            onChange={(e) => setPgProgramBodyText01(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input02"
            variant="filled"
            value={pgProgramInputBody02}
            onChange={(e) => setPgProgramBodyText02(e.target.value)}
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
                id="pg-program-input03"
                variant="filled"
                value={pgProgramInputBody03}
                onChange={(e) => setPgProgramBodyText03(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input04"
            variant="filled"
            value={pgProgramInputBody04}
            onChange={(e) => setPgProgramBodyText04(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input05"
            variant="filled"
            value={pgProgramInputBody05}
            onChange={(e) => setPgProgramBodyText05(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input06"
            variant="filled"
            value={pgProgramInputBody06}
            onChange={(e) => setPgProgramBodyText06(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input07"
            variant="filled"
            value={pgProgramInputBody07}
            onChange={(e) => setPgProgramBodyText07(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <>
      <div className="table-bg">
        <form className="table-wrapper" onSubmit={onSubmit}>
          <table className="pg-programs-table">
            <thead>
              <tr>
                {pgStudent.map((eachColumn) => (
                  <th key={eachColumn.id}>{eachColumn.pgStudentText}</th>
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

export default PgProgramTable;
