import * as React from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import ValueAdded from "./ValueAdded/ValueAdded";
import FieldProjects from "./FieldProjects/FieldProjects";
import FinancialSupport from "./FinancialSupport/FinancialSupport";
import PassPercentage from "./PassPercentage/PassPercentage";
import Online from "./Online/Online";
import Econtent from "./Econtent/Econtent";
import CentricMethod from "./CentricMethod/CentricMethod";
import TeachingPedagology from "./TeachingPedagology/TeachingPedagology";
import Attainment from "./Attainment/Attainment";

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

function Acadamics() {
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  return (
    <div className="academic-container">
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
              label=" Co-Ordinator"
              {...a11yProps(0)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Guide"
              {...a11yProps(1)}
            />

            <Tab
              sx={{ fontWeight: "bold" }}
              label="Financial Support "
              {...a11yProps(2)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label=" Pass Percentage"
              {...a11yProps(3)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Online"
              {...a11yProps(4)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="E-content Developed"
              {...a11yProps(5)}
            />

            <Tab
              sx={{ fontWeight: "bold" }}
              label="Centric Method"
              {...a11yProps(6)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Teaching Pedagology"
              {...a11yProps(7)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Attainment"
              {...a11yProps(8)}
            />

          </Tabs>
        </AppBar>
        <SwipeableViews
          axis={theme.direction === "rtl" ? "x-reverse" : "x"}
          index={value}
          onChangeIndex={handleChangeIndex}
        >
          <TabPanel value={value} index={0} dir={theme.direction}>
            <ValueAdded />
          </TabPanel>
          <TabPanel value={value} index={1} dir={theme.direction}>
            <FieldProjects />
          </TabPanel>
          <TabPanel value={value} index={2} dir={theme.direction}>
            <FinancialSupport />
          </TabPanel>
          <TabPanel value={value} index={3} dir={theme.direction}>
            <PassPercentage />
          </TabPanel>
          <TabPanel value={value} index={4} dir={theme.direction}>
            <Online />
          </TabPanel>
          <TabPanel value={value} index={5} dir={theme.direction}>
            <Econtent />
          </TabPanel>
          <TabPanel value={value} index={6} dir={theme.direction}>
            <CentricMethod />
          </TabPanel>

          <TabPanel value={value} index={7} dir={theme.direction}>
            <TeachingPedagology />
          </TabPanel>

          <TabPanel value={value} index={8} dir={theme.direction}>
            <Attainment />
          </TabPanel>

        </SwipeableViews>
      </Box>
    </div>
  );
}

export default Acadamics;
