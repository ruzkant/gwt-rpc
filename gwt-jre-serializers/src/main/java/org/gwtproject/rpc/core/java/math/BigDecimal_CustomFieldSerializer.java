/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.rpc.core.java.math;

import com.google.gwt.user.client.rpc.SerializationException;
import org.gwtproject.rpc.serialization.api.SerializationStreamReader;
import org.gwtproject.rpc.serialization.api.SerializationStreamWriter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Custom field serializer for BigDecimal.
 */
public class BigDecimal_CustomFieldSerializer {

    /**
     * @param streamReader a SerializationStreamReader instance
     * @param instance the instance to be deserialized
     */
    public static void deserialize(SerializationStreamReader streamReader,
                                   BigDecimal instance) {
    }

    public static BigDecimal instantiate(SerializationStreamReader streamReader)
            throws SerializationException {

        final int scale = streamReader.readInt();
        BigInteger bigInt = BigInteger_CustomFieldSerializer.instantiate(streamReader);
        return new BigDecimal(bigInt, scale);
    }

    public static void serialize(SerializationStreamWriter streamWriter,
                                 BigDecimal instance) throws SerializationException {
        streamWriter.writeInt(instance.scale());
        BigInteger_CustomFieldSerializer.serialize(streamWriter, instance.unscaledValue());
    }
}
