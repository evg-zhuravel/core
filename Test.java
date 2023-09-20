import com.rd.Daybook;
import com.rd.Note;

import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Note> notes = List.of(new Note("Dmitro Karp", "Solve maths", "Solve tasks 1 and 2", Note.Priority.MEDIUM, new Date()),
                new Note("Dmitro Karp", "Do physical exercises", "Training"),
                new Note("Buy food", "Bread, bear, macaroni"),
                new Note("Su Sho", "Meeting", "Meeting with friends at 20:00", Note.Priority.LOW, new Date())
        );

        Daybook daybook = new Daybook(notes);
        daybook.addNote(0, new Note("Buy food for my dog", "Buy some meat"));
        daybook.removeNote(3);
        daybook.addNote(new Note("John Woo", "Repair lamp", "Repair mother`s lamp. It`s on the table in the kitchen", new Date()));
        daybook.printNotes();
    }
}
