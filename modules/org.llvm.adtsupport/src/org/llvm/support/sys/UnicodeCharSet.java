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

package org.llvm.support.sys;

/// \brief Holds a reference to an ordered array of UnicodeCharRange and allows

import org.clank.java.std;
import org.clank.support.Converted;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.type$ptr;
import org.llvm.adt.aliases.ArrayRef;
import org.llvm.support.llvm;

/// to quickly check if a code point is contained in the set represented by this
/// array.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::UnicodeCharSet">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 42,
 FQN = "llvm::sys::UnicodeCharSet", NM = "_ZN4llvm3sys14UnicodeCharSetE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm3sys14UnicodeCharSetE")
//</editor-fold>
public final class UnicodeCharSet {
/*public:*/
  /*typedef llvm::ArrayRef<UnicodeCharRange> CharRanges*/
//  public static final class CharRanges extends ArrayRef<UnicodeCharRange>{ };
  
  /// \brief Constructs a UnicodeCharSet instance from an array of
  /// UnicodeCharRanges.
  ///
  /// Array pointed by \p Ranges should have the lifetime at least as long as
  /// the UnicodeCharSet instance, and should not change. Array is validated by
  /// the constructor, so it makes sense to create as few UnicodeCharSet
  /// instances per each array of ranges, as possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::UnicodeCharSet::UnicodeCharSet">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", old_line = 53,
   FQN = "llvm::sys::UnicodeCharSet::UnicodeCharSet", NM = "_ZN4llvm3sys14UnicodeCharSetC1ENS_8ArrayRefINS0_16UnicodeCharRangeEEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm3sys14UnicodeCharSetC1ENS_8ArrayRefINS0_16UnicodeCharRangeEEE")
  //</editor-fold>
  public UnicodeCharSet(ArrayRef<UnicodeCharRange> Ranges) {
    /* : Ranges(Ranges)*/ 
    //START JInit
    this.Ranges = new /*const*/ArrayRef<UnicodeCharRange>(Ranges.$vector());
    //END JInit
    assert (rangesAreValid());
  }

  
  /// \brief Returns true if the character set contains the Unicode code point
  /// \p C.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::UnicodeCharSet::contains">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", old_line = 59,
   FQN = "llvm::sys::UnicodeCharSet::contains", NM = "_ZNK4llvm3sys14UnicodeCharSet8containsEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm3sys14UnicodeCharSet8containsEj")
  //</editor-fold>
  public boolean contains(int/*uint32_t*/ C) /*const*/ {
    return std.binary_search(Ranges.begin(), Ranges.end(), C);
  }

/*private:*/
  /// \brief Returns true if each of the ranges is a proper closed range
  /// [min, max], and if the ranges themselves are ordered and non-overlapping.
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::UnicodeCharSet::rangesAreValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 75,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", old_line = 66,
   FQN = "llvm::sys::UnicodeCharSet::rangesAreValid", NM = "_ZNK4llvm3sys14UnicodeCharSet14rangesAreValidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm3sys14UnicodeCharSet14rangesAreValidEv")
  //</editor-fold>
  private boolean rangesAreValid() /*const*/ {
    int/*uint32_t*/ Prev = 0;
    for (type$ptr<UnicodeCharRange> I = $tryClone(Ranges.begin()), /*P*/ E = $tryClone(Ranges.end());
         I.$noteq(E); I.$preInc()) {
      if (I.$noteq(Ranges.begin()) && Prev >= I./*->*/$star().Lower) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().$out("Upper bound 0x");
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().write_hex(Prev);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().$out(" should be less than succeeding lower bound 0x");
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().write_hex(I./*->*/$star().Lower).$out("\n");
          }
        } while (false);
        return false;
      }
      if (I./*->*/$star().Upper < I./*->*/$star().Lower) {
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().$out("Upper bound 0x");
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().write_hex(I./*->*/$star().Lower);
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().$out(" should not be less than lower bound 0x");
          }
        } while (false);
        do {
          if (/*::*/llvm.DebugFlag && /*::*/llvm.isCurrentDebugType("")) {
            llvm.dbgs().write_hex(I./*->*/$star().Upper).$out("\n");
          }
        } while (false);
        return false;
      }
      Prev = I./*->*/$star().Upper;
    }

    return true;
  }

  private /*const*/ArrayRef<UnicodeCharRange> Ranges;
}