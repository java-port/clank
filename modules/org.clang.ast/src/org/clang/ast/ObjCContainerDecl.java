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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.ast.DeclContext.*;


/// ObjCContainerDecl - Represents a container for method declarations.
/// Current sub-classes are ObjCInterfaceDecl, ObjCCategoryDecl,
/// ObjCProtocolDecl, and ObjCImplDecl.
///
//<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 901,
 FQN="clang::ObjCContainerDecl", NM="_ZN5clang17ObjCContainerDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDeclE")
//</editor-fold>
public class ObjCContainerDecl extends /*public*/ NamedDecl implements /*public*/ DeclContext, Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCInterfaceDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 51,
   FQN="clang::ObjCContainerDecl::anchor", NM="_ZN5clang17ObjCContainerDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  
  private SourceLocation AtStart;
  
  // These two locations in the range mark the end of the method container.
  // The first points to the '@' token, and the second to the 'end' token.
  private SourceRange AtEnd;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::ObjCContainerDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 911,
   FQN="clang::ObjCContainerDecl::ObjCContainerDecl", NM="_ZN5clang17ObjCContainerDeclC1ENS_4Decl4KindEPNS_11DeclContextEPNS_14IdentifierInfoENS_14SourceLocationES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDeclC1ENS_4Decl4KindEPNS_11DeclContextEPNS_14IdentifierInfoENS_14SourceLocationES7_")
  //</editor-fold>
  public ObjCContainerDecl(Kind DK, DeclContext /*P*/ DC, 
      IdentifierInfo /*P*/ Id, SourceLocation nameLoc, 
      SourceLocation atStartLoc) {
    // : NamedDecl(DK, DC, nameLoc, Id), DeclContext(DK), AtStart(atStartLoc), AtEnd() 
    //START JInit
    super(DK, DC, new SourceLocation(nameLoc), new DeclarationName(Id));
    this.DeclContext$Flds = $DeclContext(DK);
    this.AtStart = new SourceLocation(atStartLoc);
    this.AtEnd = new SourceRange();
    //END JInit
  }

  
  // Iterator access to instance/class properties.
  /*typedef specific_decl_iterator<ObjCPropertyDecl> prop_iterator*/
//  public final class prop_iterator extends DeclContext.specific_decl_iterator<ObjCPropertyDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<ObjCPropertyDecl> > prop_range*/
//  public final class prop_range extends iterator_range<ObjCPropertyDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::properties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 921,
   FQN="clang::ObjCContainerDecl::properties", NM="_ZNK5clang17ObjCContainerDecl10propertiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl10propertiesEv")
  //</editor-fold>
  public iterator_range<ObjCPropertyDecl /*P*/ > properties() /*const*/ {
    return new iterator_range<ObjCPropertyDecl /*P*/ >(prop_begin(), prop_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::prop_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 922,
   FQN="clang::ObjCContainerDecl::prop_begin", NM="_ZNK5clang17ObjCContainerDecl10prop_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl10prop_beginEv")
  //</editor-fold>
  public DeclContext.specific_decl_iterator<ObjCPropertyDecl> prop_begin() /*const*/ {
    return new DeclContext.specific_decl_iterator<ObjCPropertyDecl>(ObjCPropertyDecl.class, decls_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::prop_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 925,
   FQN="clang::ObjCContainerDecl::prop_end", NM="_ZNK5clang17ObjCContainerDecl8prop_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl8prop_endEv")
  //</editor-fold>
  public DeclContext.specific_decl_iterator<ObjCPropertyDecl> prop_end() /*const*/ {
    return new DeclContext.specific_decl_iterator<ObjCPropertyDecl>(ObjCPropertyDecl.class, decls_end());
  }

  
  /*typedef filtered_decl_iterator<ObjCPropertyDecl, &FPtrObjCPropertyDecl::isInstanceProperty> instprop_iterator*/
//  public final class instprop_iterator extends DeclContext.filtered_decl_iterator<ObjCPropertyDecl>{ };
  /*typedef llvm::iterator_range<instprop_iterator> instprop_range*/
//  public final class instprop_range extends iterator_range<ObjCPropertyDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::instance_properties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 934,
   FQN="clang::ObjCContainerDecl::instance_properties", NM="_ZNK5clang17ObjCContainerDecl19instance_propertiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl19instance_propertiesEv")
  //</editor-fold>
  public iterator_range<ObjCPropertyDecl /*P*/ > instance_properties() /*const*/ {
    return new iterator_range<ObjCPropertyDecl /*P*/ >(instprop_begin(), instprop_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::instprop_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 937,
   FQN="clang::ObjCContainerDecl::instprop_begin", NM="_ZNK5clang17ObjCContainerDecl14instprop_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl14instprop_beginEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCPropertyDecl> instprop_begin() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCPropertyDecl>(ObjCPropertyDecl.class, decls_begin(), /*AddrOf*//*FPtr*/ObjCPropertyDecl::isInstanceProperty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::instprop_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 940,
   FQN="clang::ObjCContainerDecl::instprop_end", NM="_ZNK5clang17ObjCContainerDecl12instprop_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl12instprop_endEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCPropertyDecl> instprop_end() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCPropertyDecl>(ObjCPropertyDecl.class, decls_end(), /*AddrOf*//*FPtr*/ObjCPropertyDecl::isInstanceProperty);
  }

  
  /*typedef filtered_decl_iterator<ObjCPropertyDecl, &FPtrObjCPropertyDecl::isClassProperty> classprop_iterator*/
//  public final class classprop_iterator extends DeclContext.filtered_decl_iterator<ObjCPropertyDecl>{ };
  /*typedef llvm::iterator_range<classprop_iterator> classprop_range*/
//  public final class classprop_range extends iterator_range<ObjCPropertyDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::class_properties">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 949,
   FQN="clang::ObjCContainerDecl::class_properties", NM="_ZNK5clang17ObjCContainerDecl16class_propertiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl16class_propertiesEv")
  //</editor-fold>
  public iterator_range<ObjCPropertyDecl /*P*/ > class_properties() /*const*/ {
    return new iterator_range<ObjCPropertyDecl /*P*/ >(classprop_begin(), classprop_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::classprop_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 952,
   FQN="clang::ObjCContainerDecl::classprop_begin", NM="_ZNK5clang17ObjCContainerDecl15classprop_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl15classprop_beginEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCPropertyDecl> classprop_begin() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCPropertyDecl>(ObjCPropertyDecl.class, decls_begin(), /*AddrOf*//*FPtr*/ObjCPropertyDecl::isClassProperty);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::classprop_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 955,
   FQN="clang::ObjCContainerDecl::classprop_end", NM="_ZNK5clang17ObjCContainerDecl13classprop_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl13classprop_endEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCPropertyDecl> classprop_end() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCPropertyDecl>(ObjCPropertyDecl.class, decls_end(), /*AddrOf*//*FPtr*/ObjCPropertyDecl::isClassProperty);
  }

  
  // Iterator access to instance/class methods.
  /*typedef specific_decl_iterator<ObjCMethodDecl> method_iterator*/
//  public final class method_iterator extends DeclContext.specific_decl_iterator<ObjCMethodDecl>{ };
  /*typedef llvm::iterator_range<specific_decl_iterator<ObjCMethodDecl> > method_range*/
//  public final class method_range extends iterator_range<ObjCMethodDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 964,
   FQN="clang::ObjCContainerDecl::methods", NM="_ZNK5clang17ObjCContainerDecl7methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl7methodsEv")
  //</editor-fold>
  public iterator_range<ObjCMethodDecl /*P*/ > methods() /*const*/ {
    return new iterator_range<ObjCMethodDecl /*P*/ >(meth_begin(), meth_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::meth_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 967,
   FQN="clang::ObjCContainerDecl::meth_begin", NM="_ZNK5clang17ObjCContainerDecl10meth_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl10meth_beginEv")
  //</editor-fold>
  public DeclContext.specific_decl_iterator<ObjCMethodDecl> meth_begin() /*const*/ {
    return new DeclContext.specific_decl_iterator<ObjCMethodDecl>(ObjCMethodDecl.class, decls_begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::meth_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 970,
   FQN="clang::ObjCContainerDecl::meth_end", NM="_ZNK5clang17ObjCContainerDecl8meth_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl8meth_endEv")
  //</editor-fold>
  public DeclContext.specific_decl_iterator<ObjCMethodDecl> meth_end() /*const*/ {
    return new DeclContext.specific_decl_iterator<ObjCMethodDecl>(ObjCMethodDecl.class, decls_end());
  }

  
  /*typedef filtered_decl_iterator<ObjCMethodDecl, &FPtrObjCMethodDecl::isInstanceMethod> instmeth_iterator*/
//  public final class instmeth_iterator extends DeclContext.filtered_decl_iterator<ObjCMethodDecl>{ };
  /*typedef llvm::iterator_range<instmeth_iterator> instmeth_range*/
//  public final class instmeth_range extends iterator_range<ObjCMethodDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::instance_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 979,
   FQN="clang::ObjCContainerDecl::instance_methods", NM="_ZNK5clang17ObjCContainerDecl16instance_methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl16instance_methodsEv")
  //</editor-fold>
  public iterator_range<ObjCMethodDecl /*P*/ > instance_methods() /*const*/ {
    return new iterator_range<ObjCMethodDecl /*P*/ >(instmeth_begin(), instmeth_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::instmeth_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 982,
   FQN="clang::ObjCContainerDecl::instmeth_begin", NM="_ZNK5clang17ObjCContainerDecl14instmeth_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl14instmeth_beginEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCMethodDecl> instmeth_begin() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCMethodDecl>(ObjCMethodDecl.class, decls_begin(), /*AddrOf*//*FPtr*/ObjCMethodDecl::isInstanceMethod);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::instmeth_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 985,
   FQN="clang::ObjCContainerDecl::instmeth_end", NM="_ZNK5clang17ObjCContainerDecl12instmeth_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl12instmeth_endEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCMethodDecl> instmeth_end() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCMethodDecl>(ObjCMethodDecl.class, decls_end(), /*AddrOf*//*FPtr*/ObjCMethodDecl::isInstanceMethod);
  }

  
  /*typedef filtered_decl_iterator<ObjCMethodDecl, &FPtrObjCMethodDecl::isClassMethod> classmeth_iterator*/
//  public final class classmeth_iterator extends DeclContext.filtered_decl_iterator<ObjCMethodDecl>{ };
  /*typedef llvm::iterator_range<classmeth_iterator> classmeth_range*/
//  public final class classmeth_range extends iterator_range<ObjCMethodDecl /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::class_methods">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 994,
   FQN="clang::ObjCContainerDecl::class_methods", NM="_ZNK5clang17ObjCContainerDecl13class_methodsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl13class_methodsEv")
  //</editor-fold>
  public iterator_range<ObjCMethodDecl /*P*/ > class_methods() /*const*/ {
    return new iterator_range<ObjCMethodDecl /*P*/ >(classmeth_begin(), classmeth_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::classmeth_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 997,
   FQN="clang::ObjCContainerDecl::classmeth_begin", NM="_ZNK5clang17ObjCContainerDecl15classmeth_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl15classmeth_beginEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCMethodDecl> classmeth_begin() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCMethodDecl>(ObjCMethodDecl.class, decls_begin(), /*AddrOf*//*FPtr*/ObjCMethodDecl::isClassMethod);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::classmeth_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1000,
   FQN="clang::ObjCContainerDecl::classmeth_end", NM="_ZNK5clang17ObjCContainerDecl13classmeth_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl13classmeth_endEv")
  //</editor-fold>
  public DeclContext.filtered_decl_iterator<ObjCMethodDecl> classmeth_end() /*const*/ {
    return new DeclContext.filtered_decl_iterator<ObjCMethodDecl>(ObjCMethodDecl.class, decls_end(), /*AddrOf*//*FPtr*/ObjCMethodDecl::isClassMethod);
  }

  
  // Get the local instance/class method declared in this interface.
  
  // Get the local instance/class method declared in this interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 67,
   FQN="clang::ObjCContainerDecl::getMethod", NM="_ZNK5clang17ObjCContainerDecl9getMethodENS_8SelectorEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl9getMethodENS_8SelectorEbb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getMethod(Selector Sel, boolean isInstance) /*const*/ {
    return getMethod(Sel, isInstance, 
           false);
  }
  public ObjCMethodDecl /*P*/ getMethod(Selector Sel, boolean isInstance, 
           boolean AllowHidden/*= false*/) /*const*/ {
    {
      // If this context is a hidden protocol definition, don't find any
      // methods there.
      /*const*/ ObjCProtocolDecl /*P*/ Proto = dyn_cast_ObjCProtocolDecl(this);
      if ((Proto != null)) {
        {
          /*const*/ ObjCProtocolDecl /*P*/ Def = Proto.getDefinition$Const();
          if ((Def != null)) {
            if (Def.isHidden() && !AllowHidden) {
              return null;
            }
          }
        }
      }
    }
    
    // Since instance & class methods can have the same name, the loop below
    // ensures we get the correct method.
    //
    // @interface Whatever
    // - (int) class_method;
    // + (float) class_method;
    // @end
    //
    DeclContextLookupResult R = lookup(new DeclarationName(new Selector(Sel)));
    for (DeclContextLookupResult.iterator Meth = R.begin(), MethEnd = R.end();
         Meth.$noteq(MethEnd); Meth.$preInc()) {
      ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(Meth.$star());
      if ((MD != null) && MD.isInstanceMethod() == isInstance) {
        return MD;
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1007,
   FQN="clang::ObjCContainerDecl::getInstanceMethod", NM="_ZNK5clang17ObjCContainerDecl17getInstanceMethodENS_8SelectorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl17getInstanceMethodENS_8SelectorEb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getInstanceMethod(Selector Sel) /*const*/ {
    return getInstanceMethod(Sel, 
                   false);
  }
  public ObjCMethodDecl /*P*/ getInstanceMethod(Selector Sel, 
                   boolean AllowHidden/*= false*/) /*const*/ {
    return getMethod(new Selector(Sel), true/*isInstance*/, AllowHidden);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1011,
   FQN="clang::ObjCContainerDecl::getClassMethod", NM="_ZNK5clang17ObjCContainerDecl14getClassMethodENS_8SelectorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl14getClassMethodENS_8SelectorEb")
  //</editor-fold>
  public ObjCMethodDecl /*P*/ getClassMethod(Selector Sel) /*const*/ {
    return getClassMethod(Sel, false);
  }
  public ObjCMethodDecl /*P*/ getClassMethod(Selector Sel, boolean AllowHidden/*= false*/) /*const*/ {
    return getMethod(new Selector(Sel), false/*isInstance*/, AllowHidden);
  }

  
  /// \brief This routine returns 'true' if a user declared setter method was
  /// found in the class, its protocols, its super classes or categories.
  /// It also returns 'true' if one of its categories has declared a 'readwrite'
  /// property.  This is because, user must provide a setter method for the
  /// category's 'readwrite' property.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::HasUserDeclaredSetterMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 101,
   FQN="clang::ObjCContainerDecl::HasUserDeclaredSetterMethod", NM="_ZNK5clang17ObjCContainerDecl27HasUserDeclaredSetterMethodEPKNS_16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl27HasUserDeclaredSetterMethodEPKNS_16ObjCPropertyDeclE")
  //</editor-fold>
  public boolean HasUserDeclaredSetterMethod(/*const*/ ObjCPropertyDecl /*P*/ Property) /*const*/ {
    Selector Sel = Property.getSetterName();
    DeclContextLookupResult R = lookup(new DeclarationName(new Selector(Sel)));
    for (DeclContextLookupResult.iterator Meth = R.begin(), MethEnd = R.end();
         Meth.$noteq(MethEnd); Meth.$preInc()) {
      ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(Meth.$star());
      if ((MD != null) && MD.isInstanceMethod() && !MD.isImplicit()) {
        return true;
      }
    }
    {
      
      /*const*/ ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(this);
      if ((ID != null)) {
        // Also look into categories, including class extensions, looking
        // for a user declared instance method.
        for (/*const*/ ObjCCategoryDecl /*P*/ Cat : ID.visible_categories()) {
          {
            ObjCMethodDecl /*P*/ MD = Cat.getInstanceMethod(new Selector(Sel));
            if ((MD != null)) {
              if (!MD.isImplicit()) {
                return true;
              }
            }
          }
          if (Cat.IsClassExtension()) {
            continue;
          }
          // Also search through the categories looking for a 'readwrite'
          // declaration of this property. If one found, presumably a setter will
          // be provided (properties declared in categories will not get
          // auto-synthesized).
          for (/*const*/ ObjCPropertyDecl /*P*/ P : Cat.properties())  {
            if (P.getIdentifier() == Property.getIdentifier()) {
              if (((P.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)) {
                return true;
              }
              break;
            }
          }
        }
        
        // Also look into protocols, for a user declared instance method.
        for (/*const*/ ObjCProtocolDecl /*P*/ Proto : ID.all_referenced_protocols())  {
          if (Proto.HasUserDeclaredSetterMethod(Property)) {
            return true;
          }
        }
        
        // And in its super class.
        ObjCInterfaceDecl /*P*/ OSC = ID.getSuperClass();
        while ((OSC != null)) {
          if (OSC.HasUserDeclaredSetterMethod(Property)) {
            return true;
          }
          OSC = OSC.getSuperClass();
        }
      }
    }
    {
      /*const*/ ObjCProtocolDecl /*P*/ PD = dyn_cast_ObjCProtocolDecl(this);
      if ((PD != null)) {
        for (/*const*/ ObjCProtocolDecl /*P*/ PI : PD.protocols())  {
          if (PI.HasUserDeclaredSetterMethod(Property)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  
  /// getIvarDecl - This method looks up an ivar in this ContextDecl.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getIvarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 55,
   FQN="clang::ObjCContainerDecl::getIvarDecl", NM="_ZNK5clang17ObjCContainerDecl11getIvarDeclEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl11getIvarDeclEPNS_14IdentifierInfoE")
  //</editor-fold>
  public ObjCIvarDecl /*P*/ getIvarDecl(IdentifierInfo /*P*/ Id) /*const*/ {
    DeclContextLookupResult R = lookup(new DeclarationName(Id));
    for (DeclContextLookupResult.iterator Ivar = R.begin(), IvarEnd = R.end();
         Ivar.$noteq(IvarEnd); Ivar.$preInc()) {
      {
        ObjCIvarDecl /*P*/ ivar = dyn_cast_ObjCIvarDecl(Ivar.$star());
        if ((ivar != null)) {
          return ivar;
        }
      }
    }
    return null;
  }

  
  
  /// FindPropertyDeclaration - Finds declaration of the property given its name
  /// in 'PropertyId' and returns it. It returns 0, if not found.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::FindPropertyDeclaration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 213,
   FQN="clang::ObjCContainerDecl::FindPropertyDeclaration", NM="_ZNK5clang17ObjCContainerDecl23FindPropertyDeclarationEPKNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl23FindPropertyDeclarationEPKNS_14IdentifierInfoENS_21ObjCPropertyQueryKindE")
  //</editor-fold>
  public ObjCPropertyDecl /*P*/ FindPropertyDeclaration(/*const*/ IdentifierInfo /*P*/ PropertyId, 
                         /*ObjCPropertyQueryKind*/byte/*uint8_t*/ QueryKind) /*const*/ {
    {
      // Don't find properties within hidden protocol definitions.
      /*const*/ ObjCProtocolDecl /*P*/ Proto = dyn_cast_ObjCProtocolDecl(this);
      if ((Proto != null)) {
        {
          /*const*/ ObjCProtocolDecl /*P*/ Def = Proto.getDefinition$Const();
          if ((Def != null)) {
            if (Def.isHidden()) {
              return null;
            }
          }
        }
      }
    }
    {
      
      // Search the extensions of a class first; they override what's in
      // the class itself.
      /*const*/ ObjCInterfaceDecl /*P*/ ClassDecl = dyn_cast_ObjCInterfaceDecl(this);
      if ((ClassDecl != null)) {
        for (/*const*/ ObjCCategoryDecl /*P*/ Ext : ClassDecl.visible_extensions()) {
          {
            ObjCPropertyDecl /*P*/ P = Ext.FindPropertyDeclaration(PropertyId, QueryKind);
            if ((P != null)) {
              return P;
            }
          }
        }
      }
    }
    {
      
      ObjCPropertyDecl /*P*/ PD = ObjCPropertyDecl.findPropertyDecl(cast_DeclContext(this), PropertyId, 
          QueryKind);
      if ((PD != null)) {
        return PD;
      }
    }
    switch (getKind()) {
     default:
      break;
     case ObjCProtocol:
      {
        /*const*/ ObjCProtocolDecl /*P*/ PID = cast_ObjCProtocolDecl(this);
        for (/*const*/ ObjCProtocolDecl /*P*/ I : PID.protocols())  {
          {
            ObjCPropertyDecl /*P*/ P = I.FindPropertyDeclaration(PropertyId, 
                QueryKind);
            if ((P != null)) {
              return P;
            }
          }
        }
        break;
      }
     case ObjCInterface:
      {
        /*const*/ ObjCInterfaceDecl /*P*/ OID = cast_ObjCInterfaceDecl(this);
        // Look through categories (but not extensions; they were handled above).
        for (/*const*/ ObjCCategoryDecl /*P*/ Cat : OID.visible_categories()) {
          if (!Cat.IsClassExtension()) {
            {
              ObjCPropertyDecl /*P*/ P = Cat.FindPropertyDeclaration(PropertyId, QueryKind);
              if ((P != null)) {
                return P;
              }
            }
          }
        }
        
        // Look through protocols.
        for (/*const*/ ObjCProtocolDecl /*P*/ I : OID.all_referenced_protocols())  {
          {
            ObjCPropertyDecl /*P*/ P = I.FindPropertyDeclaration(PropertyId, 
                QueryKind);
            if ((P != null)) {
              return P;
            }
          }
        }
        {
          
          // Finally, check the super class.
          /*const*/ ObjCInterfaceDecl /*P*/ superClass = OID.getSuperClass();
          if ((superClass != null)) {
            return superClass.FindPropertyDeclaration(PropertyId, QueryKind);
          }
        }
        break;
      }
     case ObjCCategory:
      {
        /*const*/ ObjCCategoryDecl /*P*/ OCD = cast_ObjCCategoryDecl(this);
        // Look through protocols.
        if (!OCD.IsClassExtension()) {
          for (/*const*/ ObjCProtocolDecl /*P*/ I : OCD.protocols())  {
            {
              ObjCPropertyDecl /*P*/ P = I.FindPropertyDeclaration(PropertyId, 
                  QueryKind);
              if ((P != null)) {
                return P;
              }
            }
          }
        }
        break;
      }
    }
    return null;
  }

  
  /*typedef llvm::DenseMap<std::pair<IdentifierInfo *, unsigned int>, ObjCPropertyDecl *> PropertyMap*/
//  public final class PropertyMap extends DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >{ };
  
  /*typedef llvm::DenseMap<const ObjCProtocolDecl *, ObjCPropertyDecl *> ProtocolPropertyMap*/
//  public final class ProtocolPropertyMap extends DenseMap</*const*/ ObjCProtocolDecl /*P*/ , ObjCPropertyDecl /*P*/ >{ };
  
  /*typedef llvm::SmallVector<ObjCPropertyDecl *, 8> PropertyDeclOrder*/
//  public final class PropertyDeclOrder extends SmallVector<ObjCPropertyDecl /*P*/ >{ };
  
  /// This routine collects list of properties to be implemented in the class.
  /// This includes, class's and its conforming protocols' properties.
  /// Note, the superclass's properties are not included in the list.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::collectPropertiesToImplement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1033,
   FQN="clang::ObjCContainerDecl::collectPropertiesToImplement", NM="_ZNK5clang17ObjCContainerDecl28collectPropertiesToImplementERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S8_EEEERNS1_11SmallVectorIS8_Lj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl28collectPropertiesToImplementERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_S8_EEEERNS1_11SmallVectorIS8_Lj8EEE")
  //</editor-fold>
  public /*virtual*/ void collectPropertiesToImplement(final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PM, 
                              final SmallVector<ObjCPropertyDecl /*P*/ > /*&*/ PO) /*const*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getAtStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1036,
   FQN="clang::ObjCContainerDecl::getAtStartLoc", NM="_ZNK5clang17ObjCContainerDecl13getAtStartLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl13getAtStartLocEv")
  //</editor-fold>
  public SourceLocation getAtStartLoc() /*const*/ {
    return new SourceLocation(AtStart);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::setAtStartLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1037,
   FQN="clang::ObjCContainerDecl::setAtStartLoc", NM="_ZN5clang17ObjCContainerDecl13setAtStartLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl13setAtStartLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAtStartLoc(SourceLocation Loc) {
    AtStart.$assign(Loc);
  }

  
  // Marks the end of the container.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getAtEndRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1040,
   FQN="clang::ObjCContainerDecl::getAtEndRange", NM="_ZNK5clang17ObjCContainerDecl13getAtEndRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl13getAtEndRangeEv")
  //</editor-fold>
  public SourceRange getAtEndRange() /*const*/ {
    return new SourceRange(AtEnd);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::setAtEndRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1043,
   FQN="clang::ObjCContainerDecl::setAtEndRange", NM="_ZN5clang17ObjCContainerDecl13setAtEndRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl13setAtEndRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setAtEndRange(SourceRange atEnd) {
    AtEnd.$assign(atEnd);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1047,
   FQN="clang::ObjCContainerDecl::getSourceRange", NM="_ZNK5clang17ObjCContainerDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang17ObjCContainerDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/AtStart, getAtEndRange().getEnd());
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1052,
   FQN="clang::ObjCContainerDecl::classof", NM="_ZN5clang17ObjCContainerDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1053,
   FQN="clang::ObjCContainerDecl::classofKind", NM="_ZN5clang17ObjCContainerDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstObjCContainer.getValue()
       && K.getValue() <= Kind.lastObjCContainer.getValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1058,
   FQN="clang::ObjCContainerDecl::castToDeclContext", NM="_ZN5clang17ObjCContainerDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ ObjCContainerDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/ObjCContainerDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 1061,
   FQN="clang::ObjCContainerDecl::castFromDeclContext", NM="_ZN5clang17ObjCContainerDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static ObjCContainerDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/ObjCContainerDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCContainerDecl::~ObjCContainerDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 901,
   FQN="clang::ObjCContainerDecl::~ObjCContainerDecl", NM="_ZN5clang17ObjCContainerDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang17ObjCContainerDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
  }

  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  @Override public String toString() {
    return "" + "AtStart=" + AtStart // NOI18N
              + ", AtEnd=" + AtEnd // NOI18N
              + super.toString(); // NOI18N
  }
}
