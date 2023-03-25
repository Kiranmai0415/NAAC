import React, { useState } from 'react';
import './qualityAdvisor-style.css';

function QualityAdvisor() {
  const [dataValue111, setDataValue111] = useState('');
  const [metricGradeScaleValue111, setMetricGradeScaleValue111] = useState('');
  const [metricWeightedGradePoints111, setMetricWeightedGradePoints111] = useState('');

  function metricGradeScaleForPercentages(dataValue) {
    if (dataValue >= 0 && dataValue <= 20) {
      return 0;
    }
    if (dataValue >= 21 && dataValue <= 40) {
      return 1;
    }
    if (dataValue >= 41 && dataValue <= 60) {
      return 2;
    }
    if (dataValue >= 61 && dataValue <= 80) {
      return 3;
    }
    if (dataValue >= 81) {
      return 4;
    }
    return '';
  }
  function metricGradeScaleForRadio(dataValue) {
    if (dataValue === 'option a') {
      return 4;
    }
    if (dataValue === 'option b') {
      return 3;
    }
    if (dataValue === 'option c') {
      return 2;
    }
    if (dataValue === 'option d') {
      return 1;
    }
    if (dataValue === 'option e') {
      return 0;
    }
    return '';
  }
  function metricGradeScaleForNumbers(dataValue) {
    if (dataValue >= 100) {
      return 4;
    }
    if (dataValue >= 80 && dataValue < 100) {
      return 3;
    }
    if (dataValue >= 60 && dataValue < 80) {
      return 2;
    }
    if (dataValue >= 20 && dataValue < 60) {
      return 1;
    }
    if (dataValue >= 0 && dataValue < 20) {
      return 0;
    }
    return '';
  }
  function metricWeightedGradePointsCalculation(
    metricGradeScaleValue,
    metricWeightage
  ) {
    return metricGradeScaleValue * metricWeightage;
  }
  return (
    <div className="main-container">
      <div className="eachTable-container">
        <table>
          <tr>
            <th style={{ width: '70px' }}>S.No</th>
            <th style={{ width: '90px' }}>Metric No.</th>
            <th style={{ width: '90px' }}>QI/QN</th>
            <th style={{ width: '400px' }}>Description</th>
            <th style={{ width: '70px' }}>W</th>
            <th style={{ width: '80px' }}>KI(W)</th>
            <th style={{ width: '100px' }}>Criteria(W)</th>
            <th style={{ width: '120px' }}>
              ADVV - 2 (Adiverse data validation) Response
            </th>
            <th style={{ width: '120px' }}>Metric Grade scale (0-4)</th>
            <th style={{ width: '120px' }}>
              Metric wise weighted Grade points
            </th>
            <th style={{ width: '120px' }}>KI wise Weighted Grade</th>
            <th style={{ width: '120px' }}>KI wise Grade Point Average</th>
            <th style={{ width: '100px' }}>Criteria (W)</th>
            <th style={{ width: '120px' }}>
              Criteria wise Grade Point Average
            </th>
          </tr>
          <tr>
            <td>1.</td>
            <td>1.1.1</td>
            <td>QI</td>
            <td>
              Curricula developed and implemented have relevance to the local,
              national, regional and global developmental needs which is
              reflected in Programme outcomes (POs), Programme Specific
              Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered
              by the Institution.
            </td>
            <td>20</td>
            <td rowspan="3">50</td>
            <td rowspan="11">150</td>
            <td>
              <input
                value={dataValue111}
                onChange={(e) => setDataValue111(e.target.value)}
                type="text"
              />
            </td>
            <td>
              <input
                type="text"
                onChange={(e) => setMetricGradeScaleValue111(e.target.value)}
                value={metricGradeScaleForNumbers(dataValue111)}
              />
            </td>
            <td>
              {/* <input
                onChange={(e) => setMetricWeightedGradePoints111(e.target.value)
                }
                value={metricWeightedGradePointsCalculation(
                  metricGradeScaleValue111,
                  20
                )}
                type="text"
              /> */}
            </td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>2.</td>
            <td>1.1.2</td>
            <td>QN</td>
            <td>
              Percentage of Programmes where syllabus revision was carried out
              during the last five years.
            </td>
            <td>20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>3.</td>
            <td>1.1.3</td>
            <td>QN</td>
            <td>
              Average percentage of courses having focus on employability/
              entrepreneurship/ skill development offered by the institution
              during the last five years.
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>4.</td>
            <td>1.2.1</td>
            <td>QN</td>
            <td>
              {' '}
              Percentage of new courses introduced of the total number of
              courses across all programs offered during the last five years.
            </td>
            <td>20</td>
            <td rowspan="2">40</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>5.</td>
            <td>1.2.2</td>
            <td>QN</td>
            <td>
              Percentage of Programmes in which Choice Based Credit System
              (CBCS) / elective course system has been implemented (Data for the
              latest completed academic year).
            </td>
            <td>20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>6.</td>
            <td>1.3.1</td>
            <td>QI</td>
            <td>
              Institution integrates crosscutting issues relevant to
              Professional Ethics ,Gender, Human Values ,Environment and
              Sustainability into the Curriculum.
            </td>
            <td>10</td>
            <td rowspan="4">40</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>7.</td>
            <td>1.3.2</td>
            <td>QN</td>
            <td>
              Number of value-added courses for imparting transferable and life
              skills offered during last five years.
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>8.</td>
            <td>1.3.3</td>
            <td>QN</td>
            <td>
              Average Percentage of students enrolled in the courses under 1.3.2
              above.
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>9.</td>
            <td>1.3.4</td>
            <td>QN</td>
            <td>
              Percentage of students undertaking field projects/ internships /
              student projects (Data for the latest completed academic year).
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>10.</td>
            <td>1.4.1</td>
            <td>QN</td>
            <td>
              Structured feedback for design and review of syllabus ( semester
              wise / year wise) is obtained from 1) Students, 2) Teachers, 3)
              Employers, 4) Alumni.
            </td>
            <td>10</td>
            <td rowspan="2">20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>11.</td>
            <td>1.4.2</td>
            <td>QN</td>
            <td>
              Structured feedback for design and review of syllabus ( semester
              wise / year wise) is obtained from 1) Students, 2) Teachers, 3)
              Employers, 4) Alumni Options.
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>12.</td>
            <td>2.1.1</td>
            <td>QN</td>
            <td>Average Enrolment percentage (Average of last five years)</td>
            <td>10</td>
            <td rowspan="2">20</td>
            <td rowspan="18">300</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>13.</td>
            <td>2.1.2</td>
            <td>QN</td>
            <td>
              Average percentage of seats filled against reserved categories
              (SC, ST, OBC, Divyangjan, etc.as per applicable reservation policy
              ) during the last five years ( exclusive of supernumerary seats)
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>14.</td>
            <td>2.2.1</td>
            <td>QI</td>
            <td>
              The institution assesses the learning levels of the students and
              organises special Programmes for advanced learners and slow
              learners
            </td>
            <td>15</td>
            <td rowspan="2">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>15.</td>
            <td>2.2.2</td>
            <td>QN</td>
            <td>
              Student - Full time teacher ratio (Data for the latest completed
              academic year) The institution provides seed money to its teachers
              for research.
            </td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>16.</td>
            <td>2.3.1</td>
            <td>QI</td>
            <td>
              Student centric methods, such as experiential learning,
              participative learning and problem solving methodologies are used
              for enhancing learning experiences
            </td>
            <td>15</td>
            <td rowspan="4">50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>17.</td>
            <td>2.3.2</td>
            <td>QI</td>
            <td>
              Teachers use ICT enabled tools including online resources for
              effective teaching and learning process.
            </td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>18.</td>
            <td>2.3.3</td>
            <td>QN</td>
            <td>
              Ratio of students to mentor for academic and other related issues
              (Data for the latest completed academic year )
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>19.</td>
            <td>2.3.4</td>
            <td>QN</td>
            <td>
              Average percentage of full time teachers against sanctioned posts
              during the last five years
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>20.</td>
            <td>2.4.1</td>
            <td>QN</td>
            <td>
              Average number of days from the date of last semester-end/ year-
              end examination till the declaration of results year-wise during
              the last five yearsdsx
            </td>
            <td>15</td>
            <td rowspan="3">50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>21.</td>
            <td>2.4.2</td>
            <td>QN</td>
            <td>
              {' '}
              Average percentage of full time teachers with Ph. D. / D.M. /
              M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last
              five years (consider only highest degree for count).
            </td>
            <td>20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>22.</td>
            <td>2.4.3</td>
            <td>QN</td>
            <td>
              Average teaching experience of full time teachers in the same
              institution (Data for the latest completed academic year in number
              of years)
            </td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>23.</td>
            <td>2.5.1</td>
            <td>QN</td>
            <td>
              Average number of days from the date of last semester-end/ year-
              end examination till the declaration of results year-wise during
              the last five years
            </td>
            <td>20</td>
            <td rowspan="3">50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>24.</td>
            <td>2.5.2</td>
            <td>QN</td>
            <td>
              Average percentage of student complaints/grievances about
              evaluation against total number appeared in the examinations
              during the last five years
            </td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>25.</td>
            <td>2.5.3</td>
            <td>QI</td>
            <td>
              IT integration and reforms in the examination procedures and
              processes including Continuous Internal Assessment (CIA) have
              brought in considerable improvement in Examination Management
              System (EMS) of the Institution.
            </td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>26.</td>
            <td>2.6.1</td>
            <td>QN</td>
            <td>
              Programme and course outcomes for all Programmes offered by the
              institution are stated and displayed on website and communicated
              to teachers and students.
            </td>
            <td>20</td>
            <td rowspan="3">50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>27.</td>
            <td>2.6.2</td>
            <td>QN</td>
            <td>
              Attainment of programme outcomes and course outcomes are evaluated
              by the institution.
            </td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>28.</td>
            <td>2.6.3</td>
            <td>QI</td>
            <td>
              {' '}
              Pass Percentage of students(Data for the latest completed academic
              year).
            </td>
            <td>20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>29.</td>
            <td>2.7.1</td>
            <td>QN</td>
            <td>
              {' '}
              The institution provides seed money to its teachers for research.
            </td>
            <td>50</td>
            <td>50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>30.</td>
            <td>3.1.1</td>
            <td>QI</td>
            <td>The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.</td>
            <td>6</td>
            <td rowspan="3">20</td>
            <td rowspan="23">150</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>31.</td>
            <td>3.1.2</td>
            <td>QN</td>
            <td>The institution provides seed money to its teachers for research.</td>
            <td>8</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>32.</td>
            <td>3.1.3</td>
            <td>QN</td>
            <td>Percentage of teachers awarded national/ international fellowship for advanced studies/ research during the last five years.</td>
            <td>6</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>30.</td>
            <td>3.2.1</td>
            <td>QI</td>
            <td>Grants received from Government and non-governmental agencies for research projects, endowments, Chairs in the institution during the last five years (INR in Lakhs).</td>
            <td>2</td>
            <td rowspan="4">10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>31.</td>
            <td>3.2.2</td>
            <td>QN</td>
            <td>Percentage of teachers having research projects during the last five years.</td>
            <td>2</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>32.</td>
            <td>3.2.3</td>
            <td>QN</td>
            <td>Percentage of teachers recognised as research guides.</td>
            <td>3</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>33.</td>
            <td>3.2.4</td>
            <td>QN</td>
            <td>Average percentage of departments having Research projects funded by government and non-government agencies during the last five years.</td>
            <td>3</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>34.</td>
            <td>3.3.1</td>
            <td>QI</td>
            <td>nstitution has created an eco system for innovations, creation and transfer of knowledge supported by dedicated centers for research, entrepreneurship, community orientation, Incubation etc.</td>
            <td>5</td>
            <td rowspan="2">10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>35.</td>
            <td>3.3.2</td>
            <td>QN</td>
            <td>Number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development during the last five years.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>36.</td>
            <td>3.4.1</td>
            <td>QN</td>
            <td>The institution ensures implementation of its stated code of Ethics for reseach through the following:</td>
            <td>5</td>
            <td rowspan="6">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>37.</td>
            <td>3.4.2</td>
            <td>QN</td>
            <td>Number of Ph.D's registered per teacher (as per the data given w.r.t recognized Ph.D guides/ supervisors provided at 3.2.3 metric) during the last five years.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>38.</td>
            <td>3.4.3</td>
            <td>QN</td>
            <td>Number of research papers per teachers in the Journals notified on UGC website during the last five years.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>39.</td>
            <td>3.4.4</td>
            <td>QN</td>
            <td>Number of books and chapters in edited volumes / books published per teacher during the last five years.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>40.</td>
            <td>3.4.5</td>
            <td>QN</td>
            <td>Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>41.</td>
            <td>3.4.6</td>
            <td>QN</td>
            <td>Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h-index of the Institution.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>42.</td>
            <td>3.5.1</td>
            <td>QN</td>
            <td>Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs).</td>
            <td>5</td>
            <td rowspan="2">10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>43.</td>
            <td>3.5.2</td>
            <td>QN</td>
            <td>Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs).</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>44.</td>
            <td>3.6.1</td>
            <td>QI</td>
            <td>Extension activities are carried out in the neighbourhood community, sensitising students to social issues, for their holistic development, and impact thereof during the last five years.</td>
            <td>10</td>
            <td rowspan="4">50</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>45.</td>
            <td>3.6.2</td>
            <td>QN</td>
            <td>Number of awards and recognition received by the Institution, its teachers and students for extension activities from Government / Government recognised bodies during last five years.</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>46.</td>
            <td>3.6.3</td>
            <td>QN</td>
            <td>Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years.</td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>47.</td>
            <td>3.6.4</td>
            <td>QN</td>
            <td>Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years.</td>
            <td>15</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>48.</td>
            <td>3.7.1</td>
            <td>QN</td>
            <td>Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on -the-job training/ project work.</td>
            <td>10</td>
            <td rowspan="2">20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>49.</td>
            <td>3.7.2</td>
            <td>QN</td>
            <td>Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered).</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>50.</td>
            <td>4.1.1</td>
            <td>QI</td>
            <td>The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc.</td>
            <td>6</td>
            <td rowspan="4">30</td>
            <td rowspan="14">100</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>51.</td>
            <td>4.1.2</td>
            <td>QI</td>
            <td>The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>52.</td>
            <td>4.1.3</td>
            <td>QN</td>
            <td>Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>53.</td>
            <td>4.1.4</td>
            <td>QN</td>
            <td>Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>54.</td>
            <td>4.2.1</td>
            <td>QI</td>
            <td>Library is automated using Integrated Library Management System (ILMS).</td>
            <td>5</td>
            <td rowspan="4">20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>55.</td>
            <td>4.2.2</td>
            <td>QN</td>
            <td>Institution has access to the following: e-journals,e-ShodhSindhu,Shodhganga Membership,e-books,Databases,Remote access to e-resources</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>56.</td>
            <td>4.2.3</td>
            <td>QN</td>
            <td>Average annual expenditure for purchase of books/ e-books and subscription to journals/e-journals during the last five years (INR in Lakhs)</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>57.</td>
            <td>4.2.4</td>
            <td>QN</td>
            <td> Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>58.</td>
            <td>4.3.1</td>
            <td>QI</td>
            <td>Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities.</td>
            <td>8</td>
            <td rowspan="4">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>59.</td>
            <td>4.3.2</td>
            <td>QN</td>
            <td>Student - Computer ratio (Data for the latest completed academic year)</td>
            <td>8</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>60.</td>
            <td>4.3.3</td>
            <td>QN</td>
            <td>Bandwidth of internet connection in the Institution.</td>
            <td>8</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>61.</td>
            <td>4.3.4</td>
            <td>QN</td>
            <td>Institution has the following Facilities for e-content development</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>62.</td>
            <td>4.4.1</td>
            <td>QN</td>
            <td> Average percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years.</td>
            <td>10</td>
            <td rowspan="2">20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>63.</td>
            <td>4.4.2</td>
            <td>QI</td>
            <td>There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>64.</td>
            <td>5.1.1</td>
            <td>QN</td>
            <td>Average percentage of students benefited by scholarships and freeships provided by the Government during last five years.</td>
            <td>6</td>
            <td rowspan="5">30</td>
            <td rowspan="13">100</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>65.</td>
            <td>5.1.2</td>
            <td>QN</td>
            <td>Average percentage of students benefited by scholarships, freeships, etc. provided by the institution and non-government agencies during the last five years</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>66.</td>
            <td>5.1.3</td>
            <td>QN</td>
            <td>Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)</td>
            <td>8</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>67.</td>
            <td>5.1.4</td>
            <td>QN</td>
            <td>Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.</td>
            <td>6</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>68.</td>
            <td>5.1.5</td>
            <td>QN</td>
            <td>Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>69.</td>
            <td>5.2.1</td>
            <td>QN</td>
            <td>Average percentage of placement of outgoing students during the last five years.</td>
            <td>10</td>
            <td rowspan="3">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>70.</td>
            <td>5.2.2</td>
            <td>QN</td>
            <td>Percentage of student progression to higher education (previous graduating batch).</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>71.</td>
            <td>5.2.3</td>
            <td>QN</td>
            <td>Average percentage of students qualifying in state/national/ international level examinations during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations, etc.)</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>72.</td>
            <td>5.3.1</td>
            <td>QN</td>
            <td>Number of awards/medals for outstanding performance in sports/cultural activities at inter-university / state /national / international events (award for a team event should be counted as one) during the last five years.</td>
            <td>10</td>
            <td rowspan="3">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>73.</td>
            <td>5.3.2</td>
            <td>QI</td>
            <td>Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution.</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>74.</td>
            <td>5.3.3</td>
            <td>QN</td>
            <td>Average number of sports and cultural events / competitions organised by the institution per year.</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>75.</td>
            <td>5.4.1</td>
            <td>QI</td>
            <td>The Alumni Association/Chapters (registered and functional)contributes significantly to the development of the institution through financial and other support services.</td>
            <td>5</td>
            <td rowspan="2">10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>76.</td>
            <td>5.4.2</td>
            <td>QN</td>
            <td>Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>77.</td>
            <td>6.1.1</td>
            <td>QI</td>
            <td>The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution.</td>
            <td>5</td>
            <td rowspan="2">10</td>
            <td rowspan="9">100</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>78.</td>
            <td>6.1.2</td>
            <td>QI</td>
            <td>The effective leadership is reflected in various institutional practices such as decentralization and participative management.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>79.</td>
            <td>6.2.1</td>
            <td>QI</td>
            <td>The institutional Strategic/ Perspective plan is effectively deployed.</td>
            <td>2</td>
            <td rowspan="3">10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>80.</td>
            <td>6.2.2</td>
            <td>QI</td>
            <td>The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup appointment and service rules, procedures, etc.</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>81.</td>
            <td>6.2.3</td>
            <td>QN</td>
            <td>Implementation of e-governance in areas of operation.</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>82.</td>
            <td>6.3.1</td>
            <td>QI</td>
            <td>The institutional Strategic/ Perspective plan is effectively deployed.</td>
            <td>4</td>
            <td rowspan="4">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>83.</td>
            <td>6.3.2</td>
            <td>QN</td>
            <td>Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.</td>
            <td>8</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>84.</td>
            <td>6.3.3</td>
            <td>QN</td>
            <td>The institution provides seed money to its teachers for research.</td>
            <td>8</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>85.</td>
            <td>6.3.4</td>
            <td>QN</td>
            <td>The institution provides seed money to its teachers for research.</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>86.</td>
            <td>6.4.1</td>
            <td>QI</td>
            <td>The institutional Strategic/ Perspective plan is effectively deployed.</td>
            <td>4</td>
            <td rowspan="3">20</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>87.</td>
            <td>6.4.2</td>
            <td>QN</td>
            <td>Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs).</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>88.</td>
            <td>6.4.3</td>
            <td>QI</td>
            <td>Institutional strategies for mobilisation of funds and the optimal utilisation of resources.</td>
            <td>6</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>89.</td>
            <td>6.5.1</td>
            <td>QI</td>
            <td>Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of – Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles).</td>
            <td>10</td>
            <td rowspan="3">30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>90.</td>
            <td>6.5.2</td>
            <td>QI</td>
            <td>The institution reviews its teaching learning process, structures & methodologies of operations and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the incremental improvement in various activities ( For first cycle - Incremental improvements made for the preceding five years with regard to quality For second and subsequent cycles - Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives ).</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>91.</td>
            <td>6.5.3</td>
            <td>QN</td>
            <td>Quality assurance initiatives of the institution include</td>
            <td>10</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>92.</td>
            <td>7.1.1</td>
            <td>QI</td>
            <td>Measures initiated by the Institution for the promotion of gender equity during the last five years.</td>
            <td>5</td>
            <td rowspan="11">50</td>
            <td rowspan="13">100</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>93.</td>
            <td>7.1.2</td>
            <td>QN</td>
            <td>The Institution has facilities for alternate sources of energy and energy conservation measures.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>94.</td>
            <td>7.1.3</td>
            <td>QI</td>
            <td>Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words) Solid waste management Liquid waste management Biomedical waste management E-waste management Waste recycling system Hazardous chemicals and radioactive waste management.</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>95.</td>
            <td>7.1.4</td>
            <td>QN</td>
            <td>Water conservation facilities available in the Institution.</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>96.</td>
            <td>7.1.5</td>
            <td>QN</td>
            <td>Green campus initiatives include.</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>97.</td>
            <td>7.1.6</td>
            <td>QN</td>
            <td>Quality audits on environment and energy are regularly undertaken by the Institution and any awards received for such green campus initiatives.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>98.</td>
            <td>7.1.7</td>
            <td>QN</td>
            <td>The Institution has disabled-friendly, barrier free environment.</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>99.</td>
            <td>7.1.8</td>
            <td>QI</td>
            <td>Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words).</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>100.</td>
            <td>7.1.9</td>
            <td>QI</td>
            <td> Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).</td>
            <td>4</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>101.</td>
            <td>7.1.10</td>
            <td>QN</td>
            <td>The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>102.</td>
            <td>7.1.11</td>
            <td>QN</td>
            <td>Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).</td>
            <td>5</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>103.</td>
            <td>7.2.1</td>
            <td>QI</td>
            <td>Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.</td>
            <td>30</td>
            <td>30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td>104.</td>
            <td>7.3.1</td>
            <td>QI</td>
            <td>Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words.</td>
            <td>30</td>
            <td>30</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </table>
      </div>
    </div>
  );
}

export default QualityAdvisor;
