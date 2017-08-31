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

package org.clang.staticanalyzer.checkers.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 29,
 FQN="(anonymous namespace)::StackAddrEscapeChecker", NM="_ZN12_GLOBAL__N_122StackAddrEscapeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZN12_GLOBAL__N_122StackAddrEscapeCheckerE")
//</editor-fold>
public class StackAddrEscapeChecker extends /*public*/ Checker/*<PreStmt<ReturnStmt>, EndFunction> */
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.EndFunctionChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT_stackleak;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_returnstack;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 119,
   FQN="(anonymous namespace)::StackAddrEscapeChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_122StackAddrEscapeChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZNK12_GLOBAL__N_122StackAddrEscapeChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ RS, 
              final CheckerContext /*&*/ C) /*const*/ {
    
    /*const*/ Expr /*P*/ RetE = RS.getRetValue$Const();
    if (!(RetE != null)) {
      return;
    }
    RetE = RetE.IgnoreParens$Const();
    
    /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
    SVal V = C.getState().$arrow().getSVal(RetE, LCtx);
    /*const*/ MemRegion /*P*/ R = V.getAsRegion();
    if (!(R != null)) {
      return;
    }
    
    /*const*/ StackSpaceRegion /*P*/ SS = dyn_cast_or_null_StackSpaceRegion(R.getMemorySpace());
    if (!(SS != null)) {
      return;
    }
    
    // Return stack memory in an ancestor stack frame is fine.
    /*const*/ StackFrameContext /*P*/ CurFrame = LCtx.getCurrentStackFrame();
    /*const*/ StackFrameContext /*P*/ MemFrame = SS.getStackFrame();
    if (MemFrame != CurFrame) {
      return;
    }
    
    // Automatic reference counting automatically copies blocks.
    if (C.getASTContext().getLangOpts().ObjCAutoRefCount
       && isa_BlockDataRegion(R)) {
      return;
    }
    {
      
      // Returning a record by value is fine. (In this case, the returned
      // expression will be a copy-constructor, possibly wrapped in an
      // ExprWithCleanups node.)
      /*const*/ ExprWithCleanups /*P*/ Cleanup = dyn_cast_ExprWithCleanups(RetE);
      if ((Cleanup != null)) {
        RetE = Cleanup.getSubExpr$Const();
      }
    }
    if (isa_CXXConstructExpr(RetE) && RetE.getType().$arrow().isRecordType()) {
      return;
    }
    {
      
      // The CK_CopyAndAutoreleaseBlockObject cast causes the block to be copied
      // so the stack address is not escaping here.
      /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(RetE);
      if ((ICE != null)) {
        if (isa_BlockDataRegion(R)
           && ICE.getCastKind() == CastKind.CK_CopyAndAutoreleaseBlockObject) {
          return;
        }
      }
    }
    
    EmitStackError(C, R, RetE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 171,
   FQN="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction", NM="_ZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextE")
  //</editor-fold>
  public void checkEndFunction(final CheckerContext /*&*/ Ctx) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    checkEndFunction$$.CallBack cb = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(Ctx.getState());
      
      // Iterate over all bindings to global variables and see if it contains
      // a memory region in the stack space.
      ;
      
      cb/*J*/= new checkEndFunction$$.CallBack(Ctx);
      state.$arrow().getStateManager().getStoreManager().iterBindings(state.$arrow().getStore(), cb);
      if (cb.V.empty()) {
        return;
      }
      
      // Generate an error node.
      ExplodedNode /*P*/ N = $c$.clean(Ctx.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
      if (!(N != null)) {
        return;
      }
      if (!BT_stackleak.$bool()) {
        BT_stackleak.reset(new BuiltinBug(this, $("Stack address stored into global variable"), 
                $("Stack address was saved into a global variable. This is dangerous because the address will become invalid after returning from the function")));
      }
      
      for (/*uint*/int i = 0, e = cb.V.size(); i != e; ++i) {
        raw_svector_ostream os = null;
        unique_ptr<BugReport> report = null;
        try {
          // Generate a report for this bug.
          SmallString/*<512>*/ buf/*J*/= new SmallString/*<512>*/(512);
          os/*J*/= new raw_svector_ostream(buf);
          SourceRange range = genName(os, cb.V.$at(i).second, Ctx.getASTContext());
          os.$out(/*KEEP_STR*/" is still referred to by the ");
          if (isa_StaticGlobalSpaceRegion(cb.V.$at(i).first.getMemorySpace())) {
            os.$out(/*KEEP_STR*/$static);
          } else {
            os.$out(/*KEEP_STR*/$global);
          }
          os.$out(/*KEEP_STR*/" variable '");
          /*const*/ VarRegion /*P*/ VR = cast_VarRegion(cb.V.$at(i).first.getBaseRegion());
          $out_raw_ostream_NamedDecl$C(os, $Deref(VR.getDecl())).$out(
              /*KEEP_STR*/"' upon returning to the caller.  This will be a dangling reference"
          );
          report = llvm.make_unique(new BugReport(BT_stackleak.$star(), os.str(), N));
          if (range.isValid()) {
            report.$arrow().addRange(new SourceRange(range));
          }
          
          Ctx.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
        } finally {
          if (report != null) { report.$destroy(); }
          if (os != null) { os.$destroy(); }
        }
      }
    } finally {
      if (cb != null) { cb.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }
  private static final class checkEndFunction$$ {
    static //<editor-fold defaultstate="collapsed" desc="CallBack">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 176,
     FQN="CallBack", NM="_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEE8CallBack",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEE8CallBack")
    //</editor-fold>
     class CallBack extends /*public*/ StoreManager.BindingsHandler implements Destructors.ClassWithDestructor {
    /*private:*/
      private final CheckerContext /*&*/ Ctx;
      private /*const*/ StackFrameContext /*P*/ CurSFC;
    /*public:*/
      public SmallVector<std.pairPtrPtr</*const*/ MemRegion /*P*/ , /*const*/ MemRegion /*P*/ >> V;
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction(CheckerContext & )::CallBack::CallBack">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 183,
       FQN="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction(CheckerContext & )::CallBack::CallBack", NM="_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEEN8CallBackC1ES4_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEEN8CallBackC1ES4_")
      //</editor-fold>
      public CallBack(final CheckerContext /*&*/ CC) {
        // : StoreManager::BindingsHandler(), Ctx(CC), CurSFC(CC.getLocationContext()->getCurrentStackFrame()), V() 
        //START JInit
        super();
        this./*&*/Ctx=/*&*/CC;
        this.CurSFC = CC.getLocationContext().getCurrentStackFrame();
        this.V = new SmallVector<std.pairPtrPtr</*const*/ MemRegion /*P*/ , /*const*/ MemRegion /*P*/ >>(10, new std.pairPtrPtr</*const*/ MemRegion /*P*/ , /*const*/ MemRegion /*P*/ >());
        //END JInit
      }
    
      
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction(CheckerContext & )::CallBack::HandleBinding">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 188,
       FQN="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction(CheckerContext & )::CallBack::HandleBinding", NM="_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEEN8CallBack13HandleBindingERNS2_12StoreManagerEPKvPKNS2_9MemRegionENS2_4SValE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEEN8CallBack13HandleBindingERNS2_12StoreManagerEPKvPKNS2_9MemRegionENS2_4SValE")
      //</editor-fold>
      @Override public boolean HandleBinding(final StoreManager /*&*/ SMgr, /*const*/Object/*void P*/ store, 
                   /*const*/ MemRegion /*P*/ region, SVal val)/* override*/ {
        if (!isa_GlobalsSpaceRegion(region.getMemorySpace())) {
          return true;
        }
        
        /*const*/ MemRegion /*P*/ vR = val.getAsRegion();
        if (!(vR != null)) {
          return true;
        }
        
        // Under automated retain release, it is okay to assign a block
        // directly to a global variable.
        if (Ctx.getASTContext().getLangOpts().ObjCAutoRefCount
           && isa_BlockDataRegion(vR)) {
          return true;
        }
        {
          
          /*const*/ StackSpaceRegion /*P*/ SSR = dyn_cast_StackSpaceRegion(vR.getMemorySpace());
          if ((SSR != null)) {
            // If the global variable holds a location in the current stack frame,
            // record the binding to emit a warning.
            if (SSR.getStackFrame() == CurSFC) {
              V.push_back(std.make_pair_Ptr_Ptr(region, vR));
            }
          }
        }
        
        return true;
      }
    
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction(CheckerContext & )::CallBack::~CallBack">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 176,
       FQN="(anonymous namespace)::StackAddrEscapeChecker::checkEndFunction(CheckerContext & )::CallBack::~CallBack", NM="_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEEN8CallBackD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZZNK12_GLOBAL__N_122StackAddrEscapeChecker16checkEndFunctionERN5clang4ento14CheckerContextEEN8CallBackD0Ev")
      //</editor-fold>
      @Override public /*inline*/ void $destroy() {
        //START JDestroy
        V.$destroy();
        super.$destroy();
        //END JDestroy
      }
    
      
      @Override public String toString() {
        return "" + "Ctx=" + "[CheckerContext]" // NOI18N
                  + ", CurSFC=" + "[StackFrameContext]" // NOI18N
                  + ", V=" + V // NOI18N
                  + super.toString(); // NOI18N
      }
    };
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::EmitStackError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 95,
   FQN="(anonymous namespace)::StackAddrEscapeChecker::EmitStackError", NM="_ZNK12_GLOBAL__N_122StackAddrEscapeChecker14EmitStackErrorERN5clang4ento14CheckerContextEPKNS2_9MemRegionEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZNK12_GLOBAL__N_122StackAddrEscapeChecker14EmitStackErrorERN5clang4ento14CheckerContextEPKNS2_9MemRegionEPKNS1_4ExprE")
  //</editor-fold>
  private void EmitStackError(final CheckerContext /*&*/ C, /*const*/ MemRegion /*P*/ R, 
                /*const*/ Expr /*P*/ RetE) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      if (!BT_returnstack.$bool()) {
        BT_returnstack.reset(new BuiltinBug(this, $("Return of address to stack-allocated memory")));
      }
      
      // Generate a report for this bug.
      SmallString/*<512>*/ buf/*J*/= new SmallString/*<512>*/(512);
      os/*J*/= new raw_svector_ostream(buf);
      SourceRange range = genName(os, R, C.getASTContext());
      os.$out(/*KEEP_STR*/" returned to caller");
      report = llvm.make_unique(new BugReport(BT_returnstack.$star(), os.str(), N));
      report.$arrow().addRange(RetE.getSourceRange());
      if (range.isValid()) {
        report.$arrow().addRange(new SourceRange(range));
      }
      
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::genName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 45,
   FQN="(anonymous namespace)::StackAddrEscapeChecker::genName", NM="_ZN12_GLOBAL__N_122StackAddrEscapeChecker7genNameERN4llvm11raw_ostreamEPKN5clang4ento9MemRegionERNS4_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZN12_GLOBAL__N_122StackAddrEscapeChecker7genNameERN4llvm11raw_ostreamEPKN5clang4ento9MemRegionERNS4_10ASTContextE")
  //</editor-fold>
  private static SourceRange genName(final raw_ostream /*&*/ os, /*const*/ MemRegion /*P*/ R, 
         final ASTContext /*&*/ Ctx) {
    // Get the base region, stripping away fields and elements.
    R = R.getBaseRegion();
    final SourceManager /*&*/ SM = Ctx.getSourceManager();
    SourceRange range/*J*/= new SourceRange();
    os.$out(/*KEEP_STR*/"Address of ");
    {
      
      // Check if the region is a compound literal.
      /*const*/ CompoundLiteralRegion /*P*/ CR = dyn_cast_CompoundLiteralRegion(R);
      if ((CR != null)) {
        /*const*/ CompoundLiteralExpr /*P*/ CL = CR.getLiteralExpr();
        os.$out(/*KEEP_STR*/"stack memory associated with a compound literal declared on line ").$out_uint(
            SM.getExpansionLineNumber(CL.getLocStart())
        ).$out(
            /*KEEP_STR*/" returned to caller"
        );
        range.$assignMove(CL.getSourceRange());
      } else {
        /*const*/ AllocaRegion /*P*/ AR = dyn_cast_AllocaRegion(R);
        if ((AR != null)) {
          /*const*/ Expr /*P*/ ARE = AR.getExpr();
          SourceLocation L = ARE.getLocStart();
          range.$assignMove(ARE.getSourceRange());
          os.$out(/*KEEP_STR*/"stack memory allocated by call to alloca() on line ").$out_uint(
              SM.getExpansionLineNumber(/*NO_COPY*/L)
          );
        } else {
          /*const*/ BlockDataRegion /*P*/ BR = dyn_cast_BlockDataRegion(R);
          if ((BR != null)) {
            /*const*/ BlockDecl /*P*/ BD = BR.getCodeRegion().getDecl();
            SourceLocation L = BD.getLocStart();
            range.$assignMove(BD.getSourceRange());
            os.$out(/*KEEP_STR*/"stack-allocated block declared on line ").$out_uint(
                SM.getExpansionLineNumber(/*NO_COPY*/L)
            );
          } else {
            /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(R);
            if ((VR != null)) {
              os.$out(/*KEEP_STR*/"stack memory associated with local variable '").$out(
                  VR.getString()
              ).$out_char($$SGL_QUOTE);
              range.$assignMove(VR.getDecl().getSourceRange());
            } else {
              /*const*/ CXXTempObjectRegion /*P*/ TOR = dyn_cast_CXXTempObjectRegion(R);
              if ((TOR != null)) {
                QualType Ty = TOR.getValueType().getLocalUnqualifiedType();
                os.$out(/*KEEP_STR*/"stack memory associated with temporary object of type '");
                Ty.print(os, Ctx.getPrintingPolicy());
                os.$out(/*KEEP_STR*/$SGL_QUOTE);
                range.$assignMove(TOR.getExpr().getSourceRange());
              } else {
                throw new llvm_unreachable("Invalid region in ReturnStackAddressChecker.");
              }
            }
          }
        }
      }
    }
    
    return range;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::~StackAddrEscapeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 29,
   FQN="(anonymous namespace)::StackAddrEscapeChecker::~StackAddrEscapeChecker", NM="_ZN12_GLOBAL__N_122StackAddrEscapeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZN12_GLOBAL__N_122StackAddrEscapeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_returnstack.$destroy();
    BT_stackleak.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StackAddrEscapeChecker::StackAddrEscapeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp", line = 29,
   FQN="(anonymous namespace)::StackAddrEscapeChecker::StackAddrEscapeChecker", NM="_ZN12_GLOBAL__N_122StackAddrEscapeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/StackAddrEscapeChecker.cpp -nm=_ZN12_GLOBAL__N_122StackAddrEscapeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ StackAddrEscapeChecker() {
    // : Checker<PreStmt<ReturnStmt>, EndFunction>(), BT_stackleak(), BT_returnstack() 
    //START JInit
    super();
    this.BT_stackleak = new std.unique_ptr<BuiltinBug>();
    this.BT_returnstack = new std.unique_ptr<BuiltinBug>();
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ReturnStmt) {
      checkPreStmt((ReturnStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class),
    new EndFunction()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_stackleak=" + BT_stackleak // NOI18N
              + ", BT_returnstack=" + BT_returnstack // NOI18N
              + super.toString(); // NOI18N
  }
}
