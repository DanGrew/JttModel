/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.commit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.dangrew.jtt.model.users.JenkinsUser;
import uk.dangrew.jtt.model.users.JenkinsUserImpl;

public class CommitTest {

   private static final String ID = "s;dvboawuy4fkawb";
   private static final Long TIMESTAMP = 3485269387L;
   private static final JenkinsUser USER = new JenkinsUserImpl( "SomeUser" );
   private static final String COMMENT = "i have commented";
   private static final String MESSAGE = "my message";
   private static final List< CommitItem > COMMITS = Arrays.asList( 
            new CommitItem( "Path1", EditType.add ),
            new CommitItem( "Path2", EditType.edit ),
            new CommitItem( "Path3", EditType.delete ),
            new CommitItem( "Path4", EditType.edit )
   );
   
   private Commit systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      systemUnderTest = new Commit(
               ID,
               TIMESTAMP,
               USER,
               COMMENT,
               MESSAGE,
               COMMITS
      );
   }//End Method

   @Test public void shouldProvideCommitId() {
      assertThat( systemUnderTest.id(), is( ID ) );
   }//End Method
   
   @Test public void shouldProvideTimestamp() {
      assertThat( systemUnderTest.timestamp(), is( TIMESTAMP ) );
   }//End Method
   
   @Test public void shouldProvideUser() {
      assertThat( systemUnderTest.user(), is( USER ) );
   }//End Method
   
   @Test public void shouldProvideComment() {
      assertThat( systemUnderTest.comment(), is( COMMENT ) );
   }//End Method
   
   @Test public void shouldProvideMessage() {
      assertThat( systemUnderTest.message(), is( MESSAGE ) );
   }//End Method
   
   @Test public void shouldProvideCommitItems() {
      assertThat( systemUnderTest.commits(), is( COMMITS ) );
   }//End Method
   
   @Test( expected  = IllegalArgumentException.class ) public void shouldNotAcceptNullId(){
      new Commit(
               null,
               TIMESTAMP,
               USER,
               COMMENT,
               MESSAGE,
               COMMITS
      );
   }//End Method
   
   @Test( expected  = IllegalArgumentException.class ) public void shouldNotAcceptEmptyId(){
      new Commit(
               "    ",
               TIMESTAMP,
               USER,
               COMMENT,
               MESSAGE,
               COMMITS
      );
   }//End Method
   
   @Test( expected  = IllegalArgumentException.class ) public void shouldNotAcceptNullTimestamp(){
      new Commit(
               ID,
               null,
               USER,
               COMMENT,
               MESSAGE,
               COMMITS
      );
   }//End Method

   @Test( expected  = IllegalArgumentException.class ) public void shouldNotAcceptNullUser(){
      new Commit(
               ID,
               TIMESTAMP,
               null,
               COMMENT,
               MESSAGE,
               COMMITS
      );
   }//End Method
   
   @Test( expected  = IllegalArgumentException.class ) public void shouldNotAcceptNullCommits(){
      new Commit(
               ID,
               TIMESTAMP,
               USER,
               COMMENT,
               MESSAGE,
               null
      );
   }//End Method
}//End Class
