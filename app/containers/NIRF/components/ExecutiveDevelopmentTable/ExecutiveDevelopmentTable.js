import React, { Fragment, useState } from 'react';
import './ExecutiveDevelopmentTable.css';
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
const executiveDevelopmentProgram = [
  'Total no. of Executive Development Programs/ Management Development Programs',
  'Total no. of Participants',
  'Total Annual Earnings (Amount in Rupees)(Excluding Lodging & Boarding Charges)',
  'Total Annual Earnings in Words',
];

function ExecutiveDevelopmentTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [executiveDevelopmentInputHead01, setExecutiveDevelopmentHeadText01] = useState('');
  const [executiveDevelopmentInputHead02, setExecutiveDevelopmentHeadText02] = useState('');
  const [executiveDevelopmentInputHead03, setExecutiveDevelopmentHeadText03] = useState('');
  const [executiveDevelopmentInputBody01, setExecutiveDevelopmentBodyText01] = useState('');
  const [executiveDevelopmentInputBody02, setExecutiveDevelopmentBodyText02] = useState('');
  const [executiveDevelopmentInputBody03, setExecutiveDevelopmentBodyText03] = useState('');
  const [executiveDevelopmentInputBody04, setExecutiveDevelopmentBodyText04] = useState('');

  const dataObject = {
    executiveDevelopmentInputHead01Value: executiveDevelopmentInputHead01,
    executiveDevelopmentInputHead02Value: executiveDevelopmentInputHead02,
    executiveDevelopmentInputHead03Value: executiveDevelopmentInputHead03,
    executiveDevelopmentInputBody01Value: executiveDevelopmentInputBody01,
    executiveDevelopmentInputBody02Value: executiveDevelopmentInputBody02,
    executiveDevelopmentInputBody03Value: executiveDevelopmentInputBody03,
    executiveDevelopmentInputBody04Value: executiveDevelopmentInputBody04,
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
    if (executiveDevelopmentInputHead01 === '') {
      alert('please fill the academic year field');
    }
    if (executiveDevelopmentInputHead02 === '') {
      alert('please fill the academic year field');
    }
    if (executiveDevelopmentInputHead03 === '') {
      alert('please fill the academic year field');
    }
    if (executiveDevelopmentInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (executiveDevelopmentInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (executiveDevelopmentInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (executiveDevelopmentInputBody04 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td style={{ width: '25%' }}>
          <Autocomplete
            id="program-input-dropdown"
            options={executiveDevelopmentProgram}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="executive-development-input01"
                placeholder="Select Academic Year"
                variant="filled"
                value={executiveDevelopmentInputBody01}
                onChange={(e) => setExecutiveDevelopmentBodyText01(e.target.value)
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
            id="executive-development-input02"
            variant="filled"
            value={executiveDevelopmentInputBody01}
            onChange={(e) => setExecutiveDevelopmentBodyText02(e.target.value)
            }
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="executive-development-input03"
            variant="filled"
            value={executiveDevelopmentInputBody03}
            onChange={(e) => setExecutiveDevelopmentBodyText03(e.target.value)
            }
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="executive-development-input04"
            variant="filled"
            value={executiveDevelopmentInputBody04}
            onChange={(e) => setExecutiveDevelopmentBodyText04(e.target.value)
            }
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="executive-development-table">
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
                      id="executive-development-input01"
                      variant="filled"
                      value={executiveDevelopmentInputHead01}
                      onChange={(e) => setExecutiveDevelopmentHeadText01(e.target.value)
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
                      id="executive-development-input02"
                      variant="filled"
                      value={executiveDevelopmentInputHead02}
                      onChange={(e) => setExecutiveDevelopmentHeadText02(e.target.value)
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
                      id="executive-development-input03"
                      variant="filled"
                      value={executiveDevelopmentInputHead03}
                      onChange={(e) => setExecutiveDevelopmentHeadText03(e.target.value)
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

export default ExecutiveDevelopmentTable;
