/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.jobs.suppliments;

import uk.dangrew.jtt.model.jobs.BuildResultStatus;
import uk.dangrew.jtt.model.jobs.JenkinsJob;
import uk.dangrew.jtt.model.utility.observable.FunctionListChangeListenerImpl;

/**
 * The {@link CommitsSinceFailureSupplementer} is responsible for supplementing the {@link uk.dangrew.jtt.model.commit.Commit}s
 * made since the last failure as more builds are made, not accounting for history.
 */
public class CommitsSinceFailureSupplementer {

   private final JenkinsJob job;
   
   /**
    * Constructs a new {@link CommitsSinceFailureSupplementor}.
    * @param job the associated {@link JenkinsJob} to supplement.
    */
   public CommitsSinceFailureSupplementer( JenkinsJob job ) {
      this.job = job;
      
      job.commits().addListener( new FunctionListChangeListenerImpl<>( 
               null, job.supplements().commitsSinceLastFailure()::add 
      ) );
      job.buildProperty().addListener( ( s, o, n ) -> {
         if ( n.getValue() == BuildResultStatus.SUCCESS ) {
            job.supplements().commitsSinceLastFailure().clear();
         }
      } );
   }//End Constructor

   /**
    * Method to determine whether this supplementer is associated with the given {@link JenkinsJob}.
    * @param job the {@link JenkinsJob} in question.
    */
   public boolean isAssociatedWith( JenkinsJob job ) {
      return this.job == job;
   }//End Method

}//End Class
