import React, { useState } from 'react';
import Criteria61 from './cV61/c61.js';
import Criteria62 from './cV62/c62.js';
import Criteria63 from './cV63/c63.js';
import Criteria64 from './cV64/c64.js';
import Criteria65 from './cV65/c65.js';
import './c6-style.css';
import {
  AssignPopup6,
  AssignPopup61,
  AssignPopup62,
  AssignPopup63,
  AssignPopup64,
  AssignPopup65,
} from './assignPopup6.js';

function Criteria6() {
  // state variables
  const [screenStatus61, setScreenStatus61] = useState(false);
  const [screenStatus62, setScreenStatus62] = useState(false);
  const [screenStatus63, setScreenStatus63] = useState(false);
  const [screenStatus64, setScreenStatus64] = useState(false);
  const [screenStatus65, setScreenStatus65] = useState(false);
  const [assignStatus6, setAssignStatus6] = useState(false);
  const [assignStatus61, setAssignStatus61] = useState(false);
  const [assignStatus62, setAssignStatus62] = useState(false);
  const [assignStatus63, setAssignStatus63] = useState(false);
  const [assignStatus64, setAssignStatus64] = useState(false);
  const [assignStatus65, setAssignStatus65] = useState(false);

  // rendering DOM
  return (
    <div className="c6-container">
      {/* Criteria Heading */}
      <div className="c6-heading-container">
        <h1 className="c6-heading-style">
        Governance, Leadership and Management (100)
        </h1>
        {/* <button
          onClick={() => setAssignStatus6(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup6
          isAssign6Clicked={assignStatus6}
          setIsAssign6Clicked={setAssignStatus6}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 6.1 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus61(!screenStatus61)}
            className="c6x-heading-style"
          >
            6.1: Institutional Vision and Leadership (15)
          </h1>
          {/* <button
            onClick={() => setAssignStatus61(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup61
            isAssign61Clicked={assignStatus61}
            setIsAssign61Clicked={setAssignStatus61}
          />
        </div>
      </div>
      {screenStatus61 ? <Criteria61 /> : null}

      {/* Key Indicator: 6.2 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus62(!screenStatus62)}
            className="c6x-heading-style"
          >
            6.2:Strategy Development and Deployment (12)
          </h1>
          {/* <button
            onClick={() => setAssignStatus62(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup62
            isAssign62Clicked={assignStatus62}
            setIsAssign62Clicked={setAssignStatus62}
          />
        </div>
      </div>
      {screenStatus62 ? <Criteria62 /> : null}

      {/* Key Indicator: 6.3 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus63(!screenStatus63)}
            className="c6x-heading-style"
          >
            6.3: Faculty Empowerment Strategies (33)
          </h1>
          {/* <button
            onClick={() => setAssignStatus63(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup63
            isAssign63Clicked={assignStatus63}
            setIsAssign63Clicked={setAssignStatus63}
          />
        </div>
      </div>
      {screenStatus63 ? <Criteria63 /> : null}

      {/* Key Indicator: 6.4 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus64(!screenStatus64)}
            className="c6x-heading-style"
          >
            6.4: Financial Management and Resource Mobilization (10)
          </h1>
          {/* <button
            onClick={() => setAssignStatus64(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup64
            isAssign64Clicked={assignStatus64}
            setIsAssign64Clicked={setAssignStatus64}
          />
        </div>
      </div>
      {screenStatus64 ? <Criteria64 /> : null}

      {/* Key Indicator: 6.5 */}
      <div className="c6x-container">
        <div className="c6x-subContainer">
          <h1
            onClick={() => setScreenStatus65(!screenStatus65)}
            className="c6x-heading-style"
          >
            6.5: Internal Quality Assurance System (IQAS)
          </h1>
          {/* <button
            onClick={() => setAssignStatus65(true)}
            className="c6x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup65
            isAssign65Clicked={assignStatus65}
            setIsAssign65Clicked={setAssignStatus65}
          />
        </div>
      </div>
      {screenStatus65 ? <Criteria65 /> : null}
    </div>
  );
}

export default Criteria6;
