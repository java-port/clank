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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a C11 generic selection.
///
/// A generic selection (C11 6.5.1.1) contains an unevaluated controlling
/// expression, followed by one or more generic associations.  Each generic
/// association specifies a type name and an expression, or "default" and an
/// expression (in which case it is known as a default generic association).
/// The type and value of the generic selection are identical to those of its
/// result expression, which is defined as the expression in the generic
/// association with a type name that is compatible with the type of the
/// controlling expression, or the expression in the default generic association
/// if no types are compatible.  For example:
///
/// @code
/// _Generic(X, double: 1, float: 2, default: 3)
/// @endcode
///
/// The above expression evaluates to 1 if 1.0 is substituted for X, 2 if 1.0f
/// or 3 if "hello".
///
/// As an extension, generic selections are allowed in C++, where the following
/// additional semantics apply:
///
/// Any generic selection whose controlling expression is type-dependent or
/// which names a dependent type in its association list is result-dependent,
/// which means that the choice of result expression is dependent.
/// Result-dependent generic associations are both type- and value-dependent.
//<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4413,
 FQN="clang::GenericSelectionExpr", NM="_ZN5clang20GenericSelectionExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExprE")
//</editor-fold>
public class GenericSelectionExpr extends /*public*/ Expr {
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4414,
   FQN="clang::GenericSelectionExpr::(anonymous)", NM="_ZN5clang20GenericSelectionExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExprE_Unnamed_enum")
  //</editor-fold>
  /*friend*/public enum Unnamed_enum implements Native.ComparableLower {
    CONTROLLING(0),
    END_EXPR(CONTROLLING.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  /*friend*/public type$ptr<TypeSourceInfo /*P*/ /*P*/> AssocTypes;
  /*friend*/public type$ptr<Stmt /*P*/ /*P*/> SubExprs;
  /*friend*/public /*uint*/int NumAssocs;
  /*friend*/public /*uint*/int ResultIndex;
  /*friend*/public SourceLocation GenericLoc;
  /*friend*/public SourceLocation DefaultLoc;
  /*friend*/public SourceLocation RParenLoc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::GenericSelectionExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3457,
   FQN="clang::GenericSelectionExpr::GenericSelectionExpr", NM="_ZN5clang20GenericSelectionExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS8_IS6_EES4_S4_bj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS8_IS6_EES4_S4_bj")
  //</editor-fold>
  public GenericSelectionExpr(final /*const*/ ASTContext /*&*/ Context, 
      SourceLocation GenericLoc, Expr /*P*/ ControllingExpr, 
      ArrayRef<TypeSourceInfo /*P*/ > AssocTypes, 
      ArrayRef<Expr /*P*/ > AssocExprs, 
      SourceLocation DefaultLoc, 
      SourceLocation RParenLoc, 
      boolean ContainsUnexpandedParameterPack, 
      /*uint*/int ResultIndex) {
    // : Expr(GenericSelectionExprClass, AssocExprs[ResultIndex]->getType(), AssocExprs[ResultIndex]->getValueKind(), AssocExprs[ResultIndex]->getObjectKind(), AssocExprs[ResultIndex]->isTypeDependent(), AssocExprs[ResultIndex]->isValueDependent(), AssocExprs[ResultIndex]->isInstantiationDependent(), ContainsUnexpandedParameterPack), AssocTypes(new (Context) new TypeSourceInfo * [AssocTypes.size()]), SubExprs(new (Context) new Stmt * [END_EXPR + AssocExprs.size()]), NumAssocs(AssocExprs.size()), ResultIndex(ResultIndex), GenericLoc(GenericLoc), DefaultLoc(DefaultLoc), RParenLoc(RParenLoc) 
    //START JInit
    super(StmtClass.GenericSelectionExprClass, 
        AssocExprs.$at(ResultIndex).getType(), 
        AssocExprs.$at(ResultIndex).getValueKind(), 
        AssocExprs.$at(ResultIndex).getObjectKind(), 
        AssocExprs.$at(ResultIndex).isTypeDependent(), 
        AssocExprs.$at(ResultIndex).isValueDependent(), 
        AssocExprs.$at(ResultIndex).isInstantiationDependent(), 
        ContainsUnexpandedParameterPack);
    this.AssocTypes = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new TypeSourceInfo /*P*/ [AssocTypes.size()]);
    this.SubExprs = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new Stmt /*P*/ [Unnamed_enum.END_EXPR.getValue() + AssocExprs.size()]);
    this.NumAssocs = AssocExprs.size();
    this.ResultIndex = ResultIndex;
    this.GenericLoc = new SourceLocation(GenericLoc);
    this.DefaultLoc = new SourceLocation(DefaultLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    //END JInit
    SubExprs.$set(Unnamed_enum.CONTROLLING.getValue(), ControllingExpr);
    assert (AssocTypes.size() == AssocExprs.size());
    std.copy(AssocTypes.begin(), AssocTypes.end(), this.AssocTypes);
    std.copy(AssocExprs.begin(), AssocExprs.end(), SubExprs.$add(Unnamed_enum.END_EXPR.getValue()));
  }

  
  /// This constructor is used in the result-dependent case.
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::GenericSelectionExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3483,
   FQN="clang::GenericSelectionExpr::GenericSelectionExpr", NM="_ZN5clang20GenericSelectionExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS8_IS6_EES4_S4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExprC1ERKNS_10ASTContextENS_14SourceLocationEPNS_4ExprEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS8_IS6_EES4_S4_b")
  //</editor-fold>
  public GenericSelectionExpr(final /*const*/ ASTContext /*&*/ Context, 
      SourceLocation GenericLoc, Expr /*P*/ ControllingExpr, 
      ArrayRef<TypeSourceInfo /*P*/ > AssocTypes, 
      ArrayRef<Expr /*P*/ > AssocExprs, 
      SourceLocation DefaultLoc, 
      SourceLocation RParenLoc, 
      boolean ContainsUnexpandedParameterPack) {
    // : Expr(GenericSelectionExprClass, Context.DependentTy.operator QualType(), VK_RValue, OK_Ordinary, /*isTypeDependent=*/ true, /*isValueDependent=*/ true, /*isInstantiationDependent=*/ true, ContainsUnexpandedParameterPack), AssocTypes(new (Context) new TypeSourceInfo * [AssocTypes.size()]), SubExprs(new (Context) new Stmt * [END_EXPR + AssocExprs.size()]), NumAssocs(AssocExprs.size()), ResultIndex(-1UU), GenericLoc(GenericLoc), DefaultLoc(DefaultLoc), RParenLoc(RParenLoc) 
    //START JInit
    super(StmtClass.GenericSelectionExprClass, 
        Context.DependentTy.$QualType(), 
        ExprValueKind.VK_RValue, 
        ExprObjectKind.OK_Ordinary, 
        true, 
        true, 
        true, 
        ContainsUnexpandedParameterPack);
    this.AssocTypes = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new TypeSourceInfo /*P*/ [AssocTypes.size()]);
    this.SubExprs = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Context)*/ new Stmt /*P*/ [Unnamed_enum.END_EXPR.getValue() + AssocExprs.size()]);
    this.NumAssocs = AssocExprs.size();
    this.ResultIndex = -1/*U*/;
    this.GenericLoc = new SourceLocation(GenericLoc);
    this.DefaultLoc = new SourceLocation(DefaultLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    //END JInit
    SubExprs.$set(Unnamed_enum.CONTROLLING.getValue(), ControllingExpr);
    assert (AssocTypes.size() == AssocExprs.size());
    std.copy(AssocTypes.begin(), AssocTypes.end(), this.AssocTypes);
    std.copy(AssocExprs.begin(), AssocExprs.end(), SubExprs.$add(Unnamed_enum.END_EXPR.getValue()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::GenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4437,
   FQN="clang::GenericSelectionExpr::GenericSelectionExpr", NM="_ZN5clang20GenericSelectionExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ GenericSelectionExpr(EmptyShell Empty) {
    // : Expr(GenericSelectionExprClass, Empty), GenericLoc(), DefaultLoc(), RParenLoc() 
    //START JInit
    super(StmtClass.GenericSelectionExprClass, new EmptyShell(Empty));
    this.GenericLoc = new SourceLocation();
    this.DefaultLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getNumAssocs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4440,
   FQN="clang::GenericSelectionExpr::getNumAssocs", NM="_ZNK5clang20GenericSelectionExpr12getNumAssocsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr12getNumAssocsEv")
  //</editor-fold>
  public /*uint*/int getNumAssocs() /*const*/ {
    return NumAssocs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getGenericLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4442,
   FQN="clang::GenericSelectionExpr::getGenericLoc", NM="_ZNK5clang20GenericSelectionExpr13getGenericLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr13getGenericLocEv")
  //</editor-fold>
  public SourceLocation getGenericLoc() /*const*/ {
    return new SourceLocation(GenericLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getDefaultLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4443,
   FQN="clang::GenericSelectionExpr::getDefaultLoc", NM="_ZNK5clang20GenericSelectionExpr13getDefaultLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr13getDefaultLocEv")
  //</editor-fold>
  public SourceLocation getDefaultLoc() /*const*/ {
    return new SourceLocation(DefaultLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4444,
   FQN="clang::GenericSelectionExpr::getRParenLoc", NM="_ZNK5clang20GenericSelectionExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getAssocExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4446,
   FQN="clang::GenericSelectionExpr::getAssocExpr", NM="_ZNK5clang20GenericSelectionExpr12getAssocExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr12getAssocExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getAssocExpr$Const(/*uint*/int i) /*const*/ {
    return cast_Expr(SubExprs.$at(Unnamed_enum.END_EXPR.getValue() + i));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getAssocExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4449,
   FQN="clang::GenericSelectionExpr::getAssocExpr", NM="_ZN5clang20GenericSelectionExpr12getAssocExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExpr12getAssocExprEj")
  //</editor-fold>
  public Expr /*P*/ getAssocExpr(/*uint*/int i) {
    return cast_Expr(SubExprs.$at(Unnamed_enum.END_EXPR.getValue() + i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getAssocTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4451,
   FQN="clang::GenericSelectionExpr::getAssocTypeSourceInfo", NM="_ZNK5clang20GenericSelectionExpr22getAssocTypeSourceInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr22getAssocTypeSourceInfoEj")
  //</editor-fold>
  public /*const*/ TypeSourceInfo /*P*/ getAssocTypeSourceInfo$Const(/*uint*/int i) /*const*/ {
    return AssocTypes.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getAssocTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4454,
   FQN="clang::GenericSelectionExpr::getAssocTypeSourceInfo", NM="_ZN5clang20GenericSelectionExpr22getAssocTypeSourceInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExpr22getAssocTypeSourceInfoEj")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getAssocTypeSourceInfo(/*uint*/int i) {
    return AssocTypes.$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getAssocType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4456,
   FQN="clang::GenericSelectionExpr::getAssocType", NM="_ZNK5clang20GenericSelectionExpr12getAssocTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr12getAssocTypeEj")
  //</editor-fold>
  public QualType getAssocType(/*uint*/int i) /*const*/ {
    {
      /*const*/ TypeSourceInfo /*P*/ TS = getAssocTypeSourceInfo$Const(i);
      if ((TS != null)) {
        return TS.getType();
      } else {
        return new QualType();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getControllingExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4463,
   FQN="clang::GenericSelectionExpr::getControllingExpr", NM="_ZNK5clang20GenericSelectionExpr18getControllingExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr18getControllingExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getControllingExpr$Const() /*const*/ {
    return cast_Expr(SubExprs.$at(Unnamed_enum.CONTROLLING.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getControllingExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4466,
   FQN="clang::GenericSelectionExpr::getControllingExpr", NM="_ZN5clang20GenericSelectionExpr18getControllingExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExpr18getControllingExprEv")
  //</editor-fold>
  public Expr /*P*/ getControllingExpr() {
    return cast_Expr(SubExprs.$at(Unnamed_enum.CONTROLLING.getValue()));
  }

  
  /// Whether this generic selection is result-dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::isResultDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4469,
   FQN="clang::GenericSelectionExpr::isResultDependent", NM="_ZNK5clang20GenericSelectionExpr17isResultDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr17isResultDependentEv")
  //</editor-fold>
  public boolean isResultDependent() /*const*/ {
    return ResultIndex == -1/*U*/;
  }

  
  /// The zero-based index of the result expression's generic association in
  /// the generic selection's association list.  Defined only if the
  /// generic selection is not result-dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getResultIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4474,
   FQN="clang::GenericSelectionExpr::getResultIndex", NM="_ZNK5clang20GenericSelectionExpr14getResultIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr14getResultIndexEv")
  //</editor-fold>
  public /*uint*/int getResultIndex() /*const*/ {
    assert (!isResultDependent()) : "Generic selection is result-dependent";
    return ResultIndex;
  }

  
  /// The generic selection's result expression.  Defined only if the
  /// generic selection is not result-dependent.
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getResultExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4481,
   FQN="clang::GenericSelectionExpr::getResultExpr", NM="_ZNK5clang20GenericSelectionExpr13getResultExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr13getResultExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getResultExpr$Const() /*const*/ {
    return getAssocExpr$Const(getResultIndex());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getResultExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4482,
   FQN="clang::GenericSelectionExpr::getResultExpr", NM="_ZN5clang20GenericSelectionExpr13getResultExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExpr13getResultExprEv")
  //</editor-fold>
  public Expr /*P*/ getResultExpr() {
    return getAssocExpr(getResultIndex());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4484,
   FQN="clang::GenericSelectionExpr::getLocStart", NM="_ZNK5clang20GenericSelectionExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(GenericLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4485,
   FQN="clang::GenericSelectionExpr::getLocEnd", NM="_ZNK5clang20GenericSelectionExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang20GenericSelectionExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4487,
   FQN="clang::GenericSelectionExpr::classof", NM="_ZN5clang20GenericSelectionExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.GenericSelectionExprClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::GenericSelectionExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4491,
   FQN="clang::GenericSelectionExpr::children", NM="_ZN5clang20GenericSelectionExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang20GenericSelectionExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(SubExprs), new StmtIterator(SubExprs.$add(Unnamed_enum.END_EXPR.getValue()).$add(NumAssocs)));
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "AssocTypes=" + AssocTypes // NOI18N
              + ", SubExprs=" + SubExprs // NOI18N
              + ", NumAssocs=" + NumAssocs // NOI18N
              + ", ResultIndex=" + ResultIndex // NOI18N
              + ", GenericLoc=" + GenericLoc // NOI18N
              + ", DefaultLoc=" + DefaultLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
