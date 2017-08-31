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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.impl.EnvironmentStatics.*;


/// An entry in the environment consists of a Stmt and an LocationContext.
/// This allows the environment to manage context-sensitive bindings,
/// which is essentially for modeling recursive function analysis, among
/// other things.
//<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 35,
 FQN="clang::ento::EnvironmentEntry", NM="_ZN5clang4ento16EnvironmentEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento16EnvironmentEntryE")
//</editor-fold>
public class EnvironmentEntry extends /*public*/ std.pairPtrPtr</*const*/ Stmt /*P*/ , /*const*/ StackFrameContext /*P*/ >
    implements ComparableLower, FoldingSetTrait.Profilable {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::EnvironmentEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 54,
   FQN="clang::ento::EnvironmentEntry::EnvironmentEntry", NM="_ZN5clang4ento16EnvironmentEntryC1EPKNS_4StmtEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento16EnvironmentEntryC1EPKNS_4StmtEPKNS_15LocationContextE")
  //</editor-fold>
  public EnvironmentEntry(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ L) {
    // : std::pair<const Stmt * , const StackFrameContext * >(ignoreTransparentExprs(S), L ? L->getCurrentStackFrame() : null) 
    //START JInit
    super(JD$T$RR_T1$RR.INSTANCE, ignoreTransparentExprs(S), 
        (L != null) ? L.getCurrentStackFrame() : (/*const*/ StackFrameContext /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 40,
   FQN="clang::ento::EnvironmentEntry::getStmt", NM="_ZNK5clang4ento16EnvironmentEntry7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento16EnvironmentEntry7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    return first;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::getLocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 41,
   FQN="clang::ento::EnvironmentEntry::getLocationContext", NM="_ZNK5clang4ento16EnvironmentEntry18getLocationContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento16EnvironmentEntry18getLocationContextEv")
  //</editor-fold>
  public /*const*/ LocationContext /*P*/ getLocationContext() /*const*/ {
    return second;
  }

  
  /// Profile an EnvironmentEntry for inclusion in a FoldingSet.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 44,
   FQN="clang::ento::EnvironmentEntry::Profile", NM="_ZN5clang4ento16EnvironmentEntry7ProfileERN4llvm16FoldingSetNodeIDERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento16EnvironmentEntry7ProfileERN4llvm16FoldingSetNodeIDERKS1_")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ EnvironmentEntry /*&*/ E) {
    ID.AddPointer(E.getStmt());
    ID.AddPointer(E.getLocationContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 50,
   FQN="clang::ento::EnvironmentEntry::Profile", NM="_ZNK5clang4ento16EnvironmentEntry7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZNK5clang4ento16EnvironmentEntry7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    Profile(ID, /*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::EnvironmentEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 35,
   FQN="clang::ento::EnvironmentEntry::EnvironmentEntry", NM="_ZN5clang4ento16EnvironmentEntryC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento16EnvironmentEntryC1EOS1_")
  //</editor-fold>
  public /*inline*/ EnvironmentEntry(JD$Move _dparam, final EnvironmentEntry /*&&*/$Prm0) {
    // : std::pair<const Stmt * , const StackFrameContext * >(static_cast<EnvironmentEntry &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::EnvironmentEntry::EnvironmentEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Environment.h", line = 35,
   FQN="clang::ento::EnvironmentEntry::EnvironmentEntry", NM="_ZN5clang4ento16EnvironmentEntryC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZN5clang4ento16EnvironmentEntryC1ERKS1_")
  //</editor-fold>
  public /*inline*/ EnvironmentEntry(final /*const*/ EnvironmentEntry /*&*/ $Prm0) {
    // : std::pair<const Stmt * , const StackFrameContext * >() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  @Override public EnvironmentEntry clone() { 
    return new EnvironmentEntry(this); 
  }

  @Override public EnvironmentEntry move() { 
    return new EnvironmentEntry(JD$Move.INSTANCE, this); 
  }

  @Override
  public boolean $less(Object obj) {
    EnvironmentEntry other = (EnvironmentEntry) obj;
    int hash1 = System.identityHashCode(this.first);
    int hash2 = System.identityHashCode(other.first);
    if (hash1 < hash2) {
      return true;
    }
    if (hash1 > hash2) {
      return false;
    }
    hash1 = System.identityHashCode(this.second);
    hash2 = System.identityHashCode(other.second);
    if (hash1 < hash2) {
      return true;
    }
    return false;
  }
  
  @Override public String toString() {
    StringBuilder out = new StringBuilder("{");
    out.append(NativeTrace.getIdentityStr(this.first));
    out.append("|");
    out.append(NativeTrace.getIdentityStr(this.second));
    out.append("}");
    return out.toString(); // NOI18N
  }
}
