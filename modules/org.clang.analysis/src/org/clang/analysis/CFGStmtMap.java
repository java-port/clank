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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::CFGStmtMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFGStmtMap.h", line = 27,
 FQN="clang::CFGStmtMap", NM="_ZN5clang10CFGStmtMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZN5clang10CFGStmtMapE")
//</editor-fold>
public class CFGStmtMap implements Destructors.ClassWithDestructor {
  private ParentMap /*P*/ PM;
  private Object/*void P*/ M;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGStmtMap::CFGStmtMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFGStmtMap.h", line = 31,
   FQN="clang::CFGStmtMap::CFGStmtMap", NM="_ZN5clang10CFGStmtMapC1EPNS_9ParentMapEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZN5clang10CFGStmtMapC1EPNS_9ParentMapEPv")
  //</editor-fold>
  private CFGStmtMap(ParentMap /*P*/ pm, Object/*void P*/ m) {
    // : PM(pm), M(m) 
    //START JInit
    this.PM = pm;
    this.M = m;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGStmtMap::~CFGStmtMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp", line = 25,
   FQN="clang::CFGStmtMap::~CFGStmtMap", NM="_ZN5clang10CFGStmtMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZN5clang10CFGStmtMapD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (CFGStmtMapStatics.AsMap(M) != null) { CFGStmtMapStatics.AsMap(M).$destroy();};
  }

  
  /// Returns a new CFGMap for the given CFG.  It is the caller's
  /// responsibility to 'delete' this object when done using it.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGStmtMap::Build">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp", line = 78,
   FQN="clang::CFGStmtMap::Build", NM="_ZN5clang10CFGStmtMap5BuildEPNS_3CFGEPNS_9ParentMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZN5clang10CFGStmtMap5BuildEPNS_3CFGEPNS_9ParentMapE")
  //</editor-fold>
  public static CFGStmtMap /*P*/ Build(CFG /*P*/ C, ParentMap /*P*/ PM) {
    if (!(C != null) || !(PM != null)) {
      return null;
    }
    
    DenseMap</*const*/ Stmt /*P*/ , CFGBlock /*P*/ > /*P*/ SM = new DenseMap</*const*/ Stmt /*P*/ , CFGBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CFGBlock /*P*/ )null);
    
    // Walk all blocks, accumulating the block-level expressions, labels,
    // and terminators.  
    for (type$ptr<CFGBlock> I = $tryClone(C.begin()), /*P*/ E = $tryClone(C.end()); $noteq_ptr(I, E); I.$preInc())  {
      CFGStmtMapStatics.Accumulate($Deref(SM), I.$star());
    }
    
    return new CFGStmtMap(PM, SM);
  }

  
  /// Returns the CFGBlock the specified Stmt* appears in.  For Stmt* that
  /// are terminators, the CFGBlock is the block they appear as a terminator,
  /// and not the block they appear as a block-level expression (e.g, '&&').
  /// CaseStmts and LabelStmts map to the CFGBlock they label.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGStmtMap::getBlock">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp", line = 27,
   FQN="clang::CFGStmtMap::getBlock", NM="_ZN5clang10CFGStmtMap8getBlockEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZN5clang10CFGStmtMap8getBlockEPNS_4StmtE")
  //</editor-fold>
  public CFGBlock /*P*/ getBlock_Stmt$P(Stmt /*P*/ S) {
    DenseMap</*const*/ Stmt /*P*/ , CFGBlock /*P*/ > /*P*/ SM = CFGStmtMapStatics.AsMap(M);
    Stmt /*P*/ X = S;
    
    // If 'S' isn't in the map, walk the ParentMap to see if one of its ancestors
    // is in the map.
    while ((X != null)) {
      DenseMapIterator</*const*/ Stmt /*P*/ , CFGBlock /*P*/ > I = SM.find(X);
      if (I.$noteq(/*NO_ITER_COPY*/SM.end())) {
        CFGBlock /*P*/ B = I.$arrow().second;
        // Memoize this lookup.
        if (X != S) {
          ($Deref(SM)).$set(X, B);
        }
        return B;
      }
      
      X = PM.getParentIgnoreParens_Stmt$P(X);
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGStmtMap::getBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFGStmtMap.h", line = 46,
   FQN="clang::CFGStmtMap::getBlock", NM="_ZNK5clang10CFGStmtMap8getBlockEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGStmtMap.cpp -nm=_ZNK5clang10CFGStmtMap8getBlockEPKNS_4StmtE")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getBlock_Stmt$C$P$Const(/*const*/ Stmt /*P*/ S) /*const*/ {
    return ((/*const_cast*/CFGStmtMap /*P*/ )(this)).getBlock_Stmt$P(((/*const_cast*/Stmt /*P*/ )(S)));
  }

  
  @Override public String toString() {
    return "" + "PM=" + PM // NOI18N
              + ", M=" + M; // NOI18N
  }
}
