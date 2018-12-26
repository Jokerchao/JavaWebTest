import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kraos
 * User: 98073
 * Date: 2018/12/26
 * Time: 16:22
 */

//实现 Filter 类
public class AuthenFilter implements Filter {

    //初始化Filter
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    //该方法完成实际的过滤操作
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取请求信息(测试时可以通过get方式在URL中添加name)
        //http://localhost:8080/servlet_demo/helloword?name=123
        String name = servletRequest.getParameter("name");

        // 过滤器核心代码逻辑
        System.out.println("过滤器获取请求参数:" + name);
        System.out.println("第二个过滤器执行--网站名称：www.runoob.com");

        if ("123".equals(name)) {
            // 把请求传回过滤链
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //设置返回内容类型
            servletResponse.setContentType("text/html;charset=GBK");

            //在页面输出响应信息
            PrintWriter out = servletResponse.getWriter();
            out.print("<b>name不正确，请求被拦截，不能访问web资源</b>");
            System.out.println("name不正确，请求被拦截，不能访问web资源");
        }
    }

    //释放Servlet过滤器占用的资源
    @Override
    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
