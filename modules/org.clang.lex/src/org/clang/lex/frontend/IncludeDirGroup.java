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

package org.clang.lex.frontend;

import org.clank.support.*;

/// IncludeDirGroup - Identifiers the group a include entry belongs to, which
/// represents its relative positive in the search list.  A \#include of a ""
/// path starts at the -iquote group, then searches the Angled group, then
/// searches the system group, etc.
//<editor-fold defaultstate="collapsed" desc="clang::frontend::IncludeDirGroup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", line = 28,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderSearchOptions.h", old_line = 27,
 FQN="clang::frontend::IncludeDirGroup", NM="_ZN5clang8frontend15IncludeDirGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang8frontend15IncludeDirGroupE")
//</editor-fold>
public enum IncludeDirGroup implements Native.ComparableLower {
  Quoted(0), ///< '\#include ""' paths, added by 'gcc -iquote'.
  Angled(Quoted.getValue() + 1), ///< Paths for '\#include <>' added by '-I'.
  IndexHeaderMap(Angled.getValue() + 1), ///< Like Angled, but marks header maps used when
  ///  building frameworks.
  System(IndexHeaderMap.getValue() + 1), ///< Like Angled, but marks system directories.
  ExternCSystem(System.getValue() + 1), ///< Like System, but headers are implicitly wrapped in
  ///  extern "C".
  CSystem(ExternCSystem.getValue() + 1), ///< Like System, but only used for C.
  CXXSystem(CSystem.getValue() + 1), ///< Like System, but only used for C++.
  ObjCSystem(CXXSystem.getValue() + 1), ///< Like System, but only used for ObjC.
  ObjCXXSystem(ObjCSystem.getValue() + 1), ///< Like System, but only used for ObjC++.
  After(ObjCXXSystem.getValue() + 1); ///< Like System, but searched after the system directories.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static IncludeDirGroup valueOf(int val) {
    IncludeDirGroup out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final IncludeDirGroup[] VALUES;
    private static final IncludeDirGroup[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (IncludeDirGroup kind : IncludeDirGroup.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new IncludeDirGroup[min < 0 ? (1-min) : 0];
      VALUES = new IncludeDirGroup[max >= 0 ? (1+max) : 0];
      for (IncludeDirGroup kind : IncludeDirGroup.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private IncludeDirGroup(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((IncludeDirGroup)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((IncludeDirGroup)obj).value);}
  //</editor-fold>
}
