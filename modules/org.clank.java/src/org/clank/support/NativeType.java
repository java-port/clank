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


package org.clank.support;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.clank.java.std;
import org.clank.support.aliases.*;

/**
 *
 * @author petrk
 */
public class NativeType {

  public final static int BYTES_IN_BYTE = Byte.SIZE / Byte.SIZE;

  public final static int BYTES_IN_UCHAR = Byte.SIZE / Byte.SIZE;

  public final static int BYTES_IN_INT = Integer.SIZE / Byte.SIZE;
  
  public final static int BYTES_IN_FLOAT = Float.SIZE / Byte.SIZE;

  public final static int BYTES_IN_DOUBLE = Double.SIZE / Byte.SIZE;

  public final static int BYTES_IN_UINT = Integer.SIZE / Byte.SIZE;

  public final static int BYTES_IN_SHORT = Character.SIZE / Byte.SIZE;

  public final static int BYTES_IN_USHORT = Character.SIZE / Byte.SIZE;

  public final static int BYTES_IN_BOOL = BYTES_IN_BYTE;

  public final static int BYTES_IN_LONG = Long.SIZE / Byte.SIZE;
  public final static int BYTES_IN_ULONG = Long.SIZE / Byte.SIZE;

  public final static int BYTES_IN_LLINT = Long.SIZE / Byte.SIZE;
  
  public final static int BYTES_IN_ULINT = Long.SIZE / Byte.SIZE;

  public final static int BYTES_IN_ULLINT = Long.SIZE / Byte.SIZE;
  
  public final static int CHAR_BIT = Byte.SIZE;
  public final static int BITS_PER_WORD = Character.SIZE;
  
  // constants from $LLVM_SRC/llvm/projects/compiler-rt/lib/builtins/fp_lib.h
  // typedef uint32_t rep_t;  
  //typedef uint64_t rep_t;
  //typedef int64_t srep_t;
  //typedef double fp_t;
  public final static int significandBits = 52;
  // constants from $LLVM_SRC/llvm/projects/compiler-rt/lib/builtins/fp_lib.h
  public final static int typeWidth       = (/*sizeof(rep_t)*/BYTES_IN_UINT*CHAR_BIT);
  public final static int exponentBits    = (typeWidth - significandBits - 1);
  public final static int maxExponent     = ((1 << exponentBits) - 1);
  public final static int exponentBias    = (maxExponent >>> 1);
// constants from $LLVM_SRC/llvm/projects/compiler-rt/lib/builtins/fp_lib.h
  public final static /*uint64_t*/long implicitBit     = (1L << significandBits);
  public final static /*uint64_t*/long significandMask = (implicitBit - 1L);
  public final static /*uint64_t*/long signBit         = (1L << (significandBits + exponentBits));
  public final static /*uint64_t*/long absMask         = (signBit - 1L);
  public final static /*uint64_t*/long exponentMask    = (absMask ^ significandMask);
  public final static /*uint64_t*/long oneRep          = (((long)exponentBias) << significandBits);
  public final static /*uint64_t*/long infRep          = exponentMask;
  public final static /*uint64_t*/long quietBit        = (implicitBit >>> 1);
  public final static /*uint64_t*/long qnanRep         = (exponentMask | quietBit);

  private final static int BYTES_IN_JAVA_32_OBJECT_HEADER = 8;
  private final static int BYTES_IN_JAVA_64_OBJECT_HEADER = 16;
  private final static int BYTES_IN_JAVA_64_COMPRESSED_OBJECT_HEADER = 12;
  private final static long MAX_COMPRESSED_OOPS_BYTES = 1024L * 1024L * 3500L;
  
  public final static int BYTES_IN_JAVA_OBJECT_HEADER;
  static {
    int value = BYTES_IN_JAVA_64_OBJECT_HEADER;
    int bits = Integer.getInteger("sun.arch.data.model", 64);
    Runtime runtime = Runtime.getRuntime();
    if (bits == 32) {
      value = BYTES_IN_JAVA_32_OBJECT_HEADER;
    } else if (bits == 64) {
      if (runtime.maxMemory() <= MAX_COMPRESSED_OOPS_BYTES) {
        value = BYTES_IN_JAVA_64_COMPRESSED_OBJECT_HEADER;
      }
    }
    if (NativeTrace.VERBOSE_MODE) {
      System.err.println("sun.arch.data.model="+bits);
      System.err.println("Max memory " + NativeTrace.formatNumber(runtime.maxMemory()) + " vs. " + NativeTrace.formatNumber(MAX_COMPRESSED_OOPS_BYTES));
      System.err.println("Expected Class header size: " + value);
    }
    BYTES_IN_JAVA_OBJECT_HEADER = value;
  }

  public final static int BYTES_IN_JAVA_ARRAY_HEADER = 12;

  public final static int BYTES_IN_JAVA_OBJECT_REF = 4;

  public static void clearStatistics() {
    char$ptr$array.clearStatistics();
    type$ptr$array.clearStatistics();
    ushort$ptr$array.clearStatistics();
    uint$ptr$array.clearStatistics();
    int$ptr$array.clearStatistics();
    bool$ptr$array.clearStatistics();
    long$ptr$array.clearStatistics();
    llong$ptr$array.clearStatistics();
    short$ptr$array.clearStatistics();
    uchar$ptr$array.clearStatistics();
    ullong$ptr$array.clearStatistics();
    
    char$ptr$single.clearStatistics();
    type$ptr$single.clearStatistics();
    type$ref$single.clearStatistics();
    ushort$ptr$single.clearStatistics();    
    uint$ptr$single.clearStatistics();
    int$ptr$single.clearStatistics();
    bool$ptr$single.clearStatistics();
    long$ptr$single.clearStatistics();
    llong$ptr$single.clearStatistics();
    short$ptr$single.clearStatistics();
    uchar$ptr$single.clearStatistics();
    ullong$ptr$single.clearStatistics();
    
    char$ptr$CharSequence.clearStatistics();
    
    std.clearStatistics();
    
    Casts.clearStatistics();
    NativePointer.clearStatistics();
  }
  
  public static long printStatistics(PrintWriter out) {
    out.println("---Array based---");
    long ArrValue = 0;
    ArrValue += char$ptr$array.printStatistics(out);
    ArrValue += type$ptr$array.printStatistics(out);
    ArrValue += uint$ptr$array.printStatistics(out);
    ArrValue += int$ptr$array.printStatistics(out);
    ArrValue += long$ptr$array.printStatistics(out);
    ArrValue += bool$ptr$array.printStatistics(out);
    ArrValue += ushort$ptr$array.printStatistics(out);
    ArrValue += short$ptr$array.printStatistics(out);
    ArrValue += uchar$ptr$array.printStatistics(out);
    ArrValue += llong$ptr$array.printStatistics(out);
    ArrValue += ullong$ptr$array.printStatistics(out);
    NativeTrace.dumpStatisticValue(out, "TotalArrayBasedPointers", ArrValue);
    out.println("---Single based---");
    long SglValue = 0;
    SglValue += char$ptr$single.printStatistics(out);
    SglValue += type$ptr$single.printStatistics(out);
    SglValue += type$ref$single.printStatistics(out);
    SglValue += uint$ptr$single.printStatistics(out);
    SglValue += int$ptr$single.printStatistics(out);
    SglValue += long$ptr$single.printStatistics(out);
    SglValue += bool$ptr$single.printStatistics(out);
    SglValue += ushort$ptr$single.printStatistics(out);
    SglValue += short$ptr$single.printStatistics(out);
    SglValue += uchar$ptr$single.printStatistics(out);
    SglValue += llong$ptr$single.printStatistics(out);
    SglValue += ullong$ptr$single.printStatistics(out);
    NativeTrace.dumpStatisticValue(out, "TotalSingleBasedPointers", SglValue);
    out.println("---Others---");
    long Value = ArrValue + SglValue;
    Value += char$ptr$CharSequence.printStatistics(out);
    
    Value += std.printPairsStatistics(out);
    Value += std.printSmartPtrsStatistics(out);
    
    Value += Casts.printStatistics(out);
    Value += NativePointer.printStatistics(out);
    out.flush();
    NativeTrace.dumpStatisticValue(out, "TotalJavaMemoryValue", Value);
    return Value;
  }
  
  public interface SizeofCapable {
    /**
     * provides size of in bytes of the object 
     * @return 
     */
    public /*size_t*/int $sizeof();
  }

  public interface ToByteArray {
    /**
     * get object as byte array
     * @return byte presentation of object
     */
    public byte[] toByteArray();
    public static byte get0(short x) {return (byte)(x        & 0xFF);}
    public static byte get1(short x) {return (byte)((x>>> 8) & 0xFF);}
    public static byte get0(int   x) {return (byte)(x        & 0xFF);}
    public static byte get1(int   x) {return (byte)((x>>> 8) & 0xFF);}
    public static byte get2(int   x) {return (byte)((x>>>16) & 0xFF);}
    public static byte get3(int   x) {return (byte)((x>>>24) & 0xFF);}
    public static byte get0(long  x) {return (byte)(x        & 0xFF);}
    public static byte get1(long  x) {return (byte)((x>>> 8) & 0xFF);}
    public static byte get2(long  x) {return (byte)((x>>>16) & 0xFF);}
    public static byte get3(long  x) {return (byte)((x>>>24) & 0xFF);}
    public static byte get4(long  x) {return (byte)((x>>>32)  & 0xFF);}
    public static byte get5(long  x) {return (byte)((x>>>40) & 0xFF);}
    public static byte get6(long  x) {return (byte)((x>>>48) & 0xFF);}
    public static byte get7(long  x) {return (byte)((x>>>56) & 0xFF);}
  }
  
  public static int sizeof(boolean b) {
    return BYTES_IN_BYTE;
  }
  
  public static int sizeof(byte b) {
    return BYTES_IN_BYTE;
  }

  public static int sizeof(char b) {
    return BYTES_IN_SHORT;
  }

  public static int sizeof(short b) {
    return BYTES_IN_SHORT;
  }

  public static int sizeof(int b) {
    return BYTES_IN_INT;
  }

  public static int sizeof(float b) {
    return BYTES_IN_FLOAT;
  }

  public static int sizeof(long b) {
    return BYTES_IN_LONG;
  }

  public static int sizeof(double b) {
    return BYTES_IN_DOUBLE;
  }
  
  public static int sizeof$null(Object nullPtr) {
    assert nullPtr == null : "must be used only for sizeof(null)";
    return 0;
  }
  
  public static int sizeof$str(String str) {
    if (str == null) {
      return 0;
    }    
    assert str == str.intern();
    return str.length() + 1/*TERM*/;
  }

  public static int sizeof_array(byte[] o) {
    return o.length * BYTES_IN_BYTE;
  }
  
  public static int sizeof_not_null(Object o) {
    if (o == null) {
      return 0;
    }
    return sizeof(o);
  }
  
  public static int sizeof(Class<?> cls) {
    if (cls == null) {
      return 0;
    } else if (cls == int.class) {
      return BYTES_IN_INT;
    } else if (cls == byte.class) {
      return BYTES_IN_BYTE;
    } else if (cls == long.class) {
      return BYTES_IN_LONG;
    } else if (cls == float.class) {
      return BYTES_IN_FLOAT;
    } else if (cls == double.class) {
      return BYTES_IN_DOUBLE;
    } else if (cls == type$ptr.class) {
      return sizeof$ptr();
    } else if (cls == Object.class) {
      return 1;
    }
    NativeTrace.assertTrueInConsole(false, "Unexpected class ", cls);
    return sizeof((Object)cls);
  }
  
  public static int sizeof$uint8() {
    return BYTES_IN_BYTE;
  }

  public static int sizeof$uint16() {
    return BYTES_IN_SHORT;
  }

  public static int $sizeof_UInt() {
    return sizeof$uint32();
  }
  
  public static int $sizeof_UIntptr_t() {
    throw new UnsupportedOperationException("Not yet implemented.");
  }
  
  public static int $sizeof_ULong() {
    return sizeof$uint64();
  }
  
  public static int $sizeof_Double() {
    return sizeof$uint64();
  }

  public static int sizeof$uint32() {
    return BYTES_IN_INT;
  }

  public static int sizeof$uint64() {
    return BYTES_IN_LONG;
  }

  public static int sizeof$ptr() {
    return BYTES_IN_JAVA_OBJECT_REF;
  }
  
  public static int $sizeof_ptr() {
    return sizeof$ptr();
  }
  
  public static int sizeof(byte[] array) {
    return array.length * BYTES_IN_BYTE;
  }
  
  public static int sizeof(Object o) {
    if (o == null) {
      // null pointer to object is 4 bytes
      return sizeof$ptr();
    }
    if (o instanceof SizeofCapable) {
      return (int) ((SizeofCapable)o).$sizeof();
    }
    
    Class<?> cls = null;
    if (o instanceof Class) {
      cls = (Class<?>) o;
    } else {
      cls = o.getClass();
    }
    if (cls != null) {
      if (char$ptr.class.isAssignableFrom(cls)) {
        return sizeof$ptr();
      } else if (Byte.class.isAssignableFrom(cls) || byte.class.isAssignableFrom(cls) 
          || char$ref.class.isAssignableFrom(cls)) {
        return BYTES_IN_BYTE;
      } else if (Integer.class.isAssignableFrom(cls) || int.class.isAssignableFrom(cls) 
          || int$ref.class.isAssignableFrom(cls)) {
        return BYTES_IN_INT;
      } else if (Long.class.isAssignableFrom(cls) || long.class.isAssignableFrom(cls)
          || long$ref.class.isAssignableFrom(cls)) {
        return BYTES_IN_LONG;
      } else if (uint$ref.class.isAssignableFrom(cls)) {
        return BYTES_IN_UINT;
      } else if (byte[].class.isAssignableFrom(cls)) {
        return sizeof_array((byte[])o);
      } else {
        if (warnedSizeOf.add(cls)) {
//          new Exception().printStackTrace();
          NativeTrace.traceNotImplemented("can not calculate SIZE_OF " + cls);
        }
      }
    }
    return BYTES_IN_JAVA_OBJECT_REF;
  }

  private static final Set<Class<?>> warnedSizeOf = new HashSet<>();
  
  private static final Map<String, Object> defaultValues = new HashMap<>();

  static {
    // for test purposes
    defaultValues.put(Integer.class.getName(), 0);
    defaultValues.put(Long.class.getName(), 0l);
    defaultValues.put(Boolean.class.getName(), false);
  }

  private static Class loadClass(String name) throws ClassNotFoundException {
    try {
      ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
      if (contextClassLoader != null) {
        return contextClassLoader.loadClass(name);
      }
      return Class.forName(name);
    } catch (Exception e) {
      return Class.forName(name);
    }
  }

  public static <T> T createNewInstance(Class<T> cls) {
    if (cls == null) {
      return null;
    }
    T res = null;
    try {
      cls = loadClass(cls.getName());
      Constructor<T> constructor = cls.getDeclaredConstructor();
      constructor.setAccessible(true);
      res = constructor.newInstance();
    } catch (java.lang.reflect.InvocationTargetException | java.lang.InstantiationException e) {
      Throwable ex = e;
      if (e.getCause() != null) {
        ex = e.getCause();
      } else {
        NativeTrace.assertTrueInConsole(false, "Can not create object of class" + cls.getName());
      }
      NativeTrace.printStackTraceOnce(ex);
      res = null;
    } catch (java.lang.NoSuchMethodException e) {
      assert false : "Not defined constructor without parameters for " + cls;
    } catch (Exception ex) {
      NativeTrace.printStackTraceOnce(ex);
      res = null;
    }
    return res;
  }
  
  public static <T> T createDefaultValue(Class<T> cls) {
    if (cls == null) {
      return null;
    }
    String key = cls.getName();
    T res = null;
    if (defaultValues.containsKey(key)) {
      res = (T) defaultValues.get(key);
    } else {
      res = createNewInstance(cls);
      if (res != null) {
        defaultValues.put(key, res);
        System.err.println("Instantiated Default Value for " + key);
      } else if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
        // remember that class can not be instantiated
        defaultValues.put(key, null);
      } else {
        assert false : "Not defined constructor without parameters for " + cls;
      }
    }
    return res instanceof NativeCloneable ? (T) ((NativeCloneable) res).clone() : res;
  }

  private NativeType() {
    throw new AssertionError();
  }
}
