package com.google.zetasketch.internal.hash;

import com.google.common.hash.HashFunction;
import java.nio.charset.StandardCharsets;

/**
 * Library to compute standard 64 bit hashes for values.
 *
 * <p>This library is designed to return specific hashes that are compatible with other programming
 * languages, in particular C++ and Go. This is important so that aggregators that use hashes
 * produce {@code AggregatorStateProto}s that are exchangeable between different implementations.
 */
public final class DefaultHash implements Hash  {
    public static final Hash HASH = new DefaultHash();
    private static final HashFunction HASH_FUNCTION = new Fingerprint2011();
  
    /** Returns the 64 bit hash of the byte array value. */
    public long of(byte[] value) {
      return HASH_FUNCTION.hashBytes(value).asLong();
    }
  
    /** Returns the 64 bit hash of the integer value. */
    public long of(int value) {
      return HASH_FUNCTION.hashInt(value).asLong();
    }
  
    /** Returns the 64 bit hash of the long value. */
    public long of(long value) {
      return HASH_FUNCTION.hashLong(value).asLong();
    }
  
    /** Returns the 64 bit hash of the String value. */
    public long of(String value) {
      return HASH_FUNCTION.hashString(value, StandardCharsets.UTF_8).asLong();
    }
  
    private DefaultHash() {}
  }
  