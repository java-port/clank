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


/// Represents a point after we ran remove dead bindings AFTER
/// processing the  given statement.
//<editor-fold defaultstate="collapsed" desc="clang::PostStmtPurgeDeadSymbols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 457,
 FQN="clang::PostStmtPurgeDeadSymbols", NM="_ZN5clang24PostStmtPurgeDeadSymbolsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang24PostStmtPurgeDeadSymbolsE")
//</editor-fold>
public class PostStmtPurgeDeadSymbols extends /*public*/ StmtPoint {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 459,
   FQN="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols", NM="_ZN5clang24PostStmtPurgeDeadSymbolsC1EPKNS_4StmtEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang24PostStmtPurgeDeadSymbolsC1EPKNS_4StmtEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public PostStmtPurgeDeadSymbols(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ L) {
    this(S, L, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public PostStmtPurgeDeadSymbols(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ L, 
      /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    // : StmtPoint(S, null, PostStmtPurgeDeadSymbolsKind, L, tag) 
    //START JInit
    super(S, (/*const*/Object/*void P*/ )null, Kind.PostStmtPurgeDeadSymbolsKind, L, tag);
    //END JInit
  }

/*private:*/
  /*friend  class ProgramPoint*/
  //<editor-fold defaultstate="collapsed" desc="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 465,
   FQN="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols", NM="_ZN5clang24PostStmtPurgeDeadSymbolsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang24PostStmtPurgeDeadSymbolsC1Ev")
  //</editor-fold>
  /*friend*/protected/*private*/ PostStmtPurgeDeadSymbols() {
    // : StmtPoint() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostStmtPurgeDeadSymbols::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 466,
   FQN="clang::PostStmtPurgeDeadSymbols::isKind", NM="_ZN5clang24PostStmtPurgeDeadSymbols6isKindERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang24PostStmtPurgeDeadSymbols6isKindERKNS_12ProgramPointE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ ProgramPoint /*&*/ Location) {
    return Location.getKind() == Kind.PostStmtPurgeDeadSymbolsKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 457,
   FQN="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols", NM="_ZN5clang24PostStmtPurgeDeadSymbolsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang24PostStmtPurgeDeadSymbolsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PostStmtPurgeDeadSymbols(final /*const*/ PostStmtPurgeDeadSymbols /*&*/ $Prm0) {
    // : StmtPoint() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 457,
   FQN="clang::PostStmtPurgeDeadSymbols::PostStmtPurgeDeadSymbols", NM="_ZN5clang24PostStmtPurgeDeadSymbolsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp -nm=_ZN5clang24PostStmtPurgeDeadSymbolsC1EOS0_")
  //</editor-fold>
  public /*inline*/ PostStmtPurgeDeadSymbols(JD$Move _dparam, final PostStmtPurgeDeadSymbols /*&&*/$Prm0) {
    // : StmtPoint(static_cast<PostStmtPurgeDeadSymbols &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public PostStmtPurgeDeadSymbols clone() {
    assert this.getClass() == PostStmtPurgeDeadSymbols.class : "must be overridden in " + this.getClass();
    return new PostStmtPurgeDeadSymbols(this);
  }
  
  @Override public PostStmtPurgeDeadSymbols move() {
    assert this.getClass() == PostStmtPurgeDeadSymbols.class : "must be overridden in " + this.getClass();
    return new PostStmtPurgeDeadSymbols(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
