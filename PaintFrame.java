import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;

class PaintPanel extends JPanel implements MouseListener, MouseMotionListener{
	static Graphics2D gra2;
	int oldX, oldY;
	public static int r = 0;
	public static int g = 0;
	public static int b = 0;
	public static int thick = 5;
	
	public PaintPanel(){
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.RED);
	}

	public void mouseDragged(MouseEvent e) {
		Graphics gra = getGraphics();
		gra2 = (Graphics2D)gra;
		BasicStroke bs1 = new BasicStroke(thick, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		gra2.setStroke(bs1);
		gra2.setColor(new Color(r, g ,b));
		gra2.drawLine(oldX, oldY, e.getX(), e.getY());
		oldX = e.getX();
		oldY = e.getY();
	}
	public void mousePressed(MouseEvent e) {
		oldX = e.getX();
		oldY = e.getY();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}

public class PaintFrame extends JFrame implements ActionListener, AdjustmentListener{
	
	PaintPanel panel; //絵を描くパネル
	Image image;
	JButton buttonBLACK = new JButton(); //黒色ボタンを追加
	JButton buttonWHITE = new JButton(); //白色ボタンを追加
	JButton buttonGRAY = new JButton(); //灰色ボタンを追加
	JButton buttonRED = new JButton(); //赤色ボタンを追加
	JButton buttonGREEN = new JButton(); //緑色ボタンを追加
	JButton buttonBLUE = new JButton(); //青色ボタンを追加
	JButton buttonYELLOW = new JButton(); //黄色ボタンを追加
	JButton buttonCYAN = new JButton(); //水色ボタンを追加
	JButton buttonPINK = new JButton(); //ピンク色ボタンを追加
	JButton buttonPURPLE = new JButton(); //紫色ボタンを追加
	JButton buttonORANGE = new JButton(); //オレンジ色ボタンを追加
	JButton buttonBROWN = new JButton(); //茶色ボタンを追加
	JButton buttonALLCOLOR = new JButton("決定"); //色を自作できるボタンを追加
	JButton buttonSAVE = new JButton("保存"); //保存ボタンを追加
	JScrollBar scrollBarR = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260); //線の太さを設定するバーを追加
	JLabel valueLabelR = new JLabel("赤 : " + 0); //Rの値を表示するラベル 
	JScrollBar scrollBarG = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260); //線の太さを設定するバーを追加
	JLabel valueLabelG = new JLabel("緑 : " + 0); //Gの値を表示するラベル 
	JScrollBar scrollBarB = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260); //線の太さを設定するバーを追加
	JLabel valueLabelB = new JLabel("青 : " + 0); //Bの値を表示するラベル 
	JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 5, 5, 0, 55); //線の太さを設定するバーを追加
	JLabel valueLabel= new JLabel("5"); //線の太さを表示するラベル 
	JLabel iroLabel= new JLabel(" 線の色"); //ツールバーの説明ラベル1
	JLabel jisakuLabel= new JLabel("色自作"); //ツールバーの説明ラベル2 
	JLabel hutosaLabel= new JLabel("線の太さ"); //ツールバーの説明ラベル3
	JLabel hozonLabel= new JLabel("画像を保存する"); //ツールバーの説明ラベル4
	
	int r = 0; //色を自作する際に使用
	int g = 0;
	int b = 0;
	
	public static void main(String[] args) {
		new PaintFrame();
	}
	
	PaintFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		//ツールバーを作成
	    JToolBar toolBar = new JToolBar(JToolBar.VERTICAL);
	    toolBar.setFloatable(false);
	    //ツールバーに乗せるパネル（色を配置するパレット）を作成
	    JPanel panelColor = new JPanel();
	    panelColor.setPreferredSize(new Dimension(100, 100));
	    panelColor.setLayout(new GridLayout(6,2));
	    buttonBLACK.setBackground(Color.BLACK);
	    buttonWHITE.setBackground(Color.WHITE);
	    buttonGRAY.setBackground(Color.GRAY);
	    buttonRED.setBackground(Color.RED);
		buttonGREEN.setBackground(Color.GREEN);
		buttonBLUE.setBackground(Color.BLUE);
		buttonYELLOW.setBackground(Color.YELLOW);
		buttonCYAN.setBackground(Color.CYAN);
		buttonPINK.setBackground(Color.PINK);
		buttonPURPLE.setBackground(new Color(128, 0, 128));
		buttonORANGE.setBackground(Color.ORANGE);
		buttonBROWN.setBackground(new Color(165, 42, 42));
	    panelColor.add(buttonBLACK);
	    panelColor.add(buttonWHITE);
	    panelColor.add(buttonGRAY);
	    panelColor.add(buttonRED);
	    panelColor.add(buttonGREEN);
	    panelColor.add(buttonBLUE);
	    panelColor.add(buttonYELLOW);
	    panelColor.add(buttonCYAN);
	    panelColor.add(buttonPINK);
	    panelColor.add(buttonPURPLE);
	    panelColor.add(buttonORANGE);
	    panelColor.add(buttonBROWN);
	    //色を自作するボタン等の設定
	    buttonALLCOLOR.setForeground(new Color(255, 255, 255));
	    buttonALLCOLOR.setBackground(new Color(r, g, b));
	    //説明ラベルの設定
	    iroLabel.setOpaque(true);
	    iroLabel.setBackground(Color.WHITE);
	    jisakuLabel.setOpaque(true);
		jisakuLabel.setBackground(Color.WHITE);
		hutosaLabel.setOpaque(true);
		hutosaLabel.setBackground(Color.WHITE);
		hozonLabel.setOpaque(true);
		hozonLabel.setBackground(Color.WHITE);
	    //パレットとスクロールバーとラベルをツールバーに乗せ、ツールバーをコンテナに乗せる
	    toolBar.add(iroLabel);
	    toolBar.add(panelColor);
	    toolBar.addSeparator();
	    toolBar.add(jisakuLabel);
	    toolBar.add(buttonALLCOLOR);
	    toolBar.add(scrollBarR);
	    toolBar.add(valueLabelR);
	    toolBar.add(scrollBarG);
	    toolBar.add(valueLabelG);
	    toolBar.add(scrollBarB);
	    toolBar.add(valueLabelB);
	    toolBar.addSeparator();
	    toolBar.add(hutosaLabel);
	    toolBar.add(scrollBar);
	    toolBar.add(valueLabel);
	    toolBar.addSeparator();
	    toolBar.add(hozonLabel);
	    toolBar.add(buttonSAVE);
	    getContentPane().add(toolBar);
	    //絵を描くパネルを作成
		panel = new PaintPanel();
		panel.setPreferredSize(new Dimension(450, 450));
		getContentPane().add(panel);
		//イベント設定
	    buttonBLACK.addActionListener(this);
	    buttonWHITE.addActionListener(this);
	    buttonGRAY.addActionListener(this);
	    buttonRED.addActionListener(this);
	    buttonGREEN.addActionListener(this);
	    buttonBLUE.addActionListener(this);
	    buttonYELLOW.addActionListener(this);
	    buttonCYAN.addActionListener(this);
	    buttonPINK.addActionListener(this);
	    buttonPURPLE.addActionListener(this);
	    buttonORANGE.addActionListener(this);
	    buttonBROWN.addActionListener(this);
	    buttonALLCOLOR.addActionListener(this);
	    buttonSAVE.addActionListener(this);
	    scrollBar.addAdjustmentListener(this);
	    scrollBarR.addAdjustmentListener(this);
	    scrollBarG.addAdjustmentListener(this);
	    scrollBarB.addAdjustmentListener(this);
		setSize(700,550);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonBLACK) {
			PaintPanel.r = 0;
			PaintPanel.g = 0;
			PaintPanel.b = 0;
		}else if(e.getSource() == buttonWHITE) {
			PaintPanel.r = 255;
			PaintPanel.g = 255;
			PaintPanel.b = 255;
		}else if(e.getSource() == buttonGRAY) {
			PaintPanel.r = 128;
			PaintPanel.g = 128;
			PaintPanel.b = 128;
		}else if(e.getSource() == buttonRED) {
			PaintPanel.r = 255;
			PaintPanel.g = 0;
			PaintPanel.b = 0;
		}else if(e.getSource() == buttonGREEN) {
			PaintPanel.r = 0;
			PaintPanel.g = 255;
			PaintPanel.b = 0;
		}else if(e.getSource() == buttonBLUE) {
			PaintPanel.r = 0;
			PaintPanel.g = 0;
			PaintPanel.b = 255;
		}else if(e.getSource() == buttonYELLOW) {
			PaintPanel.r = 255;
			PaintPanel.g = 255;
			PaintPanel.b = 0;
		}else if(e.getSource() == buttonCYAN) {
			PaintPanel.r = 0;
			PaintPanel.g = 255;
			PaintPanel.b = 255;
		}else if(e.getSource() == buttonPINK) {
			PaintPanel.r = 255;
			PaintPanel.g = 192;
			PaintPanel.b = 203;
		}else if(e.getSource() == buttonPURPLE) {
			PaintPanel.r = 128;
			PaintPanel.g = 0;
			PaintPanel.b = 128;
		}else if(e.getSource() == buttonORANGE) {
			PaintPanel.r = 255;
			PaintPanel.g = 165;
			PaintPanel.b = 0;
		}else if(e.getSource() == buttonBROWN) {
			PaintPanel.r = 165;
			PaintPanel.g = 42;
			PaintPanel.b = 42;
		}else if(e.getSource() == buttonALLCOLOR) {
			PaintPanel.r = r;
			PaintPanel.g = g;
			PaintPanel.b = b;
		}else if(e.getSource() == buttonSAVE) {
			
	        int w = panel.getWidth(), h = panel.getHeight();
	        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB );
	        PaintPanel.gra2 =  (Graphics2D) image.getGraphics(); // kuro
			panel.paint( PaintPanel.gra2 );
//			PaintPanel.gra2.drawImage(image, 0, 0, null);
//			PaintPanel.gra2.drawImage(image, w, h, this);
//			PaintPanel.gra2.dispose();
	        
			JFileChooser filechooser = new JFileChooser();
		    int i = filechooser.showSaveDialog(this);
		    if (i == JFileChooser.APPROVE_OPTION){
		      File file = filechooser.getSelectedFile();
		      String filePath = file.getPath();
		        if (!filePath.toLowerCase().endsWith(".jpg")) // 拡張子の確認
		            file = new File(filePath + ".jpg"); // 付いてなければ付ける
		      try {
				ImageIO.write(image, "jpg", file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		      System.out.println(file.getName() + "を保存しました");
		    }else if (i == JFileChooser.CANCEL_OPTION){
		      System.out.println("キャンセルされました");
		    }else if (i == JFileChooser.ERROR_OPTION){
		      System.out.println("エラー又は取消しがありました");
		    }
		}
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getSource() == scrollBarR) {
			JScrollBar sb = (JScrollBar)e.getSource();
			valueLabelR.setText("赤 : " + sb.getValue());
			r = sb.getValue();
			buttonALLCOLOR.setBackground(new Color(r, g, b));
		}else if(e.getSource() == scrollBarG) {
			JScrollBar sb = (JScrollBar)e.getSource();
			valueLabelG.setText("緑 : " + sb.getValue());
			g = sb.getValue();
			buttonALLCOLOR.setBackground(new Color(r, g, b));
		}else if(e.getSource() == scrollBarB) {
			JScrollBar sb = (JScrollBar)e.getSource();
			valueLabelB.setText("青 : " + sb.getValue());
			b = sb.getValue();
			buttonALLCOLOR.setBackground(new Color(r, g, b));
		}else if(e.getSource() == scrollBar) {
			JScrollBar sb = (JScrollBar)e.getSource();
			valueLabel.setText("" + sb.getValue());
			PaintPanel.thick = sb.getValue();
		}
	}
	
}