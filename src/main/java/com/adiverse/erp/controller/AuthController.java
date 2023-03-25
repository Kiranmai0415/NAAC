package com.adiverse.erp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.model.ERole;
import com.adiverse.erp.model.Role;
import com.adiverse.erp.model.User;
import com.adiverse.erp.payload.request.LoginRequest;
import com.adiverse.erp.payload.request.SignupRequest;
import com.adiverse.erp.payload.response.JwtResponse;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.repository.RoleRepository;
import com.adiverse.erp.repository.UserRepository;
import com.adiverse.erp.security.jwt.JwtUtils;
import com.adiverse.erp.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles,userDetails.getInstituteType(),userDetails.getCollegeId()));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	  System.out.println("role == >"+signUpRequest.getRole());
	  System.out.println("instute type == >"+signUpRequest.getInstituteType());
	  if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()),signUpRequest.getInstituteType(),signUpRequest.getEamcetCode(), signUpRequest.getCollegeName());

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "student":
            Role studentRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(studentRole);

            break;
        case "faculty":
            Role facultyRole = roleRepository.findByName(ERole.ROLE_FACULTY)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(facultyRole);

            break;
        case "hod":
            Role hodRole = roleRepository.findByName(ERole.ROLE_HOD)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(hodRole);

            break;
        case "principal":
            Role principalRole = roleRepository.findByName(ERole.ROLE_PRINCIPAL)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(principalRole);

            break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        case "qualityadvisor":
            Role qualityadvisorRole = roleRepository.findByName(ERole.ROLE_QUALITYADVISOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(qualityadvisorRole);

            break;
        case "dean":
            Role deanRole = roleRepository.findByName(ERole.ROLE_DEAN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(deanRole);

            break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
  
  /*@PostMapping("/refresh")
  public ResponseEntity<?> refreshJwtToken(@Valid @RequestBody TokenRefreshRequest tokenRefreshRequest) {
      	
    String requestRefreshToken = tokenRefreshRequest.getRefreshToken();
      	
    Optional<String> token = Optional.of(refreshTokenService.findByToken(requestRefreshToken)
        .map(refreshToken -> {
            refreshTokenService.verifyExpiration(refreshToken);
            userDeviceService.verifyRefreshAvailability(refreshToken);
            refreshTokenService.increaseCount(refreshToken);
            return refreshToken;
        })
        .map(RefreshToken::getUserDevice)
        .map(UserDevice::getUser)
        .map(u -> jwtProvider.generateTokenFromUser(u))
        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Missing refresh token in database. Please login again")));
    return ResponseEntity.ok().body(new JwtResponse(token.get(), tokenRefreshRequest.getRefreshToken(), jwtProvider.getExpiryDuration()));
  }*/
}
