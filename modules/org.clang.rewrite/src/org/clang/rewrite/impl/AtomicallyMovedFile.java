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

package org.clang.rewrite.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.support.sys.fs;

// A wrapper for a file stream that atomically overwrites the target.
//
// Creates a file output stream for a temporary file in the constructor,
// which is later accessible via getStream() if ok() return true.
// Flushes the stream and moves the temporary file to the target location
// in the destructor.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicallyMovedFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 402,
 FQN="(anonymous namespace)::AtomicallyMovedFile", NM="_ZN12_GLOBAL__N_119AtomicallyMovedFileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN12_GLOBAL__N_119AtomicallyMovedFileE")
//</editor-fold>
public class AtomicallyMovedFile implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicallyMovedFile::AtomicallyMovedFile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 404,
   FQN="(anonymous namespace)::AtomicallyMovedFile::AtomicallyMovedFile", NM="_ZN12_GLOBAL__N_119AtomicallyMovedFileC1ERN5clang17DiagnosticsEngineEN4llvm9StringRefERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN12_GLOBAL__N_119AtomicallyMovedFileC1ERN5clang17DiagnosticsEngineEN4llvm9StringRefERb")
  //</editor-fold>
  public AtomicallyMovedFile(DiagnosticsEngine /*&*/ Diagnostics, StringRef Filename, 
      bool$ref/*bool &*/ AllWritten) {
    // : Diagnostics(Diagnostics), Filename(Filename), TempFilename(), FileStream(), AllWritten(AllWritten) 
    //START JInit
    this./*&*/Diagnostics=/*&*/Diagnostics;
    this.Filename = new StringRef(Filename);
    this.TempFilename = new SmallString/*128*/(128);
    this.FileStream = new std.unique_ptr<raw_fd_ostream>();
    this./*&*/AllWritten=/*&*/AllWritten;
    //END JInit
    TempFilename.$assign(/*NO_COPY*/Filename);
    TempFilename.$addassign(/*STRINGREF_STR*/"-%%%%%%%%");
    int$ref FD = create_int$ref();
    if (fs.createUniqueFile(new Twine(TempFilename), FD, TempFilename).$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        AllWritten.$set(false);
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(Diagnostics.Report(diag.err_unable_to_make_temp)), 
            TempFilename.$StringRef()));
      } finally {
        $c$.$destroy();
      }
    } else {
      FileStream.reset(new raw_fd_ostream(FD.$deref(), /*shouldClose=*/ true));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicallyMovedFile::~AtomicallyMovedFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 419,
   FQN="(anonymous namespace)::AtomicallyMovedFile::~AtomicallyMovedFile", NM="_ZN12_GLOBAL__N_119AtomicallyMovedFileD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN12_GLOBAL__N_119AtomicallyMovedFileD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (!ok()) {
      return;
    }
    
    // Close (will also flush) theFileStream.
    FileStream.$arrow().close();
    {
      std.error_code ec = fs.rename(new Twine(TempFilename), new Twine(Filename));
      if (ec.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          AllWritten.$set(false);
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(Diagnostics.Report(diag.err_unable_to_rename_temp)), 
                      TempFilename.$StringRef()), /*NO_COPY*/Filename), new StringRef(ec.message())));
          // If the remove fails, there's not a lot we can do - this is already an
          // error.
          fs.remove(new Twine(TempFilename));
        } finally {
          $c$.$destroy();
        }
      }
    }
    //START JDestroy
    FileStream.$destroy();
    TempFilename.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicallyMovedFile::ok">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 434,
   FQN="(anonymous namespace)::AtomicallyMovedFile::ok", NM="_ZN12_GLOBAL__N_119AtomicallyMovedFile2okEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN12_GLOBAL__N_119AtomicallyMovedFile2okEv")
  //</editor-fold>
  public boolean ok() {
    return (boolean)FileStream.$bool();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AtomicallyMovedFile::getStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp", line = 435,
   FQN="(anonymous namespace)::AtomicallyMovedFile::getStream", NM="_ZN12_GLOBAL__N_119AtomicallyMovedFile9getStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/Rewriter.cpp -nm=_ZN12_GLOBAL__N_119AtomicallyMovedFile9getStreamEv")
  //</editor-fold>
  public raw_ostream /*&*/ getStream() {
    return FileStream.$star();
  }

/*private:*/
  private DiagnosticsEngine /*&*/ Diagnostics;
  private StringRef Filename;
  private SmallString/*128*/ TempFilename;
  private std.unique_ptr<raw_fd_ostream> FileStream;
  private bool$ref/*bool &*/ AllWritten;
  
  @Override public String toString() {
    return "" + "Diagnostics=" + Diagnostics // NOI18N
              + ", Filename=" + Filename // NOI18N
              + ", TempFilename=" + TempFilename // NOI18N
              + ", FileStream=" + FileStream // NOI18N
              + ", AllWritten=" + AllWritten; // NOI18N
  }
}
