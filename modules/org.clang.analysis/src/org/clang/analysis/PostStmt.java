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
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::PostStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 302,
 FQN="clang::PostStmt", NM="_ZN5clang8PostStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtE")
//</editor-fold>
public class PostStmt extends /*public*/ StmtPoint {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::PostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 304,
   FQN="clang::PostStmt::PostStmt", NM="_ZN5clang8PostStmtC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtC1Ev")
  //</editor-fold>
  /*friend*/protected/*protected*/ PostStmt() {
    // : StmtPoint() 
    //START JInit
    super();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::PostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 305,
   FQN="clang::PostStmt::PostStmt", NM="_ZN5clang8PostStmtC1EPKNS_4StmtEPKvNS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtC1EPKNS_4StmtEPKvNS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  protected PostStmt(/*const*/ Stmt /*P*/ S, /*const*/Object/*void P*/ data, ProgramPoint.Kind k, /*const*/ LocationContext /*P*/ L) {
    this(S, data, k, L, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  protected PostStmt(/*const*/ Stmt /*P*/ S, /*const*/Object/*void P*/ data, ProgramPoint.Kind k, /*const*/ LocationContext /*P*/ L, 
      /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    // : StmtPoint(S, data, k, L, tag) 
    //START JInit
    super(S, data, k, L, tag);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::PostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 310,
   FQN="clang::PostStmt::PostStmt", NM="_ZN5clang8PostStmtC1EPKNS_4StmtENS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtC1EPKNS_4StmtENS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public /*explicit*/ PostStmt(/*const*/ Stmt /*P*/ S, ProgramPoint.Kind k, /*const*/ LocationContext /*P*/ L) {
    this(S, k, L, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public /*explicit*/ PostStmt(/*const*/ Stmt /*P*/ S, ProgramPoint.Kind k, /*const*/ LocationContext /*P*/ L, 
      /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    // : StmtPoint(S, null, k, L, tag) 
    //START JInit
    super(S, (/*const*/Object/*void P*/ )null, k, L, tag);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::PostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 314,
   FQN="clang::PostStmt::PostStmt", NM="_ZN5clang8PostStmtC1EPKNS_4StmtEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtC1EPKNS_4StmtEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public /*explicit*/ PostStmt(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ L) {
    this(S, L, 
      (/*const*/ ProgramPointTag /*P*/ )null);
  }
  public /*explicit*/ PostStmt(/*const*/ Stmt /*P*/ S, /*const*/ LocationContext /*P*/ L, 
      /*const*/ ProgramPointTag /*P*/ tag/*= null*/) {
    // : StmtPoint(S, null, PostStmtKind, L, tag) 
    //START JInit
    super(S, (/*const*/Object/*void P*/ )null, Kind.PostStmtKind, L, tag);
    //END JInit
  }

/*private:*/
  /*friend  class ProgramPoint*/
  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 320,
   FQN="clang::PostStmt::isKind", NM="_ZN5clang8PostStmt6isKindERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmt6isKindERKNS_12ProgramPointE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ ProgramPoint /*&*/ Location) {
    /*uint*/int k = Location.getKind().getValue();
    return $greatereq_uint(k, Kind.MinPostStmtKind.getValue()) && $lesseq_uint(k, Kind.MaxPostStmtKind.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::PostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 302,
   FQN="clang::PostStmt::PostStmt", NM="_ZN5clang8PostStmtC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtC1ERKS0_")
  //</editor-fold>
  public /*inline*/ PostStmt(final /*const*/ PostStmt /*&*/ $Prm0) {
    // : StmtPoint() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PostStmt::PostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 302,
   FQN="clang::PostStmt::PostStmt", NM="_ZN5clang8PostStmtC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang8PostStmtC1EOS0_")
  //</editor-fold>
  public /*inline*/ PostStmt(JD$Move _dparam, final PostStmt /*&&*/$Prm0) {
    // : StmtPoint(static_cast<PostStmt &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public PostStmt clone() {
    assert this.getClass() == PostStmt.class : "must be overridden in " + this.getClass();
    return new PostStmt(this);
  }
  
  @Override public PostStmt move() {
    assert this.getClass() == PostStmt.class : "must be overridden in " + this.getClass();
    return new PostStmt(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
