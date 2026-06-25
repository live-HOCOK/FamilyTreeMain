package com.kitokot.familytree.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class RequestIdFilter extends OncePerRequestFilter {

  public static final String REQUEST_ID = "requestId";

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
                                  @NonNull HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    MDC.put(REQUEST_ID, UUID.randomUUID().toString());
    try {
      filterChain.doFilter(request, response);
    } finally {
      MDC.remove(REQUEST_ID);
    }
  }
}
