
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import controller_tests.AggressiveStrategyTest;
import controller_tests.AttackTest;
import controller_tests.BenevolentStrategyTest;
import controller_tests.CheaterStrategyTest;
import controller_tests.FortificationTest;
import controller_tests.MapValidationTest;
import controller_tests.ReinforcementTest;
import controller_tests.StartupPhaseTest;

@RunWith(Suite.class)
@SuiteClasses({FortificationTest.class,
	MapValidationTest.class,
	ReinforcementTest.class,
	AttackTest.class,
	StartupPhaseTest.class,
	AggressiveStrategyTest.class,
	BenevolentStrategyTest.class,
	CheaterStrategyTest.class
})

/**
 * This class runs all the test classes
 * @author Navjot kaur
 *
 */
public class TestSuite {

}
