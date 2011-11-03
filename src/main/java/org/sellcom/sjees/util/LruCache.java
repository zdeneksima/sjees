/*
 * Copyright 2011 sellcom.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sellcom.sjees.util;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.sellcom.sjees.annotations.NotApi;

@NotApi
public class LruCache<K, V> implements Map<K, V> {

	private final int cacheSize;

	private Map<K, V> entries;


	public LruCache(final int size) {
		cacheSize = size + 1;

		entries = Collections.synchronizedMap(new LinkedHashMap<K, V>(cacheSize, 1.0F, true) {
			private static final long serialVersionUID = -5008036535023262234L;

			@Override
			protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
				return super.size() > cacheSize;
			}
		});
	}


	@Override
	public void clear() {
		entries.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return entries.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return entries.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return entries.entrySet();
	}

	@Override
	public V get(Object key) {
		return entries.get(key);
	}

	@Override
	public boolean isEmpty() {
		return entries.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return entries.keySet();
	}

	@Override
	public V put(K key, V value) {
		return entries.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		entries.putAll(map);
	}

	@Override
	public V remove(Object key) {
		return entries.remove(key);
	}

	@Override
	public int size() {
		return entries.size();
	}

	@Override
	public Collection<V> values() {
		return entries.values();
	}

}
