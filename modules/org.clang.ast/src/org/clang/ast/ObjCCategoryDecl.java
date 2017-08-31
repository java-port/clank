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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;


/// ObjCCategoryDecl - Represents a category declaration. A category allows
/// you to add methods to an existing class (without subclassing or modifying
/// the original class interface or implementation:-). Categories don't allow
/// you to add instance data. The following example adds "myMethod" to all
/// NSView's within a process:
///
/// \@interface NSView (MyViewMethods)
/// - myMethod;
/// \@end
///
/// Categories also allow you to split the implementation of a class across
/// several files (a feature more naturally supported in C++).
///
/// Categories were originally inspired by dynamic languages such as Common
/// Lisp and Smalltalk.  More traditional class-based languages (C++, Java)
/// don't support this level of dynamism, which is both powerful and dangerous.
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2171,
 FQN="clang::ObjCCategoryDecl", NM="_ZN5clang16ObjCCategoryDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDeclE")
//</editor-fold>
public class ObjCCategoryDecl extends /*public*/ ObjCContainerDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCCategoryDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1904,
   FQN="clang::ObjCCategoryDecl::anchor", NM="_ZN5clang16ObjCCategoryDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// Interface belonging to this category
  /*friend*/public ObjCInterfaceDecl /*P*/ ClassInterface;
  
  /// The type parameters associated with this category, if any.
  /*friend*/public ObjCTypeParamList /*P*/ TypeParamList;
  
  /// referenced protocols in this category.
  private ObjCProtocolList ReferencedProtocols;
  
  /// Next category belonging to this class.
  /// FIXME: this should not be a singly-linked list.  Move storage elsewhere.
  /*friend*/public ObjCCategoryDecl /*P*/ NextClassCategory;
  
  /// \brief The location of the category name in this declaration.
  private SourceLocation CategoryNameLoc;
  
  /// class extension may have private ivars.
  private SourceLocation IvarLBraceLoc;
  private SourceLocation IvarRBraceLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::ObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1906,
   FQN="clang::ObjCCategoryDecl::ObjCCategoryDecl", NM="_ZN5clang16ObjCCategoryDeclC1EPNS_11DeclContextENS_14SourceLocationES3_S3_PNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclEPNS_17ObjCTypeParamListES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDeclC1EPNS_11DeclContextENS_14SourceLocationES3_S3_PNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclEPNS_17ObjCTypeParamListES3_S3_")
  //</editor-fold>
  private ObjCCategoryDecl(DeclContext /*P*/ DC, SourceLocation AtLoc, 
      SourceLocation ClassNameLoc, 
      SourceLocation CategoryNameLoc, 
      IdentifierInfo /*P*/ Id, ObjCInterfaceDecl /*P*/ IDecl, 
      ObjCTypeParamList /*P*/ typeParamList) {
    this(DC, AtLoc, 
      ClassNameLoc, 
      CategoryNameLoc, 
      Id, IDecl, 
      typeParamList, 
      new SourceLocation(), 
      new SourceLocation());
  }
  private ObjCCategoryDecl(DeclContext /*P*/ DC, SourceLocation AtLoc, 
      SourceLocation ClassNameLoc, 
      SourceLocation CategoryNameLoc, 
      IdentifierInfo /*P*/ Id, ObjCInterfaceDecl /*P*/ IDecl, 
      ObjCTypeParamList /*P*/ typeParamList, 
      SourceLocation IvarLBraceLoc/*= SourceLocation()*/) {
    this(DC, AtLoc, 
      ClassNameLoc, 
      CategoryNameLoc, 
      Id, IDecl, 
      typeParamList, 
      IvarLBraceLoc, 
      new SourceLocation());
  }
  private ObjCCategoryDecl(DeclContext /*P*/ DC, SourceLocation AtLoc, 
      SourceLocation ClassNameLoc, 
      SourceLocation CategoryNameLoc, 
      IdentifierInfo /*P*/ Id, ObjCInterfaceDecl /*P*/ IDecl, 
      ObjCTypeParamList /*P*/ typeParamList, 
      SourceLocation IvarLBraceLoc/*= SourceLocation()*/, 
      SourceLocation IvarRBraceLoc/*= SourceLocation()*/) {
    // : ObjCContainerDecl(ObjCCategory, DC, Id, ClassNameLoc, AtLoc), ClassInterface(IDecl), TypeParamList(null), ReferencedProtocols(), NextClassCategory(null), CategoryNameLoc(CategoryNameLoc), IvarLBraceLoc(IvarLBraceLoc), IvarRBraceLoc(IvarRBraceLoc) 
    //START JInit
    super(Kind.ObjCCategory, DC, Id, new SourceLocation(ClassNameLoc), new SourceLocation(AtLoc));
    this.ClassInterface = IDecl;
    this.TypeParamList = null;
    this.ReferencedProtocols = new ObjCProtocolList();
    this.NextClassCategory = null;
    this.CategoryNameLoc = new SourceLocation(CategoryNameLoc);
    this.IvarLBraceLoc = new SourceLocation(IvarLBraceLoc);
    this.IvarRBraceLoc = new SourceLocation(IvarRBraceLoc);
    //END JInit
    setTypeParamList(typeParamList);
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1921,
   FQN="clang::ObjCCategoryDecl::Create", NM="_ZN5clang16ObjCCategoryDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_S5_PNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclEPNS_17ObjCTypeParamListES5_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_S5_PNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclEPNS_17ObjCTypeParamListES5_S5_")
  //</editor-fold>
  public static ObjCCategoryDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation AtLoc, 
        SourceLocation ClassNameLoc, 
        SourceLocation CategoryNameLoc, 
        IdentifierInfo /*P*/ Id, 
        ObjCInterfaceDecl /*P*/ IDecl, 
        ObjCTypeParamList /*P*/ typeParamList) {
    return Create(C, DC, 
        AtLoc, 
        ClassNameLoc, 
        CategoryNameLoc, 
        Id, 
        IDecl, 
        typeParamList, 
        new SourceLocation(), 
        new SourceLocation());
  }
  public static ObjCCategoryDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation AtLoc, 
        SourceLocation ClassNameLoc, 
        SourceLocation CategoryNameLoc, 
        IdentifierInfo /*P*/ Id, 
        ObjCInterfaceDecl /*P*/ IDecl, 
        ObjCTypeParamList /*P*/ typeParamList, 
        SourceLocation IvarLBraceLoc/*= SourceLocation()*/) {
    return Create(C, DC, 
        AtLoc, 
        ClassNameLoc, 
        CategoryNameLoc, 
        Id, 
        IDecl, 
        typeParamList, 
        IvarLBraceLoc, 
        new SourceLocation());
  }
  public static ObjCCategoryDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation AtLoc, 
        SourceLocation ClassNameLoc, 
        SourceLocation CategoryNameLoc, 
        IdentifierInfo /*P*/ Id, 
        ObjCInterfaceDecl /*P*/ IDecl, 
        ObjCTypeParamList /*P*/ typeParamList, 
        SourceLocation IvarLBraceLoc/*= SourceLocation()*/, 
        SourceLocation IvarRBraceLoc/*= SourceLocation()*/) {
    ObjCCategoryDecl /*P*/ CatDecl = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCCategoryDecl(DC, new SourceLocation(AtLoc), new SourceLocation(ClassNameLoc), new SourceLocation(CategoryNameLoc), Id, 
                IDecl, typeParamList, new SourceLocation(IvarLBraceLoc), 
                new SourceLocation(IvarRBraceLoc));
     });
    if ((IDecl != null)) {
      // Link this category into its class's category list.
      CatDecl.NextClassCategory = IDecl.getCategoryListRaw();
      if (IDecl.hasDefinition()) {
        IDecl.setCategoryListRaw(CatDecl);
        {
          ASTMutationListener /*P*/ L = C.getASTMutationListener();
          if ((L != null)) {
            L.AddedObjCCategoryToInterface(CatDecl, IDecl);
          }
        }
      }
    }
    
    return CatDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1947,
   FQN="clang::ObjCCategoryDecl::CreateDeserialized", NM="_ZN5clang16ObjCCategoryDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCCategoryDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCCategoryDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null, (ObjCTypeParamList /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2214,
   FQN="clang::ObjCCategoryDecl::getClassInterface", NM="_ZN5clang16ObjCCategoryDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl17getClassInterfaceEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getClassInterface() {
    return ClassInterface;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2215,
   FQN="clang::ObjCCategoryDecl::getClassInterface", NM="_ZNK5clang16ObjCCategoryDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl17getClassInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getClassInterface$Const() /*const*/ {
    return ClassInterface;
  }

  
  /// Retrieve the type parameter list associated with this category or
  /// extension.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2219,
   FQN="clang::ObjCCategoryDecl::getTypeParamList", NM="_ZNK5clang16ObjCCategoryDecl16getTypeParamListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl16getTypeParamListEv")
  //</editor-fold>
  public ObjCTypeParamList /*P*/ getTypeParamList() /*const*/ {
    return TypeParamList;
  }

  
  /// Set the type parameters of this category.
  ///
  /// This function is used by the AST importer, which must import the type
  /// parameters after creating their DeclContext to avoid loops.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::setTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1963,
   FQN="clang::ObjCCategoryDecl::setTypeParamList", NM="_ZN5clang16ObjCCategoryDecl16setTypeParamListEPNS_17ObjCTypeParamListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl16setTypeParamListEPNS_17ObjCTypeParamListE")
  //</editor-fold>
  public void setTypeParamList(ObjCTypeParamList /*P*/ TPL) {
    TypeParamList = TPL;
    if (!(TPL != null)) {
      return;
    }
    // Set the declaration context of each of the type parameters.
    for (ObjCTypeParamDecl /*P*/ typeParam : $Deref(TypeParamList))  {
      typeParam.setDeclContext(this);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1954,
   FQN="clang::ObjCCategoryDecl::getImplementation", NM="_ZNK5clang16ObjCCategoryDecl17getImplementationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl17getImplementationEv")
  //</editor-fold>
  public ObjCCategoryImplDecl /*P*/ getImplementation() /*const*/ {
    return getASTContext().getObjCImplementation(((/*const_cast*/ObjCCategoryDecl /*P*/ )(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::setImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1959,
   FQN="clang::ObjCCategoryDecl::setImplementation", NM="_ZN5clang16ObjCCategoryDecl17setImplementationEPNS_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl17setImplementationEPNS_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void setImplementation(ObjCCategoryImplDecl /*P*/ ImplD) {
    getASTContext().setObjCImplementation(this, ImplD);
  }

  
  /// setProtocolList - Set the list of protocols that this interface
  /// implements.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::setProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2233,
   FQN="clang::ObjCCategoryDecl::setProtocolList", NM="_ZN5clang16ObjCCategoryDecl15setProtocolListEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl15setProtocolListEPKPNS_16ObjCProtocolDeclEjPKNS_14SourceLocationERNS_10ASTContextE")
  //</editor-fold>
  public void setProtocolList(type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> List, /*uint*/int Num, 
                 /*const*/type$ptr<SourceLocation> /*P*/ Locs, final ASTContext /*&*/ C) {
    ReferencedProtocols.set(List, Num, Locs, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getReferencedProtocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2238,
   FQN="clang::ObjCCategoryDecl::getReferencedProtocols", NM="_ZNK5clang16ObjCCategoryDecl22getReferencedProtocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl22getReferencedProtocolsEv")
  //</editor-fold>
  public /*const*/ ObjCProtocolList /*&*/ getReferencedProtocols() /*const*/ {
    return ReferencedProtocols;
  }

  
  /*typedef ObjCProtocolList::iterator protocol_iterator*/
//  public final class protocol_iterator extends type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/>{ };
  /*typedef llvm::iterator_range<protocol_iterator> protocol_range*/
//  public final class protocol_range extends iterator_range<ObjCProtocolDecl /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2245,
   FQN="clang::ObjCCategoryDecl::protocols", NM="_ZNK5clang16ObjCCategoryDecl9protocolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl9protocolsEv")
  //</editor-fold>
  public iterator_range<ObjCProtocolDecl /*P*/ /*const*/> protocols() /*const*/ {
    return new iterator_range<ObjCProtocolDecl /*P*/ /*const*/>(protocol_begin(), protocol_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocol_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2248,
   FQN="clang::ObjCCategoryDecl::protocol_begin", NM="_ZNK5clang16ObjCCategoryDecl14protocol_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl14protocol_beginEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*protocol_iterator*/ protocol_begin() /*const*/ {
    return ReferencedProtocols.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocol_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2251,
   FQN="clang::ObjCCategoryDecl::protocol_end", NM="_ZNK5clang16ObjCCategoryDecl12protocol_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl12protocol_endEv")
  //</editor-fold>
  public type$ptr<ObjCProtocolDecl>/*protocol_iterator*/ protocol_end() /*const*/ {
    return ReferencedProtocols.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocol_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2252,
   FQN="clang::ObjCCategoryDecl::protocol_size", NM="_ZNK5clang16ObjCCategoryDecl13protocol_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl13protocol_sizeEv")
  //</editor-fold>
  public /*uint*/int protocol_size() /*const*/ {
    return ReferencedProtocols.size();
  }

  /*typedef ObjCProtocolList::loc_iterator protocol_loc_iterator*/
//  public final class protocol_loc_iterator extends /*const*/type$ptr<SourceLocation> /*P*/ { };
  /*typedef llvm::iterator_range<protocol_loc_iterator> protocol_loc_range*/
//  public final class protocol_loc_range extends iterator_range</*const*/ SourceLocation>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocol_locs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2256,
   FQN="clang::ObjCCategoryDecl::protocol_locs", NM="_ZNK5clang16ObjCCategoryDecl13protocol_locsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl13protocol_locsEv")
  //</editor-fold>
  public iterator_range</*const*/ SourceLocation> protocol_locs() /*const*/ {
    return new iterator_range</*const*/ SourceLocation>(protocol_loc_begin(), protocol_loc_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocol_loc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2259,
   FQN="clang::ObjCCategoryDecl::protocol_loc_begin", NM="_ZNK5clang16ObjCCategoryDecl18protocol_loc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl18protocol_loc_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ protocol_loc_begin() /*const*/ {
    return ReferencedProtocols.loc_begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::protocol_loc_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2262,
   FQN="clang::ObjCCategoryDecl::protocol_loc_end", NM="_ZNK5clang16ObjCCategoryDecl16protocol_loc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl16protocol_loc_endEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ protocol_loc_end() /*const*/ {
    return ReferencedProtocols.loc_end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getNextClassCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2266,
   FQN="clang::ObjCCategoryDecl::getNextClassCategory", NM="_ZNK5clang16ObjCCategoryDecl20getNextClassCategoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl20getNextClassCategoryEv")
  //</editor-fold>
  public ObjCCategoryDecl /*P*/ getNextClassCategory() /*const*/ {
    return NextClassCategory;
  }

  
  /// \brief Retrieve the pointer to the next stored category (or extension),
  /// which may be hidden.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getNextClassCategoryRaw">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2270,
   FQN="clang::ObjCCategoryDecl::getNextClassCategoryRaw", NM="_ZNK5clang16ObjCCategoryDecl23getNextClassCategoryRawEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl23getNextClassCategoryRawEv")
  //</editor-fold>
  public ObjCCategoryDecl /*P*/ getNextClassCategoryRaw() /*const*/ {
    return NextClassCategory;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::IsClassExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2274,
   FQN="clang::ObjCCategoryDecl::IsClassExtension", NM="_ZNK5clang16ObjCCategoryDecl16IsClassExtensionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl16IsClassExtensionEv")
  //</editor-fold>
  public boolean IsClassExtension() /*const*/ {
    return getIdentifier() == null;
  }

  
  /*typedef specific_decl_iterator<ObjCIvarDecl> ivar_iterator*/
//  public final class ivar_iterator extends specific_decl_iterator<ObjCIvarDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<ObjCIvarDecl> > ivar_range*/
//  public final class ivar_range extends iterator_range<ObjCIvarDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::ivars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2279,
   FQN="clang::ObjCCategoryDecl::ivars", NM="_ZNK5clang16ObjCCategoryDecl5ivarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl5ivarsEv")
  //</editor-fold>
  public iterator_range<ObjCIvarDecl /*P*/ > ivars() /*const*/ {
    return new iterator_range<ObjCIvarDecl /*P*/ >(ivar_begin(), ivar_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::ivar_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2280,
   FQN="clang::ObjCCategoryDecl::ivar_begin", NM="_ZNK5clang16ObjCCategoryDecl10ivar_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl10ivar_beginEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCIvarDecl> ivar_begin() /*const*/ {
    return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class, decls_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::ivar_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2283,
   FQN="clang::ObjCCategoryDecl::ivar_end", NM="_ZNK5clang16ObjCCategoryDecl8ivar_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl8ivar_endEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCIvarDecl> ivar_end() /*const*/ {
    return new specific_decl_iterator<ObjCIvarDecl>(ObjCIvarDecl.class, decls_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::ivar_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2286,
   FQN="clang::ObjCCategoryDecl::ivar_size", NM="_ZNK5clang16ObjCCategoryDecl9ivar_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl9ivar_sizeEv")
  //</editor-fold>
  public /*uint*/int ivar_size() /*const*/ {
    return std.distance(ivar_begin(), ivar_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::ivar_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2289,
   FQN="clang::ObjCCategoryDecl::ivar_empty", NM="_ZNK5clang16ObjCCategoryDecl10ivar_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl10ivar_emptyEv")
  //</editor-fold>
  public boolean ivar_empty() /*const*/ {
    return $eq_specific_decl_iterator$SpecificDecl$C(ivar_begin(), ivar_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getCategoryNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2293,
   FQN="clang::ObjCCategoryDecl::getCategoryNameLoc", NM="_ZNK5clang16ObjCCategoryDecl18getCategoryNameLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl18getCategoryNameLocEv")
  //</editor-fold>
  public SourceLocation getCategoryNameLoc() /*const*/ {
    return new SourceLocation(CategoryNameLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::setCategoryNameLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2294,
   FQN="clang::ObjCCategoryDecl::setCategoryNameLoc", NM="_ZN5clang16ObjCCategoryDecl18setCategoryNameLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl18setCategoryNameLocENS_14SourceLocationE")
  //</editor-fold>
  public void setCategoryNameLoc(SourceLocation Loc) {
    CategoryNameLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::setIvarLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2296,
   FQN="clang::ObjCCategoryDecl::setIvarLBraceLoc", NM="_ZN5clang16ObjCCategoryDecl16setIvarLBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl16setIvarLBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIvarLBraceLoc(SourceLocation Loc) {
    IvarLBraceLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getIvarLBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2297,
   FQN="clang::ObjCCategoryDecl::getIvarLBraceLoc", NM="_ZNK5clang16ObjCCategoryDecl16getIvarLBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl16getIvarLBraceLocEv")
  //</editor-fold>
  public SourceLocation getIvarLBraceLoc() /*const*/ {
    return new SourceLocation(IvarLBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::setIvarRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2298,
   FQN="clang::ObjCCategoryDecl::setIvarRBraceLoc", NM="_ZN5clang16ObjCCategoryDecl16setIvarRBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl16setIvarRBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setIvarRBraceLoc(SourceLocation Loc) {
    IvarRBraceLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::getIvarRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2299,
   FQN="clang::ObjCCategoryDecl::getIvarRBraceLoc", NM="_ZNK5clang16ObjCCategoryDecl16getIvarRBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang16ObjCCategoryDecl16getIvarRBraceLocEv")
  //</editor-fold>
  public SourceLocation getIvarRBraceLoc() /*const*/ {
    return new SourceLocation(IvarRBraceLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2301,
   FQN="clang::ObjCCategoryDecl::classof", NM="_ZN5clang16ObjCCategoryDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2302,
   FQN="clang::ObjCCategoryDecl::classofKind", NM="_ZN5clang16ObjCCategoryDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCCategory;
  }

  
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCategoryDecl::~ObjCCategoryDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2171,
   FQN="clang::ObjCCategoryDecl::~ObjCCategoryDecl", NM="_ZN5clang16ObjCCategoryDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang16ObjCCategoryDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ClassInterface=" + ClassInterface // NOI18N
              + ", TypeParamList=" + TypeParamList // NOI18N
              + ", ReferencedProtocols=" + ReferencedProtocols // NOI18N
              + ", NextClassCategory=" + NextClassCategory // NOI18N
              + ", CategoryNameLoc=" + CategoryNameLoc // NOI18N
              + ", IvarLBraceLoc=" + IvarLBraceLoc // NOI18N
              + ", IvarRBraceLoc=" + IvarRBraceLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
