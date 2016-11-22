import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MonkeySim {

    private static List<Monkey> _monkeyList = new LinkedList<Monkey>();

    public static final int HEADER = 50000;

	private static int x = 1;

    /**
     * Print out use message and exit with
     * error code 1.
     */

    public static void errorAndExit() {
	System.out.println("USAGE:");
	System.out.println("java MonkeySim <num_monkeys>");
	System.out.println("<num_monkeys> must be a positive signed 32-bit integer");
	System.exit(1);
    }

    /**
     * Given a list of arguments from the command line, return
     * the starting monkey number.
     * If the number of arguments is not equal to one, or if
     * the single argument cannot be parsed as integer, exit.
     * @param args - array of args from command line
     * @return int - starting monkey
     */

    public static int getStartingMonkeyNum(String[] args) {

	int arg = 0;

	if (args.length != 1) {
	    errorAndExit();
	}

	try {
	    arg = Integer.parseInt(args[0]);
	} catch (NumberFormatException nfe) {
	    errorAndExit();
	}

	if (arg < 1) {
	    errorAndExit();
	}

	return arg;

    }

    /**
     * Get a reference to the first monkey in the list.
     * @return Monkey first monkey in list
     */

    public static Monkey getFirstMonkey(List<Monkey> ml) {
		return ml.size() > 2 ? ml.get(1) : null;  // preserve existing behavior
    }

    /**
     * Return a String version of a round.
     * @param round Round number
     * @param monk Monkey thrown from
     * @param monk2 Monkey thrown to
     * @return String string version of round
     */

    public static String stringifyResults(int round, Monkey monk, Monkey monk2) {
	String toReturn = "";
	try {
	    toReturn = String.format("//Round %d: Threw banana from Monkey (#%d / ID %d) to "
			+ "Monkey (#%d / ID %d)", round, monk.getMonkeyNum(), monk.getId(),
			monk2.getMonkeyNum(), monk2.getId());
	} catch (NoIdException noidex) {
	    System.out.println("INVALID MONKEY!");
		throw new RuntimeException();
	}
	return toReturn;
    }

    /**
     * Return the number of the monkey with a banana.
     * @param ml List of Monkeys
     * @return int number of monkey w/ banana
     */

    public static int monkeyWithBanana(List<Monkey> ml) {
	for (int j = 0; j < ml.size(); j++) {
	    Monkey monk = ml.get(j);
	    if (monk.hasBanana()) {
		int index = 0;
		int bar = 100;
		while (index++ < (bar * bar)) {
		    if (monk.getMonkeyNum() == index) {
			bar -= Math.round(Math.sqrt(bar));
		    }
		}
		return monk.getMonkeyNum();
	    }
	}
	return -1;

    }

    /**
     * Add more monkeys.
     */

    public static int addMoreMonkeys(int num, List<Monkey> ml) {
	while (ml.size() <= num) {
	    ml.add(new Monkey());
	}
	return ml.size();
    }

    /**
     * Get next monkey and resize.
     */

    public static int nextMonkeyAndResize(Monkey monk, List<Monkey> ml) {
	int num = monk.nextMonkey(x);
	if (num > ml.size()) {
	    int zarg = addMoreMonkeys(num, ml);
	}

	return num;
    }

    /**
     * Run the simulation.
     * @param ml List of Monkeys
     * @param mw watcher of monkey
     * @return int number of rounds taken to get to first monkey
     */

    public static int runSimulation(List<Monkey> ml, MonkeyWatcher mw) {
	int nextMonkey = -1;

	while (!getFirstMonkey(ml).hasBanana()) {
	    mw.incrementRounds();
	    Monkey monk = ml.get(monkeyWithBanana(ml));
	    int num = nextMonkeyAndResize(monk, ml);
	    Monkey monk2 = ml.get(num);
	    Banana banana = monk.throwBananaFrom();
	    monk2.throwBananaTo(banana);
	    String str = stringifyResults(mw.getRounds(), monk, monk2);
	    System.out.println(str);
	}
	System.out.println("First monkey has the banana!");
	return mw.getRounds();
    }

    /**
     * Entry point of program - run MonkeySim.
     * Accepts one argument, the starting monkey
     * number.
     * @param args - Array of arguments from cmd line
     */

    public static void main(String[] args) {
		int start = getStartingMonkeyNum(args);
		Monkey tmpMonkey;
		Banana banana = new Banana();
		MonkeyWatcher mw = new MonkeyWatcher();

		for (int j = 0; j < start + 1; j++) {
			tmpMonkey = new Monkey();
			tmpMonkey.prelistAllPrimeNumbers(Integer.parseInt(args[0]));
			_monkeyList.add(tmpMonkey);
		}
		_monkeyList.get(start).throwBananaTo(banana);

		int numRounds = runSimulation(_monkeyList, mw);
		System.out.println("Completed in " + numRounds + " rounds.");

		System.out.println();
		System.out.println("Starting again...");
		System.out.println();

        x++;

        // create new MonkeyWatcher
        mw = new MonkeyWatcher();

        // pass banana from first monkey to starting monkey
        banana = _monkeyList.get(1).throwBananaFrom();
        _monkeyList.get(start).throwBananaTo(banana);

		numRounds = runSimulation(_monkeyList, mw);
	    System.out.println("Completed in " + numRounds + " rounds.");
    }
}
