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


/// \brief Represents an access specifier followed by colon ':'.
///
/// An objects of this class represents sugar for the syntactic occurrence
/// of an access specifier followed by a colon in the list of member
/// specifiers of a C++ class definition.
///
/// Note that they do not represent other uses of access specifiers,
/// such as those occurring in a list of base specifiers.
/// Also note that this class has nothing to do with so-called
/// "access declarations" (C++98 11.3 [class.access.dcl]).
//<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 103,
 FQN="clang::AccessSpecDecl", NM="_ZN5clang14AccessSpecDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDeclE")
//</editor-fold>
public class AccessSpecDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // Decl Allocation/Deallocation Method Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 31,
   FQN="clang::AccessSpecDecl::anchor", NM="_ZN5clang14AccessSpecDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  /// \brief The location of the ':'.
  private SourceLocation ColonLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::AccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 108,
   FQN="clang::AccessSpecDecl::AccessSpecDecl", NM="_ZN5clang14AccessSpecDeclC1ENS_15AccessSpecifierEPNS_11DeclContextENS_14SourceLocationES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDeclC1ENS_15AccessSpecifierEPNS_11DeclContextENS_14SourceLocationES4_")
  //</editor-fold>
  private AccessSpecDecl(AccessSpecifier AS, DeclContext /*P*/ DC, 
      SourceLocation ASLoc, SourceLocation ColonLoc) {
    // : Decl(AccessSpec, DC, ASLoc), ColonLoc(ColonLoc) 
    //START JInit
    super(Kind.AccessSpec, DC, new SourceLocation(ASLoc));
    this.ColonLoc = new SourceLocation(ColonLoc);
    //END JInit
    setAccess(AS);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::AccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 113,
   FQN="clang::AccessSpecDecl::AccessSpecDecl", NM="_ZN5clang14AccessSpecDeclC1ENS_4Decl10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDeclC1ENS_4Decl10EmptyShellE")
  //</editor-fold>
  private AccessSpecDecl(EmptyShell Empty) {
    // : Decl(AccessSpec, Empty), ColonLoc() 
    //START JInit
    super(Kind.AccessSpec, new EmptyShell(Empty));
    this.ColonLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  /// \brief The location of the access specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::getAccessSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 117,
   FQN="clang::AccessSpecDecl::getAccessSpecifierLoc", NM="_ZNK5clang14AccessSpecDecl21getAccessSpecifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14AccessSpecDecl21getAccessSpecifierLocEv")
  //</editor-fold>
  public SourceLocation getAccessSpecifierLoc() /*const*/ {
    return getLocation();
  }

  /// \brief Sets the location of the access specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::setAccessSpecifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 119,
   FQN="clang::AccessSpecDecl::setAccessSpecifierLoc", NM="_ZN5clang14AccessSpecDecl21setAccessSpecifierLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl21setAccessSpecifierLocENS_14SourceLocationE")
  //</editor-fold>
  public void setAccessSpecifierLoc(SourceLocation ASLoc) {
    setLocation(new SourceLocation(ASLoc));
  }

  
  /// \brief The location of the colon following the access specifier.
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::getColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 122,
   FQN="clang::AccessSpecDecl::getColonLoc", NM="_ZNK5clang14AccessSpecDecl11getColonLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14AccessSpecDecl11getColonLocEv")
  //</editor-fold>
  public SourceLocation getColonLoc() /*const*/ {
    return new SourceLocation(ColonLoc);
  }

  /// \brief Sets the location of the colon.
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::setColonLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 124,
   FQN="clang::AccessSpecDecl::setColonLoc", NM="_ZN5clang14AccessSpecDecl11setColonLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl11setColonLocENS_14SourceLocationE")
  //</editor-fold>
  public void setColonLoc(SourceLocation CLoc) {
    ColonLoc.$assign(CLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 126,
   FQN="clang::AccessSpecDecl::getSourceRange", NM="_ZNK5clang14AccessSpecDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang14AccessSpecDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(getAccessSpecifierLoc(), getColonLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 130,
   FQN="clang::AccessSpecDecl::Create", NM="_ZN5clang14AccessSpecDecl6CreateERNS_10ASTContextENS_15AccessSpecifierEPNS_11DeclContextENS_14SourceLocationES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl6CreateERNS_10ASTContextENS_15AccessSpecifierEPNS_11DeclContextENS_14SourceLocationES6_")
  //</editor-fold>
  public static AccessSpecDecl /*P*/ Create(final ASTContext /*&*/ C, AccessSpecifier AS, 
        DeclContext /*P*/ DC, SourceLocation ASLoc, 
        SourceLocation ColonLoc) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new AccessSpecDecl(AS, DC, new SourceLocation(ASLoc), new SourceLocation(ColonLoc));
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 33,
   FQN="clang::AccessSpecDecl::CreateDeserialized", NM="_ZN5clang14AccessSpecDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static AccessSpecDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new AccessSpecDecl(new EmptyShell());
     });
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 138,
   FQN="clang::AccessSpecDecl::classof", NM="_ZN5clang14AccessSpecDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 139,
   FQN="clang::AccessSpecDecl::classofKind", NM="_ZN5clang14AccessSpecDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.AccessSpec;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AccessSpecDecl::~AccessSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 103,
   FQN="clang::AccessSpecDecl::~AccessSpecDecl", NM="_ZN5clang14AccessSpecDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang14AccessSpecDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ColonLoc=" + ColonLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
