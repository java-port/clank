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

package org.clang.staticanalyzer.frontend.ento.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.frontend.ento.*;
import org.clang.basic.vfs.FileSystem;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ModelInjector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.h", line = 43,
 FQN="clang::ento::ModelInjector", NM="_ZN5clang4ento13ModelInjectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang4ento13ModelInjectorE")
//</editor-fold>
public class ModelInjector extends /*public*/ CodeInjector implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ModelInjector::ModelInjector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp", line = 28,
   FQN="clang::ento::ModelInjector::ModelInjector", NM="_ZN5clang4ento13ModelInjectorC1ERNS_16CompilerInstanceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang4ento13ModelInjectorC1ERNS_16CompilerInstanceE")
  //</editor-fold>
  public ModelInjector(final CompilerInstance /*&*/ CI) {
    // : CodeInjector(), CI(CI), Bodies() 
    //START JInit
    super();
    this./*&*/CI=/*&*/CI;
    this.Bodies = new StringMap<Stmt /*P*/ >((Stmt /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ModelInjector::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp", line = 30,
   FQN="clang::ento::ModelInjector::getBody", NM="_ZN5clang4ento13ModelInjector7getBodyEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang4ento13ModelInjector7getBodyEPKNS_12FunctionDeclE")
  //</editor-fold>
  @Override public Stmt /*P*/ getBody(/*const*/ FunctionDecl /*P*/ D)/* override*/ {
    onBodySynthesis(D);
    return Bodies.$at(D.getName());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ModelInjector::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp", line = 35,
   FQN="clang::ento::ModelInjector::getBody", NM="_ZN5clang4ento13ModelInjector7getBodyEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang4ento13ModelInjector7getBodyEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public Stmt /*P*/ getBody(/*const*/ ObjCMethodDecl /*P*/ D)/* override*/ {
    onBodySynthesis(D);
    return Bodies.$at(D.getName());
  }

/*private:*/
  /// \brief Synthesize a body for a declaration
  ///
  /// This method first looks up the appropriate model file based on the
  /// model-path configuration option and the name of the declaration that is
  /// looked up. If no model were synthesized yet for a function with that name
  /// it will create a new compiler instance to parse the model file using the
  /// ASTContext, Preprocessor, SourceManager of the original compiler instance.
  /// The former resources are shared between the two compiler instance, so the
  /// newly created instance have to "leak" these objects, since they are owned
  /// by the original instance.
  ///
  /// The model-path should be either an absolute path or relative to the
  /// working directory of the compiler.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ModelInjector::onBodySynthesis">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp", line = 40,
   FQN="clang::ento::ModelInjector::onBodySynthesis", NM="_ZN5clang4ento13ModelInjector15onBodySynthesisEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang4ento13ModelInjector15onBodySynthesisEPKNS_9NamedDeclE")
  //</editor-fold>
  private void onBodySynthesis(/*const*/ NamedDecl /*P*/ D) {
    IntrusiveRefCntPtr<CompilerInvocation> Invocation = null;
    CompilerInstance Instance = null;
    ParseModelFileAction parseModelFile = null;
    CrashRecoveryContext CRC = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      // FIXME: what about overloads? Declarations can be used as keys but what
      // about file name index? Mangled names may not be suitable for that either.
      if (Bodies.count(D.getName()) != 0) {
        return;
      }
      
      final SourceManager /*&*/ SM = CI.getSourceManager();
      FileID mainFileID = SM.getMainFileID();
      
      IntrusiveRefCntPtr<AnalyzerOptions> analyzerOpts = CI.getAnalyzerOpts();
      StringRef modelPath = new StringRef(analyzerOpts.$arrow().Config.$at(/*STRINGREF_STR*/"model-path"));
      
      SmallString/*128*/ fileName/*J*/= new SmallString/*128*/(128);
      if (!modelPath.empty()) {
        fileName.$assign(
            new StringRef($add_string_T$C$P($add_string($add_string_T$C$P(modelPath.str(), /*KEEP_STR*/"/"), D.getName().str()), /*KEEP_STR*/".model"))
        );
      } else {
        fileName.$assign(new StringRef($add_string_T$C$P(D.getName().str(), /*KEEP_STR*/".model")));
      }
      if (!fs.exists(new Twine(fileName.str()))) {
        Bodies.$set(D.getName(), null);
        return;
      }
      
      Invocation/*J*/= new IntrusiveRefCntPtr<CompilerInvocation>(new CompilerInvocation(CI.getInvocation()));
      
      final FrontendOptions /*&*/ FrontendOpts = Invocation.$arrow().getFrontendOpts();
      InputKind IK = InputKind.IK_CXX; // FIXME
      FrontendOpts.Inputs.clear();
      FrontendOpts.Inputs.emplace_back(new FrontendInputFile(fileName.$StringRef(), IK));
      FrontendOpts.DisableFree = true;
      
      Invocation.$arrow().getDiagnosticOpts().VerifyDiagnostics = false;
      
      // Modules are parsed by a separate CompilerInstance, so this code mimics that
      // behavior for models
      Instance/*J*/= $c$.clean(new CompilerInstance($c$.track(CI.getPCHContainerOperations())));
      Instance.setInvocation($AddrOf(Invocation.$star()));
      Instance.createDiagnostics(new ForwardingDiagnosticConsumer(CI.getDiagnosticClient()), 
          /*ShouldOwnClient=*/ true);
      
      Instance.getDiagnostics().setSourceManager($AddrOf(SM));
      
      Instance.setVirtualFileSystem($c$.track(new IntrusiveRefCntPtr<FileSystem>($AddrOf(CI.getVirtualFileSystem())))); $c$.clean();
      
      // The instance wants to take ownership, however DisableFree frontend option
      // is set to true to avoid double free issues
      Instance.setFileManager($AddrOf(CI.getFileManager()));
      Instance.setSourceManager($AddrOf(SM));
      Instance.setPreprocessor($AddrOf(CI.getPreprocessor()));
      Instance.setASTContext($AddrOf(CI.getASTContext()));
      
      Instance.getPreprocessor().InitializeForModelFile();
      
      parseModelFile/*J*/= new ParseModelFileAction(Bodies);
      
      /*const*//*uint*/int ThreadStackSize = 8 << 20;
      CRC/*J*/= new CrashRecoveryContext();
      
      final CompilerInstance finalInstance = Instance;
      final ParseModelFileAction finalParseModelFile = parseModelFile;
      CRC.RunSafelyOnThread(/*FuncArg*//*[&, &Instance, &parseModelFile]*/ () -> {
                finalInstance.ExecuteAction(finalParseModelFile);
              }, 
          ThreadStackSize);
      
      Instance.getPreprocessor().FinalizeForModelFile();
      
      Instance.resetAndLeakSourceManager();
      Instance.resetAndLeakFileManager();
      Instance.resetAndLeakPreprocessor();
      
      // The preprocessor enters to the main file id when parsing is started, so
      // the main file id is changed to the model file during parsing and it needs
      // to be reseted to the former main file id after parsing of the model file
      // is done.
      SM.setMainFileID(/*NO_COPY*/mainFileID);
    } finally {
      if (CRC != null) { CRC.$destroy(); }
      if (parseModelFile != null) { parseModelFile.$destroy(); }
      if (Instance != null) { Instance.$destroy(); }
      if (Invocation != null) { Invocation.$destroy(); }
      $c$.$destroy();
    }
  }

  
  private final CompilerInstance /*&*/ CI;
  
  // FIXME: double memoization is redundant, with memoization both here and in
  // BodyFarm.
  private StringMap<Stmt /*P*/ > Bodies;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ModelInjector::~ModelInjector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.h", line = 43,
   FQN="clang::ento::ModelInjector::~ModelInjector", NM="_ZN5clang4ento13ModelInjectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN5clang4ento13ModelInjectorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Bodies.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CI=" + CI // NOI18N
              + ", Bodies=" + Bodies // NOI18N
              + super.toString(); // NOI18N
  }
}
