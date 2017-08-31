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

package org.clang.tools.services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.clang.basic.Diagnostic;
import org.clang.basic.DiagnosticOptions;
import org.clang.basic.DiagnosticsEngine;
import org.clang.basic.LangOptions;
import org.clang.basic.PresumedLoc;
import org.clang.basic.spi.PreprocessorImplementation;
import org.clang.frontend.TextDiagnosticPrinter;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clang.tools.services.ClankDiagnosticInfo;
import org.clang.tools.services.ClankDiagnosticServices;
import org.clang.tools.services.ClankRunDiagnosticsSettings;
import org.clang.tools.services.support.ClangUtilities;
import org.clank.support.Native;
import org.llvm.support.llvm;
import org.llvm.support.raw_ostream;

/**
 *
 * @author masha
 */
public class ClankDiagnosticsConsumerImpl extends /*public*/ TextDiagnosticPrinter {
    private boolean insideSourceFile = false;
    private final raw_ostream out;
    private final boolean null_stream;
    private final ClankDiagnosticsStorage diagnosticsStorage;
    //private final ClankDiagnosticResponse response;
    private final ClankCompilationDataBase.Entry entry;
    private LangOptions /*&*/ LangOpts;
    
    public ClankDiagnosticsConsumerImpl(raw_ostream /*&*/ os, DiagnosticOptions /*P*/ diags, 
            ClankRunDiagnosticsSettings settings, ClankCompilationDataBase.Entry entry) {
        super(os, diags, false);
//        super();
        assert os != null;
        this.out = os;
        this.null_stream = (os == llvm.nulls());
        this.diagnosticsStorage = new ClankDiagnosticsStorage(settings.response, entry);
        this.entry = entry;
    }

    @Override
    public /*virtual*/ void BeginSourceFile(/*const*//*const*/LangOptions /*&*/ LangOpts, /*const*/PreprocessorImplementation /*P*/ PP) {
        super.BeginSourceFile(LangOpts, PP); 
        this.LangOpts = LangOpts;
        insideSourceFile = true;
    }
    
    @Override
    public void EndSourceFile() {
        insideSourceFile = false;
        super.EndSourceFile(); 
        diagnosticsStorage.done();
    }
      
    @Override
    public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, final Diagnostic Info) {
        
        if (null_stream) {
            return;
        }
        String  fileName = "";
        if (Info.hasSourceManager()) {
            PresumedLoc presumedLoc = Info.getSourceManager().getPresumedLoc(Info.getLocation());
            if (presumedLoc.isValid()) {
              fileName = Native.$toString(presumedLoc.getFilename());
            }
        }
        Level level = ClangUtilities.toLoggerLevel(DiagLevel);       
        if (!entry.getCompiledFiles().iterator().next().toString().equals(fileName)) {
          Logger.getLogger(ClankDiagnosticsConsumerImpl.class.getName()).log(Level.FINE, "file is not the same as requested, problem found in {0}", fileName);
          return;
        }
        if (ClankDiagnosticServices.DEBUG_DIAGNOSTIC_SERVICES) {
          super.HandleDiagnostic(DiagLevel, Info);
        }
        //it was an attempt to add note from the header file if original error/warning found in our entry.
        //need to work on it, now it doesn't work
//        if (diagnosticsStorage.willBeAdded(ClankDiagnosticInfo.Severity.valueOf(DiagLevel.getValue()), fileName)) {
          diagnosticsStorage.addError(new ClankDiagnosticInfoImpl(DiagLevel, Info, LangOpts));
//        }
        
    }    
}
