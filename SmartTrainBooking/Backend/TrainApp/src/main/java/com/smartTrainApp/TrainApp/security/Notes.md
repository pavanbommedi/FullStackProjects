Security Roadmap for Your TrainApp

We will implement security in 8 phases.

Phase 1

Security fundamentals & dependency setup

Phase 2

User authentication with JWT

Phase 3

JWT generation and validation

Phase 4

Custom authentication filter

Phase 5

Role-based authorization (RBAC)

Phase 6

Secure APIs with method security

Phase 7

Refresh tokens (production-grade)

Phase 8

OAuth2 + OpenID Connect login


------------------------------------
AuthorizationFilter
       ↓
Check SecurityContext
       ↓
Is user authenticated?
       ↓
Yes → Continue
No → 401 Unauthorized

---------------------------------

Client Request
      ↓
SecurityFilterChain
      ↓
BasicAuthenticationFilter
      ↓
Extract username/password
      ↓
AuthenticationManager
      ↓
DaoAuthenticationProvider
      ↓
UserDetailsService
      ↓
InMemoryUserDetailsManager
      ↓
Find user
      ↓
Password match
      ↓
Authentication success
      ↓
SecurityContextHolder
      ↓
AuthorizationFilter
      ↓
Controller

----------------------------------------
Client sends username/password
        ↓
Spring Security
        ↓
CustomUserDetailsService.loadUserByUsername()
        ↓
UserRepository.findByEmail()
        ↓
Fetch User entity from DB
        ↓
Convert to Spring Security User
        ↓
AuthenticationManager validates password