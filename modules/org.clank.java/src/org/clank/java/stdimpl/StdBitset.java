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

import java.security.InvalidParameterException;
import org.clank.java.std;
import org.clank.support.Native;
import org.clank.support.Native.NativeComparable;
import org.clank.support.aliases.*;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class StdBitset extends StdBaseBitset implements NativeComparable<std.bitset> {  
  
  public boolean $at$Const(int value) {
    return test(value);
  }

  public boolean $at(int value) {
    return test(value);
  }

  private final int _Nb;

  protected StdBitset(StdBitset $Prm0) {
    super($Prm0);
    this._Nb = $Prm0._Nb;
  }
  
  protected StdBitset(int _Nb) {
    super(_GLIBCXX_BITSET_WORDS(_Nb));
    this._Nb = _Nb;
  }

  protected StdBitset(int _Nb, /*ushort*/char __val) {
    super(_GLIBCXX_BITSET_WORDS(_Nb), __val);
    this._Nb = _Nb;
  }
  
  /**
   *  Use a subset of a string.
   *  @param  __s  A string of @a 0 and @a 1 characters.
   *  @param  __position  Index of the first character in @a __s to use;
   *                    defaults to zero.
   *  @throw  std::out_of_range  If @a pos is bigger the size of @a __s.
   *  @throw  std::invalid_argument  If a character appears in the string
   *                                 which is neither @a 0 nor @a 1.
   */
  protected StdBitset(int _Nb, std.string __s) {
    this(_Nb, __s, 0);
  }
  
	protected StdBitset(int _Nb, std.string __s, int __position) {
    super(_GLIBCXX_BITSET_WORDS(_Nb));
    this._Nb = _Nb;
	  if (__position > __s.size()) {
	    throw new RuntimeException("bitset::bitset initial position not valid");
    }
	  _M_copy_from_string(__s, __position, std.string.npos, '0', '1');
	}
      
  // Set, reset, and flip.
  /**
   *  @brief Sets every bit to true.
   */
  public std.bitset set() {
    this._M_do_set();
    this._M_do_sanitize();
    return (std.bitset) this;
  }

  /**
   *  @brief Sets a given bit to a particular value.
   *  @param  __position  The index of the bit.
   *  @param  __val  Either true or false, defaults to true.
   *  @throw  std::out_of_range  If @a pos is bigger the size of the %set.
   */
  public std.bitset set(/*uchar*/byte __position) {
    return set(__position & 0xFF, true);
  }
  public std.bitset set(/*uchar*/byte __position, boolean __val) {
    return set(__position & 0xFF, __val);
  }
  public std.bitset set(int __position) {
    return set(__position, true);
  }
  public std.bitset set(int __position, boolean __val) {
    assert __position >= 0 : "must be unsigned " + __position;   
    if (__position >= _Nb) {
      throw new RuntimeException("Overflow!");
    }
    return _Unchecked_set(__position, __val ? 1 : 0);
  }

  /**
   *  @brief Sets every bit to false.
   */
  public std.bitset reset() {
    this._M_do_reset();
    return (std.bitset) this;
  }

  /**
   *  @brief Sets a given bit to false.
   *  @param  __position  The index of the bit.
   *  @throw  std::out_of_range  If @a pos is bigger the size of the %set.
   *
   *  Same as writing @c set(pos,false).
   */
  public std.bitset reset(/*uchar*/byte __position) {
    return reset(__position & 0xFF);
  }  
  public std.bitset reset(int __position) {
    assert __position >= 0 : "must be unsigned " + __position;   
    if (__position >= _Nb) {
      throw new RuntimeException("Overflow!");
    }
    return _Unchecked_reset(__position);
  }
  
  /**
   *  @brief Toggles every bit to its opposite value.
   */
  public std.bitset flip() {
    this._M_do_flip();
    this._M_do_sanitize();
    return (std.bitset) this;
  }

  /**
   *  @brief Toggles a given bit to its opposite value.
   *  @param  __position  The index of the bit.
   *  @throw  std::out_of_range  If @a pos is bigger the size of the %set.
   */
  public std.bitset flip(/*uchar*/byte __position) {
    return flip(__position & 0xFF);
  }
  public std.bitset flip(int __position) {
    assert __position >= 0 : "must be unsigned " + __position;    
    if (__position >= _Nb) {
      throw new RuntimeException("Overflow!");
    }
    return _Unchecked_flip(__position);
  }  
  
  /// Returns the number of bits which are set.
  public int count() { 
    return this._M_do_count(); 
  }

  /// Returns the total number of bits.
  public int size() { 
    return _Nb;
  }

  //@{
  /// These comparisons for equality/inequality are, well, @e bitwise.
  @Override
  public boolean $eq(std.bitset other) {
    return this._M_is_equal(other);
  }

  @Override
  public boolean $noteq(std.bitset other) {
    return !this._M_is_equal(other);
  }
  //@}

  public void $andassign(std.bitset other) {
    _M_do_and(other);
  }

  public void $orassign(std.bitset other) {
    _M_do_or(other);
  }

  public static std.bitset $bitand_bitset$_Nb$C(std.bitset b1, std.bitset b2) {
    std.bitset res = new std.bitset(b1.size());
    // here we use the fact that in the new bitset (in Java) all bits are zero
    res._M_do_or(b1); // now res is the copy of b1
    res._M_do_and(b2);
    return res;
  }

  public std.bitset $bitnot() {
    std.bitset res = new std.bitset(this._Nb);
    // here we use the fact that in the new bitset (in Java) all bits are zero
    res._M_do_or(this);
    return res;
  }

  /**
   *  @brief Tests the value of a bit.
   *  @param  __position  The index of a bit.
   *  @return  The value at @a pos.
   *  @throw  std::out_of_range  If @a pos is bigger the size of the %set.
   */
  public boolean test(/*uchar*/byte __position) {
    return test(__position & 0xFF);
  }
  public boolean test(int __position) {
    assert __position >= 0 : "must be unsigned " + __position;
    if (__position >= _Nb) {
      throw new RuntimeException("Overflow!");
    }
    return _Unchecked_test(__position);
  }

  // _GLIBCXX_RESOLVE_LIB_DEFECTS
  // DR 693. std::bitset::all() missing.
  /**
   *  @brief Tests whether all the bits are on.
   *  @return  True if all the bits are set.
   */
  public boolean all() { 
    return this._M_are_all(_Nb); 
  }

  /**
   *  @brief Tests whether any of the bits are on.
   *  @return  True if at least one bit is set.
   */
  public boolean any() { 
    return this._M_is_any(); 
  }

  /**
   *  @brief Tests whether any of the bits are on.
   *  @return  True if none of the bits are set.
   */
  public boolean none() { 
    return !this._M_is_any(); 
  }  

  @Override
  public String toString() {
    std.string tmp = new std.string();
    _M_copy_to_string(tmp, '0', '1');
    return tmp.toJavaString();
  }
  
  //@{
  /**
   *  These versions of single-bit set, reset, flip, and test are
   *  extensions from the SGI version.  They do no range checking.
   *  @ingroup SGIextensions
   */
  protected std.bitset _Unchecked_set(int __pos) {
    this._M_getword$ref(__pos).$set((char) (this._M_getword(__pos) | StdBaseBitset._S_maskbit(__pos)));
    return (std.bitset) this;
  }

  protected std.bitset _Unchecked_set(int __pos, int __val)
  {
    if (__val != 0) {
      this._M_getword$ref(__pos).$set((char) (this._M_getword(__pos) | StdBaseBitset._S_maskbit(__pos)));
    } else {
      this._M_getword$ref(__pos).$set((char) (this._M_getword(__pos) & (~StdBaseBitset._S_maskbit(__pos))));
    }
    return (std.bitset) this;
  }

  protected std.bitset _Unchecked_reset(int __pos) {
    this._M_getword$ref(__pos).$set((char) (this._M_getword(__pos) & (~StdBaseBitset._S_maskbit(__pos))));
    return (std.bitset) this;
  }

  protected std.bitset _Unchecked_flip(int __pos) {
    this._M_getword$ref(__pos).$set((char) (this._M_getword(__pos) ^ StdBaseBitset._S_maskbit(__pos)));
    return (std.bitset) this;
  }

  protected boolean _Unchecked_test(int __pos)  {
    return ((this._M_getword(__pos) & StdBaseBitset._S_maskbit(__pos)) != 0); 
  }
  //@}      
      
  private void _M_do_sanitize() { 
    _Sanitize __sanitize_type = new _Sanitize(_Nb % _GLIBCXX_BITSET_BITS_PER_WORD);
    __sanitize_type._S_do_sanitize(this._M_hiword$ref());
  }      
  
  private void _M_copy_from_string(std.string __s, int __pos, int __n, char __zero, char __one) { 
    _M_copy_from_string(__s, __pos, __n, (byte) __zero, (byte) __one);
  }
  
	private void _M_copy_from_string(std.string __s, int __pos, int __n, byte __zero, byte __one) { 
    _M_copy_from_ptr(__s.data(), __s.size(), __pos, __n, __zero, __one); 
  }
  
  private void _M_copy_from_ptr(char$ptr __s, int __len, int __pos, int __n, char __zero, char __one) {
    _M_copy_from_ptr(__s, __len, __pos, __n, (byte) __zero, (byte) __one);
  }
  
  private void _M_copy_from_ptr(char$ptr __s, int __len, int __pos, int __n, byte __zero, byte __one) {
    reset();
    final int __nbits = std.min(_Nb, std.min(__n, (__len - __pos)));
    for (int __i = __nbits; __i > 0; --__i) {
      final byte __c = __s.$at(__pos + __nbits - __i);
      if (Native.$eq(__c, __zero)) {
        // do nothing
      } else if (Native.$eq(__c, __one)) {
        _Unchecked_set(__i - 1);
      } else {
        throw new InvalidParameterException("Not 'one' or 'zero' character found!");
      }
    }
  }
  
  private void _M_copy_to_string(std.string __s, char __zero, char __one) {
    _M_copy_to_string(__s, (byte) __zero, (byte) __one);
  }

  private void _M_copy_to_string(std.string __s, byte __zero, byte __one) {
    __s.assign(_Nb, __zero);
    for (int __i = _Nb; __i > 0; --__i) {
      if (_Unchecked_test(__i - 1)) {
        __s.$set(_Nb - __i, __one);
      }
    }
  }
      
  private static int _GLIBCXX_BITSET_WORDS(int __n) {
    return ((__n) / _GLIBCXX_BITSET_BITS_PER_WORD + 
        (((__n) % _GLIBCXX_BITSET_BITS_PER_WORD) == 0 ? 0 : 1));
  }      
  
  // Helper class to zero out the unused high-order bits in the highest word.
  private static class _Sanitize
  {
    private final int _Extrabits;

    public _Sanitize(int _Extrabits) {
      this._Extrabits = _Extrabits;
    }

    public void _S_do_sanitize(ushort$ref __val) { 
      __val.$set((char) (__val.$deref() & (~((~(char)(0)) << _Extrabits)))); 
    }
  };
}
