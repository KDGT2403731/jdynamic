package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String itemIdStr = request.getParameter("itemId");
		
		PrintWriter out = response.getWriter();
		
		if (itemIdStr != null && !itemIdStr.matches("\\d+")) {
			out.println("<h2>不正な商品IDです。</h2>");
			return;
		}
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<String> cart = (List<String>) session.getAttribute("shoppingCart");
		
		if (cart == null) {
			cart = new ArrayList<>();
		}
		
		String itemName = getItemName(itemIdStr);
		cart.add(itemName);
		
		session.setAttribute("shoppingCart", cart);
		out.println("<h2>現在のカート内容</h2>");
		for (int i = 0; i < cart.size(); i++) {
			out.println((i+1) + ": " + cart.get(i) + "<br>");
		}
		out.println("<a href=\"/jdynamic/shopItems.html\">商品一覧に戻る</a>");
	}
	
	private String getItemName(String itemId) {
		switch (itemId) {
		case "101":
			return "ノートパソコン";
		case "202":
			return "プリンター";
		case "303":
			return "スマートフォン";
		default:
			return "不明な商品";
		}
	}
}
