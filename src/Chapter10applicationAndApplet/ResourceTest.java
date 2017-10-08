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
 * 生成可执行的jar文件
 * 演示资源加载
 * 
 * 
 * 生成可执行jar文件（必须要有资源清单*.mf）
 * 资源文件基本：
 * Manifest_Version: 1.0
 * Main-Class: MainClassName(not add .class)
 * 
 * 步骤：
 * 1.编译Java文件：javac *.java
 * 2.生成jar文件：jar cvfm jarFileName.jar File1 File2...
 * 更新资源请清单：jar ufm jarFileName manifest-addition.mf
 * .jar程序选项：Java核心技术P427
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


	
	//他的构造函数
	public ResourceTest(){
		this.setSize(DEFAULT_WIDTH, DEFAULT_HERIGHT);
		this.setLayout(new BorderLayout());
		scrollPane.add(textArea);
		
		//设置fram的图标
		//资源加载器
		//得到"person.jpg"的资源位置（图像或声音）
		URL url=this.getClass().getResource("person.jpg");
		//用getImage()读取，声音用getAudioClip()
		Image image=new ImageIcon(url).getImage();
		setIconImage(image);
		
		JMenuBar menuBar=new JMenuBar();
		JMenu FileMenu=new JMenu("File");
		JMenuItem OpenItem=FileMenu.add("Open");
		JMenuItem CloseItem=FileMenu.add("Close");
		JMenuItem SaveItem=FileMenu.add("Save");
		//给open和close添加监听器
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
		editText.setText("请输入留言：");
		
		panel.add(textArea);
		panel.add(editText);
		this.add(panel,BorderLayout.CENTER);
		System.out.println(panel.getSize());
		
		JTextArea welcome=new JTextArea();
		welcome.setText("欢迎使用本系统！");
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
			//需要javaws.jar文件
			try {
				//在浏览器默认显示文档
				//使用BasicService接口访问服务
				BasicService basic=(BasicService) ServiceManager
						.lookup("javax.jnlp.BasicService");
				//查看jnlp配置文件中的codeBase路径
				URL codeBase= basic.getCodeBase();
				System.out.println("codeBase:"+codeBase);
				
				//PersistenceService允许应用程序保留少量的配置信息，并且在下次运行时恢复，类似cookie，使用URL键进行持久性存储：URL键可以存储任意的二进制数据
				PersistenceService service=(PersistenceService) ServiceManager
						.lookup("javax.jnlp.PersistenceService");
				URL key=new URL(codeBase,"title");
				
				
				try{
					//访问与某个特定键关联的信息:无法知道这个键是否存在，只能通过“FileNotFoundException”异常
					FileContents contents=service.get(key);
					InputStream in=contents.getInputStream();
					BufferedReader reader=new BufferedReader(new InputStreamReader(in));
					title=reader.readLine();
				}catch (FileNotFoundException e) {
					title=JOptionPane.showInputDialog("please supply a frame title");
					if(title==null)
						return;
					
					//保证从第二次开始读取时，能通过持久性存储得到title的值
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
	
	
	
	//打开文件
	public void open(){
		try {
			//1.访问服务
			FileOpenService service=(FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
			//2.openFileDialog接受应用程序提供的    初始路径名     和    文件拓展名
			FileContents contents= service.openFileDialog(".", new String[]{"txt"});
			//3.调用getInputStream和getOutputStream来读写文件
			if(contents!=null){
				InputStream input=contents.getInputStream();
				Scanner in=new Scanner(input);
				while(in.hasNext()){
					//把它写到文本框中
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
	
	
	//保存文件
	public void save(){
		try {
			FileSaveService service=(FileSaveService) ServiceManager
					.lookup("javax.jnlp.FileSaveService");
			
			//读取输入框中的string
			ByteArrayInputStream input=new ByteArrayInputStream(editText.getText().getBytes());
			//保存文件的弹框
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