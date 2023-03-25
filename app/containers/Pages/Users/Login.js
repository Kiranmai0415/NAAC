import React, { useState, useRef } from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import { useHistory } from 'react-router-dom';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import NAACBrochure2 from '../../../../public/images/NAAC brochure-2.png';
//import Vignans from '../../../../public/images/Vignans-logo.png';
import Vignans from '../../../../public/images/Adiversetech-Logo.jpg'
import AuthService from './services/auth.service';

function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="http://www.adiversetech.com/">
        Adiversetech.com
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

const theme = createTheme();

export default function SignInSide() {
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');

  const checkBtn = useRef();
  const history = useHistory();
  let dashboard = '/app/pages/faculty Dashboard';
  const handleSubmit = (event) => {
    event.preventDefault();
    setMessage('');
    setLoading(true);

    const data = new FormData(event.currentTarget);
    const username = data.get('username');
    const password = data.get('password');
    console.log('user name :' + username);
    console.log('password :' + password);
    if (username !== '' && password !== '') {
      AuthService.login(username, password).then(
        (response) => {
          console.log('is it login success' + JSON.stringify(response));
          // history.push("/app/dashboard/faculty");
          // history.push('app/pages/dashboard');
          console.log('role of the user is ==>' + response.roles[0]);
          if (response.roles[0] === 'ROLE_FACULTY') {
            dashboard = '/app/Autonomous/faculty Dashboard';
          } else if (response.roles[0] === 'ROLE_DEAN') {
            dashboard = '/app/Autonomous/dean Dashboard';
          } else if (response.roles[0] === 'ROLE_PRINCIPAL') {
            dashboard = '/app/Autonomous/principal Dashboard';
          } else if (response.roles[0] === 'ROLE_QUALITYADVISOR') {
            dashboard = '/app/Autonomous/Quality Advisor Dashboard';
          }
          history.push(dashboard);
          window.location.reload();
        },
        (error) => {
          const resMessage = (error.response
              && error.response.data
              && error.response.data.message)
            || error.message
            || error.toString();

          setLoading(false);
          setMessage(resMessage);
        }
      );
    } else {
      setLoading(false);
    }
  };

  return (
    <ThemeProvider theme={theme}>
      <Grid container component="main" sx={{ height: '100vh' }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage: 'url(https://source.unsplash.com/random/?city,night,fruit)',
            backgroundRepeat: 'no-repeat',
            backgroundColor: (t) => (t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900]),
            backgroundSize: 'cover',
            backgroundPosition: 'center',
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <div style={{ margin: '10px' }}><img src={Vignans} alt="Vignans University" style={{ width: '350px', }} /></div>
            <div>
              <Typography component="h1" variant="h5">
              Sign in
              </Typography>
            </div>
            <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1 }}>
              <TextField
                margin="normal"
                required
                fullWidth
                id="username"
                label="User Name"
                name="username"
                autoComplete="username"
                autoFocus
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />
              <FormControlLabel
                control={<Checkbox value="remember" color="primary" />}
                label="Remember me"
              />
              {message && (
                <div className="form-group">
                  <div className="alert alert-danger" role="alert">
                    {message}
                  </div>
                </div>
              )}
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item xs>
                  <Link href="/register" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Link href="/register" variant="body2">
                    {"Don't have an account? Sign Up"}
                  </Link>
                </Grid>
              </Grid>
              <Copyright sx={{ mt: 5 }} />
            </Box>
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}
