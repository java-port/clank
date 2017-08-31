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

package org.clang.ast;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;

/// UnaryExprOrTypeTraitExpr - expression with either a type or (unevaluated)
/// expression operand.  Used for sizeof/alignof (C99 6.5.3.4) and
/// vec_step (OpenCL 1.1 6.11.12).
//<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1974,
 FQN="clang::UnaryExprOrTypeTraitExpr", NM="_ZN5clang24UnaryExprOrTypeTraitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExprE")
//</editor-fold>
public class UnaryExprOrTypeTraitExpr extends /*public*/ Expr {
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1975,
   FQN="clang::UnaryExprOrTypeTraitExpr::(anonymous)", NM="_ZN5clang24UnaryExprOrTypeTraitExprE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExprE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public TypeSourceInfo /*P*/ Ty;
    public Stmt /*P*/ Ex;
    //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1975,
     FQN="clang::UnaryExprOrTypeTraitExpr::(anonymous union)::", NM="_ZN5clang24UnaryExprOrTypeTraitExprUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExprUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union1() {
    }

    
    @Override public String toString() {
      return "" + "Ty=" + Ty // NOI18N
                + ", Ex=" + Ex; // NOI18N
    }
  };
  private Unnamed_union1 Argument;
  private SourceLocation OpLoc;
  private SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::UnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1982,
   FQN="clang::UnaryExprOrTypeTraitExpr::UnaryExprOrTypeTraitExpr", NM="_ZN5clang24UnaryExprOrTypeTraitExprC1ENS_20UnaryExprOrTypeTraitEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExprC1ENS_20UnaryExprOrTypeTraitEPNS_14TypeSourceInfoENS_8QualTypeENS_14SourceLocationES5_")
  //</editor-fold>
  public UnaryExprOrTypeTraitExpr(UnaryExprOrTypeTrait ExprKind, TypeSourceInfo /*P*/ TInfo, 
      QualType resultType, SourceLocation op, 
      SourceLocation rp) {
    // : Expr(UnaryExprOrTypeTraitExprClass, resultType, VK_RValue, OK_Ordinary, false, TInfo->getType()->isDependentType(), TInfo->getType()->isInstantiationDependentType(), TInfo->getType()->containsUnexpandedParameterPack()), Argument(), OpLoc(op), RParenLoc(rp) 
    //START JInit
    super(StmtClass.UnaryExprOrTypeTraitExprClass, new QualType(resultType), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false,  // Never type-dependent (C++ [temp.dep.expr]p3).
        // Value-dependent if the argument is type-dependent.
        TInfo.getType().$arrow().isDependentType(), 
        TInfo.getType().$arrow().isInstantiationDependentType(), 
        TInfo.getType().$arrow().containsUnexpandedParameterPack());
    this.Argument = new Unnamed_union1();
    this.OpLoc = new SourceLocation(op);
    this.RParenLoc = new SourceLocation(rp);
    //END JInit
    Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind = $uint2uint_2bits(ExprKind.getValue());
    Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType = true;
    Argument.Ty = TInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::UnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1364,
   FQN="clang::UnaryExprOrTypeTraitExpr::UnaryExprOrTypeTraitExpr", NM="_ZN5clang24UnaryExprOrTypeTraitExprC1ENS_20UnaryExprOrTypeTraitEPNS_4ExprENS_8QualTypeENS_14SourceLocationES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExprC1ENS_20UnaryExprOrTypeTraitEPNS_4ExprENS_8QualTypeENS_14SourceLocationES5_")
  //</editor-fold>
  public UnaryExprOrTypeTraitExpr(UnaryExprOrTypeTrait ExprKind, Expr /*P*/ E, QualType resultType, 
      SourceLocation op, SourceLocation rp) {
    // : Expr(UnaryExprOrTypeTraitExprClass, resultType, VK_RValue, OK_Ordinary, false, E->isTypeDependent(), E->isInstantiationDependent(), E->containsUnexpandedParameterPack()), Argument(), OpLoc(op), RParenLoc(rp) 
    //START JInit
    super(StmtClass.UnaryExprOrTypeTraitExprClass, new QualType(resultType), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false,  // Never type-dependent (C++ [temp.dep.expr]p3).
        // Value-dependent if the argument is type-dependent.
        E.isTypeDependent(), E.isInstantiationDependent(), 
        E.containsUnexpandedParameterPack());
    this.Argument = new Unnamed_union1();
    this.OpLoc = new SourceLocation(op);
    this.RParenLoc = new SourceLocation(rp);
    //END JInit
    Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind = $uint2uint_2bits(ExprKind.getValue());
    Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType = false;
    Argument.Ex = E;
    
    // Check to see if we are in the situation where alignof(decl) should be
    // dependent because decl's alignment is dependent.
    if (ExprKind == UnaryExprOrTypeTrait.UETT_AlignOf) {
      if (!isValueDependent() || !isInstantiationDependent()) {
        E = E.IgnoreParens();
        
        /*const*/ ValueDecl /*P*/ D = null;
        {
          /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
          if ((DRE != null)) {
            D = DRE.getDecl$Const();
          } else {
            /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
            if ((ME != null)) {
              D = ME.getMemberDecl();
            }
          }
        }
        if ((D != null)) {
          for (/*const*/ AlignedAttr /*P*/ I : D.specific_attrs(AlignedAttr.class)) {
            if (I.isAlignmentDependent()) {
              setValueDependent(true);
              setInstantiationDependent(true);
              break;
            }
          }
        }
      }
    }
  }

  
  /// \brief Construct an empty sizeof/alignof expression.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::UnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2002,
   FQN="clang::UnaryExprOrTypeTraitExpr::UnaryExprOrTypeTraitExpr", NM="_ZN5clang24UnaryExprOrTypeTraitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ UnaryExprOrTypeTraitExpr(EmptyShell Empty) {
    // : Expr(UnaryExprOrTypeTraitExprClass, Empty), Argument(), OpLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.UnaryExprOrTypeTraitExprClass, new EmptyShell(Empty));
    this.Argument = new Unnamed_union1();
    this.OpLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2005,
   FQN="clang::UnaryExprOrTypeTraitExpr::getKind", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr7getKindEv")
  //</editor-fold>
  public UnaryExprOrTypeTrait getKind() /*const*/ {
    return /*static_cast*/UnaryExprOrTypeTrait.valueOf(Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::setKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2008,
   FQN="clang::UnaryExprOrTypeTraitExpr::setKind", NM="_ZN5clang24UnaryExprOrTypeTraitExpr7setKindENS_20UnaryExprOrTypeTraitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr7setKindENS_20UnaryExprOrTypeTraitE")
  //</editor-fold>
  public void setKind(UnaryExprOrTypeTrait K) {
    Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind = $uint2uint_2bits(K.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::isArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2010,
   FQN="clang::UnaryExprOrTypeTraitExpr::isArgumentType", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr14isArgumentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr14isArgumentTypeEv")
  //</editor-fold>
  public boolean isArgumentType() /*const*/ {
    return Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2011,
   FQN="clang::UnaryExprOrTypeTraitExpr::getArgumentType", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr15getArgumentTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr15getArgumentTypeEv")
  //</editor-fold>
  public QualType getArgumentType() /*const*/ {
    return getArgumentTypeInfo().getType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getArgumentTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2014,
   FQN="clang::UnaryExprOrTypeTraitExpr::getArgumentTypeInfo", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr19getArgumentTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr19getArgumentTypeInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getArgumentTypeInfo() /*const*/ {
    assert (isArgumentType()) : "calling getArgumentType() when arg is expr";
    return Argument.Ty;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getArgumentExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2018,
   FQN="clang::UnaryExprOrTypeTraitExpr::getArgumentExpr", NM="_ZN5clang24UnaryExprOrTypeTraitExpr15getArgumentExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr15getArgumentExprEv")
  //</editor-fold>
  public Expr /*P*/ getArgumentExpr() {
    assert (!isArgumentType()) : "calling getArgumentExpr() when arg is type";
    return ((/*static_cast*/Expr /*P*/ )(Argument.Ex));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getArgumentExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2022,
   FQN="clang::UnaryExprOrTypeTraitExpr::getArgumentExpr", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr15getArgumentExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr15getArgumentExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArgumentExpr$Const() /*const*/ {
    return ((/*const_cast*/UnaryExprOrTypeTraitExpr /*P*/ )(this)).getArgumentExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::setArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2026,
   FQN="clang::UnaryExprOrTypeTraitExpr::setArgument", NM="_ZN5clang24UnaryExprOrTypeTraitExpr11setArgumentEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr11setArgumentEPNS_4ExprE")
  //</editor-fold>
  public void setArgument(Expr /*P*/ E) {
    Argument.Ex = E;
    Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType = false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::setArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2030,
   FQN="clang::UnaryExprOrTypeTraitExpr::setArgument", NM="_ZN5clang24UnaryExprOrTypeTraitExpr11setArgumentEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr11setArgumentEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setArgument(TypeSourceInfo /*P*/ TInfo) {
    Argument.Ty = TInfo;
    Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType = true;
  }

  
  /// Gets the argument type, or the type of the argument expression, whichever
  /// is appropriate.
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getTypeOfArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2037,
   FQN="clang::UnaryExprOrTypeTraitExpr::getTypeOfArgument", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr17getTypeOfArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr17getTypeOfArgumentEv")
  //</editor-fold>
  public QualType getTypeOfArgument() /*const*/ {
    return isArgumentType() ? getArgumentType() : getArgumentExpr$Const().getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2041,
   FQN="clang::UnaryExprOrTypeTraitExpr::getOperatorLoc", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::setOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2042,
   FQN="clang::UnaryExprOrTypeTraitExpr::setOperatorLoc", NM="_ZN5clang24UnaryExprOrTypeTraitExpr14setOperatorLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr14setOperatorLocENS_14SourceLocationE")
  //</editor-fold>
  public void setOperatorLoc(SourceLocation L) {
    OpLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2044,
   FQN="clang::UnaryExprOrTypeTraitExpr::getRParenLoc", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2045,
   FQN="clang::UnaryExprOrTypeTraitExpr::setRParenLoc", NM="_ZN5clang24UnaryExprOrTypeTraitExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation L) {
    RParenLoc.$assign(L);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2047,
   FQN="clang::UnaryExprOrTypeTraitExpr::getLocStart", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(OpLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2048,
   FQN="clang::UnaryExprOrTypeTraitExpr::getLocEnd", NM="_ZNK5clang24UnaryExprOrTypeTraitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang24UnaryExprOrTypeTraitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 2050,
   FQN="clang::UnaryExprOrTypeTraitExpr::classof", NM="_ZN5clang24UnaryExprOrTypeTraitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.UnaryExprOrTypeTraitExprClass;
  }

  
  // Iterators
  
  //===----------------------------------------------------------------------===//
  //  Child Iterators for iterating over subexpressions/substatements
  //===----------------------------------------------------------------------===//
  
  // UnaryExprOrTypeTraitExpr
  //<editor-fold defaultstate="collapsed" desc="clang::UnaryExprOrTypeTraitExpr::children">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3807,
   FQN="clang::UnaryExprOrTypeTraitExpr::children", NM="_ZN5clang24UnaryExprOrTypeTraitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang24UnaryExprOrTypeTraitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    // If this is of a type and the type is a VLA type (and not a typedef), the
    // size expression of the VLA needs to be treated as an executable expression.
    // Why isn't this weirdness documented better in StmtIterator?
    if (isArgumentType()) {
      {
        /*const*/ VariableArrayType /*P*/ T = dyn_cast_VariableArrayType(getArgumentType().getTypePtr());
        if ((T != null)) {
          return new iterator_range<Stmt/*P*/>(new StmtIterator(T), new StmtIterator());
        }
      }
      return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
    }
    return new iterator_range<Stmt/*P*/>(new StmtIterator(create_type$ptr($AddrOf(Argument.Ex))), new StmtIterator(create_type$ptr($AddrOf(Argument.Ex)).$add(1)));
  }

  
  @Override public String toString() {
    return "" + "Argument=" + Argument // NOI18N
              + ", OpLoc=" + OpLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
