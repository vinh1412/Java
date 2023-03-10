package tuan1_74_CongTruNhanChia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CongTruNhanChia extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnGiai, btnXoa, btnThoat;
	private JTextField txtA, txtB, txtKQ;
	private JLabel lblNhapA, lblNhapB, lblKQ, lblTieuDe;
	private JRadioButton radCong, radTru, radNhan, radChia;

	public CongTruNhanChia() {
		setTitle("Cộng-Trừ-Nhân-Chia");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUICongTruNhanChia();
		setVisible(true);
	}

	public void createGUICongTruNhanChia() {
		JPanel jpNorth = new JPanel();
		add(jpNorth, BorderLayout.NORTH);
		lblTieuDe = new JLabel("Cộng Trừ Nhân Chia");
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		jpNorth.add(lblTieuDe);

		JPanel jpWest = new JPanel();
		jpWest.setLayout(new GridLayout(20, 1, 1, -10));
		jpWest.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		btnGiai = new JButton("Giải ");
		btnXoa = new JButton("Xóa ");
		btnThoat = new JButton("Thoát ");
		jpWest.add(btnGiai = new JButton("Giải"));
		jpWest.add(Box.createVerticalStrut(10));
		jpWest.add(btnXoa = new JButton("Xóa"));
		jpWest.add(Box.createVerticalStrut(10));
		jpWest.add(btnThoat = new JButton("Thoát"));
		jpWest.add(Box.createVerticalStrut(10));
		add(jpWest, BorderLayout.WEST);
		jpWest.setBackground(Color.LIGHT_GRAY);

		JPanel jpSouth = new JPanel();
		add(jpSouth, BorderLayout.SOUTH);
		jpSouth.setPreferredSize(new Dimension(0, 50));
		jpSouth.setBackground(Color.pink);
		JPanel oVuong1 = new JPanel();
		oVuong1.setBackground(Color.blue);
		oVuong1.setPreferredSize(new Dimension(25, 23));
		jpSouth.add(oVuong1);
		JPanel oVuong2 = new JPanel();
		oVuong2.setBackground(Color.red);
		oVuong2.setPreferredSize(new Dimension(25, 23));
		jpSouth.add(oVuong2);
		JPanel oVuong3 = new JPanel();
		oVuong3.setBackground(Color.yellow);
		oVuong3.setPreferredSize(new Dimension(25, 23));
		jpSouth.add(oVuong3);

		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new BoxLayout(jpCenter, BoxLayout.Y_AXIS));
		add(jpCenter, BorderLayout.CENTER);
		jpCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		JPanel phanA = new JPanel();
		lblNhapA = new JLabel("Nhập a:");
		txtA = new JTextField(30);
		phanA.add(lblNhapA);
		phanA.add(txtA);
		jpCenter.add(phanA);
		JPanel phanB = new JPanel();
		lblNhapB = new JLabel("Nhập b:");
		txtB = new JTextField(30);
		phanB.add(lblNhapB);
		phanB.add(txtB);
		jpCenter.add(phanB);

		JPanel jpKhungChucNang = new JPanel();
		JPanel jpPheptoan = new JPanel();
		jpPheptoan.setLayout(new GridLayout(2, 2));
		jpPheptoan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		radCong = new JRadioButton("Cộng");
		radTru = new JRadioButton("Trừ");
		radNhan = new JRadioButton("Nhân");
		radChia = new JRadioButton("Chia");
		ButtonGroup group = new ButtonGroup();
		group.add(radCong);
		group.add(radTru);
		group.add(radNhan);
		group.add(radChia);
		jpPheptoan.add(radCong);
		jpPheptoan.add(radTru);
		jpPheptoan.add(radNhan);
		jpPheptoan.add(radChia);
		jpKhungChucNang.add(jpPheptoan);
		jpCenter.add(jpKhungChucNang);

		JPanel jpKetQua = new JPanel();
		lblKQ = new JLabel("Kết quả: ");
		txtKQ = new JTextField(30);
		txtKQ.setEditable(false);
		jpKetQua.add(lblKQ);
		jpKetQua.add(txtKQ);
		jpCenter.add(jpKetQua);

		btnThoat.addActionListener(this);
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
	}

	public static void main(String[] args) {
		new CongTruNhanChia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			int ret = JOptionPane.showConfirmDialog(null, "Muốn thoát hả?", "Thoát", JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		if (o.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		}
		if (o.equals(btnGiai)) {
			String sa = txtA.getText();
			int a = 0, b = 0;
			try {
				a = Integer.parseInt(sa);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "a nhập sai định dạng!");
				txtA.selectAll();
				txtA.requestFocus();
				return;
			}
			String sb = txtB.getText();
			try {
				b = Integer.parseInt(sb);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "b nhập sai định dạng!");
				txtB.selectAll();
				txtB.requestFocus();
				return;
			}
			double kq = 0;
			if (radCong.isSelected()) {
				kq = (a + b);
			} else if (radTru.isSelected()) {
				kq = (a - b);
			} else if (radNhan.isSelected()) {
				kq = (a * b);
			} else {
				kq = a * 1.0 / b * 1.0;
			}
			txtKQ.setText(kq + "");
		}
	}
}
