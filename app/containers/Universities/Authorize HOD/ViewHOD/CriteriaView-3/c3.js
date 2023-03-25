import React, { useState } from 'react';
import Criteria31 from './cV31/c31';
import Criteria32 from './cV32/c32';
import Criteria33 from './cV33/c33';
import Criteria34 from './cV34/c34';
import Criteria35 from './cV35/c35';
import Criteria36 from './cV36/c36';
import Criteria37 from './cV37/c37';
import './c3-style.css';

function CriteriaView3() {
  // state variables
  const [screenStatus31, setScreenStatus31] = useState(false);
  const [screenStatus32, setScreenStatus32] = useState(false);
  const [screenStatus33, setScreenStatus33] = useState(false);
  const [screenStatus34, setScreenStatus34] = useState(false);
  const [screenStatus35, setScreenStatus35] = useState(false);
  const [screenStatus36, setScreenStatus36] = useState(false);
  const [screenStatus37, setScreenStatus37] = useState(false);

  // rendering DOM
  return (
    <div className="c3-container">
      {/* Criteria Heading */}
      <div className="c3-heading-container">
        <h1 className="c3-heading-style">
        Research, Innovations and Extension (250)
        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 3.1 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus31(!screenStatus31)}
            className="c3x-heading-style"
          >
            3.1: Promotions of Research and Facilities (20)
          </h1>
        </div>
      </div>
      {screenStatus31 ? <Criteria31 /> : null}

      {/* Key Indicator: 3.2 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus32(!screenStatus32)}
            className="c3x-heading-style"
          >
            3.2: Resource Mobilization for Research (40)
          </h1>
        </div>
      </div>
      {screenStatus32 ? <Criteria32 /> : null}

      {/* Key Indicator: 3.3 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus33(!screenStatus33)}
            className="c3x-heading-style"
          >
            3.3: Innovation Ecosystem (20)
          </h1>
        </div>
      </div>
      {screenStatus33 ? <Criteria33 /> : null}

      {/* Key Indicator: 3.4 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus34(!screenStatus34)}
            className="c3x-heading-style"
          >
            3.4: Research Publications and Awards (120)
          </h1>
        </div>
      </div>
      {screenStatus34 ? <Criteria34 /> : null}

      {/* Key Indicator: 3.5 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus35(!screenStatus35)}
            className="c3x-heading-style"
          >
            3.5: Consultancy (20)
          </h1>
        </div>
      </div>
      {screenStatus35 ? <Criteria35 /> : null}

      {/* Key Indicator: 3.6 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus36(!screenStatus36)}
            className="c3x-heading-style"
          >
            3.6: Extension Activities (20)
          </h1>
        </div>
      </div>
      {screenStatus36 ? <Criteria36 /> : null}

      {/* Key Indicator: 3.7 */}
      <div className="c3x-container">
        <div className="c3x-subContainer">
          <h1
            onClick={() => setScreenStatus37(!screenStatus37)}
            className="c3x-heading-style"
          >
            3.7: Collaboration (10)
          </h1>
        </div>
      </div>
      {screenStatus37 ? <Criteria37 /> : null}
    </div>
  );
}

export default CriteriaView3;
