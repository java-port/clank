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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// Represents a C array with a specified size that is not an
/// integer-constant-expression.  For example, 'int s[x+foo()]'.
/// Since the size expression is an arbitrary expression, we store it as such.
///
/// Note: VariableArrayType's aren't uniqued (since the expressions aren't) and
/// should not be: two lexically equivalent variable array types could mean
/// different things, for example, these variables do not have the same type
/// dynamically:
///
/// void foo(int x) {
///   int Y[x];
///   ++x;
///   int Z[x];
/// }
///
//<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2607,
 FQN="clang::VariableArrayType", NM="_ZN5clang17VariableArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17VariableArrayTypeE")
//</editor-fold>
public class VariableArrayType extends /*public*/ ArrayType {
  /// An assignment-expression. VLA's are only permitted within
  /// a function block.
  /*friend*//*private*/ Stmt /*P*/ SizeExpr;
  /// The range spanned by the left and right array brackets.
  private SourceRange Brackets;
  
  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::VariableArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2614,
   FQN="clang::VariableArrayType::VariableArrayType", NM="_ZN5clang17VariableArrayTypeC1ENS_8QualTypeES1_PNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17VariableArrayTypeC1ENS_8QualTypeES1_PNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE")
  //</editor-fold>
  /*friend*//*package*/ VariableArrayType(QualType et, QualType can, Expr /*P*/ e, 
      ArraySizeModifier sm, /*uint*/int tq, 
      SourceRange brackets) {
    // : ArrayType(VariableArray, et, can, sm, tq, et->containsUnexpandedParameterPack()), SizeExpr((Stmt * )e), Brackets(brackets) 
    //START JInit
    super(TypeClass.VariableArray, new QualType(et), new QualType(can), sm, tq, 
        et.$arrow().containsUnexpandedParameterPack());
    this.SizeExpr = (Stmt /*P*/ )e;
    this.Brackets = new SourceRange(brackets);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::getSizeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2623,
   FQN="clang::VariableArrayType::getSizeExpr", NM="_ZNK5clang17VariableArrayType11getSizeExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17VariableArrayType11getSizeExprEv")
  //</editor-fold>
  public Expr /*P*/ getSizeExpr() /*const*/ {
    // We use C-style casts instead of cast<> here because we do not wish
    // to have a dependency of Type.h on Stmt.h/Expr.h.
    return (Expr /*P*/ )SizeExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::getBracketsRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2628,
   FQN="clang::VariableArrayType::getBracketsRange", NM="_ZNK5clang17VariableArrayType16getBracketsRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17VariableArrayType16getBracketsRangeEv")
  //</editor-fold>
  public SourceRange getBracketsRange() /*const*/ {
    return new SourceRange(Brackets);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::getLBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2629,
   FQN="clang::VariableArrayType::getLBracketLoc", NM="_ZNK5clang17VariableArrayType14getLBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17VariableArrayType14getLBracketLocEv")
  //</editor-fold>
  public SourceLocation getLBracketLoc() /*const*/ {
    return Brackets.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2630,
   FQN="clang::VariableArrayType::getRBracketLoc", NM="_ZNK5clang17VariableArrayType14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17VariableArrayType14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    return Brackets.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2632,
   FQN="clang::VariableArrayType::isSugared", NM="_ZNK5clang17VariableArrayType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17VariableArrayType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2633,
   FQN="clang::VariableArrayType::desugar", NM="_ZNK5clang17VariableArrayType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17VariableArrayType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2635,
   FQN="clang::VariableArrayType::classof", NM="_ZN5clang17VariableArrayType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17VariableArrayType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.VariableArray;
  }

  
  /*friend  class StmtIteratorBase*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::VariableArrayType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2641,
   FQN="clang::VariableArrayType::Profile", NM="_ZN5clang17VariableArrayType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17VariableArrayType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    throw new llvm_unreachable("Cannot unique VariableArrayTypes.");
  }

  @Override public String toString() {
    return "" + "SizeExpr=" + SizeExpr // NOI18N
              + ", Brackets=" + Brackets // NOI18N
              + super.toString(); // NOI18N
  }
}
