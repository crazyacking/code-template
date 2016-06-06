import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        String sourceFolderName="D:\\Desktop\\file\\"; // ��Ҫ����ת��������ļ���
        String targetFolderName="D:\\Desktop\\output\\"; // ת����д�뵽��Ŀ���ļ���
        File folder=new File(sourceFolderName);
        File[] files=folder.listFiles();
        for(int i=0;i<files.length;++i){
            String newFileName=targetFolderName+files[i].getName();
            Main.transferFile(sourceFolderName+files[i].getName(),newFileName);
        }
    }

    private static void transferFile(String srcFileName, String destFileName) throws IOException {
        String line_separator = System.getProperty("line.separator");
        FileInputStream fis = new FileInputStream(srcFileName);
        StringBuffer content = new StringBuffer();
        DataInputStream in = new DataInputStream(fis);
        BufferedReader d = new BufferedReader(new InputStreamReader(in, "GBK"));// , "UTF-8"
        String line = null;
        while ((line = d.readLine()) != null)
            content.append(line + line_separator);
        d.close();
        in.close();
        fis.close();

        Writer ow = new OutputStreamWriter(new FileOutputStream(destFileName), "utf-8");
        ow.write(content.toString());
        ow.close();
    }
}
