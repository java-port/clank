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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clank.support;

import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicLong;
import static org.clank.java.std.strlen;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$is_array_based;
import static org.clank.support.Native.$noClone;
import org.clank.support.Native.assignable;
import org.clank.support.NativeCallback.Object2BinaryStreamConverter;
import static org.clank.support.NativeMemory.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class Casts {

    private Casts() {}
    
    
    public static <T> T static_cast(Object o, Class<T> cls) {              
        if (o != null && cls.isAssignableFrom(o.getClass())) {
            return (T) o;
        }
        
        // From object to void$ptr
        if (!(o instanceof void$ptr) && cls == void$ptr.class) {          
            return (T) new void$ptr$impl(o);            
        }
        
        // From void$ptr$impl to anything
        if (o instanceof void$ptr$impl) {
            return (T) ((void$ptr$impl)o).value;
        }
        
        throw new UnsupportedOperationException("Static conversion from " + o.getClass() + " to " + cls + " is not implemented!");
    }

    /**
     * convert address to object pointer
     * reinterpret_cast<const char*>(addr)
     * @param <T>
     * @param cls
     * @param val
     * @return 
     */    
    public static <T> T reinterpret_cast(Class<T> cls, long/*intptr_t*/ val) {
      assert ((val & 7l) == 0l) : "Incorrect val = " + val;
      val >>= 3;
      if (val == 0) {
        return null;
      } else if (val == -1) {
        throw new AssertionError();
      }
      trackReinterpret_cast();
      synchronized (counter) {
        Reference<Object> res = longToObjectMap.get(val);
        assert(res != null && res.get() != null) : "No " + cls + " for " + val;
        return cls.cast(res.get());
      }      
    }
    
    /**
     * convert address to object pointer
     * reinterpret_cast<const char*>(addr)
     * @param <T>
     * @param cls
     * @param val
     * @return 
     */
    public static <T> T reinterpret_cast(Class<T> cls, int/*intptr_t*/ val) {
        return reinterpret_cast(cls, (long)val);
    }
    
    public static Object reinterpret_cast_Object/*intptr_t*/(Object o) {
      return o;
    }
       
    public static int $uint(byte c) {
      return (0xff & c);
    }
    /* cast signed to unsigned char */
    public static char $char(byte c) {
      return (char) (0xff & c);
    }    
    public static char $char(int c) {
      return (char) (0xff & c);
    }    
    public static char $char(char c) {
      return c;
    }    
    /* cast signed to unsigned char */
    public static char $char(long c) {
      return (char) (0xff & c);
    }    
    
    /**
     * get address of object
     * @param obj
     * @return 
     */
//    public static int/*intptr_t*/ reinterpret_cast_int/*intptr_t*/(Object obj) {
//      return (int) reinterpret_cast_long(obj);
//    }
//    public static int/*uintptr_t*/ reinterpret_cast_uint/*intptr_t*/(Object obj) {
//      return (int) reinterpret_cast_long(obj);
//    }
    public static int reinterpret_cast_int(Object o) {
      return ((Number)o).intValue();
    }
    
    public static int reinterpret_cast_uint(Object o) {
      return ((Number)o).intValue();
    }
    
    private static final AtomicLong counter = new AtomicLong(1);
    
    private final static HashMap<Long, Reference<Object>> longToObjectMap = new HashMap<>();
    
    private final static WeakHashMap<Object, Long> objTolongMap = new WeakHashMap<>();
    
   /**
    * get address of object
    *
    * @param obj
    * @return
    */    
    public static long/*uintptr_t*/ reinterpret_cast_long/*uintptr_t*/(Object obj) {
      if (obj == null) {
        return 0;
      }
      new Exception(obj.getClass().getSimpleName() + " => long").printStackTrace(System.err);      
      trackReinterpret_cast_long();
      synchronized (counter) {
        if (objTolongMap.containsKey(obj)) {
          return objTolongMap.get(obj) << 3;
        }
        long current = counter.incrementAndGet();
        objTolongMap.put(obj, current);
        longToObjectMap.put(current, new WeakReference<>(obj));
        return current << 3;
      }
    }
    
    // reinterpret_cast<T*>(Ptr);
    public static <T> type$ptr<T> reinterpret_ptr_cast(Class<T> cls, void$ptr Ptr) {   
      throw new UnsupportedOperationException();
    }
    
    // reinterpret_cast<const char*>(Object)
    public static char$ptr reinterpret_cast_const_char$ptr(Object val) {
      assert false : "no conversion to char$ptr from " + val;
      return NativePointer.create_char$ptr(val.toString());
    }
    
    // reinterpret_cast<char*>(int)
    public static char$ptr reinterpret_cast_const_char$ptr(int val) {
      trackReinterpret_cast_int_bytes();
      return NativePointer.create_char$ptr(ByteUtils.intToBytes(val));
    }

    // reinterpret_cast<const char*>(long)
    public static char$ptr reinterpret_cast_const_char$ptr(long val) {
      trackReinterpret_cast_long_bytes();
      return NativePointer.create_char$ptr(ByteUtils.longToBytes(val));
    }

    public static <T> T reinterpret_cast(Class<T> cls, Object val) {
      return (T) val;
    }
    // reinterpret_cast<Type>(Ptr)
    // PERF: if plan to remove reinterpret_cast don't forget $tryClone!
    public static <T> T reinterpret_cast(Class<T> toClass, void$ptr Ptr) {        
        if (Ptr == null) {
          return (T) null;
        }
        final Class<? extends void$ptr> fromClass = Ptr.getClass();
        if (toClass.isAssignableFrom(fromClass)) {
            return (T) (Ptr.clone());
        }
        
        if (Ptr instanceof void$ptr$impl) {
            return toClass.cast(((void$ptr$impl) Ptr).value);
//            throw new UnsupportedOperationException("Cannot cast fake pointer " + Ptr.getClass());
        }
        
        MemoryPoint data = unfoldMemoryPoint(extractMemoryPoint(Ptr));
        boolean uCharMem = false;
        if (data.memory instanceof char$memory || (uCharMem = (data.memory instanceof uchar$mem))) {
            char$memory byteMemory;
            if (uCharMem) {
                byteMemory = new char$mem(((uchar$mem)data.memory).$array());
            } else {
                byteMemory = (char$memory)data.memory;
            }
            int byteIndex = data.byteIndex;
            if (char$ptr.class == toClass) {
                return (T) new char$ptr$heavy(byteMemory, byteIndex);
            } else if (uchar$ptr.class == toClass) {
              uchar$mem ucharMemory = new uchar$mem(((char$mem)byteMemory).$array());
              return (T) new uchar$ptr$heavy(ucharMemory, byteIndex);
            } else  if (ushort$ptr.class == toClass) {
                ushort$memproj<char$memory> ushortMemory = new ushort$uchar$memproj(byteMemory, byteIndex % NativeType.BYTES_IN_INT);
                int intIndex = ushortMemory.fromByteIndex(byteIndex - ushortMemory.getByteShift());

                return (T)new ushort$ptr$heavy(ushortMemory, intIndex);
            } else  if (int$ptr.class == toClass) {
                int$memproj<char$memory> intMemory = new uint$uchar$memproj(byteMemory, byteIndex % NativeType.BYTES_IN_INT);
                int intIndex = intMemory.fromByteIndex(byteIndex - intMemory.getByteShift());

                return (T)new int$ptr$heavy(intMemory, intIndex);
            } else  if (uint$ptr.class == toClass) {
                uint$memproj<char$memory> uintMemory = new uint$uchar$memproj(byteMemory, byteIndex % NativeType.BYTES_IN_UINT);
                int intIndex = uintMemory.fromByteIndex(byteIndex - uintMemory.getByteShift());

                return (T)new uint$ptr$heavy(uintMemory, intIndex);
            } else  if (long$ptr.class == toClass) {
                long$memproj<char$memory> longMemory = new ulong$uchar$memproj(byteMemory, byteIndex % NativeType.BYTES_IN_LONG);
                int longIndex = longMemory.fromByteIndex(byteIndex - longMemory.getByteShift());

                return (T)new long$ptr$heavy(longMemory, longIndex);
            } else  if (ulong$ptr.class == toClass) {
                ulong$memproj<char$memory> ulongMemory = new ulong$uchar$memproj(byteMemory, byteIndex % NativeType.BYTES_IN_ULONG);
                int ulongIndex = ulongMemory.fromByteIndex(byteIndex - ulongMemory.getByteShift());

                return (T)new ulong$ptr$heavy(ulongMemory, ulongIndex);
            }
        } else if (data.memory instanceof uint$memory) {
          uint$memory uintMemory = (uint$memory)data.memory;
          int byteIndex = data.byteIndex;
          if (uint$ptr.class == toClass) {
            return (T) new uint$ptr$heavy(uintMemory, byteIndex);
          } else if (uchar$ptr.class == toClass) {
            uchar$memproj<uint$memory> ucharMemory = new uchar$uint$memproj(uintMemory);
            int charIndex = ucharMemory.fromByteIndex(byteIndex - ucharMemory.getByteShift());
            
            return (T) new uchar$ptr$heavy(ucharMemory, charIndex);
          } else if (char$ptr.class == toClass) {
            char$memproj<uint$memory> ucharMemory = new uchar$uint$memproj(uintMemory);
            int charIndex = ucharMemory.fromByteIndex(byteIndex - ucharMemory.getByteShift());
            
            return (T) new char$ptr$heavy(ucharMemory, charIndex);
          }
        } else if (data.memory instanceof ulong$memory) {
          ulong$memory ulongMemory = (ulong$memory)data.memory;
          int byteIndex = data.byteIndex;
          if (uchar$ptr.class == toClass) {
            uchar$memproj<ulong$memory> ucharMemory = new uchar$ulong$memproj(ulongMemory);
            int charIndex = ucharMemory.fromByteIndex(byteIndex - ucharMemory.getByteShift());
            
            return (T) new uchar$ptr$heavy(ucharMemory, charIndex);
          } else if (char$ptr.class == toClass) {
            char$memproj<ulong$memory> ucharMemory = new uchar$ulong$memproj(ulongMemory);
            int charIndex = ucharMemory.fromByteIndex(byteIndex - ucharMemory.getByteShift());
            
            return (T) new char$ptr$heavy(ucharMemory, charIndex);
          }
        }
        
        throw new UnsupportedOperationException("Reinterpret conversion from " + fromClass + " to " + toClass + " is not implemented!");
    }
    
    /**
     * This method allows to represent stream of original objects (not pointers!) of type T as byte-stream
     * where each T-object is transformed into sizeof(T) bytes using input converter.
     * @param <Iter> type of iterator
     * @param <T> type of input 
     * @param toClass must be char$ptr.class
     * @param orig stream of T-objects
     * @param sizeof$T sizeof(T) - size in bytes of a single T
     * @param conv converter from T to it's sizeof(T) bytes representation
     * @return stream of Ts converted to bytes
     */
    public static <Iter extends type$iterator<Iter, T>, T> char$ptr reinterpret_cast(Class<char$ptr> toClass, Iter orig, int sizeof$T, NativeCallback.Object2BinaryStreamConverter<T> conv) {
      assert toClass == char$ptr.class;
      assert sizeof$T > 0;
      assert orig != null;    
      class ConverterFromObjectToSizeOfTBytesStream<Iter extends type$iterator<Iter, T>, T> implements char$ptr, DebuggableAbstractPointerType<ConverterFromObjectToSizeOfTBytesStream<Iter, T>> {
        private final Iter delegate;
        private final int sizeof$T;
        private final Object2BinaryStreamConverter<T> conv;
        // TODO: flags below can be put into index field if needed
        int $index_in_object;
        T $star;
        ConverterFromObjectToSizeOfTBytesStream(Iter delegate, int sizeof$T, Object2BinaryStreamConverter<T> conv) {
          // JAVA: we don't clone, because in native original one was supposed to be used
          // and we here just wrap it
          this.delegate = $noClone(delegate);
          this.sizeof$T = sizeof$T;
          this.conv = conv;
          this.$index_in_object = 0;
          this.$star = null;
        }
        ConverterFromObjectToSizeOfTBytesStream(ConverterFromObjectToSizeOfTBytesStream<Iter, T> $Prm0) {
          this.delegate = $Clone($Prm0.delegate);
          this.sizeof$T = $Prm0.sizeof$T;
          this.conv = $Prm0.conv;
          this.$index_in_object = $Prm0.$index_in_object;
          this.$star = $Prm0.$star;
        }

        @Override
        public ConverterFromObjectToSizeOfTBytesStream<Iter, T> clone() {
          return new ConverterFromObjectToSizeOfTBytesStream(this);
        }

        @Override
        public ConverterFromObjectToSizeOfTBytesStream const_clone() {
          return clone().$toConstPtr();
        }

        @Override
        public char$ptr $assign(char$ptr $Prm0) {
          return $assign((ConverterFromObjectToSizeOfTBytesStream)$Prm0);
        }
        public char$ptr $assign(ConverterFromObjectToSizeOfTBytesStream<Iter, T> $Prm0) {
          assert (this.sizeof$T == $Prm0.sizeof$T);
          assert (this.conv == $Prm0.conv);        
          ((assignable<Iter>)this.delegate).$assign($Prm0.delegate);
          this.$index_in_object = $Prm0.$index_in_object;
          this.$star = $Prm0.$star;
          return this;
        }

        @Override
        public char$ptr $preInc() {
          $index_in_object++;
          advanceIfNeeded();
          return this;
        }

        @Override
        public char$ptr $postInc() {
          char$ptr out = $Clone(this);
          this.$preInc();
          return out;
        }

        @Override
        public boolean $eq(Object other) {
          return $eq((ConverterFromObjectToSizeOfTBytesStream<Iter, T>)other);
        }     
        public boolean $eq(ConverterFromObjectToSizeOfTBytesStream<Iter, T> RHS) {
          assert (this.sizeof$T == RHS.sizeof$T);
          assert (this.conv == RHS.conv);
          return (this.$index_in_object == RHS.$index_in_object)
                  && Native.$eq_iter(this.delegate, RHS.delegate);
        }     

        @Override
        public /*char*/byte $star() {
          queryDelegateIfNeeded();
          return conv.char$at($index_in_object, $star);
        }

        private void advanceIfNeeded() {
          assert !_isConstPtr() : "Can not modify const iterator ";
          assert $index_in_object >= 0;
          assert $index_in_object <= sizeof$T;        
          if (this.$index_in_object == sizeof$T) {
            delegate.$preInc();
            this.$star = null;
            this.$index_in_object = 0;
          }
        }

        private void queryDelegateIfNeeded() {
          assert $index_in_object >= 0;
          assert $index_in_object < sizeof$T;        
          if (this.$star == null) {
            assert this.$index_in_object == 0;
            this.$star = delegate.$star();
            assert this.$star != null : "how can streamed object be null?" + delegate;
          }
        }

        ///////////////////////////////////////////////////////////////////////////
        // Not yet implemented section

        @Override      
        public int $index() {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte[] $array() {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set(byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $at(int index) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$andassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$xorassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$orassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$addassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$minusassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$starassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$slashassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$modassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$lshiftassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$rshiftassign(int index, byte value) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$postInc(int index) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$postDec(int index) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$preInc(int index) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public byte $set$preDec(int index) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public type$ptr<char$ptr> $addr() {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public type$memory<char$ptr> getSelfMemory() {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int getSelfIndex() {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean $isNull() {
          return false;
        }

        @Override
        public boolean $noteq(Object p) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isComparableTo(void$ptr other) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean $greater(Object obj) {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override      
        public int $hashcode() {
          throw new UnsupportedOperationException("Not supported yet.");
        }

        ///////////////////////////////////////////////////////////////////////////
        // FOR DEBUG PURPOSES

        private byte _flags; // MAY BE MOVE INTO index field?

        public/*debug-only*/ final boolean _isConstPtr() {
          return (_flags & CONST_PTR) != 0;
        }

        public/*debug-only*/ ConverterFromObjectToSizeOfTBytesStream<Iter, T> $toConstPtr() {
          _flags |= CONST_PTR;
          return this;
        }

        public/*debug-only*/ ConverterFromObjectToSizeOfTBytesStream<Iter, T> $cleanConstPtr() {
          assert _isConstPtr() : "only marked as const can be cleared; may be you are doing something not completely investigated?";
          $cleanConstPtrWithoutAssert();
          return this;
        }

        public/*debug-only*/ final void $cleanConstPtrWithoutAssert() {
          _flags &= ~CONST_PTR;
        }

        public/*debug-only*/ final boolean _isConstContent() {
          return (_flags & CONST_CONTENT) != 0;
        }

        public/*debug-only*/ ConverterFromObjectToSizeOfTBytesStream<Iter, T> $toConstContent() {
          _flags |= CONST_CONTENT;
          return this;
        }

        public/*debug-only*/ ConverterFromObjectToSizeOfTBytesStream<Iter, T> $cleanConstContent() {
          assert _isConstContent(): "only marked as const can be cleared; may be you are doing something not completely investigated?";
          $cleanConstContentWithoutAssert();
          return this;
        }  

        public/*debug-only*/ final void $cleanConstContentWithoutAssert() {
          _flags &= ~CONST_CONTENT;
        }      

        @Override
        public String toString() {
          return (this.$star == null ? " NOT YET QUERIED [" : "[") + this.$index_in_object + "]-byte of [" + this.delegate + "]";
        }
      }
      return new ConverterFromObjectToSizeOfTBytesStream(orig, sizeof$T, conv);
    }

//    // dyn_cast<Type>(Ptr)
//    public static <T> T dyn_cast(Class<T> cls, Object o) {
//        if (cls.isInstance(o)) {
//            return cls.cast(o);
//        }
//        return null;
//    }
//
//    // dyn_cast_or_null<Type>(Ptr)
//    public static <T> T dyn_cast_or_null(Class<T> cls, Object o) {
//        if (cls.isInstance(o)) {
//            return cls.cast(o);
//        }
//        return null;
//    }
    
    // dynamic_cast<Type>(Ptr)
    public static <T> T dynamic_cast(Class<T> cls, Object o) {
        if (cls.isInstance(o)) {
            return cls.cast(o);
        }
        return null;
    }
    
    // const_cast<Type>(Ptr)
    public static <T> T const_cast(Object o) {
        return (T)o;
    }       
    
    public static String toJavaString(char$ptr str) {
        return toCharSequence(str).toString();
    }
    public static String toJavaString(char$ptr str, int Len) {
        return toCharSequence(str, Len).toString();
    }
    public static String toJavaString(byte[] bytes, int start, int len) {
        return toCharSequence(bytes, start, len).toString();
    }

    public static CharSequence toCharSequence(byte[] bytes, int start, int len) {
      return toCharSequenceImpl(null, bytes, start, len);
    }

    public static void toStringBuilder(StringBuilder buf, byte[] bytes, int start, int len) {
      assert buf != null;
      toCharSequenceImpl(buf, bytes, start, len);
    }
    
    public static CharSequence toCharSequence(char$ptr str) {
      return toCharSequence(str, -1);
    }
    
    public static CharSequence toCharSequence(char$ptr str, int len) {
      if ($is_array_based(str)) {
        return toCharSequenceImpl((StringBuilder)null, str.$array(), str.$index(), len);
      } else if (str instanceof char$ptr$CharSequence) {
        return toCharSequenceImpl((StringBuilder) null, ((char$ptr$CharSequence)str).getCharSequence(), str.$index(), len);
      }
      StringBuilder buf = new StringBuilder(16);
      return toCharSequenceNonArrayBasedAsciiPtr(buf, str, len);
    }
    
    public static void toStringBuilder(StringBuilder buf, char$ptr str) {
      assert buf != null;
      toStringBuilderImpl(buf, str, -1);
    }
    
    public static void toStringBuilder(StringBuilder buf, char$ptr str, int len) {
      assert buf != null;
      toStringBuilderImpl(buf, str, len);
    }
    
    private static void toStringBuilderImpl(StringBuilder buf, char$ptr str, int len) {
      if ($is_array_based(str)) {
        toCharSequenceImpl(buf, str.$array(), str.$index(), len);
        return;
      } else if (str instanceof char$ptr$CharSequence) {
        toCharSequenceImpl(buf, ((char$ptr$CharSequence)str).getCharSequence(), str.$index(), len);
        return;
      }
      toCharSequenceNonArrayBasedAsciiPtr(buf, str, len);
    }
    
    private static CharSequence toCharSequenceImpl(StringBuilder buf, CharSequence text, int start, int len) {
        final int textLen = text.length();
        len = (len < 0) ? (textLen - start) : len;
        final CharSequence out = (start == 0 && len == textLen) ? text : text.subSequence(start, start + len);
        if (buf == null) {
          return out;
        } else {
          buf.append(out);
          return buf;
        }      
    }
    
    private static CharSequence toCharSequenceImpl(StringBuilder buf, byte[] bytes, int start, int len) {
        // TODO: this is ineffective when len is not specified - we scan it for zero in strlen, 
        // it would be much better if we scanned it for zero in UTF_8.decode
        try {
            len = (len < 0) ? strlen(bytes, start) : len;
            CharSequence out = UTF_8.decode(bytes, start, len);
            if (buf != null) {
                buf.append(out);
                return buf;
            } else {
                return out;
            }
        } catch (Exception e) {
            // storage is already destroyed, see comment in the callee
            if (buf == null) {
                // prepare fallback buffer
                buf = new StringBuilder(16);
            }
            return toCharSequenceNonArrayBasedAsciiPtr(buf, create_char$ptr(bytes, start), len);
        }
    }

    private static StringBuilder toCharSequenceNonArrayBasedAsciiPtr(StringBuilder buf, char$ptr str, int len) {
        assert buf != null;
        if (str == null) {
          buf.append("<null>");
          return buf;
        }
        int idx = 0;
        if (len < 0) {
          try {
            char c;
            while ((c = $char(str.$at(idx++))) != 0) {
              buf.append(c);
            }
          } catch (Exception e) {
            // when destroyed object is hovered by mouse in debugger session, we
            // don't want exceptions in tooltip

            // The over cases is: Logging is posted into separate thread which is flushed when underlying 
            // storage is already destroyed
            buf.replace(buf.length()-idx+1, buf.length(), "###Corrupted IDX="+str.$index()+"###");
          }
        } else {
          while (len-- > 0) {
            buf.append($char(str.$at(idx++)));
          }          
        }
        return buf;
    }   

    private static final class void$ptr$impl implements void$ptr, NativeCloneable<void$ptr> {
        
        private Object value;
        
        public void$ptr$impl() {}

        public void$ptr$impl(Object value) {
            this.value = value;
        }
        
        public void $assign(Object value) {
            this.value = value;
        }
        
        @Override
        public boolean $isNull() {
            return false;
        }  

        @Override
        public boolean $eq(Object p) {
            return (p instanceof void$ptr$impl) && ((void$ptr$impl)p).value == value;
        }
        
        @Override
        public boolean isComparableTo(void$ptr other) {
            throw new UnsupportedOperationException("Not supported.");
        }        

        @Override
        public boolean $less(Object obj) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public boolean $lesseq(Object obj) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public boolean $greater(Object obj) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public boolean $greatereq(Object obj) {
            throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public boolean $noteq(Object p) {
            return !$eq(p);
        }

        @Override
        public void$ptr clone() {
            try {
                return (void$ptr) super.clone();
            } catch (CloneNotSupportedException ex) {
                throw new AssertionError("Clone is not supported!"); //NOI18N
            }
        }

        @Override
        public int $hashcode() {
            return System.identityHashCode(value);
        }

        @Override
        public String toString() {
          return "void$ptr{" + value + '}';
        }
                
    }    
    
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long callReinterpret_cast = 0;
    private static long callReinterpret_cast_long = 0;
    private static long callReinterpret_cast_long_bytes = 0;
    private static long callReinterpret_cast_int_bytes = 0;
    private static void trackReinterpret_cast_long() {
      callReinterpret_cast_long++;
    }
    private static void trackReinterpret_cast_long_bytes() {
      callReinterpret_cast_long_bytes++;
    }
    private static void trackReinterpret_cast_int_bytes() {
      callReinterpret_cast_int_bytes++;
    }

    private static void trackReinterpret_cast() {
      callReinterpret_cast++;
    }

    public static void clearStatistics() {
      callReinterpret_cast = 0;
      callReinterpret_cast_long = 0;
      callReinterpret_cast_long_bytes = 0;
      callReinterpret_cast_int_bytes = 0;
    }

    public static long printStatistics(PrintWriter out) {
      out.printf("%22s  called:\t%s.%n", "Cast [Object->long]", NativeTrace.formatNumber(callReinterpret_cast_long));
      out.printf("%22s  called:\t%s.%n", "Cast [long->Object]", NativeTrace.formatNumber(callReinterpret_cast));
      out.printf("%22s  called:\t%s.%n", "Cast [long->byte[]]", NativeTrace.formatNumber(callReinterpret_cast_long_bytes));
      out.printf("%22s  called:\t%s.%n", "Cast [int->byte[]]", NativeTrace.formatNumber(callReinterpret_cast_int_bytes));
      long Value = callReinterpret_cast_long + callReinterpret_cast + callReinterpret_cast_long_bytes + callReinterpret_cast_int_bytes;
      NativeTrace.dumpStatisticValue(out, "TotalLibStdCastsValue", Value);
      return Value;
    }    
}
