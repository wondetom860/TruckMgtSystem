package com.mycompany.invmgtsys.services;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

// import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.mycompany.invmgtsys.models.Warehouse;
import com.nimbusds.jose.util.Container;

import java.util.ArrayList;
import java.util.List;

// import io.vavr.collection.RedBlackTree.Color;

public class WarehouseGui extends JFrame implements ActionListener {
    private List<JFrame> warehouseFrames = new ArrayList<>();
    private java.awt.Container c;
    private JLabel title;
    private JLabel location;
    private JTextField tlocation;
    private JLabel currentQuantity;
    private JTextField tcurrentQuantity;
    private JLabel maxCapacity;
    private JTextField tmaxCapacity;

    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JButton showListBtn;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    public static void main(String[] args) throws SQLException {
        new WarehouseGui();
    }

    public WarehouseGui() throws SQLException {
        // showWithTable();
        // return;

        setTitle("Create Warehouse Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("New Warehouse");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        location = new JLabel("Location");
        location.setFont(new Font("Arial", Font.PLAIN, 20));
        location.setSize(150, 20);
        location.setLocation(40, 100);
        c.add(location);

        tlocation = new JTextField();
        tlocation.setFont(new Font("Arial", Font.PLAIN, 20));
        tlocation.setSize(190, 30);
        tlocation.setLocation(200, 100);
        c.add(tlocation);

        currentQuantity = new JLabel("Current Quantity");
        currentQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        currentQuantity.setSize(150, 20);
        currentQuantity.setLocation(40, 150);
        c.add(currentQuantity);

        tcurrentQuantity = new JTextField();
        tcurrentQuantity.setFont(new Font("Arial", Font.PLAIN, 20));
        tcurrentQuantity.setSize(190, 30);
        tcurrentQuantity.setLocation(200, 150);
        c.add(tcurrentQuantity);

        maxCapacity = new JLabel("Max Capacity");
        maxCapacity.setFont(new Font("Arial", Font.PLAIN, 20));
        maxCapacity.setSize(150, 20);
        maxCapacity.setLocation(40, 200);
        c.add(maxCapacity);

        tmaxCapacity = new JTextField();
        tmaxCapacity.setFont(new Font("Arial", Font.PLAIN, 20));
        tmaxCapacity.setSize(190, 30);
        tmaxCapacity.setLocation(200, 200);
        c.add(tmaxCapacity);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 20));
        sub.setSize(100, 20);
        sub.setLocation(50, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 20));
        reset.setSize(100, 20);
        reset.setLocation(160, 450);
        reset.addActionListener(this);
        c.add(reset);

        showListBtn = new JButton("Show List");
        showListBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        showListBtn.setPreferredSize(new Dimension(50,50));
        showListBtn.addActionListener(this);
        showListBtn.setLocation(220, 450);
        c.add(showListBtn);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 20));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        warehouseFrames.add(this);
        // hideOthers();
        setVisible(true);

    }

    public void hideOthers() {
        for (JFrame jFrame : warehouseFrames) {
            jFrame.setVisible(false);
        }
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

    public void showWithTable() throws SQLException {
        // headers for the table
        String[] columns = new String[] {
                "Id", "Location", "Current Quantity", "Max Capacity"
        };

        // actual data for the table in a 2d array
        List<Warehouse> warehouses = new InventoryService().getAllWarehouses();
        Object[][] data = new Object[warehouses.size()][4];
        for (int i = 0; i < warehouses.size(); i++) {
            data[i] = new Object[] { warehouses.get(i).getId(), warehouses.get(i).getLocation(),
                    warehouses.get(i).getCurrentQuantity(), warehouses.get(i).getMaxCapacity() };
        }
        // create table with data
        JTable table = new JTable(data, columns);

        // add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Warehouse lists");
        this.setBounds(300, 90, 900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.pack();
        warehouseFrames.add(this);
        this.setVisible(true);
    }

    public void createToolBar() {
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);

        ImageIcon iconWarehouses = new ImageIcon(
                new ImageIcon("InvMgtSys/src/resources/images/warehouse.png").getImage()
                        .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        ImageIcon iconAddWarehouse = new ImageIcon(
                new ImageIcon("InvMgtSys/src/resources/images/warehouseAdd.png").getImage()
                        .getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        JButton warehousesB = new JButton(iconWarehouses);
        JButton addWarehousesB = new JButton(iconAddWarehouse);

        toolbar.add(warehousesB);
        toolbar.add(addWarehousesB);

        add(toolbar, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {

            Warehouse ws = new Warehouse(Integer.parseInt(tmaxCapacity.getText()),
                    Integer.parseInt(tcurrentQuantity.getText()), Integer.parseInt(tmaxCapacity.getText()),
                    tlocation.getText());
            InventoryService is = new InventoryService();
            is.addWarehouse(ws);
            String display = "Warehouse ID : " + ws.getId() +
                    "\nWarehouse Location : " + ws.getLocation() +
                    "\nWarehouse Current Quantity : " + ws.getCurrentQuantity() +
                    "\nWarehouse Max Capacity : " + ws.getMaxCapacity();
            tout.setText(display);
            tout.setEditable(false);

            res.setText("Warehouse Created Successfully..");

        }

        else if (e.getSource() == showListBtn) {
            hideOthers();
            try {
                showWithTable();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tlocation.setText(def);
            tcurrentQuantity.setText(def);
            tmaxCapacity.setText(def);
            res.setText(def);
            tout.setText(def);
            resadd.setText(def);
        }
    }
}
