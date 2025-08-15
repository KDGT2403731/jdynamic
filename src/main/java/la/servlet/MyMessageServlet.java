package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/MyMessageServlet")
public class MyMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String message = request.getParameter("message");
		String size = request.getParameter("size");
		
		if (message == null || message.isEmpty()) {
			out.println("<h3>メッセージを入力してください！</h3>");
			return;
		}
		String tag;
		switch (size) {
		case "large":
			tag = "h1";
			break;
		case "medium":
			tag = "h3";
			break;
		case "small":
			tag = "h4";
			break;
		default:
			tag = "p";
			break;
		}
		out.println("<html><body>");
		out.println("<" + tag + ">" + message + "</" + tag + ">");
		out.println("</body></html>");
	}

}
