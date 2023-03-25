import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './PhdStudentTable.css';
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

function PhdStudentTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [phdStudentInputBody01, setPhdStudentBodyText01] = useState('');
  const [phdStudentInputBody02, setPhdStudentBodyText02] = useState('');
  const [phdStudentInputBody03, setPhdStudentBodyText03] = useState('');
  const [phdStudentInputBody04, setPhdStudentBodyText04] = useState('');
  const [phdStudentInputBody05, setPhdStudentBodyText05] = useState('');
  const [phdStudentInputBody06, setPhdStudentBodyText06] = useState('');
  const [phdStudentInputBody07, setPhdStudentBodyText07] = useState('');
  const [phdStudentInputBody08, setPhdStudentBodyText08] = useState('');
  const [phdStudentInputBody09, setPhdStudentBodyText09] = useState('');
  const [phdStudentInputBody10, setPhdStudentBodyText10] = useState('');
  const [phdStudentInputBody11, setPhdStudentBodyText11] = useState('');
  const [phdStudentInputBody12, setPhdStudentBodyText12] = useState('');
  const [phdStudentInputBody13, setPhdStudentBodyText13] = useState('');
  const [phdStudentInputBody14, setPhdStudentBodyText14] = useState('');
  const [phdStudentInputBody15, setPhdStudentBodyText15] = useState('');
  const [phdStudentInputBody16, setPhdStudentBodyText16] = useState('');
  const [phdStudentInputBody17, setPhdStudentBodyText17] = useState('');
  const [phdStudentInputBody18, setPhdStudentBodyText18] = useState('');

  const dataObject = {
    phdStudentInputBody01Value: phdStudentInputBody01,
    phdStudentInputBody02Value: phdStudentInputBody02,
    phdStudentInputBody03Value: phdStudentInputBody03,
    phdStudentInputBody04Value: phdStudentInputBody04,
    phdStudentInputBody05Value: phdStudentInputBody05,
    phdStudentInputBody06Value: phdStudentInputBody06,
    phdStudentInputBody07Value: phdStudentInputBody07,
    phdStudentInputBody08Value: phdStudentInputBody08,
    phdStudentInputBody09Value: phdStudentInputBody09,
    phdStudentInputBody10Value: phdStudentInputBody10,
    phdStudentInputBody11Value: phdStudentInputBody11,
    phdStudentInputBody12Value: phdStudentInputBody12,
    phdStudentInputBody13Value: phdStudentInputBody13,
    phdStudentInputBody14Value: phdStudentInputBody14,
    phdStudentInputBody15Value: phdStudentInputBody15,
    phdStudentInputBody16Value: phdStudentInputBody16,
    phdStudentInputBody17Value: phdStudentInputBody17,
    phdStudentInputBody18Value: phdStudentInputBody18,
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
    if (phdStudentInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody04 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody05 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody06 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody07 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody08 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody09 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody10 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody11 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody12 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody13 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody14 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody15 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody16 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody17 === '') {
      alert('please fill the academic year field');
    }
    if (phdStudentInputBody18 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input01"
            variant="filled"
            value={phdStudentInputBody16}
            onChange={(e) => setPhdStudentBodyText16(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input01"
            variant="filled"
            value={phdStudentInputBody17}
            onChange={(e) => setPhdStudentBodyText17(e.target.value)}
          />
        </td>
        <td colspan="2">
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="pg-program-input01"
            variant="filled"
            value={phdStudentInputBody18}
            onChange={(e) => setPhdStudentBodyText18(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="pg-programs-table">
          <thead>
            <tr>
              <th colspan="4">
                Ph.D (Student pursuing doctoral program till 2020-21 Students
                admitted in the academic year 2020-21 should not be entered
                here.)
              </th>
            </tr>
            <tr>
              <th style={{ width: '50%' }} colspan="2"></th>
              <th colspan="2">Total Student</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="2">Full Time</td>
              <td colspan="2">
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input01"
                  variant="filled"
                  value={phdStudentInputBody01}
                  onChange={(e) => setPhdStudentBodyText01(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td colspan="2">Part Time</td>
              <td colspan="2">
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input02"
                  variant="filled"
                  value={phdStudentInputBody02}
                  onChange={(e) => setPhdStudentBodyText02(e.target.value)}
                />
              </td>
            </tr>
          </tbody>
          <thead>
            <tr>
              <th colspan="4">
                No. of Ph.D students graduated (including Integrated Ph.D)
              </th>
            </tr>
            <tr>
              <th style={{ width: '25%' }}></th>
              <th>
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
                      value={phdStudentInputBody03}
                      onChange={(e) => setPhdStudentBodyText03(e.target.value)}
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ug-program-input04"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={phdStudentInputBody04}
                      onChange={(e) => setPhdStudentBodyText04(e.target.value)}
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ug-program-input05"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={phdStudentInputBody05}
                      onChange={(e) => setPhdStudentBodyText05(e.target.value)}
                    />
                  )}
                />
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Full Time</td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input06"
                  variant="filled"
                  value={phdStudentInputBody06}
                  onChange={(e) => setPhdStudentBodyText06(e.target.value)}
                />
              </td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input07"
                  variant="filled"
                  value={phdStudentInputBody07}
                  onChange={(e) => setPhdStudentBodyText07(e.target.value)}
                />
              </td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input08"
                  variant="filled"
                  value={phdStudentInputBody08}
                  onChange={(e) => setPhdStudentBodyText08(e.target.value)}
                />
              </td>
            </tr>
            <tr>
              <td>Part Time</td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input09"
                  variant="filled"
                  value={phdStudentInputBody09}
                  onChange={(e) => setPhdStudentBodyText09(e.target.value)}
                />
              </td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input10"
                  variant="filled"
                  value={phdStudentInputBody10}
                  onChange={(e) => setPhdStudentBodyText10(e.target.value)}
                />
              </td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input11"
                  variant="filled"
                  value={phdStudentInputBody11}
                  onChange={(e) => setPhdStudentBodyText11(e.target.value)}
                />
              </td>
            </tr>
          </tbody>
          <thead>
            <tr>
              <th colspan="4">
                PG (Student pursuing MD/MS/DNB program till 2020-21 Students
                admitted in the academic year 2021 - 22 should not be entered
                here)
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td colspan="3">
                Number of students pursuing PG (MD/MS/DNB) program
              </td>
              <td>
                <TextField
                  style={{ width: '100%' }}
                  required="required"
                  placeholder="Enter Number"
                  id="pg-program-input12"
                  variant="filled"
                  value={phdStudentInputBody12}
                  onChange={(e) => setPhdStudentBodyText12(e.target.value)}
                />
              </td>
            </tr>
          </tbody>
          <thead>
            <tr>
              <th colspan="4">
                No. of students Graduating in PG (MD/MS/DNB) program
              </th>
            </tr>
            <tr>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ug-program-input13"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={phdStudentInputBody13}
                      onChange={(e) => setPhdStudentBodyText13(e.target.value)}
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ug-program-input14"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={phdStudentInputBody14}
                      onChange={(e) => setPhdStudentBodyText14(e.target.value)}
                    />
                  )}
                />
              </th>
              <th colspan="2">
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ug-program-input15"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={phdStudentInputBody15}
                      onChange={(e) => setPhdStudentBodyText15(e.target.value)}
                    />
                  )}
                />
              </th>
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
  );
}

export default PhdStudentTable;
