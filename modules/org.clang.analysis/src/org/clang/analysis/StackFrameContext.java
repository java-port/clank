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

//<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 278,
 FQN="clang::StackFrameContext", NM="_ZN5clang17StackFrameContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang17StackFrameContextE")
//</editor-fold>
public class StackFrameContext extends /*public*/ LocationContext implements Destructors.ClassWithDestructor {
  // The callsite where this stack frame is established.
  private /*const*/ Stmt /*P*/ CallSite;
  
  // The parent block of the callsite.
  private /*const*/ CFGBlock /*P*/ Block;
  
  // The index of the callsite in the CFGBlock.
  private /*uint*/int Index;
  
  /*friend  class LocationContextManager*/
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::StackFrameContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 289,
   FQN="clang::StackFrameContext::StackFrameContext", NM="_ZN5clang17StackFrameContextC1EPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang17StackFrameContextC1EPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj")
  //</editor-fold>
  /*friend*/protected/*private*/ StackFrameContext(AnalysisDeclContext /*P*/ ctx, /*const*/ LocationContext /*P*/ parent, 
      /*const*/ Stmt /*P*/ s, /*const*/ CFGBlock /*P*/ blk, 
      /*uint*/int idx) {
    // : LocationContext(StackFrame, ctx, parent), CallSite(s), Block(blk), Index(idx) 
    //START JInit
    super(ContextKind.StackFrame, ctx, parent);
    this.CallSite = s;
    this.Block = blk;
    this.Index = idx;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::~StackFrameContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 296,
   FQN="clang::StackFrameContext::~StackFrameContext", NM="_ZN5clang17StackFrameContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang17StackFrameContextD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::getCallSite">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 298,
   FQN="clang::StackFrameContext::getCallSite", NM="_ZNK5clang17StackFrameContext11getCallSiteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang17StackFrameContext11getCallSiteEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getCallSite() /*const*/ {
    return CallSite;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::getCallSiteBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 300,
   FQN="clang::StackFrameContext::getCallSiteBlock", NM="_ZNK5clang17StackFrameContext16getCallSiteBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang17StackFrameContext16getCallSiteBlockEv")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getCallSiteBlock() /*const*/ {
    return Block;
  }

  
  /// Return true if the current LocationContext has no caller context.
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::inTopFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 303,
   FQN="clang::StackFrameContext::inTopFrame", NM="_ZNK5clang17StackFrameContext10inTopFrameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang17StackFrameContext10inTopFrameEv")
  //</editor-fold>
  @Override public boolean inTopFrame() /*const*//* override*/ {
    return getParent() == null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 305,
   FQN="clang::StackFrameContext::getIndex", NM="_ZNK5clang17StackFrameContext8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang17StackFrameContext8getIndexEv")
  //</editor-fold>
  public /*uint*/int getIndex() /*const*/ {
    return Index;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 366,
   FQN="clang::StackFrameContext::Profile", NM="_ZN5clang17StackFrameContext7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang17StackFrameContext7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID)/* override*/ {
    Profile(ID, getAnalysisDeclContext(), getParent(), CallSite, Block, Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 309,
   FQN="clang::StackFrameContext::Profile", NM="_ZN5clang17StackFrameContext7ProfileERN4llvm16FoldingSetNodeIDEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang17StackFrameContext7ProfileERN4llvm16FoldingSetNodeIDEPNS_19AnalysisDeclContextEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, AnalysisDeclContext /*P*/ ctx, 
         /*const*/ LocationContext /*P*/ parent, /*const*/ Stmt /*P*/ s, 
         /*const*/ CFGBlock /*P*/ blk, /*uint*/int idx) {
    ProfileCommon(ID, ContextKind.StackFrame, ctx, parent, s);
    ID.AddPointer(blk);
    ID.AddInteger_uint(idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StackFrameContext::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 317,
   FQN="clang::StackFrameContext::classof", NM="_ZN5clang17StackFrameContext7classofEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang17StackFrameContext7classofEPKNS_15LocationContextE")
  //</editor-fold>
  public static boolean classof(/*const*/ LocationContext /*P*/ Ctx) {
    return Ctx.getKind() == ContextKind.StackFrame;
  }

  
  @Override public String toString() {
    return "" + "CallSite=" + CallSite // NOI18N
              + ", Block=" + Block // NOI18N
              + ", Index=" + Index // NOI18N
              + ", " + super.toString(); // NOI18N
  }
}
