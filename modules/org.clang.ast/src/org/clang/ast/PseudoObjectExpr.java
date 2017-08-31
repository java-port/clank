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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// PseudoObjectExpr - An expression which accesses a pseudo-object
/// l-value.  A pseudo-object is an abstract object, accesses to which
/// are translated to calls.  The pseudo-object expression has a
/// syntactic form, which shows how the expression was actually
/// written in the source code, and a semantic form, which is a series
/// of expressions to be executed in order which detail how the
/// operation is actually evaluated.  Optionally, one of the semantic
/// forms may also provide a result value for the expression.
///
/// If any of the semantic-form expressions is an OpaqueValueExpr,
/// that OVE is required to have a source expression, and it is bound
/// to the result of that source expression.  Such OVEs may appear
/// only in subsequent semantic-form expressions and as
/// sub-expressions of the syntactic form.
///
/// PseudoObjectExpr should be used only when an operation can be
/// usefully described in terms of fairly simple rewrite rules on
/// objects and functions that are meant to be used by end-developers.
/// For example, under the Itanium ABI, dynamic casts are implemented
/// as a call to a runtime function called __dynamic_cast; using this
/// class to describe that would be inappropriate because that call is
/// not really part of the user-visible semantics, and instead the
/// cast is properly reflected in the AST and IR-generation has been
/// taught to generate the call as necessary.  In contrast, an
/// Objective-C property access is semantically defined to be
/// equivalent to a particular message send, and this is very much
/// part of the user model.  The name of this class encourages this
/// modelling design.
//<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4679,
 FQN="clang::PseudoObjectExpr", NM="_ZN5clang16PseudoObjectExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExprE")
//</editor-fold>
public final class PseudoObjectExpr extends /*public*/ Expr implements /*private*/ TrailingObjects<PseudoObjectExpr, Expr /*P*/ > {
  // PseudoObjectExprBits.NumSubExprs - The number of sub-expressions.
  // Always at least two, because the first sub-expression is the
  // syntactic form.
  
  // PseudoObjectExprBits.ResultIndex - The index of the
  // sub-expression holding the result.  0 means the result is void,
  // which is unambiguous because it's the index of the syntactic
  // form.  Note that this is therefore 1 higher than the value passed
  // in to Create, which is an index within the semantic forms.
  // Note also that ASTStmtWriter assumes this encoding.
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getSubExprsBuffer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4693,
   FQN="clang::PseudoObjectExpr::getSubExprsBuffer", NM="_ZN5clang16PseudoObjectExpr17getSubExprsBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr17getSubExprsBufferEv")
  //</editor-fold>
  /*friend*/public type$ptr<Expr /*P*/ /*P*/> getSubExprsBuffer() {
    return this.<Expr /*P*/ >getTrailingObjects(Expr.class);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getSubExprsBuffer">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4694,
   FQN="clang::PseudoObjectExpr::getSubExprsBuffer", NM="_ZNK5clang16PseudoObjectExpr17getSubExprsBufferEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr17getSubExprsBufferEv")
  //</editor-fold>
  private type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> getSubExprsBuffer$Const() /*const*/ {
    return this.<Expr /*P*/ >getTrailingObjects$Const(Expr.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::PseudoObjectExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3774,
   FQN="clang::PseudoObjectExpr::PseudoObjectExpr", NM="_ZN5clang16PseudoObjectExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEN4llvm8ArrayRefIS4_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExprC1ENS_8QualTypeENS_13ExprValueKindEPNS_4ExprEN4llvm8ArrayRefIS4_EEj")
  //</editor-fold>
  private PseudoObjectExpr(QualType type, ExprValueKind VK, 
      Expr /*P*/ syntax, ArrayRef<Expr /*P*/ > semantics, 
      /*uint*/int resultIndex) {
    // : Expr(PseudoObjectExprClass, type, VK, OK_Ordinary, /*filled in at end of ctor*/ false, false, false, false), TrailingObjects<PseudoObjectExpr, Expr * >() 
    //START JInit
    super(StmtClass.PseudoObjectExprClass, new QualType(type), VK, ExprObjectKind.OK_Ordinary, 
        false, false, false, false);
    $TrailingObjects();
    //END JInit
    Unnamed_field.PseudoObjectExprBits.NumSubExprs = $uint2uint_8bits(semantics.size() + 1);
    Unnamed_field.PseudoObjectExprBits.ResultIndex = $uint2uint_8bits(resultIndex + 1);
    
    for (/*uint*/int i = 0, e = semantics.size() + 1; i != e; ++i) {
      Expr /*P*/ E = (i == 0 ? syntax : semantics.$at(i - 1));
      getSubExprsBuffer().$set(i, E);
      if (E.isTypeDependent()) {
        Unnamed_field.ExprBits.TypeDependent = true;
      }
      if (E.isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (E.isInstantiationDependent()) {
        Unnamed_field.ExprBits.InstantiationDependent = true;
      }
      if (E.containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      if (isa_OpaqueValueExpr(E)) {
        assert (cast_OpaqueValueExpr(E).getSourceExpr() != null) : "opaque-value semantic expressions for pseudo-object operations must have sources";
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::PseudoObjectExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3745,
   FQN="clang::PseudoObjectExpr::PseudoObjectExpr", NM="_ZN5clang16PseudoObjectExprC1ENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExprC1ENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  private PseudoObjectExpr(EmptyShell shell, /*uint*/int numSemanticExprs) {
    // : Expr(PseudoObjectExprClass, shell), TrailingObjects<PseudoObjectExpr, Expr * >() 
    //START JInit
    super(StmtClass.PseudoObjectExprClass, new EmptyShell(shell));
    $TrailingObjects();
    //END JInit
    Unnamed_field.PseudoObjectExprBits.NumSubExprs = $uint2uint_8bits(numSemanticExprs + 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getNumSubExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4704,
   FQN="clang::PseudoObjectExpr::getNumSubExprs", NM="_ZNK5clang16PseudoObjectExpr14getNumSubExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr14getNumSubExprsEv")
  //</editor-fold>
  private /*uint*/int getNumSubExprs() /*const*/ {
    return $8bits_uint2uint(Unnamed_field.PseudoObjectExprBits.NumSubExprs);
  }

/*public:*/
  /// NoResult - A value for the result index indicating that there is
  /// no semantic result.
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4711,
   FQN="clang::PseudoObjectExpr::(anonymous)", NM="_ZN5clang16PseudoObjectExprE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExprE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS : unsigned int {*/
    public static final /*uint*/int NoResult = ~0/*U*/;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3750,
   FQN="clang::PseudoObjectExpr::Create", NM="_ZN5clang16PseudoObjectExpr6CreateERKNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS5_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr6CreateERKNS_10ASTContextEPNS_4ExprEN4llvm8ArrayRefIS5_EEj")
  //</editor-fold>
  public static PseudoObjectExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, Expr /*P*/ syntax, 
        ArrayRef<Expr /*P*/ > semantics, 
        /*uint*/int resultIndex) {
    assert ((syntax != null)) : "no syntactic expression!";
    assert ((semantics.size() != 0)) : "no semantic expressions!";
    
    QualType type/*J*/= new QualType();
    ExprValueKind VK;
    if (resultIndex == NoResult) {
      type.$assignMove(C.VoidTy.$QualType());
      VK = ExprValueKind.VK_RValue;
    } else {
      assert ($less_uint(resultIndex, semantics.size()));
      type.$assignMove(semantics.$at(resultIndex).getType());
      VK = semantics.$at(resultIndex).getValueKind();
      assert (semantics.$at(resultIndex).getObjectKind() == ExprObjectKind.OK_Ordinary);
    }
    
    Object/*void P*/ buffer = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Expr.class, semantics.size() + 1), 
        alignOf(PseudoObjectExpr.class));
    return /*NEW_EXPR [Stmt::new]*//*new (buffer)*/ Stmt.$new(buffer, (type$ptr<?> Mem)->{
        return new PseudoObjectExpr(new QualType(type), VK, syntax, new ArrayRef<Expr /*P*/ >(semantics), 
                resultIndex);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 3736,
   FQN="clang::PseudoObjectExpr::Create", NM="_ZN5clang16PseudoObjectExpr6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr6CreateERKNS_10ASTContextENS_4Stmt10EmptyShellEj")
  //</editor-fold>
  public static PseudoObjectExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ Context, 
        EmptyShell sh, 
        /*uint*/int numSemanticExprs) {
    Object/*void P*/ buffer = Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(Expr.class, 1 + numSemanticExprs), 
        alignOf(PseudoObjectExpr.class));
    return /*NEW_EXPR [Stmt::new]*//*new (buffer)*/ Stmt.$new(buffer, (type$ptr<?> Mem)->{
        return new PseudoObjectExpr(new EmptyShell(sh), numSemanticExprs);
     });
  }

  
  /// Return the syntactic form of this expression, i.e. the
  /// expression it actually looks like.  Likely to be expressed in
  /// terms of OpaqueValueExprs bound in the semantic form.
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getSyntacticForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4723,
   FQN="clang::PseudoObjectExpr::getSyntacticForm", NM="_ZN5clang16PseudoObjectExpr16getSyntacticFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr16getSyntacticFormEv")
  //</editor-fold>
  public Expr /*P*/ getSyntacticForm() {
    return getSubExprsBuffer().$at(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getSyntacticForm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4724,
   FQN="clang::PseudoObjectExpr::getSyntacticForm", NM="_ZNK5clang16PseudoObjectExpr16getSyntacticFormEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr16getSyntacticFormEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSyntacticForm$Const() /*const*/ {
    return getSubExprsBuffer$Const().$at(0);
  }

  
  /// Return the index of the result-bearing expression into the semantics
  /// expressions, or PseudoObjectExpr::NoResult if there is none.
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getResultExprIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4728,
   FQN="clang::PseudoObjectExpr::getResultExprIndex", NM="_ZNK5clang16PseudoObjectExpr18getResultExprIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr18getResultExprIndexEv")
  //</editor-fold>
  public /*uint*/int getResultExprIndex() /*const*/ {
    if (Unnamed_field.PseudoObjectExprBits.ResultIndex == $int2uint_8bits(0)) {
      return NoResult;
    }
    return Unnamed_field.PseudoObjectExprBits.ResultIndex - $int2uint_8bits(1);
  }

  
  /// Return the result-bearing expression, or null if there is none.
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getResultExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4734,
   FQN="clang::PseudoObjectExpr::getResultExpr", NM="_ZN5clang16PseudoObjectExpr13getResultExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr13getResultExprEv")
  //</editor-fold>
  public Expr /*P*/ getResultExpr() {
    if (Unnamed_field.PseudoObjectExprBits.ResultIndex == $int2uint_8bits(0)) {
      return null;
    }
    return getSubExprsBuffer().$at(Unnamed_field.PseudoObjectExprBits.ResultIndex);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getResultExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4739,
   FQN="clang::PseudoObjectExpr::getResultExpr", NM="_ZNK5clang16PseudoObjectExpr13getResultExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr13getResultExprEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getResultExpr$Const() /*const*/ {
    return ((/*const_cast*/PseudoObjectExpr /*P*/ )(this)).getResultExpr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getNumSemanticExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4743,
   FQN="clang::PseudoObjectExpr::getNumSemanticExprs", NM="_ZNK5clang16PseudoObjectExpr19getNumSemanticExprsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr19getNumSemanticExprsEv")
  //</editor-fold>
  public /*uint*/int getNumSemanticExprs() /*const*/ {
    return getNumSubExprs() - 1;
  }

  
  /*typedef Expr *const *semantics_iterator*/
//  public final class semantics_iterator extends type$ptr<Expr /*P*/ /*const*/ /*P*/>{ };
  /*typedef const Expr *const *const_semantics_iterator*/
//  public final class const_semantics_iterator extends type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::semantics_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4747,
   FQN="clang::PseudoObjectExpr::semantics_begin", NM="_ZN5clang16PseudoObjectExpr15semantics_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr15semantics_beginEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*const*/ /*P*/> semantics_begin() {
    return getSubExprsBuffer().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::semantics_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4750,
   FQN="clang::PseudoObjectExpr::semantics_begin", NM="_ZNK5clang16PseudoObjectExpr15semantics_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr15semantics_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> semantics_begin$Const() /*const*/ {
    return getSubExprsBuffer$Const().$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::semantics_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4753,
   FQN="clang::PseudoObjectExpr::semantics_end", NM="_ZN5clang16PseudoObjectExpr13semantics_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr13semantics_endEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*const*/ /*P*/> semantics_end() {
    return getSubExprsBuffer().$add(getNumSubExprs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::semantics_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4756,
   FQN="clang::PseudoObjectExpr::semantics_end", NM="_ZNK5clang16PseudoObjectExpr13semantics_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr13semantics_endEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> semantics_end$Const() /*const*/ {
    return getSubExprsBuffer$Const().$add(getNumSubExprs());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::semantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4760,
   FQN="clang::PseudoObjectExpr::semantics", NM="_ZN5clang16PseudoObjectExpr9semanticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr9semanticsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ /*const*/> semantics() {
    return llvm.make_range(semantics_begin(), semantics_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::semantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4763,
   FQN="clang::PseudoObjectExpr::semantics", NM="_ZNK5clang16PseudoObjectExpr9semanticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr9semanticsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> semantics$Const() /*const*/ {
    return llvm.make_range(semantics_begin$Const(), semantics_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getSemanticExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4767,
   FQN="clang::PseudoObjectExpr::getSemanticExpr", NM="_ZN5clang16PseudoObjectExpr15getSemanticExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr15getSemanticExprEj")
  //</editor-fold>
  public Expr /*P*/ getSemanticExpr(/*uint*/int index) {
    assert ($less_uint(index + 1, getNumSubExprs()));
    return getSubExprsBuffer().$at(index + 1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getSemanticExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4771,
   FQN="clang::PseudoObjectExpr::getSemanticExpr", NM="_ZNK5clang16PseudoObjectExpr15getSemanticExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr15getSemanticExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getSemanticExpr$Const(/*uint*/int index) /*const*/ {
    return ((/*const_cast*/PseudoObjectExpr /*P*/ )(this)).getSemanticExpr(index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getExprLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4775,
   FQN="clang::PseudoObjectExpr::getExprLoc", NM="_ZNK5clang16PseudoObjectExpr10getExprLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr10getExprLocEv")
  //</editor-fold>
  public SourceLocation getExprLoc() /*const*//* __attribute__((pure))*/ {
    return getSyntacticForm$Const().getExprLoc();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4779,
   FQN="clang::PseudoObjectExpr::getLocStart", NM="_ZNK5clang16PseudoObjectExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return getSyntacticForm$Const().getLocStart();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4782,
   FQN="clang::PseudoObjectExpr::getLocEnd", NM="_ZNK5clang16PseudoObjectExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16PseudoObjectExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return getSyntacticForm$Const().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4786,
   FQN="clang::PseudoObjectExpr::children", NM="_ZN5clang16PseudoObjectExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    type$ptr<Stmt /*P*/ /*P*/> cs = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, getSubExprsBuffer())));
    return new iterator_range<Stmt/*P*/>(new StmtIterator(cs), new StmtIterator(cs.$add(getNumSubExprs())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PseudoObjectExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 4791,
   FQN="clang::PseudoObjectExpr::classof", NM="_ZN5clang16PseudoObjectExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16PseudoObjectExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.PseudoObjectExprClass;
  }

  
  /*friend  TrailingObjects<PseudoObjectExpr, Expr *>*/
  /*friend  class ASTStmtReader*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == Expr.class;
    return 0;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
