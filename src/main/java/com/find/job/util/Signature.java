package com.find.job.util;


import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;

/**
 * This class defines common routines for generating
 * authentication signatures for AWS requests.
 */
public class Signature {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";


    /**
     * Computes RFC 2104-compliant HMAC signature.
     * * @param data
     * The data to be signed.
     *
     * @param key The signing key.
     * @return The Base64-urlSafe encoded RFC 3548-compliant HMAC signature.
     * @throws SignatureException when signature generation fails
     */
    public static String calculateRFC2104HMAC(String data, String key)
            throws SignatureException {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = BaseEncoding.base64Url().encode(rawHmac);
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws SignatureException {
        String token = calculateRFC2104HMAC(" [{\"project_name\": \"\\u6df1\\u5733\\u6885\\u6797\\u4e07\\u79d1\\u4e2d\\u5fc3\", \"batch_id\": 201604131, \"name\": \"\\u5bab\\u4ead\", \"success\": true, \"mobile\": \"18503056932\", \"time\": \"2016-04-13 13:47:55\", \"qr_code\": \"\", \"role_code\": \"LB10001\", \"longitude\": \"0.0\", \"source\": \"lebang\", \"role_name\": \"\\u503c\\u73ed\\u7ecf\\u7406\", \"send_time\": \"2016-04-13 00:00:00\", \"latitude\": \"0.0\", \"type\": \"signin\", \"project_code\": \"44030029\"}, {\"project_name\": \"\\u6df1\\u5733\\u6885\\u6797\\u4e07\\u79d1\\u4e2d\\u5fc3\", \"batch_id\": 201604131, \"name\": \"\\u5bab\\u4ead\", \"success\": true, \"mobile\": \"18503056932\", \"time\": \"2016-04-13 13:47:55\", \"qr_code\": \"\", \"role_code\": \"LB10002\", \"longitude\": \"0.0\", \"source\": \"lebang\", \"role_name\": \"\\u573a\\u6240\\u7ba1\\u7406\\u8d1f\\u8d23\\u4eba\", \"send_time\": \"2016-04-13 00:00:00\", \"latitude\": \"0.0\", \"type\": \"signin\", \"project_code\": \"44030029\"}, {\"project_name\": \"\\u6df1\\u5733\\u6885\\u6797\\u4e07\\u79d1\\u4e2d\\u5fc3\", \"batch_id\": 201604133, \"name\": \"\\u5bab\\u4ead\", \"success\": true, \"mobile\": \"18503056932\", \"time\": \"2016-04-13 13:48:03\", \"qr_code\": \"\", \"role_code\": \"LB10001\", \"longitude\": \"0.0\", \"source\": \"lebang\", \"role_name\": \"\\u503c\\u73ed\\u7ecf\\u7406\", \"send_time\": \"2016-04-13 00:00:00\", \"latitude\": \"0.0\", \"type\": \"signin\", \"project_code\": \"44030029\"}, {\"project_name\": \"\\u6df1\\u5733\\u6885\\u6797\\u4e07\\u79d1\\u4e2d\\u5fc3\", \"batch_id\": 201604133, \"name\": \"\\u5bab\\u4ead\", \"success\": true, \"mobile\": \"18503056932\", \"time\": \"2016-04-13 13:48:03\", \"qr_code\": \"\", \"role_code\": \"LB10002\", \"longitude\": \"0.0\", \"source\": \"lebang\", \"role_name\": \"\\u573a\\u6240\\u7ba1\\u7406\\u8d1f\\u8d23\\u4eba\", \"send_time\": \"2016-04-13 00:00:00\", \"latitude\": \"0.0\", \"type\": \"signin\", \"project_code\": \"44030029\"}]0/api/partner/staffs/attendance", "0d3f9526-e9e1-4d76-9e95-a66bb19ee488");
        System.out.println("Signature.main  " + token);
    }

}