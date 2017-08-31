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


package org.clank.java.stdimpl;

import org.clank.java.std;
import static org.clank.java.std.memset;
import static org.clank.java.std.strlen;
import org.clank.support.Casts;
import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.Native;
import org.clank.support.NativeCloneable;
import static org.clank.support.Native.$tryClone;
import org.clank.support.NativeMoveable;
import org.clank.support.NativePointer;
import static org.clank.support.NativePointer.*;
import org.clank.support.NativeSwappable;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.char$iterator;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.ulong$ptr;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public abstract class StdString implements Native.NativeComparable, Native.ComparableLowerGreater,
        Comparable<std.string>, NativeSwappable, NativeMoveable<std.string>,
        Native.OpCapable, NativeCloneable<std.string>, Native.assignable<std.string>, 
        Destructors.ClassWithDestructor {
  
  // public static /*size_type*/long npos = Long.MAX_VALUE; // ~((/*size_t*/int)(0))
  // PERF: use int
  public static /*size_type*/int npos = Integer.MAX_VALUE; // ~((/*size_t*/int)(0))
  
  public final static byte TERM = NativePointer.$$TERM;
  
  private static final byte[] TERM_ARRAY;
  static {
    TERM_ARRAY = new byte[] { TERM };
    assert NativeTrace.registerArrayWithImmutableContent(TERM_ARRAY, "StdString.TERM_ARRAY");
  }
  // must be after the above lines, because EMPTY will use TERM_ARRAY and TERM
  public static final std.string EMPTY = new std.string(NativePointer.$EMPTY, 0, std.strlen(NativePointer.$EMPTY), true);
  protected std.vectorChar array;
  
  private final boolean _const;

  protected StdString() {
    // PERF: init directly completely initialized, but need careful check
    // that we don't have writes into TERM_ARRAY
    array = new std.vectorChar(TERM_ARRAY, 1);
    this._const = false;
    if (false) _postModUpdate();
  }

  protected StdString(byte ar[]) {
    array = new std.vectorChar(ar, strlen(ar));
    this._const = false;
    _postModUpdate();
  }
  
  protected StdString(char$iterator<?> data, /*size_t*/int length) {
    array = new std.vectorChar(data, length);
    this._const = false;
    _postModUpdate();
  }

  /**
   * @brief Construct string as multiple characters.
   * @param n Number of characters.
   * @param c Character to use.
   * @param a Allocator to use (default is default allocator).
   */
  protected StdString(/*size_t*/int __n, char __c) {
    this.array = new std.vectorChar(__n, (byte) __c);
    this._const = false;
    _postModUpdate();
  }
  
  protected StdString(/*size_t*/int __n, byte __c) {
    this.array = new std.vectorChar(__n, __c);
    this._const = false;
    _postModUpdate();
  }

  protected StdString(CharSequence value) {
    this.array = new std.vectorChar();
    this.array.reserve(value.length() + 1/*TERM*/);
    for (int i = 0; i < value.length(); i++) {
      this.array.append(1, (byte) value.charAt(i));
    }
    this._const = false;
    _postModUpdate();
  }

  protected StdString(std.string other) {
    this.array = $tryClone(other.array);
    this._const = false;
  }
  
  protected StdString(JD$Move _dparam, std.string other) {
    std.vectorChar tmp = this.array;
    this.array = other.array;
    other.array = tmp;
    this._const = false;
  }

  protected StdString(char$ptr value) {
    this(value, strlen(value));
  }

  protected StdString(char$ptr value, /*size_t*/int length) {
    this(value, 0, length);
  }

  protected StdString(char$iterator<?> begin, char$iterator<?> end) {
    this(begin, ((char$iterator) end).$sub((char$iterator) begin));
  }
  
  protected StdString(char$ptr from, /*size_t*/int StartIdx, /*size_t*/int length) {
    this(from, StartIdx, length, false);
  }

  protected StdString(char$ptr from, /*size_t*/int StartIdx, /*size_t*/int length, boolean _const) {    
    final byte[] ar;
    if (length == 0) {
      assert TERM_ARRAY != null : "TERM_ARRAY is not yet initialized?";
      ar = TERM_ARRAY;
    } else {
      ar = new$char(length + 1);
      for (int i = 0; i < length;) {
        ar[i++] = from.$at(StartIdx++);
      }
      ar[length] = TERM;
    }
    this.array = new std.vectorChar(ar, length+1);
    this._const = _const;
    if (false) _postModUpdate();
  }  

  protected StdString(byte[] from, /*size_t*/int StartIdx, /*size_t*/int length, boolean _const) {    
    final byte[] ar;
    if (length == 0) {
      assert TERM_ARRAY != null : "TERM_ARRAY is not yet initialized?";
      ar = TERM_ARRAY;
    } else {
      ar = new$char(length + 1);
      System.arraycopy(from, StartIdx, ar, 0, length);
      ar[length] = TERM;
    }
    this.array = new std.vectorChar(ar, length+1);
    this._const = _const;
    if (false) _postModUpdate();
  }  
  
  public std.string assign(std.string other) {
    assert !_isConst() : "This string cannot be modified!";
    this.array.$assign(other.array);
    return (std.string) this;
  }
  public std.string $assign(std.string other) {
    return assign(other);
  }

  public std.string $assign(CharSequence other) {
    assert !_isConst() : "This string cannot be modified!";
    $assign(new std.string(other));
    return (std.string) this;
  }

  public std.string $assign(char$ptr value) {
    assert !_isConst() : "This string cannot be modified!";
    $assign(new std.string(value));
    return (std.string) this;
  }

  public final std.string $assign_T$C$P(char$ptr value) {
    return $assign(value);
  }
   
  public final std.string $assign_T$C$P(CharSequence value) {
    return $assign(value);
  }

  public final std.string assign$T(ulong$ptr begin, ulong$ptr end) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  @Override public void swap(NativeSwappable RHS) {
    swap((std.string)RHS);
  }

  public void swap(std.string str) {
    assert this != str;
    assert !_const;
    assert !((StdString)str)._const;
    assert this.array != str.array;
    std.vectorChar other = this.array;
    this.array = str.array;
    str.array = other;
  }  
  
  /**
   * returns content as char$ptr.
   * if CharSequence is needed, use toJavaString
   * @return 
   */
  public char$ptr c_str() {
    return array.data();
  }

  public char$ptr data() {
    return array.data();
  }

  public char$ptr begin() {
    return array.data();
  }

  public char$ptr begin$Const() {
    return array.data();
  }

  public char$ptr end() {
    return begin().$add(length());
  }

  public char$ptr end$Const() {
    return begin().$add(length());
  }
  
  /**
   *  Returns a read/write reverse iterator that points to the last
   *  character in the %string.  Iteration is done in reverse element
   *  order.  Unshares the string.
   */
  public std.reverse_iteratorChar rbegin() { 
    return new std.reverse_iteratorChar(this.end()); 
  }

  /**
   *  Returns a read-only (constant) reverse iterator that points
   *  to the last character in the %string.  Iteration is done in
   *  reverse element order.
   */
  public std.reverse_iteratorChar rbegin$Const() { 
    return new std.reverse_iteratorChar(this.end()); 
  }

  /**
   *  Returns a read/write reverse iterator that points to one before the
   *  first character in the %string.  Iteration is done in reverse
   *  element order.  Unshares the string.
   */
  public std.reverse_iteratorChar rend() { 
    return new std.reverse_iteratorChar(this.begin()); 
  }
  
  /**
   *  Returns a read-only (constant) reverse iterator that points
   *  to one before the first character in the %string.  Iteration
   *  is done in reverse element order.
   */
  public std.reverse_iteratorChar rend$Const() { 
    return new std.reverse_iteratorChar(this.begin()); 
  }

  @Override
  public void $destroy() {
    // do nothing
  }

  public void reserve(/*size_t*/int size) {
    array.reserve(size+1/*TERM*/);
    _postModUpdate();
  }
  public void resize(/*size_t*/int size) {
    resize(size, TERM);
  }
  
  public void resize(/*size_t*/int size, char defaultValue) {
    resize(size, $(defaultValue));
  }

  public void resize(/*size_t*/int size, byte defaultValue) {
    assert array.size() > 0;
    // move one step backward trailing '\0'
    // otherwize defaultValue would be after '\0' and do not replace it
    array.pop_back();
    array.resize(size+1/*TERM*/, defaultValue);
    array.$set(size, TERM);
    assert size() == size;
  }  

  public int size() {
    // size is till '\0'
    return length();
  }
  
  ///  Returns the size() of the largest possible %string.
  public /*size_t*/int max_size() { 
    return Integer.MAX_VALUE;
  }

  public int length() {
    return array.size() - 1/*TERM*/;
  }

  public /*size_t*/int capacity() {
    return array.capacity() - 1/*TERM*/;
  }
  
  public boolean empty() {
    assert length() >= 0;
    return length() == 0;
  }
  
  /**
   *  @brief  Set value to multiple characters.
   *  @param __n  Length of the resulting string.
   *  @param __c  The character to use.
   *  @return  Reference to this string.
   *
   *  This function sets the value of this string to @a __n copies of
   *  character @a __c.
   */
  public std.string assign(int __n, byte __c) {
    assert !_isConst() : "This string cannot be modified!";
    return _M_replace_aux(0, this.size(), __n, __c); 
  } 

  public std.string assign(char$ptr begin, char$ptr end) {
    assert !_isConst() : "This string cannot be modified!";
    $assign(new std.string(begin, end));
    return (std.string) this;
  }
  
  /**
   *  @brief  Set value to a C substring.
   *  @param __s  The C string to use.
   *  @param __n  Number of characters to use.
   *  @return  Reference to this string.
   *
   *  This function sets the value of this string to the first @a __n
   *  characters of @a __s.  If @a __n is is larger than the number of
   *  available characters in @a __s, the remainder of @a __s is used.
   */
  public std.string assign(char$ptr __s, int __n) {
    assert !_isConst() : "This string cannot be modified!";
    $assign(new std.string(__s, __s.$add(__n)));
    return (std.string) this;
  }

  /**
   *  @brief  Set value to contents of a C string.
   *  @param __s  The C string to use.
   *  @return  Reference to this string.
   *
   *  This function sets the value of this string to the value of @a __s.
   *  The data is copied, so there is no dependence on @a __s once the
   *  function returns.
   */
  public std.string assign(char$ptr __s) {
    assert !_isConst() : "This string cannot be modified!";
    $assign(new std.string(__s));
    return (std.string) this;
  }

  public std.string assign$T(char$iterator begin, char$iterator end) {
    assert !_isConst() : "This string cannot be modified!";
    $assign(new std.string(begin, end));
    return (std.string) this;
  }        
  
  public char$ptr erase(char$ptr __position) {
    assert !_isConst() : "This string cannot be modified!";
    return erase(convertPtrToIter(__position)).star$ref().deref$ptr();
  }    
          
  public char$ptr erase(char$ptr __first, char$ptr __last) {
    assert !_isConst() : "This string cannot be modified!";
    return erase(convertPtrToIter(__first), convertPtrToIter(__last)).star$ref().deref$ptr();
  }

  public std.string erase() {
    assert !_isConst() : "This string cannot be modified!";
    return erase(0, npos);
  }
  public std.string erase(/*size_type*/int __pos/* = 0*/) {
    assert !_isConst() : "This string cannot be modified!";
    return erase(__pos, npos);
  }
  public std.string erase(/*size_type*/int __pos/* = 0*/, /*size_type*/int __n/* = npos*/) {
    assert !_isConst() : "This string cannot be modified!";
    std.vectorChar.iterator first = array.begin().$add(__pos);
    std.vectorChar.iterator last = (__n != npos ? first.$add(__n) : array.end());
    erase(first, last);
    return (std.string) this;
  }
    
  public char$ptr insert(char$ptr __p, char __c) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr result = array.insert(convertPtrToIter(__p), (byte) __c).star$ref().deref$ptr();
    _postModUpdate();
    return result;
  }    
  
  public char$ptr insert(char$ptr __p, char$iterator<?> __k1, char$iterator<?> __k2) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr result = array.insert(convertPtrToIter(__p), __k1, __k2).star$ref().deref$ptr();
    _postModUpdate();
    return result;
  }        
  
  public std.string append(char$iterator<?> __first, char$iterator<?> __last) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr _M_iend;
    return replace(_M_iend = _M_iend(), _M_iend, __first, 0, ((char$iterator)__last).$sub(__first));
  }
  
  public std.string append(char$iterator<?> __first, int Size) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr _M_iend;
    return Size == 0 ? (std.string)this : replace(_M_iend = _M_iend(), _M_iend, __first, 0, Size);
  }    

  public std.string append(char$ptr __first, int __firstStartIdx, int Size) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr _M_iend;
    return Size == 0 ? (std.string)this : replace(_M_iend = _M_iend(), _M_iend, __first, __firstStartIdx, Size);
  }    

  public std.string append(byte[] __first, int __firstStartIdx, int Size) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr _M_iend;
    return Size == 0 ? (std.string)this : replace(_M_iend = _M_iend(), _M_iend, __first, __firstStartIdx, Size);
  }    

  public std.string append(char$ptr __extra) {
    assert !_isConst() : "This string cannot be modified!";
    char$ptr _M_iend;
    return replace(_M_iend = _M_iend(), _M_iend, __extra, 0, strlen(__extra));
  }    
  
  public void push_back(byte c) {
    assert !_isConst() : "This string cannot be modified!";
    array.insert(array.begin().$add(length()), (byte) c);
    _postModUpdate();
  }    
    
  public void clear() {
    assert !_isConst() : "This string cannot be modified!";
    array = new std.vectorChar();
    _postModUpdate();
  }

  public std.string $addassign(byte c) {
    assert !_isConst() : "This string cannot be modified!";
    push_back(c);
    return (std.string) this;
  }

  public final std.string $addassign_T(byte c) {
    return $addassign(c);
  }

  public std.string $addassign(char c) {
    assert !_isConst() : "This string cannot be modified!";
    return $addassign($(c));
  }

  public std.string $addassign(std.string extra) {
    assert !_isConst() : "This string cannot be modified!";
    array.insert(array.begin().$add(length()), extra.begin(), extra.end());
    _postModUpdate();
    return (std.string) this;
  }
  
  public std.string $addassign(char$ptr extra) {
    assert !_isConst() : "This string cannot be modified!";
    array.insert(array.begin().$add(length()), extra, extra.$add(strlen(extra)));
    _postModUpdate();
    return (std.string) this;
  }
  
  public final std.string $addassign_T$C$P(CharSequence extra) {
    assert !_isConst() : "This string cannot be modified!";
    return $addassign(create_char$ptr(extra));
  }    
  
  public final std.string $addassign_T$C$P(char$ptr extra) {
    assert !_isConst() : "This string cannot be modified!";
    return $addassign(extra);
  }    
  
  public std.string $addassign(CharSequence extra) {
    assert !_isConst() : "This string cannot be modified!";
    return $addassign(create_char$ptr(extra));
  }    
  
  public byte back() {
    return array.$at(size()-1);
  }
  
  public byte $at(int val) {
    return array.$at(val);
  }
  
  public byte $at$Const(int val) {
    return array.$at(val);
  }
  
  public byte $set(int idx, byte val) {
    assert !_isConst() : "This string cannot be modified!";
    return array.$set(idx, val);
  }
  
  public std.string substr(int idx) {
    return new std.string(begin().$add(idx), end());
  }
  
  /**
   *  @brief  Get a substring.
   *  @param __pos  Index of first character (default 0).
   *  @param __n  Number of characters in substring (default remainder).
   *  @return  The new string.
   *  @throw  std::out_of_range  If __pos > size().
   *
   *  Construct and return a new string using the @a __n
   *  characters starting at @a __pos.  If the string is too
   *  short, use the remainder of the characters.  If @a __pos is
   *  beyond the end of the string, out_of_range is thrown.
  */
  public std.string substr(int __pos, int __n) {
    if (__n == npos) {
      return substr(__pos);
    }
    return new std.string(begin().$add(__pos), begin().$add(__pos + __n));
  }    
  
  /**
   *  @brief  Replace characters with value of a C substring.
   *  @param __pos  Index of first character to replace.
   *  @param __n1  Number of characters to be replaced.
   *  @param __s  C string to insert.
   *  @param __n2  Number of characters from @a s to use.
   *  @return  Reference to this string.
   *  @throw  std::out_of_range  If @a pos1 > size().
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__pos,__pos + __n1)
   *  from this string.  In place, the first @a __n2 characters of
   *  @a __s are inserted, or all of @a __s if @a __n2 is too large.  If
   *  @a __pos is beyond end of string, out_of_range is thrown.  If
   *  the length of result exceeds max_size(), length_error is
   *  thrown.  The value of the string doesn't change if an error
   *  is thrown.
  */    
  public std.string replace(int __pos, int __n1, char$ptr __s, int __n2) {
    assert !_isConst() : "This string cannot be modified!";
    boolean __left;
    char$ptr _M_data = _M_data();
    __n1 = (__n1 == npos) ? (size()-__pos) : __n1;
    if (_M_disjunct(__s)) {
      return _M_replace_safe(__pos, __n1, __s, __n2);
    } else if ((__left = (__s.$index() + __n2 <= _M_data.$index() + __pos)) || (_M_data.$index() + __pos + __n1 <= __s.$index())) {
      // Work in-place: non-overlapping case.
      int __off = __s.$sub(_M_data);
      __off = __left ? __off : (__off + __n2 - __n1);
      _M_mutate(__pos, __n1, __n2);
      _M_data = _M_data();
      _M_copy(_M_data, __pos, _M_data, __off,  __n2);
      _postModUpdate();
      return (std.string) this;
    } else {
      // Todo: overlapping case.
      
      std.string __tmp = new std.string(__s, __n2);
      return _M_replace_safe(__pos, __n1, __tmp._M_data(), __n2);
    }
  }  
  
  public std.string replace(int __pos, int __n1, CharSequence __s, int __n2) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__pos, __n1, create_char$ptr(__s), __n2);
  }
  
  /**
   *  @brief  Replace characters with value of a C string.
   *  @param __pos  Index of first character to replace.
   *  @param __n1  Number of characters to be replaced.
   *  @param __s  C string to insert.
   *  @return  Reference to this string.
   *  @throw  std::out_of_range  If @a pos > size().
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__pos,__pos + __n1)
   *  from this string.  In place, the characters of @a __s are
   *  inserted.  If @a __pos is beyond end of string, out_of_range
   *  is thrown.  If the length of result exceeds max_size(),
   *  length_error is thrown.  The value of the string doesn't
   *  change if an error is thrown.
  */
  public std.string replace(int __pos, int __n1, char$ptr __s) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__pos, __n1, __s, strlen(__s));
  }
  
  /**
   *  @brief  Replace characters with value from another string.
   *  @param __pos  Index of first character to replace.
   *  @param __n  Number of characters to be replaced.
   *  @param __str  String to insert.
   *  @return  Reference to this string.
   *  @throw  std::out_of_range  If @a pos is beyond the end of this
   *  string.
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__pos,__pos+__n) from
   *  this string.  In place, the value of @a __str is inserted.
   *  If @a __pos is beyond end of string, out_of_range is thrown.
   *  If the length of the result exceeds max_size(), length_error
   *  is thrown.  The value of the string doesn't change if an
   *  error is thrown.
  */
  public std.string replace(int __pos, int __n, std.string __str) { 
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__pos, __n, __str._M_data(), __str.size()); 
  }    
  
  public std.string replace(int __pos, int __n, CharSequence __str) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__pos, __n, create_char$ptr(__str));
  }
  
  /**
   *  @brief  Replace characters with value from another string.
   *  @param __pos1  Index of first character to replace.
   *  @param __n1  Number of characters to be replaced.
   *  @param __str  String to insert.
   *  @param __pos2  Index of first character of str to use.
   *  @param __n2  Number of characters from str to use.
   *  @return  Reference to this string.
   *  @throw  std::out_of_range  If @a __pos1 > size() or @a __pos2 >
   *  __str.size().
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__pos1,__pos1 + n) from this
   *  string.  In place, the value of @a __str is inserted.  If @a __pos is
   *  beyond end of string, out_of_range is thrown.  If the length of the
   *  result exceeds max_size(), length_error is thrown.  The value of the
   *  string doesn't change if an error is thrown.
  */
  public std.string replace(int __pos1, int __n1, std.string __str, int __pos2, int __n2) { 
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__pos1, __n1, 
        __str._M_data().$add(__str._M_check(__pos2, "basic_string::replace")), 
        __str._M_limit(__pos2, __n2)
    ); 
  }    
  
  /**
   *  @brief  Replace characters with multiple characters.
   *  @param __pos  Index of first character to replace.
   *  @param __n1  Number of characters to be replaced.
   *  @param __n2  Number of characters to insert.
   *  @param __c  Character to insert.
   *  @return  Reference to this string.
   *  @throw  std::out_of_range  If @a __pos > size().
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [pos,pos + n1) from this
   *  string.  In place, @a __n2 copies of @a __c are inserted.
   *  If @a __pos is beyond end of string, out_of_range is thrown.
   *  If the length of result exceeds max_size(), length_error is
   *  thrown.  The value of the string doesn't change if an error
   *  is thrown.
  */
  public std.string replace(int __pos, int __n1, int __n2, byte __c) { 
    assert !_isConst() : "This string cannot be modified!";
    return _M_replace_aux(_M_check(__pos, "basic_string::replace"),
	      _M_limit(__pos, __n1), __n2, __c); 
  }    
  
  public std.string replace(int __pos, int __n1, int __n2, char __c) { 
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__pos, __n1, __n2, (byte) __c);
  }
  
  /**
   *  @brief  Replace range of characters with string.
   *  @param __i1  Iterator referencing start of range to replace.
   *  @param __i2  Iterator referencing end of range to replace.
   *  @param __str  String value to insert.
   *  @return  Reference to this string.
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__i1,__i2).  In place,
   *  the value of @a __str is inserted.  If the length of result
   *  exceeds max_size(), length_error is thrown.  The value of
   *  the string doesn't change if an error is thrown.
  */
  public std.string replace(char$ptr __i1, char$ptr __i2, std.string __str) { 
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__i1, __i2, __str._M_data(), __str.size()); 
  }

  /**
   *  @brief  Replace range of characters with C substring.
   *  @param __i1  Iterator referencing start of range to replace.
   *  @param __i2  Iterator referencing end of range to replace.
   *  @param __s  C string value to insert.
   *  @param __n  Number of characters from s to insert.
   *  @return  Reference to this string.
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__i1,__i2).  In place,
   *  the first @a __n characters of @a __s are inserted.  If the
   *  length of result exceeds max_size(), length_error is thrown.
   *  The value of the string doesn't change if an error is
   *  thrown.
  */
  public std.string replace(char$ptr __i1, char$ptr __i2, char$ptr __s, int __n) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__i1.$sub(_M_ibegin()), __i2.$sub(__i1), __s, __n);
  }
  
  public std.string replace(char$ptr __i1, char$ptr __i2, CharSequence __s, int __n) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__i1.$sub(_M_ibegin()), __i2.$sub(__i1), create_char$ptr(__s), __n);
  }

  /**
   *  @brief  Replace range of characters with C string.
   *  @param __i1  Iterator referencing start of range to replace.
   *  @param __i2  Iterator referencing end of range to replace.
   *  @param __s  C string value to insert.
   *  @return  Reference to this string.
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__i1,__i2).  In place,
   *  the characters of @a __s are inserted.  If the length of
   *  result exceeds max_size(), length_error is thrown.  The
   *  value of the string doesn't change if an error is thrown.
  */
  public std.string replace(char$ptr __i1, char$ptr __i2, char$ptr __s) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__i1, __i2, __s, strlen(__s));
  }
  
  public std.string replace(char$ptr __i1, char$ptr __i2, CharSequence __s) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__i1, __i2, create_char$ptr(__s), __s.length());
  }

  /**
   *  @brief  Replace range of characters with multiple characters
   *  @param __i1  Iterator referencing start of range to replace.
   *  @param __i2  Iterator referencing end of range to replace.
   *  @param __n  Number of characters to insert.
   *  @param __c  Character to insert.
   *  @return  Reference to this string.
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__i1,__i2).  In place,
   *  @a __n copies of @a __c are inserted.  If the length of
   *  result exceeds max_size(), length_error is thrown.  The
   *  value of the string doesn't change if an error is thrown.
  */
  public std.string replace(char$ptr __i1, char$ptr __i2, int __n, byte __c) {
    assert !_isConst() : "This string cannot be modified!";
    return _M_replace_aux(__i1.$sub(_M_ibegin()), __i2.$sub(__i1), __n, __c);
  }    
  
  public std.string replace(char$ptr __i1, char$ptr __i2, int __n, char __c) {
    assert !_isConst() : "This string cannot be modified!";
    return this.replace(__i1, __i2, __n, (byte) __c);
  }
  
  /**
   *  @brief  Replace range of characters with range.
   *  @param __i1  Iterator referencing start of range to replace.
   *  @param __i2  Iterator referencing end of range to replace.
   *  @param __k1  Iterator referencing start of range to insert.
   *  @param __k2  Iterator referencing end of range to insert.
   *  @return  Reference to this string.
   *  @throw  std::length_error  If new length exceeds @c max_size().
   *
   *  Removes the characters in the range [__i1,__i2).  In place,
   *  characters in the range [__k1,__k2) are inserted.  If the
   *  length of result exceeds max_size(), length_error is thrown.
   *  The value of the string doesn't change if an error is
   *  thrown.
  */
  public std.string replace(char$ptr __i1, char$ptr __i2, char$iterator<?> __k1, char$iterator<?> __k2) {
    assert !_isConst() : "This string cannot be modified!";
    return replace(__i1, __i2, __k1, 0, ((char$iterator) __k2).$sub((char$iterator) __k1));
  }    
  public std.string replace(char$ptr __i1, char$ptr __i2, char$iterator<?> __k1, int __k1_Idx, int Size) {
    assert !_isConst() : "This string cannot be modified!";
    return _M_replace_dispatch(__i1, __i2, __k1, __k1_Idx, Size);
  }    
  public std.string replace(char$ptr __i1, char$ptr __i2, byte[] __k1, int __k1_Idx, int Size) {
    assert !_isConst() : "This string cannot be modified!";
    return _M_replace_dispatch(__i1, __i2, __k1, __k1_Idx, Size);
  }    
  
  /**
   *  @brief  Find position of a C substring.
   *  @param __s  C string to locate.
   *  @param __pos  Index of character to search from.
   *  @param __n  Number of characters from @a s to search for.
   *  @return  Index of start of first occurrence.
   *
   *  Starting from @a __pos, searches forward for the first @a
   *  __n characters in @a __s within this string.  If found,
   *  returns the index where it begins.  If not found, returns
   *  npos.
  */
  public int find(char$ptr __s, int __pos, int __n) {
    final int __size = this.size();
    final char$ptr __data = _M_data();

    if (__n == 0) {
      return __pos <= __size ? __pos : npos;
    }

    if (__n <= __size) {
      for (; __pos <= __size - __n; ++__pos)
        if (Native.$eq(__data.$at(__pos), __s.$at(0)) && 
            std.strncmp(__data.$add(__pos + 1), __s.$add(1), __n - 1) == 0) {
            return __pos;
        }
    }
    return npos;
  }
  
  public int find(CharSequence __s, int __pos, int __n) {
    return find(create_char$ptr(__s), __pos, __n);
  }

  /**
   *  @brief  Find position of a string.
   *  @param __str  String to locate.
   *  @return  Index of start of first occurrence.
   *
   *  Starting from @a __pos, searches forward for value of @a __str within
   *  this string.  If found, returns the index where it begins.  If not
   *  found, returns npos.
  */
  public int find(std.string __str) { 
    return this.find(__str, 0); 
  }  
  
  /**
   *  @brief  Find position of a string.
   *  @param __str  String to locate.
   *  @param __pos  Index of character to search from (default 0).
   *  @return  Index of start of first occurrence.
   *
   *  Starting from @a __pos, searches forward for value of @a __str within
   *  this string.  If found, returns the index where it begins.  If not
   *  found, returns npos.
  */  
  public int find(std.string __str, int __pos) { 
    return this.find(__str.data(), __pos, __str.size()); 
  }
  

  /**
   *  @brief  Find position of a C string.
   *  @param __s  C string to locate.
   *  @return  Index of start of first occurrence.
   *
   *  Starting from @a __pos, searches forward for the value of @a
   *  __s within this string.  If found, returns the index where
   *  it begins.  If not found, returns npos.
  */
  public int find(char$ptr __s) {
    return this.find(__s, 0);
  }  
  
  public int find_T$C$P_size_type$_CharT(String __s) {
    return find(__s);
  }  
  public final int find_T$C$P_rebind$_CharT(CharSequence __s) {
    return find(__s);
  }
  public int find(CharSequence __s) {
    return this.find(create_char$ptr(__s));
  }

  /**
   *  @brief  Find position of a C string.
   *  @param __s  C string to locate.
   *  @param __pos  Index of character to search from (default 0).
   *  @return  Index of start of first occurrence.
   *
   *  Starting from @a __pos, searches forward for the value of @a
   *  __s within this string.  If found, returns the index where
   *  it begins.  If not found, returns npos.
  */  
  public int find(char$ptr __s, int __pos) {
    return this.find(__s, __pos, strlen(__s));
  }
  
  public int find(CharSequence __s, int __pos) {
    return this.find(create_char$ptr(__s), __pos);
  }

  /**
   *  @brief  Find position of a character.
   *  @param __c  Character to locate.
   *  @return  Index of first occurrence.
   *
   *  Starting from @a __pos, searches forward for @a __c within
   *  this string.  If found, returns the index where it was
   *  found.  If not found, returns npos.
  */  
  public int find(byte __c) { 
    return this.find(__c, 0);
  }
  
  public int find(char __c) { 
    return this.find((byte) __c);
  }
  
  public int find_first_of(byte __c) {
    return find_first_of(__c, 0);
  }
  
  public int find_first_of(byte __c, int __pos /*= 0*/) {
    return this.find(__c, __pos);
  }

  public int find_first_of_T_$_CharT(byte __c, int __pos) {
    return this.find(__c, __pos);
  }
  
  /**
   *  @brief  Find position of a character of string.
   *  @param __str  String containing characters to locate.
   *  @param __pos  Index of character to search from (default 0).
   *  @return  Index of first occurrence.
   *
   *  Starting from @a __pos, searches forward for one of the
   *  characters of @a __str within this string.  If found,
   *  returns the index where it was found.  If not found, returns
   *  npos.
  */
  public int find_first_of(std.string __str) {
    return find_first_of(__str, 0);
  }
  public int find_first_of(std.string __str, int __pos /*= 0*/) {
    return find_first_of(__str.data(), __pos, __str.size());
  }
  
  /**
   *  @brief  Find position of a character of C substring.
   *  @param __s  String containing characters to locate.
   *  @param __pos  Index of character to search from.
   *  @param __n  Number of characters from s to search for.
   *  @return  Index of first occurrence.
   *
   *  Starting from @a __pos, searches forward for one of the
   *  first @a __n characters of @a __s within this string.  If
   *  found, returns the index where it was found.  If not found,
   *  returns npos.
  */
  public int find_first_of(char$ptr __s, int __pos, int __n) {
    // see strcspn
    int i;
    char$ptr string = data();
    for (i = __pos; Native.$bool(string) && (string.$at(i) != 0); i++) {
      int j;
      for (j = 0; j < __n; j++) {
        if (string.$at(i) == __s.$at(j)) {
          break;
        }
      }
      if (j != __n) {
        break;
      }
    }
    return (i < length()) ? i : npos;
  }

  /**
   *  @brief  Find position of a character of C string.
   *  @param __s  String containing characters to locate.
   *  @param __pos  Index of character to search from (default 0).
   *  @return  Index of first occurrence.
   *
   *  Starting from @a __pos, searches forward for one of the
   *  characters of @a __s within this string.  If found, returns
   *  the index where it was found.  If not found, returns npos.
  */
  public int find_first_of(char$ptr __s) {
    return this.find_first_of(__s, 0);
  }
  public int find_first_of(char$ptr __s, int __pos) {
    return this.find_first_of(__s, __pos, strlen(__s));
  }
  
  /**
   *  @brief  Find last position of a character of string.
   *  @param __str  String containing characters to locate.
   *  @param __pos  Index of character to search back from (default end).
   *  @return  Index of last occurrence.
   *
   *  Starting from @a __pos, searches backward for one of the
   *  characters of @a __str within this string.  If found,
   *  returns the index where it was found.  If not found, returns
   *  npos.
  */
  public int find_last_of(std.string/*&*/ __str) { 
    return this.find_last_of(__str, std.string.npos);
  }
  public int find_last_of(std.string/*&*/ __str, int __pos /*= npos*/) { 
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  /**
   *  @brief  Find last position of a character of C substring.
   *  @param __s  C string containing characters to locate.
   *  @param __pos  Index of character to search back from.
   *  @param __n  Number of characters from s to search for.
   *  @return  Index of last occurrence.
   *
   *  Starting from @a __pos, searches backward for one of the
   *  first @a __n characters of @a __s within this string.  If
   *  found, returns the index where it was found.  If not found,
   *  returns npos.
  */
  public int find_last_of(char$ptr __s, int __pos, int __n) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  /**
   *  @brief  Find last position of a character of C string.
   *  @param __s  C string containing characters to locate.
   *  @param __pos  Index of character to search back from (default end).
   *  @return  Index of last occurrence.
   *
   *  Starting from @a __pos, searches backward for one of the
   *  characters of @a __s within this string.  If found, returns
   *  the index where it was found.  If not found, returns npos.
  */
  public int find_last_of(char$ptr __s) {
    return this.find_last_of(__s, std.string.npos);
  }
  public int find_last_of(char$ptr __s, int __pos /*= npos*/) {
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  /**
   *  @brief  Find last position of a character.
   *  @param __c  Character to locate.
   *  @param __pos  Index of character to search back from (default end).
   *  @return  Index of last occurrence.
   *
   *  Starting from @a __pos, searches backward for @a __c within
   *  this string.  If found, returns the index where it was
   *  found.  If not found, returns npos.
   *
   *  Note: equivalent to rfind(__c, __pos).
  */
  public int find_last_of(byte __c) { 
    return this.find_last_of(__c, std.string.npos);
  }
  public int find_last_of(byte __c, int __pos /*= npos*/) { 
    throw new UnsupportedOperationException("Not implemented yet.");
  }

  /**
   *  @brief  Find position of a character.
   *  @param __c  Character to locate.
   *  @param __pos  Index of character to search from (default 0).
   *  @return  Index of first occurrence.
   *
   *  Starting from @a __pos, searches forward for @a __c within
   *  this string.  If found, returns the index where it was
   *  found.  If not found, returns npos.
  */    
  public int find(byte __c, int __pos) { 
    int __ret = npos;
    final int __size = this.size();
    if (__pos < __size) {
      char$ptr __data = _M_data();
      final int __n = __size - __pos;
      final char$ptr __from = __data.$add(__pos);
      final char$ptr __to = __data.$add(__pos + __n);
      char$ptr __p = std.find(__from, __to, __c);
      if (__p.$noteq(__to)) {
        __ret = __p.$sub(__data);
      }
    }
    return __ret;    
  }
  
  public int find(char __c, int __pos) { 
    return this.find((byte) __c, __pos);
  }
  
  /**
   *  @brief  Find last position of a string.
   *  @param __str  String to locate.
   *  @return  Index of start of last occurrence.
   *
   *  Starting from @a __pos, searches backward for value of @a
   *  __str within this string.  If found, returns the index where
   *  it begins.  If not found, returns npos.
  */
  public int rfind(std.string __str) {
    return this.rfind(__str, npos); 
  }  

  /**
   *  @brief  Find last position of a string.
   *  @param __str  String to locate.
   *  @param __pos  Index of character to search back from (default end).
   *  @return  Index of start of last occurrence.
   *
   *  Starting from @a __pos, searches backward for value of @a
   *  __str within this string.  If found, returns the index where
   *  it begins.  If not found, returns npos.
  */
  public int rfind(std.string __str, int __pos) {
    return this.rfind(__str.data(), __pos, __str.size()); 
  }

  /**
   *  @brief  Find last position of a C substring.
   *  @param __s  C string to locate.
   *  @param __pos  Index of character to search back from.
   *  @param __n  Number of characters from s to search for.
   *  @return  Index of start of last occurrence.
   *
   *  Starting from @a __pos, searches backward for the first @a
   *  __n characters in @a __s within this string.  If found,
   *  returns the index where it begins.  If not found, returns
   *  npos.
  */
  public int rfind(char$ptr __s, int __pos, int __n) {
    final int __size = this.size();
    if (__n <= __size) {
      __pos = std.min(__size - __n, __pos);
      char$ptr __data = _M_data();
      do
      {
        if (std.strncmp(__data.$add(__pos), __s, __n) == 0) {
          return __pos;
        }
      } while (__pos-- > 0);
    }
    return npos;    
  }
  
  public int rfind(CharSequence __s, int __pos, int __n) {
    return rfind(create_char$ptr(__s), __pos, __n);
  }
  
  /**
   *  @brief  Find last position of a C string.
   *  @param __s  C string to locate.
   *  @return  Index of start of  last occurrence.
   *
   *  Starting from @a __pos, searches backward for the value of
   *  @a __s within this string.  If found, returns the index
   *  where it begins.  If not found, returns npos.
  */
  public int rfind(char$ptr __s) {
    return this.rfind(__s, npos);
  }  
  
  public int rfind(CharSequence __s) {
    return this.rfind(create_char$ptr(__s));
  }    

  /**
   *  @brief  Find last position of a C string.
   *  @param __s  C string to locate.
   *  @param __pos  Index of character to start search at (default end).
   *  @return  Index of start of  last occurrence.
   *
   *  Starting from @a __pos, searches backward for the value of
   *  @a __s within this string.  If found, returns the index
   *  where it begins.  If not found, returns npos.
  */
  public int rfind(char$ptr __s, int __pos) {
    return this.rfind(__s, __pos, strlen(__s));
  }
  
  public int rfind(CharSequence __s, int __pos) {
    return this.rfind(create_char$ptr(__s), __pos);
  }
  
  /**
   *  @brief  Find last position of a character.
   *  @param __c  Character to locate.
   *  @return  Index of last occurrence.
   *
   *  Starting from @a __pos, searches backward for @a __c within
   *  this string.  If found, returns the index where it was
   *  found.  If not found, returns npos.
  */
  public int rfind(byte __c) {
    return this.rfind(__c, npos);
  }  
  
  public int rfind(char __c) {
    return this.rfind((byte) __c);
  }

  /**
   *  @brief  Find last position of a character.
   *  @param __c  Character to locate.
   *  @param __pos  Index of character to search back from (default end).
   *  @return  Index of last occurrence.
   *
   *  Starting from @a __pos, searches backward for @a __c within
   *  this string.  If found, returns the index where it was
   *  found.  If not found, returns npos.
  */
  public int rfind(byte __c, int __pos) {
    int __size = this.size();
    if (__size > 0) {
      if (--__size > __pos) {
        __size = __pos;
      }
      for (++__size; __size-- > 0; ) {
        if (Native.$eq(_M_data().$at(__size), __c)) {
          return __size;
        }
      }
    }
    return npos;    
  }
  
  public int rfind(char __c, int __pos) {
    return this.rfind((byte) __c, __pos);
  }
  
  /**
   *  @brief  Compare to a string.
   *  @param __str  String to compare against.
   *  @return  Integer < 0, 0, or > 0.
   *
   *  Returns an integer < 0 if this string is ordered before @a
   *  __str, 0 if their values are equivalent, or > 0 if this
   *  string is ordered after @a __str.  Determines the effective
   *  length rlen of the strings to compare as the smallest of
   *  size() and str.size().  The function then compares the two
   *  strings by calling traits::compare(data(), str.data(),rlen).
   *  If the result of the comparison is nonzero returns it,
   *  otherwise the shorter one is ordered first.
  */
  public int compare(std.string __str) {
    return compareTo(__str);
  }

  @Override
  public boolean $eq(Object __other) {
    if (!(__other instanceof std.string)) {
      return false;
    }      
    std.string other = (std.string) __other;
    if (length() == other.length()) {
      for (int i = 0; i < length(); i++) {
        if (array.$at(i) != other.array.$at(i)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }    

  @Override
  public boolean $noteq(Object other) {
    return !$eq(other);
  }

  @Override
  public int compareTo(std.string o) {
    if (this.$less(o)) {
      return -1;
    }
    if (o.$less(this)) {
      return 1;
    }    
    return 0;
  }
  
  @Override
  public boolean $less(Object __other) {
    StdString other = (StdString) __other;
    return std.lexicographical_compare(begin(), end(), other.begin(), other.end());
  }

  @Override
  public boolean $lesseq(Object obj) {
    return !((StdString) obj).$less(this);
  }

  @Override
  public boolean $greater(Object obj) {
    return ((StdString) obj).$less(this);
  }

  @Override
  public boolean $greatereq(Object obj) {
    return !this.$less((StdString) obj);
  }
    
  @Override
  public Boolean $op(Native.OpCapable.Op k, Object obj) {
    if (Native.OpCapable.Op.EQ == k) {
      if (obj instanceof StdString) {
        return $eq((StdString)obj);
      } else if (obj instanceof CharSequence) {
        return $eq(new std.string((CharSequence) obj));
      } else if (obj instanceof char$iterator<?>) {
        return $eq(new std.string((char$iterator<?>) obj, strlen((char$iterator<?>)obj)));
      }
      // std.string knowns nothing i.e. about StringRef which can be asked later by Native.$eq
      return null;
    }
    assert false : "can not check " + k + " for " + obj.getClass();
    return null;
  }
  
  public std.string $assignMove(std.string other) {
    assert !_isConst() : "This string cannot be modified!";
    this.array = other.array;
    other.array = null;
    return (std.string) this;
  }

  @Override
  public std.string clone() {
    return new std.string((std.string) this);
  }

  @Override
  public std.string move() {
    return new std.string(JD$Move.INSTANCE, (std.string) this);
  }

  @Override
  public String toString() {
    return "[string size="+this.length() + "+\'0\']\n" + toJavaString();
  }
  
  public String toJavaString() {
    return Casts.toJavaString(array.$array(), 0, length());
  }
  
  protected char$ptr _M_data() { return data(); }    
  
  // For the internal use we have functions similar to `begin'/`end'
  // but they do not call _M_leak.
  protected char$ptr _M_ibegin() { return data(); }

  protected char$ptr _M_iend() { return data().$add(size()); }    
  
  // NB: _M_limit doesn't check for a bad __pos value.
  protected int _M_limit(int __pos, int __off) {
    boolean __testoff =  __off < (this.size() - __pos);
    return __testoff ? __off : this.size() - __pos;
  }    
  
  // True if _Rep and source do not overlap.
  protected boolean _M_disjunct(char$ptr __s) {
    return !__s.isComparableTo(_M_data()) || __s.$less(data()) || (data().$add(this.size()).$less(__s));
  }
  
  protected std.string _M_replace_aux(int __pos1, int __n1, int __n2, byte __c) {
    assert _M_check_length(__n1, __n2, "basic_string::_M_replace_aux");
    _M_mutate(__pos1, __n1, __n2);
    if (__n2 > 0) {
      memset(_M_data().$add(__pos1), __c, __n2);
    }
    _postModUpdate();
    return (std.string) this;
  }    
  
  protected std.string _M_replace_safe(int __pos1, int __n1, char$ptr __s, int __n2)
  {
    _M_mutate(__pos1, __n1, __n2);
    if (__n2 > 0) {
      _M_copy(_M_data(), __pos1, __s, 0, __n2);
    }
    _postModUpdate();
    return (std.string) this;
  }    
  
  protected std.string _M_replace_dispatch(char$ptr __i1, char$ptr __i2, char$iterator<?> __k1, char$iterator<?> __k2) {
    return _M_replace_dispatch(__i1, __i2, __k1, 0, ((char$iterator) __k2).$sub((char$iterator) __k1));
  }
  protected std.string _M_replace_dispatch(char$ptr __i1, char$ptr __i2, char$iterator<?> __from, int __fromIdx, int Size) {
    std.string __s = Size == 0 ? EMPTY : new std.string(__from, __fromIdx, Size);
    assert Size == __s.size() : "" + Size + " vs. " + __s.size();
    int __n1 = __i2.$sub(__i1);
    assert _M_check_length(__n1, __s.size(), "basic_string::_M_replace_dispatch");
    return _M_replace_safe(__i1.$sub(_M_ibegin()), __n1, __s._M_data(), Size);
  }
  protected std.string _M_replace_dispatch(char$ptr __i1, char$ptr __i2, byte[] __from, int __fromIdx, int Size) {
    std.string __s = Size == 0 ? EMPTY : new std.string(__from, __fromIdx, Size);
    assert Size == __s.size() : "" + Size + " vs. " + __s.size();
    int __n1 = __i2.$sub(__i1);
    assert _M_check_length(__n1, __s.size(), "basic_string::_M_replace_dispatch");
    return _M_replace_safe(__i1.$sub(_M_ibegin()), __n1, __s._M_data(), Size);
  }

  protected void _M_mutate(int __pos, int __len1, int __len2)
  {
    final int __old_size = this.size();
    final int __new_size = __old_size + __len2 - __len1;
    final int __how_much = __old_size - __pos - __len1;

    if (__new_size > this.capacity()) {
      this.array.reserve(__new_size + 1/*TERM*/);
    }
    
    if (__how_much > 0 && __len1 != __len2) {
      char$ptr _M_data = _M_data();
      // Work in-place.
      if (__len2 > __len1) {
        int downToIdx = __pos + __len1;
        int fromIdx = downToIdx + __how_much;
        int destIdx = __pos + __len2 + __how_much;
        std.copy_backward(_M_data, downToIdx, fromIdx, _M_data, destIdx);
      } else {
        int fromIdx = __pos + __len1;
        int toIdx = fromIdx + __how_much;
        int destIdx = __pos + __len2;
        std.copy(_M_data, fromIdx, toIdx, _M_data, destIdx);
      }
    }
    
    this.array.set_size(__new_size);
  }    
  
  protected void _M_copy(char$ptr __d, int __dIdx, char$ptr __s, int __sIdx, int __n)
  {
    std.copy(__s, __sIdx, __sIdx + __n, __d, __dIdx);
  }    
  
  protected void _M_move(char$ptr __d, int __dIdx, char$ptr __s, int __sIdx, int __n)
  {
    std.copy(__s, __sIdx, __sIdx + __n, __d, __dIdx);
  }
  
  protected int _M_check(int __pos, CharSequence __s)  {
    if (__pos > this.size()) {
      throw new RuntimeException(__s.toString());
    }
    return __pos;
  }
  
  private boolean _M_check_length(int __n1, int __n2, CharSequence __s) {
    if (this.max_size() - (this.size() - __n1) < __n2) {
      throw new RuntimeException(__s.toString());
    }
    return true;
  }    
  
  private std.vectorChar.iterator convertPtrToIter(char$ptr ptr) {
    return array.begin().$add(ptr.$sub(begin()));
  }
  
  private void _postModUpdate() {
    if (array.empty() || array.$at(array.size() - 1) != TERM) {
      this.array.append(1, TERM);
    }
  }    
  
  private char$iterator erase(std.vectorChar.iterator __position) {
    assert !_isConst() : "This string cannot be modified!";
    char$iterator res = array.erase((std.vectorChar.iterator) __position);
    _postModUpdate();
    return res;
  }
  
  private char$iterator erase(std.vectorChar.iterator __first, std.vectorChar.iterator __last) {
    assert !_isConst() : "This string cannot be modified!";
    char$iterator res = array.erase(__first, __last);
    _postModUpdate();
    return res;
  }    

  // JAVA: indicator that this string must never  modify its content.
  private boolean _isConst() {
    return _const;
  }
}
