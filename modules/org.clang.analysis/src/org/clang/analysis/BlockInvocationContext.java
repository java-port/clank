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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;

//<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 345,
 FQN="clang::BlockInvocationContext", NM="_ZN5clang22BlockInvocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22BlockInvocationContextE")
//</editor-fold>
public class BlockInvocationContext extends /*public*/ LocationContext implements Destructors.ClassWithDestructor {
  private /*const*/ BlockDecl /*P*/ BD;
  
  // FIXME: Come up with a more type-safe way to model context-sensitivity.
  private /*const*/Object/*void P*/ ContextData;
  
  /*friend  class LocationContextManager*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::BlockInvocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 353,
   FQN="clang::BlockInvocationContext::BlockInvocationContext", NM="_ZN5clang22BlockInvocationContextC1EPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22BlockInvocationContextC1EPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv")
  //</editor-fold>
  /*friend*/protected/*private*/ BlockInvocationContext(AnalysisDeclContext /*P*/ ctx, 
      /*const*/ LocationContext /*P*/ parent, 
      /*const*/ BlockDecl /*P*/ bd, /*const*/Object/*void P*/ contextData) {
    // : LocationContext(Block, ctx, parent), BD(bd), ContextData(contextData) 
    //START JInit
    super(ContextKind.Block, ctx, parent);
    this.BD = bd;
    this.ContextData = contextData;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::~BlockInvocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 359,
   FQN="clang::BlockInvocationContext::~BlockInvocationContext", NM="_ZN5clang22BlockInvocationContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22BlockInvocationContextD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::getBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 361,
   FQN="clang::BlockInvocationContext::getBlockDecl", NM="_ZNK5clang22BlockInvocationContext12getBlockDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang22BlockInvocationContext12getBlockDeclEv")
  //</editor-fold>
  public /*const*/ BlockDecl /*P*/ getBlockDecl() /*const*/ {
    return BD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::getContextData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 363,
   FQN="clang::BlockInvocationContext::getContextData", NM="_ZNK5clang22BlockInvocationContext14getContextDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang22BlockInvocationContext14getContextDataEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getContextData() /*const*/ {
    return ContextData;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 374,
   FQN="clang::BlockInvocationContext::Profile", NM="_ZN5clang22BlockInvocationContext7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22BlockInvocationContext7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID)/* override*/ {
    Profile(ID, getAnalysisDeclContext(), getParent(), BD, ContextData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 367,
   FQN="clang::BlockInvocationContext::Profile", NM="_ZN5clang22BlockInvocationContext7ProfileERN4llvm16FoldingSetNodeIDEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22BlockInvocationContext7ProfileERN4llvm16FoldingSetNodeIDEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, AnalysisDeclContext /*P*/ ctx, 
         /*const*/ LocationContext /*P*/ parent, /*const*/ BlockDecl /*P*/ bd, 
         /*const*/Object/*void P*/ contextData) {
    ProfileCommon(ID, ContextKind.Block, ctx, parent, bd);
    ID.AddPointer(contextData);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BlockInvocationContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 374,
   FQN="clang::BlockInvocationContext::classof", NM="_ZN5clang22BlockInvocationContext7classofEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang22BlockInvocationContext7classofEPKNS_15LocationContextE")
  //</editor-fold>
  public static boolean classof(/*const*/ LocationContext /*P*/ Ctx) {
    return Ctx.getKind() == ContextKind.Block;
  }

  
  @Override public String toString() {
    return "" + "BD=" + BD // NOI18N
              + ", ContextData=" + ContextData // NOI18N
              + super.toString(); // NOI18N
  }
}
