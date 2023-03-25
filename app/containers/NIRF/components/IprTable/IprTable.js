import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './IprTable.css';
import { ButtonGroup, Button } from '@mui/material';

const calendarYears = [
  '2021',
  '2020',
  '2019',
  '2018',
  '2017',
  '2016',
  '2015',
  '2014',
  '2013',
  '2012',
  '2011',
  '2010',
];
const patents = ['No. of Patents Published', 'No. of Patents Granted'];

function IprTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [iprInputHead01, setIprHeadText01] = useState('');
  const [iprInputHead02, setIprHeadText02] = useState('');
  const [iprInputHead03, setIprHeadText03] = useState('');
  const [iprInputBody01, setIprBodyText01] = useState('');
  const [iprInputBody02, setIprBodyText02] = useState('');
  const [iprInputBody03, setIprBodyText03] = useState('');
  const [iprInputBody04, setIprBodyText04] = useState('');

  const dataObject = {
    iprInputHead01Value: iprInputHead01,
    iprInputHead02Value: iprInputHead02,
    iprInputHead03Value: iprInputHead03,
    iprInputBody01Value: iprInputBody01,
    iprInputBody02Value: iprInputBody02,
    iprInputBody03Value: iprInputBody03,
    iprInputBody04Value: iprInputBody04,
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
    if (iprInputHead01 === '') {
      alert('please fill the academic year field');
    }
    if (iprInputHead02 === '') {
      alert('please fill the academic year field');
    }
    if (iprInputHead03 === '') {
      alert('please fill the academic year field');
    }
    if (iprInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (iprInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (iprInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (iprInputBody04 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td style={{ width: '25%' }}>
          <Autocomplete
            id="program-input-dropdown"
            options={patents}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="ipr-input01"
                placeholder="Select Academic Year"
                variant="filled"
                value={iprInputBody01}
                onChange={(e) => setIprBodyText01(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="ipr-input02"
            variant="filled"
            value={iprInputBody02}
            onChange={(e) => setIprBodyText02(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="ipr-input03"
            variant="filled"
            value={iprInputBody03}
            onChange={(e) => setIprBodyText03(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="ipr-input04"
            variant="filled"
            value={iprInputBody04}
            onChange={(e) => setIprBodyText04(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="financial-capital-table">
          <thead>
            <tr>
              <th>Calendar year</th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={calendarYears}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ipr-input01"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={iprInputHead01}
                      onChange={(e) => setIprHeadText01(e.target.value)}
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={calendarYears}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ipr-input02"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={iprInputHead02}
                      onChange={(e) => setIprHeadText02(e.target.value)}
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={calendarYears}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="ipr-input03"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={iprInputHead03}
                      onChange={(e) => setIprHeadText03(e.target.value)}
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

export default IprTable;
