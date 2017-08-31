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


/// ObjCCompatibleAliasDecl - Represents alias of a class. This alias is
/// declared as \@compatibility_alias alias class.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2626,
 FQN="clang::ObjCCompatibleAliasDecl", NM="_ZN5clang23ObjCCompatibleAliasDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDeclE")
//</editor-fold>
public class ObjCCompatibleAliasDecl extends /*public*/ NamedDecl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // ObjCCompatibleAliasDecl
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2138,
   FQN="clang::ObjCCompatibleAliasDecl::anchor", NM="_ZN5clang23ObjCCompatibleAliasDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  /// Class that this is an alias of.
  private ObjCInterfaceDecl /*P*/ AliasedClass;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::ObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2631,
   FQN="clang::ObjCCompatibleAliasDecl::ObjCCompatibleAliasDecl", NM="_ZN5clang23ObjCCompatibleAliasDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDeclC1EPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  private ObjCCompatibleAliasDecl(DeclContext /*P*/ DC, SourceLocation L, IdentifierInfo /*P*/ Id, 
      ObjCInterfaceDecl /*P*/ aliasedClass) {
    // : NamedDecl(ObjCCompatibleAlias, DC, L, Id), AliasedClass(aliasedClass) 
    //START JInit
    super(Kind.ObjCCompatibleAlias, DC, new SourceLocation(L), new DeclarationName(Id));
    this.AliasedClass = aliasedClass;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2140,
   FQN="clang::ObjCCompatibleAliasDecl::Create", NM="_ZN5clang23ObjCCompatibleAliasDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationEPNS_14IdentifierInfoEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public static ObjCCompatibleAliasDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, 
        IdentifierInfo /*P*/ Id, 
        ObjCInterfaceDecl /*P*/ AliasedClass) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new ObjCCompatibleAliasDecl(DC, new SourceLocation(L), Id, AliasedClass);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2148,
   FQN="clang::ObjCCompatibleAliasDecl::CreateDeserialized", NM="_ZN5clang23ObjCCompatibleAliasDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static ObjCCompatibleAliasDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new ObjCCompatibleAliasDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                (IdentifierInfo /*P*/ )null, (ObjCInterfaceDecl /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2642,
   FQN="clang::ObjCCompatibleAliasDecl::getClassInterface", NM="_ZNK5clang23ObjCCompatibleAliasDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZNK5clang23ObjCCompatibleAliasDecl17getClassInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getClassInterface$Const() /*const*/ {
    return AliasedClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::getClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2643,
   FQN="clang::ObjCCompatibleAliasDecl::getClassInterface", NM="_ZN5clang23ObjCCompatibleAliasDecl17getClassInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl17getClassInterfaceEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getClassInterface() {
    return AliasedClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::setClassInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2644,
   FQN="clang::ObjCCompatibleAliasDecl::setClassInterface", NM="_ZN5clang23ObjCCompatibleAliasDecl17setClassInterfaceEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl17setClassInterfaceEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void setClassInterface(ObjCInterfaceDecl /*P*/ D) {
    AliasedClass = D;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2646,
   FQN="clang::ObjCCompatibleAliasDecl::classof", NM="_ZN5clang23ObjCCompatibleAliasDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2647,
   FQN="clang::ObjCCompatibleAliasDecl::classofKind", NM="_ZN5clang23ObjCCompatibleAliasDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.ObjCCompatibleAlias;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCCompatibleAliasDecl::~ObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclObjC.h", line = 2626,
   FQN="clang::ObjCCompatibleAliasDecl::~ObjCCompatibleAliasDecl", NM="_ZN5clang23ObjCCompatibleAliasDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clang23ObjCCompatibleAliasDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AliasedClass=" + AliasedClass // NOI18N
              + super.toString(); // NOI18N
  }
}
