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
import org.clang.basic.*;


/// TypeDecl - Represents a declaration of a type.
///
//<editor-fold defaultstate="collapsed" desc="clang::TypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2569,
 FQN="clang::TypeDecl", NM="_ZN5clang8TypeDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDeclE")
//</editor-fold>
public class TypeDecl extends /*public*/ NamedDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 4127,
   FQN="clang::TypeDecl::anchor", NM="_ZN5clang8TypeDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /// TypeForDecl - This indicates the Type object that represents
  /// this TypeDecl.  It is a cache maintained by
  /// ASTContext::getTypedefType, ASTContext::getTagDeclType, and
  /// ASTContext::getTemplateTypeParmType, and TemplateTypeParmDecl.
  /*friend*/protected/*private*/ /*mutable *//*const*/ Type /*P*/ TypeForDecl;
  /// LocStart - The start of the source range for this declaration.
  private SourceLocation LocStart;
  /*friend  class ASTContext*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::TypeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2581,
   FQN="clang::TypeDecl::TypeDecl", NM="_ZN5clang8TypeDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoES5_")
  //</editor-fold>
  protected TypeDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, IdentifierInfo /*P*/ Id) {
    this(DK, DC, L, Id, 
      new SourceLocation());
  }
  protected TypeDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, IdentifierInfo /*P*/ Id, 
      SourceLocation StartL/*= SourceLocation()*/) {
    // : NamedDecl(DK, DC, L, Id), TypeForDecl(null), LocStart(StartL) 
    //START JInit
    super(DK, DC, new SourceLocation(L), new DeclarationName(Id));
    this.TypeForDecl = null;
    this.LocStart = new SourceLocation(StartL);
    //END JInit
  }

/*public:*/
  // Low-level accessor. If you just want the type defined by this node,
  // check out ASTContext::getTypeDeclType or one of
  // ASTContext::getTypedefType, ASTContext::getRecordType, etc. if you
  // already know the specific kind of node this is.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::getTypeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2590,
   FQN="clang::TypeDecl::getTypeForDecl", NM="_ZNK5clang8TypeDecl14getTypeForDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8TypeDecl14getTypeForDeclEv")
  //</editor-fold>
  public /*const*/ Type /*P*/ getTypeForDecl() /*const*/ {
    return TypeForDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::setTypeForDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2591,
   FQN="clang::TypeDecl::setTypeForDecl", NM="_ZN5clang8TypeDecl14setTypeForDeclEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDecl14setTypeForDeclEPKNS_4TypeE")
  //</editor-fold>
  public void setTypeForDecl(/*const*/ Type /*P*/ TD) {
    TypeForDecl = TD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2593,
   FQN="clang::TypeDecl::getLocStart", NM="_ZNK5clang8TypeDecl11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8TypeDecl11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(LocStart);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::setLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2594,
   FQN="clang::TypeDecl::setLocStart", NM="_ZN5clang8TypeDecl11setLocStartENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDecl11setLocStartENS_14SourceLocationE")
  //</editor-fold>
  public void setLocStart(SourceLocation L) {
    LocStart.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2595,
   FQN="clang::TypeDecl::getSourceRange", NM="_ZNK5clang8TypeDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang8TypeDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (LocStart.isValid()) {
      return new SourceRange(/*NO_COPY*/LocStart, getLocation());
    } else {
      return new SourceRange(getLocation());
    }
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2603,
   FQN="clang::TypeDecl::classof", NM="_ZN5clang8TypeDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2604,
   FQN="clang::TypeDecl::classofKind", NM="_ZN5clang8TypeDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstType.getValue() && K.getValue() <= Kind.lastType.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypeDecl::~TypeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 2569,
   FQN="clang::TypeDecl::~TypeDecl", NM="_ZN5clang8TypeDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang8TypeDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return " as$TypeDecl{" + "TypeForDecl=" + NativeTrace.getIdentityStr(TypeForDecl) // NOI18N
              + ", LocStart=" + LocStart + "}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}
