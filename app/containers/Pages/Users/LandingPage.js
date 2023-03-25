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
import Grid from '@mui/material/Grid';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { Link } from 'react-router-dom';
import DrawerComponent from './HomePage/Drawer';
import './LandingPage.css';
import CMRLogo from '../../../api/images/logo-3.png';
import headerBackground from '../../../api/images/CMRTC.jpg';
import NAACBrochure1 from '../../../../public/images/NAAC brochure-1.png';

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

const App = () => {
  const myStyle = {
    backgroundImage: `url(${NAACBrochure1})`,
    height: '100vh',
    marginTop: '-70px',
    fontSize: '50px',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
  };
  const height = 60;
  const width = 200;
  const classes = useStyles();
  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('md'));
  const imgRef = React.createRef();
  return (
    <ThemeProvider theme={theme}>
      <Grid container component="main" sx={{ height: '100vh' }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={12}
          sx={{
            backgroundImage: `url(${NAACBrochure1})`,
            backgroundRepeat: 'no-repeat',
            backgroundColor: (t) => (t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900]),
            backgroundSize: 'contain',
            backgroundPosition: 'center',
            height: 700,
            width: 900
          }}
        />
        <AppBar>
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
                <Link to='/login' className={classes.link}>
                  Sign
                </Link>
                <Link to='/Register' className={classes.link}>
                  Register
                </Link>
              </div>
            )}
          </Toolbar>
        </AppBar>
      </Grid>
    </ThemeProvider>
  );
};

export default App;
