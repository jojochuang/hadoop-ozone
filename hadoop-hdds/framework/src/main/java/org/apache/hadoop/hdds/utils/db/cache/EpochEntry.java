/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.hadoop.hdds.utils.db.cache;

import java.util.Objects;

/**
 * Class used which describes epoch entry. This will be used during deletion
 * entries from cache for partial table cache.
 * @param <CACHEKEY>
 */
public class EpochEntry<CACHEKEY> implements Comparable<CACHEKEY> {

  private long epoch;
  private CACHEKEY cachekey;

  EpochEntry(long epoch, CACHEKEY cachekey) {
    this.epoch = epoch;
    this.cachekey = cachekey;
  }

  public long getEpoch() {
    return epoch;
  }

  public CACHEKEY getCachekey() {
    return cachekey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EpochEntry<?> that = (EpochEntry<?>) o;
    return epoch == that.epoch && Objects.equals(cachekey, that.cachekey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epoch, cachekey);
  }

  @Override
  public int compareTo(Object o) {
    if(this.epoch == ((EpochEntry<?>)o).epoch) {
      return 0;
    } else if (this.epoch < ((EpochEntry<?>)o).epoch) {
      return -1;
    } else {
      return 1;
    }
  }

}
