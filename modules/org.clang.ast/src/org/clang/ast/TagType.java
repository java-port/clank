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
import org.clang.ast.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::TagType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3684,
 FQN="clang::TagType", NM="_ZN5clang7TagTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang7TagTypeE")
//</editor-fold>
public class TagType extends /*public*/ Type {
  /// Stores the TagDecl associated with this type. The decl may point to any
  /// TagDecl that declares the entity.
  /*friend*/public TagDecl /*P*/ decl;
  
  /*friend  class ASTReader*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TagType::TagType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2944,
   FQN="clang::TagType::TagType", NM="_ZN5clang7TagTypeC1ENS_4Type9TypeClassEPKNS_7TagDeclENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang7TagTypeC1ENS_4Type9TypeClassEPKNS_7TagDeclENS_8QualTypeE")
  //</editor-fold>
  protected TagType(TypeClass TC, /*const*/ TagDecl /*P*/ D, QualType can) {
    // : Type(TC, can, D->isDependentType(), /*InstantiationDependent=*/ D->isDependentType(), /*VariablyModified=*/ false, /*ContainsUnexpandedParameterPack=*/ false), decl(const_cast<TagDecl * >(D)) 
    //START JInit
    super(TC, new QualType(can), D.isDependentType(), 
        D.isDependentType(), 
        false, 
        false);
    this.decl = ((/*const_cast*/TagDecl /*P*/ )(D));
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TagType::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2960,
   FQN="clang::TagType::getDecl", NM="_ZNK5clang7TagType7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang7TagType7getDeclEv")
  //</editor-fold>
  public TagDecl /*P*/ getDecl() /*const*/ {
    return TypeStatics.getInterestingTagDecl(decl);
  }

  
  /// Determines whether this type is in the process of being defined.
  //<editor-fold defaultstate="collapsed" desc="clang::TagType::isBeingDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2964,
   FQN="clang::TagType::isBeingDefined", NM="_ZNK5clang7TagType14isBeingDefinedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang7TagType14isBeingDefinedEv")
  //</editor-fold>
  public boolean isBeingDefined() /*const*/ {
    return getDecl().isBeingDefined();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TagType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3700,
   FQN="clang::TagType::classof", NM="_ZN5clang7TagType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang7TagType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass().getValue() >= TypeClass.TagFirst.getValue() && T.getTypeClass().getValue() <= TypeClass.TagLast.getValue();
  }

  @Override public String toString() {
    return "" + "decl=" + decl // NOI18N
              + super.toString(); // NOI18N
  }
}
