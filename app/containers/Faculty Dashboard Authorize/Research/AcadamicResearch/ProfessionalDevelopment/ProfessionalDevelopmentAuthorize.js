import React, { useState } from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import { toast } from "react-toastify";
import "./ProfessionalDevelopmentAuthorize.css"


// Alert custom messages start
const successMessage = (message) => {
  toast.success(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "success1",
  });
};
const errorMessage = (message) => {
  toast.error(message, {
    position: toast.POSITION.TOP_CENTER,
    toastId: "error1",
  });
};
// End here

function TabPanel(props) {
  const {
    children, value, index, ...other
  } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`full-width-tabpanel-${index}`}
      aria-labelledby={`full-width-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    "aria-controls": `full-width-tabpanel-${index}`,
  };
}

function ProfessionalDevelopmentAuthorize() {
  const theme = useTheme();
  const [value, setValue] = React.useState(0);
  const [assignStatus1, setAssignStatus1] = useState('');

  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectComment, setRejectComment] = useState();
  const rejectContent = {
    nirfID: {
      collegeId: 1,
      financialYear: "2022",
      typeOfInstitution: "overall"
    },
    assignedTo: 'sireeshasiri830@gmail.com',
    assignedBy: 'kothapetateja189@gmail.com',
    deanComments: rejectComment,
  };

  const authContent = {
    nirfID: {
      collegeId: 1,
      financialYear: "2022",
      typeOfInstitution: "overall"
    },
    assignedTo: 'sireeshasiri830@gmail.com',
    assignedBy: 'kothapetateja189@gmail.com',
    deanComments: "",
  };

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
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
    fetch('http://localhost:9090/api/v1/principalRejectRecord?screenType=overall', rejectAPImethod).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Inserted Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  function onConfirmingAuthorize(e) {
    e.preventDefault();
    console.log('Assigned');
    const authAPImethod = {
      method: 'POST',
      headers: { Accept: 'application/json' },
      authorization:
        'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
      body: jsonBlob(authContent),
    };
    fetch('http://localhost:9090/api/v1/principalAuthorizedEmail?screenType=overall', authAPImethod)
      .then((response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Inserted Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      });
  }
  return (

    <div>
      <div className="accreditation-container2">
       
        <div className="accreditation-button-container">
          <button
            onClick={(e) => {
              onConfirmingAuthorize(e);
            }}
            className="student-button-style"
            style={{ color: 'white', backgroundColor: "green" }}
          >
            Authorize
          </button>

          <button
            onClick={() => {
              setRejectButtonClickStatus(true);
            }}
            className="accreditation-button-style"
            style={{ color: 'white', backgroundColor: "red"}}
          >
            Reject
          </button>
        </div>
        {rejectButtonClickStatus ? (
          <div style={{ marginLeft: '13%' }}>
            <h1>Reason for Rejection</h1>
            <textarea value={rejectComment} onChange={(e) => setRejectComment(e.target.value)} cols={90} rows={6}>{rejectComment}</textarea>
            <div>
              <button
                onClick={() => setRejectButtonClickStatus(false)}
                style={{
                  color: 'black',
                  backgroundColor: 'grey',
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
                  color: 'white',
                  backgroundColor: 'red',
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
      </div>
    </div>

  );
}
export default ProfessionalDevelopmentAuthorize;
