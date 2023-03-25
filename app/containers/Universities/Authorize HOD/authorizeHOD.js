import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";

import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import { resources } from "../../appConstants";

import AuthService from "../../Pages/Users/services/auth.service";
// import aa from "./ViewHOD/CriteriaView-1/"
import Criteria1 from "./AuthozeHodc1";
import Criteria2 from "./AuthozeHodc2";
import Criteria3 from "./AuthozeHodc3";
import Criteria4 from "./AuthozeHodc4";
import Criteria5 from "./AuthozeHodc5";
import Criteria6 from "./AuthozeHodc6";
import Criteria7 from "./AuthozeHodc7";

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

function AuthorizeHODScreen() {
  const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  const [rejectReasonComments, setRejectReasonComments] = useState("");

  let role = null;
  let email = null;
  // eslint-disable-next-line prefer-destructuring
  role = AuthService.getCurrentUser().roles[0];
  email = AuthService.getCurrentUser().email;
  const authorizeContent = {
    criteriaId: { collegeId: "1", financialYear: "2021-2022" },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    deanComments: "",
    role,
    status: "A",
  };
  const rejectContent = {
    criteriaId: { collegeId: "1", financialYear: "2021-2022" },
    assignedTo: "anamita1996@gmail.com",
    assignedBy: email,
    deanComments: rejectReasonComments,
    role,
    status: "R",
  };
  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  function onConfirmingReject() {
    console.log("Rejected");
    const rejectAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(rejectContent),
    };
    fetch(resources.APPLICATION_URL + "deanRejectRecord", rejectAPImethod).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Record is Rejected Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  }
  function onClickingSaveSendingTexts() {
    console.log("Assigned");
    const authorizeAPImethod = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(authorizeContent),
    };
    fetch(
      resources.APPLICATION_URL + "deanAuthorizedEmail",
      authorizeAPImethod
    ).then((response) => {
      console.log(response);
      if (response.ok) {
        successMessage("Record is Authorized Successfully");
      } else if (response.status >= 400) {
        errorMessage("Got the Error Please retry after sometime");
      }
    });
  }
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  return (
    <>
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
            <Criteria1 />
          </TabPanel>
          <TabPanel value={value} index={1} dir={theme.direction}>
            <Criteria2 />
          </TabPanel>
          <TabPanel value={value} index={2} dir={theme.direction}>
            <Criteria3 />
          </TabPanel>
          <TabPanel value={value} index={3} dir={theme.direction}>
            <Criteria4 />
          </TabPanel>
          <TabPanel value={value} index={4} dir={theme.direction}>
            <Criteria5 />
          </TabPanel>
          <TabPanel value={value} index={5} dir={theme.direction}>
            <Criteria6 />
          </TabPanel>
          <TabPanel value={value} index={6} dir={theme.direction}>
            <Criteria7 />
          </TabPanel>
        </SwipeableViews>
      </Box>

      <div className="c31x-button-container">
        {/* <button
          onClick={() => {
            onClickingSaveSendingTexts();
          }}
          className="c31x-button-style"
          style={{ color: "white", backgroundColor: "green" }}
        >
          Authorize
        </button> */}

        {/* <button
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
    </>
  );
}

export default AuthorizeHODScreen;
