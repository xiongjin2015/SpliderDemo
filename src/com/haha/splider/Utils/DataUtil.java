
package com.haha.splider.Utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public final class DataUtil {

    /**
     * 返回该url地址的html数据
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public static String doGet(String urlStr) throws Exception {

        System.out.println("access url :" + urlStr);

        StringBuffer sb = new StringBuffer(); // is thread safe;
        InputStream in = null;
        InputStreamReader isr = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
            conn.setRequestProperty("User-Agent", "haha http/2.0");
            conn.setRequestProperty("Connection", "Close");

            int respCode = conn.getResponseCode();
            String encoding = conn.getContentEncoding();

            if (respCode == 200) {

                if (encoding != null && encoding.toLowerCase().contains("gzip")) {
                    in = new GZIPInputStream(new BufferedInputStream(
                            conn.getInputStream()));
                } else {
                    in = new BufferedInputStream(conn.getInputStream());
                }

                isr = new InputStreamReader(in, "UTF-8");

                int len = 0;
                char[] buf = new char[1024 * 16];

                while ((len = isr.read(buf)) != -1) {
                    sb.append(new String(buf, 0, len));
                }
            } else {
                throw new Exception("访问网络异常,respCode:" + respCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("访问网络异常");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e) {
            }
        }

        return sb.toString();
    }

    public static String ToDBC(String input)
    {
      char[] c = input.toCharArray();
      for (int i = 0; i < c.length; i++) {
        if (c[i] == ' ') {
          c[i] = ' ';
        } else if ((c[i] > 65280) && (c[i] < 65375)) {
          c[i] = ((char)(c[i] - 65248));
        }
      }
      return new String(c);
    }

}
