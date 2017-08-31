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
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.support.*;
import static org.clang.analysis.impl.AnalysisDeclContextStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// AnalysisDeclContext contains the context data for the function or method
/// under analysis.
//<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 66,
 FQN="clang::AnalysisDeclContext", NM="_ZN5clang19AnalysisDeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContextE")
//</editor-fold>
public class AnalysisDeclContext implements Destructors.ClassWithDestructor {
  /// Backpoint to the AnalysisManager object that created this
  /// AnalysisDeclContext. This may be null.
  private AnalysisDeclContextManager /*P*/ Manager;
  
  private /*const*/ Decl /*P*/ /*const*/ D;
  
  private std.unique_ptr<CFG> cfg;
  
  private std.unique_ptr<CFG> completeCFG;
  private std.unique_ptr<CFGStmtMap> cfgStmtMap;
  
  private CFG.BuildOptions cfgBuildOptions;
  private DenseMap</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > /*P*/ forcedBlkExprs;
  
  private boolean builtCFG;
  
  private boolean builtCompleteCFG;
  private std.unique_ptr<ParentMap> PM;
  private std.unique_ptr<PseudoConstantAnalysis> PCA;
  private std.unique_ptr<CFGReverseBlockReachabilityAnalysis> CFA;
  
  private BumpPtrAllocatorImpl A;
  
  private DenseMap</*const*/ BlockDecl /*P*/ , Object/*void P*/ > /*P*/ ReferencedBlockVars;
  
  private Object/*void P*/ ManagedAnalyses;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::AnalysisDeclContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 53,
   FQN="clang::AnalysisDeclContext::AnalysisDeclContext", NM="_ZN5clang19AnalysisDeclContextC1EPNS_26AnalysisDeclContextManagerEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContextC1EPNS_26AnalysisDeclContextManagerEPKNS_4DeclE")
  //</editor-fold>
  public AnalysisDeclContext(AnalysisDeclContextManager /*P*/ Mgr, 
      /*const*/ Decl /*P*/ d) {
    // : Manager(Mgr), D(d), cfg(), completeCFG(), cfgStmtMap(), cfgBuildOptions(), forcedBlkExprs(null), builtCFG(false), builtCompleteCFG(false), PM(), PCA(), CFA(), A(), ReferencedBlockVars(null), ManagedAnalyses(null) 
    //START JInit
    this.Manager = Mgr;
    this.D = d;
    this.cfg = new std.unique_ptr<CFG>();
    this.completeCFG = new std.unique_ptr<CFG>();
    this.cfgStmtMap = new std.unique_ptr<CFGStmtMap>();
    this.cfgBuildOptions = new CFG.BuildOptions();
    this.forcedBlkExprs = null;
    this.builtCFG = false;
    this.builtCompleteCFG = false;
    this.PM = new std.unique_ptr<ParentMap>();
    this.PCA = new std.unique_ptr<PseudoConstantAnalysis>();
    this.CFA = new std.unique_ptr<CFGReverseBlockReachabilityAnalysis>();
    this.A = new BumpPtrAllocatorImpl();
    this.ReferencedBlockVars = null;
    this.ManagedAnalyses = null;
    //END JInit
    cfgBuildOptions.forcedBlkExprs = create_type$ptr2FieldT(this, ()->forcedBlkExprs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::AnalysisDeclContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 38,
   FQN="clang::AnalysisDeclContext::AnalysisDeclContext", NM="_ZN5clang19AnalysisDeclContextC1EPNS_26AnalysisDeclContextManagerEPKNS_4DeclERKNS_3CFG12BuildOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContextC1EPNS_26AnalysisDeclContextManagerEPKNS_4DeclERKNS_3CFG12BuildOptionsE")
  //</editor-fold>
  public AnalysisDeclContext(AnalysisDeclContextManager /*P*/ Mgr, 
      /*const*/ Decl /*P*/ d, 
      final /*const*/ CFG.BuildOptions /*&*/ buildOptions) {
    // : Manager(Mgr), D(d), cfg(), completeCFG(), cfgStmtMap(), cfgBuildOptions(buildOptions), forcedBlkExprs(null), builtCFG(false), builtCompleteCFG(false), PM(), PCA(), CFA(), A(), ReferencedBlockVars(null), ManagedAnalyses(null) 
    //START JInit
    this.Manager = Mgr;
    this.D = d;
    this.cfg = new std.unique_ptr<CFG>();
    this.completeCFG = new std.unique_ptr<CFG>();
    this.cfgStmtMap = new std.unique_ptr<CFGStmtMap>();
    this.cfgBuildOptions = new CFG.BuildOptions(buildOptions);
    this.forcedBlkExprs = null;
    this.builtCFG = false;
    this.builtCompleteCFG = false;
    this.PM = new std.unique_ptr<ParentMap>();
    this.PCA = new std.unique_ptr<PseudoConstantAnalysis>();
    this.CFA = new std.unique_ptr<CFGReverseBlockReachabilityAnalysis>();
    this.A = new BumpPtrAllocatorImpl();
    this.ReferencedBlockVars = null;
    this.ManagedAnalyses = null;
    //END JInit
    cfgBuildOptions.forcedBlkExprs = create_type$ptr2FieldT(this, ()->forcedBlkExprs);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::~AnalysisDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 598,
   FQN="clang::AnalysisDeclContext::~AnalysisDeclContext", NM="_ZN5clang19AnalysisDeclContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (forcedBlkExprs != null) { forcedBlkExprs.$destroy();};
    if (ReferencedBlockVars != null) { ReferencedBlockVars.$destroy();};
    // Release the managed analyses.
    if ((ManagedAnalyses != null)) {
      DenseMap</*const*/Object/*void P*/, ManagedAnalysis /*P*/ > /*P*/ M = (DenseMap</*const*/Object/*void P*/, ManagedAnalysis /*P*/ > /*P*/)ManagedAnalyses;
      llvm.DeleteContainerSeconds($Deref(M));
      if (M != null) { M.$destroy();};
    }
    //START JDestroy
    A.$destroy();
    CFA.$destroy();
    PCA.$destroy();
    PM.$destroy();
    cfgStmtMap.$destroy();
    completeCFG.$destroy();
    cfg.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 100,
   FQN="clang::AnalysisDeclContext::getASTContext", NM="_ZNK5clang19AnalysisDeclContext13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() /*const*/ {
    return D.getASTContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 101,
   FQN="clang::AnalysisDeclContext::getDecl", NM="_ZNK5clang19AnalysisDeclContext7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext7getDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getDecl() /*const*/ {
    return D;
  }

  
  /// Return the AnalysisDeclContextManager (if any) that created
  /// this AnalysisDeclContext.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 105,
   FQN="clang::AnalysisDeclContext::getManager", NM="_ZNK5clang19AnalysisDeclContext10getManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext10getManagerEv")
  //</editor-fold>
  public AnalysisDeclContextManager /*P*/ getManager() /*const*/ {
    return Manager;
  }

  
  /// Return the build options used to construct the CFG.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getCFGBuildOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 110,
   FQN="clang::AnalysisDeclContext::getCFGBuildOptions", NM="_ZN5clang19AnalysisDeclContext18getCFGBuildOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext18getCFGBuildOptionsEv")
  //</editor-fold>
  public CFG.BuildOptions /*&*/ getCFGBuildOptions() {
    return cfgBuildOptions;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getCFGBuildOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 114,
   FQN="clang::AnalysisDeclContext::getCFGBuildOptions", NM="_ZNK5clang19AnalysisDeclContext18getCFGBuildOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext18getCFGBuildOptionsEv")
  //</editor-fold>
  public /*const*/ CFG.BuildOptions /*&*/ getCFGBuildOptions$Const() /*const*/ {
    return cfgBuildOptions;
  }

  
  /// getAddEHEdges - Return true iff we are adding exceptional edges from
  /// callExprs.  If this is false, then try/catch statements and blocks
  /// reachable from them can appear to be dead in the CFG, analysis passes must
  /// cope with that.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getAddEHEdges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 122,
   FQN="clang::AnalysisDeclContext::getAddEHEdges", NM="_ZNK5clang19AnalysisDeclContext13getAddEHEdgesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext13getAddEHEdgesEv")
  //</editor-fold>
  public boolean getAddEHEdges() /*const*/ {
    return cfgBuildOptions.AddEHEdges;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getUseUnoptimizedCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 123,
   FQN="clang::AnalysisDeclContext::getUseUnoptimizedCFG", NM="_ZNK5clang19AnalysisDeclContext20getUseUnoptimizedCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext20getUseUnoptimizedCFGEv")
  //</editor-fold>
  public boolean getUseUnoptimizedCFG() /*const*/ {
    return !cfgBuildOptions.PruneTriviallyFalseEdges;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getAddImplicitDtors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 126,
   FQN="clang::AnalysisDeclContext::getAddImplicitDtors", NM="_ZNK5clang19AnalysisDeclContext19getAddImplicitDtorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext19getAddImplicitDtorsEv")
  //</editor-fold>
  public boolean getAddImplicitDtors() /*const*/ {
    return cfgBuildOptions.AddImplicitDtors;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getAddInitializers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 127,
   FQN="clang::AnalysisDeclContext::getAddInitializers", NM="_ZNK5clang19AnalysisDeclContext18getAddInitializersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext18getAddInitializersEv")
  //</editor-fold>
  public boolean getAddInitializers() /*const*/ {
    return cfgBuildOptions.AddInitializers;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::registerForcedBlockExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 181,
   FQN="clang::AnalysisDeclContext::registerForcedBlockExpression", NM="_ZN5clang19AnalysisDeclContext29registerForcedBlockExpressionEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext29registerForcedBlockExpressionEPKNS_4StmtE")
  //</editor-fold>
  public void registerForcedBlockExpression(/*const*/ Stmt /*P*/ stmt) {
    if (!(forcedBlkExprs != null)) {
      forcedBlkExprs = new DenseMap</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ CFGBlock /*P*/ )null);
    }
    {
      // Default construct an entry for 'stmt'.
      /*const*/ Expr /*P*/ e = dyn_cast_Expr(stmt);
      if ((e != null)) {
        stmt = e.IgnoreParens$Const();
      }
    }
    /*J:(void)*/($Deref(forcedBlkExprs)).$at_T1$C$R(stmt);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getBlockForRegisteredExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 190,
   FQN="clang::AnalysisDeclContext::getBlockForRegisteredExpression", NM="_ZN5clang19AnalysisDeclContext31getBlockForRegisteredExpressionEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext31getBlockForRegisteredExpressionEPKNS_4StmtE")
  //</editor-fold>
  public /*const*/ CFGBlock /*P*/ getBlockForRegisteredExpression(/*const*/ Stmt /*P*/ stmt) {
    assert Native.$bool(forcedBlkExprs);
    {
      /*const*/ Expr /*P*/ e = dyn_cast_Expr(stmt);
      if ((e != null)) {
        stmt = e.IgnoreParens$Const();
      }
    }
    DenseMapIterator</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > itr = new DenseMapIterator</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ >(forcedBlkExprs.find(stmt));
    assert (itr.$noteq(/*NO_ITER_COPY*/forcedBlkExprs.end()));
    return itr.$arrow().second;
  }

  
  /// \brief Get the body of the Declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 127,
   FQN="clang::AnalysisDeclContext::getBody", NM="_ZNK5clang19AnalysisDeclContext7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext7getBodyEv")
  //</editor-fold>
  public Stmt /*P*/ getBody() /*const*/ {
    bool$ref Tmp = create_bool$ref();
    return getBody(Tmp);
  }

  
  /// \brief Get the body of the Declaration.
  /// \param[out] IsAutosynthesized Specifies if the body is auto-generated
  ///             by the BodyFarm.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getBody">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pass Manager to getBodyFarm*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 93,
   FQN="clang::AnalysisDeclContext::getBody", NM="_ZNK5clang19AnalysisDeclContext7getBodyERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext7getBodyERb")
  //</editor-fold>
  public Stmt /*P*/ getBody(final bool$ref/*bool &*/ IsAutosynthesized) /*const*/ {
    IsAutosynthesized.$set(false);
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        Stmt /*P*/ Body = FD.getBody();
        if ((Manager != null) && Manager.synthesizeBodies()) {
          Stmt /*P*/ SynthesizedBody = getBodyFarm(/*JAVA*/Manager, getASTContext()).getBody(FD);
          if ((SynthesizedBody != null)) {
            Body = SynthesizedBody;
            IsAutosynthesized.$set(true);
          }
        }
        return Body;
      } else {
        /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
        if ((MD != null)) {
          Stmt /*P*/ Body = MD.getBody();
          if ((Manager != null) && Manager.synthesizeBodies()) {
            Stmt /*P*/ SynthesizedBody = getBodyFarm(/*JAVA*/Manager, getASTContext()).getBody(MD);
            if ((SynthesizedBody != null)) {
              Body = SynthesizedBody;
              IsAutosynthesized.$set(true);
            }
          }
          return Body;
        } else {
          /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
          if ((BD != null)) {
            return BD.getBody();
          } else {
            /*const*/ FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_or_null_FunctionTemplateDecl(D);
            if ((FunTmpl != null)) {
              return FunTmpl.getTemplatedDecl().getBody();
            }
          }
        }
      }
    }
    throw new llvm_unreachable("unknown code decl");
  }

  
  /// \brief Checks if the body of the Decl is generated by the BodyFarm.
  ///
  /// Note, the lookup is not free. We are going to call getBody behind
  /// the scenes.
  /// \sa getBody
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::isBodyAutosynthesized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 132,
   FQN="clang::AnalysisDeclContext::isBodyAutosynthesized", NM="_ZNK5clang19AnalysisDeclContext21isBodyAutosynthesizedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext21isBodyAutosynthesizedEv")
  //</editor-fold>
  public boolean isBodyAutosynthesized() /*const*/ {
    bool$ref Tmp = create_bool$ref();
    getBody(Tmp);
    return Tmp.$deref();
  }

  
  /// \brief Checks if the body of the Decl is generated by the BodyFarm from a
  /// model file.
  ///
  /// Note, the lookup is not free. We are going to call getBody behind
  /// the scenes.
  /// \sa getBody
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::isBodyAutosynthesizedFromModelFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 138,
   FQN="clang::AnalysisDeclContext::isBodyAutosynthesizedFromModelFile", NM="_ZNK5clang19AnalysisDeclContext34isBodyAutosynthesizedFromModelFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext34isBodyAutosynthesizedFromModelFileEv")
  //</editor-fold>
  public boolean isBodyAutosynthesizedFromModelFile() /*const*/ {
    bool$ref Tmp = create_bool$ref();
    Stmt /*P*/ Body = getBody(Tmp);
    return Tmp.$deref() && Body.getLocStart().isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 214,
   FQN="clang::AnalysisDeclContext::getCFG", NM="_ZN5clang19AnalysisDeclContext6getCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext6getCFGEv")
  //</editor-fold>
  public CFG /*P*/ getCFG() {
    if (!cfgBuildOptions.PruneTriviallyFalseEdges) {
      return getUnoptimizedCFG();
    }
    if (!builtCFG) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(cfg.$assignMove($c$.track(CFG.buildCFG(D, getBody(), $AddrOf(D.getASTContext()), cfgBuildOptions))));
        // Even when the cfg is not successfully built, we don't
        // want to try building it again.
        builtCFG = true;
        if (PM.$bool()) {
          addParentsForSyntheticStmts(cfg.get(), PM.$star());
        }
        
        // The Observer should only observe one build of the CFG.
        getCFGBuildOptions().Observer = null;
      } finally {
        $c$.$destroy();
      }
    }
    return cfg.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getCFGStmtMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 252,
   FQN="clang::AnalysisDeclContext::getCFGStmtMap", NM="_ZN5clang19AnalysisDeclContext13getCFGStmtMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext13getCFGStmtMapEv")
  //</editor-fold>
  public CFGStmtMap /*P*/ getCFGStmtMap() {
    if (cfgStmtMap.$bool()) {
      return cfgStmtMap.get();
    }
    {
      
      CFG /*P*/ c = getCFG();
      if ((c != null)) {
        cfgStmtMap.reset(CFGStmtMap.Build(c, $AddrOf(getParentMap())));
        return cfgStmtMap.get();
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getCFGReachablityAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 264,
   FQN="clang::AnalysisDeclContext::getCFGReachablityAnalysis", NM="_ZN5clang19AnalysisDeclContext25getCFGReachablityAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext25getCFGReachablityAnalysisEv")
  //</editor-fold>
  public CFGReverseBlockReachabilityAnalysis /*P*/ getCFGReachablityAnalysis() {
    if (CFA.$bool()) {
      return CFA.get();
    }
    {
      
      CFG /*P*/ c = getCFG();
      if ((c != null)) {
        CFA.reset(new CFGReverseBlockReachabilityAnalysis($Deref(c)));
        return CFA.get();
      }
    }
    
    return null;
  }

  
  /// Return a version of the CFG without any edges pruned.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getUnoptimizedCFG">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 233,
   FQN="clang::AnalysisDeclContext::getUnoptimizedCFG", NM="_ZN5clang19AnalysisDeclContext17getUnoptimizedCFGEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext17getUnoptimizedCFGEv")
  //</editor-fold>
  public CFG /*P*/ getUnoptimizedCFG() {
    if (!builtCompleteCFG) {
      SaveAndRestoreBool NotPrune = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        NotPrune/*J*/= new SaveAndRestoreBool(create_bool$ref(cfgBuildOptions.PruneTriviallyFalseEdges), 
            false);
        $c$.clean(completeCFG.$assignMove(
            $c$.track(CFG.buildCFG(D, getBody(), $AddrOf(D.getASTContext()), cfgBuildOptions))
        ));
        // Even when the cfg is not successfully built, we don't
        // want to try building it again.
        builtCompleteCFG = true;
        if (PM.$bool()) {
          addParentsForSyntheticStmts(completeCFG.get(), PM.$star());
        }
        
        // The Observer should only observe one build of the CFG.
        getCFGBuildOptions().Observer = null;
      } finally {
        if (NotPrune != null) { NotPrune.$destroy(); }
        $c$.$destroy();
      }
    }
    return completeCFG.get();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::dumpCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 276,
   FQN="clang::AnalysisDeclContext::dumpCFG", NM="_ZN5clang19AnalysisDeclContext7dumpCFGEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext7dumpCFGEb")
  //</editor-fold>
  public void dumpCFG(boolean ShowColors) {
    getCFG().dump(getASTContext().getLangOpts(), ShowColors);
  }

  
  /// \brief Returns true if we have built a CFG for this analysis context.
  /// Note that this doesn't correspond to whether or not a valid CFG exists, it
  /// corresponds to whether we *attempted* to build one.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::isCFGBuilt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 169,
   FQN="clang::AnalysisDeclContext::isCFGBuilt", NM="_ZNK5clang19AnalysisDeclContext10isCFGBuiltEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext10isCFGBuiltEv")
  //</editor-fold>
  public boolean isCFGBuilt() /*const*/ {
    return builtCFG;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getParentMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 280,
   FQN="clang::AnalysisDeclContext::getParentMap", NM="_ZN5clang19AnalysisDeclContext12getParentMapEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext12getParentMapEv")
  //</editor-fold>
  public ParentMap /*&*/ getParentMap() {
    if (!PM.$bool()) {
      PM.reset(new ParentMap(getBody()));
      {
        /*const*/ CXXConstructorDecl /*P*/ C = dyn_cast_CXXConstructorDecl(getDecl());
        if ((C != null)) {
          for (/*const*/ CXXCtorInitializer /*P*/ I : C.inits$Const()) {
            PM.$arrow().addStmt(I.getInit());
          }
        }
      }
      if (builtCFG) {
        addParentsForSyntheticStmts(getCFG(), PM.$star());
      }
      if (builtCompleteCFG) {
        addParentsForSyntheticStmts(getUnoptimizedCFG(), PM.$star());
      }
    }
    return PM.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getPseudoConstantAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 296,
   FQN="clang::AnalysisDeclContext::getPseudoConstantAnalysis", NM="_ZN5clang19AnalysisDeclContext25getPseudoConstantAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext25getPseudoConstantAnalysisEv")
  //</editor-fold>
  public PseudoConstantAnalysis /*P*/ getPseudoConstantAnalysis() {
    if (!PCA.$bool()) {
      PCA.reset(new PseudoConstantAnalysis(getBody()));
    }
    return PCA.get();
  }

  
  /*typedef const VarDecl *const *referenced_decls_iterator*/
//  public final class referenced_decls_iterator extends type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getReferencedBlockVars">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 575,
   FQN="clang::AnalysisDeclContext::getReferencedBlockVars", NM="_ZN5clang19AnalysisDeclContext22getReferencedBlockVarsEPKNS_9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext22getReferencedBlockVarsEPKNS_9BlockDeclE")
  //</editor-fold>
  public iterator_range</*const*/ VarDecl /*P*/ /*const*/> getReferencedBlockVars(/*const*/ BlockDecl /*P*/ BD) {
    if (!(ReferencedBlockVars != null)) {
      ReferencedBlockVars = new DenseMap</*const*/ BlockDecl /*P*/ , Object/*void P*/ >(DenseMapInfo$LikePtr.$Info(), (Object/*void P*/ )null);
    }
    
    /*const*/ BumpVector</*const*/ VarDecl /*P*/ > /*P*/ V = LazyInitializeReferencedDecls(BD, (/*Deref*/ReferencedBlockVars).ref$at(BD), A);
    return llvm.make_range(V.begin$Const(), V.end$Const());
  }

  
  /// Return the ImplicitParamDecl* associated with 'self' if this
  /// AnalysisDeclContext wraps an ObjCMethodDecl.  Returns NULL otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getSelfDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 149,
   FQN="clang::AnalysisDeclContext::getSelfDecl", NM="_ZNK5clang19AnalysisDeclContext11getSelfDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZNK5clang19AnalysisDeclContext11getSelfDeclEv")
  //</editor-fold>
  public /*const*/ ImplicitParamDecl /*P*/ getSelfDecl() /*const*/ {
    {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(D);
      if ((MD != null)) {
        return MD.getSelfDecl();
      }
    }
    {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
      if ((BD != null)) {
        // See if 'self' was captured by the block.
        for (final /*const*/ BlockDecl.Capture /*&*/ I : BD.captures()) {
          /*const*/ VarDecl /*P*/ VD = I.getVariable();
          if (isSelfDecl(VD)) {
            return dyn_cast_ImplicitParamDecl(VD);
          }
        }
      }
    }
    
    /*const*/ CXXMethodDecl /*P*/ CXXMethod = dyn_cast_CXXMethodDecl(D);
    if (!(CXXMethod != null)) {
      return null;
    }
    
    /*const*/ CXXRecordDecl /*P*/ parent = CXXMethod.getParent$Const();
    if (!parent.isLambda()) {
      return null;
    }
    
    for (final /*const*/ LambdaCapture /*&*/ LC : parent.captures()) {
      if (!LC.capturesVariable()) {
        continue;
      }
      
      VarDecl /*P*/ VD = LC.getCapturedVar();
      if (isSelfDecl(VD)) {
        return dyn_cast_ImplicitParamDecl(VD);
      }
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getStackFrame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 316,
   FQN="clang::AnalysisDeclContext::getStackFrame", NM="_ZN5clang19AnalysisDeclContext13getStackFrameEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext13getStackFrameEPKNS_15LocationContextEPKNS_4StmtEPKNS_8CFGBlockEj")
  //</editor-fold>
  public /*const*/ StackFrameContext /*P*/ getStackFrame(/*const*/ LocationContext /*P*/ Parent, /*const*/ Stmt /*P*/ S, 
               /*const*/ CFGBlock /*P*/ Blk, /*uint*/int Idx) {
    return getLocationContextManager().getStackFrame(this, Parent, S, Blk, Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getBlockInvocationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 322,
   FQN="clang::AnalysisDeclContext::getBlockInvocationContext", NM="_ZN5clang19AnalysisDeclContext25getBlockInvocationContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext25getBlockInvocationContextEPKNS_15LocationContextEPKNS_9BlockDeclEPKv")
  //</editor-fold>
  public /*const*/ BlockInvocationContext /*P*/ getBlockInvocationContext(/*const*/ LocationContext /*P*/ parent, 
                           /*const*/ BlockDecl /*P*/ BD, 
                           /*const*/Object/*void P*/ ContextData) {
    return getLocationContextManager().getBlockInvocationContext(this, parent, 
        BD, ContextData);
  }

  
  /// Return the specified analysis object, lazily running the analysis if
  /// necessary.  Return NULL if the analysis could not run.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getAnalysis">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/AnalysisContext.h", line = 196,
   FQN="clang::AnalysisDeclContext::getAnalysis", NM="Tpl__ZN5clang19AnalysisDeclContext11getAnalysisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=Tpl__ZN5clang19AnalysisDeclContext11getAnalysisEv")
  //</editor-fold>
  public </*typename*/ T extends ManagedAnalysis> T /*P*/ getAnalysis(Class<T> clazz) {
    //LiveVariables
    //RelaxedLiveVariables
    //PostOrderCFGView
    /*const*/Object/*void P*/ tag;
    if (LiveVariables.class.equals(clazz)) {
      tag = LiveVariables.getTag();
    } else if (RelaxedLiveVariables.class.equals(clazz)) {
      tag = RelaxedLiveVariables.getTag();
    } else if (PostOrderCFGView.class.equals(clazz)) {
      tag = PostOrderCFGView.getTag();
    } else {
      throw new UnsupportedOperationException("Usupported class "+clazz);
    }
    assert tag == clazz : "JAVA: use class as the class-tag";
    final type$ref<ManagedAnalysis /*P*/ /*&*/> data = getAnalysisImpl(tag);
    if (!(data.$deref() != null)) {
      if (LiveVariables.class.equals(clazz)) {
        data.$set(LiveVariables.create(/*Deref*/this));
      } else if (RelaxedLiveVariables.class.equals(clazz)) {
        data.$set(RelaxedLiveVariables.create(/*Deref*/this));
      } else if (PostOrderCFGView.class.equals(clazz)) {
        data.$set(PostOrderCFGView.create(/*Deref*/this));
      } else {
        throw new UnsupportedOperationException("Usupported class "+clazz);
      }
    }
    assert data.$deref().getClass() == clazz : "" + clazz + " vs " + data.$deref().getClass();
    return ((/*static_cast*/T /*P*/ )(data.$deref()));
  }

  
  /// Returns true if the root namespace of the given declaration is the 'std'
  /// C++ namespace.
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::isInStdNamespace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 330,
   FQN="clang::AnalysisDeclContext::isInStdNamespace", NM="_ZN5clang19AnalysisDeclContext16isInStdNamespaceEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext16isInStdNamespaceEPKNS_4DeclE")
  //</editor-fold>
  public static boolean isInStdNamespace(/*const*/ Decl /*P*/ D) {
    /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const().getEnclosingNamespaceContext$Const();
    /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(DC);
    if (!(ND != null)) {
      return false;
    }
    {
      
      /*const*/ DeclContext /*P*/ Parent;
      while (((/*P*/ Parent = ND.getParent$Const()) != null)) {
        if (!isa_NamespaceDecl(Parent)) {
          break;
        }
        ND = cast_NamespaceDecl(Parent);
      }
    }
    
    return ND.isStdNamespace();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getAnalysisImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 585,
   FQN="clang::AnalysisDeclContext::getAnalysisImpl", NM="_ZN5clang19AnalysisDeclContext15getAnalysisImplEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext15getAnalysisImplEPKv")
  //</editor-fold>
  private type$ref<ManagedAnalysis /*P*/ /*&*/> getAnalysisImpl(/*const*/Object/*void P*/ tag) {
    if (!(ManagedAnalyses != null)) {
      ManagedAnalyses = new DenseMap</*const*/Object/*void P*/, ManagedAnalysis /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ManagedAnalysis /*P*/ )null);
    }
    DenseMap</*const*/Object/*void P*/, ManagedAnalysis /*P*/ > /*P*/ M = (DenseMap</*const*/Object/*void P*/, ManagedAnalysis /*P*/ > /*P*/)ManagedAnalyses;
    return (/*Deref*/M).ref$at(tag);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnalysisDeclContext::getLocationContextManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp", line = 345,
   FQN="clang::AnalysisDeclContext::getLocationContextManager", NM="_ZN5clang19AnalysisDeclContext25getLocationContextManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang19AnalysisDeclContext25getLocationContextManagerEv")
  //</editor-fold>
  private LocationContextManager /*&*/ getLocationContextManager() {
    assert ((Manager != null)) : "Cannot create LocationContexts without an AnalysisDeclContextManager!";
    return Manager.getLocationContextManager();
  }

  
  @Override public String toString() {
    return "" + "Manager=" + "[AnalysisDeclContextManager]" // NOI18N
              + ", D=" + D // NOI18N
              + ", cfg=" + cfg // NOI18N
              + ", completeCFG=" + completeCFG // NOI18N
              + ", cfgStmtMap=" + cfgStmtMap // NOI18N
              + ", cfgBuildOptions=" + cfgBuildOptions // NOI18N
              + ", forcedBlkExprs=" + forcedBlkExprs // NOI18N
              + ", builtCFG=" + builtCFG // NOI18N
              + ", builtCompleteCFG=" + builtCompleteCFG // NOI18N
              + ", PM=" + PM // NOI18N
              + ", PCA=" + PCA // NOI18N
              + ", CFA=" + CFA // NOI18N
              + ", A=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", ReferencedBlockVars=" + ReferencedBlockVars // NOI18N
              + ", ManagedAnalyses=" + ManagedAnalyses; // NOI18N
  }
}
