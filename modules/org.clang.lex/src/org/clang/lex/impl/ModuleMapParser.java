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

package org.clang.lex.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.llvm.*;
import org.clang.lex.impl.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.Module.Header;
import static org.clang.lex.impl.ModuleMapStatics.*;
import org.llvm.support.sys.path;
import org.clang.basic.java.ClankAliases;
import org.clang.basic.vfs.FileSystem;
import org.clang.basic.vfs.recursive_directory_iterator;

//<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1007,
 FQN = "clang::ModuleMapParser", NM = "_ZN5clang15ModuleMapParserE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParserE")
//</editor-fold>
public class ModuleMapParser implements Destructors.ClassWithDestructor {
  private Lexer /*&*/ L;
  private SourceManager /*&*/ SourceMgr;
  
  /// \brief Default target information, used only for string literal
  /// parsing.
  private /*const*/ TargetInfo /*P*/ Target;
  
  private DiagnosticsEngine /*&*/ Diags;
  private ModuleMap /*&*/ Map;
  
  /// \brief The current module map file.
  private /*const*/ FileEntry /*P*/ ModuleMapFile;
  
  /// \brief The directory that file names in this module map file should
  /// be resolved relative to.
  private /*const*/ DirectoryEntry /*P*/ Directory;
  
  /// \brief The directory containing Clang-supplied headers.
  private /*const*/ DirectoryEntry /*P*/ BuiltinIncludeDir;
  
  /// \brief Whether this module map is in a system header directory.
  private boolean IsSystem;
  
  /// \brief Whether an error occurred.
  private boolean HadError;
  
  /// \brief Stores string data for the various string literals referenced
  /// during parsing.
  private BumpPtrAllocatorImpl StringData;
  
  /// \brief The current token.
  private MMToken Tok;
  
  /// \brief The active module.
  private Module /*P*/ ActiveModule;
  
  /// \brief Whether a module uses the 'requires excluded' hack to mark its
  /// contents as 'textual'.
  ///
  /// On older Darwin SDK versions, 'requires excluded' is used to mark the
  /// contents of the Darwin.C.excluded (assert.h) and Tcl.Private modules as
  /// non-modular headers.  For backwards compatibility, we continue to
  /// support this idiom for just these modules, and map the headers to
  /// 'textual' to match the original intent.
  private SmallPtrSet<Module /*P*/ > UsesRequiresExcludedHack;
  
  /// \brief Consume the current token and return its location.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::consumeToken">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1101,
   FQN = "clang::ModuleMapParser::consumeToken", NM = "_ZN5clang15ModuleMapParser12consumeTokenEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser12consumeTokenEv")
  //</editor-fold>
  private SourceLocation consumeToken() {
    retry: while (true) {
      SourceLocation Result = Tok.getLocation();
      Tok.clear();

      Token LToken/*J*/= new Token();
      L.LexFromRawLexer(LToken);
      Tok.Location = LToken.getLocation().getRawEncoding();
      switch (LToken.getKind()) {
       case tok.TokenKind.raw_identifier:
        {
          StringRef RI = LToken.getRawIdentifier();
          Tok.StringData = $tryClone(RI.data());
          Tok.StringLength = RI.size();
          Tok.Kind = new StringSwitchUShort/*MMToken.TokenKind*/(/*NO_COPY*/RI).
              Case(/*KEEP_STR*/"config_macros", MMToken.TokenKind.ConfigMacros).
              Case(/*KEEP_STR*/"conflict", MMToken.TokenKind.Conflict).
              Case(/*KEEP_STR*/"exclude", MMToken.TokenKind.ExcludeKeyword).
              Case(/*KEEP_STR*/"explicit", MMToken.TokenKind.ExplicitKeyword).
              Case(/*KEEP_STR*/"export", MMToken.TokenKind.ExportKeyword).
              Case(/*KEEP_STR*/"extern", MMToken.TokenKind.ExternKeyword).
              Case(/*KEEP_STR*/"framework", MMToken.TokenKind.FrameworkKeyword).
              Case(/*KEEP_STR*/"header", MMToken.TokenKind.HeaderKeyword).
              Case(/*KEEP_STR*/"link", MMToken.TokenKind.LinkKeyword).
              Case(/*KEEP_STR*/"module", MMToken.TokenKind.ModuleKeyword).
              Case(/*KEEP_STR*/"private", MMToken.TokenKind.PrivateKeyword).
              Case(/*KEEP_STR*/"requires", MMToken.TokenKind.RequiresKeyword).
              Case(/*KEEP_STR*/"textual", MMToken.TokenKind.TextualKeyword).
              Case(/*KEEP_STR*/"umbrella", MMToken.TokenKind.UmbrellaKeyword).
              Case(/*KEEP_STR*/"use", MMToken.TokenKind.UseKeyword).
                  Default(MMToken.TokenKind.Identifier);
          break;
        }
       case tok.TokenKind.comma:
        Tok.Kind = MMToken.TokenKind.Comma;
        break;
       case tok.TokenKind.eof:
        Tok.Kind = MMToken.TokenKind.EndOfFile;
        break;
       case tok.TokenKind.l_brace:
        Tok.Kind = MMToken.TokenKind.LBrace;
        break;
       case tok.TokenKind.l_square:
        Tok.Kind = MMToken.TokenKind.LSquare;
        break;
       case tok.TokenKind.period:
        Tok.Kind = MMToken.TokenKind.Period;
        break;
       case tok.TokenKind.r_brace:
        Tok.Kind = MMToken.TokenKind.RBrace;
        break;
       case tok.TokenKind.r_square:
        Tok.Kind = MMToken.TokenKind.RSquare;
        break;
       case tok.TokenKind.star:
        Tok.Kind = MMToken.TokenKind.Star;
        break;
       case tok.TokenKind.exclaim:
        Tok.Kind = MMToken.TokenKind.Exclaim;
        break;
       case tok.TokenKind.string_literal:
        {
          if (LToken.hasUDSuffix()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(Diags.Report(LToken.getLocation(), diag.err_invalid_string_udl)));
              HadError = true;
              continue retry;
            } finally {
              $c$.$destroy();
            }
          }

          // Parse the string literal.
          LangOptions LangOpts/*J*/= new LangOptions();
          StringLiteralParser StringLiteral/*J*/= new StringLiteralParser(new ArrayRefToken(LToken), SourceMgr, LangOpts, $Deref(Target));
          if (StringLiteral.hadError()) {
            continue retry;
          }

          // Copy the string literal into our string data allocator.
          /*uint*/int Length = StringLiteral.GetStringLength();
          char$ptr/*char P*/ Saved = StringData.Allocate(Length + 1);
          memcpy(Saved, StringLiteral.GetString().data(), Length);
          Saved.$set(Length, $$TERM);

          // Form the token.
          Tok.Kind = MMToken.TokenKind.StringLiteral;
          Tok.StringData = $tryClone(Saved);
          Tok.StringLength = Length;
          break;
        }
       case tok.TokenKind.comment:
        continue retry;
       default:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diags.Report(LToken.getLocation(), diag.err_mmap_unknown_token)));
            HadError = true;
            continue retry;
          } finally {
            $c$.$destroy();
          }
        }
      }

      return Result;
    }
  }

  
  /// \brief Skip tokens until we reach the a token with the given kind
  /// (or the end of the file).
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::skipUntil">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1208,
   FQN = "clang::ModuleMapParser::skipUntil", NM = "_ZN5clang15ModuleMapParser9skipUntilENS_7MMToken9TokenKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser9skipUntilENS_7MMToken9TokenKindE")
  //</editor-fold>
  private void skipUntil(/*MMToken.TokenKind*/char K) {
    /*uint*/int braceDepth = 0;
    /*uint*/int squareDepth = 0;
    do {
      switch (Tok.Kind) {
       case MMToken.TokenKind.EndOfFile:
        return;
       case MMToken.TokenKind.LBrace:
        if (Tok.is(K) && braceDepth == 0 && squareDepth == 0) {
          return;
        }
        
        ++braceDepth;
        break;
       case MMToken.TokenKind.LSquare:
        if (Tok.is(K) && braceDepth == 0 && squareDepth == 0) {
          return;
        }
        
        ++squareDepth;
        break;
       case MMToken.TokenKind.RBrace:
        if ($greater_uint(braceDepth, 0)) {
          --braceDepth;
        } else if (Tok.is(K)) {
          return;
        }
        break;
       case MMToken.TokenKind.RSquare:
        if ($greater_uint(squareDepth, 0)) {
          --squareDepth;
        } else if (Tok.is(K)) {
          return;
        }
        break;
       default:
        if (braceDepth == 0 && squareDepth == 0 && Tok.is(K)) {
          return;
        }
        break;
      }
      
      consumeToken();
    } while (true);
  }

  
  /*typedef SmallVector<std::pair<std::string, SourceLocation>, 2> ModuleId*/
//  public final class ModuleId extends SmallVector<std.pair<std.string, SourceLocation>>{ };
  
  /// \brief Parse a module-id.
  ///
  ///   module-id:
  ///     identifier
  ///     identifier '.' module-id
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseModuleId">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1261,
   FQN = "clang::ModuleMapParser::parseModuleId", NM = "_ZN5clang15ModuleMapParser13parseModuleIdERN4llvm11SmallVectorISt4pairISsNS_14SourceLocationEELj2EEE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser13parseModuleIdERN4llvm11SmallVectorISt4pairISsNS_14SourceLocationEELj2EEE")
  //</editor-fold>
  private boolean parseModuleId(ClankAliases.ModuleId/*&*/ Id) {
    Id.clear();
    do {
      if (Tok.is(MMToken.TokenKind.Identifier) || Tok.is(MMToken.TokenKind.StringLiteral)) {
        Id.push_back(new std.pairTypeType<std.string, SourceLocation>(std.make_pair(Tok.getString().$string(), Tok.getLocation())));
        consumeToken();
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_module_name)));
          return true;
        } finally {
          $c$.$destroy();
        }        
      }
      if (!Tok.is(MMToken.TokenKind.Period)) {
        break;
      }

      consumeToken();
    } while (true);

    return false;
  }

  
  /// \brief Parse a module declaration.
  ///
  ///   module-declaration:
  ///     'extern' 'module' module-id string-literal
  ///     'explicit'[opt] 'framework'[opt] 'module' module-id attributes[opt] 
  ///       { module-member* }
  ///
  ///   module-member:
  ///     requires-declaration
  ///     header-declaration
  ///     submodule-declaration
  ///     export-declaration
  ///     link-declaration
  ///
  ///   submodule-declaration:
  ///     module-declaration
  ///     inferred-submodule-declaration
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseModuleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1312,
   FQN = "clang::ModuleMapParser::parseModuleDecl", NM = "_ZN5clang15ModuleMapParser15parseModuleDeclEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser15parseModuleDeclEv")
  //</editor-fold>
  private void parseModuleDecl() {
    assert (Tok.is(MMToken.TokenKind.ExplicitKeyword) || Tok.is(MMToken.TokenKind.ModuleKeyword) || Tok.is(MMToken.TokenKind.FrameworkKeyword) || Tok.is(MMToken.TokenKind.ExternKeyword));
    if (Tok.is(MMToken.TokenKind.ExternKeyword)) {
      parseExternModuleDecl();
      return;
    }

    // Parse 'explicit' or 'framework' keyword, if present.
    SourceLocation ExplicitLoc/*J*/= new SourceLocation();
    boolean Explicit = false;
    boolean Framework = false;

    // Parse 'explicit' keyword, if present.
    if (Tok.is(MMToken.TokenKind.ExplicitKeyword)) {
      ExplicitLoc.$assignMove(consumeToken());
      Explicit = true;
    }

    // Parse 'framework' keyword, if present.
    if (Tok.is(MMToken.TokenKind.FrameworkKeyword)) {
      consumeToken();
      Framework = true;
    }

    // Parse 'module' keyword.
    if (!Tok.is(MMToken.TokenKind.ModuleKeyword)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {      
        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_module)));
        consumeToken();
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }      
    }
    consumeToken(); // 'module' keyword

    // If we have a wildcard for the module name, this is an inferred submodule.
    // Parse it. 
    if (Tok.is(MMToken.TokenKind.Star)) {
      parseInferredModuleDecl(Framework, Explicit);
      return;
    }

    // Parse the module name.
    ClankAliases.ModuleId Id/*J*/= new ClankAliases.ModuleId();
    if (parseModuleId(Id)) {
      HadError = true;
      return;
    }
    if ((ActiveModule != null)) {
      if ($greater_uint(Id.size(), 1)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {        
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(/*NO_COPY*/Id.front().second, diag.err_mmap_nested_submodule_id)), 
              new SourceRange(/*NO_COPY*/Id.front().second, /*NO_COPY*/Id.back().second)));

          HadError = true;
          return;
        } finally {
          $c$.$destroy();
        }        
      }
    } else if (Id.size() == 1 && Explicit) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Top-level modules can't be explicit.
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/ExplicitLoc, diag.err_mmap_explicit_top_level)));
        Explicit = false;
        ExplicitLoc.$assignMove(new SourceLocation());
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }

    Module /*P*/ PreviousActiveModule = ActiveModule;
    if ($greater_uint(Id.size(), 1)) {
      // This module map defines a submodule. Go find the module of which it
      // is a submodule.
      ActiveModule = null;
      /*const*/ Module /*P*/ TopLevelModule = null;
      for (/*uint*/int I = 0, N = Id.size() - 1; I != N; ++I) {
        {
          Module /*P*/ Next = Map.lookupModuleQualified(new StringRef(Id.$at(I).first), ActiveModule);
          if ((Next != null)) {
            if (I == 0) {
              TopLevelModule = Next;
            }
            ActiveModule = Next;
            continue;
          }
        }
        if ((ActiveModule != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Id.$at(I).second, diag.err_mmap_missing_module_qualified)), 
                    new StringRef(Id.$at(I).first)), 
                new StringRef(ActiveModule.getTopLevelModule().getFullModuleName())));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Id.$at(I).second, diag.err_mmap_expected_module_name)));
          } finally {
            $c$.$destroy();
          }
        }
        HadError = true;
        return;
      }
      if (ModuleMapFile != Map.getContainingModuleMapFile(TopLevelModule)) {
        assert (ModuleMapFile != Map.getModuleMapFileForUniquing(TopLevelModule)) : "submodule defined in same file as 'module *' that allowed its top-level module";
        Map.addAdditionalModuleMapFile(TopLevelModule, ModuleMapFile);
      }
    }

    StringRef ModuleName = new StringRef(Id.back().first);
    /*SourceLocation*/int ModuleNameLoc = Id.back().second.getRawEncoding();

    // Parse the optional attribute list.
    ModuleMap.Attributes Attrs/*J*/= new ModuleMap.Attributes();
    if (parseOptionalAttributes(Attrs)) {
      return;
    }

    // Parse the opening brace.
    if (!Tok.is(MMToken.TokenKind.LBrace)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_lbrace)), 
            /*NO_COPY*/ModuleName));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    SourceLocation LBraceLoc = consumeToken();
    {

      // Determine whether this (sub)module has already been defined.
      Module /*P*/ Existing = Map.lookupModuleQualified(/*NO_COPY*/ModuleName, ActiveModule);
      if ((Existing != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (Existing.DefinitionLoc.isInvalid() && !(ActiveModule != null)) {
            // Skip the module definition.
            skipUntil(MMToken.TokenKind.RBrace);
            if (Tok.is(MMToken.TokenKind.RBrace)) {
              consumeToken();
            } else {
              $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_rbrace)));
              $c$.clean($c$.track(Diags.Report(/*NO_COPY*/LBraceLoc, diag.note_mmap_lbrace_match)));
              HadError = true;
            }
            return;
          }
          
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/ModuleNameLoc, diag.err_mmap_module_redefinition)), 
              /*NO_COPY*/ModuleName));
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/Existing.DefinitionLoc, diag.note_mmap_prev_definition)));
          
          // Skip the module definition.
          skipUntil(MMToken.TokenKind.RBrace);
          if (Tok.is(MMToken.TokenKind.RBrace)) {
            consumeToken();
          }
          
          HadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }

    // Start defining this module.
    ActiveModule = Map.findOrCreateModule(/*NO_COPY*/ModuleName, ActiveModule, Framework, 
        Explicit).first;
    ActiveModule.DefinitionLoc.$assign(ModuleNameLoc);
    if (Attrs.IsSystem || IsSystem) {
      ActiveModule.IsSystem = true;
    }
    if (Attrs.IsExternC) {
      ActiveModule.IsExternC = true;
    }
    ActiveModule.Directory = Directory;

    boolean Done = false;
    do {
      switch (Tok.Kind) {
       case MMToken.TokenKind.EndOfFile:
       case MMToken.TokenKind.RBrace:
        Done = true;
        break;
       case MMToken.TokenKind.ConfigMacros:
        parseConfigMacros();
        break;
       case MMToken.TokenKind.Conflict:
        parseConflict();
        break;
       case MMToken.TokenKind.ExplicitKeyword:
       case MMToken.TokenKind.ExternKeyword:
       case MMToken.TokenKind.FrameworkKeyword:
       case MMToken.TokenKind.ModuleKeyword:
        parseModuleDecl();
        break;
       case MMToken.TokenKind.ExportKeyword:
        parseExportDecl();
        break;
       case MMToken.TokenKind.UseKeyword:
        parseUseDecl();
        break;
       case MMToken.TokenKind.RequiresKeyword:
        parseRequiresDecl();
        break;
       case MMToken.TokenKind.TextualKeyword:
        parseHeaderDecl(MMToken.TokenKind.TextualKeyword, consumeToken());
        break;
       case MMToken.TokenKind.UmbrellaKeyword:
        {
          SourceLocation UmbrellaLoc = consumeToken();
          if (Tok.is(MMToken.TokenKind.HeaderKeyword)) {
            parseHeaderDecl(MMToken.TokenKind.UmbrellaKeyword, /*NO_COPY*/UmbrellaLoc);
          } else {
            parseUmbrellaDirDecl(/*NO_COPY*/UmbrellaLoc);
          }
          break;
        }
       case MMToken.TokenKind.ExcludeKeyword:
        parseHeaderDecl(MMToken.TokenKind.ExcludeKeyword, consumeToken());
        break;
       case MMToken.TokenKind.PrivateKeyword:
        parseHeaderDecl(MMToken.TokenKind.PrivateKeyword, consumeToken());
        break;
       case MMToken.TokenKind.HeaderKeyword:
        parseHeaderDecl(MMToken.TokenKind.HeaderKeyword, consumeToken());
        break;
       case MMToken.TokenKind.LinkKeyword:
        parseLinkDecl();
        break;
       default:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_member)));
            consumeToken();
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    } while (!Done);
    if (Tok.is(MMToken.TokenKind.RBrace)) {
      consumeToken();
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_rbrace)));
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/LBraceLoc, diag.note_mmap_lbrace_match)));
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }

    // If the active module is a top-level framework, and there are no link
    // libraries, automatically link against the framework.
    if (ActiveModule.IsFramework && !ActiveModule.isSubFramework()
       && ActiveModule.LinkLibraries.empty()) {
      inferFrameworkLink(ActiveModule, Directory, SourceMgr.getFileManager());
    }

    // If the module meets all requirements but is still unavailable, mark the
    // whole tree as unavailable to prevent it from building.
    if (!ActiveModule.IsAvailable && !ActiveModule.IsMissingRequirement
       && (ActiveModule.Parent != null)) {
      ActiveModule.getTopLevelModule().markUnavailable();
      ActiveModule.getTopLevelModule().MissingHeaders.append_T(ActiveModule.MissingHeaders.begin(), ActiveModule.MissingHeaders.end());
    }

    // We're done parsing this module. Pop back to the previous module.
    ActiveModule = PreviousActiveModule;
  }

  
  /// \brief Parse an extern module declaration.
  ///
  ///   extern module-declaration:
  ///     'extern' 'module' module-id string-literal
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseExternModuleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1566,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1564,
   FQN="clang::ModuleMapParser::parseExternModuleDecl", NM="_ZN5clang15ModuleMapParser21parseExternModuleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser21parseExternModuleDeclEv")
  //</editor-fold>
  private void parseExternModuleDecl() {
    assert (Tok.is(MMToken.TokenKind.ExternKeyword));
    SourceLocation ExternLoc = consumeToken(); // 'extern' keyword

    // Parse 'module' keyword.
    if (!Tok.is(MMToken.TokenKind.ModuleKeyword)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_module)));
        consumeToken();
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    consumeToken(); // 'module' keyword

    // Parse the module name.
    ClankAliases.ModuleId Id/*J*/= new ClankAliases.ModuleId();
    if (parseModuleId(Id)) {
      HadError = true;
      return;
    }

    // Parse the referenced module map file name.
    if (!Tok.is(MMToken.TokenKind.StringLiteral)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_mmap_file)));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    std.string FileName = Tok.getString().$string();
    consumeToken(); // filename

    StringRef FileNameRef = new StringRef(FileName);
    SmallString/*128*/ ModuleMapFileName/*J*/= new SmallString/*128*/(128);
    if (path.is_relative(new Twine(FileNameRef))) {
      ModuleMapFileName.$addassign(/*STRINGREF_STR*/Directory.getName());
      path.append(ModuleMapFileName, new Twine(FileName));
      FileNameRef.$assignMove(ModuleMapFileName.$StringRef());
    }
    {
      /*const*/ FileEntry /*P*/ File = SourceMgr.getFileManager().getFile(/*NO_COPY*/FileNameRef);
      if ((File != null)) {
        Map.parseModuleMapFile(File, /*IsSystem=*/ false, 
            Map.HeaderInfo.getHeaderSearchOpts().ModuleMapFileHomeIsCwd ? Directory : File.getDir(), /*NO_COPY*/ExternLoc);
      }
    }
  }

  
  /// \brief Parse a requires declaration.
  ///
  ///   requires-declaration:
  ///     'requires' feature-list
  ///
  ///   feature-list:
  ///     feature ',' feature-list
  ///     feature
  ///
  ///   feature:
  ///     '!'[opt] identifier
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseRequiresDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1653,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1651,
   FQN="clang::ModuleMapParser::parseRequiresDecl", NM="_ZN5clang15ModuleMapParser17parseRequiresDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser17parseRequiresDeclEv")
  //</editor-fold>
  private void parseRequiresDecl() {
    assert (Tok.is(MMToken.TokenKind.RequiresKeyword));

    // Parse 'requires' keyword.
    consumeToken();

    // Parse the feature-list.
    do {
      boolean RequiredState = true;
      if (Tok.is(MMToken.TokenKind.Exclaim)) {
        RequiredState = false;
        consumeToken();
      }
      if (!Tok.is(MMToken.TokenKind.Identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_feature)));
          HadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }

      // Consume the feature name.
      std.string Feature = Tok.getString().$string();
      consumeToken();

      bool$ref IsRequiresExcludedHack = create_bool$ref(false);
      boolean ShouldAddRequirement = shouldAddRequirement(ActiveModule, new StringRef(Feature), IsRequiresExcludedHack);
      if (IsRequiresExcludedHack.$deref()) {
        UsesRequiresExcludedHack.insert(ActiveModule);
      }
      if (ShouldAddRequirement) {
        // Add this feature.
        ActiveModule.addRequirement(new StringRef(Feature), RequiredState, Map.LangOpts, 
            $Deref(Map.Target));
      }
      if (!Tok.is(MMToken.TokenKind.Comma)) {
        break;
      }

      // Consume the comma.
      consumeToken();
    } while (true);
  }

  
  /// \brief Parse a header declaration.
  ///
  ///   header-declaration:
  ///     'textual'[opt] 'header' string-literal
  ///     'private' 'textual'[opt] 'header' string-literal
  ///     'exclude' 'header' string-literal
  ///     'umbrella' 'header' string-literal
  ///
  /// FIXME: Support 'private textual header'.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseHeaderDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1726,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1724,
   FQN="clang::ModuleMapParser::parseHeaderDecl", NM="_ZN5clang15ModuleMapParser15parseHeaderDeclENS_7MMToken9TokenKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser15parseHeaderDeclENS_7MMToken9TokenKindENS_14SourceLocationE")
  //</editor-fold>
  private void parseHeaderDecl(/*MMToken.TokenKind*/char LeadingToken, 
                 SourceLocation LeadingLoc) {
    Module.UnresolvedHeaderDirective Header = null;
    try {
      // We've already consumed the first token.
      /*ModuleMap::ModuleHeaderRole*//*uint*/int Role = ModuleMap.ModuleHeaderRole.NormalHeader;
      if (LeadingToken == MMToken.TokenKind.PrivateKeyword) {
        Role = ModuleMap.ModuleHeaderRole.PrivateHeader;
        // 'private' may optionally be followed by 'textual'.
        if (Tok.is(MMToken.TokenKind.TextualKeyword)) {
          LeadingToken = Tok.Kind;
          consumeToken();
        }
      }
      if (LeadingToken == MMToken.TokenKind.TextualKeyword) {
        Role = ((/*ModuleMap::ModuleHeaderRole*//*uint*/int)(Role | ModuleMap.ModuleHeaderRole.TextualHeader));
      }
      if ((UsesRequiresExcludedHack.count(ActiveModule) != 0)) {
        // Mark this header 'textual' (see doc comment for
        // Module::UsesRequiresExcludedHack).
        Role = ((/*ModuleMap::ModuleHeaderRole*//*uint*/int)(Role | ModuleMap.ModuleHeaderRole.TextualHeader));
      }
      if (LeadingToken != MMToken.TokenKind.HeaderKeyword) {
        if (!Tok.is(MMToken.TokenKind.HeaderKeyword)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_header)), 
                (LeadingToken == MMToken.TokenKind.PrivateKeyword ? $private : LeadingToken == MMToken.TokenKind.ExcludeKeyword ? $("exclude") : LeadingToken == MMToken.TokenKind.TextualKeyword ? $("textual") : $("umbrella"))));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        consumeToken();
      }

      // Parse the header name.
      if (!Tok.is(MMToken.TokenKind.StringLiteral)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_header)), 
              /*KEEP_STR*/"header"));
          HadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }
      Header/*J*/= new Module.UnresolvedHeaderDirective();
      Header.FileName.$assignMove(Tok.getString().$string());
      Header.FileNameLoc.$assignMove(consumeToken());

      // Check whether we already have an umbrella.
      if (LeadingToken == MMToken.TokenKind.UmbrellaKeyword && ActiveModule.Umbrella.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/Header.FileNameLoc, diag.err_mmap_umbrella_clash)), 
              new StringRef(ActiveModule.getFullModuleName())));
          HadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }

      // Look for this file.
      /*const*/ FileEntry /*P*/ File = null;
      /*const*/ FileEntry /*P*/ BuiltinFile = null;
      SmallString/*128*/ RelativePathName/*J*/= new SmallString/*128*/(128);
      if (path.is_absolute(new Twine(Header.FileName))) {
        RelativePathName.$assign(new StringRef(Header.FileName));
        File = SourceMgr.getFileManager().getFile(RelativePathName.$StringRef());
      } else {
        // Search for the header file within the search directory.
        SmallString/*128*/ FullPathName/*J*/= new SmallString/*128*/(new StringRef(Directory.getName()), 128);
        /*uint*/int FullPathLength = FullPathName.size();
        if (ActiveModule.isPartOfFramework()) {
          appendSubframeworkPaths(ActiveModule, RelativePathName);

          // Check whether this file is in the public headers.
          path.append(RelativePathName, new Twine(/*KEEP_STR*/"Headers"), new Twine(Header.FileName));
          path.append(FullPathName, new Twine(RelativePathName));
          File = SourceMgr.getFileManager().getFile(FullPathName.$StringRef());
          if (!(File != null)) {
            // Check whether this file is in the private headers.
            // FIXME: Should we retain the subframework paths here?
            RelativePathName.clear();
            FullPathName.resize(FullPathLength);
            path.append(RelativePathName, new Twine(/*KEEP_STR*/"PrivateHeaders"), 
                new Twine(Header.FileName));
            path.append(FullPathName, new Twine(RelativePathName));
            File = SourceMgr.getFileManager().getFile(FullPathName.$StringRef());
          }
        } else {
          // Lookup for normal headers.
          path.append(RelativePathName, new Twine(Header.FileName));
          path.append(FullPathName, new Twine(RelativePathName));
          File = SourceMgr.getFileManager().getFile(FullPathName.$StringRef());

          // If this is a system module with a top-level header, this header
          // may have a counterpart (or replacement) in the set of headers
          // supplied by Clang. Find that builtin header.
          if (ActiveModule.IsSystem && LeadingToken != MMToken.TokenKind.UmbrellaKeyword
             && (BuiltinIncludeDir != null) && BuiltinIncludeDir != Directory
             && isBuiltinHeader(new StringRef(Header.FileName))) {
            SmallString/*128*/ BuiltinPathName/*J*/= new SmallString/*128*/(new StringRef(BuiltinIncludeDir.getName()), 128);
            path.append(BuiltinPathName, new Twine(Header.FileName));
            BuiltinFile = SourceMgr.getFileManager().getFile(BuiltinPathName.$StringRef());

            // If Clang supplies this header but the underlying system does not,
            // just silently swap in our builtin version. Otherwise, we'll end
            // up adding both (later).
            //
            // For local visibility, entirely replace the system file with our
            // one and textually include the system one. We need to pass macros
            // from our header to the system one if we #include_next it.
            //
            // FIXME: Can we do this in all cases?
            if ((BuiltinFile != null) && (!(File != null) || Map.LangOpts.ModulesLocalVisibility)) {
              File = BuiltinFile;
              RelativePathName.$assign(BuiltinPathName);
              BuiltinFile = null;
            }
          }
        }
      }

      // FIXME: We shouldn't be eagerly stat'ing every file named in a module map.
      // Come up with a lazy way to do this.
      if ((File != null)) {
        if (LeadingToken == MMToken.TokenKind.UmbrellaKeyword) {
          /*const*/ DirectoryEntry /*P*/ UmbrellaDir = File.getDir();
          {
            Module /*P*/ UmbrellaModule = Map.UmbrellaDirs.$at(UmbrellaDir);
            if ((UmbrellaModule != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/LeadingLoc, diag.err_mmap_umbrella_clash)), 
                    new StringRef(UmbrellaModule.getFullModuleName())));
                HadError = true;
              } finally {
                $c$.$destroy();
              }
            } else {
              // Record this umbrella header.
              Map.setUmbrellaHeader(ActiveModule, File, new Twine(RelativePathName.str()));
            }
          }
        } else if (LeadingToken == MMToken.TokenKind.ExcludeKeyword) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            Module.Header H = new Module.Header(RelativePathName.str(), File);
            Map.excludeHeader(ActiveModule, $c$.track(new Module.Header(H))); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // If there is a builtin counterpart to this file, add it now, before
            // the "real" header, so we build the built-in one first when building
            // the module.
            if ((BuiltinFile != null)) {
              // FIXME: Taking the name from the FileEntry is unstable and can give
              // different results depending on how we've previously named that file
              // in this build.
              Module.Header H = new Module.Header(BuiltinFile.getName(), BuiltinFile);
              Map.addHeader(ActiveModule, $c$.track(new Module.Header(H)), Role); $c$.clean();
            }

            // Record this header.
            Module.Header H = new Module.Header(RelativePathName.str(), File);
            Map.addHeader(ActiveModule, $c$.track(new Module.Header(H)), Role); $c$.clean();
          } finally {
            $c$.$destroy();
          }
        }
      } else if (LeadingToken != MMToken.TokenKind.ExcludeKeyword) {
        // Ignore excluded header files. They're optional anyway.

        // If we find a module that has a missing header, we mark this module as
        // unavailable and store the header directive for displaying diagnostics.
        Header.IsUmbrella = LeadingToken == MMToken.TokenKind.UmbrellaKeyword;
        ActiveModule.markUnavailable();
        ActiveModule.MissingHeaders.push_back(Header);
      }
    } finally {
      if (Header != null) { Header.$destroy(); }
    }
  }

  
  /// \brief Parse an umbrella directory declaration.
  ///
  ///   umbrella-dir-declaration:
  ///     umbrella string-literal
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseUmbrellaDirDecl">
  @Converted(kind = Converted.Kind.MANUAL, optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1894,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1892,
   FQN="clang::ModuleMapParser::parseUmbrellaDirDecl", NM="_ZN5clang15ModuleMapParser20parseUmbrellaDirDeclENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser20parseUmbrellaDirDeclENS_14SourceLocationE")
  //</editor-fold>
  private void parseUmbrellaDirDecl(SourceLocation UmbrellaLoc) {
    // Parse the directory name.
    if (!Tok.is(MMToken.TokenKind.StringLiteral)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_header)), 
            /*KEEP_STR*/"umbrella"));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    std.string DirName = Tok.getString().$string();
    SourceLocation DirNameLoc = consumeToken();
    
    // Check whether we already have an umbrella.
    if (ActiveModule.Umbrella.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/DirNameLoc, diag.err_mmap_umbrella_clash)), 
            new StringRef(ActiveModule.getFullModuleName())));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Look for this file.
    /*const*/ DirectoryEntry /*P*/ Dir = null;
    if (path.is_absolute(DirName)) {
      Dir = SourceMgr.getFileManager().getDirectory(new StringRef(DirName));
    } else {
      SmallString/*128*/ PathName/*J*/= new SmallString/*128*/(128);
      PathName.$assign(/*STRINGREF_STR*/Directory.getName(), Directory.getNameLen());
      path.append(PathName, DirName);
      Dir = SourceMgr.getFileManager().getDirectory(PathName.$StringRef());
    }
    if (!(Dir != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/DirNameLoc, diag.err_mmap_umbrella_dir_not_found)), 
            new StringRef(DirName)));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    if ((UsesRequiresExcludedHack.count(ActiveModule) != 0)) {
      SmallVector<Module.Header> Headers = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Mark this header 'textual' (see doc comment for
        // ModuleMapParser::UsesRequiresExcludedHack). Although iterating over the
        // directory is relatively expensive, in practice this only applies to the
        // uncommonly used Tcl module on Darwin platforms.
        std.error_code EC/*J*/= new std.error_code();
        Headers/*J*/= new SmallVector<Module.Header>(6, Module.Header.EMPTY);
        FileSystem /*&*/ FS = SourceMgr.getFileManager().$getVirtualFileSystem();
        for (recursive_directory_iterator I/*J*/= new recursive_directory_iterator(FS, new Twine(Dir.getName()), EC), E/*J*/= new recursive_directory_iterator();
             I.$noteq(E) && !EC.$bool(); I.increment(EC)) {
          {
            /*const*/ FileEntry /*P*/ FE = SourceMgr.getFileManager().getFile(I.$arrow().getName());
            if ((FE != null)) {

              Module.Header Header = new Module.Header(I.$arrow().getName(), FE);
              Headers.push_back_T$RR(std.move(Header));
            }
          }
        }
        
        // Sort header paths so that the pcm doesn't depend on iteration order.
        llvm.array_pod_sort(Headers.begin(), Headers.end(), ModuleMapStatics::compareModuleHeaders);
        
        for (Header /*&*/ Header : Headers)  {
          Map.addHeader(ActiveModule, $c$.track(new Module.Header(JD$Move.INSTANCE, std.move(Header))), ModuleMap.ModuleHeaderRole.TextualHeader); $c$.clean();
        }
        return;
      } finally {
        if (Headers != null) { Headers.$destroy(); }
        $c$.$destroy();
      }
    }
    {
      
      Module /*P*/ OwningModule = Map.UmbrellaDirs.$at(Dir);
      if ((OwningModule != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(/*NO_COPY*/UmbrellaLoc, diag.err_mmap_umbrella_clash)), 
              new StringRef(OwningModule.getFullModuleName())));
          HadError = true;
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Record this umbrella directory.
    Map.setUmbrellaDir(ActiveModule, Dir, new Twine(DirName));
  }

  
  /// \brief Parse a module export declaration.
  ///
  ///   export-declaration:
  ///     'export' wildcard-module-id
  ///
  ///   wildcard-module-id:
  ///     identifier
  ///     '*'
  ///     identifier '.' wildcard-module-id
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseExportDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1978,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1974,
   FQN="clang::ModuleMapParser::parseExportDecl", NM="_ZN5clang15ModuleMapParser15parseExportDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser15parseExportDeclEv")
  //</editor-fold>
  private void parseExportDecl() {
    assert (Tok.is(MMToken.TokenKind.ExportKeyword));
    SourceLocation ExportLoc = consumeToken();

    // Parse the module-id with an optional wildcard at the end.
    ClankAliases.ModuleId ParsedModuleId/*J*/= new ClankAliases.ModuleId();
    boolean Wildcard = false;
    do {
      JavaCleaner $c$ = $createJavaCleaner();
      try {    
        // FIXME: Support string-literal module names here.
        if (Tok.is(MMToken.TokenKind.Identifier)) {
          ParsedModuleId.push_back(new std.pairTypeType<std.string, SourceLocation>(std.make_pair(Tok.getString().$string(), 
                  Tok.getLocation())));
          consumeToken();
          if (Tok.is(MMToken.TokenKind.Period)) {
            consumeToken();
            continue;
          }

          break;
        }
        if (Tok.is(MMToken.TokenKind.Star)) {
          Wildcard = true;
          consumeToken();
          break;
        }

        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_module_id)));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    } while (true);
    
    Module.UnresolvedExportDecl Unresolved = new Module.UnresolvedExportDecl(
      ExportLoc, ParsedModuleId, Wildcard
    );
    ActiveModule.UnresolvedExports.push_back(Unresolved);
  }

  
  /// \brief Parse a module use declaration.
  ///
  ///   use-declaration:
  ///     'use' wildcard-module-id
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseUseDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2021,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2017,
   FQN="clang::ModuleMapParser::parseUseDecl", NM="_ZN5clang15ModuleMapParser12parseUseDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser12parseUseDeclEv")
  //</editor-fold>
  private void parseUseDecl() {
    assert (Tok.is(MMToken.TokenKind.UseKeyword));
    SourceLocation KWLoc = consumeToken();
    // Parse the module-id.
    ClankAliases.ModuleId ParsedModuleId/*J*/= new ClankAliases.ModuleId();
    parseModuleId(ParsedModuleId);
    if ((ActiveModule.Parent != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/KWLoc, diag.err_mmap_use_decl_submodule)));
      } finally {
        $c$.$destroy();
      }
    } else {
      ActiveModule.UnresolvedDirectUses.push_back(ParsedModuleId);
    }
  }

  
  /// \brief Parse a link declaration.
  ///
  ///   module-declaration:
  ///     'link' 'framework'[opt] string-literal
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseLinkDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2038,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2034,
   FQN="clang::ModuleMapParser::parseLinkDecl", NM="_ZN5clang15ModuleMapParser13parseLinkDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser13parseLinkDeclEv")
  //</editor-fold>
  private void parseLinkDecl() {
    assert (Tok.is(MMToken.TokenKind.LinkKeyword));
    SourceLocation LinkLoc = consumeToken();
    
    // Parse the optional 'framework' keyword.
    boolean IsFramework = false;
    if (Tok.is(MMToken.TokenKind.FrameworkKeyword)) {
      consumeToken();
      IsFramework = true;
    }
    
    // Parse the library name
    if (!Tok.is(MMToken.TokenKind.StringLiteral)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($out$Same2Bool($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_library_name)), 
                IsFramework), new SourceRange(/*NO_COPY*/LinkLoc)));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    std.string LibraryName = Tok.getString().$string();
    consumeToken();
    ActiveModule.LinkLibraries.push_back(new Module.LinkLibrary(LibraryName, 
            IsFramework));
  }

  
  /// \brief Parse a configuration macro declaration.
  ///
  ///   module-declaration:
  ///     'config_macros' attributes[opt] config-macro-list?
  ///
  ///   config-macro-list:
  ///     identifier (',' identifier)?
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseConfigMacros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2070,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2066,
   FQN="clang::ModuleMapParser::parseConfigMacros", NM="_ZN5clang15ModuleMapParser17parseConfigMacrosEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser17parseConfigMacrosEv")
  //</editor-fold>
  private void parseConfigMacros() {
    assert (Tok.is(MMToken.TokenKind.ConfigMacros));
    SourceLocation ConfigMacrosLoc = consumeToken();
    
    // Only top-level modules can have configuration macros.
    if ((ActiveModule.Parent != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/ConfigMacrosLoc, diag.err_mmap_config_macro_submodule)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Parse the optional attributes.
    ModuleMap.Attributes Attrs/*J*/= new ModuleMap.Attributes();
    if (parseOptionalAttributes(Attrs)) {
      return;
    }
    if (Attrs.IsExhaustive && !(ActiveModule.Parent != null)) {
      ActiveModule.ConfigMacrosExhaustive = true;
    }
    
    // If we don't have an identifier, we're done.
    // FIXME: Support macros with the same name as a keyword here.
    if (!Tok.is(MMToken.TokenKind.Identifier)) {
      return;
    }
    
    // Consume the first identifier.
    if (!(ActiveModule.Parent != null)) {
      ActiveModule.ConfigMacros.push_back(Tok.getString().str());
    }
    consumeToken();
    
    do {
      // If there's a comma, consume it.
      if (!Tok.is(MMToken.TokenKind.Comma)) {
        break;
      }
      consumeToken();
      
      // We expect to see a macro name here.
      // FIXME: Support macros with the same name as a keyword here.
      if (!Tok.is(MMToken.TokenKind.Identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_config_macro)));
          break;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Consume the macro name.
      if (!(ActiveModule.Parent != null)) {
        ActiveModule.ConfigMacros.push_back(Tok.getString().str());
      }
      consumeToken();
    } while (true);
  }

  
  /// \brief Parse a conflict declaration.
  ///
  ///   module-declaration:
  ///     'conflict' module-id ',' string-literal
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseConflict">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2140,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2134,
   FQN="clang::ModuleMapParser::parseConflict", NM="_ZN5clang15ModuleMapParser13parseConflictEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser13parseConflictEv")
  //</editor-fold>
  private void parseConflict() {
    assert (Tok.is(MMToken.TokenKind.Conflict));
    SourceLocation ConflictLoc = consumeToken();
    Module.UnresolvedConflict Conflict/*J*/= new Module.UnresolvedConflict();
    
    // Parse the module-id.
    if (parseModuleId(Conflict.Id)) {
      return;
    }
    
    // Parse the ','.
    if (!Tok.is(MMToken.TokenKind.Comma)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_conflicts_comma)), 
            new SourceRange(/*NO_COPY*/ConflictLoc)));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    consumeToken();
    
    // Parse the message.
    if (!Tok.is(MMToken.TokenKind.StringLiteral)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_conflicts_message)), 
            new StringRef(formatModuleId(Conflict.Id))));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    Conflict.Message.$assignMove(Tok.getString().str());
    consumeToken();
    
    // Add this unresolved conflict.
    ActiveModule.UnresolvedConflicts.push_back(Conflict);
  }

  
  /// \brief Parse an inferred module declaration (wildcard modules).
  ///
  ///   module-declaration:
  ///     'explicit'[opt] 'framework'[opt] 'module' * attributes[opt]
  ///       { inferred-module-member* }
  ///
  ///   inferred-module-member:
  ///     'export' '*'
  ///     'exclude' identifier
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseInferredModuleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2173,
   FQN="clang::ModuleMapParser::parseInferredModuleDecl", NM="_ZN5clang15ModuleMapParser23parseInferredModuleDeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser23parseInferredModuleDeclEbb")
  //</editor-fold>
  private void parseInferredModuleDecl(boolean Framework, boolean Explicit) {
    assert (Tok.is(MMToken.TokenKind.Star));
    SourceLocation StarLoc = consumeToken();
    boolean Failed = false;
    
    // Inferred modules must be submodules.
    if (!(ActiveModule != null) && !Framework) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/StarLoc, diag.err_mmap_top_level_inferred_submodule)));
        Failed = true;
      } finally {
        $c$.$destroy();
      }
    }
    if ((ActiveModule != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Inferred modules must have umbrella directories.
        if ($c$.clean(!Failed && ActiveModule.IsAvailable
           && !$c$.track(ActiveModule.getUmbrellaDir()).$bool())) {
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/StarLoc, diag.err_mmap_inferred_no_umbrella)));
          Failed = true;
        }
        
        // Check for redefinition of an inferred module.
        if (!Failed && ActiveModule.InferSubmodules) {
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/StarLoc, diag.err_mmap_inferred_redef)));
          if (ActiveModule.InferredSubmoduleLoc.isValid()) {
            $c$.clean($c$.track(Diags.Report(/*NO_COPY*/ActiveModule.InferredSubmoduleLoc, 
                diag.note_mmap_prev_definition)));
          }
          Failed = true;
        }
        
        // Check for the 'framework' keyword, which is not permitted here.
        if (Framework) {
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/StarLoc, diag.err_mmap_inferred_framework_submodule)));
          Framework = false;
        }
      } finally {
        $c$.$destroy();
      }
    } else if (Explicit) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/StarLoc, diag.err_mmap_explicit_inferred_framework)));
        Explicit = false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If there were any problems with this inferred submodule, skip its body.
    if (Failed) {
      if (Tok.is(MMToken.TokenKind.LBrace)) {
        consumeToken();
        skipUntil(MMToken.TokenKind.RBrace);
        if (Tok.is(MMToken.TokenKind.RBrace)) {
          consumeToken();
        }
      }
      HadError = true;
      return;
    }
    
    // Parse optional attributes.
    ModuleMap.Attributes Attrs/*J*/= new ModuleMap.Attributes();
    if (parseOptionalAttributes(Attrs)) {
      return;
    }
    if ((ActiveModule != null)) {
      // Note that we have an inferred submodule.
      ActiveModule.InferSubmodules = true;
      ActiveModule.InferredSubmoduleLoc.$assign(StarLoc);
      ActiveModule.InferExplicitSubmodules = Explicit;
    } else {
      // We'll be inferring framework modules for this directory.
      Map.InferredDirectories.$at(Directory).InferModules = true;
      Map.InferredDirectories.$at(Directory).Attrs.$assign(Attrs);
      Map.InferredDirectories.$at(Directory).ModuleMapFile = ModuleMapFile;
      // FIXME: Handle the 'framework' keyword.
    }
    
    // Parse the opening brace.
    if (!Tok.is(MMToken.TokenKind.LBrace)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_lbrace_wildcard)));
        HadError = true;
        return;
      } finally {
        $c$.$destroy();
      }
    }
    SourceLocation LBraceLoc = consumeToken();
    
    // Parse the body of the inferred submodule.
    boolean Done = false;
    do {
      switch (Tok.Kind) {
       case MMToken.TokenKind.EndOfFile:
       case MMToken.TokenKind.RBrace:
        Done = true;
        break;
       case MMToken.TokenKind.ExcludeKeyword:
        {
          if ((ActiveModule != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out$Same2Bool($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_inferred_member)), 
                  (ActiveModule != (Module /*P*/ )null)));
              consumeToken();
              break;
            } finally {
              $c$.$destroy();
            }
          }
          
          consumeToken();
          // FIXME: Support string-literal module names here.
          if (!Tok.is(MMToken.TokenKind.Identifier)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_missing_exclude_name)));
              break;
            } finally {
              $c$.$destroy();
            }
          }
          
          Map.InferredDirectories.$at(Directory).ExcludedModules.
              push_back(Tok.getString().$string());
          consumeToken();
          break;
        }
       case MMToken.TokenKind.ExportKeyword:
        if (!(ActiveModule != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_inferred_member)), 
                (ActiveModule != (Module /*P*/ )null)));
            consumeToken();
            break;
          } finally {
            $c$.$destroy();
          }
        }
        
        consumeToken();
        if (Tok.is(MMToken.TokenKind.Star)) {
          ActiveModule.InferExportWildcard = true;
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diags.Report(Tok.getLocation(), 
                diag.err_mmap_expected_export_wildcard)));
          } finally {
            $c$.$destroy();
          }
        }
        consumeToken();
        break;
       case MMToken.TokenKind.ExplicitKeyword:
       case MMToken.TokenKind.ModuleKeyword:
       case MMToken.TokenKind.HeaderKeyword:
       case MMToken.TokenKind.PrivateKeyword:
       case MMToken.TokenKind.UmbrellaKeyword:
       default:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out$Same2Bool($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_inferred_member)), 
                (ActiveModule != (Module /*P*/ )null)));
            consumeToken();
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    } while (!Done);
    if (Tok.is(MMToken.TokenKind.RBrace)) {
      consumeToken();
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_rbrace)));
        $c$.clean($c$.track(Diags.Report(/*NO_COPY*/LBraceLoc, diag.note_mmap_lbrace_match)));
        HadError = true;
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /*typedef ModuleMap::Attributes Attributes*/
//  public final class Attributes extends ModuleMap.Attributes{ };
  
  /// \brief Parse optional attributes.
  ///
  ///   attributes:
  ///     attribute attributes
  ///     attribute
  ///
  ///   attribute:
  ///     [ identifier ]
  ///
  /// \param Attrs Will be filled in with the parsed attributes.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseOptionalAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2336,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2329,
   FQN="clang::ModuleMapParser::parseOptionalAttributes", NM="_ZN5clang15ModuleMapParser23parseOptionalAttributesERNS_9ModuleMap10AttributesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser23parseOptionalAttributesERNS_9ModuleMap10AttributesE")
  //</editor-fold>
  private boolean parseOptionalAttributes(ModuleMap.Attributes /*&*/ Attrs) {
    boolean HadError = false;
    while (Tok.is(MMToken.TokenKind.LSquare)) {
      // Consume the '['.
      SourceLocation LSquareLoc = consumeToken();
      
      // Check whether we have an attribute name here.
      if (!Tok.is(MMToken.TokenKind.Identifier)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_attribute)));
          skipUntil(MMToken.TokenKind.RSquare);
          if (Tok.is(MMToken.TokenKind.RSquare)) {
            consumeToken();
          }
          HadError = true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Decode the attribute name.
      AttributeKind Attribute = new StringSwitch<AttributeKind>(Tok.getString()).
          Case(/*KEEP_STR*/"exhaustive", AttributeKind.AT_exhaustive).
          Case(/*KEEP_STR*/"extern_c", AttributeKind.AT_extern_c).
          Case(/*KEEP_STR*/"system", AttributeKind.AT_system).
          Default(AttributeKind.AT_unknown);
      switch (Attribute) {
       case AT_unknown:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(Tok.getLocation(), diag.warn_mmap_unknown_attribute)), 
                Tok.getString()));
            break;
          } finally {
            $c$.$destroy();
          }
        }
       case AT_system:
        Attrs.IsSystem = true;
        break;
       case AT_extern_c:
        Attrs.IsExternC = true;
        break;
       case AT_exhaustive:
        Attrs.IsExhaustive = true;
        break;
      }
      consumeToken();
      
      // Consume the ']'.
      if (!Tok.is(MMToken.TokenKind.RSquare)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_rsquare)));
          $c$.clean($c$.track(Diags.Report(/*NO_COPY*/LSquareLoc, diag.note_mmap_lsquare_match)));
          skipUntil(MMToken.TokenKind.RSquare);
          HadError = true;
        } finally {
          $c$.$destroy();
        }
      }
      if (Tok.is(MMToken.TokenKind.RSquare)) {
        consumeToken();
      }
    }
    
    return HadError;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::ModuleMapParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1080,
   FQN = "clang::ModuleMapParser::ModuleMapParser", NM = "_ZN5clang15ModuleMapParserC1ERNS_5LexerERNS_13SourceManagerEPKNS_10TargetInfoERNS_17DiagnosticsEngineERNS_9ModuleMapEPKNS_9FileEntryEPKNS_14DirectoryEntryESH_b",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParserC1ERNS_5LexerERNS_13SourceManagerEPKNS_10TargetInfoERNS_17DiagnosticsEngineERNS_9ModuleMapEPKNS_9FileEntryEPKNS_14DirectoryEntryESH_b")
  //</editor-fold>
  public /*explicit*/ ModuleMapParser(Lexer /*&*/ L, SourceManager /*&*/ SourceMgr, 
      /*const*/ TargetInfo /*P*/ Target, 
      DiagnosticsEngine /*&*/ Diags, 
      ModuleMap /*&*/ Map, 
      /*const*/ FileEntry /*P*/ ModuleMapFile, 
      /*const*/ DirectoryEntry /*P*/ Directory, 
      /*const*/ DirectoryEntry /*P*/ BuiltinIncludeDir, 
      boolean IsSystem) {
    /* : L(L), SourceMgr(SourceMgr), Target(Target), Diags(Diags), Map(Map), ModuleMapFile(ModuleMapFile), Directory(Directory), BuiltinIncludeDir(BuiltinIncludeDir), IsSystem(IsSystem), HadError(false), StringData(), Tok(), ActiveModule(null), UsesRequiresExcludedHack()*/ 
    //START JInit
    this./*&*/L=/*&*/L;
    this./*&*/SourceMgr=/*&*/SourceMgr;
    this.Target = Target;
    this./*&*/Diags=/*&*/Diags;
    this./*&*/Map=/*&*/Map;
    this.ModuleMapFile = ModuleMapFile;
    this.Directory = Directory;
    this.BuiltinIncludeDir = BuiltinIncludeDir;
    this.IsSystem = IsSystem;
    this.HadError = false;
    this.StringData = new BumpPtrAllocatorImpl();
    this.Tok = new MMToken();
    this.ActiveModule = null;
    this.UsesRequiresExcludedHack = new SmallPtrSet<Module /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2);
    //END JInit
    Tok.clear();
    consumeToken();
  }

  
  
  /// \brief Parse a module map file.
  ///
  ///   module-map-file:
  ///     module-declaration*
  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::parseModuleMapFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2398,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2391,
   FQN="clang::ModuleMapParser::parseModuleMapFile", NM="_ZN5clang15ModuleMapParser18parseModuleMapFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParser18parseModuleMapFileEv")
  //</editor-fold>
  public boolean parseModuleMapFile() {
    do {
      switch (Tok.Kind) {
       case MMToken.TokenKind.EndOfFile:
        return HadError;
       case MMToken.TokenKind.ExplicitKeyword:
       case MMToken.TokenKind.ExternKeyword:
       case MMToken.TokenKind.ModuleKeyword:
       case MMToken.TokenKind.FrameworkKeyword:
        parseModuleDecl();
        break;
       case MMToken.TokenKind.Comma:
       case MMToken.TokenKind.ConfigMacros:
       case MMToken.TokenKind.Conflict:
       case MMToken.TokenKind.Exclaim:
       case MMToken.TokenKind.ExcludeKeyword:
       case MMToken.TokenKind.ExportKeyword:
       case MMToken.TokenKind.HeaderKeyword:
       case MMToken.TokenKind.Identifier:
       case MMToken.TokenKind.LBrace:
       case MMToken.TokenKind.LinkKeyword:
       case MMToken.TokenKind.LSquare:
       case MMToken.TokenKind.Period:
       case MMToken.TokenKind.PrivateKeyword:
       case MMToken.TokenKind.RBrace:
       case MMToken.TokenKind.RSquare:
       case MMToken.TokenKind.RequiresKeyword:
       case MMToken.TokenKind.Star:
       case MMToken.TokenKind.StringLiteral:
       case MMToken.TokenKind.TextualKeyword:
       case MMToken.TokenKind.UmbrellaKeyword:
       case MMToken.TokenKind.UseKeyword:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(Diags.Report(Tok.getLocation(), diag.err_mmap_expected_module)));
            HadError = true;
            consumeToken();
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    } while (true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ModuleMapParser::~ModuleMapParser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1007,
   FQN="clang::ModuleMapParser::~ModuleMapParser", NM="_ZN5clang15ModuleMapParserD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang15ModuleMapParserD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UsesRequiresExcludedHack.$destroy();
    StringData.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "L=" + L // NOI18N
              /* STACKOVERFLOW: NEVER PRINT SourceManager + ", SourceMgr=" + SourceMgr // NOI18N*/
              + ", Target=" + Target // NOI18N
              /* STACKOVERFLOW: NEVER PRINT DIAGS + ", Diags=" + Diags // NOI18N*/
              + ", Map=" + Map // NOI18N
              + ", ModuleMapFile=" + ModuleMapFile // NOI18N
              + ", Directory=" + Directory // NOI18N
              + ", BuiltinIncludeDir=" + BuiltinIncludeDir // NOI18N
              + ", IsSystem=" + IsSystem // NOI18N
              + ", HadError=" + HadError // NOI18N
              + ", StringData=" + StringData // NOI18N
              + ", Tok=" + Tok // NOI18N
              + ", ActiveModule=" + ActiveModule // NOI18N
              + ", UsesRequiresExcludedHack=" + UsesRequiresExcludedHack; // NOI18N
  }
}
