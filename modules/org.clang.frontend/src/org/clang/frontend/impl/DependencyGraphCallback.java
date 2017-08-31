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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.support.sys.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 29,
 FQN="(anonymous namespace)::DependencyGraphCallback", NM="_ZN12_GLOBAL__N_123DependencyGraphCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallbackE")
//</editor-fold>
public class DependencyGraphCallback extends /*public*/ PPCallbacks implements Destructors.ClassWithDestructor {
  private /*const*/ Preprocessor /*P*/ PP;
  private std.string OutputFile;
  private std.string SysRoot;
  private SetVector</*const*/ FileEntry /*P*/ > AllFiles;
  /*typedef llvm::DenseMap<const FileEntry *, SmallVector<const FileEntry *, 2> > DependencyMap*/
//  public final class DependencyMap extends DenseMap</*const*/ FileEntry /*P*/ , SmallVector</*const*/ FileEntry /*P*/> >{ };
  
  private DenseMap</*const*/ FileEntry /*P*/ , SmallVector</*const*/ FileEntry /*P*/> > Dependencies;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback::writeNodeReference">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 92,
   FQN="(anonymous namespace)::DependencyGraphCallback::writeNodeReference", NM="_ZN12_GLOBAL__N_123DependencyGraphCallback18writeNodeReferenceERN4llvm11raw_ostreamEPKN5clang9FileEntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallback18writeNodeReferenceERN4llvm11raw_ostreamEPKN5clang9FileEntryE")
  //</editor-fold>
  private raw_ostream /*&*/ writeNodeReference(raw_ostream /*&*/ OS, 
                    /*const*/ FileEntry /*P*/ Node) {
    OS.$out(/*KEEP_STR*/"header_").$out_uint(Node.getUID());
    return OS;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback::OutputGraphFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 99,
   FQN="(anonymous namespace)::DependencyGraphCallback::OutputGraphFile", NM="_ZN12_GLOBAL__N_123DependencyGraphCallback15OutputGraphFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallback15OutputGraphFileEv")
  //</editor-fold>
  private void OutputGraphFile() {
    raw_fd_ostream OS = null;
    try {
      std.error_code EC/*J*/= new std.error_code();
      OS/*J*/= new raw_fd_ostream(new StringRef(OutputFile), EC, fs.OpenFlags.F_Text);
      if (EC.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(PP.getDiagnostics().Report(diag.err_fe_error_opening)), new StringRef(OutputFile)), 
              new StringRef(EC.message())));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      OS.$out(/*KEEP_STR*/"digraph \"dependencies\" {\n");
      
      // Write the nodes
      for (/*uint*/int I = 0, N = AllFiles.size(); I != N; ++I) {
        // Write the node itself.
        OS.indent(2);
        writeNodeReference(OS, AllFiles.$at(I));
        OS.$out(/*KEEP_STR*/" [ shape=\"box\", label=\"");
        StringRef FileName = new StringRef(AllFiles.$at(I).getName());
        if (FileName.startswith(new StringRef(SysRoot))) {
          FileName.$assignMove(FileName.substr(SysRoot.size()));
        }
        
        OS.$out(DOT.EscapeString(FileName.$string())).$out(
            /*KEEP_STR*/"\"];\n"
        );
      }
      
      // Write the edges
      for (DenseMapIterator</*const*/ FileEntry /*P*/ , SmallVector</*const*/ FileEntry /*P*/>> F = Dependencies.begin(), 
          FEnd = Dependencies.end();
           F.$noteq(/*NO_ITER_COPY*/FEnd); F.$preInc()) {
        for (/*uint*/int I = 0, N = F.$arrow().second.size(); I != N; ++I) {
          OS.indent(2);
          writeNodeReference(OS, F.$arrow().first);
          OS.$out(/*KEEP_STR*/" -> ");
          writeNodeReference(OS, F.$arrow().second.$at(I));
          OS.$out(/*KEEP_STR*/";\n");
        }
      }
      OS.$out(/*KEEP_STR*/"}\n");
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback::DependencyGraphCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 45,
   FQN="(anonymous namespace)::DependencyGraphCallback::DependencyGraphCallback", NM="_ZN12_GLOBAL__N_123DependencyGraphCallbackC1EPKN5clang12PreprocessorEN4llvm9StringRefES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallbackC1EPKN5clang12PreprocessorEN4llvm9StringRefES6_")
  //</editor-fold>
  public DependencyGraphCallback(/*const*/ Preprocessor /*P*/ _PP, StringRef OutputFile, 
      StringRef SysRoot) {
    // : PPCallbacks(), PP(_PP), OutputFile(OutputFile.str()), SysRoot(SysRoot.str()), AllFiles(), Dependencies() 
    //START JInit
    super();
    this.PP = _PP;
    this.OutputFile = OutputFile.str();
    this.SysRoot = SysRoot.str();
    this.AllFiles = new SetVector</*const*/ FileEntry /*P*/ >((FileEntry/*P*/)null);
    this.Dependencies = new DenseMap</*const*/ FileEntry /*P*/ , SmallVector</*const*/ FileEntry /*P*/> >(FileEntry.DMI$FileEntryPtr, /*PERF*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback::InclusionDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*eod*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 68,
   FQN="(anonymous namespace)::DependencyGraphCallback::InclusionDirective", NM="_ZN12_GLOBAL__N_123DependencyGraphCallback18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallback18InclusionDirectiveEN5clang14SourceLocationERKNS1_5TokenEN4llvm9StringRefEbNS1_15CharSourceRangeEPKNS1_9FileEntryES7_S7_PKNS1_6ModuleE")
  //</editor-fold>
  @Override public void InclusionDirective(SourceLocation HashLoc, /*JAVA*/SourceLocation EodLoc, 
                    /*const*/ Token /*&*/ IncludeTok, 
                    StringRef FileName, 
                    boolean IsAngled, 
                    CharSourceRange FilenameRange, 
                    /*const*/ FileEntry /*P*/ File, 
                    StringRef SearchPath, 
                    StringRef RelativePath, 
                    /*const*/ Module /*P*/ Imported)/* override*/ {
    if (!(File != null)) {
      return;
    }
    
    SourceManager /*&*/ SM = PP.getSourceManager();
    /*const*/ FileEntry /*P*/ FromFile = SM.getFileEntryForID(SM.getFileID(SM.getExpansionLoc(/*NO_COPY*/HashLoc)));
    if (!(FromFile != null)) {
      return;
    }
    
    Dependencies.$at_T1$C$R(FromFile).push_back(File);
    
    AllFiles.insert(File);
    AllFiles.insert(FromFile);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback::EndOfMainFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 55,
   FQN="(anonymous namespace)::DependencyGraphCallback::EndOfMainFile", NM="_ZN12_GLOBAL__N_123DependencyGraphCallback13EndOfMainFileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallback13EndOfMainFileEv")
  //</editor-fold>
  @Override public void EndOfMainFile()/* override*/ {
    OutputGraphFile();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DependencyGraphCallback::~DependencyGraphCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp", line = 29,
   FQN="(anonymous namespace)::DependencyGraphCallback::~DependencyGraphCallback", NM="_ZN12_GLOBAL__N_123DependencyGraphCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/DependencyGraph.cpp -nm=_ZN12_GLOBAL__N_123DependencyGraphCallbackD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Dependencies.$destroy();
    AllFiles.$destroy();
    SysRoot.$destroy();
    OutputFile.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT Preprocessor + ", PP=" + PP // NOI18N */
              + ", OutputFile=" + OutputFile // NOI18N
              + ", SysRoot=" + SysRoot // NOI18N
              + ", AllFiles=" + AllFiles // NOI18N
              + ", Dependencies=" + Dependencies // NOI18N
              + super.toString(); // NOI18N
  }
}
