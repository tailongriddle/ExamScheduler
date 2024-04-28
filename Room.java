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
public class Room {
  private String location;
  private int capacity;


  /**
   * Creates a new Room object
   */
  public Room(String location, int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity cannot be less than zero!");
    }

    this.location = location;
    this.capacity = capacity;

  }

  /**
   * Returns location of the room
   * 
   * @return
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Returns capacity of the room
   * 
   * @return
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Creates a new Room object that subtracts a given amount from the current object's capacity
   * 
   * @param subtract
   * @return
   */
  public Room reduceCapacity(int subtract) {
    if (subtract > this.capacity) {
      throw new IllegalArgumentException("New capacity cannot be negative!");
    }
    return new Room(this.location, this.getCapacity() - subtract);
  }
}
