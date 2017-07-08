/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.commit;

import java.util.Collections;
import java.util.List;

import uk.dangrew.jtt.model.users.JenkinsUser;

/**
 * A {@link Commit} represents a single commit made to the associated repository detected by the
 * the associated {@link uk.dangrew.jtt.model.jobs.JenkinsJob}.
 */
public class Commit {

   private final String id;
   private final Long timestamp;
   private final JenkinsUser user;
   private final String comment;
   private final String message;
   private final List< CommitItem > commits;
   
   /**
    * Constructs a new {@link Commit}.
    * @param id the id of the commit, unique.
    * @param timestamp the timestamp of the commit.
    * @param user the {@link JenkinsUser} that made the commit.
    * @param comment the comment provided with the commit.
    * @param message the message provided with the commit.
    * @param commits the {@link CommitItem}s in the commit, i.e. files and change types.
    */
   public Commit(
            String id, 
            Long timestamp, 
            JenkinsUser user, 
            String comment, 
            String message,
            List< CommitItem > commits 
   ) {
      if ( id == null || timestamp == null || user == null || commits == null ) {
         throw new IllegalArgumentException( "Must supply non null value." );
      } else if ( id.trim().isEmpty() ) {
         throw new IllegalArgumentException( "Must supply non empty value." );
      }
      
      this.id = id;
      this.timestamp = timestamp;
      this.user = user;
      this.comment = comment;
      this.message = message;
      this.commits = Collections.unmodifiableList( commits );
   }//End Constructor

   /**
    * Access to the property.
    * @return the property.
    */
   public String id() {
      return id;
   }//End Method

   /**
    * Access to the property.
    * @return the property.
    */
   public Long timestamp() {
      return timestamp;
   }//End Method

   /**
    * Access to the property.
    * @return the property.
    */
   public JenkinsUser user() {
      return user;
   }//End Method

   /**
    * Access to the property.
    * @return the property.
    */
   public String comment() {
      return comment;
   }//End Method
   
   /**
    * Access to the property.
    * @return the property.
    */
   public String message() {
      return message;
   }//End Method

   /**
    * Access to the property.
    * @return the property.
    */
   public List< CommitItem > commits() {
      return commits;
   }//End Method

}//End Class
