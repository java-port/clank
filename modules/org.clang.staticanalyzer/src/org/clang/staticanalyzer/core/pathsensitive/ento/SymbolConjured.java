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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// A symbol representing the result of an expression in the case when we do
/// not know anything about what the expression is.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 73,
 FQN="clang::ento::SymbolConjured", NM="_ZN5clang4ento14SymbolConjuredE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolConjuredE")
//</editor-fold>
public class SymbolConjured extends /*public*/ SymbolData implements Destructors.ClassWithDestructor {
  private /*const*/ Stmt /*P*/ S;
  private QualType T;
  private /*uint*/int Count;
  private /*const*/ LocationContext /*P*/ LCtx;
  private /*const*/Object/*void P*/ SymbolTag;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::SymbolConjured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 81,
   FQN="clang::ento::SymbolConjured::SymbolConjured", NM="_ZN5clang4ento14SymbolConjuredC1EjPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEjPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolConjuredC1EjPKNS_4StmtEPKNS_15LocationContextENS_8QualTypeEjPKv")
  //</editor-fold>
  public SymbolConjured(/*uint*/int sym, /*const*/ Stmt /*P*/ s, /*const*/ LocationContext /*P*/ lctx, 
      QualType t, /*uint*/int count, /*const*/Object/*void P*/ symbolTag) {
    // : SymbolData(SymbolConjuredKind, sym), S(s), T(t), Count(count), LCtx(lctx), SymbolTag(symbolTag) 
    //START JInit
    super(Kind.SymbolConjuredKind, sym);
    this.S = s;
    this.T = new QualType(t);
    this.Count = count;
    this.LCtx = lctx;
    this.SymbolTag = symbolTag;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 86,
   FQN="clang::ento::SymbolConjured::getStmt", NM="_ZNK5clang4ento14SymbolConjured7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolConjured7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    return S;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::getCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 87,
   FQN="clang::ento::SymbolConjured::getCount", NM="_ZNK5clang4ento14SymbolConjured8getCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolConjured8getCountEv")
  //</editor-fold>
  public /*uint*/int getCount() /*const*/ {
    return Count;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::getTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 88,
   FQN="clang::ento::SymbolConjured::getTag", NM="_ZNK5clang4ento14SymbolConjured6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolConjured6getTagEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getTag() /*const*/ {
    return SymbolTag;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 307,
   FQN="clang::ento::SymbolConjured::getType", NM="_ZNK5clang4ento14SymbolConjured7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolConjured7getTypeEv")
  //</editor-fold>
  @Override public QualType getType() /*const*//* override*/ {
    return new QualType(T);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp", line = 67,
   FQN="clang::ento::SymbolConjured::dumpToStream", NM="_ZNK5clang4ento14SymbolConjured12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZNK5clang4ento14SymbolConjured12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    os.$out(/*KEEP_STR*/"conj_$").$out_uint(getSymbolID()).$out_char($$LCURLY).$out(T.getAsString()).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 94,
   FQN="clang::ento::SymbolConjured::Profile", NM="_ZN5clang4ento14SymbolConjured7ProfileERN4llvm16FoldingSetNodeIDEPKNS_4StmtENS_8QualTypeEjPKNS_15LocationContextEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolConjured7ProfileERN4llvm16FoldingSetNodeIDEPKNS_4StmtENS_8QualTypeEjPKNS_15LocationContextEPKv")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ profile, /*const*/ Stmt /*P*/ S, 
         QualType T, /*uint*/int Count, /*const*/ LocationContext /*P*/ LCtx, 
         /*const*/Object/*void P*/ SymbolTag) {
    profile.AddInteger_uint((/*uint*/int)Kind.SymbolConjuredKind.getValue());
    profile.AddPointer(S);
    profile.AddPointer(LCtx);
    profile.Add(T);
    profile.AddInteger_uint(Count);
    profile.AddPointer(SymbolTag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 105,
   FQN="clang::ento::SymbolConjured::Profile", NM="_ZN5clang4ento14SymbolConjured7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolConjured7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ profile)/* override*/ {
    Profile(profile, S, /*NO_COPY*/T, Count, LCtx, SymbolTag);
  }

  
  // Implement isa<T> support.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 110,
   FQN="clang::ento::SymbolConjured::classof", NM="_ZN5clang4ento14SymbolConjured7classofEPKNS0_7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolConjured7classofEPKNS0_7SymExprE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ SymExpr /*P*/ SE) {
    return SE.getKind() == Kind.SymbolConjuredKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SymbolConjured::~SymbolConjured">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/SymbolManager.h", line = 73,
   FQN="clang::ento::SymbolConjured::~SymbolConjured", NM="_ZN5clang4ento14SymbolConjuredD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/SymbolManager.cpp -nm=_ZN5clang4ento14SymbolConjuredD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "S=" + S // NOI18N
              + ", T=" + T // NOI18N
              + ", Count=" + Count // NOI18N
              + ", LCtx=" + "[LocationContext]" // NOI18N
              + ", SymbolTag=" + SymbolTag // NOI18N
              + super.toString(); // NOI18N
  }
}
