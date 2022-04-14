
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import controllerTests.AggressiveStrategyTest;
import controllerTests.AttackTest;
import controllerTests.BenevolentStrategyTest;
import controllerTests.CheaterStrategyTest;
import controllerTests.FortificationTest;
import controllerTests.MapValidationTest;
import controllerTests.ReinforcementTest;
import controllerTests.StartupPhaseTest;

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
