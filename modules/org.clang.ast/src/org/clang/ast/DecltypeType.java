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


/// Represents the type `decltype(expr)` (C++11).
//<editor-fold defaultstate="collapsed" desc="clang::DecltypeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3590,
 FQN="clang::DecltypeType", NM="_ZN5clang12DecltypeTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12DecltypeTypeE")
//</editor-fold>
public class DecltypeType extends /*public*/ Type {
  private Expr /*P*/ E;
  private QualType UnderlyingType;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DecltypeType::DecltypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2897,
   FQN="clang::DecltypeType::DecltypeType", NM="_ZN5clang12DecltypeTypeC1EPNS_4ExprENS_8QualTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12DecltypeTypeC1EPNS_4ExprENS_8QualTypeES3_")
  //</editor-fold>
  protected DecltypeType(Expr /*P*/ E, QualType underlyingType) {
    this(E, underlyingType, new QualType());
  }
  protected DecltypeType(Expr /*P*/ E, QualType underlyingType, QualType can/*= QualType()*/) {
    // : Type(Decltype, can, E->isInstantiationDependent(), E->isInstantiationDependent(), E->getType()->isVariablyModifiedType(), E->containsUnexpandedParameterPack()), E(E), UnderlyingType(underlyingType) 
    //START JInit
    // C++11 [temp.type]p2: "If an expression e involves a template parameter,
    // decltype(e) denotes a unique dependent type." Hence a decltype type is
    // type-dependent even if its expression is only instantiation-dependent.
    super(TypeClass.Decltype, new QualType(can), E.isInstantiationDependent(), 
        E.isInstantiationDependent(), 
        E.getType().$arrow().isVariablyModifiedType(), 
        E.containsUnexpandedParameterPack());
    this.E = E;
    this.UnderlyingType = new QualType(underlyingType);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DecltypeType::getUnderlyingExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3598,
   FQN="clang::DecltypeType::getUnderlyingExpr", NM="_ZNK5clang12DecltypeType17getUnderlyingExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12DecltypeType17getUnderlyingExprEv")
  //</editor-fold>
  public Expr /*P*/ getUnderlyingExpr() /*const*/ {
    return E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DecltypeType::getUnderlyingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3599,
   FQN="clang::DecltypeType::getUnderlyingType", NM="_ZNK5clang12DecltypeType17getUnderlyingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12DecltypeType17getUnderlyingTypeEv")
  //</editor-fold>
  public QualType getUnderlyingType() /*const*/ {
    return new QualType(UnderlyingType);
  }

  
  /// \brief Remove a single level of sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::DecltypeType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2911,
   FQN="clang::DecltypeType::desugar", NM="_ZNK5clang12DecltypeType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12DecltypeType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    if (isSugared()) {
      return getUnderlyingType();
    }
    
    return new QualType(this, 0);
  }

  
  /// \brief Returns whether this type directly provides sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::DecltypeType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2909,
   FQN="clang::DecltypeType::isSugared", NM="_ZNK5clang12DecltypeType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12DecltypeType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return !E.isInstantiationDependent();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DecltypeType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3607,
   FQN="clang::DecltypeType::classof", NM="_ZN5clang12DecltypeType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12DecltypeType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Decltype;
  }

  @Override public String toString() {
    return "" + "E=" + E // NOI18N
              + ", UnderlyingType=" + UnderlyingType // NOI18N
              + super.toString(); // NOI18N
  }
}
