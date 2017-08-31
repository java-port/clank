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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


// Basically just a very focused copy of TreeTransform.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 47,
 FQN="(anonymous namespace)::Rebuilder", NM="_ZN12_GLOBAL__N_19RebuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19RebuilderE")
//</editor-fold>
public class/*struct*/ Rebuilder {
  public final Sema /*&*/ S;
  public /*uint*/int MSPropertySubscriptCount;
  /*typedef llvm::function_ref<Expr *(Expr *, unsigned int)> SpecificRebuilderRefTy*/
//  public final class SpecificRebuilderRefTy extends ExprUnsigned2Expr<Expr>{ };
  public final /*const*/ ExprUnsigned2Expr<Expr> /*&*/ SpecificCallback;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder::Rebuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 52,
   FQN="(anonymous namespace)::Rebuilder::Rebuilder", NM="_ZN12_GLOBAL__N_19RebuilderC1ERN5clang4SemaERKN4llvm12function_refIFPNS1_4ExprES7_jEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19RebuilderC1ERN5clang4SemaERKN4llvm12function_refIFPNS1_4ExprES7_jEEE")
  //</editor-fold>
  public Rebuilder(final Sema /*&*/ S, final /*const*/ ExprUnsigned2Expr<Expr> /*&*/ SpecificCallback) {
    // : S(S), MSPropertySubscriptCount(0), SpecificCallback(SpecificCallback) 
    //START JInit
    this./*&*/S=/*&*/S;
    this.MSPropertySubscriptCount = 0;
    this./*&*/SpecificCallback=/*&*/SpecificCallback;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder::rebuildObjCPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 56,
   FQN="(anonymous namespace)::Rebuilder::rebuildObjCPropertyRefExpr", NM="_ZN12_GLOBAL__N_19Rebuilder26rebuildObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19Rebuilder26rebuildObjCPropertyRefExprEPN5clang19ObjCPropertyRefExprE")
  //</editor-fold>
  public Expr /*P*/ rebuildObjCPropertyRefExpr(ObjCPropertyRefExpr /*P*/ refExpr) {
    // Fortunately, the constraint that we're rebuilding something
    // with a base limits the number of cases here.
    if (refExpr.isClassReceiver() || refExpr.isSuperReceiver()) {
      return refExpr;
    }
    if (refExpr.isExplicitProperty()) {
      return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(refExpr.getExplicitProperty(), refExpr.getType(), 
          refExpr.getValueKind(), refExpr.getObjectKind(), 
          refExpr.getLocation(), SpecificCallback.$call(refExpr.getBase(), 0)));
    }
    return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCPropertyRefExpr(refExpr.getImplicitPropertyGetter(), 
        refExpr.getImplicitPropertySetter(), refExpr.getType(), 
        refExpr.getValueKind(), refExpr.getObjectKind(), 
        refExpr.getLocation(), SpecificCallback.$call(refExpr.getBase(), 0)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder::rebuildObjCSubscriptRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 74,
   FQN="(anonymous namespace)::Rebuilder::rebuildObjCSubscriptRefExpr", NM="_ZN12_GLOBAL__N_19Rebuilder27rebuildObjCSubscriptRefExprEPN5clang20ObjCSubscriptRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19Rebuilder27rebuildObjCSubscriptRefExprEPN5clang20ObjCSubscriptRefExprE")
  //</editor-fold>
  public Expr /*P*/ rebuildObjCSubscriptRefExpr(ObjCSubscriptRefExpr /*P*/ refExpr) {
    assert Native.$bool(refExpr.getBaseExpr());
    assert Native.$bool(refExpr.getKeyExpr());
    
    return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ObjCSubscriptRefExpr(SpecificCallback.$call(refExpr.getBaseExpr(), 0), 
        SpecificCallback.$call(refExpr.getKeyExpr(), 1), refExpr.getType(), 
        refExpr.getValueKind(), refExpr.getObjectKind(), 
        refExpr.getAtIndexMethodDecl(), refExpr.setAtIndexMethodDecl(), 
        refExpr.getRBracket()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder::rebuildMSPropertyRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 85,
   FQN="(anonymous namespace)::Rebuilder::rebuildMSPropertyRefExpr", NM="_ZN12_GLOBAL__N_19Rebuilder24rebuildMSPropertyRefExprEPN5clang17MSPropertyRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19Rebuilder24rebuildMSPropertyRefExprEPN5clang17MSPropertyRefExprE")
  //</editor-fold>
  public Expr /*P*/ rebuildMSPropertyRefExpr(MSPropertyRefExpr /*P*/ refExpr) {
    assert Native.$bool(refExpr.getBaseExpr());
    
    return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new MSPropertyRefExpr(SpecificCallback.$call(refExpr.getBaseExpr(), 0), 
        refExpr.getPropertyDecl(), refExpr.isArrow(), refExpr.getType(), 
        refExpr.getValueKind(), refExpr.getQualifierLoc(), 
        refExpr.getMemberLoc()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder::rebuildMSPropertySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 94,
   FQN="(anonymous namespace)::Rebuilder::rebuildMSPropertySubscriptExpr", NM="_ZN12_GLOBAL__N_19Rebuilder30rebuildMSPropertySubscriptExprEPN5clang23MSPropertySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19Rebuilder30rebuildMSPropertySubscriptExprEPN5clang23MSPropertySubscriptExprE")
  //</editor-fold>
  public Expr /*P*/ rebuildMSPropertySubscriptExpr(MSPropertySubscriptExpr /*P*/ refExpr) {
    assert Native.$bool(refExpr.getBase());
    assert Native.$bool(refExpr.getIdx());
    
    Expr /*P*/ NewBase = rebuild(refExpr.getBase());
    ++MSPropertySubscriptCount;
    return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new MSPropertySubscriptExpr(NewBase, 
        SpecificCallback.$call(refExpr.getIdx(), MSPropertySubscriptCount), 
        refExpr.getType(), refExpr.getValueKind(), refExpr.getObjectKind(), 
        refExpr.getRBracketLoc()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Rebuilder::rebuild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 107,
   FQN="(anonymous namespace)::Rebuilder::rebuild", NM="_ZN12_GLOBAL__N_19Rebuilder7rebuildEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_19Rebuilder7rebuildEPN5clang4ExprE")
  //</editor-fold>
  public Expr /*P*/ rebuild(Expr /*P*/ e) {
    {
      // Fast path: nothing to look through.
      ObjCPropertyRefExpr /*P*/ PRE = dyn_cast_ObjCPropertyRefExpr(e);
      if ((PRE != null)) {
        return rebuildObjCPropertyRefExpr(PRE);
      }
    }
    {
      ObjCSubscriptRefExpr /*P*/ SRE = dyn_cast_ObjCSubscriptRefExpr(e);
      if ((SRE != null)) {
        return rebuildObjCSubscriptRefExpr(SRE);
      }
    }
    {
      MSPropertyRefExpr /*P*/ MSPRE = dyn_cast_MSPropertyRefExpr(e);
      if ((MSPRE != null)) {
        return rebuildMSPropertyRefExpr(MSPRE);
      }
    }
    {
      MSPropertySubscriptExpr /*P*/ MSPSE = dyn_cast_MSPropertySubscriptExpr(e);
      if ((MSPSE != null)) {
        return rebuildMSPropertySubscriptExpr(MSPSE);
      }
    }
    {
      
      // Otherwise, we should look through and rebuild anything that
      // IgnoreParens would.
      ParenExpr /*P*/ parens = dyn_cast_ParenExpr(e);
      if ((parens != null)) {
        e = rebuild(parens.getSubExpr());
        final Expr /*P*/ L$e = e;
        return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ParenExpr(parens.getLParen(), 
            parens.getRParen(), 
            L$e));
      }
    }
    {
      
      UnaryOperator /*P*/ uop = dyn_cast_UnaryOperator(e);
      if ((uop != null)) {
        assert (uop.getOpcode() == UnaryOperatorKind.UO_Extension);
        e = rebuild(uop.getSubExpr());
        final Expr /*P*/ L$e = e;
        return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new UnaryOperator(L$e, uop.getOpcode(), 
            uop.getType(), 
            uop.getValueKind(), 
            uop.getObjectKind(), 
            uop.getOperatorLoc()));
      }
    }
    {
      
      GenericSelectionExpr /*P*/ gse = dyn_cast_GenericSelectionExpr(e);
      if ((gse != null)) {
        assert (!gse.isResultDependent());
        /*uint*/int resultIndex = gse.getResultIndex();
        /*uint*/int numAssocs = gse.getNumAssocs();
        
        SmallVector<Expr /*P*/ > assocs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, numAssocs, (Expr /*P*/ )null);
        SmallVector<TypeSourceInfo /*P*/ > assocTypes/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, numAssocs, (TypeSourceInfo /*P*/ )null);
        
        for (/*uint*/int i = 0; i != numAssocs; ++i) {
          Expr /*P*/ assoc = gse.getAssocExpr(i);
          if (i == resultIndex) {
            assoc = rebuild(assoc);
          }
          assocs.$set(i, assoc);
          assocTypes.$set(i, gse.getAssocTypeSourceInfo(i));
        }
        
        return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new GenericSelectionExpr(S.Context, 
            gse.getGenericLoc(), 
            gse.getControllingExpr(), 
            new ArrayRef<TypeSourceInfo /*P*/ >(assocTypes, true), 
            new ArrayRef<Expr /*P*/ >(assocs, true), 
            gse.getDefaultLoc(), 
            gse.getRParenLoc(), 
            gse.containsUnexpandedParameterPack(), 
            resultIndex));
      }
    }
    {
      
      ChooseExpr /*P*/ ce = dyn_cast_ChooseExpr(e);
      if ((ce != null)) {
        assert (!ce.isConditionDependent());
        
        type$ptr<Expr> /*P*/ LHS = create_type$ptr(ce.getLHS()), /*P*/ RHS = create_type$ptr(ce.getRHS());
        final type$ptr<Expr /*P*/ /*&*/> rebuiltExpr = ce.isConditionTrue() ? LHS : RHS;
        rebuiltExpr.$set(rebuild(rebuiltExpr.$star()));
        
        return /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new ChooseExpr(ce.getBuiltinLoc(), 
            ce.getCond(), 
            LHS.$star(), RHS.$star(),
            rebuiltExpr./*->*/$star().getType(), 
            rebuiltExpr./*->*/$star().getValueKind(), 
            rebuiltExpr./*->*/$star().getObjectKind(), 
            ce.getRParenLoc(), 
            ce.isConditionTrue(), 
            rebuiltExpr./*->*/$star().isTypeDependent(), 
            rebuiltExpr./*->*/$star().isValueDependent()));
      }
    }
    throw new llvm_unreachable("bad expression to rebuild!");
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", MSPropertySubscriptCount=" + MSPropertySubscriptCount // NOI18N
              + ", SpecificCallback=" + SpecificCallback; // NOI18N
  }
}
