package com.rd;

import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

public class Note {

    private String author;
    private String title;
    private String description;
    private Priority priority;
    private Date dateOfCreation;

    public Note(String author, String title, String description, Priority priority, Date dateOfCreation) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dateOfCreation = dateOfCreation;
    }

    public Note(String author, String title, String description, Priority priority) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Note(String author, String title, String description) {
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public Note(String author, String title, String description, Date dateOfCreation) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
    }

    public Note(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    private List<String> getValues() {
        List<String> values = new ArrayList<>();
        Field[] fields = Note.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object o = new Object();
            try {
                o = field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (o != null) {
                values.add(String.valueOf(o));
            }
        }
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;
        return Objects.equals(author, note.author) && Objects.equals(title, note.title) && Objects.equals(description, note.description) && priority == note.priority && Objects.equals(dateOfCreation, note.dateOfCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, description, priority, dateOfCreation);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("------------------------\n");
        for (String s : getValues()) {
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }

    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}
