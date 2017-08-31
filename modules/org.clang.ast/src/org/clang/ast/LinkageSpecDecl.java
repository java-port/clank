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
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;
import org.clang.ast.DeclContext.*;


/// \brief Represents a linkage specification. 
///
/// For example:
/// \code
///   extern "C" void foo();
/// \endcode
//<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2523,
 FQN="clang::LinkageSpecDecl", NM="_ZN5clang15LinkageSpecDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDeclE")
//</editor-fold>
public class LinkageSpecDecl extends /*public*/ Decl implements /*public*/ DeclContext, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2023,
   FQN="clang::LinkageSpecDecl::anchor", NM="_ZN5clang15LinkageSpecDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  /// \brief Represents the language in a linkage specification.
  ///
  /// The values are part of the serialization ABI for
  /// ASTs and cannot be changed without altering that ABI.  To help
  /// ensure a stable ABI for this, we choose the DW_LANG_ encodings
  /// from the dwarf standard.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::LanguageIDs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2532,
   FQN="clang::LinkageSpecDecl::LanguageIDs", NM="_ZN5clang15LinkageSpecDecl11LanguageIDsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl11LanguageIDsE")
  //</editor-fold>
  public static final class/*enum*/ LanguageIDs {
    public static final /*uint*/int lang_c = /* DW_LANG_C */ 0x0002;
    public static final /*uint*/int lang_cxx = /* DW_LANG_C_plus_plus */ 0x0004;
  };
/*private:*/
  /// \brief The language for this linkage specification.
  private /*JBYTE unsigned int*/ byte Language /*: 3*/;
  /// \brief True if this linkage spec has braces.
  ///
  /// This is needed so that hasBraces() returns the correct result while the
  /// linkage spec body is being parsed.  Once RBraceLoc has been set this is
  /// not used, so it doesn't need to be serialized.
  private /*JBIT unsigned int*/ boolean HasBraces /*: 1*/;
  /// \brief The source location for the extern keyword.
  private SourceLocation ExternLoc;
  /// \brief The source location for the right brace (if valid).
  private SourceLocation RBraceLoc;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::LinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2550,
   FQN="clang::LinkageSpecDecl::LinkageSpecDecl", NM="_ZN5clang15LinkageSpecDeclC1EPNS_11DeclContextENS_14SourceLocationES3_NS0_11LanguageIDsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDeclC1EPNS_11DeclContextENS_14SourceLocationES3_NS0_11LanguageIDsEb")
  //</editor-fold>
  private LinkageSpecDecl(DeclContext /*P*/ DC, SourceLocation ExternLoc, 
      SourceLocation LangLoc, /*LanguageIDs*//*uint*/int lang, boolean HasBraces) {
    // : Decl(LinkageSpec, DC, LangLoc), DeclContext(LinkageSpec), Language(lang), HasBraces(HasBraces), ExternLoc(ExternLoc), RBraceLoc(SourceLocation()) 
    //START JInit
    super(Kind.LinkageSpec, DC, new SourceLocation(LangLoc));
    this.DeclContext$Flds = $DeclContext(Kind.LinkageSpec);
    this.Language = $uint2uint_3bits(lang);
    this.HasBraces = HasBraces;
    this.ExternLoc = new SourceLocation(ExternLoc);
    this.RBraceLoc = new SourceLocation();
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2025,
   FQN="clang::LinkageSpecDecl::Create", NM="_ZN5clang15LinkageSpecDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS0_11LanguageIDsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl6CreateERNS_10ASTContextEPNS_11DeclContextENS_14SourceLocationES5_NS0_11LanguageIDsEb")
  //</editor-fold>
  public static LinkageSpecDecl /*P*/ Create(final ASTContext /*&*/ C, 
        DeclContext /*P*/ DC, 
        SourceLocation ExternLoc, 
        SourceLocation LangLoc, 
        /*LanguageIDs*//*uint*/int Lang, 
        boolean HasBraces) {
    return /*NEW_EXPR [Decl::new]*//*new (C, DC)*/ Decl.$new(C, DC, (type$ptr<?> New$Mem)->{
        return new LinkageSpecDecl(DC, new SourceLocation(ExternLoc), new SourceLocation(LangLoc), Lang, HasBraces);
     });
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2034,
   FQN="clang::LinkageSpecDecl::CreateDeserialized", NM="_ZN5clang15LinkageSpecDecl18CreateDeserializedERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl18CreateDeserializedERNS_10ASTContextEj")
  //</editor-fold>
  public static LinkageSpecDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, 
                    /*uint*/int ID) {
    return /*NEW_EXPR [Decl::new]*//*new (C, ID)*/ Decl.$new(C, ID, (type$ptr<?> New$Mem)->{
        return new LinkageSpecDecl((DeclContext /*P*/ )null, new SourceLocation(), 
                new SourceLocation(), LanguageIDs.lang_c, false);
     });
  }

  
  /// \brief Return the language specified by this linkage specification.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::getLanguage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2564,
   FQN="clang::LinkageSpecDecl::getLanguage", NM="_ZNK5clang15LinkageSpecDecl11getLanguageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15LinkageSpecDecl11getLanguageEv")
  //</editor-fold>
  public /*LanguageIDs*//*uint*/int getLanguage() /*const*/ {
    return ((/*LanguageIDs*//*uint*/int)(Language));
  }

  /// \brief Set the language specified by this linkage specification.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::setLanguage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2566,
   FQN="clang::LinkageSpecDecl::setLanguage", NM="_ZN5clang15LinkageSpecDecl11setLanguageENS0_11LanguageIDsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl11setLanguageENS0_11LanguageIDsE")
  //</editor-fold>
  public void setLanguage(/*LanguageIDs*//*uint*/int L) {
    Language = $uint2uint_3bits(L);
  }

  
  /// \brief Determines whether this linkage specification had braces in
  /// its syntactic form.
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::hasBraces">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2570,
   FQN="clang::LinkageSpecDecl::hasBraces", NM="_ZNK5clang15LinkageSpecDecl9hasBracesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15LinkageSpecDecl9hasBracesEv")
  //</editor-fold>
  public boolean hasBraces() /*const*/ {
    assert (!RBraceLoc.isValid() || HasBraces);
    return HasBraces;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::getExternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2575,
   FQN="clang::LinkageSpecDecl::getExternLoc", NM="_ZNK5clang15LinkageSpecDecl12getExternLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15LinkageSpecDecl12getExternLocEv")
  //</editor-fold>
  public SourceLocation getExternLoc() /*const*/ {
    return new SourceLocation(ExternLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::getRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2576,
   FQN="clang::LinkageSpecDecl::getRBraceLoc", NM="_ZNK5clang15LinkageSpecDecl12getRBraceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15LinkageSpecDecl12getRBraceLocEv")
  //</editor-fold>
  public SourceLocation getRBraceLoc() /*const*/ {
    return new SourceLocation(RBraceLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::setExternLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2577,
   FQN="clang::LinkageSpecDecl::setExternLoc", NM="_ZN5clang15LinkageSpecDecl12setExternLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl12setExternLocENS_14SourceLocationE")
  //</editor-fold>
  public void setExternLoc(SourceLocation L) {
    ExternLoc.$assign(L);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::setRBraceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2578,
   FQN="clang::LinkageSpecDecl::setRBraceLoc", NM="_ZN5clang15LinkageSpecDecl12setRBraceLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl12setRBraceLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRBraceLoc(SourceLocation L) {
    RBraceLoc.$assign(L);
    HasBraces = RBraceLoc.isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2583,
   FQN="clang::LinkageSpecDecl::getLocEnd", NM="_ZNK5clang15LinkageSpecDecl9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15LinkageSpecDecl9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (hasBraces()) {
      return getRBraceLoc();
    }
    // No braces: get the end location of the (only) declaration in context
    // (if present).
    return decls_empty() ? getLocation() : decls_begin().$arrow().getLocEnd();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2591,
   FQN="clang::LinkageSpecDecl::getSourceRange", NM="_ZNK5clang15LinkageSpecDecl14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZNK5clang15LinkageSpecDecl14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* __attribute__((pure)) override*/ {
    return new SourceRange(/*NO_COPY*/ExternLoc, getLocEnd());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2595,
   FQN="clang::LinkageSpecDecl::classof", NM="_ZN5clang15LinkageSpecDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2596,
   FQN="clang::LinkageSpecDecl::classofKind", NM="_ZN5clang15LinkageSpecDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.LinkageSpec;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::castToDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2597,
   FQN="clang::LinkageSpecDecl::castToDeclContext", NM="_ZN5clang15LinkageSpecDecl17castToDeclContextEPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl17castToDeclContextEPKS0_")
  //</editor-fold>
  public static DeclContext /*P*/ castToDeclContext(/*const*/ LinkageSpecDecl /*P*/ D) {
    return ((/*static_cast*/DeclContext /*P*/ )(((/*const_cast*/LinkageSpecDecl /*P*/ )(D))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::castFromDeclContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2600,
   FQN="clang::LinkageSpecDecl::castFromDeclContext", NM="_ZN5clang15LinkageSpecDecl19castFromDeclContextEPKNS_11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDecl19castFromDeclContextEPKNS_11DeclContextE")
  //</editor-fold>
  public static LinkageSpecDecl /*P*/ castFromDeclContext(/*const*/ DeclContext /*P*/ DC) {
    return ((/*static_cast*/LinkageSpecDecl /*P*/ )(((/*const_cast*/DeclContext /*P*/ )(DC))));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LinkageSpecDecl::~LinkageSpecDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclCXX.h", line = 2523,
   FQN="clang::LinkageSpecDecl::~LinkageSpecDecl", NM="_ZN5clang15LinkageSpecDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clang15LinkageSpecDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    DeclContext.super.$destroy$DeclContext();
  }

  
  private final DeclContext$Fields DeclContext$Flds;// use return value of $DeclContext();
  @Override public final DeclContext$Fields $DeclContext$Fields() { return DeclContext$Flds; }
  
  @Override public String toString() {
    return "" + "Language=" + $uchar2uint(Language) // NOI18N
              + ", HasBraces=" + HasBraces // NOI18N
              + ", ExternLoc=" + ExternLoc // NOI18N
              + ", RBraceLoc=" + RBraceLoc // NOI18N
              + super.toString(); // NOI18N
  }
}
