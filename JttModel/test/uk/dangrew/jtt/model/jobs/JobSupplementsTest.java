/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.jobs;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class JobSupplementsTest {

   private JenkinsJob job;
   private JobSupplements systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      job = new JenkinsJobImpl( "job" );
      systemUnderTest = new JobSupplements();
   }//End Method

   @Test public void shouldProvideCommittersSinceLastFailure() {
      assertThat( systemUnderTest.commitsSinceLastFailure(), is( empty() ) );
   }//End Method

}//End Class
