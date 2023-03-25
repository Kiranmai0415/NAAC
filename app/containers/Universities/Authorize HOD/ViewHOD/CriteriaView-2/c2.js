import React, { useState } from 'react';
import Criteria21 from './cV21/c21';
import Criteria22 from './cV22/c22';
import Criteria23 from './cV23/c23';
import Criteria24 from './cV24/c24';
import Criteria25 from './cV25/c25';
import Criteria26 from './cV26/c26';
import Criteria27 from './cV27/c27';
import './c2-style.css';

function CriteriaView2() {
  // state variables
  const [screenStatus21, setScreenStatus21] = useState(false);
  const [screenStatus22, setScreenStatus22] = useState(false);
  const [screenStatus23, setScreenStatus23] = useState(false);
  const [screenStatus24, setScreenStatus24] = useState(false);
  const [screenStatus25, setScreenStatus25] = useState(false);
  const [screenStatus26, setScreenStatus26] = useState(false);
  const [screenStatus27, setScreenStatus27] = useState(false);

  // rendering DOM
  return (
    <div className="c2-container">
      {/* Criteria Heading */}
      <div className="c2-heading-container">
        <h1 className="c2-heading-style">
        Teaching Learning and Evaluation
        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 2.1 */}
      <div className="c2x-container">
        <div className="c2x-subContainer">
          <h1
            onClick={() => setScreenStatus21(!screenStatus21)}
            className="c2x-heading-style"
          >
            2.1: Student Enrolment and Profile
          </h1>
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
            2.2: Catering to Student Diversity
          </h1>
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
            2.3:Teaching-Learning Process
          </h1>
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
            2.4: Teacher Profile and Quality
          </h1>
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
            2.5: Evaluation Process and Reforms
          </h1>
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
            2.6: Student Performance and Learning Outcomes
          </h1>
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
            2.7: Student Satisfaction Survey
          </h1>
        </div>
      </div>
      {screenStatus27 ? <Criteria27 /> : null}
    </div>
  );
}

export default CriteriaView2;
