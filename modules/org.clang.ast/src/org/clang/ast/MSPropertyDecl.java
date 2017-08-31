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


/// An instance of this class represents the declaration of a property
/// member.  This is a Microsoft extension to C++, first introduced in
/// Visual Studio .NET 2003 as a parallel to similar features in C#
/// and Managed C++.
///
/// A property must always be a non-static class member.
///
/// A property member superficially resembles a non-static data
/// member, except preceded by a property attribute:
///   __declspec(property(get=GetX, put=PutX)) int x;
/// Either (but not both) of the 'get' and 'put' names may be omitted.
///
/// A reference to a property is always an lvalue.  If the lvalue
/// undergoes lvalue-to-rvalue conversion, then a getter name is
/// required, and that member is called with no arguments.
/// If the lvalue is assigned into, then a setter name is required,
/// and that member is called with one argument, the value assigned.
/// Both operations are potentially overloaded.  Compound assignments
/// are permitted, as are the increment and decrement operators.
///
/// The getter and putter methods are permitted to be overloaded,
/// although their return and parameter types are subject to certain
/// restrictions according to the type of the property.
///
/// A property declared using an incomplete array type may
/// additionally be subscripted, adding extra parameters to the getter
/// and putter methods.
//<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3394,
 FQN="clang::MSPropertyDecl", NM="_ZN5clang14MSPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14MSPropertyDeclE")
//</editor-fold>
public class MSPropertyDecl extends /*public*/ DeclaratorDecl implements Destructors.ClassWithDestructor {
  /*friend*/public IdentifierInfo /*P*/ GetterId;
  /*friend*/public IdentifierInfo /*P*/ SetterId;
  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::MSPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3397,
   FQN="clang::MSPropertyDecl::MSPropertyDecl", NM="_ZN5clang14MSPropertyDeclC1EPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoES3_PNS_14IdentifierInfoES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14MSPropertyDeclC1EPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoES3_PNS_14IdentifierInfoES9_")
  //</editor-fold>
  private MSPropertyDecl(DeclContext /*P*/ DC, SourceLocation L, DeclarationName N, 
      QualType T, TypeSourceInfo /*P*/ TInfo, SourceLocation StartL, 
      IdentifierInfo /*P*/ Getter, IdentifierInfo /*P*/ Setter) {
    // : DeclaratorDecl(MSProperty, DC, L, N, T, TInfo, StartL), GetterId(Getter), SetterId(Setter) 
    //START JInit
    super(Kind.MSProperty, DC, new SourceLocation(L), new DeclarationName(N), new QualType(T), TInfo, new SourceLocation(StartL));
    this.GetterId = Getter;
    this.SetterId = Setter;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2320,
   FQN="clang::MSPropertyDecl::Create", NM="_ZN5clang14MSPropertyDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoES5_PNS_14IdentifierInfoESB_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14MSPropertyDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameENS_8QualTypeEPNS_14TypeSourceInfoES5_PNS_14IdentifierInfoESB_")
  //</editor-fold>
  public static MSPropertyDecl /*P*/ Create(final ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation L, DeclarationName N, 
        QualType T, TypeSourceInfo /*P*/ TInfo, 
        SourceLocation StartL, 
        IdentifierInfo /*P*/ Getter, 
        IdentifierInfo /*P*/ Setter) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new MSPropertyDecl(DC, new SourceLocation(L), new DeclarationName(N), new QualType(T), TInfo, new SourceLocation(StartL), Getter, Setter);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2329,
   FQN="clang::MSPropertyDecl::CreateDeserialized", NM="_ZN5clang14MSPropertyDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14MSPropertyDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static MSPropertyDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new MSPropertyDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new DeclarationName(), new QualType(), (TypeSourceInfo /*P*/ )null, 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, (IdentifierInfo /*P*/ )null);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3410,
   FQN="clang::MSPropertyDecl::classof", NM="_ZN5clang14MSPropertyDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14MSPropertyDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return D.getKind() == Kind.MSProperty;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::hasGetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3412,
   FQN="clang::MSPropertyDecl::hasGetter", NM="_ZNK5clang14MSPropertyDecl9hasGetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14MSPropertyDecl9hasGetterEv")
  //</editor-fold>
  public boolean hasGetter() /*const*/ {
    return GetterId != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::getGetterId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3413,
   FQN="clang::MSPropertyDecl::getGetterId", NM="_ZNK5clang14MSPropertyDecl11getGetterIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14MSPropertyDecl11getGetterIdEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getGetterId() /*const*/ {
    return GetterId;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::hasSetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3414,
   FQN="clang::MSPropertyDecl::hasSetter", NM="_ZNK5clang14MSPropertyDecl9hasSetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14MSPropertyDecl9hasSetterEv")
  //</editor-fold>
  public boolean hasSetter() /*const*/ {
    return SetterId != null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::getSetterId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3415,
   FQN="clang::MSPropertyDecl::getSetterId", NM="_ZNK5clang14MSPropertyDecl11getSetterIdEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14MSPropertyDecl11getSetterIdEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getSetterId() /*const*/ {
    return SetterId;
  }

  
  /*friend  class ASTDeclReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::MSPropertyDecl::~MSPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 3394,
   FQN="clang::MSPropertyDecl::~MSPropertyDecl", NM="_ZN5clang14MSPropertyDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14MSPropertyDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "GetterId=" + GetterId // NOI18N
              + ", SetterId=" + SetterId // NOI18N
              + super.toString(); // NOI18N
  }
}
