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
import { resources } from "../../appConstants";

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

  function jsonBlob(obj) {
    return new Blob([JSON.stringify(obj)], {
      type: "application/json",
    });
  }

  const dataAssign = {
    nirfID: {
      collegeId: "1",
      financialYear: "2022",
    },
    facultyAuthorizedEmail: email1,
  };

  function onClickingAssign() {
    const methodAssign1 = {
      method: "POST",
      headers: { Accept: "application/json" },
      authorization:
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHVkZW50LnByb2ZpbGUiLCJpYXQiOjE2NjMwNTcyODUsImV4cCI6MTY2MzE0MzY4NX0.jFSgzv5ZYDLtsoL9afkwDCNRdFdJKIBdu7i-JpFjnzJW78tx9qIb4IAONAHAomZTVFt_D1SbSKqvJS8v02cRQQ",
      body: jsonBlob(dataAssign),
    };
    fetch(resources.APPLICATION_URL+"studentdata", methodAssign1).then(
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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>

      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-2</h1>

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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>

      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-3</h1>

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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>

      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-4</h1>

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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>

      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-5</h1>

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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>

      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-6</h1>

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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>

      <div className="student-container2">
        <div className="student-heading-container">
          <h1 className="student-c1-heading-style">Criteria-7</h1>

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
                  onClose={handleClose}
                  style={{ color: "#02334d" }}
                >
                  Assign To
                </BootstrapDialogTitle>

                <DialogContent dividers>
                  <div style={{ padding: "50px" }}>
                    <label className="online-edu-label-style">Email ID:</label>
                    <input
                      className="online-edu-input-style"
                      type="text"
                      onChange={(e) => setEmail1(e.target.value)}
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
            <div style={{ marginLeft: "5%" }}>
              {isAssign ? (
                <Button
                  variant="outlined"
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                  className="student-cx-assign-button-style"
                  style={{ color: "#02334d" }}
                >
                  Re-Assign
                </Button>
              ) : (
                <Button
                  variant="outlined"
                  disabled
                  className="student-cx-assign-button-style"
                >
                  Re-Assign
                </Button>
              )}
            </div>
            {/* ReAssign */}

            <BootstrapDialog
              onClose={handleCloseReAssign}
              aria-labelledby="customized-dialog-title"
              open={openReAssign}
            >
              <BootstrapDialogTitle
                id="customized-dialog-title"
                onClose={handleCloseReAssign}
              >
                Assign To
              </BootstrapDialogTitle>

              <DialogContent dividers>
                <div style={{ padding: "50px" }}>
                  <label className="online-edu-label-style">Email ID:</label>
                  <input className="online-edu-input-style" type="text" />
                </div>
              </DialogContent>
              <DialogActions>
                <Button
                  autoFocus
                  onClick={() => {
                    handleClickOpenReAssign();
                  }}
                >
                  Re-Assign
                </Button>
              </DialogActions>
            </BootstrapDialog>
          </div>
        </div>
      </div>
    </div>
  );
}
