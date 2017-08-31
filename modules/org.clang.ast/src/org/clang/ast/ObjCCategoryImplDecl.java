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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// ObjCCategoryImplDecl - An object of this class encapsulates a category
/// \@implementation declaration. If a category class has declaration of a
/// property, its implementation must be specified in the category's
/// \@implementation declaration. Example:
/// \@interface I \@end
/// \@interface I(CATEGORY)
///    \@property int p1, d1;
/// \@end
/// \@implementation I(CATEGORY)
///  \@dynamic p1,d1;
/// \@end
///
/// ObjCCategoryImplDecl
//<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2380,
 FQN="clang::ObjCCategoryImplDecl", NM="_ZN5clang20ObjCCategoryImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDeclE")
//</editor-fold>
public class ObjCCategoryImplDecl extends /*public*/ ObjCImplDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCCategoryImplDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1977,
   FQN="clang::ObjCCategoryImplDecl::anchor", NM="_ZN5clang20ObjCCategoryImplDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  // Category name
  private IdentifierInfo /*P*/ Id;
  
  // Category name location
  /*friend*/public SourceLocation CategoryNameLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::ObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2389,
   FQN="clang::ObjCCategoryImplDecl::ObjCCategoryImplDecl", NM="_ZN5clang20ObjCCategoryImplDeclC1EPNS_11DeclContextEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclENS_14SourceLocationES7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDeclC1EPNS_11DeclContextEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclENS_14SourceLocationES7_S7_")
  //</editor-fold>
  private ObjCCategoryImplDecl(DeclContext /*P*/ DC, IdentifierInfo /*P*/ Id, 
      ObjCInterfaceDecl /*P*/ classInterface, 
      SourceLocation nameLoc, SourceLocation atStartLoc, 
      SourceLocation CategoryNameLoc) {
    // : ObjCImplDecl(ObjCCategoryImpl, DC, classInterface, nameLoc, atStartLoc), Id(Id), CategoryNameLoc(CategoryNameLoc) 
    //START JInit
    super(Kind.ObjCCategoryImpl, DC, classInterface, new SourceLocation(nameLoc), new SourceLocation(atStartLoc));
    this.Id = Id;
    this.CategoryNameLoc = new SourceLocation(CategoryNameLoc);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1979,
   FQN="clang::ObjCCategoryImplDecl::Create", NM="_ZN5clang20ObjCCategoryImplDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclENS_14SourceLocationES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDecl6CreateERNS_10ASTContextEPNS_11DeclContextEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclENS_14SourceLocationES9_S9_")
  //</editor-fold>
  public static ObjCCategoryImplDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        IdentifierInfo /*P*/ Id, 
        ObjCInterfaceDecl /*P*/ ClassInterface, 
        SourceLocation nameLoc, 
        SourceLocation atStartLoc, 
        SourceLocation CategoryNameLoc) {
    if ((ClassInterface != null) && ClassInterface.hasDefinition()) {
      ClassInterface = ClassInterface.getDefinition();
    }
    final ObjCInterfaceDecl finalClassInterface = ClassInterface;
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCCategoryImplDecl(DC, Id, finalClassInterface, new SourceLocation(nameLoc), 
                new SourceLocation(atStartLoc), new SourceLocation(CategoryNameLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1992,
   FQN="clang::ObjCCategoryImplDecl::CreateDeserialized", NM="_ZN5clang20ObjCCategoryImplDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCCategoryImplDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCCategoryImplDecl((DeclContext /*P*/ )null, (IdentifierInfo /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null, 
                new SourceLocation(), new SourceLocation(), 
                new SourceLocation());
     });
  }

  
  /// getIdentifier - Get the identifier that names the category
  /// interface associated with this implementation.
  /// FIXME: This is a bad API, we are hiding NamedDecl::getIdentifier()
  /// with a different meaning. For example:
  /// ((NamedDecl *)SomeCategoryImplDecl)->getIdentifier()
  /// returns the class interface name, whereas
  /// ((ObjCCategoryImplDecl *)SomeCategoryImplDecl)->getIdentifier()
  /// returns the category name.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2412,
   FQN="clang::ObjCCategoryImplDecl::getIdentifier", NM="_ZNK5clang20ObjCCategoryImplDecl13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCCategoryImplDecl13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return Id;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::setIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2415,
   FQN="clang::ObjCCategoryImplDecl::setIdentifier", NM="_ZN5clang20ObjCCategoryImplDecl13setIdentifierEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDecl13setIdentifierEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void setIdentifier(IdentifierInfo /*P*/ II) {
    Id = II;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::getCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1999,
   FQN="clang::ObjCCategoryImplDecl::getCategoryDecl", NM="_ZNK5clang20ObjCCategoryImplDecl15getCategoryDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCCategoryImplDecl15getCategoryDeclEv")
  //</editor-fold>
  public ObjCCategoryDecl /*P*/ getCategoryDecl() /*const*/ {
    {
      // The class interface might be NULL if we are working with invalid code.
      /*const*/ ObjCInterfaceDecl /*P*/ ID = getClassInterface$Const();
      if ((ID != null)) {
        return ID.FindCategoryDeclaration(getIdentifier());
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::getCategoryNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2419,
   FQN="clang::ObjCCategoryImplDecl::getCategoryNameLoc", NM="_ZNK5clang20ObjCCategoryImplDecl18getCategoryNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCCategoryImplDecl18getCategoryNameLocEv")
  //</editor-fold>
  public SourceLocation getCategoryNameLoc() /*const*/ {
    return new SourceLocation(CategoryNameLoc);
  }

  
  /// getName - Get the name of identifier for the class interface associated
  /// with this implementation as a StringRef.
  //
  // FIXME: This is a bad API, we are hiding NamedDecl::getName with a different
  // meaning.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2426,
   FQN="clang::ObjCCategoryImplDecl::getName", NM="_ZNK5clang20ObjCCategoryImplDecl7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCCategoryImplDecl7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return (Id != null) ? Id.getName() : new StringRef();
  }

  
  /// @brief Get the name of the class associated with this interface.
  //
  // FIXME: Deprecated, move clients to getName().
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::getNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2431,
   FQN="clang::ObjCCategoryImplDecl::getNameAsString", NM="_ZNK5clang20ObjCCategoryImplDecl15getNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang20ObjCCategoryImplDecl15getNameAsStringEv")
  //</editor-fold>
  public std.string getNameAsString() /*const*/ {
    return getName().$string();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2435,
   FQN="clang::ObjCCategoryImplDecl::classof", NM="_ZN5clang20ObjCCategoryImplDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2436,
   FQN="clang::ObjCCategoryImplDecl::classofKind", NM="_ZN5clang20ObjCCategoryImplDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCCategoryImpl;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryImplDecl::~ObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2380,
   FQN="clang::ObjCCategoryImplDecl::~ObjCCategoryImplDecl", NM="_ZN5clang20ObjCCategoryImplDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang20ObjCCategoryImplDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Id=" + Id // NOI18N
              + ", CategoryNameLoc=" + CategoryNameLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
