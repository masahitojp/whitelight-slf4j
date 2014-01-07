whitelight-slf4j
================

The whitelight-slf4j package provides a very thin SLF4J wrapper.

## Usage

<pre>
<code>
  private static final Logger LOGGER = new Logger(Clazz.class);
  private static final Marker MARKER = MarkerFactory.getMarker("Clazz");
  
  public static void main(String[] args) {
      LOGGER.info(MARKER, "str");
      LOGGER.info(MARKER, "str {} {}", "str1", "str2");
  }
</code>
</pre>

## Use with Maven

Coming soon! 

## Prerequisites

* JDK6+

## License

Licensed under the MIT License.
