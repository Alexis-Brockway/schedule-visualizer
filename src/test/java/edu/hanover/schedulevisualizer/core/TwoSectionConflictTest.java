package edu.hanover.schedulevisualizer.core;

import edu.hanover.schedulevisualizer.conflict.TwoCourseConflict;
import edu.hanover.schedulevisualizer.conflict.TwoCourseConstraint;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class TwoSectionConflictTest {

    @Test
    public void TwoSectionsAreTheSame() {
        Section section1 = new Section(new Course("CS", "321", "Software Development Practicum"), new HCTimeSlot(Weekday.MWF(), 1));
        Section section2 = new Section(new Course("CS", "321", "Software Development Practicum"), new HCTimeSlot(Weekday.MWF(), 1));
        TwoCourseConstraint twocourse = new TwoCourseConstraint(section1, section2);
        assertTrue(twocourse.twoConflictingCourses(section1, section2));
    }

    @Test
    public void TwoSectionsAreDifferent() {
        Section section1 = new Section(new Course("CS", "321", "Software Development Practicum"), new HCTimeSlot(Weekday.MWF(), 1));
        Section section2 = new Section(new Course("CS", "220", "Fundamentals Of CS"), new HCTimeSlot(Weekday.MWF(), 1));
        TwoCourseConstraint twocourse = new TwoCourseConstraint(section1, section2);
        assertFalse(twocourse.twoConflictingCourses(section1, section2));
    }

    @Test
    public void sameSectionsHaveSameTimeSlot() {
        Section section1 = new Section(new Course("CS", "321", "Software Development Practicum"), new HCTimeSlot(Weekday.MWF(), 1));
        Section section2 = new Section(new Course("CS", "321", "Software Development Practicum"), new HCTimeSlot(Weekday.MWF(), 1));
        TwoCourseConstraint twocourse = new TwoCourseConstraint(section1, section2);
        assertTrue(twocourse.generateConflict(section1, section2).equals(Optional.of(new TwoCourseConflict(section1, section2))));
    }

    @Test
    public void thereIsNoConflictForTwoSections() {
        Section section1 = new Section(new Course("CS", "321", "Software Development Practicum"), new HCTimeSlot(Weekday.MWF(), 1));
        Section section2 = new Section(new Course("CS", "220", "Fundamentals Of CS"), new HCTimeSlot(Weekday.TR(), 1));
        TwoCourseConstraint twocourse = new TwoCourseConstraint(section1, section2);
        assertEquals(twocourse.generateConflict(section1, section2), Optional.empty());
    }
}
