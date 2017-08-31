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

import org.clank.java.std;
import org.clank.support.aliases.*;

/**
 *
 * @author vvoskres
 */
public class NativeCallback {

  @FunctionalInterface
  public interface Obj2T<T> {
    T $call(Object param);
  }
  
  // T* (Ctor)();
  @FunctionalInterface
  public interface ConstructorCallback<T> {
    T $call();
  }
  // T* (Ctor)(const T&);
  @FunctionalInterface
  public interface Copy$ConstructorCallback<T> {
    T $call(T other);
  }
  // T* (Ctor)(); used by $new operators
  @FunctionalInterface
  public interface New$ConstructorCallback<T> {
    T $call(type$ptr<?> Mem);
  }

  // T* (Ctor)();
  @FunctionalInterface
  public interface UniquePtrConstructorCallback<T> {
    std.unique_ptr<T> $call();
  }
  
  // void (Dtor)(T*);
  @FunctionalInterface
  public interface DestructorCallback<T> {
    void $call(T toDelete);
  }

  @FunctionalInterface
  public static interface Converter<F, T> {
    default Class<T> getToClass() { throw new UnsupportedOperationException(); }
    T $call (F from); 
  }

  @FunctionalInterface
  public static interface AssignIterator<Src, Dest> {
    void $call(type$iterator<?, ? extends Src> source, type$iterator<?, Dest> to);
  }

  @FunctionalInterface
  public interface Void2String {
    String $call();
  }
  
  /**
   * <T> ReturnType (*Fn)() functions
   */
  @FunctionalInterface
  public interface Void2RetType<ReturnType> {
    public ReturnType $call();
  }
  /**
   * <T> ReturnType (* )(ArgType1)
   */
  @FunctionalInterface
  public interface Type2RetType<ArgType, ReturnType> {
    public ReturnType $call(ArgType arg);
  }
  // ReturnType (* )(ArgType1, ArgType2)
  @FunctionalInterface
  public interface TwoTypes2RetType<ArgType1, ArgType2, ReturnType> {
    public ReturnType $call(ArgType1 arg1, ArgType2 arg2);
  }
  
  /**
   * void (*Fn)() functions
   */
  @FunctionalInterface
  public interface Void2Void {
    public void $call();
  }

  @FunctionalInterface
  public static interface VoidPtr2Bool extends BoolPredicate<Object/*void P*/> {
    boolean $call(Object/*void P*/  P1);
  }
  
  /**
   * void (*Fn)(void*) functions
   */
  @FunctionalInterface
  public interface VoidPtr2Void {
    public void $call(Object/*void P*/ param);
  }
  private static final class VoidPtr2Void$NoOp implements VoidPtr2Void, NativeCloneable<VoidPtr2Void$NoOp> {

    @Override public void $call(Object/*void P*/ param) {      
    }
    @Override public VoidPtr2Void$NoOp clone() {
      return new VoidPtr2Void$NoOp();
    }
  }
  public static final VoidPtr2Void VoidPtr2Void$Default = new VoidPtr2Void$NoOp();
  
  /**
   * <T> void (* )(Type)
   */
  @FunctionalInterface
  public interface Type2Void<ArgType> {
    public void $call(ArgType arg);
  }
  
  /**
   * <T> void* (* )(Type)
   */
  @FunctionalInterface
  public interface Type2VoidPtr<ArgType> {
    public Object/*void P*/ $call(ArgType arg);
  }
  
  @FunctionalInterface
  public interface Type2Int<ArgType> {
    public int $call(ArgType arg);
  }
  
  /**
   * <T> void (* )(Type1, Type2)
   */
  @FunctionalInterface
  public interface TypeType2Void<Tp1, Tp2> {
    public void $call(Tp1 arg1, Tp2 arg2);
  }
  
  @FunctionalInterface
  public interface TypeType2Type<Tp1, Tp2, T3> {
    public T3 $call(Tp1 arg1, Tp2 arg2);
  }

  /**
   * <T> void (* )(Type1, uint)
   */
  @FunctionalInterface
  public interface TypeUInt2Void<Tp> {
    public void $call(Tp arg1, /*uint*/int arg2);
  }
  
  /**
   * <T> void (* )(Type1, bool)
   */
  @FunctionalInterface
  public interface TypeBool2Void<Tp> {
    public void $call(Tp arg1, boolean arg2);
  }
  
  /**
   * <T> void (* )(Type1, Type2)
   */
  @FunctionalInterface
  public interface UIntType2Void<Tp> {
    public void $call(/*uint*/int arg1, Tp arg2);
  }
  
  /**
   * void (* )(const char * ) functions
   */
  @FunctionalInterface
  public interface ConstCharPtr2Void {
    public void $call(char$ptr param);
  }
  
  /**
   * bool (*)(T t1, T t2)
   */
  @FunctionalInterface
  public interface Type2Type<T> {
    public T $call(T a);
  }
  
  @FunctionalInterface
  public interface Type2UInt<T> {
    public /*uint*/int $call(T a);
  }
  
  /**
   * bool (*)(T t1, T t2)
   */
  @FunctionalInterface
  public interface TypeType2Bool<T> {
    public boolean $call(T a, T b);
  }
  
  /**
   * bool (*)(T1 t1, T2 t2)
   */
  @FunctionalInterface
  public interface TwoTypes2Bool<T1, T2> {
    public boolean $call(T1 a, T2 b);
  }
  
  /**
   * bool (*)(T1 t1, T2 t2, T3 t3)
   */
  @FunctionalInterface
  public interface ThreeTypes2Bool<T1, T2, T3> {
    public boolean $call(T1 a, T2 b, T3 c);
  }
  
  /**
   * bool (*Fn)(char) functions
   */
  @FunctionalInterface
  public interface CharBoolPredicate {
    public boolean $call(/*char*/byte param);
  }
  
  /**
   * bool (*Fn)(bool) functions
   */
  @FunctionalInterface
  public interface Bool2Bool {
    public boolean $call(boolean param);
  }
  
  /**
   * bool (*Fn)(T) functions
   */
  @FunctionalInterface
  public interface BoolPredicate<T> {
    public boolean $call(T param);
  }
    
  /**
   * bool (*Fn)(uchar) functions
   */
  @FunctionalInterface
  public interface UCharBoolPredicate {
    public boolean $call(/*uchar*/byte param);
  }
  
  /**
   * bool (*Fn)(ushort) functions
   */
  @FunctionalInterface
  public interface UShortBoolPredicate {
    public boolean $call(/*ushort*/char param);
  }
  
  /**
   * bool (*Fn)(short) functions
   */
  @FunctionalInterface
  public interface ShortBoolPredicate {
    public boolean $call(short param);
  }

  /**
   * bool (*Fn)(uint) functions
   */
  @FunctionalInterface
  public interface UIntBoolPredicate {
    public boolean $call(/*uint*/int param);
  }
  
  /**
   * bool (*Fn)(uint,uint) functions
   */
  @FunctionalInterface
  public interface UIntUIntBoolPredicate {
    public boolean $call(/*uint*/int param1, /*uint*/int param2);
  }
  
  /**
   * bool (*Fn)(int) functions
   */
  @FunctionalInterface
  public interface IntBoolPredicate {
    public boolean $call(/*int*/int param);
  }
  
  /**
   * bool (*Fn)(long) functions
   */
  @FunctionalInterface
  public interface LongBoolPredicate {
    public boolean $call(long param);
  }
  
  /**
   * bool (*Fn)(ulong) functions
   */
  @FunctionalInterface
  public interface ULongBoolPredicate {
    public boolean $call(/*ulong*/long param);
  }
  
  /**
   * bool (*Fn)(double) functions
   */
  @FunctionalInterface
  public interface DoubleBoolPredicate {
    public boolean $call(double param);
  }
  
  /**
   * bool (*Fn)(float) functions
   */
  @FunctionalInterface
  public interface FloatBoolPredicate {
    public boolean $call(float param);
  }
  
  /**
   * bool (*)()
   */
  @FunctionalInterface
  public interface VoidBoolPredicate {
    public boolean $call();
  }

  /**
   * char (*Fn)(char) functions
   */  
  @FunctionalInterface
  public interface Char2Char {
    public /*char*/byte $call(/*char*/byte in);
  }
  
  /**
   * char (*Fn)(int) functions
   */  
  @FunctionalInterface
  public interface Int2Char {
    public /*char*/byte $call(int in);
  }
  
  /**
   * void (*Fn)(char) functions
   */  
  @FunctionalInterface
  public interface Char2Void {
    public void $call(/*char*/byte ini);
  }
  
  /**
   * void (*Fn)(int) functions
   */
  @FunctionalInterface
  public interface Int2Void {
    public void $call(int in);
  }
  
  /**
   * void (*Fn)(uint) functions
   */
  @FunctionalInterface
  public interface UInt2Void {
    public void $call(/*uint*/int uint);
  }
  
  /**
   * void (*Fn)(long) functions
   */
  @FunctionalInterface
  public interface Long2Void {
    public void $call(long in);
  }
  
  /**
   * void (*Fn)(bool) functions
   */
  @FunctionalInterface
  public interface Bool2Void {
    public void $call(boolean in);
  }
  private static final class Bool2Void$NoOp implements Bool2Void, NativeCloneable<Bool2Void$NoOp> {

    @Override public void $call(boolean in) {      
    }
    @Override public Bool2Void$NoOp clone() {
      return new Bool2Void$NoOp();
    }
  }
  public static final Bool2Void Bool2Void$Default = new Bool2Void$NoOp();
  
  /**
   * void (*Fn)(int) functions
   */
  @FunctionalInterface
  public interface T2Void<T> {
    public void $call(T in);
  }
  
  /**
   * T (*Fn)(int) functions
   */
  @FunctionalInterface
  public interface Int2Type<T> {
    public T $call(int in);
  }

//  
//  /**
//   * typedef void (*unspecified_bool_type)();
//   * 
//   * static void unspecified_bool_true() {}
//   * 
//   * operator unspecified_bool_type() const { // true if error
//   *  return _val_ == 0 ? 0 : unspecified_bool_true;
//   * }
//   */
//  public interface unspecified_bool_type {
//    
//  }
  
  public static final Void2Void unspecified_bool_true  = new Void2Void() {

    @Override
    public String toString() {
      return "unspecified_bool_true";
    }

    @Override
    public void $call() {
      throw new UnsupportedOperationException();
    }
  };
  
  /**
   * little endian byte-stream presentation converter.
   * @param <T> 
   */
  @FunctionalInterface
  public static interface Object2BinaryStreamConverter<T> {
    /*char*/byte char$at(int index, T obj);
  }
}
