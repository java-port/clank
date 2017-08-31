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
import org.clang.ast.java.*;


/// \brief Declaration of a template type parameter.
///
/// For example, "T" in
/// \code
/// template<typename T> class vector;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1037,
 FQN="clang::TemplateTypeParmDecl", NM="_ZN5clang20TemplateTypeParmDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDeclE")
//</editor-fold>
public class TemplateTypeParmDecl extends /*public*/ TypeDecl implements Common$TemplateParmDecl<TemplateTypeParmDecl, TypeSourceInfo/*P*/>, Destructors.ClassWithDestructor {
  /// \brief Whether this template type parameter was declaration with
  /// the 'typename' keyword.
  ///
  /// If false, it was declared with the 'class' keyword.
  private /*JBIT bool*/ boolean Typename /*: 1*/;
  
  /// \brief The default template argument, if any.
  /*typedef DefaultArgStorage<TemplateTypeParmDecl, TypeSourceInfo *> DefArgStorage*/
//  public final class DefArgStorage extends DefArgStorage_TemplateTypeParmDecl{ };
  private DefArgStorage_TemplateTypeParmDecl DefaultArgument;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::TemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1049,
   FQN="clang::TemplateTypeParmDecl::TemplateTypeParmDecl", NM="_ZN5clang20TemplateTypeParmDeclC1EPNS_11DeclContextENS_14SourceLocationES3_PNS_14IdentifierInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDeclC1EPNS_11DeclContextENS_14SourceLocationES3_PNS_14IdentifierInfoEb")
  //</editor-fold>
  private TemplateTypeParmDecl(DeclContext /*P*/ DC, SourceLocation KeyLoc, 
      SourceLocation IdLoc, IdentifierInfo /*P*/ Id, 
      boolean Typename) {
    // : TypeDecl(TemplateTypeParm, DC, IdLoc, Id, KeyLoc), Typename(Typename), DefaultArgument() 
    //START JInit
    super(Kind.TemplateTypeParm, DC, new SourceLocation(IdLoc), Id, new SourceLocation(KeyLoc));
    this.Typename = Typename;
    this.DefaultArgument = new DefArgStorage_TemplateTypeParmDecl();
    //END JInit
  }

  
  /// Sema creates these on the stack during auto type deduction.
  /*friend  class Sema*/
/*public:*/
  
  //===----------------------------------------------------------------------===//
  // TemplateTypeParm Allocation/Deallocation Method Implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 472,
   FQN="clang::TemplateTypeParmDecl::Create", NM="_ZN5clang20TemplateTypeParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_jjPNS_14IdentifierInfoEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl6CreateERKNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES6_jjPNS_14IdentifierInfoEbb")
  //</editor-fold>
  public static TemplateTypeParmDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, DeclContext /*P*/ DC, 
        SourceLocation KeyLoc, SourceLocation NameLoc, 
        /*uint*/int D, /*uint*/int P, IdentifierInfo /*P*/ Id, 
        boolean Typename, boolean ParameterPack) {
    TemplateTypeParmDecl /*P*/ TTPDecl = /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> Mem)->{
        return new TemplateTypeParmDecl(DC, new SourceLocation(KeyLoc), new SourceLocation(NameLoc), Id, Typename);
     });
    QualType TTPType = C.getTemplateTypeParmType(D, P, ParameterPack, TTPDecl);
    TTPDecl.setTypeForDecl(TTPType.getTypePtr());
    return TTPDecl;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 484,
   FQN="clang::TemplateTypeParmDecl::CreateDeserialized", NM="_ZN5clang20TemplateTypeParmDecl18CreateDeserializedERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl18CreateDeserializedERKNS_10ASTContextEj")
  //</editor-fold>
  public static TemplateTypeParmDecl /*P*/ CreateDeserialized(final /*const*/ ASTContext /*&*/ C, /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> Mem)->{
        return new TemplateTypeParmDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), (IdentifierInfo /*P*/ )null, false);
     });
  }

  
  /// \brief Whether this template type parameter was declared with
  /// the 'typename' keyword.
  ///
  /// If not, it was declared with the 'class' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::wasDeclaredWithTypename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1072,
   FQN="clang::TemplateTypeParmDecl::wasDeclaredWithTypename", NM="_ZNK5clang20TemplateTypeParmDecl23wasDeclaredWithTypenameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl23wasDeclaredWithTypenameEv")
  //</editor-fold>
  public boolean wasDeclaredWithTypename() /*const*/ {
    return Typename;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getDefaultArgStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1074,
   FQN="clang::TemplateTypeParmDecl::getDefaultArgStorage", NM="_ZNK5clang20TemplateTypeParmDecl20getDefaultArgStorageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl20getDefaultArgStorageEv")
  //</editor-fold>
  @Override public /*const*/DefArgStorage_TemplateTypeParmDecl/*&*/ getDefaultArgStorage() /*const*/ {
    return DefaultArgument;
  }

  
  /// \brief Determine whether this template parameter has a default
  /// argument.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::hasDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1078,
   FQN="clang::TemplateTypeParmDecl::hasDefaultArgument", NM="_ZNK5clang20TemplateTypeParmDecl18hasDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl18hasDefaultArgumentEv")
  //</editor-fold>
  @Override public boolean hasDefaultArgument() /*const*/ {
    return DefaultArgument.isSet();
  }

  
  /// \brief Retrieve the default argument, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1081,
   FQN="clang::TemplateTypeParmDecl::getDefaultArgument", NM="_ZNK5clang20TemplateTypeParmDecl18getDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl18getDefaultArgumentEv")
  //</editor-fold>
  public QualType getDefaultArgument() /*const*/ {
    return DefaultArgument.get().getType();
  }

  
  /// \brief Retrieves the default argument's source information, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getDefaultArgumentInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1086,
   FQN="clang::TemplateTypeParmDecl::getDefaultArgumentInfo", NM="_ZNK5clang20TemplateTypeParmDecl22getDefaultArgumentInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl22getDefaultArgumentInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getDefaultArgumentInfo() /*const*/ {
    return DefaultArgument.get();
  }

  
  /// \brief Retrieves the location of the default argument declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getDefaultArgumentLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 490,
   FQN="clang::TemplateTypeParmDecl::getDefaultArgumentLoc", NM="_ZNK5clang20TemplateTypeParmDecl21getDefaultArgumentLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl21getDefaultArgumentLocEv")
  //</editor-fold>
  public SourceLocation getDefaultArgumentLoc() /*const*/ {
    return hasDefaultArgument() ? getDefaultArgumentInfo().getTypeLoc().getBeginLoc() : new SourceLocation();
  }

  
  /// \brief Determines whether the default argument was inherited
  /// from a previous declaration of this template.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::defaultArgumentWasInherited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1095,
   FQN="clang::TemplateTypeParmDecl::defaultArgumentWasInherited", NM="_ZNK5clang20TemplateTypeParmDecl27defaultArgumentWasInheritedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl27defaultArgumentWasInheritedEv")
  //</editor-fold>
  public boolean defaultArgumentWasInherited() /*const*/ {
    return DefaultArgument.isInherited();
  }

  
  /// \brief Set the default argument for this template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::setDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1100,
   FQN="clang::TemplateTypeParmDecl::setDefaultArgument", NM="_ZN5clang20TemplateTypeParmDecl18setDefaultArgumentEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl18setDefaultArgumentEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public void setDefaultArgument(TypeSourceInfo /*P*/ DefArg) {
    DefaultArgument.set(DefArg);
  }

  /// \brief Set that this default argument was inherited from another
  /// parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::setInheritedDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1105,
   FQN="clang::TemplateTypeParmDecl::setInheritedDefaultArgument", NM="_ZN5clang20TemplateTypeParmDecl27setInheritedDefaultArgumentERKNS_10ASTContextEPS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl27setInheritedDefaultArgumentERKNS_10ASTContextEPS0_")
  //</editor-fold>
  public void setInheritedDefaultArgument(final /*const*/ ASTContext /*&*/ C, 
                             TemplateTypeParmDecl /*P*/ Prev) {
    DefaultArgument.setInherited(C, Prev);
  }

  
  /// \brief Removes the default argument of this template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::removeDefaultArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1111,
   FQN="clang::TemplateTypeParmDecl::removeDefaultArgument", NM="_ZN5clang20TemplateTypeParmDecl21removeDefaultArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl21removeDefaultArgumentEv")
  //</editor-fold>
  public void removeDefaultArgument() {
    DefaultArgument.clear();
  }

  
  /// \brief Set whether this template type parameter was declared with
  /// the 'typename' or 'class' keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::setDeclaredWithTypename">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1117,
   FQN="clang::TemplateTypeParmDecl::setDeclaredWithTypename", NM="_ZN5clang20TemplateTypeParmDecl23setDeclaredWithTypenameEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl23setDeclaredWithTypenameEb")
  //</editor-fold>
  public void setDeclaredWithTypename(boolean withTypename) {
    Typename = withTypename;
  }

  
  /// \brief Retrieve the depth of the template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 504,
   FQN="clang::TemplateTypeParmDecl::getDepth", NM="_ZNK5clang20TemplateTypeParmDecl8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl8getDepthEv")
  //</editor-fold>
  public /*uint*/int getDepth() /*const*/ {
    return getTypeForDecl().getAs$TemplateTypeParmType().getDepth();
  }

  
  /// \brief Retrieve the index of the template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 508,
   FQN="clang::TemplateTypeParmDecl::getIndex", NM="_ZNK5clang20TemplateTypeParmDecl8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl8getIndexEv")
  //</editor-fold>
  public /*uint*/int getIndex() /*const*/ {
    return getTypeForDecl().getAs$TemplateTypeParmType().getIndex();
  }

  
  /// \brief Returns whether this is a parameter pack.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::isParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 512,
   FQN="clang::TemplateTypeParmDecl::isParameterPack", NM="_ZNK5clang20TemplateTypeParmDecl15isParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl15isParameterPackEv")
  //</editor-fold>
  public boolean isParameterPack() /*const*/ {
    return getTypeForDecl().getAs$TemplateTypeParmType().isParameterPack();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 496,
   FQN="clang::TemplateTypeParmDecl::getSourceRange", NM="_ZNK5clang20TemplateTypeParmDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateTypeParmDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    if (hasDefaultArgument() && !defaultArgumentWasInherited()) {
      return new SourceRange(getLocStart(), 
          getDefaultArgumentInfo().getTypeLoc().getEndLoc());
    } else {
      return super.getSourceRange();
    }
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1131,
   FQN="clang::TemplateTypeParmDecl::classof", NM="_ZN5clang20TemplateTypeParmDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1132,
   FQN="clang::TemplateTypeParmDecl::classofKind", NM="_ZN5clang20TemplateTypeParmDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.TemplateTypeParm;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateTypeParmDecl::~TemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1037,
   FQN="clang::TemplateTypeParmDecl::~TemplateTypeParmDecl", NM="_ZN5clang20TemplateTypeParmDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateTypeParmDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Typename=" + Typename // NOI18N
              + ", DefaultArgument=" + DefaultArgument // NOI18N
              + super.toString(); // NOI18N
  }
}
