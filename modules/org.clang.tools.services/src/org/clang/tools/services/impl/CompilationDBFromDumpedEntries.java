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
import org.clang.frontend.InputKind;
import org.clang.frontend.LangStandard;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clang.tools.services.support.DataBaseEntry;
import org.clang.tools.services.support.DataBaseEntryBuilder;
import org.clank.support.NativeTrace;
import org.llvm.support.llvm;
import org.llvm.support.raw_ostream;
import static org.clank.support.literal_constants.$LF;

/**
 *
 * @author Vladimir Voskresensky
 */
public class CompilationDBFromDumpedEntries extends AbstractClankCompilationDataBase {
    private CompilationDBFromDumpedEntries(String dbName, List<Entry> compilations) {
        super(dbName, compilations);
    }

    public static void DumpEntry(ClankCompilationDataBase.Entry compileEntry, raw_ostream out) {
        out.$out(TU_PREFIX).$out($LF);
        for (CharSequence Path : compileEntry.getCompiledFiles()) {
            out.$out(Path.toString()).$out($LF);
        }
        out.$out(CWD_PREFIX).$out($LF);
        CharSequence CWD = compileEntry.getCompileWorkingDir();
        out.$out(CWD == null ? NULL_VAL : CWD.toString()).$out($LF);         
        out.$out(SYS_ROOT_PREFIX).$out($LF);
        CharSequence SysRoot = compileEntry.getSysRoot();
        out.$out(SysRoot == null ? NULL_VAL : SysRoot.toString()).$out($LF);         

        out.$out(LANG_PREFIX).$out($LF);
        out.$out(compileEntry.getLanguage().name()).$out($LF);            
        out.$out(LANG_STD_PREFIX).$out($LF);
        out.$out(compileEntry.getLangStandard().name()).$out($LF);            
    
        // handle -include
        out.$out(INCLUDE_FILE_PREFIX).$out($LF);
        for (CharSequence path : compileEntry.getIncludeFiles()) {
            out.$out(path.toString()).$out($LF);
        }
        // -I
        out.$out(INCLUDE_USER_PREFIX).$out($LF);
        for (IncludePath Path : compileEntry.getUserIncludePaths()) {
            out.$out(Path.getPath().toString()).
                    $out(Path.isFramework()?FRAMEWORK_MARKER:"").
                    $out(Path.ignoreSysRoot()?"":WITH_SYS_ROOT_MARKER).
                    $out($LF);
        }
        out.$out(INCLUDE_SYSTEM_PREFIX).$out($LF);
        for (IncludePath Path : compileEntry.getPredefinedSystemIncludePaths()) {
            out.$out(Path.getPath().toString()).
                    $out(Path.isFramework()?FRAMEWORK_MARKER:"").
                    $out(Path.ignoreSysRoot()?"":WITH_SYS_ROOT_MARKER).
                    $out($LF);
        }
        out.$out(USER_DEFINES_PREFIX).$out($LF);
        for (String macro : compileEntry.getUserMacroDefines()) {
            out.$out(macro).$out($LF);
        }
        out.$out(USER_UNDEFINES_PREFIX).$out($LF);
        for (String macro : compileEntry.getUserMacroUndefines()) {
            out.$out(macro).$out($LF);
        }
        out.$out(SYSTEM_DEFINES_PREFIX).$out($LF);
        for (String macro : compileEntry.getSystemMacroDefines()) {
            out.$out(macro).$out($LF);
        }
    }
    
    public static ClankCompilationDataBase createFromDumpEntries(String path) {
      long time = System.currentTimeMillis();
      try {
        File file = new File(path);
        if (!file.exists()) {
            System.err.println("File does not exist: " + path);
            return null;
        }
        List<ClankCompilationDataBase.Entry> compileLines = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        DumpEntryBuilder builder = null;
        Map<String, AtomicInteger> differentLines = new ConcurrentHashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (DumpEntryBuilder.isStartNewEntry(line)) {
                    if (builder != null) {
                        DataBaseEntry entry = builder.createDataBaseEntry();
                        if (PreprocessorSupport.isInterstingTestFile(entry)) {
                          compileLines.add(entry);
                        }
                    }
                    builder = new DumpEntryBuilder();
                }
                builder.handle(line);
            }
            if (builder != null) {
                DataBaseEntry entry = builder.createDataBaseEntry();
                if (PreprocessorSupport.isInterstingTestFile(entry)) {
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
        return new CompilationDBFromDumpedEntries(path, compileLines);
      } finally {
        time = System.currentTimeMillis() - time;
        llvm.outs().$out("Creating DB from ").$out(path).$out(" took ").$out(NativeTrace.formatNumber(time)).$out("ms \n").flush();
      }
    }
    
    private static final String SYSTEM_DEFINES_PREFIX = "@system defines";
    private static final String USER_UNDEFINES_PREFIX = "@user undefines";
    private static final String USER_DEFINES_PREFIX = "@user defines";
    private static final String INCLUDE_SYSTEM_PREFIX = "@include <...>";
    private static final String INCLUDE_USER_PREFIX = "@include \"...\"";
    private static final String INCLUDE_FILE_PREFIX = "@-include";
    private static final String LANG_STD_PREFIX = "@Language standard";
    private static final String LANG_PREFIX = "@Language";
    private static final String CWD_PREFIX = "@CWD";
    private static final String SYS_ROOT_PREFIX = "@SYS_ROOT";
    private static final String TU_PREFIX = "@TU";
    private static final String NULL_VAL = "NULL";
    private static final String FRAMEWORK_MARKER = " (framework directory)";
    private static final String WITH_SYS_ROOT_MARKER = " (-iwithsysroot)";
    
    private static final class DumpEntryBuilder extends DataBaseEntryBuilder {

        private static boolean isStartNewEntry(String line) {
            return State.TU.matches(line);
        }
        
        private State state = State.INITIAL;

        private enum State {
            TU(TU_PREFIX),
            CWD(CWD_PREFIX),
            SYS_ROOT(SYS_ROOT_PREFIX),
            DASH_STD(LANG_STD_PREFIX),
            DASH_X(LANG_PREFIX),
            DASH_INCLUDE(INCLUDE_FILE_PREFIX),
            DASH_I(INCLUDE_USER_PREFIX),
            INCLUDE_SYSTEM(INCLUDE_SYSTEM_PREFIX),
            DASH_D(USER_DEFINES_PREFIX),
            DASH_U(USER_UNDEFINES_PREFIX),
            SYSTEM_DEFINES(SYSTEM_DEFINES_PREFIX),
            INITIAL(null);
            
            private final String flag;

            private State(String flags) {
                this.flag = flags;
            }

            private boolean matches(String param) {
                if (flag != null) {
                    assert (flag.length() > 0);
                    if (param.startsWith(flag)) {
                        return true;
                    }
                }
                return false;
            }
        }
        private static final State[] STATE_VALUES = State.values();
        
        private boolean startNewState(String param) {
            for (State st : STATE_VALUES) {
                if (st.matches(param)) {
                    this.state = st;
                    return true;
                }
            }
            return false;
        }
        
        private void handle(String param) {
            if (startNewState(param)) {
                return;
            }
            boolean ignoreSysroot = true;
            boolean framework = false;
            if (param.endsWith(WITH_SYS_ROOT_MARKER)) {
                ignoreSysroot = false;
                param = param.substring(0, param.length() - WITH_SYS_ROOT_MARKER.length()).trim();
            }
            if (param.endsWith(FRAMEWORK_MARKER)) {
                framework = true;
                param = param.substring(0, param.length() - FRAMEWORK_MARKER.length()).trim();
            }
            switch (state) {
                case TU:
                    setMainFile(param);
                    break;
                case CWD:
                    if (NULL_VAL.equals(param)) {
                        setCwd(null);
                    } else {
                        setCwd(param);
                    }
                    break;
                case SYS_ROOT:
                    if (NULL_VAL.equals(param)) {
                        setSysRoot(null);
                    } else {
                        setSysRoot(param);
                    }
                    break;
                case DASH_INCLUDE:
                    addIncFile(param);
                    break;
                case DASH_I:
                    addUserIncludePath(param, framework, ignoreSysroot);
                    break;
                case DASH_D:
                    addUserMacroDef(param);
                    break;
                case DASH_U:
                    addUserMacroUndef(param);
                    break;
                case DASH_STD:
                    setLangStd(LangStandard.Kind.valueOf(param));
                    break;
                case DASH_X:
                    setLang(InputKind.valueOf(param));
                    break;
                case INCLUDE_SYSTEM:
                    addPredefinedSystemIncludePath(param, framework, ignoreSysroot);
                    break;
                case SYSTEM_DEFINES:
                    addPredefinedSystemMacroDef(param);
                    break;
                default:
                    throw new AssertionError(state.name());
            }
        }        
    }    
}
