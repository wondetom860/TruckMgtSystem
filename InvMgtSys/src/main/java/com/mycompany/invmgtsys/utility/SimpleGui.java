/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.utility;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 *
 * @author wonde
 */
public class SimpleGui extends JFrame {
    public SimpleGui() {
        setSize(400, 500);
        setTitle("Simple Gui");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Toolkit toolKit = getToolkit();
        Dimension size = toolKit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2,
                size.height / 2 - getHeight() / 2);

    }

    public static void main(String[] args) {
        SimpleGui sgui = new SimpleGui();
        sgui.setVisible(true);
    }
}
