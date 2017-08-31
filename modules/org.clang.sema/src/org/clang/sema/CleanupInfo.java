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

//<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 20,
 FQN="clang::CleanupInfo", NM="_ZN5clang11CleanupInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfoE")
//</editor-fold>
public class CleanupInfo {
  private boolean ExprNeedsCleanups/* = false*/;
  private boolean CleanupsHaveSideEffects/* = false*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::exprNeedsCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 25,
   FQN="clang::CleanupInfo::exprNeedsCleanups", NM="_ZNK5clang11CleanupInfo17exprNeedsCleanupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang11CleanupInfo17exprNeedsCleanupsEv")
  //</editor-fold>
  public boolean exprNeedsCleanups() /*const*/ {
    return ExprNeedsCleanups;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::cleanupsHaveSideEffects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 27,
   FQN="clang::CleanupInfo::cleanupsHaveSideEffects", NM="_ZNK5clang11CleanupInfo23cleanupsHaveSideEffectsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang11CleanupInfo23cleanupsHaveSideEffectsEv")
  //</editor-fold>
  public boolean cleanupsHaveSideEffects() /*const*/ {
    return CleanupsHaveSideEffects;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::setExprNeedsCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 29,
   FQN="clang::CleanupInfo::setExprNeedsCleanups", NM="_ZN5clang11CleanupInfo20setExprNeedsCleanupsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfo20setExprNeedsCleanupsEb")
  //</editor-fold>
  public void setExprNeedsCleanups(boolean SideEffects) {
    ExprNeedsCleanups = true;
    CleanupsHaveSideEffects |= SideEffects;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 34,
   FQN="clang::CleanupInfo::reset", NM="_ZN5clang11CleanupInfo5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfo5resetEv")
  //</editor-fold>
  public void reset() {
    ExprNeedsCleanups = false;
    CleanupsHaveSideEffects = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::mergeFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 39,
   FQN="clang::CleanupInfo::mergeFrom", NM="_ZN5clang11CleanupInfo9mergeFromES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfo9mergeFromES0_")
  //</editor-fold>
  public void mergeFrom(CleanupInfo Rhs) {
    ExprNeedsCleanups |= Rhs.ExprNeedsCleanups;
    CleanupsHaveSideEffects |= Rhs.CleanupsHaveSideEffects;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::CleanupInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 20,
   FQN="clang::CleanupInfo::CleanupInfo", NM="_ZN5clang11CleanupInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CleanupInfo(final /*const*/ CleanupInfo /*&*/ $Prm0) {
    // : ExprNeedsCleanups(.ExprNeedsCleanups), CleanupsHaveSideEffects(.CleanupsHaveSideEffects) 
    //START JInit
    this.ExprNeedsCleanups = $Prm0.ExprNeedsCleanups;
    this.CleanupsHaveSideEffects = $Prm0.CleanupsHaveSideEffects;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::CleanupInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 20,
   FQN="clang::CleanupInfo::CleanupInfo", NM="_ZN5clang11CleanupInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ CleanupInfo(JD$Move _dparam, final CleanupInfo /*&&*/$Prm0) {
    // : ExprNeedsCleanups(static_cast<CleanupInfo &&>().ExprNeedsCleanups), CleanupsHaveSideEffects(static_cast<CleanupInfo &&>().CleanupsHaveSideEffects) 
    //START JInit
    this.ExprNeedsCleanups = $Prm0.ExprNeedsCleanups;
    this.CleanupsHaveSideEffects = $Prm0.CleanupsHaveSideEffects;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::CleanupInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 20,
   FQN="clang::CleanupInfo::CleanupInfo", NM="_ZN5clang11CleanupInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfoC1Ev")
  //</editor-fold>
  public /*inline*/ CleanupInfo() {
    // : ExprNeedsCleanups(false), CleanupsHaveSideEffects(false) 
    //START JInit
    /*InClass*/this.ExprNeedsCleanups = false;
    /*InClass*/this.CleanupsHaveSideEffects = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CleanupInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CleanupInfo.h", line = 20,
   FQN="clang::CleanupInfo::operator=", NM="_ZN5clang11CleanupInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang11CleanupInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ CleanupInfo /*&*/ $assign(final /*const*/ CleanupInfo /*&*/ $Prm0) {
    this.ExprNeedsCleanups = $Prm0.ExprNeedsCleanups;
    this.CleanupsHaveSideEffects = $Prm0.CleanupsHaveSideEffects;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "ExprNeedsCleanups=" + ExprNeedsCleanups // NOI18N
              + ", CleanupsHaveSideEffects=" + CleanupsHaveSideEffects; // NOI18N
  }
}
