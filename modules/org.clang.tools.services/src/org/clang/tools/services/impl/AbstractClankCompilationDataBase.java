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

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clank.support.NativeTrace;

/**
 *
 * @author Vladimir Voskresensky
 */
public abstract class AbstractClankCompilationDataBase implements ClankCompilationDataBase {
    public static final String SORT_PARSED_FILES_PROPERTY = "cnd.model.parse.sorted";
    public static final boolean SORT_PARSED_FILES = 
            Boolean.valueOf(System.getProperty(SORT_PARSED_FILES_PROPERTY, "false")) 
            || (NativeTrace.TRACE_FILE_INFO_EXIT > 0);
    
    private final Collection<ClankCompilationDataBase.Entry> compilations;
    private final String name;

    public AbstractClankCompilationDataBase(String dbName, List<ClankCompilationDataBase.Entry> compilations) {
        this.name = dbName;
        if (SORT_PARSED_FILES) {
          compilations = sort(compilations);
        }
        this.compilations = Collections.unmodifiableCollection(compilations);
    }
    
    @Override
    public final Collection<ClankCompilationDataBase.Entry> getCompilations() {
        return compilations;
    }

    @Override
    public final String getName() {
        return name;
    }
    
    private static List<ClankCompilationDataBase.Entry> sort(List<ClankCompilationDataBase.Entry> entries) {
        if (PreprocessorSupport.THREADS_COUNT != 1) {
          NativeTrace.printStackTraceOnce(new IllegalStateException("Sort make sense only with 1 thread, not " + PreprocessorSupport.THREADS_COUNT));
        }
        Collections.sort(entries, COMPARATOR);        
        return entries;
    }
    
    private static final Comparator<ClankCompilationDataBase.Entry> COMPARATOR = new Comparator<ClankCompilationDataBase.Entry>() {
      @Override
      public int compare(Entry o1, Entry o2) {
          return o1.getCompiledFiles().iterator().next().toString().compareTo(o2.getCompiledFiles().iterator().next().toString());
      }
    };
}
