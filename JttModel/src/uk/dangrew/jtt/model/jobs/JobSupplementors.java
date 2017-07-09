/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.jobs;

import uk.dangrew.jtt.model.jobs.suppliments.CommitsSinceFailureSupplementer;

/**
 * {@link JobSupplementors} collects supplementers for the {@link JobSupplements} on {@link JenkinsJob}s.
 */
public class JobSupplementors {
   
   private JenkinsJob job;
   private CommitsSinceFailureSupplementer commitsSinceLastFailureSupplimentor;

   /**
    * Associates the supplementors with the given {@link JenkinsJob}.
    * Can only be called once.
    * @param job the {@link JenkinsJob}.
    */
   void associate( JenkinsJob job ) {
      if ( this.job != null ) {
         throw new IllegalStateException( "Already associated." );
      }
      
      this.job = job;
      this.commitsSinceLastFailureSupplimentor = new CommitsSinceFailureSupplementer( job );
   }//End Constructor
   
   CommitsSinceFailureSupplementer commitsSinceLastFailureSupplimentor() {
      return commitsSinceLastFailureSupplimentor;
   }//End Method

}//End Class
