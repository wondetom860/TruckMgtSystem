/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invmgtsys.repository;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.invmgtsys.models.Section;

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

    public int getId(Section section){
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

    public List<Section> getAllSections() {
        return sections;
    }
}
