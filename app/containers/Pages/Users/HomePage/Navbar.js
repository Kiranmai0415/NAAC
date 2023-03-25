import React from 'react';
import {
  AppBar,
  Toolbar,
  CssBaseline,
  Typography,
  makeStyles,
  useTheme,
  useMediaQuery,
} from '@material-ui/core';
import { Link } from 'react-router-dom';
import DrawerComponent from './Drawer';
import CMRLogo from '../../api/images/logo-3.png';
const useStyles = makeStyles((theme) => ({
  navlinks: {
    marginLeft: theme.spacing(5),
    display: 'flex',
  },
  logo: {
    flexGrow: '1',
    cursor: 'pointer',
  },
  link: {
    textDecoration: 'none',
    color: 'white',
    fontSize: '20px',
    marginLeft: theme.spacing(20),
    '&:hover': {
      color: 'yellow',
      borderBottom: '1px solid white',
    },
  },
}));

function Navbar() {
  const classes = useStyles();
  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('md'));
  const imgRef = React.createRef();
  // Fetching current height and width
  const height = 60;
  const width = 200;
  return (

    <AppBar>
      <CssBaseline />
      <Toolbar>
        <Typography variant="h4" className={classes.logo}>
          <img
            height={height}
            width={width}
            src={CMRLogo}
            alt="profile-img"
          />
        </Typography>
        {isMobile ? (
          <DrawerComponent />
        ) : (
          <div className={classes.navlinks}>
            <Link to="/erpLandingPage" className={classes.link}>
              Home
            </Link>
            <Link to="/about" className={classes.link}>
              About
            </Link>
            <Link to='' className={classes.link}>
              Sign
            </Link>
            <Link to='' className={classes.link}>
              Register
            </Link>
          </div>
        )}
      </Toolbar>
    </AppBar>
  );
}
export default Navbar;
