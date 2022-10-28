package com.huerta.springboot.app.zuul.springbootzuulserverzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostFilterTime extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PostFilterTime.class);

  @Override
  public Object run() throws ZuulException {
    final RequestContext ctx = RequestContext.getCurrentContext();
    final HttpServletRequest request = ctx.getRequest();
    log.info("Go inside post");
    final Long timeStart = (Long) request.getAttribute("timeStart");
    final Long timeEnd = System.currentTimeMillis();
    final Long finalTime = timeStart - timeEnd;
    log.info(
      String.format(
        "Final Time in seconds %s seg.",
        finalTime.doubleValue() / 1000.00
      )
    );
    log.info(String.format("Final Time in miliseconds %s mil.", finalTime));
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
    return "post";
  }
}
