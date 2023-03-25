import React, { useState, useRef } from 'react';
import { useHistory } from 'react-router-dom';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { da } from 'date-fns/locale';
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

export default function Register() {
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');
  const history = useHistory();
  const handleSubmit = (event) => {
    event.preventDefault();
    setMessage('');
    setLoading(true);

    const data = new FormData(event.currentTarget);
    console.log({
      username: data.get('username'),
      email: data.get('email'),
      password: data.get('password'),
      role: data.get('role'),
      instituteType: data.get('instituteType'),
      eamcetCode: data.get('eamcetCode')
    });

    const username = data.get('username');
    const email = data.get('email');
    const password = data.get('password');
    const roleItem = data.get('role');
    const role = [roleItem];
    const instituteType = data.get('instituteType');
    const eamcetCode = data.get('eamcetCode');
    const collegeName = data.get('collegeName');
    console.log('user name :' + username);
    console.log('email : ' + email);
    console.log('password :' + password);
    console.log('role : ' + role[0]);
    console.log('instituteType : ' + instituteType);
    console.log('Eamcet Code : ' + eamcetCode);
    console.log('College Name', collegeName);
    if (username !== '' && password !== '') {
      AuthService.register(username, email, password, role, instituteType, eamcetCode, collegeName).then(
        (response) => {
          alert('registration is success' + JSON.stringify(response));
          // history.push("/app/dashboard/faculty");
          history.push('/login');
          window.location.reload();
        },
        (error) => {
          const resMessage = (error.response
              && error.response.data
              && error.response.data.message)
            || error.message
            || error.toString();
          alert('error message is : ' + resMessage);
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
            backgroundImage: 'url(https://source.unsplash.com/random)',
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
            <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Sign up
            </Typography>
            <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="username"
                    label="User Name"
                    name="username"
                    autoComplete="User Name"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="email"
                    label="Email Address"
                    name="email"
                    autoComplete="email"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    name="password"
                    label="Password"
                    type="password"
                    id="password"
                    autoComplete="new-password"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    name="eamcetCode"
                    label="Eamcet Code of the College"
                    id="eamcetCode"
                    autoComplete="eamcetCode"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    name="collegeName"
                    label="Name of the College"
                    id="collegeName"
                    autoComplete="collegeName"
                  />
                </Grid>
                <Grid item xs={12}>
                  {/* <InputLabel id="demo-simple-select-label">Role</InputLabel> */}
                  <Select
                    required
                    fullWidth
                    name="role"
                    labelId="Role"
                    id="role"
                    autoComplete="Role"
                    defaultValue='Role'
                  >
                    <MenuItem value=""><em>None</em></MenuItem>
                    <MenuItem value='admin'>Admin</MenuItem>
                    <MenuItem value='dean'>Dean</MenuItem>
                    <MenuItem value='faculty'>Faculty</MenuItem>
                    <MenuItem value='hod'>HOD</MenuItem>
                    <MenuItem value='principal'>Principal</MenuItem>
                    <MenuItem value='qualityadvisor'>Quality Advisor</MenuItem>
                    <MenuItem value='student'>Student</MenuItem>
                  </Select>
                </Grid>
                <Grid item xs={12}>
                  {/* <InputLabel id="demo-simple-select-label">Role</InputLabel> */}
                  <Select
                    required
                    fullWidth
                    name="instituteType"
                    label="instituteType"
                    id="instituteType"
                    autoComplete="instituteType"
                    defaultValue='instituteType'
                  >
                    <MenuItem value=""><em>None</em></MenuItem>
                    <MenuItem value='autonomous'>Autonomous</MenuItem>
                    <MenuItem value='affiliated'>Affiliated</MenuItem>
                    <MenuItem value='university'>University</MenuItem>
                  </Select>
                </Grid>
                <Grid item xs={12}>
                  <FormControlLabel
                    control={<Checkbox value="allowExtraEmails" color="primary" />}
                    label="I want to receive inspiration, marketing promotions and updates via email."
                  />
                </Grid>
                {message && (
                  <Grid item xs={12}>
                    <div> Error Message is : {message} </div>
                  </Grid>
                )}
              </Grid>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Sign Up
              </Button>
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <Link href="/login" variant="body2">
                    Already have an account? Sign in
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
