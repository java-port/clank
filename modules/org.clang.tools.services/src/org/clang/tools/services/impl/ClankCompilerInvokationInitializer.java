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

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.clang.basic.DiagnosticIDs;
import org.clang.basic.DiagnosticOptions;
import org.clang.basic.FileData;
import org.clang.basic.FileManager;
import org.clang.basic.LangOptions;
import org.clang.basic.SourceManager;
import org.clang.basic.target.TargetOptions;
import org.clang.frontend.CompilerInstance;
import org.clang.frontend.CompilerInvocation;
import org.clang.lex.HeaderSearchOptions;
import org.clang.lex.PreprocessorOptions;
import org.clang.lex.frontend.IncludeDirGroup;
import org.clang.tools.services.ClankCompilationDataBase;
import org.clang.tools.services.ClankDiagnosticServices;
import org.clang.tools.services.support.ClangUtilities;
import org.clank.java.std;
import org.clank.support.NativePointer;
import org.llvm.adt.IntrusiveRefCntPtr;
import org.llvm.adt.StringRef;
import org.llvm.adt.Triple;
import org.llvm.adt.Twine;
import org.llvm.adt.aliases.StringMap;
import org.llvm.support.MemoryBuffer;
import org.llvm.support.sys.fs;

/**
 * Should initialize Clank CopilerInvokation instance on the base of file (file buffer)
 *  and options from NativeFileItem (-I -D)
 * @author masha
 */
public class ClankCompilerInvokationInitializer {
    private static final boolean TRACE = ClankDiagnosticServices.DEBUG_DIAGNOSTIC_SERVICES;
 /*package*/static final fs.UniqueID INVALID_ID = fs.INVALID_UNIQUE_ID;
    /*package*/static final FileData CACHE_MISSING = new FileData();
    
    protected static final IntrusiveRefCntPtr<DiagnosticIDs> DiagID;
    private static final DiagnosticOptions dOpts = new DiagnosticOptions();
    private static final StringMap<FileData/*, BumpPtrAllocator*/> FileStatCache;
    private static final StringMap<FileData/*, BumpPtrAllocator*/> DirectoryStatCache;
    private static final StringMap<MemoryBuffer/*, BumpPtrAllocator*/> MemoryBufferCache;
    private static final AtomicInteger MemoryBufferCacheHits;
    private static final AtomicInteger MemoryBufferCacheMisses;
    private static final AtomicInteger MemoryBufferMainFileHits;
    static {
        DiagID = new IntrusiveRefCntPtr<>(new DiagnosticIDs());
        FileStatCache = new StringMap<FileData/*, BumpPtrAllocator*/>(1024*64, null);
        DirectoryStatCache = new StringMap<FileData/*, BumpPtrAllocator*/>(1024*8, null);
        MemoryBufferCache = new StringMap<MemoryBuffer/*, BumpPtrAllocator*/>(1024*16, null);
        MemoryBufferCacheHits = new AtomicInteger(0);
        MemoryBufferCacheMisses = new AtomicInteger(0);
        MemoryBufferMainFileHits = new AtomicInteger(0);
    }

        
    public static void fillInCompilerInstance(CompilerInstance compilerInstance, ClankCompilationDataBase.Entry compileEntry) {
      FileManager FileMgr = PreprocessorInitializerHelper.$getFileManager(
              new SharedMemoryBufferCache(MemoryBufferCache, MemoryBufferCacheHits, MemoryBufferMainFileHits, MemoryBufferCacheMisses), 
              FileStatCache, DirectoryStatCache, compileEntry.getFileSystem());
      compilerInstance.setFileManager(FileMgr);
      SourceManager SourceMgr = new SourceManager(compilerInstance.getDiagnostics(), FileMgr);
      compilerInstance.setSourceManager(SourceMgr);      
    }
    
    public static void fillInCompilerInvokationOpts(CompilerInvocation compilerInvokation, ClankCompilationDataBase.Entry compileEntry, Map<String, MemoryBuffer> remappedBuffers) {
      LangOptions opts = compilerInvokation.LangOpts.$arrow();
      opts.Digraphs = true;
      opts.Trigraphs = true;
      opts.LineComment = true;
      final TargetOptions TargetOpts = compilerInvokation.TargetOpts.$arrow();
      TargetOpts.Triple.$assign("x86_64");
      Triple T/*J*/= new Triple(new Twine(TargetOpts.Triple));
      final PreprocessorOptions PPOpts = compilerInvokation.PreprocessorOpts.$arrow();      
        // remap unsaved files as memory buffers
      if (remappedBuffers != null && !remappedBuffers.isEmpty()) {
          PPOpts.RetainRemappedFileBuffers = true;
          for (Map.Entry<String, MemoryBuffer> entry : remappedBuffers.entrySet()) {
            final StringRef PathStringRef = ClangUtilities.createPathStringRef(entry.getKey());
            final MemoryBuffer ToValue = entry.getValue();
            if (TRACE) {
                System.err.println("mapping [" + PathStringRef.toJavaString() + "]=> Size [" + 
                        ToValue.getBufferSize() + "]" + NativePointer.$LF);
            }
            PPOpts.addRemappedFile(PathStringRef, ToValue);
          }
        }      
    // handle -include
        for (CharSequence path : compileEntry.getIncludeFiles()) {
            if (TRACE) {
                System.err.println("file include " + path.toString());
            }
            PPOpts.Includes.push_back(path);
        }
        for (String macro : compileEntry.getSystemMacroDefines()) {
            if (TRACE) {
                System.err.println("sys macro " + macro);
            }
            PPOpts.addMacroDef(new StringRef(macro));
        }
        for (String macro : compileEntry.getUserMacroDefines()) {
            if (TRACE) {
                 System.err.println("user macro " + macro);
            }
            PPOpts.addMacroDef(new StringRef(macro));
        }
        // remap unsaved files as memory buffers
        //TODO: fixme
//        if (this.remappedBuffers != null && !this.remappedBuffers.isEmpty()) {
//            PPOpts.RetainRemappedFileBuffers = true;
//            for (Map.Entry<String, MemoryBuffer> entry : this.remappedBuffers.entrySet()) {
//              final StringRef PathStringRef = ClangUtilities.createPathStringRef(entry.getKey());
//              final MemoryBuffer ToValue = entry.getValue();
//              if (TRACE) {
//                  err.$out("mapping [").$out(PathStringRef).$out("]=> Size [").$out(ToValue.getBufferSize()).$out("]").$out(NativePointer.$LF);
//              }
//              PPOpts.addRemappedFile(PathStringRef, ToValue);
//            }
//        }      
      
      CompilerInvocation.setLangDefaults(opts, compileEntry.getLanguage(), T, PPOpts, compileEntry.getLangStandard());      

    }
  
    public static void fillInHeaderSearchOptions (HeaderSearchOptions options, 
            ClankCompilationDataBase.Entry compileEntry) {
  //      HeaderSearchOptions options = super.createHeaderSearchOptions();
        //if (TRACE) {
            options.Verbose = false;
        //}
        CharSequence sysRoot = compileEntry.getSysRoot();
        if (sysRoot != null && sysRoot.length() > 0) {
          options.Sysroot = new std.string(sysRoot);
        }
        // -I and -F
        for (ClankCompilationDataBase.IncludePath Path : compileEntry.getUserIncludePaths()) {
            if (TRACE) {
              System.err.println("user include " + Path.getPath().toString());
                //err.$out("user include ").$out(Path.getPath().toString()).$out(NativePointer.$LF);
            }
            StringRef strPath = new StringRef(NativePointer.create_char$ptr_utf8(Path.getPath()));
            options.AddPath(strPath, IncludeDirGroup.Angled, Path.isFramework(), Path.ignoreSysRoot());
        }
        // -isystem
        for (ClankCompilationDataBase.IncludePath Path : compileEntry.getPredefinedSystemIncludePaths()) {
            if (TRACE) {
              System.err.println("sys include " + Path.getPath().toString());
                //err.$out("sys include ").$out(Path.getPath().toString()).$out(NativePointer.$LF);
            }
            StringRef strPath = new StringRef(NativePointer.create_char$ptr_utf8(Path.getPath()));
            // add search path
            options.AddPath(strPath, IncludeDirGroup.System, Path.isFramework(), Path.ignoreSysRoot());
            // and register as system header prefix
            options.AddSystemHeaderPrefix(strPath, true);
        }
        CharSequence absPathLookupPrefix = compileEntry.getAbsPathLookupPrefix();
        if (absPathLookupPrefix != null && absPathLookupPrefix.length() > 0) {
          options.AbsPathLookupPrefix = new std.string(compileEntry.getAbsPathLookupPrefix());
        } else {
          options.AbsPathLookupPrefix = std.string.EMPTY;
        }
        //options.UseBuiltinIncludes = false;
        options.UseLibcxx = false;
        options.UseStandardCXXIncludes = false;
        options.UseStandardSystemIncludes = false;
        //return options;
          
    }
}
