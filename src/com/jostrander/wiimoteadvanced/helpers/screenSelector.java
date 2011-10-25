package com.jostrander.wiimoteadvanced.helpers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.jostrander.wiimoteadvanced.WiiMoteAdvanced;
import com.jostrander.wiimoteadvanced.runtimePrefs;

@SuppressWarnings("serial")
public class screenSelector extends JDialog implements MouseListener {

	private int thisid;
	private Rectangle r;
	JDialog hint = new JDialog();
	public screenSelector(int id, Rectangle r) {
		try {
			this.r=r;
			this.thisid=id;
			JLabel label = new JLabel("<html>Device " + (id+1) + "<br>Click this screen to select it.</html>");
			label.setForeground(new Color(255, 255, 255));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font(null, 0, 30));
			hint.setUndecorated(true);
			hint.setAlwaysOnTop(true);
			hint.setBackground(new Color(0, 0, 0, 128));
			hint.setLocation(r.x, r.y);
			hint.setSize(new Dimension(r.width, r.height));
			hint.add(label);
			hint.setVisible(true);
			hint.addMouseListener(this);
			WiiMoteAdvanced.screens.add(hint);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
			runtimePrefs.Device=thisid;
			runtimePrefs.screenDims = r;
			Iterator<JDialog> i = WiiMoteAdvanced.screens.iterator();
			while (i.hasNext()) {
				i.next().setVisible(false);
			}
			WiiMoteAdvanced.screens = null;
			JOptionPane.showMessageDialog(null, "You chose screen "+(runtimePrefs.Device+1));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
