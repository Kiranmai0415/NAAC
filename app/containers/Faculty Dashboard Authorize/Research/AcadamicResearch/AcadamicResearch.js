import * as React from "react";
import SwipeableViews from "react-swipeable-views";
import { useTheme } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";

import Patents from "./Patents/Patents";
import PhDAwarded from "./Ph.DAwarded/PhDAwarded";
import Publications from "./Publications/Publications";
import Books from "./Books/Books";
import CollaborationsLinkages from "./CollaborationsLinkages/CollaborationsLinkages";

import NoOfWorkshop from "./NoOfWorkshops/NoOfWorkshop";
import Fellowship from "./FellowShip/FellowShip";

import ResearchGuides from "./ResearchGuides/ResearchGuides";
import Mous from "./Mous/Mous";
import ResearchFellows from "./ResearchFellows/ResearchFellows";
import AwardandRecogintion from "./AwardsandRecognition/AwardsandRecognition";
import Hindex from "./h-index/Hindex";
import Citations from "./Citations/Citations";

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
            aria-label="Acadamic Research"
          >
            <Tab
              sx={{ fontWeight: "bold" }}
              label=" Workshop"
              {...a11yProps(0)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Ph.D Awarded "
              {...a11yProps(1)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Publications"
              {...a11yProps(2)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label=" Patents"
              {...a11yProps(3)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Collaborations Linkages"
              {...a11yProps(4)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Books"
              {...a11yProps(5)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Fellowship"
              {...a11yProps(6)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Research Guides"
              {...a11yProps(7)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Mous"
              {...a11yProps(8)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Research Fellows"
              {...a11yProps(9)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Award and Recogintion"
              {...a11yProps(10)}
            />

            <Tab
              sx={{ fontWeight: "bold" }}
              label="H-Index"
              {...a11yProps(11)}
            />
            <Tab
              sx={{ fontWeight: "bold" }}
              label="Citations"
              {...a11yProps(12)}
            />

          </Tabs>
        </AppBar>
        <SwipeableViews
          axis={theme.direction === "rtl" ? "x-reverse" : "x"}
          index={value}
          onChangeIndex={handleChangeIndex}
        >

          <TabPanel value={value} index={0} dir={theme.direction}>
            <NoOfWorkshop/>
          </TabPanel>
          <TabPanel value={value} index={1} dir={theme.direction}>
            <PhDAwarded />
          </TabPanel>
          <TabPanel value={value} index={2} dir={theme.direction}>
            <Publications />
          </TabPanel>
          <TabPanel value={value} index={3} dir={theme.direction}>
            <Patents />
          </TabPanel>
          <TabPanel value={value} index={4} dir={theme.direction}>
            <CollaborationsLinkages />
          </TabPanel>

          <TabPanel value={value} index={5} dir={theme.direction}>
            <Books />
          </TabPanel>

          <TabPanel value={value} index={6} dir={theme.direction}>
            <Fellowship />
          </TabPanel>
          <TabPanel value={value} index={7} dir={theme.direction}>
            <ResearchGuides />
          </TabPanel>
          <TabPanel value={value} index={8} dir={theme.direction}>
            <Mous />
          </TabPanel>
          <TabPanel value={value} index={9} dir={theme.direction}>
            <ResearchFellows />
          </TabPanel>
          <TabPanel value={value} index={10} dir={theme.direction}>
            <AwardandRecogintion />
          </TabPanel>
          <TabPanel value={value} index={11} dir={theme.direction}>
            <Hindex />
          </TabPanel>
          <TabPanel value={value} index={12} dir={theme.direction}>
            <Citations />
          </TabPanel>

        </SwipeableViews>
      </Box>
    </div>
  );
}

export default AcadamicResearch;
