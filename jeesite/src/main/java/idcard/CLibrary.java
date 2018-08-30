package idcard;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface CLibrary extends Library {
//    CLibrary INSTANCE = (CLibrary) Native.loadLibrary("dll/ID_Detect", CLibrary.class);
    CLibrary INSTANCE = (CLibrary) Native.loadLibrary("E:\\project\\jeesite\\bin\\dll\\ID_Detect", CLibrary.class);
//    CLibrary INSTANCE = (CLibrary) Native.loadLibrary("E:/project/jeesitebin/dll/ID_Detect", CLibrary.class);
    public Pointer[] result_test(String libpath,String imgpath);
}
