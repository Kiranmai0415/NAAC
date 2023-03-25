import React, { useState } from 'react';

import Criteria1 from '../QIF/Criteria-1/c1';
import Criteria2 from '../QIF/Criteria-2/c2';
import Criteria3 from '../QIF/Criteria-3/c3';
import Criteria4 from '../QIF/Criteria-4/c4';
import Criteria5 from '../QIF/Criteria-5/c5';
import Criteria6 from '../QIF/Criteria-6/c6';
import Criteria7 from '../QIF/Criteria-7/c7';

function AuthorizeScreen() {
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const rejectContent = {
    emailAddress: 'namita131996@gmail.com',
    comments: 'Please check the year-wise college data given in Criteria 4',
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: 'application/json',
    });
  }
  function onConfirmingReject() {
    console.log('Assigned');
    const rejectAPImethod = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(rejectContent),
    };
    fetch('http://localhost:8080/api/v1/sendMail', rejectAPImethod).then(
      (response) => console.log(response)
    );
  }

  return (
    <>
      <Criteria1 />
      <Criteria2 />
      <Criteria3 />
      <Criteria4 />
      <Criteria5 />
      <Criteria6 />
      <Criteria7 />

      <div className="c31x-button-container">
        <button
          onClick={() => {
            // onClickingSaveSendingTexts();
          }}
          className="c31x-button-style"
          style={{ color: 'white', backgroundColor: 'green' }}
        >
          Authorize
        </button>

        <button
          onClick={() => {
            setRejectButtonClickStatus(true);
          }}
          className="c31x-button-style"
          style={{ color: 'white', backgroundColor: 'red' }}
        >
          Reject
        </button>
      </div>
      {rejectButtonClickStatus ? (
        <div style={{ marginLeft: '13%' }}>
          <h1>Reason for Rejection</h1>
          <textarea cols={110} rows={6}></textarea>
          <div>
            <button
              onClick={() => setRejectButtonClickStatus(false)}
              style={{
                color: 'black',
                backgroundColor: 'white',
                borderRadius: '4px',
                marginRight: '3%',
                boxShadow:
                  '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',
              }}
            >
              Cancel
            </button>
            <button
              onClick={() => {
                setRejectButtonClickStatus(false);
                onConfirmingReject();
              }}
              style={{
                color: 'black',
                backgroundColor: 'white',
                borderRadius: '4px',
                boxShadow:
                  '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',
              }}
            >
              Confirm Reject
            </button>
          </div>
        </div>
      ) : null}
    </>
  );
}

export default AuthorizeScreen;
