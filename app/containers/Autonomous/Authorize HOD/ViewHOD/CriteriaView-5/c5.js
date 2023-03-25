import React, { useState , useEffect} from 'react';
import Criteria51 from './cV51/c51.js';
import Criteria52 from './cV52/c52.js';
import Criteria53 from './cV53/c53.js';
import Criteria54 from './cV54/c54.js';
import './c5-style.css';

function CriteriaView5() {
  // state variables
  const [screenStatus51, setScreenStatus51] = useState(false);
  const [screenStatus52, setScreenStatus52] = useState(false);
  const [screenStatus53, setScreenStatus53] = useState(false);
  const [screenStatus54, setScreenStatus54] = useState(false);

  // rendering DOM
  return (
    <div className="c5-container">
      {/* Criteria Heading */}
      <div className="c5-heading-container">
        <h1 className="c5-heading-style">Student Support and Progression (100)
</h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 5.1 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus51(!screenStatus51)}
            className="c5x-heading-style"
          >
           5.1 Student Support (30)
          </h1>
        </div>
      </div>
      {screenStatus51 ? <Criteria51 /> : null}

      {/* Key Indicator: 5.2 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus52(!screenStatus52)}
            className="c5x-heading-style"
          >
            5.2 Student Progression (30)

          </h1>
        </div>
      </div>
      {screenStatus52 ? <Criteria52 /> : null}

      {/* Key Indicator: 5.3 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus53(!screenStatus53)}
            className="c5x-heading-style"
          >
            5.3 Student Participation and Activities (30)

          </h1>
        </div>
      </div>
      {screenStatus53 ? <Criteria53 /> : null}

      {/* Key Indicator: 5.4 */}
      <div className="c5x-container">
        <div className="c5x-subContainer">
          <h1
            onClick={() => setScreenStatus54(!screenStatus54)}
            className="c5x-heading-style"
          >
          5.4 Alumni Engagement (10)
          </h1>
        </div>
      </div>
      {screenStatus54 ? <Criteria54 /> : null}
    </div>
  );
}

export default CriteriaView5;
