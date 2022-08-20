package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
   @Test
   public void testSettingJobId() {
      Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
      assertNotEquals(job1.getId(), job2.getId());
   }
   @Test
   public void testJobConstructorSetsAllFields() {
      Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      assertTrue(job3 instanceof Job);
      assertEquals("Product tester", job3.getName());
      assertTrue(job3.getEmployer() instanceof Employer);
      assertEquals("ACME",job3.getEmployer().getValue());
      assertTrue(job3.getLocation() instanceof Location);
      assertEquals("Desert", job3.getLocation().getValue());
      assertTrue(job3.getPositionType() instanceof PositionType);
      assertEquals("Quality control", job3.getPositionType().getValue());
      assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
      assertEquals("Persistence", job3.getCoreCompetency().getValue());
   }
   @Test
   public void testJobsForEquality() {
      Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      assertFalse(job4.equals(job5));
   }
   @Test
   public void testToStringStartsAndEndsWithNewLine() {
      Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      String string = "\n" + "ID: " + job6.getId() + "\n" +
              "Name: " + job6.getName() + "\n" +
              "Employer: " + job6.getEmployer() + "\n" +
              "Location: " + job6.getLocation() + "\n" +
              "Position Type: " + job6.getPositionType() + "\n" +
              "Core Competency: " + job6.getCoreCompetency() + "\n";
      assertEquals(string.charAt(0), job6.toString().charAt(0));
      assertEquals(string.charAt(string.length()-1), job6.toString().charAt(job6.toString().length()-1));
   }
   @Test
   public void testToStringContainsCorrectLabelsAndData(){
      Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      String string = "\n" + "ID: " + job7.getId() + "\n" +
              "Name: " + job7.getName() + "\n" +
              "Employer: " + job7.getEmployer() + "\n" +
              "Location: " + job7.getLocation() + "\n" +
              "Position Type: " + job7.getPositionType() + "\n" +
              "Core Competency: " + job7.getCoreCompetency() + "\n";
      assertEquals(string, job7.toString());
   }
   @Test
   public void testToStringHandlesEmptyField() {
      Job job8 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
      String string = "\n" + "ID: " + job8.getId() + "\n" +
              "Name: " + job8.getName() + "\n" +
              "Employer: " + "Data not available" + "\n" +
              "Location: " + job8.getLocation() + "\n" +
              "Position Type: " + job8.getPositionType() + "\n" +
              "Core Competency: " + job8.getCoreCompetency() + "\n";
      assertEquals(string, job8.toString());
   }
}
