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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.java.built_in.__builtin_popcountl;
import org.clank.support.NativeType;


/**
 *  Base class, general case.  It is a class invariant that _Nw will be
 *  nonnegative.
 *
 *  See documentation for bitset.
*/
public class StdBaseBitset {
  
  protected static final int _GLIBCXX_BITSET_BITS_PER_WORD = NativeType.BITS_PER_WORD;
  
  protected static final int __CHAR_BIT__ = NativeType.CHAR_BIT;
  
  private final int _Nw;
  
  /// 0 is the least significant word.
  private final /*ushort*/char _M_w[];

  public StdBaseBitset() {
    this._Nw = 0;
    this._M_w = null;
  }

  protected StdBaseBitset(int _Nw) { 
    this._Nw = (int) _Nw;
    this._M_w = new$ushort(_Nw);
  }

  protected StdBaseBitset(int _Nw, /*ushort*/char __val) { 
    this(_Nw);
    this._M_w[0] = __val; 
  }

  protected StdBaseBitset(StdBaseBitset $Prm0) {
    this($Prm0._Nw);
    std.copy($Prm0._M_w, 0, $Prm0._Nw, this._M_w, 0);
  }
  
  protected static int _S_whichword(int __pos) { 
    return __pos / _GLIBCXX_BITSET_BITS_PER_WORD; 
  }

  protected static int _S_whichbyte(int __pos)
  { return (__pos % _GLIBCXX_BITSET_BITS_PER_WORD) / __CHAR_BIT__; }

  protected static int _S_whichbit(int __pos) { 
    return __pos % _GLIBCXX_BITSET_BITS_PER_WORD; 
  }

  protected static char _S_maskbit(int __pos) { 
    return (char) (1 << _S_whichbit(__pos)); 
  }

  protected int _M_getword(int __pos) { 
    return _M_w[(int) _S_whichword(__pos)]; 
  }
  
  protected ushort$ref _M_getword$ref(int __pos) { 
    return create_ushort$ref(_M_w, _S_whichword(__pos));
  }      

  protected int _M_hiword() { 
    return _M_w[_Nw - 1]; 
  }
  
  protected ushort$ref _M_hiword$ref() { 
    return create_ushort$ref(_M_w, _Nw - 1); 
  }      

  protected void _M_do_and(StdBaseBitset __x) {
    for (int __i = 0; __i < _Nw; __i++) {
      _M_w[__i] &= __x._M_w[__i];
    }
  }

  protected void _M_do_or(StdBaseBitset __x) {
    for (int __i = 0; __i < _Nw; __i++) {
      _M_w[__i] |= __x._M_w[__i];
    }
  }

  protected void _M_do_xor(StdBaseBitset __x) {
    for (int __i = 0; __i < _Nw; __i++) {
      _M_w[__i] ^= __x._M_w[__i];
    }
  }

  protected void _M_do_left_shift(int __shift) {
    if (__shift != 0) {
      final int __wshift = __shift / _GLIBCXX_BITSET_BITS_PER_WORD;
      final int __offset = __shift % _GLIBCXX_BITSET_BITS_PER_WORD;

      if (__offset == 0) {
        for (int __n = _Nw - 1; __n >= __wshift; --__n) {
          _M_w[(int) __n] = _M_w[(int) (__n - __wshift)];
        }
      } else {
          final int __sub_offset = (_GLIBCXX_BITSET_BITS_PER_WORD - __offset);
          for (int __n = _Nw - 1; __n > __wshift; --__n) {
            _M_w[(int) __n] = (char) ((_M_w[(int) (__n - __wshift)] << __offset) 
                | (_M_w[(int) (__n - __wshift - 1)] >>> __sub_offset));
          }
          _M_w[(int) __wshift] = (char) (_M_w[0] << __offset);
      }

      std.fill(create_ushort$ptr(_M_w), create_ushort$ptr(_M_w, __wshift), (char) 0);
    }
  }

  protected void _M_do_right_shift(int __shift) {
    if (__shift != 0) {
      final int __wshift = __shift / _GLIBCXX_BITSET_BITS_PER_WORD;
      final int __offset = __shift % _GLIBCXX_BITSET_BITS_PER_WORD;
      final int __limit = _Nw - __wshift - 1;

      if (__offset == 0) {
        for (int __n = 0; __n <= __limit; ++__n) {
          _M_w[(int) __n] = _M_w[(int) (__n + __wshift)];
        }
      } else {
          final int __sub_offset = (_GLIBCXX_BITSET_BITS_PER_WORD - __offset);
          for (int __n = 0; __n < __limit; ++__n) {
            _M_w[(int) __n] = (char) ((_M_w[(int) (__n + __wshift)] >>> __offset)
                   | (_M_w[(int) (__n + __wshift + 1)] << __sub_offset));
          }
          _M_w[(int) __limit] = (char) (_M_w[_Nw-1] >>> __offset);
      }

      std.fill(create_ushort$ptr(_M_w, __limit + 1), create_ushort$ptr(_M_w, _Nw), (char) 0);
    }
  }

  protected void _M_do_flip() {
    for (int __i = 0; __i < _Nw; __i++) {
      _M_w[__i] = (char) ~_M_w[__i];
    }
  }

  protected void _M_do_set() {
    for (int __i = 0; __i < _Nw; __i++) {
      _M_w[__i] = (char) ~0;
    }
  }

  protected void _M_do_reset() { 
    std.memset(_M_w, '\0', _Nw); 
  }

  protected boolean _M_is_equal(StdBaseBitset __x) {
    for (int __i = 0; __i < _Nw; ++__i) {
      if (_M_w[__i] != __x._M_w[__i]) {
        return false;
      }
    }
    return true;
  }

  protected boolean _M_are_all(int _Nb) {
    for (int __i = 0; __i < _Nw - 1; __i++) {
      if (_M_w[__i] != (char)~0) {
        return false;
      }
    }
    return _M_hiword() == (~(0) >>> (_Nw * _GLIBCXX_BITSET_BITS_PER_WORD - _Nb));
  }

  protected boolean _M_is_any()  {
    for (int __i = 0; __i < _Nw; __i++) {
      if (_M_w[__i] != 0) {
        return true;
      }
    }
    return false;
  }

  protected int _M_do_count() {
    int __result = 0;
    for (int __i = 0; __i < _Nw; __i++) {
      __result += __builtin_popcountl(_M_w[__i]);
    }
    return __result;
  }

  protected long _M_do_to_ulong() {
    throw new UnsupportedOperationException("Not supported yet!");
  }

  // find first "on" bit
  protected int _M_do_find_first(int __not_found) {
    throw new UnsupportedOperationException("Not supported yet!");
  }

  // find the next "on" bit that follows "prev"
  protected int  _M_do_find_next(int __prev, int __not_found) {
    throw new UnsupportedOperationException("Not supported yet!");
  }
};