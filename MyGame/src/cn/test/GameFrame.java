package cn.test;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {

	Image img = GameUtil.getImage("images/hello.jpg");
	
	public void launchFrame(){
		setSize(300, 300);
		setLocation(400, 200);
		setVisible(true);
		
		new PaintThead().start();//�����߳�
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private double x,y;
	private boolean left;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y, null);
		if(left){
			x -=2;
		}else{
			x +=2;
		}
		x +=2;
		y +=2;
	}

	/**
	 * ����һ���ظ����ڵ��߳��࣬�ڲ���
	 * @author Administrator
	 *
	 */
	class PaintThead extends Thread {
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();

	}

}
