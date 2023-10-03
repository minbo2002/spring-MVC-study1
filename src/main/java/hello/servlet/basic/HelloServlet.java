package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")  // name : 서블릿이름    urlPatterns : URL 매핑
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.service(req, resp);
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");  // request.getParameter()  :  쿼리 파라미터를 가져옴  ex) localhost:8080/hello?username=kim
        System.out.println("username = " + username);

        response.setContentType("text/plain"); // 응답에 대한 Content-Type을 지정 (HTTP message header)
        response.setCharacterEncoding("utf-8"); // 응답에 대한 문자 인코딩을 지정 (HTTP message header)
        response.getWriter().write("hello " + username); // response.getWriter().write()  :  HTTP message body에 데이터가 들어간다.
    }
}
