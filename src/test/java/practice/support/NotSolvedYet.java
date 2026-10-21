package practice.support;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.opentest4j.TestAbortedException;

/**
 * Turns "not solved yet" into a <em>skipped</em> test instead of a failed one.
 *
 * <p>Every stub in {@code src/main/java} throws
 * {@code new UnsupportedOperationException("not solved yet")}. Without this handler, every
 * unsolved problem would show as a red failure and hide the problems you are working on.
 * With it, unsolved problems are listed as skipped, and only real mistakes are red.
 *
 * <p>When running against the reference solutions ({@code -Psolutions}), nothing is skipped:
 * a missing solution is a real failure there.
 */
public final class NotSolvedYet implements TestExecutionExceptionHandler {

    public static final String MESSAGE = "not solved yet";

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable thrown) throws Throwable {
        boolean runningSolutions = Boolean.getBoolean("practice.solutions");
        if (!runningSolutions && thrown instanceof UnsupportedOperationException && MESSAGE.equals(thrown.getMessage())) {
            throw new TestAbortedException("not solved yet: write your solution, then run this test again");
        }
        throw thrown;
    }
}
