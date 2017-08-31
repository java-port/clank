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


/// Base for LValueReferenceType and RValueReferenceType
///
//<editor-fold defaultstate="collapsed" desc="clang::ReferenceType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2319,
 FQN="clang::ReferenceType", NM="_ZN5clang13ReferenceTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ReferenceTypeE")
//</editor-fold>
public class ReferenceType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType PointeeType;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::ReferenceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2323,
   FQN="clang::ReferenceType::ReferenceType", NM="_ZN5clang13ReferenceTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ReferenceTypeC1ENS_4Type9TypeClassENS_8QualTypeES3_b")
  //</editor-fold>
  protected ReferenceType(TypeClass tc, QualType Referencee, QualType CanonicalRef, 
      boolean SpelledAsLValue) {
    // : Type(tc, CanonicalRef, Referencee->isDependentType(), Referencee->isInstantiationDependentType(), Referencee->isVariablyModifiedType(), Referencee->containsUnexpandedParameterPack()), FoldingSetNode(), PointeeType(Referencee) 
    //START JInit
    super(tc, new QualType(CanonicalRef), Referencee.$arrow().isDependentType(), 
        Referencee.$arrow().isInstantiationDependentType(), 
        Referencee.$arrow().isVariablyModifiedType(), 
        Referencee.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.PointeeType = new QualType(Referencee);
    //END JInit
    Unnamed_field.ReferenceTypeBits.SpelledAsLValue = SpelledAsLValue;
    Unnamed_field.ReferenceTypeBits.InnerRef = Referencee.$arrow().isReferenceType();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::isSpelledAsLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2336,
   FQN="clang::ReferenceType::isSpelledAsLValue", NM="_ZNK5clang13ReferenceType17isSpelledAsLValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ReferenceType17isSpelledAsLValueEv")
  //</editor-fold>
  public boolean isSpelledAsLValue() /*const*/ {
    return Unnamed_field.ReferenceTypeBits.SpelledAsLValue;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::isInnerRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2337,
   FQN="clang::ReferenceType::isInnerRef", NM="_ZNK5clang13ReferenceType10isInnerRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ReferenceType10isInnerRefEv")
  //</editor-fold>
  public boolean isInnerRef() /*const*/ {
    return Unnamed_field.ReferenceTypeBits.InnerRef;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::getPointeeTypeAsWritten">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2339,
   FQN="clang::ReferenceType::getPointeeTypeAsWritten", NM="_ZNK5clang13ReferenceType23getPointeeTypeAsWrittenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ReferenceType23getPointeeTypeAsWrittenEv")
  //</editor-fold>
  public QualType getPointeeTypeAsWritten() /*const*/ {
    return new QualType(PointeeType);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::getPointeeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2340,
   FQN="clang::ReferenceType::getPointeeType", NM="_ZNK5clang13ReferenceType14getPointeeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang13ReferenceType14getPointeeTypeEv")
  //</editor-fold>
  public QualType getPointeeType() /*const*/ {
    // FIXME: this might strip inner qualifiers; okay?
    /*const*/ ReferenceType /*P*/ T = this;
    while (T.isInnerRef()) {
      T = T.PointeeType.$arrow().castAs(ReferenceType.class);
    }
    return new QualType(T.PointeeType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2348,
   FQN="clang::ReferenceType::Profile", NM="_ZN5clang13ReferenceType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ReferenceType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, /*NO_COPY*/PointeeType, isSpelledAsLValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2351,
   FQN="clang::ReferenceType::Profile", NM="_ZN5clang13ReferenceType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ReferenceType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeEb")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         QualType Referencee, 
         boolean SpelledAsLValue) {
    ID.AddPointer(Referencee.getAsOpaquePtr());
    ID.AddBoolean(SpelledAsLValue);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ReferenceType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2358,
   FQN="clang::ReferenceType::classof", NM="_ZN5clang13ReferenceType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang13ReferenceType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.LValueReference
       || T.getTypeClass() == TypeClass.RValueReference;
  }

  @Override public String toString() {
    return "" + "PointeeType=" + PointeeType // NOI18N
              + super.toString(); // NOI18N
  }
}
