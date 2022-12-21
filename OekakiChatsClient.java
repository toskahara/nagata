import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//【ｐ2】JPanelクラスを継承したCanbusクラスを作成し、MouseListener～インターフェースを実装
class Canvas extends JPanel implements MouseListener,MouseMotionListener{
	
	//コンストラクタ
	public Canvas(){
		addMouseListener(this); //メソッドを使って自分自身をリスナ登録
		addMouseMotionListener(this); //メソッドを使って自分自身をリスナ登録
		setBackground(Color.WHITE); //背景を白に設定
	}

	//MouseClickedメソッドで描画用のGraphicsオブジェクトを取得する
	public void mouseClicked(MouseEvent e) {
		Graphics g=getGraphics(); 
		g.setColor(Color.BLACK);	//描画色を黒に設定（今は黒にしてるけど、多分配列で色を設定するか？）
		g.fillRect(e.getX(),e.getY(),1,1);	//直径1の四角を描画（今は1にしているが、配列で設定するか？）
}

	//MouseDraggedメソッドで描画用のGraphicsオブジェクトを取得する
	public void mouseDragged(MouseEvent e) {
		Graphics g=getGraphics(); 
		g.setColor(Color.BLACK);	//描画色を黒に設定（今は黒にしてるけど、多分配列で色を設定するか？）
		g.fillRect(e.getX(),e.getY(),1,1);	//直径1の四角を描画（今は1にしているが、配列で設定するか？）
	}
	
	//MouseListenerインタフェース実装の為のメソッド残り5つ空実装
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	
}


class Menu extends JFrame{
	
	JPanel panel1=new JPanel();		//メニュー
	JPanel panel2=new JPanel();		//キャンバス
	JPanel panel3=new JPanel();		//チャット
	
	//p1パネル
	JPanel panel1_1=new JPanel();	//プリセットカラー
	JPanel panel1_2=new JPanel();	//ペンの大きさ選択
	JPanel panel1_3=new JPanel();	//ツール

	//カラーボタン
	JButton black=new JButton(" ") ;
	JButton white=new JButton(" ") ;
	JButton brown=new JButton(" ") ;
	JButton gray=new JButton(" ") ;
	JButton red=new JButton(" ") ;
	JButton blue=new JButton(" ") ;
	JButton green=new JButton(" ") ;
	JButton yellow=new JButton(" ") ;
	
	//ペンボタン
	JButton pen1=new JButton("●");
	JButton pen2=new JButton("●");
	JButton pen3=new JButton("●");
	JButton pen4=new JButton("●");
	JButton pen5=new JButton("●");
	JButton pen6=new JButton("●");
	
	//ボタンメニュー
	JButton keshi=new JButton("消しゴム");
	JButton torikomi=new JButton("取　　込");
	JButton hozon=new JButton("保　　存");
	JButton zenkeshi=new JButton("全  消  し");
	JButton kaku=new JButton("拡　　大");
	JButton shuku=new JButton("縮　　小");
	JButton out=new JButton("退　　出");
	

	
	Menu(){
		setTitle("お絵描き");
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	JPanel mp=new JPanel();
	//	mp.setLayout(new GridLayout(1,2));
		//フレームにメニューパネル、キャンバス、チャットを追加
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1));
	//	getContentPane().add(panel1);
		
//		mp.add(panel1);//左側にメニュー
//		mp.add(new Canvas());	//右上にキャンバス
//		getContentPane().add(new Chat());//右下にチャット
//		getContentPane().add(mp);
		
		setSize(600,800);//あとでかえる
		setVisible(true);
	
		
	//	panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
		panel1.setLayout(new GridLayout(2,2));
		
		
		//p1_1プリセットカラー
		//ボタンをp1_1に作成して、コンテナに追加
		panel1_1.setLayout(new GridLayout(4,2));
		panel1_1.add(black);	//黒
		black.setBackground(Color.BLACK);
		panel1_1.add(white);	//白
		white.setBackground(Color.WHITE);
		panel1_1.add(brown);	//茶色
		brown.setBackground(Color.ORANGE);
		panel1_1.add(gray);		//グレー
		gray.setBackground(Color.GRAY);
		panel1_1.add(red);		//赤
		red.setBackground(Color.RED);
		panel1_1.add(blue);		//青
		blue.setBackground(Color.BLUE);
		panel1_1.add(green);	//緑
		green.setBackground(Color.GREEN);
		panel1_1.add(yellow);	//黄色
		yellow.setBackground(Color.YELLOW);
		
	//	panel1.add(panel1_1);
		getContentPane().add(panel1_1);
			
		//ペン大きさ
		panel1_2.setLayout(new GridLayout(3,2));
		panel1_2.add(pen1);		//1px
		pen1.setFont(new Font("Arial",Font.PLAIN,5));
		panel1_2.add(pen2);		//5px
		pen2.setFont(new Font("Arial",Font.PLAIN,10));
		panel1_2.add(pen3);		//10px
		pen3.setFont(new Font("Arial",Font.PLAIN,15));
		panel1_2.add(pen4);		//20px
		pen4.setFont(new Font("Arial",Font.PLAIN,20));
		panel1_2.add(pen5);		//50px
		pen5.setFont(new Font("Arial",Font.PLAIN,30));
		panel1_2.add(pen6);		//100px
		pen6.setFont(new Font("Arial",Font.PLAIN,50));
		
	//	panel1.add(panel1_2);
		getContentPane().add(panel1_2);
	
		//ツール
		panel1_3.setLayout(new BoxLayout(panel1_3,BoxLayout.Y_AXIS));
		panel1_3.add(keshi);
		panel1_3.add(torikomi);
		panel1_3.add(hozon);
		panel1_3.add(zenkeshi);	
		panel1_3.add(kaku);		//これは横に2つに分けたい
		panel1_3.add(shuku);	//同上
		panel1_3.add(out);
		
	//	panel1.add(panel1_3);
		getContentPane().add(panel1_3);
		
	//	mp.add(panel1);//左側にメニュー
	
	}
	
}




public class OekakiChatsClient {
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new Menu();
	}
	

}
