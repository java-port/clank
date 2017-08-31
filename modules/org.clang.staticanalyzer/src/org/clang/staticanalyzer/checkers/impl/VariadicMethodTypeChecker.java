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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;
import org.clang.analysis.domainspecific.ento.*;
import static org.clang.staticanalyzer.checkers.impl.BasicObjCFoundationChecksStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VariadicMethodTypeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 679,
 FQN="(anonymous namespace)::VariadicMethodTypeChecker", NM="_ZN12_GLOBAL__N_125VariadicMethodTypeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_125VariadicMethodTypeCheckerE")
//</editor-fold>
public class VariadicMethodTypeChecker extends /*public*/ Checker/*T<PreObjCMessage> */
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, Destructors.ClassWithDestructor {
  private /*mutable */Selector arrayWithObjectsS;
  private /*mutable */Selector dictionaryWithObjectsAndKeysS;
  private /*mutable */Selector setWithObjectsS;
  private /*mutable */Selector orderedSetWithObjectsS;
  private /*mutable */Selector initWithObjectsS;
  private /*mutable */Selector initWithObjectsAndKeysS;
  private /*mutable */std.unique_ptr<BugType> BT;
  
  // end anonymous namespace
  
  /// isVariadicMessage - Returns whether the given message is a variadic message,
  /// where all arguments must be Objective-C types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VariadicMethodTypeChecker::isVariadicMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 697,
   FQN="(anonymous namespace)::VariadicMethodTypeChecker::isVariadicMessage", NM="_ZNK12_GLOBAL__N_125VariadicMethodTypeChecker17isVariadicMessageERKN5clang4ento14ObjCMethodCallE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_125VariadicMethodTypeChecker17isVariadicMessageERKN5clang4ento14ObjCMethodCallE")
  //</editor-fold>
  private boolean isVariadicMessage(final /*const*/ ObjCMethodCall /*&*/ msg) /*const*/ {
    /*const*/ ObjCMethodDecl /*P*/ MD = msg.getDecl();
    if (!(MD != null) || !MD.isVariadic() || isa_ObjCProtocolDecl(MD.getDeclContext$Const())) {
      return false;
    }
    
    Selector S = msg.getSelector();
    if (msg.isInstanceMessage()) {
      // FIXME: Ideally we'd look at the receiver interface here, but that's not
      // useful for init, because alloc returns 'id'. In theory, this could lead
      // to false positives, for example if there existed a class that had an
      // initWithObjects: implementation that does accept non-Objective-C pointer
      // types, but the chance of that happening is pretty small compared to the
      // gains that this analysis gives.
      /*const*/ ObjCInterfaceDecl /*P*/ Class = MD.getClassInterface$Const();
      switch (findKnownClass(Class)) {
       case FC_NSArray:
       case FC_NSOrderedSet:
       case FC_NSSet:
        return S.$eq(/*NO_COPY*/initWithObjectsS);
       case FC_NSDictionary:
        return S.$eq(/*NO_COPY*/initWithObjectsAndKeysS);
       default:
        return false;
      }
    } else {
      /*const*/ ObjCInterfaceDecl /*P*/ Class = msg.getReceiverInterface();
      switch (findKnownClass(Class)) {
       case FC_NSArray:
        return S.$eq(/*NO_COPY*/arrayWithObjectsS);
       case FC_NSOrderedSet:
        return S.$eq(/*NO_COPY*/orderedSetWithObjectsS);
       case FC_NSSet:
        return S.$eq(/*NO_COPY*/setWithObjectsS);
       case FC_NSDictionary:
        return S.$eq(/*NO_COPY*/dictionaryWithObjectsAndKeysS);
       default:
        return false;
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VariadicMethodTypeChecker::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 743,
   FQN="(anonymous namespace)::VariadicMethodTypeChecker::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_125VariadicMethodTypeChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_125VariadicMethodTypeChecker19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ msg, 
                     final CheckerContext /*&*/ C) /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new APIMisuse(this, 
              $("Arguments passed to variadic method aren't all Objective-C pointer types")));
      
      final ASTContext /*&*/ Ctx = C.getASTContext();
      arrayWithObjectsS.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"arrayWithObjects"), Ctx));
      dictionaryWithObjectsAndKeysS.$assignMove(
          GetUnarySelector(new StringRef(/*KEEP_STR*/"dictionaryWithObjectsAndKeys"), Ctx)
      );
      setWithObjectsS.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"setWithObjects"), Ctx));
      orderedSetWithObjectsS.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"orderedSetWithObjects"), Ctx));
      
      initWithObjectsS.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"initWithObjects"), Ctx));
      initWithObjectsAndKeysS.$assignMove(GetUnarySelector(new StringRef(/*KEEP_STR*/"initWithObjectsAndKeys"), Ctx));
    }
    if (!isVariadicMessage(msg)) {
      return;
    }
    
    // We are not interested in the selector arguments since they have
    // well-defined types, so the compiler will issue a warning for them.
    /*uint*/int variadicArgsBegin = msg.getSelector().getNumArgs();
    
    // We're not interested in the last argument since it has to be nil or the
    // compiler would have issued a warning for it elsewhere.
    /*uint*/int variadicArgsEnd = msg.getNumArgs() - 1;
    if ($lesseq_uint(variadicArgsEnd, variadicArgsBegin)) {
      return;
    }
    
    // Verify that all arguments have Objective-C types.
    OptionalPtr<ExplodedNode /*P*/ > errorNode/*J*/= new OptionalPtr<ExplodedNode /*P*/ >();
    
    for (/*uint*/int I = variadicArgsBegin; I != variadicArgsEnd; ++I) {
      raw_svector_ostream os = null;
      unique_ptr<BugReport> R = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        QualType ArgTy = msg.getArgExpr(I).getType();
        if (ArgTy.$arrow().isObjCObjectPointerType()) {
          continue;
        }
        
        // Block pointers are treaded as Objective-C pointers.
        if (ArgTy.$arrow().isBlockPointerType()) {
          continue;
        }
        
        // Ignore pointer constants.
        if (msg.getArgSVal(I).getAs(NsLoc.ConcreteInt.class).$bool()) {
          continue;
        }
        
        // Ignore pointer types annotated with 'NSObject' attribute.
        if (C.getASTContext().isObjCNSObjectType(new QualType(ArgTy))) {
          continue;
        }
        
        // Ignore CF references, which can be toll-free bridged.
        if (coreFoundation.isCFObjectRef(new QualType(ArgTy))) {
          continue;
        }
        
        // Generate only one error node to use for all bug reports.
        if (!errorNode.hasValue()) {
          errorNode.$assign_T$RR(C.generateNonFatalErrorNode());
        }
        if (!(errorNode.getValue() != null)) {
          continue;
        }
        
        SmallString/*128*/ sbuf/*J*/= new SmallString/*128*/(128);
        os/*J*/= new raw_svector_ostream(sbuf);
        
        StringRef TypeName = GetReceiverInterfaceName(msg);
        if (!TypeName.empty()) {
          os.$out(/*KEEP_STR*/"Argument to '").$out(/*NO_COPY*/TypeName).$out(/*KEEP_STR*/"' method '");
        } else {
          os.$out(/*KEEP_STR*/"Argument to method '");
        }
        
        msg.getSelector().print(os);
        os.$out(/*KEEP_STR*/"' should be an Objective-C pointer type, not '");
        ArgTy.print(os, new PrintingPolicy(C.getLangOpts()));
        os.$out(/*KEEP_STR*/$SGL_QUOTE);
        
        R = llvm.make_unique(new BugReport(BT.$star(), os.str(), errorNode.getValue()));
        R.$arrow().addRange(msg.getArgSourceRange(I));
        C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
      } finally {
        if (R != null) { R.$destroy(); }
        if (os != null) { os.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VariadicMethodTypeChecker::~VariadicMethodTypeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 679,
   FQN="(anonymous namespace)::VariadicMethodTypeChecker::~VariadicMethodTypeChecker", NM="_ZN12_GLOBAL__N_125VariadicMethodTypeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_125VariadicMethodTypeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VariadicMethodTypeChecker::VariadicMethodTypeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 679,
   FQN="(anonymous namespace)::VariadicMethodTypeChecker::VariadicMethodTypeChecker", NM="_ZN12_GLOBAL__N_125VariadicMethodTypeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_125VariadicMethodTypeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ VariadicMethodTypeChecker() {
    // : Checker<PreObjCMessage>(), arrayWithObjectsS(), dictionaryWithObjectsAndKeysS(), setWithObjectsS(), orderedSetWithObjectsS(), initWithObjectsS(), initWithObjectsAndKeysS(), BT() 
    //START JInit
    super();
    this.arrayWithObjectsS = new Selector();
    this.dictionaryWithObjectsAndKeysS = new Selector();
    this.setWithObjectsS = new Selector();
    this.orderedSetWithObjectsS = new Selector();
    this.initWithObjectsS = new Selector();
    this.initWithObjectsAndKeysS = new Selector();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new PreObjCMessage()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "arrayWithObjectsS=" + arrayWithObjectsS // NOI18N
              + ", dictionaryWithObjectsAndKeysS=" + dictionaryWithObjectsAndKeysS // NOI18N
              + ", setWithObjectsS=" + setWithObjectsS // NOI18N
              + ", orderedSetWithObjectsS=" + orderedSetWithObjectsS // NOI18N
              + ", initWithObjectsS=" + initWithObjectsS // NOI18N
              + ", initWithObjectsAndKeysS=" + initWithObjectsAndKeysS // NOI18N
              + ", BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
