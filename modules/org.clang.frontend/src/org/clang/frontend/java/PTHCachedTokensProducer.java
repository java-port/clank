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

package org.clang.frontend.java;

import static org.clang.basic.BasicClangGlobals.$out_DiagnosticBuilder$C_StringRef;
import org.clang.basic.DiagnosticsEngine;
import org.clang.basic.FileID;
import org.clang.basic.diag;
import org.clang.frontend.FrontendClangGlobals;
import org.clang.lex.PTHManager;
import org.clang.lex.java.PTHManagerDriver;
import org.clang.lex.Preprocessor;
import org.clank.java.std;
import org.clank.java.std_errors;
import org.clank.support.Converted;
import org.clank.support.NativeTrace;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.support.ErrorOr;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.raw_fd_ostream;
import org.llvm.adt.SmallString;
import org.llvm.support.sys.fs;
import org.llvm.support.sys.path;
import org.openide.util.lookup.ServiceProvider;

/**
 * service to create token-cache files.
 * @author Vladimir Voskresensky
 */
@ServiceProvider(service = PTHManagerDriver.PTHProducer.class)
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public final class PTHCachedTokensProducer implements PTHManagerDriver.PTHProducer {
  
  public PTHCachedTokensProducer() {
  }

  @Override
  public MemoryBuffer CreateCachedTokens(/*FileID*/int FID, std.string LexedFileName, Preprocessor PP, 
          boolean needComments, boolean needIncompleteTokenState) {
    std.string OutputFile = createTemporaryPTHFile(LexedFileName, PP.getDiagnostics());
    if (OutputFile.empty()) {
      return null;
    }
    try {
      if (EmitBufferTokens(OutputFile, FID, LexedFileName, PP, needComments, needIncompleteTokenState)) {
        ErrorOr<std.unique_ptr<MemoryBuffer> > FileOrErr = PTHManager.CreateMemoryBuffer(OutputFile);
        if (FileOrErr.$bool()) {
          // was able to load token-cache
          MemoryBuffer Buf = FileOrErr.get().release();
          return Buf;
        }
      }
      return null;
    } catch (Throwable e) {
      NativeTrace.printStackTraceOnce(e);
      return null;
    } finally {
      // clear temporary file
      std_errors.error_code EC = fs.remove(new Twine(OutputFile));
      if (EC.$bool()) {
        // can not remove temporary file
      }
    }
  }
  
  private std.string createTemporaryPTHFile(std.string LexedFileName, DiagnosticsEngine Diags) {
    StringRef Path = new StringRef(LexedFileName);
    StringRef Name = path.filename(Path);
    SmallString/*128*/ PathBuf = new SmallString/*128*/(128);
    std.error_code EC = fs.createTemporaryFile(new Twine(Name), new StringRef("pth"), PathBuf);
    if (EC.$bool()) {
      $out_DiagnosticBuilder$C_StringRef(Diags.Report(diag.err_unable_to_make_temp), new StringRef(EC.message())).$destroy();
      return std.string.EMPTY;
    }
    return PathBuf.str().$string();   
  }
  
  private boolean EmitBufferTokens(std.string outFileName, /*FileID*/int FID, std.string FileName, 
          Preprocessor PP, boolean needComments, boolean needIncompleteTokenState) {
    assert FID != FileID.getInvalidID();
    raw_fd_ostream /*P*/ OS = null;
    try {
    // prepare output file
    std.error_code Error/*J*/= new std.error_code();
      OS = new raw_fd_ostream(new StringRef(outFileName), Error, fs.OpenFlags.F_None);
    if (Error.$bool()) {
        return false;
    }
    
    // emit PTH into file stream
    FrontendClangGlobals.CacheTokens(PP, OS, FID, FileName, needComments, needIncompleteTokenState);
    return true;
    } finally {
      if (OS != null) {OS.$destroy();}
    }
  }
}
