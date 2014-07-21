package com.wsoft.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.wsoft.controller.BaseCtrl;
import com.wsoft.controller.CtrlCache;
import com.wsoft.model.HibernateProxy;

public class Main implements ActionListener {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuItem servicesItem;
	private JMenuItem materialsItem;
	private JMenuItem interventionsItem;
	private JMenuItem diagnosisItem;
	private JButton patientsBtn;
	private JButton appointmentsBtn;
	private JButton doctorsBtn;
	private JButton servicesBtn;
	private JMenu registriesMenu;
	private static JDesktopPane desktop;
	private static int xSize;
	private static int ySize;
	private int sizeDecrementer = 75;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final URL url = Main.class.getClassLoader().getResource("dentist.gif");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HibernateProxy.session();
					HibernateProxy.closeSession();
					Main window = new Main();
					Toolkit tk = Toolkit.getDefaultToolkit();
					window.xSize = ((int) tk.getScreenSize().getWidth())
							- window.sizeDecrementer;
					window.ySize = ((int) tk.getScreenSize().getHeight())
							- window.sizeDecrementer;
					window.frame.setSize(window.xSize, window.ySize);
					Dimension dimension = Toolkit.getDefaultToolkit()
							.getScreenSize();
					int x = (int) ((dimension.getWidth() - window.xSize) / 2);
					int y = (int) ((dimension.getHeight() - window.ySize) / 2);

					Image image = window.frame.getToolkit().createImage(url);
					window.desktop = new ImagePanel(image, 350, 350);

					window.frame
							.setTitle("Stomatolo\u0161ka Ordinacija Dr. Idrizovi\u0107");

					ImageIcon appImage = new ImageIcon(ImageIO.read(Main.class
							.getResource("/ZaVadjenje.bmp")));
					window.frame.setIconImage(appImage.getImage());

					window.frame.setContentPane(window.desktop);

					window.frame.setLocation(x, y);
					window.frame.setVisible(true);
					window.frame.setExtendedState(window.frame
							.getExtendedState() | JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 879, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		registriesMenu = new JMenu("Registri");
		registriesMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		registriesMenu.setIcon(new ImageIcon(Main.class
				.getResource("/icons/integration_note.png")));
		menuBar.add(registriesMenu);

		servicesItem = new JMenuItem("Registar usluga");
		servicesItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		servicesItem.setIcon(new ImageIcon(Main.class
				.getResource("/icons/integration_note.png")));
		servicesItem.addActionListener(this);
		servicesItem.setName("com.wsoft.view.ServicesFrame");
		registriesMenu.add(servicesItem);

		materialsItem = new JMenuItem("Registar materijala");
		materialsItem.setName("com.wsoft.view.MaterialsFrame");
		materialsItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		materialsItem.setIcon(new ImageIcon(Main.class
				.getResource("/icons/integration_note.png")));
		materialsItem.addActionListener(this);
		registriesMenu.add(materialsItem);

		interventionsItem = new JMenuItem("Registar intervencija");
		interventionsItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		interventionsItem.setIcon(new ImageIcon(Main.class
				.getResource("/icons/integration_note.png")));
		interventionsItem.addActionListener(this);
		registriesMenu.add(interventionsItem);

		diagnosisItem = new JMenuItem("Registar dijagnoza");
		diagnosisItem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		diagnosisItem.setIcon(new ImageIcon(Main.class
				.getResource("/icons/integration_note.png")));
		diagnosisItem.addActionListener(this);
		registriesMenu.add(diagnosisItem);

		patientsBtn = new JButton("Evidencija pacijenata");
		patientsBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		patientsBtn.setIcon(new ImageIcon(Main.class
				.getResource("/icons/folder-open.png")));
		patientsBtn.setName("com.wsoft.view.PatientFrame");
		patientsBtn.addActionListener(this);
		menuBar.add(patientsBtn);

		appointmentsBtn = new JButton("Zakazivanje pregleda");
		appointmentsBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		appointmentsBtn.setIcon(new ImageIcon(Main.class
				.getResource("/icons/pencil.png")));
		appointmentsBtn.addActionListener(this);
		menuBar.add(appointmentsBtn);

		doctorsBtn = new JButton("Evidencija stomatologa");
		doctorsBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doctorsBtn.setIcon(new ImageIcon(Main.class
				.getResource("/icons/user.png")));
		doctorsBtn.addActionListener(this);
		menuBar.add(doctorsBtn);

		servicesBtn = new JButton("Izvr\u0161ene usluge");
		servicesBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		servicesBtn.setIcon(new ImageIcon(Main.class
				.getResource("/icons/credit.png")));
		servicesBtn.setName("com.wsoft.view.ExecutedServices");
		servicesBtn.addActionListener(this);
		menuBar.add(servicesBtn);
	}

	public static boolean checkIfInternalOpened(java.lang.Class frameClass)
			throws PropertyVetoException {
		for (JInternalFrame frame : Main.desktop.getAllFrames()) {
			if (frame.getClass().getName().equals(frameClass.getName())) {
				frame.setSelected(true);
				return true;
			}
		}
		return false;
	}

	public static void openFrame(java.lang.Class frameClass, int minusX,
			int minusY) {
		try {
			if (!checkIfInternalOpened(frameClass)) {
				BaseFrame internalFrame = (BaseFrame) frameClass.newInstance();
				List<BaseCtrl> ctrls = CtrlCache.getViewCtrls(internalFrame);
				for (BaseCtrl ctrl : ctrls) {
					ctrl.loadView();
				}
				internalFrame.setMaximizable(true);
				internalFrame.pack();
				internalFrame.setClosable(true);
				internalFrame.setResizable(true);
				internalFrame.setSize(Main.xSize - minusX, Main.ySize - minusY);
				ImageIcon appImage = new ImageIcon(ImageIO.read(Main.class
						.getResource("/ZaVadjenje.bmp")));
				internalFrame.setFrameIcon(appImage);
				Dimension desktopSize = Main.desktop.getSize();
				Dimension jInternalFrameSize = internalFrame.getSize();
				int width = (desktopSize.width - jInternalFrameSize.width) / 2;
				int height = (desktopSize.height - jInternalFrameSize.height) / 2;
				internalFrame.setLocation(width, height);
				Main.desktop.add(internalFrame);
				internalFrame.setVisible(true);
				internalFrame.setSelected(true);
			}
		} catch (InstantiationException | IllegalAccessException
				| PropertyVetoException | IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AbstractButton btnSource = null;
		Object source = e.getSource();
		if (source instanceof AbstractButton) {
			btnSource = (AbstractButton) source;
			String internalFrameClass = btnSource.getName();
			if (internalFrameClass != null) {
				try {
					Main.openFrame(Class.forName(internalFrameClass), 15, 70);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
