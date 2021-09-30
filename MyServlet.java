package kr.co.greenart;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	@Override			//	request					response
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 요청을 처리하는 중");
		LocalDateTime now = LocalDateTime.now();
		//	request객체에 now를 "now"란 이름에 저장해서 보냄 
		req.setAttribute("now", now);
		//	같은 request, response를 가지고 myjsp페이지로 이동(forward로)
		req.getRequestDispatcher("/WEB-INF/myjsp.jsp").forward(req, resp);
		// web.xml에 지정한대로 /first 경로를 통해서만 페이지를 찾을 수 있게 됨
//		PrintWriter out  = resp.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Servlet service</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>hello Servlet</h1>");
//		out.println("</body>");
//		out.println("</html>");
		//-> jsp에서 보여주는 gui역할을 해줌 
	}

}
