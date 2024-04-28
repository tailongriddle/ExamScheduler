//////////////// FILE HEADER //////////////////////////
//
// Title: P06 Exam Scheduler
// Course: CS 300 Spring 2022
//
// Author: Tai-Long Riddle
// Email: mlriddle@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: piazza
// Online Sources: Piazza :)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


/**
 * @author tai
 *
 */
public class ExamScheduler {

  /***
   * 
   * Creates a schedule from given rooms and courses
   * 
   * @param rooms
   * @param courses
   * @return schedule
   */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) {
    Schedule starter = new Schedule(rooms, courses);
    return findScheduleHelper(starter, 0);

  }

  /***
   * 
   * Helper for creating a schedule, assigns courses and checks validity of schedule
   * 
   * @param given
   * @param index
   * @return given schedule
   */
  private static Schedule findScheduleHelper(Schedule given, int index) {
    if (index == given.getNumCourses()) { // if index is the same as the number of courses...
      if (given.isComplete()) { // if given is complete...
        return given; // return schedule
      }
      throw new IllegalStateException("Schedule is invalid!"); // throw exception if given is
                                                               // incomplete
    }


    if (given.isAssigned(index)) { // if index is assigned in given...
      for (int i = 0; i < given.getNumCourses(); i++) { // for all courses in given...
        given.assignCourse(index, i); // assign index to i

      }
      return given; // return given schedule
    }


    for (int i = 0; i < given.getNumCourses(); i++) {
      if (!given.isAssigned(i)) { // if i is not assigned in given...
        given.assignCourse(index, i); // assign index to i
      }

    }
    return given; // return given schedule
  }

  /***
   * 
   * Find all possible schedules for given courses
   * 
   * @param rooms
   * @param courses
   * @return
   */
  public static List<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    Schedule starter = new Schedule(rooms, courses);
    return findAllSchedulesHelper(starter, 0);
  }

  /***
   * 
   * Helper for finding all schedules for given courses
   * 
   * @param given
   * @param index
   * @return
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule given, int index) {
    ArrayList<Schedule> possible = new ArrayList<>(); // create empty array list for possible

    if (index == given.getNumCourses()) { // if the index is the same as the given number of courses
      if (given.isComplete()) { // if given is complete...
        possible.add(given); // add given to possible list of schedules
        return possible; // return possible list of schedules
      }

    }
    if (given.isAssigned(index)) { // if index is assigned in given schedule..
      for (int i = 0; i < given.getNumCourses() - 1; i++) { // for each course in given...
        given.assignCourse(index, i); // assign index in given to i 

      }
      return possible; // return list of possible schedules
    }
    for (int i = index; i < given.getNumCourses() - 1; i++) { 
      if (!given.isAssigned(i)) {
        possible.add(given);
        findAllSchedulesHelper(given, index + 1);
      }

    }
    return possible;
  }


}
