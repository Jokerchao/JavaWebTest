import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kraos
 * User: 9807315
 * Date: 2018/12/
 * Time: 16:29
 */

@WebServlet("/Test")
public class Test extends HttpServlet {
    private int i;

    @Override
    public void init() throws ServletException {
        i = 100;
        System.out.println("servlet初始化！");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //获取writer实例
        PrintWriter writer = resp.getWriter();
        writer.print(i);
    }

    @Override
    public void destroy() {
        i = 100;
        System.out.println("servlet销毁！");
    }
}
