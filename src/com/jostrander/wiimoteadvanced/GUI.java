package com.jostrander.wiimoteadvanced;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class GUI {
	public static JFrame gui = new JFrame();
	public static JTabbedPane tabs = new JTabbedPane();
	public static JPanel tab1 = new JPanel();
	public static JPanel tab2 = new JPanel();
	public static JTextField batterytf = new JTextField();
	public static JTextField connectedtf = new JTextField();
	public static JComboBox<String> mode = new JComboBox<String>();
	
	public static void init() {
		gui.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		gui.setSize(300,300);
		gui.setResizable(false);
		gui.setTitle("WiiMoteAdvanced");
		/*
		 *  TAB 1 [BASICS]
		 */
		tab1.setLayout(null);
		JLabel connected = new JLabel("Wiimote Connected:");
		connected.setSize(200,20);
		connected.setBounds(5, 5, connected.getWidth(), connected.getHeight());
		JLabel battery = new JLabel("Battery Level:");
		battery.setSize(100, 20);
		battery.setBounds(5, 35, battery.getWidth(), battery.getHeight());

		connectedtf.setEnabled(false);
		connectedtf.setSize(120, 20);
		connectedtf.setBounds(150, 5, connectedtf.getWidth(), connectedtf.getHeight());
		
		batterytf.setEnabled(false);
		batterytf.setSize(120,20);
		batterytf.setBounds(150, 35, batterytf.getWidth(), batterytf.getHeight());
		
		mode.setSize(120,20);
		mode.setLocation(150, 65);
		mode.addItem("WiiMouse");
		mode.addItem("Whiteboard");
		mode.addItem("Airmouse");
		
		tab1.add(connected);
		tab1.add(connectedtf);
		tab1.add(batterytf);
		tab1.add(battery);
		tab1.add(mode);
		tabs.addTab("Basics", tab1);
		
		/*
		 * 	TAB 2 [ADVANCED]
		 */
		tabs.addTab("Advanced", tab2);
		gui.setContentPane(tabs);		
	}
	public void showOptions() {
		gui.setVisible(true);
	}
} 
