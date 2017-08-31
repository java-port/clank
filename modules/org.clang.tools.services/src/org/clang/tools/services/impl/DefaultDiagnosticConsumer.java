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
/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2015 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2015 Sun Microsystems, Inc.
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
import org.clang.tools.services.support.ClangUtilities;
import org.clank.java.std;
import org.clank.support.Native;
import org.llvm.adt.SmallString;
import org.llvm.support.llvm;
import org.llvm.support.raw_ostream;

/**
 *
 * @author Vladimir Voskresensky
 */
public class DefaultDiagnosticConsumer extends /*public*/ TextDiagnosticPrinter {
    private boolean insideSourceFile = false;
    private final raw_ostream out;
    private final boolean null_stream;
    
    public DefaultDiagnosticConsumer(raw_ostream /*&*/ os, DiagnosticOptions /*P*/ diags) {
        super(os, diags, false);
        assert os != null;
        this.out = os;
        this.null_stream = (os == llvm.nulls());
    }

    @Override
    public /*virtual*/ void BeginSourceFile(/*const*//*const*/LangOptions /*&*/ LangOpts, /*const*/PreprocessorImplementation /*P*/ PP) {
        super.BeginSourceFile(LangOpts, PP); 
        insideSourceFile = true;
    }
    
    @Override
    public void EndSourceFile() {
        insideSourceFile = false;
        super.EndSourceFile(); 
    }
    
    @Override
    public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, Diagnostic Info) {
        if (null_stream) {
            return;
        }
        if (insideSourceFile) {
            super.HandleDiagnostic(DiagLevel, Info);
            return;
        }
        SmallString out = new SmallString(1024);
        Info.FormatDiagnostic(out);
        String Loc = "";
        if (Info.hasSourceManager()) {
            PresumedLoc presumedLoc = Info.getSourceManager().getPresumedLoc(Info.getLocation());
            if (presumedLoc.isValid()) {
                Loc = "In file " + Native.$toString(presumedLoc.getFilename()) + " line " + presumedLoc.getLine() + ", col " + presumedLoc.getColumn() + "\n";
            }
        }
        Level level = ClangUtilities.toLoggerLevel(DiagLevel);
        String msg = new std.string(out.data()).toJavaString();
        if (DiagLevel.getValue() >= DiagnosticsEngine.Level.Error.getValue()) {
            msg = msg;
        }
        Logger.getLogger(DefaultDiagnosticConsumer.class.getName()).log(level, "{2}{0}:{1}\n", new Object[]{DiagLevel, msg, Loc});
    }
}
