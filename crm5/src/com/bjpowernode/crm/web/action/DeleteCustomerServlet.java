package com.bjpowernode.crm.web.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.crm.util.DBUtil;

public class DeleteCustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡɾ���Ŀͻ�id
		String id = request.getParameter("id");
		//�������ݿ�ɾ������
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "delete from t_customer where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			count = ps.executeUpdate();
			
			
			
			DBUtil.beginTransaction(conn);
			DBUtil.commitTransaction(conn);
			
		}catch (Exception e) {
			DBUtil.rollbackTransaction(conn);
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, null);
		}
		
		if(count == 1) {
			//ɾ���ɹ����ٴ���ת����ʾ�ͻ��б�ҳ��
			//�ض���/list
			response.sendRedirect(request.getContextPath() + "/list");
			
		}
		
		
		
		
	}

}























