import * as React from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import Grants from "./Grants/Grants";
import Consultancy from "./Consultancy/Consultancy";
import SeedMoney from "./SeedMoney/SeedMoney";
import RevenueCorporate from "./RevenueCorporate/RevenueCorporate";

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
            aria-label="SpronseredResearch"
          >
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Consultancy"
              {...a11yProps(0)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label=" Revenue Corporate "
              {...a11yProps(1)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Grants"
              {...a11yProps(2)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label=" Seed Money"
              {...a11yProps(3)}
            />

          </Tabs>
        </AppBar>
        <SwipeableViews
          axis={theme.direction === "rtl" ? "x-reverse" : "x"}
          index={value}
          onChangeIndex={handleChangeIndex}
        >

          <TabPanel value={value} index={0} dir={theme.direction}>
            <Consultancy />
          </TabPanel>
          <TabPanel value={value} index={1} dir={theme.direction}>
            <RevenueCorporate/>
          </TabPanel>
          <TabPanel value={value} index={2} dir={theme.direction}>
            <Grants />
          </TabPanel>

          <TabPanel value={value} index={3} dir={theme.direction}>
            <SeedMoney />
          </TabPanel>

        </SwipeableViews>
      </Box>
    </div>
  );
}

export default AcadamicResearch;
