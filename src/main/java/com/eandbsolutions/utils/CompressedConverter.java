package com.eandbsolutions.utils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CompressedConverter implements DynamoDBTypeConverter<AttributeValue, ByteBuffer> {

    @Override
    public AttributeValue convert(ByteBuffer object) {
        return new AttributeValue().withB(object);
    }

    @Override
    public ByteBuffer unconvert(AttributeValue object) {
        if (object.getB() != null) {
            //ByteBuffer
            return object.getB();
        } else if (object.getS() != null) {
            try {
                System.out.println("Up here");
                return StringCompressionUtil.compressString(object.getS());
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
