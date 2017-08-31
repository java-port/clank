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

import org.clank.support.Native.assignable;
import static org.clank.support.NativeType.*;
import org.clank.support.aliases.*;
import java.lang.reflect.Field;
import static org.clank.support.Unsigned.*;
import sun.misc.Unsafe;

/**
 *
 * @author petrk
 */
public class NativeMemory {
  private static final int NATIVE_PAGE_SIZE;
  private static final int FALLBACK_PAGE_SIZE = 1024*4;// 4K
  static {
    int pageSize; 
    try {
      Field f = Unsafe.class.getDeclaredField("theUnsafe"); // NOI18N
      f.setAccessible(true);
      Unsafe unsafe = (Unsafe)f.get(null);
      pageSize = unsafe.pageSize();
      if (NativeTrace.VERBOSE_MODE) {
        System.err.printf("Native Page Size is %d%n", pageSize); // NOI18N
      }
    } catch (Throwable ex) {
      // don't have unsafe
      pageSize = FALLBACK_PAGE_SIZE;
      if (NativeTrace.VERBOSE_MODE) {
        System.err.printf("No Unsafe, Use Native Page Size as %d%n", pageSize); // NOI18N
      }
    }
    NATIVE_PAGE_SIZE = pageSize;
  }
    
    /*
    ****************************************************************************
    *   Interfaces
    ****************************************************************************
    */          
  
    public static interface Allocator {
        public static final int MaxPageSize = Integer.getInteger("clank.max.page.size", 1 << 16); // 256K
        public static final int PageSize = Integer.getInteger("clank.page.size",  Math.min(MaxPageSize, NATIVE_PAGE_SIZE));
        
        default void Reset()  {
          throw new UnsupportedOperationException();
        }

        // TODO: think about Object as return type
        default char$ptr Allocate(/*size_t*/int Size, /*size_t*/int Alignment) {
          throw new UnsupportedOperationException();
        }

        // TODO: think about Object as return type
        default char$ptr Allocate(/*size_t*/int Size)  {
          return Allocate(Size, 1);
        }

        default char$ptr Allocate$Chars(/*size_t*/int Size)  {
          return Allocate$Chars(Size, 1);
        }

        default char$ptr Allocate$Chars(/*size_t*/int Size, /*uint*/int Align/*= 1*/) /*const*/ {
          return Allocate(Size, Align);
        }

        default char$ptr AllocateSlab(/*size_t*/int Size) {
          throw new UnsupportedOperationException();
        }

        // TODO: think about Object as return type
        default <T> void$ptr Allocate(Class<T> cls, /*size_t*/int Num)  {
          throw new UnsupportedOperationException();
        }

        default void Deallocate(Object Ptr)  {
          throw new UnsupportedOperationException();
        }
        
        default void Deallocate$NotSameRemoveCV(Object Ptr)  {
          throw new UnsupportedOperationException();
        }
        
        default void DeallocateSlab(char$ptr SlabStartPtr, /*size_t*/int Size)  {
          throw new UnsupportedOperationException();
        }

        default void PrintStats() {
          throw new UnsupportedOperationException();
        }
        
        default <T> T $RegisterCreated(T obj) {
          return obj;
        }
        
        default /*size_t*/long getTotalMemory()  {
          throw new UnsupportedOperationException();
        }
    }  
    
    public static interface BumpAllocator extends Allocator {
        int AllocateAndGetIndex(/*size_t*/int Size, /*size_t*/int Alignment);

        int AllocateAndGetIndex(/*size_t*/int Size);

        byte[] GetLastAllocationStorage();
    }
    
    // Base interface for all kinds of memory
    public static interface memory {
        /**
         * size of element in bytes
         * @return sizeof(T)
         */
        int sizeof();

        /**
         * @return size of memory in elements
         */
        int size();     

        /**
         * Translates real index to byte index (byte number from the beginning of memory)
         * 
         * @param index
         * @return byte index
         */
        int toByteIndex(int index);

        /**
         * Translates byte index to real index
         * 
         * @param index
         * @return projection index
         */        
        int fromByteIndex(int index);

        default boolean $eq(memory other) {
          if (this == other) {
            return true;
          }
          throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
        }
        default boolean $noteq(memory other) {
          return !$eq(other);
        }
    }           
    
    // Base interface for all kinds of memory projections
    public static interface memproj<M extends memory> extends memory {
        
        /**
         * Gets memory on which this projection is based
         * 
         * @return original memory
         */
        M getOrigMemory();
        
        /**
         * Gets shift from the beginning of original memory.
         * 
         * (= byte index of start of this memory in original memory)
         * 
         * @return shift from start of original memory.
         */
        int getByteShift();
           
    }    
    
    /*
    ****************************************************************************
    *   Implementations of different kinds of memory
    ****************************************************************************
    */
    
    public static final class type$mem<T> implements type$memory<T> {
        
        private final T[] array;

        public type$mem(T value) {
            array = (T[]) new Object[1];
            array[0] = value;
        }

        public type$mem(T[] array) {
            this.array = array;
        }

        @Override
        public T $set(int idx, T value) {
            int index = (int)idx;
            T old = array[(int)index];
            if (array[(int)index] == null) {
              array[(int)index] = (value instanceof NativeCloneable ? ((NativeCloneable<T>) value).clone() : value);
            } else if (array[(int)index] instanceof assignable) {
                assignable<T> obj = (assignable<T>) array[(int)index];
                obj.$assign(value);
            } else {
                throw new UnsupportedOperationException(value.getClass() + " must implement " + assignable.class);
            }
            return old;
        }

        @Override
        public T $at(int index) {
            return array[(int)index];
        }

        @Override
        public int sizeof() {
          // TODO: sizeof(T)
          return 1;
        }

        @Override
        public int size() {
            return array.length;
        }

        @Override
        public int toByteIndex(int index) {
            return index*sizeof();
        }

        @Override
        public int fromByteIndex(int index) {
            return index/sizeof();
        }

    @Override
    public T $set$addassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$minusassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$andassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$xorassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$orassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$starassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$slashassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$modassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$lshiftassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$rshiftassign(int index, T value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$postInc(int index) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$postDec(int index) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$preInc(int index) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T $set$preDec(int index) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
    /*
    ****************************************************************************
    *   Implementations of different kinds of memory projections
    ****************************************************************************
    */
    
    // used for both: ushort
    public static final class ushort$uchar$memproj implements /*short$memproj<char$memory>, */ushort$memproj<char$memory> {

      private final char$memory origMemory;

      private final int shift;

      private final int size;

      public ushort$uchar$memproj(char$memory origMemory, /*uint*/ int shift) {
        this.origMemory = origMemory;
        this.shift = (int) shift;
        this.size = (origMemory.size() - (int) shift) / NativeType.BYTES_IN_USHORT;
      }

      @Override
      public char$memory getOrigMemory() {
        return origMemory;
      }

      @Override
      public int getByteShift() {
        return shift;
      }

      @Override
      public char $at(int index) {
        int origIndex = index * BYTES_IN_USHORT + shift;
        int b2 = 0xFF & origMemory.$at(origIndex);
        int b1 = 0xFF & origMemory.$at(origIndex + 1);
        return $uint2ushort((b1 << 8) + b2);
      }

      @Override
      public char $set(int index, char value) {
        int origIndex = index * BYTES_IN_USHORT + shift;
        int b4 = 0xFF & origMemory.$set(origIndex, (byte) (value & 0xff));
        int b3 = 0xFF & origMemory.$set(origIndex + 1, (byte) ((value >>> 8) & 0xff));
        int b2 = 0xFF & origMemory.$set(origIndex + 2, (byte) ((value >>> 16) & 0xff));
        int b1 = 0xFF & origMemory.$set(origIndex + 3, (byte) ((value >>> 24) & 0xff));
        return $uint2ushort((b1 << 8) + b2);
      }

      @Override
      public int sizeof() {
        return BYTES_IN_USHORT;
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public int toByteIndex(int index) {
        return index * BYTES_IN_USHORT;
      }

      @Override
      public int fromByteIndex(int index) {
        return index / BYTES_IN_USHORT;
      }

      @Override
      public char $set$addassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$minusassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$andassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$xorassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$orassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$starassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$slashassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$modassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$lshiftassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$rshiftassign(int index, char value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public char $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    }    
    
    // used for both: int and uint
    public static final class uint$uchar$memproj implements int$memproj<char$memory>, uint$memproj<char$memory> { // Little endian

      private final char$memory origMemory;

      private final int shift;

      private final int size;

      public uint$uchar$memproj(char$memory origMemory, /*uint*/ int shift) {
        this.origMemory = origMemory;
        this.shift = (int) shift;
        this.size = (origMemory.size() - (int) shift) / NativeType.BYTES_IN_INT;
      }

      @Override
      public char$memory getOrigMemory() {
        return origMemory;
      }

      @Override
      public int getByteShift() {
        return shift;
      }

      @Override
      public int $at(int index) {
        int origIndex = index * BYTES_IN_INT + shift;
        int b4 = 0xFF & origMemory.$at(origIndex);
        int b3 = 0xFF & origMemory.$at(origIndex + 1);
        int b2 = 0xFF & origMemory.$at(origIndex + 2);
        int b1 = 0xFF & origMemory.$at(origIndex + 3);
        return (b1 << 24) + (b2 << 16) + (b3 << 8) + (b4);
      }

      @Override
      public int $set(int index, int value) {
        int origIndex = index * BYTES_IN_INT + shift;
        int b4 = 0xFF & origMemory.$set(origIndex, (byte) (value & 0xff));
        int b3 = 0xFF & origMemory.$set(origIndex + 1, (byte) ((value >>> 8) & 0xff));
        int b2 = 0xFF & origMemory.$set(origIndex + 2, (byte) ((value >>> 16) & 0xff));
        int b1 = 0xFF & origMemory.$set(origIndex + 3, (byte) ((value >>> 24) & 0xff));
        return (b1 << 24) + (b2 << 16) + (b3 << 8) + (b4);
      }

      @Override
      public int sizeof() {
        return BYTES_IN_INT;
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public int toByteIndex(int index) {
        return index * BYTES_IN_INT;
      }

      @Override
      public int fromByteIndex(int index) {
        return index / BYTES_IN_INT;
      }

      @Override
      public int $set$addassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$minusassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$andassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$xorassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$orassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$starassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$slashassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$modassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$lshiftassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$rshiftassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    }    
    
    // used for both: int and uint
    public static final class ulong$uchar$memproj implements long$memproj<char$memory>, ulong$memproj<char$memory> { // Little endian

      private final char$memory origMemory;

      private final int shift;

      private final int size;

      public ulong$uchar$memproj(char$memory origMemory, /*uint*/ int shift) {
        this.origMemory = origMemory;
        this.shift = (int) shift;
        this.size = (origMemory.size() - (int) shift) / NativeType.BYTES_IN_LONG;
      }

      @Override
      public char$memory getOrigMemory() {
        return origMemory;
      }

      @Override
      public int getByteShift() {
        return shift;
      }

      @Override
      public long $at(int index) {
        int origIndex = index * BYTES_IN_LONG + shift;
        long b8 = 0xFF & origMemory.$at(origIndex);
        long b7 = 0xFF & origMemory.$at(origIndex + 1);
        long b6 = 0xFF & origMemory.$at(origIndex + 2);
        long b5 = 0xFF & origMemory.$at(origIndex + 3);
        long b4 = 0xFF & origMemory.$at(origIndex + 4);
        long b3 = 0xFF & origMemory.$at(origIndex + 5);
        long b2 = 0xFF & origMemory.$at(origIndex + 6);
        long b1 = 0xFF & origMemory.$at(origIndex + 7);
        return (b1 << 54) | (b2 << 48) | (b3 << 40) | (b4 << 32) | (b5 << 24) | (b6 << 16) | (b7 << 8) | (b8);
      }

      @Override
      public long $set(int index, long value) {
        int origIndex = index * BYTES_IN_LONG + shift;
        long b8 = 0xFF & origMemory.$set(origIndex, (byte) (value & 0xff));
        long b7 = 0xFF & origMemory.$set(origIndex + 1, (byte) ((value >>> 8) & 0xff));
        long b6 = 0xFF & origMemory.$set(origIndex + 2, (byte) ((value >>> 16) & 0xff));
        long b5 = 0xFF & origMemory.$set(origIndex + 3, (byte) ((value >>> 24) & 0xff));
        long b4 = 0xFF & origMemory.$set(origIndex + 4, (byte) ((value >>> 32) & 0xff));
        long b3 = 0xFF & origMemory.$set(origIndex + 5, (byte) ((value >>> 40) & 0xff));
        long b2 = 0xFF & origMemory.$set(origIndex + 6, (byte) ((value >>> 48) & 0xff));
        long b1 = 0xFF & origMemory.$set(origIndex + 7, (byte) ((value >>> 54) & 0xff));
        return (b1 << 54) | (b2 << 48) | (b3 << 40) | (b4 << 32) | (b5 << 24) | (b6 << 16) | (b7 << 8) | (b8);
      }

      @Override
      public int sizeof() {
        return BYTES_IN_LONG;
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public int toByteIndex(int index) {
        return index * BYTES_IN_LONG;
      }

      @Override
      public int fromByteIndex(int index) {
        return index / BYTES_IN_LONG;
      }
      
      @Override
      public long $set$addassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$minusassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$andassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$xorassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$orassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$starassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$slashassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$modassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$lshiftassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$rshiftassign(int index, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public long $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }      
    }    
    
    // used for both: char and uchar
    public static final class uchar$uint$memproj implements char$memproj<uint$memory>, uchar$memproj<uint$memory> { // Little endian

      private final uint$memory origMemory;

      private final int size;

      public uchar$uint$memproj(uint$memory origMemory) {
        this.origMemory = origMemory;
        this.size = origMemory.size() * origMemory.sizeof();
      }

      @Override
      public uint$memory getOrigMemory() {
        return origMemory;
      }

      @Override
      public int getByteShift() {
        return 0;
      }

      @Override
      public byte $at(int index) {
        int origIndex = index / NativeType.BYTES_IN_UINT;
        int origShift = index % NativeType.BYTES_IN_UINT;
        return (byte) ((origMemory.$at(origIndex) & (0xff << (8 * origShift)))
                >>> (8 * origShift));
      }

      @Override
      public byte $set(int index, byte value) {
        int origIndex = index / NativeType.BYTES_IN_UINT;
        int origShift = index % NativeType.BYTES_IN_UINT;
        int newValue = (origMemory.$at(origIndex) & (~(0xff << (8 * origShift)))) 
                | (Unsigned.$uchar2uint(value) << (8 * origShift));
        origMemory.$set(origIndex, newValue);
        return value;
      }

      @Override
      public int sizeof() {
        return NativeType.BYTES_IN_BYTE;
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public int toByteIndex(int index) {
        return index;
      }

      @Override
      public int fromByteIndex(int index) {
        return index;
      }

      @Override
      public byte $set$addassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$minusassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$andassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$xorassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$orassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$starassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$slashassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$modassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$lshiftassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$rshiftassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    }
    
    // used for both: char and uchar
    public static final class uchar$ulong$memproj implements char$memproj<ulong$memory>, uchar$memproj<ulong$memory> { // Little endian

      private final ulong$memory origMemory;

      private final int size;

      public uchar$ulong$memproj(ulong$memory origMemory) {
        this.origMemory = origMemory;
        this.size = origMemory.size() * origMemory.sizeof();
      }

      @Override
      public ulong$memory getOrigMemory() {
        return origMemory;
      }

      @Override
      public int getByteShift() {
        return 0;
      }

      @Override
      public byte $at(int index) {
        int origIndex = index / NativeType.BYTES_IN_ULONG;
        int origShift = index % NativeType.BYTES_IN_ULONG;
        return (byte) ((origMemory.$at(origIndex) & (0xffL << (8 * origShift)))
                >>> (8 * origShift));
      }

      @Override
      public byte $set(int index, byte value) {
        int origIndex = index / NativeType.BYTES_IN_ULONG;
        int origShift = index % NativeType.BYTES_IN_ULONG;
        long newValue = (origMemory.$at(origIndex) & (~(0xffL << (8 * origShift)))) 
                | (Unsigned.$uchar2ulong(value) << (8 * origShift));
        origMemory.$set(origIndex, newValue);
        return value;
      }

      @Override
      public int sizeof() {
        return NativeType.BYTES_IN_BYTE;
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public int toByteIndex(int index) {
        return index;
      }

      @Override
      public int fromByteIndex(int index) {
        return index;
      }

      @Override
      public byte $set$addassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$minusassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$andassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$xorassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$orassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$starassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$slashassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$modassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$lshiftassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$rshiftassign(int index, byte value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public byte $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
    }
    
    /*
    ****************************************************************************
    *   Helpers
    ****************************************************************************
    */         
    
    static final class MemoryPoint {
        
        public memory memory;
        
        public int byteIndex;

        public MemoryPoint() {}

        public MemoryPoint(memory first, int byteIndex) {
            this.memory = first;
            this.byteIndex = byteIndex;
        }
    }   
    
    static MemoryPoint unfoldMemoryPoint(MemoryPoint data) {
        MemoryPoint result = new MemoryPoint(data.memory, data.byteIndex);
        while (result.memory instanceof memproj) {
            result.byteIndex += ((memproj)result.memory).getByteShift();
            result.memory = ((memproj)result.memory).getOrigMemory();
        }
        return result;
    }       
    
    static boolean areMemoryPointsComparable(MemoryPoint p1, MemoryPoint p2) {
        if (p1.memory.$noteq(p2.memory)) {
            p1 = unfoldMemoryPoint(p1);
            p2 = unfoldMemoryPoint(p2);
        }
        return p1.memory.$eq(p2.memory);
    }
    
    static int compareMemoryPoints(MemoryPoint p1, MemoryPoint p2) {
        if (p1.memory != p2.memory) {
            p1 = unfoldMemoryPoint(p1);
            p2 = unfoldMemoryPoint(p2);
        }
        
        if (p1.memory.$eq(p2.memory)) {
            return (int)(p1.byteIndex - p2.byteIndex);
        }
        
        throw new UnsupportedOperationException("Incomparable memory points!");
    }
    
    static long calcMemoryPointHashCode(MemoryPoint mp) {
        mp = unfoldMemoryPoint(mp);
        return ((long) System.identityHashCode(mp.memory)) ^ mp.byteIndex;
    }
    
    static int getMemoryPointsDistance(MemoryPoint p1, MemoryPoint p2) {
      int distBytes = compareMemoryPoints(p1, p2);
      return distBytes / Math.max(p1.memory.sizeof(), p2.memory.sizeof());
    }    
    
    static boolean areEqualMemoryPoints(MemoryPoint p1, MemoryPoint p2) {
        if (p1.memory != p2.memory) {
            p1 = unfoldMemoryPoint(p1);
            p2 = unfoldMemoryPoint(p2);
        }
        if (p1.memory.$noteq(p2.memory)) {
            return false;
        }
        return compareMemoryPoints(p1, p2) == 0;
    }    
    
    
    private NativeMemory() {
        throw new AssertionError();
    }
}
