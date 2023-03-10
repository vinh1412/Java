package tuan1_74_SoNguyenTo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenTo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNhap;
	private JTextArea txtXuat;
	private JButton btnGenerate;

	public SoNguyenTo() {
		setTitle("Primes");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		createGUISoNguyenTo();
	}

	private void createGUISoNguyenTo() {
		setLayout(null);
		add(txtNhap = new JTextField());
		txtNhap.setBounds(50, 30, 200, 30);
		txtNhap.setToolTipText("Nhập số lượng số nguyên tố muốn xem");

		add(btnGenerate = new JButton("Generate"));
		btnGenerate.setBounds(250, 30, 100, 30);

		JScrollPane srl;
		add(srl = new JScrollPane(txtXuat = new JTextArea()));
		srl.setBounds(50, 70, 300, 170);
		txtXuat.setToolTipText("Danh sách các số nguyên tố");
		txtXuat.setEditable(false);
		btnGenerate.addActionListener(this);
	}

	public static void main(String[] args) {
		new SoNguyenTo().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnGenerate)) {
			int n = Integer.parseInt(txtNhap.getText());
			if (n>0) {
				for (int i = 2; i < Integer.MAX_VALUE; i++) {
					if (isPrimeNumber(i)) {
						txtXuat.append(i+"\n");
						n--;
					}
					if(n==0) {
						break;
					}
				}
			}else {
				//txtXuat.setText("Phải nhập số nguyên dương");
				JOptionPane.showMessageDialog(this, "Phải nhập số nguyên dương");
				txtNhap.setText("");
				//txtXuat.setText("");
				txtNhap.requestFocus();
			}
		}
	}

	public static boolean isPrimeNumber(int n) {
		// so nguyen n < 2 khong phai la so nguyen to
		if (n < 2) {
			return false;
		}
		// check so nguyen to khi n >= 2
		int squareRoot = (int) Math.sqrt(n);
		for (int i = 2; i <= squareRoot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
