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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::StmtPoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 262,
 FQN="clang::StmtPoint", NM="_ZN5clang9StmtPointE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang9StmtPointE")
//</editor-fold>
public class StmtPoint extends /*public*/ ProgramPoint {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::StmtPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 264,
   FQN="clang::StmtPoint::StmtPoint", NM="_ZN5clang9StmtPointC1EPKNS_4StmtEPKvNS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang9StmtPointC1EPKNS_4StmtEPKvNS_12ProgramPoint4KindEPKNS_15LocationContextEPKNS_15ProgramPointTagE")
  //</editor-fold>
  public StmtPoint(/*const*/ Stmt /*P*/ S, /*const*/Object/*void P*/ p2, ProgramPoint.Kind k, /*const*/ LocationContext /*P*/ L, 
      /*const*/ ProgramPointTag /*P*/ tag) {
    // : ProgramPoint(S, p2, k, L, tag) 
    //START JInit
    super(S, p2, k, L, tag);
    //END JInit
    assert Native.$bool(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::getStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 270,
   FQN="clang::StmtPoint::getStmt", NM="_ZNK5clang9StmtPoint7getStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZNK5clang9StmtPoint7getStmtEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getStmt() /*const*/ {
    return (/*const*/ Stmt /*P*/ )getData1();
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::getStmtAs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 273,
   FQN="clang::StmtPoint::getStmtAs", NM="Tpl__ZNK5clang9StmtPoint9getStmtAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=Tpl__ZNK5clang9StmtPoint9getStmtAsEv")
  //</editor-fold>
  public </*typename*/ T extends Stmt> /*const*/ T /*P*/ getStmtAs(Class<T> clazz) /*const*/ {
    return dyn_cast(clazz, getStmt());
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::StmtPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 276,
   FQN="clang::StmtPoint::StmtPoint", NM="_ZN5clang9StmtPointC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang9StmtPointC1Ev")
  //</editor-fold>
  /*friend*/protected/*protected*/ StmtPoint() {
    // : ProgramPoint() 
    //START JInit
    super();
    //END JInit
  }

/*private:*/
  /*friend  class ProgramPoint*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::isKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 279,
   FQN="clang::StmtPoint::isKind", NM="_ZN5clang9StmtPoint6isKindERKNS_12ProgramPointE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang9StmtPoint6isKindERKNS_12ProgramPointE")
  //</editor-fold>
  /*friend*/protected/*private*/ static boolean isKind(final /*const*/ ProgramPoint /*&*/ Location) {
    /*uint*/int k = Location.getKind().getValue();
    return $greatereq_uint(k, Kind.PreStmtKind.getValue()) && $lesseq_uint(k, Kind.MaxPostStmtKind.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::StmtPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 262,
   FQN="clang::StmtPoint::StmtPoint", NM="_ZN5clang9StmtPointC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang9StmtPointC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StmtPoint(final /*const*/ StmtPoint /*&*/ $Prm0) {
    // : ProgramPoint() 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtPoint::StmtPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/ProgramPoint.h", line = 262,
   FQN="clang::StmtPoint::StmtPoint", NM="_ZN5clang9StmtPointC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngine.cpp -nm=_ZN5clang9StmtPointC1EOS0_")
  //</editor-fold>
  public /*inline*/ StmtPoint(JD$Move _dparam, final StmtPoint /*&&*/$Prm0) {
    // : ProgramPoint(static_cast<StmtPoint &&>()) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override public StmtPoint clone() {
    assert this.getClass() == StmtPoint.class : "must be overridden in " + this.getClass();
    return new StmtPoint(this);
  }
  
  @Override public StmtPoint move() {
    assert this.getClass() == StmtPoint.class : "must be overridden in " + this.getClass();
    return new StmtPoint(JD$Move.INSTANCE, this);
  }
  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
    
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
