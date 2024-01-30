package com.mycompany.invmgtsys.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

// import io.vavr.collection.RedBlackTree.Color;

public class InvMgtScreen extends JFrame {
    public static void main(String[] args) {
        new InvMgtScreen();
    }

    public InvMgtScreen() {
        setTitle("Inventory Management");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenuBar();
        createToolBar();

        JPanel panel = new JPanel();
        panel.setSize(800, 700);
        panel.setBackground(Color.gray);
        add(panel, BorderLayout.CENTER);
        setVisible(true);

    }

    public void createMenuBar() {
        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");

        ImageIcon icon = new ImageIcon("InvMgtSys/src/resources/images/close.png");

        JMenuItem fileClose = new JMenuItem("Close", icon);
        fileClose.setToolTipText("Close the inventory App");

        fileClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(fileClose);

        JMenu view = new JMenu("View");

        JMenuItem fullScreen = new JMenuItem("Full Screen");
        fullScreen.setToolTipText("Expand to full screen mode");
        view.add(fullScreen);

        menubar.add(file);
        menubar.add(view);

        setJMenuBar(menubar);

    }

    public void createToolBar() {
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);

        ImageIcon iconWarehouses = new ImageIcon(new ImageIcon("InvMgtSys/src/resources/images/warehouse.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        ImageIcon iconAddWarehouse = new ImageIcon(new ImageIcon("InvMgtSys/src/resources/images/warehouseAdd.png").getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JButton warehousesB = new JButton(iconWarehouses);
        JButton addWarehousesB = new JButton(iconAddWarehouse);

        toolbar.add(warehousesB);
        toolbar.add(addWarehousesB);

        add(toolbar, BorderLayout.WEST);

    }
}
