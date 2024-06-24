package jp.ac.it_college.std.s23018.messageboard.presentaion.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

object SecurityHandler :
    AuthenticationSuccessHandler,
    AuthenticationFailureHandler,
    AuthenticationEntryPoint,
    AccessDeniedHandler {

        // 7.1.14 BookManagerAuthernticationSuccessHandlerだったもの
        override fun onAuthenticationSuccess(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            authentication: Authentication?
        ) {
            response?.status = HttpServletResponse.SC_OK
        }

        // 7.1.15  BookManagerAuthenticationFailureHandlerだったもの
        override fun onAuthenticationFailure(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            exception: AuthenticationException?
        ) {
            response?.status = HttpServletResponse.SC_UNAUTHORIZED
        }

        //7.1.16 BookManagerAuthenticationEntryPointだったもの
        override fun commence(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            authException: AuthenticationException?
        ) {
            response?.status = HttpServletResponse.SC_UNAUTHORIZED
        }

        //7.1.17 BookManagerAccessDeniedHandlerだったもの
        override fun handle(
            request: HttpServletRequest?,
            response: HttpServletResponse?,
            accessDeniedException: AccessDeniedException?
        ) {
            response?.status = HttpServletResponse.SC_FORBIDDEN
        }
    }

