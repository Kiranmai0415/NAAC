import React, { useState } from 'react';
import Criteria21 from './cV21/c21.js';
import Criteria22 from './cV22/c22.js';
import Criteria23 from './cV23/c23.js';
import Criteria24 from './cV24/c24.js';
import Criteria25 from './cV25/c25.js';
import Criteria26 from './cV26/c26.js';
import Criteria27 from './cV27/c27.js';
import './c2-style.css';
import {
  AssignPopup2,
  AssignPopup21,
  AssignPopup22,
  AssignPopup23,
  AssignPopup24,
  AssignPopup25,
  AssignPopup26,
  AssignPopup27,
} from './assignPopup2.js';

function Criteria2() {
  // state variables
  const [screenStatus21, setScreenStatus21] = useState(false);
  const [screenStatus22, setScreenStatus22] = useState(false);
  const [screenStatus23, setScreenStatus23] = useState(false);
  const [screenStatus24, setScreenStatus24] = useState(false);
  const [screenStatus25, setScreenStatus25] = useState(false);
  const [screenStatus26, setScreenStatus26] = useState(false);
  const [screenStatus27, setScreenStatus27] = useState(false);
  const [assignStatus2, setAssignStatus2] = useState(false);
  const [assignStatus21, setAssignStatus21] = useState(false);
  const [assignStatus22, setAssignStatus22] = useState(false);
  const [assignStatus23, setAssignStatus23] = useState(false);
  const [assignStatus24, setAssignStatus24] = useState(false);
  const [assignStatus25, setAssignStatus25] = useState(false);
  const [assignStatus26, setAssignStatus26] = useState(false);
  const [assignStatus27, setAssignStatus27] = useState(false);

  // rendering DOM
  return (
    <div className="c2-container">
      {/* Criteria Heading */}
      <div className="c2-heading-container">
        <h1 className="c2-heading-style">
        Teaching Learning and Evaluation (350)
        </h1>
        {/* <button
          onClick={() => setAssignStatus2(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup2
          isAssign2Clicked={assignStatus2}
          setIsAssign2Clicked={setAssignStatus2}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 2.1 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus21(!screenStatus21)}
            className="c2x-heading-style"
          >
            2.1: Student Enrolment and Profile (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus21(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup21
            isAssign21Clicked={assignStatus21}
            setIsAssign21Clicked={setAssignStatus21}
          />
        </div>
      </div>
      {screenStatus21 ? <Criteria21 /> : null}

      {/* Key Indicator: 2.2 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus22(!screenStatus22)}
            className="c2x-heading-style"
          >
            2.2: Catering to Student Diversity (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus22(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup22
            isAssign22Clicked={assignStatus22}
            setIsAssign22Clicked={setAssignStatus22}
          />
        </div>
      </div>
      {screenStatus22 ? <Criteria22 /> : null}

      {/* Key Indicator: 2.3 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus23(!screenStatus23)}
            className="c2x-heading-style"
          >
            2.3:Teaching-Learning Process (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus23(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup23
            isAssign23Clicked={assignStatus23}
            setIsAssign23Clicked={setAssignStatus23}
          />
        </div>
      </div>
      {screenStatus23 ? <Criteria23 /> : null}

      {/* Key Indicator: 2.4 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus24(!screenStatus24)}
            className="c2x-heading-style"
          >
            2.4: Teacher Profile and Quality (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus24(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup24
            isAssign24Clicked={assignStatus24}
            setIsAssign24Clicked={setAssignStatus24}
          />
        </div>
      </div>
      {screenStatus24 ? <Criteria24 /> : null}

      {/* Key Indicator: 2.5 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus25(!screenStatus25)}
            className="c2x-heading-style"
          >
            2.5: Evaluation Process and Reforms (40)
          </h1>
          {/* <button
            onClick={() => setAssignStatus25(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup25
            isAssign25Clicked={assignStatus25}
            setIsAssign25Clicked={setAssignStatus25}
          />
        </div>
      </div>
      {screenStatus25 ? <Criteria25 /> : null}

      {/* Key Indicator: 2.6 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus26(!screenStatus26)}
            className="c2x-heading-style"
          >
            2.6: Student Performance and Learning Outcomes (90)
          </h1>
          {/* <button
            onClick={() => setAssignStatus26(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup26
            isAssign26Clicked={assignStatus26}
            setIsAssign26Clicked={setAssignStatus26}
          />
        </div>
      </div>
      {screenStatus26 ? <Criteria26 /> : null}

      {/* Key Indicator: 2.7 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus27(!screenStatus27)}
            className="c2x-heading-style"
          >
            2.7: Student Satisfaction Survey (60)
          </h1>
          {/* <button
            onClick={() => setAssignStatus27(true)}
            className="c2x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup27
            isAssign27Clicked={assignStatus27}
            setIsAssign27Clicked={setAssignStatus27}
          />
        </div>
      </div>
      {screenStatus27 ? <Criteria27 /> : null}
    </div>
  );
}

export default Criteria2;
