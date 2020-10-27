package seedu.duke.command;

import seedu.duke.exception.DukeException;
import seedu.duke.task.Event;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

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

        String keyword = input;
        int userIndex = -1;
        int count = 1;

        for (int i = 0; i < users.getTotalUserCount(); i++) {
            if ((users.getUser(i + 1).getName() == nowUser.getName())) {
                userIndex = i + 1;
                break;
            }
        }

        assert userIndex != -1 : "User not found";

        String classesFound = "";
        ArrayList<Event> timetableMon = (users.getUser(userIndex).getTimetable()).getTimetable("mon");
        ArrayList<Event> timetableTue = (users.getUser(userIndex).getTimetable()).getTimetable("tue");
        ArrayList<Event> timetableWed = (users.getUser(userIndex).getTimetable()).getTimetable("wed");
        ArrayList<Event> timetableThu = (users.getUser(userIndex).getTimetable()).getTimetable("thu");
        ArrayList<Event> timetableFri = (users.getUser(userIndex).getTimetable()).getTimetable("fri");
        ArrayList<Event> timetableSat = (users.getUser(userIndex).getTimetable()).getTimetable("sat");
        ArrayList<Event> timetableSun = (users.getUser(userIndex).getTimetable()).getTimetable("sun");

        for (Object c : timetableMon) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Monday) " + classEvent;
                count++;
            }
        }

        for (Object c : timetableTue) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Tuesday) " + classEvent;
                count++;
            }
        }

        for (Object c : timetableWed) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Wednesday) " + classEvent;
                count++;
            }
        }

        for (Object c : timetableThu) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Thursday) " + classEvent;
                count++;
            }
        }

        for (Object c : timetableFri) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Friday) " + classEvent;
                count++;
            }
        }

        for (Object c : timetableSat) {
            String classEvent = c.toString();
            if (classEvent.contains(keyword)) {
                classesFound = classesFound + "\n" + count + ". (Saturday) " + classEvent;
                count++;
            }
        }

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
