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


/// \brief Represents the dependent type named by a dependently-scoped
/// typename using declaration, e.g.
///   using typename Base<T>::foo;
///
/// Template instantiation turns these into the underlying type.
//<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3473,
 FQN="clang::UnresolvedUsingType", NM="_ZN5clang19UnresolvedUsingTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang19UnresolvedUsingTypeE")
//</editor-fold>
public class UnresolvedUsingType extends /*public*/ Type {
  private UnresolvedUsingTypenameDecl /*P*/ Decl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::UnresolvedUsingType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3476,
   FQN="clang::UnresolvedUsingType::UnresolvedUsingType", NM="_ZN5clang19UnresolvedUsingTypeC1EPKNS_27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang19UnresolvedUsingTypeC1EPKNS_27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  /*friend*/protected/*private*/ UnresolvedUsingType(/*const*/ UnresolvedUsingTypenameDecl /*P*/ D) {
    // : Type(UnresolvedUsing, QualType(), true, true, false, /*ContainsUnexpandedParameterPack=*/ false), Decl(const_cast<UnresolvedUsingTypenameDecl * >(D)) 
    //START JInit
    super(TypeClass.UnresolvedUsing, new QualType(), true, true, false, 
        false);
    this.Decl = ((/*const_cast*/UnresolvedUsingTypenameDecl /*P*/ )(D));
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3483,
   FQN="clang::UnresolvedUsingType::getDecl", NM="_ZNK5clang19UnresolvedUsingType7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang19UnresolvedUsingType7getDeclEv")
  //</editor-fold>
  public UnresolvedUsingTypenameDecl /*P*/ getDecl() /*const*/ {
    return Decl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3485,
   FQN="clang::UnresolvedUsingType::isSugared", NM="_ZNK5clang19UnresolvedUsingType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang19UnresolvedUsingType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3486,
   FQN="clang::UnresolvedUsingType::desugar", NM="_ZNK5clang19UnresolvedUsingType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang19UnresolvedUsingType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3488,
   FQN="clang::UnresolvedUsingType::classof", NM="_ZN5clang19UnresolvedUsingType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang19UnresolvedUsingType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.UnresolvedUsing;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3492,
   FQN="clang::UnresolvedUsingType::Profile", NM="_ZN5clang19UnresolvedUsingType7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang19UnresolvedUsingType7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, Decl);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UnresolvedUsingType::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 3495,
   FQN="clang::UnresolvedUsingType::Profile", NM="_ZN5clang19UnresolvedUsingType7ProfileERN4llvm16FoldingSetNodeIDEPNS_27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang19UnresolvedUsingType7ProfileERN4llvm16FoldingSetNodeIDEPNS_27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         UnresolvedUsingTypenameDecl /*P*/ D) {
    ID.AddPointer(D);
  }

  @Override public String toString() {
    return "" + "Decl=" + Decl // NOI18N
              + super.toString(); // NOI18N
  }
}
