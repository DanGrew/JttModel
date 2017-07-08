/*
 * ----------------------------------------
 *        Jenkins Test Tracker Model
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2017
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.commit;

/**
 * A {@link CommitItem} is a file and the type of change made to it.
 */
public class CommitItem {

   private final String itemPath;
   private final EditType editType;
   
   /**
    * Constructs a new {@link CommitItem}.
    * @param itemPath the path to the file changed.
    * @param editType the type of change made.
    */
   public CommitItem( String itemPath, EditType editType ) {
      if ( itemPath == null || editType == null ) {
         throw new IllegalArgumentException( "Must supply non null value." );
      } else if ( itemPath.trim().isEmpty() ) {
         throw new IllegalArgumentException( "Must supply non empty value." );
      }
      
      this.itemPath = itemPath;
      this.editType = editType;
   }//End Constructor

   /**
    * Access to the property.
    * @return the property.
    */
   public String itemPath() {
      return itemPath;
   }//End Method

   /**
    * Access to the property.
    * @return the property.
    */
   public EditType editType() {
      return editType;
   }//End Method

}//End Class
