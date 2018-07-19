package prec2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddressBook extends JFrame {
	//컬럼 이름 배열
	String [] colums = { "이름","소속팀","포지션"};
	//데이터 배열
	String [][] data = {
			{"르브론제임스","LA레이커스","파워포워드"},
			{"제임스하든","휴스턴","스몰포워드"},
			{"크리스폴","휴스턴","포인트가드"},
			{"커리","골든스테이트","슈팅가드"},
			{"이궈달라","골든스테이트","스몰포워드"},
			{"케빈러브","클리브랜드","센터"},
	};
	
	public AddressBook() {
		setBounds(500,500,1000,1000);
		setTitle("농구선수");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//테이블 모델 만들기
		DefaultTableModel model = new DefaultTableModel(data,colums);
		//테이블 모델을 이용해서 테이블을 만들기
		JTable table = new JTable(model);
		//table.setModel(model);
		//출력 영역의 크기보다 table이 커지더라도
		//스크롤 바를 이용할 수 있도록 Scroll을 생성
		JScrollPane scrollPane = new JScrollPane(table);
		//스크롤 패인을 프레임에 부착
		add(scrollPane);
		
		
		/*// 메뉴 바를 생성
				JMenuBar menubar = new JMenuBar();
				
				JMenu file = new JMenu("파일(a)");
				//단축키 설정하는 것 이러면 alt a누르면 파일 버튼이 눌러진다.
				file.setMnemonic('a');
				
				JMenuItem item1 = new JMenuItem("열기");
				file.add(item1);
				
				JCheckBoxMenuItem item2 = new JCheckBoxMenuItem("저장");
				file.add(item2);
				
				JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("편집");
				file.add(item3);
				
				*/
				
				
				//menubar.add(file);
				
				//메뉴 바를 윈도우에 부착
				//setJMenuBar(menubar);
				
		
		JLabel label = new JLabel("이름");
		JTextField tfName = new JTextField(10);
		JLabel tf1Phone = new JLabel("전화번호");
		JTextField tfPhone = new JTextField(10);
		JLabel lblAddress = new JLabel("주소");
		JTextField tfAddress = new JTextField(10);
		
		JButton btnInsert = new JButton("삽입");
		JButton btnDelete = new JButton("삭제");

		JPanel southPanel = new JPanel();
		southPanel.add(label);
		southPanel.add(tfName);
		southPanel.add(tf1Phone);
		southPanel.add(tfPhone);
		southPanel.add(lblAddress);
		southPanel.add(tfAddress);
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);

	

		add("South",southPanel);
		
		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드에 입력된 내용 가져오기
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String address = tfAddress.getText();
				
				//좌우 공백 제거하기
				name = name.trim();
				phone = phone.trim();
				address = address.trim();
				
				//name의 필수 입력
				//이름이 입력되지 않은 경우 길이가 0 //null이 아니다.
				if(name.length() == 0) { //데이터에 네임이 없다는 것은 랭스가 0이다라는것
					JOptionPane.showMessageDialog(null, "이름은 필수 입력","이름",JOptionPane.WARNING_MESSAGE);
					//아래쪽을 더이상 수행하지 않도록
					return; // 클래스 밖으로가게된다.
				}
				
				//테이블의 데이터를 편집하기 위해서 테이블의 
				//데이터 모델을 가져옵니다.
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//데이터를 추가하기 위해서 추가할 데이터 배열을 생성
				String [] row = {name,phone,address};
				//모델에 추가
				model.addRow(row);
				//테이블 갱신
				table.updateUI();
				
				//텍스트 필드 클리어 추가시키고 비워주는 역할 없으면 추가 시키고 남아있다.
				tfName.setText("");
				tfPhone.setText("");
				tfAddress.setText("");
				//메세지 박스 출력
				JOptionPane.showMessageDialog(null, "데이터삽입성공","삽입작업",JOptionPane.PLAIN_MESSAGE);
			}
			
		};
		btnInsert.addActionListener(listener);
		
		ActionListener listener2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//선택한 행 번호 찾기
				int idx = table.getSelectedRow();
				//테이블에서 행을 선택하지 않았다면
				if(!(idx >=0 && idx <table.getRowCount())) {
					JOptionPane.showMessageDialog(null, "행을 선택하세요!","삭제 실패",JOptionPane.WARNING_MESSAGE);
					//더이상 진행하면 안되니까 클래스를 빠져나가버린다.
					return;
				}
				
				
				//테이블의 모델 가져오기
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				//행에 해당하는 데이터 지우기
				model.removeRow(idx);
				
				table.updateUI();
				// 지우고 경고 창 주기
				JOptionPane.showMessageDialog(null, "데이터 삭제 성공","삭제",JOptionPane.WARNING_MESSAGE);
				
			}
			
		};
		btnDelete.addActionListener(listener2);
		
		setVisible(true);
		
/*		JOptionPane.showMessageDialog(null, "메시지 다이얼로그", "대화상자",JOptionPane.QUESTION_MESSAGE);
*/		
		/*int r = JOptionPane.showConfirmDialog(null, "메시지 다이얼로그", "대화상자",JOptionPane.YES_NO_OPTION);
		System.out.println(r);
*//*		
		String r = JOptionPane.showInputDialog(null ,"메시지 다이얼로그", "대화상자",JOptionPane.YES_NO_CANCEL_OPTION );
		System.out.println(r);
		*/
		
		
	}
}
