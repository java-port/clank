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

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type TextDiagnosticPrinterStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZL22printDiagnosticOptionsRN4llvm11raw_ostreamEN5clang17DiagnosticsEngine5LevelERKNS2_10DiagnosticERKNS2_17DiagnosticOptionsE; -static-type=TextDiagnosticPrinterStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class TextDiagnosticPrinterStatics {


/// \brief Print any diagnostic option information to a raw_ostream.
///
/// This implements all of the logic for adding diagnostic options to a message
/// (via OS). Each relevant option is comma separated and all are enclosed in
/// the standard bracketing: " [...]".
//<editor-fold defaultstate="collapsed" desc="printDiagnosticOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp", line = 54,
 FQN="printDiagnosticOptions", NM="_ZL22printDiagnosticOptionsRN4llvm11raw_ostreamEN5clang17DiagnosticsEngine5LevelERKNS2_10DiagnosticERKNS2_17DiagnosticOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TextDiagnosticPrinter.cpp -nm=_ZL22printDiagnosticOptionsRN4llvm11raw_ostreamEN5clang17DiagnosticsEngine5LevelERKNS2_10DiagnosticERKNS2_17DiagnosticOptionsE")
//</editor-fold>
public static void printDiagnosticOptions(raw_ostream /*&*/ OS, 
                      DiagnosticsEngine.Level Level, 
                      /*const*/ Diagnostic /*&*/ Info, 
                      /*const*/ DiagnosticOptions /*&*/ DiagOpts) {
  boolean Started = false;
  if (DiagOpts.ShowOptionNames) {
    // Handle special cases for non-warnings early.
    if (Info.getID() == diag.fatal_too_many_errors) {
      OS.$out(/*KEEP_STR*/" [-ferror-limit=]");
      return;
    }
    
    // The code below is somewhat fragile because we are essentially trying to
    // report to the user what happened by inferring what the diagnostic engine
    // did. Eventually it might make more sense to have the diagnostic engine
    // include some "why" information in the diagnostic.
    
    // If this is a warning which has been mapped to an error by the user (as
    // inferred by checking whether the default mapping is to an error) then
    // flag it as such. Note that diagnostics could also have been mapped by a
    // pragma, but we don't currently have a way to distinguish this.
    if (Level == DiagnosticsEngine.Level.Error
       && DiagnosticIDs.isBuiltinWarningOrExtension(Info.getID())
       && !DiagnosticIDs.isDefaultMappingAsError(Info.getID())) {
      OS.$out(/*KEEP_STR*/" [-Werror");
      Started = true;
    }
    
    StringRef Opt = DiagnosticIDs.getWarningOptionForDiag(Info.getID());
    if (!Opt.empty()) {
      OS.$out((Started ? $COMMA : $(" ["))).$out(
          (Level == DiagnosticsEngine.Level.Remark ? $("-R") : $("-W"))
      ).$out(/*NO_COPY*/Opt);
      StringRef OptValue = Info.getDiags().getFlagValue();
      if (!OptValue.empty()) {
        OS.$out(/*KEEP_STR*/$EQ).$out(/*NO_COPY*/OptValue);
      }
      Started = true;
    }
  }
  
  // If the user wants to see category information, include it too.
  if ((DiagOpts.ShowCategories != 0)) {
    /*uint*/int DiagCategory = DiagnosticIDs.getCategoryNumberForDiag(Info.getID());
    if ((DiagCategory != 0)) {
      OS.$out((Started ? $COMMA : $(" [")));
      Started = true;
      if (DiagOpts.ShowCategories == 1) {
        OS.$out_uint(DiagCategory);
      } else {
        assert (DiagOpts.ShowCategories == 2) : "Invalid ShowCategories value";
        OS.$out(DiagnosticIDs.getCategoryNameFromID(DiagCategory));
      }
    }
  }
  if (Started) {
    OS.$out_char($$RSQUARE);
  }
}

} // END OF class TextDiagnosticPrinterStatics
