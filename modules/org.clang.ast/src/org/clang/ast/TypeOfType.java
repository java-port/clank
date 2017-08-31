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
import static org.clang.ast.java.AstTypesRTTI.*;

/// Represents `typeof(type)`, a GCC extension.
//<editor-fold defaultstate="collapsed" desc="clang::TypeOfType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3566,
 FQN="clang::TypeOfType", NM="_ZN5clang10TypeOfTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10TypeOfTypeE")
//</editor-fold>
public class TypeOfType extends /*public*/ Type {
  private QualType TOType;
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfType::TypeOfType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3568,
   FQN="clang::TypeOfType::TypeOfType", NM="_ZN5clang10TypeOfTypeC1ENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10TypeOfTypeC1ENS_8QualTypeES1_")
  //</editor-fold>
  /*friend*//*package*/ TypeOfType(QualType T, QualType can) {
    // : Type(TypeOf, can, T->isDependentType(), T->isInstantiationDependentType(), T->isVariablyModifiedType(), T->containsUnexpandedParameterPack()), TOType(T) 
    //START JInit
    super(TypeClass.TypeOf, new QualType(can), T.$arrow().isDependentType(), 
        T.$arrow().isInstantiationDependentType(), 
        T.$arrow().isVariablyModifiedType(), 
        T.$arrow().containsUnexpandedParameterPack());
    this.TOType = new QualType(T);
    //END JInit
    assert (!isa_TypedefType(can)) : "Invalid canonical type";
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfType::getUnderlyingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3578,
   FQN="clang::TypeOfType::getUnderlyingType", NM="_ZNK5clang10TypeOfType17getUnderlyingTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10TypeOfType17getUnderlyingTypeEv")
  //</editor-fold>
  public QualType getUnderlyingType() /*const*/ {
    return new QualType(TOType);
  }

  
  /// \brief Remove a single level of sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3581,
   FQN="clang::TypeOfType::desugar", NM="_ZNK5clang10TypeOfType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10TypeOfType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getUnderlyingType();
  }

  
  /// \brief Returns whether this type directly provides sugar.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3584,
   FQN="clang::TypeOfType::isSugared", NM="_ZNK5clang10TypeOfType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10TypeOfType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeOfType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3586,
   FQN="clang::TypeOfType::classof", NM="_ZN5clang10TypeOfType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10TypeOfType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.TypeOf;
  }

  @Override public String toString() {
    return "" + "TOType=" + TOType // NOI18N
              + super.toString(); // NOI18N
  }
}
