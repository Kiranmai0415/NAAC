import React, { Fragment, useState } from 'react';
import './ConsultancyProjectTable.css';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
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
const consultancyProject = [
  'Total no. of Consultancy Projects',
  'Total no. of Client Organizations',
  'Total Amount Received (Amount in Rupees)',
  'Amount Received in Words',
];

function ConsultancyProjectTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [consultancyProjectInputHead01, setConsultancyProjectHeadText01] = useState('');
  const [consultancyProjectInputHead02, setConsultancyProjectHeadText02] = useState('');
  const [consultancyProjectInputHead03, setConsultancyProjectHeadText03] = useState('');
  const [consultancyProjectInputBody01, setConsultancyProjectBodyText01] = useState('');
  const [consultancyProjectInputBody02, setConsultancyProjectBodyText02] = useState('');
  const [consultancyProjectInputBody03, setConsultancyProjectBodyText03] = useState('');
  const [consultancyProjectInputBody04, setConsultancyProjectBodyText04] = useState('');

  const dataObject = {
    consultancyProjectInputHead01Value: consultancyProjectInputHead01,
    consultancyProjectInputHead02Value: consultancyProjectInputHead02,
    consultancyProjectInputHead03Value: consultancyProjectInputHead03,
    consultancyProjectInputBody01Value: consultancyProjectInputBody01,
    consultancyProjectInputBody02Value: consultancyProjectInputBody02,
    consultancyProjectInputBody03Value: consultancyProjectInputBody03,
    consultancyProjectInputBody04Value: consultancyProjectInputBody04,
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
    if (consultancyProjectInputHead01 === '') {
      alert('please fill the academic year field');
    }
    if (consultancyProjectInputHead02 === '') {
      alert('please fill the academic year field');
    }
    if (consultancyProjectInputHead03 === '') {
      alert('please fill the academic year field');
    }
    if (consultancyProjectInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (consultancyProjectInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (consultancyProjectInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (consultancyProjectInputBody04 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td style={{ width: '25%' }}>
          <Autocomplete
            id="program-input-dropdown"
            options={consultancyProject}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="consultancy-project-input01"
                placeholder="Select Academic Year"
                variant="filled"
                value={consultancyProjectInputBody01}
                onChange={(e) => setConsultancyProjectBodyText01(e.target.value)
                }
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="consultancy-project-input02"
            variant="filled"
            value={consultancyProjectInputBody01}
            onChange={(e) => setConsultancyProjectBodyText02(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="consultancy-project-input03"
            variant="filled"
            value={consultancyProjectInputBody03}
            onChange={(e) => setConsultancyProjectBodyText03(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="consultancy-project-input04"
            variant="filled"
            value={consultancyProjectInputBody04}
            onChange={(e) => setConsultancyProjectBodyText04(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="consultancy-project-table">
          <thead>
            <tr>
              <th>Financial Year</th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      placeholder="Select Academic Year"
                      id="consultancy-project-input01"
                      variant="filled"
                      value={consultancyProjectInputHead01}
                      onChange={(e) => setConsultancyProjectHeadText01(e.target.value)
                      }
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
                      placeholder="Select Academic Year"
                      id="consultancy-project-input02"
                      variant="filled"
                      value={consultancyProjectInputHead02}
                      onChange={(e) => setConsultancyProjectHeadText02(e.target.value)
                      }
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
                      placeholder="Select Academic Year"
                      id="consultancy-project-input03"
                      variant="filled"
                      value={consultancyProjectInputHead03}
                      onChange={(e) => setConsultancyProjectHeadText03(e.target.value)
                      }
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

export default ConsultancyProjectTable;
