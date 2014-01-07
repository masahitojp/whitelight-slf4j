package me.masahito.whitelight.slf4j;

import org.junit.Test;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;


public class LoggerTest {

    @Test
    public void testInfo() throws Exception {
        final Logger logger = new Logger(this.getClass());
        final Marker marker = MarkerFactory.getMarker("marker");

        logger.debug(marker, "src {}" , "args");
        logger.info(marker, "src");
        logger.warn(marker, "src");
        logger.error(marker, "src");
    }
}
