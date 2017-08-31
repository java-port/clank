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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 31,
 FQN="(anonymous namespace)::Range", NM="_ZN12_GLOBAL__N_15RangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_15RangeE")
//</editor-fold>
public class Range extends /*public*/ std.pairPtrPtr</*const*/ APSInt /*P*/ , /*const*/ APSInt /*P*/ > implements FoldingSetTrait.Profilable {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::Range">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 34,
   FQN="(anonymous namespace)::Range::Range", NM="_ZN12_GLOBAL__N_15RangeC1ERKN4llvm6APSIntES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_15RangeC1ERKN4llvm6APSIntES4_")
  //</editor-fold>
  public Range(final /*const*/ APSInt /*&*/ from, final /*const*/ APSInt /*&*/ to) {
    // : std::pair<const APSInt * , const APSInt * >(&from, &to) 
    //START JInit
    super(JD$T$RR_T1$RR.INSTANCE, $AddrOf(from), $AddrOf(to));
    //END JInit
    assert (from.$lesseq(to));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::Includes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 38,
   FQN="(anonymous namespace)::Range::Includes", NM="_ZNK12_GLOBAL__N_15Range8IncludesERKN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_15Range8IncludesERKN4llvm6APSIntE")
  //</editor-fold>
  public boolean Includes(final /*const*/ APSInt /*&*/ v) /*const*/ {
    return $Deref(first.$lesseq(v)) && v.$lesseq($Deref(second));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::From">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 41,
   FQN="(anonymous namespace)::Range::From", NM="_ZNK12_GLOBAL__N_15Range4FromEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_15Range4FromEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ From() /*const*/ {
    return $Deref(first);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::To">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 44,
   FQN="(anonymous namespace)::Range::To", NM="_ZNK12_GLOBAL__N_15Range2ToEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_15Range2ToEv")
  //</editor-fold>
  public /*const*/ APSInt /*&*/ To() /*const*/ {
    return $Deref(second);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::getConcreteValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 47,
   FQN="(anonymous namespace)::Range::getConcreteValue", NM="_ZNK12_GLOBAL__N_15Range16getConcreteValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_15Range16getConcreteValueEv")
  //</editor-fold>
  public /*const*/ APSInt /*P*/ getConcreteValue() /*const*/ {
    return /*AddrOf*/From() == $AddrOf(To()) ? $AddrOf(From()) : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 51,
   FQN="(anonymous namespace)::Range::Profile", NM="_ZNK12_GLOBAL__N_15Range7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZNK12_GLOBAL__N_15Range7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.AddPointer($AddrOf(From()));
    ID.AddPointer($AddrOf(To()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Range::Range">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp", line = 31,
   FQN="(anonymous namespace)::Range::Range", NM="_ZN12_GLOBAL__N_15RangeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RangeConstraintManager.cpp -nm=_ZN12_GLOBAL__N_15RangeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Range(final /*const*/ Range /*&*/ $Prm0) {
    // : std::pair<const APSInt * , const APSInt * >() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  @Override public Range clone() {
    return new Range(this);
  }

  @Override public Range move() {
    return new Range(first, second);
  }
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
