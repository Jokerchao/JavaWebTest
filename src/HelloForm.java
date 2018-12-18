/**
 * Created by Kraos
 * User: 98073
 * Date: 2018/12/18
 * Time: 14:39
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
    private static final long serialVersionID = 1L;

    public HelloForm() {
        super();
        // TODO: 2018/12/18   Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    //重载处理表单
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这里不改解析中文会乱码
        resp.setContentType("text/html");
        //请求解决乱码
        resp.setContentType("text/html;charset=utf-8");

        //响应解决乱码
        req.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        String title = "使用 GET 方法读取表单数据";
        String name = req.getParameter("name");
        print(req, writer, title, name);

    }

    private void print(HttpServletRequest req, PrintWriter writer, String title, String name) {
        String docType = "<!DOCTYPE html> \n";
        writer.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址</b>："
                + req.getParameter("url") + "\n" +
                "</ul>\n" +
                "</body></html>");
    }

    //处理post请求
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String title = "使用 POST 方法读取表单数据";
        // 处理中文
        String name = new String(req.getParameter("name").getBytes("ISO8859-1"), StandardCharsets.UTF_8);
        print(req, out, title, name);
    }
}
