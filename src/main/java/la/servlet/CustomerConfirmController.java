package la.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import la.bean.CustomerBean;

public class CustomerConfirmController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		CustomerBean customer = null;
		
		if (session != null) {
			customer = (CustomerBean) session.getAttribute("customerData");
		}
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<html><body>");
		if (customer == null) {
			response.getWriter().println("<p>登録情報がありません。</p>");
		} else {
			response.getWriter().println("<h2>登録情報</h2>");
			response.getWriter().println("<p>名前: " + customer.getName() + "</p>");
			response.getWriter().println("<p>住所: " + customer.getAddress() + "</p>");
			response.getWriter().println("<p>電話番号: " + customer.getTel() + "</p>");
		}
		response.getWriter().println("<a href='customerForm.html'>戻る</a>");
		response.getWriter().println("</body></html>");
	}

}
