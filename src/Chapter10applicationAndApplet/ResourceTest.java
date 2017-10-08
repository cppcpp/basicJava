package Chapter10applicationAndApplet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.jnlp.BasicService;
import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.jnlp.PersistenceService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.print.ServiceUIFactory;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/*
 * ���ɿ�ִ�е�jar�ļ�
 * ��ʾ��Դ����
 * 
 * 
 * ���ɿ�ִ��jar�ļ�������Ҫ����Դ�嵥*.mf��
 * ��Դ�ļ�������
 * Manifest_Version: 1.0
 * Main-Class: MainClassName(not add .class)
 * 
 * ���裺
 * 1.����Java�ļ���javac *.java
 * 2.����jar�ļ���jar cvfm jarFileName.jar File1 File2...
 * ������Դ���嵥��jar ufm jarFileName manifest-addition.mf
 * .jar����ѡ�Java���ļ���P427
 * */
public class ResourceTest  extends JFrame{
	private final static int DEFAULT_HERIGHT=500;
	private final static int DEFAULT_WIDTH=300;
	JScrollPane scrollPane=new JScrollPane();
	JTextArea textArea= new JTextArea();
	JTextArea editText=new JTextArea();

	public static void main(String[] args) {
		new ResourceTest();
		
	}


	
	//���Ĺ��캯��
	public ResourceTest(){
		this.setSize(DEFAULT_WIDTH, DEFAULT_HERIGHT);
		this.setLayout(new BorderLayout());
		scrollPane.add(textArea);
		
		//����fram��ͼ��
		//��Դ������
		//�õ�"person.jpg"����Դλ�ã�ͼ���������
		URL url=this.getClass().getResource("person.jpg");
		//��getImage()��ȡ��������getAudioClip()
		Image image=new ImageIcon(url).getImage();
		setIconImage(image);
		
		JMenuBar menuBar=new JMenuBar();
		JMenu FileMenu=new JMenu("File");
		JMenuItem OpenItem=FileMenu.add("Open");
		JMenuItem CloseItem=FileMenu.add("Close");
		JMenuItem SaveItem=FileMenu.add("Save");
		//��open��close��Ӽ�����
		OpenItem.addActionListener(EventHandler.create(ActionListener.class, this, "open"));
		SaveItem.addActionListener(EventHandler.create(ActionListener.class, this, "save"));
		
		menuBar.add(FileMenu);
		this.add(menuBar, BorderLayout.NORTH);
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setSize(DEFAULT_WIDTH, 200);
		
		
		textArea.setEditable(false);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setSize(DEFAULT_WIDTH, 50);
		InputStream txtStream=getClass().getResourceAsStream("readme.txt");
		Scanner in=new Scanner(txtStream);
		while(in.hasNext()){
			textArea.append(in.nextLine()+"\n");	
		}
		
		
		editText.setBackground(Color.PINK);
		editText.setSize(DEFAULT_WIDTH, 50);
		editText.setText("���������ԣ�");
		
		panel.add(textArea);
		panel.add(editText);
		this.add(panel,BorderLayout.CENTER);
		System.out.println(panel.getSize());
		
		JTextArea welcome=new JTextArea();
		welcome.setText("��ӭʹ�ñ�ϵͳ��");
		welcome.setEditable(false);
		welcome.setBackground(Color.blue);
		this.add(welcome,BorderLayout.SOUTH);
		
		this.setTitle("resourceTest");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	
	
	
	
	
	
	public void setTitle(){
		String title=null;
			//��Ҫjavaws.jar�ļ�
			try {
				//�������Ĭ����ʾ�ĵ�
				//ʹ��BasicService�ӿڷ��ʷ���
				BasicService basic=(BasicService) ServiceManager
						.lookup("javax.jnlp.BasicService");
				//�鿴jnlp�����ļ��е�codeBase·��
				URL codeBase= basic.getCodeBase();
				System.out.println("codeBase:"+codeBase);
				
				//PersistenceService����Ӧ�ó�����������������Ϣ���������´�����ʱ�ָ�������cookie��ʹ��URL�����г־��Դ洢��URL�����Դ洢����Ķ���������
				PersistenceService service=(PersistenceService) ServiceManager
						.lookup("javax.jnlp.PersistenceService");
				URL key=new URL(codeBase,"title");
				
				
				try{
					//������ĳ���ض�����������Ϣ:�޷�֪��������Ƿ���ڣ�ֻ��ͨ����FileNotFoundException���쳣
					FileContents contents=service.get(key);
					InputStream in=contents.getInputStream();
					BufferedReader reader=new BufferedReader(new InputStreamReader(in));
					title=reader.readLine();
				}catch (FileNotFoundException e) {
					title=JOptionPane.showInputDialog("please supply a frame title");
					if(title==null)
						return;
					
					//��֤�ӵڶ��ο�ʼ��ȡʱ����ͨ���־��Դ洢�õ�title��ֵ
					service.create(key, 100);
					FileContents contents=service.get(key);
					OutputStream out=contents.getOutputStream(true);
					PrintStream printOut=new PrintStream(out);
					printOut.print(title);
					
				}
			} catch (UnavailableServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	//���ļ�
	public void open(){
		try {
			//1.���ʷ���
			FileOpenService service=(FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
			//2.openFileDialog����Ӧ�ó����ṩ��    ��ʼ·����     ��    �ļ���չ��
			FileContents contents= service.openFileDialog(".", new String[]{"txt"});
			//3.����getInputStream��getOutputStream����д�ļ�
			if(contents!=null){
				InputStream input=contents.getInputStream();
				Scanner in=new Scanner(input);
				while(in.hasNext()){
					//����д���ı�����
					textArea.append(in.nextLine()+"\n");	
				}
			}
			
		} catch (UnavailableServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//�����ļ�
	public void save(){
		try {
			FileSaveService service=(FileSaveService) ServiceManager
					.lookup("javax.jnlp.FileSaveService");
			
			//��ȡ������е�string
			ByteArrayInputStream input=new ByteArrayInputStream(editText.getText().getBytes());
			//�����ļ��ĵ���
			service.saveFileDialog(".",new String[]{"txt"},input,"saveFile.txt");
			
		} catch (UnavailableServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}