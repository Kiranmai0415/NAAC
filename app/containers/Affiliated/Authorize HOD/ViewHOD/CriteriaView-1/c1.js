import React, { useState } from 'react';
import Criteria11 from './cV11/c11.js';
import Criteria12 from './cV12/c12.js';
import Criteria13 from './cV13/c13.js';
import Criteria14 from './cV14/c14.js';
import './c1-style.css';
import {
  AssignPopup1,
  AssignPopup11,
  AssignPopup12,
  AssignPopup13,
  AssignPopup14,
} from './assignPopup1.js';

function Criteria1() {
  // state variables
  const [screenStatus11, setScreenStatus11] = useState(false);
  const [screenStatus12, setScreenStatus12] = useState(false);
  const [screenStatus13, setScreenStatus13] = useState(false);
  const [screenStatus14, setScreenStatus14] = useState(false);
  const [assignStatus1, setAssignStatus1] = useState(false);
  const [assignStatus11, setAssignStatus11] = useState(false);
  const [assignStatus12, setAssignStatus12] = useState(false);
  const [assignStatus13, setAssignStatus13] = useState(false);
  const [assignStatus14, setAssignStatus14] = useState(false);

  // rendering DOM
  return (
    <div className="c1-container">
      {/* Criteria Heading */}
      <div className="c1-heading-container">
        <h1 className="c1-heading-style">
        Curricular Aspects (100)
        </h1>
        {/* <button
          onClick={() => setAssignStatus1(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup1
          isAssign1Clicked={assignStatus1}
          setIsAssign1Clicked={setAssignStatus1}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 1.1 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus11(!screenStatus11)}
            className="c1x-heading-style"
          >
            1.1: Curriculum Design and Development (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus11(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup11
            isAssign11Clicked={assignStatus11}
            setIsAssign11Clicked={setAssignStatus11}
          />
        </div>
      </div>
      {screenStatus11 ? <Criteria11 /> : null}

      {/* Key Indicator: 1.2 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus12(!screenStatus12)}
            className="c1x-heading-style"
          >
            1.2: Academic Flexibility (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus12(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup12
            isAssign12Clicked={assignStatus12}
            setIsAssign12Clicked={setAssignStatus12}
          />
        </div>
      </div>
      {screenStatus12 ? <Criteria12 /> : null}

      {/* Key Indicator: 1.3 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus13(!screenStatus13)}
            className="c1x-heading-style"
          >
            1.3: Curriculum Enrichment (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus13(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup13
            isAssign13Clicked={assignStatus13}
            setIsAssign13Clicked={setAssignStatus13}
          />
        </div>
      </div>
      {screenStatus13 ? <Criteria13 /> : null}

      {/* Key Indicator: 1.4 */}
      <div className="c1x-container">
        <div className="c1x-subContainer">
          <h1
            onClick={() => setScreenStatus14(!screenStatus14)}
            className="c1x-heading-style"
          >
            1.4: Feedback System (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus14(true)}
            className="c1x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup14
            isAssign14Clicked={assignStatus14}
            setIsAssign14Clicked={setAssignStatus14}
          />
        </div>
      </div>
      {screenStatus14 ? <Criteria14 /> : null}
    </div>
  );
}

export default Criteria1;
