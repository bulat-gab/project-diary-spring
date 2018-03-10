package com.gab.model.pojo;

import java.util.Objects;

/**
 * Created by gab on 06.Mar.2018
 */
public class Diary {
    private String name;
    private String note;

    public Diary(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, note);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Diary)) return false;

        Diary diary = (Diary) obj;
        return Objects.equals(name, diary.name)
                && Objects.equals(note, diary.note);
    }
}
