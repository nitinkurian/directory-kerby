package org.haox.asn1;

import org.haox.asn1.type.AbstractAsn1Type;
import org.haox.asn1.type.Asn1Type;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Asn1 decoder
 */
public class Asn1InputBuffer {
    private final LimitedByteBuffer limitedBuffer;

    public Asn1InputBuffer(byte[] bytes) {
        this(new LimitedByteBuffer(bytes));
    }

    public Asn1InputBuffer(ByteBuffer byteBuffer) {
        this(new LimitedByteBuffer(byteBuffer));
    }

    public Asn1InputBuffer(LimitedByteBuffer limitedByteBuffer) {
        this.limitedBuffer = limitedByteBuffer;
    }

    public Asn1Type read() throws IOException {
        if (! limitedBuffer.available()) {
            return null;
        }
        return AbstractAsn1Type.decodeOne(limitedBuffer);
    }
}
