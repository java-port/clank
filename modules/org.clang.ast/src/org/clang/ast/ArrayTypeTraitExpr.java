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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief An Embarcadero array type trait, as used in the implementation of
/// __array_rank and __array_extent.
///
/// Example:
/// \code
///   __array_rank(int[10][20]) == 2
///   __array_extent(int, 1)    == 20
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2356,
 FQN="clang::ArrayTypeTraitExpr", NM="_ZN5clang18ArrayTypeTraitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExprE")
//</editor-fold>
public class ArrayTypeTraitExpr extends /*public*/ Expr implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 1433,
   FQN="clang::ArrayTypeTraitExpr::anchor", NM="_ZN5clang18ArrayTypeTraitExpr6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExpr6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  /// \brief The trait. An ArrayTypeTrait enum in MSVC compat unsigned.
  /*friend*/public /*JBYTE unsigned int*/ byte ATT /*: 2*/;
  
  /// \brief The value of the type trait. Unspecified if dependent.
  /*friend*/public long/*uint64_t*/ Value;
  
  /// \brief The array dimension being queried, or -1 if not used.
  private Expr /*P*/ Dimension;
  
  /// \brief The location of the type trait keyword.
  /*friend*/public SourceLocation Loc;
  
  /// \brief The location of the closing paren.
  /*friend*/public SourceLocation RParen;
  
  /// \brief The type being queried.
  /*friend*/public TypeSourceInfo /*P*/ QueriedType;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::ArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2378,
   FQN="clang::ArrayTypeTraitExpr::ArrayTypeTraitExpr", NM="_ZN5clang18ArrayTypeTraitExprC1ENS_14SourceLocationENS_14ArrayTypeTraitEPNS_14TypeSourceInfoEyPNS_4ExprES1_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExprC1ENS_14SourceLocationENS_14ArrayTypeTraitEPNS_14TypeSourceInfoEyPNS_4ExprES1_NS_8QualTypeE")
  //</editor-fold>
  public ArrayTypeTraitExpr(SourceLocation loc, ArrayTypeTrait att, 
      TypeSourceInfo /*P*/ queried, long/*uint64_t*/ value, 
      Expr /*P*/ dimension, SourceLocation rparen, QualType ty) {
    // : Expr(ArrayTypeTraitExprClass, ty, VK_RValue, OK_Ordinary, false, queried->getType()->isDependentType(), (queried->getType()->isInstantiationDependentType() || (dimension && dimension->isInstantiationDependent())), queried->getType()->containsUnexpandedParameterPack()), ATT(att), Value(value), Dimension(dimension), Loc(loc), RParen(rparen), QueriedType(queried) 
    //START JInit
    super(StmtClass.ArrayTypeTraitExprClass, new QualType(ty), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        false, queried.getType().$arrow().isDependentType(), 
        (queried.getType().$arrow().isInstantiationDependentType()
           || ((dimension != null) && dimension.isInstantiationDependent())), 
        queried.getType().$arrow().containsUnexpandedParameterPack());
    this.ATT = $uint2uint_2bits(att.getValue());
    this.Value = value;
    this.Dimension = dimension;
    this.Loc = new SourceLocation(loc);
    this.RParen = new SourceLocation(rparen);
    this.QueriedType = queried;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::ArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2390,
   FQN="clang::ArrayTypeTraitExpr::ArrayTypeTraitExpr", NM="_ZN5clang18ArrayTypeTraitExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ ArrayTypeTraitExpr(EmptyShell Empty) {
    // : Expr(ArrayTypeTraitExprClass, Empty), ATT(0), Value(false), Loc(), RParen(), QueriedType(implicit TypeSourceInfo * ()) 
    //START JInit
    super(StmtClass.ArrayTypeTraitExprClass, new EmptyShell(Empty));
    this.ATT = $uint2uint_2bits(0);
    this.Value = /*false*/0;
    this.Loc = new SourceLocation();
    this.RParen = new SourceLocation();
    this.QueriedType = /*implicit-init*/((TypeSourceInfo /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::~ArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2394,
   FQN="clang::ArrayTypeTraitExpr::~ArrayTypeTraitExpr", NM="_ZN5clang18ArrayTypeTraitExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExprD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2396,
   FQN="clang::ArrayTypeTraitExpr::getLocStart", NM="_ZNK5clang18ArrayTypeTraitExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2397,
   FQN="clang::ArrayTypeTraitExpr::getLocEnd", NM="_ZNK5clang18ArrayTypeTraitExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(RParen);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2399,
   FQN="clang::ArrayTypeTraitExpr::getTrait", NM="_ZNK5clang18ArrayTypeTraitExpr8getTraitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr8getTraitEv")
  //</editor-fold>
  public ArrayTypeTrait getTrait() /*const*/ {
    return /*static_cast*/ArrayTypeTrait.valueOf(ATT);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getQueriedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2401,
   FQN="clang::ArrayTypeTraitExpr::getQueriedType", NM="_ZNK5clang18ArrayTypeTraitExpr14getQueriedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr14getQueriedTypeEv")
  //</editor-fold>
  public QualType getQueriedType() /*const*/ {
    return QueriedType.getType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getQueriedTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2403,
   FQN="clang::ArrayTypeTraitExpr::getQueriedTypeSourceInfo", NM="_ZNK5clang18ArrayTypeTraitExpr24getQueriedTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr24getQueriedTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getQueriedTypeSourceInfo() /*const*/ {
    return QueriedType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2405,
   FQN="clang::ArrayTypeTraitExpr::getValue", NM="_ZNK5clang18ArrayTypeTraitExpr8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr8getValueEv")
  //</editor-fold>
  public long/*uint64_t*/ getValue() /*const*/ {
    assert (!isTypeDependent());
    return Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::getDimensionExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2407,
   FQN="clang::ArrayTypeTraitExpr::getDimensionExpression", NM="_ZNK5clang18ArrayTypeTraitExpr22getDimensionExpressionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang18ArrayTypeTraitExpr22getDimensionExpressionEv")
  //</editor-fold>
  public Expr /*P*/ getDimensionExpression() /*const*/ {
    return Dimension;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2409,
   FQN="clang::ArrayTypeTraitExpr::classof", NM="_ZN5clang18ArrayTypeTraitExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.ArrayTypeTraitExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::ArrayTypeTraitExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 2414,
   FQN="clang::ArrayTypeTraitExpr::children", NM="_ZN5clang18ArrayTypeTraitExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang18ArrayTypeTraitExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "ATT=" + $uchar2uint(ATT) // NOI18N
              + ", Value=" + Value // NOI18N
              + ", Dimension=" + Dimension // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", RParen=" + RParen // NOI18N
              + ", QueriedType=" + QueriedType // NOI18N
              + super.toString(); // NOI18N
  }
}
