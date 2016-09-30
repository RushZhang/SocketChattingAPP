/*
 * �ҵĺ����б�������İ���ˡ���������
 */
package com.qq.client.view;

import com.qq.client.model.QqClientUser;
import com.qq.client.tools.*;
import com.qq.common.Message;
import com.qq.common.User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class QqFriendList extends JFrame implements ActionListener,MouseListener{
	String []friend=new String[50];//�����鱣����ѵ�ID
	int count;//������ѵ���Ŀ
	
	//������һ�ſ�Ƭ���ҵĺ��ѣ�
	JLabel jphy_jl;
	JPanel jphy1,jphy2,jphy3,jphy4,jphy5;
	JButton jphy_jb1,jphy_jb2,jphy_jb3,jphy_jb4,jphy_jb5,jphy_jb6;
	JScrollPane jspl;
	String owner;
	
	//�����ڶ��ſ�Ƭ��İ���ˣ�
	JLabel jpmsr_jl;
	JPanel jpmsr1,jpmsr2,jpmsr3,jpmsr4,jpmsr5;
	JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3,jpmsr_jb4,jpmsr_jb5,jpmsr_jb6;
	JScrollPane jspl2;
	JLabel []jbls;
	
	//���������ſ�Ƭ����������
	JLabel jphmd_jl;
	JPanel jphmd1,jphmd2,jphmd3,jphmd4;
	JButton jphmd_jb1,jphmd_jb2,jphmd_jb3,jphmd_jb4,jphmd_jb5,jphmd_jb6;
	JScrollPane jspl3;
	
	//������JFrame���ó�CardLayout
	CardLayout cl;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//QqFriendList qqFriendList=new QqFriendList("10000");
	}
	
	//��ѯ�û��ĺ��ѣ�Ȼ����ʾ����
	public void showMyFriend(String ownerId)
	{
		QqClientUser qqClientUser=new QqClientUser();
		User u=new User();
		u.setOperation("5");
		u.setQum(ownerId);
		friend=qqClientUser.Sql2(u);
		for(int i=0;i<50;i++)
		{
			//System.out.println(friend[i]);
		}	
		for(int i=0;friend[i]!=null;i++)
			count++;
		//System.out.println("���ѵ���ĿΪ��"+count);
	}
	
	//�������ߵĺ��ѵ����
	/*public void updateFriend(Message m)
	{
		String onLineFriend[]=m.getConn().split(" ");
		int i=0,j=0;
		for(i=0;i<count;i++)
		{  
			for(j=0;j<onLineFriend.length;j++)
			{
				if(friend[i].equals(onLineFriend[j]))
				{
					jbls[i].setEnabled(true);
					System.out.println("i="+i);
					break;
				}
			}
		}
	}*/
	
	public void updateFriend(Message m)
	{
		String onLineFriend[]=m.getConn().split(" ");
		for(int i=0;i<onLineFriend.length;i++)
		{
			System.out.println(onLineFriend[i]);
			jbls[Integer.parseInt(onLineFriend[i])-10000].setEnabled(true);
		}
	}

	
	public QqFriendList(String ownerId)
	{
		this.owner=ownerId;
		
		showMyFriend(owner);
		//������һ�ſ�Ƭ����ʾ�����б���
		jphy_jl=new JLabel(ownerId+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
		jphy_jb1=new JButton("Friends");
		jphy_jb2=new JButton("Strangers");
		jphy_jb2.addActionListener(this);
		jphy_jb3=new JButton("Blacklist");
		jphy_jb3.addActionListener(this);
		jphy_jb4=new JButton("Add Friends");
		jphy_jb4.addActionListener(this);
		jphy_jb5=new JButton("Delete Friends");
		jphy_jb5.addActionListener(this);
		jphy_jb6=new JButton("Logout");
		jphy_jb6.addActionListener(this);
		
		jphy1=new JPanel(new BorderLayout());
		//�޶�ֻ����50������
		jphy2=new JPanel(new GridLayout(50,1,4,4));
		//��jphy2����ʼ��50������
		jbls =new JLabel[50];
		
		
		/*for(int i=0;i<count;i++)
		{
			jbls[i]=new JLabel(friend[i]+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
			jbls[i].setEnabled(false);
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);	
		}*/
		
		for(int i=0;i<jbls.length;i++)
		{
			jbls[i]=new JLabel(i+10000+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
			jbls[i].setEnabled(false);
			if(jbls[i].getText().equals(ownerId))
			{
				jbls[i].setEnabled(true);
			}
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);	
		}
		
	
		
		jphy3=new JPanel(new GridLayout(3,1));
		//��������ť���뵽jphy3��
		
		
		jphy4=new JPanel(new GridLayout(2,1));
		jphy4.add(jphy_jl);
		jphy4.add(jphy_jb1);
		
		jphy5=new JPanel();
		jphy5.add(jphy_jb4);
		jphy5.add(jphy_jb5);
		jphy5.add(jphy_jb6);
		
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);
		jphy3.add(jphy5);
		
		jspl=new JScrollPane(jphy2);
		
		//��jphy1��ʼ��
		jphy1.add(jphy4,"North");
		jphy1.add(jspl,"Center");
		jphy1.add(jphy3,"South");
		
		
		
		//�����ڶ��ſ�Ƭ(��ʾİ����)
		jpmsr_jl=new JLabel(ownerId+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
		jpmsr_jb1=new JButton("Friends");
		jpmsr_jb1.addActionListener(this);
		jpmsr_jb2=new JButton("Strangers");
		jpmsr_jb3=new JButton("Blacklist");
		jpmsr_jb3.addActionListener(this);
		jpmsr_jb4=new JButton("Add Friends");
		jpmsr_jb4.addActionListener(this);
		jpmsr_jb5=new JButton("Delete Friends");
		jpmsr_jb5.addActionListener(this);
		jpmsr_jb6=new JButton("Logout");
		jpmsr_jb6.addActionListener(this);
		
		
		jpmsr1=new JPanel(new BorderLayout());
		//�ٶ���20��İ����
		jpmsr2=new JPanel(new GridLayout(20,1,4,4));
		
		//��jpmsr2����ʼ��20��İ����
		JLabel []jbls2=new JLabel[20];
		for(int i=0;i<jbls2.length;i++)
		{
			jbls2[i]=new JLabel(i+10000+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
			jbls2[i].setEnabled(false);
			jpmsr2.add(jbls2[i]);	
		}
		
	
		jpmsr3=new JPanel(new GridLayout(3,1));
		//��������ť���뵽jphy3��
		jpmsr3.add(jpmsr_jl);
		jpmsr3.add(jpmsr_jb1);
		jpmsr3.add(jpmsr_jb2);
		
		jpmsr5=new JPanel();
		jpmsr5.add(jpmsr_jb4);
		jpmsr5.add(jpmsr_jb5);
		jpmsr5.add(jpmsr_jb6);
		
		jpmsr4=new JPanel(new GridLayout(2,1));
		jpmsr4.add(jpmsr_jb3);
		jpmsr4.add(jpmsr5);
		jspl2=new JScrollPane(jpmsr2);
		
		//��jpmsr1��ʼ��
		jpmsr1.add(jpmsr3,"North");
		jpmsr1.add(jspl2,"Center");
		jpmsr1.add(jpmsr4,"South");
		
		
		//���������ſ�Ƭ����ʾ��������
		jphmd_jl=new JLabel(ownerId+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
		jphmd_jb1=new JButton("Friends");
		jphmd_jb1.addActionListener(this);
		jphmd_jb2=new JButton("Strangers");
		jphmd_jb2.addActionListener(this);
		jphmd_jb3=new JButton("Blacklist");
		jphmd_jb4=new JButton("Add Friends");
		jphmd_jb4.addActionListener(this);
		jphmd_jb5=new JButton("Delete Friends");
		jphmd_jb5.addActionListener(this);
		jphmd_jb6=new JButton("Logout");
		jphmd_jb6.addActionListener(this);
		
		jphmd1=new JPanel(new BorderLayout());
		//�ٶ���10������
		jphmd2=new JPanel(new GridLayout(10,1,4,4));
		
		//��jphmd2����ʼ��10������
		JLabel []jbls3=new JLabel[10];
		for(int i=0;i<jbls3.length;i++)
		{
			jbls3[i]=new JLabel(i+10000+"",new ImageIcon("image/ͷ��.GIF"),JLabel.LEFT);
			jbls3[i].setEnabled(false);
			jphmd2.add(jbls3[i]);	
		}
		
	
		jphmd3=new JPanel(new GridLayout(4,1));
		jphmd4=new JPanel();
		//��������ť���뵽jphy3��
		jphmd3.add(jphmd_jl);
		jphmd3.add(jphmd_jb1);
		jphmd3.add(jphmd_jb2);
		jphmd3.add(jphmd_jb3);
		jphmd4.add(jphmd_jb4);
		jphmd4.add(jphmd_jb5);
		jphmd4.add(jphmd_jb6);
		jspl3=new JScrollPane(jphmd2);
		
		//��jphmd1��ʼ��
		jphmd1.add(jphmd3,"North");
		jphmd1.add(jspl3,"Center");
		jphmd1.add(jphmd4,"South");
		
	
		cl=new CardLayout();
		this.setLayout(cl);
		this.add(jphy1,"1");
		this.add(jpmsr1,"2");
		this.add(jphmd1,"3");
		
		//�ڴ�����ʾ�Լ��ı��
		this.setSize(300,550);
		this.setLocation(900,80);
		this.setTitle("Ruixuan QQ-      "+ownerId);
		Image img = Toolkit.getDefaultToolkit().getImage("image/ͷ��.GIF");
		setIconImage(img);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jphy_jb2 || e.getSource()==jphmd_jb2)//��������İ���˵İ�ť������ʾ�ڶ��ſ�Ƭ
		{
			cl.show(this.getContentPane(),"2");
		}
		else if(e.getSource()==jpmsr_jb1 || e.getSource()==jphmd_jb1)//���������ҵĺ��ѵİ�ť������ʾ��һ�ſ�Ƭ
		{
			cl.show(this.getContentPane(),"1");
		}
		else if(e.getSource()==jphy_jb3 || e.getSource()==jpmsr_jb3)//�������˺������İ�ť������ʾ�����ſ�Ƭ
		{
			cl.show(this.getContentPane(),"3");
		}else if(e.getSource()==jphy_jb4||e.getSource()==jpmsr_jb4||e.getSource()==jphmd_jb4)
		{
			//���Ӻ���
			String friendId = JOptionPane.showInputDialog("Please input your friend's QQ number��");
			QqClientUser qqClientUser=new QqClientUser();
			User u=new User();
			u.setOperation("2");
			u.setQum(owner);
			u.setFriendId(friendId);
			if(qqClientUser.Sql(u))
			{
				JOptionPane.showMessageDialog(this, "Adding succeed","QQ",JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "Adding failed","QQ",JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(e.getSource()==jphy_jb5||e.getSource()==jpmsr_jb5||e.getSource()==jphmd_jb5)
		{
			//ɾ������
			String friendId = JOptionPane.showInputDialog("Please input your friend's QQ number��");
			QqClientUser qqClientUser=new QqClientUser();
			User u=new User();
			u.setOperation("2");
			u.setQum(owner);
			u.setFriendId(friendId);
			u.setOperation("4");
			if(qqClientUser.Sql(u))
			{
				JOptionPane.showMessageDialog(this, "Deleting scuueed","QQ",JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this, "Deleting failed","QQ",JOptionPane.WARNING_MESSAGE);
			}
			
			
		}else if(e.getSource()==jphy_jb6||e.getSource()==jpmsr_jb6||e.getSource()==jphmd_jb6)
		{
			//�˳�
			//�Ͽ��������������
			System.exit(0);
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//��Ӧ�û�˫�����¼������õ����ѵı��
		if(e.getClickCount()==2)//˫��
		{
			//�õ����ѱ��
			String friendNo=((JLabel)e.getSource()).getText();
System.out.println(friendNo);
			QqChat qqChat=new QqChat(this.owner,friendNo);
			//�������������������
			ManageQqChat.addQqChat(this.owner+" "+friendNo, qqChat);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.red);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}