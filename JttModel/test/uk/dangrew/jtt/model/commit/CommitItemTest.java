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

import org.junit.Before;
import org.junit.Test;

public class CommitItemTest {

   private static final String ITEM_PATH = "Some Path";
   private static final EditType EDIT_TYPE = EditType.edit;
   
   private CommitItem systemUnderTest;

   @Before public void initialiseSystemUnderTest() {
      systemUnderTest = new CommitItem( ITEM_PATH, EDIT_TYPE );
   }//End Method

   @Test public void shouldProvideItemPath() {
      assertThat( systemUnderTest.itemPath(), is( ITEM_PATH ) );
   }//End Method
   
   @Test public void shouldProvideEditType() {
      assertThat( systemUnderTest.editType(), is( EDIT_TYPE ) );
   }//End Method
   
   @Test( expected = IllegalArgumentException.class ) public void shouldNotAcceptNullPath(){
      new CommitItem( null, EDIT_TYPE );
   }//End Method
   
   @Test( expected = IllegalArgumentException.class ) public void shouldNotAcceptEmptyPath(){
      new CommitItem( "   ", EDIT_TYPE );
   }//End Method
   
   @Test( expected = IllegalArgumentException.class ) public void shouldNotAcceptNullEditType(){
      new CommitItem( ITEM_PATH, null );
   }//End Method

}//End Class
