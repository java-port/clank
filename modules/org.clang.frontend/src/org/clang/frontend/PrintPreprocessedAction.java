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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import static org.clang.frontend.FrontendClangGlobals.*;
import org.clang.basic.*;
import org.clang.frontend.*;

//<editor-fold defaultstate="collapsed" desc="clang::PrintPreprocessedAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 233,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 232,
 FQN="clang::PrintPreprocessedAction", NM="_ZN5clang23PrintPreprocessedActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang23PrintPreprocessedActionE")
//</editor-fold>
public class PrintPreprocessedAction extends /*public*/ PreprocessorFrontendAction implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreprocessedAction::ExecuteAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", line = 677,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp", old_line = 671,
   FQN="clang::PrintPreprocessedAction::ExecuteAction", NM="_ZN5clang23PrintPreprocessedAction13ExecuteActionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp -nm=_ZN5clang23PrintPreprocessedAction13ExecuteActionEv")
  //</editor-fold>
  @Override protected void ExecuteAction()/* override*/ {
    std.unique_ptr<raw_ostream> OS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CompilerInstance /*&*/ CI = getCompilerInstance();
      // Output file may need to be set to 'Binary', to avoid converting Unix style
      // line feeds (<LF>) to Microsoft style line feeds (<CR><LF>).
      //
      // Look to see what type of line endings the file uses. If there's a
      // CRLF, then we won't open the file up in binary mode. If there is
      // just an LF or CR, then we will open the file up in binary mode.
      // In this fashion, the output format should match the input format, unless
      // the input format has inconsistent line endings.
      //
      // This should be a relatively fast operation since most files won't have
      // all of their source code on a single line. However, that is still a 
      // concern, so if we scan for too long, we'll just assume the file should
      // be opened in binary mode.
      boolean BinaryMode = true;
      bool$ptr InvalidFile = null;//create_bool$ptr(false);
      /*const*/ SourceManager /*&*/ SM = CI.getSourceManager();
      /*const*/ MemoryBuffer /*P*/ Buffer = SM.getBuffer(SM.getMainFileID(), 
          /*AddrOf*/InvalidFile);
      if (!Buffer.isInvalid()) {
        /*const*/char$ptr/*char P*/ cur = $tryClone(Buffer.getBufferStart());
        /*const*/char$ptr/*char P*/ end = $tryClone(Buffer.getBufferEnd());
        /*const*/char$ptr/*char P*/ next = $tryClone(($noteq_ptr(cur, end)) ? cur.$add(1) : end);
        
        // Limit ourselves to only scanning 256 characters into the source
        // file.  This is mostly a sanity check in case the file has no 
        // newlines whatsoever.
        if (end.$sub(cur) > 256) {
          end = $tryClone(cur.$add(256));
        }
        while (next.$less(end)) {
          if (cur.$star() == 0x0D) { // CR
            if (next.$star() == 0x0A) { // CRLF
              BinaryMode = false;
            }
            
            break;
          } else if (cur.$star() == 0x0A) { // LF
            break;
          }
          
          cur.$preInc();
          next.$preInc();
        }
      }
      
      OS = $c$.clean(new std.unique_ptr<raw_ostream>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(CI.createDefaultOutputFile(BinaryMode, getCurrentFile()))));
      if (!OS.$bool()) {
        return;
      }
      
      DoPrintPreprocessedInput(CI.getPreprocessor(), OS.get(), 
          CI.getPreprocessorOutputOpts());
    } finally {
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreprocessedAction::hasPCHSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 237,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 236,
   FQN="clang::PrintPreprocessedAction::hasPCHSupport", NM="_ZNK5clang23PrintPreprocessedAction13hasPCHSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZNK5clang23PrintPreprocessedAction13hasPCHSupportEv")
  //</editor-fold>
  @Override public/*protected*/ boolean hasPCHSupport() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreprocessedAction::~PrintPreprocessedAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 232,
   FQN="clang::PrintPreprocessedAction::~PrintPreprocessedAction", NM="_ZN5clang23PrintPreprocessedActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang23PrintPreprocessedActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintPreprocessedAction::PrintPreprocessedAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Frontend/FrontendActions.h", old_line = 232,
   FQN="clang::PrintPreprocessedAction::PrintPreprocessedAction", NM="_ZN5clang23PrintPreprocessedActionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp -nm=_ZN5clang23PrintPreprocessedActionC1Ev")
  //</editor-fold>
  public /*inline*/ PrintPreprocessedAction() {
    // : PreprocessorFrontendAction() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
