package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.Job;
     
/**
 * Tests important methods in Volunteer to ensure functionality,
 * and to implicitly test addJob.
 *
 * @author Kai Stansfield
 * @version February 11, 2018
 */
public class JobTest {    
    //isMoreThanMinimumDaysVol
    static Job wayAfterVol;
    static Job justOnLimitVol;
    static Job pastLimitVol;
    
    //isMoreThanMinimumDaysUnvol
    static Job wayAfterUnvol;
    static Job justOnLimitUnvol;
    static Job pastLimitUnvol;
    
    //isNoScheduleConflicts
    static Job testAgainstJob;
    static Job badStart;
    static Job badEnd;
    static Job noConflicts;
    
    //isActiveJob
    static Job activeJob;
    static Job inactiveJob;
    
    //isInPast
    static Job inPast;
    static Job notInPast;
    
    //isJobTooFar
    static LocalDate tooFar;
    static LocalDate notTooFar;
    
    @Before
    public void setup() {
        //isMoreThanMinimumDaysVol test parameters. DM = "Doesn't Matter"
        wayAfterVol = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER + 10),
                LocalDate.now().plusDays(
                    Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER + 12));
        justOnLimitVol = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER + 2));
        pastLimitVol = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER - 2),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_VOLUNTEER));
        
        //isMoreThanMinimumDaysUnvol test parameters. DM = "Doesn't Matter"
        wayAfterUnvol = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 10),
                LocalDate.now().plusDays(
                    Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 12));
        justOnLimitUnvol = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 2));
        pastLimitUnvol = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER - 2),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER));
        
        //isGoodStart/isGoodEnd/isNoScheduleConflicts test parameters.
        //DM = "Doesn't Matter"
        testAgainstJob = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 5),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 8));
        badStart = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 7),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 10));
        badEnd = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 3),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 6));
        noConflicts = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 9),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 12));
        
        //isActiveJob test parameters. DM = "Doesn't Matter"
        activeJob = new Job("DM", "DM", "DM", LocalDate.now().minusDays(2),
                        LocalDate.now().plusDays(1));
        inactiveJob = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 3));
        
        //isInPast test parameters. DM = "Doesn't Matter"
        inPast = new Job("DM", "DM", "DM", LocalDate.now().minusDays(3),
                        LocalDate.now().minusDays(1));
        notInPast = new Job("DM", "DM", "DM", LocalDate.now().plusDays(
                        Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER),
                        LocalDate.now().plusDays(
                            Job.MINIMUM_NUMBER_OF_DAYS_TO_UNVOLUNTEER + 3));
        
        //isJobTooFar test parameters.
        tooFar = LocalDate.now().plusDays(Job.MAX_DISTANCE + 1);
        notTooFar = LocalDate.now().plusDays(Job.MAX_DISTANCE);
    }
    
    @Test
    public void isMoreThanMinimumDaysVol_wayAfter_True() {
        assertTrue(wayAfterVol.isMoreThanMinimumDaysVol());
    }
    
    @Test
    public void isMoreThanMinimumDaysVol_justOnLimit_True() {
        assertTrue(justOnLimitVol.isMoreThanMinimumDaysVol());
    }
    
    @Test
    public void isMoreThanMinimumDaysVol_pastLimit_False() {
        assertFalse(pastLimitVol.isMoreThanMinimumDaysVol());
    }

    
    @Test
    public void isMoreThanMinimumDaysUnvol_wayAfter_True() {
        assertTrue(wayAfterUnvol.isMoreThanMinimumDaysUnvol());
    }
    
    @Test
    public void isMoreThanMinimumDaysUnvol_justOnLimit_True() {
        assertTrue(justOnLimitUnvol.isMoreThanMinimumDaysUnvol());
    }
    
    @Test
    public void isMoreThanMinimumDaysUnvol_pastLimit_False() {
        assertFalse(pastLimitUnvol.isMoreThanMinimumDaysUnvol());
    }
    
    
    @Test
    public void isGoodStart_startsDuringCurrent_False() {
        assertFalse(testAgainstJob.isGoodStart(badStart));
    }
    
    @Test
    public void isGoodStart_DoesntstartsDuringCurrent_True() {
        assertTrue(testAgainstJob.isGoodStart(noConflicts));
    }
    
    @Test
    public void isGoodEnd_endsDuringCurrent_False() {
        assertFalse(testAgainstJob.isGoodEnd(badEnd));
    }
    
    @Test
    public void isGoodEnd_DoesntendsDuringCurrent_True() {
        assertTrue(testAgainstJob.isGoodEnd(noConflicts));
    }
    
    @Test
    public void isNoScheduleConflicts_noConflicts_True() {
        assertTrue(testAgainstJob.isGoodEnd(noConflicts));
    }
    
    
    @Test
    public void isActiveJob_ActiveJob_True() {
        assertTrue(activeJob.isActiveJob());
    }
    
    @Test
    public void isActiveJob_InactiveJob_False() {
        assertFalse(inactiveJob.isActiveJob());
    }
    
    @Test
    public void isInPast_InPast_True() {
        assertTrue(inPast.isInPast());
    }

    @Test
    public void isInPast_NotInPast_False() {
        assertFalse(notInPast.isInPast());
    }
    
    @Test
    public void isDateTooFar_TooFar_True() {
        assertTrue(Job.isDateTooFar(tooFar));
    }
    @Test
    public void isDateTooFar_NotTooFar_False() {
        assertFalse(Job.isDateTooFar(notTooFar));
    }
}
