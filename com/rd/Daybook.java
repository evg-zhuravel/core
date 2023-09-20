package com.rd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Daybook {

    private List<Note> notes = new ArrayList<>();

    public Daybook(List<Note> notes) {
        this.notes.addAll(notes);
    }

    public Daybook(Note note) {
        notes.add(note);
    }

    public Daybook() {
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void addNote(int index, Note note) {
        notes.add(index, note);
    }

    public void setNode(int index, Note note) {
        notes.set(index, note);
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public void removeNote(String noteTitle) {
        Objects.requireNonNull(noteTitle);
        notes.removeIf(value -> value.getTitle().equals(noteTitle));
    }

    public Note getNote(int index) {
        return notes.get(index);
    }

    public void printNotes() {
        System.out.println("\t  Daybook info");
        notes.forEach(System.out::print);
    }
}
