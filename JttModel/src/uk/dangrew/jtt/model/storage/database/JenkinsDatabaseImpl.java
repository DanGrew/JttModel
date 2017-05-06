/*
 * ----------------------------------------
 *          Jenkins Test Tracker
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2016
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.storage.database;

import javafx.collections.ObservableList;
import uk.dangrew.jtt.model.jobs.JenkinsJob;
import uk.dangrew.jtt.model.nodes.JenkinsNode;
import uk.dangrew.jtt.model.storage.database.events.JenkinsJobPropertyListener;
import uk.dangrew.jtt.model.storage.database.events.JenkinsUserPropertyListener;
import uk.dangrew.jtt.model.storage.structure.MappedObservableStoreManagerImpl;
import uk.dangrew.jtt.model.storage.structure.ObjectStoreManager;
import uk.dangrew.jtt.model.tests.TestClass;
import uk.dangrew.jtt.model.users.JenkinsUser;

/**
 * Basic implementation of the {@link JenkinsDatabase}.
 */
public class JenkinsDatabaseImpl implements JenkinsDatabase {

   private ObjectStoreManager< TestClassKey, TestClass > testClasses;
   private ObjectStoreManager< String, JenkinsJob > jenkinsJobs;
   private ObjectStoreManager< String, JenkinsUser > jenkinsUsers;
   private ObjectStoreManager< String, JenkinsNode > jenkinsNodes;
   private JenkinsJobPropertyListener jenkinsJobProperties;
   private JenkinsUserPropertyListener jenkinsUserProperties;

   /**
    * Constructs a new {@link JenkinsDatabaseImpl}.
    */
   JenkinsDatabaseImpl() {
      testClasses = new MappedObservableStoreManagerImpl<>();
      jenkinsJobs = new MappedObservableStoreManagerImpl<>();
      jenkinsUsers = new MappedObservableStoreManagerImpl<>();
      jenkinsNodes = new MappedObservableStoreManagerImpl<>();
      jenkinsJobProperties = new JenkinsJobPropertyListener( this );
      jenkinsUserProperties = new JenkinsUserPropertyListener( this );
   }//End Constructor
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasNoTestClasses() {
      return testClasses.isEmpty();
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasNoJenkinsJobs() {
      return jenkinsJobs.isEmpty();
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasNoJenkinsUsers() {
      return jenkinsUsers.isEmpty();
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasNoJenkinsNodes() {
      return jenkinsNodes.isEmpty();
   }//End Method

   /**
    * {@inheritDoc}
    */
   @Override public boolean hasTestClass( TestClassKey testClassKey ) {
      return testClasses.has( testClassKey );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasJenkinsJob( String key ) {
      return jenkinsJobs.has( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasJenkinsUser( String key ) {
      return jenkinsUsers.has( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean hasJenkinsNode( String key ) {
      return jenkinsNodes.has( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean containsTestClass( TestClass testClass ) {
      return testClasses.objectList().contains( testClass );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean containsJenkinsJob( JenkinsJob jenkinsJob ) {
      return jenkinsJobs.objectList().contains( jenkinsJob );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean containsJenkinsUser( JenkinsUser jenkinsUser ) {
      return jenkinsUsers.objectList().contains( jenkinsUser );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean containsJenkinsNode( JenkinsNode jenkinsNode ) {
      return jenkinsNodes.objectList().contains( jenkinsNode );
   }//End Method

   /**
    * {@inheritDoc}
    */
   @Override public void store( TestClass testClass ) {
      if ( testClass == null ) {
         return;
      }
      
      TestClassKey representativeKey = new TestClassKeyImpl( 
               testClass.nameProperty().get(), 
               testClass.locationProperty().get() 
      );
      testClasses.store( representativeKey, testClass );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public void store( JenkinsJob jenkinsJob ) {
      if ( jenkinsJob == null ) {
         return;
      }
      if ( jenkinsJob.nameProperty().get() == null ) {
         return;
      }
      
      jenkinsJobs.store( jenkinsJob.nameProperty().get(), jenkinsJob );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public void store( JenkinsUser jenkinsUser ) {
      if ( jenkinsUser == null ) {
         return;
      }
      if ( jenkinsUser.nameProperty().get() == null ) {
         return;
      }
      
      jenkinsUsers.store( jenkinsUser.nameProperty().get(), jenkinsUser );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public void store( JenkinsNode jenkinsNode ) {
      if ( jenkinsNode == null ) {
         return;
      }
      if ( jenkinsNode.nameProperty().get() == null ) {
         return;
      }
      
      jenkinsNodes.store( jenkinsNode.nameProperty().get(), jenkinsNode );
   }//End Method

   /**
    * {@inheritDoc}
    */
   @Override public TestClass getTestClass( TestClassKey testClassKey ) {
      return testClasses.get( testClassKey );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsJob getJenkinsJob( String key ) {
      return jenkinsJobs.get( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsUser getJenkinsUser( String key ) {
      return jenkinsUsers.get( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsNode getJenkinsNode( String key ) {
      return jenkinsNodes.get( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public TestClass removeTestClass( TestClassKey testClassKey ) {
      return testClasses.remove( testClassKey );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsJob removeJenkinsJob( String key ) {
      return jenkinsJobs.remove( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsUser removeJenkinsUser( String key ) {
      return jenkinsUsers.remove( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsNode removeJenkinsNode( String key ) {
      return jenkinsNodes.remove( key );
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean removeTestClass( TestClass testClass ) {
      if ( testClass == null ) {
         return false;
      }
      
      TestClass removed = testClasses.remove( new TestClassKeyImpl( 
               testClass.nameProperty().get(), testClass.locationProperty().get() ) 
      );
      return removed != null;
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean removeJenkinsJob( JenkinsJob jenkinsJob ) {
      if ( jenkinsJob == null ) {
         return false;
      }
      
      JenkinsJob removed = jenkinsJobs.remove( jenkinsJob.nameProperty().get() );
      return removed != null;
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean removeJenkinsUser( JenkinsUser jenkinsUser ) {
      if ( jenkinsUser == null ) {
         return false;
      }
      
      JenkinsUser removed = jenkinsUsers.remove( jenkinsUser.nameProperty().get() );
      return removed != null;
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public boolean removeJenkinsNode( JenkinsNode jenkinsNode ) {
      if ( jenkinsNode == null ) {
         return false;
      }
      
      JenkinsNode removed = jenkinsNodes.remove( jenkinsNode.nameProperty().get() );
      return removed != null;
   }//End Method

   /**
    * {@inheritDoc}
    */
   @Override public ObservableList< TestClass > testClasses() {
      return testClasses.objectList();
   }//End Method

   /**
    * {@inheritDoc}
    */
   @Override public ObservableList< JenkinsJob > jenkinsJobs() {
      return jenkinsJobs.objectList();
   }//End Method

   /**
    * {@inheritDoc}
    */
   @Override public ObservableList< JenkinsUser > jenkinsUsers() {
      return jenkinsUsers.objectList();
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public ObservableList< JenkinsNode > jenkinsNodes() {
      return jenkinsNodes.objectList();
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsJobPropertyListener jenkinsJobProperties() {
      return jenkinsJobProperties;
   }//End Method
   
   /**
    * {@inheritDoc}
    */
   @Override public JenkinsUserPropertyListener jenkinsUserProperties() {
      return jenkinsUserProperties;
   }//End Method

}//End Class
