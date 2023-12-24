package test.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

public class AssertUtils {

    private static final Logger LOGGER = LogManager.getLogger(AssertUtils.class);

    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
        LOGGER.info(String.format("%s.\nActual:    %s.\nExpected: %s", reason, actual, matcher));
        MatcherAssert.assertThat(reason, actual, matcher);
    }
}
