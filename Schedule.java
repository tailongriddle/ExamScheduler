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
public class Schedule {
  private Room[] rooms;
  private Course[] courses;
  private int[] assignments;

  /**
   * Creates a new Schedule with an empty assignment array
   */
  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;

    assignments = new int[courses.length];
    for (int i = 0; i < assignments.length; i++) {
      assignments[i] = -1;
    }

  }

  /**
   * 
   * Creates a new Schedule
   * 
   * @param rooms
   * @param courses
   * @param assignments
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }


  /**
   * Returns number of rooms
   * 
   * @return
   */
  public int getNumRooms() {
    return this.rooms.length;
  }

  /**
   * Returns room at given index
   * 
   * @param index
   * @return
   */
  public Room getRoom(int index) {
    if (index < 0 || index > rooms.length - 1) {
      throw new IndexOutOfBoundsException("Index cannot be less than 0!");
    }

    return this.rooms[index];
  }

  /**
   * Returns number of courses
   * 
   * @return
   */
  public int getNumCourses() {
    return this.courses.length;
  }

  /**
   * Returns course at given index
   * 
   * @param index
   * @return
   */
  public Course getCourse(int index) {
    if (index < 0 || index > courses.length - 1) {
      throw new IndexOutOfBoundsException("Index cannot be less than 0!");
    }

    return this.courses[index];
  }

  /**
   * Checks if given index is assigned, returns false if not
   * 
   * @param index
   * @return
   */
  public boolean isAssigned(int index) {
    if (assignments[index] == -1) {
      return false;
    }
    return true;
  }

  /**
   * Returns assignment at given index
   * 
   * @param index
   * @return
   */
  public Room getAssignment(int index) {
    if (index < 0 || index > rooms.length - 1) {
      throw new IndexOutOfBoundsException("Index cannot be less than 0!");
    } else if (!isAssigned(index)) {
      throw new IllegalArgumentException("Index is not assigned!");

    }

    return this.rooms[index];
  }

  /**
   * Checks if every course is assigned to a room, returns false if not
   * 
   * @return
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (isAssigned(i) == false) {
        return false;
      }
    }
    return true;
  }

  /**
   * Assigns course at given index to room at given index, creates a new Schedule object
   * 
   * @param courseIndex
   * @param roomIndex
   * @return
   */
  public Schedule assignCourse(int courseIndex, int roomIndex) {
    int[] newAssign = new int[courses.length];
    if (courseIndex < 0 || courseIndex > courses.length - 1) {
      throw new IndexOutOfBoundsException("Course must be within bounds!");
    }

    if (roomIndex < 0 || roomIndex > rooms.length - 1) {
      throw new IndexOutOfBoundsException("Room must be within bounds!");
    }

    if (assignments[courseIndex] != -1) {
      throw new IllegalArgumentException("Course is already assigned room!");
    }

    if (courses[courseIndex].getNumStudents() > rooms[roomIndex].getCapacity()) {
      throw new IllegalArgumentException("Course has too many students for room capacity!");
    }

    newAssign[courseIndex] = roomIndex;

    return new Schedule(rooms, courses, newAssign);
  }

  /**
   * Returns a string representation of course assignments
   */
  @Override
  public String toString() {
    String out = "{";
    for (int i = 0; i < courses.length - 1; i++) {
      if (isAssigned(i)) {
        out += courses[i].getName() + ": ";
        out += rooms[assignments[i]].getLocation();

      }
      out += courses[i].getName() + ": Unassigned";
      if (i != courses.length - 1) {
        out += ", ";
      }
    }
    out += "}";
    return out;
  }

}
