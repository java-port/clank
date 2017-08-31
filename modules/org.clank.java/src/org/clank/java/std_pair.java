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

import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.Obj2T;
import org.clank.support.NativeFoldingSetTrait;
import org.clank.support.NativeMoveable;
import org.clank.support.NativeSwappable;
import org.clank.support.NativeTrace;
import org.clank.support.NativeType;
import static org.clank.support.Unsigned.*;
import org.clank.support.aliases.*;
import org.clank.support.void$ptr;
/**
 *
 * @author Vladimir Voskresensky
 */
public interface std_pair {
  public static /*<bool,bool>pair*/int wrap_bool_bool_pair(boolean First, boolean Second) {
    int Out = (First ? 0x80000000 : 0) | (Second ? 1 : 0);
    assert $first_bool(Out) == First;
    assert $second_bool(Out) == Second;
    return Out;
  }

  public static /*<bool,uint>pair*/long wrap_bool_int_pair(boolean First, int Second) {
    long Out = (First ? 0x8000000000000000L : 0L) | $uint2long(Second);
    assert $first_bool(Out) == First;
    assert $second_int(Out) == Second : $second_int(Out) + " vs. " + Second;
    return Out;
  }
  
  public static /*<bool,uint>pair*/long wrap_bool_uint_pair(boolean First, /*uint*/int Second) {
    long Out = (First ? 0x8000000000000000L : 0L) | $uint2long(Second);
    assert $first_bool(Out) == First;
    assert $second_uint(Out) == Second : $second_uint(Out) + " vs. " + Second;
    return Out;
  }
  
  public static /*<char-byte,int>pair*/long wrap_char_int_pair(byte First, int Second) {
    long Out = (((long)(First)) << 32) | $uint2long(Second);
    assert $first_byte(Out) == First;
    assert $second_int(Out) == Second;
    return Out;
  }
  
  public static /*<char-byte,int>pair*/long wrap_char_int_pair(char First, int Second) {
    assert Second < Byte.MAX_VALUE;
    long Out = (((long)(First)) << 32) | $uint2long(Second);
    assert $first_byte(Out) == First;
    assert $second_int(Out) == Second;
    return Out;
  }

  public static /*<int,int>pair*/long wrap_int_int_pair(int First, int Second) {
    long Out = (((long)(First)) << 32) | $uint2long(Second);
    assert $first_int(Out) == First;
    assert $second_int(Out) == Second;
    return Out;
  }

  public static /*<uint-int,uint-int>pair*/long wrap_uint_uint_pair(int First, int Second) {
    long Out = (((long)(First)) << 32) | $uint2long(Second);
    assert $first_uint(Out) == First;
    assert $second_uint(Out) == Second;
    return Out;
  }

  public static /*<int-int,uint-int>pair*/long wrap_int_uint_pair(std.pairIntInt pair) {
    long Out = (((long)(pair.first)) << 32) | $uint2long(pair.second);
    assert $first_int(Out) == pair.first;
    assert $second_int(Out) == pair.second;
    return Out;
  }

  public static /*<int-int,uint-int>pair*/long wrap_int_uint_pair(int First, int Second) {
    long Out = (((long)(First)) << 32) | $uint2long(Second);
    assert $first_int(Out) == First;
    assert $second_int(Out) == Second;
    return Out;
  }
  
  public static int $first_int(/*<int,?>pair*/long Pair) {
    return (int)(Pair >>> 32);
  }

  public static /*uint*/int $first_uint(/*<uint,?>pair*/long Pair) {
    return (int)(Pair >>> 32);
  }

  public static int $second_int(/*<?,int>pair*/long Pair) {
    assert (int)(Pair & 0xFFFFFFFFL) == (int)Pair;
    return (int)(Pair);
  }

  public static /*uint*/int $second_uint(/*<?,uint>pair*/long Pair) {
    assert (int)(Pair & 0xFFFFFFFFL) == (int)Pair;
    return (int)(Pair);
  }

  public static byte $first_byte(/*<char-byte,?>pair*/long Pair) {
    return (byte)(Pair >>> 32);
  }

  public static byte $second_byte(/*<?,char-byte>pair*/long Pair) {
    assert (byte)(Pair & 0xFFL) == (byte)Pair;
    return (byte)(Pair);
  }

  public static boolean $second_bool(/*<?,boolean>pair*/byte Pair) {
    return (Pair & 0x1) == 0x1;
  }

  public static boolean $second_bool(/*<?,boolean>pair*/int Pair) {
    return (Pair & 0x1) == 0x1;
  }

  public static boolean $first_bool(/*<boolean,?>pair*/byte Pair) {
    return Pair < 0;
  }

  public static boolean $first_bool(/*<boolean,?>pair*/int Pair) {
    return Pair < 0;
  }

  public static boolean $first_bool(/*<boolean,?>pair*/long Pair) {
    return Pair < 0;
  } 
  
  public static final boolean MOVE_IN_PAIR_CTR = true;//Boolean.getBoolean("clank.pair.move");
  public static final boolean ASSERT_NULL_IN_PAIR_CTR = Boolean.getBoolean("clank.pair.assert.null");
  
  public static class pair<T, T1> implements Native.NativePOD<pair<T, T1>>, NativeMoveable<pair<T, T1>>, NativeType.SizeofCapable, Destructors.ClassWithDestructor, NativeFoldingSetTrait.NativeProfilable {
    
    public T first;
    public T1 second;
    
    // JAVA ONLY
    public static <T, T1> pair<T, T1> of(T f, T1 s) {
      return new std.pair(f, s);
    }
    
    public pair(JD$Move _param, pair<T, T1> other) {
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      this.first = MOVE_IN_PAIR_CTR ? Native.$tryMove(null, other.first, isFirstPointerLike()) : other.first;
      this.second = MOVE_IN_PAIR_CTR ? Native.$tryMove(null, other.second, isSecondPointerLike()) : other.second;
//      assert (isFirstPointerLike() && isSecondPointerLike()) || (first == null) || (first != second) : "can not have equal non-pointers";
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (first != null) : "forgot to pass value?";
      assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (second != null) : "forgot to pass value?";
      trackInstance();      
    }
    
    public <U1, U2> pair(JD$Pair$_U1$_U2 _param, U1 first, U2 second) {
      this((T)first, (T1)second);
      assert _param != null;
    }
    
    public <U1, U2> pair(JD$Pair$_U1$_U2 _param, pair<U1, U2> other) {
      this((T)other.first, (T1)other.second);
      assert _param != null;
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }
    
    public <U1, U2> pair(JD$Pair$_U1$_U2 _param, Obj2T<T> conv1, Obj2T<T1> conv2, Object other) {
      this(conv1.$call(other), conv2.$call(other));
      assert _param != null;
    }
    
    public pair(pair<T, T1> other) {
      this(other.first, other.second);
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pair() {
      this((T)null, (T1)null);
    }

    public pair(JD$T$RR_T1$RR _dparam, T first, T1 second) {
      this.first = first; //$tryMove(null, first, isFirstPointerLike());
      this.second = second;// $tryMove(null, second, isSecondPointerLike());
//      assert (isFirstPointerLike() && isSecondPointerLike()) || (first == null) || (first != second) : "can not have equal non-pointers";
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (first != null) : "forgot to pass value?";
      assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (second != null) : "forgot to pass value?";      
      trackInstance();
    }

    public pair(JD$T$RR_T1$C$R _dparam, /*const*/T first, T1 second) {
      this.first = first; //$tryMove(null, first, isFirstPointerLike());
      this.second = second;
//      assert (isFirstPointerLike() && isSecondPointerLike()) || (first == null) || (first != second) : "can not have equal non-pointers";
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (first != null) : "forgot to pass value?";
      assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (second != null) : "forgot to pass value?";      
      trackInstance();
    }
    
    public pair(std.piecewise_construct_t _dparam, std.tuple first, std.tuple second) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    public pair(T first, T1 second) {
      this.first = first;
      this.second = second;
//      assert (isFirstPointerLike() && isSecondPointerLike()) || (first == null) || (first != second) : "can not have equal non-pointers";
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (first != null) : "forgot to pass value?";
      assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (second != null) : "forgot to pass value?";      
      trackInstance();
    }

    public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(first);
      }
      if (!isSecondPointerLike()) {
        Destructors.$destroy(second);
      }
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (value != null) : "forgot to pass value?";
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    public type$ref<T1> second$ref() {
      return new type$ref<T1/*&*/>() {
        @Override
        public T1 /*&*/ $deref() {
          return second;
        }

        @Override
        public T1 /*&*/ $set(T1/*&*/ value) {
          assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (value != null) : "forgot to pass value?";          
          return second = Native.$tryAssign(second, value, isSecondPointerLike());
        }
      };
    }
    
    public T getFirst() {
      return first;
    }
    
    public T1 getSecond() {
      return second;
    }
    
    @Override
    public pair<T, T1> clone() {
      assert this.getClass() == std.pair.class : "must be overridden in derived class" + this.getClass();
      return new std.pair($tryClone(first), $tryClone(second));
    }

    @Override
    public pair<T, T1> move() {
      assert this.getClass() == std.pair.class : "must be overridden in derived class" + this.getClass();
      return new std.pair($tryMove(first), $tryMove(second));
    }

    @Override
    public pair<T, T1> $assign(pair<T, T1> other) {
      this.first = Native.$tryAssign(first, other.first, isFirstPointerLike());
      this.second = Native.$tryAssign(second, other.second, isSecondPointerLike());
      assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (first != null) : "forgot to pass value?";
      assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (second != null) : "forgot to pass value?";      
      return this;
    }
    
    public pair<T, T1> $assignMove(pair<T, T1> other) {
      assert this != other;
      this.first = Native.$tryMove(first, other.first, isFirstPointerLike());
      this.second = Native.$tryMove(second, other.second, isSecondPointerLike());
      assert !ASSERT_NULL_IN_PAIR_CTR || isFirstPointerLike() || (first != null) : "forgot to pass value?";
      assert !ASSERT_NULL_IN_PAIR_CTR || isSecondPointerLike() || (second != null) : "forgot to pass value?";      
      return this;
    }
    
    @Override
    public boolean $eq(pair<T, T1> other) {
      if (other == null) {
        return false;
      }
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      return Native.$eq(this.first, other.first, isFirstPointerLike()) 
              && Native.$eq(this.second, other.second, isSecondPointerLike());
    }

    @Override
    public boolean $noteq(pair<T, T1> other) {
      return !$eq(other);
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    protected boolean isSecondPointerLike() {
      return false;
    }
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pair.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pair.class.getSimpleName(), instances);
      return instances;        
    }      

    @Override
    public int $sizeof() {
      // FIXME: probably it is incorrect to consider fields as references
      NativeTrace.traceNotImplemented("std.pair.$sizeof");
      return NativeType.sizeof$ptr() + NativeType.sizeof$ptr();
    }

    public void $assign_pair$_U1$_U2(pair<T, T1> other) {
      $assign(other);
    }

    @Override
    public final void Profile(NativeFoldingSetTrait.NativeFoldingSetNodeID ID) {
      if (isFirstPointerLike()) {
        ID.AddPointer(this.first);
      } else {
        ((NativeFoldingSetTrait.NativeProfilable)this.first).Profile(ID);
      }
      if (isSecondPointerLike()) {
        ID.AddPointer(this.second);
      } else {
        ((NativeFoldingSetTrait.NativeProfilable)this.second).Profile(ID);
      }
    }
  }
  
  public static class pairPtrPtr<T, T1> extends pair<T, T1> implements ComparableLower {
    
    // JAVA ONLY
    public static <T, T1> pairPtrPtr<T, T1> of(T f, T1 s) {
      return new std.pairPtrPtr(f, s);
    }
    
    public pairPtrPtr(JD$Move _param, pair<T, T1> other) {
      super(_param, other);
      trackInstance();
    }
    
    public <U1, U2> pairPtrPtr(JD$Pair$_U1$_U2 _param, pair<U1, U2> other) {
      super(_param, other);
      trackInstance();
    }

    public <U1, U2> pairPtrPtr(JD$Pair$_U1$_U2 _param, U1 first, U2 second) {
      super(_param, first, second);
      trackInstance();
    }

    public pairPtrPtr(pair<T, T1> other) {
      super(other);
      trackInstance();
    }
    
    public pairPtrPtr() {
      this((T)null, (T1)null);
    }

    public pairPtrPtr(JD$T$RR_T1$RR _dparam, T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairPtrPtr(JD$T$RR_T1$C$R _dparam, /*const*/T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairPtrPtr(T first, T1 second) {
      super(first, second);
      trackInstance();
    }

    @Override protected final boolean isFirstPointerLike() {
      return true;
    }

    @Override protected final boolean isSecondPointerLike() {
      return true;
    }
    
    @Override
    public pairPtrPtr<T, T1> clone() {
      assert this.getClass() == std.pairPtrPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrPtr(first, second);
    }
    
    @Override
    public pairPtrPtr<T, T1> move() {
      assert this.getClass() == std.pairPtrPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrPtr(first, second);
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pair.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrPtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrPtr.class.getSimpleName(), instances);
      return instances;        
    }      

    @Override
    public int $sizeof() {
      NativeTrace.traceNotImplemented("std.pairPtrPtr.$sizeof");
      return NativeType.sizeof$ptr() + NativeType.sizeof$ptr();
    }

    @Override
    public boolean $less(Object obj) {
      pairPtrPtr<T, T1> other = (pairPtrPtr<T, T1>)obj;
      //if (Native.$less(first, other.first)) {
      //  return true;
      //} if (Native.$eq(first, other.first)) {
      //  return Native.$less(second, other.second);
      //}
      //return false;
      int hash1 = System.identityHashCode(this.first);
      int hash2 = System.identityHashCode(other.first);
      if (hash1 < hash2) {
        return true;
      }
      if (hash1 > hash2) {
        return false;
      }
      hash1 = System.identityHashCode(this.second);
      hash2 = System.identityHashCode(other.second);
      if (hash1 < hash2) {
        return true;
      }
      return false;
    }
  }

  public static class pairPtrType<T, T1> extends pair<T, T1> {
    
    // JAVA ONLY
    public static <T, T1> pairPtrType<T, T1> of(T f, T1 s) {
      return new std.pairPtrType(f, s);
    }
    
    public pairPtrType(JD$Move _param, pair<T, T1> other) {
      super(_param, other);
      trackInstance();
    }
    
    public <U1, U2> pairPtrType(JD$Pair$_U1$_U2 _param, pair<U1, U2> other) {
      super(_param, other);
      trackInstance();
    }
    
    public <U1, U2> pairPtrType(JD$Pair$_U1$_U2 _param, Obj2T<T> conv1, Obj2T<T1> conv2, Object other) {
      super(_param, conv1, conv2, other);
      trackInstance();
    }
    
    public pairPtrType(pair<T, T1> other) {
      super(other);
      trackInstance();
    }

    public pairPtrType() {
      this((T)null, (T1)null);
    }

    public pairPtrType(JD$T$RR_T1$RR _dparam, T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairPtrType(JD$T$RR_T1$C$R _dparam, /*const*/T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairPtrType(T first, T1 second) {
      super(first, second);
      trackInstance();
    }

    public pairPtrType(JD$Pair$_U1$_U2 INSTANCE, T first, T1 second) {
      this(first, second);
    }

    @Override protected final boolean isFirstPointerLike() {
      return true;
    }

    @Override protected final boolean isSecondPointerLike() {
      return false;
    }
    
    @Override
    public pairPtrType<T, T1> clone() {
      assert this.getClass() == std.pairPtrType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrType(first, $tryClone(second));
    }
    
    @Override
    public pairPtrType<T, T1> move() {
      assert this.getClass() == std.pairPtrType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrType(first, $tryMove(second));
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pair.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrType.class.getSimpleName(), instances);
      return instances;        
    }      

    @Override
    public int $sizeof() {
      NativeTrace.traceNotImplemented("std.pairPtrType.$sizeof");
      return NativeType.sizeof$ptr() + NativeType.sizeof$ptr();
    }
  }

  public static class pairTypePtr<T, T1> extends pair<T, T1> {
    
    // JAVA ONLY
    public static <T, T1> pairTypePtr<T, T1> of(T f, T1 s) {
      return new std.pairTypePtr(f, s);
    }
    
    public pairTypePtr(JD$Move _param, pair<T, T1> other) {
      super(_param, other);
      trackInstance();
    }

    public <U1, U2> pairTypePtr(JD$Pair$_U1$_U2 _param, U1 first, U2 second) {
      super(_param, first, second);
      trackInstance();
    }
    
    public <U1, U2> pairTypePtr(JD$Pair$_U1$_U2 _param, pair<U1, U2> other) {
      super(_param, other);
      trackInstance();
    }
    
    public <U1, U2> pairTypePtr(JD$Pair$_U1$_U2 _param, Obj2T<T> conv1, Obj2T<T1> conv2, pair<U1, U2> other) {
      super(_param, conv1, conv2, other);
      trackInstance();
    }

    public pairTypePtr(pair<T, T1> other) {
      super(other);
      trackInstance();
    }
   
    public pairTypePtr() {
      this((T)null, (T1)null);
    }

    public pairTypePtr(JD$T$RR_T1$RR _dparam, T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairTypePtr(JD$T$RR_T1$C$R _dparam, /*const*/T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairTypePtr(T first, T1 second) {
      super(first, second);
      trackInstance();
    }

    @Override protected boolean isFirstPointerLike() {
      return false;
    }

    @Override protected boolean isSecondPointerLike() {
      return true;
    }
    
    @Override
    public pairTypePtr<T, T1> clone() {
      assert this.getClass() == std.pairTypePtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypePtr($tryClone(first), second);
    }
    
    @Override
    public pairTypePtr<T, T1> move() {
      assert this.getClass() == std.pairTypePtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypePtr($tryMove(first), second);
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pair.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypePtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypePtr.class.getSimpleName(), instances);
      return instances;        
    }      

    @Override
    public int $sizeof() {
      NativeTrace.traceNotImplemented("std.pairTypePtr.$sizeof");
      return NativeType.sizeof$ptr() + NativeType.sizeof$ptr();
    }
  }

  public static class pairTypeType<T, T1> extends pair<T, T1> {
    
    // JAVA ONLY
    public static <T, T1> pairTypeType<T, T1> of(T f, T1 s) {
      return new std.pairTypeType(f, s);
    }
    
    public pairTypeType(JD$Move _param, pair<T, T1> other) {
      super(_param, other);
      trackInstance();
    }
    
    public <U1, U2> pairTypeType(JD$Pair$_U1$_U2 _param, pair<U1, U2> other) {
      super(_param, other);
      trackInstance();
    }
    
    public <U1, U2> pairTypeType(JD$Pair$_U1$_U2 _param, Obj2T<T> conv1, Obj2T<T1> conv2, Object other) {
      super(_param, conv1, conv2, other);
      trackInstance();
    }

    public pairTypeType(pair<T, T1> other) {
      super(other);
      trackInstance();
    }
    
    public pairTypeType() {
      this((T)null, (T1)null);
    }

    public pairTypeType(JD$Pair$_U1$_U2 _dparam, T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairTypeType(JD$T$RR_T1$RR _dparam, T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairTypeType(JD$T$RR_T1$C$R _dparam, /*const*/T first, T1 second) {
      super(_dparam, first, second);
      trackInstance();
    }

    public pairTypeType(T first, T1 second) {
      super(first, second);
      trackInstance();
    }

    @Override protected final boolean isFirstPointerLike() {
      return false;
    }

    @Override protected final boolean isSecondPointerLike() {
      return false;
    }
    
    @Override
    public pairTypeType<T, T1> clone() {
      assert this.getClass() == std.pairTypeType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeType($tryClone(first), $tryClone(second));
    }
    
    @Override
    public pairTypeType<T, T1> move() {
      assert this.getClass() == std.pairTypeType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeType($tryMove(first), $tryMove(second));
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pair.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeType.class.getSimpleName(), instances);
      return instances;        
    }      

    @Override
    public int $sizeof() {
      NativeTrace.traceNotImplemented("std.pairTypeType.$sizeof");
      return NativeType.sizeof$ptr() + NativeType.sizeof$ptr();
    }
  }
  
  // std::pair<int, int>
  public static class pairIntInt implements Native.NativePOD<pairIntInt>, NativeMoveable<pairIntInt> {

    public int first;
    public int second;

    public pairIntInt(JD$Move _param, pairIntInt other) {
      this(other.first, other.second);
    }
    
    public pairIntInt() {
      this(0, 0);
    }

    public pairIntInt(pairIntInt other) {
      this(other.first, other.second);
    }

    public pairIntInt(int first, int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairIntInt(long/*int,int*/ merged) {
      this($first_int(merged), $second_int(merged));
    }

    public pairIntInt(JD$Pair$_U1$_U2 INSTANCE, int first, int second) {
      this(first, second);
    }

    public long/*int,int*/$long() {
      return wrap_int_int_pair(first, second);
    }
    
    @Override
    public pairIntInt $assign(pairIntInt other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }

    public pairIntInt $assign(long/*int,int*/ other) {
      this.first = $first_int(other);
      this.second = $second_int(other);
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairIntInt clone() {
      assert this.getClass() == std.pairIntInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntInt(first, second);
    }

    @Override
    public pairIntInt move() {
      assert this.getClass() == std.pairIntInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntInt(first, second);
    }

    @Override
    public boolean $noteq(pairIntInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairIntInt other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairIntInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairIntInt.class.getSimpleName(), instances);
      return instances;
    }   
  }

  // std::pair<uint, T>
  public static class pairIntType<T> implements Native.NativePOD<pairIntType<T>>, NativeMoveable<pairIntType<T>>, Destructors.ClassWithDestructor {

    public int first;
    public T second;

    public pairIntType(JD$Move _param, pairIntType other) {
      this.first = other.first;
      this.second = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.second, isSecondPointerLike()) : (T)other.second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      trackInstance();
    }
    
    public pairIntType() {
      this(0, null);
    }
    
    public pairIntType(T second) {
      this(0, second);
    }

    public pairIntType(int first, T second) {
      this.first = (int) first;
      this.second = second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairIntType<T> $assign(pairIntType<T> other) {
      this.first = other.first;
      this.second = $tryAssign(this.second, other.second, isSecondPointerLike());
      return this;
    }

    public pairIntType<T> $assignMove(pairIntType<T> other) {
      this.first = other.first;
      this.second = $tryMove(this.second, other.second, isSecondPointerLike());
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> second$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return second;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return second = Native.$tryAssign(second, value, isSecondPointerLike());
        }
      };
    }
    
    @Override
    public pairIntType<T> clone() {
      assert this.getClass() == std.pairIntType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntType(first, $tryClone(second));
    }

    @Override
    public pairIntType<T> move() {
      assert this.getClass() == std.pairIntType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntType(first, $tryMove(second));
    }

    @Override
    public boolean $noteq(pairIntType<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairIntType<T> other) {
      return (other != null) && this.first == other.first && Native.$eq(this.second, other.second, isSecondPointerLike());
    }
   
    protected boolean isSecondPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isSecondPointerLike()) {
        Destructors.$destroy(this.second);
      }
    }
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairIntType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairIntType.class.getSimpleName(), instances);
      return instances;           
    }      
  }

  // std::pair<int, T*>
  public static class pairIntPtr<T/*P*/> extends pairIntType<T> {

    public pairIntPtr(JD$Move _param, pairIntType other) {
      this(other.first, (T/*P*/)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();      
    }
    
    public pairIntPtr() {
      this(0, (T/*P*/)null);
    }

    public pairIntPtr(pairIntType<T/*P*/> other) {
      this(other.first, (T/*P*/)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();       
    }

    public pairIntPtr(JD$T$RR_T1$RR _dparam, int first, T/*P*/ second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairIntPtr(JD$T$RR_T1$C$R INSTANCE, int first, T/*P*/ second) {
      this(first, second);
    }

    public pairIntPtr(int first, T/*P*/ second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public pairIntPtr<T/*P*/> clone() {
      assert this.getClass() == std.pairIntPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntPtr<T>(this.first, (T/*P*/)this.second);
    }

    @Override
    public pairIntPtr<T/*P*/> move() {
      assert this.getClass() == std.pairIntPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntPtr<T>(this.first, (T/*P*/)this.second);
    }
    
    @Override protected final boolean isSecondPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairIntType.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairIntPtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairIntPtr.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<unsigned char, T>
  public static class pairUCharType<T> implements Native.NativePOD<pairUCharType<T>>, NativeMoveable<pairUCharType<T>>, Destructors.ClassWithDestructor {

    public /*uchar*/byte first;
    public T second;

    public pairUCharType(pairUCharType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairUCharType(JD$Move _param, pairUCharType other) {
      this.first = other.first;
      this.second = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.second, isSecondPointerLike()) : (T)other.second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      trackInstance();
    }
    
    public pairUCharType() {
      this((byte) 0, null);
    }

    public pairUCharType(/*uchar*/byte first, T second) {
      this.first = first;
      this.second = second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> second$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return second;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return second = Native.$tryAssign(second, value, isSecondPointerLike());
        }
      };
    }
    
    @Override
    public pairUCharType<T> $assign(pairUCharType<T> value) {
      this.first = value.first;
      this.second = $tryAssign(this.second, value.second, isSecondPointerLike());
      return this;
    }

    @Override
    public pairUCharType<T> $assignMove(pairUCharType<T> value) {
      this.first = value.first;
      this.second = $tryMove(this.second, value.second, isSecondPointerLike());
      return this;
    }

    @Override
    public pairUCharType<T> clone() {
      assert this.getClass() == std.pairUCharType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUCharType(first, $tryClone(second));
    }

    @Override
    public pairUCharType<T> move() {
      assert this.getClass() == std.pairUCharType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUCharType(first, $tryMove(second));
    }

    @Override
    public boolean $noteq(pairUCharType<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUCharType<T> other) {
      return (other != null) && this.first == other.first && Native.$eq(this.second, other.second, isSecondPointerLike());
    }
    
    protected boolean isSecondPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isSecondPointerLike()) {
        Destructors.$destroy(this.second);
      }
    }
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUCharType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUCharType.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<uchar, T*>
  public static class pairUCharPtr<T/*P*/> extends pairUCharType {

    public pairUCharPtr(JD$Move _param, pairUCharType other) {
      this(other.first, (T/*P*/)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }
    
    public pairUCharPtr() {
      this((byte)0, (T/*P*/)null);
    }

    public pairUCharPtr(pairUCharType<T/*P*/> other) {
      this(other.first, (T/*P*/)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairUCharPtr(JD$T$RR_T1$RR _dparam, /*uchar*/byte first, T/*P*/ second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairUCharPtr(JD$T$RR_T1$C$R INSTANCE, /*uchar*/byte first, T/*P*/ second) {
      this(first, second);
    }

    public pairUCharPtr(/*uchar*/byte first, T/*P*/ second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public pairUCharPtr<T/*P*/> clone() {
      assert this.getClass() == std.pairUCharPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUCharPtr<T>(this.first, (T/*P*/)this.second);
    }

    @Override
    public pairUCharPtr<T/*P*/> move() {
      assert this.getClass() == std.pairUCharPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUCharPtr<T>(this.first, (T/*P*/)this.second);
    }
    
    @Override protected final boolean isSecondPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairUCharType.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUCharPtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUCharPtr.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, int>
  public static class pairTypeInt<T> implements Native.NativePOD<pairTypeInt<T>>, NativeMoveable<pairTypeInt<T>>, NativeSwappable, Destructors.ClassWithDestructor {

    public T first;
    public int second;

    public pairTypeInt(JD$Move _param, pairTypeInt other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeInt(pairTypeInt<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeInt(JD$Pair$_U1$_U2 INSTANCE, pairTypeUInt<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairTypeInt() {
      this(null, 0);
    }

    public pairTypeInt(T first, int second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeInt<T> $assign(pairTypeInt<T> value) {
      this.first = $tryAssign(this.first, value.first, isFirstPointerLike());
      this.second = value.second;
      return this;
    }

    @Override
    public pairTypeInt<T> $assignMove(pairTypeInt<T> value) {
      this.first = $tryMove(this.first, value.first, isFirstPointerLike());
      this.second = value.second;
      return this;
    }

    @Override
    public pairTypeInt<T> clone() {
      assert this.getClass() == std.pairTypeInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeInt<>($tryClone(first), second);
    }

    @Override
    public pairTypeInt<T> move() {
      assert this.getClass() == std.pairTypeInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeInt<>($tryMove(first), second);
    }

    @Override
    public void swap(NativeSwappable RHS) {
      pairTypeInt<T> _RHS = (pairTypeInt<T>) RHS;
      if (isFirstPointerLike()) {
        T oldFirst = this.first;
        this.first = _RHS.first;
        _RHS.first = oldFirst;        
      } else {
        std.swap((NativeSwappable)this.first, (NativeSwappable)_RHS.first);
      }
      int oldSecond = this.second;
      this.second = _RHS.second;
      _RHS.second = oldSecond;
    }

    @Override
    public boolean $noteq(pairTypeInt<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeInt<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<T*, int>
  public static class pairPtrInt<T/*P*/> extends pairTypeInt<T> {

    public pairPtrInt(JD$Move _param, pairTypeInt<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrInt() {
      this((T)null, 0);
    }

    public pairPtrInt(pairTypeInt<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrInt(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*uint*/int second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrInt(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*uint*/int second) {
      this(first, second);
    }

    public pairPtrInt(T/*P*/ first, /*uint*/int second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrInt<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrInt<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrInt<T/*P*/> move() {
      assert this.getClass() == std.pairPtrInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrInt<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeInt.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }  
  
  // std::pair<uint, T>
  public static class pairUIntType<T> implements Native.NativePOD<pairUIntType<T>>, NativeMoveable<pairUIntType<T>>, Destructors.ClassWithDestructor {

    public /*uint*/int first;
    public T second;

    public pairUIntType(pairUIntType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairUIntType(JD$Move _param, pairUIntType other) {
      this.first = other.first;
      this.second = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.second, isSecondPointerLike()) : (T)other.second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      trackInstance();
    }

    public pairUIntType(JD$Pair$_U1$_U2 _param, pairUIntType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairUIntType(JD$T$RR _param, /*uint*/int first, T second) {
      this.first = first;
      this.second = (T)second;//$$tryMove(null, second, isSecondPointerLike());
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairUIntType(JD$T$RR_T1$RR _param, /*uint*/int first, T second) {
      this.first = first;
      this.second = (T)second;//$$tryMove(null, second, isSecondPointerLike());
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }
    
    public pairUIntType() {
      this(0, (T)null);
    }

    public pairUIntType(/*uint*/int first, T second) {
      this.first = first;
      this.second = second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairUIntType(JD$T$RR_T1$C$R INSTANCE, int first, T second) {
      this(first, second);
    }

    public pairUIntType<T> $assign(pairUIntType<T> other) {
      this.first = other.first;
      this.second = Native.$tryAssign(second, other.second, isSecondPointerLike());
      return this;
    }
    
    public pairUIntType<T> $assignMove(pairUIntType<T> other) {
      assert this != other;
      this.first = other.first;
      this.second = Native.$tryMove(second, other.second, isSecondPointerLike());
      return this;
    }
    
    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> second$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return second;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return second = Native.$tryAssign(second, value, isSecondPointerLike());
        }
      };
    }
    
    @Override
    public pairUIntType<T> clone() {
      assert this.getClass() == std.pairUIntType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntType(first, $tryClone(second));
    }

    @Override
    public pairUIntType<T> move() {
      assert this.getClass() == std.pairUIntType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntType(first, $tryMove(second));
    }

    @Override
    public boolean $noteq(pairUIntType<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUIntType<T> other) {
      return (other != null) && this.first == other.first && Native.$eq(this.second, other.second, isSecondPointerLike());
    }
    
    protected boolean isSecondPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isSecondPointerLike()) {
        Destructors.$destroy(this.second);
      }
    }
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntType.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<unsigned, T*>
  public static class pairUIntPtr<T> extends pairUIntType<T> {

    public pairUIntPtr(JD$Move _param, pairUIntType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }
    
    public pairUIntPtr() {
      this(0, (T)null);
    }

    public pairUIntPtr(pairUIntType<T> other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairUIntPtr(JD$T$RR_T1$RR _dparam, /*uint*/int first, T second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairUIntPtr(JD$T$RR_T1$C$R INSTANCE, /*uint*/int first, T second) {
      this(first, second);
    }

    public pairUIntPtr(/*uint*/int first, T second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public pairUIntPtr<T> clone() {
      assert this.getClass() == std.pairUIntPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntPtr<T>(this.first, (T/*P*/)this.second);
    }

    @Override
    public pairUIntPtr<T> move() {
      assert this.getClass() == std.pairUIntPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntPtr<T>(this.first, (T/*P*/)this.second);
    }
    
    @Override protected final boolean isSecondPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairUIntType.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntPtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntPtr.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  public static class pairULongBool implements Native.NativePOD<pairULongBool>, NativeMoveable<pairULongBool> {
    public /*ulong*/long first;
    public boolean second;

    public pairULongBool() {
    }
    
    public pairULongBool(long a, boolean b) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pairULongBool $assign(pairULongBool value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pairULongBool clone() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pairULongBool move() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  

  // std::pair<uint8_t, int64_t>
  public static class pairUCharLong implements Native.NativePOD<pairUCharLong>, NativeMoveable<pairUCharLong> {

    @Override
    public pairUCharLong $assign(pairUCharLong value) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pairUCharLong clone() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pairUCharLong move() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  }
  // std::pair<unsinged int, char>
  public static class pairULongChar implements Native.NativePOD<pairULongChar>, NativeMoveable<pairULongChar> {

    public /*ulong*/long first;
    public byte second;

    public pairULongChar(pairULongChar other) {
      this(other.first, other.second);
    }

    public pairULongChar(JD$Move _param, pairULongChar other) {
      this(other.first, other.second);
    }
    
    public pairULongChar() {
      this(0, (byte) 0);
    }

    public pairULongChar(/*ulong*/long first, byte second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairULongChar $assign(std.pairULongChar other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + (char) second + '}';
    }

    @Override
    public pairULongChar clone() {
      assert this.getClass() == std.pairULongChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongChar(first, second);
    }

    @Override
    public pairULongChar move() {
      assert this.getClass() == std.pairULongChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongChar(first, second);
    }

    @Override
    public boolean $noteq(pairULongChar other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairULongChar other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairULongChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairULongChar.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<uint64_t, T>
  public static class pairULongType<T> implements Native.NativePOD<pairULongType<T>>, NativeMoveable<pairULongType<T>>, Destructors.ClassWithDestructor {

    public /*uint*/long first;
    public T second;

    public pairULongType(pairULongType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairULongType(JD$Move _param, pairULongType other) {
      this.first = other.first;
      this.second = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.second, isSecondPointerLike()) : (T)other.second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      trackInstance();
    }
    
    public pairULongType() {
      this(0, null);
    }

    public pairULongType(/*uint*/long first, T second) {
      this.first = first;
      this.second = second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairULongType<T> $assign(pairULongType<T> other) {
      this.first = other.first;
      this.second = $tryAssign(this.second, other.second, isSecondPointerLike());
      return this;
    }

    public pairULongType<T> $assignMove(pairULongType<T> other) {
      this.first = other.first;
      this.second = $tryMove(this.second, other.second, isSecondPointerLike());
      return this;
    }
    
    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> second$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return second;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return second = Native.$tryAssign(second, value, isSecondPointerLike());
        }
      };
    }
    
    @Override
    public pairULongType<T> clone() {
      assert this.getClass() == std.pairULongType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongType(first, $tryClone(second));
    }

    @Override
    public pairULongType<T> move() {
      assert this.getClass() == std.pairULongType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongType(first, $tryMove(second));
    }

    @Override
    public boolean $noteq(pairULongType<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairULongType<T> other) {
      return (other != null) && this.first == other.first && Native.$eq(this.second, other.second);
    }
    
    protected boolean isSecondPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isSecondPointerLike()) {
        Destructors.$destroy(this.second);
      }
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntType.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<ulong, T*>
  public static class pairULongPtr<T> extends pairULongType<T> {

    public pairULongPtr(JD$Move _param, pairULongType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }
    
    public pairULongPtr() {
      this(0, (T)null);
    }

    public pairULongPtr(pairULongType<T> other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairULongPtr(JD$T$RR_T1$RR _dparam, /*ulong*/long first, T second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairULongPtr(JD$T$RR_T1$C$R INSTANCE, /*ulong*/long first, T second) {
      this(first, second);
    }

    public pairULongPtr(/*ulong*/long first, T second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public pairULongPtr<T> clone() {
      assert this.getClass() == std.pairULongPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongPtr<T>(this.first, (T/*P*/)this.second);
    }

    @Override
    public pairULongPtr<T> move() {
      assert this.getClass() == std.pairULongPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongPtr<T>(this.first, (T/*P*/)this.second);
    }
    
    @Override protected final boolean isSecondPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairULongType.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairULongPtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairULongPtr.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  public static class pairULLongType<T> extends pairULongType<T> {
    public pairULLongType(pairULongType other) {
      super(other);
    }
    public pairULLongType(JD$Move _param, pairULongType other) {
      super(_param, other);
    }
    public pairULLongType() {
    }
    public pairULLongType(/*uint*/long first, T second) {
      super(first, second);
    }
  }
  
  // std::pair<T, short>
  public static class pairTypeShort<T> implements Native.NativePOD<pairTypeShort<T>>, NativeMoveable<pairTypeShort<T>>, Destructors.ClassWithDestructor {

    public T first;
    public /*ushort*/short second;

    public pairTypeShort(JD$Move _param, pairTypeShort other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeShort() {
      this((T)null, (/*ushort*/short)0);
    }

    public pairTypeShort(pairTypeShort<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeShort(T first, /*ushort*/short second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairTypeShort<T> $assign(pairTypeShort<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeShort<T> $assignMove(pairTypeShort<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeShort<T> clone() {
      assert this.getClass() == std.pairTypeShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeShort<T>($tryClone(first), second);
    }

    @Override
    public pairTypeShort<T> move() {
      assert this.getClass() == std.pairTypeShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeShort<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeShort<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeShort<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }    
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeShort.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeShort.class.getSimpleName(), instances);
      return instances;         
    }    
    
  }

  // std::pair<T, ushort>
  public static class pairTypeUShort<T> implements Native.NativePOD<pairTypeUShort<T>>, NativeMoveable<pairTypeUShort<T>>, Destructors.ClassWithDestructor {

    public T first;
    public /*ushort*/char second;

    public pairTypeUShort(JD$Move _param, pairTypeUShort other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeUShort() {
      this((T)null, (/*ushort*/char)0);
    }

    public pairTypeUShort(pairTypeUShort<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUShort(T first, /*ushort*/char second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairTypeUShort<T> $assign(pairTypeUShort<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeUShort<T> $assignMove(pairTypeUShort<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeUShort<T> clone() {
      assert this.getClass() == std.pairTypeUShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUShort<T>($tryClone(first), second);
    }

    @Override
    public pairTypeUShort<T> move() {
      assert this.getClass() == std.pairTypeUShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUShort<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeUShort<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeUShort<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }  
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeUShort.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeUShort.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T*, ushort>
  public static class pairPtrUShort<T/*P*/> extends pairTypeUShort<T> {

    public pairPtrUShort(JD$Move _param, pairTypeUShort other) {
      this((T)other.first, other.second);
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrUShort() {
      this((T)null, (char)0);
    }

    public pairPtrUShort(pairTypeUShort<T/*P*/> other) {
      this((T)other.first, other.second);
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrUShort(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*ushort*/char second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrUShort(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*ushort*/char second) {
      this(first, second);
    }

    public pairPtrUShort(T/*P*/ first, /*ushort*/char second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrUShort(JD$Pair$_U1$_U2 INSTANCE, T first, /*ushort*/char second) {
      this(first, second);
    }

    @Override
    public pairPtrUShort<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrUShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrUShort<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrUShort<T/*P*/> move() {
      assert this.getClass() == std.pairPtrUShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrUShort<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeUShort.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrUShort.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrUShort.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, unsigned>
  public static class pairTypeUInt<T> implements Native.NativePOD<pairTypeUInt<T>>, NativeMoveable<pairTypeUInt<T>>, Destructors.ClassWithDestructor, NativeFoldingSetTrait.NativeProfilable, NativeSwappable {

    public T first;
    public /*uint*/int second;

    public pairTypeUInt(JD$Move _param, pairTypeUInt other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeUInt() {
      this((T)null, 0);
    }

    public pairTypeUInt(pairTypeUInt<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUInt(JD$T$RR_T1$RR _dparam, T first, /*uint*/int second) {
      this.first = (T)first;//$tryMove(null, first, isFirstPointerLike());
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairTypeUInt(JD$T$RR_T1$C$R INSTANCE, T first, /*uint*/int second) {
      this.first = (T)first;//$tryMove(null, first, isFirstPointerLike());
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairTypeUInt(JD$Pair$_U1$_U2 _dparam, pairTypeUInt<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUInt(JD$Pair$_U1$_U2 _dparam, pairTypeBool<T> other) {
      this(other.first, other.second ? 1 : 0);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUInt(JD$Pair$_U1$_U2 INSTANCE, pairTypeULong<T> other) {
      this(other.first, (int)other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUInt(T first, /*uint*/int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairTypeUInt(JD$Pair$_U1$_U2 INSTANCE, pairTypeInt<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUInt(JD$Pair$_U1$_U2 INSTANCE, T first, int second) {
      this(first, second);
    }

    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override
    public pairTypeUInt<T> $assign(pairTypeUInt<T> other) {
      assert this != other;
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeUInt<T> $assignMove(pairTypeUInt<T> other) {
      assert this != other;
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }
    
    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeUInt<T> clone() {
      assert this.getClass() == std.pairTypeUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUInt<T>($tryClone(first), second);
    }

    @Override
    public pairTypeUInt<T> move() {
      assert this.getClass() == std.pairTypeUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUInt<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeUInt<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeUInt<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    @Override
    public final void Profile(NativeFoldingSetTrait.NativeFoldingSetNodeID ID) {
      if (isFirstPointerLike()) {
        ID.AddPointer(this.first);
      } else {
        ((NativeFoldingSetTrait.NativeProfilable)this.first).Profile(ID);
      }
      ID.AddInteger_uint(this.second);
    }

    @Override
    public void swap(NativeSwappable $Prm0) {
      assert this.getClass() == std.pairTypeUInt.class : "must be overridden in derived class" + this.getClass();
      std.pairTypeUInt<T> RHS = (std.pairTypeUInt<T>)$Prm0;
      if (isFirstPointerLike()) {
        T oldFirst = this.first;
        this.first = RHS.first;
        RHS.first = oldFirst;        
      } else {
        std.swap((NativeSwappable)this.first, (NativeSwappable)RHS.first);
      }
      int Tmp = this.second;
      this.second = RHS.second;
      RHS.second = Tmp;
    }
        
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeUInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T*, unsigned>
  public static class pairPtrUInt<T/*P*/> extends pairTypeUInt<T> {

    public pairPtrUInt(JD$Move _param, pairTypeUInt other) {
      this((T)other.first, other.second);
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrUInt() {
      this((T)null, 0);
    }

    public pairPtrUInt(pairTypeUInt<T/*P*/> other) {
      this((T)other.first, other.second);
      assert this.isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrUInt(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*uint*/int second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrUInt(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*uint*/int second) {
      this(first, second);
    }

    public pairPtrUInt(T/*P*/ first, /*uint*/int second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrUInt(JD$Pair$_U1$_U2 INSTANCE, T first, int second) {
      this(first, second);
    }

    @Override
    public pairPtrUInt<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrUInt<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrUInt<T/*P*/> move() {
      assert this.getClass() == std.pairPtrUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrUInt<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeUInt.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrUInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, uint64_t>
  public static class pairTypeULong<T> implements Native.NativePOD<pairTypeULong<T>>, NativeMoveable<pairTypeULong<T>>, Destructors.ClassWithDestructor {

    public T first;
    public /*uint*/long second;

    public pairTypeULong(JD$T$RR_T1$RR _param, T first, long second) {
      this.first = (T)first;//$tryMove(null, first, isFirstPointerLike());
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairTypeULong(JD$Pair$_U1$_U2 _param, pairTypeULong other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairTypeULong(JD$Move _param, pairTypeULong other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeULong(JD$Pair$_U1$_U2 _diff, pairTypeUInt<T> other) {
      this(other.first, $uint2ulong(other.second));
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeULong() {
      this((T)null, 0);
    }

    public pairTypeULong(pairTypeULong<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeULong(T first, /*uint*/long second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairTypeULong<T> $assign(pairTypeULong<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeULong<T> $assignMove(pairTypeULong<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeULong<T> clone() {
      assert this.getClass() == std.pairTypeULong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeULong<T>($tryClone(first), second);
    }

    @Override
    public pairTypeULong<T> move() {
      assert this.getClass() == std.pairTypeULong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeULong<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeULong<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeULong<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    /*friend subclasses*/ static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeULong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeULong.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<T*, uint64>
  public static class pairPtrULong<T/*P*/> extends pairTypeULong<T> {

    public pairPtrULong(JD$Move _param, pairTypeULong other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrULong() {
      this((T)null, 0);
    }

    public pairPtrULong(pairTypeULong<T/*P*/> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrULong(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*ulong*/long second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrULong(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*ulong*/long second) {
      this(first, second);
    }

    public pairPtrULong(T/*P*/ first, /*ulong*/long second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrULong<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrULong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrULong<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrULong<T/*P*/> move() {
      assert this.getClass() == std.pairPtrULong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrULong<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeULong.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrULong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrULong.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, unsigned long long>
  public static class pairTypeULLong<T> implements Native.NativePOD<pairTypeULLong<T>>, NativeMoveable<pairTypeULLong<T>>, Destructors.ClassWithDestructor {

    public T first;
    public /*uint*/long second;

    public pairTypeULLong(JD$Move _param, pairTypeULLong other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeULLong(JD$Pair$_U1$_U2 _param, pairTypeULLong other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairTypeULLong() {
      this((T)null, 0);
    }

    public pairTypeULLong(pairTypeULLong<T> other) {
      this(other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeULLong(T first, /*uint*/long second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairTypeULLong<T> $assign(pairTypeULLong<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeULLong<T> $assignMove(pairTypeULLong<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeULLong<T> clone() {
      assert this.getClass() == std.pairTypeULLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeULLong<T>($tryClone(first), second);
    }

    @Override
    public pairTypeULLong<T> move() {
      assert this.getClass() == std.pairTypeULLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeULLong<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeULLong<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeULLong<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeULLong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeULLong.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<T*, unsigned long long>
  public static class pairPtrULLong<T/*P*/> extends pairTypeULLong {

    public pairPtrULLong(JD$Move _param, pairTypeULLong other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrULLong() {
      this((T)null, 0);
    }

    public pairPtrULLong(pairTypeULLong<T/*P*/> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrULLong(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*ulong*/long second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrULLong(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*ulong*/long second) {
      this(first, second);
    }

    public pairPtrULLong(T/*P*/ first, /*ulong*/long second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrULLong<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrULLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrULLong<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrULLong<T/*P*/> move() {
      assert this.getClass() == std.pairPtrULLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrULLong<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeULLong.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrULLong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrULLong.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, long>
  public static class pairTypeLong<T> implements Native.NativePOD<pairTypeLong<T>>, NativeMoveable<pairTypeLong<T>>, Destructors.ClassWithDestructor {

    public T first;
    public long second;

    public pairTypeLong(pairTypeLong other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeLong(JD$Move _param, pairTypeLong other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeLong() {
      this(null, 0);
    }

    public pairTypeLong(T first, long second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }

    @Override
    public pairTypeLong<T> $assign(pairTypeLong<T> value) {
      this.first = $tryAssign(this.first, value.first, isFirstPointerLike());
      this.second = value.second;
      return this;
    }

    @Override
    public pairTypeLong<T> $assignMove(pairTypeLong<T> value) {
      this.first = $tryMove(this.first, value.first, isFirstPointerLike());
      this.second = value.second;
      return this;
    }

    @Override
    public pairTypeLong<T> clone() {
      assert this.getClass() == std.pairTypeLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeLong($tryClone(first), second);
    }

    @Override
    public pairTypeLong<T> move() {
      assert this.getClass() == std.pairTypeLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeLong($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeLong<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeLong<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }        
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeLong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeLong.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<T*, long>
  public static class pairPtrLong<T/*P*/> extends pairTypeLong {

    public pairPtrLong(JD$Move _param, pairTypeLong other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrLong() {
      this((T)null, 0);
    }

    public pairPtrLong(pairTypeLong<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrLong(JD$T$RR_T1$RR _dparam, T/*P*/ first, long second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrLong(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, long second) {
      this(first, second);
    }

    public pairPtrLong(T/*P*/ first, long second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrLong<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrLong<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrLong<T/*P*/> move() {
      assert this.getClass() == std.pairPtrLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrLong<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeLong.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrLong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrLong.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, uintptr_t>
  public static class pairTypeUIntptr_t<T> implements Native.NativePOD<pairTypeUIntptr_t<T>>, NativeMoveable<pairTypeUIntptr_t<T>>, Destructors.ClassWithDestructor, NativeFoldingSetTrait.NativeProfilable {

    public T first;
    public /*uintptr_t*/Object second;

    public pairTypeUIntptr_t(pairTypeUIntptr_t other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUIntptr_t(JD$Move _param, pairTypeUIntptr_t other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeUIntptr_t() {
      this((T)null, null);
    }

    public pairTypeUIntptr_t(T first, /*uintptr_t*/Object second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeUIntptr_t<T> $assign(pairTypeUIntptr_t<T> value) {
      this.first = $tryAssign(this.first, value.first, isFirstPointerLike());
      this.second = value.second;
      return this;
    }

    @Override
    public pairTypeUIntptr_t<T> $assignMove(pairTypeUIntptr_t<T> value) {
      this.first = $tryMove(this.first, value.first, isFirstPointerLike());
      this.second = value.second;
      return this;
    }

    @Override
    public pairTypeUIntptr_t<T> clone() {
      assert this.getClass() == std.pairTypeUIntptr_t.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUIntptr_t($tryClone(first), second);
    }

    @Override
    public pairTypeUIntptr_t<T> move() {
      assert this.getClass() == std.pairTypeUIntptr_t.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUIntptr_t($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeUIntptr_t<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeUIntptr_t<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
   
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }     
        
    @Override
    public final void Profile(NativeFoldingSetTrait.NativeFoldingSetNodeID ID) {
      if (isFirstPointerLike()) {
        ID.AddPointer(this.first);
      } else {
        ((NativeFoldingSetTrait.NativeProfilable)this.first).Profile(ID);
      }
      ID.AddPointer(this.second);
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeUIntptr_t.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeUIntptr_t.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<T, bool>
  public static class pairTypeBool<T> implements Native.NativePOD<pairTypeBool<T>>, NativeMoveable<pairTypeBool<T>>, Destructors.ClassWithDestructor {

    public T first;
    public boolean second;

    public pairTypeBool(pairTypeBool<?> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairTypeBool(JD$Move _param, pairTypeBool<?> other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeBool(JD$Pair$_U1$_U2 _param, pairTypeBool<?> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairTypeBool() {
      this(null, false);
    }

    public pairTypeBool(JD$T$RR_T1$RR _dparam, T first, boolean second) {
      this.first = (T)first;//$tryMove(null, first, isFirstPointerLike());
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairTypeBool(T first, boolean second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairTypeBool(JD$Pair$_U1$_U2 INSTANCE, T first, boolean second) {
      this(first, second);
    }

    @Override
    public pairTypeBool<T> $assign(std.pairTypeBool<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeBool<T> $assignMove(std.pairTypeBool<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeBool<T> clone() {
      assert this.getClass() == std.pairTypeBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeBool<T>($tryClone(first), second);
    }

    @Override
    public pairTypeBool<T> move() {
      assert this.getClass() == std.pairTypeBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeBool<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeBool<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeBool<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }

    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }         
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeBool.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeBool.class.getSimpleName(), instances);
      return instances;           
    }      
  }

  // std::pair<T*, bool>
  public static class pairPtrBool<T/*P*/> extends pairTypeBool<T> {

    public pairPtrBool(JD$Move _param, pairTypeBool other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrBool() {
      this((T)null, false);
    }

    public pairPtrBool(pairTypeBool<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrBool(JD$T$RR_T1$RR _dparam, T/*P*/ first, boolean second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrBool(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, boolean second) {
      this(first, second);
    }

    public pairPtrBool(T/*P*/ first, boolean second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrBool<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrBool<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeBool.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrBool.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrBool.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, char>
  public static class pairTypeChar<T> implements Native.NativePOD<pairTypeChar<T>>, NativeMoveable<pairTypeChar<T>>, Destructors.ClassWithDestructor {

    public T first;
    public byte second;

    public pairTypeChar(pairTypeChar other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeChar(JD$Move _param, pairTypeChar other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeChar() {
      this(null, (byte) 0);
    }

    public pairTypeChar(T first, byte second) {
      this.first = first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairTypeChar<T> $assign(std.pairTypeChar<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeChar<T> $assignMove(std.pairTypeChar<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + (char) second + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    @Override
    public pairTypeChar<T> clone() {
      assert this.getClass() == std.pairTypeChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeChar<T>($tryClone(first), second);
    }

    @Override
    public pairTypeChar<T> move() {
      assert this.getClass() == std.pairTypeChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeChar<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeChar<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeChar<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }     
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeChar.class.getSimpleName(), instances);
      return instances;           
    }    
  }

  // std::pair<T*, char>
  public static class pairPtrChar<T/*P*/> extends pairTypeChar {

    public pairPtrChar(JD$Move _param, pairTypeChar other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrChar() {
      this((T)null, (byte)0);
    }

    public pairPtrChar(pairTypeChar<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrChar(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*char*/byte second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrChar(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*char*/byte second) {
      this(first, second);
    }

    public pairPtrChar(T/*P*/ first, /*char*/byte second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrChar<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrChar<T/*P*/>((T/*P*/)this.first, this.second);
    }

    @Override
    public pairPtrChar<T/*P*/> move() {
      assert this.getClass() == std.pairPtrChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrChar<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeChar.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrChar.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<T, uchar>
  public static class pairTypeUChar<T> implements Native.NativePOD<pairTypeUChar<T>>, NativeMoveable<pairTypeUChar<T>>, Destructors.ClassWithDestructor {

    public T first;
    public /*uchar*/byte second;

    public pairTypeUChar(pairTypeUChar other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairTypeUChar(JD$Move _param, pairTypeUChar other) {
      this.first = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.first, isFirstPointerLike()) : (T)other.first;
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      assert isFirstPointerLike() == other.isFirstPointerLike();
      this.second = second;
      trackInstance();
    }
    
    public pairTypeUChar() {
      this(null, (/*uchar*/byte) 0);
    }

    public pairTypeUChar(JD$T$RR_T1$RR _dparam, T first, /*uchar*/byte second) {
      this.first = (T)first;//$tryMove(null, first, isFirstPointerLike());
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairTypeUChar(JD$T$RR_T1$RR _dparam, T first, /*uint*/int second) {
      this.first = (T)first;//$tryMove(null, first, isFirstPointerLike());
      assert !isFirstPointerLike() || !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = $uint2uchar(second);
    }

    public pairTypeUChar(T first, /*uchar*/byte second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public pairTypeUChar<T> $assign(std.pairTypeUChar<T> other) {
      this.first = $tryAssign(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public pairTypeUChar<T> $assignMove(std.pairTypeUChar<T> other) {
      this.first = $tryMove(this.first, other.first, isFirstPointerLike());
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + $uchar2uint(second) + '}';
    }

    public type$ref<T> first$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return first;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return first = Native.$tryAssign(first, value, isFirstPointerLike());
        }
      };
    }
    
    public T getFirst() {
      return first;
    }
    
    public /*uchar*/byte getSecond() {
      return second;
    }
    
    @Override
    public pairTypeUChar<T> clone() {
      assert this.getClass() == std.pairTypeUChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUChar<T>($tryClone(first), second);
    }

    @Override
    public pairTypeUChar<T> move() {
      assert this.getClass() == std.pairTypeUChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairTypeUChar<T>($tryMove(first), second);
    }

    @Override
    public boolean $noteq(pairTypeUChar<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairTypeUChar<T> other) {
      return (other != null) && this.second == other.second && Native.$eq(this.first, other.first, isFirstPointerLike());
    }
    
    protected boolean isFirstPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isFirstPointerLike()) {
        Destructors.$destroy(this.first);
      }
    }     
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairTypeUChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairTypeUChar.class.getSimpleName(), instances);
      return instances;           
    }    
  }

  // std::pair<T*, char>
  public static class pairPtrUChar<T/*P*/> extends pairTypeUChar {

    public pairPtrUChar(JD$Move _param, pairTypeUChar other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }
    
    public pairPtrUChar() {
      this((T)null, (byte)0);
    }

    public pairPtrUChar(pairTypeUChar<T> other) {
      this((T)other.first, other.second);
      assert isFirstPointerLike() == other.isFirstPointerLike();
    }

    public pairPtrUChar(JD$T$RR_T1$RR _dparam, T/*P*/ first, /*char*/byte second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    public pairPtrUChar(JD$T$RR_T1$C$R INSTANCE, T/*P*/ first, /*char*/byte second) {
      this(first, second);
    }

    public pairPtrUChar(T/*P*/ first, /*char*/byte second) {
      this.first = first;
      assert !(first instanceof void$ptr) : "unexpected as JavaPtr: " + first.getClass();
      this.second = second;
      trackInstance();
    }

    @Override
    public pairPtrUChar<T/*P*/> clone() {
      assert this.getClass() == std.pairPtrUChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrUChar<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override
    public pairPtrUChar<T/*P*/> move() {
      assert this.getClass() == std.pairPtrUChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairPtrUChar<T/*P*/>((T/*P*/)this.first, this.second);
    }
    
    @Override protected final boolean isFirstPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairTypeUChar.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairPtrUChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairPtrUChar.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<bool, T>
  public static class pairBoolType<T> implements Native.NativePOD<pairBoolType<T>>, NativeMoveable<pairBoolType<T>>, Destructors.ClassWithDestructor {

    public boolean first;
    public T second;

    public pairBoolType(pairBoolType other) {
      this(other.first, (T)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairBoolType(JD$Move _param, pairBoolType other) {
      this.first = other.first;
      this.second = MOVE_IN_PAIR_CTR ? $tryMove(null, (T)other.second, isSecondPointerLike()) : (T)other.second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
      trackInstance();
    }
    
    public pairBoolType() {
      this(false, null);
    }

    public pairBoolType(boolean first, T second) {
      this.first = first;
      this.second = second;
      assert !isSecondPointerLike() || !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public pairBoolType<T> $assign(std.pairBoolType<T> other) {
      this.first = other.first;
      this.second = $tryAssign(this.second, other.second, isSecondPointerLike());
      return this;
    }

    @Override
    public pairBoolType<T> $assignMove(std.pairBoolType<T> other) {
      this.first = other.first;
      this.second = $tryMove(this.second, other.second, isSecondPointerLike());
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    public type$ref<T> second$ref() {
      return new type$ref<T/*&*/>() {
        @Override
        public T /*&*/ $deref() {
          return second;
        }

        @Override
        public T /*&*/ $set(T/*&*/ value) {
          return second = Native.$tryAssign(second, value, isSecondPointerLike());
        }
      };
    }
    
    @Override
    public pairBoolType<T> clone() {
      assert this.getClass() == std.pairBoolType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolType<>(first, $tryClone(second));
    }

    @Override
    public pairBoolType<T> move() {
      assert this.getClass() == std.pairBoolType.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolType<>(first, $tryMove(second));
    }

    @Override
    public boolean $noteq(pairBoolType<T> other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairBoolType<T> other) {
      return (other != null) && this.first == other.first && Native.$eq(this.second, other.second, isSecondPointerLike());
    }
    
    protected boolean isSecondPointerLike() {
      return false;
    }
    
    @Override public void $destroy() {
      if (!isSecondPointerLike()) {
        Destructors.$destroy(this.second);
      }
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairBoolType.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairBoolType.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<bool, T*>
  public static class pairBoolPtr<T/*P*/> extends pairBoolType {

    public pairBoolPtr(JD$Move _param, pairBoolType other) {
      this(other.first, (T/*P*/)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }
    
    public pairBoolPtr() {
      this(false, (T/*P*/)null);
    }

    public pairBoolPtr(pairBoolType<T/*P*/> other) {
      this(other.first, (T/*P*/)other.second);
      assert this.isSecondPointerLike() == other.isSecondPointerLike();
    }

    public pairBoolPtr(JD$T$RR_T1$RR _dparam, boolean first, T/*P*/ second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    public pairBoolPtr(JD$T$RR_T1$C$R INSTANCE, boolean first, T/*P*/ second) {
      this(first, second);
    }

    public pairBoolPtr(boolean first, T/*P*/ second) {
      this.first = first;
      this.second = second;
      assert !(second instanceof void$ptr) : "unexpected as JavaPtr: " + second.getClass();
      trackInstance();
    }

    @Override
    public pairBoolPtr<T/*P*/> clone() {
      assert this.getClass() == std.pairBoolPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolPtr<T>(this.first, (T/*P*/)this.second);
    }
    
    @Override
    public pairBoolPtr<T/*P*/> move() {
      assert this.getClass() == std.pairBoolPtr.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolPtr<T>(this.first, (T/*P*/)this.second);
    }
    
    @Override protected final boolean isSecondPointerLike() {
      return true;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
        pairBoolType.instances--;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairBoolPtr.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairBoolPtr.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<bool, char>
  public static class pairBoolChar implements Native.NativePOD<pairBoolChar>, NativeMoveable<pairBoolChar> {

    public boolean first;
    public byte second;

    public pairBoolChar(pairBoolChar other) {
      this(other.first, other.second);
    }

    public pairBoolChar(JD$Move _param, pairBoolChar other) {
      this(other.first, other.second);
    }
    
    public pairBoolChar() {
      this(false, (byte) 0);
    }

    public pairBoolChar(boolean first, byte second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairBoolChar $assign(std.pairBoolChar other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + (char) second + '}';
    }

    @Override
    public pairBoolChar clone() {
      assert this.getClass() == std.pairBoolChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolChar(first, second);
    }

    @Override
    public pairBoolChar move() {
      assert this.getClass() == std.pairBoolChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolChar(first, second);
    }

    @Override
    public boolean $noteq(pairBoolChar other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairBoolChar other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairBoolChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairBoolChar.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<bool, char>
  public static class pairBoolUInt implements Native.NativePOD<pairBoolUInt>, NativeMoveable<pairBoolUInt> {

    public boolean first;
    public int /*unsigned*/ second;
 
    public pairBoolUInt(pairBoolUInt other) {
      this(other.first, other.second);
    }

    public pairBoolUInt(JD$Move _param, pairBoolUInt other) {
      this(other.first, other.second);
    }

    public pairBoolUInt() {
      this(false, (byte) 0);
    }

    public pairBoolUInt(boolean first, int /*unsigned*/ second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairBoolUInt $assign(pairBoolUInt other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + (char) second + '}';
    }

    @Override
    public pairBoolUInt clone() {
      assert this.getClass() == std.pairBoolUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolUInt(first, second);
    }

    @Override
    public pairBoolUInt move() {
      assert this.getClass() == std.pairBoolUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairBoolUInt(first, second);
    }

    @Override
    public boolean $noteq(pairBoolUInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairBoolUInt other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairBoolUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairBoolUInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<unsinged int, char>
  public static class pairUIntChar implements Native.NativePOD<pairUIntChar>, NativeMoveable<pairUIntChar> {

    public /*uint*/int first;
    public byte second;

    public pairUIntChar(pairUIntChar other) {
      this(other.first, other.second);
    }

    public pairUIntChar(JD$Move _param, pairUIntChar other) {
      this(other.first, other.second);
    }
    
    public pairUIntChar() {
      this(0, (byte) 0);
    }

    public pairUIntChar(/*uint*/int first, byte second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairUIntChar $assign(std.pairUIntChar other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + (char) second + '}';
    }

    @Override
    public pairUIntChar clone() {
      assert this.getClass() == std.pairUIntChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntChar(first, second);
    }

    @Override
    public pairUIntChar move() {
      assert this.getClass() == std.pairUIntChar.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntChar(first, second);
    }

    @Override
    public boolean $noteq(pairUIntChar other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUIntChar other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntChar.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntChar.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<int, bool>
  public static class pairIntBool implements Native.NativePOD<pairIntBool>, NativeMoveable<pairIntBool>  {

    public int first;
    public boolean second;

    public pairIntBool(JD$Move _param, pairIntBool other) {
      this(other.first, other.second);
    }

    public pairIntBool() {
      this(0, false);
    }

    public pairIntBool(pairIntBool other) {
      this(other.first, other.second);
    }

    public pairIntBool(int first, boolean second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairIntBool $assign(pairIntBool value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairIntBool clone() {
      assert this.getClass() == std.pairIntBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntBool(first, second);
    }

    @Override
    public pairIntBool move() {
      assert this.getClass() == std.pairIntBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntBool(first, second);
    }

    @Override
    public boolean $noteq(pairIntBool other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairIntBool other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static void printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairIntBool.class.getSimpleName(), NativeTrace.formatNumber(instances));
    }    
  }

  // std::pair<uint, bool>
  public static class pairUIntBool implements Native.NativePOD<pairUIntBool>, NativeMoveable<pairUIntBool>  {

    public /*uint*/int first;
    public boolean second;

    public pairUIntBool(JD$Move _param, pairUIntBool other) {
      this(other.first, other.second);
    }
    
    public pairUIntBool() {
      this(0, false);
    }

    public pairUIntBool(pairUIntBool other) {
      this(other.first, other.second);
    }

    public pairUIntBool(/*uint*/int first, boolean second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairUIntBool $assign(pairUIntBool value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairUIntBool clone() {
      assert this.getClass() == std.pairUIntBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntBool(first, second);
    }

    @Override
    public pairUIntBool move() {
      assert this.getClass() == std.pairUIntBool.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntBool(first, second);
    }

    @Override
    public boolean $noteq(pairUIntBool other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUIntBool other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntBool.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntBool.class.getSimpleName(), instances);
      return instances;   
    }    
  }

  // std::pair<unsigned, signed>
  public static class pairUIntInt implements Native.NativePOD<pairUIntInt>, NativeMoveable<pairUIntInt> {

    public /*uint*/int first;
    public int second;
    
    public pairUIntInt(pairUIntInt other) {
      this(other.first, other.second);
    }

    public pairUIntInt(JD$Move _param, pairUIntInt other) {
      this(other.first, other.second);
    }

    public pairUIntInt() {
      this(0, 0);
    }

    public pairUIntInt(/*uint*/int first, int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairUIntInt(JD$Pair$_U1$_U2 INSTANCE, int first, int second) {
      this(first, second);
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairUIntInt $assign(pairUIntInt value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairUIntInt clone() {
      assert this.getClass() == std.pairUIntInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntInt(first, second);
    }

    @Override
    public pairUIntInt move() {
      assert this.getClass() == std.pairUIntInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntInt(first, second);
    }

    @Override
    public boolean $noteq(pairUIntInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUIntInt other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<unsigned, unsigned>
  public static class pairUIntUInt implements Native.NativePOD<pairUIntUInt>, NativeMoveable<pairUIntUInt> {

    public /*uint*/int first;
    public /*uint*/int second;
    
    public pairUIntUInt(pairUIntUInt other) {
      this(other.first, other.second);
    }

    public pairUIntUInt(JD$Move _param, pairUIntUInt other) {
      this(other.first, other.second);
    }

    public pairUIntUInt() {
      this(0, 0);
    }

    public pairUIntUInt(/*uint*/int first, /*uint*/int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }
    
    public pairUIntUInt(JD$T$RR_T1$RR _param, /*uint*/int first, /*uint*/int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairUIntUInt(JD$Pair$_U1$_U2 INSTANCE, pairUIntInt other) {
      this(other.first, other.second);
    }

    public pairUIntUInt(JD$T$C$R_T$RR _param, int first, int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairUIntUInt(JD$Pair$_U1$_U2 _param, pairIntInt other) {
      this(other.first, other.second);
    }

    public pairUIntUInt(JD$T$RR_T1$RR INSTANCE, long first, /*uint*/int second) {
      this($ulong2uint(first), second);
    }

    public pairUIntUInt(JD$Pair$_U1$_U2 INSTANCE, /*uint*/int first, /*uint*/int second) {
      this(first, second);
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairUIntUInt $assign(pairUIntUInt value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairUIntUInt clone() {
      assert this.getClass() == std.pairUIntUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntUInt(first, second);
    }

    @Override
    public pairUIntUInt move() {
      assert this.getClass() == std.pairUIntUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntUInt(first, second);
    }

    @Override
    public boolean $noteq(pairUIntUInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUIntUInt other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUIntUInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<uint64_t, short>
  public static class pairULongShort implements Native.NativePOD<pairULongShort>, NativeMoveable<pairULongShort> {

    public /*ulong*/long first;
    public /*uint*/int second;

    public pairULongShort(pairULongShort other) {
      this(other.first, other.second);
    }

    public pairULongShort(JD$Move _param, pairULongShort other) {
      this(other.first, other.second);
    }
    
    public pairULongShort() {
      this(0, 0);
    }

    public pairULongShort(/*ulong*/long first, /*uint*/int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairULongShort $assign(pairULongShort other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }
    
    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairULongShort clone() {
      assert this.getClass() == std.pairULongShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongShort(first, second);
    }

    @Override
    public pairULongShort move() {
      assert this.getClass() == std.pairULongShort.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongShort(first, second);
    }

    @Override
    public boolean $noteq(pairULongShort other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairULongShort other) {
      return (other != null) && this.first == other.first && (this.second == other.second);
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairULongShort.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairULongShort.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<uint64_t, unsigned int>
  public static class pairULongUInt implements Native.NativePOD<pairULongUInt>, NativeMoveable<pairULongUInt> {

    public /*ulong*/long first;
    public /*uint*/int second;

    public pairULongUInt(pairULongUInt other) {
      this(other.first, other.second);
    }

    public pairULongUInt(JD$Move _param, pairULongUInt other) {
      this(other.first, other.second);
    }
    
    public pairULongUInt() {
      this(0, 0);
    }

    public pairULongUInt(/*ulong*/long first, /*uint*/int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairULongUInt $assign(pairULongUInt other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }
    
    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairULongUInt clone() {
      assert this.getClass() == std.pairULongUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongUInt(first, second);
    }

    @Override
    public pairULongUInt move() {
      assert this.getClass() == std.pairULongUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongUInt(first, second);
    }

    @Override
    public boolean $noteq(pairULongUInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairULongUInt other) {
      return (other != null) && this.first == other.first && (this.second == other.second);
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairULongUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairULongUInt.class.getSimpleName(), instances);
      return instances;         
    }    
  }

  // std::pair<unsigned, unsigned>
  public static class pairULongULong implements Native.NativePOD<pairULongULong>, NativeMoveable<pairULongULong> {

    public /*uint*/long first;
    public /*uint*/long second;

    public pairULongULong(pairULongULong other) {
      this(other.first, other.second);
    }

    public pairULongULong(JD$Move _param, pairULongULong other) {
      this(other.first, other.second);
    }
    
    public pairULongULong() {
      this(0, 0);
    }

    public pairULongULong(/*uint*/long first, /*uint*/long second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairULongULong $assign(pairULongULong value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairULongULong clone() {
      assert this.getClass() == std.pairULongULong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongULong(first, second);
    }

    @Override
    public pairULongULong move() {
      assert this.getClass() == std.pairULongULong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairULongULong(first, second);
    }

    @Override
    public boolean $noteq(pairULongULong other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairULongULong other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairULongULong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairULongULong.class.getSimpleName(), instances);
      return instances;
    }
  }

  // std::pair<uint16t, uint32_t>
  public static class pairUShortUInt implements Native.NativePOD<pairUShortUInt>, NativeMoveable<pairUShortUInt> {

    public /*uint16_t*/char first;
    public int/*uint32_t*/ second;

    public pairUShortUInt(pairUShortUInt other) {
      this(other.first, other.second);
    }

    public pairUShortUInt(JD$Move _param, pairUShortUInt other) {
      this(other.first, other.second);
    }
    
    public pairUShortUInt() {
      this((char)0, 0);
    }

    public pairUShortUInt(/*uint16_t*/char first, int/*uint32_t*/ second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairUShortUInt $assign(pairUShortUInt other) {
      this.first = other.first;
      this.second = other.second;
      return this;
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairUShortUInt clone() {
      assert this.getClass() == std.pairUShortUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUShortUInt(first, second);
    }

    @Override
    public pairUShortUInt move() {
      assert this.getClass() == std.pairUShortUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUShortUInt(first, second);
    }

    @Override
    public boolean $noteq(pairUShortUInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUShortUInt other) {
      return (other != null) && this.first == other.first && Native.$eq(this.second, other.second);
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUShortUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairUShortUInt.class.getSimpleName(), instances);
      return instances;           
    }      
  }
  
  // std::pair<int, unsigned>
  public static class pairIntUInt implements Native.NativePOD<pairIntUInt>, NativeMoveable<pairIntUInt> {

    public int first;
    public /*uint*/int second;

    public pairIntUInt(pairIntUInt other) {
      this(other.first, other.second);
    }

    public pairIntUInt(JD$Move _param, pairIntUInt other) {
      this(other.first, other.second);
    }
    
    public pairIntUInt() {
      this(0, 0);
    }

    public pairIntUInt(int first, /*uint*/int second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    public pairIntUInt(long/*int,uint*/ merged) {
      this($first_int(merged), $second_uint(merged));
    }
        
    public long/*int,uint*/$long() {
      return wrap_int_uint_pair(first, second);
    }   
    
    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairIntUInt $assign(pairIntUInt value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    public pairIntUInt $assign(long/*int,uint*/ other) {
      this.first = $first_int(other);
      this.second = $second_uint(other);
      return this;
    }

    public pairIntUInt $assignMove(long/*int,uint*/ other) {
      this.first = $first_int(other);
      this.second = $second_uint(other);
      return this;
    }
    
    @Override
    public pairIntUInt clone() {
      assert this.getClass() == std.pairIntUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntUInt(first, second);
    }
    
    @Override
    public pairIntUInt move() {
      assert this.getClass() == std.pairIntUInt.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntUInt(first, second);
    }

    @Override
    public boolean $noteq(pairIntUInt other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairIntUInt other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    } 
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;
    private static void trackInstance() {
      if (NativeTrace.STATISTICS) instances++;
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairIntUInt.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairIntUInt.class.getSimpleName(), instances);
      return instances;           
    }      
  }

  // std::pair<int, long>
  public static class pairIntLong implements Native.NativePOD<pairIntLong>, NativeMoveable<pairIntLong> {

    public int first;
    public long second;

    public pairIntLong(pairIntLong other) {
      this(other.first, other.second);
    }

    public pairIntLong(JD$Move _param, pairIntLong other) {
      this(other.first, other.second);
    }
    
    public pairIntLong() {
      this(0, 0);
    }

    public pairIntLong(int first, long second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairIntLong $assign(pairIntLong value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairIntLong clone() {
      assert this.getClass() == std.pairIntLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntLong(first, second);
    }

    @Override
    public pairIntLong move() {
      assert this.getClass() == std.pairIntLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairIntLong(first, second);
    }

    @Override
    public boolean $noteq(pairIntLong other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairIntLong other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairIntLong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairIntLong.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  // std::pair<long, long>
  public static class pairLongLong implements Native.NativePOD<pairLongLong>, NativeMoveable<pairLongLong> {

    public long first;
    public long second;

    public pairLongLong(pairLongLong other) {
      this(other.first, other.second);
    }

    public pairLongLong(JD$Move _param, pairLongLong other) {
      this(other.first, other.second);
    }
    
    public pairLongLong() {
      this(0, 0);
    }

    public pairLongLong(long first, long second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }

    @Override
    public pairLongLong $assign(pairLongLong value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairLongLong clone() {
      assert this.getClass() == std.pairLongLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairLongLong(first, second);
    }

    @Override
    public pairLongLong move() {
      assert this.getClass() == std.pairLongLong.class : "must be overridden in derived class" + this.getClass();
      return new std.pairLongLong(first, second);
    }

    @Override
    public boolean $noteq(pairLongLong other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairLongLong other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static long printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairLongLong.class.getSimpleName(), NativeTrace.formatNumber(instances));
      NativeTrace.dumpStatisticValue(pairLongLong.class.getSimpleName(), instances);
      return instances;         
    }    
  }
  
  public static class pairUIntRefUIntRef implements Native.NativePOD<pairUIntRefUIntRef>, NativeMoveable<pairUIntRefUIntRef> {

    public uint$ref first;
    public uint$ref second;

    public pairUIntRefUIntRef(pairUIntRefUIntRef other) {
      this(other.first, other.second);
    }

    public pairUIntRefUIntRef(JD$Move _param, pairUIntRefUIntRef other) {
      this(other.first, other.second);
    }
    
    public pairUIntRefUIntRef(uint$ref first, uint$ref second) {
      this.first = first;
      this.second = second;
      trackInstance();
    }

    @Override
    public String toString() {
      return "{" + first + "|" + second + '}';
    }
    
    public pairUIntRefUIntRef $assign(pairUIntUInt value) {
      this.first.$set(value.first);
      this.second.$set(value.second);
      return this;
    }
    
    @Override
    public pairUIntRefUIntRef $assign(pairUIntRefUIntRef value) {
      this.first = value.first;
      this.second = value.second;
      return this;
    }

    @Override
    public pairUIntRefUIntRef clone() {
      assert this.getClass() == std.pairUIntRefUIntRef.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntRefUIntRef(first, second);
    }

    @Override
    public pairUIntRefUIntRef move() {
      assert this.getClass() == std.pairUIntRefUIntRef.class : "must be overridden in derived class" + this.getClass();
      return new std.pairUIntRefUIntRef(first, second);
    }

    @Override
    public boolean $noteq(pairUIntRefUIntRef other) {
      return !$eq(other);
    }

    @Override
    public boolean $eq(pairUIntRefUIntRef other) {
      return (other != null) && this.first == other.first && this.second == other.second;
    }

    //////////////////////////////////////////////////////////////////////////////
    // Performance Statistics
    private static long instances = 0;

    private static void trackInstance() {
      if (NativeTrace.STATISTICS) {
        instances++;
      }
    }

    public static void clearStatistics() {
      instances = 0;
    }

    public static void printStatistics(java.io.PrintWriter out) {
      out.printf("%22s created:\t%s%n", pairUIntRefUIntRef.class.getSimpleName(), NativeTrace.formatNumber(instances));
    }    
  }
  
}
