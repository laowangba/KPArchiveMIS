package html2doc;
 
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
 
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/**
 * 将html文档转为doc
 * @author soildwang
 *
 */
public class html2doc {
       /**
        * 读取html文件到word
        * @param filepath html文件的路径
        * @return
        * @throws Exception
        */
       public static boolean WriteWordFile(String filepath, String filename) throws Exception {
          boolean flag = false;
          ByteArrayInputStream bais = null;
          FileOutputStream fos = null;
          try {
             if (!"".equals(filepath)) {
                File fileDir = new File(filepath);
                if (fileDir.exists()) {
                   String content = html2doc.readFile(filepath + filename +".html");
                   byte b[] = content.getBytes();
                   bais = new ByteArrayInputStream(b);
                   POIFSFileSystem poifs = new POIFSFileSystem();
                   DirectoryEntry directory = poifs.getRoot();
                   DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
                   fos = new FileOutputStream(filepath + filename + ".doc");
                       poifs.writeFilesystem(fos);
                       bais.close();
                       fos.close();
                    }
                 }
              } catch (IOException e) {
                     e.printStackTrace();
              } finally {
                 if(fos != null) fos.close();
                 if(bais != null) bais.close();
              }
           return flag;
       }
 
       /**
        * 读取html文件到字符串
        * @param filename
        * @return
        * @throws Exception
        */
       public static String readFile(String filename) throws Exception {
              StringBuffer buffer = new StringBuffer("");
              BufferedReader br = null;
              try {
                     br = new BufferedReader(new FileReader(filename));
                     buffer = new StringBuffer();
                     while (br.ready())
                            buffer.append((char) br.read());
              } catch (Exception e) {
                     e.printStackTrace();
              } finally {
                     if(br!=null) br.close();
              }
              return buffer.toString();
       }
      
       public static void main(String[] args) throws Exception {
//              new html2doc().writeWordFile("C:/preview4510.html");
       }
}
