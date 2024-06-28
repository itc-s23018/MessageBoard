package jp.ac.it_college.std.s23018.messageboard.presentaion.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.naming.AuthenticationException

object SecurityHandler :
    AuthenticationSuccessHandler,
    AuthenticationFailureHandler,
    AuthenticationEntryPoint,
    AccessDeniedHandler {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: org.springframework.security.core.Authentication?
    ) {
        response?.status = HttpServletResponse.SC_OK
    }

    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: org.springframework.security.core.AuthenticationException?
    ) {
        response?.status = HttpServletResponse.SC_UNAUTHORIZED
    }

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: org.springframework.security.core.AuthenticationException?
    ) {
        response?.status = HttpServletResponse.SC_UNAUTHORIZED
    }

    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        accessDeniedException: org.springframework.security.access.AccessDeniedException?
    ) {
        response?.status = HttpServletResponse.SC_FORBIDDEN
    }


}