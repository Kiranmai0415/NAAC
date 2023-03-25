import * as React from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";

import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import GeneralInformation from "./GeneralInformation/GeneralInformation";
import FacultyAwards from "./Faculty Awards/FacultyAwards";
import FullTimeTeacher from "./FullTimeTeacher/FullTimeTeacher";

import Professional from "./Professional/Professional";
import PercentageFullTimeTeacher from "./PercentageFullTimeTeacher/PercentageFullTimeTeacher";

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

function AcadamicResearch() {
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  return (
    <div className="acadamic-container">
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
            aria-label="Academic Research"
          >
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Employee Information"
              {...a11yProps(0)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Awards"
              {...a11yProps(1)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="FullTime Teacher"
              {...a11yProps(2)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Qualification"
              {...a11yProps(3)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Professional"
              {...a11yProps(4)}
            />

          </Tabs>
        </AppBar>
        <SwipeableViews
          axis={theme.direction === "rtl" ? "x-reverse" : "x"}
          index={value}
          onChangeIndex={handleChangeIndex}
        >

          <TabPanel value={value} index={0} dir={theme.direction}>
            <GeneralInformation />
          </TabPanel>
          <TabPanel value={value} index={1} dir={theme.direction}>
            <FacultyAwards />
          </TabPanel>
          <TabPanel value={value} index={2} dir={theme.direction}>
            <FullTimeTeacher />
          </TabPanel>
          <TabPanel value={value} index={3} dir={theme.direction}>
            <PercentageFullTimeTeacher />
          </TabPanel>

          <TabPanel value={value} index={4} dir={theme.direction}>
            <Professional />
          </TabPanel>

        </SwipeableViews>
      </Box>
    </div>
  );
}

export default AcadamicResearch;
