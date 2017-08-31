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
import java.util.Comparator;
import org.clank.java.std;
import org.clank.java.std_functional.binary_functionArgArg2Bool;
import org.clank.support.NativeCallback.Converter;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;

/**
 *
 * @author vvoskres
 */
public final class Native {

  public static boolean $bitand(long Ptr, int i) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static interface NativeUnsignedTypeMarker { }
  public static boolean isKnownUnsignedType(Class<?> cls) {
    boolean out = NativeUnsignedTypeMarker.class.isAssignableFrom(cls);
    assert !out || !NativeSignedTypeMarker.class.isAssignableFrom(cls) : "can not be signed and unsigned";
    return out;
  }

  public static interface NativeSignedTypeMarker { }
  public static boolean isKnownSignedType(Class<?> cls) {
    boolean out = NativeSignedTypeMarker.class.isAssignableFrom(cls);
    assert !out || !NativeUnsignedTypeMarker.class.isAssignableFrom(cls) : "can not be signed and unsigned";
    return out;
  }
  
  public static interface NativeUIntEnum extends Native.ComparableLower, NativeUnsignedTypeMarker {
    public /*uint*/int getValue();
    @Override public default boolean $less(Object obj) { return Unsigned.$less_uint(getValue(), ((NativeUIntEnum)obj).getValue());}
    @Override public default boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(getValue(), ((NativeUIntEnum)obj).getValue());}
  }
  
  public static interface NativeIntEnum extends Native.ComparableLower, NativeSignedTypeMarker {
    public int getValue();
    @Override public default boolean $less(Object obj) { return Unsigned.$less_int(getValue(), ((NativeIntEnum)obj).getValue());}
    @Override public default boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(getValue(), ((NativeIntEnum)obj).getValue());}
  }
  
  public static interface NativeUShortEnum extends Native.ComparableLower, NativeUnsignedTypeMarker {
    public /*ushort*/char getValue();
    @Override public default boolean $less(Object obj) { return Unsigned.$less_ushort(getValue(), ((NativeUShortEnum)obj).getValue());}
    @Override public default boolean $lesseq(Object obj) { return Unsigned.$lesseq_ushort(getValue(), ((NativeUShortEnum)obj).getValue());}
  }
  
  public static interface NativeUCharEnum extends Native.ComparableLower, NativeUnsignedTypeMarker {
    public /*uchar*/byte getValue();
    @Override public default boolean $less(Object obj) { return Unsigned.$less_uchar(getValue(), ((NativeUCharEnum)obj).getValue());}
    @Override public default boolean $lesseq(Object obj) { return Unsigned.$lesseq_uchar(getValue(), ((NativeUCharEnum)obj).getValue());}
  }

  public static interface NativeCharEnum extends NativeSignedTypeMarker {
    public /*char*/byte getValue();
  }

  public static interface NativeBoolEnum extends NativeUnsignedTypeMarker {
    public /*bool*/boolean getValue();
  }

  public static interface ComparatorLower<LHS, RHS> extends binary_functionArgArg2Bool<LHS, RHS> {
    boolean $less(LHS one, RHS other);

    @Override
    public default boolean $call(LHS arg1, RHS arg2) {
      return $less(arg1, arg2);
    }
  }

  public static <LHS, RHS> ComparatorLower<LHS, RHS> ComparatorLower(NativeCallback.TwoTypes2Bool<LHS, RHS> comparator) {
    return new ComparatorLower<LHS, RHS>() {
      @Override
      public boolean $less(LHS one, RHS other) {
        return comparator.$call(one, other);
      }
    };
  }

  public static interface NativeComparable<T> {
    default boolean $noteq(T other) { return !$eq(other); }
    default boolean $eq(T other) { throw new UnsupportedOperationException("Not yet implemented in " + this.getClass()); }
  }
  
  public static interface Native$Bool {
    default boolean $bool() { return !$not(); }
    default boolean $not() { return !$bool(); }
  }
  
  public static interface OpCapable {
    enum Op {
      EQ,
      LESS,
      LESSEQ,
      GREATER,
      GREATEREQ
    }
    
    Boolean $op(Op k, Object obj);
  }
  
  public static interface ComparableLower {
    boolean $less(Object obj); 
    default boolean $lesseq(Object obj) { throw new UnsupportedOperationException(); }
  }
  
  public static interface ComparableGreater {
    boolean $greater(Object obj); 
    default boolean $greatereq(Object obj) { throw new UnsupportedOperationException(); }
  }
  
  public static interface ComparableLowerGreater extends ComparableLower, ComparableGreater {
    // Empty
  }  
  
  /**
   * All classes with begin() and end() methods should implement NativeIterable
   * @param <Iter> 
   */
  public static interface NativeIterable<Iter> {
    /**
     * 
     * @return iterator pointing to the start
     */
    Iter begin();
    default Iter begin$Const() { return begin(); }
    
    /**
     * 
     * @return iterator pointing to the end
     */
    Iter end();
    default Iter end$Const() { return end(); }
  }
  
  
  /**
   * All classes with rbegin() and rend() methods should implement NativeIterable
   * @param <Iter> 
   */
  public static interface NativeReverseIterable<Iter> {
    /**
     * 
     * @return iterator pointing to the start
     */
    Iter rbegin();
    default Iter rbegin$Const() { return rbegin(); }
    
    /**
     * 
     * @return iterator pointing to the end
     */
    Iter rend();
    default Iter rend$Const() { return rend(); }
  }
  
  
  /**
   * Represents object which could change his fields (mutable object).
   * This is only for standard copy-assignment operator owner.
   * Class& operator=(const Class& other) {
   *  ... copy ...
   *  return *this;
   * }
   * Class that implements this interface must extend T
   * 
   * @param <T> should be implementator's class 
   * 
   * Example:
   * class AAA implements assignable<AAA> {};
   */    
  public static interface assignable<T> {

      /**
       * Copies value to itself
       * 
       * @param value 
       */
      T $assign(T value);

      default T $assignMove(T value) {
        return $assign(value);
      }
  }
  
  public static interface NativePOD<T> extends assignable<T>, NativeCloneable<T>, NativeComparable<T> {
    
  }
  
  public static interface NativeHashable {
    
    /*uint*/int $hashcode();
    
  }  
        
  public static final class CharSequenceToCharPtrConverter implements Converter<CharSequence, org.clank.support.aliases.char$ptr> {

    @Override
    public Class<char$ptr> getToClass() {
      return char$ptr.class;
    }

    @Override
    public char$ptr $call(CharSequence from) {
      return create_char$ptr(from);
    }
    
  }
  
  public static final class CharPtrToStringConverter implements Converter<org.clank.support.aliases.char$ptr, String> {

    @Override
    public Class<String> getToClass() {
      return String.class;
    }

    @Override
    public String $call(char$ptr from) {
      return Native.$toString(from);
    }
    
  }
  
  public static final class CharPtrToCharSequenceConverter implements Converter<org.clank.support.aliases.char$ptr, CharSequence> {

    @Override
    public Class<CharSequence> getToClass() {
      return CharSequence.class;
    }

    @Override
    public CharSequence $call(char$ptr from) {
      return Native.$toString(from);
    }
    
  }
  
  public static <T> T/*P*/ $new_uint_voidPtr(final Object/*void P*/ Mem, NativeCallback.New$ConstructorCallback<T/*P*/> New$Ctr) {
    return New$Ctr.$call((type$ptr<?>)Mem);
  }  
  
  public static JavaCleaner $createJavaCleaner() {
    return JavaCleaner.create();
  }
  
  public static void destroy(boolean val) {
  }

  public static void destroy(byte val) {
  }
  
  public static void destroy(char val) {
  }
  
  public static void destroy(short val) {
  }
  
  public static void destroy(int val) {
  }
  
  public static void destroy(long val) {
  }
  
  public static void destroy(Destructors.ClassWithDestructor obj) {
    obj.$destroy();
    obj.$delete();
  }
  
  public static void destroy(Object obj) {
    if (obj instanceof Destructors.ClassWithDestructor) {
      destroy((Destructors.ClassWithDestructor)obj);
    }
  }
  
  /** 
   * in C++: ::operator delete(p);  
   * That's a conveniency shortcut for Destructors.$delete_voidPtr;
   * it's here because we usually add a static import for Native.* 
   */
  public static <T /*extends Destructors.ClassWithDestructor*/> void $delete_voidPtr(type$ptr<T> p) {
    Destructors.$delete_voidPtr(p);
  }
  
  public static boolean bool$ptr(Object o) {
    assert !(o instanceof void$ptr): "unexpected class " + o.getClass();
    return o != null;
  }
  
  public static boolean bool$ptr(void$ptr o) {
    return $bool(o);
  }
  
  public static boolean $bool(Object o) {
    // some objects have implemented $bool
    if (o instanceof Native$Bool) {
      return ((Native$Bool) o).$bool();
    }
    return o != null;
  }
  public static boolean $not(Object o) {
    return !$bool(o);
  }
    
  public static boolean $bool(Native$Bool o) {
    return o != null && o.$bool();
  }
  public static boolean $not(Native$Bool o) {
    return !$bool(o);
  }
    
  public static boolean $bool(boolean o) {
    return o;
  }
  public static boolean $not(boolean o) {
    return !o;
  }
    
  public static boolean $bool(byte o) {
    return o != 0;
  }
  public static boolean $not(byte o) {
    return o == 0;
  }
    
  public static boolean $bool(char o) {
    return o != 0;
  }
  public static boolean $not(char o) {
    return o == 0;
  }
    
  public static boolean $bool(short o) {
    return o != 0;
  }
  public static boolean $not(short o) {
    return o == 0;
  }
    
  public static boolean $bool(int o) {
    return o != 0;
  }
  public static boolean $not(int o) {
    return o == 0;
  }
    
  public static boolean $bool(long o) {
    return o != 0;
  }
  public static boolean $not(long o) {
    return o == 0;
  }
    
  public static int $hashcode_ptr(Object P) {
    if (P == null) {
      return 0;
    }
    if (P instanceof NativeHashable) {
      return ((NativeHashable)P).$hashcode();
    }
    return System.identityHashCode(P);
  }
    
  public static boolean $eq_ptr(Object primary, Object second) {
    if (primary == second) {
      return true;
    } else if (primary instanceof NativePointerLike) {
      return ((NativePointerLike) primary).$eqPointerLike(second);
    } else if (second instanceof NativePointerLike) {
      return ((NativePointerLike) second).$eqPointerLike(primary);
    } else if (primary instanceof abstract_iterator) {
      return $eq_iter((abstract_iterator)primary, (abstract_iterator)second);
    }    
    assert !isIteratorLikeTypeName(primary) : "All Iterators must be comparable " + primary.getClass();
    assert !isIteratorLikeTypeName(second) : "All Iterators must be comparable " + second.getClass();
    return false;
  }

  public static <T extends void$ptr> boolean $eq_ptr(T primary, T second) {
    if (primary == second) {
      return true;
    }
    if (primary == null) {
      return false;
    }
    return primary.$eq(second);
  }
  
  public static boolean $eq_iter(abstract_iterator primary, abstract_iterator second) {
    return std.$eq___normal_iterator(primary, second);
  }
  
  public static boolean $eq(abstract_iterator primary, abstract_iterator second) {
    throw new AssertionError("must use $eq_iter for iterators");
  }
  
  public static boolean $eq(void$ptr primary, void$ptr second) {
    throw new AssertionError("must use $eq_ptr for pointers");
  }
  
  public static boolean $eq(Object primary, Object second) {
    assert !(primary instanceof void$ptr && second instanceof void$ptr) : "must use $eq_ptr for pointers";
    assert !(primary instanceof abstract_iterator && second instanceof abstract_iterator) : "must use $eq_iter for iterators";
    return $eq(primary, second, false);
  }
  
  public static boolean $eq(Object primary, Object second, boolean isDataPointerLike) {
    if (isDataPointerLike) {
      assert !(primary instanceof void$ptr) || !(second instanceof void$ptr): "Real pointers should not be considered as 'pointer like'! use $eq_ptr instead";
      assert !(primary instanceof abstract_iterator) || !(second instanceof abstract_iterator): "Real iterators should not be considered as 'pointer like'! use $noteq_iter instead";
      return primary == second;
    } else {
      if (primary == second) {
        return true;
      }
      if (primary instanceof OpCapable) {
        Boolean res = ((OpCapable) primary).$op(OpCapable.Op.EQ, second);
        if (res != null) {
          return res;
        }
      }
      if (second instanceof OpCapable) {
        Boolean res = ((OpCapable) second).$op(OpCapable.Op.EQ, primary);
        if (res != null) {
          return res;
        }
      }    
      // be sure equals is implemented using $eq when operator== is overloaded
      if (primary instanceof NativeComparable) {
        return ((NativeComparable) primary).$eq(second);
      }    
      if (second instanceof NativeComparable) {
        return ((NativeComparable) second).$eq(primary);
      }
      // this should be after above calls, because some comparable implementations
      // are ready to be compared to null as "true"
      if (primary == null || second == null) {
        return false;
      }    
      
      assert primary.getClass().isAssignableFrom(second.getClass()) 
              || second.getClass().isAssignableFrom(primary.getClass()) : "Forgot to call conversion operator?";
      
      // be sure equals is implemented using $eq when operator== is overloaded
      return primary.equals(second);
    }
  }
  
  public static boolean $eq(byte primary, byte second) {
    return primary == second;
  }
  
  public static boolean $eq(byte primary, byte second, boolean isDataPointerLike) {
    return primary == second;
  }
  
  public static boolean $eq(char primary, char second) {
    return primary == second;
  }
  
  public static boolean $eq(char primary, /*uchar*/byte second) {
    return primary == (0xFF & second);
  }
  
  public static boolean $eq(char primary, char second, boolean isDataPointerLike) {
    return primary == second;
  }
  
  public static boolean $eq(short primary, short second) {
    return primary == second;
  }
  
    public static boolean $eq(short primary, short second, boolean isDataPointerLike) {
    return primary == second;
  }

  public static boolean $eq(int primary, int second) {
    return primary == second;
  }
  
    public static boolean $eq(int primary, int second, boolean isDataPointerLike) {
    return primary == second;
  }
  
  public static boolean $eq(long primary, long second) {
    return primary == second;
  }  
  
  public static boolean $eq(long primary, long second, boolean isDataPointerLike) {
    return primary == second;
  }  
  
  public static boolean $eq(boolean primary, boolean second) {
    return primary == second;
  }
  
  public static boolean $eq(boolean primary, boolean second, boolean isDataPointerLike) {
    return primary == second;
  }
  
  public static boolean $less$JavaRef(Object LHS, Object RHS) {
    // emulate compare of native pointers which are java references using identity hash codes
    assert !(LHS instanceof void$ptr) : "must not be used for pointers";
    assert !(RHS instanceof void$ptr) : "must not be used for pointers";
    if (LHS == RHS) return false;
    int L = System.identityHashCode(LHS);
    int R = System.identityHashCode(RHS);
    if (L == R) {
      throw new IllegalStateException("Don't support such compare yet, need weak-ref based global indexer to resolve collisions");
    }
    return L < R;
  }
  
  public static int compare$JavaRef(Object LHS, Object RHS) {
    // emulate compare of native pointers which are java references using identity hash codes
    assert !(LHS instanceof void$ptr) : "must not be used for pointers";
    assert !(RHS instanceof void$ptr) : "must not be used for pointers";
    if (LHS == RHS) return 0;
    int L = System.identityHashCode(LHS);
    int R = System.identityHashCode(RHS);
    if (L == R) {
      throw new IllegalStateException("Don't support such compare yet, need weak-ref based global indexer to resolve collisions");
    }
    return L < R ? -1 : 1;
  }
  
  public static int compare$less$Objects(Object LHS, Object RHS) {
    // emulate compare of native pointers which are java references using identity hash codes
    assert !(LHS instanceof void$ptr) : "must not be used for pointers";
    assert !(RHS instanceof void$ptr) : "must not be used for pointers";
    if (LHS == RHS) return 0;
    if (Native.$less(LHS, RHS)) {
      return -1;
    } else if (Native.$less(RHS, LHS)) {
      return 1;
    }    
    return 0;
  }
          
  public static <T> java.util.Comparator<T> Comparator$JavaRef() {
    return Native::compare$JavaRef;
  }
  
  public static boolean $less(ComparableLower primary, ComparableLower second) {
    return primary.$less(second);
  }
  
  public static boolean $less(Object primary, Object second) {
    if (primary == second) {
      return false;
    }
    if (primary instanceof OpCapable) {
      // primary < second
      Boolean res = ((OpCapable) primary).$op(OpCapable.Op.LESS, second);
      if (res != null) {
        return res;
      }
    }
    if (second instanceof OpCapable) {
      // primary < second <=> second > primary
      Boolean res = ((OpCapable) second).$op(OpCapable.Op.GREATER, primary);
      if (res != null) {
        return res;
      }
    }    
    if (primary instanceof Comparable && primary.getClass().isInstance(second)) {
      return ((Comparable) primary).compareTo(second) < 0;
    }
    if (second instanceof Comparable && second.getClass().isInstance(primary)) {
      return ((Comparable) second).compareTo(primary) > 0;
    }
    if (primary instanceof ComparableLower && primary.getClass().isInstance(second)) {
      return ((ComparableLower) primary).$less(second);
    }
    if (primary instanceof Number && second instanceof Number) {
      return ((Number)primary).longValue() < ((Number)second).longValue();
    }
    // this should be after above calls, because some comparable implementations
    // are ready to be compared to null as "true"
    if (primary == null || second == null) {
      return false;
    }
    throw new AssertionError("not implementing ComparableLower/Comparable/OpCapable for LESS? for " + 
            NativeTrace.getIdentityStr(primary) + " vs. " + NativeTrace.getIdentityStr(second));
  }
  
  public static boolean $lesseq(Object first, Object second) {
    throw new UnsupportedOperationException("Not implemented yet!");
  }
  
  public static boolean $lesseq_ptr(void$ptr first, void$ptr second) {
    return first.$lesseq(second);
  }
  
  public static boolean $greater(Object first, Object second) {
    throw new UnsupportedOperationException("Not implemented yet!");
  }
  
  public static boolean $greatereq(Object first, Object second) {
    throw new UnsupportedOperationException("Not implemented yet!");
  }
  
  public static boolean $greatereq_ptr(void$ptr first, void$ptr second) {
    return first.$greatereq(second);
  }
  
  public static boolean $noteq_ptr(Object primary, Object second) {
    return !$eq_ptr(primary, second);
  }
  
  public static boolean $noteq_ptr(void$ptr primary, void$ptr second) {
    return !$eq_ptr(primary, second);
  }
  
  public static boolean $noteq_iter(abstract_iterator primary, abstract_iterator second) {
    return !$eq_iter(primary, second);
  }
  
  public static boolean $noteq(abstract_iterator primary, abstract_iterator second) {
    throw new AssertionError("must use $noteq_iter for iterators:" + NativeTrace.getIdentityStr(primary));
  }
  
  public static boolean $noteq(void$ptr primary, void$ptr second) {
    throw new AssertionError("must use $noteq_ptr for pointers:" + NativeTrace.getIdentityStr(primary));
  }
  
  public static boolean $noteq(Object primary, Object second) {
    assert !(primary instanceof void$ptr && second instanceof void$ptr) : "must use $noteq_ptr for pointers:"  + NativeTrace.getIdentityStr(primary);
    assert !(primary instanceof abstract_iterator && second instanceof abstract_iterator) : "must use $noteq_iter for iterators: " + NativeTrace.getIdentityStr(primary);
    return $noteq(primary, second, false);
  }
  
  public static boolean $noteq(Object primary, Object second, boolean isPointerLike) {
    if (isPointerLike) {
      assert !(primary instanceof void$ptr) || !(second instanceof void$ptr): "Real pointers should not be considered as 'pointer like'! use $noteq_ptr instead: "  + NativeTrace.getIdentityStr(primary);
      assert !(primary instanceof abstract_iterator) || !(second instanceof abstract_iterator): "Real iterators should not be considered as 'pointer like'! use $noteq_iter instead:" + NativeTrace.getIdentityStr(primary);
      return primary != second;
    } else {
      if (primary == second) {
        return false;
      }
      // be sure equals is implemented using $eq when operator== is overloaded
      if (primary instanceof NativeComparable) {
        return ((NativeComparable)primary).$noteq(second);
      }
      if (second instanceof NativeComparable) {
        return ((NativeComparable) second).$noteq(primary);
      }
      // this should be after above calls, because some comparable implementations
      // are ready to be compared to null as "true"
      if (primary == null || second == null) {
        return true;
      }
      return !primary.equals(second);
    }
  }
  
  public static boolean $noteq(byte primary, byte second) {
    return primary != second;
  }
  
  public static boolean $noteq(byte primary, byte second, boolean isPointerLike) {
    return primary != second;
  }
  
  public static boolean $noteq(char primary, char second) {
    return primary != second;
  }
  
  public static boolean $noteq(char primary, char second, boolean isPointerLike) {
    return primary != second;
  }
  
  public static boolean $noteq(int primary, int second) {
    return primary != second;
  }
  
  public static boolean $noteq(int primary, int second, boolean isPointerLike) {
    return primary != second;
  }
  
  public static boolean $noteq(long primary, long second) {
    return primary != second;
  }  
  
  public static boolean $noteq(long primary, long second, boolean isPointerLike) {
    return primary != second;
  }  
  
  public static boolean $noteq(boolean primary, boolean second) {
    return primary != second;
  }
  
  public static boolean $noteq(boolean primary, boolean second, boolean isPointerLike) {
    return primary != second;
  }
  
  public static boolean $less(int first, int second) {
    return first < second;
  }  
  
  public static boolean $lesseq(int first, int second) {
    return first <= second;
  }
  
  public static boolean $greater(int first, int second) {
    return first > second;
  }
  
  public static boolean $greatereq(int first, int second) {
    return first >= second;
  }
  
  public static boolean $less(long first, long second) {
    return first < second;
  }  
  
  public static boolean $lesseq(long first, long second) {
    return first <= second;
  }
  
  public static boolean $greater(long first, long second) {
    return first > second;
  }
  
  public static boolean $greatereq(long first, long second) {
    return first >= second;
  }
  
  /**
   * Performs assign operation (a = b) in a proper way.
   * 
   * <T>
   * @param dst - destination
   * @param src - source
   * @param isPointerLike - if T in c++ was pointer and is object in java, then true.
   *                         Usually isPointerlike depends on passed default value into collection.
   * 
   * @return value that must be assigned to destination field.
   */
  public static <T> T $tryAssign(T dst, T src, boolean isPointerLike) {
    if (isPointerLike) {
      if (src instanceof NativePointerLike) {
        // continue below like value
      } else if (dst instanceof NativePointerLike) {
        // continue below like value
      } else {
        return src;
      }
    }
    if (dst instanceof assignable) {
      ((assignable) dst).$assign(src);
      return dst;
    }
    return $tryClone(src);
  }

  public static <T> T $tryMoveStrong(T dst, T src, boolean isPointerLike) {
    assert !isPointerLike;
    if (dst instanceof assignable) {
      ((assignable) dst).$assignMove(src);
      return dst;
    }
    assert src instanceof NativeMoveable : "expected NativeMoveable " + NativeTrace.getIdentityStr(src);
    return (T)$Move((NativeMoveable<?>)src);
  }

  public static <T> T $tryMove(T dst, T src, boolean isPointerLike) {
    if (isPointerLike) {
      if (src instanceof NativePointerLike) {
        // continue below like 'value'
      } else if (dst instanceof NativePointerLike) {
        // continue below like 'value'
      } else {
        return src;
      }
    }
    if (dst instanceof assignable) {
      ((assignable) dst).$assignMove(src);
      return dst;
    }
    return $tryMove(src);
  }

  public static uchar$ptr $tryClone(uchar$ptr t) {
    if (t == null) {
      return null;
    }
    uchar$ptr out = t.clone();
    assert out.getClass() == t.getClass() : "INVALID clone! Was " + t.getClass() + " became " + out.getClass();
    assert out.$eq(t) : "INVALID $eq in " + t.getClass();
    return out;
  }

  public static char$ptr $tryClone(char$ptr t) {
    if (t == null) {
      return null;
    }
    char$ptr out = t.clone();
    assert out.getClass() == t.getClass() : "INVALID clone! Was " + t.getClass() + " became " + out.getClass();
    assert out.$eq(t) : "INVALID $eq in " + t.getClass();
    return out;
  }
  
  public static int $ptr_index(char$ptr ptr) {
    return ptr != null ? ptr.$index() : 0;
  }
  
  public static int $ptr_index(int$ptr ptr) {
    return ptr != null ? ptr.$index() : 0;
  }
  
  public static int $ptr_index(type$ptr ptr) {
    return ptr != null ? ptr.$index() : 0;
  }
  
  public static int $sub_ptr(char$ptr first, char$ptr second) {
    return first == second ? 0 : first.$sub(second);
  }
  
  public static int $sub_ptr(int$ptr first, int$ptr second) {
    return first == second ? 0 : first.$sub(second);
  }
  
  public static int $sub_ptr(type$ptr first, type$ptr second) {
    return first == second ? 0 : first.$sub(second);
  }
  
  public static <T> type$ptr<T> $add(type$ptr<T> ptr, int val) {
    return val != 0 ? ptr.$add(val) : $tryClone(ptr);
  }

  public static <T> type$iterator<?, T> $add(type$iterator<?, T> ptr, int val) {
    return (val != 0) ? ptr.$add(val) : $tryClone(ptr);
  }

  public static int $add(int lhs, int rhs) {
    return lhs + rhs;
  }
  
  public static void $setIndex(char$ptr ptr, char$ptr orig) {
    assert ptr.isComparableTo(orig) : "ptr has different buffer? " + ptr + " vs. " + orig;
    $setIndex(ptr, orig.$index());
  }

  public static char$ptr $incConstIndex(char$ptr ptr, int amount) {
    ptr = Native.$cleanConst(ptr);
    if (amount!=0) {
      ptr.$inc(amount);
    }
    return Native.$toConst(ptr);
  }

  public static void $setIndex(char$ptr ptr, int index) {
    int cur$index = ptr.$index();
    if (cur$index != index) {
      ptr.$inc(index-cur$index);
    }
    assert ptr.$index() == index;
  }

  public static void $setIndex(int$ptr ptr, int index) {
    int cur$index = ptr.$index();
    if (cur$index != index) {
      ptr.$inc(index-cur$index);
    }
    assert ptr.$index() == index;
  }

  public static void $setIndex(uint$ptr ptr, int index) {
    int cur$index = ptr.$index();
    if (cur$index != index) {
      ptr.$inc(index-cur$index);
    }
    assert ptr.$index() == index;
  }

  public static void $setIndex(type$ptr ptr, int index) {
    int cur$index = ptr.$index();
    if (cur$index != index) {
      ptr.$inc(index-cur$index);
    }
    assert ptr.$index() == index;
  }

  public static void $setArrayAndIndex(type$ptr ptr, Object[] array, int index) {
    assert $is_array_based(ptr);
    ((type$ptr$array)ptr).index = index;
    AliasesAccessor.$setArray((type$ptr$array)ptr, array, index);
  }

  public static void $setArrayAndIndex(char$ptr ptr, byte[] array, int index) {
    assert $is_array_based(ptr);
    ((char$ptr$array)ptr).index = index;
    AliasesAccessor.$setArray((char$ptr$array)ptr, array, index);
  }
  
  public static void $setArrayAndIndex(char$ptr$array ptr, byte[] array, int index) {
    assert $is_array_based(ptr);
    ptr.index = index;
    AliasesAccessor.$setArray(ptr, array, index);
  }

  public static <T extends NativeMoveable<T>> T $tryMove(T t) {
    return $Move(t);
  }

  public static <T> T $tryMove(T t) {
    if (t instanceof NativeMoveable<?>) {
      return (T)$Move((NativeMoveable)t);
    }
    return $tryClone(t);
  }
  public static <T extends NativeMoveable> T $Move(T t) {
    return t == null ? null : (T)t.move();
  }

  public static boolean $tryMove(boolean val) {
    return val;
  }
  
  public static byte $tryMove(byte val) {
    return val;
  }  
  
  public static short $tryMove(short val) {
    return val;
  }    
  
  public static int $tryMove(int val) {
    return val;
  }      
  
  public static long $tryMove(long val) {
    return val;
  }   
  
  public static char $tryMove(char val) {
    return val;
  }

  private static <T> boolean assertEqualAfterClone(T val, T copy) {
    //!(val instanceof NativeComparable) || ((NativeComparable<T>)copy).$eq(val) : "INVALID $eq in " + val.getClass();
    if (val instanceof NativeComparable) {
      if (val instanceof abstract_iterator || val.getClass().getSimpleName().contains(/*i*/"terator")) {
        boolean res = ((NativeComparable<T>)copy).$eq(val);
        //assert res : "INVALID $eq in class " + val.getClass();
        if (!res) {
          res = ((NativeComparable<T>)copy).$eq(val);
        }      
        assert res : "INVALID $eq in class " + val.getClass();
      }
    }
    return true;
  }
  
  public static <T extends NativeCloneable> T $tryClone(T t) {
    return $Clone(t);
  }
  public static <T extends NativeCloneable> T $Clone(T t) {
    if (t == null) {
      return null;
    }
    T out = ((NativeCloneable<T>) t).clone();
    assert (out.getClass() == t.getClass()) || "org.llvm.adt.StringRef$ConstStringRef".equals(t.getClass().getName()) : "INVALID clone! Was " + t.getClass() + " became " + out.getClass();
    assert assertEqualAfterClone(t, out);
    return out;
  }
  
  public static <T> T $tryClone(T t) {
    if (t instanceof NativeCloneable<?>) {
      return (T)$Clone((NativeCloneable<T>)t);
    }
    assert !isIteratorLikeTypeName(t) : "All Iterators must be cloneable " + t.getClass();
    return t;
  }
  
  private static final boolean isIteratorLikeTypeName(Object o) {
    if (!NativeTrace.isDebugMode()) {
      throw new IllegalStateException("Only for calls from assert");
    }
    if (o == null) {
      return false;
    }
    String clsName = o.getClass().getSimpleName();
    if (clsName.contains("Iter")) {
      return true;
    }
    int indexOf = clsName.indexOf("iter");
    if (indexOf >= 0) {
      if (indexOf == 0) {
        return true;
      }
      char beforeI = clsName.charAt(indexOf-1);
      // filter out wr'iter' classes
      if (beforeI == 'r') {
        return false;
      }
      // filter out L'iter'al classes
      if (beforeI == 'L') {
        return false;
      }
      return true;
    }
    return false;
  }
  /**
   * Create a shallow copy of the array
   * @param val array to be cloned
   * @return cloned instance
   */
  public static <T> T[] $tryClone(T[] val) {
    return val.clone();
  }
  
  public static boolean $tryClone(boolean val) {
    return val;
  }
  
  public static byte $tryClone(byte val) {
    return val;
  }  
  
  public static short $tryClone(short val) {
    return val;
  }    
  
  public static int $tryClone(int val) {
    return val;
  }      
  
  public static long $tryClone(long val) {
    return val;
  }   
  
  public static char $tryClone(char val) {
    return val;
  }

  public static char$ptr $noClone(char$ptr t) {
    // marker for code where we know no clone is needed
    return t;
  }

  public static <T> T $noClone(T t) {
    // marker for code where we know no clone is needed
    return t;
  }
  
  public static boolean $is_array_based(type$ptr t) {
    return t instanceof type$ptr$array;
  }
  
  public static boolean $is_array_based(char$ptr t) {
    return t instanceof char$ptr$array;
  }
  
  public static boolean $is_array_based(uchar$ptr t) {
    return t instanceof uchar$ptr$array;
  }
  
  public static byte[] $extract_chars(NativeMemory.memory t) {
    return t instanceof char$mem ? ((char$mem)t).$array() : null;
  }
  
  public static boolean $is_array_based(ushort$ptr t) {
    return t instanceof ushort$ptr$array;
  }
  
  public static boolean $is_array_based(short$ptr t) {
    return t instanceof short$ptr$array;
  }
  
  public static boolean $is_array_based(uint$ptr t) {
    return t instanceof uint$ptr$array;
  }
  
  public static boolean $is_array_based(int$ptr t) {
    return t instanceof int$ptr$array;
  }
  
  public static boolean $is_array_based(ulong$ptr t) {
    return t instanceof ulong$ptr$array;
  }
  
  public static boolean $is_array_based(long$ptr t) {
    return t instanceof long$ptr$array;
  }
  
  public static boolean $assertConstPtr(char$ptr t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof DebuggableAbstractPointerType
              : "unexpected class " + t.getClass();
      assert t == null || ((DebuggableAbstractPointerType) t)._isConstPtr()
              : "Required const pointer!";
    }
    return true;
  }
  
  public static char$ptr $cleanConst(char$ptr t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof AbstractArrayPointerType : "unexpected class " + t.getClass();
      return t == null ? null : ((AbstractArrayPointerType<char$ptr>) t).$cleanConstPtr();
    } else {
      return t;
    }
  }
  
  public static char$ptr $prepareCloneFor(char$ptr toPrepare, char$ptr orig) {
    if (toPrepare == orig) {
      return toPrepare;
    }
    if ((toPrepare == null) || (toPrepare.getClass() != orig.getClass())) {
      toPrepare = $tryClone(orig);
    } else {
      if (((DebuggableAbstractPointerType)toPrepare)._isConstPtr()) {
        toPrepare = $cleanConst(toPrepare);
      }
      toPrepare.$assign(orig);
    }
    return toPrepare;
  }
  
  public static ulong$ptr $toConst(ulong$ptr t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof DebuggableAbstractPointerType: "unexpected class " + t.getClass();
      return t == null ? null : ((DebuggableAbstractPointerType<ulong$ptr>)t).$toConstPtr();
    } else {
      return t;
    }    
  }
  
  public static uint$ptr $toConst(uint$ptr t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof DebuggableAbstractPointerType: "unexpected class " + t.getClass();
      return t == null ? null : ((DebuggableAbstractPointerType<uint$ptr>)t).$toConstPtr();
    } else {
      return t;
    }    
  }
  
  public static char$ptr $toConst(char$ptr t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof DebuggableAbstractPointerType: "unexpected class " + t.getClass();
      return t == null ? null : ((DebuggableAbstractPointerType<char$ptr>)t).$toConstPtr();
    } else {
      return t;
    }    
  }
  
  public static <T> type$ptr<T> $toConst(type$ptr<T> t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof DebuggableAbstractPointerType: "unexpected class " + t.getClass();
      return t == null ? null : ((DebuggableAbstractPointerType<type$ptr<T>>)t).$toConstPtr();
    } else {
      return t;
    }    
  }

  public static <T> type$ptr<T> $cleanConst(type$ptr<T> t) {
    if (NativeTrace.isDebugMode()) {
      assert t == null || t instanceof DebuggableAbstractPointerType : "unexpected class " + t.getClass();
      return t == null ? null : ((DebuggableAbstractPointerType<type$ptr<T>>)t).$cleanConstPtr();
    } else {
      return t;
    }
  }
  
  public static char$ptr $tryConstClone(char$ptr t) {
    assert t == null || t instanceof DebuggableAbstractPointerType: "unexpected class " + t.getClass();
    return t == null ? null : t.const_clone();
  }

  public static char$ptr $tryDebugConstClone(char$ptr t) {
    if (NativeTrace.isDebugMode()) {
      return t == null ? null : t.const_clone();
    } else {
      return t;
    }
  }

  public static <T> T $tryConstClone(T t) {
    if (t == null) {
      return null;
    }
    if (t instanceof abstract_iterator) {
      return (T)(((abstract_iterator) t).const_clone());
    }
    if (t instanceof DebuggableAbstractPointerType) {
      if (((DebuggableAbstractPointerType) t)._isConstPtr()) {
        return t;
      }
    }
    if (t instanceof NativeCloneable) {
      return ((NativeCloneable<T>) t).clone();
    }
    throw new AssertionError("Why not cloneable?" + t);
  }
  
  public static String $toString(char$ptr chars) {
    if (chars == null) {
      return null;
    }
    return Casts.toJavaString(chars);
  }   
  
  public static String $toString(char$ptr chars, int length) {
    return Casts.toJavaString(chars, length);
  } 

  public static String $toString(char$iterator<?> chars) {
    if (chars instanceof char$ptr) {
      return $toString((char$ptr)chars);
    }
    return $toString(chars, std.strlen(chars));
  }   
  
  public static String $toString(char$iterator<?> chars, int length) {
    if (chars instanceof char$ptr) {
      return $toString((char$ptr)chars, length);
    }    
    chars = $tryClone(chars);
    StringBuilder out = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      out.append((char)chars.$star());
      chars.$preInc();
    }
    return out.toString();
  } 

  public static <T> T $star(type$iterator<?, T> ptr) {
    return ptr.$star();
  }

  public static <T> T $star(T o) {
    return o;
  }

  public static <T> T $addr(T o) {
    return o;
  }

  public static boolean N$assert(boolean Condition) {
    assert Condition;
    return true;
  }

  public static boolean N$assert(boolean Condition, String Msg) {
    assert Condition : Msg;
    return true;
  }
  
  public static <T> T $Deref(T obj) {
    assert obj != null : "Should not deref nullptr";
    return obj;
  }
  
  public static <T> T $Deref(type$ref<T> obj) {
    assert obj != null : "Should not deref nullptr";
    return obj.$deref();
  }
  
  public static /*uint*/int $Deref(uint$iterator<?> obj) {
    assert obj != null : "Should not deref nullptr";
    return obj.$star();
  }
  
  public static <T> T $Deref(type$iterator<?, T> obj) {
    assert obj != null : "Should not deref nullptr";
    return obj.$star();
  }

  public static boolean $Deref(boolean val) {
    return val;
  }
  
  public static byte $Deref(byte val) {
    return val;
  }
  
  public static char $Deref(char val) {
    return val;
  }
  
  public static short $Deref(short val) {
    return val;
  }
  
  public static int $Deref(int val) {
    return val;
  }
  
  public static long $Deref(long val) {
    return val;
  }
  
  public static float $Deref(float val) {
    return val;
  }
  
  public static double $Deref(double val) {
    return val;
  }
  
  public static <T> T $AddrOf(T obj) {
    assert obj != null : "Can not take address of nullptr";
    return obj;
  }
  
  public static boolean $AddrOf(boolean val) {
    return val;
  }
  
  public static byte $AddrOf(byte val) {
    return val;
  }
  
  public static char $AddrOf(char val) {
    return val;
  }
  
  public static short $AddrOf(short val) {
    return val;
  }
  
  public static int $AddrOf(int val) {
    return val;
  }
  
  public static long $AddrOf(long val) {
    return val;
  }
  
  public static float $AddrOf(float val) {
    return val;
  }
  
  public static double $AddrOf(double val) {
    return val;
  }
  
  public static int $compare_type(Object o1, Object o2) {
    if (o1 instanceof Native.ComparableLower) {
      if (((Native.ComparableLower) o1).$less(o2)) {
        return -1;
      }
      return ((Native.ComparableLower) o2).$less(o1) ? 1 : 0;
    } else if (o1 instanceof Comparable) {
      return ((Comparable) o1).compareTo(o2);
    } else {
      throw new UnsupportedOperationException("NO ComparableLower: " + o1.getClass() + " vs. " + o2.getClass());
    }
  }
  
  public static int $compare_ptr(Object o1, Object o2) {
    if (o1 instanceof NativePointerLike) {
      if (((Native.ComparableLower) o1).$less(o2)) {
        return -1;
      }
      return ((Native.ComparableLower) o2).$less(o1) ? 1 : 0;
    } else {
      if (Native.$less$JavaRef(o1, o2)) {
        return -1;
      }
      return Native.$less$JavaRef(o2, o1) ? 1 : 0;
    }
  }
  
  public static int $compare_type_int(Integer o1, Integer o2) {
    return o1.compareTo(o2);
  }
  
  public static int $compare_type_uint(Integer o1, Integer o2) {
    return Unsigned.$compare_uint(o1, o2);
  }
  
  public static int $compare_type_long(Long o1, Long o2) {
    return o1.compareTo(o2);
  }
  
  public static int $compare_type_ulong(Long o1, Long o2) {
    return Unsigned.$compare_ulong(o1, o2);
  }
  
  // Array initialization
  public static <T> int $appendArray(T destination[], int from, T source[]) {
    assert from == 0 || destination[from - 1] != null : "Why previous element is not initialized yet?";
    for (int i = 0; i < source.length; ++i) {
      destination[i + from] = source[i];
    }
    return from + source.length;
  }
  
  public static int $appendArray(byte destination[], int from, byte source[]) {
    for (int i = 0; i < source.length; ++i) {
      destination[i + from] = source[i];
    }
    return from + source.length;
  }

  public static int $appendArray(type$ptr<char$ptr> destination, int From, char$ptr[] source) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  // concurrent level
  private static final int NUM_PARALLEL_THREADS = Runtime.getRuntime().availableProcessors();

  public static int availableProcessors() {
    return NUM_PARALLEL_THREADS;
  }
  
  private Native() {
  }
  
  /*package*/ static void clearStatistics() {
    JavaCleaner.clearStatistics();
  }
  
  /*package*/ static long printStatistics(PrintWriter out) {
    long Value = JavaCleaner.printStatistics(out);
    return Value;
  }
}
