import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './PgProgramThreeYears.css';
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
  { id: 5, pgStudentText: 'No. of students admitted through Lateral entry' },
  { id: 6, pgStudentText: 'Academic Year' },
  {
    id: 7,
    pgStudentText: 'No. of students graduating in minimum stipulated time',
  },
  { id: 8, pgStudentText: 'No. of students placed' },
  { id: 9, pgStudentText: 'Median salary of placed graduates(Amount in Rs.)' },
  { id: 10, pgStudentText: 'No. of students selected for Higher Studies' },
];

function PgProgramThreeYears() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [pgProgramThreeInput, setPgProgramThreeInput] = useState('');
  const [pgProgramThreeInputBody01, setPgProgramThreeBodyText01] = useState('');
  const [pgProgramThreeInputBody02, setPgProgramThreeBodyText02] = useState('');
  const [pgProgramThreeInputBody03, setPgProgramThreeBodyText03] = useState('');
  const [pgProgramThreeInputBody04, setPgProgramThreeBodyText04] = useState('');
  const [pgProgramThreeInputBody05, setPgProgramThreeBodyText05] = useState('');
  const [pgProgramThreeInputBody06, setPgProgramThreeBodyText06] = useState('');
  const [pgProgramThreeInputBody07, setPgProgramThreeBodyText07] = useState('');
  const [pgProgramThreeInputBody08, setPgProgramThreeBodyText08] = useState('');
  const [pgProgramThreeInputBody09, setPgProgramThreeBodyText09] = useState('');

  const dataObject = {
    pgProgramThreeInputValue: pgProgramThreeInput,
    pgProgramThreeInputBody01Value: pgProgramThreeInputBody01,
    pgProgramThreeInputBody02Value: pgProgramThreeInputBody02,
    pgProgramThreeInputBody03Value: pgProgramThreeInputBody03,
    pgProgramThreeInputBody04Value: pgProgramThreeInputBody04,
    pgProgramThreeInputBody05Value: pgProgramThreeInputBody05,
    pgProgramThreeInputBody06Value: pgProgramThreeInputBody06,
    pgProgramThreeInputBody07Value: pgProgramThreeInputBody07,
    pgProgramThreeInputBody08Value: pgProgramThreeInputBody08,
    pgProgramThreeInputBody09Value: pgProgramThreeInputBody09,
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
    if (pgProgramThreeInput === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody04 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody07 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody08 === '') {
      alert('please fill the academic year field');
    }
    if (pgProgramThreeInputBody09 === '') {
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
                value={pgProgramThreeInput}
                onChange={(e) => setPgProgramThreeInput(e.target.value)}
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
            value={pgProgramThreeInputBody01}
            onChange={(e) => setPgProgramThreeBodyText01(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input02"
            variant="filled"
            value={pgProgramThreeInputBody02}
            onChange={(e) => setPgProgramThreeBodyText02(e.target.value)}
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
                value={pgProgramThreeInputBody03}
                onChange={(e) => setPgProgramThreeBodyText03(e.target.value)}
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
            value={pgProgramThreeInputBody04}
            onChange={(e) => setPgProgramThreeBodyText04(e.target.value)}
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
                id="pg-program-input05"
                variant="filled"
                value={pgProgramThreeInputBody05}
                onChange={(e) => setPgProgramThreeBodyText05(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input06"
            variant="filled"
            value={pgProgramThreeInputBody06}
            onChange={(e) => setPgProgramThreeBodyText06(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input07"
            variant="filled"
            value={pgProgramThreeInputBody07}
            onChange={(e) => setPgProgramThreeBodyText07(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input08"
            variant="filled"
            value={pgProgramThreeInputBody08}
            onChange={(e) => setPgProgramThreeBodyText08(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input09"
            variant="filled"
            value={pgProgramThreeInputBody09}
            onChange={(e) => setPgProgramThreeBodyText09(e.target.value)}
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

export default PgProgramThreeYears;
