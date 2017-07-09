/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.jobs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import uk.dangrew.jtt.model.commit.Commit;

/**
 * {@link JobSupplements} provides properties that are identified, supplemented, by the system. 
 */
public class JobSupplements {
   
   private final ObservableList< Commit > commitsSinceLastFailure;

   /**
    * Constructs a new {@link JobSupplements}.
    */
   JobSupplements() {
      this.commitsSinceLastFailure = FXCollections.observableArrayList();
   }//End Class
   
   /**
    * Access to the {@link Commit}s made since the last failure, not accounting for history
    * but tracking as new builds are identified.
    * @return the {@link ObservableList}.
    */
   public ObservableList< Commit > commitsSinceLastFailure() {
      return commitsSinceLastFailure;
   }//End Method

}//End Class
