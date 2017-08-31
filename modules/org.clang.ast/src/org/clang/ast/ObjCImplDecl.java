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
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import org.clang.ast.DeclContext.*;

//<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2308,
 FQN="clang::ObjCImplDecl", NM="_ZN5clang12ObjCImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDeclE")
//</editor-fold>
public class ObjCImplDecl extends /*public*/ ObjCContainerDecl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2007,
   FQN="clang::ObjCImplDecl::anchor", NM="_ZN5clang12ObjCImplDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  /// Class interface for this class/category implementation
  private ObjCInterfaceDecl /*P*/ ClassInterface;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::ObjCImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2315,
   FQN="clang::ObjCImplDecl::ObjCImplDecl", NM="_ZN5clang12ObjCImplDeclC1ENS_4Decl4KindEPNS_11DeclContextEPNS_17ObjCInterfaceDeclENS_14SourceLocationES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDeclC1ENS_4Decl4KindEPNS_11DeclContextEPNS_17ObjCInterfaceDeclENS_14SourceLocationES7_")
  //</editor-fold>
  protected ObjCImplDecl(Kind DK, DeclContext /*P*/ DC, 
      ObjCInterfaceDecl /*P*/ classInterface, 
      SourceLocation nameLoc, SourceLocation atStartLoc) {
    // : ObjCContainerDecl(DK, DC, classInterface ? classInterface->getIdentifier() : null, nameLoc, atStartLoc), ClassInterface(classInterface) 
    //START JInit
    super(DK, DC, 
        (classInterface != null) ? classInterface.getIdentifier() : (IdentifierInfo /*P*/ )null, 
        new SourceLocation(nameLoc), new SourceLocation(atStartLoc));
    this.ClassInterface = classInterface;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2325,
   FQN="clang::ObjCImplDecl::getClassInterface", NM="_ZNK5clang12ObjCImplDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCImplDecl17getClassInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getClassInterface$Const() /*const*/ {
    return ClassInterface;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2326,
   FQN="clang::ObjCImplDecl::getClassInterface", NM="_ZN5clang12ObjCImplDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl17getClassInterfaceEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getClassInterface() {
    return ClassInterface;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::setClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2015,
   FQN="clang::ObjCImplDecl::setClassInterface", NM="_ZN5clang12ObjCImplDecl17setClassInterfaceEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl17setClassInterfaceEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void setClassInterface(ObjCInterfaceDecl /*P*/ IFace) {
    final ASTContext /*&*/ Ctx = getASTContext();
    {
      
      ObjCImplementationDecl /*P*/ ImplD = dyn_cast_or_null_ObjCImplementationDecl(this);
      if ((ImplD != null)) {
        if ((IFace != null)) {
          Ctx.setObjCImplementation(IFace, ImplD);
        }
      } else {
        ObjCCategoryImplDecl /*P*/ ImplD$1 = dyn_cast_or_null_ObjCCategoryImplDecl(this);
        if ((ImplD$1 != null)) {
          {
            ObjCCategoryDecl /*P*/ CD = IFace.FindCategoryDeclaration(getIdentifier());
            if ((CD != null)) {
              Ctx.setObjCImplementation(CD, ImplD$1);
            }
          }
        }
      }
    }
    
    ClassInterface = IFace;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::addInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2329,
   FQN="clang::ObjCImplDecl::addInstanceMethod", NM="_ZN5clang12ObjCImplDecl17addInstanceMethodEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl17addInstanceMethodEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void addInstanceMethod(ObjCMethodDecl /*P*/ method) {
    // FIXME: Context should be set correctly before we get here.
    method.setLexicalDeclContext(this);
    addDecl(method);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::addClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2334,
   FQN="clang::ObjCImplDecl::addClassMethod", NM="_ZN5clang12ObjCImplDecl14addClassMethodEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl14addClassMethodEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void addClassMethod(ObjCMethodDecl /*P*/ method) {
    // FIXME: Context should be set correctly before we get here.
    method.setLexicalDeclContext(this);
    addDecl(method);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::addPropertyImplementation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2009,
   FQN="clang::ObjCImplDecl::addPropertyImplementation", NM="_ZN5clang12ObjCImplDecl25addPropertyImplementationEPNS_20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl25addPropertyImplementationEPNS_20ObjCPropertyImplDeclE")
  //</editor-fold>
  public void addPropertyImplementation(ObjCPropertyImplDecl /*P*/ property) {
    // FIXME: The context should be correct before we get here.
    property.setLexicalDeclContext(this);
    addDecl(property);
  }

  
  
  /// FindPropertyImplDecl - This method looks up a previous ObjCPropertyImplDecl
  /// added to the list of those properties \@synthesized/\@dynamic in this
  /// category \@implementation block.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::FindPropertyImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2049,
   FQN="clang::ObjCImplDecl::FindPropertyImplDecl", NM="_ZNK5clang12ObjCImplDecl20FindPropertyImplDeclEPNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCImplDecl20FindPropertyImplDeclEPNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE")
  //</editor-fold>
  public ObjCPropertyImplDecl /*P*/ FindPropertyImplDecl(IdentifierInfo /*P*/ Id, 
                      /*ObjCPropertyQueryKind*/byte/*uint8_t*/ QueryKind) /*const*/ {
    ObjCPropertyImplDecl /*P*/ ClassPropImpl = null;
    for (ObjCPropertyImplDecl /*P*/ PID : property_impls())  {
      // If queryKind is unknown, we return the instance property if one
      // exists; otherwise we return the class property.
      if (PID.getPropertyDecl().getIdentifier() == Id) {
        if ((QueryKind == ObjCPropertyQueryKind.OBJC_PR_query_unknown
           && !PID.getPropertyDecl().isClassProperty())
           || (QueryKind == ObjCPropertyQueryKind.OBJC_PR_query_class
           && PID.getPropertyDecl().isClassProperty())
           || (QueryKind == ObjCPropertyQueryKind.OBJC_PR_query_instance
           && !PID.getPropertyDecl().isClassProperty())) {
          return PID;
        }
        if (PID.getPropertyDecl().isClassProperty()) {
          ClassPropImpl = PID;
        }
      }
    }
    if (QueryKind == ObjCPropertyQueryKind.OBJC_PR_query_unknown) {
      // We can't find the instance property, return the class property.
      return ClassPropImpl;
    }
    
    return null;
  }

  
  /// FindPropertyImplIvarDecl - This method lookup the ivar in the list of
  /// properties implemented in this \@implementation block and returns
  /// the implemented property that uses it.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::FindPropertyImplIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2036,
   FQN="clang::ObjCImplDecl::FindPropertyImplIvarDecl", NM="_ZNK5clang12ObjCImplDecl24FindPropertyImplIvarDeclEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCImplDecl24FindPropertyImplIvarDeclEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCPropertyImplDecl /*P*/ FindPropertyImplIvarDecl(IdentifierInfo /*P*/ ivarId) /*const*/ {
    for (ObjCPropertyImplDecl /*P*/ PID : property_impls())  {
      if ((PID.getPropertyIvarDecl() != null)
         && PID.getPropertyIvarDecl().getIdentifier() == ivarId) {
        return PID;
      }
    }
    return null;
  }

  
  // Iterator access to properties.
  /*typedef specific_decl_iterator<ObjCPropertyImplDecl> propimpl_iterator*/
//  public final class propimpl_iterator extends specific_decl_iterator<ObjCPropertyImplDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<ObjCPropertyImplDecl> > propimpl_range*/
//  public final class propimpl_range extends iterator_range<ObjCPropertyImplDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::property_impls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2351,
   FQN="clang::ObjCImplDecl::property_impls", NM="_ZNK5clang12ObjCImplDecl14property_implsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCImplDecl14property_implsEv")
  //</editor-fold>
  public iterator_range<ObjCPropertyImplDecl /*P*/ > property_impls() /*const*/ {
    return new iterator_range<ObjCPropertyImplDecl /*P*/ >(propimpl_begin(), propimpl_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::propimpl_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2354,
   FQN="clang::ObjCImplDecl::propimpl_begin", NM="_ZNK5clang12ObjCImplDecl14propimpl_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCImplDecl14propimpl_beginEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCPropertyImplDecl> propimpl_begin() /*const*/ {
    return new specific_decl_iterator<ObjCPropertyImplDecl>(ObjCPropertyImplDecl.class, decls_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::propimpl_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2357,
   FQN="clang::ObjCImplDecl::propimpl_end", NM="_ZNK5clang12ObjCImplDecl12propimpl_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang12ObjCImplDecl12propimpl_endEv")
  //</editor-fold>
  public specific_decl_iterator<ObjCPropertyImplDecl> propimpl_end() /*const*/ {
    return new specific_decl_iterator<ObjCPropertyImplDecl>(ObjCPropertyImplDecl.class, decls_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2361,
   FQN="clang::ObjCImplDecl::classof", NM="_ZN5clang12ObjCImplDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2362,
   FQN="clang::ObjCImplDecl::classofKind", NM="_ZN5clang12ObjCImplDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstObjCImpl.getValue() && K.getValue() <= Kind.lastObjCImpl.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCImplDecl::~ObjCImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2308,
   FQN="clang::ObjCImplDecl::~ObjCImplDecl", NM="_ZN5clang12ObjCImplDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang12ObjCImplDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ClassInterface=" + ClassInterface // NOI18N
              + super.toString(); // NOI18N
  }
}
