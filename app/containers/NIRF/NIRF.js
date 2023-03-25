import React, { useState } from 'react';
import './NIRF.css';
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import { Button } from '@mui/material';

import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import Typography from '@mui/material/Typography';

import SanctionedTable from './components/SanctionedTable/SanctionedTable';
import ProgramsTable from './components/ProgramsTable/ProgramsTable';
import UGProgramTable from './components/UGProgramTable/UGProgramTable';
import PgProgramTable from './components/PgProgramTable/PgProgramTable';
import PgProgramThreeYears from './components/PgProgramThreeYears/PgProgramThreeYears';
import PhdStudentTable from './components/PhdStudentTable/PhdStudentTable';
import OnlineEducationTable from './components/OnlineEducationTable/OnlineEducationTable';
import FinancialCapitalTable from './components/FinancialCapitalTable/FinancialCapitalTable';
import FinancialOperationalTable from './components/FinancialOperationalTable/FinancialOperationalTable';
import IprTable from './components/IprTable/IprTable';
import SponsoredResearchTable from './components/SponsoredResearchTable/SponsoredResearchTable';
import ConsultancyProjectTable from './components/ConsultancyProjectTable/ConsultancyProjectTable';
import PcsFacilitiesTable from './components/PcsFacilitiesTable/PcsFacilitiesTable';
import ExecutiveDevelopmentTable from './components/ExecutiveDevelopmentTable/ExecutiveDevelopmentTable';
import NbaAccreditationTable from './components/NbaAccreditationTable/NbaAccreditationTable';
import NaacAccreditationTable from './components/NaacAccreditationTable/NaacAccreditationTable';
import FacultyDetailsTable from './components/FacultyDetailsTable/FacultyDetailsTable';

const instituteNames = ['Finolex Academy of Management and Technology [IR-E-C-34021]', 'Sathyabama Institute of Science and Technology [IR-E-U-0474]', 'Indian Institute of Technology Madras [IR-E-U-0456]'];

function App() {
  return (
    <div className='main-app-container'>
      <div className="App">
        <h1 className='header'>National Institutional Ranking Framework</h1>
        <p className='header'>Ministry of Education</p>
        <p className='header'>Government of India</p>
      </div>
      <div>
        <h4 className='data-submitted'>Data Submitted by Institution for India Rankings '2022'</h4>
        <div className='institute-name'>
          <p className='institute-name-space'>Institute Name: </p>
          <Autocomplete
            disablePortal
            id="instituteNames"
            sx={{ width: 700 }}
            options={instituteNames}
            renderInput={(params) => <TextField {...params} placeholder="Enter Institute Name" variant="standard" />}
          />
        </div>
      </div>

      <hr/>

      <div>
        <Accordion expanded>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography id='headings'>Sanctioned (Approved) Intake</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography >
              <SanctionedTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion >
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel2a-content"
            id="panel2a-header"
          >
            <Typography id='headings'>Total Actual Student Strength (Program(s) Offered by Your Institution)</Typography>
          </AccordionSummary>

          <AccordionDetails style={{ padding: '5px' }}>
            <ProgramsTable />
          </AccordionDetails>
        </Accordion>

        <h3>Placement & Higher Studies</h3>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel3a-content"
            id="panel3a-header"
          >
            <Typography id='headings'>UG [4 Years Program(s)]: Placement & higher studies for previous 3 year</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <UGProgramTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel4a-content"
            id="panel4a-header"
          >
            <Typography id='headings'>PG [2 Years Program(s)]: Placement & higher studies for previous 3 years</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <PgProgramTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel5a-content"
            id="panel5a-header"
          >
            <Typography id='headings'>PG [3 Years Program(s)]: Placement & higher studies for previous 3 years</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <PgProgramThreeYears />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel6a-content"
            id="panel6a-header"
          >
            <Typography id='headings'>Ph.D Student Detail</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <PhdStudentTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel7a-content"
            id="panel7a-header"
          >
            <Typography id='headings'>Online Education</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <OnlineEducationTable />
            </Typography>
          </AccordionDetails>
        </Accordion>
        <h1></h1>
        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel8a-content"
            id="panel8a-header"
          >
            <Typography id='headings'>Financial Resources: Utilised Amount for the Capital expenditure for previous 3 years</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <FinancialCapitalTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel9a-content"
            id="panel9a-header"
          >
            <Typography id='headings'>Financial Resources: Utilised Amount for thee Operational expenditure for previous 3 years</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <FinancialOperationalTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel10a-content"
            id="panel10a-header"
          >
            <Typography id='headings'>IPR</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <IprTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel11a-content"
            id="panel11a-header"
          >
            <Typography id='headings'>Sponsored Research Details</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <SponsoredResearchTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel12a-content"
            id="panel12a-header"
          >
            <Typography id='headings'>Consultancy Project Details</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <ConsultancyProjectTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel13a-content"
            id="panel13a-header"
          >
            <Typography id='headings'>Executive Development Program/Management Development Programs</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <ExecutiveDevelopmentTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel14a-content"
            id="panel14a-header"
          >
            <Typography id='headings'>PCS Facilities: Facilities of physically challenged students</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <PcsFacilitiesTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <h3>Accreditation</h3>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel15a-content"
            id="panel15a-header"
          >
            <Typography id='headings'>NBA Accreditation</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <NbaAccreditationTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel16a-content"
            id="panel16a-header"
          >
            <Typography id='headings'>NAAC Accreditation</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <NaacAccreditationTable />
            </Typography>
          </AccordionDetails>
        </Accordion>

        <Accordion>
          <AccordionSummary
            expandIcon={<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24"><path d="M0 0h24v24H0z" fill="none"/><path d="M16.59 8.59L12 13.17 7.41 8.59 6 10l6 6 6-6z"/></svg>}
            aria-controls="panel17a-content"
            id="panel17a-header"
          >
            <Typography id='headings'>Faculty Details</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Typography>
              <FacultyDetailsTable />
            </Typography>
          </AccordionDetails>
        </Accordion>
      </div>
      <div id="button">
        <Button style={{ width: '50%', textAlign: 'center', margin: '5px' }} id="save-sanctioned" variant="contained" type="button" >Save</Button>
      </div>
    </div>
  );
}

export default App;
