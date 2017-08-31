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

import org.clang.tools.services.support.DataBaseEntry;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clang.tools.services.support.DataBaseEntryBuilder;

/**
 *
 * @author Vladimir Voskresensky
 */
public class CompilationDBFromNB extends AbstractClankCompilationDataBase {
    private CompilationDBFromNB(List<ClankCompilationDataBase.Entry> compilations) {
        super("DBFromNB with [" + compilations.size() + "] entries", compilations);
    }

    public static ClankCompilationDataBase createFromNBCompileLines(String nbPropFile) {
        File file = new File(nbPropFile);
        if (!file.exists()) {
            System.err.println("File does not exist: " + nbPropFile);
            return null;
        }
        List<Entry> compileLines = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        Map<String, AtomicInteger> differentLines = new ConcurrentHashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(nbPropFile), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                DataBaseEntry entry = createEntry(line);
                if (entry != null) {
                    String opts = line.substring(line.indexOf("#")+1);
                    if (!differentLines.containsKey(opts)) {
                        differentLines.put(opts, new AtomicInteger(0));
                    }
                    differentLines.get(opts).incrementAndGet();
                    compileLines.add(entry);
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }   

        if (false) {
            for (Map.Entry<String, AtomicInteger> entry : differentLines.entrySet()) {
                System.err.printf("[%2d] %s%n", entry.getValue(), entry.getKey());
            }
        }
        return new CompilationDBFromNB(compileLines);
    }
    
    private static DataBaseEntry createEntry(String line) {
        // PATH=CWD#-IAbsPath1 -IAbsPath2 -DM1 -UM2 -....
        int eq = line.indexOf("=");
        if (eq < 0) {
            System.err.println("not found '=' in line " + line);
        }
        int hash = line.indexOf("#");
        if (hash < 0) {
            System.err.println("not found '#' in  line " + line);
        }
        String file = line.substring(0, eq);
        String cwd = line.substring(eq+1, hash);
        String compileString = line.substring(hash+1);
        
        CompileLineEntryBuilder builder = new CompileLineEntryBuilder(file);
        for (String option : splitCommandLine(compileString)) {
            builder.handle(option);
        }
        return builder.createDataBaseEntry();
    }

    private static List<String> splitCommandLine(String line) {
        List<String> res = new ArrayList<>();
        int i = 0;
        StringBuilder current = new StringBuilder();
        boolean isSingleQuoteMode = false;
        boolean isDoubleQuoteMode = false;
        while (i < line.length()) {
            char c = line.charAt(i);
            i++;
            switch (c) {
                case '\'': // NOI18N
                    if (isSingleQuoteMode) {
                        isSingleQuoteMode = false;
                    } else if (!isDoubleQuoteMode) {
                        isSingleQuoteMode = true;
                    }
                    current.append(c);
                    break;
                case '\"': // NOI18N
                    if (isDoubleQuoteMode) {
                        isDoubleQuoteMode = false;
                    } else if (!isSingleQuoteMode) {
                        isDoubleQuoteMode = true;
                    }
                    current.append(c);
                    break;
                case ' ': // NOI18N
                case '\t': // NOI18N
                case '\n': // NOI18N
                case '\r': // NOI18N
                    if (isSingleQuoteMode || isDoubleQuoteMode) {
                        current.append(c);
                        break;
                    } else {
                        if (current.length() > 0) {
                            res.add(current.toString());
                            current.setLength(0);
                        }
                    }
                    break;
                default:
                    current.append(c);
                    break;
            }
        }
        if (current.length() > 0) {
            res.add(current.toString().trim());
        }
        return res;
    }

    private static final class CompileLineEntryBuilder extends DataBaseEntryBuilder {
        private final String mainFile;        
        private State state;

        private enum State {
            DASH_INCLUDE("-include"),
            DASH_D("-D"),
            DASH_I("-I"),
            DASH_F("-F"),
            DASH_STD("-std=", "-std"),
            DASH_U("-U"),
            DASH_X("-x"),
            INITIAL();
            
            private final String flags[];

            private State(String... flags) {
                this.flags = flags;
            }

            private boolean matches(String param) {
                return getOptIndex(param) >= 0;
            }

            private int getOptIndex(String param) {
                if (flags != null) {
                    for (int i = 0; i < flags.length; i++) {
                        String str = flags[i];
                        assert (str.length() > 0);
                        if (param.startsWith(str)) {
                            return i;
                        }
                        ;
                    }
                }
                return -1;
            }

            private String getValue(String param) {
                assert matches(param);
                int idx = getOptIndex(param);
                return param.substring(this.flags[idx].length());
            }
        }

        public CompileLineEntryBuilder(String mainFile) {
            this(mainFile, null);
        }

        public CompileLineEntryBuilder(String mainFile, String cwd) {
            super(mainFile, cwd == null ? null : cwd);
            this.mainFile = mainFile;
            this.state = State.INITIAL;
        }

        private void resetState() {
            state = State.INITIAL;
        }
        
        private String startNewState(String param) {
            for (State st : State.values()) {
                if (st.matches(param)) {
                    param = st.getValue(param);
                    this.state = st;
                    break;
                }
            }
            return param;
        }
        
        private void handle(String param) {
            if (state == State.INITIAL) {
                param = startNewState(param);
            }
            if (param.isEmpty()) {
                // it was like '-I Path', not '-IPath'
                // param will be passed to the next call
                return;
            }
            switch (state) {
                case DASH_INCLUDE:
                    addIncFile(param);
                    break;
                case DASH_I:
                    addUserIncludePath(param, false, true);
                    break;
                case DASH_F:
                    addUserIncludePath(param, true, true);
                    break;
                case DASH_D:
                    addUserMacroDef(param);
                    break;
                case DASH_U:
                    addUserMacroUndef(param);
                    break;
                case DASH_STD:
                    setLangStd(param);
                    break;
                case DASH_X:
                    setLang(param, mainFile);
                    break;
                case INITIAL:
                    break;
                default:
                    throw new AssertionError(state.name());
            }
            resetState();
        }
    }
    
}
