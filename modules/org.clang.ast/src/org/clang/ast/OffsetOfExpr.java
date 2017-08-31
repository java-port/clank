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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clank.java.std;
import org.llvm.adt.java.TrailingObjectsUtils;
import org.llvm.support.TrailingObjects.*;


/// OffsetOfExpr - [C99 7.17] - This represents an expression of the form
/// offsetof(record-type, member-designator). For example, given:
/// @code
/// struct S {
///   float f;
///   double d;
/// };
/// struct T {
///   int i;
///   struct S s[10];
/// };
/// @endcode
/// we can represent and evaluate the expression @c offsetof(struct T, s[2].d).
//<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1874,
 FQN="clang::OffsetOfExpr", NM="_ZN5clang12OffsetOfExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExprE")
//</editor-fold>
public final class OffsetOfExpr extends /*public*/ Expr implements /*private*/ TrailingObjects2<OffsetOfExpr, OffsetOfNode, Expr /*P*/ > {
  private SourceLocation OperatorLoc;
  private SourceLocation RParenLoc;
  // Base type;
  private TypeSourceInfo /*P*/ TSInfo;
  // Number of sub-components (i.e. instances of OffsetOfNode).
  private /*uint*/int NumComps;
  // Number of sub-expressions (i.e. array subscript expressions).
  private /*uint*/int NumExprs;
  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::numTrailingObjects">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1885,
   FQN="clang::OffsetOfExpr::numTrailingObjects", NM="_ZNK5clang12OffsetOfExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_12OffsetOfNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr18numTrailingObjectsEN4llvm25trailing_objects_internal19TrailingObjectsBase13OverloadTokenINS_12OffsetOfNodeEEE")
  //</editor-fold>
  private /*size_t*/int numTrailingObjects(OverloadToken<OffsetOfNode> $Prm0) /*const*/ {
    return NumComps;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::OffsetOfExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1330,
   FQN="clang::OffsetOfExpr::OffsetOfExpr", NM="_ZN5clang12OffsetOfExprC1ERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS_12OffsetOfNodeEEENS9_IPNS_4ExprEEES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExprC1ERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS_12OffsetOfNodeEEENS9_IPNS_4ExprEEES5_")
  //</editor-fold>
  private OffsetOfExpr(final /*const*/ ASTContext /*&*/ C, QualType type, 
      SourceLocation OperatorLoc, TypeSourceInfo /*P*/ tsi, 
      ArrayRef<OffsetOfNode> comps, ArrayRef<Expr /*P*/ > exprs, 
      SourceLocation RParenLoc) {
    // : Expr(OffsetOfExprClass, type, VK_RValue, OK_Ordinary, /*TypeDependent=*/ false, /*ValueDependent=*/ tsi->getType()->isDependentType(), tsi->getType()->isInstantiationDependentType(), tsi->getType()->containsUnexpandedParameterPack()), TrailingObjects<OffsetOfExpr, OffsetOfNode, Expr * >(), OperatorLoc(OperatorLoc), RParenLoc(RParenLoc), TSInfo(tsi), NumComps(comps.size()), NumExprs(exprs.size()) 
    //START JInit
    super(StmtClass.OffsetOfExprClass, new QualType(type), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, 
        tsi.getType().$arrow().isDependentType(), 
        tsi.getType().$arrow().isInstantiationDependentType(), 
        tsi.getType().$arrow().containsUnexpandedParameterPack());
    $TrailingObjects();
    this.OperatorLoc = new SourceLocation(OperatorLoc);
    this.RParenLoc = new SourceLocation(RParenLoc);
    this.TSInfo = tsi;
    this.NumComps = comps.size();
    this.NumExprs = exprs.size();
    //END JInit
    for (/*uint*/int i = 0; i != comps.size(); ++i) {
      setComponent(i, new OffsetOfNode(comps.$at(i)));
    }
    
    for (/*uint*/int i = 0; i != exprs.size(); ++i) {
      if (exprs.$at(i).isTypeDependent() || exprs.$at(i).isValueDependent()) {
        Unnamed_field.ExprBits.ValueDependent = true;
      }
      if (exprs.$at(i).containsUnexpandedParameterPack()) {
        Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
      }
      
      setIndexExpr(i, exprs.$at(i));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::OffsetOfExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1894,
   FQN="clang::OffsetOfExpr::OffsetOfExpr", NM="_ZN5clang12OffsetOfExprC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExprC1Ejj")
  //</editor-fold>
  private /*explicit*/ OffsetOfExpr(/*uint*/int numComps, /*uint*/int numExprs) {
    // : Expr(OffsetOfExprClass, EmptyShell()), TrailingObjects<OffsetOfExpr, OffsetOfNode, Expr * >(), OperatorLoc(), RParenLoc(), TSInfo(null), NumComps(numComps), NumExprs(numExprs) 
    //START JInit
    super(StmtClass.OffsetOfExprClass, new EmptyShell());
    $TrailingObjects();
    this.OperatorLoc = new SourceLocation();
    this.RParenLoc = new SourceLocation();
    this.TSInfo = null;
    this.NumComps = numComps;
    this.NumExprs = numExprs;
    //END JInit
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1310,
   FQN="clang::OffsetOfExpr::Create", NM="_ZN5clang12OffsetOfExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS_12OffsetOfNodeEEENS9_IPNS_4ExprEEES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoEN4llvm8ArrayRefINS_12OffsetOfNodeEEENS9_IPNS_4ExprEEES5_")
  //</editor-fold>
  public static OffsetOfExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType type, 
        SourceLocation OperatorLoc, 
        TypeSourceInfo /*P*/ tsi, 
        ArrayRef<OffsetOfNode> comps, 
        ArrayRef<Expr /*P*/ > exprs, 
        SourceLocation RParenLoc) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(OffsetOfNode.class, Expr.class, comps.size(), exprs.size()),
            new std.pairIntPtr<>(1, ()->null), // this
            new std.pairIntPtr<>(comps.size(), ()->new OffsetOfNode()) // OffsetOfNode
    );
    
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new OffsetOfExpr(C, new QualType(type), new SourceLocation(OperatorLoc), tsi, new ArrayRef<OffsetOfNode>(comps), new ArrayRef<Expr /*P*/ >(exprs), 
                new SourceLocation(RParenLoc));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1323,
   FQN="clang::OffsetOfExpr::CreateEmpty", NM="_ZN5clang12OffsetOfExpr11CreateEmptyERKNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr11CreateEmptyERKNS_10ASTContextEjj")
  //</editor-fold>
  public static OffsetOfExpr /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int numComps, /*uint*/int numExprs) {
    Object/*void P*/ _Mem = C.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(OffsetOfNode.class, Expr.class, numComps, numExprs),
            new std.pairIntPtr<>(1, ()->null), // this
            new std.pairIntPtr<>(numComps, ()->new OffsetOfNode()) // OffsetOfNode
    );
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(_Mem, (type$ptr<?> Mem)->{
        return new OffsetOfExpr(numComps, numExprs);
     });
  }

  
  /// getOperatorLoc - Return the location of the operator.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1909,
   FQN="clang::OffsetOfExpr::getOperatorLoc", NM="_ZNK5clang12OffsetOfExpr14getOperatorLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr14getOperatorLocEv")
  //</editor-fold>
  public SourceLocation getOperatorLoc() /*const*/ {
    return new SourceLocation(OperatorLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::setOperatorLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1910,
   FQN="clang::OffsetOfExpr::setOperatorLoc", NM="_ZN5clang12OffsetOfExpr14setOperatorLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr14setOperatorLocENS_14SourceLocationE")
  //</editor-fold>
  public void setOperatorLoc(SourceLocation L) {
    OperatorLoc.$assign(L);
  }

  
  /// \brief Return the location of the right parentheses.
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1913,
   FQN="clang::OffsetOfExpr::getRParenLoc", NM="_ZNK5clang12OffsetOfExpr12getRParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr12getRParenLocEv")
  //</editor-fold>
  public SourceLocation getRParenLoc() /*const*/ {
    return new SourceLocation(RParenLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::setRParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1914,
   FQN="clang::OffsetOfExpr::setRParenLoc", NM="_ZN5clang12OffsetOfExpr12setRParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr12setRParenLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRParenLoc(SourceLocation R) {
    RParenLoc.$assign(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1916,
   FQN="clang::OffsetOfExpr::getTypeSourceInfo", NM="_ZNK5clang12OffsetOfExpr17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return TSInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::setTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1919,
   FQN="clang::OffsetOfExpr::setTypeSourceInfo", NM="_ZN5clang12OffsetOfExpr17setTypeSourceInfoEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr17setTypeSourceInfoEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setTypeSourceInfo(TypeSourceInfo /*P*/ tsi) {
    TSInfo = tsi;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getComponent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1923,
   FQN="clang::OffsetOfExpr::getComponent", NM="_ZNK5clang12OffsetOfExpr12getComponentEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr12getComponentEj")
  //</editor-fold>
  public /*const*/ OffsetOfNode /*&*/ getComponent(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, NumComps)) : "Subscript out of range";
    return this.<OffsetOfNode>getTrailingObjects$Const(OffsetOfNode.class).$at(Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::setComponent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1928,
   FQN="clang::OffsetOfExpr::setComponent", NM="_ZN5clang12OffsetOfExpr12setComponentEjNS_12OffsetOfNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr12setComponentEjNS_12OffsetOfNodeE")
  //</editor-fold>
  public void setComponent(/*uint*/int Idx, OffsetOfNode ON) {
    assert ($less_uint(Idx, NumComps)) : "Subscript out of range";
    this.<OffsetOfNode>getTrailingObjects(OffsetOfNode.class).$at(Idx).$assign(ON);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getNumComponents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1933,
   FQN="clang::OffsetOfExpr::getNumComponents", NM="_ZNK5clang12OffsetOfExpr16getNumComponentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr16getNumComponentsEv")
  //</editor-fold>
  public /*uint*/int getNumComponents() /*const*/ {
    return NumComps;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getIndexExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1937,
   FQN="clang::OffsetOfExpr::getIndexExpr", NM="_ZN5clang12OffsetOfExpr12getIndexExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr12getIndexExprEj")
  //</editor-fold>
  public Expr /*P*/ getIndexExpr(/*uint*/int Idx) {
    assert ($less_uint(Idx, NumExprs)) : "Subscript out of range";
    return this.<Expr /*P*/ >getTrailingObjects(Expr.class).$at(Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getIndexExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1942,
   FQN="clang::OffsetOfExpr::getIndexExpr", NM="_ZNK5clang12OffsetOfExpr12getIndexExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr12getIndexExprEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getIndexExpr$Const(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, NumExprs)) : "Subscript out of range";
    return this.<Expr /*P*/ >getTrailingObjects$Const(Expr.class).$at(Idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::setIndexExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1947,
   FQN="clang::OffsetOfExpr::setIndexExpr", NM="_ZN5clang12OffsetOfExpr12setIndexExprEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr12setIndexExprEjPNS_4ExprE")
  //</editor-fold>
  public void setIndexExpr(/*uint*/int Idx, Expr /*P*/ E) {
    assert ($less_uint(Idx, NumComps)) : "Subscript out of range";
    this.<Expr /*P*/ >getTrailingObjects(Expr.class).$set(Idx, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getNumExpressions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1952,
   FQN="clang::OffsetOfExpr::getNumExpressions", NM="_ZNK5clang12OffsetOfExpr17getNumExpressionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr17getNumExpressionsEv")
  //</editor-fold>
  public /*uint*/int getNumExpressions() /*const*/ {
    return NumExprs;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1956,
   FQN="clang::OffsetOfExpr::getLocStart", NM="_ZNK5clang12OffsetOfExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(OperatorLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1957,
   FQN="clang::OffsetOfExpr::getLocEnd", NM="_ZNK5clang12OffsetOfExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang12OffsetOfExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParenLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1959,
   FQN="clang::OffsetOfExpr::classof", NM="_ZN5clang12OffsetOfExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OffsetOfExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::OffsetOfExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1964,
   FQN="clang::OffsetOfExpr::children", NM="_ZN5clang12OffsetOfExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang12OffsetOfExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    type$ptr<Stmt /*P*/ /*P*/> begin = $tryClone(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this.<Expr /*P*/ >getTrailingObjects(Expr.class))));
    return new iterator_range<Stmt/*P*/>(new StmtIterator(begin), new StmtIterator(begin.$add(NumExprs)));
  }

  /*friend  TrailingObjects<OffsetOfExpr, OffsetOfNode, Expr *>*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public /*size_t*/int getNumTailingObject_OverloadToken$TrailingTy1() { 
    return numTrailingObjects((OverloadToken<OffsetOfNode>)null); 
  }
  
  @Override
  public final type$ptr<?> $TrailingObjects() {
    return super.$this$plus1();
  }
  
  @Override
  public final int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == OffsetOfNode.class
            || clazz == Expr.class;
    if (clazz == OffsetOfNode.class) {
      return 0;
    }
    return getNumTailingObject_OverloadToken$TrailingTy1();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OperatorLoc=" + OperatorLoc // NOI18N
              + ", RParenLoc=" + RParenLoc // NOI18N
              + ", TSInfo=" + TSInfo // NOI18N
              + ", NumComps=" + NumComps // NOI18N
              + ", NumExprs=" + NumExprs // NOI18N
              + super.toString(); // NOI18N
  }
}
