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
package org.clang.tools.services.support;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.clang.basic.DiagnosticsEngine;
import org.clang.frontend.FrontendOptions;
import org.clang.frontend.InputKind;
import org.clang.frontend.LangStandard;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clang.tools.services.ClankProgressHandler;
import org.clang.tools.services.impl.CompilationDBFromDumpedEntries;
import org.llvm.adt.StringRef;
import org.llvm.adt.StringSwitch;
import static org.clank.support.NativePointer.*;
import org.llvm.support.raw_ostream;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class ClangUtilities {
    private ClangUtilities() {
    }
    
    public static CharSequence getFirstCompiledPath(ClankCompilationDataBase.Entry entry) {
        Collection<CharSequence> TUs = entry.getCompiledFiles();
        for (CharSequence TU : TUs) {
            return TU;
        }
        return "";
    }
    
    public static void DumpEntry(ClankCompilationDataBase.Entry compileEntry, raw_ostream out) {
        CompilationDBFromDumpedEntries.DumpEntry(compileEntry, out);
    }
        
    public static ClankProgressHandler EmptyProgress() {
        return NO_OP_PROGRESS;
    }
    
    public static ClankProgressHandler createProgress(final raw_ostream out) {
        return new ClankOSProgressHandler(out);
    }
    

    public static StringRef createPathStringRef(CharSequence pathOrUrl) {
        return new StringRef(create_char$ptr_utf8(pathOrUrl));
    }

    public static Level toLoggerLevel(DiagnosticsEngine.Level DiagLevel) {
        switch (DiagLevel) {
            case Ignored:
            case Note:
                return Level.INFO;
            case Warning:
                return Level.WARNING;
            case Error:
            case Fatal:
                return Level.SEVERE;
            default:
                throw new AssertionError(DiagLevel.name());
        }
    } 
    
    public static LangStandard.Kind getLangStandard(String param) {
      LangStandard.Kind LangStd = new StringSwitch<LangStandard.Kind>(param).
          Case("c89", LangStandard.Kind.lang_c89).
          Case("c90", LangStandard.Kind.lang_c90).
          Case("iso9899:1990", LangStandard.Kind.lang_iso9899_1990).
          Case("iso9899:199409", LangStandard.Kind.lang_c94).
          Case("gnu89", LangStandard.Kind.lang_gnu89).
          Case("gnu90", LangStandard.Kind.lang_gnu90).
          Case("c99", LangStandard.Kind.lang_c99).
          Case("c9x", LangStandard.Kind.lang_c9x).
          Case("iso9899:1999", LangStandard.Kind.lang_iso9899_1999).
          Case("iso9899:199x", LangStandard.Kind.lang_iso9899_199x).
          Case("gnu99", LangStandard.Kind.lang_gnu99).
          Case("gnu9x", LangStandard.Kind.lang_gnu9x).
          Case("c11", LangStandard.Kind.lang_c11).
          Case("c1x", LangStandard.Kind.lang_c1x).
          Case("iso9899:2011", LangStandard.Kind.lang_iso9899_2011).
          Case("iso9899:2011", LangStandard.Kind.lang_iso9899_201x).
          Case("gnu11", LangStandard.Kind.lang_gnu11).
          Case("gnu1x", LangStandard.Kind.lang_gnu1x).
          Case("c++98", LangStandard.Kind.lang_cxx98).
          Case("c++03", LangStandard.Kind.lang_cxx03).
          Case("gnu++98", LangStandard.Kind.lang_gnucxx98).
          Case("c++0x", LangStandard.Kind.lang_cxx0x).
          Case("c++11", LangStandard.Kind.lang_cxx11).
          Case("gnu++0x", LangStandard.Kind.lang_gnucxx0x).
          Case("gnu++11", LangStandard.Kind.lang_gnucxx11).
          Case("c++1y", LangStandard.Kind.lang_cxx1y).
          Case("gnu++1y", LangStandard.Kind.lang_gnucxx1y).
          Case("cl", LangStandard.Kind.lang_opencl).
          Case("CL1.1", LangStandard.Kind.lang_opencl11).
          Case("CL1.2", LangStandard.Kind.lang_opencl12).
          Case("cuda", LangStandard.Kind.lang_cuda).
          Default(LangStandard.Kind.lang_unspecified);
      return LangStd;
    }
    
    public static InputKind getInputKind(String param, String intputFile) {
        InputKind DashX = InputKind.IK_None;
        DashX = new StringSwitch<InputKind>(param).
            Case("c", InputKind.IK_C).
            Case("cl", InputKind.IK_OpenCL).
            Case("cuda", InputKind.IK_CUDA).
            Case("c++", InputKind.IK_CXX).
            Case("objective-c", InputKind.IK_ObjC).
            Case("objective-c++", InputKind.IK_ObjCXX).
            Case("cpp-output", InputKind.IK_PreprocessedC).
            Case("assembler-with-cpp", InputKind.IK_Asm).
            Case("c++-cpp-output", InputKind.IK_PreprocessedCXX).
            Case("objective-c-cpp-output", InputKind.IK_PreprocessedObjC).
            Case("objc-cpp-output", InputKind.IK_PreprocessedObjC).
            Case("objective-c++-cpp-output", InputKind.IK_PreprocessedObjCXX).
            Case("objc++-cpp-output", InputKind.IK_PreprocessedObjCXX).
            Case("c-header", InputKind.IK_C).
            Case("cl-header", InputKind.IK_OpenCL).
            Case("objective-c-header", InputKind.IK_ObjC).
            Case("c++-header", InputKind.IK_CXX).
            Case("objective-c++-header", InputKind.IK_ObjCXX).
            Cases("ast", "pcm", InputKind.IK_AST).
            Case("ir", InputKind.IK_LLVM_IR).
            Default(InputKind.IK_None);

        if (DashX == InputKind.IK_None) {
            DashX = FrontendOptions.getInputKindForExtension(new StringRef(intputFile).rsplit($('.')).second);
        }
        return DashX;
    }    
    
    private static final Pattern variable = Pattern.compile("\\$\\{([^\\}]+)\\}");

    public static String substituteEnvironmentVariables(String from) {
        return substituteEnvironmentVariables(from, System.getenv(), null);
    }

    public static String substituteEnvironmentVariables(String str, Map<String, String> variables, Map<String, String> usedVariables) {
      if (usedVariables == null) {
        usedVariables = new HashMap<>();
      } else {
        usedVariables.clear();
      }

      Matcher matcher = variable.matcher(str);
      int start = 0;
      while (matcher.find(start)) {
        String property = variables.get(matcher.group(1));
        if (property != null) {
          usedVariables.put(matcher.group(), property);
        }
        start = matcher.end();
      }

      for (String key : usedVariables.keySet()) {
        str = str.replace(key, usedVariables.get(key));
      }

      return str;
    }    

    public static class ClankProgressHandlerChain implements ClankProgressHandler {
        private final ClankProgressHandler next;

        public ClankProgressHandlerChain(ClankProgressHandler next) {
            this.next = next;
        }

        @Override
        public void setDisplayName(String newDisplayName) {
            next.setDisplayName(newDisplayName);
        }

        @Override
        public void start(int workunits, long estimate) {
            next.start(workunits, estimate);
        }

        @Override
        public void switchToIndeterminate() {
            next.switchToIndeterminate();
        }

        @Override
        public void switchToDeterminate(int workunits, long estimate) {
            next.switchToDeterminate(workunits, estimate);
        }

        @Override
        public void progress(String message, int workunit) {
            next.progress(message, workunit);
        }
    }
    
    private static final ClankProgressHandler NO_OP_PROGRESS = new ClankProgressHandler() {

        @Override
        public void setDisplayName(String newDisplayName) {
        }

        @Override
        public void start(int workunits, long estimate) {
        }

        @Override
        public void switchToIndeterminate() {
        }

        @Override
        public void switchToDeterminate(int workunits, long estimate) {
        }

        @Override
        public void progress(String message, int workunit) {
        }
    };

    private static final class ClankOSProgressHandler implements ClankProgressHandler {

        private final raw_ostream out;

        public ClankOSProgressHandler(raw_ostream out) {
            this.out = out;
        }

        @Override
        public void setDisplayName(String newDisplayName) {
            out.$out(newDisplayName).$out_char($$LF).flush();
        }

        @Override
        public void start(int workunits, long estimate) {
            out.$out("Started to proceed ").$out_uint(workunits).$out(" work units\n").flush();
        }
        
        @Override
        public void switchToIndeterminate() {
            
        }
        
        @Override
        public void switchToDeterminate(int workunits, long estimate) {
            out.$out("Going to proceed ").$out_uint(workunits).$out(" work units\n").flush();
        }
        
        @Override
        public void progress(String message, int workunit) {
            out.$out(message).$out_char($$LF).flush();
        }
    }
}
