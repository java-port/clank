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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.*;


//<editor-fold defaultstate="collapsed" desc="static type ChainedIncludesSourceStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZL15createASTReaderRN5clang16CompilerInstanceEN4llvm9StringRefERNS2_15SmallVectorImplISt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS6_EEEERNS4_ISsEEPNS_26ASTDeserializationListenerE; -static-type=ChainedIncludesSourceStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class ChainedIncludesSourceStatics {

//<editor-fold defaultstate="collapsed" desc="createASTReader">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*changed input param to ASTDeserializationListenerImplementation*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 78,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", old_line = 76,
 FQN="createASTReader", NM="_ZL15createASTReaderRN5clang16CompilerInstanceEN4llvm9StringRefERNS2_15SmallVectorImplISt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS6_EEEERNS4_ISsEEPNS_26ASTDeserializationListenerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZL15createASTReaderRN5clang16CompilerInstanceEN4llvm9StringRefERNS2_15SmallVectorImplISt10unique_ptrINS2_12MemoryBufferESt14default_deleteIS6_EEEERNS4_ISsEEPNS_26ASTDeserializationListenerE")
//</editor-fold>
public static ASTReader /*P*/ createASTReader(CompilerInstance /*&*/ CI, StringRef pchFile, 
               SmallVectorImpl<std.unique_ptr<MemoryBuffer> > /*&*/ MemBufs, 
               SmallVectorImpl<std.string> /*&*/ bufNames) {
  return createASTReader(CI, pchFile, 
               MemBufs, 
               bufNames, 
               (ASTDeserializationListenerImplementation /*P*/ )null);
}
public static ASTReader /*P*/ createASTReader(CompilerInstance /*&*/ CI, StringRef pchFile, 
               SmallVectorImpl<std.unique_ptr<MemoryBuffer> > /*&*/ MemBufs, 
               SmallVectorImpl<std.string> /*&*/ bufNames, 
               ASTDeserializationListenerImplementation /*P*/ deserialListener/*= null*/) {
  std.unique_ptr<ASTReader> Reader = null;
  try {
    Preprocessor /*&*/ PP = CI.getPreprocessor();
    Reader/*J*/= new std.unique_ptr<ASTReader>();
    Reader.reset(new ASTReader(PP, CI.getASTContext(), 
            CI.getPCHContainerReader(), 
            /*Extensions=*/ /*{ */new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >()/* }*/, 
            /*isysroot=*/ new StringRef(/*KEEP_STR*/$EMPTY), /*DisableValidation=*/ true));
    for (/*uint*/int ti = 0; $less_uint(ti, bufNames.size()); ++ti) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef sr/*J*/= new StringRef(bufNames.$at(ti));
        Reader.$arrow().addInMemoryBuffer(sr, $c$.track(new std.unique_ptr<MemoryBuffer>(JD$Move.INSTANCE, std.move(MemBufs.$at(ti))))); $c$.clean();
      } finally {
        $c$.$destroy();
      }
    }
    Reader.$arrow().setDeserializationListener(deserialListener);
    switch (Reader.$arrow().ReadAST(new StringRef(pchFile), ModuleKind.MK_PCH, new SourceLocation(), 
        ASTReader.LoadFailureCapabilities.ARR_None)) {
     case Success:
      // Set the predefines buffer as suggested by the PCH reader.
      PP.setPredefines(new StringRef(Reader.$arrow().getSuggestedPredefines()));
      return Reader.release();
     case Failure:
     case Missing:
     case OutOfDate:
     case VersionMismatch:
     case ConfigurationMismatch:
     case HadErrors:
      break;
    }
    return null;
  } finally {
    if (Reader != null) { Reader.$destroy(); }
  }
}

} // END OF class ChainedIncludesSourceStatics
