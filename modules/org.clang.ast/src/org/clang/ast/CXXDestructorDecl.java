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
import org.clank.support.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;

/// \brief Represents a C++ destructor within a class.
///
/// For example:
///
/// \code
/// class X {
/// public:
///   ~X(); // represented by a CXXDestructorDecl.
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2414,
 FQN="clang::CXXDestructorDecl", NM="_ZN5clang17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDeclE")
//</editor-fold>
public class CXXDestructorDecl extends /*public*/ CXXMethodDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1962,
   FQN="clang::CXXDestructorDecl::anchor", NM="_ZN5clang17CXXDestructorDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /*friend*/public FunctionDecl /*P*/ OperatorDelete;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::CXXDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2419,
   FQN="clang::CXXDestructorDecl::CXXDestructorDecl", NM="_ZN5clang17CXXDestructorDeclC1ERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDeclC1ERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbb")
  //</editor-fold>
  private CXXDestructorDecl(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, SourceLocation StartLoc, 
      final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
      QualType T, TypeSourceInfo /*P*/ TInfo, 
      boolean isInline, boolean isImplicitlyDeclared) {
    // : CXXMethodDecl(CXXDestructor, C, RD, StartLoc, NameInfo, T, TInfo, SC_None, isInline, /*isConstexpr=*/ false, SourceLocation()), OperatorDelete(null) 
    //START JInit
    super(Kind.CXXDestructor, C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
        StorageClass.SC_None, isInline, false, new SourceLocation());
    this.OperatorDelete = null;
    //END JInit
    setImplicit(isImplicitlyDeclared);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1971,
   FQN="clang::CXXDestructorDecl::Create", NM="_ZN5clang17CXXDestructorDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDecl6CreateERNS_10ASTContextEPNS_13CXXRecordDeclENS_14SourceLocationERKNS_19DeclarationNameInfoENS_8QualTypeEPNS_14TypeSourceInfoEbb")
  //</editor-fold>
  public static CXXDestructorDecl /*P*/ Create(final ASTContext /*&*/ C, CXXRecordDecl /*P*/ RD, 
        SourceLocation StartLoc, 
        final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        boolean isInline, boolean isImplicitlyDeclared) {
    assert (NameInfo.getName().getNameKind() == DeclarationName.NameKind.CXXDestructorName) : "Name must refer to a destructor";
    return /*NEW_EXPR [Decl::new]*//*new (C, RD)*/ Decl.$new(C, RD, (type$ptr<?> Mem)->{
        return new CXXDestructorDecl(C, RD, new SourceLocation(StartLoc), NameInfo, new QualType(T), TInfo, 
                isInline, isImplicitlyDeclared);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1964,
   FQN="clang::CXXDestructorDecl::CreateDeserialized", NM="_ZN5clang17CXXDestructorDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static CXXDestructorDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new CXXDestructorDecl(C, (CXXRecordDecl /*P*/ )null, new SourceLocation(), new DeclarationNameInfo(), 
                new QualType(), (TypeSourceInfo /*P*/ )null, false, false);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::setOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1984,
   FQN="clang::CXXDestructorDecl::setOperatorDelete", NM="_ZN5clang17CXXDestructorDecl17setOperatorDeleteEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDecl17setOperatorDeleteEPNS_12FunctionDeclE")
  //</editor-fold>
  public void setOperatorDelete(FunctionDecl /*P*/ OD) {
    CXXDestructorDecl /*P*/ First = cast_CXXDestructorDecl(getFirstDecl());
    if ((OD != null) && !(First.OperatorDelete != null)) {
      First.OperatorDelete = OD;
      {
        ASTMutationListener /*P*/ L = getASTMutationListener();
        if ((L != null)) {
          L.ResolvedOperatorDelete(First, OD);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::getOperatorDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2439,
   FQN="clang::CXXDestructorDecl::getOperatorDelete", NM="_ZNK5clang17CXXDestructorDecl17getOperatorDeleteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang17CXXDestructorDecl17getOperatorDeleteEv")
  //</editor-fold>
  public /*const*/ FunctionDecl /*P*/ getOperatorDelete() /*const*/ {
    return cast_CXXDestructorDecl(getFirstDecl$Const()).OperatorDelete;
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2444,
   FQN="clang::CXXDestructorDecl::classof", NM="_ZN5clang17CXXDestructorDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2445,
   FQN="clang::CXXDestructorDecl::classofKind", NM="_ZN5clang17CXXDestructorDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.CXXDestructor;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXDestructorDecl::~CXXDestructorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2414,
   FQN="clang::CXXDestructorDecl::~CXXDestructorDecl", NM="_ZN5clang17CXXDestructorDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang17CXXDestructorDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "OperatorDelete=" + OperatorDelete // NOI18N
              + super.toString(); // NOI18N
  }
}
