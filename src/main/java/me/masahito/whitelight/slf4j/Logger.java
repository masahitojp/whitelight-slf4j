/*
* Copyright (c) 2014 Masato Nakamura
*
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
*
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
* THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package me.masahito.whitelight.slf4j;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

/**
 * The [White Light SLF4J] package provides a very thin SLF4J wrapper.
 * It is released under a MIT license.
 *
 *  * example:
 *  <pre>   {@code
 *
 *   private static final Logger LOGGER = new Logger(Clazz.class);
 *   private static final Marker MARKER = MarkerFactory.getMarker("Clazz");
 *
 *   public static void main(String[] args) {
 *       LOGGER.info(MARKER, "str");
 *       LOGGER.info(MARKER, "str {} {}", "str1", "str2");
 *   }
 *
 *   }</pre>
 */
public class Logger {

    private final String FQCN = Logger.class.getName();
    private final org.slf4j.Logger logger;

    public Logger(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void debug(final Marker marker, final String message, Object... args) {
        if (logger.isDebugEnabled(marker)) {
            this.log(marker, LocationAwareLogger.DEBUG_INT, message, args);
        }
    }

    public void info(final Marker marker, final String message, Object... args) {
        if (logger.isInfoEnabled(marker)) {
            this.log(marker, LocationAwareLogger.INFO_INT, message, args);
        }
    }

    public void warn(final Marker marker, final String message, Object... args) {
        if (logger.isWarnEnabled(marker)) {
            this.log(marker, LocationAwareLogger.WARN_INT, message, args);
        }
    }

    public void error(final Marker marker, final String message, Object... args) {
        if (logger.isErrorEnabled(marker)) {
            this.log(marker, LocationAwareLogger.ERROR_INT, message, args);
        }
    }

    private void log(final Marker marker, final int levelInt, final String message, final Object[] args) {
        ((LocationAwareLogger) logger).log(marker, FQCN,levelInt, message, args, null);
    }
}
