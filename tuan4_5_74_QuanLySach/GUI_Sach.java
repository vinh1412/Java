package tuan4_5_74_QuanLySach;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI_Sach extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMaSach, lblTuaSach, lblNamXB, lblSoTrang, lblISBN, lblTacGia, lblNhaXuatBan, lblDonGia;
	private JTextField txtMaSach, txtTuaSach, txtNamXB, txtSoTrang, txtISBN, txtTacGia, txtNhaXuatBan, txtDonGia;
	private JPanel pnNorth, pnCenter;
	public GUI_Sach() {
		setTitle("Quản lý sách");
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUISach();
		setVisible(true);
		
	}
	public void createGUISach() {
		pnNorth= new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.X_AXIS));
		pnNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		Box b= Box.createVerticalBox();
		Box b1=Box.createHorizontalBox();
		Box b2=Box.createHorizontalBox();
		Box b3=Box.createHorizontalBox();
		Box b4=Box.createHorizontalBox();
		Box b5=Box.createHorizontalBox();
		
		lblMaSach= new JLabel("Mã sách: ");
		txtMaSach= new JTextField(30);
		b1.add(lblMaSach);
		b1.add(txtMaSach);
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		
		lblTuaSach= new JLabel("Tựa sách: ");
		txtTuaSach= new JTextField(54);
		lblTacGia= new JLabel("Tác giả: ");
		txtTacGia= new JTextField(54);
		lblTuaSach.setPreferredSize(lblMaSach.getPreferredSize());
		b2.add(lblTuaSach);
		b2.add(txtTuaSach);
		
		b2.add(lblTacGia);
		b2.add(txtTacGia);
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		
		pnNorth.add(b);
		add(pnNorth, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI_Sach();
	}

}
