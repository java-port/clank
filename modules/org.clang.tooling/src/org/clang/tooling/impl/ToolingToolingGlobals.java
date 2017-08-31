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
package org.clang.tooling.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.llvm.option.*;
import org.clang.tooling.*;


//<editor-fold defaultstate="collapsed" desc="static type ToolingToolingGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN5clang7tooling24newFrontendActionFactoryEPT_PNS0_19SourceFileCallbacksE;Tpl__ZN5clang7tooling24newFrontendActionFactoryEv;_ZN5clang7tooling13newInvocationEPNS_17DiagnosticsEngineERKN4llvm11SmallVectorIPKcLj16EEE;_ZN5clang7tooling13runToolOnCodeEPNS_14FrontendActionERKN4llvm5TwineES6_St10shared_ptrINS_22PCHContainerOperationsEE;_ZN5clang7tooling15getAbsolutePathEN4llvm9StringRefE;_ZN5clang7tooling16buildASTFromCodeERKN4llvm5TwineES4_St10shared_ptrINS_22PCHContainerOperationsEE;_ZN5clang7tooling21runToolOnCodeWithArgsEPNS_14FrontendActionERKN4llvm5TwineERKSt6vectorISsSaISsEES6_S6_St10shared_ptrINS_22PCHContainerOperationsEERKS7_ISt4pairISsSsESaISG_EE;_ZN5clang7tooling24buildASTFromCodeWithArgsERKN4llvm5TwineERKSt6vectorISsSaISsEES4_S4_St10shared_ptrINS_22PCHContainerOperationsEE;_ZN5clang7tooling30addTargetAndModeForProgramNameERSt6vectorISsSaISsEEN4llvm9StringRefE; -static-type=ToolingToolingGlobals -package=org.clang.tooling.impl")
//</editor-fold>
public final class ToolingToolingGlobals {


/// \brief Returns a new FrontendActionFactory for a given type.
///
/// T must derive from clang::FrontendAction.
///
/// Example:
/// FrontendActionFactory *Factory =
///   newFrontendActionFactory<clang::SyntaxOnlyAction>();
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newFrontendActionFactory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 353,
 FQN="clang::tooling::newFrontendActionFactory", NM="Tpl__ZN5clang7tooling24newFrontendActionFactoryEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN5clang7tooling24newFrontendActionFactoryEv")
//</editor-fold>
public static </*typename*/ T> std.unique_ptr<FrontendActionFactory> newFrontendActionFactory() {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns a new FrontendActionFactory for any type that provides an
/// implementation of newASTConsumer().
///
/// FactoryT must implement: ASTConsumer *newASTConsumer().
///
/// Example:
/// struct ProvidesASTConsumers {
///   clang::ASTConsumer *newASTConsumer();
/// } Factory;
/// std::unique_ptr<FrontendActionFactory> FactoryAdapter(
///   newFrontendActionFactory(&Factory));
/*template <typename FactoryT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newFrontendActionFactory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Tooling/Tooling.h", line = 364,
 FQN="clang::tooling::newFrontendActionFactory", NM="Tpl__ZN5clang7tooling24newFrontendActionFactoryEPT_PNS0_19SourceFileCallbacksE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=Tpl__ZN5clang7tooling24newFrontendActionFactoryEPT_PNS0_19SourceFileCallbacksE")
//</editor-fold>
public static /*inline*/ </*typename*/ FactoryT> std.unique_ptr<FrontendActionFactory> newFrontendActionFactory(FactoryT /*P*/ ConsumerFactory) {
  return newFrontendActionFactory(ConsumerFactory, (SourceFileCallbacks /*P*/ )null);
}
public static /*inline*/ </*typename*/ FactoryT> std.unique_ptr<FrontendActionFactory> newFrontendActionFactory(FactoryT /*P*/ ConsumerFactory, SourceFileCallbacks /*P*/ Callbacks/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Runs (and deletes) the tool on 'Code' with the -fsyntax-only flag.
///
/// \param ToolAction The action to run over the code.
/// \param Code C++ code.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param PCHContainerOps  The PCHContainerOperations for loading and creating
///                         clang modules.
///
/// \return - True if 'ToolAction' was successfully executed.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::runToolOnCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 104,
 FQN="clang::tooling::runToolOnCode", NM="_ZN5clang7tooling13runToolOnCodeEPNS_14FrontendActionERKN4llvm5TwineES6_St10shared_ptrINS_22PCHContainerOperationsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling13runToolOnCodeEPNS_14FrontendActionERKN4llvm5TwineES6_St10shared_ptrINS_22PCHContainerOperationsEE")
//</editor-fold>
public static boolean runToolOnCode(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code) {
  return runToolOnCode(ToolAction, Code, 
             new Twine(/*KEEP_STR*/"input.cc"), 
             std.make_shared(new PCHContainerOperations()));
}
public static boolean runToolOnCode(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
             final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return runToolOnCode(ToolAction, Code, 
             FileName, 
             std.make_shared(new PCHContainerOperations()));
}
public static boolean runToolOnCode(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
             final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
             std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Runs (and deletes) the tool on 'Code' with the -fsyntax-only flag and
///        with additional other flags.
///
/// \param ToolAction The action to run over the code.
/// \param Code C++ code.
/// \param Args Additional flags to pass on.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param ToolName The name of the binary running the tool. Standard library
///                 header paths will be resolved relative to this.
/// \param PCHContainerOps   The PCHContainerOperations for loading and creating
///                          clang modules.
///
/// \return - True if 'ToolAction' was successfully executed.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::runToolOnCodeWithArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 124,
 FQN="clang::tooling::runToolOnCodeWithArgs", NM="_ZN5clang7tooling21runToolOnCodeWithArgsEPNS_14FrontendActionERKN4llvm5TwineERKSt6vectorISsSaISsEES6_S6_St10shared_ptrINS_22PCHContainerOperationsEERKS7_ISt4pairISsSsESaISG_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling21runToolOnCodeWithArgsEPNS_14FrontendActionERKN4llvm5TwineERKSt6vectorISsSaISsEES6_S6_St10shared_ptrINS_22PCHContainerOperationsEERKS7_ISt4pairISsSsESaISG_EE")
//</editor-fold>
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, new Twine(/*KEEP_STR*/"input.cc"), 
                     new Twine(/*KEEP_STR*/"clang-tool"), 
                     std.make_shared(new PCHContainerOperations()), 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, FileName, 
                     new Twine(/*KEEP_STR*/"clang-tool"), 
                     std.make_shared(new PCHContainerOperations()), 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                     final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, FileName, 
                     ToolName, 
                     std.make_shared(new PCHContainerOperations()), 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                     final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  return runToolOnCodeWithArgs(ToolAction, Code, 
                     Args, FileName, 
                     ToolName, 
                     PCHContainerOps, 
                     new std.vector<std.pair<std.string, std.string>>(new pairTypeType<std.string, std.string>(new std.string(), new std.string())));
}
public static boolean runToolOnCodeWithArgs(FrontendAction /*P*/ ToolAction, final /*const*/ Twine /*&*/ Code, 
                     final /*const*/std.vectorString/*&*/ Args, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                     final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/, 
                     std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/, 
                     final /*const*/std.vector<std.pair<std.string, std.string>> /*&*/ VirtualMappedFiles/*= FileContentMappings()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Builds an AST for 'Code'.
///
/// \param Code C++ code.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param PCHContainerOps The PCHContainerOperations for loading and creating
/// clang modules.
///
/// \return The resulting AST or null if an error occurred.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::buildASTFromCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 492,
 FQN="clang::tooling::buildASTFromCode", NM="_ZN5clang7tooling16buildASTFromCodeERKN4llvm5TwineES4_St10shared_ptrINS_22PCHContainerOperationsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling16buildASTFromCodeERKN4llvm5TwineES4_St10shared_ptrINS_22PCHContainerOperationsEE")
//</editor-fold>
public static std.unique_ptr<ASTUnit> buildASTFromCode(final /*const*/ Twine /*&*/ Code) {
  return buildASTFromCode(Code, new Twine(/*KEEP_STR*/"input.cc"), 
                std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCode(final /*const*/ Twine /*&*/ Code, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return buildASTFromCode(Code, FileName, 
                std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCode(final /*const*/ Twine /*&*/ Code, final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, 
                std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Builds an AST for 'Code' with additional flags.
///
/// \param Code C++ code.
/// \param Args Additional flags to pass on.
/// \param FileName The file name which 'Code' will be mapped as.
/// \param ToolName The name of the binary running the tool. Standard library
///                 header paths will be resolved relative to this.
/// \param PCHContainerOps The PCHContainerOperations for loading and creating
/// clang modules.
///
/// \return The resulting AST or null if an error occurred.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::buildASTFromCodeWithArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 499,
 FQN="clang::tooling::buildASTFromCodeWithArgs", NM="_ZN5clang7tooling24buildASTFromCodeWithArgsERKN4llvm5TwineERKSt6vectorISsSaISsEES4_S4_St10shared_ptrINS_22PCHContainerOperationsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling24buildASTFromCodeWithArgsERKN4llvm5TwineERKSt6vectorISsSaISsEES4_S4_St10shared_ptrINS_22PCHContainerOperationsEE")
//</editor-fold>
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args) {
  return buildASTFromCodeWithArgs(Code, Args, 
                        new Twine(/*KEEP_STR*/"input.cc"), new Twine(/*KEEP_STR*/"clang-tool"), 
                        std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args, 
                        final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/) {
  return buildASTFromCodeWithArgs(Code, Args, 
                        FileName, new Twine(/*KEEP_STR*/"clang-tool"), 
                        std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args, 
                        final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/) {
  return buildASTFromCodeWithArgs(Code, Args, 
                        FileName, ToolName, 
                        std.make_shared(new PCHContainerOperations()));
}
public static std.unique_ptr<ASTUnit> buildASTFromCodeWithArgs(final /*const*/ Twine /*&*/ Code, final /*const*/std.vectorString/*&*/ Args, 
                        final /*const*/ Twine /*&*/ FileName/*= "input.cc"*/, final /*const*/ Twine /*&*/ ToolName/*= "clang-tool"*/, 
                        std.shared_ptr<PCHContainerOperations> PCHContainerOps/*= std::make_shared<PCHContainerOperations>()*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the absolute path of \c File, by prepending it with
/// the current directory if \c File is not absolute.
///
/// Otherwise returns \c File.
/// If 'File' starts with "./", the returned path will not contain the "./".
/// Otherwise, the returned path will contain the literal path-concatenation of
/// the current directory and \c File.
///
/// The difference to llvm::sys::fs::make_absolute is the canonicalization this
/// does by removing "./" and computing native paths.
///
/// \param File Either an absolute or relative path.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::getAbsolutePath">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 158,
 FQN="clang::tooling::getAbsolutePath", NM="_ZN5clang7tooling15getAbsolutePathEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling15getAbsolutePathEN4llvm9StringRefE")
//</editor-fold>
public static std.string getAbsolutePath(StringRef File) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Changes CommandLine to contain implicit flags that would have been
/// defined had the compiler driver been invoked through the path InvokedAs.
///
/// For example, when called with \c InvokedAs set to `i686-linux-android-g++`,
/// the arguments '-target', 'i686-linux-android`, `--driver-mode=g++` will
/// be inserted after the first argument in \c CommandLine.
///
/// This function will not add new `-target` or `--driver-mode` flags if they
/// are already present in `CommandLine` (even if they have different settings
/// than would have been inserted).
///
/// \pre `llvm::InitializeAllTargets()` has been called.
///
/// \param CommandLine the command line used to invoke the compiler driver or
/// Clang tool, including the path to the executable as \c CommandLine[0].
/// \param InvokedAs the path to the driver used to infer implicit flags.
///
/// \note This will not set \c CommandLine[0] to \c InvokedAs. The tooling
/// infrastructure expects that CommandLine[0] is a tool path relative to which
/// the builtin headers can be found.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::addTargetAndModeForProgramName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 173,
 FQN="clang::tooling::addTargetAndModeForProgramName", NM="_ZN5clang7tooling30addTargetAndModeForProgramNameERSt6vectorISsSaISsEEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling30addTargetAndModeForProgramNameERSt6vectorISsSaISsEEN4llvm9StringRefE")
//</editor-fold>
public static void addTargetAndModeForProgramName(final std.vectorString/*&*/ CommandLine, 
                              StringRef InvokedAs) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Creates a \c CompilerInvocation.

/// \brief Returns a clang build invocation initialized from the CC1 flags.
//<editor-fold defaultstate="collapsed" desc="clang::tooling::newInvocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp", line = 90,
 FQN="clang::tooling::newInvocation", NM="_ZN5clang7tooling13newInvocationEPNS_17DiagnosticsEngineERKN4llvm11SmallVectorIPKcLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN5clang7tooling13newInvocationEPNS_17DiagnosticsEngineERKN4llvm11SmallVectorIPKcLj16EEE")
//</editor-fold>
public static CompilerInvocation /*P*/ newInvocation(DiagnosticsEngine /*P*/ Diagnostics, 
             final /*const*/ArgStringList/*&*/ CC1Args) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class ToolingToolingGlobals
