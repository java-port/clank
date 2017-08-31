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
import org.llvm.adt.*;
import org.clang.basic.*;


/// Represents an array type in C++ whose size is a value-dependent expression.
///
/// For example:
/// \code
/// template<typename T, int Size>
/// class array {
///   T data[Size];
/// };
/// \endcode
///
/// For these types, we won't actually know what the array bound is
/// until template instantiation occurs, at which point this will
/// become either a ConstantArrayType or a VariableArrayType.
//<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2659,
 FQN="clang::DependentSizedArrayType", NM="_ZN5clang23DependentSizedArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang23DependentSizedArrayTypeE")
//</editor-fold>
public class DependentSizedArrayType extends /*public*/ ArrayType {
  private final /*const*/ ASTContext /*&*/ Context;
  
  /// \brief An assignment expression that will instantiate to the
  /// size of the array.
  ///
  /// The expression itself might be null, in which case the array
  /// type will have its size deduced from an initializer.
  private Stmt /*P*/ SizeExpr;
  
  /// The range spanned by the left and right array brackets.
  private SourceRange Brackets;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::DependentSizedArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 124,
   FQN="clang::DependentSizedArrayType::DependentSizedArrayType", NM="_ZN5clang23DependentSizedArrayTypeC1ERKNS_10ASTContextENS_8QualTypeES4_PNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang23DependentSizedArrayTypeC1ERKNS_10ASTContextENS_8QualTypeES4_PNS_4ExprENS_9ArrayType17ArraySizeModifierEjNS_11SourceRangeE")
  //</editor-fold>
  /*friend*//*package*/ DependentSizedArrayType(final /*const*/ ASTContext /*&*/ Context, 
      QualType et, QualType can, 
      Expr /*P*/ e, ArraySizeModifier sm, 
      /*uint*/int tq, 
      SourceRange brackets) {
    // : ArrayType(DependentSizedArray, et, can, sm, tq, (et->containsUnexpandedParameterPack() || (e && e->containsUnexpandedParameterPack()))), Context(Context), SizeExpr((Stmt * )e), Brackets(brackets) 
    //START JInit
    super(TypeClass.DependentSizedArray, new QualType(et), new QualType(can), sm, tq, 
        (et.$arrow().containsUnexpandedParameterPack()
           || ((e != null) && e.containsUnexpandedParameterPack())));
    this./*&*/Context=/*&*/Context;
    this.SizeExpr = (Stmt /*P*/ )e;
    this.Brackets = new SourceRange(brackets);
    //END JInit
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::getSizeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2679,
   FQN="clang::DependentSizedArrayType::getSizeExpr", NM="_ZNK5clang23DependentSizedArrayType11getSizeExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang23DependentSizedArrayType11getSizeExprEv")
  //</editor-fold>
  public Expr /*P*/ getSizeExpr() /*const*/ {
    // We use C-style casts instead of cast<> here because we do not wish
    // to have a dependency of Type.h on Stmt.h/Expr.h.
    return (Expr /*P*/ )SizeExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::getBracketsRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2684,
   FQN="clang::DependentSizedArrayType::getBracketsRange", NM="_ZNK5clang23DependentSizedArrayType16getBracketsRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang23DependentSizedArrayType16getBracketsRangeEv")
  //</editor-fold>
  public SourceRange getBracketsRange() /*const*/ {
    return new SourceRange(Brackets);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::getLBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2685,
   FQN="clang::DependentSizedArrayType::getLBracketLoc", NM="_ZNK5clang23DependentSizedArrayType14getLBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang23DependentSizedArrayType14getLBracketLocEv")
  //</editor-fold>
  public SourceLocation getLBracketLoc() /*const*/ {
    return Brackets.getBegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::getRBracketLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2686,
   FQN="clang::DependentSizedArrayType::getRBracketLoc", NM="_ZNK5clang23DependentSizedArrayType14getRBracketLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang23DependentSizedArrayType14getRBracketLocEv")
  //</editor-fold>
  public SourceLocation getRBracketLoc() /*const*/ {
    return Brackets.getEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2688,
   FQN="clang::DependentSizedArrayType::isSugared", NM="_ZNK5clang23DependentSizedArrayType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang23DependentSizedArrayType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2689,
   FQN="clang::DependentSizedArrayType::desugar", NM="_ZNK5clang23DependentSizedArrayType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang23DependentSizedArrayType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2691,
   FQN="clang::DependentSizedArrayType::classof", NM="_ZN5clang23DependentSizedArrayType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang23DependentSizedArrayType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.DependentSizedArray;
  }

  
  /*friend  class StmtIteratorBase*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2698,
   FQN="clang::DependentSizedArrayType::Profile", NM="_ZN5clang23DependentSizedArrayType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang23DependentSizedArrayType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, Context, getElementType(), 
        getSizeModifier(), getIndexTypeCVRQualifiers(), getSizeExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DependentSizedArrayType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 136,
   FQN="clang::DependentSizedArrayType::Profile", NM="_ZN5clang23DependentSizedArrayType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextENS_8QualTypeENS_9ArrayType17ArraySizeModifierEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang23DependentSizedArrayType7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextENS_8QualTypeENS_9ArrayType17ArraySizeModifierEjPNS_4ExprE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         final /*const*/ ASTContext /*&*/ Context, 
         QualType ET, 
         ArraySizeModifier SizeMod, 
         /*uint*/int TypeQuals, 
         Expr /*P*/ E) {
    ID.AddPointer(ET.getAsOpaquePtr());
    ID.AddInteger_int(SizeMod.getValue());
    ID.AddInteger_uint(TypeQuals);
    E.Profile(ID, Context, true);
  }

  @Override public String toString() {
    return "" + "Context=" + "[ASTContext]" // NOI18N
              + ", SizeExpr=" + SizeExpr // NOI18N
              + ", Brackets=" + Brackets // NOI18N
              + super.toString(); // NOI18N
  }
}
