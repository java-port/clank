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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
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
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.IvarInvalidationCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 56,
 FQN="(anonymous namespace)::IvarInvalidationCheckerImpl", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImplE")
//</editor-fold>
public class IvarInvalidationCheckerImpl {
  /*typedef llvm::SmallSetVector<const ObjCMethodDecl *, 2> MethodSet*/
//  public final class MethodSet extends SmallSetVector</*const*/ ObjCMethodDecl /*P*/ >{ };
  /*typedef llvm::DenseMap<const ObjCMethodDecl *, const ObjCIvarDecl *> MethToIvarMapTy*/
//  public final class MethToIvarMapTy extends DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ >{ };
  /*typedef llvm::DenseMap<const ObjCPropertyDecl *, const ObjCIvarDecl *> PropToIvarMapTy*/
//  public final class PropToIvarMapTy extends DenseMap</*const*/ ObjCPropertyDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ >{ };
  /*typedef llvm::DenseMap<const ObjCIvarDecl *, const ObjCPropertyDecl *> IvarToPropMapTy*/
//  public final class IvarToPropMapTy extends DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 65,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoE")
  //</editor-fold>
  private static class/*struct*/ InvalidationInfo implements Destructors.ClassWithDestructor, Native.assignable<InvalidationInfo>, NativeCloneable<InvalidationInfo>, NativeMoveable<InvalidationInfo> {
    /// Has the ivar been invalidated?
    public boolean IsInvalidated;
    
    /// The methods which can be used to invalidate the ivar.
    public SmallSetVector</*const*/ ObjCMethodDecl /*P*/ > InvalidationMethods;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::InvalidationInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 72,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::InvalidationInfo", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoC1Ev")
    //</editor-fold>
    public InvalidationInfo() {
      // : IsInvalidated(false), InvalidationMethods() 
      //START JInit
      this.IsInvalidated = false;
      this.InvalidationMethods = new SmallSetVector</*const*/ ObjCMethodDecl /*P*/ >(2, (/*const*/ ObjCMethodDecl /*P*/ ) null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::addInvalidationMethod">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 73,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::addInvalidationMethod", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfo21addInvalidationMethodEPKN5clang14ObjCMethodDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfo21addInvalidationMethodEPKN5clang14ObjCMethodDeclE")
    //</editor-fold>
    public void addInvalidationMethod(/*const*/ ObjCMethodDecl /*P*/ MD) {
      InvalidationMethods.insert(MD);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::needsInvalidation">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 77,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::needsInvalidation", NM="_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfo17needsInvalidationEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfo17needsInvalidationEv")
    //</editor-fold>
    public boolean needsInvalidation() /*const*/ {
      return !InvalidationMethods.empty();
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::hasMethod">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 81,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::hasMethod", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfo9hasMethodEPKN5clang14ObjCMethodDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfo9hasMethodEPKN5clang14ObjCMethodDeclE")
    //</editor-fold>
    public boolean hasMethod(/*const*/ ObjCMethodDecl /*P*/ MD) {
      if (IsInvalidated) {
        return true;
      }
      for (type$iterator<?,/*const*/ ObjCMethodDecl /*P*/ /*const*/ /*P*/> I = $tryClone(InvalidationMethods.begin()), 
          /*P*/ E = $tryClone(InvalidationMethods.end()); $noteq_ptr(I, E); I.$preInc()) {
        if (I.$star() == MD) {
          IsInvalidated = true;
          return true;
        }
      }
      return false;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::InvalidationInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 65,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::InvalidationInfo", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ InvalidationInfo(final /*const*/ InvalidationInfo /*&*/ $Prm0) {
      // : IsInvalidated(.IsInvalidated), InvalidationMethods(.InvalidationMethods) 
      //START JInit
      this.IsInvalidated = $Prm0.IsInvalidated;
      this.InvalidationMethods = new SmallSetVector</*const*/ ObjCMethodDecl /*P*/ >($Prm0.InvalidationMethods);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::InvalidationInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 65,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::InvalidationInfo", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ InvalidationInfo(JD$Move _dparam, final InvalidationInfo /*&&*/$Prm0) {
      // : IsInvalidated(static_cast<InvalidationInfo &&>().IsInvalidated), InvalidationMethods(static_cast<InvalidationInfo &&>().InvalidationMethods) 
      //START JInit
      this.IsInvalidated = $Prm0.IsInvalidated;
      this.InvalidationMethods = new SmallSetVector</*const*/ ObjCMethodDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.InvalidationMethods);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::~InvalidationInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 65,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::~InvalidationInfo", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      InvalidationMethods.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 65,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::InvalidationInfo::operator=", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl16InvalidationInfoaSERKS1_")
    //</editor-fold>
    public /*inline*/ InvalidationInfo /*&*/ $assign(final /*const*/ InvalidationInfo /*&*/ $Prm0) {
      this.IsInvalidated = $Prm0.IsInvalidated;
      this.InvalidationMethods.$assign($Prm0.InvalidationMethods);
      return /*Deref*/this;
    }

    @Override
    public InvalidationInfo clone() {
      return new InvalidationInfo(this);
    }

    @Override
    public InvalidationInfo move() {
      return new InvalidationInfo(JD$Move.INSTANCE, this);
    }
    
    @Override public String toString() {
      return "" + "IsInvalidated=" + IsInvalidated // NOI18N
                + ", InvalidationMethods=" + InvalidationMethods; // NOI18N
    }
  };
  
  /*typedef llvm::DenseMap<const ObjCIvarDecl *, InvalidationInfo> IvarSet*/
//  public final class IvarSet extends DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>{ };
  
  /// Statement visitor, which walks the method body and flags the ivars
  /// referenced in it (either directly or via property).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 99,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawlerE")
  //</editor-fold>
  private static class MethodCrawler implements /*public*/ ConstStmtVisitorVoid<MethodCrawler> {
    /// The set of Ivars which need to be invalidated.
    private final DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> /*&*/ IVars;
    
    /// Flag is set as the result of a message send to another
    /// invalidation method.
    private final bool$ref/*bool &*/ CalledAnotherInvalidationMethod;
    
    /// Property setter to ivar mapping.
    private final /*const*/DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > /*&*/ PropertySetterToIvarMap;
    
    /// Property getter to ivar mapping.
    private final /*const*/DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > /*&*/ PropertyGetterToIvarMap;
    
    /// Property to ivar mapping.
    private final /*const*/DenseMap</*const*/ ObjCPropertyDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > /*&*/ PropertyToIvarMap;
    
    /// The invalidation method being currently processed.
    private /*const*/ ObjCMethodDecl /*P*/ InvalidationMethod;
    
    private final ASTContext /*&*/ Ctx;
    
    /// Peel off parens, casts, OpaqueValueExpr, and PseudoObjectExpr.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::peel">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 590,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::peel", NM="_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler4peelEPKN5clang4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler4peelEPKN5clang4ExprE")
    //</editor-fold>
    private /*const*/ Expr /*P*/ peel(/*const*/ Expr /*P*/ E) /*const*/ {
      E = E.IgnoreParenCasts$Const();
      {
        /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(E);
        if ((POE != null)) {
          E = POE.getSyntacticForm$Const().IgnoreParenCasts$Const();
        }
      }
      {
        /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
        if ((OVE != null)) {
          E = OVE.getSourceExpr().IgnoreParenCasts();
        }
      }
      return E;
    }

    
    /// Does this expression represent zero: '0'?
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::isZero">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 642,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::isZero", NM="_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler6isZeroEPKN5clang4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler6isZeroEPKN5clang4ExprE")
    //</editor-fold>
    private boolean isZero(/*const*/ Expr /*P*/ E) /*const*/ {
      E = peel(E);
      
      return (E.isNullPointerConstant(Ctx, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull)
         != Expr.NullPointerConstantKind.NPCK_NotNull);
    }

    
    /// Mark the given ivar as invalidated.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::markInvalidated">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 578,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::markInvalidated", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler15markInvalidatedEPKN5clang12ObjCIvarDeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler15markInvalidatedEPKN5clang12ObjCIvarDeclE")
    //</editor-fold>
    private void markInvalidated(/*const*/ ObjCIvarDecl /*P*/ Iv) {
      DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> I = IVars.find(Iv);
      if (I.$noteq(/*NO_ITER_COPY*/IVars.end())) {
        // If InvalidationMethod is present, we are processing the message send and
        // should ensure we are invalidating with the appropriate method,
        // otherwise, we are processing setting to 'nil'.
        if (!(InvalidationMethod != null) || I.$arrow().second.hasMethod(InvalidationMethod)) {
          IVars.erase(new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(I));
        }
      }
    }

    
    /// Checks if IvarRef refers to the tracked IVar, if yes, marks it as
    /// invalidated.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::checkObjCIvarRefExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 599,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::checkObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler20checkObjCIvarRefExprEPKN5clang15ObjCIvarRefExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler20checkObjCIvarRefExprEPKN5clang15ObjCIvarRefExprE")
    //</editor-fold>
    private void checkObjCIvarRefExpr(/*const*/ ObjCIvarRefExpr /*P*/ IvarRef) {
      {
        /*const*/ Decl /*P*/ D = IvarRef.getDecl$Const();
        if ((D != null)) {
          markInvalidated(cast_ObjCIvarDecl(D.getCanonicalDecl$Const()));
        }
      }
    }

    
    /// Checks if ObjCPropertyRefExpr refers to the tracked IVar, if yes, marks
    /// it as invalidated.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::checkObjCPropertyRefExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 616,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::checkObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler24checkObjCPropertyRefExprEPKN5clang19ObjCPropertyRefExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler24checkObjCPropertyRefExprEPKN5clang19ObjCPropertyRefExprE")
    //</editor-fold>
    private void checkObjCPropertyRefExpr(/*const*/ ObjCPropertyRefExpr /*P*/ PA) {
      if (PA.isExplicitProperty()) {
        /*const*/ ObjCPropertyDecl /*P*/ PD = PA.getExplicitProperty();
        if ((PD != null)) {
          PD = cast_ObjCPropertyDecl(PD.getCanonicalDecl$Const());
          DenseMapIterator</*const*/ ObjCPropertyDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > IvI = PropertyToIvarMap.find$Const(PD);
          if (IvI.$noteq(PropertyToIvarMap.end$Const())) {
            markInvalidated(IvI.$arrow().second);
          }
          return;
        }
      }
      if (PA.isImplicitProperty()) {
        /*const*/ ObjCMethodDecl /*P*/ MD = PA.getImplicitPropertySetter();
        if ((MD != null)) {
          MD = cast_ObjCMethodDecl(MD.getCanonicalDecl$Const());
          DenseMapIterator</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > IvI = PropertyGetterToIvarMap.find$Const(MD);
          if (IvI.$noteq(PropertyGetterToIvarMap.end$Const())) {
            markInvalidated(IvI.$arrow().second);
          }
          return;
        }
      }
    }

    
    /// Checks if ObjCMessageExpr refers to (is a getter for) the tracked IVar,
    /// if yes, marks it as invalidated.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::checkObjCMessageExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 605,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::checkObjCMessageExpr", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler20checkObjCMessageExprEPKN5clang15ObjCMessageExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler20checkObjCMessageExprEPKN5clang15ObjCMessageExprE")
    //</editor-fold>
    private void checkObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ ME) {
      /*const*/ ObjCMethodDecl /*P*/ MD = ME.getMethodDecl$Const();
      if ((MD != null)) {
        MD = cast_ObjCMethodDecl(MD.getCanonicalDecl$Const());
        DenseMapIterator</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > IvI = PropertyGetterToIvarMap.find$Const(MD);
        if (IvI.$noteq(PropertyGetterToIvarMap.end$Const())) {
          markInvalidated(IvI.$arrow().second);
        }
      }
    }

    
    /// Checks if the Expr refers to an ivar, if yes, marks it as invalidated.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::check">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 649,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::check", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler5checkEPKN5clang4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler5checkEPKN5clang4ExprE")
    //</editor-fold>
    private void check(/*const*/ Expr /*P*/ E) {
      E = peel(E);
      {
        
        /*const*/ ObjCIvarRefExpr /*P*/ IvarRef = dyn_cast_ObjCIvarRefExpr(E);
        if ((IvarRef != null)) {
          checkObjCIvarRefExpr(IvarRef);
          return;
        }
      }
      {
        
        /*const*/ ObjCPropertyRefExpr /*P*/ PropRef = dyn_cast_ObjCPropertyRefExpr(E);
        if ((PropRef != null)) {
          checkObjCPropertyRefExpr(PropRef);
          return;
        }
      }
      {
        
        /*const*/ ObjCMessageExpr /*P*/ MsgExpr = dyn_cast_ObjCMessageExpr(E);
        if ((MsgExpr != null)) {
          checkObjCMessageExpr(MsgExpr);
          return;
        }
      }
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::MethodCrawler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 146,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::MethodCrawler", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawlerC1ERN4llvm8DenseMapIPKN5clang12ObjCIvarDeclENS0_16InvalidationInfoENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S8_EEEERbRKNS3_IPKNS4_14ObjCMethodDeclES7_NS9_ISJ_EENSC_ISJ_S7_EEEESO_RKNS3_IPKNS4_16ObjCPropertyDeclES7_NS9_ISR_EENSC_ISR_S7_EEEERNS4_10ASTContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawlerC1ERN4llvm8DenseMapIPKN5clang12ObjCIvarDeclENS0_16InvalidationInfoENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S8_EEEERbRKNS3_IPKNS4_14ObjCMethodDeclES7_NS9_ISJ_EENSC_ISJ_S7_EEEESO_RKNS3_IPKNS4_16ObjCPropertyDeclES7_NS9_ISR_EENSC_ISR_S7_EEEERNS4_10ASTContextE")
    //</editor-fold>
    public MethodCrawler(final DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> /*&*/ InIVars, 
        final bool$ref/*bool &*/ InCalledAnotherInvalidationMethod, 
        final /*const*/DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > /*&*/ InPropertySetterToIvarMap, 
        final /*const*/DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > /*&*/ InPropertyGetterToIvarMap, 
        final /*const*/DenseMap</*const*/ ObjCPropertyDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > /*&*/ InPropertyToIvarMap, 
        final ASTContext /*&*/ InCtx) {
      // : ConstStmtVisitor<MethodCrawler>(), IVars(InIVars), CalledAnotherInvalidationMethod(InCalledAnotherInvalidationMethod), PropertySetterToIvarMap(InPropertySetterToIvarMap), PropertyGetterToIvarMap(InPropertyGetterToIvarMap), PropertyToIvarMap(InPropertyToIvarMap), InvalidationMethod(null), Ctx(InCtx) 
      //START JInit
      $ConstStmtVisitor();
      this./*&*/IVars=/*&*/InIVars;
      this./*&*/CalledAnotherInvalidationMethod=/*&*/InCalledAnotherInvalidationMethod;
      this./*&*/PropertySetterToIvarMap=/*&*/InPropertySetterToIvarMap;
      this./*&*/PropertyGetterToIvarMap=/*&*/InPropertyGetterToIvarMap;
      this./*&*/PropertyToIvarMap=/*&*/InPropertyToIvarMap;
      this.InvalidationMethod = null;
      this./*&*/Ctx=/*&*/InCtx;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 160,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitStmt", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler9VisitStmtEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler9VisitStmtEPKN5clang4StmtE")
    //</editor-fold>
    public void VisitStmt(/*const*/ Stmt /*P*/ S) {
      VisitChildren(S);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitBinaryOperator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 668,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
    //</editor-fold>
    public void VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ BO) {
      VisitStmt(BO);
      
      // Do we assign/compare against zero? If yes, check the variable we are
      // assigning to.
      BinaryOperatorKind Opcode = BO.getOpcode();
      if (Opcode != BinaryOperatorKind.BO_Assign
         && Opcode != BinaryOperatorKind.BO_EQ
         && Opcode != BinaryOperatorKind.BO_NE) {
        return;
      }
      if (isZero(BO.getRHS())) {
        check(BO.getLHS());
        return;
      }
      if (Opcode != BinaryOperatorKind.BO_Assign && isZero(BO.getLHS())) {
        check(BO.getRHS());
        return;
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitObjCMessageExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 691,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE")
    //</editor-fold>
    public void VisitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ ME) {
      /*const*/ ObjCMethodDecl /*P*/ MD = ME.getMethodDecl$Const();
      /*const*/ Expr /*P*/ Receiver = ME.getInstanceReceiver$Const();
      
      // Stop if we are calling '[self invalidate]'.
      if ((Receiver != null) && isInvalidationMethod(MD, /*LookForPartial*/ false)) {
        if (Receiver.isObjCSelfExpr()) {
          CalledAnotherInvalidationMethod.$set(true);
          return;
        }
      }
      
      // Check if we call a setter and set the property to 'nil'.
      if ((MD != null) && (ME.getNumArgs() == 1) && isZero(ME.getArg$Const(0))) {
        MD = cast_ObjCMethodDecl(MD.getCanonicalDecl$Const());
        DenseMapIterator</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > IvI = PropertySetterToIvarMap.find$Const(MD);
        if (IvI.$noteq(PropertySetterToIvarMap.end$Const())) {
          markInvalidated(IvI.$arrow().second);
          return;
        }
      }
      
      // Check if we call the 'invalidation' routine on the ivar.
      if ((Receiver != null)) {
        InvalidationMethod = MD;
        check(Receiver.IgnoreParenCasts$Const());
        InvalidationMethod = null;
      }
      
      VisitStmt(ME);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitChildren">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 166,
     FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::MethodCrawler::VisitChildren", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler13VisitChildrenEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl13MethodCrawler13VisitChildrenEPKN5clang4StmtE")
    //</editor-fold>
    public void VisitChildren(/*const*/ Stmt /*P*/ S) {
      for (/*const*/ Stmt /*P*/ Child : S.children$Const()) {
        if ((Child != null)) {
          /*J:ToBase*/ConstStmtVisitorVoid /*P*/ .super.Visit(Child);
        }
        if (CalledAnotherInvalidationMethod.$deref()) {
          return;
        }
      }
    }

    
    @Override public String toString() {
      return "" + "IVars=" + IVars // NOI18N
                + ", CalledAnotherInvalidationMethod=" + CalledAnotherInvalidationMethod // NOI18N
                + ", PropertySetterToIvarMap=" + PropertySetterToIvarMap // NOI18N
                + ", PropertyGetterToIvarMap=" + PropertyGetterToIvarMap // NOI18N
                + ", PropertyToIvarMap=" + PropertyToIvarMap // NOI18N
                + ", InvalidationMethod=" + InvalidationMethod // NOI18N
                + ", Ctx=" + "[ASTContext]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  /// Check if the any of the methods inside the interface are annotated with
  /// the invalidation annotation, update the IvarInfo accordingly.
  /// \param LookForPartial is set when we are searching for partial
  ///        invalidators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::containsInvalidationMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 239,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::containsInvalidationMethod", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl26containsInvalidationMethodEPKN5clang17ObjCContainerDeclERNS0_16InvalidationInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl26containsInvalidationMethodEPKN5clang17ObjCContainerDeclERNS0_16InvalidationInfoEb")
  //</editor-fold>
  private static void containsInvalidationMethod(/*const*/ ObjCContainerDecl /*P*/ D, final InvalidationInfo /*&*/ OutInfo, boolean Partial) {
    if (!(D != null)) {
      return;
    }
    assert (!isa_ObjCImplementationDecl(D));
    // TODO: Cache the results.
    
    // Check all methods.
    for (/*const*/ ObjCMethodDecl /*P*/ MDI : D.methods())  {
      if (isInvalidationMethod(MDI, Partial)) {
        OutInfo.addInvalidationMethod(cast_ObjCMethodDecl(MDI.getCanonicalDecl$Const()));
      }
    }
    {
      
      // If interface, check all parent protocols and super.
      /*const*/ ObjCInterfaceDecl /*P*/ InterfD = dyn_cast_ObjCInterfaceDecl(D);
      if ((InterfD != null)) {
        
        // Visit all protocols.
        for (/*const*/ ObjCProtocolDecl /*P*/ I : InterfD.protocols())  {
          containsInvalidationMethod(I.getDefinition$Const(), OutInfo, Partial);
        }
        
        // Visit all categories in case the invalidation method is declared in
        // a category.
        for (/*const*/ ObjCCategoryDecl /*P*/ Ext : InterfD.visible_extensions())  {
          containsInvalidationMethod(Ext, OutInfo, Partial);
        }
        
        containsInvalidationMethod(InterfD.getSuperClass(), OutInfo, Partial);
        return;
      }
    }
    {
      
      // If protocol, check all parent protocols.
      /*const*/ ObjCProtocolDecl /*P*/ ProtD = dyn_cast_ObjCProtocolDecl(D);
      if ((ProtD != null)) {
        for (/*const*/ ObjCProtocolDecl /*P*/ I : ProtD.protocols()) {
          containsInvalidationMethod(I.getDefinition$Const(), OutInfo, Partial);
        }
        return;
      }
    }
  }

  
  /// Check if ivar should be tracked and add to TrackedIvars if positive.
  /// Returns true if ivar should be tracked.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::trackIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 279,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::trackIvar", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl9trackIvarEPKN5clang12ObjCIvarDeclERN4llvm8DenseMapIS4_NS0_16InvalidationInfoENS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_S7_EEEEPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl9trackIvarEPKN5clang12ObjCIvarDeclERN4llvm8DenseMapIS4_NS0_16InvalidationInfoENS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_S7_EEEEPS4_")
  //</editor-fold>
  private static boolean trackIvar(/*const*/ ObjCIvarDecl /*P*/ Iv, 
           final DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> /*&*/ TrackedIvars, 
           type$ptr</*const*/ ObjCIvarDecl /*P*/ /*P*/> FirstIvarDecl) {
    InvalidationInfo Info = null;
    try {
      QualType IvQTy = Iv.getType();
      /*const*/ ObjCObjectPointerType /*P*/ IvTy = IvQTy.$arrow().getAs(ObjCObjectPointerType.class);
      if (!(IvTy != null)) {
        return false;
      }
      /*const*/ ObjCInterfaceDecl /*P*/ IvInterf = IvTy.getInterfaceDecl();
      
      Info/*J*/= new InvalidationInfo();
      containsInvalidationMethod(IvInterf, Info, /*LookForPartial*/ false);
      if (Info.needsInvalidation()) {
        /*const*/ ObjCIvarDecl /*P*/ I = cast_ObjCIvarDecl(Iv.getCanonicalDecl$Const());
        TrackedIvars.$at_T1$C$R(I).$assign(Info);
        if (!(FirstIvarDecl.$star() != null)) {
          FirstIvarDecl.$set(I);
        }
        return true;
      }
      return false;
    } finally {
      if (Info != null) { Info.$destroy(); }
    }
  }

  
  /// Given the property declaration, and the list of tracked ivars, finds
  /// the ivar backing the property when possible. Returns '0' when no such
  /// ivar could be found.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::findPropertyBackingIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 300,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::findPropertyBackingIvar", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl23findPropertyBackingIvarEPKN5clang16ObjCPropertyDeclEPKNS1_17ObjCInterfaceDeclERN4llvm8DenseMapIPKNS1_12ObjCIvarDeclENS0_16InvalidationInfoENS8_12DenseMapInfoISC_EENS8_6detail12DenseMapPairISC_SD_EEEEPSC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl23findPropertyBackingIvarEPKN5clang16ObjCPropertyDeclEPKNS1_17ObjCInterfaceDeclERN4llvm8DenseMapIPKNS1_12ObjCIvarDeclENS0_16InvalidationInfoENS8_12DenseMapInfoISC_EENS8_6detail12DenseMapPairISC_SD_EEEEPSC_")
  //</editor-fold>
  private static /*const*/ ObjCIvarDecl /*P*/ findPropertyBackingIvar(/*const*/ ObjCPropertyDecl /*P*/ Prop, 
                         /*const*/ ObjCInterfaceDecl /*P*/ InterfaceD, 
                         final DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> /*&*/ TrackedIvars, 
                         type$ptr</*const*/ ObjCIvarDecl /*P*/ /*P*/> FirstIvarDecl) {
    /*const*/ ObjCIvarDecl /*P*/ IvarD = null;
    
    // Lookup for the synthesized case.
    IvarD = Prop.getPropertyIvarDecl();
    // We only track the ivars/properties that are defined in the current
    // class (not the parent).
    if ((IvarD != null) && IvarD.getContainingInterface() == InterfaceD) {
      if ((TrackedIvars.count(IvarD) != 0)) {
        return IvarD;
      }
      // If the ivar is synthesized we still want to track it.
      if (trackIvar(IvarD, TrackedIvars, FirstIvarDecl)) {
        return IvarD;
      }
    }
    
    // Lookup IVars named "_PropName"or "PropName" among the tracked Ivars.
    StringRef PropName = Prop.getIdentifier().getName();
    for (DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> I = new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(TrackedIvars.begin()), 
        E = new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(TrackedIvars.end()); I.$noteq(E); I.$preInc()) {
      /*const*/ ObjCIvarDecl /*P*/ Iv = I.$arrow().first;
      StringRef IvarName = Iv.getName();
      if ($eq_StringRef(/*NO_COPY*/IvarName, /*NO_COPY*/PropName)) {
        return Iv;
      }
      
      SmallString/*128*/ PropNameWithUnderscore/*J*/= new SmallString/*128*/(128);
      {
        raw_svector_ostream os = null;
        try {
          os/*J*/= new raw_svector_ostream(PropNameWithUnderscore);
          os.$out_char($$UNDERSCORE).$out(/*NO_COPY*/PropName);
        } finally {
          if (os != null) { os.$destroy(); }
        }
      }
      if ($eq_StringRef(/*NO_COPY*/IvarName, PropNameWithUnderscore.$StringRef())) {
        return Iv;
      }
    }
    
    // Note, this is a possible source of false positives. We could look at the
    // getter implementation to find the ivar when its name is not derived from
    // the property name.
    return null;
  }

  
  /// Print ivar name or the property if the given ivar backs a property.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::printIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 345,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::printIvar", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl9printIvarERN4llvm19raw_svector_ostreamEPKN5clang12ObjCIvarDeclERKNS1_8DenseMapIS7_PKNS4_16ObjCPropertyDeclENS1_12DenseMapInfoIS7_EENS1_6detail12DenseMapPairIS7_SB_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImpl9printIvarERN4llvm19raw_svector_ostreamEPKN5clang12ObjCIvarDeclERKNS1_8DenseMapIS7_PKNS4_16ObjCPropertyDeclENS1_12DenseMapInfoIS7_EENS1_6detail12DenseMapPairIS7_SB_EEEE")
  //</editor-fold>
  private static void printIvar(final raw_svector_ostream /*&*/ os, 
           /*const*/ ObjCIvarDecl /*P*/ IvarDecl, 
           final /*const*/DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > /*&*/ IvarToPopertyMap) {
    if (IvarDecl.getSynthesize()) {
      /*const*/ ObjCPropertyDecl /*P*/ PD = IvarToPopertyMap.lookup(IvarDecl);
      assert ((PD != null)) : "Do we synthesize ivars for something other than properties?";
      os.$out(/*KEEP_STR*/"Property ").$out(PD.getName()).$out(/*KEEP_STR*/$SPACE);
    } else {
      os.$out(/*KEEP_STR*/"Instance variable ").$out(IvarDecl.getName()).$out(/*KEEP_STR*/$SPACE);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::reportNoInvalidationMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 529,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::reportNoInvalidationMethod", NM="_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl26reportNoInvalidationMethodEN5clang4ento9CheckNameEPKNS1_12ObjCIvarDeclERKN4llvm8DenseMapIS6_PKNS1_16ObjCPropertyDeclENS7_12DenseMapInfoIS6_EENS7_6detail12DenseMapPairIS6_SB_EEEEPKNS1_17ObjCInterfaceDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl26reportNoInvalidationMethodEN5clang4ento9CheckNameEPKNS1_12ObjCIvarDeclERKN4llvm8DenseMapIS6_PKNS1_16ObjCPropertyDeclENS7_12DenseMapInfoIS6_EENS7_6detail12DenseMapPairIS6_SB_EEEEPKNS1_17ObjCInterfaceDeclEb")
  //</editor-fold>
  private void reportNoInvalidationMethod(CheckName $CheckName, /*const*/ ObjCIvarDecl /*P*/ FirstIvarDecl, 
                            final /*const*/DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > /*&*/ IvarToPopertyMap, 
                            /*const*/ ObjCInterfaceDecl /*P*/ InterfaceD, boolean MissingDeclaration) /*const*/ {
    raw_svector_ostream os = null;
    try {
      SmallString/*128*/ sbuf/*J*/= new SmallString/*128*/(128);
      os/*J*/= new raw_svector_ostream(sbuf);
      assert Native.$bool(FirstIvarDecl);
      printIvar(os, FirstIvarDecl, IvarToPopertyMap);
      os.$out(/*KEEP_STR*/"needs to be invalidated; ");
      if (MissingDeclaration) {
        os.$out(/*KEEP_STR*/"no invalidation method is declared for ");
      } else {
        os.$out(/*KEEP_STR*/"no invalidation method is defined in the @implementation for ");
      }
      os.$out(InterfaceD.getName());
      
      PathDiagnosticLocation IvarDecLocation = PathDiagnosticLocation.createBegin(FirstIvarDecl, BR.getSourceManager());
      
      BR.EmitBasicReport(FirstIvarDecl, new CheckName($CheckName), new StringRef(/*KEEP_STR*/"Incomplete invalidation"), 
          new StringRef(categories.CoreFoundationObjectiveC), os.str(), 
          new PathDiagnosticLocation(IvarDecLocation));
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::reportIvarNeedsInvalidation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 552,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::reportIvarNeedsInvalidation", NM="_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl27reportIvarNeedsInvalidationEPKN5clang12ObjCIvarDeclERKN4llvm8DenseMapIS4_PKNS1_16ObjCPropertyDeclENS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_S9_EEEEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl27reportIvarNeedsInvalidationEPKN5clang12ObjCIvarDeclERKN4llvm8DenseMapIS4_PKNS1_16ObjCPropertyDeclENS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_S9_EEEEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  private void reportIvarNeedsInvalidation(/*const*/ ObjCIvarDecl /*P*/ IvarD, 
                             final /*const*/DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > /*&*/ IvarToPopertyMap, 
                             /*const*/ ObjCMethodDecl /*P*/ MethodD) /*const*/ {
    raw_svector_ostream os = null;
    try {
      SmallString/*128*/ sbuf/*J*/= new SmallString/*128*/(128);
      os/*J*/= new raw_svector_ostream(sbuf);
      printIvar(os, IvarD, IvarToPopertyMap);
      os.$out(/*KEEP_STR*/"needs to be invalidated or set to nil");
      if ((MethodD != null)) {
        PathDiagnosticLocation MethodDecLocation = PathDiagnosticLocation.createEnd(MethodD.getBody(), 
            BR.getSourceManager(), 
            new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, Mgr.getAnalysisDeclContext(MethodD)));
        BR.EmitBasicReport(MethodD, new CheckName(Filter.checkName_InstanceVariableInvalidation), 
            new StringRef(/*KEEP_STR*/"Incomplete invalidation"), 
            new StringRef(categories.CoreFoundationObjectiveC), os.str(), 
            new PathDiagnosticLocation(MethodDecLocation));
      } else {
        BR.EmitBasicReport(IvarD, new CheckName(Filter.checkName_InstanceVariableInvalidation), 
            new StringRef(/*KEEP_STR*/"Incomplete invalidation"), new StringRef(categories.CoreFoundationObjectiveC), 
            os.str(), 
            PathDiagnosticLocation.createBegin(IvarD, BR.getSourceManager()));
      }
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  private final AnalysisManager /*&*/ Mgr;
  private final BugReporter /*&*/ BR;
  /// Filter on the checks performed.
  private final /*const*/ ChecksFilter /*&*/ Filter;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::IvarInvalidationCheckerImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 219,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::IvarInvalidationCheckerImpl", NM="_ZN12_GLOBAL__N_127IvarInvalidationCheckerImplC1ERN5clang4ento15AnalysisManagerERNS2_11BugReporterERKNS_12ChecksFilterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZN12_GLOBAL__N_127IvarInvalidationCheckerImplC1ERN5clang4ento15AnalysisManagerERNS2_11BugReporterERKNS_12ChecksFilterE")
  //</editor-fold>
  public IvarInvalidationCheckerImpl(final AnalysisManager /*&*/ InMgr, 
      final BugReporter /*&*/ InBR, 
      final /*const*/ ChecksFilter /*&*/ InFilter) {
    // : Mgr(InMgr), BR(InBR), Filter(InFilter) 
    //START JInit
    this./*&*/Mgr=/*&*/InMgr;
    this./*&*/BR=/*&*/InBR;
    this./*&*/Filter=/*&*/InFilter;
    //END JInit
  }

  
  
  // Check that the invalidatable interfaces with ivars/properties implement the
  // invalidation methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::IvarInvalidationCheckerImpl::visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp", line = 359,
   FQN="(anonymous namespace)::IvarInvalidationCheckerImpl::visit", NM="_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl5visitEPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IvarInvalidationChecker.cpp -nm=_ZNK12_GLOBAL__N_127IvarInvalidationCheckerImpl5visitEPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  public void visit(/*const*/ ObjCImplementationDecl /*P*/ ImplD) /*const*/ {
    DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> Ivars = null;
    InvalidationInfo PartialInfo = null;
    InvalidationInfo Info = null;
    try {
      // Collect all ivars that need cleanup.
      Ivars/*J*/= new DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(DenseMapInfo$LikePtr.$Info(), new InvalidationInfo());
      // Record the first Ivar needing invalidation; used in reporting when only
      // one ivar is sufficient. Cannot grab the first on the Ivars set to ensure
      // deterministic output.
      type$ptr</*const*/ ObjCIvarDecl /*P*/ > FirstIvarDecl = create_type$null$ptr(null);
      /*const*/ ObjCInterfaceDecl /*P*/ InterfaceD = ImplD.getClassInterface$Const();
      
      // Collect ivars declared in this class, its extensions and its implementation
      ObjCInterfaceDecl /*P*/ IDecl = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(InterfaceD));
      for (/*const*/ ObjCIvarDecl /*P*/ Iv = IDecl.all_declared_ivar_begin(); (Iv != null);
           Iv = Iv.getNextIvar$Const())  {
        trackIvar(Iv, Ivars, $AddrOf(FirstIvarDecl));
      }
      
      // Construct Property/Property Accessor to Ivar maps to assist checking if an
      // ivar which is backing a property has been reset.
      DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > PropSetterToIvarMap/*J*/= new DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ObjCIvarDecl /*P*/ )null);
      DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > PropGetterToIvarMap/*J*/= new DenseMap</*const*/ ObjCMethodDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ObjCIvarDecl /*P*/ )null);
      DenseMap</*const*/ ObjCPropertyDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ > PropertyToIvarMap/*J*/= new DenseMap</*const*/ ObjCPropertyDecl /*P*/ , /*const*/ ObjCIvarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ObjCIvarDecl /*P*/ )null);
      DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > IvarToPopertyMap/*J*/= new DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ObjCPropertyDecl /*P*/ )null);
      
      DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > PropMap/*J*/= new DenseMap<>(DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);      
      SmallVector<ObjCPropertyDecl /*P*/ > PropOrder/*J*/= new SmallVector<ObjCPropertyDecl /*P*/ >(8, (ObjCPropertyDecl /*P*/ )null);
      InterfaceD.collectPropertiesToImplement(PropMap, PropOrder);
      
      for (DenseMapIterator<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > I = PropMap.begin(), E = PropMap.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
        /*const*/ ObjCPropertyDecl /*P*/ PD = I.$arrow().second;
        if (PD.isClassProperty()) {
          continue;
        }
        
        /*const*/ ObjCIvarDecl /*P*/ ID = findPropertyBackingIvar(PD, InterfaceD, Ivars, 
            $AddrOf(FirstIvarDecl));
        if (!(ID != null)) {
          continue;
        }
        
        // Store the mappings.
        PD = cast_ObjCPropertyDecl(PD.getCanonicalDecl$Const());
        PropertyToIvarMap.$set(PD, ID);
        IvarToPopertyMap.$set(ID, PD);
        
        // Find the setter and the getter.
        /*const*/ ObjCMethodDecl /*P*/ SetterD = PD.getSetterMethodDecl();
        if ((SetterD != null)) {
          SetterD = cast_ObjCMethodDecl(SetterD.getCanonicalDecl$Const());
          PropSetterToIvarMap.$set(SetterD, ID);
        }
        
        /*const*/ ObjCMethodDecl /*P*/ GetterD = PD.getGetterMethodDecl();
        if ((GetterD != null)) {
          GetterD = cast_ObjCMethodDecl(GetterD.getCanonicalDecl$Const());
          PropGetterToIvarMap.$set(GetterD, ID);
        }
      }
      
      // If no ivars need invalidation, there is nothing to check here.
      if (Ivars.empty()) {
        return;
      }
      
      // Find all partial invalidation methods.
      PartialInfo/*J*/= new InvalidationInfo();
      containsInvalidationMethod(InterfaceD, PartialInfo, /*LookForPartial*/ true);
      
      // Remove ivars invalidated by the partial invalidation methods. They do not
      // need to be invalidated in the regular invalidation methods.
      boolean AtImplementationContainsAtLeastOnePartialInvalidationMethod = false;
      for (type$iterator<?, /*const*/ ObjCMethodDecl /*P*/ /*const*/ /*P*/> I = $tryClone(PartialInfo.InvalidationMethods.begin()), 
          /*P*/ E = $tryClone(PartialInfo.InvalidationMethods.end()); $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ ObjCMethodDecl /*P*/ InterfD = I.$star();
        
        // Get the corresponding method in the @implementation.
        /*const*/ ObjCMethodDecl /*P*/ D = ImplD.getMethod(InterfD.getSelector(), 
            InterfD.isInstanceMethod());
        if ((D != null) && D.hasBody()) {
          AtImplementationContainsAtLeastOnePartialInvalidationMethod = true;
          
          bool$ref CalledAnotherInvalidationMethod = create_bool$ref(false);
          // The MethodCrowler is going to remove the invalidated ivars.
          new MethodCrawler(Ivars, 
              CalledAnotherInvalidationMethod, 
              PropSetterToIvarMap, 
              PropGetterToIvarMap, 
              PropertyToIvarMap, 
              BR.getContext()).VisitStmt(D.getBody());
          // If another invalidation method was called, trust that full invalidation
          // has occurred.
          if (CalledAnotherInvalidationMethod.$deref()) {
            Ivars.clear();
          }
        }
      }
      
      // If all ivars have been invalidated by partial invalidators, there is
      // nothing to check here.
      if (Ivars.empty()) {
        return;
      }
      
      // Find all invalidation methods in this @interface declaration and parents.
      Info/*J*/= new InvalidationInfo();
      containsInvalidationMethod(InterfaceD, Info, /*LookForPartial*/ false);
      
      // Report an error in case none of the invalidation methods are declared.
      if (!Info.needsInvalidation() && !PartialInfo.needsInvalidation()) {
        if (Filter.check_MissingInvalidationMethod.$ConstBoolRef()) {
          reportNoInvalidationMethod(new CheckName(Filter.checkName_MissingInvalidationMethod), 
              FirstIvarDecl.$star(), IvarToPopertyMap, InterfaceD, 
              /*MissingDeclaration*/ true);
        }
        // If there are no invalidation methods, there is no ivar validation work
        // to be done.
        return;
      }
      
      // Only check if Ivars are invalidated when InstanceVariableInvalidation
      // has been requested.
      if (!Filter.check_InstanceVariableInvalidation.$ConstBoolRef()) {
        return;
      }
      
      // Check that all ivars are invalidated by the invalidation methods.
      boolean AtImplementationContainsAtLeastOneInvalidationMethod = false;
      for (type$iterator<?, /*const*/ ObjCMethodDecl /*P*/ /*const*/ /*P*/> I = $tryClone(Info.InvalidationMethods.begin()), 
          /*P*/ E = $tryClone(Info.InvalidationMethods.end()); $noteq_ptr(I, E); I.$preInc()) {
        /*const*/ ObjCMethodDecl /*P*/ InterfD = I.$star();
        
        // Get the corresponding method in the @implementation.
        /*const*/ ObjCMethodDecl /*P*/ D = ImplD.getMethod(InterfD.getSelector(), 
            InterfD.isInstanceMethod());
        if ((D != null) && D.hasBody()) {
          AtImplementationContainsAtLeastOneInvalidationMethod = true;
          
          // Get a copy of ivars needing invalidation.
          DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> IvarsI = new DenseMap</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(Ivars);
          
          bool$ref CalledAnotherInvalidationMethod =  create_bool$ref(false);
          new MethodCrawler(IvarsI, 
              CalledAnotherInvalidationMethod, 
              PropSetterToIvarMap, 
              PropGetterToIvarMap, 
              PropertyToIvarMap, 
              BR.getContext()).VisitStmt(D.getBody());
          // If another invalidation method was called, trust that full invalidation
          // has occurred.
          if (CalledAnotherInvalidationMethod.$deref()) {
            continue;
          }
          
          // Warn on the ivars that were not invalidated by the method.
          for (DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> I$1 = new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(IvarsI.begin()), E$1 = new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(IvarsI.end()); I$1.$noteq(E$1); I$1.$preInc())  {
            reportIvarNeedsInvalidation(I$1.$arrow().first, IvarToPopertyMap, D);
          }
        }
      }
      
      // Report an error in case none of the invalidation methods are implemented.
      if (!AtImplementationContainsAtLeastOneInvalidationMethod) {
        if (AtImplementationContainsAtLeastOnePartialInvalidationMethod) {
          // Warn on the ivars that were not invalidated by the prrtial
          // invalidation methods.
          for (DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo> I = new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(Ivars.begin()), E = new DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , InvalidationInfo>(Ivars.end()); I.$noteq(E); I.$preInc())  {
            reportIvarNeedsInvalidation(I.$arrow().first, IvarToPopertyMap, (/*const*/ ObjCMethodDecl /*P*/ )null);
          }
        } else {
          // Otherwise, no invalidation methods were implemented.
          reportNoInvalidationMethod(new CheckName(Filter.checkName_InstanceVariableInvalidation), 
              FirstIvarDecl.$star(), IvarToPopertyMap, InterfaceD, 
              /*MissingDeclaration*/ false);
        }
      }
    } finally {
      if (Info != null) { Info.$destroy(); }
      if (PartialInfo != null) { PartialInfo.$destroy(); }
      if (Ivars != null) { Ivars.$destroy(); }
    }
  }

  
  @Override public String toString() {
    return "" + "Mgr=" + "[AnalysisManager]" // NOI18N
              + ", BR=" + BR // NOI18N
              + ", Filter=" + Filter; // NOI18N
  }
}
