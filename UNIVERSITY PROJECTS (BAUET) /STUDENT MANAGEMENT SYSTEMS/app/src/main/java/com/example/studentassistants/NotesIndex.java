package com.example.studentassistants;

import java.util.ArrayList;

public class NotesIndex {


    public String Title;

    public NotesIndex(String title) {
        Title = title;
    }

    public NotesIndex(StudentClassnotes studentClassnotes, ArrayList<NotesIndex> arrayList){

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title =title;
    }
}
