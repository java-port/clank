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

package org.clang.ast.comments;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.comments.CommentsGlobals.*;
import static org.clang.ast.comments.impl.CommentSemaCommentsStatics.*;
import org.clang.ast.comments.impl.SimpleTypoCorrector;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::comments::Sema">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentSema.h", line = 33,
 FQN="clang::comments::Sema", NM="_ZN5clang8comments4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4SemaE")
//</editor-fold>
public class Sema implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::Sema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentSema.h", line = 34,
   FQN="clang::comments::Sema::Sema", NM="_ZN5clang8comments4SemaC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4SemaC1ERKS1_")
  //</editor-fold>
  private Sema(final /*const*/ Sema /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentSema.h", line = 35,
   FQN="clang::comments::Sema::operator=", NM="_ZN5clang8comments4SemaaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4SemaaSERKS1_")
  //</editor-fold>
  private void $assign(final /*const*/ Sema /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Allocator for AST nodes.
  private final BumpPtrAllocatorImpl /*&*/ Allocator;
  
  /// Source manager for the comment being parsed.
  private final /*const*/ SourceManager /*&*/ SourceMgr;
  
  private final DiagnosticsEngine /*&*/ Diags;
  
  private final CommandTraits /*&*/ Traits;
  
  private /*const*/ Preprocessor /*P*/ PP;
  
  /// Information about the declaration this comment is attached to.
  private DeclInfo /*P*/ ThisDeclInfo;
  
  /// Comment AST nodes that correspond to parameter names in
  /// \c TemplateParameters.
  ///
  /// Contains a valid value if \c DeclInfo->IsFilled is true.
  private StringMap<TParamCommandComment /*P*/ > TemplateParameterDocs;
  
  /// AST node for the \\brief command and its aliases.
  private /*const*/ BlockCommandComment /*P*/ BriefCommand;
  
  /// AST node for the \\headerfile command.
  private /*const*/ BlockCommandComment /*P*/ HeaderfileCommand;
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::Diag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentSema.h", line = 64,
   FQN="clang::comments::Sema::Diag", NM="_ZN5clang8comments4Sema4DiagENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema4DiagENS_14SourceLocationEj")
  //</editor-fold>
  private DiagnosticBuilder Diag(SourceLocation Loc, /*uint*/int DiagID) {
    return Diags.Report(/*NO_COPY*/Loc, DiagID);
  }

  
  /// A stack of HTML tags that are currently open (not matched with closing
  /// tags).
  private SmallVector<HTMLStartTagComment /*P*/ > HTMLOpenTags;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::Sema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 28,
   FQN="clang::comments::Sema::Sema", NM="_ZN5clang8comments4SemaC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERKNS_13SourceManagerERNS_17DiagnosticsEngineERNS0_13CommandTraitsEPKNS_12PreprocessorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4SemaC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEERKNS_13SourceManagerERNS_17DiagnosticsEngineERNS0_13CommandTraitsEPKNS_12PreprocessorE")
  //</editor-fold>
  public Sema(final BumpPtrAllocatorImpl /*&*/ Allocator, final /*const*/ SourceManager /*&*/ SourceMgr, 
      final DiagnosticsEngine /*&*/ Diags, final CommandTraits /*&*/ Traits, 
      /*const*/ Preprocessor /*P*/ PP) {
    // : Allocator(Allocator), SourceMgr(SourceMgr), Diags(Diags), Traits(Traits), PP(PP), ThisDeclInfo(null), TemplateParameterDocs(), BriefCommand(null), HeaderfileCommand(null), HTMLOpenTags() 
    //START JInit
    this./*&*/Allocator=/*&*/Allocator;
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this./*&*/Diags=/*&*/Diags;
    this./*&*/Traits=/*&*/Traits;
    this.PP = PP;
    this.ThisDeclInfo = null;
    this.TemplateParameterDocs = new StringMap<TParamCommandComment /*P*/ >((TParamCommandComment /*P*/ )null);
    this.BriefCommand = null;
    this.HeaderfileCommand = null;
    this.HTMLOpenTags = new SmallVector<HTMLStartTagComment /*P*/ >(8, (HTMLStartTagComment /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::setDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 36,
   FQN="clang::comments::Sema::setDecl", NM="_ZN5clang8comments4Sema7setDeclEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema7setDeclEPKNS_4DeclE")
  //</editor-fold>
  public void setDecl(/*const*/ Decl /*P*/ D) {
    if (!(D != null)) {
      return;
    }
    
    ThisDeclInfo = /*FIXME:NEW_EXPR [operator new] NM=_ZnwIN4llvm15MallocAllocatorELj4096ELj4096EEPvjRNS0_20BumpPtrAllocatorImplIT_XT0_EXT1_EEE*/
    /*new (Allocator)*/ new DeclInfo();
    ThisDeclInfo.CommentDecl = D;
    ThisDeclInfo.IsFilled = false;
  }

  
  /// Returns a copy of array, owned by Sema's allocator.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::copyArray">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentSema.h", line = 81,
   FQN="clang::comments::Sema::copyArray", NM="Tpl__ZN5clang8comments4Sema9copyArrayEN4llvm8ArrayRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=Tpl__ZN5clang8comments4Sema9copyArrayEN4llvm8ArrayRefIT_EE")
  //</editor-fold>
  public </*typename*/ T> ArrayRef<T> copyArray(Class<T> clazz,ArrayRef<T> Source) {
    if (Native.$not(Source.empty())) {
      return Source.copy(clazz, Allocator);
    }
    return ArrayRef.None();
  }
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED)
  public ArrayRefUInt copyArray(ArrayRefUInt Source) {
    if (Native.$not(Source.empty())) {
      return Source.copy(int.class, Allocator);
    }
    return ArrayRefUInt.None();
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnParagraphComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 45,
   FQN="clang::comments::Sema::actOnParagraphComment", NM="_ZN5clang8comments4Sema21actOnParagraphCommentEN4llvm8ArrayRefIPNS0_20InlineContentCommentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema21actOnParagraphCommentEN4llvm8ArrayRefIPNS0_20InlineContentCommentEEE")
  //</editor-fold>
  public ParagraphComment /*P*/ actOnParagraphComment(ArrayRef<InlineContentComment /*P*/ > Content) {
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new ParagraphComment(new ArrayRef<InlineContentComment /*P*/ >(Content));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnBlockCommandStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 50,
   FQN="clang::comments::Sema::actOnBlockCommandStart", NM="_ZN5clang8comments4Sema22actOnBlockCommandStartENS_14SourceLocationES2_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22actOnBlockCommandStartENS_14SourceLocationES2_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  public BlockCommandComment /*P*/ actOnBlockCommandStart(SourceLocation LocBegin, 
                        SourceLocation LocEnd, 
                        /*uint*/int CommandID, 
                        CommandMarkerKind CommandMarker) {
    BlockCommandComment /*P*/ BC = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new BlockCommandComment(new SourceLocation(LocBegin), new SourceLocation(LocEnd), 
        CommandID, 
        CommandMarker);
    checkContainerDecl(BC);
    return BC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnBlockCommandArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 62,
   FQN="clang::comments::Sema::actOnBlockCommandArgs", NM="_ZN5clang8comments4Sema21actOnBlockCommandArgsEPNS0_19BlockCommandCommentEN4llvm8ArrayRefINS2_8ArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema21actOnBlockCommandArgsEPNS0_19BlockCommandCommentEN4llvm8ArrayRefINS2_8ArgumentEEE")
  //</editor-fold>
  public void actOnBlockCommandArgs(BlockCommandComment /*P*/ Command, 
                       ArrayRef<BlockCommandComment.Argument> Args) {
    Command.setArgs(new ArrayRef<BlockCommandComment.Argument>(Args));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnBlockCommandFinish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 67,
   FQN="clang::comments::Sema::actOnBlockCommandFinish", NM="_ZN5clang8comments4Sema23actOnBlockCommandFinishEPNS0_19BlockCommandCommentEPNS0_16ParagraphCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema23actOnBlockCommandFinishEPNS0_19BlockCommandCommentEPNS0_16ParagraphCommentE")
  //</editor-fold>
  public void actOnBlockCommandFinish(BlockCommandComment /*P*/ Command, 
                         ParagraphComment /*P*/ Paragraph) {
    Command.setParagraph(Paragraph);
    checkBlockCommandEmptyParagraph(Command);
    checkBlockCommandDuplicate(Command);
    if ((ThisDeclInfo != null)) {
      // These checks only make sense if the comment is attached to a
      // declaration.
      checkReturnsCommand(Command);
      checkDeprecatedCommand(Command);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnParamCommandStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 80,
   FQN="clang::comments::Sema::actOnParamCommandStart", NM="_ZN5clang8comments4Sema22actOnParamCommandStartENS_14SourceLocationES2_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22actOnParamCommandStartENS_14SourceLocationES2_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  public ParamCommandComment /*P*/ actOnParamCommandStart(SourceLocation LocBegin, 
                        SourceLocation LocEnd, 
                        /*uint*/int CommandID, 
                        CommandMarkerKind CommandMarker) {
    ParamCommandComment /*P*/ Command = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new ParamCommandComment(new SourceLocation(LocBegin), new SourceLocation(LocEnd), CommandID, 
        CommandMarker);
    if (!isFunctionDecl()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($c$.track(Diag(Command.getLocation(), 
                    diag.warn_doc_param_not_attached_to_a_function_decl)), 
                CommandMarker.getValue()), 
            Command.getCommandNameRange(Traits)));
      } finally {
        $c$.$destroy();
      }
    }
    
    return Command;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnParamCommandDirectionArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 228,
   FQN="clang::comments::Sema::actOnParamCommandDirectionArg", NM="_ZN5clang8comments4Sema29actOnParamCommandDirectionArgEPNS0_19ParamCommandCommentENS_14SourceLocationES4_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema29actOnParamCommandDirectionArgEPNS0_19ParamCommandCommentENS_14SourceLocationES4_N4llvm9StringRefE")
  //</editor-fold>
  public void actOnParamCommandDirectionArg(ParamCommandComment /*P*/ Command, 
                               SourceLocation ArgLocBegin, 
                               SourceLocation ArgLocEnd, 
                               StringRef Arg) {
    std.string ArgLower = Arg.lower();
    int Direction = getParamPassDirection(new StringRef(ArgLower));
    if (Direction == -1) {
      // Try again with whitespace removed.
      ArgLower.erase(std.remove_if(ArgLower.begin(), ArgLower.end(), /*FuncRef*/BasicClangGlobals::isWhitespace), 
          ArgLower.end());
      Direction = getParamPassDirection(new StringRef(ArgLower));
      
      SourceRange ArgRange/*J*/= new SourceRange(/*NO_COPY*/ArgLocBegin, /*NO_COPY*/ArgLocEnd);
      if (Direction != -1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/char$ptr/*char P*/ FixedName = $tryClone(ParamCommandComment.getDirectionAsString(ParamCommandComment.PassDirection.valueOf(Direction)));
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(new SourceLocation(ArgLocBegin), diag.warn_doc_param_spaces_in_direction)), 
                  /*NO_COPY*/ArgRange), FixItHint.CreateReplacement(/*NO_COPY*/ArgRange, new StringRef(FixedName))));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(new SourceLocation(ArgLocBegin), diag.warn_doc_param_invalid_direction)), /*NO_COPY*/ArgRange));
          Direction = ParamCommandComment.PassDirection.In.getValue(); // Sane fall back.
        } finally {
          $c$.$destroy();
        }
      }
    }
    Command.setDirection(ParamCommandComment.PassDirection.valueOf(Direction), 
        /*Explicit=*/ true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnParamCommandParamNameArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 257,
   FQN="clang::comments::Sema::actOnParamCommandParamNameArg", NM="_ZN5clang8comments4Sema29actOnParamCommandParamNameArgEPNS0_19ParamCommandCommentENS_14SourceLocationES4_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema29actOnParamCommandParamNameArgEPNS0_19ParamCommandCommentENS_14SourceLocationES4_N4llvm9StringRefE")
  //</editor-fold>
  public void actOnParamCommandParamNameArg(ParamCommandComment /*P*/ Command, 
                               SourceLocation ArgLocBegin, 
                               SourceLocation ArgLocEnd, 
                               StringRef Arg) {
    // Parser will not feed us more arguments than needed.
    assert (Command.getNumArgs() == 0);
    if (!Command.isDirectionExplicit()) {
      // User didn't provide a direction argument.
      Command.setDirection(ParamCommandComment.PassDirection.In, /* Explicit = */ false);
    }
    /*typedef BlockCommandComment::Argument Argument*/
//    final class Argument extends BlockCommandComment.Argument{ };
    BlockCommandComment.Argument /*P*/ A = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new BlockCommandComment.Argument(new SourceRange(/*NO_COPY*/ArgLocBegin, 
            /*NO_COPY*/ArgLocEnd), 
        new StringRef(Arg));
    Command.setArgs(llvm.makeArrayRef(A, 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnParamCommandFinish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 275,
   FQN="clang::comments::Sema::actOnParamCommandFinish", NM="_ZN5clang8comments4Sema23actOnParamCommandFinishEPNS0_19ParamCommandCommentEPNS0_16ParagraphCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema23actOnParamCommandFinishEPNS0_19ParamCommandCommentEPNS0_16ParagraphCommentE")
  //</editor-fold>
  public void actOnParamCommandFinish(ParamCommandComment /*P*/ Command, 
                         ParagraphComment /*P*/ Paragraph) {
    Command.setParagraph(Paragraph);
    checkBlockCommandEmptyParagraph(Command);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnTParamCommandStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 281,
   FQN="clang::comments::Sema::actOnTParamCommandStart", NM="_ZN5clang8comments4Sema23actOnTParamCommandStartENS_14SourceLocationES2_jNS0_17CommandMarkerKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema23actOnTParamCommandStartENS_14SourceLocationES2_jNS0_17CommandMarkerKindE")
  //</editor-fold>
  public TParamCommandComment /*P*/ actOnTParamCommandStart(SourceLocation LocBegin, 
                         SourceLocation LocEnd, 
                         /*uint*/int CommandID, 
                         CommandMarkerKind CommandMarker) {
    TParamCommandComment /*P*/ Command = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new TParamCommandComment(new SourceLocation(LocBegin), new SourceLocation(LocEnd), CommandID, 
        CommandMarker);
    if (!isTemplateOrSpecialization()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_int($c$.track(Diag(Command.getLocation(), 
                    diag.warn_doc_tparam_not_attached_to_a_template_decl)), 
                CommandMarker.getValue()), 
            Command.getCommandNameRange(Traits)));
      } finally {
        $c$.$destroy();
      }
    }
    
    return Command;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnTParamCommandParamNameArg">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 299,
   FQN="clang::comments::Sema::actOnTParamCommandParamNameArg", NM="_ZN5clang8comments4Sema30actOnTParamCommandParamNameArgEPNS0_20TParamCommandCommentENS_14SourceLocationES4_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema30actOnTParamCommandParamNameArgEPNS0_20TParamCommandCommentENS_14SourceLocationES4_N4llvm9StringRefE")
  //</editor-fold>
  public void actOnTParamCommandParamNameArg(TParamCommandComment /*P*/ Command, 
                                SourceLocation ArgLocBegin, 
                                SourceLocation ArgLocEnd, 
                                StringRef Arg) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Parser will not feed us more arguments than needed.
      assert (Command.getNumArgs() == 0);
      
      /*typedef BlockCommandComment::Argument Argument*/
//      final class Argument extends BlockCommandComment.Argument{ };
      BlockCommandComment.Argument /*P*/ A = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new BlockCommandComment.Argument(new SourceRange(/*NO_COPY*/ArgLocBegin, 
              /*NO_COPY*/ArgLocEnd), 
          new StringRef(Arg));
      Command.setArgs(llvm.makeArrayRef(A, 1));
      if (!isTemplateOrSpecialization()) {
        // We already warned that this \\tparam is not attached to a template decl.
        return;
      }
      
      /*const*/ TemplateParameterList /*P*/ TemplateParameters = ThisDeclInfo.TemplateParameters;
      SmallVectorUInt Position/*J*/= new SmallVectorUInt(2, 0);
      if (resolveTParamReference(new StringRef(Arg), TemplateParameters, $AddrOf(Position))) {
        Command.setPosition(copyArray(llvm.makeArrayRef(Position)));
        final type$ref<TParamCommandComment /*P*/ /*&*/> PrevCommand = TemplateParameterDocs.ref$at(/*NO_COPY*/Arg);
        if ((PrevCommand.$deref() != null)) {
          SourceRange ArgRange/*J*/= new SourceRange(/*NO_COPY*/ArgLocBegin, /*NO_COPY*/ArgLocEnd);
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(new SourceLocation(ArgLocBegin), diag.warn_doc_tparam_duplicate)), 
                  /*NO_COPY*/Arg), /*NO_COPY*/ArgRange));
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(PrevCommand.$deref().getLocation(), diag.note_doc_tparam_previous)), 
              PrevCommand.$deref().getParamNameRange()));
        }
        PrevCommand.$set(Command);
        return;
      }
      
      SourceRange ArgRange/*J*/= new SourceRange(/*NO_COPY*/ArgLocBegin, /*NO_COPY*/ArgLocEnd);
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(new SourceLocation(ArgLocBegin), diag.warn_doc_tparam_not_found)), 
              /*NO_COPY*/Arg), /*NO_COPY*/ArgRange));
      if (!(TemplateParameters != null) || TemplateParameters.size() == 0) {
        return;
      }
      
      StringRef CorrectedName/*J*/= new StringRef();
      if (TemplateParameters.size() == 1) {
        /*const*/ NamedDecl /*P*/ Param = TemplateParameters.getParam$Const(0);
        /*const*/ IdentifierInfo /*P*/ II = Param.getIdentifier();
        if ((II != null)) {
          CorrectedName.$assignMove(II.getName());
        }
      } else {
        CorrectedName.$assignMove(correctTypoInTParamReference(new StringRef(Arg), TemplateParameters));
      }
      if (!CorrectedName.empty()) {
        $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(new SourceLocation(ArgLocBegin), diag.note_doc_tparam_name_suggestion)), 
                /*NO_COPY*/CorrectedName), 
            FixItHint.CreateReplacement(/*NO_COPY*/ArgRange, /*NO_COPY*/CorrectedName)));
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnTParamCommandFinish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 358,
   FQN="clang::comments::Sema::actOnTParamCommandFinish", NM="_ZN5clang8comments4Sema24actOnTParamCommandFinishEPNS0_20TParamCommandCommentEPNS0_16ParagraphCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema24actOnTParamCommandFinishEPNS0_20TParamCommandCommentEPNS0_16ParagraphCommentE")
  //</editor-fold>
  public void actOnTParamCommandFinish(TParamCommandComment /*P*/ Command, 
                          ParagraphComment /*P*/ Paragraph) {
    Command.setParagraph(Paragraph);
    checkBlockCommandEmptyParagraph(Command);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnInlineCommand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 364,
   FQN="clang::comments::Sema::actOnInlineCommand", NM="_ZN5clang8comments4Sema18actOnInlineCommandENS_14SourceLocationES2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema18actOnInlineCommandENS_14SourceLocationES2_j")
  //</editor-fold>
  public InlineCommandComment /*P*/ actOnInlineCommand(SourceLocation CommandLocBegin, 
                    SourceLocation CommandLocEnd, 
                    /*uint*/int CommandID) {
    ArrayRef<InlineCommandComment.Argument> Args/*J*/= new ArrayRef<InlineCommandComment.Argument>(false);
    StringRef CommandName = new StringRef(Traits.getCommandInfo(CommandID).Name);
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new InlineCommandComment(new SourceLocation(CommandLocBegin), 
        new SourceLocation(CommandLocEnd), 
        CommandID, 
        getInlineCommandRenderKind(new StringRef(CommandName)), 
        new ArrayRef<InlineCommandComment.Argument>(Args));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnInlineCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 377,
   FQN="clang::comments::Sema::actOnInlineCommand", NM="_ZN5clang8comments4Sema18actOnInlineCommandENS_14SourceLocationES2_jS2_S2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema18actOnInlineCommandENS_14SourceLocationES2_jS2_S2_N4llvm9StringRefE")
  //</editor-fold>
  public InlineCommandComment /*P*/ actOnInlineCommand(SourceLocation CommandLocBegin, 
                    SourceLocation CommandLocEnd, 
                    /*uint*/int CommandID, 
                    SourceLocation ArgLocBegin, 
                    SourceLocation ArgLocEnd, 
                    StringRef Arg) {
    /*typedef InlineCommandComment::Argument Argument*/
//    final class Argument extends InlineCommandComment.Argument{ };
    InlineCommandComment.Argument /*P*/ A = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new InlineCommandComment.Argument(new SourceRange(/*NO_COPY*/ArgLocBegin, 
            /*NO_COPY*/ArgLocEnd), 
        new StringRef(Arg));
    StringRef CommandName = new StringRef(Traits.getCommandInfo(CommandID).Name);
    
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new InlineCommandComment(new SourceLocation(CommandLocBegin), 
        new SourceLocation(CommandLocEnd), 
        CommandID, 
        getInlineCommandRenderKind(new StringRef(CommandName)), 
        llvm.makeArrayRef(A, 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnUnknownCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 397,
   FQN="clang::comments::Sema::actOnUnknownCommand", NM="_ZN5clang8comments4Sema19actOnUnknownCommandENS_14SourceLocationES2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema19actOnUnknownCommandENS_14SourceLocationES2_N4llvm9StringRefE")
  //</editor-fold>
  public InlineContentComment /*P*/ actOnUnknownCommand(SourceLocation LocBegin, 
                     SourceLocation LocEnd, 
                     StringRef CommandName) {
    /*uint*/int CommandID = Traits.registerUnknownCommand(new StringRef(CommandName)).getID();
    return actOnUnknownCommand(new SourceLocation(LocBegin), new SourceLocation(LocEnd), CommandID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnUnknownCommand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 404,
   FQN="clang::comments::Sema::actOnUnknownCommand", NM="_ZN5clang8comments4Sema19actOnUnknownCommandENS_14SourceLocationES2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema19actOnUnknownCommandENS_14SourceLocationES2_j")
  //</editor-fold>
  public InlineContentComment /*P*/ actOnUnknownCommand(SourceLocation LocBegin, 
                     SourceLocation LocEnd, 
                     /*uint*/int CommandID) {
    ArrayRef<InlineCommandComment.Argument> Args/*J*/= new ArrayRef<InlineCommandComment.Argument>(false);
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new InlineCommandComment(new SourceLocation(LocBegin), new SourceLocation(LocEnd), CommandID, 
        InlineCommandComment.RenderKind.RenderNormal, 
        new ArrayRef<InlineCommandComment.Argument>(Args));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnText">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 414,
   FQN="clang::comments::Sema::actOnText", NM="_ZN5clang8comments4Sema9actOnTextENS_14SourceLocationES2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema9actOnTextENS_14SourceLocationES2_N4llvm9StringRefE")
  //</editor-fold>
  public TextComment /*P*/ actOnText(SourceLocation LocBegin, 
           SourceLocation LocEnd, 
           StringRef Text) {
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new TextComment(new SourceLocation(LocBegin), new SourceLocation(LocEnd), new StringRef(Text));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnVerbatimBlockStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 420,
   FQN="clang::comments::Sema::actOnVerbatimBlockStart", NM="_ZN5clang8comments4Sema23actOnVerbatimBlockStartENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema23actOnVerbatimBlockStartENS_14SourceLocationEj")
  //</editor-fold>
  public VerbatimBlockComment /*P*/ actOnVerbatimBlockStart(SourceLocation Loc, 
                         /*uint*/int CommandID) {
    StringRef CommandName = new StringRef(Traits.getCommandInfo(CommandID).Name);
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new VerbatimBlockComment(new SourceLocation(Loc), 
        Loc.getLocWithOffset(1 + CommandName.size()), 
        CommandID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnVerbatimBlockLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 429,
   FQN="clang::comments::Sema::actOnVerbatimBlockLine", NM="_ZN5clang8comments4Sema22actOnVerbatimBlockLineENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22actOnVerbatimBlockLineENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public VerbatimBlockLineComment /*P*/ actOnVerbatimBlockLine(SourceLocation Loc, 
                        StringRef Text) {
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new VerbatimBlockLineComment(new SourceLocation(Loc), new StringRef(Text));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnVerbatimBlockFinish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 434,
   FQN="clang::comments::Sema::actOnVerbatimBlockFinish", NM="_ZN5clang8comments4Sema24actOnVerbatimBlockFinishEPNS0_20VerbatimBlockCommentENS_14SourceLocationEN4llvm9StringRefENS5_8ArrayRefIPNS0_24VerbatimBlockLineCommentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema24actOnVerbatimBlockFinishEPNS0_20VerbatimBlockCommentENS_14SourceLocationEN4llvm9StringRefENS5_8ArrayRefIPNS0_24VerbatimBlockLineCommentEEE")
  //</editor-fold>
  public void actOnVerbatimBlockFinish(VerbatimBlockComment /*P*/ Block, 
                          SourceLocation CloseNameLocBegin, 
                          StringRef CloseName, 
                          ArrayRef<VerbatimBlockLineComment /*P*/ > Lines) {
    Block.setCloseName(new StringRef(CloseName), new SourceLocation(CloseNameLocBegin));
    Block.setLines(new ArrayRef<VerbatimBlockLineComment /*P*/ >(Lines));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnVerbatimLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 443,
   FQN="clang::comments::Sema::actOnVerbatimLine", NM="_ZN5clang8comments4Sema17actOnVerbatimLineENS_14SourceLocationEjS2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema17actOnVerbatimLineENS_14SourceLocationEjS2_N4llvm9StringRefE")
  //</editor-fold>
  public VerbatimLineComment /*P*/ actOnVerbatimLine(SourceLocation LocBegin, 
                   /*uint*/int CommandID, 
                   SourceLocation TextBegin, 
                   StringRef Text) {
    VerbatimLineComment /*P*/ VL = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new VerbatimLineComment(new SourceLocation(LocBegin), 
        TextBegin.getLocWithOffset(Text.size()), 
        CommandID, 
        new SourceLocation(TextBegin), 
        new StringRef(Text));
    checkFunctionDeclVerbatimLine(VL);
    checkContainerDeclVerbatimLine(VL);
    return VL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnHTMLStartTagStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 458,
   FQN="clang::comments::Sema::actOnHTMLStartTagStart", NM="_ZN5clang8comments4Sema22actOnHTMLStartTagStartENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22actOnHTMLStartTagStartENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public HTMLStartTagComment /*P*/ actOnHTMLStartTagStart(SourceLocation LocBegin, 
                        StringRef TagName) {
    return /*FIXME:NEW_EXPR*//*new (Allocator)*/ new HTMLStartTagComment(new SourceLocation(LocBegin), new StringRef(TagName));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnHTMLStartTagFinish">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 463,
   FQN="clang::comments::Sema::actOnHTMLStartTagFinish", NM="_ZN5clang8comments4Sema23actOnHTMLStartTagFinishEPNS0_19HTMLStartTagCommentEN4llvm8ArrayRefINS2_9AttributeEEENS_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema23actOnHTMLStartTagFinishEPNS0_19HTMLStartTagCommentEN4llvm8ArrayRefINS2_9AttributeEEENS_14SourceLocationEb")
  //</editor-fold>
  public void actOnHTMLStartTagFinish(HTMLStartTagComment /*P*/ Tag, 
                         ArrayRef<HTMLStartTagComment.Attribute> Attrs, 
                         SourceLocation GreaterLoc, 
                         boolean IsSelfClosing) {
    Tag.setAttrs(new ArrayRef<HTMLStartTagComment.Attribute>(Attrs));
    Tag.setGreaterLoc(new SourceLocation(GreaterLoc));
    if (IsSelfClosing) {
      Tag.setSelfClosing();
    } else if (!isHTMLEndTagForbidden(Tag.getTagName())) {
      HTMLOpenTags.push_back(Tag);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnHTMLEndTag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 476,
   FQN="clang::comments::Sema::actOnHTMLEndTag", NM="_ZN5clang8comments4Sema15actOnHTMLEndTagENS_14SourceLocationES2_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema15actOnHTMLEndTagENS_14SourceLocationES2_N4llvm9StringRefE")
  //</editor-fold>
  public HTMLEndTagComment /*P*/ actOnHTMLEndTag(SourceLocation LocBegin, 
                 SourceLocation LocEnd, 
                 StringRef TagName) {
    HTMLEndTagComment /*P*/ HET = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new HTMLEndTagComment(new SourceLocation(LocBegin), new SourceLocation(LocEnd), new StringRef(TagName));
    if (isHTMLEndTagForbidden(new StringRef(TagName))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(HET.getLocation(), diag.warn_doc_html_end_forbidden)), 
                /*NO_COPY*/TagName), HET.getSourceRange()));
        HET.setIsMalformed();
        return HET;
      } finally {
        $c$.$destroy();
      }
    }
    
    boolean FoundOpen = false;
    for (std.reverse_iterator<HTMLStartTagComment /*P*/ /*const*/> I = new std.reverse_iterator<HTMLStartTagComment /*P*/ /*const*/>(JD$Reverse_iterator$_Iter$C.INSTANCE, HTMLOpenTags.rbegin()), E = new std.reverse_iterator<HTMLStartTagComment /*P*/ /*const*/>(JD$Reverse_iterator$_Iter$C.INSTANCE, HTMLOpenTags.rend());
         $noteq_reverse_iterator$C(I, E); I.$preInc()) {
      if ($eq_StringRef((I.$star()).getTagName(), /*NO_COPY*/TagName)) {
        FoundOpen = true;
        break;
      }
    }
    if (!FoundOpen) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(HET.getLocation(), diag.warn_doc_html_end_unbalanced)), 
            HET.getSourceRange()));
        HET.setIsMalformed();
        return HET;
      } finally {
        $c$.$destroy();
      }
    }
    while (!HTMLOpenTags.empty()) {
      HTMLStartTagComment /*P*/ HST = HTMLOpenTags.pop_back_val();
      StringRef LastNotClosedTagName = HST.getTagName();
      if ($eq_StringRef(/*NO_COPY*/LastNotClosedTagName, /*NO_COPY*/TagName)) {
        // If the start tag is malformed, end tag is malformed as well.
        if (HST.isMalformed()) {
          HET.setIsMalformed();
        }
        break;
      }
      if (isHTMLEndTagOptional(new StringRef(LastNotClosedTagName))) {
        continue;
      }
      
      bool$ptr OpenLineInvalid = create_bool$ptr();
      /*const*//*uint*/int OpenLine = SourceMgr.getPresumedLineNumber(HST.getLocation(), 
          $AddrOf(OpenLineInvalid));
      bool$ptr CloseLineInvalid = create_bool$ptr();
      /*const*//*uint*/int CloseLine = SourceMgr.getPresumedLineNumber(HET.getLocation(), 
          $AddrOf(CloseLineInvalid));
      if (OpenLineInvalid.$star() || CloseLineInvalid.$star() || OpenLine == CloseLine) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(HST.getLocation(), diag.warn_doc_html_start_end_mismatch)), 
                          HST.getTagName()), HET.getTagName()), 
                  HST.getSourceRange()), HET.getSourceRange()));
          HST.setIsMalformed();
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(HST.getLocation(), diag.warn_doc_html_start_end_mismatch)), 
                      HST.getTagName()), HET.getTagName()), 
              HST.getSourceRange()));
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(HET.getLocation(), diag.note_doc_html_end_tag)), 
              HET.getSourceRange()));
          HST.setIsMalformed();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return HET;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::actOnFullComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 544,
   FQN="clang::comments::Sema::actOnFullComment", NM="_ZN5clang8comments4Sema16actOnFullCommentEN4llvm8ArrayRefIPNS0_19BlockContentCommentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema16actOnFullCommentEN4llvm8ArrayRefIPNS0_19BlockContentCommentEEE")
  //</editor-fold>
  public FullComment /*P*/ actOnFullComment(ArrayRef<BlockContentComment /*P*/ > Blocks) {
    FullComment /*P*/ FC = /*FIXME:NEW_EXPR*//*new (Allocator)*/ new FullComment(new ArrayRef<BlockContentComment /*P*/ >(Blocks), ThisDeclInfo);
    resolveParamCommandIndexes(FC);
    
    // Complain about HTML tags that are not closed.
    while (!HTMLOpenTags.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        HTMLStartTagComment /*P*/ HST = HTMLOpenTags.pop_back_val();
        if (isHTMLEndTagOptional(HST.getTagName())) {
          continue;
        }
        
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(HST.getLocation(), diag.warn_doc_html_missing_end_tag)), 
                HST.getTagName()), HST.getSourceRange()));
        HST.setIsMalformed();
      } finally {
        $c$.$destroy();
      }
    }
    
    return FC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkBlockCommandEmptyParagraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 563,
   FQN="clang::comments::Sema::checkBlockCommandEmptyParagraph", NM="_ZN5clang8comments4Sema31checkBlockCommandEmptyParagraphEPNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema31checkBlockCommandEmptyParagraphEPNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkBlockCommandEmptyParagraph(BlockCommandComment /*P*/ Command) {
    if (Traits.getCommandInfo(Command.getCommandID()).IsEmptyParagraphAllowed) {
      return;
    }
    
    ParagraphComment /*P*/ Paragraph = Command.getParagraph();
    if (Paragraph.isWhitespace()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation DiagLoc/*J*/= new SourceLocation();
        if ($greater_uint(Command.getNumArgs(), 0)) {
          DiagLoc.$assignMove(Command.getArgRange(Command.getNumArgs() - 1).getEnd());
        }
        if (!DiagLoc.isValid()) {
          DiagLoc.$assignMove(Command.getCommandNameRange(Traits).getEnd());
        }
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(Diag(new SourceLocation(DiagLoc), diag.warn_doc_block_command_empty_paragraph)), 
                    Command.getCommandMarker().getValue()), 
                Command.getCommandName(Traits)), 
            Command.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkReturnsCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 581,
   FQN="clang::comments::Sema::checkReturnsCommand", NM="_ZN5clang8comments4Sema19checkReturnsCommandEPKNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema19checkReturnsCommandEPKNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkReturnsCommand(/*const*/ BlockCommandComment /*P*/ Command) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Traits.getCommandInfo(Command.getCommandID()).IsReturnsCommand) {
        return;
      }
      assert ((ThisDeclInfo != null)) : "should not call this check on a bare comment";
      if (isFunctionDecl()) {
        if (ThisDeclInfo.ReturnType.$arrow().isVoidType()) {
          /*uint*/int DiagKind;
          switch (ThisDeclInfo.CommentDecl.getKind()) {
           default:
            if (ThisDeclInfo.IsObjCMethod) {
              DiagKind = 3;
            } else {
              DiagKind = 0;
            }
            break;
           case CXXConstructor:
            DiagKind = 1;
            break;
           case CXXDestructor:
            DiagKind = 2;
            break;
          }
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(Diag(Command.getLocation(), 
                              diag.warn_doc_returns_attached_to_a_void_function)), 
                          Command.getCommandMarker().getValue()), 
                      Command.getCommandName(Traits)), 
                  DiagKind), 
              Command.getSourceRange()));
        }
        return;
      } else if (isObjCPropertyDecl()) {
        return;
      }
      
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(Diag(Command.getLocation(), 
                      diag.warn_doc_returns_not_attached_to_a_function_decl)), 
                  Command.getCommandMarker().getValue()), 
              Command.getCommandName(Traits)), 
          Command.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Emit diagnostics about duplicate block commands that should be
  /// used only once per comment, e.g., \\brief and \\returns.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkBlockCommandDuplicate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 623,
   FQN="clang::comments::Sema::checkBlockCommandDuplicate", NM="_ZN5clang8comments4Sema26checkBlockCommandDuplicateEPKNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema26checkBlockCommandDuplicateEPKNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkBlockCommandDuplicate(/*const*/ BlockCommandComment /*P*/ Command) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Command.getCommandID());
      /*const*/ BlockCommandComment /*P*/ PrevCommand = null;
      if (Info.IsBriefCommand) {
        if (!(BriefCommand != null)) {
          BriefCommand = Command;
          return;
        }
        PrevCommand = BriefCommand;
      } else if (Info.IsHeaderfileCommand) {
        if (!(HeaderfileCommand != null)) {
          HeaderfileCommand = Command;
          return;
        }
        PrevCommand = HeaderfileCommand;
      } else {
        // We don't want to check this command for duplicates.
        return;
      }
      StringRef CommandName = Command.getCommandName(Traits);
      StringRef PrevCommandName = PrevCommand.getCommandName(Traits);
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(Diag(Command.getLocation(), diag.warn_doc_block_command_duplicate)), 
                  Command.getCommandMarker().getValue()), 
              /*NO_COPY*/CommandName), 
          Command.getSourceRange()));
      if ($eq_StringRef(/*NO_COPY*/CommandName, /*NO_COPY*/PrevCommandName)) {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(Diag(PrevCommand.getLocation(), diag.note_doc_block_command_previous)), 
                    PrevCommand.getCommandMarker().getValue()), 
                /*NO_COPY*/PrevCommandName), 
            PrevCommand.getSourceRange()));
      } else {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_int($c$.track(Diag(PrevCommand.getLocation(), 
                        diag.note_doc_block_command_previous_alias)), 
                    PrevCommand.getCommandMarker().getValue()), 
                /*NO_COPY*/PrevCommandName), 
            /*NO_COPY*/CommandName));
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkDeprecatedCommand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 661,
   FQN="clang::comments::Sema::checkDeprecatedCommand", NM="_ZN5clang8comments4Sema22checkDeprecatedCommandEPKNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22checkDeprecatedCommandEPKNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkDeprecatedCommand(/*const*/ BlockCommandComment /*P*/ Command) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Traits.getCommandInfo(Command.getCommandID()).IsDeprecatedCommand) {
        return;
      }
      assert ((ThisDeclInfo != null)) : "should not call this check on a bare comment";
      
      /*const*/ Decl /*P*/ D = ThisDeclInfo.CommentDecl;
      if (!(D != null)) {
        return;
      }
      if (D.hasAttr(DeprecatedAttr.class)
         || D.hasAttr(AvailabilityAttr.class)
         || D.hasAttr(UnavailableAttr.class)) {
        return;
      }
      
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(Command.getLocation(), 
              diag.warn_doc_deprecated_not_sync)), 
          Command.getSourceRange()));
      {
        
        // Try to emit a fixit with a deprecation attribute.
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
        if ((FD != null)) {
          // Don't emit a Fix-It for non-member function definitions.  GCC does not
          // accept attributes on them.
          /*const*/ DeclContext /*P*/ Ctx = FD.getDeclContext$Const();
          if ((!(Ctx != null) || !Ctx.isRecord())
             && FD.doesThisDeclarationHaveABody()) {
            return;
          }
          
          StringRef AttributeSpelling = new StringRef(/*KEEP_STR*/"__attribute__((deprecated))");
          if ((PP != null)) {
            TokenValue Tokens[/*6*/] = new TokenValue [/*6*/] {
              new TokenValue(org.clang.basic.tok.TokenKind.kw___attribute), new TokenValue(org.clang.basic.tok.TokenKind.l_paren), new TokenValue(org.clang.basic.tok.TokenKind.l_paren), 
              new TokenValue(PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"deprecated"))), 
              new TokenValue(org.clang.basic.tok.TokenKind.r_paren), new TokenValue(org.clang.basic.tok.TokenKind.r_paren)
            };
            StringRef MacroName = PP.getLastMacroWithSpelling(FD.getLocation(), 
                new ArrayRef<TokenValue>(Tokens, false));
            if (!MacroName.empty()) {
              AttributeSpelling.$assign(MacroName);
            }
          }
          
          SmallString/*64*/ TextToInsert/*J*/= new SmallString/*64*/(64, new StringRef(/*KEEP_STR*/$SPACE));
          TextToInsert.$addassign(/*NO_COPY*/AttributeSpelling);
          $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($c$.track(Diag(FD.getLocEnd(), 
                  diag.note_add_deprecation_attr)), 
              FixItHint.CreateInsertion(FD.getLocEnd().getLocWithOffset(1), 
                  TextToInsert.$StringRef())));
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkFunctionDeclVerbatimLine">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 98,
   FQN="clang::comments::Sema::checkFunctionDeclVerbatimLine", NM="_ZN5clang8comments4Sema29checkFunctionDeclVerbatimLineEPKNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema29checkFunctionDeclVerbatimLineEPKNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkFunctionDeclVerbatimLine(/*const*/ BlockCommandComment /*P*/ Comment) {
    /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Comment.getCommandID());
    if (!Info.IsFunctionDeclarationCommand) {
      return;
    }
    
    /*uint*/int DiagSelect;
    switch (CommandTraits.KnownCommandIDs.valueOf(Comment.getCommandID())) {
     case KCI_function:
      DiagSelect = (!isAnyFunctionDecl() && !isFunctionTemplateDecl()) ? 1 : 0;
      break;
     case KCI_functiongroup:
      DiagSelect = (!isAnyFunctionDecl() && !isFunctionTemplateDecl()) ? 2 : 0;
      break;
     case KCI_method:
      DiagSelect = !isObjCMethodDecl() ? 3 : 0;
      break;
     case KCI_methodgroup:
      DiagSelect = !isObjCMethodDecl() ? 4 : 0;
      break;
     case KCI_callback:
      DiagSelect = !isFunctionPointerVarDecl() ? 5 : 0;
      break;
     default:
      DiagSelect = 0;
      break;
    }
    if ((DiagSelect != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_int($c$.track(Diag(Comment.getLocation(), diag.warn_doc_function_method_decl_mismatch)), 
                        Comment.getCommandMarker().getValue()), 
                    (DiagSelect - 1)), (DiagSelect - 1)), 
            Comment.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkContainerDeclVerbatimLine">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 131,
   FQN="clang::comments::Sema::checkContainerDeclVerbatimLine", NM="_ZN5clang8comments4Sema30checkContainerDeclVerbatimLineEPKNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema30checkContainerDeclVerbatimLineEPKNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkContainerDeclVerbatimLine(/*const*/ BlockCommandComment /*P*/ Comment) {
    /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Comment.getCommandID());
    if (!Info.IsRecordLikeDeclarationCommand) {
      return;
    }
    /*uint*/int DiagSelect;
    switch (CommandTraits.KnownCommandIDs.valueOf(Comment.getCommandID())) {
     case KCI_class:
      DiagSelect = (!isClassOrStructDecl() && !isClassTemplateDecl()) ? 1 : 0;
      // Allow @class command on @interface declarations.
      // FIXME. Currently, \class and @class are indistinguishable. So,
      // \class is also allowed on an @interface declaration
      if ((DiagSelect != 0) && (Comment.getCommandMarker().getValue() != 0) && isObjCInterfaceDecl()) {
        DiagSelect = 0;
      }
      break;
     case KCI_interface:
      DiagSelect = !isObjCInterfaceDecl() ? 2 : 0;
      break;
     case KCI_protocol:
      DiagSelect = !isObjCProtocolDecl() ? 3 : 0;
      break;
     case KCI_struct:
      DiagSelect = !isClassOrStructDecl() ? 4 : 0;
      break;
     case KCI_union:
      DiagSelect = !isUnionDecl() ? 5 : 0;
      break;
     default:
      DiagSelect = 0;
      break;
    }
    if ((DiagSelect != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_int($c$.track(Diag(Comment.getLocation(), diag.warn_doc_api_container_decl_mismatch)), 
                        Comment.getCommandMarker().getValue()), 
                    (DiagSelect - 1)), (DiagSelect - 1)), 
            Comment.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::checkContainerDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 168,
   FQN="clang::comments::Sema::checkContainerDecl", NM="_ZN5clang8comments4Sema18checkContainerDeclEPKNS0_19BlockCommandCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema18checkContainerDeclEPKNS0_19BlockCommandCommentE")
  //</editor-fold>
  public void checkContainerDecl(/*const*/ BlockCommandComment /*P*/ Comment) {
    /*const*/ CommandInfo /*P*/ Info = Traits.getCommandInfo(Comment.getCommandID());
    if (!Info.IsRecordLikeDetailCommand || isRecordLikeDecl()) {
      return;
    }
    /*uint*/int DiagSelect;
    switch (CommandTraits.KnownCommandIDs.valueOf(Comment.getCommandID())) {
     case KCI_classdesign:
      DiagSelect = 1;
      break;
     case KCI_coclass:
      DiagSelect = 2;
      break;
     case KCI_dependency:
      DiagSelect = 3;
      break;
     case KCI_helper:
      DiagSelect = 4;
      break;
     case KCI_helperclass:
      DiagSelect = 5;
      break;
     case KCI_helps:
      DiagSelect = 6;
      break;
     case KCI_instancesize:
      DiagSelect = 7;
      break;
     case KCI_ownership:
      DiagSelect = 8;
      break;
     case KCI_performance:
      DiagSelect = 9;
      break;
     case KCI_security:
      DiagSelect = 10;
      break;
     case KCI_superclass:
      DiagSelect = 11;
      break;
     default:
      DiagSelect = 0;
      break;
    }
    if ((DiagSelect != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_int($c$.track(Diag(Comment.getLocation(), diag.warn_doc_container_decl_mismatch)), 
                    Comment.getCommandMarker().getValue()), 
                (DiagSelect - 1)), 
            Comment.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// Resolve parameter names to parameter indexes in function declaration.
  /// Emit diagnostics about unknown parametrs.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::resolveParamCommandIndexes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 711,
   FQN="clang::comments::Sema::resolveParamCommandIndexes", NM="_ZN5clang8comments4Sema26resolveParamCommandIndexesEPKNS0_11FullCommentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema26resolveParamCommandIndexesEPKNS0_11FullCommentE")
  //</editor-fold>
  public void resolveParamCommandIndexes(/*const*/ FullComment /*P*/ FC) {
    if (!isFunctionDecl()) {
      // We already warned that \\param commands are not attached to a function
      // decl.
      return;
    }
    
    SmallVector<ParamCommandComment /*P*/ > UnresolvedParamCommands/*J*/= new SmallVector<ParamCommandComment /*P*/ >(8, (ParamCommandComment /*P*/ )null);
    
    // Comment AST nodes that correspond to \c ParamVars for which we have
    // found a \\param command or NULL if no documentation was found so far.
    SmallVector<ParamCommandComment /*P*/ > ParamVarDocs/*J*/= new SmallVector<ParamCommandComment /*P*/ >(8, (ParamCommandComment /*P*/ )null);
    
    ArrayRef</*const*/ ParmVarDecl /*P*/ > ParamVars = getParamVars();
    ParamVarDocs.resize(ParamVars.size(), (ParamCommandComment /*P*/ /*const*/)null);
    
    // First pass over all \\param commands: resolve all parameter names.
    for (type$ptr<Comment/*P*/> I = $tryClone(FC.child_begin()), /*P*/ /*const*/ /*P*/ E = $tryClone(FC.child_end());
         $noteq_ptr(I, E); I.$preInc()) {
      ParamCommandComment /*P*/ PCC = dyn_cast_ParamCommandComment(I.$star());
      if (!(PCC != null) || !PCC.hasParamName()) {
        continue;
      }
      StringRef ParamName = PCC.getParamNameAsWritten();
      
      // Check that referenced parameter name is in the function decl.
      /*const*//*uint*/int ResolvedParamIndex = resolveParmVarReference(new StringRef(ParamName), 
          new ArrayRef</*const*/ ParmVarDecl /*P*/ >(ParamVars));
      if (ResolvedParamIndex == ParamCommandComment.Unnamed_enum.VarArgParamIndex.getValue()) {
        PCC.setIsVarArgParam();
        continue;
      }
      if (ResolvedParamIndex == ParamCommandComment.Unnamed_enum.InvalidParamIndex.getValue()) {
        UnresolvedParamCommands.push_back(PCC);
        continue;
      }
      PCC.setParamIndex(ResolvedParamIndex);
      if ((ParamVarDocs.$at(ResolvedParamIndex) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceRange ArgRange = PCC.getParamNameRange();
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(ArgRange.getBegin(), diag.warn_doc_param_duplicate)), 
                  /*NO_COPY*/ParamName), /*NO_COPY*/ArgRange));
          ParamCommandComment /*P*/ PrevCommand = ParamVarDocs.$at(ResolvedParamIndex);
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diag(PrevCommand.getLocation(), diag.note_doc_param_previous)), 
              PrevCommand.getParamNameRange()));
        } finally {
          $c$.$destroy();
        }
      }
      ParamVarDocs.$set(ResolvedParamIndex, PCC);
    }
    
    // Find parameter declarations that have no corresponding \\param.
    SmallVector</*const*/ ParmVarDecl /*P*/ > OrphanedParamDecls/*J*/= new SmallVector</*const*/ ParmVarDecl /*P*/ >(8, (/*const*/ ParmVarDecl /*P*/ )null);
    for (/*uint*/int i = 0, e = ParamVarDocs.size(); i != e; ++i) {
      if (!(ParamVarDocs.$at(i) != null)) {
        OrphanedParamDecls.push_back(ParamVars.$at(i));
      }
    }
    
    // Second pass over unresolved \\param commands: do typo correction.
    // Suggest corrections from a set of parameter declarations that have no
    // corresponding \\param.
    for (/*uint*/int i = 0, e = UnresolvedParamCommands.size(); i != e; ++i) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ ParamCommandComment /*P*/ PCC = UnresolvedParamCommands.$at(i);
        
        SourceRange ArgRange = PCC.getParamNameRange();
        StringRef ParamName = PCC.getParamNameAsWritten();
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(ArgRange.getBegin(), diag.warn_doc_param_not_found)), 
                /*NO_COPY*/ParamName), /*NO_COPY*/ArgRange));
        
        // All parameters documented -- can't suggest a correction.
        if (OrphanedParamDecls.size() == 0) {
          continue;
        }
        
        /*uint*/int CorrectedParamIndex = ParamCommandComment.Unnamed_enum.InvalidParamIndex.getValue();
        if (OrphanedParamDecls.size() == 1) {
          // If one parameter is not documented then that parameter is the only
          // possible suggestion.
          CorrectedParamIndex = 0;
        } else {
          // Do typo correction.
          CorrectedParamIndex = correctTypoInParmVarReference(new StringRef(ParamName), 
              new ArrayRef</*const*/ ParmVarDecl /*P*/ >(OrphanedParamDecls, true));
        }
        if (CorrectedParamIndex != ParamCommandComment.Unnamed_enum.InvalidParamIndex.getValue()) {
          /*const*/ ParmVarDecl /*P*/ CorrectedPVD = OrphanedParamDecls.$at(CorrectedParamIndex);
          {
            /*const*/ IdentifierInfo /*P*/ CorrectedII = CorrectedPVD.getIdentifier();
            if ((CorrectedII != null)) {
              $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diag(ArgRange.getBegin(), diag.note_doc_param_name_suggestion)), 
                      CorrectedII.getName()), 
                  FixItHint.CreateReplacement(/*NO_COPY*/ArgRange, CorrectedII.getName())));
            }
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 800,
   FQN="clang::comments::Sema::isFunctionDecl", NM="_ZN5clang8comments4Sema14isFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema14isFunctionDeclEv")
  //</editor-fold>
  public boolean isFunctionDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return ThisDeclInfo.getKind() == DeclInfo.DeclKind.FunctionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isAnyFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 808,
   FQN="clang::comments::Sema::isAnyFunctionDecl", NM="_ZN5clang8comments4Sema17isAnyFunctionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema17isAnyFunctionDeclEv")
  //</editor-fold>
  public boolean isAnyFunctionDecl() {
    return isFunctionDecl() && (ThisDeclInfo.CurrentDecl != null)
       && isa_FunctionDecl(ThisDeclInfo.CurrentDecl);
  }

  
  /// \returns \c true if declaration that this comment is attached to declares
  /// a function pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isFunctionPointerVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 833,
   FQN="clang::comments::Sema::isFunctionPointerVarDecl", NM="_ZN5clang8comments4Sema24isFunctionPointerVarDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema24isFunctionPointerVarDeclEv")
  //</editor-fold>
  public boolean isFunctionPointerVarDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    if (ThisDeclInfo.getKind() == DeclInfo.DeclKind.VariableKind) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(ThisDeclInfo.CurrentDecl);
        if ((VD != null)) {
          QualType QT = VD.getType();
          return QT.$arrow().isFunctionPointerType();
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isFunctionOrMethodVariadic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 813,
   FQN="clang::comments::Sema::isFunctionOrMethodVariadic", NM="_ZN5clang8comments4Sema26isFunctionOrMethodVariadicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema26isFunctionOrMethodVariadicEv")
  //</editor-fold>
  public boolean isFunctionOrMethodVariadic() {
    if (!isAnyFunctionDecl() && !isObjCMethodDecl() && !isFunctionTemplateDecl()) {
      return false;
    }
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ThisDeclInfo.CurrentDecl);
      if ((FD != null)) {
        return FD.isVariadic();
      }
    }
    {
      /*const*/ FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(ThisDeclInfo.CurrentDecl);
      if ((FTD != null)) {
        return FTD.getTemplatedDecl().isVariadic();
      }
    }
    {
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(ThisDeclInfo.CurrentDecl);
      if ((MD != null)) {
        return MD.isVariadic();
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 828,
   FQN="clang::comments::Sema::isObjCMethodDecl", NM="_ZN5clang8comments4Sema16isObjCMethodDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema16isObjCMethodDeclEv")
  //</editor-fold>
  public boolean isObjCMethodDecl() {
    return isFunctionDecl() && (ThisDeclInfo.CurrentDecl != null)
       && isa_ObjCMethodDecl(ThisDeclInfo.CurrentDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isObjCPropertyDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 847,
   FQN="clang::comments::Sema::isObjCPropertyDecl", NM="_ZN5clang8comments4Sema18isObjCPropertyDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema18isObjCPropertyDeclEv")
  //</editor-fold>
  public boolean isObjCPropertyDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return ThisDeclInfo.CurrentDecl.getKind() == Decl.Kind.ObjCProperty;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isTemplateOrSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 855,
   FQN="clang::comments::Sema::isTemplateOrSpecialization", NM="_ZN5clang8comments4Sema26isTemplateOrSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema26isTemplateOrSpecializationEv")
  //</editor-fold>
  public boolean isTemplateOrSpecialization() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return ThisDeclInfo.getTemplateKind() != DeclInfo.TemplateDeclKind.NotTemplate;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isRecordLikeDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 863,
   FQN="clang::comments::Sema::isRecordLikeDecl", NM="_ZN5clang8comments4Sema16isRecordLikeDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema16isRecordLikeDeclEv")
  //</editor-fold>
  public boolean isRecordLikeDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return isUnionDecl() || isClassOrStructDecl() || isObjCInterfaceDecl()
       || isObjCProtocolDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isClassOrStructDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 883,
   FQN="clang::comments::Sema::isClassOrStructDecl", NM="_ZN5clang8comments4Sema19isClassOrStructDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema19isClassOrStructDeclEv")
  //</editor-fold>
  public boolean isClassOrStructDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return (ThisDeclInfo.CurrentDecl != null)
       && isa_RecordDecl(ThisDeclInfo.CurrentDecl)
       && !isUnionDecl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isUnionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 872,
   FQN="clang::comments::Sema::isUnionDecl", NM="_ZN5clang8comments4Sema11isUnionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema11isUnionDeclEv")
  //</editor-fold>
  public boolean isUnionDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    {
      /*const*/ RecordDecl /*P*/ RD = dyn_cast_or_null_RecordDecl(ThisDeclInfo.CurrentDecl);
      if ((RD != null)) {
        return RD.isUnion();
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isObjCInterfaceDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 911,
   FQN="clang::comments::Sema::isObjCInterfaceDecl", NM="_ZN5clang8comments4Sema19isObjCInterfaceDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema19isObjCInterfaceDeclEv")
  //</editor-fold>
  public boolean isObjCInterfaceDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return (ThisDeclInfo.CurrentDecl != null)
       && isa_ObjCInterfaceDecl(ThisDeclInfo.CurrentDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isObjCProtocolDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 920,
   FQN="clang::comments::Sema::isObjCProtocolDecl", NM="_ZN5clang8comments4Sema18isObjCProtocolDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema18isObjCProtocolDeclEv")
  //</editor-fold>
  public boolean isObjCProtocolDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return (ThisDeclInfo.CurrentDecl != null)
       && isa_ObjCProtocolDecl(ThisDeclInfo.CurrentDecl);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isClassTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 893,
   FQN="clang::comments::Sema::isClassTemplateDecl", NM="_ZN5clang8comments4Sema19isClassTemplateDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema19isClassTemplateDeclEv")
  //</editor-fold>
  public boolean isClassTemplateDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return (ThisDeclInfo.CurrentDecl != null)
       && (isa_ClassTemplateDecl(ThisDeclInfo.CurrentDecl));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::isFunctionTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 902,
   FQN="clang::comments::Sema::isFunctionTemplateDecl", NM="_ZN5clang8comments4Sema22isFunctionTemplateDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22isFunctionTemplateDeclEv")
  //</editor-fold>
  public boolean isFunctionTemplateDecl() {
    if (!(ThisDeclInfo != null)) {
      return false;
    }
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return (ThisDeclInfo.CurrentDecl != null)
       && (isa_FunctionTemplateDecl(ThisDeclInfo.CurrentDecl));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::getParamVars">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 929,
   FQN="clang::comments::Sema::getParamVars", NM="_ZN5clang8comments4Sema12getParamVarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema12getParamVarsEv")
  //</editor-fold>
  public ArrayRef</*const*/ ParmVarDecl /*P*/ > getParamVars() {
    if (!ThisDeclInfo.IsFilled) {
      inspectThisDecl();
    }
    return new ArrayRef</*const*/ ParmVarDecl /*P*/ >(ThisDeclInfo.ParamVars);
  }

  
  /// Extract all important semantic information from
  /// \c ThisDeclInfo->ThisDecl into \c ThisDeclInfo members.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::inspectThisDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 935,
   FQN="clang::comments::Sema::inspectThisDecl", NM="_ZN5clang8comments4Sema15inspectThisDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema15inspectThisDeclEv")
  //</editor-fold>
  public void inspectThisDecl() {
    ThisDeclInfo.fill();
  }

  
  /// Returns index of a function parameter with a given name.
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::resolveParmVarReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 939,
   FQN="clang::comments::Sema::resolveParmVarReference", NM="_ZN5clang8comments4Sema23resolveParmVarReferenceEN4llvm9StringRefENS2_8ArrayRefIPKNS_11ParmVarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema23resolveParmVarReferenceEN4llvm9StringRefENS2_8ArrayRefIPKNS_11ParmVarDeclEEE")
  //</editor-fold>
  public /*uint*/int resolveParmVarReference(StringRef Name, 
                         ArrayRef</*const*/ ParmVarDecl /*P*/ > ParamVars) {
    for (/*uint*/int i = 0, e = ParamVars.size(); i != e; ++i) {
      /*const*/ IdentifierInfo /*P*/ II = ParamVars.$at(i).getIdentifier();
      if ((II != null) && $eq_StringRef(II.getName(), /*NO_COPY*/Name)) {
        return i;
      }
    }
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"...") && isFunctionOrMethodVariadic()) {
      return ParamCommandComment.Unnamed_enum.VarArgParamIndex.getValue();
    }
    return ParamCommandComment.Unnamed_enum.InvalidParamIndex.getValue();
  }

  
  /// Returns index of a function parameter with the name closest to a given
  /// typo.
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::correctTypoInParmVarReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1005,
   FQN="clang::comments::Sema::correctTypoInParmVarReference", NM="_ZN5clang8comments4Sema29correctTypoInParmVarReferenceEN4llvm9StringRefENS2_8ArrayRefIPKNS_11ParmVarDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema29correctTypoInParmVarReferenceEN4llvm9StringRefENS2_8ArrayRefIPKNS_11ParmVarDeclEEE")
  //</editor-fold>
  public /*uint*/int correctTypoInParmVarReference(StringRef Typo, 
                               ArrayRef</*const*/ ParmVarDecl /*P*/ > ParamVars) {
    SimpleTypoCorrector Corrector/*J*/= new SimpleTypoCorrector(new StringRef(Typo));
    for (/*uint*/int i = 0, e = ParamVars.size(); i != e; ++i)  {
      Corrector.addDecl(ParamVars.$at(i));
    }
    if ((Corrector.getBestDecl() != null)) {
      return Corrector.getBestDeclIndex();
    } else {
      return ParamCommandComment.Unnamed_enum.InvalidParamIndex.getValue();
    }
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::resolveTParamReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1043,
   FQN="clang::comments::Sema::resolveTParamReference", NM="_ZN5clang8comments4Sema22resolveTParamReferenceEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema22resolveTParamReferenceEN4llvm9StringRefEPKNS_21TemplateParameterListEPNS2_15SmallVectorImplIjEE")
  //</editor-fold>
  public boolean resolveTParamReference(StringRef Name, 
                        /*const*/ TemplateParameterList /*P*/ TemplateParameters, 
                        SmallVectorImplUInt/*P*/ Position) {
    Position.clear();
    if (!(TemplateParameters != null)) {
      return false;
    }
    
    return ResolveTParamReferenceHelper(new StringRef(Name), TemplateParameters, Position);
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::correctTypoInTParamReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1070,
   FQN="clang::comments::Sema::correctTypoInTParamReference", NM="_ZN5clang8comments4Sema28correctTypoInTParamReferenceEN4llvm9StringRefEPKNS_21TemplateParameterListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments4Sema28correctTypoInTParamReferenceEN4llvm9StringRefEPKNS_21TemplateParameterListE")
  //</editor-fold>
  public StringRef correctTypoInTParamReference(StringRef Typo, 
                              /*const*/ TemplateParameterList /*P*/ TemplateParameters) {
    SimpleTypoCorrector Corrector/*J*/= new SimpleTypoCorrector(new StringRef(Typo));
    CorrectTypoInTParamReferenceHelper(TemplateParameters, Corrector);
    {
      /*const*/ NamedDecl /*P*/ ND = Corrector.getBestDecl();
      if ((ND != null)) {
        /*const*/ IdentifierInfo /*P*/ II = ND.getIdentifier();
        assert ((II != null)) : "SimpleTypoCorrector should not return this decl";
        return II.getName();
      }
    }
    return new StringRef();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::getInlineCommandRenderKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 1083,
   FQN="clang::comments::Sema::getInlineCommandRenderKind", NM="_ZNK5clang8comments4Sema26getInlineCommandRenderKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZNK5clang8comments4Sema26getInlineCommandRenderKindEN4llvm9StringRefE")
  //</editor-fold>
  public InlineCommandComment.RenderKind getInlineCommandRenderKind(StringRef Name) /*const*/ {
    assert Native.$bool(Traits.getCommandInfo(new StringRef(Name)).IsInlineCommand);
    
    return new StringSwitch<InlineCommandComment.RenderKind>(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"b", InlineCommandComment.RenderKind.RenderBold).
        Cases(/*KEEP_STR*/"c", /*KEEP_STR*/"p", InlineCommandComment.RenderKind.RenderMonospaced).
        Cases(/*KEEP_STR*/"a", /*KEEP_STR*/"e", /*KEEP_STR*/"em", InlineCommandComment.RenderKind.RenderEmphasized).
        Default(InlineCommandComment.RenderKind.RenderNormal);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::comments::Sema::~Sema">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentSema.h", line = 33,
   FQN="clang::comments::Sema::~Sema", NM="_ZN5clang8comments4SemaD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RawCommentList.cpp -nm=_ZN5clang8comments4SemaD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    HTMLOpenTags.$destroy();
    TemplateParameterDocs.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "Allocator=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", SourceMgr=" + "[SourceManager]" // NOI18N
              + ", Diags=" + "[DiagnosticsEngine]" // NOI18N
              + ", Traits=" + Traits // NOI18N
              + ", PP=" + "[Preprocessor]" // NOI18N
              + ", ThisDeclInfo=" + ThisDeclInfo // NOI18N
              + ", TemplateParameterDocs=" + TemplateParameterDocs // NOI18N
              + ", BriefCommand=" + BriefCommand // NOI18N
              + ", HeaderfileCommand=" + HeaderfileCommand // NOI18N
              + ", HTMLOpenTags=" + HTMLOpenTags; // NOI18N
  }
}
