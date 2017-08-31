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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.clank.java.std;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$noClone;
import org.clank.support.NativeCallback.Converter;
import static org.clank.support.Unsigned.$long2ulong;
import static org.clank.support.Unsigned.$uchar2ulong;
import static org.clank.support.Unsigned.$uint2ulong;
import static org.clank.support.Unsigned.$ulong2uchar;
import static org.clank.support.Unsigned.$ulong2uint;
import org.clank.support.aliases.char$iterator;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.long$iterator;
import org.clank.support.aliases.type$memory;
import org.clank.support.aliases.type$ptr;
import org.clank.support.aliases.uint$iterator;
import org.clank.support.aliases.uint$ptr;
import org.clank.support.aliases.ulong$iterator;
import org.clank.support.aliases.ulong$ptr;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class CollectionUtils {

  @FunctionalInterface
  public static interface Equalizer<T1, T2> {
    boolean areEqual(T1 t1, T2 t2);
  }
 
  public static <F, T> T[] transform(F[] from, Converter<F, T> converter, boolean nullTerminate, boolean SkipConvertedToNull) {
    List<T> toList = transform(Arrays.asList(from), converter, nullTerminate, SkipConvertedToNull);
    T[] to = (T[]) Array.newInstance(converter.getToClass(), toList.size());
    to = toList.toArray(to);
    return to;
  }    
  
  public static <F, T> List<T> transform(List<F> from, Converter<F, T> converter, boolean nullTerminate, boolean SkipConvertedToNull) {
    List<T> to = new ArrayList<>(from.size() + (nullTerminate ? 1 : 0));
    for (F f : from) {
      T converted = converter.$call(f);
      if (!SkipConvertedToNull || (converted != null)) {
        to.add(converted);
      }
    }
    if (nullTerminate) {
      to.add(null);
    }    
    return to;
  }    
  
  public static <T> Set<T> asSet(T ... values) {
    Set<T> result = new HashSet<>();
    for (T value : values) {
      result.add(value);
    }
    return result;
  }
  
  public static <K, V> Map<K, V> asMap(std.pair<K, V> ... pairs) {
    Map<K, V> result = new HashMap<>();
    for (std.pair<K, V> kv : pairs) {
      result.put(kv.first, kv.second);
    }
    return result;
  }

  /**
   * each input single boxed Integer value is casted to single uint value using unboxing
   * @param orig stream of Integer objects
   * @return same-sized stream of uint-values
   */
  public static uint$ptr transform_Integers2uint$ptr(type$ptr<Integer> orig) {
    class Integer2UIntValue extends AbstractPointerAdaptor<Integer2UIntValue, uint$ptr, type$ptr<Integer>> implements uint$ptr {

      public Integer2UIntValue(type$ptr<Integer> delegate) {
        super(delegate);
      }
      public Integer2UIntValue(Integer2UIntValue $Prm0) {
        super($Prm0);
      }

      @Override public /*uint*/int $star() {
        return delegate.$star().intValue();
      }

      @Override public Integer2UIntValue clone() {
        return new Integer2UIntValue(this);
      }

      @Override
      public int $set(int value) {
        return $set(0, value);
      }

      @Override
      public int $at(int index) {
        return delegate.$at(index).intValue();
      }

      @Override
      public int $set(int index, int value) {
        return delegate.$set(index, Integer.valueOf(value));
      }
      
      
    }
    return new Integer2UIntValue(orig);
  }
  
  /**
   * each input single long value is casted to single ulong value using $long2ulong
   * @param orig stream of uint values
   * @return same-sized stream of long-values
   */   
  public static ulong$ptr transform_long2ulong$ptr(long$iterator<?> orig) {

    class Long2ULongValue extends AbstractPointerAdaptor<Long2ULongValue, ulong$ptr, long$iterator> implements ulong$ptr {

      public Long2ULongValue(long$iterator delegate) {
        super(delegate);
      }
      public Long2ULongValue(Long2ULongValue $Prm0) {
        super($Prm0);
      }

      @Override public /*ulong*/long $star() {
        return $long2ulong(delegate.$star());
      }

      @Override public Long2ULongValue clone() {
        return new Long2ULongValue(this);
      }
    }
    return new Long2ULongValue(orig);
  }

  /**
   * each input single uint value is casted to single ulong value using $uint2ulong
   * @param orig stream of uint values
   * @return same-sized stream of long-values
   */  
  public static ulong$ptr transform_uint2ulong$ptr(uint$iterator<?> orig) {
    class UInt2ULongValue extends AbstractPointerAdaptor<UInt2ULongValue, ulong$ptr, uint$iterator> implements ulong$ptr {

      public UInt2ULongValue(uint$iterator delegate) {
        super(delegate);
      }
      public UInt2ULongValue(UInt2ULongValue $Prm0) {
        super($Prm0);
      }

      @Override public /*ulong*/long $star() {
        return $uint2ulong(delegate.$star());
      }

      @Override public UInt2ULongValue clone() {
        return new UInt2ULongValue(this);
      }
    }
    return new UInt2ULongValue(orig);
  }
  
  /**
   * each input single char value is casted to single ulong value using $uchar2ulong
   * @param orig stream of char values
   * @return same-sized stream of long-values
   */  
  public static ulong$ptr transform_char2ulong$ptr(char$iterator<?> orig) {
    
    class Char2ULongValue extends AbstractPointerAdaptor<Char2ULongValue, ulong$ptr, char$iterator> implements ulong$ptr {

      public Char2ULongValue(char$iterator delegate) {
        super(delegate);
      }
      public Char2ULongValue(Char2ULongValue $Prm0) {
        super($Prm0);
      }

      @Override public /*ulong*/long $star() {
        return $uchar2ulong(delegate.$star());
      }

      @Override public Char2ULongValue clone() {
        return new Char2ULongValue(this);
      }
    }
    return new Char2ULongValue(orig);
  }
  
  /**
   * each input single long value is casted to single char value using $ulong2uchar
   * @param orig stream of ulong values
   * @return same-sized stream of char-values
   */
  public static char$ptr transform_ulong2char$ptr(ulong$iterator<?> orig) {

    class ULong2CharValue extends AbstractPointerAdaptor<ULong2CharValue, char$ptr, ulong$iterator> implements char$ptr {

      public ULong2CharValue(ulong$iterator delegate) {
        super(delegate);
      }
      public ULong2CharValue(ULong2CharValue $Prm0) {
        super($Prm0);
      }

      @Override public /*char*/byte $star() {
        return $ulong2uchar(delegate.$star());
      }

      @Override public ULong2CharValue clone() {
        return new ULong2CharValue(this);
      }
    }
    return new ULong2CharValue(orig);
  }
    
  /**
   * each input single long value is casted to single uint value using $ulong2uint
   * @param orig stream of ulong values
   * @return same-sized stream of uint-values
   */
  public static uint$ptr transform_ulong2uint$ptr(ulong$iterator<?> orig) {
    class ULong2UIntValue extends AbstractPointerAdaptor<ULong2UIntValue, uint$ptr, ulong$iterator> implements uint$ptr {

      public ULong2UIntValue(ulong$iterator delegate) {
        super(delegate);
      }
      public ULong2UIntValue(ULong2UIntValue $Prm0) {
        super($Prm0);
      }

      @Override public /*uint*/int $star() {
        return $ulong2uint(delegate.$star());
      }

      @Override public ULong2UIntValue clone() {
        return new ULong2UIntValue(this);
      }
    }
    return new ULong2UIntValue(orig);
  }    
  
  //////////////////////////////////////////////////////////////////////////////
  // implementations
  
  private static abstract class AbstractPointerAdaptor<Derived extends AbstractPointerAdaptor, PtrType extends abstract_pointer, OrigIter extends abstract_iterator> implements abstract_pointer<PtrType> {

    protected final OrigIter delegate;

    protected AbstractPointerAdaptor(OrigIter delegate) {
      this.delegate = $noClone(delegate); // we don't call in constructor, but in call when needed
    }
    protected AbstractPointerAdaptor(Derived $Prm0) {
      this.delegate = $Clone((OrigIter)$Prm0.delegate); // we clone only during copy
    }
    
    @Override
    public PtrType $sub(int amount) {
      AbstractPointerAdaptor out = $Clone(this);
      out.$dec(amount);
      return (PtrType)out;
    }

    @Override
    public PtrType $add(int amount) {
      AbstractPointerAdaptor out = $Clone(this);
      out.$inc(amount);
      return (PtrType)out;
    }

    @Override
    public PtrType $dec(int amount) {
      delegate.$dec(amount);
      return (PtrType)this;
    }

    @Override
    public PtrType $inc(int amount) {
      delegate.$inc(amount);
      return (PtrType)this;
    }

    @Override
    public PtrType $postDec() {
      AbstractPointerAdaptor out = $Clone(this);
      out.$preDec();
      return (PtrType)out;
    }

    @Override
    public PtrType $postInc() {
      AbstractPointerAdaptor out = $Clone(this);
      out.$preInc();
      return (PtrType)out;
    }

    @Override
    public PtrType $preDec() {
      delegate.$preDec();
      return (PtrType)this;
    }

    @Override
    public PtrType $preInc() {
      delegate.$preInc();
      return (PtrType)this;
    }

    @Override
    public int $sub(PtrType iter) {
      return delegate.$sub(((AbstractPointerAdaptor)iter).delegate);
    }

    @Override
    public boolean $eq(Object other) {
      if (other instanceof AbstractPointerAdaptor) {
        return delegate.$eq(((AbstractPointerAdaptor) other).delegate);
      } else {
        return delegate.$eq(other);
      }
    }

    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public abstract PtrType clone();

    @Override
    public PtrType const_clone() {
      return clone();
    }

    //////////////////////////////////////////////////////////////////////////////
    // from abstract_pointer
    @Override
    public boolean $isNull() {
      return ((void$ptr)delegate).$isNull();
    }
    
    @Override
    public boolean isComparableTo(void$ptr other) {
      throw new UnsupportedOperationException("Not yet implemented isComparableTo " + this.getClass() + " vs " + NativeTrace.getIdentityStr(other));
    }

    @Override
    public int $hashcode() {
      throw new UnsupportedOperationException("Not yet implemented $hashcode " + this.getClass());
    }

    @Override
    public boolean $greater(Object other) {
      throw new UnsupportedOperationException("Not yet implemented $greater " + this.getClass() + " vs " + NativeTrace.getIdentityStr(other));
    }
    
    @Override 
    public PtrType $assign(PtrType $Prm0) {
      ((Native.assignable<OrigIter>)this.delegate).$assign((OrigIter)((AbstractPointerAdaptor)$Prm0).delegate);
      return (PtrType)this;
    }
    
    @Override
    public type$memory<PtrType> getSelfMemory() {
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass()); 
    }        

    @Override 
    public int getSelfIndex() { 
      throw new UnsupportedOperationException("Why not implemented in " + this.getClass()); 
    }
  
  }
}
