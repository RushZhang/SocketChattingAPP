package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;

import java.awt.*;
import java.awt.event.*;
public class Register extends JFrame implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5;
	JTextField jtf1,jtf2,jtf5;
	JPasswordField jtf3,jtf4;
	JButton jb1,jb2;
	JPanel jp;
	
	public Register()
	{
		jl1=new JLabel("QQ Number",JLabel.CENTER);
		jl2=new JLabel("Nickname",JLabel.CENTER);
		jl3=new JLabel("Sex",JLabel.CENTER);
		jl4=new JLabel("Password",JLabel.CENTER);
		jl5=new JLabel("PW Verification",JLabel.CENTER);
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf5=new JTextField();
		jtf3=new JPasswordField();
		jtf4=new JPasswordField();
		
		jb1=new JButton("Enter");
		jb1.addActionListener(this);
		jb2=new JButton("Reset");
		jb2.addActionListener(this);
		jp=new JPanel(new GridLayout(6,2,4,4));
		
		jp.add(jl1);
		jp.add(jtf1);
		jp.add(jl2);
		jp.add(jtf2);
		jp.add(jl3);
		jp.add(jtf5);
		jp.add(jl4);
		jp.add(jtf3);
		jp.add(jl5);
		jp.add(jtf4);
		jp.add(jb1);
		jp.add(jb2);
		
		this.add(jp);
		this.setSize(325,220);
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setTitle("QQ User Sign up");
		this.setVisible(true);
		
	}
	public static void main(String[] args)
	{
		//Register Qqregister=new Register();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)//确定按钮
		{
			
			QqClientUser qqClientUser=new QqClientUser();
			User u=new User();
			u.setOperation("2");
			u.setQum(jtf1.getText());
			u.setPetname(jtf2.getText());
			u.setPassword(jtf3.getText());
			u.setSex(jtf5.getText());
			u.setOperation("3");
			if(qqClientUser.Sql(u))
			{
				JOptionPane.showMessageDialog(this, "Login Succeed","",JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "Login Failed","",JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource()==jb2){//重置按钮
			jtf1.setText("");
			jtf2.setText("");
			jtf3.setText("");
			jtf4.setText("");
			jtf5.setText("");
		}
		
	}
	
}
