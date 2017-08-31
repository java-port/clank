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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::sema::PossiblyUnreachableDiag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 68,
 FQN="clang::sema::PossiblyUnreachableDiag", NM="_ZN5clang4sema23PossiblyUnreachableDiagE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema23PossiblyUnreachableDiagE")
//</editor-fold>
public class PossiblyUnreachableDiag implements Destructors.ClassWithDestructor, NativeMoveable<PossiblyUnreachableDiag>, NativeCloneable<PossiblyUnreachableDiag>, Native.assignable<PossiblyUnreachableDiag> {
/*public:*/
  public PartialDiagnostic PD;
  public SourceLocation Loc;
  public /*const*/ Stmt /*P*/ stmt;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::PossiblyUnreachableDiag::PossiblyUnreachableDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 74,
   FQN="clang::sema::PossiblyUnreachableDiag::PossiblyUnreachableDiag", NM="_ZN5clang4sema23PossiblyUnreachableDiagC1ERKNS_17PartialDiagnosticENS_14SourceLocationEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema23PossiblyUnreachableDiagC1ERKNS_17PartialDiagnosticENS_14SourceLocationEPKNS_4StmtE")
  //</editor-fold>
  public PossiblyUnreachableDiag(final /*const*/ PartialDiagnostic /*&*/ PD, SourceLocation Loc, 
      /*const*/ Stmt /*P*/ stmt) {
    // : PD(PD), Loc(Loc), stmt(stmt) 
    //START JInit
    this.PD = new PartialDiagnostic(PD);
    this.Loc = new SourceLocation(Loc);
    this.stmt = stmt;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::PossiblyUnreachableDiag::PossiblyUnreachableDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 68,
   FQN="clang::sema::PossiblyUnreachableDiag::PossiblyUnreachableDiag", NM="_ZN5clang4sema23PossiblyUnreachableDiagC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema23PossiblyUnreachableDiagC1ERKS1_")
  //</editor-fold>
  public /*inline*/ PossiblyUnreachableDiag(final /*const*/ PossiblyUnreachableDiag /*&*/ $Prm0) {
    // : PD(.PD), Loc(.Loc), stmt(.stmt) 
    //START JInit
    this.PD = new PartialDiagnostic($Prm0.PD);
    this.Loc = new SourceLocation($Prm0.Loc);
    this.stmt = $Prm0.stmt;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::PossiblyUnreachableDiag::PossiblyUnreachableDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 68,
   FQN="clang::sema::PossiblyUnreachableDiag::PossiblyUnreachableDiag", NM="_ZN5clang4sema23PossiblyUnreachableDiagC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema23PossiblyUnreachableDiagC1EOS1_")
  //</editor-fold>
  public /*inline*/ PossiblyUnreachableDiag(JD$Move _dparam, final PossiblyUnreachableDiag /*&&*/$Prm0) {
    // : PD(static_cast<PossiblyUnreachableDiag &&>().PD), Loc(static_cast<PossiblyUnreachableDiag &&>().Loc), stmt(static_cast<PossiblyUnreachableDiag &&>().stmt) 
    //START JInit
    this.PD = new PartialDiagnostic(JD$Move.INSTANCE, $Prm0.PD);
    this.Loc = new SourceLocation(JD$Move.INSTANCE, $Prm0.Loc);
    this.stmt = $Prm0.stmt;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::PossiblyUnreachableDiag::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 68,
   FQN="clang::sema::PossiblyUnreachableDiag::operator=", NM="_ZN5clang4sema23PossiblyUnreachableDiagaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema23PossiblyUnreachableDiagaSERKS1_")
  //</editor-fold>
  public /*inline*/ PossiblyUnreachableDiag /*&*/ $assign(final /*const*/ PossiblyUnreachableDiag /*&*/ $Prm0) {
    this.PD.$assign($Prm0.PD);
    this.Loc.$assign($Prm0.Loc);
    this.stmt = $Prm0.stmt;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::PossiblyUnreachableDiag::~PossiblyUnreachableDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 68,
   FQN="clang::sema::PossiblyUnreachableDiag::~PossiblyUnreachableDiag", NM="_ZN5clang4sema23PossiblyUnreachableDiagD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema23PossiblyUnreachableDiagD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    PD.$destroy();
    //END JDestroy
  }

  public PossiblyUnreachableDiag() {
    this.PD = new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic());
    this.Loc = new SourceLocation();
    this.stmt = null;
  }
  
  @Override public PossiblyUnreachableDiag clone() {
    return new PossiblyUnreachableDiag(this);
  }

  @Override public /*inline*/ PossiblyUnreachableDiag /*&*/ $assignMove(final /*const*/ PossiblyUnreachableDiag /*&*/ $Prm0) {
    this.PD.$assignMove($Prm0.PD);
    this.Loc.$assignMove($Prm0.Loc);
    this.stmt = $Prm0.stmt;
    return /*Deref*/this;
  }
  
  @Override public PossiblyUnreachableDiag move() {
    return new PossiblyUnreachableDiag(JD$Move.INSTANCE, this);
  }
    
  @Override public String toString() {
    return "" + "PD=" + "[PartialDiagnostic]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", stmt=" + stmt; // NOI18N
  }
}
