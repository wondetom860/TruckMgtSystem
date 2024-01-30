/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.utility;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.*;

import java.awt.event.MouseEvent;

/**
 *
 * @author wonde
 */
public class SimpleGui extends JFrame {

    private Toolkit toolkit;
    private JPopupMenu menu;
    // private Toolkit toolkit;

    public SimpleGui() {
        // setSize(600, 700);
        // setTitle("Simple Gui");
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        // toolkit = getToolkit();
        // Dimension size = toolkit.getScreenSize();
        // setLocation(size.width / 2 - getWidth() / 2,
        // size.height / 2 - getHeight() / 2);

        // JPanel panel = new JPanel();
        // getContentPane().add(panel);
        // panel.setLayout(null);

        // JButton beep = new JButton("Beep");
        // beep.setBounds(150, 60, 80, 30);
        // beep.addActionListener((ActionListener) new ActionListener() {
        // public void actionPerformed(ActionEvent event) {
        // toolkit.beep();
        // }
        // });

        // JButton close = new JButton("Close");
        // close.setBounds(50, 60, 80, 30);
        // close.setToolTipText("Click here to close the window");
        // close.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent event) {
        // System.exit(0);
        // }
        // });

        // panel.add(beep);
        // panel.add(close);

        // Menu bar::

        // setTitle("JMenuBar");

        // JMenuBar menubar = new JMenuBar();
        // ImageIcon icon = new ImageIcon("exit.png");

        // JMenu file = new JMenu("File");
        // file.setMnemonic(KeyEvent.VK_F);

        // JMenuItem fileClose = new JMenuItem("Close", icon);
        // fileClose.setMnemonic(KeyEvent.VK_C);
        // fileClose.setToolTipText("Exit application");
        // fileClose.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent event) {
        // System.exit(0);
        // }
        // });

        // file.add(fileClose);

        // menubar.add(file);

        // setJMenuBar(menubar);
        // setSize(250, 200);
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setVisible(true);

        // setTitle("Simple Submenu");

        // JMenuBar menubar = new JMenuBar();

        // ImageIcon iconNew = new ImageIcon(
        // new
        // ImageIcon("InvMgtSys/src/resources/images/new.png").getImage().getScaledInstance(20,
        // 20,
        // Image.SCALE_SMOOTH));
        // // ImageIcon iconImport = new ImageIcon(
        // // new
        // ImageIcon("InvMgtSys/src/resources/images/import.png").getImage().getScaledInstance(20,
        // 20,
        // // Image.SCALE_SMOOTH));

        // ImageIcon iconOpen = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/open.png").getImage()
        // .getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        // ImageIcon iconSave = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/save.png").getImage()
        // .getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        // ImageIcon iconClose = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/close.png").getImage()
        // .getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        // JMenu file = new JMenu("File");
        // file.setMnemonic(KeyEvent.VK_F);

        // JMenu imp = new JMenu("Import");
        // imp.setMnemonic(KeyEvent.VK_M);

        // JMenuItem newsf = new JMenuItem("Import newsfeed list...");
        // JMenuItem bookm = new JMenuItem("Import bookmarks...");
        // JMenuItem mail = new JMenuItem("Import mail...");
        // imp.add(newsf);
        // imp.add(bookm);
        // imp.add(mail);

        // JMenuItem fileNew = new JMenuItem("New", iconNew);
        // fileNew.setMnemonic(KeyEvent.VK_N);

        // JMenuItem fileOpen = new JMenuItem("Open", iconOpen);
        // fileNew.setMnemonic(KeyEvent.VK_O);

        // JMenuItem fileSave = new JMenuItem("Save", iconSave);
        // fileSave.setMnemonic(KeyEvent.VK_S);

        // JMenuItem fileClose = new JMenuItem("Close", iconClose);
        // fileClose.setMnemonic(KeyEvent.VK_C);
        // fileClose.setToolTipText("Exit application");
        // fileClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
        // ActionEvent.CTRL_MASK));
        // fileClose.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent event) {
        // System.exit(0);
        // }
        // });

        // file.add(fileNew);
        // file.add(fileOpen);
        // file.add(fileSave);

        // file.addSeparator();
        // file.add(imp);

        // file.addSeparator();

        // file.add(fileClose);

        // menubar.add(file);
        // setJMenuBar(menubar);
        // setSize(560, 450);
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setVisible(true);

        // // popup window
        // JFrame frame = new JFrame("Popup Menu Example");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // toolkit = frame.getToolkit();

        // menu = new JPopupMenu();

        // JMenuItem menuItemBeep = new JMenuItem("Beep");
        // menuItemBeep.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // toolkit.beep();
        // }
        // });

        // menu.add(menuItemBeep);

        // JMenuItem menuItemClose = new JMenuItem("Close");
        // menuItemClose.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // System.exit(0);
        // }
        // });
        // menu.add(menuItemClose);

        // frame.addMouseListener((MouseListener) new MouseAdapter() {
        // public void mouseReleased(MouseEvent e) {
        // if (e.getButton() == 3) {// 3 indicates right click
        // menu.show(e.getComponent(), e.getX(), e.getY());
        // }
        // }
        // });

        // frame.setSize(250, 200);
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);

        // // JToolBar
        // setTitle("SimpleToolbar");

        // JMenuBar menubar = new JMenuBar();

        // JMenu file = new JMenu("File");

        // menubar.add(file);

        // setJMenuBar(menubar);

        // JToolBar toolbar = new JToolBar();

        // ImageIcon icon = new ImageIcon("InvMgtSys/src/resources/images/close.png");
        // JButton exit = new JButton(icon);
        // toolbar.add(exit);

        // exit.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent event) {
        // System.exit(0);
        // }
        // });

        // add(toolbar, BorderLayout.NORTH);
        // setSize(300, 200);
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setVisible(true);

        // // Multiple toolbars-horizontal
        // setTitle("Toolbars");
        // JToolBar toolbar1 = new JToolBar();
        // JToolBar toolbar2 = new JToolBar();

        // JPanel panel = new JPanel();
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // ImageIcon newi = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/new.png").getImage().getScaledInstance(30,
        // 30, Image.SCALE_SMOOTH));
        // ImageIcon open = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/open.png").getImage().getScaledInstance(30,
        // 30, Image.SCALE_SMOOTH));
        // ImageIcon save = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/save.png").getImage().getScaledInstance(30,
        // 30, Image.SCALE_SMOOTH));
        // ImageIcon exit = new ImageIcon(new
        // ImageIcon("InvMgtSys/src/resources/images/close.png").getImage().getScaledInstance(30,
        // 30, Image.SCALE_SMOOTH));

        // JButton newb = new JButton(newi);
        // JButton openb = new JButton(open);
        // JButton saveb = new JButton(save);
        // toolbar1.add(newb);
        // toolbar1.add(openb);
        // toolbar1.add(saveb);
        // toolbar1.setAlignmentX(0);

        // JButton exitb = new JButton(exit);
        // toolbar2.add(exitb);
        // toolbar2.setAlignmentX(0);

        // exitb.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent event) {
        // System.exit(0);
        // }
        // });

        // panel.add(toolbar1);
        // panel.add(toolbar2);

        // add(panel, BorderLayout.NORTH);

        // setSize(600, 700);
        // setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setVisible(true);

        setTitle("Vertical toolbar");
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        ImageIcon iconNew = new ImageIcon(new ImageIcon("InvMgtSys/src/resources/images/new.png").getImage()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        ImageIcon iconOpen = new ImageIcon(new ImageIcon("InvMgtSys/src/resources/images/open.png").getImage()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        ImageIcon iconSave = new ImageIcon(new ImageIcon("InvMgtSys/src/resources/images/save.png").getImage()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        ImageIcon iconClose = new ImageIcon(new ImageIcon("InvMgtSys/src/resources/images/close.png").getImage()
                .getScaledInstance(40, 40, Image.SCALE_SMOOTH));

        JButton newb = new JButton(iconNew);
        JButton openb = new JButton(iconOpen);
        JButton saveb = new JButton(iconSave);
        JButton closeb = new JButton(iconClose);
        closeb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        toolbar.add(newb);
        toolbar.add(openb);
        toolbar.add(saveb);
        toolbar.add(closeb);

        add(toolbar, BorderLayout.WEST);

        setSize(650, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleGui();
        // sgui.setVisible(true);
    }
}
