import React, { useState } from "react";
import { toast } from "react-toastify";
import SwipeableViews from "react-swipeable-views";
import { useTheme, styled } from "@mui/material/styles";
import AppBar from "@mui/material/AppBar";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Box from "@mui/material/Box";
import PropTypes from "prop-types";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import DialogContent from "@mui/material/DialogContent";
import DialogActions from "@mui/material/DialogActions";
import IconButton from "@mui/material/IconButton";
import CloseIcon from "@mui/icons-material/Close";
import Typography from "@mui/material/Typography";
import "./CriteriaAssign.css";
import AuthService from "../../Pages/Users/services/auth.service";
import { resources } from "../../appConstants";
import { useEffect } from "react";


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

const BootstrapDialog = styled(Dialog)(({ theme }) => ({
  "& .MuiDialogContent-root": {
    padding: theme.spacing(2),
  },
  "& .MuiDialogActions-root": {
    padding: theme.spacing(1),
  },
}));

function BootstrapDialogTitle(props) {
  const { children, onClose, ...other } = props;

  return (
    <DialogTitle sx={{ m: 0, p: 2 }} {...other}>
      {children}
      {onClose ? (
        <IconButton
          aria-label="close"
          onClick={onClose}
          sx={{
            position: "absolute",
            right: 8,
            top: 8,
            color: (theme) => theme.palette.grey[500],
          }}
        >
          <CloseIcon />
        </IconButton>
      ) : null}
    </DialogTitle>
  );
}
BootstrapDialogTitle.propTypes = {
  children: PropTypes.node,
  onClose: PropTypes.func.isRequired,
};

function TabPanel(props) {
  const { children, value, index, ...other } = props;

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

export default function CriteriaAssign() {
  const [open, setOpen] = React.useState(false);
  const [openReAssign, setOpenReAssign] = React.useState(false);
  const [isAssign, setIsAssign] = useState(false);
  const [email1, setEmail1] = useState("");
  const [assignBy, setAssignBy] = useState("");
  const [assignDate, setAssignDate] = useState("");
  const [errors, setErrors] = useState("");
  const [assignedEmail, setAssignedEmail] = useState("");
  const [trackingStatus, setTrackingStatus] = useState(" ");

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }
  console.log("object -->" + JSON.stringify(AuthService.getCurrentUser()));
  let instituteType = AuthService.getCurrentUser().instituteType;
  console.log("instituteType=======>" + instituteType);
  const collegeId = AuthService.getCurrentUser().collegeId;
  console.log("  collegeId==========>" + collegeId);
  const d = new Date();
  let currYear = d.getFullYear();
  console.log("var ==>" + currYear);
  let fYear = parseInt(currYear) - 1 + "-" + currYear;
  console.log("current year==" + fYear);
  useEffect(
    () =>
      fetch(resources.APPLICATION_URL+"getallassignfunctionalitydata").then(
        (response) =>
          response
            .json()
            .then((data) => {
             
              console.log(JSON.stringify(data));

              data.map((eachFaculty) => {
                console.log(JSON.stringify(eachFaculty));
                if (eachFaculty.programmerId == "naacProfile") {
                  setAssignedEmail(eachFaculty.assignedTo);
                  console.log(assignedEmail);
                  let tstatus = eachFaculty.trackingStatus;
                  console.log(tstatus);
                  if (tstatus == "F") {
                    setTrackingStatus(" Pending with faculty");
                  } else {
                    setTrackingStatus(" Pending with Dean");
                  }
                  console.log(trackingStatus);
                }
              });
            })
            .catch((error) => {
              console.error("Error:", error);
            })
      ),
    [errors]
  );
   
  console.log("trackingStatus",trackingStatus)
  const dataAssign = {
    nirfID: {
      collegeId: collegeId,
      financialYear: fYear,
      typeOfInstitution: instituteType,
    },
    assignedTo: email1,
    assignedBy: assignBy,
    assignDate: "",

    programmerId: "naacProfile",
    trackingStatus: "F",
  };

  function onClickingAssign() {
    const methodAssign1 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign),
    };
    fetch(resources.APPLICATION_URL+"assignFunctionality?screenType=overallStudent", methodAssign1).then(
      (response) => {
        console.log(response);
        if (response.ok) {
          successMessage("Assigned Successfully");
        } else if (response.status >= 400) {
          errorMessage("Got the Error Please retry after sometime");
        }
      }
    );
  } 

  const handleClickOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    onClose(selectedValue);
    setOpen(false);

  };

  const handleClickOpenReAssign = () => {
    setOpenReAssign(true);
  };
  const handleCloseReAssign = () => {
    setOpenReAssign(false);
  };

  const theme = useTheme();
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };


  return (
    <div className="container-adjestment">
      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-1</h1>

          
         

          <label> <span className="student-c1-AssignedTo">Assigned To : </span ><span style={{color:"green"}}> {assignedEmail}</span></label>
          <label>
           <span className="student-c1-AssignedTo"> TrackingStatus </span>
           <span style={{color:"green"}}> : {trackingStatus} </span> 
          </label>

          <div className="student-button-container">
            <div>
            {!isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpen();
                  }}
                  className="student-cx-assign-button-style"
                >
                  Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Assign
                </Button>
              )}

              <BootstrapDialog
               onClose={handleClose}
                aria-labelledby="customized-dialog-title"
                open={open}
              >
                <BootstrapDialogTitle
                  id="customized-dialog-title"
                  style={{ color: "#02334d",marginLeft:"35%"}}
                >
                  Assign To
                </BootstrapDialogTitle>
               

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style" ><span style={{ marginLeft:"5px"}}>Email</span> </label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setAssignedEmail(e.target.value)}
                    />
               
                    <label className="online-edu-label-style"> <span style={{ marginLeft:"5px"}}>Date</span>   </label>
                    <input
                      type="date"
                      value={assignDate}
                      name="assignDate"
                      id="assignDate"
                      onChange={(e) => setAssignDate(e.target.value)}
                    />
                  </div>
                </DialogContent>
                <DialogActions>
                  <Button
                    autoFocus
                    onClick={() => {
                      handleClickOpen();
                      setIsAssign(true);
                      onClickingAssign();
                    }}
                  >
                    Assign
                  </Button>
                </DialogActions>
              </BootstrapDialog>
            </div>
            
          </div>
        </div>
      </div>
</div>
  
  );
}


   