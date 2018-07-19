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
	//�÷� �̸� �迭
	String [] colums = { "�̸�","�Ҽ���","������"};
	//������ �迭
	String [][] data = {
			{"��������ӽ�","LA����Ŀ��","�Ŀ�������"},
			{"���ӽ��ϵ�","�޽���","����������"},
			{"ũ������","�޽���","����Ʈ����"},
			{"Ŀ��","��罺����Ʈ","���ð���"},
			{"�̱Ŵ޶�","��罺����Ʈ","����������"},
			{"�ɺ󷯺�","Ŭ���귣��","����"},
	};
	
	public AddressBook() {
		setBounds(500,500,1000,1000);
		setTitle("�󱸼���");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//���̺� �� �����
		DefaultTableModel model = new DefaultTableModel(data,colums);
		//���̺� ���� �̿��ؼ� ���̺��� �����
		JTable table = new JTable(model);
		//table.setModel(model);
		//��� ������ ũ�⺸�� table�� Ŀ������
		//��ũ�� �ٸ� �̿��� �� �ֵ��� Scroll�� ����
		JScrollPane scrollPane = new JScrollPane(table);
		//��ũ�� ������ �����ӿ� ����
		add(scrollPane);
		
		
		/*// �޴� �ٸ� ����
				JMenuBar menubar = new JMenuBar();
				
				JMenu file = new JMenu("����(a)");
				//����Ű �����ϴ� �� �̷��� alt a������ ���� ��ư�� ��������.
				file.setMnemonic('a');
				
				JMenuItem item1 = new JMenuItem("����");
				file.add(item1);
				
				JCheckBoxMenuItem item2 = new JCheckBoxMenuItem("����");
				file.add(item2);
				
				JRadioButtonMenuItem item3 = new JRadioButtonMenuItem("����");
				file.add(item3);
				
				*/
				
				
				//menubar.add(file);
				
				//�޴� �ٸ� �����쿡 ����
				//setJMenuBar(menubar);
				
		
		JLabel label = new JLabel("�̸�");
		JTextField tfName = new JTextField(10);
		JLabel tf1Phone = new JLabel("��ȭ��ȣ");
		JTextField tfPhone = new JTextField(10);
		JLabel lblAddress = new JLabel("�ּ�");
		JTextField tfAddress = new JTextField(10);
		
		JButton btnInsert = new JButton("����");
		JButton btnDelete = new JButton("����");

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
				// �ؽ�Ʈ �ʵ忡 �Էµ� ���� ��������
				String name = tfName.getText();
				String phone = tfPhone.getText();
				String address = tfAddress.getText();
				
				//�¿� ���� �����ϱ�
				name = name.trim();
				phone = phone.trim();
				address = address.trim();
				
				//name�� �ʼ� �Է�
				//�̸��� �Էµ��� ���� ��� ���̰� 0 //null�� �ƴϴ�.
				if(name.length() == 0) { //�����Ϳ� ������ ���ٴ� ���� ������ 0�̴ٶ�°�
					JOptionPane.showMessageDialog(null, "�̸��� �ʼ� �Է�","�̸�",JOptionPane.WARNING_MESSAGE);
					//�Ʒ����� ���̻� �������� �ʵ���
					return; // Ŭ���� �����ΰ��Եȴ�.
				}
				
				//���̺��� �����͸� �����ϱ� ���ؼ� ���̺��� 
				//������ ���� �����ɴϴ�.
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				//�����͸� �߰��ϱ� ���ؼ� �߰��� ������ �迭�� ����
				String [] row = {name,phone,address};
				//�𵨿� �߰�
				model.addRow(row);
				//���̺� ����
				table.updateUI();
				
				//�ؽ�Ʈ �ʵ� Ŭ���� �߰���Ű�� ����ִ� ���� ������ �߰� ��Ű�� �����ִ�.
				tfName.setText("");
				tfPhone.setText("");
				tfAddress.setText("");
				//�޼��� �ڽ� ���
				JOptionPane.showMessageDialog(null, "�����ͻ��Լ���","�����۾�",JOptionPane.PLAIN_MESSAGE);
			}
			
		};
		btnInsert.addActionListener(listener);
		
		ActionListener listener2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//������ �� ��ȣ ã��
				int idx = table.getSelectedRow();
				//���̺��� ���� �������� �ʾҴٸ�
				if(!(idx >=0 && idx <table.getRowCount())) {
					JOptionPane.showMessageDialog(null, "���� �����ϼ���!","���� ����",JOptionPane.WARNING_MESSAGE);
					//���̻� �����ϸ� �ȵǴϱ� Ŭ������ ��������������.
					return;
				}
				
				
				//���̺��� �� ��������
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				//�࿡ �ش��ϴ� ������ �����
				model.removeRow(idx);
				
				table.updateUI();
				// ����� ��� â �ֱ�
				JOptionPane.showMessageDialog(null, "������ ���� ����","����",JOptionPane.WARNING_MESSAGE);
				
			}
			
		};
		btnDelete.addActionListener(listener2);
		
		setVisible(true);
		
/*		JOptionPane.showMessageDialog(null, "�޽��� ���̾�α�", "��ȭ����",JOptionPane.QUESTION_MESSAGE);
*/		
		/*int r = JOptionPane.showConfirmDialog(null, "�޽��� ���̾�α�", "��ȭ����",JOptionPane.YES_NO_OPTION);
		System.out.println(r);
*//*		
		String r = JOptionPane.showInputDialog(null ,"�޽��� ���̾�α�", "��ȭ����",JOptionPane.YES_NO_CANCEL_OPTION );
		System.out.println(r);
		*/
		
		
	}
}
