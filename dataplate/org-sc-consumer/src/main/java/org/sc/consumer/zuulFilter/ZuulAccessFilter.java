package org.sc.consumer.zuulFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class ZuulAccessFilter extends ZuulFilter {


    /***
     * 返回一个字符串代表过滤器的类型
     * pre：表示被路由之前
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /***
     * 过滤顺序
     * @return
     */
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
        String token = String.valueOf(request.getHeader("token"));
        if(!token.equals("zz")){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
