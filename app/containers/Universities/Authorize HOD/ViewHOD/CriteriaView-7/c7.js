import React, { useState } from 'react';
import Criteria71 from './cV71/c71.js';
import Criteria72 from './cV72/c72.js';
import Criteria73 from './cV73/c73.js';
import './c7-style.css';

function CriteriaView3() {
  // state variables
  const [screenStatus71, setScreenStatus71] = useState(false);
  const [screenStatus72, setScreenStatus72] = useState(false);
  const [screenStatus73, setScreenStatus73] = useState(false);

  // rendering DOM
  return (
    <div className="c7-container">
      {/* Criteria Heading */}
      <div className="c7-heading-container">
        <h1 className="c7-heading-style">
        Institutional Values and Best Practices (100)

        </h1>
      </div>

      {/* Key Indicators List */}

      {/* Key Indicator: 7.1 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus71(!screenStatus71)}
            className="c7x-heading-style"
          >
            7.1 Institutional Values and Social Responsibilities (50)
          </h1>
        </div>
      </div>
      {screenStatus71 ? <Criteria71 /> : null}

      {/* Key Indicator: 7.2 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus72(!screenStatus72)}
            className="c7x-heading-style"
          >
           7.2 Best Practices (30)
          </h1>
        </div>
      </div>
      {screenStatus72 ? <Criteria72 /> : null}

      {/* Key Indicator: 7.3 */}
      <div className="c7x-container">
        <div className="c7x-subContainer">
          <h1
            onClick={() => setScreenStatus73(!screenStatus73)}
            className="c7x-heading-style"
          >
          7.3 Institutional Distinctiveness (20)
          </h1>
        </div>
      </div>
      {screenStatus73 ? <Criteria73 /> : null}
    </div>
  );
}

export default CriteriaView3;
