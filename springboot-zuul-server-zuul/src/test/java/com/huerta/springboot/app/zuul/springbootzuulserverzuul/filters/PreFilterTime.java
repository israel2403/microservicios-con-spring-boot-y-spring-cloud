package com.huerta.springboot.app.zuul.springbootzuulserverzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PreFilterTime extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PreFilterTime.class);

  @Override
  public Object run() throws ZuulException {
    final RequestContext ctx = RequestContext.getCurrentContext();
    final HttpServletRequest request = ctx.getRequest();
    log.info(
      "%s request routed to %s",
      request.getMethod(),
      request.getRequestURL().toString()
    );
    final Long timeStart = System.currentTimeMillis();
    request.setAttribute("timeStart", timeStart);
    return null;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public String filterType() {
    return "pre";
  }
}
