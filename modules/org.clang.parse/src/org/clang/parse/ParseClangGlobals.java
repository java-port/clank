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
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN5clang8ParseASTERNS_12PreprocessorEPNS_11ASTConsumerERNS_10ASTContextEbNS_19TranslationUnitKindEPNS_20CodeCompleteConsumerEb;_ZN5clang8ParseASTERNS_4SemaEbb; -static-type=ParseClangGlobals -package=org.clang.parse")
//</editor-fold>
public final class ParseClangGlobals {


/// \brief Parse the entire file specified, notifying the ASTConsumer as
/// the file is parsed.
///
/// This operation inserts the parsed decls into the translation
/// unit held by Ctx.
///
/// \param TUKind The kind of translation unit being parsed.
///
/// \param CompletionConsumer If given, an object to consume code completion
/// results.
// namespace

//===----------------------------------------------------------------------===//
// Public interface to the file
//===----------------------------------------------------------------------===//

/// ParseAST - Parse the entire file specified, notifying the ASTConsumer as
/// the file is parsed.  This inserts the parsed decls into the translation unit
/// held by Ctx.
///
//<editor-fold defaultstate="collapsed" desc="clang::ParseAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 98,
 FQN="clang::ParseAST", NM="_ZN5clang8ParseASTERNS_12PreprocessorEPNS_11ASTConsumerERNS_10ASTContextEbNS_19TranslationUnitKindEPNS_20CodeCompleteConsumerEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN5clang8ParseASTERNS_12PreprocessorEPNS_11ASTConsumerERNS_10ASTContextEbNS_19TranslationUnitKindEPNS_20CodeCompleteConsumerEb")
//</editor-fold>
public static void ParseAST(Preprocessor /*&*/ PP, ASTConsumer /*P*/ Consumer, 
        ASTContext /*&*/ Ctx) {
  ParseAST(PP, Consumer, 
        Ctx, false, 
        TranslationUnitKind.TU_Complete, 
        (CodeCompleteConsumer /*P*/ )null, 
        false);
}
public static void ParseAST(Preprocessor /*&*/ PP, ASTConsumer /*P*/ Consumer, 
        ASTContext /*&*/ Ctx, boolean PrintStats/*= false*/) {
  ParseAST(PP, Consumer, 
        Ctx, PrintStats, 
        TranslationUnitKind.TU_Complete, 
        (CodeCompleteConsumer /*P*/ )null, 
        false);
}
public static void ParseAST(Preprocessor /*&*/ PP, ASTConsumer /*P*/ Consumer, 
        ASTContext /*&*/ Ctx, boolean PrintStats/*= false*/, 
        TranslationUnitKind TUKind/*= TU_Complete*/) {
  ParseAST(PP, Consumer, 
        Ctx, PrintStats, 
        TUKind, 
        (CodeCompleteConsumer /*P*/ )null, 
        false);
}
public static void ParseAST(Preprocessor /*&*/ PP, ASTConsumer /*P*/ Consumer, 
        ASTContext /*&*/ Ctx, boolean PrintStats/*= false*/, 
        TranslationUnitKind TUKind/*= TU_Complete*/, 
        CodeCompleteConsumer /*P*/ CompletionConsumer/*= null*/) {
  ParseAST(PP, Consumer, 
        Ctx, PrintStats, 
        TUKind, 
        CompletionConsumer, 
        false);
}
public static void ParseAST(Preprocessor /*&*/ PP, ASTConsumer /*P*/ Consumer, 
        ASTContext /*&*/ Ctx, boolean PrintStats/*= false*/, 
        TranslationUnitKind TUKind/*= TU_Complete*/, 
        CodeCompleteConsumer /*P*/ CompletionConsumer/*= null*/, 
        boolean SkipFunctionBodies/*= false*/) {
  std.unique_ptr<Sema> S = null;
  CrashRecoveryContextCleanupRegistrar<Sema> CleanupSema = null;
  try {
    
    S/*J*/= new std.unique_ptr<Sema>(new Sema(PP, Ctx, $Deref(Consumer), TUKind, CompletionConsumer));
    
    // Recover resources if we crash before exiting this method.
    CleanupSema/*J*/= new CrashRecoveryContextCleanupRegistrar<Sema>(S.get());
    
    ParseAST($Deref(S.get()), PrintStats, SkipFunctionBodies);
  } finally {
    if (CleanupSema != null) { CleanupSema.$destroy(); }
    if (S != null) { S.$destroy(); }
  }
}


/// \brief Parse the main file known to the preprocessor, producing an 
/// abstract syntax tree.
//<editor-fold defaultstate="collapsed" desc="clang::ParseAST">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp", line = 113,
 FQN="clang::ParseAST", NM="_ZN5clang8ParseASTERNS_4SemaEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp -nm=_ZN5clang8ParseASTERNS_4SemaEbb")
//</editor-fold>
public static void ParseAST(Sema /*&*/ S) {
  ParseAST(S, false, false);
}
public static void ParseAST(Sema /*&*/ S, boolean PrintStats/*= false*/) {
  ParseAST(S, PrintStats, false);
}
public static void ParseAST(Sema /*&*/ S, boolean PrintStats/*= false*/, boolean SkipFunctionBodies/*= false*/) {
  std.unique_ptr<Parser> ParseOP = null;
  CrashRecoveryContextCleanupRegistrar</*const*/Object/*, ResetStackCleanup*/> CleanupPrettyStack = null;
  PrettyStackTraceParserEntry CrashInfo = null;
  CrashRecoveryContextCleanupRegistrar<Parser> CleanupParser = null;
  try {
    // Collect global stats on Decls/Stmts (until we have a module streamer).
    if (PrintStats) {
      Decl.EnableStatistics();
      Stmt.EnableStatistics();
    }
    
    // Also turn on collection of stats inside of the Sema object.
    boolean OldCollectStats = PrintStats;
    // JAVA: easier to swap manually than creating $refs
    if (false) {
      std.swap(OldCollectStats, S.CollectStats);
    } else {
      OldCollectStats = S.CollectStats;
      S.CollectStats = PrintStats;
    }
    
    ASTConsumer /*P*/ Consumer = $AddrOf(S.getASTConsumer());
    
    ParseOP/*J*/= new std.unique_ptr<Parser>(new Parser(S.getPreprocessor(), S, SkipFunctionBodies));
    Parser /*&*/ P = $Deref(ParseOP.get());
    
    CleanupPrettyStack/*J*/= new CrashRecoveryContextCleanupRegistrar</*const*/Object/*, ResetStackCleanup*/>(new ResetStackCleanup(), llvm.SavePrettyStackState());
    CrashInfo/*J*/= new PrettyStackTraceParserEntry(P);
    
    // Recover resources if we crash before exiting this method.
    CleanupParser/*J*/= new CrashRecoveryContextCleanupRegistrar<Parser>(ParseOP.get());
    
    S.getPreprocessor().EnterMainSourceFile();
    P.Initialize();
    
    // C11 6.9p1 says translation units must have at least one top-level
    // declaration. C++ doesn't have this restriction. We also don't want to
    // complain if we have a precompiled header, although technically if the PCH
    // is empty we should still emit the (pedantic) diagnostic.
    OpaquePtr<DeclGroupRef> ADecl/*J*/= new OpaquePtr<DeclGroupRef>();
    ExternalASTSource /*P*/ External = S.getASTContext().getExternalSource();
    if ((External != null)) {
      External.StartTranslationUnit(Consumer);
    }
    if (P.ParseTopLevelDecl(ADecl)) {
      if (!(External != null) && !S.getLangOpts().CPlusPlus) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(P.Diag(diag.ext_empty_translation_unit)));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      do {
        // If we got a null return and something *was* parsed, ignore it.  This
        // is due to a top-level semicolon, an action override, or a parse error
        // skipping something.
        if (ADecl.$bool() && !Consumer.HandleTopLevelDecl(ADecl.getDeclGroupRef())) {
          return;
        }
      } while (!P.ParseTopLevelDecl(ADecl));
    }
    
    // Process any TopLevelDecls generated by #pragma weak.
    for (Decl /*P*/ D : S.WeakTopLevelDecls())  {
      Consumer.HandleTopLevelDecl(new DeclGroupRef(D));
    }
    
    Consumer.HandleTranslationUnit(S.getASTContext());
    
    // JAVA: easier to swap manually than creating $refs
    if (false) {
      std.swap(OldCollectStats, S.CollectStats);
    } else {
      S.CollectStats = OldCollectStats;
    }
    if (PrintStats) {
      llvm.errs().$out(/*KEEP_STR*/"\nSTATISTICS:\n");
      P.getActions().PrintStats();
      S.getASTContext().PrintStats();
      Decl.PrintStats();
      Stmt.PrintStats();
      Consumer.PrintStats();
    }
  } finally {
    if (CleanupParser != null) { CleanupParser.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
    if (CleanupPrettyStack != null) { CleanupPrettyStack.$destroy(); }
    if (ParseOP != null) { ParseOP.$destroy(); }
  }
}

} // END OF class ParseClangGlobals
