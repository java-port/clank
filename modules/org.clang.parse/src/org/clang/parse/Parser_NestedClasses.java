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
package org.clang.parse;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import org.clang.parse.*;
import static org.clang.parse.Parser.*;
import static org.clang.sema.SemaClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type Parser_NestedClasses">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType -split-class=clang::Parser@this -extends=Parser_NestedEnums ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser10ParseScopeE;_ZN5clang6Parser11LexedMethodE;_ZN5clang6Parser12ForRangeInitE;_ZN5clang6Parser12ParsingClassE;_ZN5clang6Parser15LateParsedClassE;_ZN5clang6Parser15ParseScopeFlagsE;_ZN5clang6Parser17IfExistsConditionE;_ZN5clang6Parser18DeclaratorScopeObjE;_ZN5clang6Parser18LateParsedAttrListE;_ZN5clang6Parser18ParsedTemplateInfoE;_ZN5clang6Parser19LateParsedAttributeE;_ZN5clang6Parser19OpenMPVarListDataTyE;_ZN5clang6Parser21LateParsedDeclarationE;_ZN5clang6Parser21ObjCDeclContextSwitchE;_ZN5clang6Parser22ObjCTypeParamListScopeE;_ZN5clang6Parser22ParsingClassDefinitionE;_ZN5clang6Parser22TentativeParsingActionE;_ZN5clang6Parser23ObjCImplParsingDataRAIIE;_ZN5clang6Parser25LateParsedDefaultArgumentE;_ZN5clang6Parser25ParsedAttributesWithRangeE;_ZN5clang6Parser26TemplateParameterDepthRAIIE;_ZN5clang6Parser27LateParsedMemberInitializerE;_ZN5clang6Parser27LateParsedMethodDeclarationE;_ZN5clang6Parser31RevertingTentativeParsingActionE;_ZN5clang6Parser33UnannotatedTentativeParsingActionE;_ZN5clang6Parser40ConditionDeclarationOrInitStatementStateE; -static-type=Parser_NestedClasses -package=org.clang.parse")
//</editor-fold>
public class Parser_NestedClasses extends Parser_NestedEnums {
private final /*split clang::Parser*/ Parser $this() { return (Parser)this; }


/// \brief RAII class that manages the template parameter depth.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TemplateParameterDepthRAII">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 204,
   FQN="clang::Parser::TemplateParameterDepthRAII", NM="_ZN5clang6Parser26TemplateParameterDepthRAIIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26TemplateParameterDepthRAIIE")
  //</editor-fold>
  protected /*private*/ static class TemplateParameterDepthRAII implements Destructors.ClassWithDestructor {
    private final uint$ref/*uint &*/ Depth;
    private /*uint*/int AddedLevels;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TemplateParameterDepthRAII::TemplateParameterDepthRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 208,
     FQN="clang::Parser::TemplateParameterDepthRAII::TemplateParameterDepthRAII", NM="_ZN5clang6Parser26TemplateParameterDepthRAIIC1ERj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26TemplateParameterDepthRAIIC1ERj")
    //</editor-fold>
    public /*explicit*/ TemplateParameterDepthRAII(final uint$ref/*uint &*/ Depth) {
      // : Depth(Depth), AddedLevels(0) 
      //START JInit
      this./*&*/Depth=/*&*/Depth;
      this.AddedLevels = 0;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TemplateParameterDepthRAII::~TemplateParameterDepthRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 211,
     FQN="clang::Parser::TemplateParameterDepthRAII::~TemplateParameterDepthRAII", NM="_ZN5clang6Parser26TemplateParameterDepthRAIID0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26TemplateParameterDepthRAIID0Ev")
    //</editor-fold>
    public void $destroy() {
      Depth.$set$minusassign(AddedLevels);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TemplateParameterDepthRAII::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 215,
     FQN="clang::Parser::TemplateParameterDepthRAII::operator++", NM="_ZN5clang6Parser26TemplateParameterDepthRAIIppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26TemplateParameterDepthRAIIppEv")
    //</editor-fold>
    public void $preInc() {
      Depth.$set$preInc();
      ++AddedLevels;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TemplateParameterDepthRAII::addDepth">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 219,
     FQN="clang::Parser::TemplateParameterDepthRAII::addDepth", NM="_ZN5clang6Parser26TemplateParameterDepthRAII8addDepthEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser26TemplateParameterDepthRAII8addDepthEj")
    //</editor-fold>
    public void addDepth(/*uint*/int D) {
      Depth.$set$addassign(D);
      AddedLevels += D;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TemplateParameterDepthRAII::getDepth">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 223,
     FQN="clang::Parser::TemplateParameterDepthRAII::getDepth", NM="_ZNK5clang6Parser26TemplateParameterDepthRAII8getDepthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser26TemplateParameterDepthRAII8getDepthEv")
    //</editor-fold>
    public /*uint*/int getDepth() /*const*/ {
      return Depth.$deref();
    }

    
    @Override public String toString() {
      return "" + "Depth=" + Depth // NOI18N
                + ", AddedLevels=" + AddedLevels; // NOI18N
    }
  }

/// TentativeParsingAction - An object that is used as a kind of "tentative
/// parsing transaction". It gets instantiated to mark the token position and
/// after the token consumption is done, Commit() or Revert() is called to
/// either "commit the consumed tokens" or revert to the previously marked
/// token position. Example:
///
///   TentativeParsingAction TPA(*this);
///   ConsumeToken();
///   ....
///   TPA.Revert();
///
//<editor-fold defaultstate="collapsed" desc="clang::Parser::TentativeParsingAction">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 679,
   FQN="clang::Parser::TentativeParsingAction", NM="_ZN5clang6Parser22TentativeParsingActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22TentativeParsingActionE")
  //</editor-fold>
  protected /*private*/ static class TentativeParsingAction implements Destructors.ClassWithDestructor {
    private final Parser /*&*/ P;
    private Token PrevTok;
    private /*size_t*/int PrevTentativelyDeclaredIdentifierCount;
    private /*ushort*/char PrevParenCount;
    private /*ushort*/char PrevBracketCount;
    private /*ushort*/char PrevBraceCount;
    private boolean isActive;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TentativeParsingAction::TentativeParsingAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 687,
     FQN="clang::Parser::TentativeParsingAction::TentativeParsingAction", NM="_ZN5clang6Parser22TentativeParsingActionC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22TentativeParsingActionC1ERS0_")
    //</editor-fold>
    public /*explicit*/ TentativeParsingAction(final Parser /*&*/ p) {
      // : P(p), PrevTok() 
      //START JInit
      this./*&*/P=/*&*/p;
      this.PrevTok = new Token();
      //END JInit
      PrevTok.$assign(P.Tok);
      PrevTentativelyDeclaredIdentifierCount
         = P.TentativelyDeclaredIdentifiers.size();
      PrevParenCount = P.ParenCount;
      PrevBracketCount = P.BracketCount;
      PrevBraceCount = P.BraceCount;
      P.PP.EnableBacktrackAtThisPos();
      isActive = true;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TentativeParsingAction::Commit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 697,
     FQN="clang::Parser::TentativeParsingAction::Commit", NM="_ZN5clang6Parser22TentativeParsingAction6CommitEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22TentativeParsingAction6CommitEv")
    //</editor-fold>
    public void Commit() {
      assert (isActive) : "Parsing action was finished!";
      P.TentativelyDeclaredIdentifiers.resize(PrevTentativelyDeclaredIdentifierCount);
      P.PP.CommitBacktrackedTokens();
      isActive = false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TentativeParsingAction::Revert">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 704,
     FQN="clang::Parser::TentativeParsingAction::Revert", NM="_ZN5clang6Parser22TentativeParsingAction6RevertEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22TentativeParsingAction6RevertEv")
    //</editor-fold>
    public void Revert() {
      assert (isActive) : "Parsing action was finished!";
      P.PP.Backtrack();
      P.Tok.$assign(PrevTok);
      P.TentativelyDeclaredIdentifiers.resize(PrevTentativelyDeclaredIdentifierCount);
      P.ParenCount = PrevParenCount;
      P.BracketCount = PrevBracketCount;
      P.BraceCount = PrevBraceCount;
      isActive = false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::TentativeParsingAction::~TentativeParsingAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 715,
     FQN="clang::Parser::TentativeParsingAction::~TentativeParsingAction", NM="_ZN5clang6Parser22TentativeParsingActionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22TentativeParsingActionD0Ev")
    //</editor-fold>
    public void $destroy() {
      assert (!isActive) : "Forgot to call Commit or Revert!";
    }

    
    @Override public String toString() {
      return "" + "P=" + "[Parser]" // NOI18N
                + ", PrevTok=" + PrevTok // NOI18N
                + ", PrevTentativelyDeclaredIdentifierCount=" + PrevTentativelyDeclaredIdentifierCount // NOI18N
                + ", PrevParenCount=" + $ushort2uint(PrevParenCount) // NOI18N
                + ", PrevBracketCount=" + $ushort2uint(PrevBracketCount) // NOI18N
                + ", PrevBraceCount=" + $ushort2uint(PrevBraceCount) // NOI18N
                + ", isActive=" + isActive; // NOI18N
    }
  }
/// A TentativeParsingAction that automatically reverts in its destructor.
/// Useful for disambiguation parses that will always be reverted.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::RevertingTentativeParsingAction">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 721,
   FQN="clang::Parser::RevertingTentativeParsingAction", NM="_ZN5clang6Parser31RevertingTentativeParsingActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser31RevertingTentativeParsingActionE")
  //</editor-fold>
  protected /*private*/ static class RevertingTentativeParsingAction extends /*private*/ Parser.TentativeParsingAction implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::RevertingTentativeParsingAction::RevertingTentativeParsingAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 724,
     FQN="clang::Parser::RevertingTentativeParsingAction::RevertingTentativeParsingAction", NM="_ZN5clang6Parser31RevertingTentativeParsingActionC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser31RevertingTentativeParsingActionC1ERS0_")
    //</editor-fold>
    public RevertingTentativeParsingAction(final Parser /*&*/ P) {
      // : Parser::TentativeParsingAction(P) 
      //START JInit
      super(P);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::RevertingTentativeParsingAction::~RevertingTentativeParsingAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 726,
     FQN="clang::Parser::RevertingTentativeParsingAction::~RevertingTentativeParsingAction", NM="_ZN5clang6Parser31RevertingTentativeParsingActionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser31RevertingTentativeParsingActionD0Ev")
    //</editor-fold>
    public void $destroy() {
      Revert();
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  }

/// \brief A tentative parsing action that can also revert token annotations.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::UnannotatedTentativeParsingAction">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 965,
   FQN="clang::Parser::UnannotatedTentativeParsingAction", NM="_ZN5clang6Parser33UnannotatedTentativeParsingActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser33UnannotatedTentativeParsingActionE")
  //</editor-fold>
  protected /*private*/ static class UnannotatedTentativeParsingAction extends /*public*/ TentativeParsingAction implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::UnannotatedTentativeParsingAction::UnannotatedTentativeParsingAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 967,
     FQN="clang::Parser::UnannotatedTentativeParsingAction::UnannotatedTentativeParsingAction", NM="_ZN5clang6Parser33UnannotatedTentativeParsingActionC1ERS0_NS_3tok9TokenKindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser33UnannotatedTentativeParsingActionC1ERS0_NS_3tok9TokenKindE")
    //</editor-fold>
    public /*explicit*/ UnannotatedTentativeParsingAction(final Parser /*&*/ Self, 
        /*tok.TokenKind*/char EndKind) {
      // : TentativeParsingAction(Self), Self(Self), Toks(), EndKind(EndKind) 
      //START JInit
      super(Self);
      this./*&*/Self=/*&*/Self;
      this.Toks = new SmallVectorToken(4, /*new Token()*/(Token)null);
      this.EndKind = EndKind;
      //END JInit
      TentativeParsingAction Inner = null;
      try {
        // Stash away the old token stream, so we can restore it once the
        // tentative parse is complete.
        Inner/*J*/= new TentativeParsingAction(Self);
        Self.ConsumeAndStoreUntil(EndKind, Toks, true, /*ConsumeFinalToken*/ false);
        Inner.Revert();
      } finally {
        if (Inner != null) { Inner.$destroy(); }
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::UnannotatedTentativeParsingAction::RevertAnnotations">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*std::copy*/,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 977,
     FQN="clang::Parser::UnannotatedTentativeParsingAction::RevertAnnotations", NM="_ZN5clang6Parser33UnannotatedTentativeParsingAction17RevertAnnotationsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser33UnannotatedTentativeParsingAction17RevertAnnotationsEv")
    //</editor-fold>
    public void RevertAnnotations() {
      Revert();
      
      // Put back the original tokens.
      Self.SkipUntil(EndKind, $bitor_SkipUntilFlags(/*KEEP_ENUM*/SkipUntilFlags.StopAtSemi, /*KEEP_ENUM*/SkipUntilFlags.StopBeforeMatch));
      if ((Toks.size() != 0)) {
        unique_ptr_array<Token> Buffer = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Buffer = llvm.make_unique(new$T(new Token [Toks.size()], ()->new Token()));
          std.copy(Toks.begin().$add(1), Toks.end(), create_type$ptr(Buffer.get()), false);
          Buffer.$at(Toks.size() - 1).$assign(Self.Tok);
          Self.PP.EnterTokenStream($c$.track(new unique_ptr_array<Token>(JD$Move.INSTANCE, std.move(Buffer))), Toks.size(), true); $c$.clean();
          
          Self.Tok.$assign(Toks.front());
        } finally {
          if (Buffer != null) { Buffer.$destroy(); }
          $c$.$destroy();
        }
      }
    }

  /*private:*/
    private final Parser /*&*/ Self;
    private SmallVectorToken Toks;
    private /*tok.TokenKind*/char EndKind;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::UnannotatedTentativeParsingAction::~UnannotatedTentativeParsingAction">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 965,
     FQN="clang::Parser::UnannotatedTentativeParsingAction::~UnannotatedTentativeParsingAction", NM="_ZN5clang6Parser33UnannotatedTentativeParsingActionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser33UnannotatedTentativeParsingActionD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Toks.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]" // NOI18N
                + ", Toks=" + Toks // NOI18N
                + ", EndKind=" + $ushort2uint(EndKind) // NOI18N
                + super.toString(); // NOI18N
    }
  }

/// ObjCDeclContextSwitch - An object used to switch context from
/// an objective-c decl context to its enclosing decl context and
/// back.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCDeclContextSwitch">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 734,
   FQN="clang::Parser::ObjCDeclContextSwitch", NM="_ZN5clang6Parser21ObjCDeclContextSwitchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21ObjCDeclContextSwitchE")
  //</editor-fold>
  protected /*private*/ static class ObjCDeclContextSwitch implements Destructors.ClassWithDestructor {
    private final Parser /*&*/ P;
    private Decl /*P*/ DC;
    private SaveAndRestoreBool WithinObjCContainer;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCDeclContextSwitch::ObjCDeclContextSwitch">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 739,
     FQN="clang::Parser::ObjCDeclContextSwitch::ObjCDeclContextSwitch", NM="_ZN5clang6Parser21ObjCDeclContextSwitchC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21ObjCDeclContextSwitchC1ERS0_")
    //</editor-fold>
    public /*explicit*/ ObjCDeclContextSwitch(final Parser /*&*/ p) {
      // : P(p), DC(p.getObjCDeclContext()), WithinObjCContainer(P.ParsingInObjCContainer, DC != null) 
      //START JInit
      this./*&*/P=/*&*/p;
      this.DC = p.getObjCDeclContext();
      this.WithinObjCContainer = new SaveAndRestoreBool(P.ParsingInObjCContainer$Ref, DC != (Decl /*P*/ )null);
      //END JInit
      if ((DC != null)) {
        P.Actions.ActOnObjCTemporaryExitContainerContext(cast(DeclContext.class, DC));
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCDeclContextSwitch::~ObjCDeclContextSwitch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 745,
     FQN="clang::Parser::ObjCDeclContextSwitch::~ObjCDeclContextSwitch", NM="_ZN5clang6Parser21ObjCDeclContextSwitchD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21ObjCDeclContextSwitchD0Ev")
    //</editor-fold>
    public void $destroy() {
      if ((DC != null)) {
        P.Actions.ActOnObjCReenterContainerContext(cast(DeclContext.class, DC));
      }
      //START JDestroy
      WithinObjCContainer.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "P=" + "[Parser]" // NOI18N
                + ", DC=" + DC // NOI18N
                + ", WithinObjCContainer=" + WithinObjCContainer; // NOI18N
    }
  }
//===--------------------------------------------------------------------===//
// Scope manipulation

/// ParseScope - Introduces a new scope for parsing. The kind of
/// scope is determined by ScopeFlags. Objects of this type should
/// be created on the stack to coincide with the position where the
/// parser enters the new scope, and this object's constructor will
/// create that new scope. Similarly, once the object is destroyed
/// the parser will exit the scope.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScope">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 791,
   FQN="clang::Parser::ParseScope", NM="_ZN5clang6Parser10ParseScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10ParseScopeE")
  //</editor-fold>
  public static class ParseScope implements Destructors.ClassWithDestructor {
    private Parser /*P*/ Self;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScope::ParseScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 793,
     FQN="clang::Parser::ParseScope::ParseScope", NM="_ZN5clang6Parser10ParseScopeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10ParseScopeC1ERKS1_")
    //</editor-fold>
    protected /*private*/ ParseScope(final /*const*/ ParseScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScope::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 794,
     FQN="clang::Parser::ParseScope::operator=", NM="_ZN5clang6Parser10ParseScopeaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10ParseScopeaSERKS1_")
    //</editor-fold>
    protected /*private*/ void $assign(final /*const*/ ParseScope /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    // ParseScope - Construct a new object to manage a scope in the
    // parser Self where the new Scope is created with the flags
    // ScopeFlags, but only when we aren't about to enter a compound statement.
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScope::ParseScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 800,
     FQN="clang::Parser::ParseScope::ParseScope", NM="_ZN5clang6Parser10ParseScopeC1EPS0_jbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10ParseScopeC1EPS0_jbb")
    //</editor-fold>
    public ParseScope(Parser /*P*/ Self, /*uint*/int ScopeFlags) {
      this(Self, ScopeFlags, true, 
        false);
    }
    public ParseScope(Parser /*P*/ Self, /*uint*/int ScopeFlags, boolean EnteredScope/*= true*/) {
      this(Self, ScopeFlags, EnteredScope, 
        false);
    }
    public ParseScope(Parser /*P*/ Self, /*uint*/int ScopeFlags, boolean EnteredScope/*= true*/, 
        boolean BeforeCompoundStmt/*= false*/) {
      // : Self(Self) 
      //START JInit
      this.Self = Self;
      //END JInit
      if (EnteredScope && !BeforeCompoundStmt) {
        Self.EnterScope(ScopeFlags);
      } else {
        if (BeforeCompoundStmt) {
          Self.incrementMSManglingNumber();
        }
        
        this.Self = null;
      }
    }

    
    // Exit - Exit the scope associated with this object now, rather
    // than waiting until the object is destroyed.
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScope::Exit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 815,
     FQN="clang::Parser::ParseScope::Exit", NM="_ZN5clang6Parser10ParseScope4ExitEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10ParseScope4ExitEv")
    //</editor-fold>
    public void Exit() {
      if ((Self != null)) {
        Self.ExitScope();
        Self = null;
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScope::~ParseScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 822,
     FQN="clang::Parser::ParseScope::~ParseScope", NM="_ZN5clang6Parser10ParseScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser10ParseScopeD0Ev")
    //</editor-fold>
    public void $destroy() {
      Exit();
    }

    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]"; // NOI18N
    }
  }
/// \brief RAII object used to modify the scope flags for the current scope.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScopeFlags">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 835,
   FQN="clang::Parser::ParseScopeFlags", NM="_ZN5clang6Parser15ParseScopeFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15ParseScopeFlagsE")
  //</editor-fold>
  protected /*private*/ static class ParseScopeFlags implements Destructors.ClassWithDestructor {
    private Scope /*P*/ CurScope;
    private /*uint*/int OldFlags;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScopeFlags::ParseScopeFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 838,
     FQN="clang::Parser::ParseScopeFlags::ParseScopeFlags", NM="_ZN5clang6Parser15ParseScopeFlagsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15ParseScopeFlagsC1ERKS1_")
    //</editor-fold>
    protected /*private*/ ParseScopeFlags(final /*const*/ ParseScopeFlags /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScopeFlags::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 839,
     FQN="clang::Parser::ParseScopeFlags::operator=", NM="_ZN5clang6Parser15ParseScopeFlagsaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15ParseScopeFlagsaSERKS1_")
    //</editor-fold>
    protected /*private*/ void $assign(final /*const*/ ParseScopeFlags /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  /*public:*/
    
    /// Set the flags for the current scope to ScopeFlags. If ManageFlags is false,
    /// this object does nothing.
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScopeFlags::ParseScopeFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 402,
     FQN="clang::Parser::ParseScopeFlags::ParseScopeFlags", NM="_ZN5clang6Parser15ParseScopeFlagsC1EPS0_jb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser15ParseScopeFlagsC1EPS0_jb")
    //</editor-fold>
    public ParseScopeFlags(Parser /*P*/ Self, /*uint*/int ScopeFlags) {
      this(Self, ScopeFlags, 
        true);
    }
    public ParseScopeFlags(Parser /*P*/ Self, /*uint*/int ScopeFlags, 
        boolean ManageFlags/*= true*/) {
      // : CurScope(ManageFlags ? Self->getCurScope() : null) 
      //START JInit
      this.CurScope = ManageFlags ? Self.getCurScope() : null;
      //END JInit
      if ((CurScope != null)) {
        OldFlags = CurScope.getFlags();
        CurScope.setFlags(ScopeFlags);
      }
    }


    
    /// Restore the flags for the current scope to what they were before this
    /// object overrode them.
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseScopeFlags::~ParseScopeFlags">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp", line = 413,
     FQN="clang::Parser::ParseScopeFlags::~ParseScopeFlags", NM="_ZN5clang6Parser15ParseScopeFlagsD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp -nm=_ZN5clang6Parser15ParseScopeFlagsD0Ev")
    //</editor-fold>
    public void $destroy() {
      if ((CurScope != null)) {
        CurScope.setFlags(OldFlags);
      }
    }


    
    @Override public String toString() {
      return "" + "CurScope=" + CurScope // NOI18N
                + ", OldFlags=" + OldFlags; // NOI18N
    }
  }
//===--------------------------------------------------------------------===//
// Lexing and parsing of C++ inline methods.

/// \brief Representation of a class that has been parsed, including
/// any member function declarations or definitions that need to be
/// parsed after the corresponding top-level class is complete.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClass">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1081,
   FQN="clang::Parser::ParsingClass", NM="_ZN5clang6Parser12ParsingClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ParsingClassE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ParsingClass implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClass::ParsingClass">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1082,
     FQN="clang::Parser::ParsingClass::ParsingClass", NM="_ZN5clang6Parser12ParsingClassC1EPNS_4DeclEbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ParsingClassC1EPNS_4DeclEbb")
    //</editor-fold>
    public ParsingClass(Decl /*P*/ TagOrTemplate, boolean TopLevelClass, boolean IsInterface) {
      // : TopLevelClass(TopLevelClass), TemplateScope(false), IsInterface(IsInterface), TagOrTemplate(TagOrTemplate), LateParsedDeclarations() 
      //START JInit
      this.TopLevelClass = TopLevelClass;
      this.TemplateScope = false;
      this.IsInterface = IsInterface;
      this.TagOrTemplate = TagOrTemplate;
      this.LateParsedDeclarations = new SmallVector<LateParsedDeclaration /*P*/>(2, null);
      //END JInit
    }

    
    /// \brief Whether this is a "top-level" class, meaning that it is
    /// not nested within another class.
    public /*JBIT bool*/ boolean TopLevelClass /*: 1*/;
    
    /// \brief Whether this class had an associated template
    /// scope. When true, TagOrTemplate is a template declaration;
    /// othewise, it is a tag declaration.
    public /*JBIT bool*/ boolean TemplateScope /*: 1*/;
    
    /// \brief Whether this class is an __interface.
    public /*JBIT bool*/ boolean IsInterface /*: 1*/;
    
    /// \brief The class or class template whose definition we are parsing.
    public Decl /*P*/ TagOrTemplate;
    
    /// LateParsedDeclarations - Method declarations, inline definitions and
    /// nested classes that contain pieces whose parsing will be delayed until
    /// the top-level class is fully defined.
    public SmallVector<LateParsedDeclaration /*P*/> LateParsedDeclarations;

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClass::~ParsingClass">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1081,
     FQN="clang::Parser::ParsingClass::~ParsingClass", NM="_ZN5clang6Parser12ParsingClassD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser12ParsingClassD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      LateParsedDeclarations.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "TopLevelClass=" + TopLevelClass // NOI18N
                + ", TemplateScope=" + TemplateScope // NOI18N
                + ", IsInterface=" + IsInterface // NOI18N
                + ", TagOrTemplate=" + TagOrTemplate // NOI18N
                + ", LateParsedDeclarations=" + LateParsedDeclarations; // NOI18N
    }
  }

/// [class.mem]p1: "... the class is regarded as complete within
/// - function bodies
/// - default arguments
/// - exception-specifications (TODO: C++0x)
/// - and brace-or-equal-initializers for non-static data members
/// (including such things in nested classes)."
/// LateParsedDeclarations build the tree of those elements so they can
/// be parsed after parsing the top-level class.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 920,
   FQN="clang::Parser::LateParsedDeclaration", NM="_ZN5clang6Parser21LateParsedDeclarationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21LateParsedDeclarationE")
  //</editor-fold>
  protected /*private*/ static class LateParsedDeclaration implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration::~LateParsedDeclaration">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 234,
     FQN="clang::Parser::LateParsedDeclaration::~LateParsedDeclaration", NM="_ZN5clang6Parser21LateParsedDeclarationD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21LateParsedDeclarationD0Ev")
    //</editor-fold>
    public void $destroy() {
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration::ParseLexedMethodDeclarations">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 235,
     FQN="clang::Parser::LateParsedDeclaration::ParseLexedMethodDeclarations", NM="_ZN5clang6Parser21LateParsedDeclaration28ParseLexedMethodDeclarationsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21LateParsedDeclaration28ParseLexedMethodDeclarationsEv")
    //</editor-fold>
    public void ParseLexedMethodDeclarations() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration::ParseLexedMemberInitializers">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 236,
     FQN="clang::Parser::LateParsedDeclaration::ParseLexedMemberInitializers", NM="_ZN5clang6Parser21LateParsedDeclaration28ParseLexedMemberInitializersEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21LateParsedDeclaration28ParseLexedMemberInitializersEv")
    //</editor-fold>
    public void ParseLexedMemberInitializers() {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration::ParseLexedMethodDefs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 237,
     FQN="clang::Parser::LateParsedDeclaration::ParseLexedMethodDefs", NM="_ZN5clang6Parser21LateParsedDeclaration20ParseLexedMethodDefsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21LateParsedDeclaration20ParseLexedMethodDefsEv")
    //</editor-fold>
    public void ParseLexedMethodDefs() {
    }

    
    // Late Parsed Attributes:
    // See other examples of late parsing in lib/Parse/ParseCXXInlineMethods
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration::ParseLexedAttributes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1146,
     FQN="clang::Parser::LateParsedDeclaration::ParseLexedAttributes", NM="_ZN5clang6Parser21LateParsedDeclaration20ParseLexedAttributesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser21LateParsedDeclaration20ParseLexedAttributesEv")
    //</editor-fold>
    public void ParseLexedAttributes() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDeclaration::LateParsedDeclaration">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 920,
     FQN="clang::Parser::LateParsedDeclaration::LateParsedDeclaration", NM="_ZN5clang6Parser21LateParsedDeclarationC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser21LateParsedDeclarationC1Ev")
    //</editor-fold>
    public /*inline*/ LateParsedDeclaration() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  }

/// Inner node of the LateParsedDeclaration tree that parses
/// all its members recursively.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 932,
   FQN="clang::Parser::LateParsedClass", NM="_ZN5clang6Parser15LateParsedClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15LateParsedClassE")
  //</editor-fold>
  protected /*private*/ static class LateParsedClass extends /*public*/ LateParsedDeclaration implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass::LateParsedClass">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 239,
     FQN="clang::Parser::LateParsedClass::LateParsedClass", NM="_ZN5clang6Parser15LateParsedClassC1EPS0_PNS0_12ParsingClassE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15LateParsedClassC1EPS0_PNS0_12ParsingClassE")
    //</editor-fold>
    public LateParsedClass(Parser /*P*/ P, ParsingClass /*P*/ C) {
      // : LateParsedDeclaration(), Self(P), Class(C) 
      //START JInit
      super();
      this.Self = P;
      this.Class = C;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass::~LateParsedClass">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 242,
     FQN="clang::Parser::LateParsedClass::~LateParsedClass", NM="_ZN5clang6Parser15LateParsedClassD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15LateParsedClassD0Ev")
    //</editor-fold>
    @Override public void $destroy()/* override*/ {
      Self.DeallocateParsedClasses(Class);
      super.$destroy();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass::ParseLexedMethodDeclarations">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 246,
     FQN="clang::Parser::LateParsedClass::ParseLexedMethodDeclarations", NM="_ZN5clang6Parser15LateParsedClass28ParseLexedMethodDeclarationsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15LateParsedClass28ParseLexedMethodDeclarationsEv")
    //</editor-fold>
    @Override public void ParseLexedMethodDeclarations()/* override*/ {
      Self.ParseLexedMethodDeclarations($Deref(Class));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass::ParseLexedMemberInitializers">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 250,
     FQN="clang::Parser::LateParsedClass::ParseLexedMemberInitializers", NM="_ZN5clang6Parser15LateParsedClass28ParseLexedMemberInitializersEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15LateParsedClass28ParseLexedMemberInitializersEv")
    //</editor-fold>
    @Override public void ParseLexedMemberInitializers()/* override*/ {
      Self.ParseLexedMemberInitializers($Deref(Class));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass::ParseLexedMethodDefs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 254,
     FQN="clang::Parser::LateParsedClass::ParseLexedMethodDefs", NM="_ZN5clang6Parser15LateParsedClass20ParseLexedMethodDefsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser15LateParsedClass20ParseLexedMethodDefsEv")
    //</editor-fold>
    @Override public void ParseLexedMethodDefs()/* override*/ {
      Self.ParseLexedMethodDefs($Deref(Class));
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedClass::ParseLexedAttributes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1148,
     FQN="clang::Parser::LateParsedClass::ParseLexedAttributes", NM="_ZN5clang6Parser15LateParsedClass20ParseLexedAttributesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser15LateParsedClass20ParseLexedAttributesEv")
    //</editor-fold>
    @Override public void ParseLexedAttributes()/* override*/ {
      Self.ParseLexedAttributes($Deref(Class));
    }


  /*private:*/
    private Parser /*P*/ Self;
    private ParsingClass /*P*/ Class;
    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]" // NOI18N
                + ", Class=" + Class // NOI18N
                + super.toString(); // NOI18N
    }
  }

/// Contains the lexed tokens of an attribute with arguments that
/// may reference member variables and so need to be parsed at the
/// end of the class declaration after parsing all other member
/// member declarations.
/// FIXME: Perhaps we should change the name of LateParsedDeclaration to
/// LateParsedTokens.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttribute">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 953,
   FQN="clang::Parser::LateParsedAttribute", NM="_ZN5clang6Parser19LateParsedAttributeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser19LateParsedAttributeE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ LateParsedAttribute extends /*public*/ LateParsedDeclaration implements Destructors.ClassWithDestructor {
    public Parser /*P*/ Self;
    public SmallVectorToken Toks;
    public final IdentifierInfo /*&*/ AttrName;
    public SourceLocation AttrNameLoc;
    public SmallVector<Decl /*P*/> Decls;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttribute::LateParsedAttribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 960,
     FQN="clang::Parser::LateParsedAttribute::LateParsedAttribute", NM="_ZN5clang6Parser19LateParsedAttributeC1EPS0_RNS_14IdentifierInfoENS_14SourceLocationE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser19LateParsedAttributeC1EPS0_RNS_14IdentifierInfoENS_14SourceLocationE")
    //</editor-fold>
    public /*explicit*/ LateParsedAttribute(Parser /*P*/ P, final IdentifierInfo /*&*/ Name, 
        SourceLocation Loc) {
      // : LateParsedDeclaration(), Self(P), Toks(), AttrName(Name), AttrNameLoc(Loc), Decls() 
      //START JInit
      super();
      this.Self = P;
      this.Toks = new SmallVectorToken(4, /*new Token()*/(Token)null);
      this./*&*/AttrName=/*&*/Name;
      this.AttrNameLoc = new SourceLocation(Loc);
      this.Decls = new SmallVector<Decl /*P*/>(2, null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttribute::ParseLexedAttributes">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp", line = 1152,
     FQN="clang::Parser::LateParsedAttribute::ParseLexedAttributes", NM="_ZN5clang6Parser19LateParsedAttribute20ParseLexedAttributesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser19LateParsedAttribute20ParseLexedAttributesEv")
    //</editor-fold>
    @Override public void ParseLexedAttributes()/* override*/ {
      Self.ParseLexedAttribute(/*Deref*/this, true, false);
    }


    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttribute::addDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 966,
     FQN="clang::Parser::LateParsedAttribute::addDecl", NM="_ZN5clang6Parser19LateParsedAttribute7addDeclEPNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser19LateParsedAttribute7addDeclEPNS_4DeclE")
    //</editor-fold>
    public void addDecl(Decl /*P*/ D) {
      Decls.push_back(D);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttribute::~LateParsedAttribute">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 953,
     FQN="clang::Parser::LateParsedAttribute::~LateParsedAttribute", NM="_ZN5clang6Parser19LateParsedAttributeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser19LateParsedAttributeD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      Decls.$destroy();
      Toks.$destroy();
      super.$destroy();
      //END JDestroy
    }


    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]" // NOI18N
                + ", Toks=" + Toks // NOI18N
                + ", AttrName=" + AttrName // NOI18N
                + ", AttrNameLoc=" + AttrNameLoc // NOI18N
                + ", Decls=" + Decls // NOI18N
                + super.toString(); // NOI18N
    }
  }

// A list of late-parsed attributes.  Used by ParseGNUAttributes.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttrList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*comment destroy*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 970,
   FQN="clang::Parser::LateParsedAttrList", NM="_ZN5clang6Parser18LateParsedAttrListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18LateParsedAttrListE")
  //</editor-fold>
  protected /*private*/ static final class LateParsedAttrList extends /*public*/ SmallVector<LateParsedAttribute /*P*/> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttrList::LateParsedAttrList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 972,
     FQN="clang::Parser::LateParsedAttrList::LateParsedAttrList", NM="_ZN5clang6Parser18LateParsedAttrListC1Eb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18LateParsedAttrListC1Eb")
    //</editor-fold>
    public LateParsedAttrList() {
      this(false);
    }
    public LateParsedAttrList(boolean PSoon/*= false*/) {
      // : SmallVector<LateParsedAttribute * , 2>(), ParseSoon(PSoon) 
      //START JInit
      super(2, null);
      this.ParseSoon = PSoon;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttrList::parseSoon">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 974,
     FQN="clang::Parser::LateParsedAttrList::parseSoon", NM="_ZN5clang6Parser18LateParsedAttrList9parseSoonEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18LateParsedAttrList9parseSoonEv")
    //</editor-fold>
    public boolean parseSoon() {
      return ParseSoon;
    }

  /*private:*/
    private boolean ParseSoon; // Are we planning to parse these shortly after creation?

//    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedAttrList::~LateParsedAttrList">
//    @Converted(kind = Converted.Kind.AUTO,
//     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 970,
//     FQN="clang::Parser::LateParsedAttrList::~LateParsedAttrList", NM="_ZN5clang6Parser18LateParsedAttrListD0Ev",
//     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser18LateParsedAttrListD0Ev")
//    //</editor-fold>
//    public /*inline*/ void $destroy() {
//      super.$destroy();
//    }

    
    @Override public String toString() {
      return "" + "ParseSoon=" + ParseSoon // NOI18N
                + super.toString(); // NOI18N
    }
  }

/// Contains the lexed tokens of a member function definition
/// which needs to be parsed at the end of the class declaration
/// after parsing all other member declarations.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LexedMethod">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 983,
   FQN="clang::Parser::LexedMethod", NM="_ZN5clang6Parser11LexedMethodE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser11LexedMethodE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ LexedMethod extends /*public*/ LateParsedDeclaration implements Destructors.ClassWithDestructor {
    public Parser /*P*/ Self;
    public Decl /*P*/ D;
    public SmallVectorToken Toks;
    
    /// \brief Whether this member function had an associated template
    /// scope. When true, D is a template declaration.
    /// otherwise, it is a member function declaration.
    public boolean TemplateScope;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LexedMethod::LexedMethod">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 993,
     FQN="clang::Parser::LexedMethod::LexedMethod", NM="_ZN5clang6Parser11LexedMethodC1EPS0_PNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser11LexedMethodC1EPS0_PNS_4DeclE")
    //</editor-fold>
    public /*explicit*/ LexedMethod(Parser /*P*/ P, Decl /*P*/ MD) {
      // : LateParsedDeclaration(), Self(P), D(MD), Toks(), TemplateScope(false) 
      //START JInit
      super();
      this.Self = P;
      this.D = MD;
      this.Toks = new SmallVectorToken(4, /*new Token()*/(Token)null);
      this.TemplateScope = false;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LexedMethod::ParseLexedMethodDefs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 262,
     FQN="clang::Parser::LexedMethod::ParseLexedMethodDefs", NM="_ZN5clang6Parser11LexedMethod20ParseLexedMethodDefsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser11LexedMethod20ParseLexedMethodDefsEv")
    //</editor-fold>
    @Override public void ParseLexedMethodDefs()/* override*/ {
      Self.ParseLexedMethodDef(/*Deref*/this);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LexedMethod::~LexedMethod">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 983,
     FQN="clang::Parser::LexedMethod::~LexedMethod", NM="_ZN5clang6Parser11LexedMethodD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser11LexedMethodD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      Toks.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]" // NOI18N
                + ", D=" + D // NOI18N
                + ", Toks=" + Toks // NOI18N
                + ", TemplateScope=" + TemplateScope // NOI18N
                + super.toString(); // NOI18N
    }
  }

/// LateParsedDefaultArgument - Keeps track of a parameter that may
/// have a default argument that cannot be parsed yet because it
/// occurs within a member function declaration inside the class
/// (C++ [class.mem]p2).
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDefaultArgument">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1003,
   FQN="clang::Parser::LateParsedDefaultArgument", NM="_ZN5clang6Parser25LateParsedDefaultArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25LateParsedDefaultArgumentE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ LateParsedDefaultArgument implements NativePOD<LateParsedDefaultArgument> {
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDefaultArgument::LateParsedDefaultArgument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1004,
     FQN="clang::Parser::LateParsedDefaultArgument::LateParsedDefaultArgument", NM="_ZN5clang6Parser25LateParsedDefaultArgumentC1EPNS_4DeclEPN4llvm11SmallVectorINS_5TokenELj4EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25LateParsedDefaultArgumentC1EPNS_4DeclEPN4llvm11SmallVectorINS_5TokenELj4EEE")
    //</editor-fold>
    public /*explicit*/ LateParsedDefaultArgument(Decl /*P*/ P) {
      this(P, 
        (SmallVectorToken /*P*/)null);
    }
    public /*explicit*/ LateParsedDefaultArgument(Decl /*P*/ P, 
        SmallVectorToken /*P*/ Toks/*= null*/) {
      // : Param(P), Toks(Toks) 
      //START JInit
      this.Param = P;
      this.Toks = Toks;
      //END JInit
    }

    public LateParsedDefaultArgument() {
    }

    public LateParsedDefaultArgument(final LateParsedDefaultArgument Other) {
      this.Param = Other.Param;
      this.Toks = Other.Toks;
    }

    @Override
    public LateParsedDefaultArgument clone() {
      return new LateParsedDefaultArgument(this);
    }

    @Override
    public LateParsedDefaultArgument $assign(LateParsedDefaultArgument value) {
      this.Param = value.Param;
      this.Toks = value.Toks;
      return this;
    }

    
    /// Param - The parameter declaration for this parameter.
    public Decl /*P*/ Param;
    
    /// Toks - The sequence of tokens that comprises the default
    /// argument expression, not including the '=' or the terminating
    /// ')' or ','. This will be NULL for parameters that have no
    /// default argument.
    public SmallVectorToken /*P*/ Toks;

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedDefaultArgument::~LateParsedDefaultArgument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1003,
     FQN="clang::Parser::LateParsedDefaultArgument::~LateParsedDefaultArgument", NM="_ZN5clang6Parser25LateParsedDefaultArgumentD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser25LateParsedDefaultArgumentD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    @Override public String toString() {
      return "" + "Param=" + Param // NOI18N
                + ", Toks=" + Toks; // NOI18N
    }
  }

/// LateParsedMethodDeclaration - A method declaration inside a class that
/// contains at least one entity whose parsing needs to be delayed
/// until the class itself is completely-defined, such as a default
/// argument (C++ [class.mem]p2).
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMethodDeclaration">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1022,
   FQN="clang::Parser::LateParsedMethodDeclaration", NM="_ZN5clang6Parser27LateParsedMethodDeclarationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMethodDeclarationE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ LateParsedMethodDeclaration extends /*public*/ LateParsedDeclaration implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMethodDeclaration::LateParsedMethodDeclaration">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1023,
     FQN="clang::Parser::LateParsedMethodDeclaration::LateParsedMethodDeclaration", NM="_ZN5clang6Parser27LateParsedMethodDeclarationC1EPS0_PNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMethodDeclarationC1EPS0_PNS_4DeclE")
    //</editor-fold>
    public /*explicit*/ LateParsedMethodDeclaration(Parser /*P*/ P, Decl /*P*/ M) {
      // : LateParsedDeclaration(), Self(P), Method(M), TemplateScope(false), DefaultArgs(), ExceptionSpecTokens(null) 
      //START JInit
      super();
      this.Self = P;
      this.Method = M;
      this.TemplateScope = false;
      this.DefaultArgs = new SmallVector<LateParsedDefaultArgument>(8, new LateParsedDefaultArgument());
      this.ExceptionSpecTokens = null;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMethodDeclaration::ParseLexedMethodDeclarations">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 258,
     FQN="clang::Parser::LateParsedMethodDeclaration::ParseLexedMethodDeclarations", NM="_ZN5clang6Parser27LateParsedMethodDeclaration28ParseLexedMethodDeclarationsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMethodDeclaration28ParseLexedMethodDeclarationsEv")
    //</editor-fold>
    @Override public void ParseLexedMethodDeclarations()/* override*/ {
      Self.ParseLexedMethodDeclaration(/*Deref*/this);
    }

    
    public Parser /*P*/ Self;
    
    /// Method - The method declaration.
    public Decl /*P*/ Method;
    
    /// \brief Whether this member function had an associated template
    /// scope. When true, D is a template declaration.
    /// othewise, it is a member function declaration.
    public boolean TemplateScope;
    
    /// DefaultArgs - Contains the parameters of the function and
    /// their default arguments. At least one of the parameters will
    /// have a default argument, but all of the parameters of the
    /// method will be stored so that they can be reintroduced into
    /// scope at the appropriate times.
    public SmallVector<LateParsedDefaultArgument> DefaultArgs;
    
    /// \brief The set of tokens that make up an exception-specification that
    /// has not yet been parsed.
    public SmallVectorToken /*P*/ ExceptionSpecTokens;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMethodDeclaration::~LateParsedMethodDeclaration">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1022,
     FQN="clang::Parser::LateParsedMethodDeclaration::~LateParsedMethodDeclaration", NM="_ZN5clang6Parser27LateParsedMethodDeclarationD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMethodDeclarationD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      DefaultArgs.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]" // NOI18N
                + ", Method=" + Method // NOI18N
                + ", TemplateScope=" + TemplateScope // NOI18N
                + ", DefaultArgs=" + DefaultArgs // NOI18N
                + ", ExceptionSpecTokens=" + ExceptionSpecTokens // NOI18N
                + super.toString(); // NOI18N
    }
  }

/// LateParsedMemberInitializer - An initializer for a non-static class data
/// member whose parsing must to be delayed until the class is completely
/// defined (C++11 [class.mem]p2).
//<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMemberInitializer">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1054,
   FQN="clang::Parser::LateParsedMemberInitializer", NM="_ZN5clang6Parser27LateParsedMemberInitializerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMemberInitializerE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ LateParsedMemberInitializer extends /*public*/ LateParsedDeclaration implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMemberInitializer::LateParsedMemberInitializer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1055,
     FQN="clang::Parser::LateParsedMemberInitializer::LateParsedMemberInitializer", NM="_ZN5clang6Parser27LateParsedMemberInitializerC1EPS0_PNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMemberInitializerC1EPS0_PNS_4DeclE")
    //</editor-fold>
    public LateParsedMemberInitializer(Parser /*P*/ P, Decl /*P*/ FD) {
      // : LateParsedDeclaration(), Self(P), Field(FD), Toks() 
      //START JInit
      super();
      this.Self = P;
      this.Field = FD;
      this.Toks = new SmallVectorToken(4, /*new Token()*/(Token)null);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMemberInitializer::ParseLexedMemberInitializers">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp", line = 266,
     FQN="clang::Parser::LateParsedMemberInitializer::ParseLexedMemberInitializers", NM="_ZN5clang6Parser27LateParsedMemberInitializer28ParseLexedMemberInitializersEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMemberInitializer28ParseLexedMemberInitializersEv")
    //</editor-fold>
    @Override public void ParseLexedMemberInitializers()/* override*/ {
      Self.ParseLexedMemberInitializer(/*Deref*/this);
    }

    
    public Parser /*P*/ Self;
    
    /// Field - The field declaration.
    public Decl /*P*/ Field;
    
    /// CachedTokens - The sequence of tokens that comprises the initializer,
    /// including any leading '='.
    public SmallVectorToken Toks;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::LateParsedMemberInitializer::~LateParsedMemberInitializer">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1054,
     FQN="clang::Parser::LateParsedMemberInitializer::~LateParsedMemberInitializer", NM="_ZN5clang6Parser27LateParsedMemberInitializerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser27LateParsedMemberInitializerD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      //START JDestroy
      Toks.$destroy();
      super.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Self=" + "[Parser]" // NOI18N
                + ", Field=" + Field // NOI18N
                + ", Toks=" + Toks // NOI18N
                + super.toString(); // NOI18N
    }
  }

/// \brief RAII object used to manage the parsing of a class definition.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClassDefinition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1118,
   FQN="clang::Parser::ParsingClassDefinition", NM="_ZN5clang6Parser22ParsingClassDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22ParsingClassDefinitionE")
  //</editor-fold>
  protected /*private*/ static class ParsingClassDefinition implements Destructors.ClassWithDestructor {
    private final Parser /*&*/ P;
    private boolean Popped;
    private Sema.DelayedDiagnosticsState State;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClassDefinition::ParsingClassDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1124,
     FQN="clang::Parser::ParsingClassDefinition::ParsingClassDefinition", NM="_ZN5clang6Parser22ParsingClassDefinitionC1ERS0_PNS_4DeclEbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22ParsingClassDefinitionC1ERS0_PNS_4DeclEbb")
    //</editor-fold>
    public ParsingClassDefinition(final Parser /*&*/ P, Decl /*P*/ TagOrTemplate, boolean TopLevelClass, 
        boolean IsInterface) {
      // : P(P), Popped(false), State(P.PushParsingClass(TagOrTemplate, TopLevelClass, IsInterface)) 
      //START JInit
      this./*&*/P=/*&*/P;
      this.Popped = false;
      this.State = P.PushParsingClass(TagOrTemplate, TopLevelClass, IsInterface);
      //END JInit
    }

    
    /// \brief Pop this class of the stack.
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClassDefinition::Pop">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1131,
     FQN="clang::Parser::ParsingClassDefinition::Pop", NM="_ZN5clang6Parser22ParsingClassDefinition3PopEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22ParsingClassDefinition3PopEv")
    //</editor-fold>
    public void Pop() {
      assert (!Popped) : "Nested class has already been popped";
      Popped = true;
      P.PopParsingClass(new Sema.DelayedDiagnosticsState(State));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsingClassDefinition::~ParsingClassDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1137,
     FQN="clang::Parser::ParsingClassDefinition::~ParsingClassDefinition", NM="_ZN5clang6Parser22ParsingClassDefinitionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser22ParsingClassDefinitionD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (!Popped) {
        P.PopParsingClass(new Sema.DelayedDiagnosticsState(State));
      }
    }

    
    @Override public String toString() {
      return "" + "P=" + "[Parser]" // NOI18N
                + ", Popped=" + Popped // NOI18N
                + ", State=" + State; // NOI18N
    }
  }

/// \brief Contains information about any template-specific
/// information that has been parsed prior to parsing declaration
/// specifiers.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1146,
   FQN="clang::Parser::ParsedTemplateInfo", NM="_ZN5clang6Parser18ParsedTemplateInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ParsedTemplateInfoE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ParsedTemplateInfo {
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo::ParsedTemplateInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1147,
     FQN="clang::Parser::ParsedTemplateInfo::ParsedTemplateInfo", NM="_ZN5clang6Parser18ParsedTemplateInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ParsedTemplateInfoC1Ev")
    //</editor-fold>
    public ParsedTemplateInfo() {
      // : Kind(NonTemplate), TemplateParams(null), ExternLoc(), TemplateLoc() 
      //START JInit
      this.Kind = Unnamed_enum.NonTemplate;
      this.TemplateParams = null;
      this.ExternLoc = new SourceLocation();
      this.TemplateLoc = new SourceLocation();
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo::ParsedTemplateInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1150,
     FQN="clang::Parser::ParsedTemplateInfo::ParsedTemplateInfo", NM="_ZN5clang6Parser18ParsedTemplateInfoC1EPN4llvm11SmallVectorIPNS_21TemplateParameterListELj4EEEbb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ParsedTemplateInfoC1EPN4llvm11SmallVectorIPNS_21TemplateParameterListELj4EEEbb")
    //</editor-fold>
    public ParsedTemplateInfo(SmallVector<TemplateParameterList /*P*/> /*P*/ TemplateParams, 
        boolean isSpecialization) {
      this(TemplateParams, 
        isSpecialization, 
        false);
    }
    public ParsedTemplateInfo(SmallVector<TemplateParameterList /*P*/> /*P*/ TemplateParams, 
        boolean isSpecialization, 
        boolean lastParameterListWasEmpty/*= false*/) {
      // : Kind(isSpecialization ? ExplicitSpecialization : Template), TemplateParams(TemplateParams), ExternLoc(), TemplateLoc(), LastParameterListWasEmpty(lastParameterListWasEmpty) 
      //START JInit
      this.Kind = isSpecialization ? Unnamed_enum.ExplicitSpecialization : Unnamed_enum.Template;
      this.TemplateParams = TemplateParams;
      this.ExternLoc = new SourceLocation();
      this.TemplateLoc = new SourceLocation();
      this.LastParameterListWasEmpty = lastParameterListWasEmpty;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo::ParsedTemplateInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1157,
     FQN="clang::Parser::ParsedTemplateInfo::ParsedTemplateInfo", NM="_ZN5clang6Parser18ParsedTemplateInfoC1ENS_14SourceLocationES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ParsedTemplateInfoC1ENS_14SourceLocationES2_")
    //</editor-fold>
    public /*explicit*/ ParsedTemplateInfo(SourceLocation ExternLoc, 
        SourceLocation TemplateLoc) {
      // : Kind(ExplicitInstantiation), TemplateParams(null), ExternLoc(ExternLoc), TemplateLoc(TemplateLoc), LastParameterListWasEmpty(false) 
      //START JInit
      this.Kind = Unnamed_enum.ExplicitInstantiation;
      this.TemplateParams = null;
      this.ExternLoc = new SourceLocation(ExternLoc);
      this.TemplateLoc = new SourceLocation(TemplateLoc);
      this.LastParameterListWasEmpty = false;
      //END JInit
    }

    
    /// \brief The kind of template we are parsing.
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo::(anonymous)">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1164,
     FQN="clang::Parser::ParsedTemplateInfo::(anonymous)", NM="_ZN5clang6Parser18ParsedTemplateInfoE_Unnamed_enum",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18ParsedTemplateInfoE_Unnamed_enum")
    //</editor-fold>
    public enum Unnamed_enum implements Native.ComparableLower {
      /// \brief We are not parsing a template at all.
      NonTemplate(0),
      /// \brief We are parsing a template declaration.
      Template(NonTemplate.getValue() + 1),
      /// \brief We are parsing an explicit specialization.
      ExplicitSpecialization(Template.getValue() + 1),
      /// \brief We are parsing an explicit instantiation.
      ExplicitInstantiation(ExplicitSpecialization.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Unnamed_enum valueOf(int val) {
        Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      protected /*private*/ static final class Values {
        private static final Unnamed_enum[] VALUES;
        private static final Unnamed_enum[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
          VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
          for (Unnamed_enum kind : Unnamed_enum.values()) {
            if (kind.value < 0) {
              _VALUES[-kind.value] = kind;
            } else {
              VALUES[kind.value] = kind;
            }
          }
        }
      }

      private final /*uint*/int value;
      private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
      //</editor-fold>
    };
    public Unnamed_enum Kind;
    
    /// \brief The template parameter lists, for template declarations
    /// and explicit specializations.
    public SmallVector<TemplateParameterList /*P*/> /*P*/ TemplateParams;
    
    /// \brief The location of the 'extern' keyword, if any, for an explicit
    /// instantiation
    public SourceLocation ExternLoc;
    
    /// \brief The location of the 'template' keyword, for an explicit
    /// instantiation.
    public SourceLocation TemplateLoc;
    
    /// \brief Whether the last template parameter list was empty.
    public boolean LastParameterListWasEmpty;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo::getSourceRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp", line = 1315,
     FQN="clang::Parser::ParsedTemplateInfo::getSourceRange", NM="_ZNK5clang6Parser18ParsedTemplateInfo14getSourceRangeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZNK5clang6Parser18ParsedTemplateInfo14getSourceRangeEv")
    //</editor-fold>
    public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
      if ((TemplateParams != null)) {
        return getTemplateParamsRange(TemplateParams.data(), 
            TemplateParams.size());
      }
      
      SourceRange R/*J*/= new SourceRange(/*NO_COPY*/TemplateLoc);
      if (ExternLoc.isValid()) {
        R.setBegin(/*NO_COPY*/ExternLoc);
      }
      return R;
    }



    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedTemplateInfo::~ParsedTemplateInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1146,
     FQN="clang::Parser::ParsedTemplateInfo::~ParsedTemplateInfo", NM="_ZN5clang6Parser18ParsedTemplateInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang6Parser18ParsedTemplateInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    @Override public String toString() {
      return "" + "Kind=" + Kind // NOI18N
                + ", TemplateParams=" + TemplateParams // NOI18N
                + ", ExternLoc=" + ExternLoc // NOI18N
                + ", TemplateLoc=" + TemplateLoc // NOI18N
                + ", LastParameterListWasEmpty=" + LastParameterListWasEmpty; // NOI18N
    }
  }

//===--------------------------------------------------------------------===//
// C99 6.9: External Definitions.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedAttributesWithRange">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1244,
   FQN="clang::Parser::ParsedAttributesWithRange", NM="_ZN5clang6Parser25ParsedAttributesWithRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25ParsedAttributesWithRangeE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ParsedAttributesWithRange extends /**/ ParsedAttributes implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedAttributesWithRange::ParsedAttributesWithRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1245,
     FQN="clang::Parser::ParsedAttributesWithRange::ParsedAttributesWithRange", NM="_ZN5clang6Parser25ParsedAttributesWithRangeC1ERNS_16AttributeFactoryE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25ParsedAttributesWithRangeC1ERNS_16AttributeFactoryE")
    //</editor-fold>
    public ParsedAttributesWithRange(final AttributeFactory /*&*/ factory) {
      // : ParsedAttributes(factory), Range() 
      //START JInit
      super(factory);
      this.Range = new SourceRange();
      //END JInit
    }

    
    public SourceRange Range;
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParsedAttributesWithRange::~ParsedAttributesWithRange">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1244,
     FQN="clang::Parser::ParsedAttributesWithRange::~ParsedAttributesWithRange", NM="_ZN5clang6Parser25ParsedAttributesWithRangeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser25ParsedAttributesWithRangeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      super.$destroy();
    }

    
    @Override public String toString() {
      return "" + "Range=" + Range // NOI18N
                + super.toString(); // NOI18N
    }
  }


/// Class to handle popping type parameters when leaving the scope.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCTypeParamListScope">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 99,
   FQN="clang::Parser::ObjCTypeParamListScope", NM="_ZN5clang6Parser22ObjCTypeParamListScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ObjCTypeParamListScopeE")
  //</editor-fold>
  protected /*private*/ static class ObjCTypeParamListScope implements Destructors.ClassWithDestructor {
    private final Sema /*&*/ Actions;
    private Scope /*P*/ S;
    private ObjCTypeParamList /*P*/ Params;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCTypeParamListScope::ObjCTypeParamListScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 105,
     FQN="clang::Parser::ObjCTypeParamListScope::ObjCTypeParamListScope", NM="_ZN5clang6Parser22ObjCTypeParamListScopeC1ERNS_4SemaEPNS_5ScopeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ObjCTypeParamListScopeC1ERNS_4SemaEPNS_5ScopeE")
    //</editor-fold>
    public ObjCTypeParamListScope(final Sema /*&*/ Actions, Scope /*P*/ S) {
      // : Actions(Actions), S(S), Params(null) 
      //START JInit
      this./*&*/Actions=/*&*/Actions;
      this.S = S;
      this.Params = null;
      //END JInit
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCTypeParamListScope::~ObjCTypeParamListScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 108,
     FQN="clang::Parser::ObjCTypeParamListScope::~ObjCTypeParamListScope", NM="_ZN5clang6Parser22ObjCTypeParamListScopeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ObjCTypeParamListScopeD0Ev")
    //</editor-fold>
    public void $destroy() {
      leave();
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCTypeParamListScope::enter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 112,
     FQN="clang::Parser::ObjCTypeParamListScope::enter", NM="_ZN5clang6Parser22ObjCTypeParamListScope5enterEPNS_17ObjCTypeParamListE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ObjCTypeParamListScope5enterEPNS_17ObjCTypeParamListE")
    //</editor-fold>
    public void enter(ObjCTypeParamList /*P*/ P) {
      assert (!(Params != null));
      Params = P;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCTypeParamListScope::leave">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 117,
     FQN="clang::Parser::ObjCTypeParamListScope::leave", NM="_ZN5clang6Parser22ObjCTypeParamListScope5leaveEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser22ObjCTypeParamListScope5leaveEv")
    //</editor-fold>
    public void leave() {
      if ((Params != null)) {
        Actions.popObjCTypeParamList(S, Params);
      }
      Params = null;
    }
  
    
    @Override public String toString() {
      return "" + "Actions=" + "[Sema]" // NOI18N
                + ", S=" + S // NOI18N
                + ", Params=" + Params; // NOI18N
    }
  }
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCImplParsingDataRAII">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1345,
   FQN="clang::Parser::ObjCImplParsingDataRAII", NM="_ZN5clang6Parser23ObjCImplParsingDataRAIIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser23ObjCImplParsingDataRAIIE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ObjCImplParsingDataRAII implements Destructors.ClassWithDestructor {
    public final Parser /*&*/ P;
    public Decl /*P*/ Dcl;
    public boolean HasCFunction;
    /*typedef SmallVector<LexedMethod *, 8> LateParsedObjCMethodContainer*/
//    public final class LateParsedObjCMethodContainer extends SmallVector<LexedMethod /*P*/>{ };
    public SmallVector<LexedMethod /*P*/> LateParsedObjCMethods;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCImplParsingDataRAII::ObjCImplParsingDataRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1352,
     FQN="clang::Parser::ObjCImplParsingDataRAII::ObjCImplParsingDataRAII", NM="_ZN5clang6Parser23ObjCImplParsingDataRAIIC1ERS0_PNS_4DeclE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser23ObjCImplParsingDataRAIIC1ERS0_PNS_4DeclE")
    //</editor-fold>
    public ObjCImplParsingDataRAII(final Parser /*&*/ parser, Decl /*P*/ D) {
      // : P(parser), Dcl(D), HasCFunction(false), LateParsedObjCMethods() 
      //START JInit
      this./*&*/P=/*&*/parser;
      this.Dcl = D;
      this.HasCFunction = false;
      this.LateParsedObjCMethods = new SmallVector<LexedMethod /*P*/>(8, null);
      //END JInit
      P.CurParsedObjCImpl = this;
      Finished = false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCImplParsingDataRAII::~ObjCImplParsingDataRAII">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2265,
     FQN="clang::Parser::ObjCImplParsingDataRAII::~ObjCImplParsingDataRAII", NM="_ZN5clang6Parser23ObjCImplParsingDataRAIID0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser23ObjCImplParsingDataRAIID0Ev")
    //</editor-fold>
    public void $destroy() {
      if (!Finished) {
        finish(new SourceRange(P.Tok.getLocation()));
        if (P.isEofOrEom()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track(P.Diag(P.Tok, diag.err_objc_missing_end)), 
                FixItHint.CreateInsertion(P.Tok.getLocation(), new StringRef(/*KEEP_STR*/"\n@end\n"))));
            $c$.clean($out_DiagnosticBuilder$C_int($c$.track(P.Diag(Dcl.getLocStart(), diag.note_objc_container_start)), 
                Sema.ObjCContainerKind.OCK_Implementation.getValue()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      P.CurParsedObjCImpl = null;
      assert (LateParsedObjCMethods.empty());
      //START JDestroy
      LateParsedObjCMethods.$destroy();
      //END JDestroy
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCImplParsingDataRAII::finish">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 2279,
     FQN="clang::Parser::ObjCImplParsingDataRAII::finish", NM="_ZN5clang6Parser23ObjCImplParsingDataRAII6finishENS_11SourceRangeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZN5clang6Parser23ObjCImplParsingDataRAII6finishENS_11SourceRangeE")
    //</editor-fold>
    public void finish(SourceRange AtEnd) {
      assert (!Finished);
      P.Actions.DefaultSynthesizeProperties(P.getCurScope(), Dcl);
      for (/*size_t*/int i = 0; $less_uint(i, LateParsedObjCMethods.size()); ++i)  {
        P.ParseLexedObjCMethodDefs($Deref(LateParsedObjCMethods.$at(i)), 
            true/*Methods*/);
      }
      
      P.Actions.ActOnAtEnd(P.getCurScope(), new SourceRange(AtEnd));
      if (HasCFunction) {
        for (/*size_t*/int i = 0; $less_uint(i, LateParsedObjCMethods.size()); ++i)  {
          P.ParseLexedObjCMethodDefs($Deref(LateParsedObjCMethods.$at(i)), 
              false/*c-functions*/);
        }
      }
      
      /// \brief Clear and free the cached objc methods.
      for (type$ptr<LexedMethod /*P*/> I = $tryClone(LateParsedObjCMethods.begin()), 
          /*P*/ E = $tryClone(LateParsedObjCMethods.end()); $noteq_ptr(I, E); I.$preInc())  {
        if (I.$star() != null) { I.$star().$destroy();};
      }
      LateParsedObjCMethods.clear();
      
      Finished = true;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ObjCImplParsingDataRAII::isFinished">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1360,
     FQN="clang::Parser::ObjCImplParsingDataRAII::isFinished", NM="_ZNK5clang6Parser23ObjCImplParsingDataRAII10isFinishedEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZNK5clang6Parser23ObjCImplParsingDataRAII10isFinishedEv")
    //</editor-fold>
    public boolean isFinished() /*const*/ {
      return Finished;
    }

  /*private:*/
    private boolean Finished;
    
    @Override public String toString() {
      return "" + "P=" + "[Parser]" // NOI18N
                + ", Dcl=" + Dcl // NOI18N
                + ", HasCFunction=" + HasCFunction // NOI18N
                + ", LateParsedObjCMethods=" + LateParsedObjCMethods // NOI18N
                + ", Finished=" + Finished; // NOI18N
    }
  }

/// \brief Describes the condition of a Microsoft __if_exists or
/// __if_not_exists block.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::IfExistsCondition">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1729,
   FQN="clang::Parser::IfExistsCondition", NM="_ZN5clang6Parser17IfExistsConditionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser17IfExistsConditionE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ IfExistsCondition implements Destructors.ClassWithDestructor {
    /// \brief The location of the initial keyword.
    public SourceLocation KeywordLoc;
    /// \brief Whether this is an __if_exists block (rather than an
    /// __if_not_exists block).
    public boolean IsIfExists;
    
    /// \brief Nested-name-specifier preceding the name.
    public CXXScopeSpec SS;
    
    /// \brief The name we're looking for.
    public UnqualifiedId Name;
    
    /// \brief The behavior of this __if_exists or __if_not_exists block
    /// should.
    public IfExistsBehavior Behavior;

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::IfExistsCondition::IfExistsCondition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1729,
     FQN="clang::Parser::IfExistsCondition::IfExistsCondition", NM="_ZN5clang6Parser17IfExistsConditionC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser17IfExistsConditionC1Ev")
    //</editor-fold>
    public /*inline*/ IfExistsCondition() {
      // : KeywordLoc(), SS(), Name() 
      //START JInit
      this.KeywordLoc = new SourceLocation();
      this.SS = new CXXScopeSpec();
      this.Name = new UnqualifiedId();
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Parser::IfExistsCondition::~IfExistsCondition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1729,
     FQN="clang::Parser::IfExistsCondition::~IfExistsCondition", NM="_ZN5clang6Parser17IfExistsConditionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZN5clang6Parser17IfExistsConditionD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      SS.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "KeywordLoc=" + KeywordLoc // NOI18N
                + ", IsIfExists=" + IsIfExists // NOI18N
                + ", SS=" + SS // NOI18N
                + ", Name=" + Name // NOI18N
                + ", Behavior=" + Behavior; // NOI18N
    }
  }

/// Information on a C++0x for-range-initializer found while parsing a
/// declaration which turns out to be a for-range-declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::ForRangeInit">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1823,
   FQN="clang::Parser::ForRangeInit", NM="_ZN5clang6Parser12ForRangeInitE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ForRangeInitE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ForRangeInit {
    public SourceLocation ColonLoc;
    public ActionResultTTrue<Expr /*P*/ > RangeExpr;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ForRangeInit::ParsedForRangeDecl">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1827,
     FQN="clang::Parser::ForRangeInit::ParsedForRangeDecl", NM="_ZN5clang6Parser12ForRangeInit18ParsedForRangeDeclEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser12ForRangeInit18ParsedForRangeDeclEv")
    //</editor-fold>
    public boolean ParsedForRangeDecl() {
      return !ColonLoc.isInvalid();
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ForRangeInit::ForRangeInit">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 1823,
     FQN="clang::Parser::ForRangeInit::ForRangeInit", NM="_ZN5clang6Parser12ForRangeInitC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp -nm=_ZN5clang6Parser12ForRangeInitC1Ev")
    //</editor-fold>
    public /*inline*/ ForRangeInit() {
      // : ColonLoc(), RangeExpr() 
      //START JInit
      this.ColonLoc = new SourceLocation();
      this.RangeExpr = new ActionResultTTrue<Expr /*P*/ >();
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "ColonLoc=" + ColonLoc // NOI18N
                + ", RangeExpr=" + RangeExpr; // NOI18N
    }
  }

//<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionDeclarationOrInitStatementState">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 333,
   FQN="clang::Parser::ConditionDeclarationOrInitStatementState", NM="_ZN5clang6Parser40ConditionDeclarationOrInitStatementStateE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser40ConditionDeclarationOrInitStatementStateE")
  //</editor-fold>
  protected /*private*/ static class/*struct*/ ConditionDeclarationOrInitStatementState {
    public final Parser /*&*/ P;
    public boolean CanBeExpression/* = true*/;
    public boolean CanBeCondition/* = true*/;
    public boolean CanBeInitStatement;
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionDeclarationOrInitStatementState::ConditionDeclarationOrInitStatementState">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 339,
     FQN="clang::Parser::ConditionDeclarationOrInitStatementState::ConditionDeclarationOrInitStatementState", NM="_ZN5clang6Parser40ConditionDeclarationOrInitStatementStateC1ERS0_b",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser40ConditionDeclarationOrInitStatementStateC1ERS0_b")
    //</editor-fold>
    public ConditionDeclarationOrInitStatementState(final Parser /*&*/ P, boolean CanBeInitStatement) {
      // : P(P), CanBeExpression(true), CanBeCondition(true), CanBeInitStatement(CanBeInitStatement) 
      //START JInit
      this./*&*/P=/*&*/P;
      /*InClass*/this.CanBeExpression = true;
      /*InClass*/this.CanBeCondition = true;
      this.CanBeInitStatement = CanBeInitStatement;
      //END JInit
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionDeclarationOrInitStatementState::markNotExpression">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 342,
     FQN="clang::Parser::ConditionDeclarationOrInitStatementState::markNotExpression", NM="_ZN5clang6Parser40ConditionDeclarationOrInitStatementState17markNotExpressionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser40ConditionDeclarationOrInitStatementState17markNotExpressionEv")
    //</editor-fold>
    public void markNotExpression() {
      CanBeExpression = false;
      if (CanBeCondition && CanBeInitStatement) {
        RevertingTentativeParsingAction PA = null;
        try {
          // FIXME: Unify the parsing codepaths for condition variables and
          // simple-declarations so that we don't need to eagerly figure out which
          // kind we have here. (Just parse init-declarators until we reach a
          // semicolon or right paren.)
          PA/*J*/= new RevertingTentativeParsingAction(P);
          P.SkipUntil(tok.TokenKind.r_paren, tok.TokenKind.semi, SkipUntilFlags.StopBeforeMatch);
          if (P.Tok.isNot(tok.TokenKind.r_paren)) {
            CanBeCondition = false;
          }
          if (P.Tok.isNot(tok.TokenKind.semi)) {
            CanBeInitStatement = false;
          }
        } finally {
          if (PA != null) { PA.$destroy(); }
        }
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionDeclarationOrInitStatementState::markNotCondition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 359,
     FQN="clang::Parser::ConditionDeclarationOrInitStatementState::markNotCondition", NM="_ZN5clang6Parser40ConditionDeclarationOrInitStatementState16markNotConditionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser40ConditionDeclarationOrInitStatementState16markNotConditionEv")
    //</editor-fold>
    public boolean markNotCondition() {
      CanBeCondition = false;
      return !CanBeInitStatement || !CanBeExpression;
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionDeclarationOrInitStatementState::update">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 364,
     FQN="clang::Parser::ConditionDeclarationOrInitStatementState::update", NM="_ZN5clang6Parser40ConditionDeclarationOrInitStatementState6updateENS0_8TPResultE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZN5clang6Parser40ConditionDeclarationOrInitStatementState6updateENS0_8TPResultE")
    //</editor-fold>
    public boolean update(TPResult IsDecl) {
      switch (IsDecl) {
       case True:
        markNotExpression();
        return true;
       case False:
        CanBeCondition = CanBeInitStatement = false;
        return true;
       case Ambiguous:
        return false;
       case Error:
        CanBeExpression = CanBeCondition = CanBeInitStatement = false;
        return true;
      }
      throw new llvm_unreachable("unknown tentative parse result");
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::ConditionDeclarationOrInitStatementState::result">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp", line = 381,
     FQN="clang::Parser::ConditionDeclarationOrInitStatementState::result", NM="_ZNK5clang6Parser40ConditionDeclarationOrInitStatementState6resultEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp -nm=_ZNK5clang6Parser40ConditionDeclarationOrInitStatementState6resultEv")
    //</editor-fold>
    public ConditionOrInitStatement result() /*const*/ {
      assert (((CanBeExpression ? 1 : 0) + (CanBeCondition ? 1 : 0) + (CanBeInitStatement ? 1 : 0)) < 2) : "result called but not yet resolved";
      if (CanBeExpression) {
        return ConditionOrInitStatement.Expression;
      }
      if (CanBeCondition) {
        return ConditionOrInitStatement.ConditionDecl;
      }
      if (CanBeInitStatement) {
        return ConditionOrInitStatement.InitStmtDecl;
      }
      return ConditionOrInitStatement.Error;
    }
  
    
    @Override public String toString() {
      return "" + "P=" + "[Parser]" // NOI18N
                + ", CanBeExpression=" + CanBeExpression // NOI18N
                + ", CanBeCondition=" + CanBeCondition // NOI18N
                + ", CanBeInitStatement=" + CanBeInitStatement; // NOI18N
    }
  }

/// DeclaratorScopeObj - RAII object used in Parser::ParseDirectDeclarator to
/// enter a new C++ declarator scope and exit it when the function is
/// finished.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::DeclaratorScopeObj">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2300,
   FQN="clang::Parser::DeclaratorScopeObj", NM="_ZN5clang6Parser18DeclaratorScopeObjE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18DeclaratorScopeObjE")
  //</editor-fold>
  protected /*private*/ static class DeclaratorScopeObj implements Destructors.ClassWithDestructor {
    private final Parser /*&*/ P;
    private final CXXScopeSpec /*&*/ SS;
    private boolean EnteredScope;
    private boolean CreatedScope;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::DeclaratorScopeObj::DeclaratorScopeObj">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2306,
     FQN="clang::Parser::DeclaratorScopeObj::DeclaratorScopeObj", NM="_ZN5clang6Parser18DeclaratorScopeObjC1ERS0_RNS_12CXXScopeSpecE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18DeclaratorScopeObjC1ERS0_RNS_12CXXScopeSpecE")
    //</editor-fold>
    public DeclaratorScopeObj(final Parser /*&*/ p, final CXXScopeSpec /*&*/ ss) {
      // : P(p), SS(ss), EnteredScope(false), CreatedScope(false) 
      //START JInit
      this./*&*/P=/*&*/p;
      this./*&*/SS=/*&*/ss;
      this.EnteredScope = false;
      this.CreatedScope = false;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::DeclaratorScopeObj::EnterDeclaratorScope">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2309,
     FQN="clang::Parser::DeclaratorScopeObj::EnterDeclaratorScope", NM="_ZN5clang6Parser18DeclaratorScopeObj20EnterDeclaratorScopeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18DeclaratorScopeObj20EnterDeclaratorScopeEv")
    //</editor-fold>
    public void EnterDeclaratorScope() {
      assert (!EnteredScope) : "Already entered the scope!";
      assert (SS.isSet()) : "C++ scope was not set!";
      
      CreatedScope = true;
      P.EnterScope(0); // Not a decl scope.
      if (!P.Actions.ActOnCXXEnterDeclaratorScope(P.getCurScope(), SS)) {
        EnteredScope = true;
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Parser::DeclaratorScopeObj::~DeclaratorScopeObj">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2320,
     FQN="clang::Parser::DeclaratorScopeObj::~DeclaratorScopeObj", NM="_ZN5clang6Parser18DeclaratorScopeObjD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser18DeclaratorScopeObjD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (EnteredScope) {
        assert (SS.isSet()) : "C++ scope was cleared ?";
        P.Actions.ActOnCXXExitDeclaratorScope(P.getCurScope(), SS);
      }
      if (CreatedScope) {
        P.ExitScope();
      }
    }

    
    @Override public String toString() {
      return "" + "P=" + "[Parser]" // NOI18N
                + ", SS=" + SS // NOI18N
                + ", EnteredScope=" + EnteredScope // NOI18N
                + ", CreatedScope=" + CreatedScope; // NOI18N
    }
  }

/// Data used for parsing list of variables in OpenMP clauses.
//<editor-fold defaultstate="collapsed" desc="clang::Parser::OpenMPVarListDataTy">
@Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2559,
   FQN="clang::Parser::OpenMPVarListDataTy", NM="_ZN5clang6Parser19OpenMPVarListDataTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp -nm=_ZN5clang6Parser19OpenMPVarListDataTyE")
  //</editor-fold>
  public static class/*struct*/ OpenMPVarListDataTy implements Destructors.ClassWithDestructor {
    public Expr /*P*/ TailExpr/* = null*/;
    public SourceLocation ColonLoc;
    public CXXScopeSpec ReductionIdScopeSpec;
    public DeclarationNameInfo ReductionId;
    public OpenMPDependClauseKind DepKind/* = OMPC_DEPEND_unknown*/;
    public OpenMPLinearClauseKind LinKind/* = OMPC_LINEAR_val*/;
    public OpenMPMapClauseKind MapTypeModifier/* = OMPC_MAP_unknown*/;
    public OpenMPMapClauseKind MapType/* = OMPC_MAP_unknown*/;
    public boolean IsMapTypeImplicit/* = false*/;
    public SourceLocation DepLinMapLoc;

    //<editor-fold defaultstate="collapsed" desc="clang::Parser::OpenMPVarListDataTy::OpenMPVarListDataTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2559,
     FQN="clang::Parser::OpenMPVarListDataTy::OpenMPVarListDataTy", NM="_ZN5clang6Parser19OpenMPVarListDataTyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser19OpenMPVarListDataTyC1Ev")
    //</editor-fold>
    public /*inline*/ OpenMPVarListDataTy() {
      // : TailExpr(null), ColonLoc(), ReductionIdScopeSpec(), ReductionId(), DepKind(OMPC_DEPEND_unknown), LinKind(OMPC_LINEAR_val), MapTypeModifier(OMPC_MAP_unknown), MapType(OMPC_MAP_unknown), IsMapTypeImplicit(false), DepLinMapLoc() 
      //START JInit
      /*InClass*/this.TailExpr = null;
      this.ColonLoc = new SourceLocation();
      this.ReductionIdScopeSpec = new CXXScopeSpec();
      this.ReductionId = new DeclarationNameInfo();
      /*InClass*/this.DepKind = OpenMPDependClauseKind.OMPC_DEPEND_unknown;
      /*InClass*/this.LinKind = OpenMPLinearClauseKind.OMPC_LINEAR_val;
      /*InClass*/this.MapTypeModifier = OpenMPMapClauseKind.OMPC_MAP_unknown;
      /*InClass*/this.MapType = OpenMPMapClauseKind.OMPC_MAP_unknown;
      /*InClass*/this.IsMapTypeImplicit = false;
      this.DepLinMapLoc = new SourceLocation();
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Parser::OpenMPVarListDataTy::~OpenMPVarListDataTy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Parse/Parser.h", line = 2559,
     FQN="clang::Parser::OpenMPVarListDataTy::~OpenMPVarListDataTy", NM="_ZN5clang6Parser19OpenMPVarListDataTyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN5clang6Parser19OpenMPVarListDataTyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      ReductionIdScopeSpec.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "TailExpr=" + TailExpr // NOI18N
                + ", ColonLoc=" + ColonLoc // NOI18N
                + ", ReductionIdScopeSpec=" + ReductionIdScopeSpec // NOI18N
                + ", ReductionId=" + ReductionId // NOI18N
                + ", DepKind=" + DepKind // NOI18N
                + ", LinKind=" + LinKind // NOI18N
                + ", MapTypeModifier=" + MapTypeModifier // NOI18N
                + ", MapType=" + MapType // NOI18N
                + ", IsMapTypeImplicit=" + IsMapTypeImplicit // NOI18N
                + ", DepLinMapLoc=" + DepLinMapLoc; // NOI18N
    }
  }
/*class UnannotatedTentativeParsingAction*/ /*NO BODY FOUND*/

  /// extracted from the function
      //<editor-fold defaultstate="collapsed" desc="PreserveAtomicIdentifierInfoRAII">
      @Converted(kind = Converted.Kind.MANUAL,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1333,
       FQN="PreserveAtomicIdentifierInfoRAII", NM="_ZZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeEE32PreserveAtomicIdentifierInfoRAII",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeEE32PreserveAtomicIdentifierInfoRAII")
      //</editor-fold>
       protected static class/*struct*/ PreserveAtomicIdentifierInfoRAII implements Destructors.ClassWithDestructor {
        //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseClassSpecifier(tok::TokenKind, SourceLocation, DeclSpec & , const ParsedTemplateInfo & , AccessSpecifier, bool, DeclSpecContext, ParsedAttributesWithRange & )::PreserveAtomicIdentifierInfoRAII::PreserveAtomicIdentifierInfoRAII">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1334,
         FQN="clang::Parser::ParseClassSpecifier(tok::TokenKind, SourceLocation, DeclSpec & , const ParsedTemplateInfo & , AccessSpecifier, bool, DeclSpecContext, ParsedAttributesWithRange & )::PreserveAtomicIdentifierInfoRAII::PreserveAtomicIdentifierInfoRAII", NM="_ZZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeEEN32PreserveAtomicIdentifierInfoRAIIC1ERNS_5TokenEb",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeEEN32PreserveAtomicIdentifierInfoRAIIC1ERNS_5TokenEb")
        //</editor-fold>
        public PreserveAtomicIdentifierInfoRAII(final Token /*&*/ Tok, boolean Enabled) {
          // : AtomicII(null) 
          //START JInit
          this.AtomicII = null;
          //END JInit
          if (!Enabled) {
            return;
          }
          assert (Tok.is(tok.TokenKind.kw__Atomic));
          AtomicII = Tok.getIdentifierInfo();
          AtomicII.revertTokenIDToIdentifier();
          Tok.setKind(tok.TokenKind.identifier);
        }
  
        //<editor-fold defaultstate="collapsed" desc="clang::Parser::ParseClassSpecifier(tok::TokenKind, SourceLocation, DeclSpec & , const ParsedTemplateInfo & , AccessSpecifier, bool, DeclSpecContext, ParsedAttributesWithRange & )::PreserveAtomicIdentifierInfoRAII::~PreserveAtomicIdentifierInfoRAII">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 1343,
         FQN="clang::Parser::ParseClassSpecifier(tok::TokenKind, SourceLocation, DeclSpec & , const ParsedTemplateInfo & , AccessSpecifier, bool, DeclSpecContext, ParsedAttributesWithRange & )::PreserveAtomicIdentifierInfoRAII::~PreserveAtomicIdentifierInfoRAII", NM="_ZZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeEEN32PreserveAtomicIdentifierInfoRAIID0Ev",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZZN5clang6Parser19ParseClassSpecifierENS_3tok9TokenKindENS_14SourceLocationERNS_8DeclSpecERKNS0_18ParsedTemplateInfoENS_15AccessSpecifierEbNS0_15DeclSpecContextERNS0_25ParsedAttributesWithRangeEEN32PreserveAtomicIdentifierInfoRAIID0Ev")
        //</editor-fold>
        public void $destroy() {
          if (!(AtomicII != null)) {
            return;
          }
          AtomicII.revertIdentifierToTokenID(tok.TokenKind.kw__Atomic);
        }
  
        public IdentifierInfo /*P*/ AtomicII;
        
        @Override public String toString() {
          return "" + "AtomicII=" + AtomicII; // NOI18N
        }
      };  
  ////
} // END OF class Parser_NestedClasses
