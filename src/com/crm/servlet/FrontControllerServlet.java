package com.crm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.action.Action;
import com.crm.action.ActionFactory;

@WebServlet("/controller")//1
public class FrontControllerServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 모든 요청을 처리 /controller?cmd=addMemberUI
		/*try {
			System.out.println("5초 대기");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		if (cmd == null || cmd.trim().length() == 0)
			cmd = "mainUI";

		// 일을 할 Action을 찾아온다
				//5								//2
		Action action = ActionFactory.getAction(cmd);
		
		// response 객체를 request로 넘겨줌
		request.setAttribute("response", response);

		// 결과 페이지로 이동한다
				//8			//6
		String url = action.execute(request, response);		//9
		if (url != null) {
            request.getRequestDispatcher("/" + url).forward(request, response);
        }
	}

}
