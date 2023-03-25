import React, { useState } from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import { toast } from "react-toastify";
import { resources } from "../../appConstants";

import AuthService from "../../Pages/Users/services/auth.service";
import CriteriaAuthze1 from "./Authoze principal c1";
import CriteriaAuthoze2 from "./Authoze principal c2";
import CriteriaAuthoze3 from "./Authoze principal c3";
import CriteriaAuthoze4 from "./Authoze principal c4";
import CriteriaAuthoze5 from "./Authoze principal c5";
import CriteriaAuthoze6 from "./Authoze principal c6";
import CriteriaAuthoze7 from "./Authoze principal c7";

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

function AuthorizePrincipalScreen() {
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("eamcetCode==========>" + collegeId);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring
  role = AuthService.getCurrentUser().roles[0];
  email = AuthService.getCurrentUser().email;
  const authorize = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    principalComments: "",
    role,
    status: "A",
  };

  const rejectContent = {
    criteriaId: {
      collegeId: collegeId,
      financialYear: fYear,
      typeofInstitution: instituteType,
    },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    principalComments: rejectReasonComments,
    role,
    status: "R",
  };

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function getAuthorizePrincipal() {
    console.log("Authorize Principal");
    const authAPIMethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorize),
    };
    fetch(
      resources.APPLICATION_URL +
        'principalAuthorizedEmail',
      authAPIMethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  function onConfirmingReject() {
    console.log("Assigned");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(
      resources.APPLICATION_URL +
        "principalRejectRecord?institutionType=" +
        instituteType,
      rejectAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Rejected Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }

  return (
    <>
      {/* <CriteriaView1 />
      <CriteriaView2 />
      <CriteriaView3 />
      <CriteriaView4 />
      <CriteriaView5 />
      <CriteriaView6 />
      <CriteriaView7 /> */}

      <Box sx={{ bgcolor: "RGBA(250,250,250,.4)", width: "100%" }}>
        <AppBar position="static">
          <Tabs
            sx={{
              backgroundColor: "white",
              color: "#0275d8",
              borderTopLeftRadius: "10px",
              borderTopRightRadius: "10px",
            }}
            value={value}
            onChange={handleChange}
            textColor="inherit"
            variant="fullWidth"
            aria-label="criterias"
          >
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-1"
              {...a11yProps(0)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-2"
              {...a11yProps(1)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-3"
              {...a11yProps(2)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-4"
              {...a11yProps(3)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-5"
              {...a11yProps(4)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-6"
              {...a11yProps(5)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Criteria-7"
              {...a11yProps(6)}
            />
          </Tabs>
        </AppBar>
        <SwipeableViews
          axis={theme.direction === "rtl" ? "x-reverse" : "x"}
          index={value}
          onChangeIndex={handleChangeIndex}
        >
          <TabPanel value={value} index={0} dir={theme.direction}>
            <CriteriaAuthze1 />
          </TabPanel>
          <TabPanel value={value} index={1} dir={theme.direction}>
            <CriteriaAuthoze2 />
          </TabPanel>
          <TabPanel value={value} index={2} dir={theme.direction}>
            <CriteriaAuthoze3 />
          </TabPanel>
          <TabPanel value={value} index={3} dir={theme.direction}>
            <CriteriaAuthoze4 />
          </TabPanel>
          <TabPanel value={value} index={4} dir={theme.direction}>
            <CriteriaAuthoze5 />
          </TabPanel>
          <TabPanel value={value} index={5} dir={theme.direction}>
            <CriteriaAuthoze6 />
          </TabPanel>
          <TabPanel value={value} index={6} dir={theme.direction}>
            <CriteriaAuthoze7 />
            <div className="c31x-button-container">
              {/* <button
                onClick={() => {
                  getAuthorizePrincipal();
                }}
                className="c31x-button-style"
                style={{ color: "white", backgroundColor: "green" }}
              >
                Authorize
              </button>

              <button
                onClick={() => {
                  setRejectButtonClickStatus(true);
                }}
                className="c31x-button-style"
                style={{ color: "white", backgroundColor: "red" }}
              >
                Reject
              </button> */}
            </div>
            {rejectButtonClickStatus ? (
              <div style={{ marginLeft: "13%" }}>
                <h1>Reason for Rejection</h1>
                <textarea
                  cols={110}
                  rows={6}
                  onChange={(e) => setRejectReasonComments(e.target.value)}
                ></textarea>
                <div>
                  <button
                    onClick={() => setRejectButtonClickStatus(false)}
                    style={{
                      color: "black",
                      backgroundColor: "white",
                      borderRadius: "4px",
                      marginRight: "3%",
                      boxShadow:
                        "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
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
                      color: "black",
                      backgroundColor: "white",
                      borderRadius: "4px",
                      boxShadow:
                        "0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)",
                    }}
                  >
                    Confirm Reject
                  </button>
                </div>
              </div>
            ) : null}
          </TabPanel>
        </SwipeableViews>
      </Box>
    </>
  );
}

export default AuthorizePrincipalScreen;
