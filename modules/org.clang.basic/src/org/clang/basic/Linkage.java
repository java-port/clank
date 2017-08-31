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

package org.clang.basic;

import org.clank.support.*;
import org.clang.basic.*;


/// \brief Describes the different kinds of linkage 
/// (C++ [basic.link], C99 6.2.2) that an entity may have.
//<editor-fold defaultstate="collapsed" desc="clang::Linkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 25,
 FQN="clang::Linkage", NM="_ZN5clang7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FixIt.cpp -nm=_ZN5clang7LinkageE")
//</editor-fold>
public enum Linkage/* : unsigned char*/ implements Native.ComparableLower {
  /// \brief No linkage, which means that the entity is unique and
  /// can only be referred to from within its scope.
  NoLinkage(0),
  
  /// \brief Internal linkage, which indicates that the entity can
  /// be referred to from within the translation unit (but not other
  /// translation units).
  InternalLinkage(NoLinkage.getValue() + 1),
  
  /// \brief External linkage within a unique namespace. 
  ///
  /// From the language perspective, these entities have external
  /// linkage. However, since they reside in an anonymous namespace,
  /// their names are unique to this translation unit, which is
  /// equivalent to having internal linkage from the code-generation
  /// point of view.
  UniqueExternalLinkage(InternalLinkage.getValue() + 1),
  
  /// \brief No linkage according to the standard, but is visible from other
  /// translation units because of types defined in a inline function.
  VisibleNoLinkage(UniqueExternalLinkage.getValue() + 1),
  
  /// \brief External linkage, which indicates that the entity can
  /// be referred to from other translation units.
  ExternalLinkage(VisibleNoLinkage.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static Linkage valueOf(/*uchar*/byte val) {
    Linkage out = valueOf((int)val);
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
    return out;
  }
  public static Linkage valueOf(int val) {
    Linkage out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final Linkage[] VALUES;
    private static final Linkage[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (Linkage kind : Linkage.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new Linkage[min < 0 ? (1-min) : 0];
      VALUES = new Linkage[max >= 0 ? (1+max) : 0];
      for (Linkage kind : Linkage.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uchar*/byte value;
  private Linkage(int val) { this.value = (/*uchar*/byte)val;}
  public /*uchar*/byte getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uchar(value, ((Linkage)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uchar(value, ((Linkage)obj).value);}
  //</editor-fold>
}
