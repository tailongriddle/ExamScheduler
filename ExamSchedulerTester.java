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
 * 
 * Tests all classes for exceptions and correct methods and constructors
 * 
 * @author tai
 *
 */
public class ExamSchedulerTester {

  /**
   * Tests course class for correct methods
   * 
   * @return
   */
  public static boolean testCourse() {
    Course test = new Course("ENG", 40);
    if (!test.getName().equals("ENG")) {
      return false;
    }

    if (test.getNumStudents() != 40) {
      return false;
    }
    return true;
  }

  /**
   * Tests room class for correct methods
   * 
   * @return
   */
  public static boolean testRoom() {
    Room test = new Room("ENG", 3);
    if (!test.getLocation().equals("ENG")) {
      return false;
    }

    if (test.getCapacity() != 3) {
      return false;
    }

    try {
      test.reduceCapacity(4);
    } catch (IllegalArgumentException e) {
      return true;
    }
    return false;
  }


  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(testCourse());
    System.out.println(testRoom());
  }

}
