package javastudy;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * << 개정이력(Modification Information) >>
 * 수정일			  수정자	   작업 내용(수정 내용)	
 * ----------	------   ----------------
 * 2021.10.07    이한나         레이아웃 설계, 기능 구현
 * 2021.10.08	 이한나
 */


// 외부 클래스
public class ManageSystem extends JFrame{	// JFrame 클래스는 윈도우 프로그래밍에서 '최상위 컨테이너' 역할

	public static final String String = null;

	// 내부 클래스의 객체 생성. 생성자 밖에서 생성했으므로(global) 모든 내부클래스에서 접근 가능! 
	MenuMain menuMain = new MenuMain();
	West west = new West();
	Buttons buttons = new Buttons();
	ShowTable showTable = new ShowTable();
	
	
	// 생성자에 객체들 마지막으로 add해서 붙여주자.
	public ManageSystem() {
		OUTTER: while(true) {	 // OUTTER 는 레이블
			ImageIcon icon = new ImageIcon("src/images/grimPan.png");
			JOptionPane.showMessageDialog(null, null, "고객정보 관리시스템", 
											JOptionPane.NO_OPTION, icon); //NO_OPTION은 "확인"만 띄움. 없애면 "취소"도 생성
		
			String password = JOptionPane.showInputDialog("고객관리 시스템\n패스워드 입력"); //입력받기
			String passwd = "1";
			if(password == null) {
				break OUTTER;
			}else if(password.equals(passwd)){ //패스워드 인증 성공
				setTitle("고객정보 관리 시스템");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
///////////////////// 여기에 추가 ////////////////////////
				add(menuMain.bar, BorderLayout.NORTH); // bar(젤 큰단위)를 북쪽에 배치해라
				add(west, BorderLayout.WEST);	//west객체를 왼쪽에 붙여라
				add(buttons, BorderLayout.SOUTH);
				add(showTable.scrollPane, BorderLayout.CENTER);
				
				setSize(1200,800);
				setLocation(500,50);
				setVisible(true);
				
				break OUTTER;
			}else {
				JOptionPane.showMessageDialog(null, "패스워드가 맞지 않습니다.\n'확인' 버튼을 누르세요.","에러 메세지", JOptionPane.ERROR_MESSAGE);
				continue OUTTER;
			}
			
		}
	}
	
// ===============================================================================================
	// 메뉴 만들기(파일, 정렬, 도움말) -> 내부 클래스(inner class).
	class MenuMain extends JPanel implements ActionListener, ItemListener{ //JPanel은 작은 컨테이너. Listener들은 인터페이스
		
		JMenuBar			bar;
		JMenu 				file, sort, help;  // 파일, 정렬, 도움말
		JMenuItem			fnew, fopen, fsave, fexit, proinfo;
		JCheckBoxMenuItem	sno, sname, schul, sjob;
		
		FileDialog readOpen, saveOpen;
		String fileDir, fileName, savefileName, readfileName;
		ButtonGroup gr = new ButtonGroup();		// 이거 해야 체크박스 1개만 체크되는 것 (gr.add도)
		
		
		// 생성자. 화면 구현(UI), 각 객체(컴포넌트)에 대한 이벤트 연결
		public MenuMain() {
			bar = new JMenuBar(); //여기에다가 다 붙여야함.
			
			file = new JMenu("파일");
			sort = new JMenu("정렬");
			help = new JMenu("도움말");
			
			fopen = new JMenuItem("열기");	
			fsave = new JMenuItem("저장");
			fexit = new JMenuItem("닫기");
			
			sno = new JCheckBoxMenuItem("번호"); //번호로 정렬
			sname = new JCheckBoxMenuItem("이름"); //이름으로 정렬
			schul = new JCheckBoxMenuItem("출신 지역");
			sjob = new JCheckBoxMenuItem("직업");
			
			proinfo = new JMenuItem("프로그램 정보");
			
			// 객체들 컨테이너에 붙이기
			file.add(fopen); file.add(fsave); file.addSeparator(); file.add(fexit);	//addSeparator 로 구분선 생성
			gr.add(sno); gr.add(sname); gr.add(schul); gr.add(sjob);  // 체크박스메뉴아이템을 버튼 그룹에 붙임 -> 버튼그룹으로 묶어야 어느 하나만 선택하도록 되있음 !!
			sort.add(sno); sort.add(sname); sort.add(schul); sort.add(sjob);
			help.add(proinfo);
			
			bar.add(file); bar.add(sort); bar.add(help);
			
			// '파일' 메뉴 이벤트 연결
			fopen.addActionListener(this);	//this는 이벤트 핸들러 객체 자신
			fsave.addActionListener(this);	//JMenuItem 컴포넌트는 ActionEvent 발생
			fexit.addActionListener(this);
			
			// '정렬' 메뉴 이벤트 연결
			sno.addItemListener(this);		//JCheckBoxMenuItem 은 ItemEvent 발생
			sname.addItemListener(this);
			schul.addItemListener(this);
			sjob.addItemListener(this);
			
		}
		
		
		@Override
		public void itemStateChanged(ItemEvent e) {	//ItemListener 꺼
			
		}

		@Override
		public void actionPerformed(ActionEvent e) { //ActionListener 꺼
			
		} 
	} //end MenuMain
// ===============================================================================================
	// 입력, 정보 검색 만들기 (West 내부 클래스)
	class West extends JPanel{
		
		Input input = new Input();
		Output output = new Output();
		
		
		// 생성자
		public West() {
			setLayout(new BorderLayout());
			add(input, BorderLayout.CENTER); //input을 센터쪽에 붙여라
			add(output, BorderLayout.SOUTH);
		}
		
		// 입력 정보 담당 클래스
		class Input extends JPanel{
			JTextField[] tf = new JTextField[5];	//입력 텍스트 상자
			String[] text = {"번호","이름","핸드폰 번호","이메일","주민번호"}; //입력받을 것들
			String[] jobText = {"선택","회사원","공무원","프로그래머","교수","학생","기타"};
			JLabel la, job;
			JComboBox box;
			
			// 생성자
			public Input() { // 화면 설계 UI
				setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"입력"));	//파란선 테두리(굵기:2) 생성. 제목은 '입력'
				setLayout(new GridLayout(6,2,5,30));	//6행 2열 (2차원배열처럼) 뒤에껀 간격
				
				for(int i=0;i<text.length;i++) {
					la = new JLabel(text[i]);
					tf[i] = new JTextField(10);
					la.setHorizontalAlignment(JLabel.CENTER);
					add(la); add(tf[i]);
				}
				
				box = new JComboBox(jobText);
				job = new JLabel("직업");
				job.setHorizontalAlignment(JLabel.CENTER);
				add(job); add(box);
				setPreferredSize(new Dimension(340,300));
			}
			
		}
		
		// 신상 정보 클래스. 검색버튼 누르면 '정보검색' 레이아웃 뜨도록 해야함. 디자인 2개 해야해. 
		class Output extends JPanel implements ActionListener{
			
			// 추가
			JPanel info = new JPanel();	// 신상정보 보더
			JPanel search = new JPanel(); // 정보 검색 보더
			
			CardLayout card = new CardLayout(); // 카드교체 레이아웃
			String[] text = {"	나이:","	성별:","	출생지역:", "생일:"};
			JLabel[] label = new JLabel[4];
			ButtonGroup group = new ButtonGroup();
			JRadioButton[] searchRadio = new JRadioButton[4];
			JButton searchButton;
			JButton exitButton;
			JTextField nameText;
			String[] search_name = {"이름","직업","출생지역","생년월일"};
			int searchType;
			
			// 생성자
			public Output() {	// 화면 구현, 각 객체에 대한 이벤트 연결
				
				// '신상 정보' UI 보더 만들기
				info.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"신상정보"));
				info.setLayout(new GridLayout(4, 1));	//4행 1열 그리드 레이아웃
				
				for(int i=0;i<text.length;i++) {
					label[i] = new JLabel(text[i], JLabel.LEFT);
					info.add(label[i]);
				}
				
				// '정보 검색' UI 보더 만들기
				search.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"정보검색"));
				nameText = new JTextField(10);
				searchButton = new JButton("찾기");
				exitButton = new JButton("나가기");
				
				searchButton.setBackground(Color.CYAN);
				exitButton.setBackground(Color.LIGHT_GRAY);
				
				// 버튼 객체에 이벤트 핸들러 리스너 등록
				searchButton.addActionListener(this);
				exitButton.addActionListener(this);
				
				setPreferredSize(new Dimension(340,300));
				
				int x = -70;
				search.setLayout(null);
				
				for(int i=0;i<searchRadio.length;i++) {
					searchRadio[i] = new JRadioButton(search_name[i]);
					searchRadio[i].setBounds(x+=80, 60, 80, 30);
					group.add(searchRadio[i]);
					search.add(searchRadio[i]);
					
					//이벤트 연결
					searchRadio[i].addActionListener(this);
				
				}
				nameText.setBounds(40,110,200,30);
				searchButton.setBounds(35,170,80,30);
				exitButton.setBounds(140,170,110,30);
				
				search.add(nameText);
				search.add(searchButton);
				search.add(exitButton);
				
				// Card layout 만들어서 교체되게끔
				card = new CardLayout();
				setLayout(card);
				
				add(info, "신상정보 카드");
				add(search,"정보검색 카드");
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("나가기")) goOut();
			}
			public void goOut() {
				west.output.card.show(west.output,"신상정보 카드");
			}
			
			
		}
		
	}
// ==============================================================================================================
	// 추가, 삭제, 이전, 다음, 수정, 검색 버튼 틀 (제일 밑)
	class Buttons extends JPanel implements ActionListener{ //버튼은 action listener
		
		Vector<String> vector;
		JButton addBtn, delBtn, preBtn, nextBtn, updateBtn, searchBtn; //추가, 삭제, 이전, 다음, 수정, 검색 버튼
		int age;
		String juminNo, sung, chul;
		
		public Buttons(){
			setLayout(new GridLayout(1,6));
			
			addBtn = new JButton("추가");
			delBtn = new JButton("삭제");
			preBtn = new JButton("이전");
			nextBtn = new JButton("다음");
			updateBtn = new JButton("수정");
			searchBtn = new JButton("검색");
			
			addBtn.setBackground(Color.YELLOW);
			delBtn.setBackground(Color.LIGHT_GRAY);
			preBtn.setBackground(Color.PINK);
			nextBtn.setBackground(Color.GREEN);
			updateBtn.setBackground(Color.MAGENTA);
			searchBtn.setBackground(Color.CYAN);
			
			add(addBtn);add(delBtn);add(preBtn);add(nextBtn);add(updateBtn);add(searchBtn);
			
			//버튼에 이벤트 연결
			addBtn.addActionListener(this);
			delBtn.addActionListener(this);
			preBtn.addActionListener(this);
			nextBtn.addActionListener(this);
			updateBtn.addActionListener(this);
			searchBtn.addActionListener(this);
		}
		
		
		// 버튼 클릭 -> actionPerformed 호출 -> 액션 처리
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//추가 버튼이 클릭되면. getActionCommand는 문자열을 가져옴.
			if(e.getActionCommand().equals("추가")) addData(); //이 메소드 호출해라
			else if(e.getActionCommand().equals("검색")) searchData();
			
		} 
		
		// '추가' 버튼 클릭시 이벤트 처리 메소드
		public void addData() {
			nextBtn.setEnabled(true); // 다음 버튼 활성화 (비활성화하면 클릭 못함)
			vector = new Vector<String>();
			vector.add(west.input.tf[0].getText());	//번호 입력값 얻어서 벡터 객체에 추가
			vector.add(west.input.tf[1].getText()); //이름 
			vector.add(west.input.tf[2].getText()); //핸드폰 번호
			vector.add(west.input.tf[3].getText()); //이메일
			
			juminNo = west.input.tf[4].getText(); // 주민번호 유효성 검사하자.
			
			//유효성검사
			String regex = "^[0-9]{6}-[1234][0-9]{6}$";
			boolean check = juminNo.matches(regex);
			
			if(check==false) {
				JOptionPane.showMessageDialog(null, 
						"주민번호가 정규식패턴에 맞지 않음\n주민번호를 다시 입력하세요.", "에러 메세지", JOptionPane.ERROR_MESSAGE);
				west.input.tf[4].setText(null); // 입력받은 주민번호를 지우고,
				west.input.tf[4].requestFocus(); // 이 칸에 포커스를 맞춰주자.
				return; //현재 상태 그대로 있어라.(사용자가 다시 입력할 때 까지)
			
			}else if(juminNo.length() == 14){ // 정규표현식 만족
				int sum = 0;
				int[] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5,6};
			
				for(int i=0;i<13;i++) {
					if(juminNo.charAt(i)=='-') continue;
					sum += (juminNo.charAt(i)-48)*weight[i];
				}
				int temp = 11-(sum%11);
				int result = temp%10;
				
				if(result == juminNo.charAt(13)-48) {
					JOptionPane.showMessageDialog(null, "주민번호 체크 결과 정상입니다."		//긍정적인 메세지창은 파라미터 2개
							+"\n'확인' 버튼을 누르면 정보가 출력됩니다.");	
					vector.add(juminNo);
					
					// 정상이니까 나이 추출
					Calendar cal = Calendar.getInstance(Locale.KOREA);
					int now = cal.get(Calendar.YEAR);
					int year = Integer.parseInt(juminNo.substring(0, 2));		
					if((juminNo.charAt(7)-48) < 3) {
						year += 1900;
					}else {
						year += 2000;
					}
					int age = now-year+1;
					vector.add(String.valueOf(age)); //정수를 스트링으로 바꿔서 vector에 넣어라
					
					// 성별 추출
					if((juminNo.charAt(7)-48)%2 == 0) {
						sung = "여자";
					}else {
						sung = "남자";
					}
					vector.add(sung);
					
					// 출신 지역 추출
					String[][] localCode = {{"서울","00","08"},{"부산","09","12"},{"인천","13","15"}
											,{"경기","16","25"},{"강원","26","34"},{"충북","35","39"}
											,{"대전","40","40"},{"충남","41","43"},{"충남","45","47"}
											,{"세종","44","44"},{"세종","96","96"},{"전북","48","54"}
											,{"전남","55","64"},{"광주","65","66"},{"대구","67","70"}
											,{"경북","71","80"},{"경남","81","84"},{"경남","86","90"}
											,{"울산","85","85"},{"제주","91","95"}};
					
					String localeString = juminNo.substring(8,10);
					int locale = Integer.parseInt(localeString);
					String birthPlace = null;
					
					for(int j=0;j<=19;j++) { // 배열 갯수가 19
						if(locale >= Integer.parseInt(localCode[j][1]) &&   
							locale <= Integer.parseInt(localCode[j][2])) {
							birthPlace = localCode[j][0];
						}
					}
					vector.add(birthPlace);
					vector.add(juminNo.substring(2,4)+"월 "+juminNo.substring(4,6)+"일");
				
					west.output.label[0].setText("   나 이:   "+String.valueOf(age));
					west.output.label[1].setText("   성 별:   "+sung);
					west.output.label[2].setText(" 출생지역:   "+birthPlace);
					west.output.label[3].setText("   생 일:   "+juminNo.substring(2,4)+"월 "+juminNo.substring(4,6)+"일");
					
					vector.add(west.input.box.getSelectedItem().toString());	// 직업
					
					// 벡터에 다 저장했으니까 인풋 내용 지우기
					for(int i=0;i<5;i++) {
						west.input.tf[i].setText(null);
					}
					 // 직업 (콤보박스 객체) '선택'으로 원위치
					west.input.box.setSelectedIndex(0);
					
					west.input.tf[0].requestFocus();  //첫번째 칸에 포커스 맞춰주기
					
					// JTable에 뿌려주기
					showTable.data.addElement(vector);
					showTable.datamodel.fireTableDataChanged();
					
				} else {
					JOptionPane.showMessageDialog(null, "주민번호 틀림", "에러 메세지", JOptionPane.ERROR_MESSAGE);
					west.input.tf[4].setText(null); // 입력받은 주민번호를 지우고,
					west.input.tf[4].requestFocus(); // 이 칸에 포커스를 맞춰주자.
					return; //현재 상태 그대로 있어라.(사용자가 다시 입력할 때 까지)
				}
				
				
				
			}
		}
		
		// '검색' 버튼 클릭시 이벤트 처리 메소드 (카드 변경)
		public void searchData() {
			// 방법 1
			west.output.card.show(west.output, "정보검색 카드");
			// 방법 2
		//	west.output.card.next(west.output);
		}
		
		
		
	}
// ===============================================================================================		
	// 중앙 센터 => Jtable 만들기 => 내부 클래스
	class ShowTable extends MouseAdapter{
		
		DefaultTableModel 	datamodel;
		JTable 				table;
		JScrollPane 		scrollPane;
			
		String[] colName = {"번호","이름","핸드폰번호","이메일","주민번호","나이","성별","출생지역","생일","직업"};
			
		Vector<Vector<String>> data;	//벡터 안에 벡터가 또 있음!
		Vector<String> column_name;
		int row = -1;
			
		//생성자
		public ShowTable(){
			data = new Vector<Vector<String>>();
			column_name = new Vector<String>();
			
			for(int i=0;i<colName.length;i++) {
				column_name.add(colName[i]);
			}
			
			// 1단계: default table 모델객체 만들기
			datamodel = new DefaultTableModel(data, column_name) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			// 2단계: JTable 모델 객체 만들기
			table = new JTable(datamodel);
			
			// 3단계: JScrollPane 만들기
			scrollPane = new JScrollPane(table);
			
			// 이벤트 연결
			table.addMouseListener(this);
			table.setAutoCreateRowSorter(true);
			
			TableRowSorter<TableModel> tableSorter = new TableRowSorter<TableModel>(table.getModel());
			table.setRowSorter(tableSorter);	
		
			TableSize();
				
		}
		public void TableSize() {	// 셀 크기 조절 (이메일 칸 넓게 등)
			// JTable의 셀 크기 조절하기
			table.getColumnModel().getColumn(0).setPreferredWidth(50);  // 번호 셀
			table.getColumnModel().getColumn(1).setPreferredWidth(50);  // 이름 셀
			table.getColumnModel().getColumn(2).setPreferredWidth(120); // 핸드폰 번호 셀
			table.getColumnModel().getColumn(3).setPreferredWidth(150); // 이메일 셀
			table.getColumnModel().getColumn(4).setPreferredWidth(130); // 주민번호 셀
			table.getColumnModel().getColumn(5).setPreferredWidth(50);  // 나이 셀
			table.getColumnModel().getColumn(6).setPreferredWidth(50);  // 성별 셀
			table.getColumnModel().getColumn(7).setPreferredWidth(80);  // 출생지역 셀
			table.getColumnModel().getColumn(8).setPreferredWidth(70);  // 생일 셀
			table.getColumnModel().getColumn(9).setPreferredWidth(50);  // 직업 셀
		}
	}
	
	
// ===============================================================================================	
	// 메인
	public static void main(String[] args) {
		ManageSystem ms = new ManageSystem();
		
	}

}
