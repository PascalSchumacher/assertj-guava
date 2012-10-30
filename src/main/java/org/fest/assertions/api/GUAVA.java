package org.fest.assertions.api;

import com.google.common.collect.Multimap;

/**
 * The entry point for all Guava assertions.
 * 
 * @author @marcelfalliere
 * @author @miralak
 * @author Joel Costigliola
 */
public class GUAVA extends Assertions {

  public static <K, V> MultimapAssert<K, V> assertThat(Multimap<K, V> actual) {
    return new MultimapAssert<K, V>(actual);
  }

}