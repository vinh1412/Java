package tuan1_74_PhuongTrinhBacHai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhBacHai extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnGiai, btnXoaRong, btnThoat;
	private JTextField txtA, txtB, txtC, txtKQ;
	private JLabel lblNhapA, lblNhapB, lblNhapC, lblKQ;

	public GiaiPhuongTrinhBacHai() {
		setTitle("^-^");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUIGiaiPhuongTrinhBacHai();
	}

	private void createGUIGiaiPhuongTrinhBacHai() {
		JPanel jpNorth = new JPanel();
		add(jpNorth, BorderLayout.NORTH);
		jpNorth.setBackground(Color.CYAN);
		JLabel lblTieude = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		jpNorth.add(lblTieude);
		lblTieude.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel jpCenter = new JPanel();
		add(jpCenter, BorderLayout.CENTER);
		jpCenter.setLayout(null);
		jpCenter.add(lblNhapA = new JLabel("Nhập a: "));
		int x = 30, y = 40, width = 100, height = 30;
		lblNhapA.setBounds(x, y, width, height);
		jpCenter.add(lblNhapB = new JLabel("Nhập b: "));
		y += 50;
		lblNhapB.setBounds(x, y, width, height);
		jpCenter.add(lblNhapC = new JLabel("Nhập c: "));
		y += 50;
		lblNhapC.setBounds(x, y, width, height);
		jpCenter.add(lblKQ = new JLabel("Kết quả: "));
		y += 50;
		lblKQ.setBounds(x, y, width, height);

		jpCenter.add(txtA = new JTextField());
		x += 100;
		y = 40;
		width = 300;
		txtA.setBounds(x, y, width, height);
		jpCenter.add(txtB = new JTextField());
		y += 50;
		txtB.setBounds(x, y, width, height);
		jpCenter.add(txtC = new JTextField());
		y += 50;
		txtC.setBounds(x, y, width, height);
		jpCenter.add(txtKQ = new JTextField());
		y += 50;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);

		JPanel jpSouth = new JPanel();
		add(jpSouth, BorderLayout.SOUTH);
		jpSouth.setBorder(BorderFactory.createTitledBorder("Ch�?n tác vụ"));
		jpSouth.add(btnGiai = new JButton("Giải"));
		jpSouth.add(btnXoaRong = new JButton("Xóa rỗng"));
		jpSouth.add(btnThoat = new JButton("Thoát"));

		btnGiai.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaiPhuongTrinhBacHai().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			System.exit(0);
		} else if (o.equals(btnXoaRong)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		} else if (o.equals(btnGiai)) {
			if (!isInt(txtA)) {
				focus(txtA);
			} else if (!isInt(txtB)) {
				focus(txtB);
			} else if (!isInt(txtC)) {
				focus(txtC);
			} else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				int c = Integer.parseInt(txtC.getText());
				if (a == 0) {
					giaiPhuongTrinhBac1(b, c);
				} else {
					float denta = b * b - 4 * a * c;
					float x1, x2;
					if (denta < 0) {
						txtKQ.setText("Phuong trinh vo nghiem!!!");
					} else if (denta == 0) {
						txtKQ.setText("Phuong trinh co nghiem kep la: " + (-b / (2 * a)));
					} else {
						x1 = (float) ((-b + Math.sqrt(denta)) / (2 * a));
						x2 = (float) ((-b - Math.sqrt(denta)) / (2 * a));
						txtKQ.setText("x1 = " + x1 + " và x2 = " + x2);
					}
				}

			}
		}
	}

	private void giaiPhuongTrinhBac1(int a, int b) {
		if (a != 0) {
			txtKQ.setText("Nghiệm x = " + (-b / (float) a));
		} else if (b == 0) {
			txtKQ.setText("Phương trình vô số nghiệm");
		} else {
			txtKQ.setText("Phương trình vô nghiệm");
		}
	}

	private boolean isInt(JTextField txt) {
		boolean result = true;
		try {
			Integer.parseInt(txt.getText());
		} catch (NumberFormatException ex) {
			result = false;
		}
		return result;
	}

	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Nhập lại");
		text.selectAll();
	}

}
