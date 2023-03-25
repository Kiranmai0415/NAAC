// import React, { useState, useEffect } from "react";
// import { toast } from "react-toastify";
// import { resources } from "../../appConstants";
// import AuthService from "../../Pages/Users/services/auth.service";
import React, { useEffect } from "react";
import SwipeableViews from 'react-swipeable-views';
import { useTheme } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { toast } from "react-toastify";

import CriteriaModify1 from "./CriteriaModify-1/c1";
import CriteriaModify2 from "./CriteriaModify-2/c2";
import CriteriaModify3 from "./CriteriaModify-3/c3";
import CriteriaModify4 from "./CriteriaModify-4/c4";
import CriteriaModify5 from "./CriteriaModify-5/c5";
import CriteriaModify6 from "./CriteriaModify-6/c6";
import CriteriaModify7 from "./CriteriaModify-7/c7";

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

// function AuthorizeHODScreen() {
//   const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
//   const [rejectReasonComments, setRejectReasonComments] = useState('');
//   const [principalComments, setPrincipalComments] = useState(null);

//   useEffect(
//     () => fetch("http://localhost:8080/api/v1/getTrackingInfo").then(
//       (response) => response
//         .json()
//         .then((data) => {
//           console.log("data for tracking info " + JSON.stringify(data));
//           setPrincipalComments(data[0].principalComments);
//         })
//         .catch((error) => {
//           console.error("Error:", error);
//           errorMessage("Got the Error Please try after sometime");
//         })
//     ),
//     []
//   );

// let role = null;
// let email = null;
// // eslint-disable-next-line prefer-destructuring
// role = AuthService.getCurrentUser().roles[0];
// email = AuthService.getCurrentUser().email;
// const authorizeContent = {
//   criteriaId: { collegeId: "1", financialYear: "2021-2022", typeofInstitution: "autonomous", },
//   assignedTo: "anamita1996@gmail.com",
//   assignedBy: email,
//   deanComments: "",
//   role,
//   status: "A",
// };
// const rejectContent = {
//   criteriaId: { collegeId: "1", financialYear: "2021-2022", typeofInstitution: "autonomous", },
//   assignedTo: "anamita1996@gmail.com",
//   assignedBy: email,
//   deanComments: rejectReasonComments,
//   role,
//   status: "R",
// };
// function jsonBlob(obj) {
//   return new Blob([JSON.stringify(obj)], {
//     type: "application/json",
//   });
// }
// function onConfirmingReject() {
//   console.log("Rejected");
//   const rejectAPImethod = {
//     method: "POST",
//     headers: { Accept: "application/json" },
//     authorization:
//       "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
//     body: jsonBlob(rejectContent),
//   };
//   fetch(resources.APPLICATION_URL + "deanRejectRecord", rejectAPImethod).then((response) => {
//     console.log(response);
//     if (response.ok) {
//       successMessage("Record is Rejected Successfully");
//     } else if (response.status >= 400) {
//       errorMessage("Got the Error Please retry after sometime");
//     }
//   });
// }
// function onClickingSaveSendingTexts() {
//   console.log("Assigned");
//   const authorizeAPImethod = {
//     method: "POST",
//     headers: { Accept: "application/json" },
//     authorization:
//       "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
//     body: jsonBlob(authorizeContent),
//   };
//   fetch(
//     resources.APPLICATION_URL + "deanAuthorizedEmail",
//     authorizeAPImethod
//   ).then((response) => {
//     console.log(response);
//     if (response.ok) {
//       successMessage("Record is Authorized Successfully");
//     } else if (response.status >= 400) {
//       errorMessage("Got the Error Please retry after sometime");
//     }
//   });
// }
function TabPanel(props) {
  const {
    children, value, index, ...other
  } = props;

  useEffect(
    () => fetch("http://localhost:8080/api/v1/criteria1getallfiles").then(
      (response) => response
        .json()
        .then((data) => {
          if (Object.keys(data).length === 0) {
            errorMessage("No records found for Modify");
          }
        })
    ));

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
    'aria-controls': `full-width-tabpanel-${index}`,
  };
}

export default function AutonomousCriterias() {
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  return (
    <Box sx={{ bgcolor: 'RGBA(250,250,250,.4)', width: "100%" }}>
      <AppBar position="static">
        <Tabs
          sx={{
            backgroundColor: 'white', color: '#0275d8', borderTopLeftRadius: '10px', borderTopRightRadius: '10px'
          }}
          value={value}
          onChange={handleChange}
          textColor="inherit"
          variant="fullWidth"
          aria-label="criterias"
        >
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-1" {...a11yProps(0)} />
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-2" {...a11yProps(1)} />
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-3" {...a11yProps(2)} />
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-4" {...a11yProps(3)} />
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-5" {...a11yProps(4)} />
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-6" {...a11yProps(5)} />
          <Tab sx={{ fontWeight: 'bold' }} label="CriteriaModify-7" {...a11yProps(6)} />
        </Tabs>
      </AppBar>
      <SwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={value}
        onChangeIndex={handleChangeIndex}
      >
        <TabPanel value={value} index={0} dir={theme.direction}>

          <CriteriaModify1 />
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}>
          <CriteriaModify2 />
        </TabPanel>
        <TabPanel value={value} index={2} dir={theme.direction}>
          <CriteriaModify3 />
        </TabPanel>
        <TabPanel value={value} index={3} dir={theme.direction}>
          <CriteriaModify4 />
        </TabPanel>
        <TabPanel value={value} index={4} dir={theme.direction}>
          <CriteriaModify5 />
        </TabPanel>
        <TabPanel value={value} index={5} dir={theme.direction}>
          <CriteriaModify6 />
        </TabPanel>
        <TabPanel value={value} index={6} dir={theme.direction}>
          <CriteriaModify7 />

        </TabPanel>
      </SwipeableViews>
    </Box>
  );
}

// return (
//   <>

//     <CriteriaModify2 />
//     <CriteriaModify3 />
//     <CriteriaModify4 />
//     <CriteriaModify5 />
//     <CriteriaModify6 />
//     <CriteriaModify7 />

//   </>
// );
