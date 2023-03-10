package tuan2_74_ThongTinNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;

public class GUI_ThongTinNhanVien extends JFrame implements ActionListener, MouseListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMaNV, lblHo, lblTenNV, lblTuoi, lblPhai, lblTienLuong, lblTieuDe, lblNhapSoCantim;
	private JTextField txtMaNV, txtHo, txtTenNV, txtTuoi, txtTienLuong, txtNhapSoCanTim;
	private JRadioButton radNam, radNu;
	private JPanel pnNorth, pnCenter, pnSouth;
	private JButton btnTim, btnThem, btnXoaTrang, btnXoa, btnLuu;
	private ButtonGroup group;
	private DefaultTableModel modelNhanVien;
	private JTable tableNV;
	private NhanVien_Collection listNV;

	private String url = "D:\\HK2-NAM2\\LAPTRINHHSK\\xml\\nhanvien.xml";// file lưu trữ thông tin
	private boolean status; // Hàm kiểm tra dữ liệu đã lưu vào file hay chưa

	public GUI_ThongTinNhanVien() {
		// listNV = new NhanVien_Collection();
		setTitle("^-^");// Tạo tên của giao diện
		setSize(600, 400);// Tạo kích thước giao diện
		setDefaultCloseOperation(EXIT_ON_CLOSE);// để đóng chương trình chạy
		setLocationRelativeTo(null);// căn giữa cửa sổ chương trình
		setResizable(false);// điều chỉnh co giãn giao diện
		createGUIThongTinNhanVien();
		setVisible(true);// hiện JFrame
	}

	private void createGUIThongTinNhanVien() {
		// Tạo phần tiêu đề
		pnNorth = new JPanel();
		lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");// Tên tiêu đề
		lblTieuDe.setForeground(Color.BLUE);// màu chữ
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));// kiểu chữ, font chữ, kích thức chữ
		pnNorth.add(lblTieuDe);//thêm label tiêu đề vào panel Nouth
		pnNorth.setBackground(Color.red);// màu nền tiêu đề
		add(pnNorth, BorderLayout.NORTH);//thêm panel vào vùng north của borderlayout

		// Tạo phần nhập thông tin nhân viên
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnNhap = new JPanel();
		Box b = Box.createVerticalBox();//tạo ra một đối tượng Box b dạng hộp chứa các thành phần con theo chiều dọc
		Box b1 = Box.createHorizontalBox();//tạo ra một đối tượng Box dạng hộp chứa các thành phần con theo chiều ngang
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();

		lblMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField(50);
		b1.add(lblMaNV);
		b1.add(txtMaNV);
		b.add(b1);
		b.add(Box.createVerticalStrut(5));// để tạo ra một phần trống dọc có chiều cao là 5

		lblHo = new JLabel("Họ: ");
		txtHo = new JTextField();
		lblTenNV = new JLabel("Tên nhân viên: ");
		txtTenNV = new JTextField();
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());// lấy kích thức của lblMaNV đặt làm kích thước lblHo
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTenNV);
		b2.add(txtTenNV);
		b.add(b2);
		b.add(Box.createVerticalStrut(5));

		lblTuoi = new JLabel("Tuổi: ");
		txtTuoi = new JTextField();
		lblPhai = new JLabel("Phái: ");
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		radNam.setEnabled(true);//phương thức này được sử dụng để bật trạng thái sẵn sàng của đối tượng cho phép người dùng chọn hoặc bỏ chọn
		group = new ButtonGroup();
		group.add(radNam);
		group.add(radNu);
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(Box.createHorizontalStrut(20));// để tạo ra một phần trống ngang kích thước 20px
		b3.add(radNam);
		b3.add(radNu);
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		lblTuoi.setPreferredSize(lblHo.getPreferredSize());

		lblTienLuong = new JLabel("Tiền lương: ");
		txtTienLuong = new JTextField();
		b4.add(lblTienLuong);
		b4.add(txtTienLuong);
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		b.add(b4);
		pnNhap.add(b);
		pnCenter.add(pnNhap);
		add(pnCenter, BorderLayout.CENTER);

		taoBang();

		pnSouth = new JPanel();
		JSplitPane slipt = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnSouth.add(slipt);
		JPanel pnTimKiem = new JPanel();
		lblNhapSoCantim = new JLabel("Nhập số cần tìm");
		txtNhapSoCanTim = new JTextField(9);
		btnTim = new JButton("Tìm");
		pnTimKiem.add(lblNhapSoCantim);
		pnTimKiem.add(txtNhapSoCanTim);
		pnTimKiem.add(btnTim);
		slipt.add(pnTimKiem);
		JPanel pnButton = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		pnButton.add(Box.createHorizontalStrut(4));
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		pnButton.add(btnXoa);
		pnButton.add(btnLuu);
		slipt.add(pnButton);
		pnButton.add(Box.createHorizontalStrut(4));
		// pnButton.add(Box.createRigidArea(new Dimension(5, 0)));
		add(pnSouth, BorderLayout.SOUTH);
		Border cnBorder = BorderFactory.createLineBorder(Color.gray);
		pnTimKiem.setBorder(cnBorder);
		pnButton.setBorder(cnBorder);

		// Thêm sự kiện
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		radNam.addActionListener(this);
		radNu.addActionListener(this);
		addWindowListener(this);
		tableNV.addMouseListener(this);
	}

	// tạo phần hiển thị dữ liệu
	private void taoBang() {
		JPanel pnTable = new JPanel();
		modelNhanVien = new DefaultTableModel();// Tạo để quản lý dữ liệu trong bảng
		tableNV = new JTable(modelNhanVien);// Tạo bảng
		modelNhanVien.addColumn("Mã NV");// Thêm dữ liệu vào bảng
		modelNhanVien.addColumn("Họ");
		modelNhanVien.addColumn("Tên");
		modelNhanVien.addColumn("Phái");
		modelNhanVien.addColumn("Tuổi");
		modelNhanVien.addColumn("Tiền lương");
		TableColumn phaicolumn = tableNV.getColumnModel().getColumn(4);// Trả về dữ liệu thử 4 trong bảng
		String[] options = { "Nam", "Nữ" };
		JComboBox<String> comboBox = new JComboBox<>(options);// Dùng để chứ 2 tùy chọn nam và nữ
		phaicolumn.setCellEditor(new DefaultCellEditor(comboBox));// dùng để chỉnh sửa ô dữ liệu

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);// dùng để canh lề phải
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// dùng để canh giữa
		pnTable.add(tableNV);
		// Căn lề giữa cho mã nhân viên và căn lề phải cho phái, tuổi, tiền lương
		tableNV.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tableNV.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		tableNV.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		tableNV.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

		JScrollPane sp = new JScrollPane(tableNV, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);// tạo thanh cuộn dọc và ngang
		sp.setPreferredSize(new Dimension(650, 250));//đặt kích thước hiển thị của thanh cuộn theo chiều ngang 650 và dọc 250
		pnCenter.add(sp);
		tableNV.setBackground(Color.pink);//thêm màu nền cho bảng table
		listNV = new NhanVien_Collection();
		themdulieuAuto();
		ArrayListToModel();
	}

	// Xóa tất cả dữ liệu DefaultTableModel
	private void ClearDataModel() {
		DefaultTableModel temp = (DefaultTableModel) tableNV.getModel();
		temp.getDataVector().removeAllElements();
	}

	// Xóa và đặt lại các ô nhập
	public void ClearTXT() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTenNV.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		group.clearSelection();//xóa bỏ lựa chọn được chọn trên các nút radio
		txtMaNV.setEditable(true);
	}

	// Đưa danh sách nhân viên từ ArrayList vào Model
	public void ArrayListToModel() {
		for (int i = 0; i < listNV.getSize(); i++) {
			NhanVien nv = listNV.getElement(i);// mỗi lần lặp đối tượng NhanVien được lấy ra từ danh sách listNV và đưa
												// vào mảng data
			String gioitinh;
			if (nv.getPhai())// giới tính của đối tượng sẽ chuyển thành chuỗi và nếu true là Nam, false là Nữ
				gioitinh = "Nam";
			else
				gioitinh = "Nữ";

			Object[] data = { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), gioitinh, nv.getLuong() };
			modelNhanVien.addRow(data);// đưa mảng data vào model
		}
	}

	public static void main(String[] args) {
		new GUI_ThongTinNhanVien();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableNV.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());// lấy dữ liệu tại hàng 1 cột 0 và dùng toString để
																		// chuyển đổi thành kiểu chuỗi
		txtMaNV.setEditable(false);// không cho người dùng chỉnh sửa phần mã nhân viên
		txtHo.setText(modelNhanVien.getValueAt(row, 1).toString());
		txtTenNV.setText(modelNhanVien.getValueAt(row, 2).toString());
		txtTuoi.setText(modelNhanVien.getValueAt(row, 3).toString());
		group.clearSelection();
		radNu.setSelected(modelNhanVien.getValueAt(row, 4).toString() == "Nữ" ? true : false);
		radNam.setSelected(modelNhanVien.getValueAt(row, 4).toString() == "Nam" ? true : false);
		txtTienLuong.setText(modelNhanVien.getValueAt(row, 5).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// Xử lý sự kiện tắt cửa sổ
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (status)// nếu biến status là true cửa sổ sẽ đóng
			System.exit(0);
		if (JOptionPane.showConfirmDialog(this, "Bạn có muốn lưu lại trước khi rời khỏi đây?", "Cảnh báo lưu",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)// Ngược lại sẽ hiển thị hộp thoại hỏi người
																		// dùng có muốn lưu tập tin không
			createFile();
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		// Sự kiện thêm nhân viên
		if (o.equals(btnThem)) {
			try {
				String ma = txtMaNV.getText();
				String ho = txtHo.getText();
				String ten = txtTenNV.getText();
				int tuoi = Integer.parseInt(txtTuoi.getText());
				Boolean phai = radNam.isSelected();
				double luong = Double.parseDouble(txtTienLuong.getText());

				NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong);
				if (!listNV.themNhanVien(nv)) {
					JOptionPane.showMessageDialog(this, "Trùng mã nhân viên");// hiển thị hộp thoại thông báo
				} else {
					String gioitinh;
					if (radNam.isSelected())// kiểm tra nút được chọn không
						gioitinh = "Nam";
					else
						gioitinh = "Nữ";

					Object data[] = { txtMaNV.getText(), txtHo.getText(), txtTenNV.getText(), txtTuoi.getText(),
							gioitinh, txtTienLuong.getText() };
					modelNhanVien.addRow(data);// đưa mảng data vào model
					ClearTXT();
					txtMaNV.requestFocus();

					ClearDataModel();
					ArrayListToModel();

					status = false;// Chưa lưu vào file
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Mã nhân viên bắt buộc.", "Thông báo", 2);
				txtMaNV.requestFocus();

			}
		}
		// Sự kiện xóa
		/**
		 * Nếu người dùng chọn một dòng, hộp thoại hiển thị để yêu cầu người dùng xác
		 * nhận việc xóa. Nếu người dùng đồng ý xóa, chương trình sẽ xóa nhân viên được
		 * chọn sẽ xóa danh sách và bảng hiển thị, và một hộp thoại thông báo sẽ xuất
		 * hiện để thông báo rằng xóa thành công. Nếu xóa không thành công, một hộp
		 * thoại thông báo sẽ xuất hiện để thông báo lỗi.
		 */
		if (o == btnXoa) {
			if (tableNV.getSelectedRow() == -1)// nếu không dòng nào được chọn sẽ thông báo
				JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng cần xóa.", "Thông báo", 2);
			else {
				if (tableNV.getSelectedRowCount() == 1) {//trả về số hàng được chọn trong bảng, nếu số hàng được chọn bằng 1

					if (JOptionPane.showConfirmDialog(this,
							"Bạn có chắc chắn sẽ xóa nhân viên có mã số "
									+ tableNV.getValueAt(tableNV.getSelectedRow(), 0) + " này không?",
							"Cảnh báo xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

						NhanVien nv = listNV.getElement(tableNV.getSelectedRow());
						if (listNV.xoaNhanVien(nv.getMaNV())) {
							modelNhanVien.removeRow(tableNV.getSelectedRow());// Xóa một nhân viên
							JOptionPane.showMessageDialog(this, "Xóa thành công!");

							status = false;// Chưa lưu vào file
						} else
							JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Thông báo", 0);
					}

				} else
					JOptionPane.showMessageDialog(this, "Bạn chỉ được chọn một dòng để xóa.", "Thông báo", 2);
			}
		}
		// Sự kiện xóa trắng
		/**
		 * nội dung trong nhập liệu sẽ được xóa đi, và một hộp thoại hiển thị để người
		 * dùng xác nhận việc xóa toàn bộ thông tin nhân viên. Nếu người dùng đồng ý,
		 * tất cả các dòng dữ liệu về nhân viên trong bảng sẽ được xóa đi.
		 */
		if (o.equals(btnXoaTrang)) {
			txtMaNV.setText("");
			txtHo.setText("");
			txtTenNV.setText("");
			txtTuoi.setText("");
			txtTienLuong.setText("");
			txtTuoi.setText("");
			txtMaNV.requestFocus();
			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn sẽ xóa toàn bộ thông tin không?", "Cảnh báo xóa",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				for (int n = tableNV.getRowCount(); n > 0; n--) {
					modelNhanVien.removeRow(n - 1);
				}
			}
		}
		// Sự kiên tìm
		/**
		 * Nếu chuỗi tìm kiếm không rỗng, thực hiện tìm kiếm trong danh sách nhân viên.
		 * Nếu tìm thấy, xóa toàn bộ dữ liệu trong bảng và thêm dòng dữ liệu tìm được
		 * vào bảng. Nếu không tìm thấy, hiển thị thông báo. Nếu dữ liệu nhập không hợp
		 * lệ, hiển thị thông báo và chọn toàn bộ dữ liệu đã nhập để sửa lại.
		 * 
		 * Nếu chuỗi tìm kiếm rỗng, xóa toàn bộ dữ liệu trong bảng và hiển thị lại toàn
		 * bộ dữ liệu trong danh sách nhân viên.
		 */
		if (o == btnTim) {

			String str_search = txtNhapSoCanTim.getText();
			if (str_search != null && str_search.trim().length() > 0) {
				try {
					NhanVien nv = listNV.timkiem(str_search);
					if (nv != null) {
						ClearDataModel();

						String gioitinh;
						if (nv.getPhai())
							gioitinh = "Nam";
						else
							gioitinh = "Nữ";

						Object data[] = { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), gioitinh,
								nv.getLuong() };
						modelNhanVien.addRow(data);

					} else {
						JOptionPane.showMessageDialog(this, "Không tìm thấy", "Thông báo", 1);
						return;
					}

				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ", "Thông báo", 0);
					txtNhapSoCanTim.selectAll();
					txtNhapSoCanTim.requestFocus();
				}
			} else {
				ClearDataModel();
				ArrayListToModel();
			}

		}
		// Sự kiện lưu
		/**
		 * Khi được nhấn, phương thức sẽ gọi hàm "createFile()" để tạo ra một file và
		 * lưu thông tin nhân viên vào file đó. Sau đó, biến "status" sẽ được gán giá
		 * trị "true" để đánh dấu rằng đã lưu vào file và thông báo cho người dùng bằng
		 * hộp thoại "Đã lưu file thành công!".
		 */
		if (o == btnLuu) {

			createFile();
			status = true;
			JOptionPane.showMessageDialog(this, "Đã lưu file thành công!", "Thông báo", 1);

		}
	}

	// Nếu như không tồn tại file đã lưu trữ thì sẽ tự động lấy 4 nhân viên
	public void themdulieuAuto() {
		if (checkFile()) {
			readFile();
			status = true;
		} else {
			NhanVien nv1 = new NhanVien("1111", "Lê", "Văn Huy", 26, true, 4500000);
			NhanVien nv2 = new NhanVien("2222", "Trần", "Anh Tú", 21, true, 500000);
			NhanVien nv3 = new NhanVien("3333", "Trần", "Thị Hoa", 25, false, 2500000);
			NhanVien nv4 = new NhanVien("4444", "Lê", "Kim Quỳnh", 29, false, 4000000);

			listNV.themNhanVien(nv1);
			listNV.themNhanVien(nv2);
			listNV.themNhanVien(nv3);
			listNV.themNhanVien(nv4);

		}

	}

	// Kiểm tra xem file lưu trữ dữ liệu đã có hay chưa
	public boolean checkFile() {
		if (new File(url).exists())//kiểm tra sư tồn tại của tập ti n
			return true;
		return false;
	}

	// Đọc file
	public boolean readFile() {
		try {
			File inputFile = new File(url);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// Đọc tất cả các phần tử personal
			NodeList nodeListPersonal = doc.getElementsByTagName("personal");

			// Duyệt tất cả phần tử personal
			for (int i = 0; i < nodeListPersonal.getLength(); i++) {

				// Đọc các thuộc tính của Personal
				Node nNode = nodeListPersonal.item(i);
				NhanVien nv = new NhanVien();

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					nv.setMaNV(eElement.getElementsByTagName("ma").item(0).getTextContent());
					nv.setHoNV(eElement.getElementsByTagName("ho").item(0).getTextContent());
					nv.setTenNV(eElement.getElementsByTagName("ten").item(0).getTextContent());
					nv.setTuoi(Integer.parseInt(eElement.getElementsByTagName("tuoi").item(0).getTextContent()));
					nv.setPhai(
							Boolean.parseBoolean(eElement.getElementsByTagName("gioitinh").item(0).getTextContent()));
					nv.setLuong(Double.parseDouble(eElement.getElementsByTagName("luong").item(0).getTextContent()));
				}

				listNV.themNhanVien(nv);

			}

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	// Tạo file ghi đè
	public boolean createFile() {
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// Tạo phần tử gốc có tên class
			Element rootElement = doc.createElement("class");

			// Thêm thuộc tính total vào thẻ class
			doc.appendChild(rootElement);
			Attr tongNV = doc.createAttribute("totalPersonal");
			tongNV.setValue(String.valueOf(this.getSize()));
			rootElement.setAttributeNode(tongNV);

			for (NhanVien nv : listNV.getDsNV()) {

				// Tạo phần tử personal
				Element personal = doc.createElement("personal");
				rootElement.appendChild(personal);

				// Tạo thuộc tính mã cho personal
				Element ma = doc.createElement("ma");
				ma.appendChild(doc.createTextNode(nv.getMaNV()));
				personal.appendChild(ma);

				// Tạo thuộc tính họ cho personal
				Element ho = doc.createElement("ho");
				ho.appendChild(doc.createTextNode(nv.getHoNV()));
				personal.appendChild(ho);

				// Tạo thuộc tính tên cho personal
				Element ten = doc.createElement("ten");
				ten.appendChild(doc.createTextNode(nv.getTenNV()));
				personal.appendChild(ten);

				// Tạo thuộc tính tuổi cho personal
				Element tuoi = doc.createElement("tuoi");
				tuoi.appendChild(doc.createTextNode(String.valueOf(nv.getTuoi())));
				personal.appendChild(tuoi);

				// Tạo thuộc tính giới tính cho personal
				Element gioitinh = doc.createElement("gioitinh");
				gioitinh.appendChild(doc.createTextNode(String.valueOf(nv.getPhai())));
				personal.appendChild(gioitinh);

				// Tạo thuộc tính lương cho personal
				Element luong = doc.createElement("luong");
				luong.appendChild(doc.createTextNode(String.valueOf(nv.getLuong())));
				personal.appendChild(luong);
			}
			// Ghi đè nội dung sang file xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(url));
			transformer.transform(source, result);

			status = true;

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
