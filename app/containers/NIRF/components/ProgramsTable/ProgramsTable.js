import React, { useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './ProgramsTable.css';
import { ButtonGroup, Button } from '@mui/material';

const academicProgram = [
  'UG [4 Years Program(s)]',
  'PG [2 Year Program(s)]',
  'PG [3 Year Program(s)]',
];
const studentStrength = [
  { id: 1, strengthText: '(All programs of all years)' },
  { id: 2, strengthText: 'No. of Male Students' },
  { id: 3, strengthText: 'No. of Female Students' },
  { id: 4, strengthText: 'Total Student' },
  { id: 5, strengthText: 'Within State (Including male & female)' },
  { id: 6, strengthText: 'Outside State (Including male & female)' },
  { id: 7, strengthText: 'Outside Country (Including male & female)' },
  { id: 8, strengthText: 'Economically Backward (Including male & female)' },
  {
    id: 9,
    strengthText: 'Socially Challenged (SC+ST+OBC Including male & female)',
  },
  {
    id: 10,
    strengthText:
      'No. of students receiving full tuition fee reimbursement from the State and Central Government',
  },
  {
    id: 11,
    strengthText:
      'No. of students receiving full tuition fee reimbursement from Institution Funds',
  },
  {
    id: 12,
    strengthText:
      'No. of students receiving full tuition fee reimbursement from the Private Bodies',
  },
  {
    id: 13,
    strengthText:
      'No. of students who are not receiving full tuition fee reimbursement',
  },
];

function ProgramsTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [programInput, setProgramInput] = useState('');
  const [programInputBody01, setProgramBodyText01] = useState('');
  const [programInputBody02, setProgramBodyText02] = useState('');
  const [programInputBody03, setProgramBodyText03] = useState('');
  const [programInputBody04, setProgramBodyText04] = useState('');
  const [programInputBody05, setProgramBodyText05] = useState('');
  const [programInputBody06, setProgramBodyText06] = useState('');
  const [programInputBody07, setProgramBodyText07] = useState('');
  const [programInputBody08, setProgramBodyText08] = useState('');
  const [programInputBody09, setProgramBodyText09] = useState('');
  const [programInputBody10, setProgramBodyText10] = useState('');
  const [programInputBody11, setProgramBodyText11] = useState('');
  const [programInputBody12, setProgramBodyText12] = useState('');

  const dataObject = {
    programInputValue: programInput,
    programInputBody01Value: programInputBody01,
    programInputBody02Value: programInputBody02,
    programInputBody03Value: programInputBody03,
    programInputBody04Value: programInputBody04,
    programInputBody05Value: programInputBody05,
    programInputBody06Value: programInputBody06,
    programInputBody07Value: programInputBody07,
    programInputBody08Value: programInputBody08,
    programInputBody09Value: programInputBody09,
    programInputBody10Value: programInputBody10,
    programInputBody11Value: programInputBody11,
    programInputBody12Value: programInputBody12,
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
    if (programInput === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody04 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody07 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody08 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody09 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody10 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody11 === '') {
      alert('please fill the academic year field');
    }
    if (programInputBody12 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = (i) => (
    <tbody>
      <tr>
        <td>
          <Autocomplete
            id="program-input-dropdown"
            options={academicProgram}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id={`program-input${i}`}
                placeholder="Enter Degree Program"
                variant="filled"
                value={programInput.i}
                onChange={(e) => setProgramInput(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input01${i}`}
            variant="filled"
            value={programInputBody01.i}
            onChange={(e) => setProgramBodyText01(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input02${i}`}
            variant="filled"
            value={programInputBody02.i}
            onChange={(e) => setProgramBodyText02(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input03${i}`}
            variant="filled"
            value={programInputBody03.i}
            onChange={(e) => setProgramBodyText03(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input04${i}`}
            variant="filled"
            value={programInputBody04.i}
            onChange={(e) => setProgramBodyText04(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input05${i}`}
            variant="filled"
            value={programInputBody05.i}
            onChange={(e) => setProgramBodyText05(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input06${i}`}
            variant="filled"
            value={programInputBody06.i}
            onChange={(e) => setProgramBodyText06(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input07${i}`}
            variant="filled"
            value={programInputBody07.i}
            onChange={(e) => setProgramBodyText07(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input08${i}`}
            variant="filled"
            value={programInputBody08.i}
            onChange={(e) => setProgramBodyText08(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input09${i}`}
            variant="filled"
            value={programInputBody09.i}
            onChange={(e) => setProgramBodyText09(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input10${i}`}
            variant="filled"
            value={programInputBody10.i}
            onChange={(e) => setProgramBodyText10(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input11${i}`}
            variant="filled"
            value={programInputBody11.i}
            onChange={(e) => setProgramBodyText11(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id={`program-input12${i}`}
            variant="filled"
            value={programInputBody12.i}
            onChange={(e) => setProgramBodyText12(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <>
      <div className="table-bg">
        <form className="table-wrapper" onSubmit={onSubmit}>
          <table className="programs-table">
            <thead>
              <tr>
                {studentStrength.map((eachColumn) => (
                  <th key={eachColumn.id}>{eachColumn.strengthText}</th>
                ))}
              </tr>
            </thead>
            {[...Array(academicProgramRow)].map((elementInArray, i) => tableBody(i))}
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

export default ProgramsTable;
