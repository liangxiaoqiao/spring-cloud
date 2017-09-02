package com.lc.spring.cloud.zuul.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.juli.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liangchao03 on 2017/6/20.
 */
@Service
public class AccessFilter extends ZuulFilter {
    private static Log log = LogFactory.getLog(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {"+request.getMethod()+"} request to{"+request.getRequestURI().toString()+"}");
        String accessToken = request.getParameter("author");
        if(!"colter".equalsIgnoreCase(accessToken)){
            log.warn("access is wrong   .");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("Access should be colter, now is "+accessToken);
            return null;
        }
        return null;
    }
}
