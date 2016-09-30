package com.qq.server.db;

import java.sql.*;
public class SqlHelper {

	//������Ҫ�Ķ���
	
	String url="jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=QQ";
	String user="sa";
	String passwd="";
	public boolean SqlUpdate(String sql,String []paras)
	{
		PreparedStatement ps=null;
		Connection ct=null;
		boolean b=true;
		try {
			//1.��������
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//2.�õ�����
			ct=DriverManager.getConnection(url,user,passwd);
		
			ps=ct.prepareStatement(sql);
			//��ps���ʺŸ�ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			
			//ִ�в���
			ps.executeUpdate();
			
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				if(ps!=null)
					ps.close();
				if(ct!=null)
					ct.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return b;
	}
	
	
	public boolean SqlQuery(String sql,String []paras)
	{
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		boolean b=true;
		
		try {
			//1.��������
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//2.�õ�����
			ct=DriverManager.getConnection(url,user,passwd);
		
			ps=ct.prepareStatement(sql);
			//��ps���ʺŸ�ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			//ִ�в���
			rs=ps.executeQuery();
		
			while(rs.next())
			{
				String qnum=rs.getString(1);
				String password=rs.getString(3);;
				System.out.println("QQ����"+qnum+"����"+password);	
			}
			rs=ps.executeQuery();
			if(!rs.next())
			{
				b=false;
			}
		} catch (Exception e) {
			b=false;
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(ct!=null)
					ct.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return b;
	}
	
	public String[] FriendQuery(String sql,String []paras)
	{
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		int count=0;
		String friend[]=new String[50];
		try {
			//1.��������
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//2.�õ�����
			ct=DriverManager.getConnection(url,user,passwd);
		
			ps=ct.prepareStatement(sql);
			//��ps���ʺŸ�ֵ
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			//ִ�в���
			rs=ps.executeQuery();

			while(rs.next())
			{
        		friend[count++]=rs.getString(1);
				System.out.println("QQ����:"+friend[count]);	
			};
			
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(ct!=null)
					ct.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return friend;
	}
}