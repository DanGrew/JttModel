/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.jobs.suppliments;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import uk.dangrew.jtt.model.commit.Commit;
import uk.dangrew.jtt.model.jobs.BuildResultStatus;
import uk.dangrew.jtt.model.jobs.JenkinsJob;
import uk.dangrew.jtt.model.jobs.JenkinsJobImpl;

public class CommitsSinceFailureSupplementerTest {

   private JenkinsJob job;
//   Not used but to be clear what is being tested.
//   private CommitsSinceFailureSupplimentor systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      job = new JenkinsJobImpl( "job" );
   }//End Method

   @Test public void shouldResetCommitsWhenResultIsSuccess() {
      job.supplements().commitsSinceLastFailure().add( mock( Commit.class ) );
      job.setBuildStatus( BuildResultStatus.SUCCESS );
      assertThat( job.supplements().commitsSinceLastFailure(), is( empty() ) );
   }//End Method
   
   @Test public void shouldIgnoreResultChangesThatArentSuccess() {
      Commit commit = mock( Commit.class );
      job.supplements().commitsSinceLastFailure().add( commit );
      job.setBuildStatus( BuildResultStatus.ABORTED );
      job.setBuildStatus( BuildResultStatus.FAILURE );
      job.setBuildStatus( BuildResultStatus.NOT_BUILT );
      job.setBuildStatus( BuildResultStatus.UNKNOWN );
      job.setBuildStatus( BuildResultStatus.UNSTABLE );
      assertThat( job.supplements().commitsSinceLastFailure(), contains( commit ) );
   }//End Method
   
   @Test public void shouldAddCommitsWhenCurrentCommitsRemoved() {
      Commit commitSinceFailure = mock( Commit.class );
      job.supplements().commitsSinceLastFailure().add( commitSinceFailure );
      
      Commit newCommit = mock( Commit.class );
      Commit newCommit2 = mock( Commit.class );
      job.commits().add( newCommit );
      job.commits().add( newCommit2 );
      
      job.commits().clear();
      assertThat( job.supplements().commitsSinceLastFailure(), contains( commitSinceFailure, newCommit, newCommit2 ) );
   }//End Method
   
}//End Class
