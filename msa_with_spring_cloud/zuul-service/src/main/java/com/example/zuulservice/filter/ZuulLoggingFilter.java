package com.example.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

    @Override
    public Object run() throws ZuulException {
        log.info("*************** printing logs: ");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("*************** {}", request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() {    // 사전 필터를 의미
        return "pre";
    }

    @Override
    public int filterOrder() {  // 여러 개의 필터가 있을 경우 순서를 의미함
        return 1;
    }

    @Override
    public boolean shouldFilter() { // 핉터의 사용 유무
        return true;
    }

}
