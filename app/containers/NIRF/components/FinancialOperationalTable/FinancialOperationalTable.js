import React, { Fragment, useState } from 'react';
import Autocomplete from '@mui/material/Autocomplete';
import TextField from '@mui/material/TextField';
import './FinancialOperationalTable.css';
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
const operationalExpenditure = [
  'Salaries (Teaching and Non Teaching staff)',
  'Maintenance of Academic Infrastructure or consumables and other running expenditures(excluding maintenance of hostels and allied services,rent of the building, depreciation cost, etc)',
  'Seminars/Conferences/Workshops',
];

function FinancialOperationalTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const [financialOperationalInputHead01, setFinancialOperationalHeadText01] = useState('');
  const [financialOperationalInputHead02, setFinancialOperationalHeadText02] = useState('');
  const [financialOperationalInputHead03, setFinancialOperationalHeadText03] = useState('');
  const [financialOperationalInputBody01, setFinancialOperationalBodyText01] = useState('');
  const [financialOperationalInputBody02, setFinancialOperationalBodyText02] = useState('');
  const [financialOperationalInputBody03, setFinancialOperationalBodyText03] = useState('');
  const [financialOperationalInputBody04, setFinancialOperationalBodyText04] = useState('');

  const dataObject = {
    financialOperationalInputHead01Value: financialOperationalInputHead01,
    financialOperationalInputHead02Value: financialOperationalInputHead02,
    financialOperationalInputHead03Value: financialOperationalInputHead03,
    financialOperationalInputBody01Value: financialOperationalInputBody01,
    financialOperationalInputBody02Value: financialOperationalInputBody02,
    financialOperationalInputBody03Value: financialOperationalInputBody03,
    financialOperationalInputBody04Value: financialOperationalInputBody04,
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
    if (financialOperationalInputHead01 === '') {
      alert('please fill the academic year field');
    }
    if (financialOperationalInputHead02 === '') {
      alert('please fill the academic year field');
    }
    if (financialOperationalInputHead03 === '') {
      alert('please fill the academic year field');
    }
    if (financialOperationalInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (financialOperationalInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (financialOperationalInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (financialOperationalInputBody04 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td>
          <Autocomplete
            id="program-input-dropdown"
            options={operationalExpenditure}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="financial-operational-input01"
                placeholder="Select Academic Year"
                variant="filled"
                value={financialOperationalInputBody01}
                onChange={(e) => setFinancialOperationalBodyText01(e.target.value)
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
            id="financial-operational-input02"
            variant="filled"
            value={financialOperationalInputBody02}
            onChange={(e) => setFinancialOperationalBodyText02(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="financial-operational-input03"
            variant="filled"
            value={financialOperationalInputBody03}
            onChange={(e) => setFinancialOperationalBodyText03(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Name"
            id="financial-operational-input04"
            variant="filled"
            value={financialOperationalInputBody04}
            onChange={(e) => setFinancialOperationalBodyText04(e.target.value)}
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
                      id="financial-operational-input01"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={financialOperationalInputHead01}
                      onChange={(e) => setFinancialOperationalHeadText01(e.target.value)
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
                      id="financial-operational-input02"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={financialOperationalInputHead02}
                      onChange={(e) => setFinancialOperationalHeadText02(e.target.value)
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
                      id="financial-operational-input03"
                      placeholder="Select Academic Year"
                      variant="filled"
                      value={financialOperationalInputHead03}
                      onChange={(e) => setFinancialOperationalHeadText03(e.target.value)
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

export default FinancialOperationalTable;
