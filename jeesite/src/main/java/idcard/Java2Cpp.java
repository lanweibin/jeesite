package idcard;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.thinkgem.jeesite.common.config.Global;

public class Java2Cpp {
    public static void main(String[] args) {

//        String libpath = "E:/project/idcard/bin/dll";
////		String libpath = "E:\\project\\jeesite\\bin\\dll\\ID_Detect";
//        String filepath = "E:\\project\\idcard\\1.jpg";

//        String libpath = "E:\\project\\idcard\\bin\\dll";
//        String libpath = "E:/project/jeesite/src/bin/dll";

//        String libpath = "E:\\project\\jeesite\\bin\\dll";

        String libpath = "E:/project/jeesite/bin/dll";
        String filepath = "E:/project/idcard/1.jpg";
        System.out.println(System.getProperty("file.encoding"));

        Pointer[] arr = CLibrary.INSTANCE.result_test(libpath, filepath);
        int len = arr.length;
        System.out.println(len);
        for (int i = 0; i < 5; i++) {
            try {
//				String str =  arr[i].getString(0, "UTF-8");
                String str = arr[i].getString(0, Boolean.parseBoolean("UTF-8"));
                System.out.println(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //-Dfile.encoding=UTF-8
    }
}
