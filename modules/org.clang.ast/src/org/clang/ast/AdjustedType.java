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


/// Represents a type which was implicitly adjusted by the semantic
/// engine for arbitrary reasons.  For example, array and function types can
/// decay, and function types can have their calling conventions adjusted.
//<editor-fold defaultstate="collapsed" desc="clang::AdjustedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2227,
 FQN="clang::AdjustedType", NM="_ZN5clang12AdjustedTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12AdjustedTypeE")
//</editor-fold>
public class AdjustedType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType OriginalTy;
  private QualType AdjustedTy;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::AdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2232,
   FQN="clang::AdjustedType::AdjustedType", NM="_ZN5clang12AdjustedTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12AdjustedTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_S3_")
  //</editor-fold>
  protected AdjustedType(TypeClass TC, QualType OriginalTy, QualType AdjustedTy, 
      QualType CanonicalPtr) {
    // : Type(TC, CanonicalPtr, OriginalTy->isDependentType(), OriginalTy->isInstantiationDependentType(), OriginalTy->isVariablyModifiedType(), OriginalTy->containsUnexpandedParameterPack()), FoldingSetNode(), OriginalTy(OriginalTy), AdjustedTy(AdjustedTy) 
    //START JInit
    super(TC, new QualType(CanonicalPtr), OriginalTy.$arrow().isDependentType(), 
        OriginalTy.$arrow().isInstantiationDependentType(), 
        OriginalTy.$arrow().isVariablyModifiedType(), 
        OriginalTy.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.OriginalTy = new QualType(OriginalTy);
    this.AdjustedTy = new QualType(AdjustedTy);
    //END JInit
  }

  
  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::getOriginalType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2243,
   FQN="clang::AdjustedType::getOriginalType", NM="_ZNK5clang12AdjustedType15getOriginalTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12AdjustedType15getOriginalTypeEv")
  //</editor-fold>
  public QualType getOriginalType() /*const*/ {
    return new QualType(OriginalTy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::getAdjustedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2244,
   FQN="clang::AdjustedType::getAdjustedType", NM="_ZNK5clang12AdjustedType15getAdjustedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12AdjustedType15getAdjustedTypeEv")
  //</editor-fold>
  public QualType getAdjustedType() /*const*/ {
    return new QualType(AdjustedTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2246,
   FQN="clang::AdjustedType::isSugared", NM="_ZNK5clang12AdjustedType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12AdjustedType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2247,
   FQN="clang::AdjustedType::desugar", NM="_ZNK5clang12AdjustedType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang12AdjustedType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(AdjustedTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2249,
   FQN="clang::AdjustedType::Profile", NM="_ZN5clang12AdjustedType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12AdjustedType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, /*NO_COPY*/OriginalTy, /*NO_COPY*/AdjustedTy);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2252,
   FQN="clang::AdjustedType::Profile", NM="_ZN5clang12AdjustedType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12AdjustedType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeES4_")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Orig, QualType New) {
    ID.AddPointer(Orig.getAsOpaquePtr());
    ID.AddPointer(New.getAsOpaquePtr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AdjustedType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2257,
   FQN="clang::AdjustedType::classof", NM="_ZN5clang12AdjustedType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang12AdjustedType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Adjusted || T.getTypeClass() == TypeClass.Decayed;
  }

  @Override public String toString() {
    return "" + "OriginalTy=" + OriginalTy // NOI18N
              + ", AdjustedTy=" + AdjustedTy // NOI18N
              + super.toString(); // NOI18N
  }
}
