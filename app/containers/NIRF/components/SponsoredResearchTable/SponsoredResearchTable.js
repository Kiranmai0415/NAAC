import React, { Fragment, useState } from 'react';
import './SponsoredResearchTable.css';
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
const sponsoredFinancialYear = [
  'Total no. of Sponsored Projects',
  'Total no. of Funding Agencies',
  'Total Amount Received (Amount in Rupees)',
  'Amount Received in Words',
];

function SponsoredResearchTable() {
  const [academicProgramRow, setAcademicProgramRow] = useState(1);
  const [numberOfRows, setNumberOFRows] = useState(1);
  const [isValidDisable, setIsValidDisable] = useState(true);

  const disable = () => {
    if (numberOfRows <= 0) {
      setIsValidDisable(true);
    } else {
      setIsValidDisable(false);
    }
  };
  const [sponsoredResearchInputHead01, setSponsoredResearchHeadText01] = useState('');
  const [sponsoredResearchInputHead02, setSponsoredResearchHeadText02] = useState('');
  const [sponsoredResearchInputHead03, setSponsoredResearchHeadText03] = useState('');
  const [sponsoredResearchInputBody01, setSponsoredResearchBodyText01] = useState('');
  const [sponsoredResearchInputBody02, setSponsoredResearchBodyText02] = useState('');
  const [sponsoredResearchInputBody03, setSponsoredResearchBodyText03] = useState('');
  const [sponsoredResearchInputBody04, setSponsoredResearchBodyText04] = useState('');

  const dataObject = {
    sponsoredResearchInputHead01Value: sponsoredResearchInputHead01,
    sponsoredResearchInputHead02Value: sponsoredResearchInputHead02,
    sponsoredResearchInputHead03Value: sponsoredResearchInputHead03,
    sponsoredResearchInputBody01Value: sponsoredResearchInputBody01,
    sponsoredResearchInputBody02Value: sponsoredResearchInputBody02,
    sponsoredResearchInputBody03Value: sponsoredResearchInputBody03,
    sponsoredResearchInputBody04Value: sponsoredResearchInputBody04,
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
    if (sponsoredResearchInputHead01 === '') {
      alert('please fill the academic year field');
    }
    if (sponsoredResearchInputHead02 === '') {
      alert('please fill the academic year field');
    }
    if (sponsoredResearchInputHead03 === '') {
      alert('please fill the academic year field');
    }
    if (sponsoredResearchInputBody01 === '') {
      alert('please fill the academic year field');
    }
    if (sponsoredResearchInputBody02 === '') {
      alert('please fill the academic year field');
    }
    if (sponsoredResearchInputBody03 === '') {
      alert('please fill the academic year field');
    }
    if (sponsoredResearchInputBody04 === '') {
      alert('please fill the academic year field');
    }
  };

  const tableBody = () => (
    <tbody>
      <tr>
        <td style={{ width: '25%' }}>
          <Autocomplete
            id="program-input-dropdown"
            options={sponsoredFinancialYear}
            renderInput={(params) => (
              <TextField
                {...params}
                required="required"
                id="sponsored-research-input01"
                placeholder="Select Academic Year"
                variant="filled"
                value={sponsoredResearchInputBody01}
                onChange={(e) => setSponsoredResearchBodyText01(e.target.value)}
              />
            )}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="sponsored-research-input02"
            variant="filled"
            value={sponsoredResearchInputBody01}
            onChange={(e) => setSponsoredResearchBodyText02(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="sponsored-research-input03"
            variant="filled"
            value={sponsoredResearchInputBody03}
            onChange={(e) => setSponsoredResearchBodyText03(e.target.value)}
          />
        </td>
        <td>
          <TextField
            style={{ width: '100%' }}
            required="required"
            placeholder="Enter Number"
            id="sponsored-research-input04"
            variant="filled"
            value={sponsoredResearchInputBody04}
            onChange={(e) => setSponsoredResearchBodyText04(e.target.value)}
          />
        </td>
      </tr>
    </tbody>
  );

  return (
    <div className="table-bg">
      <form className="table-wrapper" onSubmit={onSubmit}>
        <table className="sponsored-research-table">
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
                      id="sponsored-research-input01"
                      variant="filled"
                      value={sponsoredResearchInputHead01}
                      onChange={(e) => setSponsoredResearchHeadText01(e.target.value)
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
                      id="sponsored-research-input02"
                      variant="filled"
                      value={sponsoredResearchInputHead02}
                      onChange={(e) => setSponsoredResearchHeadText02(e.target.value)
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
                      id="sponsored-research-input03"
                      variant="filled"
                      value={sponsoredResearchInputHead03}
                      onChange={(e) => setSponsoredResearchHeadText03(e.target.value)
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

export default SponsoredResearchTable;
