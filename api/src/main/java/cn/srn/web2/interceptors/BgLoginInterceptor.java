package cn.srn.web2.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BgLoginInterceptor extends AbstractLoginInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(true);
//		Object obj = session.getAttribute(Const.SESSION_ADMIN);
//		if(obj == null || !(obj instanceof Admin)){
//			if (isAjaxRequest(request)) {
//				ajaxRequestReturn(response, "bgNoLogin");
//			} else {
//				request.getRequestDispatcher("/admin/bglogin").forward(request, response);
//			}
//			return false;
//		}
		return true;
	}

}