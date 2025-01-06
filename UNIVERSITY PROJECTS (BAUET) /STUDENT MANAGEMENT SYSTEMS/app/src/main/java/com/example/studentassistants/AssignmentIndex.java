package com.example.studentassistants;

import java.util.ArrayList;

public class AssignmentIndex {

    public String Title;

    public AssignmentIndex(String title) {
        Title = title;
    }

    public AssignmentIndex(StudentAssignment studentAssignment, ArrayList<AssignmentIndex> arrayList){

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title =title;
}
}