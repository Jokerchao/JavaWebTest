import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Kraos
 * User: 98073
 * Date: 2018/12/26
 * Time: 16:22
 */

//实现 Filter 类
public class LogFilter implements Filter {

    //初始化Filter
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        String site = filterConfig.getInitParameter("Site");

        //输出初始化参数
        System.out.println("网站名称："+site);
    }

    //该方法完成实际的过滤操作
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 输出站点名称
        System.out.println("站点网址：http://www.baidu.com");

        // 把请求传回过滤链
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //释放Servlet过滤器占用的资源
    @Override
    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
