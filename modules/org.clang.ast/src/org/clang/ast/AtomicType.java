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

//<editor-fold defaultstate="collapsed" desc="clang::AtomicType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5159,
 FQN="clang::AtomicType", NM="_ZN5clang10AtomicTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10AtomicTypeE")
//</editor-fold>
public class AtomicType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType ValueType;
  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::AtomicType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5162,
   FQN="clang::AtomicType::AtomicType", NM="_ZN5clang10AtomicTypeC1ENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10AtomicTypeC1ENS_8QualTypeES1_")
  //</editor-fold>
  /*friend*//*package*/ AtomicType(QualType ValTy, QualType Canonical) {
    // : Type(Atomic, Canonical, ValTy->isDependentType(), ValTy->isInstantiationDependentType(), ValTy->isVariablyModifiedType(), ValTy->containsUnexpandedParameterPack()), FoldingSetNode(), ValueType(ValTy) 
    //START JInit
    super(TypeClass.Atomic, new QualType(Canonical), ValTy.$arrow().isDependentType(), 
        ValTy.$arrow().isInstantiationDependentType(), 
        ValTy.$arrow().isVariablyModifiedType(), 
        ValTy.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.ValueType = new QualType(ValTy);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  /// Gets the type contained by this atomic type, i.e.
  /// the type returned by performing an atomic load of this atomic type.
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5173,
   FQN="clang::AtomicType::getValueType", NM="_ZNK5clang10AtomicType12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10AtomicType12getValueTypeEv")
  //</editor-fold>
  public QualType getValueType() /*const*/ {
    return new QualType(ValueType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5175,
   FQN="clang::AtomicType::isSugared", NM="_ZNK5clang10AtomicType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10AtomicType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5176,
   FQN="clang::AtomicType::desugar", NM="_ZNK5clang10AtomicType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang10AtomicType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5178,
   FQN="clang::AtomicType::Profile", NM="_ZN5clang10AtomicType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10AtomicType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getValueType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5181,
   FQN="clang::AtomicType::Profile", NM="_ZN5clang10AtomicType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10AtomicType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType T) {
    ID.AddPointer(T.getAsOpaquePtr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AtomicType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5184,
   FQN="clang::AtomicType::classof", NM="_ZN5clang10AtomicType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang10AtomicType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Atomic;
  }

  @Override public String toString() {
    return "" + "ValueType=" + ValueType // NOI18N
              + super.toString(); // NOI18N
  }
}
