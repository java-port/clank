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

package org.clang.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// Represents a program point just before an implicit call event.
///
/// Explicit calls will appear as PreStmt program points.
//<editor-fold defaultstate="collapsed" desc="clang::PreImplicitCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 551,
 FQN="clang::PreImplicitCall", NM="_ZN5clang15PreImplicitCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang15PreImplicitCallE")
//</editor-fold>
public class PreImplicitCall extends /*public*/ ImplicitCallPoint {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreImplicitCall::PreImplicitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 553,
   FQN="clang::PreImplicitCall::PreImplicitCall", NM="_ZN5clang15PreImplicitCallC1EPKNS_4DeclENS_14SourceLocationEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang15PreImplicitCallC1EPKNS_4DeclENS_14SourceLocationEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public PreImplicitCall(/*const*/ Decl /*P*/ D, SourceLocation Loc, /*const*/ LocationContext /*P*/ L) {
    this(D, Loc, L, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public PreImplicitCall(/*const*/ Decl /*P*/ D, SourceLocation Loc, /*const*/ LocationContext /*P*/ L, 
      /*const*/ ProgramPointTag /*P*/ Tag/*= null*/) {
    // : ImplicitCallPoint(D, Loc, PreImplicitCallKind, L, Tag) 
    //START JInit
    super(D, new SourceLocation(Loc), Kind.PreImplicitCallKind, L, Tag);
    //END JInit
  }

/*private:*/
  /*friend  class ProgramPoint*/
  //<editor-fold defaultstate="collapsed" desc="clang::PreImplicitCall::PreImplicitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 559,
   FQN="clang::PreImplicitCall::PreImplicitCall", NM="_ZN5clang15PreImplicitCallC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang15PreImplicitCallC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ PreImplicitCall() {
    // : ImplicitCallPoint() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreImplicitCall::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 560,
   FQN="clang::PreImplicitCall::isKind", NM="_ZN5clang15PreImplicitCall6isKindERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang15PreImplicitCall6isKindERKNS_12ProgramPointE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ ProgramPoint /*&*/ Location) {
    return Location.getKind() == Kind.PreImplicitCallKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreImplicitCall::PreImplicitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 551,
   FQN="clang::PreImplicitCall::PreImplicitCall", NM="_ZN5clang15PreImplicitCallC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang15PreImplicitCallC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PreImplicitCall(final /*const*/ PreImplicitCall /*&*/ $Prm0) {
    // : ImplicitCallPoint() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreImplicitCall::PreImplicitCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 551,
   FQN="clang::PreImplicitCall::PreImplicitCall", NM="_ZN5clang15PreImplicitCallC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang15PreImplicitCallC1EOS0_")
  //</editor-fold>
  public /*inline*/ PreImplicitCall(JD$Move _dparam, final PreImplicitCall /*&&*/$Prm0) {
    // : ImplicitCallPoint(static_cast<PreImplicitCall &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public PreImplicitCall clone() {
    assert this.getClass() == PreImplicitCall.class : "must be overridden in " + this.getClass();
    return new PreImplicitCall(this);
  }
  
  @Override public PreImplicitCall move() {
    assert this.getClass() == PreImplicitCall.class : "must be overridden in " + this.getClass();
    return new PreImplicitCall(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
