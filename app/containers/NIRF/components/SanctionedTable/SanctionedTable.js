import React, { useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './SanctionedTable.css';
import { ButtonGroup, Button, Snackbar } from '@mui/material';
import Alert from '@mui/material/Alert';

const academicProgram = [
  'UG [4 Years Program(s)]',
  'PG [2 Year Program(s)]',
  'PG [3 Year Program(s)]'
];
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

function SanctionedTable() {
  const [rows, setRows] = useState([
    {
      id: 1,
      academicProgramInput: '',
      academicProgramInputBody01: '',
      academicProgramInputBody02: '',
      academicProgramInputBody03: '',
    },
  ]);
  const [open, setOpen] = React.useState(false);

  const [academicYearInputHead01, setAcademicYearInputHead01] = useState('');
  const [academicYearInputHead02, setAcademicYearInputHead02] = useState('');
  const [academicYearInputHead03, setAcademicYearInputHead03] = useState('');

  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }
    setOpen(false);
  };

  const handleAdd = () => {
    setRows([
      ...rows,
      {
        id: rows.length + 1,
        academicProgramInput: '',
        academicProgramInputBody01: '',
        academicProgramInputBody02: '',
        academicProgramInputBody03: '',
      },
    ]);
  };

  const handleMinus = (i) => {
    const list = [...rows];
    list.splice(i, 1);
    setRows(list);
  };

  const handleInputChange = (e, index) => {
    const { name, value } = e.target;
    const list = [...rows];
    list[index][name] = value;
    setRows(list);
  };

  const saveFormData = async () => {
    console.log(rows);
    console.log(academicYearInputHead01);
    console.log(academicYearInputHead02);
    console.log(academicYearInputHead03);
    // const response = await fetch('', {
    //   method: 'POST',
    //   body: JSON.stringify(dataObject)
    // });
    // if (response.status !== 200) {
    //   throw new Error(`Request failed: ${response.status}`);
    // }
  };

  const onSubmit = async (event) => {
    event.preventDefault();
    setOpen(true);
  };

  const dataObject = {
    academicYearInputHead01Value: academicYearInputHead01,
    academicYearInputHead02Value: academicYearInputHead02,
    academicYearInputHead03Value: academicYearInputHead03,
    rowsBody: rows,
  };

  const tableBody = (i) => (
    <tbody>
      <tr>
        <td>
          <Autocomplete
            id="body-academic-program"
            options={academicProgram}
            value={rows.academicProgramInput}
            onChange={(e) => handleInputChange(e, i)}
            renderInput={(params) => (
              <TextField
                {...params}
                name="academicProgramInput"
                required="required"
                id={`body-academic-program-text${i}`}
                placeholder="Enter Degree Program"
                variant="filled"
                value={rows.academicProgramInput}
                onChange={(e) => handleInputChange(e, i)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            name="academicProgramInputBody01"
            required="required"
            placeholder="Enter Number"
            id={`body-academic-year-text01${i}`}
            variant="filled"
            value={rows.academicProgramInputBody01}
            onChange={(e) => handleInputChange(e, i)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            name="academicProgramInputBody02"
            required="required"
            placeholder="Enter Number"
            id={`body-academic-year-text02${i}`}
            variant="filled"
            value={rows.academicProgramInputBody02}
            onChange={(e) => handleInputChange(e, i)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            name="academicProgramInputBody03"
            required="required"
            placeholder="Enter Number"
            id={`body-academic-year-text03${i}`}
            variant="filled"
            value={rows.academicProgramInputBody03}
            onChange={(e) => handleInputChange(e, i)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="sanctioned-table">
          <thead>
            <tr>
              <th style={{ minWidth: '22%' }}>Academic Year</th>
              <th>
                <Autocomplete
                  id="header-academic-year01"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="header-academic-year-text"
                      placeholder="Enter Academic Year"
                      variant="filled"
                      value={academicYearInputHead01}
                      onChange={(e) => setAcademicYearInputHead01(e.target.value)
                      }
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="header-academic-year02"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="header-academic-year-text"
                      placeholder="Enter Academic Year"
                      variant="filled"
                      value={academicYearInputHead02}
                      onChange={(e) => setAcademicYearInputHead02(e.target.value)
                      }
                    />
                  )}
                />
              </th>
              <th>
                <Autocomplete
                  id="header-academic-year03"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="header-academic-year-text"
                      placeholder="Enter Academic Year"
                      variant="filled"
                      value={academicYearInputHead03}
                      onChange={(e) => setAcademicYearInputHead03(e.target.value)
                      }
                    />
                  )}
                />
              </th>
            </tr>
          </thead>
          {rows.map((row, i) => tableBody(i))}
        </table>

        <ButtonGroup
          id="buttons-div"
          disableElevation
          variant="contained"
          aria-label="Disabled elevation buttons"
        >
          <Button id="add-row-sanctioned" onClick={handleAdd}>
            +
          </Button>
          <Button disabled>Row</Button>
          {rows.length !== 1 && (
            <Button id="minus-row-sanctioned" onClick={handleMinus}>
              -
            </Button>
          )}
          <Snackbar open={open} autoHideDuration={2000} onClose={handleClose}>
            <Alert onClose={handleClose} severity="success">
              Saved successfully!
            </Alert>
          </Snackbar>

          <Button
            id="save-sanctioned"
            variant="contained"
            type="button"
            onClick={saveFormData}
          >
            Save
          </Button>
        </ButtonGroup>
      </form>
    </div>
  );
}

export default SanctionedTable;
