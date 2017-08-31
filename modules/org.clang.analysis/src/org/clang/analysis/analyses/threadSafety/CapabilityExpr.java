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

package org.clang.analysis.analyses.threadSafety;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.clang.ast.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import org.clang.analysis.analyses.threadSafety.*;
import org.clang.analysis.analyses.threadSafety.sx.SxGlobals;

//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 253,
 FQN="clang::threadSafety::CapabilityExpr", NM="_ZN5clang12threadSafety14CapabilityExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety14CapabilityExprE")
//</editor-fold>
public class CapabilityExpr implements NativeCloneable<CapabilityExpr> {
// TODO: move this back into ThreadSafety.cpp
  // This is specific to thread safety.  It is here because
  // translateAttrExpr needs it, but that should be moved too.
  /*private:*/
  private /*const*/ SExpr /*P*/ CapExpr; ///< The capability expression.
  private boolean Negated; ///< True if this is a negative capability
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::CapabilityExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 263,
   FQN="clang::threadSafety::CapabilityExpr::CapabilityExpr", NM="_ZN5clang12threadSafety14CapabilityExprC1EPKNS0_3til5SExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety14CapabilityExprC1EPKNS0_3til5SExprEb")
  //</editor-fold>
  public CapabilityExpr(/*const*/ SExpr /*P*/ E, boolean Neg) {
    // : CapExpr(E), Negated(Neg) 
    //START JInit
    this.CapExpr = E;
    this.Negated = Neg;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::sexpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 265,
   FQN="clang::threadSafety::CapabilityExpr::sexpr", NM="_ZNK5clang12threadSafety14CapabilityExpr5sexprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr5sexprEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ sexpr() /*const*/ {
    return CapExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::negative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 266,
   FQN="clang::threadSafety::CapabilityExpr::negative", NM="_ZNK5clang12threadSafety14CapabilityExpr8negativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr8negativeEv")
  //</editor-fold>
  public boolean negative() /*const*/ {
    return Negated;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::operator!">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 268,
   FQN="clang::threadSafety::CapabilityExpr::operator!", NM="_ZNK5clang12threadSafety14CapabilityExprntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExprntEv")
  //</editor-fold>
  public CapabilityExpr $not() /*const*/ {
    return new CapabilityExpr(CapExpr, !Negated);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::equals">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 272,
   FQN="clang::threadSafety::CapabilityExpr::equals", NM="_ZNK5clang12threadSafety14CapabilityExpr6equalsERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr6equalsERKS1_")
  //</editor-fold>
  public boolean equals(final /*const*/ CapabilityExpr /*&*/ other) /*const*/ {
    return (Negated == other.Negated) && SxGlobals.equals(CapExpr, other.CapExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::matches">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 276,
   FQN="clang::threadSafety::CapabilityExpr::matches", NM="_ZNK5clang12threadSafety14CapabilityExpr7matchesERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr7matchesERKS1_")
  //</editor-fold>
  public boolean matches(final /*const*/ CapabilityExpr /*&*/ other) /*const*/ {
    return (Negated == other.Negated) && SxGlobals.matches(CapExpr, other.CapExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::matchesUniv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 280,
   FQN="clang::threadSafety::CapabilityExpr::matchesUniv", NM="_ZNK5clang12threadSafety14CapabilityExpr11matchesUnivERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr11matchesUnivERKS1_")
  //</editor-fold>
  public boolean matchesUniv(final /*const*/ CapabilityExpr /*&*/ CapE) /*const*/ {
    return isUniversal() || matches(CapE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::partiallyMatches">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 284,
   FQN="clang::threadSafety::CapabilityExpr::partiallyMatches", NM="_ZNK5clang12threadSafety14CapabilityExpr16partiallyMatchesERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr16partiallyMatchesERKS1_")
  //</editor-fold>
  public boolean partiallyMatches(final /*const*/ CapabilityExpr /*&*/ other) /*const*/ {
    return (Negated == other.Negated)
       && SxGlobals.partiallyMatches(CapExpr, other.CapExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::valueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 289,
   FQN="clang::threadSafety::CapabilityExpr::valueDecl", NM="_ZNK5clang12threadSafety14CapabilityExpr9valueDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr9valueDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ valueDecl() /*const*/ {
    if (Negated || CapExpr == null) {
      return null;
    }
    {
      /*const*/ Project /*P*/ P = dyn_cast_Project(CapExpr);
      if ((P != null)) {
        return P.clangDecl();
      }
    }
    {
      /*const*/ LiteralPtr /*P*/ P = dyn_cast_LiteralPtr(CapExpr);
      if ((P != null)) {
        return P.clangDecl();
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::toString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 299,
   FQN="clang::threadSafety::CapabilityExpr::toString", NM="_ZNK5clang12threadSafety14CapabilityExpr8toStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr8toStringEv")
  //</editor-fold>
  public std.string __toString() /*const*/ {
    if (Negated) {
      return $add_T$C$P_string(/*KEEP_STR*/"!", SxGlobals.__toString(CapExpr));
    }
    return SxGlobals.__toString(CapExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::shouldIgnore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 305,
   FQN="clang::threadSafety::CapabilityExpr::shouldIgnore", NM="_ZNK5clang12threadSafety14CapabilityExpr12shouldIgnoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr12shouldIgnoreEv")
  //</editor-fold>
  public boolean shouldIgnore() /*const*/ {
    return CapExpr == null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::isInvalid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 307,
   FQN="clang::threadSafety::CapabilityExpr::isInvalid", NM="_ZNK5clang12threadSafety14CapabilityExpr9isInvalidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr9isInvalidEv")
  //</editor-fold>
  public boolean isInvalid() /*const*/ {
    return (sexpr() != null) && isa_Undefined(sexpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::isUniversal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 309,
   FQN="clang::threadSafety::CapabilityExpr::isUniversal", NM="_ZNK5clang12threadSafety14CapabilityExpr11isUniversalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety14CapabilityExpr11isUniversalEv")
  //</editor-fold>
  public boolean isUniversal() /*const*/ {
    return (sexpr() != null) && isa_Wildcard(sexpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::CapabilityExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 253,
   FQN="clang::threadSafety::CapabilityExpr::CapabilityExpr", NM="_ZN5clang12threadSafety14CapabilityExprC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety14CapabilityExprC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CapabilityExpr(final /*const*/ CapabilityExpr /*&*/ $Prm0) {
    // : CapExpr(.CapExpr), Negated(.Negated) 
    //START JInit
    this.CapExpr = $Prm0.CapExpr;
    this.Negated = $Prm0.Negated;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::CapabilityExpr::CapabilityExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyCommon.h", line = 253,
   FQN="clang::threadSafety::CapabilityExpr::CapabilityExpr", NM="_ZN5clang12threadSafety14CapabilityExprC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety14CapabilityExprC1EOS1_")
  //</editor-fold>
  public /*inline*/ CapabilityExpr(JD$Move _dparam, final CapabilityExpr /*&&*/$Prm0) {
    // : CapExpr(static_cast<CapabilityExpr &&>().CapExpr), Negated(static_cast<CapabilityExpr &&>().Negated) 
    //START JInit
    this.CapExpr = $Prm0.CapExpr;
    this.Negated = $Prm0.Negated;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected void $destroy() { }
  
  public CapabilityExpr() { }

  @Override
  public CapabilityExpr clone() {
    return new CapabilityExpr(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CapExpr=" + CapExpr // NOI18N
              + ", Negated=" + Negated; // NOI18N
  }
}
