/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */


package org.clank.java;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.clank.java.std.strlen;
import org.clank.java.std_time.timespec;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;

/**
 *
 * @author vvoskres
 */
public class io extends io_ioctl implements std_defines, io_defines, mman_defines, io_limits {
  private static final Path ROOT_PATH = Paths.get("/");

  protected io() {
  }
  
  //private enum CheckFormatStringState {
  //  INIT,
  //  AFTER_PERCENT
  //};
  public static String Cpp2JavaFormatString(String cpp) {
    String java = cpp;
  //  // %.NUM => %N in java
  //  // %.* => %* in java
  //  if (cpp.contains("%.")) {
  //    CheckFormatStringState state = CheckFormatStringState.INIT;
  //    StringBuilder out = new StringBuilder();
  //    for (int i = 0; i < cpp.length(); i++) {
  //      char ch = cpp.charAt(i);
  //      // we want to skip only . after formatting percent
  //      switch(ch) {
  //        case '%':
  //          switch (state) {
  //            case INIT:
  //              state = CheckFormatStringState.AFTER_PERCENT;
  //              break;
  //            case AFTER_PERCENT:
  //              break;
  //            default:
  //              throw new AssertionError(state.name());
  //          }
  //        case '.':
  //        default:
  //          state = CheckFormatStringState.INIT;
  //      }
  //      out.append(ch);
  //    }
  //  }
    return java;
  }
  
  public static Object[] prepareArgsForPrintf(Object ... objects) {
    int i = 0;
    for (Object obj : objects) {
      if (obj instanceof char$ptr) {
        objects[i] = Casts.toJavaString((char$ptr) obj);
      }
      ++i;
    }
    return objects;
  }

  private static final ThreadLocal<AtomicInteger> errnoVal = new ThreadLocal<AtomicInteger>() {

    @Override
    protected AtomicInteger initialValue() {
      return new AtomicInteger(0);
    }

  };
  public static int errno() {
    return errnoVal.get().get();
  }

  public static int setErrno(int errno) {
    errnoVal.get().set(errno);
    return errno;
  }
  
  public static final istream cin;
  public static final ostream cout;
  public static final ostream cerr;
  public static final FILE stdin;  /* Standard input stream.  */
  public static final FILE stdout; /* Standard output stream.  */
  public static final FILE stderr; /* Standard error output stream.  */
  public static final NativeCallback.Void2String endl;
  static {
    cin = new StreamIn(System.in);
    cout = new StreamOut(System.out);
    cerr = new StreamOut(System.err);
    stdin = new FILE(STDIN_FILENO);
    stdout = new FILE(STDOUT_FILENO);
    stderr = new FILE(STDERR_FILENO);
    endl = ()->{ return "\n"; };
  }
  
//  public static final FILE stdin;  /* Standard input stream.  */
//  public static final FILE stdout; /* Standard output stream.  */
//  public static final FILE stderr; /* Standard error output stream.  */
//  static {
//    stdin = new FILE();
//    stdout = new FILE();
//    stderr = new FILE();
//  }

  public static class basic_ifstream implements basic_istream, Destructors.ClassWithDestructor {

    public basic_ifstream(/*const char P*/char$ptr filePath) {
    }

    @Override
    public boolean eof() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean fail() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getline(std.string to) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean is_open() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  public interface basic_ios {
    public default boolean good() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  public interface basic_istream extends basic_ios, Destructors.ClassWithDestructor {

    public boolean eof();

    public boolean fail();

    public int getline(std.string to);
    
  }
  
  public static class basic_stringstream implements basic_ostream {

    @Override
    public <T> basic_ostream $out(T o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(NativeCallback.Void2String o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(byte o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(char o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(int o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out_int(int o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(long o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(double o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(char$ptr str) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(char$ptr str, int Len) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out_os_str(std.string str) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(String format, Object... args) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream write(char$ptr data, int size) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String str() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void $destroy() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  public interface istream extends basic_istream {
    
  }
  
  public interface basic_ostream extends Destructors.ClassWithDestructor {
    public <T> basic_ostream $out(T o);
    public basic_ostream $out(NativeCallback.Void2String o);
    public basic_ostream $out(byte o);
    public basic_ostream $out(char o);
    public basic_ostream $out(int o);
    public basic_ostream $out_int(int o);
    public basic_ostream $out(long o);
    public basic_ostream $out(double o);
    public basic_ostream $out(char$ptr str);
    public basic_ostream $out(char$ptr str, /*uint*/int Len);
    public basic_ostream $out_os_str(std.string str);
    public basic_ostream $out(String format, Object... args);
    public basic_ostream write(char$ptr data, int size);
  }
  public static basic_ostream $out_os_char$ptr$C(basic_ostream out, char$ptr o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_char$ptr$C(basic_ostream out, String o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_byte(basic_ostream out, byte o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_char(basic_ostream out, char o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_int(basic_ostream out, int o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_long(basic_ostream out, long o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_ulong(basic_ostream out, long o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_string$C(basic_ostream out, std.string o) {
    return out.$out_os_str(o);
  }
  
  public interface ostream extends basic_ostream {
    
  }
  
  public static class ostringstream implements basic_ostream {

    @Override
    public <T> basic_ostream $out(T o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(NativeCallback.Void2String o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(byte o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(char o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(int o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out_int(int o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(long o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(double o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(char$ptr str) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(char$ptr str, int Len) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out_os_str(std.string str) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(String format, Object... args) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream write(char$ptr data, int size) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public std.string str() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void $destroy() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  public interface iostream extends istream, ostream {
    
  }

  public static int fprintf(FILE fOut, char$ptr format, Object... args) {
    return fprintf(fOut, Native.$toString(format), args);
  }
  
  public static int fprintf(FILE fOut, CharSequence format, Object... args) {
    // TODO: make it effective
    StringWriter sw = new StringWriter();
    final String Fmt = Cpp2JavaFormatString(format.toString());
    try (PrintWriter writer = new PrintWriter(sw)) {
      writer.printf(Fmt, prepareArgsForPrintf(args));
    } catch (UnknownFormatConversionException e) {
      // no luck with format string...
      NativeTrace.registerReason(e);
      NativeTrace.traceNotImplemented("This format string is not supported: " + Fmt);
    }
    String toWrite = sw.toString();
    OpenedFile F = getOpenedFileImpl(fOut.$FD);
    
    try {
      F.writeBytes(toWrite);
    } catch (IOException ex) {
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      return -1;
    }
    return toWrite.length();
  }
  
  public static int fprintf(ostream stderr, CharSequence format, Object... args) {
    return fprintf(stderr, format.toString(), args);
  }
  
  public static int fprintf(ostream stderr, String format, Object... args) {
    stderr.$out(format, args);
    // FIXME: return number of characters written or negative value in case of fail
    return 1;
  }

  public static int printf(char$ptr format, Object...args) {
    return printf(Casts.toJavaString(format), args);
  }

  public static int printf(String format, Object...args) {
    cout.$out(format, args);
    // FIXME: return number of characters written or negative value in case of fail
    return 1; 
  }
  
  /* Write formatted output to S from argument list ARG.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static int vfprintf (FILE /*P*/__s, char$ptr __format,
           type$ptr __arg) {
    return vfprintf(__s, Casts.toJavaString(__format), __arg);
  }
  public static int vfprintf (FILE /*P*/__s, String __format,
           type$ptr __arg) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Write formatted output to stdout from argument list ARG.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static int vprintf (char$ptr __format, type$ptr __arg) {
    return vprintf(Casts.toJavaString(__format), __arg);
  }
  public static int vprintf (String __format, type$ptr __arg) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Write formatted output to S from argument list ARG.  */
  public static int vsprintf (char$ptr __s, char$ptr __format,
           type$ptr __arg) {
    return vsprintf(__s, Casts.toJavaString(__format), __arg);
  }
  public static int vsprintf (char$ptr __s, String __format,
           type$ptr __arg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /**
   * int snprintf ( char * s, size_t n, const char * format, ... );
   *
   * Write formatted output to sized buffer
   * Composes a string with the same text that would be printed if format was used on printf, but instead of being printed, the content is stored as a C string in the buffer pointed by s (taking n as the maximum buffer capacity to fill).
   *
   * If the resulting string would be longer than n-1 characters, the remaining characters are discarded and not stored, but counted for the value returned by the function.
   *
   * A terminating null character is automatically appended after the content written.
   *
   * After the format parameter, the function expects at least as many additional arguments as needed for format.
   */
  public static int snprintf(char$ptr s, /*uint*/int n, char$ptr format, Object ... objects) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printer = new PrintStream(out);
    final String Fmt = Cpp2JavaFormatString(Casts.toJavaString(format));
    try {
      printer.printf(Fmt, prepareArgsForPrintf(objects));
    } catch (UnknownFormatConversionException e) {
      // no luck with format string...
      NativeTrace.registerReason(e);
      NativeTrace.traceNotImplemented("This format string is not supported: " + Fmt);
    }
    printer.flush();
    printer.close();
    byte[] res = out.toByteArray();
    for(int i = 0; i < res.length && i < n; i++) {
      s.$set(res[i]);
      s.$preInc();
    }
    return Math.min(res.length, n);
  }
  public static int snprintf(byte s[], /*uint*/int n, char$ptr format, Object ... objects) {
    return snprintf(create_char$ptr(s), n, format, objects);
  }
  
  public static basic_ostream $out_os_T(basic_ostream out, byte o) {
    return out.$out(o);
  }
  
  /* Write a character to stdout.  */
  public static int putchar(int __c) {
    cout.$out($int2ushort(__c));
    return  __c;
  }
  
  /* Write a string, followed by a newline, to stdout.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static int puts(final char$ptr __s) {
    cout.$out(()->Casts.toJavaString(__s));
    cout.$out('\n');
    return 1;
  }
  
  /**
   * 
   * @param out
   * @param o
   * @return 
   */
  public static basic_ostream $out_os_T(basic_ostream out, char o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_T(basic_ostream out, int o) {
    return out.$out(o);
  }
  public static basic_ostream $out_os_T(basic_ostream out, long o) {
    return out.$out(o);
  }
  public static <T> basic_ostream $out_os_T(basic_ostream out, T o) {
    return out.$out(o);
  }
  
  public static basic_ostream $out_os_str(basic_ostream out, std.string o) {
    return out.$out_os_str(o);
  }
  
  
  public static int getline(basic_istream in, std.string to) {
    return in.getline(to);
  }
  
  public static int getline_is_string(basic_istream in, std.string to) {
    return in.getline(to);
  }
  
  /**
   * realpath() expands all symbolic links and resolves references to /./, /../
   * and extra '/' characters in the null-terminated string named by path to
   * produce a canonicalized absolute pathname. The resulting pathname is stored
   * as a null-terminated string, up to a maximum of PATH_MAX bytes, in the
   * buffer pointed to by resolved_path. The resulting path will have no
   * symbolic link, /./ or /../ components.
   *
   * If resolved_path is specified as NULL, then realpath() uses malloc(3) to
   * allocate a buffer of up to PATH_MAX bytes to hold the resolved pathname,
   * and returns a pointer to this buffer. The caller should deallocate this
   * buffer using free(3). 
   * 
   * Return Value
   *
   * If there is no error, realpath() returns a pointer to the resolved_path.
   *
   * Otherwise, it returns a NULL pointer, the contents of the array
   * resolved_path are undefined, and errno is set to indicate the error. 
   * 
   * Errors
   *
   * EACCES
   *
   * Read or search permission was denied for a component of the path prefix.
   *
   * EINVAL
   *
   * path is NULL. (In glibc versions before 2.3, this error is also returned if
   * resolved_path is NULL.)
   *
   * EIO
   *
   * An I/O error occurred while reading from the file system.
   *
   * ELOOP
   *
   * Too many symbolic links were encountered in translating the pathname.
   * ENAMETOOLONG A component of a pathname exceeded NAME_MAX characters, or an
   * entire pathname exceeded PATH_MAX characters. ENOENT
   *
   * The named file does not exist. ENOTDIR A component of the path prefix is
   * not a directory.
   *
   * @param name
   * @param buf
   * @return 
   */
  public static char$ptr realpath(char$ptr name, /*char*/byte buf[]) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate open request to custom FS impl?";
    if (name == null) {
      setErrno(EINVAL);
      return null;
    }
    String fileName = Native.$toString(name);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("realpath requested for:" + fileName, NativeTrace.TRACE_IO);
    Path filePath = resolvePathByFileName(fileName);
    setErrno(0);
    try {
      Path realPath = filePath.toRealPath();
      char$ptr realPathPtr = create_char$ptr_utf8(realPath.toString());
      std.memcpy(buf, 0, realPathPtr.$array(), 0, std.strlen(realPathPtr));
      return create_char$ptr(buf);
    } catch (Throwable e) {
      setErrno(EIO);
    }
    return null;
  }

  private static Path resolvePathByFileName(String fileName) {
    if (fileName.startsWith("\\") || fileName.startsWith("/") || 
       (fileName.length() > 1 && fileName.charAt(1) == ':')) {
      return ROOT_PATH.resolve(fileName);
    }
    return Paths.get(CWD.get().get(), fileName);
  }

  public static int readlink(char$ptr name, /*char*/byte buf[]) {
    throw new UnsupportedOperationException();
  }  
  
  /**
   * The write() function shall attempt to write nbyte bytes from the buffer
   * pointed to by buf to the file associated with the open file descriptor,
   * fildes.
   *
   * Before any action described below is taken, and if nbyte is zero and the
   * file is a regular file, the write() function may detect and return errors
   * as described below. In the absence of errors, or if error detection is not
   * performed, the write() function shall return zero and have no other
   * results. If nbyte is zero and the file is not a regular file, the results
   * are unspecified.
   *
   * On a regular file or other file capable of seeking, the actual writing of
   * data shall proceed from the position in the file indicated by the file
   * offset associated with fildes. Before successful return from write(), the
   * file offset shall be incremented by the number of bytes actually written.
   * On a regular file, if this incremented file offset is greater than the
   * length of the file, the length of the file shall be set to this file
   * offset.
   *
   * On a file not capable of seeking, writing shall always take place starting
   * at the current position. The value of a file offset associated with such a
   * device is undefined.
   *
   * If the O_APPEND flag of the file status flags is set, the file offset shall
   * be set to the end of the file prior to each write and no intervening file
   * modification operation shall occur between changing the file offset and the
   * write operation.
   *
   * If a write() requests that more bytes be written than there is room for
   * (for example, the process' file size limit or the physical end of a
   * medium), only as many bytes as there is room for shall be written. For
   * example, suppose there is space for 20 bytes more in a file before reaching
   * a limit. A write of 512 bytes will return 20. The next write of a non-zero
   * number of bytes would give a failure return (except as noted below).
   *
   * If the request would cause the file size to exceed the soft file size limit
   * for the process and there is no room for any bytes to be written, the
   * request shall fail and the implementation shall generate the SIGXFSZ signal
   * for the thread.
   *
   * If write() is interrupted by a signal before it writes any data, it shall
   * return -1 with errno set to [EINTR].
   *
   * If write() is interrupted by a signal after it successfully writes some
   * data, it shall return the number of bytes written.
   *
   * If the value of nbyte is greater than {SSIZE_MAX}, the result is
   * implementation-defined.
   *
   * After a write() to a regular file has successfully returned:
   *   Any successful read() from each byte position in the file that was modified
   *   by that write shall return the data specified by the write() for that
   *   position until such byte positions are again modified.
   *  
   *   Any subsequent successful write() to the same byte position in the file
   *   shall overwrite that file data.
   * 
   * Write requests to a pipe or FIFO shall be handled in the same way as a
   * regular file with the following exceptions:
   * 
   *   There is no file offset associated with a pipe, hence each write request
   *   shall append to the end of the pipe.
   *  
   *   Write requests of {PIPE_BUF} bytes or less shall not be interleaved with
   *   data from other processes doing writes on the same pipe. Writes of greater
   *   than {PIPE_BUF} bytes may have data interleaved, on arbitrary boundaries,
   *   with writes by other processes, whether or not the O_NONBLOCK flag of the
   *   file status flags is set.
   *  
   *   If the O_NONBLOCK flag is clear, a write request may cause the thread to
   *   block, but on normal completion it shall return nbyte.
   *  
   *   If the O_NONBLOCK flag is set, write() requests shall be handled
   *   differently, in the following ways:
   *  
   *   The write() function shall not block the thread.
   *  
   *   A write request for {PIPE_BUF} or fewer bytes shall have the following
   *   effect: if there is sufficient space available in the pipe, write() shall
   *   transfer all the data and return the number of bytes requested. Otherwise,
   *   write() shall transfer no data and return -1 with errno set to [EAGAIN].
   *  
   *   A write request for more than {PIPE_BUF} bytes shall cause one of the
   *   following:
   *  
   *   When at least one byte can be written, transfer what it can and return the
   *   number of bytes written. When all data previously written to the pipe is
   *   read, it shall transfer at least {PIPE_BUF} bytes.
   *  
   *   When no data can be written, transfer no data, and return -1 with errno set
   *   to [EAGAIN].
   * 
   * 
   * Upon successful completion, where nbyte is greater than 0, write() shall
   * mark for update the st_ctime and st_mtime fields of the file, and if the
   * file is a regular file, the S_ISUID and S_ISGID bits of the file mode may
   * be cleared.
   *
   * For regular files, no data transfer shall occur past the offset maximum
   * established in the open file description associated with fildes.
   *
   * If fildes refers to a socket, write() shall be equivalent to send() with no
   * flags set.
   *
   * If the O_DSYNC bit has been set, write I/O operations on the file
   * descriptor shall complete as defined by synchronized I/O data integrity
   * completion.
   *
   * If the O_SYNC bit has been set, write I/O operations on the file descriptor
   * shall complete as defined by synchronized I/O file integrity completion.
   *
   * If fildes refers to a shared memory object, the result of the write()
   * function is unspecified.
   *
   * If fildes refers to a typed memory object, the result of the write()
   * function is unspecified.
   *
   * If fildes refers to a STREAM, the operation of write() shall be determined
   * by the values of the minimum and maximum nbyte range (packet size) accepted
   * by the STREAM. These values are determined by the topmost STREAM module. If
   * nbyte falls within the packet size range, nbyte bytes shall be written. If
   * nbyte does not fall within the range and the minimum packet size value is
   * 0, write() shall break the buffer into maximum packet size segments prior
   * to sending the data downstream (the last segment may contain less than the
   * maximum packet size). If nbyte does not fall within the range and the
   * minimum value is non-zero, write() shall fail with errno set to [ERANGE].
   * Writing a zero-length buffer ( nbyte is 0) to a STREAMS device sends 0
   * bytes with 0 returned. However, writing a zero-length buffer to a
   * STREAMS-based pipe or FIFO sends no message and 0 is returned. The process
   * may issue I_SWROPT ioctl() to enable zero-length messages to be sent across
   * the pipe or FIFO.
   *
   * When writing to a STREAM, data messages are created with a priority band of
   * 0. When writing to a STREAM that is not a pipe or FIFO:
   *   If O_NONBLOCK is clear, and the STREAM cannot accept data (the STREAM write
   *   queue is full due to internal flow control conditions), write() shall block
   *   until data can be accepted.
   *  
   *   If O_NONBLOCK is set and the STREAM cannot accept data, write() shall
   *   return -1 and set errno to [EAGAIN].
   *  
   *   If O_NONBLOCK is set and part of the buffer has been written while a
   *   condition in which the STREAM cannot accept additional data occurs, write()
   *   shall terminate and return the number of bytes written.
   * 
   * In addition, write() shall fail if the STREAM head has processed an
   * asynchronous error before the call. In this case, the value of errno does
   * not reflect the result of write(), but reflects the prior error.
   *
   * The pwrite() function shall be equivalent to write(), except that it writes
   * into a given position without changing the file pointer. The first three
   * arguments to pwrite() are the same as write() with the addition of a fourth
   * argument offset for the desired position inside the file. 
   * 
   * Return Value
   * Upon successful completion, write() and pwrite() shall return the number of
   * bytes actually written to the file associated with fildes. This number
   * shall never be greater than nbyte. Otherwise, -1 shall be returned and
   * errno set to indicate the error.
   * 
   * Errors
   * 
   * The write() and pwrite() functions shall fail if:
   * 
   * EAGAIN
   *     The O_NONBLOCK flag is set for the file descriptor and the thread would be delayed in the write() operation. 
   * EBADF
   *     The fildes argument is not a valid file descriptor open for writing. 
   * EFBIG
   *     An attempt was made to write a file that exceeds the implementation-defined maximum file size or the process' file size limit, and there was no room for any bytes to be written. 
   * EFBIG
   *     The file is a regular file, nbyte is greater than 0, and the starting position is greater than or equal to the offset maximum established in the open file description associated with fildes. 
   * EINTR
   *     The write operation was terminated due to the receipt of a signal, and no data was transferred. 
   * EIO
   *     The process is a member of a background process group attempting to write to its controlling terminal, TOSTOP is set, the process is neither ignoring nor blocking SIGTTOU, and the process group of the process is orphaned. This error may also be returned under implementation-defined conditions. 
   * ENOSPC
   *     There was no free space remaining on the device containing the file. 
   * EPIPE
   *     An attempt is made to write to a pipe or FIFO that is not open for reading by any process, or that only has one end open. A SIGPIPE signal shall also be sent to the thread. 
   * ERANGE
   *     The transfer request size was outside the range supported by the STREAMS file associated with fildes.
   * 
   * The write() function shall fail if:
   * 
   * EAGAIN or EWOULDBLOCK
   * 
   *     The file descriptor is for a socket, is marked O_NONBLOCK, and write would block. 
   * ECONNRESET
   *     A write was attempted on a socket that is not connected. 
   * EPIPE
   *     A write was attempted on a socket that is shut down for writing, or is no longer connected. In the latter case, if the socket is of type SOCK_STREAM, the SIGPIPE signal is generated to the calling process.
   * 
   * The write() and pwrite() functions may fail if:
   * 
   * EINVAL
   *     The STREAM or multiplexer referenced by fildes is linked (directly or indirectly) downstream from a multiplexer. 
   * EIO
   *     A physical I/O error has occurred. 
   * ENOBUFS
   *     Insufficient resources were available in the system to perform the operation. 
   * ENXIO
   *     A request was made of a nonexistent device, or the request was outside the capabilities of the device. 
   * ENXIO
   *     A hangup occurred on the STREAM being written to.
   * 
   * A write to a STREAMS file may fail if an error message has been received at the STREAM head. In this case, errno is set to the value included in the error message.
   * 
   * The write() function may fail if:
   * 
   * EACCES
   *     A write was attempted on a socket and the calling process does not have appropriate privileges. 
   * ENETDOWN
   *     A write was attempted on a socket and the local network interface used to reach the destination is down. 
   * ENETUNREACH
   * 
   *     A write was attempted on a socket and no route to the network is present.
   * 
   * The pwrite() function shall fail and the file pointer remain unchanged if:
   * 
   * EINVAL
   *     The offset argument is invalid. The value is negative. 
   * ESPIPE
   *     fildes is associated with a pipe or FIFO.
   */
  public static long write(int fildes, char$ptr buf, int bufIdxFrom, /*size_t*/int __nbytes) {
    if (NativeTrace.TRACE_IO) NativeTrace.trace("write requested for " + fildes, NativeTrace.TRACE_IO);
    return pwrite(fildes, buf, bufIdxFrom, __nbytes, Long.MIN_VALUE);
  }
  public static long pwrite(int fildes, char$ptr __buf, int bufIdxFrom, /*size_t*/int __nbytes, long/*__off_t*/ __offset) {
    byte buffer[];
    int offset;
    if (__buf instanceof char$ptr$array) {
      buffer = __buf.$array();
      offset = bufIdxFrom;
    } else {
      offset = 0;
      buffer = new$char(__nbytes);
      char$ptr first = __buf;
      for (int i = 0, j = bufIdxFrom; i < __nbytes; i++, j++) {
        buffer[i] = first.$at(j);
      }
    }
    return pwrite(fildes, buffer, offset, __nbytes, __offset);
  }
  
  public static long write(int fildes, byte[] buffer, int bufOffset, /*size_t*/int __nbytes) {  
    if (NativeTrace.TRACE_IO) NativeTrace.trace("write byte[] requested for " + fildes, NativeTrace.TRACE_IO);
    return pwrite(fildes, buffer, bufOffset, __nbytes, Long.MIN_VALUE);
  }
  
  /* Write N bytes of BUF to FD.  Return the number written, or -1.

   This function is a cancellation point and therefore not marked with
   __THROW.  */
  public static long write(int __fd, char$ptr __buf, /*size_t*/int __n) {
    return write(__fd, __buf, 0, __n);
  }
  
  public static long pwrite(int fildes, byte[] buffer, int bufOffset, /*size_t*/int __nbytes, long/*__off_t*/ __file_offset) {  
    OpenedFile openedFile = getOpenedFileImpl(fildes);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("pwrite requested " + __nbytes + " bytes " + (__file_offset != Long.MIN_VALUE ? "from " + __file_offset : "from the last") + " position for " + fildes + ":" + openedFile, NativeTrace.TRACE_IO);
    setErrno(0);
    if (openedFile == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "pread not opened {0}", fildes);
      setErrno(EBADF);
      return -1;
    }
    if (__nbytes == 0) {
      return 0;
    }
    // seek to position
    long savedPosition = 0;
    if (__file_offset != Long.MIN_VALUE) {
      try {
        savedPosition = openedFile.position();
        openedFile.seek(__file_offset);
      } catch (IOException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
        setErrno(EOVERFLOW);
        return -1;
      }
    }
    long written = __nbytes;
    try {
      openedFile.write(buffer, bufOffset, (int)__nbytes);
    } catch (IOException ex) {
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      return -1;
    }
  
    if (__file_offset != Long.MIN_VALUE) {
      try {
        // restore position
        openedFile.seek(savedPosition);
      } catch (IOException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
        setErrno(EOVERFLOW);
        return -1;
      }
    }
    return written;
  }
  
  /**
   * The lseek() function shall set the file offset for the open file
   * description associated with the file descriptor fildes, as follows:
   *
   *
   * If whence is SEEK_SET, the file offset shall be set to offset bytes.
   *
   * If whence is SEEK_CUR, the file offset shall be set to its current location
   * plus offset.
   *
   * If whence is SEEK_END, the file offset shall be set to the size of the file
   * plus offset.
   *
   * The symbolic constants SEEK_SET, SEEK_CUR, and SEEK_END are defined in
   * <unistd.h>.
   *
   * The behavior of lseek() on devices which are incapable of seeking is
   * implementation-defined. The value of the file offset associated with such a
   * device is undefined.
   *
   * The lseek() function shall allow the file offset to be set beyond the end
   * of the existing data in the file. If data is later written at this point,
   * subsequent reads of data in the gap shall return bytes with the value 0
   * until data is actually written into the gap.
   *
   * The lseek() function shall not, by itself, extend the size of a file.
   *
   * If fildes refers to a shared memory object, the result of the lseek()
   * function is unspecified.
   *
   * If fildes refers to a typed memory object, the result of the lseek()
   * function is unspecified.
   * 
   * Return Value
   *
   * Upon successful completion, the resulting offset, as measured in bytes from
   * the beginning of the file, shall be returned. Otherwise, (off_t)-1 shall be
   * returned, errno shall be set to indicate the error, and the file offset
   * shall remain unchanged.
   *
   * Errors
   * 
   * The lseek() function shall fail if:
   * 
   * EBADF
   *     The fildes argument is not an open file descriptor. 
   * EINVAL
   *     The whence argument is not a proper value, or the resulting file offset would be negative for a regular file, block special file, or directory. 
   * EOVERFLOW
   *     The resulting file offset would be a value which cannot be represented correctly in an object of type off_t. 
   * ESPIPE
   *     The fildes argument is associated with a pipe, FIFO, or socket.
   * 
   * @param fildes
   * @param offset
   * @param whence
   * @return 
   */
  public static long/*off_t*/ lseek(int fildes, long/*off_t*/ offset, int whence) {
    OpenedFile openedFile = getOpenedFileImpl(fildes);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("lseek to position " + offset + " for " + fildes + ":" + openedFile, NativeTrace.TRACE_IO);
    setErrno(0);
    if (openedFile == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "lseek not opened {0}", fildes);
      setErrno(EBADF);
      return -1;
    }
    if (offset < 0 || offset == Long.MIN_VALUE) {
      setErrno(EINVAL);
      return -1;
    }        
    if (openedFile.file == null) {
      assert fildes <= STDERR_FILENO;
      // standard streams are checked only by 0 offset
      if (offset != 0) {
        setErrno(EOVERFLOW);
        return -1;        
      }
      // standard streams are not seekable
      return whence == SEEK_CUR ? -1 : 0;
    }
    
    // seek to position
    long savedPosition = 0;
    try {
      savedPosition = openedFile.position();
      openedFile.seek(offset);
    } catch (IOException ex) {      
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      try {
        // try to restore position on fail
        openedFile.seek(savedPosition);
      } catch (IOException ex1) {
        Logger.getLogger(io.class.getName()).log(Level.SEVERE, null, ex1);
      }
      setErrno(EOVERFLOW);
      return -1;
    }
    return offset;
  }
  
  /**
   * read()  attempts to read up to count bytes from file descriptor fd into
   * the buffer starting at buf.
   *
   * If count is zero, read() returns zero and has  no  other	 results.   If
   * count is greater than SSIZE_MAX, the result is unspecified. 
   * 
   * @param __fd
   * @param buf
   * @param __nbytes
   * @return 
   *
   *   On success, the number of bytes read is returned (zero indicates end of
   *   file), and the file position is advanced by this number.	 It is not  an
   *   error  if  this	number	is smaller than the number of bytes requested;
   *   this may happen for example because fewer bytes are actually  available
   *   right  now  (maybe  because we were close to end-of-file, or because we
   *   are reading from a pipe, or from a terminal),  or  because  read()  was
   *   interrupted  by	a  signal.  On error, -1 is returned, and errno is set
   *   appropriately. In this case it is left  unspecified  whether  the  file
   *   position (if any) changes.
   *   
   *  ERRORS
   *
   *   EAGAIN Non-blocking  I/O has been selected using O_NONBLOCK and no data
   *    was immediately available for reading.
   *
   *   EBADF  fd is not a valid file descriptor or is not open for reading.
   *
   *   EFAULT buf is outside your accessible address space.
   *
   *   EINTR  The call was interrupted by a signal before any data was read.
   *
   *   EINVAL fd is attached to an object which is unsuitable for reading;  or
   *    the  file	 was  opened  with  the	 O_DIRECT flag, and either the
   *    address specified in buf, the value specified in count,  or  the
   *    current file offset is not suitably aligned.
   *
   *   EIO    I/O error. This will happen for example when the process is in a
   *    background process group, tries to  read	from  its  controlling
   *    tty,  and	 either it is ignoring or blocking SIGTTIN or its pro-
   *    cess group is orphaned.  It may also occur when there is a  low-
   *    level I/O error while reading from a disk or tape.
   *
   *   EISDIR fd refers to a directory.
   *
   *   Other errors may occur, depending on the object connected to fd.	 POSIX
   *   allows a read() that is interrupted after reading some data  to	return
   *   -1  (with  errno set to EINTR) or to return the number of bytes already
   *   read.       
   */
  public static long read(int __fd, char$iterator buf, /*size_t*/int __nbytes) {
    if (NativeTrace.TRACE_IO) NativeTrace.trace("read requested for " + __fd, NativeTrace.TRACE_IO);
    return pread(__fd, buf, __nbytes, Long.MIN_VALUE);
  }
  
  /**
   *
   *  pread() reads up to count bytes from file descriptor fd at offset  off-
   *  set  (from the start of the file) into the buffer starting at buf.  The
   *  file offset is not changed.
   *
   *  pwrite() writes up to count bytes from the buffer starting  at  buf  to
   *  the  file  descriptor  fd  at  offset  offset.	The file offset is not
   *  changed.
   *
   *  The file referenced by fd must be capable of seeking.   
   * @param __fd
   * @param buf
   * @param __nbytes
   * @return 
   *  On success, the number of bytes read or written is returned (zero indi-
   *  cates  that  nothing  was  written,  in the case of pwrite(), or end of
   *  file, in the case of pread), or -1 on error, in which case errno is set
   *  to indicate the error.   
   *
   *  ERRORS
   *
   *     pread()	can  fail  and set errno to any error specified for read(2) or
   *     lseek(2).  pwrite() can fail and set errno to any error	specified  for
   * write(2) or lseek(2).   
   */
  public static long pread (int __fd, char$iterator<?> __buf, /*size_t*/int __nbytes, long/*__off_t*/ __offset) {
    boolean createdOwnBuffer;
    byte buffer[];
    int buf$index;
    if (__buf instanceof char$ptr$array) {
      buffer = ((char$ptr$array)__buf).$array();
      buf$index = ((char$ptr$array)__buf).$index();
      createdOwnBuffer = false;
    } else {
      buffer = new$char(__nbytes);
      buf$index = 0;
      createdOwnBuffer = true;
    }    
    long read = pread(__fd, buffer, buf$index, __nbytes, __offset);
    if (createdOwnBuffer && read > 0) {
        if (__buf instanceof char$ptr) {
          for (int i = 0; i < read; i++) {
            ((char$ptr) __buf).$set(i, buffer[i]);
          }
        } else {
          char$iterator<?> first = $tryClone(__buf);
          for (int i = 0; i < read; i++) {
            first.star$ref().$set(buffer[i]);
            first.$preInc();
          }
        }     
    }
    return read;
  }
  
  public static long pread (int __fd, byte[] buffer, int __bufOffset, /*size_t*/int __nbytes, long/*__off_t*/ __offset) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate read request to custome FS impl?";
    OpenedFile openedFile = getOpenedFileImpl(__fd);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("pread requested " + __nbytes + " bytes " + (__offset != Long.MIN_VALUE ? "from " + __offset : "from the last") + " position for " + __fd + ":" + openedFile, NativeTrace.TRACE_IO);
    setErrno(0);
    if (openedFile == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "pread not opened {0}", __fd);
      setErrno(EBADF);
      return -1;
    }
    if (__nbytes == 0) {
      return 0;
    }
    // sync on the same file
    synchronized (openedFile) {
      // seek to position
      if (openedFile.file != null) {
        long savedPosition = 0;
        if (__offset != Long.MIN_VALUE) {
          try {
            savedPosition = openedFile.position();
            openedFile.seek(__offset);
          } catch (IOException ex) {
            NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
            setErrno(EOVERFLOW);
            return -1;
          }
        }

        int read;
        try {
          read = openedFile.file.read(buffer, __bufOffset, (int)__nbytes);
        } catch (IOException ex) {
          NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
          return -1;
        }
        if (__offset != Long.MIN_VALUE) {
          try {
            // restore position
            openedFile.seek(savedPosition);
          } catch (IOException ex) {
            NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
            setErrno(EOVERFLOW);
            return -1;
          }
        }
        // In java -1 indicates end of file, in C++ 0 indicates it
        return read != -1 ? read : 0; 
      } else {
        int read;
        try {
          read = openedFile.inputStream.read(buffer, __bufOffset, (int)__nbytes);
          if (read == -1) {
            // End of file.
            read = 0;
          }
        } catch (IOException ex) {
          NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
          return -1;
        }
        return read;
      }
    }
  }
  
  /* Create a one-way communication channel (pipe).
   If successful, two file descriptors are stored in PIPEDES;
   bytes written on PIPEDES[1] can be read from PIPEDES[0].
   Returns 0 if successful, -1 if not.  */
  public static int pipe (int __pipedes[/*2*/]) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static int pipe (int$ptr __pipedes) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Print a message describing the meaning of the value of errno.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static void perror (char$ptr __s) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static void perror (String __s) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  private static class StreamIn implements istream {
    private final InputStream in;

    public StreamIn(InputStream in) {
      this.in = in;
    }

    @Override
    public boolean eof() {
      if (true) return false;
      try {
        return in.available() == 0;
      } catch (IOException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      }
      return true;
    }

    @Override
    public boolean fail() {
      return false;
    }

    @Override
    public int getline(std.string to) {
      StringBuilder out = new StringBuilder();
      try {
        int ch;
        while ((ch = in.read()) != -1) {
          if (ch == '\n') {
            break;
          }
          out.append((char)ch);
        }
      } catch (IOException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      }
      to.$assign(out.toString());
      return out.length() == 0 ? -1 : out.length();
    }

    @Override
    public void $destroy() {
      try {
        in.close();
      } catch (IOException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      }
    }
  }

  private static class StreamOut implements ostream {
    private final PrintStream out;

    public StreamOut(PrintStream out) {
      this.out = out;
    }

    @Override
    public basic_ostream $out(String format, Object... args) {
      out.printf(Cpp2JavaFormatString(format), prepareArgsForPrintf(args));
      return this;
    }
    
    @Override
    public basic_ostream $out(NativeCallback.Void2String o) {
      out.print(o.$call());
      return this;
    }
    
    @Override
    public <T> basic_ostream $out(T o) {
      out.print(o);
      return this;
    }
    
    @Override
    public basic_ostream $out(char$ptr str) {
      out.print(str);
      return this;
    }

    @Override
    public basic_ostream $out(char$ptr str, int Len) {
      throw new UnsupportedOperationException("Please implement it!");
    }

    @Override
    public basic_ostream $out_os_str(std.string str) {
      out.print(str.c_str());
      return this;
    }

    @Override
    public basic_ostream $out(byte o) {
      out.print(o);
      return this;
    }

    @Override
    public basic_ostream $out(char o) {
      out.print(o);
      return this;
    }

    @Override
    public basic_ostream $out(int o) {
      out.print(o);
      return this;
    }

    @Override
    public basic_ostream $out_int(int o) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public basic_ostream $out(long o) {
      out.print(o);
      return this;
    }

    @Override
    public basic_ostream $out(double o) {
      out.print(o);
      return this;
    }
    public basic_ostream write(char$ptr data, int size){
      throw new UnsupportedOperationException("Please implement it!");
    }

    @Override
    public void $destroy() {
      out.close();
    }
  }
  
  /* Wait for a child matching PID to die.
     If PID is greater than 0, match any process whose process ID is PID.
     If PID is (pid_t) -1, match any process.
     If PID is (pid_t) 0, match any process with the
     same process group as the current process.
     If PID is less than -1, match any process whose
     process group is the absolute value of PID.
     If the WNOHANG bit is set in OPTIONS, and that child
     is not already dead, return (pid_t) 0.  If successful,
     return PID and store the dead child's status in STAT_LOC.
     Return (pid_t) -1 for errors.  If the WUNTRACED bit is
     set in OPTIONS, return status for stopped children; otherwise don't.

     This function is a cancellation point and therefore not marked with
     __THROW.  */
  public static /*__pid_t*/int waitpid(/*__pid_t*/int __pid, int$ptr __stat_loc, int __options) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Clone the calling process, creating an exact copy.
   Return -1 for errors, 0 to the new process,
   and the process ID of the new process to the old process.  */
  public static /*__pid_t*/int fork()  {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Execute FILE, searching in the `PATH' environment variable if it contains
   no slashes, with arguments ARGV and environment from `environ'.  */
  public static int execvp(char$ptr __file, char$ptr __argv[]) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Terminate program execution with the low-order 8 bits of STATUS.  */
  public static void _exit(int __status) {
    System.exit(__status);
  }
  
  public static int futimens(int FD, timespec out[/*2*/]) {
     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  public static class/*struct*/ FILE {
    public int _cnt; /* number of available characters in buffer */
    public char$ptr/*uchar P*/ _ptr; /* next character from/to here in buffer */
    public char$ptr/*uchar P*/ _base; /* the buffer */
    public /*uchar*/short _flag; /* the state of the stream */
    public /*uchar*/short _magic; /* Old home of the file descriptor */
    /* Only fileno(3C) can retrieve the value now */
    public /*JBYTE unsigned int*/ byte __orientation /*: 2*/; /* the orientation of the stream */
    public /*JBIT unsigned int*/ boolean __ionolock /*: 1*/; /* turn off implicit locking */
    public /*JBIT unsigned int*/ boolean __seekable /*: 1*/; /* is file seekable? */
    public /*JBIT unsigned int*/ boolean __extendedfd /*: 1*/; /* enable extended FILE */
    public /*JBIT unsigned int*/ boolean __xf_nocheck /*: 1*/; /* no extended FILE runtime check */
    public /*JCHAR unsigned int*/ char __filler /*: 10*/;
    public FILE() {}

    // JAVA:
    private int $FD; // OpenedFile
    private FILE(int FD) {
      this.$FD = FD;
    }
  }

  /* stream data from opendir() */
  public static class /*struct*/ DIR {
    public int       d_fd;		/* file descriptor */
    public int       d_loc;		/* offset in block */
    public int       d_size;		/* amount of valid data */
    public char$ptr  d_buf;		/* directory block */

    @Override
    public String toString() {
      return "DIR{" + "d_fd=" + d_fd + ", d_loc=" + d_loc + ", d_size=" + d_size + ", d_buf=" + d_buf + '}';
    }
  };				

  /*
   * File-system independent directory entry.
   */
  public static class dirent {
    public long/*ino_t*/		d_ino;		/* "inode number" of entry */
    public long/*off_t*/		d_off;		/* offset of disk directory entry */
    public int              d_reclen;	/* length of this record */
    public byte             d_name[] = new$char(1);	/* name of file */

    @Override
    public String toString() {
      return "dirent{" + "d_ino=" + d_ino + ", d_off=" + d_off + ", d_reclen=" + d_reclen + ", d_name=" + new String(d_name) + '}';
    }    
  };

  // struct stat 
  public static final class stat {
    public long/*dev_t*/ st_dev;
    public long st_pad1[/*3*/] = new$long(3); /* reserved for network id */

    public long/*ino_t*/ st_ino;
    public int/*mode_t*/ st_mode;
    public /*ulong*/long st_nlink;
    public /*uint*/int st_uid;
    public /*uint*/int st_gid;
    public long/*dev_t*/ st_rdev;
    public long st_pad2[/*2*/] = new$long(2);
    public long/*off_t*/ st_size;
    public long st_pad3; /* future off_t expansion */

    public timespec st_atim = new timespec();
    public timespec st_mtim = new timespec();
    public timespec st_ctim = new timespec();
    public /*size_t*/int st_blksize;
    public long st_blocks;
    public /*char*/byte st_fstype[/*16*/] = new$char(16);
    public long st_pad4[/*8*/] = new$long(8); /* expansion area */    
  }
  
/* MODE MASKS */

/* de facto standard definitions */

public static final int 	S_IFMT	=	0xF000;	/* type of file */
public static final int 	S_IAMB	=	0x1FF;	/* access mode bits */
public static final int 	S_IFIFO	=	0x1000;	/* fifo */
public static final int 	S_IFCHR	=	0x2000;	/* character special */
public static final int 	S_IFDIR	=	0x4000;	/* directory */
/* XENIX definitions are not relevant to Solaris */
public static final int 	S_IFNAM	=	0x5000;  /* XENIX special named file */
public static final int 	S_INSEM	=	0x1;	/* XENIX semaphore subtype of IFNAM */
public static final int 	S_INSHD	=	0x2	;/* XENIX shared data subtype of IFNAM */
public static final int 	S_IFBLK	=	0x6000;	/* block special */
public static final int 	S_IFREG	=	0x8000;	/* regular */
public static final int 	S_IFLNK	=	0xA000;	/* symbolic link */
public static final int 	S_IFSOCK=	0xC000;	/* socket */
public static final int 	S_IFDOOR=	0xD000;	/* door */
public static final int 	S_IFPORT=	0xE000;	/* event port */
public static final int 	S_ISUID	=	0x800;	/* set user id on execution */
public static final int 	S_ISGID	=	0x400	;/* set group id on execution */
public static final int 	S_ISVTX	=	0x200;	/* save swapped text even after use */
public static final int 	S_IREAD	=	00400;	/* read permission, owner */
public static final int 	S_IWRITE=	00200;	/* write permission, owner */
public static final int 	S_IEXEC	=	00100;	/* execute/search permission, owner */
public static final int 	S_ENFMT	=	S_ISGID;	/* record locking enforcement flag */

/* the following macros are for POSIX conformance */

public static final int 	S_IRWXU	=	00700;	/* read, write, execute: owner */
public static final int 	S_IRUSR	=	00400;	/* read permission: owner */
public static final int 	S_IWUSR	=	00200;	/* write permission: owner */
public static final int 	S_IXUSR	=	00100;	/* execute permission: owner */
public static final int 	S_IRWXG	=	00070;	/* read, write, execute: group */
public static final int 	S_IRGRP	=	00040;	/* read permission: group */
public static final int 	S_IWGRP	=	00020;	/* write permission: group */
public static final int 	S_IXGRP	=	00010;	/* execute permission: group */
public static final int 	S_IRWXO	=	00007;	/* read, write, execute: other */
public static final int 	S_IROTH	=	00004;	/* read permission: other */
public static final int 	S_IWOTH	=	00002;	/* write permission: other */
public static final int 	S_IXOTH	=	00001;	/* execute permission: other */

  public static boolean	S_ISFIFO(long mode){ return 	(((mode)&0xF000) == S_IFIFO);}
  public static boolean	S_ISCHR(long mode) { return 	(((mode)&0xF000) == S_IFCHR);}
  public static boolean	S_ISDIR(long mode) { return 	(((mode)&0xF000) == S_IFDIR);}
  public static boolean	S_ISBLK(long mode) { return 	(((mode)&0xF000) == S_IFBLK);}
  public static boolean	S_ISREG(long mode) { return 	(((mode)&0xF000) == S_IFREG);}
  public static boolean	S_ISLNK(long mode) { return 	(((mode)&0xF000) == S_IFLNK);}
  public static boolean	S_ISSOCK(long mode){ return 	(((mode)&0xF000) == S_IFSOCK);}
  public static boolean	S_ISDOOR(long mode){ return 	(((mode)&0xF000) == S_IFDOOR);}
  public static boolean	S_ISPORT(long mode){ return   (((mode)&0xF000) == S_IFPORT);}

  private static int toUnixPermImpl(PosixFilePermission p) {
    switch (p) {
      case OWNER_READ: return S_IRUSR;
      case OWNER_WRITE: return S_IWUSR;
      case OWNER_EXECUTE: return S_IXUSR;
      case GROUP_READ: return S_IRGRP;
      case GROUP_WRITE: return S_IWGRP;
      case GROUP_EXECUTE: return S_IXGRP;
      case OTHERS_READ: return S_IROTH;
      case OTHERS_WRITE: return S_IWOTH;
      case OTHERS_EXECUTE: return S_IXOTH;
      default:
        throw new AssertionError(p.name());
    }
  }
  
  /* Return 1 if FD is a valid descriptor associated
   with a terminal, zero if not.  */
  public static int isatty (int __fd) {
    setErrno(0); 
    if (__fd <= STDERR_FILENO) {
      if (NativeTrace.UNIT_TEST_MODE) {
        // in unit tests mode we use unbuffered out/err to correctly support redirection 2>&1
        return NativeTrace.UNIT_TEST_REDIRECTED_STREAMS ? 1 : 0;
      }
      return System.console() != null ? 1 : 0;
    }
    return 0;
  }
  
  /**
   * 
   * @param file
   * @param out
   * @return On success, zero is returned.  On error, -1 is returned, and errno is
       set appropriately.
   */
  public static int stat(char$ptr file, stat/*&*/ out) {
    return stat(Native.$toString(file), out);
  }
  public static int stat(String fileName, stat/*&*/ out) {
    return statImpl(fileName, out);
  }
  public static int lstat(char$ptr file, stat/*&*/ out) {
    // lstat() is identical to stat(), except that if path is a symbolic link, 
    // then the link itself is stat-ed, not the file that it refers to. 
    return lstat(Native.$toString(file), out);
  }
  public static int lstat(String fileName, stat/*&*/ out) {
    // lstat() is identical to stat(), except that if path is a symbolic link, 
    // then the link itself is stat-ed, not the file that it refers to.     
    return statImpl(fileName, out, LinkOption.NOFOLLOW_LINKS);
  }
  private static int statImpl(String fileName, stat/*&*/ out, LinkOption... options) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate stat request to custome FS impl?";
    if (NativeTrace.TRACE_IO) NativeTrace.trace("stat requested for:" + fileName, NativeTrace.TRACE_IO);
    setErrno(0); 
    Path path = resolvePathByFileName(fileName);
    if (Files.exists(path, options)) {
      try {
        BasicFileAttributes basicAttrs = null;
        basicAttrs = Files.readAttributes(path, BasicFileAttributes.class, options);
        if (basicAttrs.isDirectory()) {
          out.st_mode |= S_IFDIR;
        }
        if (basicAttrs.isRegularFile()) {
          out.st_mode |= S_IFREG;
        }
        if (basicAttrs.isSymbolicLink()) {
          out.st_mode |= S_IFLNK;
        }
        out.st_size = basicAttrs.size();
        FileTime lastModifiedTime = basicAttrs.lastModifiedTime();
        out.st_mtim.tv_nsec = lastModifiedTime.to(TimeUnit.NANOSECONDS);
        out.st_mtim.tv_sec = lastModifiedTime.to(TimeUnit.SECONDS);
        // some attributes are not supported on windows
        boolean unixSupported = false;
        for (FileStore fileStore : path.getFileSystem().getFileStores()) {
          if (fileStore.supportsFileAttributeView(PosixFileAttributeView.class)) {
            Set<PosixFilePermission> perms = Files.getPosixFilePermissions(path, options);
            for (PosixFilePermission perm : perms) {
              out.st_mode |= toUnixPermImpl(perm);
            }
          }
          if (fileStore.supportsFileAttributeView("unix")) {
            Map<String, Object> unixAttrs = Files.readAttributes(path, "unix:ino,dev,gid,uid", options);
            out.st_ino = ((Number)unixAttrs.get("ino")).longValue();
            out.st_dev = ((Number)unixAttrs.get("dev")).longValue();
            out.st_gid = ((Number)unixAttrs.get("gid")).intValue();
            out.st_uid = ((Number)unixAttrs.get("uid")).intValue();
            unixSupported = true;
            break;
          }
        }
        if (!unixSupported) {
          Object fileKey = basicAttrs.fileKey();
          out.st_ino = fileKey == null ? path.hashCode() : fileKey.hashCode();
          out.st_dev = 0;
          out.st_gid = 0;
          out.st_uid = 0;
        }
      } catch (IOException ex) {
        NativeTrace.printStackTraceOnce(ex, Level.WARNING, true);
      }
      return 0;
    }
    setErrno(ENOENT); // no such file or directory
    return -1;
  }

  /**
   * The stat() function obtains information about the file pointed to by path.
   * Read, write, or execute permission of the named file is not required, but
   * all directories listed in the path name leading to the file must be
   * searchable.
   *
   * @param fildes
   * @param out
   * @return Upon successful completion, 0 is returned. Otherwise, -1 is
   * returned and errno is set to indicate the error.
   * 
   * ERRORS
   *
   * The stat(), fstat(), lstat(), and fstatat()  functions  will
   * fail if:
   *
   * EIO          An error occurred while reading from  the  file
   *              system.
   *
   * EOVERFLOW    The file size in bytes or the number of  blocks
   *              allocated to the file or the file serial number
   *              cannot be represented correctly in  the  struc-
   *              ture pointed to by buf.
   *
   * The stat(), lstat(), and fstatat() functions will fail if:
   *
   * EACCES          Search permission is denied for a  component
   *                 of the path prefix.
   *
   * EFAULT          The  buf or path argument points to an ille-
   *                 gal address.
   *
   * EINTR           A signal was caught during the execution  of
   *                 the  stat() or lstat() function.
   *
   * ELOOP           A loop exists in symbolic links  encountered
   *                 during the resolution of the path argument.
   *
   * ENAMETOOLONG    The length  of  the  path  argument  exceeds
   *                 {PATH_MAX},  or  the  length  of a path com-
   *                 ponent     exceeds     {NAME_MAX}      while
   *                 _POSIX_NO_TRUNC is in effect.
   *
   * ENOENT          A component of path does not name an  exist-
   *                 ing file or path is an empty string.
   *
   * ENOLINK         The path argument points to a remote machine
   *                 and  the  link  to that machine is no longer
   *                 active.
   *
   * ENOTDIR         A component of the  path  prefix  is  not  a
   *                 directory,  or  the fildes argument does not
   *                 refer to a  valid  directory  when  given  a
   *                 non-null relative path.
   *
   * The fstat() and fstatat() functions will fail if:
   *
   * EBADF      The fildes argument is  not  a  valid  open  file
   *            descriptor.  The fildes argument to fstatat() can
   *            also have the valid value of AT_FDCWD.
   *
   * EFAULT     The buf argument points to an illegal address.
   *
   * EINTR      A signal was caught during the execution  of  the
   *            fstat() function.
   *
   * ENOLINK    The fildes argument points to  a  remote  machine
   *            and the link to that machine is no longer active.
   *
   * The stat(), fstat(), and lstat() functions may fail if:
   *
   * EOVERFLOW    One of the members is too large to store in the
   *              stat structure pointed to by buf.
   *
   * The stat() and lstat() functions may fail if:
   *
   * ELOOP           More than {SYMLOOP_MAX} symbolic links  were
   *                 encountered  during  the  resolution  of the
   *                 path argument.
   *
   * ENAMETOOLONG    As a result of encountering a symbolic  link
   *                 in   resolution  of  thepath  argument,  the
   *                 length of the substituted  pathname  strings
   *                 exceeds {PATH_MAX}.
   *
   */
  public static int fstat(int fildes, stat/*&*/ out) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate fstat request to custome FS impl?";
    String openedFileNameImpl = getOpenedFileNameImpl(fildes);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("fstat requested for " + fildes + ":" + openedFileNameImpl, NativeTrace.TRACE_IO);
    setErrno(0);    
    if (openedFileNameImpl == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "closing not opened {0}", fildes);
      setErrno(EBADF);
      return -1;
    }
    if (fildes <= STDERR_FILENO) {
      // when running not from conslole let standard FDs to be files...
      boolean tty = (isatty(fildes) != 0);
      out.st_mode = tty ? S_IFCHR : S_IFREG;
      out.st_blksize = tty ? 0 : BLOCK_SIZE;
      if (fildes != STDIN_FILENO && !tty) {
        out.st_mode |= 00644;
      }
      return 0;
    } else {
      out.st_blocks = 1L;
      out.st_blksize = BLOCK_SIZE;
    }
    return stat(openedFileNameImpl, out);
  }

  public static int mkdir(char$iterator<?> __file, int/*mode_t*/ mode) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate mkdir request to custome FS impl?";
    setErrno(0); 
    // JAVA: TODO: need to convert mode to attrs and set correct errno for error case
    try {
      String fileName = Native.$toString(__file);
      if (NativeTrace.TRACE_IO) {
        NativeTrace.trace("mkdir requested for:" + fileName, NativeTrace.TRACE_IO);
      }
      Path filePath = resolvePathByFileName(fileName);
      Files.createDirectories(filePath);
    } catch (FileAlreadyExistsException ex) {
      setErrno(EEXIST);
      return -1;
    } catch (IOException ex) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, null, ex);
      setErrno(EACCES);
      return -1;
    }
    return 0;
  }
  
  public static DIR/*P*/ opendir(char$iterator<?> file) {
    setErrno(0);
    NativeTrace.traceNotImplemented("io.opendir");
    return null;
  }
  
  public static int closedir(DIR/*P*/ dir) {
    setErrno(0);
    NativeTrace.traceNotImplemented("io.closedir");
    return errno();
  }
  
  public static dirent/*P*/ readdir(DIR /*P*/ dir) {
    setErrno(0);
    NativeTrace.traceNotImplemented("io.readdir");
    return null;
  }
  
  public static int remove(char$iterator<?> __file) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate open request to custome FS impl?";
    String fileName = Native.$toString(__file);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("open requested for:" + fileName, NativeTrace.TRACE_IO);
    Path filePath = resolvePathByFileName(fileName);
    setErrno(0);
    try {
      boolean existed = Files.deleteIfExists(filePath);
      if (!existed) {
        setErrno(ENOENT);
        return -1;
      }
    } catch (IOException ex) {
      setErrno(EIO);
      return -1;
    }
    return 0;
  }
 
  public static int link(char$iterator<?> __existingfile, char$iterator<?> __link) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int symlink(char$iterator<?> __existingfile, char$iterator<?> __link) {
    String linkName = Native.$toString(__link);
    String fileName = Native.$toString(__existingfile);
    if (NativeTrace.TRACE_IO) {
      NativeTrace.trace("symlink requested for:" + fileName, NativeTrace.TRACE_IO);
    }
    Path linkPath = resolvePathByFileName(linkName);
    Path filePath = resolvePathByFileName(fileName);
    setErrno(0);
    try {
      Files.createSymbolicLink(linkPath, filePath);
      return 0;
    } catch (UnsupportedOperationException ex) {
      setErrno(EIO);
      System.out.println("This OS doesn't support creating Sym links");
      return -1;
    } catch (SecurityException ex) {
      setErrno(EACCES);
      return -1;
    } catch (FileAlreadyExistsException ex) {
      setErrno(EEXIST);
      return -1;
    } catch (IOException ex) {
      setErrno(EIO);
      return -1;
    }
  }
  
  /**
   * The rename() function shall change the name of a file. The old
   * argument points to the pathname of the file to be renamed. The new
   * argument points to the new pathname of the file.
   *
   * If either the old or new argument names a symbolic link, rename()
   * shall operate on the symbolic link itself, and shall not resolve
   * the last component of the argument. If the old argument and the new
   * argument resolve to the same existing file, rename() shall return
   * successfully and perform no other action.
   *
   * If the old argument points to the pathname of a file that is not a
   * directory, the new argument shall not point to the pathname of a
   * directory. If the link named by the new argument exists, it shall
   * be removed and old renamed to new. In this case, a link named new
   * shall remain visible to other processes throughout the renaming
   * operation and refer either to the file referred to by new or old
   * before the operation began. Write access permission is required for
   * both the directory containing old and the directory containing new.
   *
   * If the old argument points to the pathname of a directory, the new
   * argument shall not point to the pathname of a file that is not a
   * directory. If the directory named by the new argument exists, it
   * shall be removed and old renamed to new. In this case, a link named
   * new shall exist throughout the renaming operation and shall refer
   * either to the directory referred to by new or old before the
   * operation began. If new names an existing directory, it shall be
   * required to be an empty directory.
   *
   * If the old argument points to a pathname of a symbolic link, the
   * symbolic link shall be renamed. If the new argument points to a
   * pathname of a symbolic link, the symbolic link shall be removed.
   *
   * The new pathname shall not contain a path prefix that names old.
   * Write access permission is required for the directory containing
   * old and the directory containing new. If the old argument points to
   * the pathname of a directory, write access permission may be
   * required for the directory named by old, and, if it exists, the
   * directory named by new.
   *
   * If the link named by the new argument exists and the file's link
   * count becomes 0 when it is removed and no process has the file
   * open, the space occupied by the file shall be freed and the file
   * shall no longer be accessible. If one or more processes have the
   * file open when the last link is removed, the link shall be removed
   * before rename() returns, but the removal of the file contents shall
   * be postponed until all references to the file are closed.
   *
   * Upon successful completion, rename() shall mark for update the
   * st_ctime and st_mtime fields of the parent directory of each file.
   *
   * If the rename() function fails for any reason other than [EIO], any
   * file named by new shall be unaffected.
   *
   * Return Value
   *
   * Upon successful completion, rename() shall return 0; otherwise, -1
   * shall be returned, errno shall be set to indicate the error, and
   * neither the file named by old nor the file named by new shall be
   * changed or created.
   *
   * Errors
   * 
   * The rename() function shall fail if:
   * 
   * EACCES
   *     A component of either path prefix denies search permission; or one of the directories containing old or new denies write permissions; or, write permission is required and is denied for a directory pointed to by the old or new arguments. 
   * EBUSY
   *     The directory named by old or new is currently in use by the system or another process, and the implementation considers this an error. 
   * EEXIST or ENOTEMPTY
   * 
   *     The link named by new is a directory that is not an empty directory. 
   * EINVAL
   *     The new directory pathname contains a path prefix that names the old directory. 
   * EIO
   *     A physical I/O error has occurred. 
   * EISDIR
   *     The new argument points to a directory and the old argument points to a file that is not a directory. 
   * ELOOP
   *     A loop exists in symbolic links encountered during resolution of the path argument. 
   * EMLINK
   *     The file named by old is a directory, and the link count of the parent directory of new would exceed {LINK_MAX}. 
   * ENAMETOOLONG
   * 
   *     The length of the old or new argument exceeds {PATH_MAX} or a pathname component is longer than {NAME_MAX}. 
   * ENOENT
   *     The link named by old does not name an existing file, or either old or new points to an empty string. 
   * ENOSPC
   *     The directory that would contain new cannot be extended. 
   * ENOTDIR
   *     A component of either path prefix is not a directory; or the old argument names a directory and new argument names a non-directory file. 
   * EPERM or EACCES
   * 
   *     The S_ISVTX flag is set on the directory containing the file referred to by old and the caller is not the file owner, nor is the caller the directory owner, nor does the caller have appropriate privileges; or new refers to an existing file, the S_ISVTX flag is set on the directory containing this file, and the caller is not the file owner, nor is the caller the directory owner, nor does the caller have appropriate privileges. 
   * EROFS
   *     The requested operation requires writing in a directory on a read-only file system. 
   * EXDEV
   *     The links named by new and old are on different file systems and the implementation does not support links between file systems.
   * 
   * The rename() function may fail if:
   * 
   * EBUSY
   *     The file named by the old or new arguments is a named STREAM. 
   * ELOOP
   *     More than {SYMLOOP_MAX} symbolic links were encountered during resolution of the path argument. 
   * ENAMETOOLONG
   * 
   *     As a result of encountering a symbolic link in resolution of the path argument, the length of the substituted pathname string exceeded {PATH_MAX}. 
   * ETXTBSY
   *     The file to be renamed is a pure procedure (shared text) file that is being executed.
   *     
   */
  public static int rename(char$iterator<?> __from, char$iterator<?> __to) {
    String from = Native.$toString(__from);
    String to = Native.$toString(__to);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("rename requested [" + from + "] => [" + to + "]", NativeTrace.TRACE_IO);
    Path fromPath = resolvePathByFileName(from);
    Path toPath = resolvePathByFileName(to);
    setErrno(0);
    try {
      Files.move(fromPath, toPath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException ex) {
      setErrno(EIO);
      return -1;
    }
    return 0;
  }

  /* Truncate FILE to LENGTH bytes.  */
  public static int truncate(char$iterator<?> __file, long /*off_t*/size) {
    int fId = open(__file, O_WRONLY | O_CREAT);
    if (fId >= 0) {
      OpenedFile OF = getOpenedFileImpl(fId);
      try {
        OF.file.setLength(size);
      } catch (IOException ex) {
        setErrno(EIO);
        return -1;
      }
      close(fId);
      return 0;
    }
    setErrno(EACCES);
    return -1;
  }
  
  /**
   * copies an absolute pathname of the current working directory to the array
   * pointed to by buf, which is of length	size.
   *
   * @param buf
   * @param bufSize
   * @return NULL on failure with errno set accordingly, and	buf on	success. The
   * contents of the array pointed to by buf is undefined on error.
   */
  public static char$ptr getcwd(char$ptr buf, /*uint*/int bufSize) {
    setErrno(0);
    String curDir = CWD.get().get();
    char$iterator<?> first = $tryClone(buf);
    for (int i = 0; i < Math.min(bufSize, curDir.length()); i++) {
      first.star$ref().$set((byte)curDir.charAt(i));
      first.$preInc();
    }    
    return buf;
  }
  
  private static final ThreadLocal<AtomicReference<String>> CWD = new ThreadLocal<AtomicReference<String>>() {
    @Override
    protected AtomicReference<String> initialValue() {
      // ask Java
      String out = System.getProperty("user.dir");
      if (out == null) {
        // ask system
        out = System.getenv("PWD");
      }
      return new AtomicReference(out);
    }
  };
  
  public static String getCWD() {
    return CWD.get().get();
  }
  
  /**
   * changes the current working directory of the calling process to the directory specified in path. 
   * @param path
   * @return On success, zero is returned. On error, -1 is returned, and errno is set appropriately. 
   */
  public static int chdir(char$ptr path) {
    return chdir(Casts.toJavaString(path));
  }
  public static int chdir(String path) {
    setErrno(0);
    CWD.get().set(path);
    return 0;
  }
  
  /* NULL-terminated array of "NAME=VALUE" environment variables.  */
  public static char$ptr[] __environ = null;
  public static char$ptr[] environ = null;
  
/*
 * Flag values accessible to open(2) and fcntl(2)
 * The first five can only be set (exclusively) by open(2).
 */
private static final int  RW_MASK = 0x03;
public static final int	  O_RDONLY = 0;
public static final int		O_WRONLY = 1;
public static final int		O_RDWR   = 2;
public static final int		O_SEARCH	 = 0x200000;
public static final int		O_EXEC		 = 0x400000;
//#if defined(__EXTENSIONS__) || !defined(_POSIX_C_SOURCE)
public static final int		O_NDELAY	 = 0x04;	/* non-blocking I/O */
//#endif /* defined(__EXTENSIONS__) || !defined(_POSIX_C_SOURCE) */
public static final int		O_APPEND	 = 0x08;	/* append (writes guaranteed at the end) */
//#if defined(__EXTENSIONS__) || !defined(_POSIX_C_SOURCE) || \
//	(_POSIX_C_SOURCE > 2) || defined(_XOPEN_SOURCE)
public static final int		O_SYNC		 = 0x10;	/* synchronized file update option */
public static final int		O_DSYNC		 = 0x40;	/* synchronized data update option */
public static final int		O_RSYNC		 = 0x8000;	/* synchronized file update option */
				/* defines read/write file integrity */
//#endif /* defined(__EXTENSIONS__) || !defined(_POSIX_C_SOURCE) ... */
public static final int		O_NONBLOCK	 = 0x80;	/* non-blocking I/O (POSIX) */
//#ifdef	_LARGEFILE_SOURCE
public static final int		O_LARGEFILE	 = 0x2000;
//#endif

  /*
   * Flag values accessible only to open(2).
   */
  public static final int		O_CREAT		 = 0x100;	/* open with file create (uses third arg) */
  public static final int		O_TRUNC		 = 0x200;	/* open with truncation */
  public static final int		O_EXCL		 = 0x400;	/* exclusive open */
  public static final int		O_NOCTTY	 = 0x800;	/* don't allocate controlling tty (POSIX) */
  public static final int		O_XATTR		 = 0x4000;	/* extended attribute */
  public static final int		O_NOFOLLOW	 = 0x20000;	/* don't follow symlinks */
  public static final int		O_NOLINKS	 = 0x40000;	/* don't allow multiple hard links */
  public static final int		O_CLOEXEC	 = 0x800000;  /* open() sets the close on exec flag */
  public static final int		O_DIRECTORY	 = 0x1000000; /* open() fails for non-directory file */
  public static final int		O_TTY_INIT	 = 0x2000000; /* unused (POSIX allows this to be ignored) */


  
  /**
   * The close() function deallocates the file descriptor indi- cated by fildes.
   * To deallocate means to make the file descriptor available for return by
   * subsequent calls to open(2) or other functions that allocate file
   * descriptors. All outstanding record locks owned by the process on the file
   * associated with the file descriptor will be removed (that is, unlocked).
   *
   * @param FileDescriptor
   * @return Upon successful completion, 0 is returned. Otherwise, -1 is
   * returned and errno is set to indicate the error
   * 
   * The close() function will fail if:
   *
   * EBADF The fildes argument is not a valid file descriptor.
   *
   * EINTR The close() function was interrupted by a signal.
   *
   * ENOLINK The fildes argument is on a remote machine and the link to that
   * machine is no longer active.
   *
   * ENOSPC There was no free space remaining on the device containing the file.
   *
   * The close() function may fail if:
   *
   * EIO An I/O error occurred while reading from or writing to the file system.
   */
  public static int close(int FileDescriptor) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate close request to custome FS impl?";
    setErrno(0);
    final OpenedFile openedFile = getOpenedFileImpl(FileDescriptor);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("closing " + FileDescriptor + ":" + openedFile, NativeTrace.TRACE_IO);
    if (openedFile == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "closing not opened {0}", FileDescriptor);
      setErrno(EBADF);
      return -1;
    }
    // FIXME: check error code when close standard file descriptor
    if (FileDescriptor <= STDERR_FILENO) {
      // can not close stderr
      if (FileDescriptor == STDERR_FILENO) {
        Logger.getLogger(io.class.getName()).log(Level.SEVERE, "closing standard stream {0}", FileDescriptor);
        setErrno(EBADF);
        return -1;
      }
      return 0;
    }
    // free file descriptr
    synchronized (openedFiles) {
      openedFiles.set(FileDescriptor, null);
    }
    try {
      openedFile.close();
    } catch (IOException ex) {
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      setErrno(EIO);
      return -1;
    }
    return 0;
  }
  
  /**
   * Given a pathname for a file, open() returns a file descriptor, a small,
   * non-negative integer for	use in subsequent system calls (read(2), write(2),
   * lseek(2), fcntl(2), etc.). The file descriptor returned by a successful
   * call will be the lowest-numbered file	descriptor not cur- rently open for
   * the process.
   *
   * @param __file
   * @param __oflag
   * @param additional_args
   * @return open() and creat() return the new file descriptor, or -1 if an
   * error occurred (in which case, errno is set appropriately).
   *
   * ERRORS:
   *  EACCES The  requested access to the file is not allowed, or search per-
   *   mission is denied for one of the directories in the path	prefix
   *   of  pathname,  or the file did not exist yet and write access to
   *   the parent directory is not  allowed.   (See  also  path_resolu-
   *   tion(2).)
   *
   *  EEXIST pathname already exists and O_CREAT and O_EXCL were used.
   *
   *  EFAULT pathname points outside your accessible address space.
   *
   *  EISDIR pathname refers to a directory and the access requested involved
   *   writing (that is, O_WRONLY or O_RDWR is set).
   *
   *  ELOOP  Too many symbolic links were encountered in resolving  pathname,
   *   or O_NOFOLLOW was specified but pathname was a symbolic link.
   *
   *  EMFILE The process already has the maximum number of files open.
   *
   *  ENAMETOOLONG
   *   pathname was too long.
   *
   *  ENFILE The  system  limit  on  the  total number of open files has been
   *   reached.
   *
   *  ENODEV pathname refers to a device special file	and  no	 corresponding
   *   device  exists.	(This is a Linux kernel bug; in this situation
   *   ENXIO must be returned.)
   *
   *  ENOENT O_CREAT is not set and the named file does  not  exist.	Or,  a
   *   directory	 component in pathname does not exist or is a dangling
   *   symbolic link.
   *
   *  ENOMEM Insufficient kernel memory was available.
   *
   *  ENOSPC pathname was to be created but the  device  containing  pathname
   *   has no room for the new file.
   *
   *  ENOTDIR
   *   A	 component  used as a directory in pathname is not, in fact, a
   *   directory, or O_DIRECTORY was specified and pathname was	not  a
   *   directory.
   *
   *  ENXIO  O_NONBLOCK  |  O_WRONLY  is set, the named file is a FIFO and no
   *   process has the file open for reading.  Or, the file is a device
   *   special file and no corresponding device exists.
   *
   *  EOVERFLOW
   *   pathname	refers	to a regular file, too large to be opened; see
   *   O_LARGEFILE above.
   *
   *  EPERM  The O_NOATIME flag was specified, but the effective user	ID  of
   *   the  caller  did	not match the owner of the file and the caller
   *   was not privileged (CAP_FOWNER).
   *
   *  EROFS  pathname refers to a file on a read-only	filesystem  and	 write
   *   access was requested.
   *
   *  ETXTBSY
   *   pathname	refers to an executable image which is currently being
   *   executed and write access was requested.
   *
   *  EWOULDBLOCK
   *   The O_NONBLOCK flag was specified, and an incompatible lease was
   *   held on the file (see fcntl(2)).   
   */
  public static int open (char$iterator<?> __file, /*uint*/int __oflag, /*uint*/int ... additional_args) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate open request to custome FS impl?";
    String fileName = Native.$toString(__file);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("open requested for:" + fileName, NativeTrace.TRACE_IO);
    Path filePath = resolvePathByFileName(fileName);
    setErrno(0);
    boolean read = (((__oflag & RW_MASK) == O_RDONLY) || ((__oflag & RW_MASK) == O_RDWR) || ((__oflag & O_EXCL) == O_EXCL));
    boolean truncate = ((__oflag & O_CREAT) == O_CREAT) || ((__oflag & O_TRUNC) == O_TRUNC);
    boolean append = ((__oflag & O_APPEND) == O_APPEND);
    boolean write = ((__oflag & RW_MASK) == O_WRONLY) || ((__oflag & RW_MASK) == O_RDWR) || append || truncate;
    boolean create = ((__oflag & O_CREAT) == O_CREAT);
    if (create || Files.exists(filePath)) {
      if (!create && read && !Files.isReadable(filePath)) {
        setErrno(EACCES); // Permission denied
        return -1;
      }
      if (!create && write && !Files.isWritable(filePath)) {
        setErrno(EACCES); // Permission denied
        return -1;
      }
      String mode = convertToJavaFileOpenMode(__oflag);
      try {
        int fId = openFileDescriptorImpl(fileName, mode, truncate);
        if (append && fId >= 0) {
          fseek(new FILE(fId), 0, SEEK_END);
        }
        return fId;
      } catch (FileNotFoundException ex) {
        // callers use open to check file existence as well
        Logger.getLogger(io.class.getName()).log(Level.FINEST, null, ex);
        // no such file or directory
        setErrno(ENOENT); // no such file or directory       
        return -1;
      } catch (IOException ex) {
        Logger.getLogger(io.class.getName()).log(Level.INFO, null, ex);
        setErrno(EACCES);
        return -1;
      }
    }
    setErrno(ENOENT); // no such file or directory
    return -1;    
  }
  
  /**
   * delete a name and possibly the file it refers to
   * 
   * unlink() deletes a name from the filesystem. If that name was the last link
   * to a file and no processes have the file open, the file is deleted and the
   * space it was using is made available for reuse.
   *
   * If the name was the last link to a file but any processes still have the
   * file open, the file will remain in existence until the last file descriptor
   * referring to it is closed.
   *
   * If the name referred to a symbolic link, the link is removed.
   *
   * If the name referred to a socket, FIFO, or device, the name for it is
   * removed but processes which have the object open may continue to use it.
   * 
   * On success, zero is returned.  On error, -1 is returned, and errno is
   * set appropriately.
   * 
   * ERRORS  
   *
   *   EACCES Write access to the directory containing pathname is not
   *          allowed for the process's effective UID, or one of the
   *          directories in pathname did not allow search permission.  (See
   *          also path_resolution(7).)
   *
   *   EBUSY  The file pathname cannot be unlinked because it is being used
   *          by the system or another process; for example, it is a mount
   *          point or the NFS client software created it to represent an
   *          active but otherwise nameless inode ("NFS silly renamed").
   *
   *   EFAULT pathname points outside your accessible address space.
   *
   *   EIO    An I/O error occurred.
   *
   *   EISDIR pathname refers to a directory.  (This is the non-POSIX value
   *          returned by Linux since 2.1.132.)
   *
   *   ELOOP  Too many symbolic links were encountered in translating
   *          pathname.
   *
   *   ENAMETOOLONG
   *          pathname was too long.
   *
   *   ENOENT A component in pathname does not exist or is a dangling
   *          symbolic link, or pathname is empty.
   *
   *   ENOMEM Insufficient kernel memory was available.
   *
   *   ENOTDIR
   *          A component used as a directory in pathname is not, in fact, a
   *          directory.
   *
   *   EPERM  The system does not allow unlinking of directories, or
   *          unlinking of directories requires privileges that the calling
   *          process doesn't have.  (This is the POSIX prescribed error
   *          return; as noted above, Linux returns EISDIR for this case.)
   *
   *   EPERM (Linux only)
   *          The filesystem does not allow unlinking of files.
   *
   *   EPERM or EACCES
   *          The directory containing pathname has the sticky bit (S_ISVTX)
   *          set and the process's effective UID is neither the UID of the
   *          file to be deleted nor that of the directory containing it,
   *          and the process is not privileged (Linux: does not have the
   *          CAP_FOWNER capability).
   *
   *   EROFS  pathname refers to a file on a read-only filesystem.
   *
   * @param __file 
   */
  public static int unlink(char$iterator<?> __file) {
    try {
      setErrno(0);
      String fileName = Native.$toString(__file);
      if (NativeTrace.TRACE_IO) NativeTrace.trace("unlink requested for:" + fileName, NativeTrace.TRACE_IO);
      Path filePath = resolvePathByFileName(fileName);
      Files.delete(filePath);
      return 0;
    } catch (IOException ex) {
      NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
      // FIXME: correct error code from exception
      setErrno(EROFS);
      return -1;
    }
  }
   
  private static final class OpenedFile {
    private final String name;
    private final RandomAccessFile file;
    private final InputStream inputStream;
    private final DataOutput outStream;
    private FileChannel channel = null;
    private boolean closed = false;
    private final char$ptr charPtr = create_char$null$ptr();
    private MappedByteBuffer BBuffer = null;
    private int flags; // FD_CLOEXEC
    
    public OpenedFile(String name, RandomAccessFile file) {
      this.name = name;
      this.file = file;
      this.outStream = file;
      this.inputStream = null;
    }    

    public OpenedFile(String name, FileDescriptor inOutFD) {
      this.name = name;
      this.file = null;
      if (inOutFD == FileDescriptor.out || inOutFD == FileDescriptor.err) {
        this.inputStream = null;
        this.outStream = new JavaPrintStreamWrapper(inOutFD);
      } else {
        this.inputStream = new JavaInputStreamWrapper(inOutFD);
        this.outStream = null;
      }
    }    
    
    private int setFlags(int flags) {
      return this.flags = flags;
    }
    
    private int getFlags() {
      return this.flags;
    }

    @Override
    public String toString() {
      return "OpenedFile{" + "name=" + name + ", file=" + file + '}';
    }
    
    public int close() throws IOException {
      if (closed) {
        throw new IllegalStateException("already closed " + name);
      }
      closed = true;
      if (channel != null) {
        channel.close();
      }
      file.close();
      return 0;
    }

    private void write(byte[] buffer, int off, int len) throws IOException {
      this.outStream.write(buffer, off, len);
    }
    
    private void writeBytes(String bytes) throws IOException {
      this.outStream.writeBytes(bytes);
    }
    
    private static java.lang.reflect.Method DIRECT_BUFFER_CLEANER_METHOD = null;
    private static java.lang.reflect.Method DIRECT_BUFFER_CLEANER_CLEAN_METHOD = null;
    
    public char$ptr mmap(FileChannel.MapMode mode, long pos, long size) throws IOException {
      assert charPtr.$isNull() : "already in use";
      assert BBuffer == null : "already in use";
      assert channel == null : "channel already in use";
      MappedByteBuffer out = null;
      try {
        channel = file.getChannel();
        out = channel.map(mode, pos, size);
        byte[] dst = new$char($long2uint(pos + size + 1));
        out.get(dst, $long2uint(pos), $long2uint(size));
        charPtr.$assign(create_char$ptr(dst, $long2uint(pos)));
        return charPtr;
      } finally {
        String cleanerClassName = "";
        try {
          out.clear();
          if (out.isDirect()) {
            // cache methods
            if (DIRECT_BUFFER_CLEANER_CLEAN_METHOD == null) {
              Method cleanerMethod = out.getClass().getMethod("cleaner"); //NOI18N
              if (cleanerMethod != null) {
                cleanerMethod.setAccessible(true);
                // sun.misc.Cleaner in JDK8
                // java.lang.ref.Cleaner in JDK9
                Object cleaner = cleanerMethod.invoke(out);
                if (cleaner != null) {
                  Method cleanMethod = cleaner.getClass().getMethod("clean"); //NOI18N
                  if (cleanMethod != null) {
                    cleanMethod.setAccessible(true);
                    DIRECT_BUFFER_CLEANER_METHOD = cleanerMethod;
                    DIRECT_BUFFER_CLEANER_CLEAN_METHOD = cleanMethod;
                  }
                }
              }
            }
            if (DIRECT_BUFFER_CLEANER_CLEAN_METHOD != null) {
              Object cleaner = DIRECT_BUFFER_CLEANER_METHOD.invoke(out);
              if (cleaner != null) {
                DIRECT_BUFFER_CLEANER_CLEAN_METHOD.invoke(cleaner);
              }
            }
          }
        } catch (Throwable e) {
          if (!cleanerClassName.isEmpty()) {
            NativeTrace.printDebuggingStackFrames("Class " + cleanerClassName + " doesn't have 'clean' method for Buf:" + NativeTrace.getIdentityStr(out));
          }
          NativeTrace.printStackTraceOnce(e);
        }
      }
    }
    
    public boolean isPtrOwner(void$ptr MMapPtr) {
      assert (MMapPtr != charPtr) || !charPtr.$isNull() : "null can not be mapped";
      return (MMapPtr == charPtr) || charPtr.$eq(MMapPtr);
    }
    
    public boolean munmap(void$ptr MMapPtr, long length) {
      BBuffer = null;
      clear_char$ptr(charPtr);
      return true;
    }

    private long position() throws IOException {
      return file.getFilePointer();
    }
    
    private void seek(long __file_offset) throws IOException {
      file.seek(__file_offset);
    }
    
    private long length() throws IOException {
      return file.length();
    }
  }
  
  private static final class JavaInputStreamWrapper extends InputStream {
    
    public JavaInputStreamWrapper(FileDescriptor inFD) {
      assert inFD == FileDescriptor.in;
    }

    private InputStream getDelegate() {
      return System.in;
    }
    
    @Override
    public int read() throws IOException {
      return getDelegate().read();
    }
  }
  
  private static final class JavaPrintStreamWrapper implements DataOutput {
    // don't cache stream, it can be redirected by System.setOut/System.setErr
    private final boolean SystemOut;

    public JavaPrintStreamWrapper(FileDescriptor outFD) {
      assert outFD == FileDescriptor.out || outFD == FileDescriptor.err;
      this.SystemOut = (outFD == FileDescriptor.out);
    }
        
    /**
     * @return the delegate
     */
    private OutputStream getDelegate() {
      return SystemOut ? System.out : System.err;
    }
    
    @Override
    public void write(int b) throws IOException {
      getDelegate().write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
      getDelegate().write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      getDelegate().write(b, off, len);
    }

    @Override
    public void writeBoolean(boolean v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeByte(int v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeShort(int v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeChar(int v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeInt(int v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeLong(long v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeFloat(float v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeDouble(double v) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeBytes(String s) throws IOException {
      byte[] buffer = new byte[s.length()];
      for (int i = 0; i < s.length(); i++) {
        buffer[i] = $ushort2uchar(s.charAt(i));
      }
      write(buffer, 0, buffer.length);
    }

    @Override
    public void writeChars(String s) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeUTF(String s) throws IOException {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  private static final List<OpenedFile> openedFiles = new ArrayList(3);
  static {
    openedFiles.add(STDIN_FILENO, new OpenedFile("stdin", FileDescriptor.in)); // 0 is stdin file descriptor
    openedFiles.add(STDOUT_FILENO, new OpenedFile("stdout", FileDescriptor.out)); // 1 is stdout file descriptor
    openedFiles.add(STDERR_FILENO, new OpenedFile("stderr", FileDescriptor.err)); // 2 is stderr file descriptor
    if (NativeTrace.VERBOSE_MODE) {
      System.err.printf("STDOUT is a TTY? %s\n", (isatty(STDOUT_FILENO) != 0));
    }
    assert openedFiles.size() == 3;
  }
  private static OpenedFile getOpenedFileImpl(void$ptr MMap) {
    synchronized (openedFiles) {
      for (OpenedFile file : openedFiles) {
        // closed files are nulls in list
        if (file != null) {
          if (file.isPtrOwner(MMap)) {
            return file;
          }
        }
      }
      return null;
    }
  }  
  private static OpenedFile getOpenedFileImpl(int FileDescriptor) {
    synchronized (openedFiles) {
      return (FileDescriptor < openedFiles.size()) ? openedFiles.get(FileDescriptor) : null;
    }
  }  
  private static String getOpenedFileNameImpl(int FileDescriptor) {
    OpenedFile file = getOpenedFileImpl(FileDescriptor);
    return file == null ? null : file.name;
  }

  private static final String R_OPEN_MODE = "r";
  private static final String RW_OPEN_MODE = "rw";
  private static String convertToJavaFileOpenMode(/*uint*/int __oflag) {
    boolean read = (((__oflag & RW_MASK) == O_RDONLY) || ((__oflag & RW_MASK) == O_RDWR) || ((__oflag & O_EXCL) == O_EXCL));
    boolean write = (((__oflag & RW_MASK) == O_WRONLY) || ((__oflag & RW_MASK) == O_RDWR) || ((__oflag & O_CREAT) == O_CREAT) || ((__oflag & O_TRUNC) == O_TRUNC));
    assert read || write;
    return write ? RW_OPEN_MODE : R_OPEN_MODE;
  }

  private static int openFileDescriptorImpl(String name, String mode, boolean truncate) throws FileNotFoundException, IOException {
    
    RandomAccessFile file = new RandomAccessFile(name, mode);
    if (truncate) {
      try {
        file.getChannel().truncate(0);
      } catch (IOException e) {
        if ("/dev/null".contentEquals(name)) {
          // this is fine for /dev/null
        } else {
          throw e;
        }
      }
    }
    synchronized (openedFiles) {
      int index = -1;
      // find available file descriptor
      for (int i = 0; i < openedFiles.size(); i++) {
        // the first empty number
        if (openedFiles.get(i) == null) {
          index = i;
          break;
        }
      }
      if (index == -1) {
        index = openedFiles.size();
        openedFiles.add(null);
      }
      // register file descriptor
      openedFiles.set(index, new OpenedFile(name, file));
      return index;
    }
  }
  
  /**
   *   The fopen() function opens the file whose name is the string pointed to
   *   by path and associates a stream with it.
   *
   *   The argument mode points to a string beginning with one of the  follow-
   *   ing sequences (Additional characters may follow these sequences.):
   *
   *   r      Open  text  file	for  reading.  The stream is positioned at the
   *    beginning of the file.
   *
   *   r+     Open for reading and writing.  The stream is positioned  at  the
   *    beginning of the file.
   *
   *   w      Truncate	file  to  zero length or create text file for writing.
   *    The stream is positioned at the beginning of the file.
   *
   *   w+     Open for reading and writing.  The file is created  if  it  does
	 *    not  exist, otherwise it is truncated.  The stream is positioned
	 *    at the beginning of the file.
   *
   *   a      Open for appending (writing at end of file).  The file  is  cre-
	 *    ated  if it does not exist.  The stream is positioned at the end
	 *    of the file.
   *
   *   a+     Open for reading and appending (writing at end  of  file).   The
	 *    file is created if it does not exist.  The initial file position
	 *    for reading is at the beginning  of  the	file,  but  output  is
	 *    always appended to the end of the file.
   *
   *   The  mode  string  can  also  include the letter ''b'' either as a last
   *   character or as a character between the characters in any of  the  two-
   *   character  strings described above.  This is strictly for compatibility
   *   with C89 and has no effect; the ''b'' is ignored on all POSIX  conform-
   *   ing  systems, including Linux.  (Other systems may treat text files and
   *   binary files differently, and adding the ''b'' may be a	good  idea  if
   *   you  do I/O to a binary file and expect that your program may be ported
   *   to non-Unix environments.)
   *
   *   Any	  created	  files		will	     have	  mode
   *   S_IRUSR|S_IWUSR|S_IRGRP|S_IWGRP|S_IROTH|S_IWOTH	(0666), as modified by
   *   the process' umask value (see umask(2)).
   *
   *   Reads and writes may be intermixed on read/write streams in any	order.
   *   Note  that  ANSI	 C requires that a file positioning function intervene
   *   between output and input, unless an input operation encounters  end-of-
   *   file.   (If this condition is not met, then a read is allowed to return
   *   the result of writes other than the most recent.)  Therefore it is good
   *   practice (and indeed sometimes necessary under Linux) to put an fseek()
   *   or fgetpos() operation between write and	 read  operations  on  such  a
   *   stream.	 This operation may be an apparent no-op (as in fseek(..., 0L,
   *   SEEK_CUR) called for its synchronizing side effect.
   *
   *   Opening a file in append mode (a as the first character of mode) causes
   *   all subsequent write operations to this stream to occur at end-of-file,
   *   as if preceded by an
	 *    fseek(stream,0,SEEK_END);
   *   call.
   *
   *   The fdopen() function  associates  a  stream  with  the	existing  file
   *   descriptor,  fildes.   The  mode	 of the stream (one of the values "r",
   *   "r+", "w", "w+", "a", "a+") must be compatible with  the	 mode  of  the
   *   file  descriptor.  The file position indicator of the new stream is set
   *   to that belonging to fildes, and the error and  end-of-file  indicators
   *   are  cleared.   Modes  "w" or "w+" do not cause truncation of the file.
   *   The file descriptor is not dup'ed, and will be closed when  the	stream
   *   created	by  fdopen()  is closed.  The result of applying fdopen() to a
   *   shared memory object is undefined.
   *
   *   The freopen() function opens the file whose name is the string  pointed
   *   to by path and associates the stream pointed to by stream with it.  The
   *   original stream (if it exists) is closed.  The mode  argument  is  used
   *   just  as	 in  the  fopen()  function.  The primary use of the freopen()
   *   function is to change the file associated with a standard  text	stream
   *   (stderr, stdin, or stdout).   
   *
   * @param __file
   * @param mode
   * @return Upon successful completion fopen() return a
   * FILE pointer. Otherwise, NULL is returned and errno is set to indicate the
   * error.
   *
   * ERRORS
   *  EINVAL The  mode	 provided  to  fopen(),	 fdopen(),  or	freopen()  was
   *   invalid.
   *
   *  The fopen(), fdopen() and freopen() functions may  also	fail  and  set
   *  errno for any of the errors specified for the routine malloc(3).
   *
   *  The  fopen() function may also fail and set errno for any of the errors
   *  specified for the routine open(2).
   *
   *  The fdopen() function may also fail and set errno for any of the errors
   *  specified for the routine fcntl(2).
   *
   *  The  freopen()  function	 may  also  fail  and set errno for any of the
   *  errors specified for the routines open(2), fclose(3) and fflush(3).   
   */
  public static FILE	fopen(char$iterator<?> __file, CharSequence mode) {
    String fileName = Native.$toString(__file);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("fopen requested for:" + fileName, NativeTrace.TRACE_IO);
    setErrno(0); 
    String modeString = mode.toString();
    boolean exists = new java.io.File(fileName).exists();
    if (modeString.startsWith("r")) {
      if (exists) {
        boolean openForRW = modeString.startsWith("r+") || modeString.startsWith("rb+");
        int fId = open(__file, openForRW ? O_RDWR : O_RDONLY);
        if (fId >= 0) {
          return new FILE(fId);
        }
        return null;
      } else {
        setErrno(ENOENT); // no such file or directory
        return null;
      }
    } else if (modeString.startsWith("w")) {
      if (modeString.startsWith("w+")
            || modeString.startsWith("wb+")) {
        int fId = open(__file, O_RDWR | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR | S_IRGRP);
        if (fId >= 0) {
          return new FILE(fId);
        }
        return null;
      } else {
        int fId = open(__file, O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR | S_IRGRP);
        if (fId >= 0) {
          return new FILE(fId);
        }
        return null;
      }
    } else if (modeString.startsWith("a")) {
      if (modeString.startsWith("a+")
            || modeString.startsWith("ab+")) {
        int fId = open(__file, O_APPEND | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR | S_IRGRP);
        if (fId >= 0) {
          return new FILE(fId);
        }
        return null;
      } else {
        int fId = open(__file, O_RDWR | O_APPEND | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR | S_IRGRP);
        if (fId >= 0) {
          return new FILE(fId);
        }
        return null;
      }
    }
    setErrno(EINVAL); // invalid mode
    return null;
  }
  
  /* Symbolic constants for the "access" routine: */
  public static final int 	R_OK	= 4;	/* Test for Read permission */
  public static final int 	W_OK	= 2;	/* Test for Write permission */
  public static final int 	X_OK	= 1;	/* Test for eXecute permission */
  public static final int 	F_OK	= 0;	/* Test for existence of File */

  /**
   * 
   *  access()	 checks whether the process would be allowed to read, write or
   *  test for existence of the file (or other file system object) whose name
   *  is  pathname.   If  pathname is a symbolic link permissions of the file
   *  referred to by this symbolic link are tested.
   * 
   *  mode is a mask consisting of one or more of R_OK, W_OK, X_OK and	 F_OK.
   * 
   *  R_OK,  W_OK  and	 X_OK request checking whether the file exists and has
   *  read, write and execute permissions, respectively.  F_OK just  requests
   *  checking for the existence of the file.
   * 
   *  The tests depend on the permissions of the directories occurring in the
   *  path to the file, as given in  pathname,	 and  on  the  permissions  of
   *  directories  and files referred to by symbolic links encountered on the
   *  way.
   * 
   *  The check is done with the process's real UID and GID, rather than with
   *  the  effective  IDs  as	is done when actually attempting an operation.
   *  This is to allow set-user-ID programs to easily determine the  invoking
   *  user's authority.
   * 
   *  Only  access  bits  are checked, not the file type or contents.	There-
   *  fore, if a directory is found to be "writable," it probably means  that
   *  files  can  be created in the directory, and not that the directory can
   *  be written as a file.  Similarly, a DOS file may be found to  be	 "exe-
   *  cutable," but the execve(2) call will still fail.
   * 
   *  If  the process has appropriate privileges, an implementation may indi-
   *  cate success for X_OK even if none of the execute file permission  bits
   *  are set.   
   * 
   * @param __file
   * @param mode
   * @return 
   *   On  success  (all requested permissions granted), zero is returned.  On
   *   error (at least one bit in mode asked for a permission that is  denied,
   *   or  some other error occurred), -1 is returned, and errno is set appro-
   *   priately.   
   * 
   *ERRORS
   *
   *   access() shall fail if:
   *
   *   EACCES The requested access would be denied to the file or search  per-
   *    mission  is denied for one of the directories in the path prefix
   *    of pathname.  (See also path_resolution(2).)
   *
   *   ELOOP  Too many symbolic links were encountered in resolving  pathname.
   *
   *   ENAMETOOLONG
   *    pathname is too long.
   *
   *   ENOENT A directory component in pathname would have been accessible but
   *    does not exist or was a dangling symbolic link.
   *
   *   ENOTDIR
   *    A component used as a directory in pathname is not, in  fact,  a
   *    directory.
   *
   *   EROFS  Write  permission	 was  requested	 for  a	 file  on  a read-only
   *    filesystem.
   *
   *   access() may fail if:
   *
   *   EFAULT pathname points outside your accessible address space.
   *
   *   EINVAL mode was incorrectly specified.
   *
   *   EIO    An I/O error occurred.
   *
   *   ENOMEM Insufficient kernel memory was available.
   *
   *   ETXTBSY
   *    Write access was requested to an executable which is being  executed.   
   */
  public static int access(char$iterator<?> __file, long mode) {
    String fileName = Native.$toString(__file);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("access requested for:" + fileName, NativeTrace.TRACE_IO);
    Path path = resolvePathByFileName(fileName);
    setErrno(0); 
    if (mode > (R_OK | W_OK | X_OK)) {
      setErrno(EINVAL);
      return -1;
    }
    if (!Files.exists(path)) {
      setErrno(ENOENT); // No such file or directory
      return -1;
    }
    if (mode == F_OK) {
      return 0;
    }
    if ((mode & R_OK) == R_OK) {
      if (!Files.isReadable(path)) {
        setErrno(EACCES); // Permission denied
        return -1;        
      }
    }
    if ((mode & W_OK) == W_OK) {
      if (!Files.isWritable(path)) {
        setErrno(EACCES); // Permission denied
        return -1;        
      }
    }
    if ((mode & 0x1) == X_OK) {
      if (!Files.isExecutable(path)) {
        setErrno(EACCES); // Permission denied
        return -1;
      }
    }
    return 0;
  }
    
  public static int ferror(FILE F) {
    // TODO: now we do not set errors in FILE. Use errno as workaround
    return errno();
  }
  
  public static int feof(FILE F) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  public static int fclose(FILE F) {
    if (F != null && F.$FD >= 0) {
      return close(F.$FD);
    }
    return 0;
  }
  
  public static int ftruncate(int FD, long/*uint64_t*/ size) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Seek to a certain position on STREAM.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static int fseek (FILE /*P*/__stream, long __off, int __whence) {
    assert __whence == SEEK_SET 
            || __whence == SEEK_END
            || __whence == SEEK_CUR;
    if (__stream.$FD >= 0) {
      setErrno(0);
      OpenedFile OF = getOpenedFileImpl(__stream.$FD);
      try {
        long whence;
        switch (__whence) {
          case SEEK_SET:
            whence = 0;
            break;
          case SEEK_END:
            whence = OF.length();
            break;
          case SEEK_CUR:
            whence = OF.position();
            break;
          default:
            throw new IllegalStateException("Not reachable!");
        }
        OF.seek(whence + __off);
      } catch (IOException ex) {
        Logger.getLogger(io.class.getName()).log(Level.INFO, null, ex);
        setErrno(EACCES);
        return -1;
      }
      return 0;
    }
    setErrno(EINVAL);
    return -1;
  }
  
  /* Return the current position of STREAM.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static long ftell (FILE /*P*/__stream) {
    if (__stream.$FD >= 0) {
      setErrno(0);
      OpenedFile OF = getOpenedFileImpl(__stream.$FD);
      try {
        return OF.position();
      } catch (IOException ex) {
        Logger.getLogger(io.class.getName()).log(Level.INFO, null, ex);
        setErrno(EACCES);
        return -1;
      }
    }
    setErrno(EINVAL);
    return -1;
  }
  
  /* Write a string to STREAM.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static int fputs(char$ptr __s, FILE/*P*/ __stream) {
    if (__stream.$FD >= 0) {
      if (fwrite(__s, NativeType.BYTES_IN_BYTE, strlen(__s), __stream) < 0) {
        return EOF;
      }
      return 0;
    }
    setErrno(EBADF);
    return EOF;
  }
  
  /* Read chunks of generic data from STREAM.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static /*size_t*/int	fread(char$ptr buf, /*size_t*/int elem_size, /*size_t*/int count, FILE F) {
    if (F.$FD >= 0) {
      setErrno(0);
      OpenedFile OF = getOpenedFileImpl(F.$FD);
      if (OF == null) {
        Logger.getLogger(io.class.getName()).log(Level.SEVERE, "fread not opened {0}", F.$FD);
        setErrno(EBADF);
        return 0;
      }
      long bytesRead = read(F.$FD, buf, elem_size * count);
      if (bytesRead >= 0) {
        return $long2uint(bytesRead / elem_size);
      } else {
        return 0;
      }
    }
    setErrno(EBADF);
    return 0;
  }
  public static /*size_t*/int	fread(void$ptr buf, /*size_t*/int elem_size, /*size_t*/int count, FILE F) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static /*size_t*/int	fread(char$ptr buf, /*size_t*/int elem_size, /*size_t*/int count, istream F) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static /*size_t*/int	fread(void$ptr buf, /*size_t*/int elem_size, /*size_t*/int count, istream F) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Write chunks of generic data to STREAM.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static /*size_t*/int fwrite(char$ptr __ptr, /*size_t*/int __size,
            /*size_t*/int __n, FILE /*P*/ __s) {
    if (__s.$FD >= 0) {
      setErrno(0);
      OpenedFile OF = getOpenedFileImpl(__s.$FD);
      if (OF == null) {
        Logger.getLogger(io.class.getName()).log(Level.SEVERE, "fwrite not opened {0}", __s.$FD);
        setErrno(EBADF);
        return 0;
      }
      long bytesWritten = write(__s.$FD, __ptr, 0, __size * __n);
      if (bytesWritten >= 0) {
        return $long2uint(bytesWritten / __size);
      } else {
        return 0;
      }
    }
    setErrno(EBADF);
    return 0;
  }
  public static /*size_t*/int fwrite(void$ptr __ptr, /*size_t*/int __size,
            /*size_t*/int __n, FILE /*P*/ __s) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static /*size_t*/int fwrite(char$ptr __ptr, /*size_t*/int __size,
            /*size_t*/int __n, ostream /*P*/ __s) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  public static /*size_t*/int fwrite(void$ptr __ptr, /*size_t*/int __size,
            /*size_t*/int __n, ostream /*P*/ __s) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Flush STREAM, or all streams if STREAM is NULL.

     This function is a possible cancellation point and therefore not
     marked with __THROW.  */
  public static int fflush(FILE /*P*/__stream) {
    if (__stream != null && __stream.$FD >= 0) {
      OpenedFile OF = getOpenedFileImpl(__stream.$FD);
      if (OF.file != null) {
        // TODO: use sync?
        // OF.file.getFD().sync();
      } else {
        if (OF.outStream instanceof JavaPrintStreamWrapper) {
          try {
            ((JavaPrintStreamWrapper) OF.outStream).getDelegate().flush();
          } catch (IOException ex) {
            NativeTrace.printStackTraceOnce(ex, Level.SEVERE, false);
            return EOF;
          }
        }
      }
      return 0;
    }
    return EOF;
  }
  public static int fflush(ostream /*P*/__stream) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* If BUF is NULL, make STREAM unbuffered.
     Else make it use buffer BUF, of size BUFSIZ.  */
  public static void setbuf(FILE /*P*/ __stream, char$ptr __buf) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Make STREAM use buffering mode MODE.
     If BUF is not NULL, use N bytes of it for buffering;
     else allocate an internal buffer N bytes long.  */
  public static int setvbuf(FILE /*P*/ __stream, char$ptr __buf,
          int __modes, /*size_t*/int __n) {
    assert __buf == null : "Non-null buffer is not supported yet!"; 
    if (NativeTrace.TRACE_IO) {
      NativeTrace.trace("setvbuf requested for " + __stream.$FD, NativeTrace.TRACE_IO);
    }
    return 0;
  }
  
  /* Return the system file descriptor for STREAM.  */
  public static int fileno(FILE /*P*/__stream) {
    return __stream.$FD;
  }
  
  /* Get a newline-terminated string of finite length from STREAM.

   This function is a possible cancellation point and therefore not
   marked with __THROW.  */
  public static char$ptr fgets(char$ptr __s, int __n, FILE __stream) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  //////////////////////////////////////////////////////////////////////////////
  // #include <sys/mman.h>
  
  public static final char$ptr MAP_FAILED	= $toConst(create_char$ptr((byte[]) null));

  /**
   * mmap() creates a new mapping in the virtual address space of the
   * calling process. The starting address for the new mapping is
   * specified in addr. The length argument specifies the length of the
   * mapping.
   *
   * If addr is NULL, then the kernel chooses the address at which to
   * create the mapping; this is the most portable method of creating a
   * new mapping. If addr is not NULL, then the kernel takes it as a
   * hint about where to place the mapping; on Linux, the mapping will
   * be created at a nearby page boundary. The address of the new
   * mapping is returned as the result of the call.
   *
   * The contents of a file mapping (as opposed to an anonymous mapping;
   * see MAP_ANONYMOUS below), are initialized using length bytes
   * starting at offset offset in the file (or other object) referred to
   * by the file descriptor fd. offset must be a multiple of the page
   * size as returned by sysconf(_SC_PAGE_SIZE).
   *
   * The prot argument describes the desired memory protection of the
   * mapping (and must not conflict with the open mode of the file). It
   * is either PROT_NONE or the bitwise OR of one or more of the
   * following flags:
   * 
   * PROT_EXEC
   *     Pages may be executed. 
   * PROT_READ
   *     Pages may be read. 
   * PROT_WRITE
   *     Pages may be written. 
   * PROT_NONE
   *     Pages may not be accessed.
   * 
   * The flags argument determines whether updates to the mapping are
   * visible to other processes mapping the same region, and whether
   * updates are carried through to the underlying file. This behavior
   * is determined by including exactly one of the following values in
   * flags:
   * 

   * MAP_SHARED
   *     Share this mapping. Updates to the mapping are visible to other processes 
   * that map this file, and are carried through to the underlying file. 
   * The file may not actually be updated until msync(2) or munmap() is called. 
   * MAP_PRIVATE
   *     Create a private copy-on-write mapping. 
   * Updates to the mapping are not visible to other processes mapping the same file, 
   * and are not carried through to the underlying file. 
   * It is unspecified whether changes made to the 
   * file after the mmap() call are visible in the mapped region.
   * 
   * Both of these flags are described in POSIX.1-2001.
   *
   * In addition, zero or more of the following values can be ORed in
   * flags:
   *
   * MAP_32BIT (since Linux 2.4.20, 2.6)
   *     Put the mapping into the first 2 Gigabytes of the process address space. 
   * This flag is only supported on x86-64, for 64-bit programs. 
   * It was added to allow thread stacks to be allocated somewhere in 
   * the first 2GB of memory, so as to improve context-switch performance on some 
   * early 64-bit processors. Modern x86-64 processors no longer have this performance 
   * problem, so use of this flag is not required on those systems. 
   * The MAP_32BIT flag is ignored when MAP_FIXED is set. 
   * MAP_ANON
   *     Synonym for MAP_ANONYMOUS. Deprecated. 
   * MAP_ANONYMOUS
   *     The mapping is not backed by any file; its contents are initialized to zero. 
   * The fd and offset arguments are ignored; however, 
   * some implementations require fd to be -1 if MAP_ANONYMOUS (or MAP_ANON) is specified, 
   * and portable applications should ensure this. 
   * The use of MAP_ANONYMOUS in conjunction with MAP_SHARED is only supported on Linux since kernel 2.4. 
   * MAP_DENYWRITE
   *     This flag is ignored. (Long ago, it signaled that attempts 
   * to write to the underlying file should fail with ETXTBUSY. 
   * But this was a source of denial-of-service attacks.) 
   * MAP_EXECUTABLE
   *     This flag is ignored. 
   * MAP_FILE
   *     Compatibility flag. Ignored. 
   * MAP_FIXED
   *     Don't interpret addr as a hint: place the mapping at exactly that address. 
   * addr must be a multiple of the page size. If the memory region specified by addr and len 
   * overlaps pages of any existing mapping(s), 
   * then the overlapped part of the existing mapping(s) will be discarded. 
   * If the specified address cannot be used, mmap() will fail. 
   * Because requiring a fixed address for a mapping is less portable, the use of this option is discouraged. 
   * MAP_GROWSDOWN
   *     Used for stacks. Indicates to the kernel virtual memory system 
   * that the mapping should extend downward in memory. 
   * MAP_HUGETLB (since Linux 2.6.32)
   *     Allocate the mapping using "huge pages." See the Linux kernel source 
   * file Documentation/vm/hugetlbpage.txt for further information. 
   * MAP_LOCKED (since Linux 2.5.37)
   *     Lock the pages of the mapped region into memory in the manner of mlock(2). 
   * This flag is ignored in older kernels. 
   * MAP_NONBLOCK (since Linux 2.5.46)
   *     Only meaningful in conjunction with MAP_POPULATE. Don't perform read-ahead: 
   * only create page tables entries for pages that are already present in RAM. 
   * Since Linux 2.6.23, this flag causes MAP_POPULATE to do nothing. 
   * One day the combination of MAP_POPULATE and MAP_NONBLOCK may be reimplemented. 
   * MAP_NORESERVE
   *     Do not reserve swap space for this mapping. When swap space is reserved, 
   * one has the guarantee that it is possible to modify the mapping. 
   * When swap space is not reserved one might get SIGSEGV upon a write if no physical memory is available. 
   * See also the discussion of the file /proc/sys/vm/overcommit_memory in proc(5). 
   * In kernels before 2.6, this flag only had effect for private writable mappings. 
   * MAP_POPULATE (since Linux 2.5.46)
   *     Populate (prefault) page tables for a mapping. For a file mapping, 
   * this causes read-ahead on the file. 
   * Later accesses to the mapping will not be blocked by page faults. 
   * MAP_POPULATE is only supported for private mappings since Linux 2.6.23. 
   * MAP_STACK (since Linux 2.6.27)
   *     Allocate the mapping at an address suitable for a process or thread stack. 
   * This flag is currently a no-op, but is used in the glibc threading 
   * implementation so that if some architectures require special treatment 
   * for stack allocations, support can later be transparently implemented for glibc. 
   * MAP_UNINITIALIZED (since Linux 2.6.33)
   *     Don't clear anonymous pages. This flag is intended to improve 
   * performance on embedded devices. This flag is only honored if the kernel 
   * was configured with the CONFIG_MMAP_ALLOW_UNINITIALIZED option. 
   * Because of the security implications, that option is normally enabled 
   * only on embedded devices (i.e., devices where one has complete 
   * control of the contents of user memory).
   * 
   * Of the above flags, only MAP_FIXED is specified in POSIX.1-2001.
   * However, most systems also support MAP_ANONYMOUS (or its synonym
   * MAP_ANON).
   *
   * Some systems document the additional flags MAP_AUTOGROW,
   * MAP_AUTORESRV, MAP_COPY, and MAP_LOCAL.
   *
   * Memory mapped by mmap() is preserved across fork(2), with the same
   * attributes.
   *
   * A file is mapped in multiples of the page size. For a file that is
   * not a multiple of the page size, the remaining memory is zeroed
   * when mapped, and writes to that region are not written out to the
   * file. The effect of changing the size of the underlying file of a
   * mapping on the pages that correspond to added or removed regions of
   * the file is unspecified.
   * 
   * Timestamps changes for file-backed mappings For file-backed
   * mappings, the st_atime field for the mapped file may be updated at
   * any time between the mmap() and the corresponding unmapping; the
   * first reference to a mapped page will update the field if it has
   * not been already.
   *
   * The st_ctime and st_mtime field for a file mapped with PROT_WRITE
   * and MAP_SHARED will be updated after a write to the mapped region,
   * and before a subsequent msync(2) with the MS_SYNC or MS_ASYNC flag,
   * if one occurs.
   * 
   * Return Value On success, mmap() returns a pointer to the mapped
   * area. On error, the value MAP_FAILED (that is, (void *) -1) is
   * returned, and errno is set appropriately. On success, munmap()
   * returns 0, on failure -1, and errno is set (probably to EINVAL).
   * 
   * Errors
   * 
   * EACCES
   *     A file descriptor refers to a non-regular file. Or MAP_PRIVATE was requested, 
   * but fd is not open for reading. Or MAP_SHARED was requested and PROT_WRITE is set, 
   * but fd is not open in read/write (O_RDWR) mode. Or PROT_WRITE is set, but the file is append-only. 
   * EAGAIN
   *     The file has been locked, or too much memory has been locked (see setrlimit(2)). 
   * EBADF
   *     fd is not a valid file descriptor (and MAP_ANONYMOUS was not set). 
   * EINVAL
   *     We don't like addr, length, or offset (e.g., they are too large, or not aligned on a page boundary). 
   * EINVAL
   *     (since Linux 2.6.12) length was 0. 
   * EINVAL
   *     flags contained neither MAP_PRIVATE or MAP_SHARED, or contained both of these values. 
   * ENFILE
   *     The system limit on the total number of open files has been reached. 
   * ENODEV
   *     The underlying file system of the specified file does not support memory mapping. 
   * ENOMEM
   *     No memory is available, or the process's maximum number of mappings would have been exceeded. 
   * EPERM
   *     The prot argument asks for PROT_EXEC but the mapped area belongs to a file on a file system that was mounted no-exec. 
   * ETXTBSY
   *     MAP_DENYWRITE was set but the object specified by fd is open for writing. 
   * EOVERFLOW
   *     On 32-bit architecture together with the large file extension 
   * (i.e., using 64-bit off_t): the number of pages used for length plus 
   * number of pages used for offset would overflow unsigned long (32 bits).
   * 
   * Use of a mapped region can result in these signals:
   * 
   * SIGSEGV
   *     Attempted write into a region mapped as read-only. 
   * SIGBUS
   *     Attempted access to a portion of the buffer that does not correspond 
   * to the file (for example, beyond the end of the file, 
   * including the case where another process has truncated the file).
   */
  public static char$ptr mmap(void$ptr start, /*uint64_t*/long length, int prot, int flags, int FD, long/*off_t*/ offset) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate mmap-open request to custome FS impl?";
    OpenedFile openedFile = getOpenedFileImpl(FD);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("fstat requested for " + FD + ":" + openedFile, NativeTrace.TRACE_IO);
    setErrno(0);    
    if (start != null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "invalid addr {0}:{1}", new Object[] {FD, start});
      setErrno(EINVAL);
      return MAP_FAILED;
    }
    if (offset != 0) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "invalid offset {0}:{1}", new Object[] {FD, offset});
      setErrno(EINVAL);
      return MAP_FAILED;
    }
    assert start == null : "non null is not portable";
    if (openedFile == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "closing not opened {0}", FD);
      setErrno(EBADF);
      return MAP_FAILED;
    }    
    if (openedFile.file == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "closing {0}:{1}", new Object[] {FD, openedFile});
      setErrno(EBADF);
      return MAP_FAILED;
    }    
    FileChannel.MapMode mode = toMapMode(prot, flags);
    if (mode == null) {
      Logger.getLogger(io.class.getName()).log(Level.SEVERE, "no write or read flags {0}:{1}", new Object[] {FD, Integer.toHexString(flags)});
      setErrno(EINVAL);
      return MAP_FAILED;
    }
    try {
      return openedFile.mmap(mode, offset, length);
    } catch (FileNotFoundException ex) {
      // file can be already removed from FS
      Logger.getLogger(io.class.getName()).log(Level.WARNING, "file {0} not found, probably removed", new Object[]{openedFile.toString()});// NOI18N
      setErrno(EINVAL);
      return MAP_FAILED;      
    } catch (IOException ex) {
      if (ex.getMessage().contains("cannot extend file to required size")) {
        // file can be already changed on disk
        Logger.getLogger(io.class.getName()).log(Level.WARNING, "file {0} size doesn't match, probably updated externally", new Object[]{openedFile.toString()});// NOI18N
      } else {
        Logger.getLogger(io.class.getName()).log(Level.WARNING, ""+openedFile, ex);
      }
      setErrno(EINVAL);
      return MAP_FAILED;      
    }
  }

  /**
   * The munmap() system call deletes the mappings for the specified
   * address range, and causes further references to addresses within
   * the range to generate invalid memory references. The region is also
   * automatically unmapped when the process is terminated. On the other
   * hand, closing the file descriptor does not unmap the region.
   *
   * The address addr must be a multiple of the page size. All pages
   * containing a part of the indicated range are unmapped, and
   * subsequent references to these pages will generate SIGSEGV. It is
   * not an error if the indicated range does not contain any mapped
   * pages.
   */
  public static int munmap(void$ptr start, /*uint64_t*/long length) {
    assert !NativeTrace.ALWAYS_USE_NB_FS : "forgot to delegate munmap request to custome FS impl?";
    OpenedFile openedFile = getOpenedFileImpl(start);
    if (NativeTrace.TRACE_IO) NativeTrace.trace("munmap requested " + openedFile, NativeTrace.TRACE_IO);
    setErrno(0);
    if (openedFile == null) {
      // It is not a fatal error if the indicated range does not contain any mapped pages.
      // It is not a fatal error to unmap pointer from already closed file
      setErrno(EINVAL);
      return -1;
    }
    openedFile.munmap(start, length);
    return 0;
  }
  
  private static FileChannel.MapMode toMapMode(int protection, int flags) {
    FileChannel.MapMode mode = null;
    if ((protection & PROT_WRITE) == PROT_WRITE) {      
      if ((protection & PROT_READ) == PROT_READ) {
//        assert (flags & MAP_SHARED) == MAP_SHARED : "unexpected flag " + Integer.toHexString(flags);
        return FileChannel.MapMode.READ_WRITE;      
      } else if ((flags & MAP_PRIVATE) == MAP_PRIVATE) {
        return FileChannel.MapMode.PRIVATE;      
      }
    } else if ((protection & PROT_READ) == PROT_READ) {
        return FileChannel.MapMode.READ_ONLY;
    }
    return mode;
  }
  //////////////////////////////////////////////////////////////////////////////
  // #include <utsname.h>
  //////////////////////////////////////////////////////////////////////////////
  
/* Length of the entries in `struct utsname' is 65.  */
  private static final int _UTSNAME_LENGTH = 65;

/* Linux provides as additional information in the `struct utsname'
   the name of the current domain.  Define _UTSNAME_DOMAIN_LENGTH
   to a value != 0 to activate this entry.  */
  private static final int _UTSNAME_DOMAIN_LENGTH    = _UTSNAME_LENGTH;
  private static final int _UTSNAME_SYSNAME_LENGTH   = _UTSNAME_LENGTH;
  private static final int _UTSNAME_NODENAME_LENGTH  = _UTSNAME_LENGTH;
  private static final int _UTSNAME_RELEASE_LENGTH   = _UTSNAME_LENGTH;
  private static final int _UTSNAME_VERSION_LENGTH   = _UTSNAME_LENGTH;
  private static final int _UTSNAME_MACHINE_LENGTH   = _UTSNAME_LENGTH;
  
  public static final String UNKNOWN = "unknown";
  
  public static final class utsname {
    /* Name of the implementation of the operating system.  */
    public /*char*/byte sysname[] = new$char(_UTSNAME_SYSNAME_LENGTH);

    /* Name of this node on the network.  */
    public /*char*/byte nodename[] = new$char(_UTSNAME_NODENAME_LENGTH);

    /* Current release level of this implementation.  */
    public /*char*/byte release[] = new$char(_UTSNAME_RELEASE_LENGTH);
    /* Current version level of this release.  */
    public /*char*/byte version[] = new$char(_UTSNAME_VERSION_LENGTH);

    /* Name of the hardware type the system is running on.  */
    public /*char*/byte machine[] = new$char(_UTSNAME_MACHINE_LENGTH);

    /* Name of the domain of this node on the network.  */
    public /*char*/byte domainname[] = new$char(_UTSNAME_DOMAIN_LENGTH);
  }
  
  public static int uname(utsname out) {
    setErrno(0);
    std.memcpy(out.sysname, System.getProperty("os.name", UNKNOWN));
    std.memcpy(out.version, System.getProperty("os.version", UNKNOWN));
    std.memcpy(out.machine, System.getProperty("os.arch", UNKNOWN));
    std.memcpy(out.nodename, Hostname.hostName);
    std.memcpy(out.release, System.getProperty("os.arch", UNKNOWN) + "-" + System.getProperty("os.name", UNKNOWN) + "-" + System.getProperty("os.version", UNKNOWN));
    return errno();
  }
  
  private static final class Hostname
  {
     private static final String hostName = get();
     private static String get()
     {
        String hostName = null;
        if (hostName == null)
        {
           // First try a command line property
           hostName = System.getProperty("HOSTNAME") ;
        }

        if (hostName == null)
        {
           // Next try the environment
           hostName = System.getenv("HOSTNAME") ;
        }

        if (hostName == null)
        {
           // Next, assume POSIX and run uname -n
           try
           {
              Process uname = Runtime.getRuntime().exec("uname -n") ;
              BufferedReader input =
                 new BufferedReader
                   (new InputStreamReader(uname.getInputStream()));
              hostName = input.readLine() ;
              int ret = uname.waitFor() ;
              if (ret != 0)
              {
                 hostName = null ;
              }
           } catch (Exception e) {}
        }

        if (hostName == null)
        {
           // Last, do the reverse DNS lookup
           try
           {
              hostName = java.net.InetAddress.getLocalHost().getHostName() ;
           } catch (Exception e){}
        }

        return hostName == null ? UNKNOWN : hostName;
     }
  }  
  //////////////////////////////////////////////////////////////////////////////
  // #include <dlfcn.h>
  //////////////////////////////////////////////////////////////////////////////
  
  public static final class/*struct*/ Dl_info {
    public /*const*/char$ptr/*char P*/ dli_fname; /* file containing address range */
    public void$ptr/*void P*/ dli_fbase; /* base address of file image */
    public /*const*/char$ptr/*char P*/ dli_sname; /* symbol name */
    public void$ptr/*void P*/ dli_saddr; /* symbol address */
  }
 
  /**
   * The dladdr() and dladdr1() functions determine if the speci- fied address
   * is located within one of the mapped objects that make up the current
   * applications address space
   *
   * @param addr
   * @param out
   * @return If the specified address cannot be matched to a mapped object, a 0
   * is returned. Otherwise, a non-zero return is made and the associated
   * Dl_info elements are filled.
   *
   */
  public static int	dladdr(Object/*void P*/ addr, Dl_info out) {
    throw new UnsupportedOperationException("EmptyBody");
  }  
  
  /*
   * dup2() makes newfd be the copy of oldfd, closing newfd first if necessary, but note the following:
   *   - If oldfd is not a valid file descriptor, then the call fails, and newfd is not closed. 
   *   - If oldfd is a valid file descriptor, and newfd has the same value as oldfd, then dup2() does nothing, and returns newfd.
   * After a successful return from one of these system calls, the old and new file 
   * descriptors may be used interchangeably. They refer to the same open file 
   * description (see open(2)) and thus share file offset and file status flags; 
   * for example, if the file offset is modified by using lseek(2) on one of the 
   * descriptors, the offset is also changed for the other. 
  */
  public static int dup2(int oldfd, int newfd) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /* Get file-specific configuration information about PATH.  */
  public static long pathconf (char$ptr __path, int __name)  {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /* Get file-specific configuration about descriptor FD.  */
  public static long fpathconf (int __fd, int __name) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /* Get the value of the system variable NAME.  */
  public static long sysconf (int __name) {
    throw new UnsupportedOperationException("EmptyBody");
  }

//#ifdef __USE_POSIX2
  /* Get the value of the string-valued system variable NAME.  */
  public static /*uint*/int confstr (int __name, char$ptr __buf, /*uint*/int __len) {
    throw new UnsupportedOperationException("EmptyBody");
  }
//#endif
  
  /* Do the file control operation described by CMD on FD.
     The remaining arguments are interpreted depending on CMD.

     This function is a cancellation point and therefore not marked with
     __THROW.  */
  public static int fcntl(int __fd, int __cmd, Object...Args) {
    if (__fd >= 0) {
      setErrno(0);
      OpenedFile OF = getOpenedFileImpl(__fd);
      switch (__cmd) {
        case F_GETFD:
          return OF.getFlags();
          
        case F_SETFD:
          OF.setFlags((Integer) Args[0]);
          return 0;
          
        default:
          // Command is not recognized by this kernel
          setErrno(EINVAL);
          return -1;
      }
    }
    setErrno(EBADF);
    return -1;
  }
}
