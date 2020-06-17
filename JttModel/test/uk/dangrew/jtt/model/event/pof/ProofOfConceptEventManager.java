/*
 * ----------------------------------------
 *          Jenkins Test Tracker
 * ----------------------------------------
 *          Produced by Dan Grew
 *                 2016
 * ----------------------------------------
 */
package uk.dangrew.jtt.model.event.pof;

import uk.dangrew.kode.event.structure.EventManager;
import uk.dangrew.kode.event.structure.EventSubscription;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example usage of the {@link EventManager} to prove the concept.
 */
public class ProofOfConceptEventManager extends EventManager< EventValue > {

   private static final Set<EventSubscription< EventValue >> subscriptions = new LinkedHashSet<>();
   private static final ReentrantLock lock = new ReentrantLock();
   
   /**
    * Constructs a new {@link ProofOfConceptEventManager}.
    */
   protected ProofOfConceptEventManager() {
      super( subscriptions, lock );
   }//End Constructor

}//End Class
