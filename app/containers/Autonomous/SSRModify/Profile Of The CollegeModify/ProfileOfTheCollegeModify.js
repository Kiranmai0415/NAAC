import * as React from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import BasicInfo from "./BasicInformation/BasicInfo.js";
import AccademicInfo from "./AcademicInformation/AcademicInfo.js";
import EvaluativeReport from "./EvaluativeReportOfTheDepartments/EvaluativeReport.js";

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

export default function ProfileOfTheCollegeModify() {
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
            color: "#02334d",
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
            label="BasicInfo"
            {...a11yProps(0)}
          />
          <Tab
            sx={{ fontWeight: "bold" }}
            label="AccademicInfo"
            {...a11yProps(1)}
          />
          <Tab
            sx={{ fontWeight: "bold" }}
            label="EvaluativeReport"
            {...a11yProps(2)}
          />
        </Tabs>
      </AppBar>
      <SwipeableViews
        axis={theme.direction === "rtl" ? "x-reverse" : "x"}
        index={value}
        onChangeIndex={handleChangeIndex}
      >
        <TabPanel value={value} index={0} dir={theme.direction}>
          <BasicInfo />
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}>
          <AccademicInfo />
        </TabPanel>
        <TabPanel value={value} index={2} dir={theme.direction}>
          <EvaluativeReport />
        </TabPanel>
      </SwipeableViews>
    </Box>
  );
}
