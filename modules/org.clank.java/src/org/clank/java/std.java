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

import org.clank.java.stdimpl.StdMap;
import org.clank.java.stdimpl.StdMultiMapUIntType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import org.clank.java.StdFunctionPointers.BinaryOperation;
import org.clank.support.JavaDifferentiators.*;
import org.clank.java.impl.*;
import org.clank.java.stdimpl.*;
import org.clank.java.stdimpl.aliases.*;
import org.clank.support.*;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import org.clank.support.Native.ComparatorLower;
import org.clank.support.Native.assignable;
import org.clank.support.NativeCallback.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.$char;
import static org.clank.support.Unsigned.*;

public class std extends std_algo implements std_ptr, std_pair, std_deque, std_functional, std_list, std_map, std_unordered_map {
  public static boolean $noteq_vector$_Tp$_Alloc$C(vectorString a, vectorString b){
    return a.$noteq(b);
  }
  public static void static_assert(boolean val, char$ptr msg) {
    static_assert(val, Casts.toJavaString(msg));
  }

  public static void static_assert(boolean val, String msg) {
    assert val : msg;
  }

  public static <T> T/*&*/ ref(T val) {
    return ref_T$R(val);
  }

  public static <T> T/*&*/ ref_T$R(T val) {
    assert val != null;
    return /*&*/val;
  }
  
  public static /*uint*/int abs(int val) {
    return Math.abs(val);
  }

  public static /*ulong*/long abs(long val) {
    return Math.abs(val);
  }
  
  public static <T> void merge(std.vector.iterator<T> begin, std.vector.iterator<T> end, 
          type$ptr<T> begin0, type$ptr<T> end0, 
          back_insert_iterator<T> back_inserter, 
          TypeType2Bool<T> beforeThanCompare) {
    throw new UnsupportedOperationException("Not supported yet.");
  }


  /**
   * Returns an iterator pointing to the element with the smallest value in the
   * range [first,last).
   *
   * The comparisons are performed using either operator< for the first version,
   * or comp for the second; An element is the smallest if no other element
   * compares less than it. If more than one element fulfills this condition,
   * the iterator returned points to the first of such elements.
   *
   * @param <T>
   * @param first
   * @param last
   * @param comp
   * @return 
   */
  public static <_InputIterator extends type$iterator<?, ?>, T>  _InputIterator min_element(_InputIterator first, _InputIterator last, Compare<T> comp) {
    if (first.$eq(last)) return last;
 
    _InputIterator smallest = $tryClone(first);
    first = $tryClone(first);
    first.$preInc();
    for (; first.$noteq(last); first.$preInc()) {
      if (comp.compare((T)first.$star(), (T)smallest.$star())) {
          smallest = $tryClone(first);
      }
    }
    return smallest;
  }

  /**
   *  @brief  Return the maximum element in a range using comparison functor.
   *  @ingroup sorting_algorithms
   *  @param  __first  Start of range.
   *  @param  __last   End of range.
   *  @param  __comp   Comparison functor.
   *  @return  Iterator referencing the first instance of the largest value
   *  according to __comp.
  */
  public static <_InputIterator extends type$iterator<?, ?>, T>  _InputIterator max_element(_InputIterator first, _InputIterator last, Compare<T> comp) {
    if (first.$eq(last)) return last;

    _InputIterator largest = $tryClone(first);
    first = $tryClone(first);
    first.$preInc();
    for (; first.$noteq(last); first.$preInc()) {
      if (comp.compare((T)largest.$star(), (T)first.$star())) {
          largest = $tryClone(first);
      }
    }
    return largest;
  }

  public static char$ptr strdup(char$ptr Message) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

//  public static /*<bool,bool>pair*/byte wrap_bool_bool_pair(boolean First, boolean Second) {
//    return (byte)((First ? 0x8000 : 0) | (Second ? 1 : 0));
//  }
  public static class integral_constant<Type> {
    
    public final Type value;

    public integral_constant(Type value) {
      this.value = value;
    }
  }
  
  public static class integral_constant_bool {
    public final boolean value;
    public integral_constant_bool(boolean value) {
      this.value = value;
    }
  }
  
  public static class integral_constant_bool_true {
    public static final boolean value = true;
    public integral_constant_bool_true() {}
    public integral_constant_bool_true(boolean value) {
      assert value == true;
    }
  }
  
  public static class integral_constant_bool_false {
    public static final boolean value = false;
    public integral_constant_bool_false() {}
    public integral_constant_bool_false(boolean value) {
      assert value == false;
    }
  }
  
  public static class once_flag {
  }
  
  public static char$ptr $new_uint(/*uint*/int size) {
    return create_char$ptr(new$char(size));
  }

  private std() {
  }

  public static void exit(int exitCode) {
    onExitCleanup();
    if (exitCode != 0 || !NativeTrace.CLANG_MODE) {
      throw new Error("INTERRUPTED WITH EXIT CODE " + exitCode);
    }
    System.exit(exitCode);
  }

  public static void onExitCleanup() {
    try {
      synchronized (AtExitCallbacks) {
        for (Void2Void cb : AtExitCallbacks) {
          cb.$call();
        }
        AtExitCallbacks.clear();
      }
    } catch (Throwable e) {
      NativeTrace.registerCleanupException(e);
    }
  }

  private static final List<Void2Void> AtExitCallbacks = new ArrayList<Void2Void>(0);
  public static void atexit(Void2Void callback) {
    AtExitCallbacks.add(callback);
  }
  
  public static void abort() {
    exit(1);
  }

  public static /*uint*/int alarm(/*uint*/int seconds) {
    return 0;
  }
  
  public static <_Tp> _Tp forward(_Tp __t) {
    return __t;
  }
  
  /**
   *  @brief  Convert a value to an xvalue.
   *  @param  __t  A thing of arbitrary type.
   *  @return The parameter cast to an xvalue to allow moving it.
   */
  public static <_Tp> _Tp move(_Tp __t) {
    // just convert to X-Value in native, so leave param as is Java
    return __t;
  }
  
  public static boolean move(boolean val) {
    return val;
  }
  
  public static long move(long val) {
    return val;
  }
  
  public static int move(int val) {
    return val;
  }
  
  public static byte move(byte val) {
    return val;
  }
  
  public static char move(char val) {
    return val;
  }
  
  public static short move(short val) {
    return val;
  }

  public static class move_iterator<_Tp> implements type$iterator<move_iterator<_Tp>, _Tp>{
  /*protected:*/
    protected type$ptr<_Tp> _M_current;
  /*public:*/
    // JAVA: typedef _Iterator iterator_type
  //  public final class iterator_type extends _Iterator{ };
    // JAVA: typedef int iterator_category;
    // JAVA: typedef int value_type;
    // JAVA: typedef int difference_type;
    // NB: DR 680.
    // JAVA: typedef _Iterator pointer
  //  public final class pointer extends _Iterator{ };
    // JAVA: typedef value_type &&reference
  //  public final class reference extends int$ref/*int &*//*&*/{ };

//    public move_iterator() {
//      // : _M_current() 
//      //START JInit
//      this._M_current = /*ParenListExpr*/new _Iterator();
//      //END JInit
//    }

    public /*explicit*/ move_iterator(type$ptr<_Tp> __i) {
      // : _M_current(__i) 
      //START JInit
      this._M_current = __i.clone();
      //END JInit
    }

    public move_iterator(final /*const*/ move_iterator<_Tp> /*&*/ __i) {
      // : _M_current(__i.base()) 
      //START JInit
      this._M_current = __i.base().clone();
      //END JInit
    }

    public type$ptr<_Tp> base() /*const*/ {
      return _M_current;
    }

    public _Tp/*int &*//*&*/ $star() /*const*/ {
      return _M_current.$star();
    }

    public _Tp $arrow() /*const*/ {
      return _M_current.$arrow();
    }

    public move_iterator<_Tp> /*&*/ $preInc() {
      _M_current.$preInc();
      return /*Deref*/this;
    }

    public move_iterator<_Tp> $postInc(int $Prm0) {
      move_iterator<_Tp> __tmp = new move_iterator<>(/*Deref*/this);
      _M_current.$preInc();
      return __tmp;
    }

    public move_iterator<_Tp> /*&*/ $preDec() {
      _M_current.$preDec();
      return /*Deref*/this;
    }

    public move_iterator<_Tp> $postDec(int $Prm0) {
      move_iterator<_Tp> __tmp = new move_iterator<>(/*Deref*/this);
      _M_current.$preDec();
      return __tmp;
    }

    public move_iterator<_Tp> $add(int __n) /*const*/ {
      return new move_iterator<_Tp>(_M_current.$add(__n));
    }

    public move_iterator<_Tp> /*&*/ $addassign(int __n) {
      _M_current.$add(__n);
      return /*Deref*/this;
    }

    public move_iterator<_Tp> $sub(int __n) /*const*/ {
      return new move_iterator<_Tp>(_M_current.$sub(__n));
    }

    @Override
    public int $sub(move_iterator<_Tp> iter) {
      return base().$sub(iter.base());
    }

    @Override
    public boolean $eq(Object other) {
      return base().$eq(((move_iterator)other).base());
    }

    public move_iterator<_Tp> /*&*/ $minusassign(int __n) {
      _M_current.$sub(__n);
      return /*Deref*/this;
    }

    public type$ref<_Tp> /*int &*//*&*/ $at(int __n) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    @Override
    public move_iterator<_Tp> clone() {
      return new move_iterator<>(this);
    }

    @Override public String toString() {
      return "" + "_M_current=" + _M_current; // NOI18N
    }
  }

  public static <_Tp> move_iterator<_Tp> make_move_iterator(final type$ptr<_Tp> __t) {
    return new move_iterator<_Tp>(__t);
  }

  public static <F, S> pair<F, S> tie(F f, S s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pair(f, s);
  }

  public static <F> pairTypeBool<F> tie_boolean(F f, boolean s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairTypeBool<>(f, s);
  }

  public static pairIntBool tie_int_boolean(int f, boolean s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairIntBool(f, s);
  }
  
  public static <F> pairUIntType<F> tie_uint_type(int f, F s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairUIntType<>(f, s);
  }

  public static <F> pairTypeUInt<F> tie_type_uint(F f, int s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairTypeUInt<>(f, s);
  }

  public static pairIntInt tie_int(int f, int s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairIntInt(f, s);
  }

  public static pairUIntUInt tie_uint(/*uint*/int f, /*uint*/int s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairUIntUInt(f, s);
  }

  public static pairUIntRefUIntRef tie(uint$ref f, uint$ref s) {
    if (true) throw new UnsupportedOperationException("Must be unfolded in caller");
    return new std.pairUIntRefUIntRef(f, s);
  }

  public static final class numeric_limitsDouble {
    public static double infinity() {
      return Double.POSITIVE_INFINITY;
    }
  }

  public static final class numeric_limitsULong {
    public static final int digits = 64;
    public static long max() {
      return ULONG_MAX;
    }
  }

  public static final class numeric_limitsULLong {
    public static final int digits = 64;
    public static long max() {
      // we don't have 128bit builtins in Java
      return ULONG_MAX;
    }
  }

  public static final class numeric_limitsUInt {
    public static /*uint*/int max() {
      return UINT_MAX;
    }
  }

  public static final class numeric_limitsLong {
    public static long max() {
      return LONG_MAX;
    }
  }

  public static final class numeric_limitsInt {
    public static int max() {
      return INT_MAX;
    }
  }
  
//  public static interface StdAtomic<_Tp> {
//    _Tp $preInc();
//  }

  public static double sqrt(double d) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static double round(double d) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  /* Put the 1 minute, 5 minute and 15 minute load averages into the first
   NELEM elements of LOADAVG.  Return the number written (never more than
   three, but may be less than NELEM), or -1 if an error occurred.  */
  public static int getloadavg(double __loadavg[], int __nelem) {
    throw new UnsupportedOperationException("EmptyBody."); 
  }

  /**
   * The strtod(), strtof(), and strtold() functions convert the initial
   * portion of the string pointed to by nptr to double, float, and long
   * double representation, respectively.
   *
   * The expected form of the (initial portion of the) string is
   * optional leading white space as recognized by isspace(3), an
   * optional plus ('+') or minus sign ('-') and then either (i) a
   * decimal number, or (ii) a hexadecimal number, or (iii) an infinity,
   * or (iv) a NAN (not-a-number).
   *
   * A decimal number consists of a nonempty sequence of decimal digits
   * possibly containing a radix character (decimal point,
   * locale-dependent, usually '.'), optionally followed by a decimal
   * exponent. A decimal exponent consists of an 'E' or 'e', followed by
   * an optional plus or minus sign, followed by a nonempty sequence of
   * decimal digits, and indicates multiplication by a power of 10.
   *
   * A hexadecimal number consists of a "0x" or "0X" followed by a
   * nonempty sequence of hexadecimal digits possibly containing a radix
   * character, optionally followed by a binary exponent. A binary
   * exponent consists of a 'P' or 'p', followed by an optional plus or
   * minus sign, followed by a nonempty sequence of decimal digits, and
   * indicates multiplication by a power of 2. At least one of radix
   * character and binary exponent must be present.
   *
   * An infinity is either "INF" or "INFINITY", disregarding case.
   *
   * A NAN is "NAN" (disregarding case) optionally followed by '(', a
   * sequence of characters, followed by ')'. The character string
   * specifies in an implementation-dependent way the type of NAN.
   *
   * Return Value
   *
   * These functions return the converted value, if any.
   *
   * If endptr is not NULL, a pointer to the character after the last
   * character used in the conversion is stored in the location
   * referenced by endptr.
   *
   * If no conversion is performed, zero is returned and the value of
   * nptr is stored in the location referenced by endptr.
   *
   * If the correct value would cause overflow, plus or minus HUGE_VAL
   * (HUGE_VALF, HUGE_VALL) is returned (according to the sign of the
   * value), and ERANGE is stored in errno. If the correct value would
   * cause underflow, zero is returned and ERANGE is stored in errno.
   *
   * Errors
   *
   * ERANGE
   *    Overflow or underflow occurred.
   *
   * @param nptr
   * @param endptr
   * @return
   */
  public static double strtod(/*const*/char$ptr nptr, type$ptr<char$ptr> endptr) {
    return StdStrToNumber.strtod(nptr, endptr);
  }

  /*
  *----------------------------------------------------------------------
  *
  * strtoul --
  *
  *	Convert an ASCII string into an integer.
  *
  * @param string - String of ASCII digits, possibly
  *                  preceded by white space.  For bases
  *                  greater than 10, either lower- or
  *                  upper-case digits may be used.
  *
  * @param endPtr - Where to store address of terminating
  *                  character, or NULL.
  *
  * @param base - Base for conversion.  Must be less
  *                than 37.  If 0, then the base is chosen
  *                from the leading characters of string:
  *                "0x" means hex, "0" means octal, anything
  *                else means decimal.
  *
  * Results:
  *	The return value is the integer equivalent of string.  If endPtr
  *	is non-NULL, then *endPtr is filled in with the character
  *	after the last one that was part of the integer.  If string
  *	doesn't contain a valid integer value, then zero is returned
  *	and *endPtr is set to string.
  *
  * Side effects:
  *	None.
  *
  *----------------------------------------------------------------------
  */
  public static /*ulong*/long strtoul(/*const*/char$ptr string, type$ptr<char$ptr> endptr, int base) {
    return StdStrToNumber.strtoul(string, endptr, base);
  }

  public static long strtol(/*const char P*/char$ptr str, /*char PP*/ type$ptr<char$ptr> end, int base) {
    return StdStrToNumber.strtol(str, end, base);
  }
  
  /**
   * The qsort() function sorts an array with nmemb elements of size
   * size. The base argument points to the start of the array.
   *
   * The contents of the array are sorted in ascending order according
   * to a comparison function pointed to by compar, which is called with
   * two arguments that point to the objects being compared.
   *
   * The comparison function must return an integer less than, equal to,
   * or greater than zero if the first argument is considered to be
   * respectively less than, equal to, or greater than the second. If
   * two members compare as equal, their order in the sorted array is
   * undefined.
   *
   * The qsort_r() function is identical to qsort() except that the
   * comparison function compar takes a third argument. A pointer is
   * passed to the comparison function via arg. In this way, the
   * comparison function does not need to use global variables to pass
   * through arbitrary arguments, and is therefore reentrant and safe to
   * use in threads.
   *
   * Return Value
   *
   * The qsort() and qsort_r() functions return no value.
   *
   * @param base
   * @param nmemb
   * @param size - not used in Java implementation!
   * @param compar
   */
  public static <T> void qsort(type$ptr<T> base, /*size_t*/int nmemb, /*size_t*/int size, Comparator<T> compar) {
    assert size == -1 : "do not call this method with unuzed size param, pass -1 instead";
    StdQuicksort._quicksort(base, nmemb, compar);
  }
  public static <T> void stable_sort(type$ptr<T> base, /*size_t*/int nmemb, /*size_t*/int size, Comparator<T> compar) {
    assert size == -1 : "do not call this method with unuzed size param, pass -1 instead";
    StdQuicksort._stablesort(base, nmemb, compar);
  }
  public static <T> void qsort(type$iterator<?,T> Start, type$iterator<?,T> End, Comparator<T> compar) {
    throw new UnsupportedOperationException("EmptyBody qsort " + std.distance(Start, End) + " " + (Start == null ? "<null>" : Start.getClass()));
  }
  
  public static <T> void stable_sort(type$ptr<T> begin, type$ptr<T> end, Compare<T> comparator) {
    StdQuicksort._stablesort(begin, end.$sub(begin), comparator);
  }
  
  public static void stable_sort(uint$ptr begin, uint$ptr end, Compare<Integer> comparator) {
    int size = end.$sub(begin);
    type$ptr<Integer> tmp = create_type$ptr(new Integer[size]);
    type$ptr<Integer> t = $tryClone(tmp);
    for(uint$ptr I =  $tryClone(begin); !$eq_ptr(I, end); I.$preInc(), t.$preInc()) {
      t.$set(I.$star());
    }
    StdQuicksort._stablesort(tmp, size, comparator);
    t = $tryClone(tmp);
    for(uint$ptr I =  $tryClone(begin); !$eq_ptr(I, end); I.$preInc(), t.$preInc()) {
      I.$set(t.$star());
    }
  }

  public static<T>  void stable_sort(StdVector.iterator<T> begin, StdVector.iterator<T> end) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  public static<T>  void stable_sort(std.vector.iterator<T> begin, std.vector.iterator<T> end, Comparator<T> compar) {
    stable_sort(begin.toPointer(), end.$sub(begin), -1, compar);
  }

  public static class default_deleteT$Array<T> {

    public default_deleteT$Array() {
    }
  }

  public static class initializer_list<T> {

    private T[] array;

    public initializer_list() {
      array = (T[]) new Object[0];
    }

    public initializer_list(T... a) {
      array = a;
    }

    public type$iterator<?, T> begin() {
      return create_type$ptr(array);
    }
    public type$iterator<?, T> end() {
      return create_type$ptr(array, array.length);
    }
  }

  public static class forward_list<T> {

    public forward_list() {
    }

    public void $destroy() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void push_front_T$RR(T track) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  /**
   * Comparison function used in std.sort
   * @param <T>
   */
  @FunctionalInterface
  public interface Compare<T> extends ComparatorLower<T, T> {
    // TODO: rename to less
    boolean compare(T a, T b);
    
    default boolean $call(T first, T second) {
      return compare(first, second);
    }
    
    @Override
    default boolean $less(T first, T second) {
      return compare(first, second);
    }
  }
  
  @FunctionalInterface
  public interface CompareTypePtr<T> extends Comparator<type$ptr<T>> {
    int $compare$ptr(type$ptr<T> LHS, type$ptr<T> RHS);
    default int compare(type$ptr<T> lhs, type$ptr<T> rhs) {
      return $compare$ptr(lhs, rhs);
    }
  }
  
  public static final class DefaultCompare implements Compare<ComparableLower> {
    
    public static final DefaultCompare INSTANCE = new DefaultCompare();
    
    @Override
    public boolean compare(ComparableLower a, ComparableLower b) {
      return a.$less(b);
    }
    
    private DefaultCompare() {}
  }
  
  private static class CompareBasedComparator<T> implements Comparator<T> {
    
    private final Compare<T> compare;

    public CompareBasedComparator(Compare<T> compare) {
      this.compare = compare;
    }

    @Override
    public int compare(T o1, T o2) {
      if (o1 == o2) {
        return 0;
      }
      if (compare.compare(o1, o2)) {
        return -1;
      } else if (compare.compare(o2, o1)) {
        return 1;
      }
      return 0;
    }
  }
  
  private static class CompareLowerComparator<T extends ComparableLower> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
      if (o1 == o2) {
        return 0;
      }      
      if (o1.$less(o2)) {
        return -1;
      } else if (o2.$less(o1)) {
        return 1;
      }
      return 0;
    }
  }
  public static final CompareLowerComparator COMPARE_LOWER_COMPARATOR = new CompareLowerComparator();
  
  public static <T extends ComparableLower, Iter extends type$iterator<Iter, T>> void sort(Iter/*<t>*/ first, Iter/*<t>*/ last) {
    StdQuicksortIters._quicksort(first, last.$sub(first), COMPARE_LOWER_COMPARATOR);
  }
  public static <T extends ComparableLower, Iter extends type$iterator<Iter, T>> void sort(Iter/*<t>*/ first, Iter/*<t>*/ last, Comparator<T> comp) {
    StdQuicksortIters._quicksort(first, last.$sub(first), comp);
  }
  
  public static  void sort(uint$ptr first, uint$ptr last) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  public static <T, Iter extends type$iterator<Iter, T>> void sort(Iter/*<t>*/ first, Iter/*<t>*/ last, Compare<? super T> compar) {
    StdQuicksortIters._quicksort(first, last.$sub(first), new CompareBasedComparator(compar));
  }
  
  public static <T extends ComparableLower, Iter extends type$iterator<Iter, T>> void stable_sort(Iter/*<t>*/ first, Iter/*<t>*/ last) {
    StdQuicksortIters._stablesort(first, last.$sub(first), COMPARE_LOWER_COMPARATOR);
  }
  
  public static <T, Iter extends type$iterator<Iter, T>> void stable_sort(Iter/*<t>*/ first, Iter/*<t>*/ last, Compare<? super T> compar) {
    StdQuicksortIters._stablesort(first, last.$sub(first), new CompareBasedComparator(compar));
  }
  
  /**
   *  @brief Find two adjacent values in a sequence using a predicate.
   *  @ingroup non_mutating_algorithms
   *  @param  __first         A forward iterator.
   *  @param  __last          A forward iterator.
   *  @param  __binary_pred   A binary predicate.
   *  @return   The first iterator @c i such that @c i and @c i+1 are both
   *  valid iterators in @p [__first,__last) and such that
   *  @p __binary_pred(*i,*(i+1)) is true, or @p __last if no such iterator
   *  exists.
  */
  public static <T, _ForwardIterator extends type$iterator<?, T>>
    _ForwardIterator adjacent_find(_ForwardIterator __first, _ForwardIterator __last, TypeType2Bool __binary_pred) {
    if (__first.$eq(__last)) {
      return $tryClone(__last);
    }
    __first = $tryClone(__first);
    _ForwardIterator __next = $tryClone(__first);
    while (__next.$preInc().$noteq(__last))
    {
      if (__binary_pred.$call(__first.$star(), __next.$star())) {
        return __first;
      }
      __first.$preInc();
    }
    return $tryClone(__last);
  }
  
  /**
   *  @brief Remove consecutive duplicate values from a sequence.
   *  @ingroup mutating_algorithms
   *  @param  __first  A forward iterator.
   *  @param  __last   A forward iterator.
   *  @return  An iterator designating the end of the resulting sequence.
   *
   *  Removes all but the first element from each group of consecutive
   *  values that compare equal.
   *  unique() is stable, so the relative order of elements that are
   *  not removed is unchanged.
   *  Elements between the end of the resulting sequence and @p __last
   *  are still present, but their value is unspecified.
  */
  public static <T extends NativeComparable, _ForwardIterator extends type$iterator<_ForwardIterator, T>> 
        _ForwardIterator unique(_ForwardIterator/*<t>*/ __first, _ForwardIterator/*<t>*/ __last, boolean isPointerLike) {
    return unique(
            __first, 
            __last, 
            (Val1, Val2)->(isPointerLike ? Native.$eq_ptr(Val1, Val2) : Native.$eq(Val1, Val2)),
            isPointerLike
    );
  }

  public static <T, _ForwardIterator extends type$iterator<_ForwardIterator, T>> 
        _ForwardIterator unique$ptr(_ForwardIterator/*<t>*/ __first, _ForwardIterator/*<t>*/ __last) {
    return unique(
            __first, 
            __last, 
            (Val1, Val2)->(Native.$eq_ptr(Val1, Val2)),
            true
    );
  }
  
  /**
   *  @brief Remove consecutive values from a sequence using a predicate.
   *  @ingroup mutating_algorithms
   *  @param  __first        A forward iterator.
   *  @param  __last         A forward iterator.
   *  @param  __binary_pred  A binary predicate.
   *  @return  An iterator designating the end of the resulting sequence.
   *
   *  Removes all but the first element from each group of consecutive
   *  values for which @p __binary_pred returns true.
   *  unique() is stable, so the relative order of elements that are
   *  not removed is unchanged.
   *  Elements between the end of the resulting sequence and @p __last
   *  are still present, but their value is unspecified.
  */
  public static <T, _ForwardIterator extends type$iterator<_ForwardIterator, T>> 
        _ForwardIterator unique(_ForwardIterator/*<t>*/ __first, _ForwardIterator/*<t>*/ __last, 
                TypeType2Bool __binary_pred, boolean isPointerLike) {
    // Skip the beginning, if already unique.
    __first = std.adjacent_find(__first, __last, __binary_pred);
    if (__first.$eq(__last)) {
      return $tryClone(__last);
    }

    // Do the real copy work.
    _ForwardIterator __dest = $tryClone(__first);
    __first.$preInc();
    while (__first.$preInc().$noteq(__last)) {
      if (!__binary_pred.$call(__dest.$star(), __first.$star())) {
        __dest.$preInc();
        __dest.star$ref().$set($tryMove(__dest.$star(), __first.$star(), isPointerLike));
      }
    }
    return __dest.$preInc();
  }
        
  public static uint$ptr unique(uint$ptr first, uint$ptr last) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static final class not_equal_to_uint implements UIntUIntBoolPredicate {
    @Override
    public boolean $call(/*uint*/int param1, /*uint*/int param2) {
      return param1 != param2;
    }
  }

  public static final class less_uint implements UIntUIntBoolPredicate {
    @Override
    public boolean $call(/*uint*/int param1, /*uint*/int param2) {
      return Unsigned.$less_uint(param1, param2);
    }
  }

  public static final class greater_uint implements UIntUIntBoolPredicate {
    @Override
    public boolean $call(/*uint*/int param1, /*uint*/int param2) {
      return Unsigned.$greater_uint(param1, param2);
    }
  }

  /**
   *  @brief  Return an iterator pointing to the first element of
   *          the container.
   *  @param  __cont  Container.
   */
  public static <Iter> Iter begin(NativeIterable<Iter> __cont) {
    return __cont.begin();
  }

  /**
   *  @brief  Return an iterator pointing to one past the last element of
   *          the container.
   *  @param  __cont  Container.
   */
  public static <Iter> Iter end(NativeIterable<Iter> __cont) {
    return __cont.end();
  }

  /**
   *  @brief  Return an iterator pointing to the first element of the array.
   *  @param  __arr  Array.
   */
  public static <_Tp> type$ptr<_Tp> begin(_Tp[] __arr) {
    return create_type$ptr(__arr);
  }

  public static char$ptr begin(byte[] __arr) {
    return create_char$ptr(__arr);
  }
  
  public static char$ptr end(byte[] __arr) {
    return create_char$ptr(__arr, __arr.length);
  }
  
  /**
   *  @brief  Return an iterator pointing to one past the last element
   *          of the array.
   *  @param  __arr  Array.
   */
  public static <_Tp> type$ptr<_Tp> end(_Tp[] __arr) {
    return create_type$ptr(__arr, __arr.length);
  }

  /**
   *  @brief Apply a function to every element of a sequence.
   *  @ingroup non_mutating_algorithms
   *  @param  first  An input iterator.
   *  @param  last   An input iterator.
   *  @param  f      A unary function object.
   *  @return   @p f (std::move(@p f) in C++0x).
   *
   *  Applies the function object @p f to each element in the range
   *  @p [first,last).  @p f must not modify the order of the sequence.
   *  If @p f has a return value it is ignored.
  */
  public static NativeCallback.Int2Void for_each(int$ptr first, int$ptr __last, NativeCallback.Int2Void __f)
  {
    // concept requirements
    for (int$ptr __first = $tryClone(first); __first.$noteq(__last); __first.$preInc()) {
      __f.$call(__first.$star());
    }
    return __f;
  }

  public static <T> NativeCallback.T2Void<type$ptr<T>> for_each(type$ptr<T> first, type$ptr<T> __last, NativeCallback.T2Void<type$ptr<T>> __f)
  {
    // concept requirements
    for (type$ptr<T> __first = $tryClone(first); __first.$noteq(__last); __first.$preInc()) {
      __f.$call(__first);
    }
    return __f;
  }

  /**
   * std::search.
   * Searches the range [first1,last1) for the first occurrence of the
   * sequence defined by [first2,last2), and returns an iterator to its
   * first element, or last1 if no occurrences are found.
   *
   * The elements in both ranges are compared sequentially using
   * operator== (or pred, in version (2)): A subsequence of
   * [first1,last1) is considered a match only when this is true for all
   * the elements of [first2,last2).
   *
   * This function returns the first of such occurrences. For an
   * algorithm that returns the last instead, see find_end.
   * 
   * @param <ForwardIterator1>
   * @param <ForwardIterator2>
   * @param first1
   * @param last1
   * @param first2
   * @param last2
   * @return 
   */
  public static <ForwardIterator1 extends char$iterator<?>, ForwardIterator2 extends char$iterator<?>>
    ForwardIterator1 search( ForwardIterator1 first1, ForwardIterator1 last1,
                              ForwardIterator2 first2, ForwardIterator2 last2)
  {
    if (first2.$eq(last2)) {
      return first1;  // specified in C++11
    }
    first1 = $tryClone(first1);
    while (first1.$noteq(last1)) {
      ForwardIterator1 it1 = $tryClone(first1);
      ForwardIterator2 it2 = $tryClone(first2);
      while (it1.$star() == it2.$star()) {    // or: while (pred(*it1,*it2)) for version 2
        it1.$preInc();
        it2.$preInc();
        if (it2.$eq(last2)) {
          return first1;
        }
        if (it1.$eq(last1)) {
          return last1;
        }
      }
      first1.$preInc();
    }
    return last1;
  }

  public static int find(byte[] $array, int from, int end, char c) {
    int cur = from;
    while (cur != end) {
      if ($array[cur] == (byte)c) {
        return cur;
      }
      ++cur;
    }
    // ret
    return end;
  }

  public static int find(Object[] $array, int from, int end, Object c) {
    int cur = from;
    while (cur != end) {
      if ($array[cur] == c) {
        return cur;
      }
      ++cur;
    }
    // ret
    return end;
  }
  
  /**
   * std::find
   *
   * @param start
   * @param end
   * @param c
   * @return
   */  
  public static char$ptr find(char$ptr start, char$ptr end, /*char*/byte c) {
    char$ptr cur = $tryClone(start);
    while (!cur.$eq(end)) {
      if (cur.$star() == c) {
        return cur;
      }
      cur.$preInc();
    }
    // ret
    return end;
  }

  public static uint$ptr find(uint$ptr start, uint$ptr end, /*uint*/int c) {
    uint$ptr cur = $tryClone(start);
    while (!cur.$eq(end)) {
      if (cur.$star() == c) {
        return cur;
      }
      cur.$preInc();
    }
    // ret
    return end;
  }

  public static <_II1, _II2> boolean equal(_II1 __first1, _II1 __last1, _II2 __first2) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static <T> boolean equal(type$iterator<?, T> __first1, type$iterator<?, T> __last1, type$iterator<?, T> __first2, TypeType2Bool<T> filter) {
    if (__first1.$noteq(__last1)) {
      type$iterator<?, T> first1 = $tryClone(__first1);
      type$iterator<?, T> first2 = $tryClone(__first2);
      type$iterator<?, T> last1 = __last1;
      for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc()) {
          if (!filter.$call(first1.$star(), first2.$star())) {
              return false;
          }
      }
    }
    return true;    
  }
  
  public static <_ForwardIterator extends type$iterator<?, ?>, _Tp> pair<_ForwardIterator, _ForwardIterator> equal_range(_ForwardIterator __first1, _ForwardIterator __last1, _Tp _val) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  /**
   * Returns a range containing all elements equivalent to value in the range [first, last). 
   * @param <_ForwardIterator>
   * @param <_Tp>
   * @param <_Compare>
   * @param __first1
   * @param __last1
   * @param _val
   * @param __comp
   * @return std::pair containing a pair of iterators defining the wanted range,
   * the first pointing to the first element that is not less than value and the
   * second pointing to the first element greater than value.
   *
   * If there are no elements not less than value, last is returned as the first
   * element. Similarly if there are no elements greater than value, last is
   * returned as the second element
   */
  public static <_ForwardIterator extends type$iterator<?, ?>, _Tp, _Compare extends ComparatorLower<?, ?>> pair<_ForwardIterator, _ForwardIterator> equal_range(_ForwardIterator __first1, _ForwardIterator __last1, _Tp _val, _Compare __comp) {
    _ForwardIterator lower_bound = std.<_ForwardIterator, _Tp>lower_bound(__first1, __last1, _val, __comp);
    _ForwardIterator upper_bound = std.<_ForwardIterator, _Tp>upper_bound(__first1, __last1, _val, __comp);
    return std.make_pair(lower_bound, upper_bound);
  }
  
//  public static <Iterator> Iterator find(Iterator start, Iterator end, Object c) {
//    throw new UnsupportedOperationException();
//  }

  /**
   *  @brief A generalization of pointer arithmetic.
   *  @param  __i  An input iterator.
   *  @param  __n  The @a delta by which to change @p __i.
   *  @return  Nothing.
   *
   *  This increments @p i by @p n.  For bidirectional and random access
   *  iterators, @p __n may be negative, in which case @p __i is decremented.
   *
   *  For random access iterators, this uses their @c + and @c - operations
   *  and are constant time.  For other %iterator classes they are linear time.
  */
  public static <_InputIterator extends abstract_iterator<?>> void advance(_InputIterator/*&*/ it, /*size_t*/int Distance) {
    it.$inc(Distance);
  }
  
  public static <_InputIterator extends std.iterator<?, ?>> void advance(_InputIterator/*&*/ it, /*size_t*/int Distance) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /**
   * next/prev do not modify input interator (as std::advance), but return the new one.
   * @param <_ForwardIterator>
   * @param it
   * @return 
   */
  public static <_ForwardIterator extends abstract_iterator<?>> _ForwardIterator next(_ForwardIterator it) {
    return next(it, 1);
  }
  
  public static <_ForwardIterator extends abstract_iterator<?>> _ForwardIterator next(_ForwardIterator it, long __n) {
    it = $Clone(it);
    std.advance(it, (int)__n);
    return it;
  }
  
  public static <_ForwardIterator extends abstract_iterator<?>> _ForwardIterator next(_ForwardIterator it, int __n) {
    it = $Clone(it);
    std.advance(it, __n);
    return it;
  }
  
  public static <_ForwardIterator extends abstract_iterator<?>> _ForwardIterator prev(_ForwardIterator it) {
    return prev(it, 1);
  }
  
  public static <_ForwardIterator extends abstract_iterator<?>> _ForwardIterator prev(_ForwardIterator it, int __n) {
    it = $Clone(it);
    std.advance(it, -__n);
    return it;
  }

  /**
   *  @brief Perform an operation on a sequence.
   *  @ingroup mutating_algorithms
   *  @param  first     An input iterator.
   *  @param  last      An input iterator.
   *  @param  result    An output iterator.
   *  @param  unary_op  A unary operator.
   *  @return   An output iterator equal to @p result+(last-first).
   *
   *  Applies the operator to each element in the input range and assigns
   *  the results to successive elements of the output sequence.
   *  Evaluates @p *(result+N)=unary_op(*(first+N)) for each @c N in the
   *  range @p [0,last-first).
   *
   *  @p unary_op must not alter its argument.
  */
  public static < InputIterator extends char$iterator<?>,  OutputIterator extends char$iterator<?>,  UnaryOperation extends NativeCallback.Char2Char>
    OutputIterator transform (InputIterator first1, InputIterator last1, OutputIterator result, UnaryOperation op)
  {
    first1 = $tryClone(first1);
    result = $tryClone(result);
    while (first1.$noteq(last1)) {
      result.star$ref().$set(op.$call(first1.$star()));  // or: *result=binary_op(*first1,*first2++);
      result.$preInc();
      first1.$preInc();
    }
    return result;
  }

  public static <T,  OutputIterator extends back_insert_iterator<T>,  UnaryOperation extends NativeCallback.Type2RetType<T, T>>
    OutputIterator transform (type$ptr<T> first1, type$ptr<T> last1, OutputIterator result, UnaryOperation op)
  {
    first1 = $tryClone(first1);
    result = $tryClone(result);
    while (first1.$noteq(last1)) {
      result.star$ref().$set(op.$call(first1.$star()));  // or: *result=binary_op(*first1,*first2++);
      result.$preInc();
      first1.$preInc();
    }
    return result;
  }
    
  public static <T, UnaryOperation extends NativeCallback.Type2RetType<T, T>>
    type$ptr<T> transform (type$iterator<?, T> first1, type$iterator<?, T> last1, type$ptr<T> result, UnaryOperation op)
  {
    first1 = $tryClone(first1);
    result = $tryClone(result);
    while (first1.$noteq(last1)) {
      result.star$ref().$set(op.$call(first1.$star()));  // or: *result=binary_op(*first1,*first2++);
      result.$preInc();
      first1.$preInc();
    }
    return result;
  }
    
  public static <T1, T2, OutputIterator extends back_insert_iterator<T2>, UnaryOperation extends NativeCallback.Type2RetType<T1, T2>>
    OutputIterator transform (type$iterator<?, T1> first1, type$iterator<?, T1> last1, OutputIterator result, UnaryOperation op)
  {
    first1 = $tryClone(first1);
    result = $tryClone(result);
    while (first1.$noteq(last1)) {
      result.star$ref().$set(op.$call(first1.$star()));  // or: *result=binary_op(*first1,*first2++);
      result.$preInc();
      first1.$preInc();
    }
    return result;
  }

  /**
   *  @brief Find the first occurrence of a value in a sequence.
   *  @ingroup non_mutating_algorithms
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *  @param  __val    The value to find.
   *  @return   The first iterator @c i in the range @p [__first,__last)
   *  such that @c *i == @p __val, or @p __last if no such iterator exists.
  */
//  template<typename _InputIterator, typename _Tp>
//    inline _InputIterator
//    find(_InputIterator __first, _InputIterator __last,
//	 const _Tp& __val)
  public static <_InputIterator extends type$iterator<?, _Tp>, _Tp> _InputIterator find(_InputIterator __first, _InputIterator __last, Object __val) {
    return find(__first, __last, __val, false);
  }
  public static <_InputIterator extends type$iterator<?, _Tp>, _Tp> _InputIterator find(_InputIterator __first, _InputIterator __last, Object __val, boolean isPointerLike) {
    return find(__first, __last, __val, 
            isPointerLike ? 
                     (p1, p2)->p1==p2 
                    : 
                     (o1, o2)->Native.$eq(o1, o2)
    );
  }
  public static <_InputIterator extends type$iterator<?, _Tp>, _Tp> _InputIterator find(_InputIterator __first, _InputIterator __last, Object __val, CollectionUtils.Equalizer<_Tp, Object> equalizer) {
    _InputIterator iter = $tryClone(__first);
    while (iter.$noteq(__last)) {
      if (equalizer.areEqual(iter.$star(), __val)) {
        return iter;
      }
      iter.$preInc();
    }
    return __last;
  }

  /**
   * Performs a left rotation on a range of elements.
   *
   * Specifically, std::rotate swaps the elements in the range [first,
   * last) in such a way that the element n_first becomes the first
   * element of the new range and n_first - 1 becomes the last element.
   *
   * A precondition of this function is that [first, n_first) and
   * [n_first, last) are valid ranges.
   * @param first 	the beginning of the original range
   * @param middle 	the element that should appear at the beginning of the rotated range
   * @param last 	the end of the original range
   */
  public static /*char$ptr*/void rotate(char$ptr first, char$ptr middle, char$ptr last ) {
    if (!(first.$eq(middle) || middle.$eq(last))) {
      // use position and indices instead of cloning
      int _firstPos = 0;
      int first$Idx = first.$index();
      int _middlePos = 0;
      int middle$Idx = middle.$index();
      int _currentPos = _middlePos;
      int cur$Idx = middle$Idx;
      int last$Idx = last.$index();
      while(true) {
        std.iter_swap(first, _firstPos, middle, _currentPos);
        _firstPos++; _currentPos++;
        first$Idx++; cur$Idx++;
        if (first$Idx == middle$Idx) {
          if (cur$Idx == last$Idx){
            return;
          }
          _middlePos = _currentPos;
          middle$Idx = cur$Idx;
        } else if (cur$Idx == last$Idx) {
          _currentPos = _middlePos;
          cur$Idx = middle$Idx;
        }
      }
    }    
  }
  
//  public static /*char$ptr*/void rotate(char$ptr first, char$ptr middle, char$ptr last ) {
//    if (!($eq(first, middle) || $eq(middle, last))) {
//      char$ptr _first = first.clone();
//      char$ptr _middle = middle.clone();
//      char$ptr _current = middle.clone();
//      while(true) {
//        std.iter_swap(_first.$postInc(), _current.$postInc());
//        if ($eq(_first, _middle)) {
//          if ($eq(_current, last)){
//            return;
//          }
//          _middle = _current.clone();
//        } else if ($eq(_current, last)) {
//          _current = _middle.clone();
//        }
//      }
//    }    
//  }
  
  public static <ForwardIt  extends type$iterator> ForwardIt rotate( ForwardIt first, ForwardIt n_first, ForwardIt last ) {
    NativeTrace.traceNotImplemented("std.rotate type$iterator");
//    throw new UnsupportedOperationException();
    return (ForwardIt) first.$add(last.$sub(n_first));
  }

//
//  public static <_InputIterator extends type$iterator<?, std.string>> _InputIterator find(_InputIterator start, _InputIterator end, CharSequence str) {
//    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    return find(start, end, new std.string(str));
//  }

  /**
   * The strrchr() function locates the last occurrence of c (converted
   * to a char) in the string pointed to by s. The terminating null
   * character is considered to be part of the string. 
   * 
   * Return value
   * The strrchr() function returns a pointer to the located character,
   * or a null pointer if c does not occur in the string.
   *
   * @param str
   * @param ch
   * @return 
   */
  public static char$ptr strrchr(char$ptr str, byte ch) {
    int idx = 0;
    int lastChar = -1;
    do {
        if (str.$at(idx) == ch) {
            lastChar = idx;
        }
    } while(str.$at(idx++) != $$TERM);
    if (lastChar == -1) {
      return null;
    } else if (lastChar == 0) {
      return str;
    } else {
      return str.$add(lastChar);
    }
  }
  public static char$ptr strrchr(char$ptr str, char ch) {
    return strrchr(str, (byte)ch);
  }

  /**
   * 
   *
   * The strchr() function locates the ﬁrst occurrence of c (converted
   * to a char) in the string pointed to by s. The terminating null
   * character is considered to be part of the string. 
   * 
   * Return value
   *
   * The strchr() function returns a pointer to the located character,
   * or a null pointer if the character does not occur in the string.
   *
   * @param str
   * @param ch
   * @return 
   */
  public static char$ptr strchr(char$ptr str, byte ch) {
    int idx = 0;
    while (str.$at(idx) != ch) {
      if (str.$at(idx++) == $$TERM) {
        return null;
      }
    }
    return idx == 0 ? str : str.$add(idx);
  }
  public static char$ptr strchr(char$ptr str, int ch) {
    return strchr(str, (byte) ch);
  }
  public static char$ptr strchr(char$ptr str, char ch) {
    return strchr(str, (byte) ch);
  }
  
  public static char$ptr strchr(CharSequence str, int ch) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == (char)ch) {
        return create_char$ptr(str, i);
      }
    }
    return null;
  }


  /**
   *
   * The  strstr() function finds the first occurrence of the substring nee-
   * dle in the string haystack.  The terminating `\0'  characters  are  not
   * compared.
   *
   * The  strcasestr()  function  is	like strstr(), but ignores the case of
   * both arguments.
   *
   * @param haystack
   * @param needle
   * @return
   *   These functions return a pointer to the beginning of the substring,  or
   *  NULL if the substring is not found.
   */
  public static char$ptr strstr(char$ptr haystack, char$ptr needle) {
    String left = new std.string(haystack).toJavaString();
    String right = new std.string(needle).toJavaString();
    int indexOf = left.indexOf(right);
    if (indexOf < 0) {
      return null;
    }
    return haystack.$add(indexOf);
  }

  public static char$ptr strstr(char$ptr haystack, CharSequence needle) {
    return strstr(haystack, create_char$ptr(needle));
  }
  public static char$ptr strstr(CharSequence haystack, CharSequence needle) {
    return strstr(create_char$ptr(haystack), create_char$ptr(needle));
  }
  public static char$ptr strstr(CharSequence haystack, char$ptr needle) {
    return strstr(create_char$ptr(haystack), needle);
  }


  public static char$ptr strpbrk(char$ptr __s1, /*const char P*/ CharSequence __s2) {
    for(int pos1 = 0, curr1; (curr1 = __s1.$at(pos1)) != $$TERM; pos1++) {
      for(int pos2 = 0, curr2; (curr2 = __s2.charAt(pos2)) != $$TERM; pos2++) {
        if (curr1 == curr2) {
          return __s1.$add(pos1);
        }
      }
    }
    return null;
  }

  public static char$ptr strpbrk(CharSequence __s1, /*const char P*/ CharSequence __s2) {
    throw new UnsupportedOperationException();
  }

  public static char$ptr strpbrk(char$ptr __s1, /*const char P*/ char$ptr __s2) {
    for(int pos1 = 0, curr1; (curr1 = __s1.$at(pos1)) != $$TERM; pos1++) {
      for(int pos2 = 0, curr2; (curr2 = __s2.$at(pos2)) != $$TERM; pos2++) {
        if (curr1 == curr2) {
          return __s1.$add(pos1);
        }
      }
    }
    return null;
  }

  public static int strcmp(char$ptr str1, char$ptr str2) {
    int pos = 0, ch1, ch2;
    while ((ch1 = str1.$at(pos)) == (ch2 = str2.$at(pos))) {
      if (ch1 == 0) {
        return 0;
      }
      pos++;
    }
    return ch1 - ch2; // works for ascii chars
  }

  public static int strcmp(CharSequence str1, char$ptr str2) {
    return strcmp(create_char$ptr(str1), str2);
  }

  public static int strcmp(char$ptr str1, CharSequence str2) {
    // check for isNull?
    if (false/*?*/ && str1.$isNull()) {
      return str2 == null ? 0 : -1;
    }
    return strcmp(str1, create_char$ptr(str2));
  }

  public static int strcmp(CharSequence str1, CharSequence str2) {
    return strcmp(create_char$ptr(str1), create_char$ptr(str2));
  }

  public static int strncmp(char$ptr str1, char$ptr str2, int len) {
    int pos = 0, ch1 = 0, ch2 = 0;
    while (pos < len && (ch1 = str1.$at(pos)) == (ch2 = str2.$at(pos))) {
      if (ch1 == 0) {
        return 0;
      }
      pos++;
    }
    return pos == len ? 0 : ch1 - ch2; // works for ascii chars
  }

  public static int strncmp(CharSequence str1, char$ptr str2, int len) {
    throw new UnsupportedOperationException();
  }

  public static int strncmp(CharSequence str1, CharSequence str2, int len) {
    throw new UnsupportedOperationException();
  }

  public static int strnlen(char$ptr str, int max_len) {
    assert max_len >= 0;
    int len = 0;
    while (len < max_len && (str.$at(len) != $$TERM)) {
      len++;
    }
    return len;    
  }

  public static int strlen(CharSequence str) {
    return str.length();
  }

  public static int strlen(/*char*/byte buf[]) {
    return strlen(buf, 0);
  }
  
  public static int strlen(/*char*/byte buf[], int fromIdx) {
    int len = 0;
    while (buf[fromIdx++] != $$TERM) {
      len++;
    }
    return len;
  }

  public static int strlen(char$ptr str) {
    int len = 0;
    while (str.$at(len) != $$TERM) {
      len++;
    }
    return len;
  }

  public static int strlen(char$iterator<?> str) {
    str = $tryClone(str);
    int len = 0;
    while (str.$star() != $$TERM) {
      str.$preInc();
      len++;
    }
    return len;
  }
  
  // char *strncpy( char *dest, const char *src, std::size_t count );
  /**
   * Copies at most count characters of the byte string pointed to by src 
   * (including the terminating null character) to character array pointed 
   * to by dest.
   *
   *  If count is reached before the entire string src was copied, the resulting 
   *  character array is not null-terminated.
   *
   *  If, after copying the terminating null character from src, count is not
   *  reached, additional null characters are written to dest until the total
   *  of count characters have been written.
   *
   *  If the strings overlap, the behavior is undefined.
   *  Parameters
   *  dest 	- 	pointer to the character array to copy to
   *  src 	- 	pointer to the byte string to copy from
   *  count 	- 	maximum number of characters to copy
   *  
   *  Return value
   *  dest
   */
	public static char$ptr strncpy(char$ptr dest, char$ptr src, /*uint*/int count) {
    int curInd = 0;
    byte curChr;
    while (curInd < count && (curChr = src.$at(curInd)) != $$TERM) {
      dest.$set(curInd, curChr);
      ++curInd;
    }
    while (curInd < count) {
      dest.$set(curInd, $$TERM);
      ++curInd;
    }
    return dest;
  }
  public static char$ptr strncpy(char$ptr dest, String src, /*uint*/int count) {
    return strncpy(dest, create_char$ptr(src), count);
  }
  
  /* Return the length of the initial segment of S which
     consists entirely of characters not in REJECT.  */
  public static /*size_t*/int strcspn(/*const*/char$ptr/*char P*/ string, /*const*/char$ptr/*char P*/ reject) {
    int i;
    int j;

    for (i = 0; Native.$bool(string) && (string.$at(i) != 0); i++) {
      for (j = 0; Native.$bool(reject) && (reject.$at(j) != 0); j++) {
        if (string.$at(i) == reject.$at(j)) {
          break;
        }
      }
      if (Native.$bool(reject) && (reject.$at(j) != 0)) {
        break;
      }
    }
    return i;
  }

  
  /*
   *----------------------------------------------------------------------
   *
   * strspn --
   *
   *   C  o mpute the length of the  maximum initial segment of "string"
   *   w  h ose characters all are  in "chars".
   *
   * Results:
   *   T  h e return value is the l ength of the initial segment (0 if the
   *   f  i rst character isn't in  "chars".
   *
   * Side effects:
   *   N  o ne.
   *
   *----------------------------------------------------------------------
   */
  public static int strspn(char$ptr/*char P*/ string, char$ptr/*char P*/ chars) {
    /*register*/ /*char*/byte c;
    /*register*/ char$ptr/*char P*/ p;
    /*register*/ char$ptr/*char P*/ s;

    next:
    for (s = $tryClone(string) , c = s.$star(); c != 0; s.$postInc() , c = s.$star()) {
      for (p = $tryClone(chars); p.$star() != 0; p.$postInc()) {
        if (c == p.$star()) {
          continue next;
        }
      }
      break;
    }
    return s.$sub(string);
  }
  
  /**
   * Searches within the first num bytes of the block of memory pointed by ptr
   * for the first occurrence of value (interpreted as an unsigned char), and
   * returns a pointer to it.
   *
   * Both value and each of the bytes checked on the the ptr array are
   * interpreted as unsigned char for the comparison.
   * @param ptr Pointer to the block of memory where the search is performed.
   * @param value Value to be located. The value is passed as an int, but the
   * function performs a byte per byte search using the unsigned char conversion
   * of this value.
   * @param num Number of bytes to be analyzed. size_t is an unsigned integral
   * type.
   * @return A pointer to the first occurrence of value in the block of memory
   * pointed by ptr. If the value is not found, the function returns a null
   * pointer.
   */
  public static char$ptr memchr(char$ptr ptr, /*uchar*/byte value, /*size_t*/int num) {    
    for (int i = 0; i < num; i++) {
      if (ptr.$at(i) == value) {
        return ptr.$add(i);
      }
    }
    return null;
  }
  
  public static pairBoolChar make_pair_bool_char(boolean a, byte b) {
    return new std.pairBoolChar(a, b);
  }

  public static <T> pairBoolType make_pair_bool_T(boolean a, T b) {
    return new std.pairBoolType<T>(a, b);
  }

  public static pairUIntChar make_pair_uint_char(/*uint*/int a, byte b) {
    return new std.pairUIntChar(a, b);
  }

  public static pairULongChar make_pair_ulong_char(/*ulong*/long a, byte b) {
    return new std.pairULongChar(a, b);
  }

  public static pairIntInt make_pair_int_int(int a, int b) {
    return new std.pairIntInt(a, b);
  }

  public static pairUIntUInt make_pair_int2uint_int2uint(int a, int b) {
    return new std.pairUIntUInt(a, b);
  }

  public static pairIntUInt make_pair_int_uint(int a, /*uint*/int b) {
    return new std.pairIntUInt(a, b);
  }

  public static <T> pairIntType<T> make_pair_int_T(int a, T b) {
    return new std.pairIntType(a, b);
  }

  public static <T> pairIntPtr<T> make_pair_int_Ptr(int a, T/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairIntPtr(a, b);
  }

  public static pairUShortUInt make_pair_ushort_uint(/*ushort*/char a, /*uint*/int b) {
    return new std.pairUShortUInt(a, b);
  }

  public static pairUIntUInt make_pair_uint_uint(/*uint*/int a, /*uint*/int b) {
    return new std.pairUIntUInt(a, b);
  }

  public static pairUIntUInt make_pair_uint_int2uint(/*uint*/int a, int b) {
    return new std.pairUIntUInt(a, b);
  }

  public static pairUIntInt make_pair_uint_int(/*uint*/int a, /*int*/int b) {
    return new std.pairUIntInt(a, b);
  }

  public static pairULongULong make_pair_ullong_ullong(/*uint*/long a, /*uint*/long b) {
    return new std.pairULongULong(a, b);
  }

  public static pairUIntBool make_pair_uint_bool(/*uint*/int a, boolean b) {
    return new std.pairUIntBool(a, b);
  }

  public static <T> pairUIntType<T> make_pair_uint_T(/*uint*/int a, T b) {
    return new std.pairUIntType<T>(a, b);
  }
  
  public static <T> pairULongType<T> make_pair_ulong_T(/*ulong*/long a, T b) {
    return new std.pairULongType<T>(a, b);
  }

  public static <T> pairULongType<T> make_pair_ullong_T(/*ulong*/long a, T b) {
    return new std.pairULongType<T>(a, b);
  }

  public static pairULongUInt make_pair_ulong_uint(/*ulong*/long a, /*uint*/int b) {
    return new std.pairULongUInt(a, b);
  }

  public static pairULongUInt make_pair_ullong_uint(/*ulong*/long a, /*uint*/int b) {
    return new std.pairULongUInt(a, b);
  }

  public static pairULongBool make_pair_ullong_bool(long a, boolean b) {
    return new std.pairULongBool(a, b);
  }

  public static <T> pairUIntPtr<T> make_pair_uint_Ptr(/*uint*/int a, T/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairUIntPtr<T>(a, b);
  }

  public static <T> pairUIntType<T> make_pair_uint_int2T(/*uint*/int a, T b) {
    return new std.pairUIntType<T>(a, b);
  }

  public static <T> pairUIntType<T> make_pair_uint_Ptr2T(/*uint*/int a, T b) {
    return new std.pairUIntType<T>(a, b);
  }

  public static <T> pairULongPtr<T> make_pair_ulong_Ptr(/*uint*/long a, T/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairULongPtr<T>(a, b);
  }

  public static <T> pairULongPtr<T> make_pair_ullong_Ptr(/*uint*/long a, T/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairULongPtr<T>(a, b);
  }

  public static <T> pairUCharType<T> make_pair_uchar_T(/*uchar*/byte a, T b) {
    return new std.pairUCharType(a, b);
  }

  public static <T> pairTypeLong<T> make_pair_T_long(T a, long b) {
    return new std.pairTypeLong<>(a, b);
  }

  public static <T> pairTypeUInt<T> make_pair_T_uint(T a, /*uint*/int b) {
    return new std.pairTypeUInt(a, b);
  }

  public static <T> pairTypeUIntptr_t<T> make_pair_T_UIntptr_t(T a, /*UIntptr_t*/Object b) {
    return new std.pairTypeUIntptr_t(a, b);
  }

  public static <T> pairTypeULong<T> make_pair_T_ulong(T a, long b) {
    return new std.pairTypeULong<>(a, b);
  }

  public static <T> pairTypeULLong<T> make_pair_T_ullong(T a, long b) {
    return new std.pairTypeULLong<>(a, b);
  }

  public static <T> pairTypeInt<T> make_pair_T_int(T a, int b) {
    return new std.pairTypeInt(a, b);
  }

  public static <T> pairTypeInt<T> make_pair_T_int(T a, int$ref b) {
    return new std.pairTypeInt(a, b.$deref());
  }

  public static <T> pairTypeInt<T> make_pair_E_int(T a, int b) {
    return new std.pairTypeInt(a, b);
  }

  public static <T> pairTypeUInt<T> make_pair_E_int2uint(T a, int b) {
    return new std.pairTypeUInt(a, b);
  }

  public static <T> pairTypeChar<T> make_pair_T_char(T a, byte b) {
    return new std.pairTypeChar(a, b);
  }

  public static <T> pairTypeBool<T> make_pair_T_bool(T a, boolean b) {
    return new std.pairTypeBool(a, b);
  }

  public static <T> pairTypeBool<T> make_pair_T_boolean(T a, boolean b) {
    return new std.pairTypeBool(a, b);
  }

  public static <T> pairPtrBool<T> make_pair_Ptr_boolean(T a, boolean b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrBool(a, b);
  }

  public static <T> pairTypeBool<T> make_pair_nullptr_t_bool(T nullptr, boolean b) {
    assert nullptr == null;
    return new std.pairPtrBool(nullptr, b);
  }
  
  public static <A, B> pairTypeType<A, B> make_pair(A a, B b) {
    return new std.pairTypeType<A, B>(a, b);
  }
  
  public static <A, B> pairTypeType<A, B> make_pair_T_T(A a, B b) {
    return new std.pairTypeType<A, B>(a, b);
  }

  public static <T, V> pairTypeType<T, V> make_pair_T2T_T(T a, V b) {
    return new std.pairTypeType(a, b);
  }
  
  public static <T, V> pairTypeType<T, V> make_pair_T_T2T(T a, V b) {
    return new std.pairTypeType(a, b);
  }
  
  public static <T, V> pairTypeType<T, V> make_pair_Ptr2T_T(T a, V b) {
    return new std.pairTypeType(a, b);
  }
  
  public static <T, V> pairTypeType<T, V> make_pair_T_Ptr2T(T a, V b) {
    return new std.pairTypeType(a, b);
  }

  public static <T, V> pairTypeType<T, V> make_pair_Ptr2T_Ptr2T(T a, V b) {
    return new std.pairTypeType(a, b);
  }
  
  public static <T, V> pairTypeType<T, V> make_pair_T_nullptr_t2T(T a, V b) {
    return new std.pairTypeType(a, b);
  }
  
  public static <A, B> pairTypeType<A, B> make_pair_E_T(A a, B b) {
    return new std.pairTypeType<A, B>(a, b);
  }
  
  public static <A, B> pairTypePtr<A, B> make_pair_E_Ptr(A a, B/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairTypePtr<A, B>(a, b);
  }
  
  public static <A, B> pairTypeType<A, B> make_pair_T_E(A a, B/*P*/ b) {
    return new std.pairTypeType<A, B>(a, b);
  }
  
  public static <A, B> pairPtrType<A, B> make_pair_Ptr_E(A a, B/*P*/ b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrType<A, B>(a, b);
  }

  public static <A, B> pairTypePtr<A, B> make_pair_T_Ptr(A a, B/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairTypePtr<A, B>(a, b);
  }
  
  public static <A, B> pairTypePtr<A, B> make_pair_T2T_Ptr(A a, B/*P*/ b) {
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairTypePtr<A, B>(a, b);
  }
  
  public static <T, V> pairPtrPtr<T, V> make_pair_Ptr_Ptr(T/*P*/ a, V/*P*/ b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    assert !(b instanceof void$ptr) : "unexpected as JavaPtr: " + b.getClass();
    return new std.pairPtrPtr(a, b);
  }

  public static <T, V> pairPtrType<T, V> make_pair_Ptr_T(T/*P*/ a, V b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrType(a, b);
  }
  
  public static <T1, T2> pairTypePtr<T1, T2> make_pair_T_nullptr_t(T1 a, T2/*P*/ nullptr) {
    assert nullptr == null;
    return new std.pairTypePtr(a, nullptr);
  }

  public static <T1, T2> pairPtrType<T1, T2> make_pair_nullptr_t_T(T1/*P*/ nullptr, T2 b) {
    assert nullptr == null;
    return new std.pairPtrType(nullptr, b);
  }
  
  public static <T1, T2> pairPtrPtr<T1, T2> make_pair_nullptr_t_nullptr_t(T1/*P*/ nullptr1, T2/*P*/ nullptr2) {
    assert nullptr1 == null;
    assert nullptr2 == null;
    return new std.pairPtrPtr(nullptr1, nullptr2);
  }

  public static <T> pairPtrBool<T> make_pair_Ptr_bool(T/*P*/ a, boolean b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrBool(a, b);
  }

  public static <T> pairPtrUInt<T> make_pair_Ptr_uint(T/*P*/ a, /*uint*/int b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrUInt(a, b);
  }
  
  public static <T> pairPtrUInt<T> make_pair_Ptr_ulong2uint(T/*P*/ a, /*ulong*/long b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrUInt(a, $ulong2uint(b));
  }
  
  public static <T> pairPtrULong<T> make_pair_Ptr_uint2ulong(T/*P*/ a, /*uint*/int ui) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrULong(a, $uint2ulong(ui));
  }
  
  public static <T> pairPtrUInt<T> make_pair_Ptr_bool2uint(T/*P*/ a, boolean b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrUInt(a, b ? 1 : 0);
  }
  
  public static <T>  pairPtrULong<T> make_pair_Ptr_ulong(T/*P*/ a, /*unsigned long*/long b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrULong<T>(a, b);
  }
  
  public static <T>  pairPtrULLong<T> make_pair_Ptr_ullong(T/*P*/ a, /*unsigned long long*/long b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new  pairPtrULLong<T>(a, b);
  }

  public static <T> pairPtrInt<T> make_pair_Ptr_int(T/*P*/ a, int b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrInt(a, b);
  }

  public static <T> pairPtrInt<T> make_pair_Ptr_uint2int(T/*P*/ a, /*uint*/int b) {
    assert !(a instanceof void$ptr) : "unexpected as JavaPtr: " + a.getClass();
    return new std.pairPtrInt(a, b);
  }

  public static <T> pairTypeBool<T> make_pair_E_boolean(T a, boolean b) {
    return new std.pairTypeBool(a, b);
  }

  public static <T> pairTypeBool<T> make_pair_E_bool(T a, boolean b) {
    return new std.pairTypeBool(a, b);
  }

  public static <T> boolean $eq_pair$_T1$_T2$C(T pair1, T pair2) {
    return Native.$eq(pair1, pair2);
  }
  
  public static <T> boolean $noteq_pair$_T1$_T2$C(T pair1, T pair2) {
    return !$eq_pair$_T1$_T2$C(pair1, pair2);
  }
  
  public static boolean $eq_pair$_T1$_T2$C(pairUIntUInt pair1, pairUIntUInt pair2) {
    return pair1.$eq(pair2);
  }
  
  public static boolean $noteq_pair$_T1$_T2$C(pairUIntUInt pair1, pairUIntUInt pair2) {
    return !$eq_pair$_T1$_T2$C(pair1, pair2);
  }
  
  public static <T> T multiplies(T T1, T T2) {
    throw new UnsupportedOperationException();
  }
  public static <T> T plus(T T1, T T2) {
    throw new UnsupportedOperationException();
  }
  public static <T> T minus(T T1, T T2) {
    throw new UnsupportedOperationException();
  }
  
  /**
   *  @brief Determines whether an element exists in a range.
   *  @ingroup binary_search_algorithms
   *  @param  __first   An iterator.
   *  @param  __last    Another iterator.
   *  @param  __val     The search term.
   *  @return True if @p __val (or its equivalent) is in [@p
   *  __first,@p __last ].
   *
   *  Note that this does not actually return an iterator to @p __val.  For
   *  that, use std::find or a container's specialized find member functions.
  */
  public static <_ForwardIterator extends type$iterator<?, ?>>
  boolean
  binary_search(_ForwardIterator __first, _ForwardIterator __last,
                Comparable __val)
  {

    _ForwardIterator __i = std.lower_bound(__first, __last, __val);
    return __i.$noteq(__last) && !(Native.$less(__val, __i.$star()));
  }
  
  public static <T, Iter extends type$iterator<Iter, T>>
  boolean binary_search(Iter __first, Iter __last, T __val, Compare<? super T> compar) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }


  /**
   * @brief Finds the first position in which @a val could be inserted without
   * changing the ordering.
   * @ingroup binary_search_algorithms
   * @param first An iterator.
   * @param last Another iterator.
   * @param val The search term.
   * @param comp A functor to use for comparisons.
   * @return An iterator pointing to the first element <em>not less than</em> @a
   * val, or end() if every element is less than @a val.
   * @ingroup binary_search_algorithms
   *
   * The comparison function should have the same effects on ordering as the
   * function used for the initial sort.
   */
  public static <_FI extends type$iterator<?, ?>, _Tp> _FI lower_bound(_FI __first, _FI __last, _Tp __val) {
    ComparatorLower<Object, _Tp> comparator = new ComparatorLower<Object, _Tp>() {

      @Override
      public boolean $less(Object LHS, _Tp RHS) {
        return Native.$less(LHS, RHS);
      }
    };
    return lower_bound(__first, __last, __val, comparator);
  }


  public static <T, V> type$ptr<T> lower_bound(T[] arr, V val, Native.ComparatorLower<T, V> comp) {
    type$ptr<T> arPtr = create_type$ptr(arr);
    return lower_bound(arPtr, arPtr.$add(arr.length), val, comp);
  }

  public static <_ForwardIterator extends type$iterator<?, ?>, _Tp> _ForwardIterator lower_bound(_ForwardIterator __first, _ForwardIterator __last,
          _Tp __val, Native.ComparatorLower<?, ?> comp) {
    Native.ComparatorLower __comp = comp;
    int __len = std.distance(__first, __last);
    _ForwardIterator _first = $tryClone(__first);

    while (__len > 0) {
      int __half = __len >>> 1;
      _ForwardIterator __middle = $tryClone(_first);
      std.advance(__middle, __half);
      if (__comp.$less(__middle.$star(), __val)) {
        _first = (_ForwardIterator) __middle.$add(1);
        __len -= __half + 1;
      } else {
        __len = __half;
      }
    }
    return _first;
  }

  public static <_Tp> uint$ptr lower_bound(uint$ptr __first, uint$ptr __last, _Tp __val, Native.ComparatorLower<?, ?> comp) {
    Native.ComparatorLower __comp = comp;
    int __len = std.distance(__first, __last);
    uint$ptr _first = $tryClone(__first);

    while (__len > 0) {
      int __half = __len >>> 1;
      uint$ptr __middle = $tryClone(_first);
      std.advance(__middle, __half);
      if (__comp.$less(__middle.$star(), __val)) {
        _first = (uint$ptr) __middle.$add(1);
        __len -= __half + 1;
      } else {
        __len = __half;
      }
    }
    return _first;
  }

  /**
   * @brief Finds the first position in which @a val could be inserted without
   * changing the ordering.
   * @param __first An iterator.
   * @param __last Another iterator.
   * @param __val The search term.
   * @return An iterator pointing to the first element <em>not less than</em> @a
   * val, or end() if every element is less than
   * @a val.
   * @ingroup binary_search_algorithms
   */
  public static uint$ptr lower_bound_uint(uint$ptr __first, uint$ptr __last, /*uint*/int __val) {
    int __lower_index = lower_bound_uint(__first, 0, std.distance(__first, __last), __val);
    return __first.$add(__lower_index);
  }

  /**
   * @param ptr pointer
   * @param __first start index (ptr.$add(__first))
   * @param __last  last index (replacement for ptr.$add(__last))
   * @param __val searched value
   * @return  index which can be used as ptr.$add(idx)
   */
  public static int lower_bound_uint(uint$ptr ptr, int __first, int __last, /*uint*/int __val) {
    int __len = std.distance(__first, __last);

    while (__len > 0) {
      int __half = __len >>> 1;
      int __middle = __first + __half;
      if (ptr.$at(__middle) < __val) {
        __first = __middle + 1;
        __len -= __half + 1;
      } else {
        __len = __half;
      }
    }
    return __first;
  }

  /**
   * @brief Finds the first position in which @a val could be inserted without
   * changing the ordering.
   * @param first An iterator.
   * @param last Another iterator.
   * @param val The search term.
   * @return An iterator pointing to the first element <em>not less than</em> @a
   * val, or end() if every element is less than
   * @a val.
   * @ingroup binary_search_algorithms
   */  
  public static int$ptr lower_bound_int(int$ptr __first, int$ptr __last, int __val) {
    int __lower_index = lower_bound_int(__first, 0, std.distance(__first, __last), __val);
    return __first.$add(__lower_index);
  }

  /**
   * @param ptr pointer
   * @param __first start index (ptr.$add(__first))
   * @param __last  last index (replacement for ptr.$add(__last))
   * @param __val searched value
   * @return  index which can be used as ptr.$add(idx)
   */
  public static int lower_bound_int(int$ptr ptr, int __first, int __last, int __val) {
    int __len = std.distance(__first, __last);

    while (__len > 0) {
      int __half = __len >>> 1;
      int __middle = __first + __half;
      if (ptr.$at(__middle) < __val) {
        __first = __middle + 1;
        __len -= __half + 1;
      } else {
        __len = __half;
      }
    }
    return __first;
  }
  
  public static int lower_bound_int(int[] ptr, int __first, int __last, int __val) {
    int __len = std.distance(__first, __last);

    while (__len > 0) {
      int __half = __len >>> 1;
      int __middle = __first + __half;
      if (ptr[__middle] < __val) {
        __first = __middle + 1;
        __len -= __half + 1;
      } else {
        __len = __half;
      }
    }
    return __first;
  }
  
  public static <_ForwardIterator extends type$iterator<?, ?>, _Tp> _ForwardIterator upper_bound(_ForwardIterator __first, _ForwardIterator __last, _Tp __val) {
    return upper_bound(__first, __last, __val, new Native.ComparatorLower<_Tp,Object>() {

      @Override
      public boolean $less(_Tp one, Object other) {
        return Native.$less(one, other);
      }
    });
  }
  
  public static <_ForwardIterator extends type$iterator<?, ?>, _Tp> _ForwardIterator upper_bound(_ForwardIterator __first, _ForwardIterator __last, _Tp __val, Native.ComparatorLower<?,?> comp) {
    Native.ComparatorLower __comp = comp;
    int __len = std.distance(__first, __last);
    int __half;
    _ForwardIterator __middle = null;

    while (__len > 0) {
      __half = __len >>> 1;
      __middle = $tryClone(__first);
      std.advance(__middle, __half);
      if (__comp.$less(__val, __middle.$star())) {
        __len = __half;
      } else {
        __first = __middle;
        __first.$preInc();
        __len -= __half + 1;
      }
    }
    return __first;
  }

  public static <_Tp> uint$ptr upper_bound(uint$ptr __first, uint$ptr __last, _Tp __val, Native.ComparatorLower<?,?> comp) {
    Native.ComparatorLower __comp = comp;
    int __len = std.distance(__first, __last);
    int __half;
    uint$ptr __middle = null;

    while (__len > 0) {
      __half = __len >>> 1;
      __middle = $tryClone(__first);
      std.advance(__middle, __half);
      if (__comp.$less(__val, __middle.$star())) {
        __len = __half;
      } else {
        __first = __middle;
        __first.$preInc();
        __len -= __half + 1;
      }
    }
    return __first;
  }

  public static ulong$ptr upper_bound_ulong(ulong$ptr __first, ulong$ptr __last, /*ulong*/long __val) {
    int __upper_index = upper_bound_ulong(__first, 0, std.distance(__first, __last), __val);
    return __first.$add(__upper_index);
  }

  public static int upper_bound_ulong(ulong$ptr ptr, int __first, int __last, /*ulong*/long __val) {
    int __len = std.distance(__first, __last);
    int __half;
    int __middle;

    while (__len > 0) {
      __half = __len >>> 1;
      __middle = __first;
      __middle += __half;
      if (__val < __middle) {
        __len = __half;
      } else {
        __first = __middle;
        ++__first;
        __len -= __half + 1;
      }
    }
    return __first;
  }

  public static uint$ptr upper_bound_uint(uint$ptr __first, uint$ptr __last, /*uint*/int __val) {
    int __upper_index = upper_bound_uint(__first, 0, std.distance(__first, __last), __val);
    return __first.$add(__upper_index);
  }

  public static int upper_bound_uint(uint$ptr ptr, int __first, int __last, /*uint*/int __val) {
    int __len = std.distance(__first, __last);
    int __half;
    int __middle;

    while (__len > 0) {
      __half = __len >>> 1;
      __middle = __first;
      __middle += __half;
      if (__val < __middle) {
        __len = __half;
      } else {
        __first = __middle;
        ++__first;
        __len -= __half + 1;
      }
    }
    return __first;
  }

  public static int$ptr upper_bound_int(int$ptr __first, int$ptr __last, /*uint*/int __val) {
    int __upper_index = upper_bound_int(__first, 0, std.distance(__first, __last), __val);
    return __first.$add(__upper_index);
  }

  public static int upper_bound_int(int$ptr ptr, int __first, int __last, /*uint*/int __val) {
    int __len = std.distance(__first, __last);
    int __half;
    int __middle;

    while (__len > 0) {
      __half = __len >>> 1;
      __middle = __first;
      __middle += __half;
      if (__val < __middle) {
        __len = __half;
      } else {
        __first = __middle;
        ++__first;
        __len -= __half + 1;
      }
    }
    return __first;
  }
  
  public static <P> type$ptr<P> upper_bound(type$ptr<P> __first, type$ptr<P> __last, P __val, ComparatorLower<P, P> __comp) {
    int __len = std.distance(__first, __last);
    int __half;
    type$ptr<P> __middle = null;

    while (__len > 0) {
      __half = __len >>> 1;
      __middle = $tryClone(__first);
      std.advance(__middle, __half);
      if (__comp.$less(__val, __middle.$star())) {
        __len = __half;
      } else {
        __first = __middle;
        __first.$preInc();
        __len -= __half + 1;
      }
    }
    return __first;
  }

  public static void reverse(final char$ptr __first, final char$ptr __last) {
    assert __first.isComparableTo(__last);
    int dist = __last.$sub(__first);
    // work without $tryClone
    assert dist >= 0;
    int idxFirst = 0;
    int idxLast = -1;
    while (dist > 1) {
      std.iter_swap(__first, idxFirst, __last, idxLast);
      // move
      idxFirst++;
      idxLast--;
      dist -= 2;
    }
  }

  public static void reverse(char$iterator __first, char$iterator __last) {
    if (__first.$eq(__last)) {
      return;
    }
    char$iterator first = $tryClone(__first);
    char$iterator last = $tryClone(__last);
    while (first.$noteq(last) && first.$noteq(last.$preDec())) {
      iter_swap(first, last);
      first.$preInc();
    }
  }

  public static void reverse(type$iterator<?, ?> __first, type$iterator<?, ?> __last) {
    if (__first.$eq(__last)) {
      return;
    }
    type$iterator first = $tryClone(__first);
    type$iterator last = $tryClone(__last);
    while (first.$noteq(last) && first.$noteq(last.$preDec())) {
      iter_swap(first, last);
      first.$preInc();
    }
  }

  public static <_BidirectionalIterator> void reverse(_BidirectionalIterator __first, _BidirectionalIterator __last) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**
   * @brief A generalization of pointer arithmetic.
   * @param __first An input iterator.
   * @param __last An input iterator.
   * @return The distance between them.
   *
   * Returns @c n such that __first + n == __last. This requires that @p __last
   * must be reachable from @p __first. Note that @c n may be negative.
   *
   * For random access iterators, this uses their @c + and @c - operations and
   * are constant time. For other %iterator classes they are linear time.
   */
  public static <_InputIterator extends abstract_iterator> int distance(_InputIterator __first, _InputIterator __last) {
    if (__first == null && __last == null) {
      return 0;
    }
    int out;
    if (__first.getClass() == __last.getClass()) {
      out = __last.$sub(__first);
      // only org.llvm.support.sys.path.const_iterator has difference in $sub and $preInc count
      assert out == distanceImpl(__first, __last) || (__first.getClass().getCanonicalName().equals("org.llvm.support.sys.path.const_iterator")): "inconsistent std::distance. Incorrect interator clone/$noteq implementation? " + __first.getClass() + " && " + __last.getClass();
    } else {
      out = distance(__first, __last, JD$FAKE.TRAILING);
    }
    return out;
  }
  
  public static <T> int distance(type$ptr<T> __first, type$ptr<T> __last) {
    if (__first == null && __last == null) {
      return 0;
    }
    int out;
    if (__first.getClass() == __last.getClass()) {
      out = __last.$sub(__first);
      assert out == distanceImpl(__first, __last) : "inconsistent std::distance. Incorrect interator clone/$noteq implementation? " + __first.getClass() + " && " + __last.getClass();
    } else {
      out = distance(__first, __last, JD$FAKE.TRAILING);
    }
    return out;
  }
  
  public static <_InputIterator extends abstract_iterator> int distance(_InputIterator __first, _InputIterator __last, JD$FAKE dummy) {
    if (__first == null && __last == null) {
      return 0;
    }
    int dist = distanceImpl(__first, __last);
    assert dist == distanceImpl(__first, __last) : "inconsistent std::distance. Incorrect interator clone/$noteq implementation? " + __first.getClass() + " && " + __last.getClass();
    return dist;    
  }
  
  private static <_InputIterator extends abstract_iterator> int distanceImpl(_InputIterator __first, _InputIterator __last) {
    assert (__first != null && __last != null);
    int dist = 0;
    _InputIterator iter = $Clone(__first);

    while (iter.$noteq(__last)) {
      iter.$preInc();
      ++dist;
    }

    return dist;    
  }
  
  public static int distance(int __first, int __last) {
      return __last - __first;
  }
  
  public static /*uid_t*/int getuid() {
    // FIXME: use user's hashcode for now
    String user = System.getProperty("user.name");
    if (user != null) {
      return user.hashCode();
    }
    return 0;
  }

  public static <T, Iter extends type$iterator<Iter, T>> Iter __adjacent_find(Iter __first, Iter __last, TypeType2Bool __binary_pred) {
    if ($eq_ptr(__first, __last)) {
      return __last;
    }
    Iter __next = __first;
    while ($noteq_ptr(__next.$preInc(), __last)) {
      if (__binary_pred.$call(__first.$star(), __next.$star())) {
        return __first;
      }
      __first = __next;
    }
    return __last;
  }
  
  /**
   *  @brief Copies the range [first,last) into result.
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *  @param  __result An output iterator.
   *  @return   __result + (__first - __last)
   *
   *  Like copy(), but does not require an initialized output range.
  */
  public static <OutIter extends type$iterator<OutIter, ? super T>, T> OutIter 
        uninitialized_copy(type$iterator<?, ? extends T> __first, type$iterator<?, ? extends T> __last, OutIter __result) {
    // in JAVA it is like copy
    return copy(__first, __last, __result);
  }

  public static <OutIter extends type$iterator<?, T>, T> OutIter 
        uninitialized_copy_n(type$iterator<?, T> __first, int n, OutIter __result) {
    type$iterator<?, ? extends T> first = __first.clone();
    OutIter result = $tryClone(__result);
    for (int i = 0; i < n; i++) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }
        
  public static <OutIter extends char$iterator, T> OutIter 
        uninitialized_copy(char$iterator<?> __first, char$iterator<?> __last, OutIter __result) {
    return copy(__first, __last, __result);
  }
        
  public static <OutIter extends int$iterator> OutIter 
        uninitialized_copy(int$iterator<?> __first, int$iterator<?> __last, OutIter __result) {
    return copy(__first, __last, __result);
  }
        
  public static <OutIter extends uint$iterator, T> OutIter 
        uninitialized_copy(uint$iterator<?> __first, uint$iterator<?> __last, OutIter __result) {
    return copy(__first, __last, __result);
  }
  
  public static <OutIter extends ulong$iterator, T> OutIter 
        uninitialized_copy(ulong$iterator<?> __first, ulong$iterator<?> __last, OutIter __result) {
    return copy(__first, __last, __result);
  }
  
  /**
   *  @brief Copies the range [first,last) into result.
   *  @ingroup mutating_algorithms
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *  @param  __result An output iterator.
   *  @return   result + (first - last)
   *
   *  This inline function will boil down to a call to @c memmove whenever
   *  possible.  Failing that, if random access iterators are passed, then the
   *  loop count will be known (and therefore a candidate for compiler
   *  optimizations such as unrolling).  Result may not be contained within
   *  [first,last); the copy_backward function should be used instead.
   *
   *  Note that the end of the output range is permitted to be contained
   *  within [first,last).
  */
  public static <OutIter extends type$iterator<OutIter, ? super T>, T> OutIter copy(
          type$iterator<?, ? extends T> __first, type$iterator<?, ? extends T> __last, OutIter __result) {
    return copy(__first, __last, __result, true);
  }
  public static <OutIter extends type$iterator<OutIter, ? super T>, T> OutIter copy(
          type$iterator<?, ? extends T> __first, type$iterator<?, ? extends T> __last, OutIter __result, boolean isDataPointerLike) 
  {
    if (__first.$eq(__last)) {
      return __result;
    }
    type$iterator<?, ? extends T> first = __first.clone();
    type$iterator<?, ? extends T> last = __last;
    OutIter result = __result.clone();
    while (first.$noteq(last)) {
      if (isDataPointerLike) {
        result.star$ref().$set(first.$star());
      } else {
        // Try set without cloning:
        result.star$ref().$set(first.$star());
        if (result.$star() == first.$star()) {
          // If failed ($set implementation is incorrect. Maybe due to performance reasons), clone and set
          result.star$ref().$set($tryClone(first.$star()));
        }
      }
      result.$preInc();
      first.$preInc();
    }
    return result;
  }
  public static <OutIter extends type$iterator<OutIter, OutTy>, OutTy, InTy> OutIter 
        copy(type$iterator<?, ? extends InTy> __first, type$iterator<?, ? extends InTy> __last, OutIter __result, Converter<InTy, OutTy> __converter) {
    OutIter result = __result.clone();
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    type$iterator<?, ? extends InTy> first = __first.clone();
    type$iterator<?, ? extends InTy> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(__converter.$call(first.$star()));
      result.$preInc();
      first.$preInc();
    }
    return result;
  }
  public static <OutIter extends type$iterator<OutIter, OutTy>, OutTy, InTy> OutIter 
        copy(type$iterator<?, ? extends InTy> __first, type$iterator<?, ? extends InTy> __last, OutIter __result, AssignIterator<InTy, OutTy> __assign) {
    OutIter result = __result.clone();
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    type$iterator<?, ? extends InTy> first = __first.clone();
    type$iterator<?, ? extends InTy> last = __last;
    while (first.$noteq(last)) {
      __assign.$call(first, result);
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends bool$iterator<OutIter>> OutIter copy(bool$iterator<?> __first, bool$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends bool$iterator<OutIter>> OutIter copy(bool$iterator<?> __first, bool$iterator<?> __last, OutIter __result)
  {
    OutIter result = __result.clone();
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    bool$iterator<?> first = __first.clone();
    bool$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static void copy(char$ptr ptr, /*size_t*/int ptrFromIdx, /*size_t*/int ptrToIdx, char$ptr dest, /*size_t*/int destIdx)
  {
    while (ptrFromIdx != ptrToIdx) {
      dest.$set(destIdx, ptr.$at(ptrFromIdx));
      ++ptrFromIdx;++destIdx;
    }
  }
  
  public static <OutIter extends char$iterator> OutIter copy(char$iterator<?> __first, char$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends char$iterator> OutIter copy(char$iterator<?> __first, char$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    char$iterator<?> first = __first.clone();
    char$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends int$iterator> OutIter copy(int$iterator<?> __first, int$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends int$iterator> OutIter copy(int$iterator<?> __first, int$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    int$iterator<?> first = __first.clone();
    int$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends ulong$iterator> OutIter copy(ulong$iterator<?> __first, ulong$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends ulong$iterator> OutIter copy(ulong$iterator<?> __first, ulong$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    ulong$iterator<?> first = __first.clone();
    ulong$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends long$iterator> OutIter copy(long$iterator<?> __first, long$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends long$iterator> OutIter copy(long$iterator<?> __first, long$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    long$iterator<?> first = __first.clone();
    long$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends short$iterator> OutIter copy(short$iterator<?> __first, short$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends short$iterator> OutIter copy(short$iterator<?> __first, short$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    short$iterator<?> first = __first.clone();
    short$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends float$iterator> OutIter copy(float$iterator<?> __first, float$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends float$iterator> OutIter copy(float$iterator<?> __first, float$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    float$iterator<?> first = __first.clone();
    float$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends double$iterator> OutIter copy(double$iterator<?> __first, double$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends double$iterator> OutIter copy(double$iterator<?> __first, double$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    double$iterator<?> first = __first.clone();
    double$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends uchar$iterator> OutIter copy(uchar$iterator<?> __first, uchar$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends uchar$iterator> OutIter copy(uchar$iterator<?> __first, uchar$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    uchar$iterator<?> first = __first.clone();
    uchar$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends uint$iterator> OutIter copy(uint$iterator<?> __first, uint$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends uint$iterator> OutIter copy(uint$iterator<?> __first, uint$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }
    uint$iterator<?> first = __first.clone();
    uint$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static <OutIter extends ushort$iterator> OutIter copy(ushort$iterator<?> __first, ushort$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy(__first, __last, __result);
  }
  public static <OutIter extends ushort$iterator> OutIter copy(ushort$iterator<?> __first, ushort$iterator<?> __last, OutIter __result)
  {
    OutIter result = $tryClone(__result);
    if (__first == null) {
      assert __last == null;
      return result;
    }    
    ushort$iterator<?> first = __first.clone();
    ushort$iterator<?> last = __last;
    while (first.$noteq(last)) {
      result.star$ref().$set(first.$star());
      result.$preInc();
      first.$preInc();
    }
    return result;
  }

  public static void copy(Object[] from, int startFrom, int count, Object[] to, int toIndex) {
    // only pointers are copied here
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }

  public static void copy(boolean[] from, int startFrom, int count, boolean[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static void copy(byte[] from, int startFrom, int count, byte[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static void copy(char[] from, int startFrom, int count, char[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static void copy(short[] from, int startFrom, int count, short[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static void copy(int[] from, int startFrom, int count, int[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static void copy(long[] from, int startFrom, int count, long[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static void copy(float[] from, int startFrom, int count, float[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }

  public static void copy(double[] from, int startFrom, int count, double[] to, int toIndex) {
    NativePointer.copy$Object(from, startFrom, to, toIndex, count);
  }
  
  public static <OutIter> OutIter copy(std.iterator __first, std.iterator __last, OutIter __result) {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  /**
   *  @brief Copies the range [first,last) into result.
   *  @ingroup mutating_algorithms
   *  @param  __first  A bidirectional iterator.
   *  @param  __last   A bidirectional iterator.
   *  @param  __result A bidirectional iterator.
   *  @return   result - (first - last)
   *
   *  The function has the same effect as copy, but starts at the end of the
   *  range and works its way to the start, returning the start of the result.
   *  This inline function will boil down to a call to @c memmove whenever
   *  possible.  Failing that, if random access iterators are passed, then the
   *  loop count will be known (and therefore a candidate for compiler
   *  optimizations such as unrolling).
   *
   *  Result may not be in the range [first,last).  Use copy instead.  Note
   *  that the start of the output range may overlap [first,last).
  */
  public static <OutIter extends type$iterator<OutIter, T>, T> OutIter copy_backward(
          type$iterator<?, T> __first, type$iterator<?, T> __last, OutIter __result) {
    return copy_backward(__first, __last, __result, true);
  }      
  public static <OutIter extends type$iterator<OutIter, T>, T> OutIter copy_backward(
          type$iterator<?, T> __first, type$iterator<?, T> __last, OutIter __result, boolean isDataPointerLike)
  {
    type$iterator<?, T> first = __first;
    type$iterator<?, T> last = __last.clone();
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      if (isDataPointerLike) {
        result.star$ref().$set(last.$star());
        assert (result.$star() == last.$star());
      } else {
        // Try set without cloning:
        result.star$ref().$set(last.$star());
        if (result.$star() == last.$star()) {
          // If failed ($set implementation is incorrect. Maybe due to performance reasons), clone and set
          result.star$ref().$set($tryClone(last.$star()));
        }
      }
    }
    return result;
  }

  public static <OutIter extends bool$iterator<OutIter>> OutIter copy_backward(bool$iterator<?> __first, bool$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends bool$iterator<OutIter>> OutIter copy_backward(bool$iterator<?> __first, bool$iterator<?> __last, OutIter __result)
  {
    bool$iterator<?> first = __first.clone();
    bool$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static void copy_backward(char$ptr src, /*size_t*/int srcDownToIdx, /*size_t*/int srcFromIdx, char$ptr dest, /*size_t*/int destIdx)
  {
    while (srcFromIdx != srcDownToIdx) {
      --srcFromIdx;--destIdx;
      dest.$set(destIdx, src.$at(srcFromIdx));
    }
  }
  
  public static <OutIter extends char$iterator<OutIter>> OutIter copy_backward(char$iterator<?> __first, char$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends char$iterator<OutIter>> OutIter copy_backward(char$iterator<?> __first, char$iterator<?> __last, OutIter __result)
  {
    char$iterator<?> first = __first.clone();
    char$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends int$iterator<OutIter>> OutIter copy_backward(int$iterator<?> __first, int$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends int$iterator<OutIter>> OutIter copy_backward(int$iterator<?> __first, int$iterator<?> __last, OutIter __result)
  {
    int$iterator<?> first = __first.clone();
    int$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends ulong$iterator<OutIter>> OutIter copy_backward(ulong$iterator<?> __first, ulong$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends ulong$iterator<OutIter>> OutIter copy_backward(ulong$iterator<?> __first, ulong$iterator<?> __last, OutIter __result)
  {
    ulong$iterator<?> first = __first.clone();
    ulong$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends long$iterator<OutIter>> OutIter copy_backward(long$iterator<?> __first, long$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends long$iterator<OutIter>> OutIter copy_backward(long$iterator<?> __first, long$iterator<?> __last, OutIter __result)
  {
    long$iterator<?> first = __first.clone();
    long$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends float$iterator<OutIter>> OutIter copy_backward(float$iterator<?> __first, float$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends float$iterator<OutIter>> OutIter copy_backward(float$iterator<?> __first, float$iterator<?> __last, OutIter __result)
  {
    float$iterator<?> first = __first.clone();
    float$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends double$iterator<OutIter>> OutIter copy_backward(double$iterator<?> __first, double$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends double$iterator<OutIter>> OutIter copy_backward(double$iterator<?> __first, double$iterator<?> __last, OutIter __result)
  {
    double$iterator<?> first = __first.clone();
    double$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends short$iterator<OutIter>> OutIter copy_backward(short$iterator<?> __first, short$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends short$iterator<OutIter>> OutIter copy_backward(short$iterator<?> __first, short$iterator<?> __last, OutIter __result)
  {
    short$iterator<?> first = __first.clone();
    short$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends uchar$iterator<OutIter>> OutIter copy_backward(uchar$iterator<?> __first, uchar$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends uchar$iterator<OutIter>> OutIter copy_backward(uchar$iterator<?> __first, uchar$iterator<?> __last, OutIter __result)
  {
    uchar$iterator<?> first = __first.clone();
    uchar$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends uint$iterator<OutIter>> OutIter copy_backward(uint$iterator<?> __first, uint$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends uint$iterator<OutIter>> OutIter copy_backward(uint$iterator<?> __first, uint$iterator<?> __last, OutIter __result)
  {
    uint$iterator<?> first = __first.clone();
    uint$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  public static <OutIter extends ushort$iterator<OutIter>> OutIter copy_backward(ushort$iterator<?> __first, ushort$iterator<?> __last, OutIter __result, boolean isDataPointerLike) {
    assert isDataPointerLike == false;
    return copy_backward(__first, __last, __result);
  }
  public static <OutIter extends ushort$iterator<OutIter>> OutIter copy_backward(ushort$iterator<?> __first, ushort$iterator<?> __last, OutIter __result)
  {
    ushort$iterator<?> first = __first.clone();
    ushort$iterator<?> last = __last;
    OutIter result = __result.clone();
    while (last.$noteq(first)) {
      result.$preDec();
      last.$preDec();
      result.star$ref().$set(last.$star());
    }
    return result;
  }

  /**
   *  @brief Fills the range [first,first+n) with copies of value.
   *  @ingroup mutating_algorithms
   *  @param  __first  An output iterator.
   *  @param  __n      The count of copies to perform.
   *  @param  __value  A reference-to-const of arbitrary type.
   *  @return   The iterator at first+n.
   *
   *  This function fills a range with copies of the same value.  For char
   *  types filling contiguous areas of memory, this becomes an inline call
   *  to @c memset or @ wmemset.
   *
   *  _GLIBCXX_RESOLVE_LIB_DEFECTS
   *  DR 865. More algorithms that throw away information
  */
  public static <OutIter extends type$iterator<OutIter, T>, T> OutIter fill_n(OutIter __first, /*size_t*/int __n, T __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends bool$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, boolean __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends char$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, byte __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends int$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, int __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends long$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, long __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends float$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, float __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends double$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, double __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends short$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, short __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends uchar$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, /*uchar*/byte __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends uint$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, /*uint*/int __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends ulong$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, /*ulong*/long __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  public static <OutIter extends ushort$iterator<OutIter>> OutIter fill_n(OutIter __first, /*size_t*/int __n, char __value) {
    OutIter result = __first.clone();
    for (/*size_t*/int i = 0; i < __n; i++) {
      result.star$ref().$set(__value);
      result.$preInc();
    }
    return result;
  }

  /**
   *  @brief Copies the value x into the range [first,first+n).
   *  @param  __first  An input iterator.
   *  @param  __n      The number of copies to make.
   *  @param  __x      The source value.
   *  @return   Nothing.
   *
   *  Like fill_n(), but does not require an initialized output range.
  */
  public static <T> void uninitialized_fill_n(type$iterator<?, T> __first, int __n, T __value) {
    __first = $tryClone(__first);
    for (/*size_t*/int i = 0; i < __n; i++) {
      __first.star$ref().$set(__value);
      __first.$preInc();
    }
  }
  
  public static void uninitialized_fill_n(int$iterator<?> __first, int __n, int __value) {
    __first = $tryClone(__first);
    for (/*size_t*/int i = 0; i < __n; i++) {
      __first.star$ref().$set(__value);
      __first.$preInc();
    }
  }
  
  public static void uninitialized_fill_n(ulong$iterator<?> __first, int __n, long __value) {
    __first = $tryClone(__first);
    for (/*size_t*/int i = 0; i < __n; i++) {
      __first.star$ref().$set(__value);
      __first.$preInc();
    }
  }

  /**
   *  @brief Tests a range for element-wise equality.
   *  @ingroup non_mutating_algorithms
   *  @param  __first1  An input iterator.
   *  @param  __last1   An input iterator.
   *  @param  __first2  An input iterator.
   *  @return   A boolean true or false.
   *
   *  This compares the elements of two ranges using @c == and returns true or
   *  false depending on whether all of the corresponding elements of the
   *  ranges are equal.
  */
  public static boolean equal(type$iterator __first1, type$iterator __last1, type$iterator __first2)
  {
    return equal(__first1, __last1, __first2, false);
  }
  
  public static boolean equal(type$iterator __first1, type$iterator __last1, type$iterator __first2, boolean isDataPointerLike)
  {
    type$iterator first1 = (type$iterator)__first1.clone();
    type$iterator last1 = (type$iterator)__last1;
    type$iterator first2 = (type$iterator)__first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (!Native.$eq(first1.$star(), first2.$star(), isDataPointerLike))
	      return false;
	  return true;
  }

  public static boolean equal(bool$iterator<?> __first1, bool$iterator<?> __last1, bool$iterator<?> __first2)
  {
    bool$iterator<?> first1 = __first1.clone();
    bool$iterator<?> last1 = __last1;
    bool$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(char$iterator<?> __first1, char$iterator<?> __last1, char$iterator<?> __first2)
  {
    char$iterator<?> first1 = __first1.clone();
    char$iterator<?> last1 = __last1;
    char$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(int$iterator<?> __first1, int$iterator<?> __last1, int$iterator<?> __first2)
  {
    int$iterator<?> first1 = __first1.clone();
    int$iterator<?> last1 = __last1;
    int$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(long$iterator<?> __first1, long$iterator<?> __last1, long$iterator<?> __first2)
  {
    long$iterator<?> first1 = __first1.clone();
    long$iterator<?> last1 = __last1;
    long$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(short$iterator<?> __first1, short$iterator<?> __last1, short$iterator<?> __first2)
  {
    short$iterator<?> first1 = __first1.clone();
    short$iterator<?> last1 = __last1;
    short$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(uchar$iterator<?> __first1, uchar$iterator<?> __last1, uchar$iterator<?> __first2)
  {
    uchar$iterator<?> first1 = __first1.clone();
    uchar$iterator<?> last1 = __last1;
    uchar$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(uint$iterator<?> __first1, uint$iterator<?> __last1, uint$iterator<?> __first2)
  {
    uint$iterator<?> first1 = __first1.clone();
    uint$iterator<?> last1 = __last1;
    uint$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(ushort$iterator<?> __first1, ushort$iterator<?> __last1, ushort$iterator<?> __first2)
  {
    ushort$iterator<?> first1 = __first1.clone();
    ushort$iterator<?> last1 = __last1;
    ushort$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  public static boolean equal(ulong$iterator<?> __first1, ulong$iterator<?> __last1, ulong$iterator<?> __first2)
  {
    ulong$iterator<?> first1 = __first1.clone();
    ulong$iterator<?> last1 = __last1;
    ulong$iterator<?> first2 = __first2.clone();
	  for (; first1.$noteq(last1); first1.$preInc(), first2.$preInc())
	    if (first1.$star() != first2.$star())
	      return false;
	  return true;
  }

  /**
   *  @brief Performs @b dictionary comparison on ranges.
   *  @ingroup sorting_algorithms
   *  @param  __first1  An input iterator.
   *  @param  __last1   An input iterator.
   *  @param  __first2  An input iterator.
   *  @param  __last2   An input iterator.
   *  @return   A boolean true or false.
   *
   *  <em>Returns true if the sequence of elements defined by the range
   *  [first1,last1) is lexicographically less than the sequence of elements
   *  defined by the range [first2,last2).  Returns false otherwise.</em>
   *  (Quoted from [25.3.8]/1.)  If the iterators are all character pointers,
   *  then this is an inline call to @c memcmp.
  */
  public static <_II1, _II2> boolean lexicographical_compare(_II1 __first1, _II1 __last1, _II2 __first2, _II2 __last2)
  {
    throw new UnsupportedOperationException("Not implemented yet.");
  }
  public static boolean lexicographical_compare(char$iterator<?> __first1, char$iterator<?> __last1,
          char$iterator<?> __first2, char$iterator<?> __last2) {
    char$iterator<?> first1 = $tryClone(__first1);
    char$iterator<?> first2 = $tryClone(__first2);
    while (first1.$noteq(__last1) && first2.$noteq(__last2)) {
      if (first1.$star() < first2.$star()) {
        return true;
      }
      if (first2.$star() < first1.$star()) {
        return false;
      }
      first1.$preInc();
      first2.$preInc();
    }
    return first1.$eq(__last1) && first2.$noteq(__last2);
  }

//
//    public static <T> iterator<T> copy(iterator<T> first, iterator<T> last, iterator<T> result) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private static <T> int distance(iterator<T> __first, iterator<T> __last) {
//        return __last.index() - __first.index();
//    }
//
//    public static <T> void advance(iterator<T> I, int Half) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public static <T> iterator<T> find(iterator<T> begin, iterator<T> end, T Handler) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public static <T, Tp>
//    iterator<T>
//    upper_bound(iterator<T> __first, iterator<T> __last,
//		Tp __val, ComparatorExt __comp)
//    {
//      int __len = std.distance(__first, __last);
//      int __half;
//      iterator<T> __middle;
//
//      while (__len > 0)
//	{
//	  __half = __len >>> 1;
//	  __middle = __first;
//	  std.advance(__middle, __half);
//	  if (__comp.$compare(__val, __middle.get()))
//	    __len = __half;
//	  else
//	    {
//	      __first = __middle;
//	      __first.$inc();
//	      __len = __len - __half - 1;
//	    }
//	}
//      return __first;
//    }
//
//  /**
//   *  @brief Finds the last position in which @p __val could be inserted
//   *         without changing the ordering.
//   *  @ingroup binary_search_algorithms
//   *  @param  __first   An iterator.
//   *  @param  __last    Another iterator.
//   *  @param  __val     The search term.
//   *  @return  An iterator pointing to the first element greater than @p __val,
//   *           or end() if no elements are greater than @p __val.
//   *  @ingroup binary_search_algorithms
//  */
//    public static <T, Tp extends ComparableLower>
//    iterator<T>
//    upper_bound(iterator<T> __first, iterator<T> __last, Tp __val)
//    {
//      int __len = std.distance(__first, __last);
//      int __half;
//      iterator<T> __middle;
//
//      while (__len > 0)
//	{
//	  __half = __len >>> 1;
//	  __middle = __first;
//	  std.advance(__middle, __half);
//	  if (__val.$lower(__middle.get()))
//	    __len = __half;
//	  else
//	    {
//	      __first = __middle;
//	      __first.$inc();
//	      __len = __len - __half - 1;
//	    }
//	}
//      return __first;
//    }
//
//    public static <T, Tp extends ComparableLower>
//    iterator<T>
//    lower_bound(iterator<T> __first, iterator<T> __last, Tp __val)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
  public static <T> void memset(type$iterator<?, T> first, T val, /*size_t*/int len) {
    first = $tryClone(first);
    for (/*size_t*/int i = 0; i < len; i++) {
      first.star$ref().$set(val);
      first.$preInc();
    }
  }

  public static <T> void memset(type$ptr<T> array, T val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array.$set(i, val);
    }
  }
  
  public static void memset(char$ptr array, int val, /*size_t*/int len) {
    assert (len % NativeType.BYTES_IN_INT == 0);
    for (/*size_t*/int i = 0; i < len / NativeType.BYTES_IN_BYTE; i++) {
      array.$set(i, $int2char(val));
    }
  }

  public static void memset(int$ptr array, int val, /*size_t*/int len) {
    assert (len % NativeType.BYTES_IN_INT == 0);
    for (/*size_t*/int i = 0; i < len / NativeType.BYTES_IN_INT; i++) {
      array.$set(i, (int) val);
    }
  }

  public static void memset(ulong$ptr array, /*ulong*/long val, /*size_t*/int len) {
    assert (len % NativeType.BYTES_IN_ULINT == 0);
    for (/*size_t*/int i = 0; i < len / NativeType.BYTES_IN_ULINT; i++) {
      array.$set(i, val);
    }
  }

  public static void memset(uint$ptr array, /*uint*/int val, /*size_t*/int len) {
    assert (len % NativeType.BYTES_IN_UINT == 0);
    for (/*size_t*/int i = 0; i < len / NativeType.BYTES_IN_UINT; i++) {
      array.$set(i, val);
    }
  }

  public static void memset(short$ptr array, short val, /*size_t*/int len) {
    assert (len % NativeType.BYTES_IN_SHORT == 0);
    for (/*size_t*/int i = 0; i < len / NativeType.BYTES_IN_SHORT; i++) {
      array.$set(i, val);
    }
  }

  public static void memset(char$ptr array, byte val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array.$set(i,  val);
    }
  }

  public static void memset(uchar$ptr array, byte val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array.$set(i,  val);
    }
  }

  public static void memset(int array[], int val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array[(int) i] = val;
    }
  }

  public static void memset(short[] array, short val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array[(int) i] = val;
    }
  }

  public static void memset(char[] array, char val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array[(int) i] = (char) val;
    }
  }

  public static void memset(byte[] array, byte val, /*size_t*/int len) {
    for (/*size_t*/int i = 0; i < len; i++) {
      array[(int) i] = (byte) val;
    }
  }

  public static <_Tp> void swap(type$ptr<_Tp> __a, type$ptr<_Tp> __b) {
    __a.swap(__b);
//      _Tp tmp = (__a.$star() instanceof assignable) ? Native.$tryClone(__a.$star()) : __a.$star();
//      __a.$set(__b.$star());
//      __b.$set(tmp);
  }

  public static void swap(ulong$ptr __a, ulong$ptr __b) {
    long tmp = __a.$star();
    __a.$set(__b.$star());
    __b.$set(tmp);
  }

  public static <_Tp> void swap(std.vector<_Tp> __a, std.vector<_Tp> __b) {
    __a.swap(__b);
  }

  public static <_Tp> void swap(setType<_Tp> LHS, setType<_Tp> RHS) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static <_Tp> void swap(setPtr<_Tp> LHS, setPtr<_Tp> RHS) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

// Good method, buit it produces lots of ambiguities in callers
//
//  public static <_Tp extends NativePOD<_Tp>> void swap(_Tp __a, _Tp __b) {
//    _Tp tmp = __a.clone();
//    __a.$assign(__b);
//    __b.$assign(tmp);
//  }
//
  
  // NOTE: use swap(NativeSwappable, NativeSwappable) instead if need to swap values
  public static <_Tp> void swap(type$ref<_Tp> __a, type$ref<_Tp> __b) {
      _Tp tmp = __a.$deref();
      __a.$set(__b.$deref());
      __b.$set(tmp);
  }

  public static <_Tp> void swap(uint$ref __a, uint$ref __b) {
    /*uint*/int tmp = __a.$deref();
    __a.$set(__b.$deref());
    __b.$set(tmp);
  }

  public static <_Tp> void swap(int$ref __a, int$ref __b) {
    int tmp = __a.$deref();
    __a.$set(__b.$deref());
    __b.$set(tmp);
  }
  
  public static <_Tp> void swap(uint$ptr __a, uint$ptr __b) {
    /*uint*/uint$ptr tmp = $tryMove(__a);
    __a.$assignMove(__b);
    __b.$assignMove(tmp);
  }

  public static <_Tp> void swap(int$ptr __a, int$ptr __b) {
    /*uint*/int$ptr tmp = $tryMove(__a);
    __a.$assignMove(__b);
    __b.$assignMove(tmp);
  }
  
  // special methods to handle all primitive types
  public static void swap(long L, long R) {
    throw new UnsupportedOperationException("use $ref-based methods or swap manually instead");
  }

  public static void swap(boolean L, boolean R) {
    throw new UnsupportedOperationException("use $ref-based methods or swap manually instead");
  }
  
  public static void swap(NativeSwappable L, NativeSwappable R) {
    L.swap(R);
  }

  public static <T> type$ptr<T> malloc(/*size_t*/int size) {
    return malloc(size, null);
  }

  public static <T> type$ptr<T> malloc(/*size_t*/int size, T defaultValue) {
    T[] array = (T[]) new Object[(int) size];
    if (defaultValue != null) {
      for (int i = 0; i < array.length; i++) {
        array[i] = $tryClone(defaultValue);
      }
    }
    return create_type$ptr(array);
  }

  public static <T> type$ptr<T> realloc(type$ptr<T> OldMem, int OldMemSize, /*size_t*/int size) {
    return realloc(OldMem, OldMemSize, size, null);
  }

  public static <T> type$ptr<T> realloc(type$ptr<T> OldMem, int OldMemSize, /*size_t*/int size, T defaultValue) {
    T[] array = (T[]) new Object[(int) size];
    int initializeSize = (int) Math.min(size, OldMemSize);
    if (initializeSize > 0) {
      for (int i = 0; i < initializeSize; i++) {
        array[i] = OldMem.$at(i); // do not need clone here.
      }
    }
    if (defaultValue != null) {
      for (int i = initializeSize; i < array.length; i++) {
        array[i] = $tryClone(defaultValue);
      }
    }
    return create_type$ptr(array);
  }
  
  public static <T> type$ptr<T> calloc(/*size_t*/int elemNum, /*size_t*/int elemSize) {
    return malloc(elemNum * elemSize, (T) null);
  }

  /*
   ****************************************************************************
   *  Public Cpp Classes/Interfaces
   ****************************************************************************
   */
  public static final class tm {/* see ctime(3) */
    public final int tm_sec;  // seconds after the minute – [0, 61](until C++11) / [0, 60] (since C++11)
    public final int tm_min;  // minutes after the hour – [0, 59] 
    public final int tm_hour; // hours since midnight – [0, 23] 
    public final int tm_mday; // day of the month – [1, 31] 
    public final int tm_mon;  // months since January – [0, 11] 
    public final int tm_year; // years since 1900 
    public final int tm_wday; // days since Sunday – [0, 6] 
    public final int tm_yday; // days since January 1 – [0, 365]
    public final int tm_isdst;// Daylight Saving Time flag. The value is positive if DST is in effect, zero if not and negative if no information is available 
    final long millis_orig; // original millis used to create this tm
    private tm(long millis) {
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(millis);
      millis_orig = millis;
  
      tm_sec = cal.get(Calendar.SECOND);
      assert tm_sec >= 0 && tm_sec <= 60 : "tm_sec="+tm_sec;
      tm_min = cal.get(Calendar.MINUTE);
      assert tm_min >= 0 && tm_min <= 59 : "tm_min="+tm_min;
      tm_hour = cal.get(Calendar.HOUR_OF_DAY);
      assert tm_hour >= 0 && tm_hour <= 23 : "tm_hour="+tm_hour;
      tm_mday = cal.get(Calendar.DAY_OF_MONTH);        
      assert tm_mday >= 1 && tm_mday <= 31 : "tm_mday="+tm_mday;
      tm_mon = cal.get(Calendar.MONTH);
      assert tm_mon >= 0 && tm_mon <= 11 : "tm_mon="+tm_mon;
      tm_year = cal.get(Calendar.YEAR) - 1900;// in Java actual year, we need since 1900
      
      // in Java constants are from 1 (Monday) to 7 (Sunday)
      // but we need days since Sunday – [0, 6] 
      tm_wday = cal.get(Calendar.DAY_OF_WEEK) % 7;
      assert tm_wday >= 0 && tm_wday <= 6 : "tm_wday="+tm_wday;
      // in Java The first day of the year has value 1. We need from 0
      tm_yday = cal.get(Calendar.DAY_OF_YEAR) - 1;
      assert tm_yday >= 0 && tm_yday <= 365 : "tm_yday="+tm_yday;
      tm_isdst = -1;//TimeZone.getDefault().inDaylightTime(new Date(millis)) ? 1 : 0;
    }

    @Override
    public String toString() {
      return "tm{" + 
        "tm_sec=" + tm_sec + ",\n"
        + " tm_min=" + tm_min + ",\n"
        + " tm_hour=" + tm_hour + ",\n"
        + " tm_mday=" + tm_mday + ",\n"
        + " tm_mon=" + tm_mon + ",\n"
        + " tm_year=" + tm_year + ",\n"
        + " tm_wday=" + tm_wday + ",\n"
        + " tm_yday=" + tm_yday + ",\n"
        + " tm_isdst=" + tm_isdst + '}';
    }
  }

  /**
   * 
   * @param __timer
   * @return 
   */
  public static /*time_t*/long time(long$ptr/*time_t P*/__timer) {
    long out = System.currentTimeMillis();
    if (__timer != null) {
      __timer.$set(out);
    }
    return out;
  }

  /**
   * Converts given time since epoch as std::time_t value into calendar time, 
   * expressed in local time. 
   * 
   * @param__timer pointer to a time_t object to convert 
   * @return pointer to a static internal std::tm object on success, or NULL otherwise. 
   * The structure may be shared between std::gmtime, std::localtime, and std::ctime, and may be overwritten on each invocation. 
   */
  public static tm localtime(long/*const time_t P*/__timer) {
    return new tm(__timer);
  }

  /**
   *  It converts the calendar time t into a null-terminated string of the form
    "Wed Jun 30 21:49:08 1993\n" 
   * @param __tp
   * @return 
   */
  public static char$ptr asctime(tm __tp) {

      Date date = new Date(__tp.millis_orig);
      SimpleDateFormat ft = 
      new SimpleDateFormat ("EEE MMM dd HH:mm:ss yyyy");
      String format = ft.format(date) + "\n"; 
      return create_char$ptr(format);
  }

  public static class bitset extends StdBitset {

    public bitset(int _Nb) {
      super(_Nb);
    }

    public bitset(int _Nb, /*ushort*/char __val) {
      super(_Nb, __val);
    }

    public bitset(int _Nb, string __s) {
      super(_Nb, __s);
    }

    public bitset(int _Nb, string __s, int __position) {
      super(_Nb, __s, __position);
    }

    public bitset(bitset $Prm0) {
      super($Prm0);
    }

    public bitset(JD$Move _diff, bitset other) {
      super(other);
    }
    
    public void $assign(bitset other) {
      throw new UnsupportedOperationException("EmptyBody");
    }
  }

  public static final class unordered_setULong /*extends StdSetType<T> */{
    
  }
  
  public static final class unordered_setType<T> extends StdSetType<T> {

    public unordered_setType() {
    }

    public unordered_setType(type$iterator<?, T> begin, type$iterator<?, T> end) {
      super();
      insert(begin, end);
    }

    public unordered_setType(Comparator<T> comparator) {
      super(comparator);
    }

    public unordered_setType(binary_functionArgArg2Bool<T, T> comparator) {
      super(binary2Comparator(comparator));
    }

    public unordered_setType(setType<T> other) {
      super(other);
    }    
  }
  
  public static final class setType<T> extends StdSetType<T> {

    public setType() {}

    public setType(Comparator<T> comparator) {
      super(comparator);
    }
    
    public setType(std.binary_functionArgArg2Bool<T, T> comparator) {
      super(binary2Comparator(comparator));
    }

    public setType(std.setType<T> other) {
      super(other);
    }
    
    public setType(JD$Move diff, std.setType<T> other) {
      super(other);
    }
    
    public setType(type$iterator<?, T> B, type$iterator<?, T> E) {
      super();
      insert(B, E);
    }

    public setType(JD$Initializer_list$_Key_T1$C$R_T2$C$R INSTANCE, T[] data) {
      if (data != null) {
        for (T t : data) {
          this.insert(t);
        }
      }
    }

    @Override
    public setType<T> clone() {
      return new setType(this);
    }

    public void insert$T(iterator<T> begin, iterator<T> end) {
      super.insert(begin, end);
    }
  }
  
  public static final class setPtr<T> extends StdSetPtr<T> {

    public setPtr() {
      this(Native::compare$JavaRef);
    }

    public setPtr(Comparator<T> comparator) {
      super(comparator);
    }
    
    public setPtr(std.binary_functionArgArg2Bool<T, T> comparator) {
      super(binary2Comparator(comparator));
    }

    public setPtr(std.setPtr<T> other) {
      super(other);
    }
    
    public setPtr(JD$Move diff, std.setPtr<T> other) {
      super(other);
    }
    
    public setPtr(type$iterator<?, T> B, type$iterator<?, T> E) {
      super(Native::compare$JavaRef);
      insert(B, E);
    }

    public setPtr(JD$Initializer_list$_Key_T1$C$R_T2$C$R INSTANCE, T[] data) {
      if (data != null) {
        for (T t : data) {
          this.insert(t);
        }
      }
    }

    @Override
    public setPtr<T> clone() {
      return new setPtr(this);
    }

    public void insert$T(iterator<T> begin, iterator<T> end) {
      super.insert(begin, end);
    }
  }
  
  public static final class setInt extends StdSetInt {

    public setInt() {}

    public setInt(Comparator<Integer> comparator) {
      super(comparator);
    }

    public setInt(std.setInt other) {
      super(other);
    }
    
    public setInt(JD$Initializer_list$_Key_T1$C$R_T2$C$R diff, int[] other) {
      clear();
      for(int i = 0; i < other.length; i++) {
        this.insert(other[i]);
      }
    }

    @Override
    public setInt clone() {
      return new setInt(this);
    }
  }
  
  public static final class setUInt extends StdSetUInt {

    public setUInt() {}

    public setUInt(std.setUInt other) {
      super(other);
    }

    @Override
    public setUInt clone() {
      return new setUInt(this);
    }

    public pairTypeBool<std.setUInt.iterator> insert_T$RR(int SubobjectNumber) {
      return super.insert(SubobjectNumber);
    }

    public pairTypeBool<std.setUInt.iterator> insert_T$C$R(int i) {
      return super.insert(i);
    }
  }

  public static <T1, T2> boolean $less_pair(pair<T1, T2> one, pair<T1, T2> other, ComparatorLower<T1, T1> c1, ComparatorLower<T2, T2> c2) {
    return c1.$less(one.first, other.first) || (!c1.$less(other.first, one.first) && c2.$less(one.second, other.second));
  }
  
  public static <T1 extends ComparableLower, T2 extends ComparableLower> boolean $less_pair(pair<T1, T2> one, pair<T1, T2> other) {
    return one.first.$less(other.first) || (!other.first.$less(one.first) && one.second.$less(other.second));    
  }

  public static <T1 extends ComparableLower, T2 extends ComparableLower> boolean $less_pair$_T1$_T2$C(pair<T1, T2> one, pair<T1, T2> other) {
    return $less_pair(one, other);
  }

  public static <T> boolean $less_tuple_T(pair<T, T> one, pair<T, T> other, ComparatorLower<T, T> comparator) {
    return comparator.$less(one.first, other.first) || (!comparator.$less(other.first, one.first) && comparator.$less(one.second, other.second));
  }

  public static <T1, T2> boolean $less_tuple_T_T(pair<T1, T2> one, pair<T1, T2> other, ComparatorLower<T1, T1> c1, ComparatorLower<T2, T2> c2) {
    return c1.$less(one.first, other.first) || (!c1.$less(other.first, one.first) && c2.$less(one.second, other.second));
  }
  
  public static boolean $less_tuple$C(pairIntBool one, pairIntBool other) {
    return (one.first < other.first) || (!(one.first < other.first) && !one.second && other.second);
  }

  public static boolean $less_tuple$C(int firstInt, boolean firstBool, int secondInd, boolean secondBool) {
    return (firstInt < secondInd) || (!(firstInt < secondInd) && !firstBool && secondBool);
  }

  public static boolean $greater_tuple$C(pairIntBool one, pairIntBool other) {
    return (one.first > other.first) || (!(one.first > other.first) && one.second && !other.second);
  }
          
  public static boolean $less_tuple_int$C(pairIntInt one, pairIntInt other) {
    return Unsigned.$less_int(one.first, other.first) || (!Unsigned.$less_int(other.first, one.first) && Unsigned.$less_int(one.second, other.second));
  }
  
  public static boolean $less_tuple_uint$C(pairUIntUInt one, pairUIntUInt other) {
    return Unsigned.$less_uint(one.first, other.first) || (!Unsigned.$less_uint(other.first, one.first) && Unsigned.$less_uint(one.second, other.second));
  }
  
  public static final class tuple extends StdTuple {
    public tuple(tuple other) {
      super(other);
    }
    
    public tuple(Object ... elements) {
      super(elements);
    }
    
    public tuple(boolean isDataPointerLike, Object ... elements) {
      super(isDataPointerLike, elements);
    }
  }

  public static tuple make_tuple(Object ... elements) {
    return new tuple(elements);
  }
  
  public static tuple make_tuple_Ptrs(Object ... elements) {
    return new tuple(true, elements);
  }
  
  public static Object get(int idx, tuple t) {
    return t.$getAt(idx);
  }

  /**
   *  @brief  A standard container giving FILO behavior.
   *
   *  @ingroup sequences
   *
   *  Meets many of the requirements of a
   *  <a href="tables.html#65">container</a>,
   *  but does not define anything to do with iterators.  Very few of the
   *  other standard container interfaces are defined.
   *
   *  This is not a true container, but an @e adaptor.  It holds
   *  another container, and provides a wrapper interface to that
   *  container.  The wrapper is what enforces strict
   *  first-in-last-out %stack behavior.
   *
   *  The second template parameter defines the type of the underlying
   *  sequence/container.  It defaults to std::deque, but it can be
   *  any type that supports @c back, @c push_back, and @c pop_front,
   *  such as std::list, std::vector, or an appropriate user-defined
   *  type.
   *
   *  Members not found in @a normal containers are @c container_type,
   *  which is a typedef for the second Sequence parameter, and @c
   *  push, @c pop, and @c top, which are standard %stack/FILO
   *  operations.
  */  
  public static class stack<_Tp> implements NativeComparable<stack>, Destructors.ClassWithDestructor {
//      _Tp _stack[];
      private final java.util.Deque<_Tp> _stack = new java.util.LinkedList<_Tp>();
      private final boolean isDataPointerLike;
      
      public stack(_Tp DUMMY_defaultValue_UNUSED) {
        this.isDataPointerLike = (DUMMY_defaultValue_UNUSED == null);
      }
      
      /**
       *  @brief  Add data to the top of the %stack.
       *  @param  x  Data to be added.
       *
       *  This is a typical %stack operation.  The function creates an
       *  element at the top of the %stack and assigns the given data
       *  to it.  The time complexity of the operation depends on the
       *  underlying sequence.
       */
      public void push(_Tp __x) {
        push_impl(__x);
      }

      public void push_value_type(_Tp __x) {
        push_impl(__x);
      }

      private void push_impl(_Tp __x) {
        if (isDataPointerLike) {
          _stack.addFirst(__x);
        } else {
          _stack.addFirst($tryClone(__x));
        }
      }
      /**
       *  Returns a read/write reference to the data at the first
       *  element of the %stack.
       */
      public _Tp top() {
        return _stack.getFirst();
      }

      /**
       *  @brief  Removes first element.
       *
       *  This is a typical %stack operation.  It shrinks the %stack
       *  by one.  The time complexity of the operation depends on the
       *  underlying sequence.
       *
       *  Note that no data is returned, and if the first element's
       *  data is needed, it should be retrieved before pop() is
       *  called.
       */
      public void pop() {
        _stack.pollFirst();
      }

      /**
       *  Returns true if the %stack is empty.
       */
      public boolean empty() {
        return this._stack.isEmpty();
      }

      /**  Returns the number of elements in the %stack.  */
      public int size() {
        return this._stack.size();
      }

      @Override
      public boolean $noteq(stack other) {
        return !$eq(other);
      }

      @Override
      public boolean $eq(stack other) {
        if (other == null) {
          return false;
        }
        if (other == this) {
          return true;
        }
        if (this.size() != other.size()) {
          return false;
        }
        Iterator<_Tp> iterator = _stack.iterator();
        Iterator<_Tp> iteratorOther = other._stack.iterator();
        while (iterator.hasNext()) {
          assert iteratorOther.hasNext();
          if (!Native.$eq(iterator.next(), iteratorOther.next(), isDataPointerLike)) {
            return false;
          }
        }
        assert !iterator.hasNext();
        assert !iteratorOther.hasNext();
        return true;
      }
      
      @Override
      public void $destroy() {
        if (!isDataPointerLike) {
          for (_Tp elem : _stack) {
            Destructors.$destroy(elem);
          }
        }
      }
  }
  
  /** DUMMY */
  public static class stackInt implements NativeComparable<stackInt>, Destructors.ClassWithDestructor {
    private final java.util.Deque<Integer> _stack = new java.util.LinkedList<Integer>();

    public void push_value_type(int i) {
      _stack.push(i);
    }

    public void $destroy() {
    }
    public boolean empty() {
      return _stack.isEmpty();
    }
    public int top() {
      return _stack.getFirst();
    }
    public int$ref top$ref() {
      return new int$ref() {
        @Override
        public int $deref() {
          return _stack.getFirst();
        }

        @Override
        public int $set(int value) {
          _stack.pop();
          _stack.push(value);
          return value;
        }
        
      };
    }
    public int pop() {
      return _stack.pollFirst();
    }
  }

  public static void clearStatistics() {
    pair.clearStatistics();
    pairTypeType.clearStatistics();
    pairTypePtr.clearStatistics();
    pairPtrType.clearStatistics();
    pairPtrPtr.clearStatistics();
    pairBoolChar.clearStatistics();
    pairBoolType.clearStatistics();
    pairBoolPtr.clearStatistics();

    pairUShortUInt.clearStatistics();
    
    pairIntInt.clearStatistics();
    pairIntUInt.clearStatistics();
    pairIntType.clearStatistics();
    pairIntPtr.clearStatistics();
    pairLongLong.clearStatistics();
    
    pairTypeBool.clearStatistics();
    pairPtrBool.clearStatistics();
    pairTypeChar.clearStatistics();
    pairPtrChar.clearStatistics();
    pairTypeUChar.clearStatistics();
    pairPtrUChar.clearStatistics();
    pairTypeInt.clearStatistics();
    pairPtrInt.clearStatistics();
    pairTypeLong.clearStatistics();
    pairPtrLong.clearStatistics();
    pairTypeUInt.clearStatistics();
    pairPtrUInt.clearStatistics();
    pairTypeULong.clearStatistics();
    pairPtrULong.clearStatistics();
    pairTypeULLong.clearStatistics();
    pairPtrULLong.clearStatistics();
    
    pairUCharType.clearStatistics();
    pairUCharPtr.clearStatistics();
    pairUIntBool.clearStatistics();
    pairUIntChar.clearStatistics();
    pairUIntType.clearStatistics();
    pairUIntPtr.clearStatistics();
    pairULongType.clearStatistics();
    pairULongPtr.clearStatistics();
    pairUIntUInt.clearStatistics();

    shared_ptr.clearStatistics();
    unique_ptr.clearStatistics();
    unique_ptr_null_eq.clearStatistics();
    unique_ptr_with_deleter.clearStatistics();
  }

  public static long printSmartPtrsStatistics(java.io.PrintWriter out) {
    long Value = 0;
    Value += shared_ptr.printStatistics(out);
    Value += unique_ptr.printStatistics(out);
    Value += unique_ptr_null_eq.printStatistics(out);
    Value += unique_ptr_with_deleter.printStatistics(out);
    NativeTrace.dumpStatisticValue(out, "TotalLibStdSmartPtrs", Value);
    return Value;
  }

  public static long printPairsStatistics(java.io.PrintWriter out) {
    long Value = 0;
    Value += pair.printStatistics(out);
    Value += pairTypeType.printStatistics(out);
    Value += pairPtrPtr.printStatistics(out);
    Value += pairPtrType.printStatistics(out);
    Value += pairTypePtr.printStatistics(out);
    
    Value += pairBoolChar.printStatistics(out);
    Value += pairBoolType.printStatistics(out);
    Value += pairBoolPtr.printStatistics(out);

    Value += pairUShortUInt.printStatistics(out);
    
    Value += pairIntInt.printStatistics(out);
    Value += pairIntUInt.printStatistics(out);
    Value += pairIntType.printStatistics(out);
    Value += pairIntPtr.printStatistics(out);
    Value += pairLongLong.printStatistics(out);
    
    Value += pairTypeBool.printStatistics(out);
    Value += pairTypeChar.printStatistics(out);
    Value += pairTypeUChar.printStatistics(out);
    Value += pairTypeInt.printStatistics(out);
    Value += pairTypeLong.printStatistics(out);
    Value += pairTypeUInt.printStatistics(out);
    Value += pairPtrUInt.printStatistics(out);
    Value += pairTypeULong.printStatistics(out);
    Value += pairPtrULong.printStatistics(out);
    Value += pairTypeULLong.printStatistics(out);
    Value += pairPtrULLong.printStatistics(out);
    
    Value += pairPtrBool.printStatistics(out);
    Value += pairPtrChar.printStatistics(out);
    Value += pairPtrUChar.printStatistics(out);
    Value += pairPtrInt.printStatistics(out);
    Value += pairPtrUInt.printStatistics(out);
    Value += pairPtrLong.printStatistics(out);
    Value += pairPtrULong.printStatistics(out);
    
    Value += pairUCharType.printStatistics(out);
    Value += pairUCharPtr.printStatistics(out);
    Value += pairUIntBool.printStatistics(out);
    Value += pairUIntChar.printStatistics(out);
    Value += pairUIntType.printStatistics(out);
    Value += pairUIntPtr.printStatistics(out);
    Value += pairULongType.printStatistics(out);
    Value += pairULongPtr.printStatistics(out);
    Value += pairUIntUInt.printStatistics(out);
    NativeTrace.dumpStatisticValue(out, "TotalLibStdPairsValue", Value);
    return Value;
  }
  
  public static class input_iterator_tag {

    public input_iterator_tag() {
    }
  }
  
  public static class output_iterator_tag {

    public output_iterator_tag() {
    }
  }

  public static class forward_iterator_tag {

    public forward_iterator_tag() {
    }
    public forward_iterator_tag(JD$Move _dparm, Object dummy) {
    }
  }
  
  @FunctionalInterface
  public static interface hash<Key> {
    /*size_t*/int $call(Key key);
  }

  @FunctionalInterface
  public interface binary_functionBoolean<T> {

    boolean $call(/*const*/T /*&*/ lhs, /*const*/ T /*&*/ rhs) /*const*/;
  }

  public interface less<T> extends binary_functionBoolean<T> {
    
    @Override
    default boolean $call(/*const*/T /*&*/ lhs, /*const*/ T /*&*/ rhs) /*const*/ {
      return Native.$less(lhs, rhs);
    }
  }
  
  /// One of the @link comparison_functors comparison functors@endlink.
  public interface equal_to<T> extends binary_functionBoolean<T> {
    
    @Override
    default boolean $call(/*const*/T /*&*/ lhs, /*const*/ T /*&*/ rhs) /*const*/ {
      return Native.$eq(lhs, rhs);
    }
  }

  public static class less$char$ptr implements less<char$ptr> {

    @Override
    public boolean $call(char$ptr lhs, char$ptr rhs) {
      return lhs.$less(rhs);
    }
  }

  // std::bidirectional_iterator_tag
  public static class bidirectional_iterator_tag {

    public bidirectional_iterator_tag() {
    }
  }

  public static class random_access_iterator_tag {

    public random_access_iterator_tag() {
    }
  }

  public static interface ComparatorExt {

    boolean $compare(Object o1, Object o2);
  }

  public static interface ConvertableToStdString {
    public std.string std$string();
  }
  
  public static final class string extends StdString {

    /**
     * method to create string from ulong-stream where each ulong contains only one-char information
     * @param from start long-pointer which should be treated as chars
     * @param to end long-pointer which should be treated as chars
     */
    public string(ulong$ptr from, ulong$ptr to) {
      super(CollectionUtils.transform_ulong2char$ptr(from), CollectionUtils.transform_ulong2char$ptr(to));
    }

    @Override
    public int hashCode() {
      throw new UnsupportedOperationException("not yet implemented for use as keys in maps");
    }

    @Override
    public boolean equals(Object obj) {
      return this == obj;
    }

    public string() {
    }

    public string(byte[] ar) {
      super(ar);
    }

    public string(std.iterator From, std.iterator To) {
      throw new UnsupportedOperationException("not yet implemented");
    }

    public string(char$iterator<?> data, /*size_t*/int length) {
      super(data, length);
    }

    public string(/*size_t*/int __n, char __c) {
      super(__n, __c);
    }

    public string(/*size_t*/int __n, byte __c) {
      super(__n, __c);
    }

    public string(CharSequence value) {
      super(value);
    }

    public string(JD$T$C$P_T2$C$R _dparam, CharSequence value) {
      super(value);
    }

    public string(string other) {
      super(other);
    }
    
    public string(JD$Move _dparam, string other) {
      super(_dparam, other);
    }

    public string(JD$T$C$P_T2$C$R _dparam, char$ptr other) {
      super(other);
    }

    public string(char$ptr value) {
      super(value);
    }

    public string(char$ptr Start, int length) {
      super(Start, length);
    }

    public string(char$iterator<?> begin, char$iterator<?> end) {
      super(begin, end);
    }
    
    public string(char$iterator<?> from, /*size_t*/int StartIdx, /*size_t*/int Size) {
      super((char$ptr)from, StartIdx, Size);
    }
    
    public string(byte[] from, /*size_t*/int StartIdx, /*size_t*/int Size) {
      this(from, StartIdx, Size, false);
    }
    
    public string(byte[] from, /*size_t*/int StartIdx, /*size_t*/int Size, boolean _const) {
      super(from, StartIdx, Size, _const);
    }
    
    public string(char$iterator<?> from, /*size_t*/int StartIdx, /*size_t*/int Size, boolean _const) {
      super((char$ptr)from, StartIdx, Size, _const);
    }
    
    public byte[] $array() {
      return array.$array();
    }
    
    public char$ptr insert(char$ptr __p, byte __c) {    
      return super.insert(__p, $char(__c));
    }

    public char$ptr ptr$at(int index) {
      return data().$add(index);
    }
    
    public int find_T_size_type$_CharT(/*char*/byte ch) {
      return find_T_rebind$_CharT(ch);
    }
    public int find_T_rebind$_CharT(/*char*/byte ch) {
      for (int i = length()-1; i >= 0; i--) {
        if (array.$at(i) == ch) {
          return i;
        }
      }
      return -1;
    }

    public int find_last_not_of_T_size_type$_CharT(/*char*/byte ch) {
      for (int i = length()-1; i >= 0; i--) {
        if (array.$at(i) != ch) {
          return i;
        }
      }
      return -1;
    }

    public std.string append(std.string __extra) {
      return super.append(__extra.data());
    }
    
    public std.string append(int c, byte s) {
      byte[] buf = new byte[c+1];
      for(int i = 0; i < c; i++) {
        buf[i] = s;
      }
      buf[c] = 0;
      return append(create_char$ptr(buf));
    }

    public std.string/*&*/ insert$T(char$ptr pos, char$ptr begin, char$ptr end) {
      super.insert(pos, begin, end);
      return this;
    }

    public std.string/*&*/ insert_size_type$_CharT_T$C$P(int pos, char$ptr str) {
      return this.insert$T(super.begin().$add(pos), str, str.$add(strlen(str)));
    }

    public std.string/*&*/ insert(int pos, std.string str) {
      return this.insert$T(super.begin().$add(pos), str.begin(), str.end());
    }

    public void insert___normal_iterator$template$pointer$string_T(char$ptr $add, byte $$l) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int find_T_size_type$_CharT(byte $$LF, int i) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }
  
  // bool operator < (string&, string&)
  public static boolean $less_string(std.string LHS, std.string RHS) {
    return LHS.$less(RHS);
  }
  
  // bool operator < (const string&, const string&)
  public static boolean $less_string$C(std.string LHS, std.string RHS) {
    return LHS.$less(RHS);
  }

  /**
   *  @brief Find the first element in a sequence for which a
   *         predicate is true.
   *  @ingroup non_mutating_algorithms
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *  @param  __pred   A predicate.
   *  @return   The first iterator @c i in the range @p [__first,__last)
   *  such that @p __pred(*i) is true, or @p __last if no such iterator exists.
  */
  public static <_InputIterator extends type$iterator<?, T>, T>
  _InputIterator
  find_if(_InputIterator __first, _InputIterator __last,
	  BoolPredicate<T> __pred)
  {
    __first = $tryClone(__first);
    while ($noteq___normal_iterator(__first, __last)) {
      if (__pred.$call(__first.$star())) {
        break;
      }
      __first.$preInc();
    }
    return __first;
  }
  
  /**
   *  @brief Find the first element in a sequence for which a
   *         predicate is true.
   *  @ingroup non_mutating_algorithms
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *  @param  __pred   A predicate.
   *  @return   The first iterator @c i in the range @p [__first,__last)
   *  such that @p __pred(*i) is true, or @p __last if no such iterator exists.
  */
  public static <_InputIterator extends char$iterator<?>>
  _InputIterator
  find_if(_InputIterator __first, _InputIterator __last,
	  CharBoolPredicate __pred)
  {
    __first = $tryClone(__first);
    while ($noteq___normal_iterator(__first, __last)) {
      if (__pred.$call(__first.$star())) {
        break;
      }
      __first.$preInc();
    }
    return __first;
  }

  public static <_InputIterator extends ushort$iterator<?>>
  _InputIterator
  find_if(_InputIterator __first, _InputIterator __last,
	  UShortBoolPredicate __pred)
  {
    __first = $tryClone(__first);
    while ($noteq___normal_iterator(__first, __last)) {
      if (__pred.$call(__first.$star())) {
        break;
      }
      __first.$preInc();
    }
    return __first;
  }

  public static <_InputIterator, _OutputIterator, T> _OutputIterator remove_copy_if(_InputIterator __first, _InputIterator __last,
      _OutputIterator __result, BoolPredicate<T> __pred) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static <_OutputIterator extends char$iterator<?>> _OutputIterator remove_copy_if(char$iterator<?> __first, char$iterator<?> __last,
      _OutputIterator __result, CharBoolPredicate __pred) {
    char$iterator<?> first = $tryClone(__first);
    char$iterator<?> last = $noClone(__last);
    for (; first.$noteq(last); first.$preInc()) {
      if (!__pred.$call(first.$star())) {
        __result.star$ref().$set(first.$star());
        __result.$preInc();
      }
    }
    return __result;
  }
  
  /**
   *  @brief Remove elements from a sequence.
   *  @ingroup mutating_algorithms
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *  @param  __value  The value to be removed.
   *  @return   An iterator designating the end of the resulting sequence.
   *
   *  All elements equal to @p __value are removed from the range
   *  @p [__first,__last).
   *
   *  remove() is stable, so the relative order of elements that are
   *  not removed is unchanged.
   *
   *  Elements between the end of the resulting sequence and @p __last
   *  are still present, but their value is unspecified.
   */
  public static <_ForwardIterator extends type$iterator<?, _Tp>, _Tp>
    _ForwardIterator
    remove(_ForwardIterator __first, _ForwardIterator __last,
	      final _Tp __value) {
      return remove_if(
              __first, 
              __last,
              new BoolPredicate<_Tp>() {
                @Override
                public boolean $call(_Tp param) {
                  return Native.$eq(__value, param);
                }
              }
      );
    }

  /**
   *  @brief Remove elements from a sequence using a predicate.
   *  @ingroup mutating_algorithms
   *  @param  __first  A forward iterator.
   *  @param  __last   A forward iterator.
   *  @param  __pred   A predicate.
   *  @return   An iterator designating the end of the resulting sequence.
   *
   *  All elements for which @p __pred returns true are removed from the range
   *  @p [__first,__last).
   *
   *  remove_if() is stable, so the relative order of elements that are
   *  not removed is unchanged.
   *
   *  Elements between the end of the resulting sequence and @p __last
   *  are still present, but their value is unspecified.
  */
  public static <_ForwardIterator extends type$iterator<?, T>, T>
    _ForwardIterator
    remove_if(_ForwardIterator __first, _ForwardIterator __last,
	      BoolPredicate<T> __pred)
    {
      __first = find_if(__first, __last, __pred);
      if(__first.$eq(__last))
        return __first;
      _ForwardIterator __result = $tryClone(__first);
      __first.$preInc();
      for(; __first.$noteq(__last); __first.$preInc())
        if(!__pred.$call(__first.$star()))
          {
            __result.star$ref().$set(__first.$star());
            __result.$preInc();
          }
      return __result;
    }

    public static char$ptr remove_if(char$ptr __first, char$ptr __last, CharBoolPredicate __pred) {
      __first = find_if(__first, __last, __pred);
      if(__first.$eq(__last))
        return __first;
      char$ptr __result = $tryClone(__first);
      __first.$preInc();
      for(; __first.$noteq(__last); __first.$preInc())
        if(!__pred.$call(__first.$star()))
          {
            __result.star$ref().$set(__first.$star());
            __result.$preInc();
          }
      return __result;
    }

  /**
   *  @brief Replace each occurrence of one value in a sequence with another
   *         value.
   *  @ingroup mutating_algorithms
   *  @param  first      A forward iterator.
   *  @param  last       A forward iterator.
   *  @param  old_value  The value to be replaced.
   *  @param  new_value  The replacement value.
   *  @return   replace() returns no value.
   *
   *  For each iterator @c i in the range @p [first,last) if @c *i ==
   *  @p old_value then the assignment @c *i = @p new_value is performed.
  */
  public static void replace(char$iterator __first, char$iterator __last, /*uchar*/byte __old_value, /*uchar*/byte __new_value)
  {
     __first = $tryClone(__first);
    for (; __first.$noteq( __last); __first.$preInc()) {
      if (__first.$star() == __old_value) {
        __first.star$ref().$set( __new_value);
      }
    }
  }

  public static <T> back_insert_iterator<T> back_inserter(NativeContainer<T> container) {
    return new back_insert_iterator<T>(container);
  }
  
  public static back_insert_iteratorChar back_inserter(NativeContainerChar container) {
    return new back_insert_iteratorChar(container);
  }

  // 24.4.2.2.1 back_insert_iterator
  /**
   *  @brief  Turns assignment into insertion.
   *
   *  These are output iterators, constructed from a container-of-T.
   *  Assigning a T to the iterator appends it to the container using
   *  push_back.
   *
   *  Tip:  Using the back_inserter function to create these iterators can
   *  save typing.
   */
  public static class back_insert_iterator<T> implements type$iterator<back_insert_iterator<T>, T>, iterator<output_iterator_tag, T> {
    
    protected final NativeContainer<T> container;

    /// A nested typedef for the type of whatever container you used.
    //typedef _Container          container_type;

    /// The only way to create this %iterator is with a container.     
    public back_insert_iterator(NativeContainer<T>/*&*/ __x) { 
      assert __x != null;
      this.container = __x;
    }

    /**
     *  @param  __value  An instance of whatever type
     *                 container_type::const_reference is; presumably a
     *                 reference-to-const T for container<T>.
     *  @return  This %iterator, for chained operations.
     *
     *  This kind of %iterator doesn't really have a @a position in the
     *  container (you can think of the position as being permanently at
     *  the end, if you like).  Assigning a value to the %iterator will
     *  always append the value to the end of the container.
    */
    public back_insert_iterator<T>
    $set(T __value) {
      container.push_back(__value);
      return this;
    }

    public back_insert_iterator<T>
    $set(JD$Move _dparam, T __value) {
      container.push_back_T$RR(std.move(__value));
      return this;
    }

    // JAVA: returns (T) null to comply with type$iterator interface.
    /// Simply returns *this.
    public T $star() { 
      return null; 
    }
    
    private final type$ref<T> $T_REF = new type$ref<T>() {
      @Override
      public T $deref() {
        return null;
      }

      @Override
      public T $set(T value) {
        back_insert_iterator.this.$set(value);
        return null;
      }
    };
    
    public type$ref<T> star$ref() { 
      return $T_REF; 
    }

    /// Simply returns *this.  (This %iterator does not @a move.)
    public back_insert_iterator<T>
    $preInc() { 
      return this; 
    }

    /// Simply returns *this.  (This %iterator does not @a move.)
    public back_insert_iterator<T>
    $postInc() { 
      return this; 
    }

    @Override
    public back_insert_iterator<T> clone() {
      return this;
    }    

    @Override
    public boolean $eq(Object other) {
      return this == other;
    }
  }
  
  public static class back_insert_iteratorChar implements char$iterator<back_insert_iteratorChar>, iterator<output_iterator_tag, Byte> {
    
    protected final NativeContainerChar container;

    /// A nested typedef for the type of whatever container you used.
    //typedef _Container          container_type;

    /// The only way to create this %iterator is with a container.     
    public back_insert_iteratorChar(NativeContainerChar/*&*/ __x) { 
      this.container = __x;
    }

    /**
     *  @param  __value  An instance of whatever type
     *                 container_type::const_reference is; presumably a
     *                 reference-to-const T for container<T>.
     *  @return  This %iterator, for chained operations.
     *
     *  This kind of %iterator doesn't really have a @a position in the
     *  container (you can think of the position as being permanently at
     *  the end, if you like).  Assigning a value to the %iterator will
     *  always append the value to the end of the container.
    */
    public back_insert_iteratorChar
    $set(byte __value) {
      container.push_back(__value);
      return this;
    }

    public back_insert_iteratorChar
    $set(JD$Move _dparam, byte __value) {
      container.push_back(std.move(__value));
      return this;
    }

    // JAVA: returns 0 to comply with char$iterator interface.
    /// Simply returns *this.
    public byte $star() { 
      return 0; 
    }

    private final char$ref $T_REF = new char$ref() {
      @Override
      public byte $deref() {
        return 0;
      }

      @Override
      public byte $set(byte value) {
        back_insert_iteratorChar.this.$set(value);
        return value;
      }
    };

    public char$ref star$ref() { 
      return $T_REF; 
    }

    /// Simply returns *this.  (This %iterator does not @a move.)
    public back_insert_iteratorChar
    $preInc() { 
      return this; 
    }

    /// Simply returns *this.  (This %iterator does not @a move.)
    public back_insert_iteratorChar
    $postInc() { 
      return this; 
    }

    @Override
    public back_insert_iteratorChar clone() {
      return this;
    }    
  }
  
  public static <T extends ComparableGreater> T max(T left, T right) {
    return left.$greater(right) ? left : right;
  }

  public static <T extends Native.ComparableLower> T max(T left, T right) {
    return left.$less(right) ? right : left;
  }
  
  public static <T extends Native.ComparableLowerGreater> T max(T left, T right) {
    return left.$less(right) ? right : left;
  }

  public static long max(long left, long right) {
    return left > right ? left : right;
  }

  public static long max(int left, long right) {
    return left > right ? left : right;
  }

  public static long max(long left, int right) {
    return left > right ? left : right;
  }

  public static int max(int left, int right) {
    return left > right ? left : right;
  }
  
  public static /*uint*/int max_uint(/*uint*/int left, /*uint*/int right) {
    return Unsigned.$greatereq_uint(left, right) ? left : right;
  }
  
  public static <T extends ComparableGreater> T min(T left, T right) {
    return left.$greater(right) ? right : left;
  }

  public static <T extends Native.ComparableLower> T min(T left, T right) {
    return left.$less(right) ? left : right;
  }
  
  public static <T extends Native.ComparableLowerGreater> T min(T left, T right) {
    return left.$less(right) ? left : right;
  }
  
  public static long min(long left, long right) {
    return left < right ? left : right;
  }

  public static /*uint*/int min_uint(/*uint*/int left, /*uint*/int right) {
    return Unsigned.$less_uint(left, right) ? left : right;
  }

  public static int min(int left, int right) {
    return left < right ? left : right;
  }

  public static <T> T min(initializer_list<T> ilist, Compare<T> comp) {
    return min_element(ilist.begin(), ilist.end(), comp).$star();
  }

  public static <T> T max(initializer_list<T> ilist, Compare<T> comp) {
    return max_element(ilist.begin(), ilist.end(), comp).$star();
  }

  public static std.string $add_str(std.string left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_string(std.string left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_string_string$C(std.string left, std.string right) {
    return $add_string(left, right);
  }

  public static std.string $add_string$C_string(std.string left, std.string right) {
    return $add_string(left, right);
  }

  public static std.string $add_string$C(std.string left, std.string right) {
    return $add_string(left, right);
  }

  public static std.string $add_T_string(String left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T$C$P_string$C(String left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T$C$P_string(String left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T$C$P_string(char$ptr left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T_string(/*char*/byte left, std.string right) {
    return new std.string(1, left).$addassign(right);
  }

  public static std.string $add_T_string$C(char$ptr left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T_string$C(String left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T_string$C(/*char*/byte left, std.string right) {
    return new std.string(1, left).$addassign(right);
  }

  public static std.string $add_T_str(CharSequence left, std.string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_T_str$C(String left, std.string right) {
    return $add_T_str(left, right);
  }

  public static std.string $add_str_T(std.string left, CharSequence right) {
    return new std.string(left).$addassign(right);
  }
  
  public static std.string $add_str$C_T(string left,  CharSequence right) {
    return new std.string(left).$addassign(right);
  }  
  
  public static std.string $add_str$C_T(string left,  char$ptr right) {
    return new std.string(left).$addassign(new std.string(right, strlen(right)));
  }

  public static string $add_str$C_str(string left, string right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_str_T(std.string left, char$iterator<?> right) {
    return new std.string(left).$addassign(new std.string(right, strlen(right)));
  }

  public static std.string $add_str_T(std.string left, char$ptr right) {
    return new std.string(left).$addassign(new std.string(right, strlen(right)));
  }

  public static std.string $add_string_T(std.string left, String right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_string_T$C$P(std.string left, String right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_string_T$C$P(std.string left, char$ptr right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_string_T(std.string left, char$ptr right) {
    return new std.string(left).$addassign(right);
  }

  public static std.string $add_string$C_T$C$P(std.string left, String right) {
    return $add_string_T(left, right);
  }
  
  public static std.string $add_string$C_T$C$P(std.string left, char$ptr right) {
    return $add_string_T(left, right);
  }

  public static std.string $add_string$C_T(std.string left, String right) {
    return $add_string_T(left, right);
  }

  public static std.string $add_string$C_T(std.string left, char$ptr right) {
    return $add_string_T(left, right);
  }

  public static std.string $add_string$C_T(std.string left, /*char*/byte right) {
    return $add_string_T(left, right);
  }

  public static std.string $add_string_T(std.string left, /*char*/byte right) {
    return new std.string(left).$addassign(right);
  }
  
  public static std.string $add_str_T(std.string left, String right) {
    return new std.string(left).$addassign(right);
  }

  public static <T> std.string $add_T_str(T left, std.string right) {
    if (left instanceof char$ptr$CharSequence) {
      return $add_str(new string((char$ptr$CharSequence)left), right);
    } else if (left instanceof char$ptr) {
      return $add_str(new string((char$ptr)left), right);
    }
    throw new UnsupportedOperationException("Not supported yet." + right.getClass()); //To change body of generated methods, choose Tools | Templates.
  }

  public static <T> std.string $add_str_T(std.string left, T right) {
    throw new UnsupportedOperationException("Not supported yet." + right.getClass()); //To change body of generated methods, choose Tools | Templates.
  }

  public static std.string $add_str_str$C(string left, string right) {
    return $add_str$C(left, right);
  }

  public static std.string $add_str$C(string left, string right) {
    return $add_str(left, right);
  }

  public static boolean $noteq_str(std.string left, std.string right) {
    return left.$noteq(right);
  }
  
  public static boolean $noteq_str$C(std.string left, std.string right) {
    return left.$noteq(right);
  }

  public static boolean $noteq_string$C(std.string left, std.string right) {
    return left.$noteq(right);
  }

  public static boolean $eq_str_T(std.string left, String right) {
    return left.$op(Native.OpCapable.Op.EQ, right);
  }

  public static boolean $eq_str$C_T(std.string left, String right) {
    return left.$op(Native.OpCapable.Op.EQ, right);
  }
  
  public static boolean $eq_string$C_T$C$P(std.string left, String right) {
    return $eq_str$C_T(left, right);
  }
  
  public static boolean $eq_string$C_T$C$P(std.string left, char$iterator<?> right) {
    return $eq_str_T(left, right);
  }
  
  public static boolean $eq_string$C_T(std.string left, String right) {
    return $eq_str$C_T(left, right);
  }
  
  public static <T> boolean $eq_T_str(CharSequence left, std.string right) {
    return right.$op(Native.OpCapable.Op.EQ, left);
  }

  public static boolean $eq_str_T(std.string left, char$iterator<?> right) {
    if (left == null) {
      return right == null;
    }
    return left.$op(Native.OpCapable.Op.EQ, right);
  }
  
  public static boolean $eq_str$C_T(std.string left, char$iterator<?> right) {
    return $eq_str_T(left, right);
  }

  public static boolean $eq_T_str(char$iterator<?> left, std.string right) {
    if (right == null) {
      return left == null;
    }
    return right.$op(Native.OpCapable.Op.EQ, left);
  }
  
  public static boolean $eq_T_string$C(char$iterator<?> left, std.string right) { 
    return $eq_T_str(left, right);
  }
  
  public static boolean $eq_vector$_Tp$_Alloc$C(vectorString left, vectorString right) {
    return left.$eq(right);
  }

  public static <T> boolean $eq_vector$_Tp$_Alloc$C(vector<T> left, vector<T> right) {
    return left.$eq(right);
  }
  
  public static <T> boolean $less_vector$_Tp$_Alloc$C(vector<T> left, vector<T> right) {
    return left.$less(right);
  }
  
  public static <T, Comp extends ComparatorLower<T,T>> boolean $less_vector$_Tp$_Alloc$C(vector<T> left, vector<T> right, Comp __comp) {
    StdVector.iterator<T> __first1 = left.begin();
    StdVector.iterator<T> __first2 = right.begin();
    StdVector.iterator<T> __last1 = left.end();
    StdVector.iterator<T> __last2 = right.end();
    for (; $noteq_iter(__first1, __last1) && $noteq_iter(__first2, __last2); __first1.$preInc(), __first2.$preInc()) {
      if (__comp.$less(__first1.$star(),__first2.$star())) {
          return true;
      }
      if (__comp.$less(__first2.$star(),__first1.$star())) {
          return false;
      }
    }
    return $eq_iter(__first1, __last1) && $noteq_iter(__first2, __last2);
  }

  public static boolean $eq_T$C$P_string$C(char$iterator<?> left, std.string right) { 
    return $eq_T_str(left, right);
  }

  public static boolean $eq_T_str$C(char$iterator<?> left, std.string right) { 
    return $eq_T_str(left, right);
  }

  public static <T> boolean $eq_str_T(std.string left, T right) {
    throw new UnsupportedOperationException("Not supported yet for " + right.getClass()); //To change body of generated methods, choose Tools | Templates.
  }

  public static <T> boolean $eq_T_str(T left, std.string right) {
    throw new UnsupportedOperationException("Not supported yet for " + left.getClass()); //To change body of generated methods, choose Tools | Templates.
  }
  
  public static <T> boolean $noteq_unique_ptr$C_nullptr_t(unique_ptr<T> ptr, T object) {
    assert object == null : "T must be null";
    return ptr.$arrow() != object;
  }
  
  public static <T> boolean $noteq_unique_ptr$_Tp$_Dp$C_nullptr_t(unique_ptr<T> ptr, T object) {
    return $noteq_unique_ptr$C_nullptr_t(ptr, object);
  }
  
  public static <T> boolean $noteq_unique_ptr_nullptr_t(unique_ptr<T> ptr, T object) {
    assert object == null : "T must be null";
    return ptr.$arrow() != object;
  }

  public static boolean $noteq_T_str(CharSequence left, std.string right) {
    return ! $eq_T_str(left, right);
  }

  public static boolean $noteq_str_T(std.string left, CharSequence right) {
    return !$eq_str_T(left, right);
  }

  public static boolean $noteq_T_str(char$iterator<?> left, std.string right) {
    return ! $eq_T_str(left, right);
  }

  public static boolean $noteq_T_str$C(char$iterator<?> left, std.string right) {
    return ! $eq_T_str(left, right);
  }

  public static boolean $noteq_T_string$C(char$iterator<?> left, std.string right) {
    return ! $eq_T_str(left, right);
  }

  public static boolean $noteq_str_T(std.string left, char$iterator<?> right) {
    return !$eq_str_T(left, right);
  }
  
  public static boolean $noteq_string$C_T(std.string left, char$iterator<?> right) {
    return !$eq_str_T(left, right);
  }
  
  public static boolean $noteq_string$C_T$C$P(std.string left, String right) {
    return !$eq_str_T(left, right);
  }
  
  public static boolean $noteq_string$C_T(std.string left, String right) {
    return !$eq_str_T(left, right);
  }
  
  public static boolean $noteq_str$C_T(std.string left, char$iterator<?> right) {
    return !$eq_str_T(left, right);
  }
  
  public static boolean $noteq_str$C_T(std.string left, String right) {
    return !$eq_str_T(left, right);
  }
  
  public static <T> boolean $noteq_T_str(T left, std.string right) {
    return ! $eq_T_str(left, right);
  }

  public static <T> boolean $noteq_str_T(std.string left, T right) {
    return !$eq_str_T(left, right);
  }

  public static boolean $eq_str$C(std.string left, std.string right) {
    return left.$eq(right);
  }

  public static boolean $eq_str(std.string left, std.string right) {
    return $eq_str$C(left, right);
  }

  public static int count(char$iterator __first, char$iterator __last, /*char*/byte c) {
    __first = $Clone(__first);
    int __n = 0;
    for (; $noteq_ptr(__first, __last); __first.$preInc()) {
      if (__first.$star() == c) {
        ++__n;
      }
    }
    return __n;
  }
  
  public static <T> int count(type$iterator<?, T> __first, type$iterator<?, T> __last, T t) {
    __first = $Clone(__first);
    int __n = 0;
    for (; $noteq_ptr(__first, __last); __first.$preInc()) {
      if ($eq(__first.$star(), t)) {
        ++__n;
      }
    }
    return __n;
  }
  
  public static <T> int count_if(type$iterator<?, T> __first, type$iterator<?, T> __last, BoolPredicate<T> __pred) {
    __first = $Clone(__first);
    int __n = 0;
    for (; $noteq_ptr(__first, __last); __first.$preInc()) {
      if (__pred.$call(__first.$star())) {
        ++__n;
      }
    }
    return __n;
  }

  public static <T1, T2> boolean $eq_pair(std.pair<T1, T2> left, std.pair<T1, T2> right) {
    return left.$eq(right);
  }
  
  public static <T1, T2> boolean $eq_pair$C(std.pair<T1, T2> left, std.pair<T1, T2> right) {
    return $eq_pair(left, right);
  }

  public static <T> int $sub___normal_iterator(vector.iterator<T> __lhs, vector.iterator<T> __rhs) {
    return __lhs.$sub(__rhs);
  }

  public static <T> int $sub___normal_iterator$C(vector.iterator<T> __lhs, vector.iterator<T> __rhs) {
    return __lhs.$sub(__rhs);
  }
  
  public static int $sub___normal_iterator$C(char$ptr __lhs, char$ptr __rhs) {
    return __lhs.$sub(__rhs);
  }

  public static int $sub__Deque_iterator$_Tp$_Ref$_Ptr$C(deque.iterator<string> XE, deque.iterator<string> XI) {
    if (XE == XI) {
      return 0;
    }
    return XE.$sub(XI);
  }
  
  public static <T> boolean $noteq__Deque_iterator$_Tp$_Ref$_Ptr$C(deque.iterator<T> XE, deque.iterator<T> XI) {
    return !XE.$eq(XI);
  }

  public static int $sub_reverse_iterator$C(std.reverse_iteratorChar __lhs, std.reverse_iteratorChar __rhs) {
    return __lhs.$sub(__rhs);
  }

  public static boolean $noteq___normal_iterator$C(abstract_iterator<?> __lhs, abstract_iterator<?> __rhs) {
    return $noteq___normal_iterator(__lhs, __rhs);
  }
  public static boolean $noteq___normal_iterator(abstract_iterator<?> __lhs, abstract_iterator<?> __rhs) {
    return !$eq___normal_iterator(__lhs, __rhs);
  }
  
  public static <T> boolean $noteq___normal_iterator(vector.iterator<T> __lhs, vector.iterator<T> __rhs) {
    return !$eq___normal_iterator(__lhs, __rhs);
  }

  public static boolean $noteq___normal_iterator(std.vectorString.iterator __lhs, std.vectorString.iterator __rhs) {
    return !$eq___normal_iterator(__lhs, __rhs);
  }

  public static boolean $eq___normal_iterator$C(abstract_iterator<?> __lhs, abstract_iterator<?> __rhs) {
    return $eq___normal_iterator(__lhs, __rhs);
  }
  public static boolean $eq___normal_iterator(abstract_iterator<?> __lhs, abstract_iterator<?> __rhs) {
    if (__lhs == __rhs) {
      return true;
    }
    return __lhs.$eq(__rhs);
  }

  public static <T> boolean $eq___normal_iterator$C(vector.iterator<T> __lhs, vector.iterator<T> __rhs) {
    return $eq___normal_iterator(__lhs, __rhs);
  }  
  public static <T> boolean $eq___normal_iterator(vector.iterator<T> __lhs, vector.iterator<T> __rhs) {
    return __lhs.$eq(__rhs);
  }

  public static <T> boolean $eq___normal_iterator$C(std.vectorString.iterator __lhs, std.vectorString.iterator __rhs) {
    return $eq___normal_iterator(__lhs, __rhs);
  }
  public static <T> boolean $eq___normal_iterator(std.vectorString.iterator __lhs, std.vectorString.iterator __rhs) {
    return __lhs.$eq(__rhs);
  }

  
  public static <T> void$ptr __builtin_memcpy(T to[], T from[]) {
    throw new IllegalArgumentException("Use method with trailing isPointerLike paramter");
  }
  public static <T> void$ptr __builtin_memcpy(T to[], T from[], boolean isPointerLike) {
    assert  from.length == to.length;
    return memcpy(create_type$ptr(to), create_type$ptr(from), from.length, isPointerLike);
  }
  public static <T> void$ptr memcpy(T to[], T from[], int size) {
    return memcpy(create_type$ptr(to), create_type$ptr(from), size);
  }
  public static <T> void$ptr memcpy(T to[], int idxTo, T from[], int idxFrom, int size) {
    return memcpy(create_type$ptr(to, idxTo), create_type$ptr(from, idxFrom), size);
  }
  public static <T> void$ptr memmove(T to[], int idxTo, T from[], int idxFrom, int size) {
    return memmove(create_type$ptr(to, idxTo), create_type$ptr(from, idxFrom), size);
  }

  public static void$ptr memcpy(long to[], long from[], int size) {
    return memcpy(create_ulong$ptr(to), create_ulong$ptr(from), size);
  }

  public static void __builtin_memcpy(byte to[], byte from[]) {
    memcpy(to, from, from.length); // possible out of bounds; should it be Math.min(from.length, to.length) ?
  }
  public static void __builtin_memcpy(byte to[], byte from[], int size) {
    memcpy(to, from, size);
  }  
  public static void memcpy(byte to[], byte from[], int size) {
    memcpy(to, 0, from, 0, size);
  }

  public static void memcpy(byte to[], CharSequence from) {
    memcpy(to, from, from.length());
  }

  public static void memcpy(byte to[], CharSequence from, int size) {
    memcpy(create_char$ptr(to), create_char$ptr(from), size);
  }

  public static void memcpy(byte to[], char$ptr from, int size) {
    memcpy(to, 0, from, 0, size);
  }
  public static void memcpy(byte to[], int StartIdx, char$ptr from, int fromIdx, int size) {
    if (from instanceof char$ptr$array) {
      memcpy(to, StartIdx, from.$array(), from.$index() + fromIdx, size);
    } else {
      int End = (int)size + StartIdx;
      for (int i = StartIdx, j = fromIdx; i < End; i++, j++) {
        to[i] = from.$at(j);
      }    
    }
  }

  public static void memcpy(byte to[], uchar$ptr from, int size) {
    memcpy(to, 0, from, 0, size);
  }

  public static void memcpy(uchar$ptr to, uchar$ptr from, int size) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static void memcpy(byte to[], int StartIdx, uchar$ptr from, int fromIdx, int size) {
    if (from instanceof uchar$ptr$array) {
      memcpy(to, StartIdx, from.$array(), from.$index() + fromIdx, size);
    } else {
      int End = (int)size + StartIdx;
      for (int i = StartIdx, j = fromIdx; i < End; i++, j++) {
        to[i] = from.$at(j);
      }    
    }
  }

  public static void$ptr memmove(type$ptr to, type$ptr from, /*size_t*/int size) {
    if (to.$less(from)) {
      for (int i = 0; i < size; i++) {
        to.$set(i, from.$at(i));
      }
    } else {
      for (int i = size-1; i >= 0; --i) {
        to.$set(i, from.$at(i));
      }
    }
    return to;
  }

  public static void$ptr memmove(char$ptr to, char$ptr from, /*size_t*/int size) {
    if (to.$less(from)) {
      for (int i = 0; i < size; i++) {
        to.$set(i, from.$at(i));
      }
    } else {
      for (int i = size-1; i >= 0; --i) {
        to.$set(i, from.$at(i));
      }
    }
    return to;
  }

  public static void$ptr move(char$ptr begin, char$ptr end, char$ptr dst) {
    int size = std.distance(end, begin);
    return memmove(dst, begin, size);
  }
  
  // Moves the elements in the range [first, last), to another range beginning
  // at d_first. After this operation the elements in the moved-from range will
  // still contain valid values of the appropriate type, but not necessarily 
  // the same values as before the move.
  public static <OutIter extends type$iterator<OutIter, T>, T> OutIter move(type$iterator<?, T> first, type$iterator<?, T> last, OutIter result, boolean isDataPointerLike) {
    result = result.clone();
    if (first.$eq(last)) {
      return result;
    }
    first = first.clone();
    while (first.$noteq(last)) {
      if (isDataPointerLike) {
        result.star$ref().$set(first.$star());
      } else {
        // Try setMove without moving explicitely
        result.star$ref().$setMove(first.$star());
        if (result.$star() == first.$star()) {
          // If failed ($set implementation is incorrect. Maybe due to performance reasons), move and set
          result.star$ref().$set($tryMove(first.$star()));
        }
      }
      result.$preInc();
      first.$preInc();
    }
    return result;
  }
  public static <OutIter extends bool$iterator<OutIter>> OutIter move(bool$iterator<?> first, bool$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends bool$iterator<OutIter>> OutIter move(bool$iterator<?> first, bool$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends char$iterator<OutIter>> OutIter move(char$iterator<?> first, char$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends char$iterator<OutIter>> OutIter move(char$iterator<?> first, char$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends uchar$iterator<OutIter>> OutIter move(uchar$iterator<?> first, uchar$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends uchar$iterator<OutIter>> OutIter move(uchar$iterator<?> first, uchar$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends short$iterator<OutIter>> OutIter move(short$iterator<?> first, short$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends short$iterator<OutIter>> OutIter move(short$iterator<?> first, short$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends ushort$iterator<OutIter>> OutIter move(ushort$iterator<?> first, ushort$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends ushort$iterator<OutIter>> OutIter move(ushort$iterator<?> first, ushort$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends int$iterator<OutIter>> OutIter move(int$iterator<?> first, int$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends int$iterator<OutIter>> OutIter move(int$iterator<?> first, int$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends uint$iterator<OutIter>> OutIter move(uint$iterator<?> first, uint$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends uint$iterator<OutIter>> OutIter move(uint$iterator<?> first, uint$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends long$iterator<OutIter>> OutIter move(long$iterator<?> first, long$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends long$iterator<OutIter>> OutIter move(long$iterator<?> first, long$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends ulong$iterator<OutIter>> OutIter move(ulong$iterator<?> first, ulong$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends ulong$iterator<OutIter>> OutIter move(ulong$iterator<?> first, ulong$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends double$iterator<OutIter>> OutIter move(double$iterator<?> first, double$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends double$iterator<OutIter>> OutIter move(double$iterator<?> first, double$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }
  public static <OutIter extends float$iterator<OutIter>> OutIter move(float$iterator<?> first, float$iterator<?> last, OutIter result) {
    return move(first, last, result, false);
  }
  public static <OutIter extends float$iterator<OutIter>> OutIter move(float$iterator<?> first, float$iterator<?> last, OutIter result, boolean isDataPointerLike) {
    return copy(first, last, result, isDataPointerLike);
  }

  public static void$ptr memcpy(type$ptr to, type$ptr from, /*size_t*/int size, boolean isPointerLike) {
    for (int i = 0; i < size; i++) {
      to.$set(i, Native.$tryAssign(null, from.$at(i), isPointerLike));
    }
    return to;
  }
  
  @Deprecated // Use memcpy with specified trailing isDataPointerLike
  public static void$ptr memcpy(type$ptr to, type$ptr from, /*size_t*/int size) {
    return memcpy(to, from, size, true/*PointerLike*/);
  }

  public static void$ptr memcpy(long$ptr to, char$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_LONG == 0) : "size="+size;
    for (int index = 0; index < size; index+=NativeType.BYTES_IN_LONG) {
      to.$set(ByteUtils.bytesToLong(from, index, NativeType.BYTES_IN_LONG));
    }
    return to;
  }

  public static void$ptr memcpy(uint$ptr to, char$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_UINT == 0) : "size="+size;
    for (int index = 0; index < size; index+=NativeType.BYTES_IN_UINT) {
      to.$set(ByteUtils.bytesToUInt(from, index, NativeType.BYTES_IN_UINT));
    }
    return to;
  }

  public static void$ptr memcpy(ushort$ptr to, char$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_USHORT == 0) : "size="+size;
    for (int index = 0; index < size; index+=NativeType.BYTES_IN_USHORT) {
      to.$set(ByteUtils.bytesToUShort(from, index, NativeType.BYTES_IN_USHORT));
    }
    return to;
  }

  public static void$ptr memcpy(ulong$ptr to, char$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_ULONG == 0) : "size="+size;
    for (int index = 0; index < size; index+=NativeType.BYTES_IN_ULONG) {
      to.$set(ByteUtils.bytesToULong(from, index, NativeType.BYTES_IN_ULONG));
    }
    return to;
  }
  
  public static void$ptr memcpy(int$ptr to, int$ptr from, /*size_t*/int size, boolean isPointerLike) { assert !isPointerLike; return memcpy(to, from, size); }
  public static void$ptr memcpy(int$ptr to, int$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_INT == 0) : "size="+size;
    for (int i = 0; i < size / NativeType.BYTES_IN_INT; i++) {
      to.$set(i, from.$at(i));
    }
    return to;
  }

  public static void$ptr memcpy(uint$ptr to, uint$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_UINT == 0) : "size="+size;
    for (int i = 0; i < size / NativeType.BYTES_IN_UINT; i++) {
      to.$set(i, from.$at(i));
    }
    return to;
  }

  public static void$ptr memcpy(ulong$ptr to, ulong$ptr from, /*size_t*/int size, boolean isPointerLike) { assert !isPointerLike; return memcpy(to, from, size); }  
  public static void$ptr memcpy(ulong$ptr to, ulong$ptr from, /*size_t*/int size) {
    assert (size % NativeType.BYTES_IN_ULINT == 0) : "size="+size;
    for (int i = 0; i < size / NativeType.BYTES_IN_ULINT; i++) {
      to.$set(i, from.$at(i));
    }
    return to;
  }

  public static void copy_long_to_char$ptr(char$ptr to, int StartIdx, long Value, int ValOffset, int size) {
    int End = size + StartIdx;
    // shift Value to Offset; move rightmost to the last size bytes
    Value = Value >>> (NativeType.CHAR_BIT * (NativeType.BYTES_IN_LONG - ValOffset - size));
    // set bytes starting from the last one
    for (int idx = End - 1; idx >= StartIdx; --idx) {
      // set right byte
      to.$set(idx, (byte)(Value & 0xFFL));
      // move the next byte to right
      Value >>>= NativeType.CHAR_BIT;
    }
  }

  public static void memcpy(char$ptr to, char$ptr from, /*size_t*/int size) {
    memcpy(to, 0, from, 0, (int) size);
  }

  public static void memcpy(char$ptr to, int StartIdx, char$ptr from, int StartIdxFrom, int Length) {
//    if (to instanceof char$ptr$array && from instanceof char$ptr$array) {
//      memcpy(to.$array(), to.$index() + StartIdx, from.$array(), from.$index() + StartIdxFrom, Length);
//    } else {
      int End = Length + StartIdx;
      for (int i = StartIdx, j = StartIdxFrom; i < End; i++, j++) {
        to.$set(i, from.$at(j));
      }
//    }
//    return to;
  }

  public static void memcpy(char$ptr to, int idxTo, byte[] DataFrom, int StartIdxFrom, int size) {
//    if (to instanceof char$ptr$array) {
//      memcpy(to.$array(), to.$index() + idxTo, DataFrom, StartIdxFrom, size);
//    } else {
      for (int i = 0; i < size; i++) {
        to.$set(idxTo++, DataFrom[StartIdxFrom++]);
      }
//    }
//    return to;
  }

  public static char$ptr memcpy(char$ptr to, int idxTo, CharSequence DataFrom, int StartIdxFrom, int size) {
    for (int i = 0; i < size; i++) {
      to.$set(idxTo++, $ushort2uchar(DataFrom.charAt(StartIdxFrom++)));
    }
    return to;
  }

  public static void memcpy(byte[] DataTo, int StartIdx, byte[] DataFrom, int StartIdxFrom, /*size_t*/int Length) {
    // redirect to gather statistics
    NativePointer.copy$char(DataFrom, StartIdxFrom, DataTo, StartIdx, Length);
  }

  public static int memcmp(byte[] Data, byte[] DataOther, /*size_t*/int Length) {
    return memcmp(Data, 0, DataOther, 0, Length);
  }
  public static int memcmp(byte[] Data, int StartIdx, byte[] DataOther, int StartIdxOther, /*size_t*/int Length) {
    // TODO: do less cycles by removing substruct
    int Res = 0;
    int End = (int)Length + StartIdx;
    for (int i = StartIdx, j = StartIdxOther; i < End && Res == 0; i++, j++) {
      Res = Data[i] - DataOther[j];
    }
    return Res;
  }
  
  public static int memcmp(char$ptr str1, char$ptr str2, /*size_t*/int len) {
    return memcmp(str1, 0, str2, 0, len);
  }
  
  public static int memcmp(char$ptr str1, /*size_t*/int str1Idx, char$ptr str2, /*size_t*/int str2Idx, /*size_t*/int _len) {
    int pos = 0, len = (int)_len;
    byte ch1 = 0, ch2 = 0;
    while (pos < len && (ch1 = str1.$at(str1Idx)) == (ch2 = str2.$at(str2Idx))) {
      pos++;str1Idx++;str2Idx++;
    }
    return pos == len ? 0 : $uchar2ushort(ch1) - $uchar2ushort(ch2); // works for ascii chars
  }
  
  public static int memcmp(uint$ptr ptr1, uint$ptr ptr2, /*size_t*/int size) {
    int pos = 0, len = size / NativeType.BYTES_IN_UINT, val1 = 0, val2 = 0;
    while (pos < len && (val1 = ptr1.$at(pos)) == (val2 = ptr2.$at(pos))) {
      pos++;
    }
    return pos == len ? 0 : val1 - val2; // works for ascii chars
  }

  public static boolean memcmp_eq(type$ptr ptr1, type$ptr ptr2, /*size_t*/int size) {
    int pos = 0, len = size;
    Object val1 = null, val2 = null;
    while (pos < len) {
      val1 = ptr1.$at(pos);
      val2 = ptr2.$at(pos);
      if (val1 instanceof void$ptr && val2 instanceof void$ptr) {
        if (!Native.$eq_ptr(val1, val2)) {
          return false;
        }
      } else if (!Native.$eq(val1, val2)) {
        return false;
      }
      pos++;
    }
    assert pos == len || Native.$noteq(val1, val2);
    return pos == len;
  }

  public static int memcmp(type$ptr ptr1, type$ptr ptr2, /*size_t*/int size) {
    int pos = 0, len = size;
    Object val1 = null, val2 = null;
    while (pos < len && Native.$eq_ptr((val1 = ptr1.$at(pos)), (val2 = ptr2.$at(pos)))) {
      pos++;
    }
    assert pos == len || Native.$noteq_ptr(val1, val2);
    return pos == len ? 0 : Native.$less(val1, val2) ? -1 : 1;
  }

  public static int memcmp_null_termed(char$ptr str1, char$ptr nullTermed, /*size_t*/int str1Len) {
    int pos = 0;
    byte ch1 = $$TERM, ch2 = $$TERM;
    while (pos < str1Len && (ch1 = str1.$at(pos)) == (ch2 = nullTermed.$at(pos)) && (ch2 != $$TERM)) {
      pos++;
    }
    if (pos == str1Len) {
      assert ch2 != $$TERM || str1Len == 0;
      // equal only if the next is end of null-term string
      return nullTermed.$at(pos) == $$TERM ? 0 : -1;
    }
    return $uchar2ushort(ch1) - $uchar2ushort(ch2); // works for ascii chars
  }

  public static int memcmp_null_termed(CharSequence str1, int str1FromIdx, byte[] nullTermed, int nullTermedFromIdx, /*size_t*/int str1Len) {
    int pos = 0;
    /*unsigned!*/char ch1 = 0, ch2 = 0;
    while (pos < str1Len && (ch1 = str1.charAt(str1FromIdx)) == (ch2 = $uchar2ushort(nullTermed[nullTermedFromIdx])) && (ch2 != 0)) {
      pos++;str1FromIdx++;nullTermedFromIdx++;
    }
    if (pos == str1Len) {
      assert ch2 != $$TERM || str1Len == 0;
      // equal only if the next is end of null-term string
      return nullTermed[nullTermedFromIdx] == $$TERM ? 0 : -1;
    }
    return ch1 - ch2; // works for ascii chars
  }

  public static int memcmp_null_termed(char$ptr str1, byte[] nullTermed, int nullTermedFromIdx, /*size_t*/int str1Len) {
    int pos1 = 0, pos2 = nullTermedFromIdx;
    byte ch1 = $$TERM, ch2 = $$TERM;
    while (pos1 < str1Len && (ch1 = str1.$at(pos1)) == (ch2 = nullTermed[pos2]) && (ch2 != $$TERM)) {
      pos1++;pos2++;
    }
    if (pos1 == str1Len) {
      assert ch2 != $$TERM || str1Len == 0;
      // equal only if the next is end of null-term string
      return nullTermed[pos2] == $$TERM ? 0 : -1;
    }
    return $uchar2ushort(ch1) - $uchar2ushort(ch2); // works for ascii chars
  }

  // NOTE: when substring starting at str1[str1StartIndex] with str1Len bytes is equal to postfix nullTermed[nullTermedFromIdx] it returns zero
  public static int memcmp_null_termed(byte[] str1, int str1StartIndex, byte[] nullTermed, int nullTermedFromIdx, /*size_t*/int str1Len) {
    final /*uint*/int str1EndPos = str1StartIndex + str1Len;
    int pos1 = str1StartIndex, pos2 = nullTermedFromIdx;
    byte ch1 = $$TERM, ch2 = $$TERM;
    while (pos1 < str1EndPos && (ch1 = str1[pos1]) == (ch2 = nullTermed[pos2]) && (ch2 != $$TERM)) {
      pos1++;pos2++;
    }
    if (pos1 == str1Len) {
      assert ch2 != $$TERM || str1Len == 0;
      // equal only if the next is end of null-term string
      return nullTermed[pos2] == $$TERM ? 0 : -1;
    }
    return $uchar2ushort(ch1) - $uchar2ushort(ch2); // works for ascii chars
  }

  public static int memcmp(char$ptr str1, byte[] str2, int str2Idx, /*size_t*/int len) {
    return memcmp(str1, 0, str2, str2Idx, len);
  }
  
  public static int memcmp(char$ptr str1, int str1Idx, byte[] str2, int str2Idx, /*size_t*/int len) {
    int pos = 0;
    byte ch1 = $$TERM, ch2 = $$TERM;
    while (pos < len && (ch1 = str1.$at(str1Idx)) == (ch2 = str2[str2Idx])) {
      pos++;str1Idx++;str2Idx++;
    }
    return pos == len ? 0 : $uchar2ushort(ch1) - $uchar2ushort(ch2); // works for ascii chars
  }
  public static int memcmp(byte[] str1, int str1Idx, CharSequence str2, /*size_t*/int len) {
    return memcmp(str1, str1Idx, str2, 0, len);
  }
  public static int memcmp(byte[] str1, int str1Idx, CharSequence str2, int str2Idx, /*size_t*/int len) {
    int pos = 0;
    /*unsigned!*/char ch1 = $$TERM, ch2 = $$TERM;
    while (pos < len && (ch1 = $uchar2ushort(str1[str1Idx])) == (ch2 = str2.charAt(str2Idx))) {
      pos++;str1Idx++;str2Idx++;
    }
    return pos == len ? 0 : ch1 - ch2; // works for ascii chars
  }
  
  public static int memcmp(char$ptr ptr, CharSequence Str, /*size_t*/int len) {
    return memcmp(ptr, 0, Str, 0, len);
  }

  public static int memcmp(char$ptr ptr, /*size_t*/int ptrIdx, CharSequence Str, /*size_t*/int StrIdx, /*size_t*/int _len) {
    int pos = 0, len = (int)_len;
    /*unsigned!*/char ch1 = 0, ch2 = 0;
    while (pos < len && (ch1 = $uchar2ushort(ptr.$at(ptrIdx))) == (ch2 = Str.charAt(StrIdx))) {
      pos++;ptrIdx++;StrIdx++;
    }
    return pos == len ? 0 : ch1 - ch2; // works for ascii chars
  }

  public static int memcmp(CharSequence Str, char$ptr ptr, /*uint*/int len) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static int memcmp(CharSequence Str, CharSequence ptr, /*uint*/int len) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static void free(Object o) {
    // do nothing
  }

  /* Return the number of bytes in a page.  This is the system's page size,
   which is not necessarily the same as the hardware page size.  */
  public static int getpagesize () {
    return 64 * 1024;
  }

  /* Return the value of envariable NAME, or NULL if it doesn't exist.  */
  public static char$ptr getenv (char$ptr __name) {
    return getenv(Native.$toString(__name));
  }
  public static char$ptr getenv (String __name) {
    if (NativeTrace.isUnitTestMode()) {
      char$ptr env = get$$env.$$SET_ENV.ENV.get(__name);
      if (env != null) {
        return env;
      }
    }
    // PWD is mapped to the original cwd
    if ("PWD".equals(__name)) {
      return get$$env.$$PWD.PWD;
    }
    String env = System.getenv(__name);
    if (env == null) {
      return null;
    }
    return create_char$ptr_utf8(env);
  }
  
  /**
   * prepare std.getenv for unit test run.
   * @param envs collection of "KEY=VALUE" strings
   */  
  public static void set_unit_test_env(List<String> envs) {
    assert NativeTrace.isUnitTestMode();
    ConcurrentMap<String, char$ptr> ENV = get$$env.$$SET_ENV.ENV;
    synchronized (ENV) {
      for (Map.Entry<String, char$ptr> entry : ENV.entrySet()) {
        char$ptr value = entry.getValue();
        assert NativeTrace.unregisterArrayWithImmutableContent(value.$array(), "NativePointer.utf8:"+Casts.toJavaString(value));
      }
      ENV.clear();
      for (String env : envs) {
        String[] key_value = env.split("=", 2);
        assert key_value.length == 2 : "unexpected split of [" + env + "]" + Arrays.toString(key_value);
        String key = key_value[0];
        String value = key_value[1];
        assert key != null : "unexpected split of [" + env + "]" + Arrays.toString(key_value);
        key = key.trim();
        // TODO: do we need to trim values?
        assert value != null : "unexpected split of [" + env + "]" + Arrays.toString(key_value);
        if (value.startsWith("\"") && value.endsWith("\"")) {
          // value is placed in shell quotes, remove them
          value = value.substring(1, value.length()-1);
        }
        char$ptr $value = $toConst(create_char$ptr_utf8(value));
        char$ptr $prev = ENV.put(key, $value);
        assert $prev == null : "not expected previous value " + $prev;
      }
    }
  }
  
  public static char$ptr setenv(char$ptr env, char$ptr value, int opt) {
    return setenv(Native.$toString(env), Native.$toString(value), opt);
  }
  
  public static char$ptr setenv(String env, String value, int opt) {
    ConcurrentMap<String, char$ptr> ENV = get$$env.$$SET_ENV.ENV;
    char$ptr $value = $toConst(create_char$ptr_utf8(value));
    char$ptr $prev = ENV.put(env, $value);
    return $prev;
  }
  
  public static char$ptr unsetenv(char$ptr env) {
    return unsetenv(Native.$toString(env));
  }
  public static char$ptr unsetenv(String key) {
    ConcurrentMap<String, char$ptr> ENV = get$$env.$$SET_ENV.ENV;
    char$ptr $prev = ENV.remove(key);
    return $prev;
  }
  
  private static final class get$$env {
    private static final class $$SET_ENV {
      private static final ConcurrentMap<String, char$ptr> ENV = new ConcurrentHashMap<String, char$ptr>();
    }
    private static final class $$PWD {
      private static final char$ptr PWD = create_char$ptr_utf8(io.getCWD());
    }
  }

  /**
   *  @brief Swap the elements of two sequences.
   *  @ingroup mutating_algorithms
   *  @param  __first1  A forward iterator.
   *  @param  __last1   A forward iterator.
   *  @param  __first2  A forward iterator.
   *  @return   An iterator equal to @p first2+(last1-first1).
   *
   *  Swaps each element in the range @p [first1,last1) with the
   *  corresponding element in the range @p [first2,(last1-first1)).
   *  The ranges must not overlap.
  */
  public static <_ForwardIterator1 extends type$iterator<?, T>, _ForwardIterator2 extends type$iterator<?, T>, T>
  _ForwardIterator2
  swap_ranges(_ForwardIterator1 __first1, _ForwardIterator1 __last1,
	_ForwardIterator2 __first2)
  {
    __first1 = $tryClone(__first1);
    __first2 = $tryClone(__first2);
    for (; __first1.$noteq(__last1); __first1.$preInc(), __first2.$preInc())
      std.iter_swap(__first1, __first2);
    return __first2;
  }

  public static <T> void iter_swap(T[] ar, int index1, int index2) {
    T v1 = ar[index1];
    ar[index1] = ar[index2];
    ar[index2] = v1;
  }
  
  /**
   *  @brief Swaps the contents of two iterators.
   *  @ingroup mutating_algorithms
   *  @param  __a  An iterator.
   *  @param  __b  Another iterator.
   *  @return   Nothing.
   *
   *  This function swaps the values pointed to by two iterators, not the
   *  iterators themselves.
  */
  public static <_ForwardIterator1 extends type$iterator<?, T>, _ForwardIterator2 extends type$iterator<?, T>, T>
  void
  iter_swap(_ForwardIterator1 __a, _ForwardIterator2 __b)
  {
    T __tmp = $tryClone(__a.$star());
    __a.star$ref().$set(__b.$star());
    __b.star$ref().$set(__tmp);
  }
  public static void iter_swap(char$ptr __a, char$ptr __b)
  {
    byte __tmp = __a.$star();
    __a.$set(__b.$star());
    __b.$set(__tmp);
  }
  public static void iter_swap(char$ptr __a, int aAtIdx, char$ptr __b, int bAtIdx)
  {
    byte __tmp = __a.$at(aAtIdx);
    __a.$set(aAtIdx, __b.$at(bAtIdx));
    __b.$set(bAtIdx, __tmp);
  }
  public static void iter_swap(char$iterator lhs, char$iterator rhs) {
      byte tmp = lhs.$star();
      lhs.star$ref().$set(rhs.$star());
      rhs.star$ref().$set(tmp);
  }
  
  public static int isalnum(int ch) {
    return std.max(isalpha(ch), isdigit(ch));
  };

  public static int isalpha(int ch) {
    return Character.isLetter($char(ch)) ? 1 : 0;
  };

  public static int iscntrl(int ch) {
    return isprint($char(ch)) != 0 ? 0 : 1;
  };

  public static int isdigit(int ch) {
    return Character.isDigit($char(ch)) ? 1 : 0;
  };

  public static int isdigit(/*char*/byte ch) {
    return Character.isDigit($char(ch)) ? 1 : 0;
  };

  public static int islower(int ch) {
    return Character.isLowerCase($char(ch)) ? 1 : 0;
  };

  public static int isgraph(int ch) {
    return (isspace(ch) == 0 && isprint(ch) != 0) ? 1 : 0;
  };

  public static int isprint(/*uchar*/byte c) {
    return isprint(c & 0xFF);
  }
  public static int isprint(int c) {
    Character.UnicodeBlock block = Character.UnicodeBlock.of( c );
    if ((!Character.isISOControl(c)) &&
            c != 0xFFFF &&
            block != null &&
            block != Character.UnicodeBlock.SPECIALS) {
      return 1;
    }
    return 0;
  };

  public static int ispunct(int ch) {
    return (isalnum(ch) == 0 && isgraph(ch) != 0) ? 1 : 0;
  };

  public static int isspace(int ch) {
    return Character.isSpaceChar($char(ch)) ? 1 : 0;
  };

  public static int isupper(int ch) {
    return Character.isUpperCase($char(ch)) ? 1 : 0;
  };

  public static int isxdigit(int ch) {
    switch ($char(ch)) {
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      case 'a':
      case 'b':
      case 'c':
      case 'd':
      case 'e':
      case 'f':
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
        return 1;
    }
    return 0;
  };

  /* Return the lowercase version of C.  */
  public static int tolower (int __c) {
    return Character.toLowerCase(__c);
  }

  /* Return the lowercase version of C.  */
  public static byte tolower (byte __c) {
    assert __c >= 0 : "unexpected " + __c;
    int out = Character.toLowerCase(__c);
    assert out >= 0;
    assert out <= 127;
    return (byte)out;
  }

  /* Return the uppercase version of C.  */
  public static int toupper (int __c) {
    return Character.toUpperCase(__c);
  }

  /**
   *  @brief Fills the range [first,last) with copies of value.
   *  @ingroup mutating_algorithms
   *  @param  __first  A forward iterator.
   *  @param  __last   A forward iterator.
   *  @param  __value  A reference-to-const of arbitrary type.
   *  @return   Nothing.
   *
   *  This function fills a range with copies of the same value.  For char
   *  types filling contiguous areas of memory, this becomes an inline call
   *  to @c memset or @c wmemset.
  */
  public static <T> void fill(type$iterator<?, T> __first, type$iterator<?, T> __last, T __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.star$ref().$set(__value);
    }
  }

  public static void fill(ulong$iterator<?> __first, ulong$iterator<?> __last, long __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.star$ref().$set(__value);
    }
  }

  public static void fill(long$iterator<?> __first, long$iterator<?> __last, long __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.star$ref().$set(__value);
    }
  }

  public static void fill(int$iterator<?> __first, int$iterator<?> __last, int __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.star$ref().$set(__value);
    }
  }

  public static void fill(ushort$iterator<?> __first, ushort$iterator<?> __last, /*ushort*/char __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.star$ref().$set(__value);
    }
  }
  
  public static void fill(char$iterator<?> __first, char$iterator<?> __last, /*char*/byte __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.star$ref().$set((byte)__value);
    }
  }
  
  public static <T> void fill(type$ptr<T> __first, type$ptr<T> __last, T __value) {
    __first = $tryClone(__first);
    for (; __first.$noteq(__last); __first.$preInc()) {
      __first.$set(0, $tryClone(__value));
    }
  }
  
  /**
   *  @brief  Determines whether the elements of a sequence are sorted.
   *  @ingroup sorting_algorithms
   *  @param  __first   An iterator.
   *  @param  __last    Another iterator.
   *  @return  True if the elements are sorted, false otherwise.
  */
  public static <T> boolean is_sorted(type$iterator<?, T> __first, type$iterator<?, T> __last) {
    return std.is_sorted_until(__first, __last).$eq(__last);
  }
  public static <T> boolean is_sorted(type$iterator<?, T> __first, type$iterator<?, T> __last, TypeType2Bool<T> __comp) {
    return std.__is_sorted_until(__first, __last, new _Iter_less_adapter(__comp)).$eq(__last);
  }

  public static boolean is_sorted(uint$ptr begin, uint$ptr end) {
    int c = Integer.MIN_VALUE;
    for(uint$ptr I = $tryClone(begin); !$eq_ptr(I, end); I.$preInc()) {
      if (c <= I.$star()) {
        c = I.$star();
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   *  @brief  Determines the end of a sorted sequence.
   *  @ingroup sorting_algorithms
   *  @param  __first   An iterator.
   *  @param  __last    Another iterator.
   *  @return  An iterator pointing to the last iterator i in [__first, __last)
   *           for which the range [__first, i) is sorted.
  */
  public static <T> type$iterator<?, T> is_sorted_until(
          type$iterator<?, T> __first, type$iterator<?, T> __last
  ) {
      return std.__is_sorted_until(__first, __last, __iter_less_iter());
  }
  
  private static <T> type$iterator<?, T> __is_sorted_until(
          type$iterator<?, T> __first, type$iterator<?, T> __last,
          TypeType2Bool<type$iterator<?, T>> __comp
  ) {
    if (__first.$eq(__last)) {
      return __last;
    }
    
    type$iterator<?, T> __next = $tryClone(__first);
    for (__next.$preInc(); __next.$noteq(__last); __first = $tryClone(__next), __next.$preInc()) {
      if (__comp.$call(__next, __first)) {
        return __next;
      }
    }
    return __next;
  }
  
  private static <T> _Iter_less_iter<T> __iter_less_iter() { 
    return new _Iter_less_iter(); 
  }
  
  private static final class _Iter_less_adapter<T> implements TypeType2Bool<type$iterator<?, T>> {
    private final TypeType2Bool<T> wrapped;

    public _Iter_less_adapter(TypeType2Bool<T> wrapped) {
      this.wrapped = wrapped;
    }
    
    @Override
    public boolean $call(type$iterator<?, T> a, type$iterator<?, T> b) {
      return wrapped.$call(a.$star(), b.$star());
    } 
  }
  
  private static final class _Iter_less_iter<T> implements TypeType2Bool<type$iterator<?, T>> {
    @Override
    public boolean $call(type$iterator<?, T> a, type$iterator<?, T> b) {
      return Native.$less(a.$star(), b.$star());
    } 
  }

  /**
   *  @brief  Create an object that is owned by a shared_ptr.
   *  @param  __args  Arguments for the @a _Tp object's constructor.
   *  @return A shared_ptr that owns the newly created object.
   *  @throw  std::bad_alloc, or an exception thrown from the
   *          constructor of @a _Tp.
   */
  public static <T> std.shared_ptr<T> make_shared(T val) {
    // no tryClone needed here! T val was created by JConvert as param to make_shared
    return new std.shared_ptr<T>(val);
  }

  public static <T> std.unique_ptr<T> make_unique(T val) {
    // no tryClone needed here! T val was created by JConvert as param to make_unique
    return new std.unique_ptr<T>(val);
  }
  
  public static <T> std.unique_ptr_array<T> make_unique(T val[]) {
    // TODO: probably no tryClone needed here!
    return new std.unique_ptr_array<T>(val);
  }
  
  public static <T> boolean any_of(type$iterator<?, T> first, type$iterator<?, T> last, NativeCallback.BoolPredicate<T> predicate) {
    for(type$iterator<?, T> next = $tryClone(first); next.$noteq(last); next.$preInc()) {
      if (predicate.$call(next.$star())) {
        return true;
      }
    }
    return false;
  }
  
  public static <T> boolean all_of(std.vector.iterator<T> first, std.vector.iterator<T> last, NativeCallback.BoolPredicate<T> predicate) {
    first = $tryClone(first);
    while (first.$noteq(last)) {
      if (!predicate.$call(first.$star())) {
        return false;
      }
      first.$preInc();
    }
    return true;
  }

  public static <T> boolean all_of(uint$iterator first, uint$iterator last, UIntBoolPredicate predicate) {
    first = $tryClone(first);
    while (first.$noteq(last)) {
      if (!predicate.$call(first.$star())) {
        return false;
      }
      first.$preInc();
    }
    return true;
  }

  public static <T> boolean none_of(std.vector.iterator<T> first, std.vector.iterator<T> last, NativeCallback.BoolPredicate<T> predicate) {
    return Native.$eq_iter(last, find_if(first, last, predicate));
  }
  
  public static <T> boolean none_of(type$ptr<T> first, type$ptr<T> last, NativeCallback.BoolPredicate<T> predicate) {
    return Native.$eq_iter(last, find_if(first, last, predicate));
  }
  
  /**
   *  @brief  Common %iterator class.
   *
   *  This class does nothing but define nested typedefs.  %Iterator classes
   *  can inherit from this class to save some work.  The typedefs are then
   *  used in specializations and overloading.
   *
   *  In particular, there are no default implementations of requirements
   *  such as @c operator++ and the like.  (How could there be?)
  */
  public static interface iterator<_Category, _Tp /*typename _Distance = ptrdiff_t, typename _Pointer = _Tp*, typename _Reference = _Tp&*/> {
//      /// One of the @link iterator_tags tag types@endlink.
//      typedef _Category  iterator_category;
//      /// The type "pointed to" by the iterator.
//      typedef _Tp        value_type;
//      /// Distance between iterators is represented as this type.
//      typedef _Distance  difference_type;
//      /// This type represents a pointer-to-value_type.
//      typedef _Pointer   pointer;
//      /// This type represents a reference-to-value_type.
//      typedef _Reference reference;
    
    default void $iterator() {}
    default void $iterator(iterator other) {}
    default void $iterator(JD$Move param, iterator other) {}
  }

//<editor-fold defaultstate="collapsed" desc="Reverse iterators">
  public static class reverse_iterator<T> extends StdReverseIterator<T> {

    public reverse_iterator(type$iterator<?, T> delegate) {
      super(delegate);
    }

    public reverse_iterator(JD$NoCloneInput _dparm, type$iterator<?, T> delegate) {
      super(_dparm, delegate);
    }
    
    public reverse_iterator(reverse_iterator<T> other) {
      super((StdReverseIterator<T>)other);
    }
    
    public reverse_iterator(JD$Reverse_iterator$_Iter$C diff, reverse_iterator<T> other) {
      super((StdReverseIterator<T>)other);
    }
  }

  public static class reverse_iteratorBool extends StdReverseIteratorBool {

    public reverse_iteratorBool(bool$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorChar extends StdReverseIteratorChar {

    public reverse_iteratorChar(char$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorInt extends StdReverseIteratorInt {

    public reverse_iteratorInt(int$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorFloat extends StdReverseIteratorFloat {

    public reverse_iteratorFloat(float$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorDouble extends StdReverseIteratorDouble {

    public reverse_iteratorDouble(double$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorLLong extends StdReverseIteratorLLong {

    public reverse_iteratorLLong(llong$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorLong extends StdReverseIteratorLong {

    public reverse_iteratorLong(long$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorShort extends StdReverseIteratorShort {

    public reverse_iteratorShort(short$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorUChar extends StdReverseIteratorUChar {

    public reverse_iteratorUChar(uchar$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorULong extends StdReverseIteratorULong {

    public reverse_iteratorULong(ulong$iterator<?> delegate) {
      super(delegate);
    }
  }
  public static class reverse_iteratorULLong extends StdReverseIteratorULLong {

    public reverse_iteratorULLong(ullong$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorUShort extends StdReverseIteratorUShort {

    public reverse_iteratorUShort(ushort$iterator<?> delegate) {
      super(delegate);
    }
  }

  public static class reverse_iteratorUInt extends StdReverseIteratorUInt {

    public reverse_iteratorUInt(uint$iterator<?> delegate) {
      super(delegate);
    }
  }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Vectors">
  public final static class vector<T> extends StdVector<T> implements NativeIterable<StdVector.iterator<T>> {

    public vector(T defaultValue) {
      super(getSupplier(defaultValue));
    }

    public vector(int initialSize, T defaultValue) {
      super(initialSize, getSupplier(defaultValue));
    }

    public vector(int initialSize, T initialValue, T defaultValue) {
      super(initialSize, getSupplier(initialValue), getSupplier(defaultValue));
    }

    public vector(T[] array, int length, T defaultValue) {
      super(array, length, getSupplier(defaultValue));
    }

    public vector(T[] array, T defaultValue) {
      super(array, array.length, getSupplier(defaultValue));
    }

    public vector(type$iterator<?, T> iter, int length, T defaultValue) {
      super(iter, length, getSupplier(defaultValue));
    }

    public vector(type$iterator<?, T> begin, type$iterator<?, T> end, T defaultValue) {
      super(begin, end, getSupplier(defaultValue));
    }

    public <F, I extends type$iterator<I, F>> vector(I begin, I end, T defaultValue, Converter<F, T> converter) {
      this(new convert_iterator<F,T,I>(begin, converter), new convert_iterator<F,T,I>(end, converter), getSupplier(defaultValue));
    }

    public <F, I extends type$iterator<I, F>> vector(I begin, I end, Supplier<T> defaultValue, Converter<F, T> converter) {
      this(new convert_iterator<F,T,I>(begin, converter), new convert_iterator<F,T,I>(end, converter), defaultValue);
    }

    public vector(Supplier<T> defaultValue) {
      super(defaultValue);
    }

    public vector(int initialSize, Supplier<T> defaultValue) {
      super(initialSize, defaultValue);
    }

    public vector(T[] array, int length, Supplier<T> defaultValue) {
      super(array, length, defaultValue);
    }

    public vector(type$iterator<?, T> iter, int length, Supplier<T> defaultValue) {
      super(iter, length, defaultValue);
    }

    public vector(type$iterator<?, T> begin, type$iterator<?, T> end, Supplier<T> defaultValue) {
      super(begin, end, defaultValue);
    }

    public vector(vector<T> other) {
      super(other);
    }
    
    public vector(JD$Move _dparam, vector<T> other) {
      super(_dparam, other);
    }

    public vector<T> $assign(T[] a) {
      array = a;
      end = a.length;
      return this;
    }

    public type$ptr<T> data$Const() {
      return data();
    }
  }

  public final static class vectorUChar extends StdVectorUChar {

    public static final /*uchar*/byte DEFAULT = 0;

    public vectorUChar() {
      super(DEFAULT);
    }

    public vectorUChar(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorUChar(/*uint*/int initialSize, /*uchar*/byte initialValue, /*uchar*/byte defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorUChar(/*uint*/int initialSize, /*uchar*/byte defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorUChar(/*uchar*/byte[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorUChar(uchar$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorUChar(uchar$iterator<?> begin, uchar$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorUChar(uchar$iterator<?> begin, uchar$iterator<?> end, /*uchar*/byte defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorUChar(vectorUChar other) {
      super(other);
    }

    public vectorUChar(JD$Move _dparam, vectorUChar other) {
      super(_dparam, other);
    }
    
    public void insert$T(iterator I, char$iterator<?> begin, char$iterator<?> end) {
      throw new UnsupportedOperationException("EmptyBody: cast char to uchar iterators");
    }
  }

  public final static class vectorChar extends StdVectorChar {

    public static final byte DEFAULT = 0;

    public vectorChar() {
      super(DEFAULT);
    }

    public vectorChar(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorChar(/*uint*/int initialSize, byte initialValue, byte defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorChar(/*uint*/int initialSize, byte defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorChar(byte[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorChar(char$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorChar(char$iterator<?> begin, char$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorChar(char$iterator<?> begin, char$iterator<?> end, byte defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorChar(vectorChar other) {
      super(other);
    }
    
    public vectorChar(JD$Move _dparam, vectorChar other) {
      super(_dparam, other);
    }
    
    public byte[] $array() {
      return array;
    }
  }

  public final static class vectorUShort extends StdVectorUShort {

    public static final char DEFAULT = 0;

    public vectorUShort() {
      super(DEFAULT);
    }

    public vectorUShort(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorUShort(/*uint*/int initialSize, char initialValue, char defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorUShort(/*uint*/int initialSize, char defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorUShort(char[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorUShort(ushort$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorUShort(ushort$iterator<?> begin, ushort$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorUShort(ushort$iterator<?> begin, ushort$iterator<?> end, char defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorUShort(vectorUShort other) {
      super(other);
    }
    
    public vectorUShort(JD$Move _dparam, vectorUShort other) {
      super(_dparam, other);
    }    
  }

  public final static class vectorShort extends StdVectorShort {

    public static final short DEFAULT = 0;

    public vectorShort() {
      super(DEFAULT);
    }

    public vectorShort(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorShort(/*uint*/int initialSize, short initialValue, short defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorShort(/*uint*/int initialSize, short defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorShort(short[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorShort(short$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorShort(short$iterator<?> begin, short$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorShort(short$iterator<?> begin, short$iterator<?> end, short defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorShort(vectorShort other) {
      super(other);
    }
    
    public vectorShort(JD$Move _dparam, vectorShort other) {
      super(_dparam, other);
    }    
  }

  // vector<unsigned int>
  public final static class vectorUInt extends StdVectorUInt {

    public static final /*uint*/int DEFAULT = 0;

    public vectorUInt() {
      super(DEFAULT);
    }

    public vectorUInt(/*uint*/int initialSize, /*uint*/int initialValue, /*uint*/int defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorUInt(/*uint*/int initialSize, /*uint*/int defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorUInt(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorUInt(/*uint*/int[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorUInt(uint$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorUInt(uint$iterator<?> begin, uint$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorUInt(uint$iterator<?> begin, uint$iterator<?> end, /*uint*/int defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorUInt(vectorUInt other) {
      super(other);
    }
    
    public vectorUInt(JD$Move _dparam, vectorUInt other) {
      super(_dparam, other);
    }
    
    public void assign$T(ulong$iterator<?> __first, ulong$iterator<?> __last) {
      clear();
      append(__first, __last);
    }  
    
    public void append(ulong$iterator<?> in_start, ulong$iterator<?> in_end) {
      assert checkAlive();
      int NumInputs = std.distance(in_start, in_end);
      if (NumInputs == 0) {
        return;
      }
      // Grow allocated space if needed.
      if (NumInputs > (this.capacity() - this.size()))
        this.grow(this.size()+NumInputs);

      ulong$iterator<?> iter = (ulong$iterator<?>) Native.$Clone(in_start);
      while (!iter.$eq(in_end)) {
        ++end;
        $set(end-1, (int)iter.$star());
        iter.$preInc();
      }
    }
  }
  
  // vector<unsigned long int>
  public final static class vectorULong extends StdVectorULong {

    public static final /*ulong*/long DEFAULT = 0L;

    public vectorULong() {
      super(DEFAULT);
    }

    public vectorULong(/*uint*/int initialSize, /*ulong*/long initialValue, /*ulong*/long defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorULong(/*uint*/int initialSize, /*ulong*/long defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorULong(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorULong(/*ulong*/long[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorULong(ulong$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorULong(ulong$iterator<?> begin, ulong$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorULong(ulong$iterator<?> begin, ulong$iterator<?> end, /*ulong*/long defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorULong(vectorULong other) {
      super(other);
    }

    public vectorULong(JD$Move _dparam, vectorULong other) {
      super(_dparam, other);
    }    
  }

  // vector<long>
  public final static class vectorLong extends StdVectorLong {

    public static final /*long*/long DEFAULT = 0L;

    public vectorLong() {
      super(DEFAULT);
    }

    public vectorLong(/*uint*/int initialSize, /*long*/long initialValue, /*long*/long defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorLong(/*uint*/int initialSize, /*long*/long defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorLong(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorLong(/*long*/long[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorLong(long$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorLong(long$iterator<?> begin, long$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorLong(long$iterator<?> begin, long$iterator<?> end, /*ulong*/long defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorLong(vectorLong other) {
      super(other);
    }

    public vectorLong(JD$Move _dparam, vectorLong other) {
      super(_dparam, other);
    }    
  }

  // vector<int>
  public final static class vectorInt extends StdVectorInt {

    public static final int DEFAULT = 0;

    public vectorInt() {
      super(DEFAULT);
    }

    public vectorInt(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorInt(/*uint*/int initialSize, int initialValue, int defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorInt(/*uint*/int initialSize, int defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorInt(int[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorInt(int$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorInt(int$iterator<?> begin, int$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorInt(int$iterator<?> begin, int$iterator<?> end, int defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorInt(vectorInt other) {
      super(other);
    }

    public vectorInt(JD$Move _dparam, vectorInt other) {
      super(_dparam, other);
    }    
  }

  // vector<float>
  public final static class vectorFloat extends StdVectorFloat {

    public static final float DEFAULT = 0;

    public vectorFloat() {
      super(DEFAULT);
    }

    public vectorFloat(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorFloat(/*uint*/int initialSize, float initialValue, float defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorFloat(/*uint*/int initialSize, float defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorFloat(float[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorFloat(float$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorFloat(float$iterator<?> begin, float$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorFloat(float$iterator<?> begin, float$iterator<?> end, float defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorFloat(vectorFloat other) {
      super(other);
    }

    public vectorFloat(JD$Move _dparam, vectorFloat other) {
      super(_dparam, other);
    }    
  }

  // vector<double>
  public final static class vectorDouble extends StdVectorDouble {

    public static final double DEFAULT = 0;

    public vectorDouble() {
      super(DEFAULT);
    }

    public vectorDouble(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorDouble(/*uint*/int initialSize, double initialValue, double defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorDouble(/*uint*/int initialSize, double defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorDouble(double[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorDouble(double$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorDouble(double$iterator<?> begin, double$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorDouble(double$iterator<?> begin, double$iterator<?> end, double defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorDouble(vectorDouble other) {
      super(other);
    }

    public vectorDouble(JD$Move _dparam, vectorDouble other) {
      super(_dparam, other);
    }    
  }

  // vector<bool>
  public final static class vectorBool extends StdVectorBool {

    public static final boolean DEFAULT = false;

    public vectorBool() {
      super(DEFAULT);
    }

    public vectorBool(/*uint*/int initialSize) {
      super(initialSize, DEFAULT);
    }

    public vectorBool(/*uint*/int initialSize, boolean initialValue, boolean defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorBool(/*uint*/int initialSize, boolean defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorBool(boolean[] array, /*uint*/int length) {
      super(array, length, DEFAULT);
    }

    public vectorBool(bool$iterator<?> iter, /*uint*/int length) {
      super(iter, length, DEFAULT);
    }

    public vectorBool(bool$iterator<?> begin, bool$iterator<?> end) {
      super(begin, end, DEFAULT);
    }

    public vectorBool(bool$iterator<?> begin, bool$iterator<?> end, boolean defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorBool(vectorBool other) {
      super(other);
    }

    public vectorBool(JD$Move _dparam, vectorBool other) {
      super(_dparam, other);
    }    
  }

  public static final class vectorString extends StdVectorString {

    public vectorString() {
      super(std.string.EMPTY);
    }

    public vectorString(string defaultValue) {
      super(defaultValue);
    }

    public vectorString(/*uint*/int initialSize, string initialValue, string defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorString(/*uint*/int initialSize, string defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorString(string[] array, string defaultValue) {
      super(array, array.length, defaultValue);
    }

    public vectorString(string[] array, /*uint*/int length, string defaultValue) {
      super(array, length, defaultValue);
    }

    public vectorString(type$iterator<?, string> iter, /*uint*/int length, string defaultValue) {
      super(iter, length, defaultValue);
    }

    public vectorString(type$iterator<?, char$ptr> begin, type$iterator<?, char$ptr> end, string defaultValue) {
      super(new CharsToStringsIteratorAdapter(begin), new CharsToStringsIteratorAdapter(end), defaultValue);
    }

    public vectorString(type$ptr<std.string> begin, type$ptr<std.string> end, string defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorString(vectorString other) {
      super(other);
    }

    public vectorString(JD$Move _dparam, vectorString other) {
      super(_dparam, other);
    }

    public void push_back(CharSequence val) {
      push_back(new std.string(val));
    }

    public void emplace_back(char$ptr val) {
      push_back(new std.string(val));
    }

    public void push_back(char$ptr val) {
      push_back(new std.string(val));
    }
    
    public iterator insertChar$ptrs(iterator I, type$iterator<?, char$ptr> From, type$iterator<?, char$ptr> To) {
      std.string strings[] = new std.string[std.distance(From, To)];
      int index = 0;
      for (type$iterator<?, char$ptr> iter = $tryClone(From); iter.$noteq(To); iter.$preInc()) {
        strings[index] = new std.string(iter.$star());
        ++index;
      }
      return insert(I, create_type$ptr(strings), create_type$ptr(strings, strings.length));
    }
    
    @Override public /*size_t*/int $sizeof() {
      int oneElemSize = NativeType.sizeof(defaultValue);; 
      for (std.string elem : array) {
        if (elem != defaultValue) {
          oneElemSize = NativeType.sizeof(elem);
          break;
        }
      }
      return capacity() * oneElemSize;
    }    
  }

  public static final class vectorCharPtr extends StdVectorCharPtr {

    public vectorCharPtr() {
      super($(""));
    }

    public vectorCharPtr(char$ptr defaultValue) {
      super(defaultValue);
    }

    public vectorCharPtr(/*uint*/int initialSize, char$ptr initialValue, char$ptr defaultValue) {
      super(initialSize, initialValue, defaultValue);
    }

    public vectorCharPtr(/*uint*/int initialSize, char$ptr defaultValue) {
      super(initialSize, defaultValue);
    }

    public vectorCharPtr(char$ptr[] array, /*uint*/int length, char$ptr defaultValue) {
      super(array, length, defaultValue);
    }

    public vectorCharPtr(type$iterator<?, char$ptr> iter, /*uint*/int length, char$ptr defaultValue) {
      super(iter, length, defaultValue);
    }

    public vectorCharPtr(type$iterator<?, char$ptr> begin, type$iterator<?, char$ptr> end, char$ptr defaultValue) {
      super(begin, end, defaultValue);
    }

    public vectorCharPtr(vectorCharPtr other) {
      super(other);
    }
    
    public vectorCharPtr(JD$Move _dparam, vectorCharPtr other) {
      super(_dparam, other);
    } 
    
    public void push_back(CharSequence val) {
      push_back(create_char$ptr(val));
    }

    public void push_back(std.string val) {
      push_back(val.c_str());
    }
      
  }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Maps">
  
  // Adapts binary_function to comparator
  /*package*/ static <T> Comparator<T> binary2Comparator(final std.binary_functionArgArg2Bool<T, T> fun) {
    return new Comparator<T>() {
      @Override
      public int compare(T o1, T o2) {
        if (fun.$call(o1, o2)) {
          return -1;
        }
        return fun.$call(o2, o1) ? 1 : 0;
      }
    };
  }
  
  public static final class multimapUIntType<ValueT> extends StdMultiMapUIntType<ValueT> {

    public multimapUIntType(ValueT defVal) {
      super(defVal);
    }

  }
  
  public static final class multimapULongType<ValueT> extends StdMultiMapULongType<ValueT> {

    public multimapULongType(ValueT defVal) {
      super(defVal);
    }

  }
  
  public static final class priority_queue<_Tp> {
    private PriorityQueue<_Tp> _delegate;

    public priority_queue(Comparator<_Tp> _comparator) {
      _delegate = new PriorityQueue<>(_comparator);
    }

    public void push_value_type(_Tp t) {
      _delegate.add(t);
    }

    public boolean empty() {
      return _delegate.isEmpty();
    }

    public _Tp top() {
      return _delegate.peek();
    }
    
    public void $destroy() {
    }

    public _Tp pop() {
      return _delegate.poll();
    }
  }

  public static final class queue<T> {
    private final std.deque<T> delegate;
    public queue(boolean isDataPointerLike) {
      delegate = new std.deque(isDataPointerLike);
    }
    
    public void push(T val) {
      delegate.push_back(val);
    }

    public void push_value_type(T val) {
      delegate.push_back_T$C$R(val);
    }

    public void push_value_type$C(T val) {
      push_value_type(val);
    }

    public boolean empty() {
      return delegate.empty();
    }

    public T front() {
      return delegate.front();
    }
    
    public T back() {
      return delegate.back();
    }

    public T pop() {
      return delegate.pop_front();
    }
    
    public int size() {
      return delegate.size();
    }

    public void $destroy() {
      delegate.$destroy();
    }

    @Override
    public String toString() {
      return "" + delegate;
    }
  }
  
  public static final class queueDouble {
    private final std.vectorDouble delegate;
    public queueDouble() {
      delegate = new std.vectorDouble();
    }
    
    public void push(double val) {
      delegate.push_back(val);
    }

    public void push_value_type(double val) {
      delegate.push_back_T$C$R(val);
    }

    public void push_value_type$C(double val) {
      push_value_type(val);
    }

    public boolean empty() {
      return delegate.empty();
    }

    public double front() {
      return delegate.front();
    }
    
    public double back() {
      return delegate.back();
    }

    public double pop() {
      double res = delegate.front();
      delegate.erase(delegate.begin());
      return res;
    }
    
    public int size() {
      return delegate.size();
    }

    public void $destroy() {
      delegate.$destroy();
    }
  }
  
  // FIXME: need to introduce hash_map infra
  @Deprecated
  public static final class hash_map<KeyT, ValueT> extends StdMap<KeyT, ValueT> {
    
    public hash_map(ValueT defaultValue) {
      super(defaultValue);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for hash_map");
    }

    public hash_map(Comparator<KeyT> comparator, ValueT defaultValue) {
      super(comparator, defaultValue);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for hash_map");
    }
    
    public hash_map(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, ValueT defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for hash_map");
    }

    public hash_map(hash_map<KeyT, ValueT> other) {
      super((ValueT)null);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for hash_map");
    }
  }
  
  // FIXME: need to introduce unordered_map infra
  @Deprecated
  public static final class unordered_map<KeyT, ValueT> extends StdMap<KeyT, ValueT> {
    
    public unordered_map(ValueT defaultValue) {
      super(defaultValue);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for unordered_map");
    }

    public unordered_map(Comparator<KeyT> comparator, ValueT defaultValue) {
      super(comparator, defaultValue);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for unordered_map");
    }
    
    public unordered_map(std.binary_functionArgArg2Bool<KeyT, KeyT> comparator, ValueT defaultValue) {
      super(binary2Comparator(comparator), defaultValue);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for unordered_map");
    }

    public unordered_map(unordered_map<KeyT, ValueT> other) {
      super((ValueT)null);
      throw new UnsupportedOperationException("FIXME: generate template/aliases for unordered_map");
    }
  }
  
  public static class multiplies<T> implements BinaryOperation<T> {
    private final BinaryOperation<T> delegate;
    
    public multiplies(BinaryOperation<T> delegate) {
      this.delegate = delegate;
    }
    
    @Override
    public T $call(T O1, T O2) {
      return delegate.$call(O1, O2);
    }
  }
  
  public static class plus<T> implements BinaryOperation<T> {
    private final BinaryOperation<T> delegate;
    
    public plus(BinaryOperation<T> delegate) {
      this.delegate = delegate;
    }
    
    @Override
    public T $call(T O1, T O2) {
      return delegate.$call(O1, O2);
    }
  }
  
  public static class minus<T> implements BinaryOperation<T> {
    private final BinaryOperation<T> delegate;
    
    public minus(BinaryOperation<T> delegate) {
      this.delegate = delegate;
    }
    
    @Override
    public T $call(T O1, T O2) {
      return delegate.$call(O1, O2);
    }
  }
//</editor-fold>

  public static class binder1st<ArgumentType1, ArgumentType2> implements BoolPredicate<ArgumentType2> {
    private final binary_functionArgArg2Bool<ArgumentType1, ArgumentType2> fn;
    private final ArgumentType1/*&*/ value;
    public binder1st(binary_functionArgArg2Bool<ArgumentType1, ArgumentType2> fn, ArgumentType1/*&*/ value) {
      this.fn = fn;
      this.value = value;
    }
    public boolean $call(ArgumentType2 arg2) {
      return fn.$call(value, arg2);
    }
  }
  
  public static <ArgumentType1, ArgumentType2> binder1st<ArgumentType1, ArgumentType2> bind1st(
          binary_functionArgArg2Bool<ArgumentType1, ArgumentType2> fn,
          ArgumentType1/*&*/ value) {
    return new binder1st(fn, value);
  }
  
  public static class arrayUInt implements NativeCloneable<arrayUInt> {
    private final int size;
    private int[] array;
    public arrayUInt(int size, int[] a){
      this.size = size;
      this.array = a;
    }

    public arrayUInt(arrayUInt other) {
      this.size = other.size;
      this.array = new int[other.array.length];
      System.arraycopy(other.array, 0, this.array, 0, this.array.length);
    }

    public int $at(int index) {
      return array[index];
    }

    @Override
    public arrayUInt clone() {
      return new arrayUInt(this);
    }

    public int[] data(){
      return array;
    }
  }
  
  public static class piecewise_construct_t {}
  public static piecewise_construct_t piecewise_construct = new piecewise_construct_t();  
    
  /*package*/ static <T> Supplier<T> getSupplier(T val) {
    if (val != null) {
      assert NativeTrace.assertDefaultValue(val);
      return ()->$tryClone(val);
    }
    return null;
  }  
}
