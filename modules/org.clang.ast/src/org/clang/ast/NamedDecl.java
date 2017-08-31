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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.DeclarationName.*;
import static org.clang.ast.QualType.StreamedQualTypeHelper.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.DeclStatics.*;


/// NamedDecl - This represents a decl with a name.  Many decls have names such
/// as ObjCMethodDecl, but not \@class, etc.
//<editor-fold defaultstate="collapsed" desc="clang::NamedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 213,
 FQN="clang::NamedDecl", NM="_ZN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDeclE")
//</editor-fold>
public class NamedDecl extends /*public*/ Decl implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1004,
   FQN="clang::NamedDecl::anchor", NM="_ZN5clang9NamedDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  /// Name - The name of this declaration, which is typically a normal
  /// identifier but may also be a special kind of name (C++
  /// constructor, Objective-C selector, etc.)
  private DeclarationName Name;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getUnderlyingDeclImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1602,
   FQN="clang::NamedDecl::getUnderlyingDeclImpl", NM="_ZN5clang9NamedDecl21getUnderlyingDeclImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl21getUnderlyingDeclImplEv")
  //</editor-fold>
  private NamedDecl /*P*/ getUnderlyingDeclImpl()/* __attribute__((pure))*/ {
    NamedDecl /*P*/ ND = this;
    {
      UsingShadowDecl /*P*/ UD;
      while (((/*P*/ UD = dyn_cast_UsingShadowDecl(ND)) != null)) {
        ND = UD.getTargetDecl();
      }
    }
    {
      
      ObjCCompatibleAliasDecl /*P*/ AD = dyn_cast_ObjCCompatibleAliasDecl(ND);
      if ((AD != null)) {
        return AD.getClassInterface();
      }
    }
    {
      
      NamespaceAliasDecl /*P*/ AD = dyn_cast_NamespaceAliasDecl(ND);
      if ((AD != null)) {
        return AD.getNamespace();
      }
    }
    
    return ND;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::NamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 224,
   FQN="clang::NamedDecl::NamedDecl", NM="_ZN5clang9NamedDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDeclC1ENS_4Decl4KindEPNS_11DeclContextENS_14SourceLocationENS_15DeclarationNameE")
  //</editor-fold>
  protected NamedDecl(Kind DK, DeclContext /*P*/ DC, SourceLocation L, DeclarationName N) {
    // : Decl(DK, DC, L), Name(N) 
    //START JInit
    super(DK, DC, new SourceLocation(L));
    this.Name = new DeclarationName(N);
    //END JInit
  }

/*public:*/
  /// getIdentifier - Get the identifier that names this declaration,
  /// if there is one. This will return NULL if this declaration has
  /// no name (e.g., for an unnamed class) or if the name is a special
  /// name (C++ constructor, Objective-C selector, etc.).
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 232,
   FQN="clang::NamedDecl::getIdentifier", NM="_ZNK5clang9NamedDecl13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    return Name.getAsIdentifierInfo();
  }

  
  /// getName - Get the name of identifier for this declaration as a StringRef.
  /// This requires that the declaration have a name and that it be a simple
  /// identifier.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 237,
   FQN="clang::NamedDecl::getName", NM="_ZNK5clang9NamedDecl7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    assert (Name.isIdentifier()) : "Name is not a simple identifier";
    return (getIdentifier() != null) ? getIdentifier().getName() : new StringRef(/*KEEP_STR*/$EMPTY);
  }

  
  /// getNameAsString - Get a human-readable name for the declaration, even if
  /// it is one of the special kinds of names (C++ constructor, Objective-C
  /// selector, etc).  Creating this name requires expensive string
  /// manipulation, so it should be called only when performance doesn't matter.
  /// For simple declarations, getNameAsCString() should suffice.
  //
  // FIXME: This function should be renamed to indicate that it is not just an
  // alternate form of getName(), and clients should move as appropriate.
  //
  // FIXME: Deprecated, move clients to getName().
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 252,
   FQN="clang::NamedDecl::getNameAsString", NM="_ZNK5clang9NamedDecl15getNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl15getNameAsStringEv")
  //</editor-fold>
  public std.string getNameAsString() /*const*/ {
    return Name.getAsString();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::printName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 254,
   FQN="clang::NamedDecl::printName", NM="_ZNK5clang9NamedDecl9printNameERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl9printNameERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printName(final raw_ostream /*&*/ os) /*const*/ {
    $out_raw_ostream_DeclarationName(os, /*NO_COPY*/Name);
  }

  
  /// getDeclName - Get the actual, stored name of the declaration,
  /// which may be a special name.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getDeclName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 258,
   FQN="clang::NamedDecl::getDeclName", NM="_ZNK5clang9NamedDecl11getDeclNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl11getDeclNameEv")
  //</editor-fold>
  public DeclarationName getDeclName() /*const*/ {
    return new DeclarationName(Name);
  }

  
  /// \brief Set the name of this declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::setDeclName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 261,
   FQN="clang::NamedDecl::setDeclName", NM="_ZN5clang9NamedDecl11setDeclNameENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl11setDeclNameENS_15DeclarationNameE")
  //</editor-fold>
  public void setDeclName(DeclarationName N) {
    Name.$assign(N);
  }

  
  /// printQualifiedName - Returns human-readable qualified name for
  /// declaration, like A::B::i, for i being member of namespace A::B.
  /// If declaration is not member of context which can be named (record,
  /// namespace), it will return same result as printName().
  /// Creating this name is expensive, so it should be called only when
  /// performance doesn't matter.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::printQualifiedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1405,
   FQN="clang::NamedDecl::printQualifiedName", NM="_ZNK5clang9NamedDecl18printQualifiedNameERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl18printQualifiedNameERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void printQualifiedName(final raw_ostream /*&*/ OS) /*const*/ {
    printQualifiedName(OS, getASTContext().getPrintingPolicy());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::printQualifiedName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1409,
   FQN="clang::NamedDecl::printQualifiedName", NM="_ZNK5clang9NamedDecl18printQualifiedNameERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl18printQualifiedNameERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printQualifiedName(final raw_ostream /*&*/ OS, 
                    final /*const*/ PrintingPolicy /*&*/ P) /*const*/ {
    /*const*/ DeclContext /*P*/ Ctx = getDeclContext$Const();
    if (Ctx.isFunctionOrMethod()) {
      printName(OS);
      return;
    }
    
    /*typedef SmallVector<const DeclContext *, 8> ContextsTy*/
//    final class ContextsTy extends SmallVector</*const*/ DeclContext /*P*/ >{ };
    SmallVector</*const*/ DeclContext /*P*/ > Contexts/*J*/= new SmallVector</*const*/ DeclContext /*P*/ >(8, (/*const*/ DeclContext /*P*/ )null);
    
    // Collect contexts.
    while ((Ctx != null) && isa_NamedDecl(Ctx)) {
      Contexts.push_back(Ctx);
      Ctx = Ctx.getParent$Const();
    }
    
    for (/*const*/ DeclContext /*P*/ DC : reverse$NotHasRBegin(Contexts)) {
      {
        /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(DC);
        if ((Spec != null)) {
          OS.$out(Spec.getName());
          final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = Spec.getTemplateArgs();
          TemplateSpecializationType.PrintTemplateArgumentList1(OS, TemplateArgs.asArray(), P);
        } else {
          /*const*/ NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(DC);
          if ((ND != null)) {
            if (P.SuppressUnwrittenScope
               && (ND.isAnonymousNamespace() || ND.isInline())) {
              continue;
            }
            if (ND.isAnonymousNamespace()) {
              OS.$out((P.MSVCFormatting ? $("`anonymous namespace'") : $("(anonymous namespace)")));
            } else {
              $out_raw_ostream_NamedDecl$C(OS, $Deref(ND));
            }
          } else {
            /*const*/ RecordDecl /*P*/ RD = dyn_cast_RecordDecl(DC);
            if ((RD != null)) {
              if (!(RD.getIdentifier() != null)) {
                OS.$out(/*KEEP_STR*/"(anonymous ").$out(RD.getKindName()).$out_char($$RPAREN);
              } else {
                $out_raw_ostream_NamedDecl$C(OS, $Deref(RD));
              }
            } else {
              /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
              if ((FD != null)) {
                /*const*/ FunctionProtoType /*P*/ FT = null;
                if (FD.hasWrittenPrototype()) {
                  FT = dyn_cast_FunctionProtoType(FD.getType().$arrow().castAs(FunctionType.class));
                }
                
                $out_raw_ostream_NamedDecl$C(OS, $Deref(FD)).$out_char($$LPAREN);
                if ((FT != null)) {
                  /*uint*/int NumParams = FD.getNumParams();
                  for (/*uint*/int i = 0; $less_uint(i, NumParams); ++i) {
                    if ((i != 0)) {
                      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
                    }
                    $out_raw_ostream_StreamedQualTypeHelper$C(OS, FD.getParamDecl$Const(i).getType().stream(P));
                  }
                  if (FT.isVariadic()) {
                    if ($greater_uint(NumParams, 0)) {
                      OS.$out(/*KEEP_STR*/$COMMA_SPACE);
                    }
                    OS.$out(/*KEEP_STR*/$ELLIPSIS);
                  }
                }
                OS.$out_char($$RPAREN);
              } else {
                /*const*/ EnumDecl /*P*/ ED = dyn_cast_EnumDecl(DC);
                if ((ED != null)) {
                  // C++ [dcl.enum]p10: Each enum-name and each unscoped
                  // enumerator is declared in the scope that immediately contains
                  // the enum-specifier. Each scoped enumerator is declared in the
                  // scope of the enumeration.
                  if (ED.isScoped() || (ED.getIdentifier() != null)) {
                    $out_raw_ostream_NamedDecl$C(OS, $Deref(ED));
                  } else {
                    continue;
                  }
                } else {
                  $out_raw_ostream_NamedDecl$C(OS, $Deref(cast_NamedDecl(DC)));
                }
              }
            }
          }
        }
      }
      OS.$out(/*KEEP_STR*/$COLON_COLON);
    }
    if (getDeclName().$bool()) {
      $out_raw_ostream_NamedDecl$C(OS, /*Deref*/this);
    } else {
      OS.$out(/*KEEP_STR*/"(anonymous)");
    }
  }

  
  // FIXME: Remove string version.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getQualifiedNameAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1398,
   FQN="clang::NamedDecl::getQualifiedNameAsString", NM="_ZNK5clang9NamedDecl24getQualifiedNameAsStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl24getQualifiedNameAsStringEv")
  //</editor-fold>
  public std.string getQualifiedNameAsString() /*const*/ {
    raw_string_ostream OS = null;
    try {
      std.string QualName/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(QualName);
      printQualifiedName(OS, getASTContext().getPrintingPolicy());
      return new std.string(OS.str());
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  
  /// getNameForDiagnostic - Appends a human-readable name for this
  /// declaration into the given stream.
  ///
  /// This is the method invoked by Sema when displaying a NamedDecl
  /// in a diagnostic.  It does not necessarily produce the same
  /// result as printName(); for example, class template
  /// specializations are printed with their template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getNameForDiagnostic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1490,
   FQN="clang::NamedDecl::getNameForDiagnostic", NM="_ZNK5clang9NamedDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl20getNameForDiagnosticERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb")
  //</editor-fold>
  public void getNameForDiagnostic(final raw_ostream /*&*/ OS, 
                      final /*const*/ PrintingPolicy /*&*/ Policy, 
                      boolean Qualified) /*const*/ {
    if (Qualified) {
      printQualifiedName(OS, Policy);
    } else {
      printName(OS);
    }
  }

  
  /// \brief Determine whether this declaration, if
  /// known to be well-formed within its context, will replace the
  /// declaration OldD if introduced into scope. A declaration will
  /// replace another declaration if, for example, it is a
  /// redeclaration of the same variable or function, but not if it is
  /// a declaration of a different kind (function vs. class) or an
  /// overloaded function.
  ///
  /// \param IsKnownNewer \c true if this declaration is known to be newer
  /// than \p OldD (for instance, if this declaration is newly-created).
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::declarationReplaces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1514,
   FQN="clang::NamedDecl::declarationReplaces", NM="_ZNK5clang9NamedDecl19declarationReplacesEPS0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl19declarationReplacesEPS0_b")
  //</editor-fold>
  public boolean declarationReplaces(NamedDecl /*P*/ OldD) /*const*/ {
    return declarationReplaces(OldD, true);
  }
  public boolean declarationReplaces(NamedDecl /*P*/ OldD, boolean IsKnownNewer/*= true*/) /*const*/ {
    assert ($eq_DeclarationName(getDeclName(), OldD.getDeclName())) : "Declaration name mismatch";
    
    // Never replace one imported declaration with another; we need both results
    // when re-exporting.
    if (OldD.isFromASTFile() && isFromASTFile()) {
      return false;
    }
    
    // A kind mismatch implies that the declaration is not replaced.
    if (OldD.getKind() != getKind()) {
      return false;
    }
    
    // For method declarations, we never replace. (Why?)
    if (isa_ObjCMethodDecl(this)) {
      return false;
    }
    
    // For parameters, pick the newer one. This is either an error or (in
    // Objective-C) permitted as an extension.
    if (isa_ParmVarDecl(this)) {
      return true;
    }
    
    // Inline namespaces can give us two declarations with the same
    // name and kind in the same scope but different contexts; we should
    // keep both declarations in this case.
    if (!this.getDeclContext$Const().getRedeclContext$Const().Equals(OldD.getDeclContext().getRedeclContext())) {
      return false;
    }
    {
      
      // Using declarations can be replaced if they import the same name from the
      // same context.
      /*const*/ UsingDecl /*P*/ UD = dyn_cast_UsingDecl(this);
      if ((UD != null)) {
        final ASTContext /*&*/ Context = getASTContext();
        return Context.getCanonicalNestedNameSpecifier(UD.getQualifier())
           == Context.getCanonicalNestedNameSpecifier(cast_UsingDecl(OldD).getQualifier());
      }
    }
    {
      /*const*/ UnresolvedUsingValueDecl /*P*/ UUVD = dyn_cast_UnresolvedUsingValueDecl(this);
      if ((UUVD != null)) {
        final ASTContext /*&*/ Context = getASTContext();
        return Context.getCanonicalNestedNameSpecifier(UUVD.getQualifier())
           == Context.getCanonicalNestedNameSpecifier(cast_UnresolvedUsingValueDecl(OldD).getQualifier());
      }
    }
    {
      
      // UsingDirectiveDecl's are not really NamedDecl's, and all have same name.
      // They can be replaced if they nominate the same namespace.
      // FIXME: Is this true even if they have different module visibility?
      /*const*/ UsingDirectiveDecl /*P*/ UD = dyn_cast_UsingDirectiveDecl(this);
      if ((UD != null)) {
        return UD.getNominatedNamespace$Const().getOriginalNamespace$Const()
           == cast_UsingDirectiveDecl(OldD).getNominatedNamespace().
            getOriginalNamespace();
      }
    }
    if (isRedeclarable(getKind())) {
      if (getCanonicalDecl$Const() != OldD.getCanonicalDecl()) {
        return false;
      }
      if (IsKnownNewer) {
        return true;
      }
      
      // Check whether this is actually newer than OldD. We want to keep the
      // newer declaration. This loop will usually only iterate once, because
      // OldD is usually the previous declaration.
      for (Decl /*P*/ D : decl_redecls()) {
        if (D == OldD) {
          break;
        }
        
        // If we reach the canonical declaration, then OldD is not actually older
        // than this one.
        //
        // FIXME: In this case, we should not add this decl to the lookup table.
        if (D.isCanonicalDecl()) {
          return false;
        }
      }
      
      // It's a newer declaration of the same kind of declaration in the same
      // scope: we want this decl instead of the existing one.
      return true;
    }
    
    // In all other cases, we need to keep both declarations in case they have
    // different visibility. Any attempt to use the name will result in an
    // ambiguity if more than one is visible.
    return false;
  }

  
  /// \brief Determine whether this declaration has linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::hasLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1598,
   FQN="clang::NamedDecl::hasLinkage", NM="_ZNK5clang9NamedDecl10hasLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl10hasLinkageEv")
  //</editor-fold>
  public boolean hasLinkage() /*const*/ {
    return getFormalLinkage() != Linkage.NoLinkage;
  }

  
  //JAVA: using Decl::isModulePrivate;
  //JAVA: using Decl::setModulePrivate;
  
  /// \brief Determine whether this declaration is hidden from name lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::isHidden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 305,
   FQN="clang::NamedDecl::isHidden", NM="_ZNK5clang9NamedDecl8isHiddenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl8isHiddenEv")
  //</editor-fold>
  public boolean isHidden() /*const*/ {
    return Hidden;
  }

  
  /// \brief Set whether this declaration is hidden from name lookup.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::setHidden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 308,
   FQN="clang::NamedDecl::setHidden", NM="_ZN5clang9NamedDecl9setHiddenEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl9setHiddenEb")
  //</editor-fold>
  public void setHidden(boolean Hide) {
    assert ((!Hide || isFromASTFile() || hasLocalOwningModuleStorage())) : "declaration with no owning module can't be hidden";
    Hidden = Hide;
  }

  
  /// \brief Determine whether this declaration is a C++ class member.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::isCXXClassMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 315,
   FQN="clang::NamedDecl::isCXXClassMember", NM="_ZNK5clang9NamedDecl16isCXXClassMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl16isCXXClassMemberEv")
  //</editor-fold>
  public boolean isCXXClassMember() /*const*/ {
    /*const*/ DeclContext /*P*/ DC = getDeclContext$Const();
    
    // C++0x [class.mem]p1:
    //   The enumerators of an unscoped enumeration defined in
    //   the class are members of the class.
    if (isa_EnumDecl(DC)) {
      DC = DC.getRedeclContext$Const();
    }
    
    return DC.isRecord();
  }

  
  /// \brief Determine whether the given declaration is an instance member of
  /// a C++ class.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::isCXXInstanceMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1616,
   FQN="clang::NamedDecl::isCXXInstanceMember", NM="_ZNK5clang9NamedDecl19isCXXInstanceMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl19isCXXInstanceMemberEv")
  //</editor-fold>
  public boolean isCXXInstanceMember() /*const*/ {
    if (!isCXXClassMember()) {
      return false;
    }
    
    /*const*/ NamedDecl /*P*/ D = this;
    if (isa_UsingShadowDecl(D)) {
      D = cast_UsingShadowDecl(D).getTargetDecl();
    }
    if (isa_FieldDecl(D) || isa_IndirectFieldDecl(D) || isa_MSPropertyDecl(D)) {
      return true;
    }
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(D.getAsFunction$Const());
      if ((MD != null)) {
        return MD.isInstance();
      }
    }
    return false;
  }

  
  /// \brief Determine what kind of linkage this entity has.
  /// This is not the linkage as defined by the standard or the codegen notion
  /// of linkage. It is just an implementation detail that is used to compute
  /// those.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getLinkageInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1030,
   FQN="clang::NamedDecl::getLinkageInternal", NM="_ZNK5clang9NamedDecl18getLinkageInternalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl18getLinkageInternalEv")
  //</editor-fold>
  public Linkage getLinkageInternal() /*const*/ {
    // We don't care about visibility here, so ask for the cheapest
    // possible visibility analysis.
    return getLVForDecl(this, LVComputationKind.LVForLinkageOnly).getLinkage();
  }

  
  /// \brief Get the linkage from a semantic point of view. Entities in
  /// anonymous namespaces are external (in c++98).
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getFormalLinkage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 339,
   FQN="clang::NamedDecl::getFormalLinkage", NM="_ZNK5clang9NamedDecl16getFormalLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl16getFormalLinkageEv")
  //</editor-fold>
  public Linkage getFormalLinkage() /*const*/ {
    return BasicClangGlobals.getFormalLinkage(getLinkageInternal());
  }

  
  /// \brief True if this decl has external linkage.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::hasExternalFormalLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 344,
   FQN="clang::NamedDecl::hasExternalFormalLinkage", NM="_ZNK5clang9NamedDecl24hasExternalFormalLinkageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl24hasExternalFormalLinkageEv")
  //</editor-fold>
  public boolean hasExternalFormalLinkage() /*const*/ {
    return isExternalFormalLinkage(getLinkageInternal());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::isExternallyVisible">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 348,
   FQN="clang::NamedDecl::isExternallyVisible", NM="_ZNK5clang9NamedDecl19isExternallyVisibleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl19isExternallyVisibleEv")
  //</editor-fold>
  public boolean isExternallyVisible() /*const*/ {
    return BasicClangGlobals.isExternallyVisible(getLinkageInternal());
  }

  
  /// \brief Determines the visibility of this entity.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 353,
   FQN="clang::NamedDecl::getVisibility", NM="_ZNK5clang9NamedDecl13getVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl13getVisibilityEv")
  //</editor-fold>
  public Visibility getVisibility() /*const*/ {
    return getLinkageAndVisibility().getVisibility();
  }

  
  /// \brief Determines the linkage and visibility of this entity.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getLinkageAndVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1036,
   FQN="clang::NamedDecl::getLinkageAndVisibility", NM="_ZNK5clang9NamedDecl23getLinkageAndVisibilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl23getLinkageAndVisibilityEv")
  //</editor-fold>
  public LinkageInfo getLinkageAndVisibility() /*const*/ {
    LVComputationKind computation = (usesTypeVisibility(this) ? LVComputationKind.LVForType : LVComputationKind.LVForValue);
    return getLVForDecl(this, computation);
  }

  
  /// Kinds of explicit visibility.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::ExplicitVisibilityKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 361,
   FQN="clang::NamedDecl::ExplicitVisibilityKind", NM="_ZN5clang9NamedDecl22ExplicitVisibilityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl22ExplicitVisibilityKindE")
  //</editor-fold>
  public enum ExplicitVisibilityKind implements Native.ComparableLower {
    VisibilityForType(0),
    VisibilityForValue(VisibilityForType.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ExplicitVisibilityKind valueOf(int val) {
      ExplicitVisibilityKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ExplicitVisibilityKind[] VALUES;
      private static final ExplicitVisibilityKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ExplicitVisibilityKind kind : ExplicitVisibilityKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ExplicitVisibilityKind[min < 0 ? (1-min) : 0];
        VALUES = new ExplicitVisibilityKind[max >= 0 ? (1+max) : 0];
        for (ExplicitVisibilityKind kind : ExplicitVisibilityKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ExplicitVisibilityKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ExplicitVisibilityKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ExplicitVisibilityKind)obj).value);}
    //</editor-fold>
  };
  
  /// \brief If visibility was explicitly specified for this
  /// declaration, return that visibility.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getExplicitVisibility">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1112,
   FQN="clang::NamedDecl::getExplicitVisibility", NM="_ZNK5clang9NamedDecl21getExplicitVisibilityENS0_22ExplicitVisibilityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl21getExplicitVisibilityENS0_22ExplicitVisibilityKindE")
  //</editor-fold>
  public Optional<Visibility> getExplicitVisibility(ExplicitVisibilityKind kind) /*const*/ {
    return getExplicitVisibilityAux(this, kind, false);
  }

  
  /// \brief True if the computed linkage is valid. Used for consistency
  /// checking. Should always return true.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::isLinkageValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1009,
   FQN="clang::NamedDecl::isLinkageValid", NM="_ZNK5clang9NamedDecl14isLinkageValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl14isLinkageValidEv")
  //</editor-fold>
  public boolean isLinkageValid() /*const*/ {
    if (!hasCachedLinkage()) {
      return true;
    }
    
    return computeLVForDecl(this, LVComputationKind.LVForLinkageOnly).getLinkage()
       == getCachedLinkage();
  }

  
  /// \brief True if something has required us to compute the linkage
  /// of this declaration.
  ///
  /// Language features which can retroactively change linkage (like a
  /// typedef name for linkage purposes) may need to consider this,
  /// but hopefully only in transitory ways during parsing.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::hasLinkageBeenComputed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 381,
   FQN="clang::NamedDecl::hasLinkageBeenComputed", NM="_ZNK5clang9NamedDecl22hasLinkageBeenComputedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl22hasLinkageBeenComputedEv")
  //</editor-fold>
  public boolean hasLinkageBeenComputed() /*const*/ {
    return hasCachedLinkage();
  }

  
  /// \brief Looks through UsingDecls and ObjCCompatibleAliasDecls for
  /// the underlying named decl.
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getUnderlyingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 387,
   FQN="clang::NamedDecl::getUnderlyingDecl", NM="_ZN5clang9NamedDecl17getUnderlyingDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl17getUnderlyingDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getUnderlyingDecl() {
    // Fast-path the common case.
    if (this.getKind() != Kind.UsingShadow
       && this.getKind() != Kind.ConstructorUsingShadow
       && this.getKind() != Kind.ObjCCompatibleAlias
       && this.getKind() != Kind.NamespaceAlias) {
      return this;
    }
    
    return getUnderlyingDeclImpl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getUnderlyingDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 397,
   FQN="clang::NamedDecl::getUnderlyingDecl", NM="_ZNK5clang9NamedDecl17getUnderlyingDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl17getUnderlyingDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getUnderlyingDecl$Const() /*const*/ {
    return ((/*const_cast*/NamedDecl /*P*/ )(this)).getUnderlyingDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 401,
   FQN="clang::NamedDecl::getMostRecentDecl", NM="_ZN5clang9NamedDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl17getMostRecentDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getMostRecentDecl() {
    return cast_NamedDecl(/*J:cast-to-base*/super.getMostRecentDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getMostRecentDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 404,
   FQN="clang::NamedDecl::getMostRecentDecl", NM="_ZNK5clang9NamedDecl17getMostRecentDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl17getMostRecentDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getMostRecentDecl$Const() /*const*/ {
    return ((/*const_cast*/NamedDecl /*P*/ )(this)).getMostRecentDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::getObjCFStringFormattingFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 1017,
   FQN="clang::NamedDecl::getObjCFStringFormattingFamily", NM="_ZNK5clang9NamedDecl30getObjCFStringFormattingFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang9NamedDecl30getObjCFStringFormattingFamilyEv")
  //</editor-fold>
  public ObjCStringFormatFamily getObjCFStringFormattingFamily() /*const*/ {
    StringRef name = getName();
    if (name.empty()) {
      return ObjCStringFormatFamily.SFF_None;
    }
    if (name.front() == $$C) {
      if ($eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"CFStringCreateWithFormat")
         || $eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"CFStringCreateWithFormatAndArguments")
         || $eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"CFStringAppendFormat")
         || $eq_StringRef(/*NO_COPY*/name, /*STRINGREF_STR*/"CFStringAppendFormatAndArguments")) {
        return ObjCStringFormatFamily.SFF_CFString;
      }
    }
    return ObjCStringFormatFamily.SFF_None;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 410,
   FQN="clang::NamedDecl::classof", NM="_ZN5clang9NamedDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 411,
   FQN="clang::NamedDecl::classofKind", NM="_ZN5clang9NamedDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K.getValue() >= Kind.firstNamed.getValue() && K.getValue() <= Kind.lastNamed.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NamedDecl::~NamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 213,
   FQN="clang::NamedDecl::~NamedDecl", NM="_ZN5clang9NamedDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang9NamedDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override 
  public NamedDecl getPreviousDecl() { 
    return (NamedDecl)super.getPreviousDecl(); 
  } 
  
  @Override 
  public NamedDecl getPreviousDecl$Const() { 
    return (NamedDecl)super.getPreviousDecl$Const(); 
  } 
  


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return " as$NamedDecl{" + "Name=" + Name + "}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}
