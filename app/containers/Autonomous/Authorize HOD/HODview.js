import React, { useState } from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import CriteriaView1 from "./ViewHOD/CriteriaView-1/c1";
import CriteriaView2 from "./ViewHOD/CriteriaView-2/c2";
import CriteriaView3 from "./ViewHOD/CriteriaView-3/c3";
import CriteriaView4 from "./ViewHOD/CriteriaView-4/c4";
import CriteriaView5 from "./ViewHOD/CriteriaView-5/c5";
import CriteriaView6 from "./ViewHOD/CriteriaView-6/c6";
import CriteriaView7 from "./ViewHOD/CriteriaView-7/c7";

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

function HODViewScreen() {
  // const [rejectButtonClickStatus, setRejectButtonClickStatus] = useState(false);
  // const rejectContent = {
  //   emailAddress: 'namita131996@gmail.com',
  //   comments: 'Please check the year-wise college data given in Criteria 4',
  // };

  // function jsonBlob(obj) {
  //   return new Blob([JSON.stringify(obj)], {
  //     type: 'application/json',
  //   });
  // }
  // function onConfirmingReject() {
  //   console.log('Assigned');
  //   const rejectAPImethod = {
  //     method: 'POST',
  //     headers: { Accept: 'application/json' },
  //     authorization:
  //       'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ',
  //     body: jsonBlob(rejectContent),
  //   };
  //   fetch('http://localhost:8080/api/v1/authorizedEmail', rejectAPImethod).then(
  //     (response) => console.log(response)
  //   );
  // }

  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  return (
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
          <CriteriaView1 />
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}>
          <CriteriaView2 />
        </TabPanel>
        <TabPanel value={value} index={2} dir={theme.direction}>
          <CriteriaView3 />
        </TabPanel>
        <TabPanel value={value} index={3} dir={theme.direction}>
          <CriteriaView4 />
        </TabPanel>
        <TabPanel value={value} index={4} dir={theme.direction}>
          <CriteriaView5 />
        </TabPanel>
        <TabPanel value={value} index={5} dir={theme.direction}>
          <CriteriaView6 />
        </TabPanel>
        <TabPanel value={value} index={6} dir={theme.direction}>
          <CriteriaView7 />
        </TabPanel>
      </SwipeableViews>
    </Box>
  );
}

export default HODViewScreen;
