package cn.srn.web2.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends AbstractLoginInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("LoginInterceptor : " + request.getRequestURL().toString());
		HttpSession session = request.getSession(true);
//		Object obj = session.getAttribute(Const.SESSION_ADMIN);
//		if(obj == null || !(obj instanceof Admin)){
//			//System.out.println("LoginInterceptor : " + request.getRequestURL().toString() + ": Redirect to admin/login");
//			if (isAjaxRequest(request)) {
//				ajaxRequestReturn(response, "noLogin");
//			} else {
//				request.getRequestDispatcher("/admin/login").forward(request, response);
//			}
//			return false;
//		}
		return true;
	}

}