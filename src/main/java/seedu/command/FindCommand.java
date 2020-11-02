package seedu.command;

import seedu.exception.DukeException;
import seedu.task.Event;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;

import java.util.ArrayList;

/**
 * Finds class(es) in the timetable that matches the keyword.
 */
public class FindCommand extends Command {

    public FindCommand(String keyword) {
        super(keyword);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser) throws DukeException {
        if (nowUser == null) {
            throw new DukeException("Sorry! You are not logged in to any account :-(");
        }

        String[] parsedInputs = input.split("/", 2);
        String keyword = parsedInputs[1];
        int userIndex = -1;
        int count = 1;

        for (int i = 0; i < users.getTotalUserCount(); i++) {
            if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                userIndex = i + 1;
                break;
            }
        }

        assert userIndex != -1 : "User not found";

        String classesFound = "";

        ArrayList<Event> timetableMon = (users.getUser(userIndex).getTimetable()).getTimetable("mon");
        for (Object c : timetableMon) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Monday) " + classEvent;
                count++;
            }
        }

        ArrayList<Event> timetableTue = (users.getUser(userIndex).getTimetable()).getTimetable("tue");
        for (Object c : timetableTue) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Tuesday) " + classEvent;
                count++;
            }
        }

        ArrayList<Event> timetableWed = (users.getUser(userIndex).getTimetable()).getTimetable("wed");
        for (Object c : timetableWed) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Wednesday) " + classEvent;
                count++;
            }
        }
        ArrayList<Event> timetableThu = (users.getUser(userIndex).getTimetable()).getTimetable("thu");
        for (Object c : timetableThu) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Thursday) " + classEvent;
                count++;
            }
        }

        ArrayList<Event> timetableFri = (users.getUser(userIndex).getTimetable()).getTimetable("fri");
        for (Object c : timetableFri) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Friday) " + classEvent;
                count++;
            }
        }

        ArrayList<Event> timetableSat = (users.getUser(userIndex).getTimetable()).getTimetable("sat");
        for (Object c : timetableSat) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Saturday) " + classEvent;
                count++;
            }
        }

        ArrayList<Event> timetableSun = (users.getUser(userIndex).getTimetable()).getTimetable("sun");
        for (Object c : timetableSun) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Sunday) " + classEvent;
                count++;
            }
        }

        ui.printFind(classesFound, keyword);
    }
}
