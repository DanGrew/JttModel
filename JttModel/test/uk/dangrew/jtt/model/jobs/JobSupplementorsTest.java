/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.jobs;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class JobSupplementorsTest {

   private JenkinsJob job;
   private JobSupplementors systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      job = new JenkinsJobImpl( "job" );
      systemUnderTest = new JobSupplementors();
   }//End Method

   @Test( expected = IllegalStateException.class ) public void shouldNotAssociateMoreThanOnce() {
      systemUnderTest.associate( job );
      systemUnderTest.associate( new JenkinsJobImpl( "anything" ) );
   }//End Method
   
   @Test public void shouldProvideCommitsSinceFailureSupplementer() {
      assertThat( systemUnderTest.commitsSinceLastFailureSupplimentor(), is( nullValue() ) );
      systemUnderTest.associate( job );
      assertThat( systemUnderTest.commitsSinceLastFailureSupplimentor().isAssociatedWith( job ), is( true ) );
   }//End Method

}//End Class
