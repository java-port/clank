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

package org.clang.format.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.tooling.core.*;
import org.clang.basic.*;
import org.clang.basic.vfs.*;

//<editor-fold defaultstate="collapsed" desc="clang::format::Environment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 39,
 FQN="clang::format::Environment", NM="_ZN5clang6format11EnvironmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format11EnvironmentE")
//</editor-fold>
public class Environment implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 41,
   FQN="clang::format::Environment::Environment", NM="_ZN5clang6format11EnvironmentC1ERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format11EnvironmentC1ERNS_13SourceManagerENS_6FileIDEN4llvm8ArrayRefINS_15CharSourceRangeEEE")
  //</editor-fold>
  public Environment(final SourceManager /*&*/ SM, FileID ID, ArrayRef<CharSourceRange> Ranges) {
    // : ID(ID), FileName(), CharRanges(Ranges.begin(), Ranges.end()), SM(SM), FileMgr(), VirtualSM(), Diagnostics() 
    //START JInit
    this.ID = new FileID(ID);
    this.FileName = new StringRef();
    this.CharRanges = new SmallVector<CharSourceRange/*,8*/>(JD$T.INSTANCE, 8, Ranges.begin(), Ranges.end(), new CharSourceRange());
    this./*&*/SM=/*&*/SM;
    this.FileMgr = new std.unique_ptr<FileManager>();
    this.VirtualSM = new std.unique_ptr<SourceManager>();
    this.Diagnostics = new std.unique_ptr<DiagnosticsEngine>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 44,
   FQN="clang::format::Environment::Environment", NM="_ZN5clang6format11EnvironmentC1ENS_6FileIDESt10unique_ptrINS_11FileManagerESt14default_deleteIS4_EES3_INS_13SourceManagerES5_IS8_EES3_INS_17DiagnosticsEngineES5_ISB_EERKSt6vectorINS_15CharSourceRangeESaISF_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format11EnvironmentC1ENS_6FileIDESt10unique_ptrINS_11FileManagerESt14default_deleteIS4_EES3_INS_13SourceManagerES5_IS8_EES3_INS_17DiagnosticsEngineES5_ISB_EERKSt6vectorINS_15CharSourceRangeESaISF_EE")
  //</editor-fold>
  public Environment(FileID ID, std.unique_ptr<FileManager> FileMgr, 
      std.unique_ptr<SourceManager> VirtualSM, 
      std.unique_ptr<DiagnosticsEngine> Diagnostics, 
      final /*const*/std.vector<CharSourceRange> /*&*/ CharRanges) {
    // : ID(ID), FileName(), CharRanges(CharRanges.begin(), CharRanges.end()), SM(* VirtualSM), FileMgr(std::move(FileMgr)), VirtualSM(std::move(VirtualSM)), Diagnostics(std::move(Diagnostics)) 
    //START JInit
    this.ID = new FileID(ID);
    this.FileName = new StringRef();
    this.CharRanges = new SmallVector<CharSourceRange/*,8*/>(JD$T.INSTANCE, 8, CharRanges.begin$Const(), CharRanges.end$Const(), new CharSourceRange());
    this./*&*/SM=/*&*/VirtualSM.$star();
    this.FileMgr = new std.unique_ptr<FileManager>(JD$Move.INSTANCE, std.move(FileMgr));
    this.VirtualSM = new std.unique_ptr<SourceManager>(JD$Move.INSTANCE, std.move(VirtualSM));
    this.Diagnostics = new std.unique_ptr<DiagnosticsEngine>(JD$Move.INSTANCE, std.move(Diagnostics));
    //END JInit
  }

  
  // This sets up an virtual file system with file \p FileName containing \p
  // Code.
  
  // This sets up an virtual file system with file \p FileName containing \p
  // Code.
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::CreateVirtualEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp", line = 39,
   FQN="clang::format::Environment::CreateVirtualEnvironment", NM="_ZN5clang6format11Environment24CreateVirtualEnvironmentEN4llvm9StringRefES3_NS2_8ArrayRefINS_7tooling5RangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format11Environment24CreateVirtualEnvironmentEN4llvm9StringRefES3_NS2_8ArrayRefINS_7tooling5RangeEEE")
  //</editor-fold>
  public static std.unique_ptr<Environment> CreateVirtualEnvironment(StringRef Code, StringRef FileName, 
                          ArrayRef<Range> Ranges) {
    IntrusiveRefCntPtr<InMemoryFileSystem> InMemoryFileSystem = null;
    std.unique_ptr<FileManager> FileMgr = null;
    std.unique_ptr<DiagnosticsEngine> Diagnostics = null;
    std.unique_ptr<SourceManager> VirtualSM = null;
    std.vector<CharSourceRange> CharRanges = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // This is referenced by `FileMgr` and will be released by `FileMgr` when it
      // is deleted.
      InMemoryFileSystem/*J*/= new IntrusiveRefCntPtr<InMemoryFileSystem>(new InMemoryFileSystem());
      // This is passed to `SM` as reference, so the pointer has to be referenced
      // in `Environment` so that `FileMgr` can out-live this function scope.
      FileMgr/*J*/= $c$.clean(new std.unique_ptr<FileManager>(new FileManager(new FileSystemOptions(), $c$.track(new IntrusiveRefCntPtr<FileSystem>(JD$IntrusiveRefCntPtr$X$C.INSTANCE, InMemoryFileSystem)))));
      // This is passed to `SM` as reference, so the pointer has to be referenced
      // by `Environment` due to the same reason above.
      Diagnostics/*J*/= $c$.clean(new std.unique_ptr<DiagnosticsEngine>(new DiagnosticsEngine($c$.track(new IntrusiveRefCntPtr<DiagnosticIDs>(new DiagnosticIDs())), 
              new DiagnosticOptions())));
      // This will be stored as reference, so the pointer has to be stored in
      // due to the same reason above.
      VirtualSM/*J*/= new std.unique_ptr<SourceManager>(new SourceManager(Diagnostics.$star(), FileMgr.$star()));
      $c$.clean(InMemoryFileSystem.$arrow().addFile(new Twine(FileName), 0, $c$.track(MemoryBuffer.getMemBuffer(new StringRef(Code), new StringRef(FileName), /*RequiresNullTerminator=*/ false))));
      FileID ID = VirtualSM.$arrow().createFileID(FileMgr.$arrow().getFile(/*NO_COPY*/FileName), 
          new SourceLocation(), SrcMgr.CharacteristicKind.C_User);
      assert (ID.isValid());
      SourceLocation StartOfFile = VirtualSM.$arrow().getLocForStartOfFile(/*NO_COPY*/ID);
      CharRanges/*J*/= new std.vector<CharSourceRange>(new CharSourceRange());
      for (final /*const*/ Range /*&*/ $Range : Ranges) {
        SourceLocation Start = StartOfFile.getLocWithOffset($Range.getOffset());
        SourceLocation End = Start.getLocWithOffset($Range.getLength());
        CharRanges.push_back_T$RR(CharSourceRange.getCharRange(/*NO_COPY*/Start, /*NO_COPY*/End));
      }
      return llvm.make_unique(new Environment(ID, std.move(FileMgr), 
          std.move(VirtualSM), 
          std.move(Diagnostics), CharRanges));
    } finally {
      if (CharRanges != null) { CharRanges.$destroy(); }
      if (VirtualSM != null) { VirtualSM.$destroy(); }
      if (Diagnostics != null) { Diagnostics.$destroy(); }
      if (FileMgr != null) { FileMgr.$destroy(); }
      if (InMemoryFileSystem != null) { InMemoryFileSystem.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::getFileID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 58,
   FQN="clang::format::Environment::getFileID", NM="_ZNK5clang6format11Environment9getFileIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZNK5clang6format11Environment9getFileIDEv")
  //</editor-fold>
  public FileID getFileID() /*const*/ {
    return new FileID(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::getFileName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 60,
   FQN="clang::format::Environment::getFileName", NM="_ZNK5clang6format11Environment11getFileNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZNK5clang6format11Environment11getFileNameEv")
  //</editor-fold>
  public StringRef getFileName() /*const*/ {
    return new StringRef(FileName);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::getCharRanges">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 62,
   FQN="clang::format::Environment::getCharRanges", NM="_ZNK5clang6format11Environment13getCharRangesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZNK5clang6format11Environment13getCharRangesEv")
  //</editor-fold>
  public ArrayRef<CharSourceRange> getCharRanges() /*const*/ {
    return new ArrayRef<CharSourceRange>(CharRanges, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::getSourceManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 64,
   FQN="clang::format::Environment::getSourceManager", NM="_ZNK5clang6format11Environment16getSourceManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZNK5clang6format11Environment16getSourceManagerEv")
  //</editor-fold>
  public /*const*/ SourceManager /*&*/ getSourceManager() /*const*/ {
    return SM;
  }

/*private:*/
  private FileID ID;
  private StringRef FileName;
  private SmallVector<CharSourceRange/*,8*/> CharRanges;
  private final SourceManager /*&*/ SM;
  
  // The order of these fields are important - they should be in the same order
  // as they are created in `CreateVirtualEnvironment` so that they can be
  // deleted in the reverse order as they are created.
  private std.unique_ptr<FileManager> FileMgr;
  private std.unique_ptr<SourceManager> VirtualSM;
  private std.unique_ptr<DiagnosticsEngine> Diagnostics;
  //<editor-fold defaultstate="collapsed" desc="clang::format::Environment::~Environment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.h", line = 39,
   FQN="clang::format::Environment::~Environment", NM="_ZN5clang6format11EnvironmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/TokenAnalyzer.cpp -nm=_ZN5clang6format11EnvironmentD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Diagnostics.$destroy();
    VirtualSM.$destroy();
    FileMgr.$destroy();
    CharRanges.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ID=" + ID // NOI18N
              + ", FileName=" + FileName // NOI18N
              + ", CharRanges=" + CharRanges // NOI18N
              + ", SM=" + "[SourceManager]" // NOI18N
              + ", FileMgr=" + "[Unique_ptr$FileManager]" // NOI18N
              + ", VirtualSM=" + "[Unique_ptr$SourceManager]" // NOI18N
              + ", Diagnostics=" + "[Unique_ptr$DiagnosticsEngine]"; // NOI18N
  }
}
