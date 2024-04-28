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
/////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


/**
 * @author tai
 *
 */
public class Course {

  private String name;
  private int numStudents;



  /**
   * Creates a new Course object
   */
  public Course(String name, int numStudents) {
    if (numStudents < 0) {
      throw new IllegalArgumentException("Number of students cannot be less than zero!");
    }
    this.name = name;
    this.numStudents = numStudents;



  }

  /**
   * Returns name of course
   * 
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Returns number of students in courseF
   * 
   * @return
   */
  public int getNumStudents() {
    return numStudents;
  }



}
