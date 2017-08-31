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
package org.clang.frontend;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;
import org.llvm.option.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.frontend.*;


//<editor-fold defaultstate="collapsed" desc="static type FrontendClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CreateInvocationFromCommandLine.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=Tpl__ZN5clang11BuryPointerESt10unique_ptrIT_St14default_deleteIS1_EE;_ZN5clang11BuryPointerEPKv;_ZN5clang11CacheTokensERNS_12PreprocessorEPN4llvm17raw_pwrite_streamE;_ZN5clang15CreateASTDumperEN4llvm9StringRefEbb;_ZN5clang15CreateASTViewerEv;_ZN5clang16CreateASTPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EENS1_9StringRefE;_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiPNS_17DiagnosticsEngineE;_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiRNS_17DiagnosticsEngineE;_ZN5clang19ParseDiagnosticArgsERNS_17DiagnosticOptionsERN4llvm3opt7ArgListEPNS_17DiagnosticsEngineEb;_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyPNS_17DiagnosticsEngineE;_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyRNS_17DiagnosticsEngineE;_ZN5clang22AttachHeaderIncludeGenERNS_12PreprocessorERKNS_23DependencyOutputOptionsEbN4llvm9StringRefEbb;_ZN5clang22InitializePreprocessorERNS_12PreprocessorERKNS_19PreprocessorOptionsERKNS_18PCHContainerReaderERKNS_15FrontendOptionsE;_ZN5clang23CreateASTDeclNodeListerEv;_ZN5clang24ApplyHeaderSearchOptionsERNS_12HeaderSearchERKNS_19HeaderSearchOptionsERKNS_11LangOptionsERKN4llvm6TripleE;_ZN5clang24AttachDependencyGraphGenERNS_12PreprocessorEN4llvm9StringRefES3_;_ZN5clang24CreateDeclContextPrinterEv;_ZN5clang24DoPrintPreprocessedInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE;_ZN5clang27createChainedIncludesSourceERNS_16CompilerInstanceERN4llvm18IntrusiveRefCntPtrINS_18ExternalSemaSourceEEE;_ZN5clang31createInvocationFromCommandLineEN4llvm8ArrayRefIPKcEENS0_18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEE;_ZN5clang31createVFSFromCompilerInvocationERKNS_18CompilerInvocationERNS_17DiagnosticsEngineE; -static-type=FrontendClangGlobals -package=org.clang.frontend")
//</editor-fold>
public final class FrontendClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::getLastArgIntValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 198,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 193,
 FQN="clang::getLastArgIntValue", NM="_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiRNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiRNS_17DiagnosticsEngineE")
//</editor-fold>
public static /*inline*/ int getLastArgIntValue$R(/*const*/ ArgList /*&*/ Args, 
                    OptSpecifier Id, int Default, 
                    DiagnosticsEngine /*&*/ Diags) {
  return /*delegate*/org.clang.frontend.impl.UtilsClangGlobals.
    getLastArgIntValue$R(Args, 
                    Id, Default, 
                    Diags);
}

//<editor-fold defaultstate="collapsed" desc="clang::getLastArgUInt64Value">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 208,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 203,
 FQN="clang::getLastArgUInt64Value", NM="_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyRNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyRNS_17DiagnosticsEngineE")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ getLastArgUInt64Value$R(/*const*/ ArgList /*&*/ Args, 
                       OptSpecifier Id, 
                       long/*uint64_t*/ Default, 
                       DiagnosticsEngine /*&*/ Diags) {
  return /*delegate*/org.clang.frontend.impl.UtilsClangGlobals.
    getLastArgUInt64Value$R(Args, 
                       Id, 
                       Default, 
                       Diags);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::BuryPointer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", line = 219,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/Utils.h", old_line = 214,
 FQN="clang::BuryPointer", NM="Tpl__ZN5clang11BuryPointerESt10unique_ptrIT_St14default_deleteIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp -nm=Tpl__ZN5clang11BuryPointerESt10unique_ptrIT_St14default_deleteIS1_EE")
//</editor-fold>
public static </*typename*/ T> void BuryPointer$T(std.unique_ptr<T> Ptr) {
  /*delegate*/org.clang.frontend.impl.UtilsClangGlobals.
    BuryPointer$T(Ptr);
}


// AST pretty-printer: prints out the AST in a format that is close to the
// original C code.  The output is intended to be in a format such that
// clang could re-parse the output back into the same AST, but the
// implementation is still incomplete.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTPrinter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 126,
 FQN="clang::CreateASTPrinter", NM="_ZN5clang16CreateASTPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EENS1_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang16CreateASTPrinterESt10unique_ptrIN4llvm11raw_ostreamESt14default_deleteIS2_EENS1_9StringRefE")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTPrinter(std.unique_ptr<raw_ostream> Out, 
                StringRef FilterString) {
  return /*delegate*/org.clang.frontend.impl.ASTConsumersClangGlobals.
    CreateASTPrinter(Out, 
                FilterString);
}


// AST dumper: dumps the raw AST in human-readable form to stderr; this is
// intended for debugging.
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTDumper">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 133,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 130,
 FQN="clang::CreateASTDumper", NM="_ZN5clang15CreateASTDumperEN4llvm9StringRefEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang15CreateASTDumperEN4llvm9StringRefEbb")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTDumper(StringRef FilterString, 
               boolean DumpDecls, 
               boolean DumpLookups) {
  return /*delegate*/org.clang.frontend.impl.ASTConsumersClangGlobals.
    CreateASTDumper(FilterString, 
               DumpDecls, 
               DumpLookups);
}


// AST Decl node lister: prints qualified names of all filterable AST Decl
// nodes.
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTDeclNodeLister">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 141,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 138,
 FQN="clang::CreateASTDeclNodeLister", NM="_ZN5clang23CreateASTDeclNodeListerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang23CreateASTDeclNodeListerEv")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTDeclNodeLister() {
  return /*delegate*/org.clang.frontend.impl.ASTConsumersClangGlobals.
    CreateASTDeclNodeLister();
}


// Graphical AST viewer: for each function definition, creates a graph of
// the AST and displays it with the graph viewer "dotty".  Also outputs
// function declarations to stderr.
//<editor-fold defaultstate="collapsed" desc="clang::CreateASTViewer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 178,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 175,
 FQN="clang::CreateASTViewer", NM="_ZN5clang15CreateASTViewerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang15CreateASTViewerEv")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateASTViewer() {
  return /*delegate*/org.clang.frontend.impl.ASTConsumersClangGlobals.
    CreateASTViewer();
}


// DeclContext printer: prints out the DeclContext tree in human-readable form
// to stderr; this is intended for debugging.
//<editor-fold defaultstate="collapsed" desc="clang::CreateDeclContextPrinter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", line = 488,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp", old_line = 487,
 FQN="clang::CreateDeclContextPrinter", NM="_ZN5clang24CreateDeclContextPrinterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTConsumers.cpp -nm=_ZN5clang24CreateDeclContextPrinterEv")
//</editor-fold>
public static std.unique_ptr<ASTConsumer> CreateDeclContextPrinter() {
  return /*delegate*/org.clang.frontend.impl.ASTConsumersClangGlobals.
    CreateDeclContextPrinter();
}


/// Cache tokens for use with PCH. Note that this requires a seekable stream.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CacheTokens">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp", line = 573,
 FQN="clang::CacheTokens", NM="_ZN5clang11CacheTokensERNS_12PreprocessorEPN4llvm17raw_pwrite_streamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CacheTokens.cpp -nm=_ZN5clang11CacheTokensERNS_12PreprocessorEPN4llvm17raw_pwrite_streamE")
//</editor-fold>
public static void CacheTokens(Preprocessor /*&*/ PP, raw_pwrite_stream /*P*/ OS) {
  /*delegate*/org.clang.frontend.impl.CacheTokensClangGlobals.
    CacheTokens(PP, OS);
}

// JAVA: introduced new method to allow caching only one FileEntry
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static void CacheTokens(Preprocessor /*&*/ PP, raw_fd_ostream /*P*/ OS, /*FileID*/int FID, 
        std.string MainFilePath, boolean needComments, boolean needIncompleteTokenState) {
  /*delegate*/org.clang.frontend.impl.CacheTokensClangGlobals.
    CacheTokens(PP, OS, FID, MainFilePath, needComments, needIncompleteTokenState);
}

/// The ChainedIncludesSource class converts headers to chained PCHs in
/// memory, mainly for testing.
//<editor-fold defaultstate="collapsed" desc="clang::createChainedIncludesSource">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 112,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", old_line = 115,
 FQN="clang::createChainedIncludesSource", NM="_ZN5clang27createChainedIncludesSourceERNS_16CompilerInstanceERN4llvm18IntrusiveRefCntPtrINS_18ExternalSemaSourceEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN5clang27createChainedIncludesSourceERNS_16CompilerInstanceERN4llvm18IntrusiveRefCntPtrINS_18ExternalSemaSourceEEE")
//</editor-fold>
public static IntrusiveRefCntPtr<ExternalSemaSource> createChainedIncludesSource(CompilerInstance /*&*/ CI, IntrusiveRefCntPtr<ExternalSemaSource> /*&*/ Reader) {
  return /*delegate*/org.clang.frontend.impl.ChainedIncludesSourceClangGlobals.
    createChainedIncludesSource(CI, Reader);
}


/// \brief Fill out Opts based on the options given in Args.
///
/// Args must have been created from the OptTable returned by
/// createCC1OptTable().
///
/// When errors are encountered, return false and, if Diags is non-null,
/// report the error(s).
//<editor-fold defaultstate="collapsed" desc="clang::ParseDiagnosticArgs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 918,
 FQN="clang::ParseDiagnosticArgs", NM="_ZN5clang19ParseDiagnosticArgsERNS_17DiagnosticOptionsERN4llvm3opt7ArgListEPNS_17DiagnosticsEngineEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang19ParseDiagnosticArgsERNS_17DiagnosticOptionsERN4llvm3opt7ArgListEPNS_17DiagnosticsEngineEb")
//</editor-fold>
public static boolean ParseDiagnosticArgs(DiagnosticOptions /*&*/ Opts, ArgList /*&*/ Args) {
  return ParseDiagnosticArgs(Opts, Args, 
                   (DiagnosticsEngine /*P*/ )null, 
                   true);
}
public static boolean ParseDiagnosticArgs(DiagnosticOptions /*&*/ Opts, ArgList /*&*/ Args, 
                   DiagnosticsEngine /*P*/ Diags/*= null*/) {
  return ParseDiagnosticArgs(Opts, Args, 
                   Diags, 
                   true);
}
public static boolean ParseDiagnosticArgs(DiagnosticOptions /*&*/ Opts, ArgList /*&*/ Args, 
                   DiagnosticsEngine /*P*/ Diags/*= null*/, 
                   boolean DefaultDiagColor/*= true*/) {
  return /*delegate*/org.clang.frontend.impl.CompilerInvocationClangGlobals.
    ParseDiagnosticArgs(Opts, Args, 
                   Diags, 
                   DefaultDiagColor);
}

//<editor-fold defaultstate="collapsed" desc="clang::createVFSFromCompilerInvocation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2541,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2295,
 FQN="clang::createVFSFromCompilerInvocation", NM="_ZN5clang31createVFSFromCompilerInvocationERKNS_18CompilerInvocationERNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang31createVFSFromCompilerInvocationERKNS_18CompilerInvocationERNS_17DiagnosticsEngineE")
//</editor-fold>
public static IntrusiveRefCntPtr<FileSystem> createVFSFromCompilerInvocation(/*const*/ CompilerInvocation /*&*/ CI, 
                               DiagnosticsEngine /*&*/ Diags) {
  return /*delegate*/org.clang.frontend.impl.CompilerInvocationClangGlobals.
    createVFSFromCompilerInvocation(CI, 
                               Diags);
}


/// Return the value of the last argument as an integer, or a default. If Diags
/// is non-null, emits an error if the argument is given, but non-integral.

// Declared in clang/Frontend/Utils.h.
//<editor-fold defaultstate="collapsed" desc="clang::getLastArgIntValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2515,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2269,
 FQN="clang::getLastArgIntValue", NM="_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiPNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang18getLastArgIntValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEiPNS_17DiagnosticsEngineE")
//</editor-fold>
public static int getLastArgIntValue$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, int Default) {
  return getLastArgIntValue$P(Args, Id, Default, 
                    (DiagnosticsEngine /*P*/ )null);
}
public static int getLastArgIntValue$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, int Default, 
                    DiagnosticsEngine /*P*/ Diags/*= null*/) {
  return /*delegate*/org.clang.frontend.impl.CompilerInvocationClangGlobals.
    getLastArgIntValue$P(Args, Id, Default, 
                    Diags);
}

//<editor-fold defaultstate="collapsed" desc="clang::getLastArgUInt64Value">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2520,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2274,
 FQN="clang::getLastArgUInt64Value", NM="_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyPNS_17DiagnosticsEngineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang21getLastArgUInt64ValueERKN4llvm3opt7ArgListENS1_12OptSpecifierEyPNS_17DiagnosticsEngineE")
//</editor-fold>
public static long/*uint64_t*/ getLastArgUInt64Value$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, 
                       long/*uint64_t*/ Default) {
  return getLastArgUInt64Value$P(Args, Id, 
                       Default, 
                       (DiagnosticsEngine /*P*/ )null);
}
public static long/*uint64_t*/ getLastArgUInt64Value$P(/*const*/ ArgList /*&*/ Args, OptSpecifier Id, 
                       long/*uint64_t*/ Default, 
                       DiagnosticsEngine /*P*/ Diags/*= null*/) {
  return /*delegate*/org.clang.frontend.impl.CompilerInvocationClangGlobals.
    getLastArgUInt64Value$P(Args, Id, 
                       Default, 
                       Diags);
}


// When Clang->getFrontendOpts().DisableFree is set we don't delete some of the
// global objects, but we don't want LeakDetectors to complain, so we bury them
// in a globally visible array.
//<editor-fold defaultstate="collapsed" desc="clang::BuryPointer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", line = 2526,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp", old_line = 2280,
 FQN="clang::BuryPointer", NM="_ZN5clang11BuryPointerEPKv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInvocation.cpp -nm=_ZN5clang11BuryPointerEPKv")
//</editor-fold>
public static void BuryPointer(/*const*/Object/*void P*/ Ptr) {
  /*delegate*/org.clang.frontend.impl.CompilerInvocationClangGlobals.
    BuryPointer(Ptr);
}

@Converted(kind = Converted.Kind.MANUAL_ADDED/*JAVA*/)
public static void clearBuriedPointers() {
  /*delegate*/ org.clang.frontend.impl.CompilerInvocationClangGlobals.
          clearBuriedPointers();
}

/// createInvocationFromCommandLine - Construct a compiler invocation object for
/// a command line argument vector.
///
/// \return A CompilerInvocation, or 0 if none was built for the given
/// argument vector.

/// createInvocationFromCommandLine - Construct a compiler invocation object for
/// a command line argument vector.
///
/// \return A CompilerInvocation, or 0 if none was built for the given
/// argument vector.
//<editor-fold defaultstate="collapsed" desc="clang::createInvocationFromCommandLine">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CreateInvocationFromCommandLine.cpp", line = 33,
 FQN="clang::createInvocationFromCommandLine", NM="_ZN5clang31createInvocationFromCommandLineEN4llvm8ArrayRefIPKcEENS0_18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CreateInvocationFromCommandLine.cpp -nm=_ZN5clang31createInvocationFromCommandLineEN4llvm8ArrayRefIPKcEENS0_18IntrusiveRefCntPtrINS_17DiagnosticsEngineEEE")
//</editor-fold>
public static CompilerInvocation /*P*/ createInvocationFromCommandLine(ArrayRef</*const*/char$ptr/*char P*/ > ArgList) {
  return createInvocationFromCommandLine(ArgList, 
                               new IntrusiveRefCntPtr<DiagnosticsEngine>());
}
public static CompilerInvocation /*P*/ createInvocationFromCommandLine(ArrayRef</*const*/char$ptr/*char P*/ > ArgList, 
                               IntrusiveRefCntPtr<DiagnosticsEngine> Diags/*= IntrusiveRefCntPtr<DiagnosticsEngine>()*/) {
  return /*delegate*/org.clang.frontend.impl.CreateInvocationFromCommandLineClangGlobals.
    createInvocationFromCommandLine(ArgList, 
                               Diags);
}


/// AttachDependencyGraphGen - Create a dependency graph generator, and attach
/// it to the given preprocessor.
//<editor-fold defaultstate="collapsed" desc="clang::AttachDependencyGraphGen">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 62,
 FQN="clang::AttachDependencyGraphGen", NM="_ZN5clang24AttachDependencyGraphGenERNS_12PreprocessorEN4llvm9StringRefES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN5clang24AttachDependencyGraphGenERNS_12PreprocessorEN4llvm9StringRefES3_")
//</editor-fold>
public static void AttachDependencyGraphGen(Preprocessor /*&*/ PP, StringRef OutputFile, 
                        StringRef SysRoot) {
  /*delegate*/org.clang.frontend.impl.DependencyGraphClangGlobals.
    AttachDependencyGraphGen(PP, OutputFile, 
                        SysRoot);
}


/// AttachHeaderIncludeGen - Create a header include list generator, and attach
/// it to the given preprocessor.
///
/// \param DepOpts - Options controlling the output.
/// \param ShowAllHeaders - If true, show all header information instead of just
/// headers following the predefines buffer. This is useful for making sure
/// includes mentioned on the command line are also reported, but differs from
/// the default behavior used by -H.
/// \param OutputPath - If non-empty, a path to write the header include
/// information to, instead of writing to stderr.
/// \param ShowDepth - Whether to indent to show the nesting of the includes.
/// \param MSStyle - Whether to print in cl.exe /showIncludes style.
//<editor-fold defaultstate="collapsed" desc="clang::AttachHeaderIncludeGen">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp", line = 79,
 FQN="clang::AttachHeaderIncludeGen", NM="_ZN5clang22AttachHeaderIncludeGenERNS_12PreprocessorERKNS_23DependencyOutputOptionsEbN4llvm9StringRefEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/HeaderIncludeGen.cpp -nm=_ZN5clang22AttachHeaderIncludeGenERNS_12PreprocessorERKNS_23DependencyOutputOptionsEbN4llvm9StringRefEbb")
//</editor-fold>
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      false, new StringRef(/*KEEP_STR*/$EMPTY), 
                      true, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, new StringRef(/*KEEP_STR*/$EMPTY), 
                      true, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/, StringRef OutputPath/*= ""*/) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, OutputPath, 
                      true, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/, StringRef OutputPath/*= ""*/, 
                      boolean ShowDepth/*= true*/) {
  AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, OutputPath, 
                      ShowDepth, false);
}
public static void AttachHeaderIncludeGen(Preprocessor /*&*/ PP, 
                      /*const*/ DependencyOutputOptions /*&*/ DepOpts, 
                      boolean ShowAllHeaders/*= false*/, StringRef OutputPath/*= ""*/, 
                      boolean ShowDepth/*= true*/, boolean MSStyle/*= false*/) {
  /*delegate*/org.clang.frontend.impl.HeaderIncludeGenClangGlobals.
    AttachHeaderIncludeGen(PP, 
                      DepOpts, 
                      ShowAllHeaders, OutputPath, 
                      ShowDepth, MSStyle);
}


/// Apply the header search options to get given HeaderSearch object.
//<editor-fold defaultstate="collapsed" desc="clang::ApplyHeaderSearchOptions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", line = 645,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp", old_line = 644,
 FQN="clang::ApplyHeaderSearchOptions", NM="_ZN5clang24ApplyHeaderSearchOptionsERNS_12HeaderSearchERKNS_19HeaderSearchOptionsERKNS_11LangOptionsERKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitHeaderSearch.cpp -nm=_ZN5clang24ApplyHeaderSearchOptionsERNS_12HeaderSearchERKNS_19HeaderSearchOptionsERKNS_11LangOptionsERKN4llvm6TripleE")
//</editor-fold>
public static void ApplyHeaderSearchOptions(HeaderSearch /*&*/ HS, 
                        /*const*/ HeaderSearchOptions /*&*/ HSOpts, 
                        /*const*/ LangOptions /*&*/ Lang, 
                        /*const*/ Triple /*&*/ Triple) {
  /*delegate*/org.clang.frontend.impl.InitHeaderSearchClangGlobals.
    ApplyHeaderSearchOptions(HS, 
                        HSOpts, 
                        Lang, 
                        Triple);
}


/// InitializePreprocessor - Initialize the preprocessor getting it and the
/// environment ready to process a single file.

/// InitializePreprocessor - Initialize the preprocessor getting it and the
/// environment ready to process a single file. This returns true on error.
///
//<editor-fold defaultstate="collapsed" desc="clang::InitializePreprocessor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", line = 974,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp", old_line = 915,
 FQN="clang::InitializePreprocessor", NM="_ZN5clang22InitializePreprocessorERNS_12PreprocessorERKNS_19PreprocessorOptionsERKNS_18PCHContainerReaderERKNS_15FrontendOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp -nm=_ZN5clang22InitializePreprocessorERNS_12PreprocessorERKNS_19PreprocessorOptionsERKNS_18PCHContainerReaderERKNS_15FrontendOptionsE")
//</editor-fold>
public static void InitializePreprocessor(Preprocessor /*&*/ PP, /*const*/ PreprocessorOptions /*&*/ InitOpts, 
                      /*const*/ PCHContainerReader /*&*/ PCHContainerRdr, 
                      /*const*/ FrontendOptions /*&*/ FEOpts) {
  /*delegate*/org.clang.frontend.impl.InitPreprocessorClangGlobals.
    InitializePreprocessor(PP, InitOpts, 
                      PCHContainerRdr, 
                      FEOpts);
}


/// DoPrintPreprocessedInput - Implement -E mode.

/// DoPrintPreprocessedInput - This implements -E mode.
///
//<editor-fold defaultstate="collapsed" desc="clang::DoPrintPreprocessedInput">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", line = 740,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp", old_line = 719,
 FQN="clang::DoPrintPreprocessedInput", NM="_ZN5clang24DoPrintPreprocessedInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/PrintPreprocessedOutput.cpp -nm=_ZN5clang24DoPrintPreprocessedInputERNS_12PreprocessorEPN4llvm11raw_ostreamERKNS_25PreprocessorOutputOptionsE")
//</editor-fold>
public static void DoPrintPreprocessedInput(Preprocessor /*&*/ PP, raw_ostream /*P*/ OS, 
                        /*const*/ PreprocessorOutputOptions /*&*/ Opts) {
  /*delegate*/org.clang.frontend.impl.PrintPreprocessedOutputClangGlobals.
    DoPrintPreprocessedInput(PP, OS, 
                        Opts);
}

// Initialize the remapping of files to alternative contents, e.g.,
// those specified through other files.
//<editor-fold defaultstate="collapsed" desc="InitializeFileRemapping">
@Converted(kind = Converted.Kind.MANUAL_ADDED/*need to be visible for clients*/, 
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", line = 246,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp", old_line = 239,
 FQN = "InitializeFileRemapping", NM = "_ZL23InitializeFileRemappingRN5clang17DiagnosticsEngineERNS_13SourceManagerERNS_11FileManagerERKNS_19PreprocessorOptionsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/CompilerInstance.cpp -nm=_ZL23InitializeFileRemappingRN5clang17DiagnosticsEngineERNS_13SourceManagerERNS_11FileManagerERKNS_19PreprocessorOptionsE")
//</editor-fold>
public static void InitializeFileRemapping(DiagnosticsEngine /*&*/ Diags, 
                       SourceManager /*&*/ SourceMgr, 
                       FileManager /*&*/ FileMgr, 
                       /*const*/ PreprocessorOptions /*&*/ InitOpts) {
  /*delegate*/org.clang.frontend.impl.CompilerInstanceStatics.
    InitializeFileRemapping(Diags, SourceMgr, FileMgr, InitOpts);
}

} // END OF class FrontendClangGlobals
