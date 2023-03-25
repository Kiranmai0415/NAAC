import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './FinancialCapitalTable.css';
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
const capitalExpenditure = [
  'Library',
  'New Equipment for Laboratories',
  'Engineering Workshop',
  'Other expenditure on creation of Capital Assets (excluding expenditure on Land and Building)',
];

function FinancialCapitalTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [financialCapitalInputHead01, setFinancialCapitalHeadText01] = useState('');
  const [financialCapitalInputHead02, setFinancialCapitalHeadText02] = useState('');
  const [financialCapitalInputHead03, setFinancialCapitalHeadText03] = useState('');
  const [financialCapitalInputBody01, setFinancialCapitalBodyText01] = useState('');
  const [financialCapitalInputBody02, setFinancialCapitalBodyText02] = useState('');
  const [financialCapitalInputBody03, setFinancialCapitalBodyText03] = useState('');
  const [financialCapitalInputBody04, setFinancialCapitalBodyText04] = useState('');

  const dataObject = {
    financialCapitalInputHead01Value: financialCapitalInputHead01,
    financialCapitalInputHead02Value: financialCapitalInputHead02,
    financialCapitalInputHead03Value: financialCapitalInputHead03,
    financialCapitalInputBody01Value: financialCapitalInputBody01,
    financialCapitalInputBody02Value: financialCapitalInputBody02,
    financialCapitalInputBody03Value: financialCapitalInputBody03,
    financialCapitalInputBody04Value: financialCapitalInputBody04,
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
    if (financialCapitalInputHead01 === '') {
      alert('please fill the academic year field');
    }
    if (financialCapitalInputHead02 === '') {
      alert('please fill the academic year field');
    }
    if (financialCapitalInputHead03 === '') {
      alert('please fill the academic year field');
    }
    if (financialCapitalInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (financialCapitalInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (financialCapitalInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (financialCapitalInputBody04 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td>
          <Autocomplete
            id="program-input-dropdown"
            options={capitalExpenditure}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="financial-capital-input01"
                placeholder="Select Academic Year"
                variant="filled"
                value={financialCapitalInputBody01}
                onChange={(e) => setFinancialCapitalBodyText01(e.target.value)
                }
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="financial-capital-input02"
            variant="filled"
            value={financialCapitalInputBody02}
            onChange={(e) => setFinancialCapitalBodyText02(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="financial-capital-input03"
            variant="filled"
            value={financialCapitalInputBody03}
            onChange={(e) => setFinancialCapitalBodyText03(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="financial-capital-input04"
            variant="filled"
            value={financialCapitalInputBody04}
            onChange={(e) => setFinancialCapitalBodyText04(e.target.value)}
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
              <th style={{ width: '25%' }}>Academic Year</th>
              <th>
                <Autocomplete
                  id="program-input-dropdown"
                  options={academicYear}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      required="required"
                      id="financial-capital-input01"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={financialCapitalInputHead01}
                      onChange={(e) => setFinancialCapitalHeadText01(e.target.value)
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
                      id="financial-capital-input02"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={financialCapitalInputHead02}
                      onChange={(e) => setFinancialCapitalHeadText02(e.target.value)
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
                      id="financial-capital-input03"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={financialCapitalInputHead03}
                      onChange={(e) => setFinancialCapitalHeadText03(e.target.value)
                      }
                    />
                  )}
                />
              </th>
            </tr>
            <tr>
              <th></th>
              <th>Utilised Amount</th>
              <th>Utilised Amount</th>
              <th>Utilised Amount</th>
            </tr>
            <tr>
              <th colSpan="4">
                Annual Capital Expenditure on Academic Activities and Resources
                (excluding expenditure on buildings)
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

export default FinancialCapitalTable;
