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
    private static List<Section> sections = new ArrayList<>();

    public void addSection(Section section) {
        sections.add(section);
    }

    public Section getSectionById(int id) {
        for (Section section : sections) {
            if (section.getSectionId() == id) {
                return section;
            }
        }
        return null;
    }

    public void updateSection(Section updatedSection){
        int updatedSectionId = updatedSection.getSectionId();
        Section updatedSectionFound = this.getSectionById(updatedSectionId);
        if(updatedSectionFound != null){
            sections.set(updatedSectionId,updatedSectionFound);
        }
    }

    public void deleteSection(int sectionId){
        Section sectiontoDelete = this.getSectionById(sectionId);
        sections.remove(sectiontoDelete);//delete Section by id

        for (int i = 0; i < sections.size(); i++) {
            if (sectionId == sections.get(i).getSectionId()) {
                sections.remove(i);
            }
        }
    }

    public List<Section> getAllSections(){
        return sections;
    }
}
