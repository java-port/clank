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


/// Sugar for parentheses used when specifying types.
///
//<editor-fold defaultstate="collapsed" desc="clang::ParenType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2148,
 FQN="clang::ParenType", NM="_ZN5clang9ParenTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ParenTypeE")
//</editor-fold>
public class ParenType extends /*public*/ Type implements /*public*/ FoldingSetImpl.Node {
  private QualType Inner;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::ParenType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2151,
   FQN="clang::ParenType::ParenType", NM="_ZN5clang9ParenTypeC1ENS_8QualTypeES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ParenTypeC1ENS_8QualTypeES1_")
  //</editor-fold>
  /*friend*//*package*/ ParenType(QualType InnerType, QualType CanonType) {
    // : Type(Paren, CanonType, InnerType->isDependentType(), InnerType->isInstantiationDependentType(), InnerType->isVariablyModifiedType(), InnerType->containsUnexpandedParameterPack()), FoldingSetNode(), Inner(InnerType) 
    //START JInit
    super(TypeClass.Paren, new QualType(CanonType), InnerType.$arrow().isDependentType(), 
        InnerType.$arrow().isInstantiationDependentType(), 
        InnerType.$arrow().isVariablyModifiedType(), 
        InnerType.$arrow().containsUnexpandedParameterPack());
    $Node();
    this.Inner = new QualType(InnerType);
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::getInnerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2162,
   FQN="clang::ParenType::getInnerType", NM="_ZNK5clang9ParenType12getInnerTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ParenType12getInnerTypeEv")
  //</editor-fold>
  public QualType getInnerType() /*const*/ {
    return new QualType(Inner);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2164,
   FQN="clang::ParenType::isSugared", NM="_ZNK5clang9ParenType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ParenType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2165,
   FQN="clang::ParenType::desugar", NM="_ZNK5clang9ParenType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang9ParenType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return getInnerType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2167,
   FQN="clang::ParenType::Profile", NM="_ZN5clang9ParenType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ParenType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, getInnerType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2170,
   FQN="clang::ParenType::Profile", NM="_ZN5clang9ParenType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ParenType7ProfileERN4llvm16FoldingSetNodeIDENS_8QualTypeE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, QualType Inner) {
    Inner.Profile(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParenType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 2174,
   FQN="clang::ParenType::classof", NM="_ZN5clang9ParenType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang9ParenType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.Paren;
  }

  @Override public String toString() {
    return "" + "Inner=" + Inner // NOI18N
              + super.toString(); // NOI18N
  }
}
