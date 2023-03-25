import React, { useState } from 'react';
import Criteria41 from './cV41/c41.js';
import Criteria42 from './cV42/c42.js';
import Criteria43 from './cV43/c43.js';
import Criteria44 from './cV44/c44.js';

import './c4-style.css';
import {
  AssignPopup4,
  AssignPopup41,
  AssignPopup42,
  AssignPopup43,
  AssignPopup44,
} from './assignPopup4.js';

function Criteria4() {
  // state variables
  const [screenStatus41, setScreenStatus41] = useState(false);
  const [screenStatus42, setScreenStatus42] = useState(false);
  const [screenStatus43, setScreenStatus43] = useState(false);
  const [screenStatus44, setScreenStatus44] = useState(false);

  const [assignStatus4, setAssignStatus4] = useState(false);
  const [assignStatus41, setAssignStatus41] = useState(false);
  const [assignStatus42, setAssignStatus42] = useState(false);
  const [assignStatus43, setAssignStatus43] = useState(false);
  const [assignStatus44, setAssignStatus44] = useState(false);
  return (
    <div className="c4-container">
      {/* Criteria Heading */}
      <div className="c4-heading-container">
        <h1 className="c4-heading-style">
          Infrastructure and Learning Resources (100)
        </h1>
        {/* <button
          onClick={() => setAssignStatus4(true)}
          className="cx-assign-button-style"
        >
          Assign
        </button> */}
        <AssignPopup4
          isAssign4Clicked={assignStatus4}
          setIsAssign4Clicked={setAssignStatus4}
        />
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 4.1 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus41(!screenStatus41)}
            className="c4x-heading-style"
          >
            4.1: Physical Facilities (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus41(true)}
            className="c4x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup41
            isAssign41Clicked={assignStatus41}
            setIsAssign41Clicked={setAssignStatus41}
          />
        </div>
      </div>
      {screenStatus41 ? <Criteria41 /> : null}

      {/* Key Indicator: 4.2 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus42(!screenStatus42)}
            className="c4x-heading-style"
          >
            4.2: Library as a Learning Resource (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus42(true)}
            className="c4x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup42
            isAssign42Clicked={assignStatus42}
            setIsAssign42Clicked={setAssignStatus42}
          />
        </div>
      </div>
      {screenStatus42 ? <Criteria42 /> : null}

      {/* Key Indicator: 4.3 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus43(!screenStatus43)}
            className="c4x-heading-style"
          >
            4.3: IT Infrastructure (30)
          </h1>
          {/* <button
            onClick={() => setAssignStatus43(true)}
            className="c4x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup43
            isAssign43Clicked={assignStatus43}
            setIsAssign43Clicked={setAssignStatus43}
          />
        </div>
      </div>
      {screenStatus43 ? <Criteria43 /> : null}

      {/* Key Indicator: 4.4 */}
      <div className="c4x-container">
        <div className="c4x-subContainer">
          <h1
            onClick={() => setScreenStatus44(!screenStatus44)}
            className="c4x-heading-style"
          >
            4.4: Maintenance of Campus Infrastructure (20)
          </h1>
          {/* <button
            onClick={() => setAssignStatus44(true)}
            className="c4x-assign-button-style"
          >
            Assign
          </button> */}
          <AssignPopup44
            isAssign44Clicked={assignStatus44}
            setIsAssign44Clicked={setAssignStatus44}
          />
        </div>
      </div>
      {screenStatus44 ? <Criteria44 /> : null}
    </div>
  );
}
export default Criteria4;
