/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.invmgtsys.models.Section;
import com.mycompany.invmgtsys.models.Warehouse;
import com.mycompany.invmgtsys.utility.DBConnector;

/**
 *
 * @author wonde
 */
public class SectionRepository {
    public static List<Section> sections = new ArrayList<>();

    public SectionRepository(List<Section> sectionss) {// []
        sections = sectionss;
    }

    public void addSection(Section section) {
        if (sections == null) {
            sections.set(0, section);
            return;
        }
        sections.add(section);
    }

    public int getId(Section section) {
        return section.getId();
    }

    public Section getSectionById(int id) {
        // for (Section section : sections) {
        // if (section.getSectionId() == id) {
        // return section;
        // }
        // }
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionId() == id) {
                return sections.get(i);
            }
        }
        return null;
    }

    public void updateSection(Section updatedSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionId() == updatedSection.getSectionId()) {
                sections.set(i, updatedSection);
            }
        }
    }

    public void deleteSection(int sectionId) {
        Section sectiontoDelete = this.getSectionById(sectionId);
        sections.remove(sectiontoDelete);// delete Section by object

        for (int i = 0; i < sections.size(); i++) {
            if (sectionId == sections.get(i).getSectionId()) {
                sections.remove(i);
            }
        }
    }

    protected List<Section> readFromDb() {
        Connection conn = DBConnector.getDBConnection();
        List<Section> warehouses = new ArrayList<>();
        if (conn != null) {
            String queryString = "SELECT * FROM section";
            try (PreparedStatement stmt = conn.prepareStatement(queryString)) {
                try {
                    // stmt.setString(1, item_name);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Section section = new Section();
                        section.setSectionId(rs.getInt(1));
                        section.setWarehouseId(rs.getInt(2));
                        section.setAisleName(rs.getString(3));
                        section.setShelfNumber(rs.getInt(4));
                        section.setMaxCapacity(rs.getInt(5));
                        section.setCurrentCapacity(rs.getInt(6));
                        sections.add(section);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: ");
                e.printStackTrace();
            }
        }

        return warehouses;
    }

    public List<Section> getAllSections() {
        // return sections;
        return this.readFromDb();
    }
}
