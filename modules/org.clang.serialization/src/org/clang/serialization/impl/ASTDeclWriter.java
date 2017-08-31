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

package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.serialization.SerializationGlobals.*;
import static org.clang.serialization.impl.SerializationStatics.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import static org.llvm.support.llvm.*;

//<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 34,
 FQN="clang::ASTDeclWriter", NM="_ZN5clang13ASTDeclWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriterE")
//</editor-fold>
public class ASTDeclWriter implements /*public*/ DeclVisitorVoid<ASTDeclWriter>, Destructors.ClassWithDestructor {
  private final ASTWriter /*&*/ Writer;
  private final ASTContext /*&*/ Context;
  private ASTRecordWriter Record;
  
  private /*DeclCode*/int Code;
  private /*uint*/int AbbrevToUse;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::ASTDeclWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 43,
   FQN="clang::ASTDeclWriter::ASTDeclWriter", NM="_ZN5clang13ASTDeclWriterC1ERNS_9ASTWriterERNS_10ASTContextERN4llvm15SmallVectorImplIyEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriterC1ERNS_9ASTWriterERNS_10ASTContextERN4llvm15SmallVectorImplIyEE")
  //</editor-fold>
  public ASTDeclWriter(final ASTWriter /*&*/ Writer, final ASTContext /*&*/ Context, 
      final SmallVectorImplULong /*&*/ Record) {
    // : DeclVisitor<ASTDeclWriter, void>(), Writer(Writer), Context(Context), Record(Writer, Record), Code((DeclCode)0), AbbrevToUse(0) 
    //START JInit
    $DeclVisitor();
    this./*&*/Writer=/*&*/Writer;
    this./*&*/Context=/*&*/Context;
    this.Record = new ASTRecordWriter(Writer, Record);
    this.Code = 0;
    this.AbbrevToUse = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::Emit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 48,
   FQN="clang::ASTDeclWriter::Emit", NM="_ZN5clang13ASTDeclWriter4EmitEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter4EmitEPNS_4DeclE")
  //</editor-fold>
  public long/*uint64_t*/ Emit(Decl /*P*/ D) {
    if (!(Code != 0)) {
      llvm.report_fatal_error($add_Twine$C($add_StringRef$C_char$ptr$C(/*STRINGREF_STR*/new StringRef("unexpected declaration kind '"), 
                  D.getDeclKindName()), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
    }
    return Record.Emit(Code, AbbrevToUse);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::Visit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 256,
   FQN="clang::ASTDeclWriter::Visit", NM="_ZN5clang13ASTDeclWriter5VisitEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter5VisitEPNS_4DeclE")
  //</editor-fold>
  public void Visit(Decl /*P*/ D) {
    DeclVisitorVoid.super.Visit(D);
    {
      
      // Source locations require array (variable-length) abbreviations.  The
      // abbreviation infrastructure requires that arrays are encoded last, so
      // we handle it here in the case of those classes derived from DeclaratorDecl
      DeclaratorDecl /*P*/ DD = dyn_cast_DeclaratorDecl(D);
      if ((DD != null)) {
        Record.AddTypeSourceInfo(DD.getTypeSourceInfo());
      }
    }
    {
      
      // Handle FunctionDecl's body here and write it after all other Stmts/Exprs
      // have been written. We want it last because we will not read it back when
      // retrieving it from the AST, we'll just lazily set the offset. 
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        Record.push_back((FD.doesThisDeclarationHaveABody() ? 1 : 0));
        if (FD.doesThisDeclarationHaveABody()) {
          Record.AddFunctionDefinition(FD);
        }
      }
    }
    {
      
      // If this declaration is also a DeclContext, write blocks for the
      // declarations that lexically stored inside its context and those
      // declarations that are visible from its context.
      DeclContext /*P*/ DC = dyn_cast_DeclContext(D);
      if ((DC != null)) {
        VisitDeclContext(DC);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 282,
   FQN="clang::ASTDeclWriter::VisitDecl", NM="_ZN5clang13ASTDeclWriter9VisitDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter9VisitDeclEPNS_4DeclE")
  //</editor-fold>
  public void VisitDecl(Decl /*P*/ D) {
    Record.AddDeclRef(cast_or_null_Decl(D.getDeclContext()));
    if (D.getDeclContext() != D.getLexicalDeclContext()) {
      Record.AddDeclRef(cast_or_null_Decl(D.getLexicalDeclContext()));
    } else {
      Record.push_back($int2ulong(0));
    }
    Record.push_back((D.isInvalidDecl() ? 1 : 0));
    Record.push_back((D.hasAttrs() ? 1 : 0));
    if (D.hasAttrs()) {
      Record.AddAttributes(new ArrayRef</*const*/ Attr /*P*/ >(JD$Convertible.INSTANCE, D.getAttrs(), true));
    }
    Record.push_back((D.isImplicit() ? 1 : 0));
    Record.push_back((D.isUsed(false) ? 1 : 0));
    Record.push_back((D.isReferenced() ? 1 : 0));
    Record.push_back((D.isTopLevelDeclInObjCContainer() ? 1 : 0));
    Record.push_back(D.getAccess().getValue());
    Record.push_back((D.isModulePrivate() ? 1 : 0));
    Record.push_back($uint2ulong(Writer.inferSubmoduleIDFromLocation(D.getLocation())));
    
    // If this declaration injected a name into a context different from its
    // lexical context, and that context is an imported namespace, we need to
    // update its visible declarations to include this name.
    //
    // This happens when we instantiate a class with a friend declaration or a
    // function with a local extern declaration, for instance.
    //
    // FIXME: Can we handle this in AddedVisibleDecl instead?
    if (D.isOutOfLine()) {
      DeclContext /*P*/ DC = D.getDeclContext();
      {
        NamespaceDecl /*P*/ NS;
        while (((/*P*/ NS = dyn_cast_NamespaceDecl(DC.getRedeclContext())) != null)) {
          if (!NS.isFromASTFile()) {
            break;
          }
          Writer.UpdatedDeclContexts.insert(NS.getPrimaryContext());
          if (!NS.isInlineNamespace()) {
            break;
          }
          DC = NS.getParent();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitPragmaCommentDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 321,
   FQN="clang::ASTDeclWriter::VisitPragmaCommentDecl", NM="_ZN5clang13ASTDeclWriter22VisitPragmaCommentDeclEPNS_17PragmaCommentDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitPragmaCommentDeclEPNS_17PragmaCommentDeclE")
  //</editor-fold>
  public void VisitPragmaCommentDecl(PragmaCommentDecl /*P*/ D) {
    StringRef Arg = D.getArg();
    Record.push_back($uint2ulong(Arg.size()));
    VisitDecl(D);
    Record.AddSourceLocation(D.getLocStart());
    Record.push_back(D.getCommentKind().getValue());
    Record.AddString(new StringRef(Arg));
    Code = DeclCode.DECL_PRAGMA_COMMENT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitPragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 331,
   FQN="clang::ASTDeclWriter::VisitPragmaDetectMismatchDecl", NM="_ZN5clang13ASTDeclWriter29VisitPragmaDetectMismatchDeclEPNS_24PragmaDetectMismatchDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter29VisitPragmaDetectMismatchDeclEPNS_24PragmaDetectMismatchDeclE")
  //</editor-fold>
  public void VisitPragmaDetectMismatchDecl(PragmaDetectMismatchDecl /*P*/ D) {
    StringRef Name = D.getName();
    StringRef Value = D.getValue();
    Record.push_back($uint2ulong(Name.size() + 1 + Value.size()));
    VisitDecl(D);
    Record.AddSourceLocation(D.getLocStart());
    Record.AddString(new StringRef(Name));
    Record.AddString(new StringRef(Value));
    Code = DeclCode.DECL_PRAGMA_DETECT_MISMATCH;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTranslationUnitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 343,
   FQN="clang::ASTDeclWriter::VisitTranslationUnitDecl", NM="_ZN5clang13ASTDeclWriter24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter24VisitTranslationUnitDeclEPNS_19TranslationUnitDeclE")
  //</editor-fold>
  public void VisitTranslationUnitDecl(TranslationUnitDecl /*P*/ D) {
    throw new llvm_unreachable("Translation units aren't directly serialized");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitNamedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 347,
   FQN="clang::ASTDeclWriter::VisitNamedDecl", NM="_ZN5clang13ASTDeclWriter14VisitNamedDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitNamedDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void VisitNamedDecl(NamedDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddDeclarationName(D.getDeclName());
    Record.push_back($uint2ulong(needsAnonymousDeclarationNumber(D) ? Writer.getAnonymousDeclarationNumber(D) : 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitLabelDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1067,
   FQN="clang::ASTDeclWriter::VisitLabelDecl", NM="_ZN5clang13ASTDeclWriter14VisitLabelDeclEPNS_9LabelDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitLabelDeclEPNS_9LabelDeclE")
  //</editor-fold>
  public void VisitLabelDecl(LabelDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getLocStart());
    Code = DeclCode.DECL_LABEL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitNamespaceDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1074,
   FQN="clang::ASTDeclWriter::VisitNamespaceDecl", NM="_ZN5clang13ASTDeclWriter18VisitNamespaceDeclEPNS_13NamespaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter18VisitNamespaceDeclEPNS_13NamespaceDeclE")
  //</editor-fold>
  public void VisitNamespaceDecl(NamespaceDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitNamedDecl(D);
    Record.push_back((D.isInline() ? 1 : 0));
    Record.AddSourceLocation(D.getLocStart());
    Record.AddSourceLocation(D.getRBraceLoc());
    if (D.isOriginalNamespace()) {
      Record.AddDeclRef(D.getAnonymousNamespace());
    }
    Code = DeclCode.DECL_NAMESPACE;
    if (Writer.hasChain() && D.isAnonymousNamespace()
       && D == D.getMostRecentDecl$Redeclarable()) {
      // This is a most recent reopening of the anonymous namespace. If its parent
      // is in a previous PCH (or is the TU), mark that parent for update, because
      // the original namespace always points to the latest re-opening of its
      // anonymous namespace.
      Decl /*P*/ Parent = cast_Decl(D.getParent().getRedeclContext().getPrimaryContext());
      if (Parent.isFromASTFile() || isa_TranslationUnitDecl(Parent)) {
        Writer.DeclUpdates.$at(Parent).push_back(new ASTWriter.DeclUpdate(DeclUpdateKind.UPD_CXX_ADDED_ANONYMOUS_NAMESPACE, D));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitUsingDirectiveDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1139,
   FQN="clang::ASTDeclWriter::VisitUsingDirectiveDecl", NM="_ZN5clang13ASTDeclWriter23VisitUsingDirectiveDeclEPNS_18UsingDirectiveDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter23VisitUsingDirectiveDeclEPNS_18UsingDirectiveDeclE")
  //</editor-fold>
  public void VisitUsingDirectiveDecl(UsingDirectiveDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getUsingLoc());
    Record.AddSourceLocation(D.getNamespaceKeyLocation());
    Record.AddNestedNameSpecifierLoc(D.getQualifierLoc());
    Record.AddDeclRef(D.getNominatedNamespace());
    Record.AddDeclRef(dyn_cast_Decl(D.getCommonAncestor()));
    Code = DeclCode.DECL_USING_DIRECTIVE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitNamespaceAliasDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1100,
   FQN="clang::ASTDeclWriter::VisitNamespaceAliasDecl", NM="_ZN5clang13ASTDeclWriter23VisitNamespaceAliasDeclEPNS_18NamespaceAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter23VisitNamespaceAliasDeclEPNS_18NamespaceAliasDeclE")
  //</editor-fold>
  public void VisitNamespaceAliasDecl(NamespaceAliasDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getNamespaceLoc());
    Record.AddSourceLocation(D.getTargetNameLoc());
    Record.AddNestedNameSpecifierLoc(D.getQualifierLoc());
    Record.AddDeclRef(D.getNamespace());
    Code = DeclCode.DECL_NAMESPACE_ALIAS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTypeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 355,
   FQN="clang::ASTDeclWriter::VisitTypeDecl", NM="_ZN5clang13ASTDeclWriter13VisitTypeDeclEPNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter13VisitTypeDeclEPNS_8TypeDeclE")
  //</editor-fold>
  public void VisitTypeDecl(TypeDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getLocStart());
    Record.AddTypeRef(new QualType(D.getTypeForDecl(), 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTypedefNameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 361,
   FQN="clang::ASTDeclWriter::VisitTypedefNameDecl", NM="_ZN5clang13ASTDeclWriter20VisitTypedefNameDeclEPNS_15TypedefNameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter20VisitTypedefNameDeclEPNS_15TypedefNameDeclE")
  //</editor-fold>
  public void VisitTypedefNameDecl(TypedefNameDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitTypeDecl(D);
    Record.AddTypeSourceInfo(D.getTypeSourceInfo());
    Record.push_back((D.isModed() ? 1 : 0));
    if (D.isModed()) {
      Record.AddTypeRef(D.getUnderlyingType());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTypedefDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 370,
   FQN="clang::ASTDeclWriter::VisitTypedefDecl", NM="_ZN5clang13ASTDeclWriter16VisitTypedefDeclEPNS_11TypedefDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter16VisitTypedefDeclEPNS_11TypedefDeclE")
  //</editor-fold>
  public void VisitTypedefDecl(TypedefDecl /*P*/ D) {
    VisitTypedefNameDecl(D);
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.isImplicit()
       && D.getFirstDecl() == D.getMostRecentDecl$Redeclarable()
       && !D.isInvalidDecl()
       && !D.isTopLevelDeclInObjCContainer()
       && !D.isModulePrivate()
       && !needsAnonymousDeclarationNumber(D)
       && D.getDeclName().getNameKind() == DeclarationName.NameKind.Identifier) {
      AbbrevToUse = Writer.getDeclTypedefAbbrev();
    }
    
    Code = DeclCode.DECL_TYPEDEF;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTypeAliasDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 386,
   FQN="clang::ASTDeclWriter::VisitTypeAliasDecl", NM="_ZN5clang13ASTDeclWriter18VisitTypeAliasDeclEPNS_13TypeAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter18VisitTypeAliasDeclEPNS_13TypeAliasDeclE")
  //</editor-fold>
  public void VisitTypeAliasDecl(TypeAliasDecl /*P*/ D) {
    VisitTypedefNameDecl(D);
    Record.AddDeclRef(D.getDescribedAliasTemplate());
    Code = DeclCode.DECL_TYPEALIAS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitUnresolvedUsingTypenameDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1157,
   FQN="clang::ASTDeclWriter::VisitUnresolvedUsingTypenameDecl", NM="_ZN5clang13ASTDeclWriter32VisitUnresolvedUsingTypenameDeclEPNS_27UnresolvedUsingTypenameDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter32VisitUnresolvedUsingTypenameDeclEPNS_27UnresolvedUsingTypenameDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingTypenameDecl(UnresolvedUsingTypenameDecl /*P*/ D) {
    VisitTypeDecl(D);
    Record.AddSourceLocation(D.getTypenameLoc());
    Record.AddNestedNameSpecifierLoc(D.getQualifierLoc());
    Code = DeclCode.DECL_UNRESOLVED_USING_TYPENAME;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTagDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 392,
   FQN="clang::ASTDeclWriter::VisitTagDecl", NM="_ZN5clang13ASTDeclWriter12VisitTagDeclEPNS_7TagDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter12VisitTagDeclEPNS_7TagDeclE")
  //</editor-fold>
  public void VisitTagDecl(TagDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitTypeDecl(D);
    Record.push_back($uint2ulong(D.getIdentifierNamespace()));
    Record.push_back($uint2ulong((/*uint*/int)D.getTagKind().getValue())); // FIXME: stable encoding
    if (!isa_CXXRecordDecl(D)) {
      Record.push_back((D.isCompleteDefinition() ? 1 : 0));
    }
    Record.push_back((D.isEmbeddedInDeclarator() ? 1 : 0));
    Record.push_back((D.isFreeStanding() ? 1 : 0));
    Record.push_back((D.isCompleteDefinitionRequired() ? 1 : 0));
    Record.AddSourceRange(D.getBraceRange());
    if (D.hasExtInfo()) {
      Record.push_back($int2ulong(1));
      Record.AddQualifierInfo($Deref(D.getExtInfo()));
    } else {
      TypedefNameDecl /*P*/ TD = D.getTypedefNameForAnonDecl();
      if ((TD != null)) {
        Record.push_back($int2ulong(2));
        Record.AddDeclRef(TD);
        Record.AddIdentifierRef(TD.getDeclName().getAsIdentifierInfo());
      } else {
        Record.push_back($int2ulong(0));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitEnumDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 416,
   FQN="clang::ASTDeclWriter::VisitEnumDecl", NM="_ZN5clang13ASTDeclWriter13VisitEnumDeclEPNS_8EnumDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter13VisitEnumDeclEPNS_8EnumDeclE")
  //</editor-fold>
  public void VisitEnumDecl(EnumDecl /*P*/ D) {
    VisitTagDecl(D);
    Record.AddTypeSourceInfo(D.getIntegerTypeSourceInfo());
    if (!(D.getIntegerTypeSourceInfo() != null)) {
      Record.AddTypeRef(D.getIntegerType());
    }
    Record.AddTypeRef(D.getPromotionType());
    Record.push_back($uint2ulong(D.getNumPositiveBits()));
    Record.push_back($uint2ulong(D.getNumNegativeBits()));
    Record.push_back((D.isScoped() ? 1 : 0));
    Record.push_back((D.isScopedUsingClassTag() ? 1 : 0));
    Record.push_back((D.isFixed() ? 1 : 0));
    {
      MemberSpecializationInfo /*P*/ MemberInfo = D.getMemberSpecializationInfo();
      if ((MemberInfo != null)) {
        Record.AddDeclRef(MemberInfo.getInstantiatedFrom());
        Record.push_back(MemberInfo.getTemplateSpecializationKind().getValue());
        Record.AddSourceLocation(MemberInfo.getPointOfInstantiation());
      } else {
        Record.AddDeclRef((/*const*/ Decl /*P*/ )null);
      }
    }
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.isImplicit()
       && !D.isUsed(false)
       && !D.hasExtInfo()
       && !(D.getTypedefNameForAnonDecl() != null)
       && D.getFirstDecl() == D.getMostRecentDecl()
       && !D.isInvalidDecl()
       && !D.isReferenced()
       && !D.isTopLevelDeclInObjCContainer()
       && D.getAccess() == AccessSpecifier.AS_none
       && !D.isModulePrivate()
       && !CXXRecordDecl.classofKind(D.getKind())
       && !(D.getIntegerTypeSourceInfo() != null)
       && !(D.getMemberSpecializationInfo() != null)
       && !needsAnonymousDeclarationNumber(D)
       && D.getDeclName().getNameKind() == DeclarationName.NameKind.Identifier) {
      AbbrevToUse = Writer.getDeclEnumAbbrev();
    }
    
    Code = DeclCode.DECL_ENUM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitRecordDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 457,
   FQN="clang::ASTDeclWriter::VisitRecordDecl", NM="_ZN5clang13ASTDeclWriter15VisitRecordDeclEPNS_10RecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter15VisitRecordDeclEPNS_10RecordDeclE")
  //</editor-fold>
  public void VisitRecordDecl(RecordDecl /*P*/ D) {
    VisitTagDecl(D);
    Record.push_back((D.hasFlexibleArrayMember() ? 1 : 0));
    Record.push_back((D.isAnonymousStructOrUnion() ? 1 : 0));
    Record.push_back((D.hasObjectMember() ? 1 : 0));
    Record.push_back((D.hasVolatileMember() ? 1 : 0));
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.isImplicit()
       && !D.isUsed(false)
       && !D.hasExtInfo()
       && !(D.getTypedefNameForAnonDecl() != null)
       && D.getFirstDecl() == D.getMostRecentDecl()
       && !D.isInvalidDecl()
       && !D.isReferenced()
       && !D.isTopLevelDeclInObjCContainer()
       && D.getAccess() == AccessSpecifier.AS_none
       && !D.isModulePrivate()
       && !CXXRecordDecl.classofKind(D.getKind())
       && !needsAnonymousDeclarationNumber(D)
       && D.getDeclName().getNameKind() == DeclarationName.NameKind.Identifier) {
      AbbrevToUse = Writer.getDeclRecordAbbrev();
    }
    
    Code = DeclCode.DECL_RECORD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitCXXRecordDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1165,
   FQN="clang::ASTDeclWriter::VisitCXXRecordDecl", NM="_ZN5clang13ASTDeclWriter18VisitCXXRecordDeclEPNS_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter18VisitCXXRecordDeclEPNS_13CXXRecordDeclE")
  //</editor-fold>
  public void VisitCXXRecordDecl(CXXRecordDecl /*P*/ D) {
    VisitRecordDecl(D);
    
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int CXXRecNotTemplate = 0;
      final /*uint*/int CXXRecTemplate = CXXRecNotTemplate + 1;
      final /*uint*/int CXXRecMemberSpecialization = CXXRecTemplate + 1;
    /*}*/;
    {
      ClassTemplateDecl /*P*/ TemplD = D.getDescribedClassTemplate();
      if ((TemplD != null)) {
        Record.push_back($uint2ulong(CXXRecTemplate));
        Record.AddDeclRef(TemplD);
      } else {
        MemberSpecializationInfo /*P*/ MSInfo = D.getMemberSpecializationInfo();
        if ((MSInfo != null)) {
          Record.push_back($uint2ulong(CXXRecMemberSpecialization));
          Record.AddDeclRef(MSInfo.getInstantiatedFrom());
          Record.push_back(MSInfo.getTemplateSpecializationKind().getValue());
          Record.AddSourceLocation(MSInfo.getPointOfInstantiation());
        } else {
          Record.push_back($uint2ulong(CXXRecNotTemplate));
        }
      }
    }
    
    Record.push_back((D.isThisDeclarationADefinition() ? 1 : 0));
    if (D.isThisDeclarationADefinition()) {
      Record.AddCXXDefinitionData(D);
    }
    
    // Store (what we currently believe to be) the key function to avoid
    // deserializing every method so we can compute it.
    if (D.IsCompleteDefinition) {
      Record.AddDeclRef(Context.getCurrentKeyFunction(D));
    }
    
    Code = DeclCode.DECL_CXX_RECORD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitClassTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1343,
   FQN="clang::ASTDeclWriter::VisitClassTemplateSpecializationDecl", NM="_ZN5clang13ASTDeclWriter36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter36VisitClassTemplateSpecializationDeclEPNS_31ClassTemplateSpecializationDeclE")
  //</editor-fold>
  public void VisitClassTemplateSpecializationDecl(ClassTemplateSpecializationDecl /*P*/ D) {
    RegisterTemplateSpecialization(D.getSpecializedTemplate(), D);
    
    VisitCXXRecordDecl(D);
    
    PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > InstFrom = D.getSpecializedTemplateOrPartial();
    {
      Decl /*P*/ InstFromD = InstFrom.dyn_cast(ClassTemplateDecl /*P*/.class);
      if ((InstFromD != null)) {
        Record.AddDeclRef(InstFromD);
      } else {
        Record.AddDeclRef(InstFrom.get(ClassTemplatePartialSpecializationDecl /*P*/.class));
        Record.AddTemplateArgumentList($AddrOf(D.getTemplateInstantiationArgs()));
      }
    }
    
    Record.AddTemplateArgumentList($AddrOf(D.getTemplateArgs()));
    Record.AddSourceLocation(D.getPointOfInstantiation());
    Record.push_back(D.getSpecializationKind().getValue());
    Record.push_back((D.isCanonicalDecl() ? 1 : 0));
    if (D.isCanonicalDecl()) {
      // When reading, we'll add it to the folding set of the following template. 
      Record.AddDeclRef(D.getSpecializedTemplate().getCanonicalDecl());
    }
    
    // Explicit info.
    Record.AddTypeSourceInfo(D.getTypeAsWritten());
    if ((D.getTypeAsWritten() != null)) {
      Record.AddSourceLocation(D.getExternLoc());
      Record.AddSourceLocation(D.getTemplateKeywordLoc());
    }
    
    Code = DeclCode.DECL_CLASS_TEMPLATE_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitClassTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1379,
   FQN="clang::ASTDeclWriter::VisitClassTemplatePartialSpecializationDecl", NM="_ZN5clang13ASTDeclWriter43VisitClassTemplatePartialSpecializationDeclEPNS_38ClassTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter43VisitClassTemplatePartialSpecializationDeclEPNS_38ClassTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public void VisitClassTemplatePartialSpecializationDecl(ClassTemplatePartialSpecializationDecl /*P*/ D) {
    VisitClassTemplateSpecializationDecl(D);
    
    Record.AddTemplateParameterList(D.getTemplateParameters());
    Record.AddASTTemplateArgumentListInfo(D.getTemplateArgsAsWritten());
    
    // These are read/set from/to the first declaration.
    if (D.getPreviousDecl() == null) {
      Record.AddDeclRef(D.getInstantiatedFromMember());
      Record.push_back((D.isMemberSpecialization() ? 1 : 0));
    }
    
    Code = DeclCode.DECL_CLASS_TEMPLATE_PARTIAL_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitVarTemplateSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1403,
   FQN="clang::ASTDeclWriter::VisitVarTemplateSpecializationDecl", NM="_ZN5clang13ASTDeclWriter34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter34VisitVarTemplateSpecializationDeclEPNS_29VarTemplateSpecializationDeclE")
  //</editor-fold>
  public void VisitVarTemplateSpecializationDecl(VarTemplateSpecializationDecl /*P*/ D) {
    RegisterTemplateSpecialization(D.getSpecializedTemplate(), D);
    
    VisitVarDecl(D);
    
    PointerUnion<VarTemplateDecl /*P*/ , VarTemplatePartialSpecializationDecl /*P*/ > InstFrom = D.getSpecializedTemplateOrPartial();
    {
      Decl /*P*/ InstFromD = InstFrom.dyn_cast(VarTemplateDecl /*P*/.class);
      if ((InstFromD != null)) {
        Record.AddDeclRef(InstFromD);
      } else {
        Record.AddDeclRef(InstFrom.get(VarTemplatePartialSpecializationDecl /*P*/.class));
        Record.AddTemplateArgumentList($AddrOf(D.getTemplateInstantiationArgs()));
      }
    }
    
    // Explicit info.
    Record.AddTypeSourceInfo(D.getTypeAsWritten());
    if ((D.getTypeAsWritten() != null)) {
      Record.AddSourceLocation(D.getExternLoc());
      Record.AddSourceLocation(D.getTemplateKeywordLoc());
    }
    
    Record.AddTemplateArgumentList($AddrOf(D.getTemplateArgs()));
    Record.AddSourceLocation(D.getPointOfInstantiation());
    Record.push_back(D.getSpecializationKind().getValue());
    Record.push_back((D.isCanonicalDecl() ? 1 : 0));
    if (D.isCanonicalDecl()) {
      // When reading, we'll add it to the folding set of the following template.
      Record.AddDeclRef(D.getSpecializedTemplate().getCanonicalDecl());
    }
    
    Code = DeclCode.DECL_VAR_TEMPLATE_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitVarTemplatePartialSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1438,
   FQN="clang::ASTDeclWriter::VisitVarTemplatePartialSpecializationDecl", NM="_ZN5clang13ASTDeclWriter41VisitVarTemplatePartialSpecializationDeclEPNS_36VarTemplatePartialSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter41VisitVarTemplatePartialSpecializationDeclEPNS_36VarTemplatePartialSpecializationDeclE")
  //</editor-fold>
  public void VisitVarTemplatePartialSpecializationDecl(VarTemplatePartialSpecializationDecl /*P*/ D) {
    VisitVarTemplateSpecializationDecl(D);
    
    Record.AddTemplateParameterList(D.getTemplateParameters());
    Record.AddASTTemplateArgumentListInfo(D.getTemplateArgsAsWritten());
    
    // These are read/set from/to the first declaration.
    if (D.getPreviousDecl$Redeclarable() == null) {
      Record.AddDeclRef(D.getInstantiatedFromMember());
      Record.push_back((D.isMemberSpecialization() ? 1 : 0));
    }
    
    Code = DeclCode.DECL_VAR_TEMPLATE_PARTIAL_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitClassScopeFunctionSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1454,
   FQN="clang::ASTDeclWriter::VisitClassScopeFunctionSpecializationDecl", NM="_ZN5clang13ASTDeclWriter41VisitClassScopeFunctionSpecializationDeclEPNS_36ClassScopeFunctionSpecializationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter41VisitClassScopeFunctionSpecializationDeclEPNS_36ClassScopeFunctionSpecializationDeclE")
  //</editor-fold>
  public void VisitClassScopeFunctionSpecializationDecl(ClassScopeFunctionSpecializationDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddDeclRef(D.getSpecialization());
    Code = DeclCode.DECL_CLASS_SCOPE_FUNCTION_SPECIALIZATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTemplateTypeParmDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1470,
   FQN="clang::ASTDeclWriter::VisitTemplateTypeParmDecl", NM="_ZN5clang13ASTDeclWriter25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25VisitTemplateTypeParmDeclEPNS_20TemplateTypeParmDeclE")
  //</editor-fold>
  public void VisitTemplateTypeParmDecl(TemplateTypeParmDecl /*P*/ D) {
    VisitTypeDecl(D);
    
    Record.push_back((D.wasDeclaredWithTypename() ? 1 : 0));
    
    boolean OwnsDefaultArg = D.hasDefaultArgument()
       && !D.defaultArgumentWasInherited();
    Record.push_back((OwnsDefaultArg ? 1 : 0));
    if (OwnsDefaultArg) {
      Record.AddTypeSourceInfo(D.getDefaultArgumentInfo());
    }
    
    Code = DeclCode.DECL_TEMPLATE_TYPE_PARM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitValueDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 484,
   FQN="clang::ASTDeclWriter::VisitValueDecl", NM="_ZN5clang13ASTDeclWriter14VisitValueDeclEPNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitValueDeclEPNS_9ValueDeclE")
  //</editor-fold>
  public void VisitValueDecl(ValueDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddTypeRef(D.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitEnumConstantDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 489,
   FQN="clang::ASTDeclWriter::VisitEnumConstantDecl", NM="_ZN5clang13ASTDeclWriter21VisitEnumConstantDeclEPNS_16EnumConstantDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter21VisitEnumConstantDeclEPNS_16EnumConstantDeclE")
  //</editor-fold>
  public void VisitEnumConstantDecl(EnumConstantDecl /*P*/ D) {
    VisitValueDecl(D);
    Record.push_back($int2ulong((D.getInitExpr() != null) ? 1 : 0));
    if ((D.getInitExpr() != null)) {
      Record.AddStmt(D.getInitExpr());
    }
    Record.AddAPSInt(D.getInitVal());
    
    Code = DeclCode.DECL_ENUM_CONSTANT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitUnresolvedUsingValueDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1149,
   FQN="clang::ASTDeclWriter::VisitUnresolvedUsingValueDecl", NM="_ZN5clang13ASTDeclWriter29VisitUnresolvedUsingValueDeclEPNS_24UnresolvedUsingValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter29VisitUnresolvedUsingValueDeclEPNS_24UnresolvedUsingValueDeclE")
  //</editor-fold>
  public void VisitUnresolvedUsingValueDecl(UnresolvedUsingValueDecl /*P*/ D) {
    VisitValueDecl(D);
    Record.AddSourceLocation(D.getUsingLoc());
    Record.AddNestedNameSpecifierLoc(D.getQualifierLoc());
    Record.AddDeclarationNameLoc(D.DNLoc, D.getDeclName());
    Code = DeclCode.DECL_UNRESOLVED_USING_VALUE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitDeclaratorDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 499,
   FQN="clang::ASTDeclWriter::VisitDeclaratorDecl", NM="_ZN5clang13ASTDeclWriter19VisitDeclaratorDeclEPNS_14DeclaratorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter19VisitDeclaratorDeclEPNS_14DeclaratorDeclE")
  //</editor-fold>
  public void VisitDeclaratorDecl(DeclaratorDecl /*P*/ D) {
    VisitValueDecl(D);
    Record.AddSourceLocation(D.getInnerLocStart());
    Record.push_back((D.hasExtInfo() ? 1 : 0));
    if (D.hasExtInfo()) {
      Record.AddQualifierInfo($Deref(D.getExtInfo()));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 507,
   FQN="clang::ASTDeclWriter::VisitFunctionDecl", NM="_ZN5clang13ASTDeclWriter17VisitFunctionDeclEPNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter17VisitFunctionDeclEPNS_12FunctionDeclE")
  //</editor-fold>
  public void VisitFunctionDecl(FunctionDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitDeclaratorDecl(D);
    Record.AddDeclarationNameLoc(D.DNLoc, D.getDeclName());
    Record.push_back($uint2ulong(D.getIdentifierNamespace()));
    
    // FunctionDecl's body is handled last at ASTWriterDecl::Visit,
    // after everything else is written.
    Record.push_back($int2ulong((int)$2bits_uint2uint(D.SClass))); // FIXME: stable encoding
    Record.push_back($uint2ulong(D.IsInline));
    Record.push_back($uint2ulong(D.IsInlineSpecified));
    Record.push_back($uint2ulong(D.IsVirtualAsWritten));
    Record.push_back($uint2ulong(D.IsPure));
    Record.push_back($uint2ulong(D.HasInheritedPrototype));
    Record.push_back($uint2ulong(D.HasWrittenPrototype));
    Record.push_back($uint2ulong(D.IsDeleted));
    Record.push_back($uint2ulong(D.IsTrivial));
    Record.push_back($uint2ulong(D.IsDefaulted));
    Record.push_back($uint2ulong(D.IsExplicitlyDefaulted));
    Record.push_back($uint2ulong(D.HasImplicitReturnZero));
    Record.push_back($uint2ulong(D.IsConstexpr));
    Record.push_back($uint2ulong(D.HasSkippedBody));
    Record.push_back($uint2ulong(D.IsLateTemplateParsed));
    Record.push_back(D.getLinkageInternal().getValue());
    Record.AddSourceLocation(D.getLocEnd());
    
    Record.push_back(D.getTemplatedKind().getValue());
    switch (D.getTemplatedKind()) {
     case TK_NonTemplate:
      break;
     case TK_FunctionTemplate:
      Record.AddDeclRef(D.getDescribedFunctionTemplate());
      break;
     case TK_MemberSpecialization:
      {
        MemberSpecializationInfo /*P*/ MemberInfo = D.getMemberSpecializationInfo();
        Record.AddDeclRef(MemberInfo.getInstantiatedFrom());
        Record.push_back(MemberInfo.getTemplateSpecializationKind().getValue());
        Record.AddSourceLocation(MemberInfo.getPointOfInstantiation());
        break;
      }
     case TK_FunctionTemplateSpecialization:
      {
        FunctionTemplateSpecializationInfo /*P*/ FTSInfo = D.getTemplateSpecializationInfo();
        
        RegisterTemplateSpecialization(FTSInfo.getTemplate(), D);
        
        Record.AddDeclRef(FTSInfo.getTemplate());
        Record.push_back(FTSInfo.getTemplateSpecializationKind().getValue());
        
        // Template arguments.
        Record.AddTemplateArgumentList(FTSInfo.TemplateArguments);
        
        // Template args as written.
        Record.push_back(((FTSInfo.TemplateArgumentsAsWritten != (/*const*/ ASTTemplateArgumentListInfo /*P*/ )null) ? 1 : 0));
        if ((FTSInfo.TemplateArgumentsAsWritten != null)) {
          Record.push_back($uint2ulong(FTSInfo.TemplateArgumentsAsWritten.NumTemplateArgs));
          for (int i = 0, e = FTSInfo.TemplateArgumentsAsWritten.NumTemplateArgs;
               i != e; ++i)  {
            Record.AddTemplateArgumentLoc(($Deref(FTSInfo.TemplateArgumentsAsWritten)).$at(i));
          }
          Record.AddSourceLocation(new SourceLocation(FTSInfo.TemplateArgumentsAsWritten.LAngleLoc));
          Record.AddSourceLocation(new SourceLocation(FTSInfo.TemplateArgumentsAsWritten.RAngleLoc));
        }
        
        Record.AddSourceLocation(FTSInfo.getPointOfInstantiation());
        if (D.isCanonicalDecl()) {
          // Write the template that contains the specializations set. We will
          // add a FunctionTemplateSpecializationInfo to it when reading.
          Record.AddDeclRef(FTSInfo.getTemplate().getCanonicalDecl());
        }
        break;
      }
     case TK_DependentFunctionTemplateSpecialization:
      {
        DependentFunctionTemplateSpecializationInfo /*P*/ DFTSInfo = D.getDependentSpecializationInfo();
        
        // Templates.
        Record.push_back($uint2ulong(DFTSInfo.getNumTemplates()));
        for (int i = 0, e = DFTSInfo.getNumTemplates(); i != e; ++i)  {
          Record.AddDeclRef(DFTSInfo.getTemplate(i));
        }
        
        // Templates args.
        Record.push_back($uint2ulong(DFTSInfo.getNumTemplateArgs()));
        for (int i = 0, e = DFTSInfo.getNumTemplateArgs(); i != e; ++i)  {
          Record.AddTemplateArgumentLoc(DFTSInfo.getTemplateArg(i));
        }
        Record.AddSourceLocation(DFTSInfo.getLAngleLoc());
        Record.AddSourceLocation(DFTSInfo.getRAngleLoc());
        break;
      }
    }
    
    Record.push_back($uint2ulong(D.param_size()));
    for (ParmVarDecl /*P*/ P : D.parameters())  {
      Record.AddDeclRef(P);
    }
    Code = DeclCode.DECL_FUNCTION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitCXXMethodDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1196,
   FQN="clang::ASTDeclWriter::VisitCXXMethodDecl", NM="_ZN5clang13ASTDeclWriter18VisitCXXMethodDeclEPNS_13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter18VisitCXXMethodDeclEPNS_13CXXMethodDeclE")
  //</editor-fold>
  public void VisitCXXMethodDecl(CXXMethodDecl /*P*/ D) {
    VisitFunctionDecl(D);
    if (D.isCanonicalDecl()) {
      Record.push_back($uint2ulong(D.size_overridden_methods()));
      for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(D.begin_overridden_methods()), /*P*/ /*const*/ /*P*/ E = $tryClone(D.end_overridden_methods());
           $noteq_ptr(I, E); I.$preInc())  {
        Record.AddDeclRef(I.$star());
      }
    } else {
      // We only need to record overridden methods once for the canonical decl.
      Record.push_back($int2ulong(0));
    }
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && D.getFirstDecl() == D.getMostRecentDecl()
       && !D.isInvalidDecl()
       && !D.hasAttrs()
       && !D.isTopLevelDeclInObjCContainer()
       && D.getDeclName().getNameKind() == DeclarationName.NameKind.Identifier
       && !D.hasExtInfo()
       && !D.hasInheritedPrototype()
       && D.hasWrittenPrototype()) {
      AbbrevToUse = Writer.getDeclCXXMethodAbbrev();
    }
    
    Code = DeclCode.DECL_CXX_METHOD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitCXXConstructorDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1223,
   FQN="clang::ASTDeclWriter::VisitCXXConstructorDecl", NM="_ZN5clang13ASTDeclWriter23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter23VisitCXXConstructorDeclEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  public void VisitCXXConstructorDecl(CXXConstructorDecl /*P*/ D) {
    {
      InheritedConstructor Inherited = D.getInheritedConstructor();
      if (Inherited.$bool()) {
        Record.AddDeclRef(Inherited.getShadowDecl());
        Record.AddDeclRef(Inherited.getConstructor());
        Code = DeclCode.DECL_CXX_INHERITED_CONSTRUCTOR;
      } else {
        Code = DeclCode.DECL_CXX_CONSTRUCTOR;
      }
    }
    
    VisitCXXMethodDecl(D);
    
    Record.push_back($uint2ulong(D.IsExplicitSpecified));
    
    Code = D.isInheritingConstructor() ? DeclCode.DECL_CXX_INHERITED_CONSTRUCTOR : DeclCode.DECL_CXX_CONSTRUCTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitCXXDestructorDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1241,
   FQN="clang::ASTDeclWriter::VisitCXXDestructorDecl", NM="_ZN5clang13ASTDeclWriter22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitCXXDestructorDeclEPNS_17CXXDestructorDeclE")
  //</editor-fold>
  public void VisitCXXDestructorDecl(CXXDestructorDecl /*P*/ D) {
    VisitCXXMethodDecl(D);
    
    Record.AddDeclRef(D.getOperatorDelete());
    
    Code = DeclCode.DECL_CXX_DESTRUCTOR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitCXXConversionDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1249,
   FQN="clang::ASTDeclWriter::VisitCXXConversionDecl", NM="_ZN5clang13ASTDeclWriter22VisitCXXConversionDeclEPNS_17CXXConversionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitCXXConversionDeclEPNS_17CXXConversionDeclE")
  //</editor-fold>
  public void VisitCXXConversionDecl(CXXConversionDecl /*P*/ D) {
    VisitCXXMethodDecl(D);
    Record.push_back((D.IsExplicitSpecified ? 1 : 0));
    Code = DeclCode.DECL_CXX_CONVERSION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitFieldDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 836,
   FQN="clang::ASTDeclWriter::VisitFieldDecl", NM="_ZN5clang13ASTDeclWriter14VisitFieldDeclEPNS_9FieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitFieldDeclEPNS_9FieldDeclE")
  //</editor-fold>
  public void VisitFieldDecl(FieldDecl /*P*/ D) {
    VisitDeclaratorDecl(D);
    Record.push_back((D.isMutable() ? 1 : 0));
    if (D.InitStorage.getInt() == FieldDecl.InitStorageKind.ISK_BitWidthOrNothing
       && D.InitStorage.getPointer() == null) {
      Record.push_back($int2ulong(0));
    } else if (D.InitStorage.getInt() == FieldDecl.InitStorageKind.ISK_CapturedVLAType) {
      Record.push_back($int2ulong(D.InitStorage.getInt().getValue() + 1));
      Record.AddTypeRef(new QualType(((/*static_cast*/Type /*P*/ )(D.InitStorage.getPointer())), 0));
    } else {
      Record.push_back($int2ulong(D.InitStorage.getInt().getValue() + 1));
      Record.AddStmt(((/*static_cast*/Expr /*P*/ )(D.InitStorage.getPointer())));
    }
    if (!D.getDeclName().$bool()) {
      Record.AddDeclRef(Context.getInstantiatedFromUnnamedFieldDecl(D));
    }
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.isImplicit()
       && !D.isUsed(false)
       && !D.isInvalidDecl()
       && !D.isReferenced()
       && !D.isTopLevelDeclInObjCContainer()
       && !D.isModulePrivate()
       && !(D.getBitWidth() != null)
       && !D.hasInClassInitializer()
       && !D.hasExtInfo()
       && !ObjCIvarDecl.classofKind(D.getKind())
       && !ObjCAtDefsFieldDecl.classofKind(D.getKind())
       && D.getDeclName().$bool()) {
      AbbrevToUse = Writer.getDeclFieldAbbrev();
    }
    
    Code = DeclCode.DECL_FIELD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitMSPropertyDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 872,
   FQN="clang::ASTDeclWriter::VisitMSPropertyDecl", NM="_ZN5clang13ASTDeclWriter19VisitMSPropertyDeclEPNS_14MSPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter19VisitMSPropertyDeclEPNS_14MSPropertyDeclE")
  //</editor-fold>
  public void VisitMSPropertyDecl(MSPropertyDecl /*P*/ D) {
    VisitDeclaratorDecl(D);
    Record.AddIdentifierRef(D.getGetterId());
    Record.AddIdentifierRef(D.getSetterId());
    Code = DeclCode.DECL_MS_PROPERTY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitIndirectFieldDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 879,
   FQN="clang::ASTDeclWriter::VisitIndirectFieldDecl", NM="_ZN5clang13ASTDeclWriter22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitIndirectFieldDeclEPNS_17IndirectFieldDeclE")
  //</editor-fold>
  public void VisitIndirectFieldDecl(IndirectFieldDecl /*P*/ D) {
    VisitValueDecl(D);
    Record.push_back($uint2ulong(D.getChainingSize()));
    
    for (/*const*/ NamedDecl /*P*/ P : D.chain())  {
      Record.AddDeclRef(P);
    }
    Code = DeclCode.DECL_INDIRECTFIELD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitVarDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 888,
   FQN="clang::ASTDeclWriter::VisitVarDecl", NM="_ZN5clang13ASTDeclWriter12VisitVarDeclEPNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter12VisitVarDeclEPNS_7VarDeclE")
  //</editor-fold>
  public void VisitVarDecl(VarDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitDeclaratorDecl(D);
    Record.push_back(D.getStorageClass().getValue());
    Record.push_back(D.getTSCSpec().getValue());
    Record.push_back(D.getInitStyle().getValue());
    if (!isa_ParmVarDecl(D)) {
      Record.push_back((D.isExceptionVariable() ? 1 : 0));
      Record.push_back((D.isNRVOVariable() ? 1 : 0));
      Record.push_back((D.isCXXForRangeDecl() ? 1 : 0));
      Record.push_back((D.isARCPseudoStrong() ? 1 : 0));
      Record.push_back((D.isInline() ? 1 : 0));
      Record.push_back((D.isInlineSpecified() ? 1 : 0));
      Record.push_back((D.isConstexpr() ? 1 : 0));
      Record.push_back((D.isInitCapture() ? 1 : 0));
      Record.push_back((D.isPreviousDeclInSameBlockScope() ? 1 : 0));
    }
    Record.push_back(D.getLinkageInternal().getValue());
    if ((D.getInit() != null)) {
      Record.push_back($int2ulong(!D.isInitKnownICE() ? 1 : (D.isInitICE() ? 3 : 2)));
      Record.AddStmt(D.getInit());
    } else {
      Record.push_back($int2ulong(0));
    }
    
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int VarNotTemplate = 0;
      final /*uint*/int VarTemplate = VarNotTemplate + 1;
      final /*uint*/int StaticDataMemberSpecialization = VarTemplate + 1;
    /*}*/;
    {
      VarTemplateDecl /*P*/ TemplD = D.getDescribedVarTemplate();
      if ((TemplD != null)) {
        Record.push_back($uint2ulong(VarTemplate));
        Record.AddDeclRef(TemplD);
      } else {
        MemberSpecializationInfo /*P*/ SpecInfo = D.getMemberSpecializationInfo();
        if ((SpecInfo != null)) {
          Record.push_back($uint2ulong(StaticDataMemberSpecialization));
          Record.AddDeclRef(SpecInfo.getInstantiatedFrom());
          Record.push_back(SpecInfo.getTemplateSpecializationKind().getValue());
          Record.AddSourceLocation(SpecInfo.getPointOfInstantiation());
        } else {
          Record.push_back($uint2ulong(VarNotTemplate));
        }
      }
    }
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.isImplicit()
       && !D.isUsed(false)
       && !D.isInvalidDecl()
       && !D.isReferenced()
       && !D.isTopLevelDeclInObjCContainer()
       && D.getAccess() == AccessSpecifier.AS_none
       && !D.isModulePrivate()
       && !needsAnonymousDeclarationNumber(D)
       && D.getDeclName().getNameKind() == DeclarationName.NameKind.Identifier
       && !D.hasExtInfo()
       && D.getFirstDecl() == D.getMostRecentDecl$Redeclarable()
       && D.getInitStyle() == VarDecl.InitializationStyle.CInit
       && D.getInit() == null
       && !isa_ParmVarDecl(D)
       && !isa_VarTemplateSpecializationDecl(D)
       && !D.isInline()
       && !D.isConstexpr()
       && !D.isInitCapture()
       && !D.isPreviousDeclInSameBlockScope()
       && !(D.getMemberSpecializationInfo() != null)) {
      AbbrevToUse = Writer.getDeclVarAbbrev();
    }
    
    Code = DeclCode.DECL_VAR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitImplicitParamDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 957,
   FQN="clang::ASTDeclWriter::VisitImplicitParamDecl", NM="_ZN5clang13ASTDeclWriter22VisitImplicitParamDeclEPNS_17ImplicitParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitImplicitParamDeclEPNS_17ImplicitParamDeclE")
  //</editor-fold>
  public void VisitImplicitParamDecl(ImplicitParamDecl /*P*/ D) {
    VisitVarDecl(D);
    Code = DeclCode.DECL_IMPLICIT_PARAM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitParmVarDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 962,
   FQN="clang::ASTDeclWriter::VisitParmVarDecl", NM="_ZN5clang13ASTDeclWriter16VisitParmVarDeclEPNS_11ParmVarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter16VisitParmVarDeclEPNS_11ParmVarDeclE")
  //</editor-fold>
  public void VisitParmVarDecl(ParmVarDecl /*P*/ D) {
    VisitVarDecl(D);
    Record.push_back((D.isObjCMethodParameter() ? 1 : 0));
    Record.push_back($uint2ulong(D.getFunctionScopeDepth()));
    Record.push_back($uint2ulong(D.getFunctionScopeIndex()));
    Record.push_back($uint2ulong(D.getObjCDeclQualifier())); // FIXME: stable encoding
    Record.push_back((D.isKNRPromoted() ? 1 : 0));
    Record.push_back((D.hasInheritedDefaultArg() ? 1 : 0));
    Record.push_back((D.hasUninstantiatedDefaultArg() ? 1 : 0));
    if (D.hasUninstantiatedDefaultArg()) {
      Record.AddStmt(D.getUninstantiatedDefaultArg());
    }
    Code = DeclCode.DECL_PARM_VAR;
    assert (!D.isARCPseudoStrong()); // can be true of ImplicitParamDecl
    
    // If the assumptions about the DECL_PARM_VAR abbrev are true, use it.  Here
    // we dynamically check for the properties that we optimize for, but don't
    // know are true of all PARM_VAR_DECLs.
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.hasExtInfo()
       && !D.isImplicit()
       && !D.isUsed(false)
       && !D.isInvalidDecl()
       && !D.isReferenced()
       && D.getAccess() == AccessSpecifier.AS_none
       && !D.isModulePrivate()
       && D.getStorageClass().getValue() == 0
       && D.getInitStyle() == VarDecl.InitializationStyle.CInit // Can params have anything else?
       && D.getFunctionScopeDepth() == 0
       && D.getObjCDeclQualifier() == 0
       && !D.isKNRPromoted()
       && !D.hasInheritedDefaultArg()
       && D.getInit() == null
       && !D.hasUninstantiatedDefaultArg()) { // No default expr.
      AbbrevToUse = Writer.getDeclParmVarAbbrev();
    }
    
    // Check things we know are true of *every* PARM_VAR_DECL, which is more than
    // just us assuming it.
    assert (!(D.getTSCSpec().getValue() != 0)) : "PARM_VAR_DECL can't use TLS";
    assert (D.getAccess() == AccessSpecifier.AS_none) : "PARM_VAR_DECL can't be public/private";
    assert (!D.isExceptionVariable()) : "PARM_VAR_DECL can't be exception var";
    assert (D.getPreviousDecl$Redeclarable() == null) : "PARM_VAR_DECL can't be redecl";
    assert (!D.isStaticDataMember()) : "PARM_VAR_DECL can't be static data member";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitNonTypeTemplateParmDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1484,
   FQN="clang::ASTDeclWriter::VisitNonTypeTemplateParmDecl", NM="_ZN5clang13ASTDeclWriter28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter28VisitNonTypeTemplateParmDeclEPNS_23NonTypeTemplateParmDeclE")
  //</editor-fold>
  public void VisitNonTypeTemplateParmDecl(NonTypeTemplateParmDecl /*P*/ D) {
    // For an expanded parameter pack, record the number of expansion types here
    // so that it's easier for deserialization to allocate the right amount of
    // memory.
    if (D.isExpandedParameterPack()) {
      Record.push_back($uint2ulong(D.getNumExpansionTypes()));
    }
    
    VisitDeclaratorDecl(D);
    // TemplateParmPosition.
    Record.push_back($uint2ulong(D.getDepth()));
    Record.push_back($uint2ulong(D.getPosition()));
    if (D.isExpandedParameterPack()) {
      for (/*uint*/int I = 0, N = D.getNumExpansionTypes(); I != N; ++I) {
        Record.AddTypeRef(D.getExpansionType(I));
        Record.AddTypeSourceInfo(D.getExpansionTypeSourceInfo(I));
      }
      
      Code = DeclCode.DECL_EXPANDED_NON_TYPE_TEMPLATE_PARM_PACK;
    } else {
      // Rest of NonTypeTemplateParmDecl.
      Record.push_back((D.isParameterPack() ? 1 : 0));
      boolean OwnsDefaultArg = D.hasDefaultArgument()
         && !D.defaultArgumentWasInherited();
      Record.push_back((OwnsDefaultArg ? 1 : 0));
      if (OwnsDefaultArg) {
        Record.AddStmt(D.getDefaultArgument());
      }
      Code = DeclCode.DECL_NON_TYPE_TEMPLATE_PARM;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1312,
   FQN="clang::ASTDeclWriter::VisitTemplateDecl", NM="_ZN5clang13ASTDeclWriter17VisitTemplateDeclEPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter17VisitTemplateDeclEPNS_12TemplateDeclE")
  //</editor-fold>
  public void VisitTemplateDecl(TemplateDecl /*P*/ D) {
    VisitNamedDecl(D);
    
    Record.AddDeclRef(D.getTemplatedDecl());
    Record.AddTemplateParameterList(D.getTemplateParameters());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitRedeclarableTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1319,
   FQN="clang::ASTDeclWriter::VisitRedeclarableTemplateDecl", NM="_ZN5clang13ASTDeclWriter29VisitRedeclarableTemplateDeclEPNS_24RedeclarableTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter29VisitRedeclarableTemplateDeclEPNS_24RedeclarableTemplateDeclE")
  //</editor-fold>
  public void VisitRedeclarableTemplateDecl(RedeclarableTemplateDecl /*P*/ D) {
    VisitRedeclarable(D);
    
    // Emit data to initialize CommonOrPrev before VisitTemplateDecl so that
    // getCommonPtr() can be used while this is still initializing.
    if (D.isFirstDecl$Redeclarable()) {
      // This declaration owns the 'common' pointer, so serialize that data now.
      Record.AddDeclRef(D.getInstantiatedFromMemberTemplate());
      if ((D.getInstantiatedFromMemberTemplate() != null)) {
        Record.push_back((D.isMemberSpecialization() ? 1 : 0));
      }
    }
    
    VisitTemplateDecl(D);
    Record.push_back($uint2ulong(D.getIdentifierNamespace()));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitClassTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1335,
   FQN="clang::ASTDeclWriter::VisitClassTemplateDecl", NM="_ZN5clang13ASTDeclWriter22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitClassTemplateDeclEPNS_17ClassTemplateDeclE")
  //</editor-fold>
  public void VisitClassTemplateDecl(ClassTemplateDecl /*P*/ D) {
    VisitRedeclarableTemplateDecl(D);
    if (D.isFirstDecl$Redeclarable()) {
      AddTemplateSpecializations(D);
    }
    Code = DeclCode.DECL_CLASS_TEMPLATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitVarTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1395,
   FQN="clang::ASTDeclWriter::VisitVarTemplateDecl", NM="_ZN5clang13ASTDeclWriter20VisitVarTemplateDeclEPNS_15VarTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter20VisitVarTemplateDeclEPNS_15VarTemplateDeclE")
  //</editor-fold>
  public void VisitVarTemplateDecl(VarTemplateDecl /*P*/ D) {
    VisitRedeclarableTemplateDecl(D);
    if (D.isFirstDecl$Redeclarable()) {
      AddTemplateSpecializations(D);
    }
    Code = DeclCode.DECL_VAR_TEMPLATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1462,
   FQN="clang::ASTDeclWriter::VisitFunctionTemplateDecl", NM="_ZN5clang13ASTDeclWriter25VisitFunctionTemplateDeclEPNS_20FunctionTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25VisitFunctionTemplateDeclEPNS_20FunctionTemplateDeclE")
  //</editor-fold>
  public void VisitFunctionTemplateDecl(FunctionTemplateDecl /*P*/ D) {
    VisitRedeclarableTemplateDecl(D);
    if (D.isFirstDecl$Redeclarable()) {
      AddTemplateSpecializations(D);
    }
    Code = DeclCode.DECL_FUNCTION_TEMPLATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTemplateTemplateParmDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1515,
   FQN="clang::ASTDeclWriter::VisitTemplateTemplateParmDecl", NM="_ZN5clang13ASTDeclWriter29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter29VisitTemplateTemplateParmDeclEPNS_24TemplateTemplateParmDeclE")
  //</editor-fold>
  public void VisitTemplateTemplateParmDecl(TemplateTemplateParmDecl /*P*/ D) {
    // For an expanded parameter pack, record the number of expansion types here
    // so that it's easier for deserialization to allocate the right amount of
    // memory.
    if (D.isExpandedParameterPack()) {
      Record.push_back($uint2ulong(D.getNumExpansionTemplateParameters()));
    }
    
    VisitTemplateDecl(D);
    // TemplateParmPosition.
    Record.push_back($uint2ulong(D.getDepth()));
    Record.push_back($uint2ulong(D.getPosition()));
    if (D.isExpandedParameterPack()) {
      for (/*uint*/int I = 0, N = D.getNumExpansionTemplateParameters();
           I != N; ++I)  {
        Record.AddTemplateParameterList(D.getExpansionTemplateParameters(I));
      }
      Code = DeclCode.DECL_EXPANDED_TEMPLATE_TEMPLATE_PARM_PACK;
    } else {
      // Rest of TemplateTemplateParmDecl.
      Record.push_back((D.isParameterPack() ? 1 : 0));
      boolean OwnsDefaultArg = D.hasDefaultArgument()
         && !D.defaultArgumentWasInherited();
      Record.push_back((OwnsDefaultArg ? 1 : 0));
      if (OwnsDefaultArg) {
        Record.AddTemplateArgumentLoc(D.getDefaultArgument());
      }
      Code = DeclCode.DECL_TEMPLATE_TEMPLATE_PARM;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitTypeAliasTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1544,
   FQN="clang::ASTDeclWriter::VisitTypeAliasTemplateDecl", NM="_ZN5clang13ASTDeclWriter26VisitTypeAliasTemplateDeclEPNS_21TypeAliasTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter26VisitTypeAliasTemplateDeclEPNS_21TypeAliasTemplateDeclE")
  //</editor-fold>
  public void VisitTypeAliasTemplateDecl(TypeAliasTemplateDecl /*P*/ D) {
    VisitRedeclarableTemplateDecl(D);
    Code = DeclCode.DECL_TYPE_ALIAS_TEMPLATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitUsingDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1110,
   FQN="clang::ASTDeclWriter::VisitUsingDecl", NM="_ZN5clang13ASTDeclWriter14VisitUsingDeclEPNS_9UsingDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitUsingDeclEPNS_9UsingDeclE")
  //</editor-fold>
  public void VisitUsingDecl(UsingDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getUsingLoc());
    Record.AddNestedNameSpecifierLoc(D.getQualifierLoc());
    Record.AddDeclarationNameLoc(D.DNLoc, D.getDeclName());
    Record.AddDeclRef(D.FirstUsingShadow.getPointer());
    Record.push_back((D.hasTypename() ? 1 : 0));
    Record.AddDeclRef(Context.getInstantiatedFromUsingDecl(D));
    Code = DeclCode.DECL_USING;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitUsingShadowDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1121,
   FQN="clang::ASTDeclWriter::VisitUsingShadowDecl", NM="_ZN5clang13ASTDeclWriter20VisitUsingShadowDeclEPNS_15UsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter20VisitUsingShadowDeclEPNS_15UsingShadowDeclE")
  //</editor-fold>
  public void VisitUsingShadowDecl(UsingShadowDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitNamedDecl(D);
    Record.AddDeclRef(D.getTargetDecl());
    Record.AddDeclRef(D.UsingOrNextShadow);
    Record.AddDeclRef(Context.getInstantiatedFromUsingShadowDecl(D));
    Code = DeclCode.DECL_USING_SHADOW;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitConstructorUsingShadowDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1130,
   FQN="clang::ASTDeclWriter::VisitConstructorUsingShadowDecl", NM="_ZN5clang13ASTDeclWriter31VisitConstructorUsingShadowDeclEPNS_26ConstructorUsingShadowDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter31VisitConstructorUsingShadowDeclEPNS_26ConstructorUsingShadowDeclE")
  //</editor-fold>
  public void VisitConstructorUsingShadowDecl(ConstructorUsingShadowDecl /*P*/ D) {
    VisitUsingShadowDecl(D);
    Record.AddDeclRef(D.NominatedBaseClassShadowDecl);
    Record.AddDeclRef(D.ConstructedBaseClassShadowDecl);
    Record.push_back($uint2ulong(D.IsVirtual));
    Code = DeclCode.DECL_CONSTRUCTOR_USING_SHADOW;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitLinkageSpecDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1059,
   FQN="clang::ASTDeclWriter::VisitLinkageSpecDecl", NM="_ZN5clang13ASTDeclWriter20VisitLinkageSpecDeclEPNS_15LinkageSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter20VisitLinkageSpecDeclEPNS_15LinkageSpecDeclE")
  //</editor-fold>
  public void VisitLinkageSpecDecl(LinkageSpecDecl /*P*/ D) {
    VisitDecl(D);
    Record.push_back($uint2ulong(D.getLanguage()));
    Record.AddSourceLocation(D.getExternLoc());
    Record.AddSourceLocation(D.getRBraceLoc());
    Code = DeclCode.DECL_LINKAGE_SPEC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitFileScopeAsmDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1009,
   FQN="clang::ASTDeclWriter::VisitFileScopeAsmDecl", NM="_ZN5clang13ASTDeclWriter21VisitFileScopeAsmDeclEPNS_16FileScopeAsmDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter21VisitFileScopeAsmDeclEPNS_16FileScopeAsmDeclE")
  //</editor-fold>
  public void VisitFileScopeAsmDecl(FileScopeAsmDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddStmt(D.getAsmString());
    Record.AddSourceLocation(D.getRParenLoc());
    Code = DeclCode.DECL_FILE_SCOPE_ASM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitImportDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1255,
   FQN="clang::ASTDeclWriter::VisitImportDecl", NM="_ZN5clang13ASTDeclWriter15VisitImportDeclEPNS_10ImportDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter15VisitImportDeclEPNS_10ImportDeclE")
  //</editor-fold>
  public void VisitImportDecl(ImportDecl /*P*/ D) {
    VisitDecl(D);
    Record.push_back($uint2ulong(Writer.getSubmoduleID(D.getImportedModule())));
    ArrayRef<SourceLocation> IdentifierLocs = D.getIdentifierLocs();
    Record.push_back(((!IdentifierLocs.empty()) ? 1 : 0));
    if (IdentifierLocs.empty()) {
      Record.AddSourceLocation(D.getLocEnd());
      Record.push_back($int2ulong(1));
    } else {
      for (/*uint*/int I = 0, N = IdentifierLocs.size(); I != N; ++I)  {
        Record.AddSourceLocation(new SourceLocation(IdentifierLocs.$at(I)));
      }
      Record.push_back($uint2ulong(IdentifierLocs.size()));
    }
    // Note: the number of source locations must always be the last element in
    // the record.
    Code = DeclCode.DECL_IMPORT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitAccessSpecDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1273,
   FQN="clang::ASTDeclWriter::VisitAccessSpecDecl", NM="_ZN5clang13ASTDeclWriter19VisitAccessSpecDeclEPNS_14AccessSpecDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter19VisitAccessSpecDeclEPNS_14AccessSpecDeclE")
  //</editor-fold>
  public void VisitAccessSpecDecl(AccessSpecDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddSourceLocation(D.getColonLoc());
    Code = DeclCode.DECL_ACCESS_SPEC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitFriendDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1279,
   FQN="clang::ASTDeclWriter::VisitFriendDecl", NM="_ZN5clang13ASTDeclWriter15VisitFriendDeclEPNS_10FriendDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter15VisitFriendDeclEPNS_10FriendDeclE")
  //</editor-fold>
  public void VisitFriendDecl(FriendDecl /*P*/ D) {
    // Record the number of friend type template parameter lists here
    // so as to simplify memory allocation during deserialization.
    Record.push_back($uint2ulong(D.NumTPLists));
    VisitDecl(D);
    boolean hasFriendDecl = (D.Friend.is(NamedDecl /*P*/.class) != 0);
    Record.push_back((hasFriendDecl ? 1 : 0));
    if (hasFriendDecl) {
      Record.AddDeclRef(D.getFriendDecl());
    } else {
      Record.AddTypeSourceInfo(D.getFriendType());
    }
    for (/*uint*/int i = 0; $less_uint(i, D.NumTPLists); ++i)  {
      Record.AddTemplateParameterList(D.getFriendTypeTemplateParameterList(i));
    }
    Record.AddDeclRef(D.getNextFriend());
    Record.push_back($uint2ulong(D.UnsupportedFriend));
    Record.AddSourceLocation(new SourceLocation(D.FriendLoc));
    Code = DeclCode.DECL_FRIEND;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitFriendTemplateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1298,
   FQN="clang::ASTDeclWriter::VisitFriendTemplateDecl", NM="_ZN5clang13ASTDeclWriter23VisitFriendTemplateDeclEPNS_18FriendTemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter23VisitFriendTemplateDeclEPNS_18FriendTemplateDeclE")
  //</editor-fold>
  public void VisitFriendTemplateDecl(FriendTemplateDecl /*P*/ D) {
    VisitDecl(D);
    Record.push_back($uint2ulong(D.getNumTemplateParameters()));
    for (/*uint*/int i = 0, e = D.getNumTemplateParameters(); i != e; ++i)  {
      Record.AddTemplateParameterList(D.getTemplateParameterList(i));
    }
    Record.push_back(((D.getFriendDecl() != (NamedDecl /*P*/ )null) ? 1 : 0));
    if ((D.getFriendDecl() != null)) {
      Record.AddDeclRef(D.getFriendDecl());
    } else {
      Record.AddTypeSourceInfo(D.getFriendType());
    }
    Record.AddSourceLocation(D.getFriendLoc());
    Code = DeclCode.DECL_FRIEND_TEMPLATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitStaticAssertDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1549,
   FQN="clang::ASTDeclWriter::VisitStaticAssertDecl", NM="_ZN5clang13ASTDeclWriter21VisitStaticAssertDeclEPNS_16StaticAssertDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter21VisitStaticAssertDeclEPNS_16StaticAssertDeclE")
  //</editor-fold>
  public void VisitStaticAssertDecl(StaticAssertDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddStmt(D.getAssertExpr());
    Record.push_back((D.isFailed() ? 1 : 0));
    Record.AddStmt(D.getMessage());
    Record.AddSourceLocation(D.getRParenLoc());
    Code = DeclCode.DECL_STATIC_ASSERT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitBlockDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1021,
   FQN="clang::ASTDeclWriter::VisitBlockDecl", NM="_ZN5clang13ASTDeclWriter14VisitBlockDeclEPNS_9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitBlockDeclEPNS_9BlockDeclE")
  //</editor-fold>
  public void VisitBlockDecl(BlockDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddStmt(D.getBody());
    Record.AddTypeSourceInfo(D.getSignatureAsWritten());
    Record.push_back($uint2ulong(D.param_size()));
    for (ParmVarDecl /*P*/ P : D.parameters())  {
      Record.AddDeclRef(P);
    }
    Record.push_back((D.isVariadic() ? 1 : 0));
    Record.push_back((D.blockMissingReturnType() ? 1 : 0));
    Record.push_back((D.isConversionFromLambda() ? 1 : 0));
    Record.push_back((D.capturesCXXThis() ? 1 : 0));
    Record.push_back($uint2ulong(D.getNumCaptures()));
    for (final /*const*/ BlockDecl.Capture /*&*/ capture : D.captures()) {
      Record.AddDeclRef(capture.getVariable());
      
      /*uint*/int flags = 0;
      if (capture.isByRef()) {
        flags |= 1;
      }
      if (capture.isNested()) {
        flags |= 2;
      }
      if (capture.hasCopyExpr()) {
        flags |= 4;
      }
      Record.push_back($uint2ulong(flags));
      if (capture.hasCopyExpr()) {
        Record.AddStmt(capture.getCopyExpr());
      }
    }
    
    Code = DeclCode.DECL_BLOCK;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitCapturedDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1048,
   FQN="clang::ASTDeclWriter::VisitCapturedDecl", NM="_ZN5clang13ASTDeclWriter17VisitCapturedDeclEPNS_12CapturedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter17VisitCapturedDeclEPNS_12CapturedDeclE")
  //</editor-fold>
  public void VisitCapturedDecl(CapturedDecl /*P*/ CD) {
    Record.push_back($uint2ulong(CD.getNumParams()));
    VisitDecl(CD);
    Record.push_back($uint2ulong(CD.getContextParamPosition()));
    Record.push_back($int2ulong(CD.isNothrow() ? 1 : 0));
    // Body is stored by VisitCapturedStmt.
    for (/*uint*/int I = 0; $less_uint(I, CD.getNumParams()); ++I)  {
      Record.AddDeclRef(CD.getParam(I));
    }
    Code = DeclCode.DECL_CAPTURED;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitEmptyDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1016,
   FQN="clang::ASTDeclWriter::VisitEmptyDecl", NM="_ZN5clang13ASTDeclWriter14VisitEmptyDeclEPNS_9EmptyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter14VisitEmptyDeclEPNS_9EmptyDeclE")
  //</editor-fold>
  public void VisitEmptyDecl(EmptyDecl /*P*/ D) {
    VisitDecl(D);
    Code = DeclCode.DECL_EMPTY;
  }

  
  
  /// \brief Emit the DeclContext part of a declaration context decl.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1559,
   FQN="clang::ASTDeclWriter::VisitDeclContext", NM="_ZN5clang13ASTDeclWriter16VisitDeclContextEPNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter16VisitDeclContextEPNS_11DeclContextE")
  //</editor-fold>
  public void VisitDeclContext(DeclContext /*P*/ DC) {
    Record.AddOffset(Writer.WriteDeclContextLexicalBlock(Context, DC));
    Record.AddOffset(Writer.WriteDeclContextVisibleBlock(Context, DC));
  }

  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitRedeclarable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1582,
   FQN="clang::ASTDeclWriter::VisitRedeclarable", NM="Tpl__ZN5clang13ASTDeclWriter17VisitRedeclarableEPNS_12RedeclarableIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=Tpl__ZN5clang13ASTDeclWriter17VisitRedeclarableEPNS_12RedeclarableIT_EE")
  //</editor-fold>
  public </*typename*/ T extends Decl & Redeclarable> void VisitRedeclarable(Redeclarable<T> /*P*/ D) {
    T /*P*/ First = D.getFirstDecl();
    T /*P*/ MostRecent = (T /*P*/) First.getMostRecentDecl();
    T /*P*/ DAsT = ((/*static_cast*/T /*P*/ )(D));
    if (Native.$noteq(MostRecent, First)) {
      assert Native.$bool(isRedeclarableDeclKind(DAsT.getKind().getValue())) : "Not considered redeclarable?";
      
      Record.AddDeclRef(First);
      
      // Write out a list of local redeclarations of this declaration if it's the
      // first local declaration in the chain.
      /*const*/ Decl /*P*/ FirstLocal = Writer.getFirstLocalDecl(DAsT);
      if (Native.$eq(DAsT, FirstLocal)) {
        ASTRecordWriter LocalRedeclWriter = null;
        try {
          // Emit a list of all imported first declarations so that we can be sure
          // that all redeclarations visible to this module are before D in the
          // redecl chain.
          /*uint*/int I = Record.size();
          Record.push_back($int2ulong(0));
          if ((Writer.Chain != null)) {
            AddFirstDeclFromEachModule(DAsT, /*IncludeLocal*/ false);
          }
          // This is the number of imported first declarations + 1.
          Record.$at(I).$set($uint2ulong(Record.size() - I));
          
          // Collect the set of local redeclarations of this declaration, from
          // newest to oldest.
          SmallVectorULong LocalRedecls/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
          LocalRedeclWriter/*J*/= new ASTRecordWriter(Record, LocalRedecls);
          for (/*const*/ Decl /*P*/ Prev = FirstLocal.getMostRecentDecl$Decl$Const();
               Prev != FirstLocal; Prev = Prev.getPreviousDecl$Decl$Const())  {
            if (!Prev.isFromASTFile()) {
              LocalRedeclWriter.AddDeclRef(Prev);
            }
          }
          
          // If we have any redecls, write them now as a separate record preceding
          // the declaration itself.
          if (LocalRedecls.empty()) {
            Record.push_back($int2ulong(0));
          } else {
            Record.AddOffset(LocalRedeclWriter.Emit(LOCAL_REDECLARATIONS));
          }
        } finally {
          if (LocalRedeclWriter != null) { LocalRedeclWriter.$destroy(); }
        }
      } else {
        Record.push_back($int2ulong(0));
        Record.AddDeclRef(FirstLocal);
      }
      
      // Make sure that we serialize both the previous and the most-recent 
      // declarations, which (transitively) ensures that all declarations in the
      // chain get serialized.
      //
      // FIXME: This is not correct; when we reach an imported declaration we
      // won't emit its previous declaration.
      /*J:(void)*/Writer.GetDeclRef(D.getPreviousDecl());
      /*J:(void)*/Writer.GetDeclRef(MostRecent);
    } else {
      // We use the sentinel value 0 to indicate an only declaration.
      Record.push_back($int2ulong(0));
    }
  }

  
  // FIXME: Put in the same order is DeclNodes.td?
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 606,
   FQN="clang::ASTDeclWriter::VisitObjCMethodDecl", NM="_ZN5clang13ASTDeclWriter19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter19VisitObjCMethodDeclEPNS_14ObjCMethodDeclE")
  //</editor-fold>
  public void VisitObjCMethodDecl(ObjCMethodDecl /*P*/ D) {
    VisitNamedDecl(D);
    // FIXME: convert to LazyStmtPtr?
    // Unlike C/C++, method bodies will never be in header files.
    boolean HasBodyStuff = D.getBody() != null
       || D.getSelfDecl() != null || D.getCmdDecl() != null;
    Record.push_back((HasBodyStuff ? 1 : 0));
    if (HasBodyStuff) {
      Record.AddStmt(D.getBody());
      Record.AddDeclRef(D.getSelfDecl());
      Record.AddDeclRef(D.getCmdDecl());
    }
    Record.push_back((D.isInstanceMethod() ? 1 : 0));
    Record.push_back((D.isVariadic() ? 1 : 0));
    Record.push_back((D.isPropertyAccessor() ? 1 : 0));
    Record.push_back((D.isDefined() ? 1 : 0));
    Record.push_back($uint2ulong(D.IsOverriding));
    Record.push_back($uint2ulong(D.HasSkippedBody));
    
    Record.push_back($uint2ulong(D.IsRedeclaration));
    Record.push_back($uint2ulong(D.HasRedeclaration));
    if (D.HasRedeclaration) {
      assert Native.$bool(Context.getObjCMethodRedeclaration(D));
      Record.AddDeclRef(Context.getObjCMethodRedeclaration(D));
    }
    
    // FIXME: stable encoding for @required/@optional
    Record.push_back(D.getImplementationControl().getValue());
    // FIXME: stable encoding for in/out/inout/bycopy/byref/oneway/nullability
    Record.push_back($uint2ulong(D.getObjCDeclQualifier()));
    Record.push_back((D.hasRelatedResultType() ? 1 : 0));
    Record.AddTypeRef(D.getReturnType());
    Record.AddTypeSourceInfo(D.getReturnTypeSourceInfo());
    Record.AddSourceLocation(D.getLocEnd());
    Record.push_back($uint2ulong(D.param_size()));
    for (/*const*/ ParmVarDecl /*P*/ P : D.parameters())  {
      Record.AddDeclRef(P);
    }
    
    Record.push_back($uint2ulong($2bits_uint2uint(D.SelLocsKind)));
    /*uint*/int NumStoredSelLocs = D.getNumStoredSelLocs();
    type$ptr<SourceLocation /*P*/> SelLocs = D.getStoredSelLocs();
    Record.push_back($uint2ulong(NumStoredSelLocs));
    for (/*uint*/int i = 0; i != NumStoredSelLocs; ++i)  {
      Record.AddSourceLocation(new SourceLocation(SelLocs.$at(i)));
    }
    
    Code = DeclCode.DECL_OBJC_METHOD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCTypeParamDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 654,
   FQN="clang::ASTDeclWriter::VisitObjCTypeParamDecl", NM="_ZN5clang13ASTDeclWriter22VisitObjCTypeParamDeclEPNS_17ObjCTypeParamDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitObjCTypeParamDeclEPNS_17ObjCTypeParamDeclE")
  //</editor-fold>
  public void VisitObjCTypeParamDecl(ObjCTypeParamDecl /*P*/ D) {
    VisitTypedefNameDecl(D);
    Record.push_back($uint2ulong($2bits_uint2uint(D.Variance)));
    Record.push_back($uint2ulong($14bits_uint2uint(D.Index)));
    Record.AddSourceLocation(new SourceLocation(D.VarianceLoc));
    Record.AddSourceLocation(new SourceLocation(D.ColonLoc));
    
    Code = DeclCode.DECL_OBJC_TYPE_PARAM;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCContainerDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 664,
   FQN="clang::ASTDeclWriter::VisitObjCContainerDecl", NM="_ZN5clang13ASTDeclWriter22VisitObjCContainerDeclEPNS_17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitObjCContainerDeclEPNS_17ObjCContainerDeclE")
  //</editor-fold>
  public void VisitObjCContainerDecl(ObjCContainerDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getAtStartLoc());
    Record.AddSourceRange(D.getAtEndRange());
    // Abstract class (no need to define a stable serialization::DECL code).
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 671,
   FQN="clang::ASTDeclWriter::VisitObjCInterfaceDecl", NM="_ZN5clang13ASTDeclWriter22VisitObjCInterfaceDeclEPNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter22VisitObjCInterfaceDeclEPNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public void VisitObjCInterfaceDecl(ObjCInterfaceDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitObjCContainerDecl(D);
    Record.AddTypeRef(new QualType(D.getTypeForDecl(), 0));
    AddObjCTypeParamList(D.TypeParamList);
    
    Record.push_back((D.isThisDeclarationADefinition() ? 1 : 0));
    if (D.isThisDeclarationADefinition()) {
      // Write the DefinitionData
      final ObjCInterfaceDecl.DefinitionData /*&*/ Data = D.data();
      
      Record.AddTypeSourceInfo(D.getSuperClassTInfo());
      Record.AddSourceLocation(D.getEndOfDefinitionLoc());
      Record.push_back($uint2ulong(Data.HasDesignatedInitializers));
      
      // Write out the protocols that are directly referenced by the @interface.
      Record.push_back($uint2ulong(Data.ReferencedProtocols.size()));
      for (/*const*/ ObjCProtocolDecl /*P*/ P : D.protocols())  {
        Record.AddDeclRef(P);
      }
      for (final /*const*/ SourceLocation /*&*/ PL : D.protocol_locs())  {
        Record.AddSourceLocation(new SourceLocation(PL));
      }
      
      // Write out the protocols that are transitively referenced.
      Record.push_back($uint2ulong(Data.AllReferencedProtocols.size()));
      for (type$ptr<ObjCProtocolDecl> P = $tryClone(Data.AllReferencedProtocols.begin()), 
          /*P*/ /*const*/ /*P*/ PEnd = $tryClone(Data.AllReferencedProtocols.end());
           $noteq_ptr(P, PEnd); P.$preInc())  {
        Record.AddDeclRef(P.$star());
      }
      {
        
        ObjCCategoryDecl /*P*/ Cat = D.getCategoryListRaw();
        if ((Cat != null)) {
          // Ensure that we write out the set of categories for this class.
          Writer.ObjCClassesWithCategories.insert(D);
          
          // Make sure that the categories get serialized.
          for (; (Cat != null); Cat = Cat.getNextClassCategoryRaw())  {
            /*J:(void)*/Writer.GetDeclRef(Cat);
          }
        }
      }
    }
    
    Code = DeclCode.DECL_OBJC_INTERFACE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCIvarDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 715,
   FQN="clang::ASTDeclWriter::VisitObjCIvarDecl", NM="_ZN5clang13ASTDeclWriter17VisitObjCIvarDeclEPNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter17VisitObjCIvarDeclEPNS_12ObjCIvarDeclE")
  //</editor-fold>
  public void VisitObjCIvarDecl(ObjCIvarDecl /*P*/ D) {
    VisitFieldDecl(D);
    // FIXME: stable encoding for @public/@private/@protected/@package
    Record.push_back(D.getAccessControl().getValue());
    Record.push_back((D.getSynthesize() ? 1 : 0));
    if (D.getDeclContext() == D.getLexicalDeclContext()
       && !D.hasAttrs()
       && !D.isImplicit()
       && !D.isUsed(false)
       && !D.isInvalidDecl()
       && !D.isReferenced()
       && !D.isModulePrivate()
       && !(D.getBitWidth() != null)
       && !D.hasExtInfo()
       && D.getDeclName().$bool()) {
      AbbrevToUse = Writer.getDeclObjCIvarAbbrev();
    }
    
    Code = DeclCode.DECL_OBJC_IVAR;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCProtocolDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 736,
   FQN="clang::ASTDeclWriter::VisitObjCProtocolDecl", NM="_ZN5clang13ASTDeclWriter21VisitObjCProtocolDeclEPNS_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter21VisitObjCProtocolDeclEPNS_16ObjCProtocolDeclE")
  //</editor-fold>
  public void VisitObjCProtocolDecl(ObjCProtocolDecl /*P*/ D) {
    VisitRedeclarable(D);
    VisitObjCContainerDecl(D);
    
    Record.push_back((D.isThisDeclarationADefinition() ? 1 : 0));
    if (D.isThisDeclarationADefinition()) {
      Record.push_back($uint2ulong(D.protocol_size()));
      for (/*const*/ ObjCProtocolDecl /*P*/ I : D.protocols())  {
        Record.AddDeclRef(I);
      }
      for (final /*const*/ SourceLocation /*&*/ PL : D.protocol_locs())  {
        Record.AddSourceLocation(new SourceLocation(PL));
      }
    }
    
    Code = DeclCode.DECL_OBJC_PROTOCOL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCAtDefsFieldDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 752,
   FQN="clang::ASTDeclWriter::VisitObjCAtDefsFieldDecl", NM="_ZN5clang13ASTDeclWriter24VisitObjCAtDefsFieldDeclEPNS_19ObjCAtDefsFieldDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter24VisitObjCAtDefsFieldDeclEPNS_19ObjCAtDefsFieldDeclE")
  //</editor-fold>
  public void VisitObjCAtDefsFieldDecl(ObjCAtDefsFieldDecl /*P*/ D) {
    VisitFieldDecl(D);
    Code = DeclCode.DECL_OBJC_AT_DEFS_FIELD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCCategoryDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 757,
   FQN="clang::ASTDeclWriter::VisitObjCCategoryDecl", NM="_ZN5clang13ASTDeclWriter21VisitObjCCategoryDeclEPNS_16ObjCCategoryDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter21VisitObjCCategoryDeclEPNS_16ObjCCategoryDeclE")
  //</editor-fold>
  public void VisitObjCCategoryDecl(ObjCCategoryDecl /*P*/ D) {
    VisitObjCContainerDecl(D);
    Record.AddSourceLocation(D.getCategoryNameLoc());
    Record.AddSourceLocation(D.getIvarLBraceLoc());
    Record.AddSourceLocation(D.getIvarRBraceLoc());
    Record.AddDeclRef(D.getClassInterface());
    AddObjCTypeParamList(D.TypeParamList);
    Record.push_back($uint2ulong(D.protocol_size()));
    for (/*const*/ ObjCProtocolDecl /*P*/ I : D.protocols())  {
      Record.AddDeclRef(I);
    }
    for (final /*const*/ SourceLocation /*&*/ PL : D.protocol_locs())  {
      Record.AddSourceLocation(new SourceLocation(PL));
    }
    Code = DeclCode.DECL_OBJC_CATEGORY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCImplDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 797,
   FQN="clang::ASTDeclWriter::VisitObjCImplDecl", NM="_ZN5clang13ASTDeclWriter17VisitObjCImplDeclEPNS_12ObjCImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter17VisitObjCImplDeclEPNS_12ObjCImplDeclE")
  //</editor-fold>
  public void VisitObjCImplDecl(ObjCImplDecl /*P*/ D) {
    VisitObjCContainerDecl(D);
    Record.AddDeclRef(D.getClassInterface());
    // Abstract class (no need to define a stable serialization::DECL code).
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCCategoryImplDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 803,
   FQN="clang::ASTDeclWriter::VisitObjCCategoryImplDecl", NM="_ZN5clang13ASTDeclWriter25VisitObjCCategoryImplDeclEPNS_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25VisitObjCCategoryImplDeclEPNS_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public void VisitObjCCategoryImplDecl(ObjCCategoryImplDecl /*P*/ D) {
    VisitObjCImplDecl(D);
    Record.AddIdentifierRef(D.getIdentifier());
    Record.AddSourceLocation(D.getCategoryNameLoc());
    Code = DeclCode.DECL_OBJC_CATEGORY_IMPL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCImplementationDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 810,
   FQN="clang::ASTDeclWriter::VisitObjCImplementationDecl", NM="_ZN5clang13ASTDeclWriter27VisitObjCImplementationDeclEPNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter27VisitObjCImplementationDeclEPNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public void VisitObjCImplementationDecl(ObjCImplementationDecl /*P*/ D) {
    VisitObjCImplDecl(D);
    Record.AddDeclRef(D.getSuperClass());
    Record.AddSourceLocation(D.getSuperClassLoc());
    Record.AddSourceLocation(D.getIvarLBraceLoc());
    Record.AddSourceLocation(D.getIvarRBraceLoc());
    Record.push_back((D.hasNonZeroConstructors() ? 1 : 0));
    Record.push_back((D.hasDestructors() ? 1 : 0));
    Record.push_back($uint2ulong(D.NumIvarInitializers));
    if ((D.NumIvarInitializers != 0)) {
      Record.AddCXXCtorInitializers(llvm.makeArrayRef(D.init_begin(), D.init_end()));
    }
    Code = DeclCode.DECL_OBJC_IMPLEMENTATION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCCompatibleAliasDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 772,
   FQN="clang::ASTDeclWriter::VisitObjCCompatibleAliasDecl", NM="_ZN5clang13ASTDeclWriter28VisitObjCCompatibleAliasDeclEPNS_23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter28VisitObjCCompatibleAliasDeclEPNS_23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  public void VisitObjCCompatibleAliasDecl(ObjCCompatibleAliasDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddDeclRef(D.getClassInterface());
    Code = DeclCode.DECL_OBJC_COMPATIBLE_ALIAS;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCPropertyDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 778,
   FQN="clang::ASTDeclWriter::VisitObjCPropertyDecl", NM="_ZN5clang13ASTDeclWriter21VisitObjCPropertyDeclEPNS_16ObjCPropertyDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter21VisitObjCPropertyDeclEPNS_16ObjCPropertyDeclE")
  //</editor-fold>
  public void VisitObjCPropertyDecl(ObjCPropertyDecl /*P*/ D) {
    VisitNamedDecl(D);
    Record.AddSourceLocation(D.getAtLoc());
    Record.AddSourceLocation(D.getLParenLoc());
    Record.AddTypeRef(D.getType());
    Record.AddTypeSourceInfo(D.getTypeSourceInfo());
    // FIXME: stable encoding
    Record.push_back($uint2ulong((/*uint*/int)D.getPropertyAttributes()));
    Record.push_back($uint2ulong((/*uint*/int)D.getPropertyAttributesAsWritten()));
    // FIXME: stable encoding
    Record.push_back($uint2ulong((/*uint*/int)D.getPropertyImplementation().getValue()));
    Record.AddDeclarationName(new DeclarationName(D.getGetterName()));
    Record.AddDeclarationName(new DeclarationName(D.getSetterName()));
    Record.AddDeclRef(D.getGetterMethodDecl());
    Record.AddDeclRef(D.getSetterMethodDecl());
    Record.AddDeclRef(D.getPropertyIvarDecl());
    Code = DeclCode.DECL_OBJC_PROPERTY;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitObjCPropertyImplDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 825,
   FQN="clang::ASTDeclWriter::VisitObjCPropertyImplDecl", NM="_ZN5clang13ASTDeclWriter25VisitObjCPropertyImplDeclEPNS_20ObjCPropertyImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25VisitObjCPropertyImplDeclEPNS_20ObjCPropertyImplDeclE")
  //</editor-fold>
  public void VisitObjCPropertyImplDecl(ObjCPropertyImplDecl /*P*/ D) {
    VisitDecl(D);
    Record.AddSourceLocation(D.getLocStart());
    Record.AddDeclRef(D.getPropertyDecl());
    Record.AddDeclRef(D.getPropertyIvarDecl());
    Record.AddSourceLocation(D.getPropertyIvarDeclLoc());
    Record.AddStmt(D.getGetterCXXConstructor());
    Record.AddStmt(D.getSetterCXXAssignment());
    Code = DeclCode.DECL_OBJC_PROPERTY_IMPL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitOMPThreadPrivateDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1640,
   FQN="clang::ASTDeclWriter::VisitOMPThreadPrivateDecl", NM="_ZN5clang13ASTDeclWriter25VisitOMPThreadPrivateDeclEPNS_20OMPThreadPrivateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25VisitOMPThreadPrivateDeclEPNS_20OMPThreadPrivateDeclE")
  //</editor-fold>
  public void VisitOMPThreadPrivateDecl(OMPThreadPrivateDecl /*P*/ D) {
    Record.push_back($uint2ulong(D.varlist_size()));
    VisitDecl(D);
    for (Expr /*P*/ I : D.varlists())  {
      Record.AddStmt(I);
    }
    Code = DeclCode.DECL_OMP_THREADPRIVATE;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitOMPDeclareReductionDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1648,
   FQN="clang::ASTDeclWriter::VisitOMPDeclareReductionDecl", NM="_ZN5clang13ASTDeclWriter28VisitOMPDeclareReductionDeclEPNS_23OMPDeclareReductionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter28VisitOMPDeclareReductionDeclEPNS_23OMPDeclareReductionDeclE")
  //</editor-fold>
  public void VisitOMPDeclareReductionDecl(OMPDeclareReductionDecl /*P*/ D) {
    VisitValueDecl(D);
    Record.AddSourceLocation(D.getLocStart());
    Record.AddStmt(D.getCombiner());
    Record.AddStmt(D.getInitializer());
    Record.AddDeclRef(D.getPrevDeclInScope());
    Code = DeclCode.DECL_OMP_DECLARE_REDUCTION;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::VisitOMPCapturedExprDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 1657,
   FQN="clang::ASTDeclWriter::VisitOMPCapturedExprDecl", NM="_ZN5clang13ASTDeclWriter24VisitOMPCapturedExprDeclEPNS_19OMPCapturedExprDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter24VisitOMPCapturedExprDeclEPNS_19OMPCapturedExprDeclE")
  //</editor-fold>
  public void VisitOMPCapturedExprDecl(OMPCapturedExprDecl /*P*/ D) {
    VisitVarDecl(D);
    Code = DeclCode.DECL_OMP_CAPTUREDEXPR;
  }

  
  /// Add an Objective-C type parameter list to the given record.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::AddObjCTypeParamList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 146,
   FQN="clang::ASTDeclWriter::AddObjCTypeParamList", NM="_ZN5clang13ASTDeclWriter20AddObjCTypeParamListEPNS_17ObjCTypeParamListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter20AddObjCTypeParamListEPNS_17ObjCTypeParamListE")
  //</editor-fold>
  public void AddObjCTypeParamList(ObjCTypeParamList /*P*/ typeParams) {
    // Empty type parameter list.
    if (!(typeParams != null)) {
      Record.push_back($int2ulong(0));
      return;
    }
    
    Record.push_back($uint2ulong(typeParams.size()));
    for (ObjCTypeParamDecl /*P*/ typeParam : $Deref(typeParams)) {
      Record.AddDeclRef(typeParam);
    }
    Record.AddSourceLocation(typeParams.getLAngleLoc());
    Record.AddSourceLocation(typeParams.getRAngleLoc());
  }

  
  /// Add to the record the first declaration from each module file that
  /// provides a declaration of D. The intent is to provide a sufficient
  /// set such that reloading this set will load all current redeclarations.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::AddFirstDeclFromEachModule">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 164,
   FQN="clang::ASTDeclWriter::AddFirstDeclFromEachModule", NM="_ZN5clang13ASTDeclWriter26AddFirstDeclFromEachModuleEPKNS_4DeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter26AddFirstDeclFromEachModuleEPKNS_4DeclEb")
  //</editor-fold>
  public void AddFirstDeclFromEachModule(/*const*/ Decl /*P*/ D, boolean IncludeLocal) {
    MapVectorPtrPtr<ModuleFile /*P*/ , /*const*/ Decl /*P*/ > Firsts = null;
    try {
      Firsts/*J*/= new MapVectorPtrPtr<ModuleFile /*P*/ , /*const*/ Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Decl/*P*/)null);
      // FIXME: We can skip entries that we know are implied by others.
      for (/*const*/ Decl /*P*/ R = D.getMostRecentDecl$Decl$Const(); (R != null); R = R.getPreviousDecl$Decl$Const()) {
        if (R.isFromASTFile()) {
          Firsts.$set(Writer.Chain.getOwningModuleFile(R), R);
        } else if (IncludeLocal) {
          Firsts.$set((ModuleFile /*P*/ /*const*/)null, R);
        }
      }
      for (final /*const*/std.pair/*PtrPtr*/<ModuleFile /*P*/ , /*const*/ Decl /*P*/ > /*&*/ F : Firsts)  {
        Record.AddDeclRef(F.second);
      }
    } finally {
      if (Firsts != null) { Firsts.$destroy(); }
    }
  }

  
  /// Get the specialization decl from an entry in the specialization list.
  /*template <typename EntryType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::getSpecializationDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 179,
   FQN="clang::ASTDeclWriter::getSpecializationDecl", NM="Tpl__ZN5clang13ASTDeclWriter21getSpecializationDeclERT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=Tpl__ZN5clang13ASTDeclWriter21getSpecializationDeclERT_")
  //</editor-fold>
  public </*typename*/ EntryType extends HasGetTemplateArgs$TemplateArgumentList & Redeclarable> EntryType/*P*/ getSpecializationDecl(final EntryType /*&*/ T) {
    return RedeclarableTemplateDecl.SpecEntryTraits.<EntryType>$Info().getDecl(Native.$addr(T));
  }

  
  /// Get the list of partial specializations from a template's common ptr.
  //template <typename T = Common> 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::getPartialSpecializations">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 186,
   FQN="clang::ASTDeclWriter::getPartialSpecializations", NM="_ZN5clang13ASTDeclWriter25getPartialSpecializationsINS_17ClassTemplateDecl6CommonEEERDtsrT_22PartialSpecializationsEPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25getPartialSpecializationsINS_17ClassTemplateDecl6CommonEEERDtsrT_22PartialSpecializationsEPS4_")
  //</editor-fold>
  public FoldingSetVector<ClassTemplatePartialSpecializationDecl> /*&*/ getPartialSpecializations(ClassTemplateDecl.Common /*P*/ Common) {
    return Common.PartialSpecializations;
  }
  //template <typename T = Common> 
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::getPartialSpecializations">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 186,
   FQN="clang::ASTDeclWriter::getPartialSpecializations", NM="_ZN5clang13ASTDeclWriter25getPartialSpecializationsINS_15VarTemplateDecl6CommonEEERDtsrT_22PartialSpecializationsEPS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25getPartialSpecializationsINS_15VarTemplateDecl6CommonEEERDtsrT_22PartialSpecializationsEPS4_")
  //</editor-fold>
  public FoldingSetVector<VarTemplatePartialSpecializationDecl> /*&*/ getPartialSpecializations(VarTemplateDecl.Common /*P*/ Common) {
    return Common.PartialSpecializations;
  }
//  /*template <typename T> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::getPartialSpecializations">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 186,
//   FQN="clang::ASTDeclWriter::getPartialSpecializations", NM="Tpl__ZN5clang13ASTDeclWriter25getPartialSpecializationsEPT_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=Tpl__ZN5clang13ASTDeclWriter25getPartialSpecializationsEPT_")
//  //</editor-fold>
//  public </*typename*/ T> decltype(T.PartialSpecializations) /*&*/ getPartialSpecializations$T(T /*P*/ Common) {
//    return Common.PartialSpecializations;
//  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::getPartialSpecializations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 189,
   FQN="clang::ASTDeclWriter::getPartialSpecializations", NM="_ZN5clang13ASTDeclWriter25getPartialSpecializationsEPNS_20FunctionTemplateDecl6CommonE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter25getPartialSpecializationsEPNS_20FunctionTemplateDecl6CommonE")
  //</editor-fold>
  public ArrayRef<Decl> getPartialSpecializations(FunctionTemplateDecl.Common /*P*/ $Prm0) {
    return new ArrayRef<Decl>(None, false);
  }

  
  /*template <typename DeclTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::AddTemplateSpecializations">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 194,
   FQN="clang::ASTDeclWriter::AddTemplateSpecializations", NM="Tpl__ZN5clang13ASTDeclWriter26AddTemplateSpecializationsEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=Tpl__ZN5clang13ASTDeclWriter26AddTemplateSpecializationsEPT_")
  //</editor-fold>
  public </*typename*/ DeclTy extends RedeclarableTemplateDecl> void AddTemplateSpecializations(DeclTy /*P*/ D) {
    RedeclarableTemplateDecl.CommonBase /*P*/ Common = D.getCommonPtr();
    
    // If we have any lazy specializations, and the external AST source is
    // our chained AST reader, we can just write out the DeclIDs. Otherwise,
    // we need to resolve them to actual declarations.
    if (Writer.Chain != Writer.Context.getExternalSource()
       && Common.LazySpecializations != null) {
      D.LoadLazySpecializations();
      assert Native.$bool(Native.$not(Common.LazySpecializations));
    }
    
    ArrayRefUInt LazySpecializations/*J*/= new ArrayRefUInt();
    {
      uint$ptr /*P*/ LS = Common.LazySpecializations;
      if (LS != null) {
        LazySpecializations = llvm.makeArrayRef(LS.$add(1), LS.$star());
      }
    }
    
    // Add a slot to the record for the number of specializations.
    /*uint*/int I = Record.size();
    Record.push_back($int2ulong(0));
    
    // AddFirstDeclFromEachModule might trigger deserialization, invalidating
    // *Specializations iterators.
    SmallVector</*const*/ Decl /*P*/ > Specs/*J*/= new SmallVector</*const*/ Decl /*P*/ >(16, (/*const*/ Decl /*P*/ )null);
    if (Common instanceof ClassTemplateDecl.Common) {
      for (final ClassTemplateSpecializationDecl /*&*/ Entry : ((ClassTemplateDecl.Common)Common).Specializations)  {
        Specs.push_back(getSpecializationDecl(Entry));
      }
      for (final ClassTemplatePartialSpecializationDecl /*&*/ Entry : getPartialSpecializations((ClassTemplateDecl.Common)Common))  {
        Specs.push_back(getSpecializationDecl(Entry));
      }
    } else if (Common instanceof VarTemplateDecl.Common) {
      for (final VarTemplateSpecializationDecl /*&*/ Entry : ((VarTemplateDecl.Common)Common).Specializations)  {
        Specs.push_back(getSpecializationDecl(Entry));
      }
      for (final VarTemplatePartialSpecializationDecl /*&*/ Entry : getPartialSpecializations((VarTemplateDecl.Common)Common))  {
        Specs.push_back(getSpecializationDecl(Entry));
      }
    } else if (Common instanceof FunctionTemplateDecl.Common) {
      for (final FunctionTemplateSpecializationInfo /*&*/ Entry : ((FunctionTemplateDecl.Common)Common).Specializations)  {
        Specs.push_back(/*getSpecializationDecl(*/Entry.Function/*)*/);
      }
      for (final Decl /*&*/ Entry : getPartialSpecializations((FunctionTemplateDecl.Common)Common))  {
        Specs.push_back(Entry);
      }
    } else {
      throw new UnsupportedOperationException("Unsupported class "+Common.getClass().getName());
    }
    
    for (/*const*/ Decl /*P*/ D$1 : Specs) {
      assert (D$1.isCanonicalDecl()) : "non-canonical decl in set";
      AddFirstDeclFromEachModule(D$1, /*IncludeLocal*/ true);
    }
    Record.append(LazySpecializations.begin(), LazySpecializations.end());
    
    // Update the size entry we added earlier.
    Record.$at(I).$set($uint2ulong(Record.size() - I - 1));
  }

  
  /// Ensure that this template specialization is associated with the specified
  /// template on reload.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::RegisterTemplateSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 234,
   FQN="clang::ASTDeclWriter::RegisterTemplateSpecialization", NM="_ZN5clang13ASTDeclWriter30RegisterTemplateSpecializationEPKNS_4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriter30RegisterTemplateSpecializationEPKNS_4DeclES3_")
  //</editor-fold>
  public void RegisterTemplateSpecialization(/*const*/ Decl /*P*/ Template, 
                                /*const*/ Decl /*P*/ Specialization) {
    Template = Template.getCanonicalDecl$Const();
    
    // If the canonical template is local, we'll write out this specialization
    // when we emit it.
    // FIXME: We can do the same thing if there is any local declaration of
    // the template, to avoid emitting an update record.
    if (!Template.isFromASTFile()) {
      return;
    }
    
    // We only need to associate the first local declaration of the
    // specialization. The other declarations will get pulled in by it.
    if (Writer.getFirstLocalDecl(Specialization) != Specialization) {
      return;
    }
    
    Writer.DeclUpdates.$at(Template).push_back(new ASTWriter.DeclUpdate(DeclUpdateKind.UPD_CXX_ADDED_TEMPLATE_SPECIALIZATION, Specialization));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTDeclWriter::~ASTDeclWriter">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp", line = 34,
   FQN="clang::ASTDeclWriter::~ASTDeclWriter", NM="_ZN5clang13ASTDeclWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriterDecl.cpp -nm=_ZN5clang13ASTDeclWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Record.$destroy();
    DeclVisitorVoid.super.$destroy$DeclVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Writer=" + Writer // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + ", Record=" + Record // NOI18N
              + ", Code=" + Code // NOI18N
              + ", AbbrevToUse=" + AbbrevToUse // NOI18N
              + super.toString(); // NOI18N
  }
}
