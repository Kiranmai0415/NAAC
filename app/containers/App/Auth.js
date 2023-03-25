import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Outer from '../Templates/Outer';
import {
  Login,
  Register,
  ResetPassword,
  ComingSoon,
  Maintenance,
  NotFound,
  Logout,
  LandingPage,
} from '../pageListAsync';

function Auth() {
  return (
    <Outer>
      <Switch>
        <Route exact path='/erpLandingPage' component={LandingPage} />
        <Route path="/login" component={Login} />
        <Route path="/register" component={Register} />
        <Route path='/logout' component={Logout} />
        <Route path="/reset-password" component={ResetPassword} />
        <Route path="/maintenance" component={Maintenance} />
        <Route path="/coming-soon" component={ComingSoon} />
        <Route component={NotFound} />
      </Switch>
    </Outer>
  );
}

export default Auth;
